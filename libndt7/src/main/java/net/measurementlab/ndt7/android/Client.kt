package com.kts.network.ndt7.android

import android.support.annotation.CheckResult
import android.util.Log
import com.google.gson.Gson
import net.measurementlab.ndt7.android.model.ServerInfo

import okhttp3.*
import okio.ByteString
import java.net.URI
import java.net.URISyntaxException
import java.net.URLEncoder
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

// TODO(bassosimone): do we need locking for this class?

private const val TAG = "Client"

open class Client(private val settings: Settings) : WebSocketListener() {

    private val gson = Gson()
    private val measurementInterval = TimeUnit.NANOSECONDS.convert(250, TimeUnit.MILLISECONDS)
    private var currentBytes: Long = 0
    private var count: Long = 0
    private var rv = true
    private var t0: Long = 0
    private var tLast: Long = 0

    open fun onLogInfo(message: String?) {
        Log.d(TAG, "onLogInfo: $message")
    }

    open fun onError(error: Throwable?) {
        if (error != null) {
            Log.e(TAG, "onError: " + error.message)
        }
    }

    open fun onServerDownloadMeasurement(measurement: ServerInfo) {
//        Log.d(TAG, "onServerDownloadMeasurement: $measurement.")
    }

    open fun onClientDownloadMeasurement(measurement: Measurement) {
//        Log.d(TAG, "onClientDownloadMeasurement: $measurement")
    }

    open fun onDownloadClose() {
        Log.d(TAG, "onDownloadClose")

    }

    override fun onOpen(ws: WebSocket,
                        resp: Response) {
        onLogInfo("WebSocket onOpen")
    }

    override fun onMessage(ws: WebSocket,
                           text: String) {
        onLogInfo("WebSocket onMessage$text")
//        count += text.length.toDouble()
//        periodic(bytes.size.toLong())

        val measurement: ServerInfo

        try {
            measurement = gson.fromJson(text, ServerInfo::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "could not parse json", e)
            return
        }

        onServerDownloadMeasurement(measurement)
    }

    override fun onMessage(ws: WebSocket,
                           bytes: ByteString) {
//        onLogInfo("WebSocket onMessageBytes" + bytes.size.toDouble() )
        periodic(bytes.size().toLong())
    }

    override fun onClosing(ws: WebSocket,
                           code: Int,
                           reason: String) {
        // TODO(bassosimone): make sure code has the correct value otherwise
        // we must return an error to the caller.
        onDownloadClose()
        ws.close(1000, null)
    }

    override fun onFailure(ws: WebSocket,
                           t: Throwable,
                           r: Response?) {
        onError(t)
        rv = false
    }

    @CheckResult
    fun runDownload(): Boolean {
        val uri: URI

        try {
            uri = URI(
                    "wss", null, // userInfo
                    settings.hostname,
                    if (settings.port in 0..65535) settings.port else -1,
                    "/ndt/v7/download",
                    makeQuery(), settings.accessToken
            )
            Log.v(TAG, "uri.getRawQuery()" + uri.rawQuery + " uri.toString()" + uri.toString())

        } catch (e: URISyntaxException) {
            Log.e(TAG, "runDownload encountered exception", e)
            onError(e)
            return false
        }

        val builder = OkHttpClient.Builder()

        if (settings.skipTlsCertificateVerification) {
            val x509TrustManager = object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<X509Certificate>,
                                                authType: String) {
                }

                override fun checkServerTrusted(chain: Array<X509Certificate>,
                                                authType: String) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }

            try {
                val trustAllCerts = arrayOf<TrustManager>(x509TrustManager)
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, java.security.SecureRandom())
                val sslSocketFactory = sslContext.socketFactory
                builder.sslSocketFactory(sslSocketFactory, x509TrustManager)
            } catch (e: Exception) {
                Log.e(TAG, "Encountered exception while attempting to observe flag skipTlsCertificateVerification", e)
            }

            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
        }

        val client = builder
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()

        val request = Request.Builder()
                .url(uri.toString())
                .addHeader("Sec-WebSocket-Protocol", "net.measurementlab.ndt.v7")
                .build()
        client.newWebSocket(request, this)

        tLast = System.nanoTime()
        t0 = tLast

        // Basically make the code synchronous here:
        val svc = client.dispatcher().executorService()
        svc.shutdown()
        try {
            svc.awaitTermination(30, TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            // TODO(bassosimone): how to handle this error condition?
            Log.e(TAG, "runDownload awaitTermination encountered exception", e)
        }

        return rv
    }

    private fun periodic(current: Long) {
        count += current
        val now = System.nanoTime()

        currentBytes += current

        if (now - tLast > measurementInterval) {
            val measurement = Measurement((now - t0).toDouble(), null, null, Measurement.AppInfo(count, currentBytes, (now - tLast).toDouble()))
            tLast = now
            onClientDownloadMeasurement(measurement)
            currentBytes = 0;
        }
    }

     private fun makeQuery(): String? {
        var s = ""
         s += "access_token="
//         s += URLEncoder.encode(settings.accessToken, "utf-8");
        if (settings.adaptive) {
            if (!s.isEmpty()) {
                s += "&"
            }
            s += "adaptive=true"
        }
        if (settings.duration > 0) {
            if (!s.isEmpty()) {
                s += "&"
            }
            s += "duration="
            s += Integer.toString(settings.duration)
        }
        return s
    }
}

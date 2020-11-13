package net.measurementlab.ndt7.android

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.kts.network.ndt7.android.Client
import com.kts.network.ndt7.android.Measurement
import com.kts.network.ndt7.android.Settings
import net.measurementlab.ndt7.android.model.Server
import net.measurementlab.ndt7.android.model.ServerInfo
import net.measurementlab.ndt7.android.model.ServerNearest

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchNearest = Ndt7ServerSearchNearest()

        val rawJsonServerNest: ServerNearest = Gson().fromJson(searchNearest.server, ServerNearest::class.java)

        val parts: List<String> = rawJsonServerNest.getResults().get(0).getUrls().getWssNdtV7Download().split("access_token=")

        Log.i(TAG,  "parts" + parts[1])
        val search = Ndt7ServerSearch()
        val rawJsonServer: Server = Gson().fromJson(search.server, Server::class.java)

        val settings = Settings()
        settings.hostname = rawJsonServer.fqdn
        settings.port = 443
        settings.skipTlsCertificateVerification = true
        val client = MyClient(settings)

        if (!client.runDownload()) {
            Toast.makeText(this, "runDownload failed", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class MyClient constructor(settings: Settings) : Client(settings) {

        override fun onLogInfo(message: String?) {
            Log.i(TAG, "onLogInfo: $message")
        }

        override fun onError(error: Throwable?) {
            Log.e(TAG, "onError: $error")

            Handler(Looper.getMainLooper()).post { Toast.makeText(this@MainActivity,"onError: $error", Toast.LENGTH_SHORT).show() }
        }

        override fun onServerDownloadMeasurement(measurement: ServerInfo) {
            Log.d(TAG, "server measurement: $measurement")
        }

        override fun onClientDownloadMeasurement(measurement: Measurement) {
            Log.d(TAG, "client measurement: $measurement")
        }
    }
}

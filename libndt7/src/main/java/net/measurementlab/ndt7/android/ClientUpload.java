package net.measurementlab.ndt7.android;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.gson.Gson;
import com.kts.network.ndt7.android.Measurement;
import com.kts.network.ndt7.android.Settings;

import net.measurementlab.ndt7.android.model.ServerInfo;

import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.X509Certificate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;


// TODO(bassosimone): do we need locking for this class?

public class ClientUpload extends WebSocketListener {
    private Gson gson = new Gson();

    private final static int HTTP101 = 101;
    private final static int TEST_TIME = 10;
    private final static int CLOSE_SUCCESS = 1000;
    private long count = 0;
    private long currentBytes = 0;
    private long elapsed = 1;
    @NonNull
    private final Settings settings;

    private boolean rv = true;
    private long t0 = 0;
    private long tLast = 0;
    private long tLastCurrent = 0;
    private final long measurementInterval = TimeUnit.NANOSECONDS.convert(250, TimeUnit.MILLISECONDS);

    @NonNull
    private static final String TAG = "ClientUpload";

    public ClientUpload(@NonNull Settings settings) {
        this.settings = settings;
    }

    public void onLogInfo(@Nullable String message) {
        Log.d(TAG, "onLogInfo: " + message);
        // NOTHING
    }

    public void onError(@Nullable Throwable error) {
        Log.d(TAG, "onError: " + error.getMessage());
        // NOTHING
    }

    public void onServerDownloadMeasurement(@NonNull ServerInfo measurement) {
//        Log.d(TAG, "onServerDownloadMeasurement: " + measurement.toString());
        // NOTHING
    }

    public void onClientDownloadMeasurement(@NonNull Measurement measurement){
//        Log.d(TAG, "onClientDownloadMeasurement: " + measurement);
        // NOTHING
    }

    @Override
    public final void onOpen(WebSocket ws, Response resp) {
        onLogInfo("WebSocket onOpen");
        //Log.d(TAG,""+System.nanoTime());
        onLogInfo(resp.toString());
        if(resp.code() == HTTP101) {
            new Thread(() -> {
                UploadData(ws);
            }).start();
        }
    }

    public void onUploadClose() {
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        super.onMessage(webSocket, text);
        onLogInfo("WebSocket onMessage"  + text);
        ServerInfo measurement = null;

        try {
            measurement = gson.fromJson(text, ServerInfo.class);
            onServerDownloadMeasurement(measurement);

        } catch (Exception e) {
            Log.e(TAG, "could not parse json", e);
        }

    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        super.onMessage(webSocket, bytes);
        onLogInfo("WebSocket onMessage bytes" + bytes.size());

    }

    @Override
    public final void onClosing(WebSocket ws,
                                int code,
                                String reason) {
        // TODO(bassosimone): make sure code has the correct value otherwise
        // we must return an error to the caller.
        Log.d(TAG,"WebSocket closed");
        onUploadClose();
        ws.close(CLOSE_SUCCESS, null);
    }

    @Override
    public final void onFailure(WebSocket ws,
                                Throwable t,
                                Response r) {
        onError(t);
        rv = false;
    }

    @CheckResult
    public boolean runUpload() {
        URI uri;
        try {
            uri = new URI(
                    "wss",
                    "userInfo", // userInfo
                    settings.getHostname(),
                    (settings.getPort() >= 0 && settings.getPort() < 65536) ? settings.getPort() : -1,
                    "/ndt/v7/upload",
                    "",
                    null
            );
            Log.v(TAG, "uri.getRawQuery()" +  uri.getRawQuery() + " uri.toString()" + uri.toString());

        } catch (URISyntaxException e) {
            Log.e(TAG, "runUpload encountered exception", e);
            onError(e);
            return false;
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (settings.getSkipTlsCertificateVerification()) {
            X509TrustManager x509TrustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) { }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) { }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            };

            try {
                final TrustManager[] trustAllCerts = new TrustManager[]{ x509TrustManager };
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                builder.sslSocketFactory(sslSocketFactory, x509TrustManager);
            } catch (Exception e) {
                Log.e(TAG, "Encountered exception", e);
            }

            builder.hostnameVerifier((hostname, session) -> true);
        }

        OkHttpClient client = builder
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();



        Request request = new Request.Builder()
                .url(uri.toString())
                .addHeader("Sec-WebSocket-Protocol", "net.measurementlab.ndt.v7")
                .method("GET",null)
                .build();
        Log.d(TAG,request.toString());
        client.newWebSocket(request, this);

        t0 = tLast = System.nanoTime();
        client.dispatcher().executorService().shutdown();

        return rv;
    }

    //ToDo find the best compromise to upload datas
    private void UploadData(WebSocket ws) {

        long totalTime = (long) (ClientUpload.TEST_TIME * Math.pow(10, 9));
        long startTime = System.nanoTime();
        boolean toFinish = false;
        while (!toFinish) {
            elapsed = System.nanoTime() - startTime;
            periodic();

            byte[] dataChunk = new byte[1 << 15];
            new Random().nextBytes(dataChunk);
            //Log.e("uploadData", Arrays.toString(dataChunk));

            //Arrays.fill(dataChunk, (byte) new Random().nextInt(300));
            //
            //ws.send(Arrays.toString(dataChunk));
            //Ws max queuesize is 16mb
            if (ws.queueSize() <  dataChunk.length) {
                count += (long) dataChunk.length ;
                currentBytes += (long) dataChunk.length;
                ws.send(ByteString.of(dataChunk));
            }
            toFinish = (elapsed >= totalTime);
        }

        Log.v(getClass().getSimpleName(), "End ws.queueSize()" + ws.queueSize() );

        count -= ws.queueSize();

        onUploadClose();
        ws.close(CLOSE_SUCCESS, "Upload completed !");

        int sentInKB = (int) (count / 1024);
        long rate = (count / (long) Math.pow(2, 10)) / ClientUpload.TEST_TIME;
        Log.d(TAG, "sent=" + sentInKB + "KB rate=" + rate + "Mbps");
        Log.d(TAG, "Upload rate = " + rate + "Kbps");
    }



    private void periodic() {
        Long now = System.nanoTime();

        if (now - tLast > measurementInterval) {
            Measurement measurement = new Measurement(elapsed, null, null,
                    new Measurement.AppInfo(count, currentBytes, now - tLastCurrent ));
            tLast = now;
            if(currentBytes != 0) {
                currentBytes = 0;
                tLastCurrent = now;
            }
            onClientDownloadMeasurement(measurement);
        }
    }
}




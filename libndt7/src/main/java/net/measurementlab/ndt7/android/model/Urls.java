
package net.measurementlab.ndt7.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("ws:///ndt/v7/download")
    @Expose
    private String wsNdtV7Download;
    @SerializedName("ws:///ndt/v7/upload")
    @Expose
    private String wsNdtV7Upload;
    @SerializedName("wss:///ndt/v7/download")
    @Expose
    private String wssNdtV7Download;
    @SerializedName("wss:///ndt/v7/upload")
    @Expose
    private String wssNdtV7Upload;

    public String getWsNdtV7Download() {
        return wsNdtV7Download;
    }

    public void setWsNdtV7Download(String wsNdtV7Download) {
        this.wsNdtV7Download = wsNdtV7Download;
    }

    public String getWsNdtV7Upload() {
        return wsNdtV7Upload;
    }

    public void setWsNdtV7Upload(String wsNdtV7Upload) {
        this.wsNdtV7Upload = wsNdtV7Upload;
    }

    public String getWssNdtV7Download() {
        return wssNdtV7Download;
    }

    public void setWssNdtV7Download(String wssNdtV7Download) {
        this.wssNdtV7Download = wssNdtV7Download;
    }

    public String getWssNdtV7Upload() {
        return wssNdtV7Upload;
    }

    public void setWssNdtV7Upload(String wssNdtV7Upload) {
        this.wssNdtV7Upload = wssNdtV7Upload;
    }

}

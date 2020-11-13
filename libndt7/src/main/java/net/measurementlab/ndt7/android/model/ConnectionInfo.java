
package net.measurementlab.ndt7.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionInfo implements Parcelable
{

    @SerializedName("Client")
    @Expose
    private String client;
    @SerializedName("Server")
    @Expose
    private String server;
    @SerializedName("UUID")
    @Expose
    private String uUID;
    public final static Creator<ConnectionInfo> CREATOR = new Creator<ConnectionInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnectionInfo createFromParcel(Parcel in) {
            return new ConnectionInfo(in);
        }

        public ConnectionInfo[] newArray(int size) {
            return (new ConnectionInfo[size]);
        }

    }
    ;

    protected ConnectionInfo(Parcel in) {
        this.client = ((String) in.readValue((String.class.getClassLoader())));
        this.server = ((String) in.readValue((String.class.getClassLoader())));
        this.uUID = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ConnectionInfo() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUUID() {
        return uUID;
    }

    public void setUUID(String uUID) {
        this.uUID = uUID;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(client);
        dest.writeValue(server);
        dest.writeValue(uUID);
    }

    public int describeContents() {
        return  0;
    }

}

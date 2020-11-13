
package net.measurementlab.ndt7.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServerInfo implements Parcelable
{

    @SerializedName("ConnectionInfo")
    @Expose
    private ConnectionInfo connectionInfo;
    @SerializedName("BBRInfo")
    @Expose
    private BBRInfo bBRInfo;
    @SerializedName("TCPInfo")
    @Expose
    private TCPInfo tCPInfo;
    public final static Creator<ServerInfo> CREATOR = new Creator<ServerInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ServerInfo createFromParcel(Parcel in) {
            return new ServerInfo(in);
        }

        public ServerInfo[] newArray(int size) {
            return (new ServerInfo[size]);
        }

    }
    ;

    protected ServerInfo(Parcel in) {
        this.connectionInfo = ((ConnectionInfo) in.readValue((ConnectionInfo.class.getClassLoader())));
        this.bBRInfo = ((BBRInfo) in.readValue((BBRInfo.class.getClassLoader())));
        this.tCPInfo = ((TCPInfo) in.readValue((TCPInfo.class.getClassLoader())));
    }

    public ServerInfo() {
    }

    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public BBRInfo getBBRInfo() {
        return bBRInfo;
    }

    public void setBBRInfo(BBRInfo bBRInfo) {
        this.bBRInfo = bBRInfo;
    }

    public TCPInfo getTCPInfo() {
        return tCPInfo;
    }

    public void setTCPInfo(TCPInfo tCPInfo) {
        this.tCPInfo = tCPInfo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(connectionInfo);
        dest.writeValue(bBRInfo);
        dest.writeValue(tCPInfo);
    }

    public int describeContents() {
        return  0;
    }

}

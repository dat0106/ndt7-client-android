
package net.measurementlab.ndt7.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BBRInfo implements Parcelable
{

    @SerializedName("BW")
    @Expose
    private Integer bW;
    @SerializedName("MinRTT")
    @Expose
    private Integer minRTT;
    @SerializedName("PacingGain")
    @Expose
    private Integer pacingGain;
    @SerializedName("CwndGain")
    @Expose
    private Integer cwndGain;
    @SerializedName("ElapsedTime")
    @Expose
    private Integer elapsedTime;
    public final static Creator<BBRInfo> CREATOR = new Creator<BBRInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BBRInfo createFromParcel(Parcel in) {
            return new BBRInfo(in);
        }

        public BBRInfo[] newArray(int size) {
            return (new BBRInfo[size]);
        }

    }
    ;

    protected BBRInfo(Parcel in) {
        this.bW = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.minRTT = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pacingGain = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cwndGain = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.elapsedTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public BBRInfo() {
    }

    public Integer getBW() {
        return bW;
    }

    public void setBW(Integer bW) {
        this.bW = bW;
    }

    public Integer getMinRTT() {
        return minRTT;
    }

    public void setMinRTT(Integer minRTT) {
        this.minRTT = minRTT;
    }

    public Integer getPacingGain() {
        return pacingGain;
    }

    public void setPacingGain(Integer pacingGain) {
        this.pacingGain = pacingGain;
    }

    public Integer getCwndGain() {
        return cwndGain;
    }

    public void setCwndGain(Integer cwndGain) {
        this.cwndGain = cwndGain;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(bW);
        dest.writeValue(minRTT);
        dest.writeValue(pacingGain);
        dest.writeValue(cwndGain);
        dest.writeValue(elapsedTime);
    }

    public int describeContents() {
        return  0;
    }

}

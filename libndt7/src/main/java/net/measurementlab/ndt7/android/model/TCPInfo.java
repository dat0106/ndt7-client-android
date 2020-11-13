
package net.measurementlab.ndt7.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TCPInfo implements Parcelable
{

    @SerializedName("State")
    @Expose
    private Integer state;
    @SerializedName("CAState")
    @Expose
    private Integer cAState;
    @SerializedName("Retransmits")
    @Expose
    private Integer retransmits;
    @SerializedName("Probes")
    @Expose
    private Integer probes;
    @SerializedName("Backoff")
    @Expose
    private Integer backoff;
    @SerializedName("Options")
    @Expose
    private Integer options;
    @SerializedName("WScale")
    @Expose
    private Integer wScale;
    @SerializedName("AppLimited")
    @Expose
    private Integer appLimited;
    @SerializedName("RTO")
    @Expose
    private Integer rTO;
    @SerializedName("ATO")
    @Expose
    private Integer aTO;
    @SerializedName("SndMSS")
    @Expose
    private Integer sndMSS;
    @SerializedName("RcvMSS")
    @Expose
    private Integer rcvMSS;
    @SerializedName("Unacked")
    @Expose
    private Integer unacked;
    @SerializedName("Sacked")
    @Expose
    private Integer sacked;
    @SerializedName("Lost")
    @Expose
    private Integer lost;
    @SerializedName("Retrans")
    @Expose
    private Integer retrans;
    @SerializedName("Fackets")
    @Expose
    private Integer fackets;
    @SerializedName("LastDataSent")
    @Expose
    private Integer lastDataSent;
    @SerializedName("LastAckSent")
    @Expose
    private Integer lastAckSent;
    @SerializedName("LastDataRecv")
    @Expose
    private Integer lastDataRecv;
    @SerializedName("LastAckRecv")
    @Expose
    private Integer lastAckRecv;
    @SerializedName("PMTU")
    @Expose
    private Integer pMTU;
    @SerializedName("RcvSsThresh")
    @Expose
    private Integer rcvSsThresh;
    @SerializedName("RTT")
    @Expose
    private Integer rTT;
    @SerializedName("RTTVar")
    @Expose
    private Integer rTTVar;
    @SerializedName("SndSsThresh")
    @Expose
    private Integer sndSsThresh;
    @SerializedName("SndCwnd")
    @Expose
    private Integer sndCwnd;
    @SerializedName("AdvMSS")
    @Expose
    private Integer advMSS;
    @SerializedName("Reordering")
    @Expose
    private Integer reordering;
    @SerializedName("RcvRTT")
    @Expose
    private Integer rcvRTT;
    @SerializedName("RcvSpace")
    @Expose
    private Integer rcvSpace;
    @SerializedName("TotalRetrans")
    @Expose
    private Integer totalRetrans;
    @SerializedName("PacingRate")
    @Expose
    private Integer pacingRate;
    @SerializedName("MaxPacingRate")
    @Expose
    private Integer maxPacingRate;
    @SerializedName("BytesAcked")
    @Expose
    private Integer bytesAcked;
    @SerializedName("BytesReceived")
    @Expose
    private Integer bytesReceived;
    @SerializedName("SegsOut")
    @Expose
    private Integer segsOut;
    @SerializedName("SegsIn")
    @Expose
    private Integer segsIn;
    @SerializedName("NotsentBytes")
    @Expose
    private Integer notsentBytes;
    @SerializedName("MinRTT")
    @Expose
    private Integer minRTT;
    @SerializedName("DataSegsIn")
    @Expose
    private Integer dataSegsIn;
    @SerializedName("DataSegsOut")
    @Expose
    private Integer dataSegsOut;
    @SerializedName("DeliveryRate")
    @Expose
    private Integer deliveryRate;
    @SerializedName("BusyTime")
    @Expose
    private Integer busyTime;
    @SerializedName("RWndLimited")
    @Expose
    private Integer rWndLimited;
    @SerializedName("SndBufLimited")
    @Expose
    private Integer sndBufLimited;
    @SerializedName("Delivered")
    @Expose
    private Integer delivered;
    @SerializedName("DeliveredCE")
    @Expose
    private Integer deliveredCE;
    @SerializedName("BytesSent")
    @Expose
    private Integer bytesSent;
    @SerializedName("BytesRetrans")
    @Expose
    private Integer bytesRetrans;
    @SerializedName("DSackDups")
    @Expose
    private Integer dSackDups;
    @SerializedName("ReordSeen")
    @Expose
    private Integer reordSeen;
    @SerializedName("ElapsedTime")
    @Expose
    private Integer elapsedTime;
    public final static Creator<TCPInfo> CREATOR = new Creator<TCPInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TCPInfo createFromParcel(Parcel in) {
            return new TCPInfo(in);
        }

        public TCPInfo[] newArray(int size) {
            return (new TCPInfo[size]);
        }

    }
    ;

    protected TCPInfo(Parcel in) {
        this.state = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cAState = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.retransmits = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.probes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.backoff = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.options = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wScale = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.appLimited = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rTO = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.aTO = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sndMSS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rcvMSS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.unacked = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sacked = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.retrans = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fackets = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastDataSent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastAckSent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastDataRecv = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastAckRecv = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pMTU = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rcvSsThresh = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rTT = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rTTVar = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sndSsThresh = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sndCwnd = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.advMSS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.reordering = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rcvRTT = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rcvSpace = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalRetrans = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pacingRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.maxPacingRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bytesAcked = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bytesReceived = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.segsOut = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.segsIn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.notsentBytes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.minRTT = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataSegsIn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataSegsOut = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deliveryRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.busyTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rWndLimited = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sndBufLimited = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.delivered = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deliveredCE = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bytesSent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bytesRetrans = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dSackDups = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.reordSeen = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.elapsedTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public TCPInfo() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCAState() {
        return cAState;
    }

    public void setCAState(Integer cAState) {
        this.cAState = cAState;
    }

    public Integer getRetransmits() {
        return retransmits;
    }

    public void setRetransmits(Integer retransmits) {
        this.retransmits = retransmits;
    }

    public Integer getProbes() {
        return probes;
    }

    public void setProbes(Integer probes) {
        this.probes = probes;
    }

    public Integer getBackoff() {
        return backoff;
    }

    public void setBackoff(Integer backoff) {
        this.backoff = backoff;
    }

    public Integer getOptions() {
        return options;
    }

    public void setOptions(Integer options) {
        this.options = options;
    }

    public Integer getWScale() {
        return wScale;
    }

    public void setWScale(Integer wScale) {
        this.wScale = wScale;
    }

    public Integer getAppLimited() {
        return appLimited;
    }

    public void setAppLimited(Integer appLimited) {
        this.appLimited = appLimited;
    }

    public Integer getRTO() {
        return rTO;
    }

    public void setRTO(Integer rTO) {
        this.rTO = rTO;
    }

    public Integer getATO() {
        return aTO;
    }

    public void setATO(Integer aTO) {
        this.aTO = aTO;
    }

    public Integer getSndMSS() {
        return sndMSS;
    }

    public void setSndMSS(Integer sndMSS) {
        this.sndMSS = sndMSS;
    }

    public Integer getRcvMSS() {
        return rcvMSS;
    }

    public void setRcvMSS(Integer rcvMSS) {
        this.rcvMSS = rcvMSS;
    }

    public Integer getUnacked() {
        return unacked;
    }

    public void setUnacked(Integer unacked) {
        this.unacked = unacked;
    }

    public Integer getSacked() {
        return sacked;
    }

    public void setSacked(Integer sacked) {
        this.sacked = sacked;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getRetrans() {
        return retrans;
    }

    public void setRetrans(Integer retrans) {
        this.retrans = retrans;
    }

    public Integer getFackets() {
        return fackets;
    }

    public void setFackets(Integer fackets) {
        this.fackets = fackets;
    }

    public Integer getLastDataSent() {
        return lastDataSent;
    }

    public void setLastDataSent(Integer lastDataSent) {
        this.lastDataSent = lastDataSent;
    }

    public Integer getLastAckSent() {
        return lastAckSent;
    }

    public void setLastAckSent(Integer lastAckSent) {
        this.lastAckSent = lastAckSent;
    }

    public Integer getLastDataRecv() {
        return lastDataRecv;
    }

    public void setLastDataRecv(Integer lastDataRecv) {
        this.lastDataRecv = lastDataRecv;
    }

    public Integer getLastAckRecv() {
        return lastAckRecv;
    }

    public void setLastAckRecv(Integer lastAckRecv) {
        this.lastAckRecv = lastAckRecv;
    }

    public Integer getPMTU() {
        return pMTU;
    }

    public void setPMTU(Integer pMTU) {
        this.pMTU = pMTU;
    }

    public Integer getRcvSsThresh() {
        return rcvSsThresh;
    }

    public void setRcvSsThresh(Integer rcvSsThresh) {
        this.rcvSsThresh = rcvSsThresh;
    }

    public Integer getRTT() {
        return rTT;
    }

    public void setRTT(Integer rTT) {
        this.rTT = rTT;
    }

    public Integer getRTTVar() {
        return rTTVar;
    }

    public void setRTTVar(Integer rTTVar) {
        this.rTTVar = rTTVar;
    }

    public Integer getSndSsThresh() {
        return sndSsThresh;
    }

    public void setSndSsThresh(Integer sndSsThresh) {
        this.sndSsThresh = sndSsThresh;
    }

    public Integer getSndCwnd() {
        return sndCwnd;
    }

    public void setSndCwnd(Integer sndCwnd) {
        this.sndCwnd = sndCwnd;
    }

    public Integer getAdvMSS() {
        return advMSS;
    }

    public void setAdvMSS(Integer advMSS) {
        this.advMSS = advMSS;
    }

    public Integer getReordering() {
        return reordering;
    }

    public void setReordering(Integer reordering) {
        this.reordering = reordering;
    }

    public Integer getRcvRTT() {
        return rcvRTT;
    }

    public void setRcvRTT(Integer rcvRTT) {
        this.rcvRTT = rcvRTT;
    }

    public Integer getRcvSpace() {
        return rcvSpace;
    }

    public void setRcvSpace(Integer rcvSpace) {
        this.rcvSpace = rcvSpace;
    }

    public Integer getTotalRetrans() {
        return totalRetrans;
    }

    public void setTotalRetrans(Integer totalRetrans) {
        this.totalRetrans = totalRetrans;
    }

    public Integer getPacingRate() {
        return pacingRate;
    }

    public void setPacingRate(Integer pacingRate) {
        this.pacingRate = pacingRate;
    }

    public Integer getMaxPacingRate() {
        return maxPacingRate;
    }

    public void setMaxPacingRate(Integer maxPacingRate) {
        this.maxPacingRate = maxPacingRate;
    }

    public Integer getBytesAcked() {
        return bytesAcked;
    }

    public void setBytesAcked(Integer bytesAcked) {
        this.bytesAcked = bytesAcked;
    }

    public Integer getBytesReceived() {
        return bytesReceived;
    }

    public void setBytesReceived(Integer bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    public Integer getSegsOut() {
        return segsOut;
    }

    public void setSegsOut(Integer segsOut) {
        this.segsOut = segsOut;
    }

    public Integer getSegsIn() {
        return segsIn;
    }

    public void setSegsIn(Integer segsIn) {
        this.segsIn = segsIn;
    }

    public Integer getNotsentBytes() {
        return notsentBytes;
    }

    public void setNotsentBytes(Integer notsentBytes) {
        this.notsentBytes = notsentBytes;
    }

    public Integer getMinRTT() {
        return minRTT;
    }

    public void setMinRTT(Integer minRTT) {
        this.minRTT = minRTT;
    }

    public Integer getDataSegsIn() {
        return dataSegsIn;
    }

    public void setDataSegsIn(Integer dataSegsIn) {
        this.dataSegsIn = dataSegsIn;
    }

    public Integer getDataSegsOut() {
        return dataSegsOut;
    }

    public void setDataSegsOut(Integer dataSegsOut) {
        this.dataSegsOut = dataSegsOut;
    }

    public Integer getDeliveryRate() {
        return deliveryRate;
    }

    public void setDeliveryRate(Integer deliveryRate) {
        this.deliveryRate = deliveryRate;
    }

    public Integer getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(Integer busyTime) {
        this.busyTime = busyTime;
    }

    public Integer getRWndLimited() {
        return rWndLimited;
    }

    public void setRWndLimited(Integer rWndLimited) {
        this.rWndLimited = rWndLimited;
    }

    public Integer getSndBufLimited() {
        return sndBufLimited;
    }

    public void setSndBufLimited(Integer sndBufLimited) {
        this.sndBufLimited = sndBufLimited;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Integer getDeliveredCE() {
        return deliveredCE;
    }

    public void setDeliveredCE(Integer deliveredCE) {
        this.deliveredCE = deliveredCE;
    }

    public Integer getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(Integer bytesSent) {
        this.bytesSent = bytesSent;
    }

    public Integer getBytesRetrans() {
        return bytesRetrans;
    }

    public void setBytesRetrans(Integer bytesRetrans) {
        this.bytesRetrans = bytesRetrans;
    }

    public Integer getDSackDups() {
        return dSackDups;
    }

    public void setDSackDups(Integer dSackDups) {
        this.dSackDups = dSackDups;
    }

    public Integer getReordSeen() {
        return reordSeen;
    }

    public void setReordSeen(Integer reordSeen) {
        this.reordSeen = reordSeen;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(state);
        dest.writeValue(cAState);
        dest.writeValue(retransmits);
        dest.writeValue(probes);
        dest.writeValue(backoff);
        dest.writeValue(options);
        dest.writeValue(wScale);
        dest.writeValue(appLimited);
        dest.writeValue(rTO);
        dest.writeValue(aTO);
        dest.writeValue(sndMSS);
        dest.writeValue(rcvMSS);
        dest.writeValue(unacked);
        dest.writeValue(sacked);
        dest.writeValue(lost);
        dest.writeValue(retrans);
        dest.writeValue(fackets);
        dest.writeValue(lastDataSent);
        dest.writeValue(lastAckSent);
        dest.writeValue(lastDataRecv);
        dest.writeValue(lastAckRecv);
        dest.writeValue(pMTU);
        dest.writeValue(rcvSsThresh);
        dest.writeValue(rTT);
        dest.writeValue(rTTVar);
        dest.writeValue(sndSsThresh);
        dest.writeValue(sndCwnd);
        dest.writeValue(advMSS);
        dest.writeValue(reordering);
        dest.writeValue(rcvRTT);
        dest.writeValue(rcvSpace);
        dest.writeValue(totalRetrans);
        dest.writeValue(pacingRate);
        dest.writeValue(maxPacingRate);
        dest.writeValue(bytesAcked);
        dest.writeValue(bytesReceived);
        dest.writeValue(segsOut);
        dest.writeValue(segsIn);
        dest.writeValue(notsentBytes);
        dest.writeValue(minRTT);
        dest.writeValue(dataSegsIn);
        dest.writeValue(dataSegsOut);
        dest.writeValue(deliveryRate);
        dest.writeValue(busyTime);
        dest.writeValue(rWndLimited);
        dest.writeValue(sndBufLimited);
        dest.writeValue(delivered);
        dest.writeValue(deliveredCE);
        dest.writeValue(bytesSent);
        dest.writeValue(bytesRetrans);
        dest.writeValue(dSackDups);
        dest.writeValue(reordSeen);
        dest.writeValue(elapsedTime);
    }

    public int describeContents() {
        return  0;
    }

}

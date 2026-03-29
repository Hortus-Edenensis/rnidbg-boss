package com.wifi.ad.core.config.adx.model;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\u001a\u00102\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000f¨\u00066"}, d2 = {"Lcom/wifi/ad/core/config/adx/model/WkAdConfigModel;", "", "()V", "allModels", "", "Lcom/wifi/ad/core/config/adx/model/WkAdStrategyModel;", "getAllModels", "()Ljava/util/List;", "setAllModels", "(Ljava/util/List;)V", "bidType", "", "getBidType", "()I", "setBidType", "(I)V", "freqControl", "Lcom/wifi/ad/core/config/adx/model/WkAdFreqControl;", "getFreqControl", "()Lcom/wifi/ad/core/config/adx/model/WkAdFreqControl;", "setFreqControl", "(Lcom/wifi/ad/core/config/adx/model/WkAdFreqControl;)V", "isHasBaiDuAd", "", "()Z", "setHasBaiDuAd", "(Z)V", "isHasCsjAd", "setHasCsjAd", "isHasGdtAd", "setHasGdtAd", "isHasKSAd", "setHasKSAd", "isHasWifiAd", "setHasWifiAd", "other4BidType", "getOther4BidType", "setOther4BidType", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "sourceId", "getSourceId", "setSourceId", "timeOut", "getTimeOut", "setTimeOut", "updateTime", "getUpdateTime", "setUpdateTime", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkAdConfigModel {
    public static final int BIDTYPE_COMPETE = 3;
    public static final int BIDTYPE_MIXED = 4;
    public static final int BIDTYPE_PRIORITY = 2;
    public static final int BIDTYPE_PROPORTION = 1;
    public static final int OTHER_BIDTYPE_COMPETE = 3;
    public static final int OTHER_BIDTYPE_PRIORITY = 2;
    public static final int OTHER_BIDTYPE_PROPORTION = 1;
    public static final String TAG_ADTEMPLETE = "adtemplate";
    public static final String TAG_BIDTYPE = "bidtype";
    public static final String TAG_BLOCK = "block";
    public static final String TAG_DSPID = "dspid";
    public static final String TAG_DSPNAME = "dspname";
    public static final String TAG_ECPM = "ecpm";
    public static final String TAG_ECPMMAP = "mutliprice";
    public static final String TAG_FREQCONTROL = "freq_control";
    public static final String TAG_GDT_CLOSETIME = "close_time";
    public static final String TAG_INTERVAL = "interval";
    public static final String TAG_OTHER_BIDTYPE = "subbidtype";
    public static final String TAG_PRIORITY = "priority";
    public static final String TAG_RATIO = "ratio";
    public static final String TAG_SLOTID = "slotid";
    public static final String TAG_SOURCEID = "srcid";
    public static final String TAG_STRATEGY = "strategy";
    public static final String TAG_TIMEOUT = "timeout";
    public static final String TAG_UPDATETIME = "update_interval";
    private List<WkAdStrategyModel> allModels;
    private WkAdFreqControl freqControl;
    private boolean isHasBaiDuAd;
    private boolean isHasCsjAd;
    private boolean isHasGdtAd;
    private boolean isHasKSAd;
    private boolean isHasWifiAd;
    private String requestId;
    private String sourceId;
    private int timeOut;
    private int bidType = 1;
    private int other4BidType = 1;
    private int updateTime = 24;

    public final List<WkAdStrategyModel> getAllModels() {
        return this.allModels;
    }

    public final int getBidType() {
        return this.bidType;
    }

    public final WkAdFreqControl getFreqControl() {
        return this.freqControl;
    }

    public final int getOther4BidType() {
        return this.other4BidType;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    /* JADX INFO: renamed from: isHasBaiDuAd, reason: from getter */
    public final boolean getIsHasBaiDuAd() {
        return this.isHasBaiDuAd;
    }

    /* JADX INFO: renamed from: isHasCsjAd, reason: from getter */
    public final boolean getIsHasCsjAd() {
        return this.isHasCsjAd;
    }

    /* JADX INFO: renamed from: isHasGdtAd, reason: from getter */
    public final boolean getIsHasGdtAd() {
        return this.isHasGdtAd;
    }

    /* JADX INFO: renamed from: isHasKSAd, reason: from getter */
    public final boolean getIsHasKSAd() {
        return this.isHasKSAd;
    }

    /* JADX INFO: renamed from: isHasWifiAd, reason: from getter */
    public final boolean getIsHasWifiAd() {
        return this.isHasWifiAd;
    }

    public final void setAllModels(List<WkAdStrategyModel> list) {
        this.allModels = list;
    }

    public final void setBidType(int i) {
        this.bidType = i;
    }

    public final void setFreqControl(WkAdFreqControl wkAdFreqControl) {
        this.freqControl = wkAdFreqControl;
    }

    public final void setHasBaiDuAd(boolean z) {
        this.isHasBaiDuAd = z;
    }

    public final void setHasCsjAd(boolean z) {
        this.isHasCsjAd = z;
    }

    public final void setHasGdtAd(boolean z) {
        this.isHasGdtAd = z;
    }

    public final void setHasKSAd(boolean z) {
        this.isHasKSAd = z;
    }

    public final void setHasWifiAd(boolean z) {
        this.isHasWifiAd = z;
    }

    public final void setOther4BidType(int i) {
        this.other4BidType = i;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setSourceId(String str) {
        this.sourceId = str;
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }

    public final void setUpdateTime(int i) {
        this.updateTime = i;
    }
}

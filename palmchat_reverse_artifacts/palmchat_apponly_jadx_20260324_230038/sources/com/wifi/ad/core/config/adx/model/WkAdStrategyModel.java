package com.wifi.ad.core.config.adx.model;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00104\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR\u001a\u0010)\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001c\u00101\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015¨\u00067"}, d2 = {"Lcom/wifi/ad/core/config/adx/model/WkAdStrategyModel;", "", "()V", "adLoadState", "", "adTemplate", "getAdTemplate", "()I", "setAdTemplate", "(I)V", "adTimeOut", "getAdTimeOut", "setAdTimeOut", "dspId", "getDspId", "setDspId", "dspName", "", "getDspName", "()Ljava/lang/String;", "setDspName", "(Ljava/lang/String;)V", "ecpm", "getEcpm", "setEcpm", "ecpmLevelArray", "Lorg/json/JSONArray;", "getEcpmLevelArray", "()Lorg/json/JSONArray;", "setEcpmLevelArray", "(Lorg/json/JSONArray;)V", "ecpmLevelMap", "", "Lcom/wifi/ad/core/config/adx/model/WkAdMutliPrice;", "getEcpmLevelMap", "()Ljava/util/List;", "setEcpmLevelMap", "(Ljava/util/List;)V", "gdtPopCloseTime", "getGdtPopCloseTime", "setGdtPopCloseTime", "isAllBlock", "setAllBlock", "priority", "getPriority", "setPriority", "ratio", "getRatio", "setRatio", "slotId", "getSlotId", "setSlotId", "setAdLoadState", "", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkAdStrategyModel {
    public static final int STATE_LOAD_FAILED = 2;
    public static final int STATE_LOAD_SUCCESS = 1;
    public static final int STATE_NO_LOAD = 0;
    private int adLoadState;
    private int adTemplate;
    private int adTimeOut;
    private int dspId;
    private String dspName;
    private int ecpm;
    private JSONArray ecpmLevelArray;
    private List<WkAdMutliPrice> ecpmLevelMap;
    private int gdtPopCloseTime;
    private int isAllBlock;
    private int priority;
    private int ratio;
    private String slotId;

    /* JADX INFO: renamed from: adLoadState, reason: from getter */
    public final int getAdLoadState() {
        return this.adLoadState;
    }

    public final int getAdTemplate() {
        return this.adTemplate;
    }

    public final int getAdTimeOut() {
        return this.adTimeOut;
    }

    public final int getDspId() {
        return this.dspId;
    }

    public final String getDspName() {
        return this.dspName;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final JSONArray getEcpmLevelArray() {
        return this.ecpmLevelArray;
    }

    public final List<WkAdMutliPrice> getEcpmLevelMap() {
        return this.ecpmLevelMap;
    }

    public final int getGdtPopCloseTime() {
        return this.gdtPopCloseTime;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRatio() {
        return this.ratio;
    }

    public final String getSlotId() {
        return this.slotId;
    }

    /* JADX INFO: renamed from: isAllBlock, reason: from getter */
    public final int getIsAllBlock() {
        return this.isAllBlock;
    }

    public final void setAdLoadState(int adLoadState) {
        this.adLoadState = adLoadState;
    }

    public final void setAdTemplate(int i) {
        this.adTemplate = i;
    }

    public final void setAdTimeOut(int i) {
        this.adTimeOut = i;
    }

    public final void setAllBlock(int i) {
        this.isAllBlock = i;
    }

    public final void setDspId(int i) {
        this.dspId = i;
    }

    public final void setDspName(String str) {
        this.dspName = str;
    }

    public final void setEcpm(int i) {
        this.ecpm = i;
    }

    public final void setEcpmLevelArray(JSONArray jSONArray) {
        this.ecpmLevelArray = jSONArray;
    }

    public final void setEcpmLevelMap(List<WkAdMutliPrice> list) {
        this.ecpmLevelMap = list;
    }

    public final void setGdtPopCloseTime(int i) {
        this.gdtPopCloseTime = i;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final void setRatio(int i) {
        this.ratio = i;
    }

    public final void setSlotId(String str) {
        this.slotId = str;
    }
}

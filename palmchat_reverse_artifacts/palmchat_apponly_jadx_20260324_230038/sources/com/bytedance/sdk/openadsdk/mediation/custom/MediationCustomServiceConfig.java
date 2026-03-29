package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class MediationCustomServiceConfig {
    private int b;
    private int fx;
    private Map<String, Object> iz = new HashMap();
    private String nr;
    private String pn;
    private String u;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.u = str;
        this.nr = str2;
        this.fx = i;
        this.b = i2;
        this.pn = str3;
    }

    public String getADNNetworkName() {
        return this.u;
    }

    public String getADNNetworkSlotId() {
        return this.nr;
    }

    public int getAdStyleType() {
        return this.fx;
    }

    public String getCustomAdapterJson() {
        return this.pn;
    }

    public Map<String, Object> getExtraData() {
        return this.iz;
    }

    public int getSubAdtype() {
        return this.b;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.u + "', mADNNetworkSlotId='" + this.nr + "', mAdStyleType=" + this.fx + ", mSubAdtype=" + this.b + ", mCustomAdapterJson='" + this.pn + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.u = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.nr = valueSet.stringValue(2);
            this.fx = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.b = valueSet.intValue(8094);
            this.pn = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.iz.putAll(map);
        }
    }
}

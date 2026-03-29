package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationCustomInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5424a;
    private String b;
    private String fx;
    private String iz;
    private String jk;
    private String n;
    private String nr;
    private String pn;
    private String t;
    private String u;
    private String x;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.fx = str;
        this.u = str2;
        this.nr = str3;
        this.b = str4;
        this.pn = str5;
        this.iz = str6;
        this.x = str7;
        this.n = str8;
        this.f5424a = str9;
        this.jk = str10;
        this.t = str11;
    }

    public String getADNName() {
        return this.fx;
    }

    public String getAdnInitClassName() {
        return this.b;
    }

    public String getAppId() {
        return this.u;
    }

    public String getAppKey() {
        return this.nr;
    }

    public String getBannerClassName() {
        return this.pn;
    }

    public String getDrawClassName() {
        return this.t;
    }

    public String getFeedClassName() {
        return this.jk;
    }

    public String getFullVideoClassName() {
        return this.n;
    }

    public String getInterstitialClassName() {
        return this.iz;
    }

    public String getRewardClassName() {
        return this.x;
    }

    public String getSplashClassName() {
        return this.f5424a;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.u + "', mAppKey='" + this.nr + "', mADNName='" + this.fx + "', mAdnInitClassName='" + this.b + "', mBannerClassName='" + this.pn + "', mInterstitialClassName='" + this.iz + "', mRewardClassName='" + this.x + "', mFullVideoClassName='" + this.n + "', mSplashClassName='" + this.f5424a + "', mFeedClassName='" + this.jk + "', mDrawClassName='" + this.t + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.fx = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.u = valueSet.stringValue(8534);
            this.nr = valueSet.stringValue(8535);
            this.b = valueSet.stringValue(8536);
            this.pn = valueSet.stringValue(8537);
            this.iz = valueSet.stringValue(8538);
            this.x = valueSet.stringValue(8539);
            this.n = valueSet.stringValue(8540);
            this.f5424a = valueSet.stringValue(8541);
            this.jk = valueSet.stringValue(8542);
            this.t = valueSet.stringValue(8543);
        }
    }
}

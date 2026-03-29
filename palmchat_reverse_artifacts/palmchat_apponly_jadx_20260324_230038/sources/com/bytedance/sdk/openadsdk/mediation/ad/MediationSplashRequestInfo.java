package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String b;
    private String fx;
    private String nr;
    private String u;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.u = str;
        this.nr = str2;
        this.fx = str3;
        this.b = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.b;
    }
}

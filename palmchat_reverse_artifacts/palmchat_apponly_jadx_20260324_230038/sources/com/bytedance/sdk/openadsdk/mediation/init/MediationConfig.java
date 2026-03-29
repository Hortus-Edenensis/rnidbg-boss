package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationConfig implements IMediationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5427a;
    private Map<String, Object> b;
    private MediationConfigUserInfoForSegment fx;
    private JSONObject iz;
    private boolean jk;
    private String n;
    private boolean nr;
    private boolean pn;
    private String t;
    private String u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5428a;
        private Map<String, Object> b;
        private MediationConfigUserInfoForSegment fx;
        private JSONObject iz;
        private boolean jk;
        private String n;
        private boolean nr;
        private boolean pn;
        private String t;
        private String u;
        private boolean x;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.u = this.u;
            mediationConfig.nr = this.nr;
            mediationConfig.fx = this.fx;
            mediationConfig.b = this.b;
            mediationConfig.pn = this.pn;
            mediationConfig.iz = this.iz;
            mediationConfig.x = this.x;
            mediationConfig.n = this.n;
            mediationConfig.f5427a = this.f5428a;
            mediationConfig.jk = this.jk;
            mediationConfig.t = this.t;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.iz = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.pn = z;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.fx = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.nr = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.n = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.u = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.f5428a = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.jk = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.t = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.x = z;
            return this;
        }
    }

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.f5427a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.t;
    }
}

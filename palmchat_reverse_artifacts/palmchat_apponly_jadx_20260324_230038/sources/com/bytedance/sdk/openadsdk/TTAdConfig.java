package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class TTAdConfig extends CSJConfig {

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private CSJConfig.u u = new CSJConfig.u();

        public Builder addExtra(String str, Object obj) {
            this.u.u(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.u.nr(z);
            return this;
        }

        public Builder appId(String str) {
            this.u.u(str);
            return this;
        }

        public Builder appName(String str) {
            this.u.nr(str);
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this.u);
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.u.u(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.u.b(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.u.fx(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.u.u(iArr);
            return this;
        }

        public Builder keywords(String str) {
            this.u.fx(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.u.u(z);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.u.b(i);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.u.u(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.u.fx(i);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.u.b(z);
            return this;
        }

        public Builder themeStatus(int i) {
            this.u.nr(i);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.u.u(i);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.u.pn(z);
            return this;
        }
    }

    private TTAdConfig(CSJConfig.u uVar) {
        super(uVar);
    }
}

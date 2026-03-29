package com.zm.fissionsdk.api;

import com.zm.fissionsdk.api.interfaces.IFissionUnityCallback;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FissionUnityConfig implements Serializable {
    private Builder builder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder implements Serializable {
        private String appKey;
        private String appSecret;
        private transient IFissionUnityCallback callback;
        private boolean preloadGameCenter;

        public FissionUnityConfig build() {
            return new FissionUnityConfig(this);
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Builder setCallback(IFissionUnityCallback iFissionUnityCallback) {
            this.callback = iFissionUnityCallback;
            return this;
        }

        public Builder setPreloadGameCenter(boolean z) {
            this.preloadGameCenter = z;
            return this;
        }
    }

    public String getAppKey() {
        return this.builder.appKey;
    }

    public String getAppSecret() {
        return this.builder.appSecret;
    }

    public IFissionUnityCallback getCallback() {
        return this.builder.callback;
    }

    public boolean isPreloadGameCenter() {
        return this.builder.preloadGameCenter;
    }

    private FissionUnityConfig(Builder builder) {
        this.builder = builder;
    }
}

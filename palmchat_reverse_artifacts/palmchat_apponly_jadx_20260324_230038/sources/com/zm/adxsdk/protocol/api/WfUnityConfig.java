package com.zm.adxsdk.protocol.api;

import com.zm.adxsdk.protocol.api.interfaces.IUnityCallback;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfUnityConfig implements Serializable {
    private Builder builder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder implements Serializable {
        private String appKey;
        private String appSecret;
        private transient IUnityCallback callback;
        private boolean preloadGameCenter;

        public WfUnityConfig build() {
            return new WfUnityConfig(this);
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Builder setCallback(IUnityCallback iUnityCallback) {
            this.callback = iUnityCallback;
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

    public IUnityCallback getCallback() {
        return this.builder.callback;
    }

    public boolean isPreloadGameCenter() {
        return this.builder.preloadGameCenter;
    }

    private WfUnityConfig(Builder builder) {
        this.builder = builder;
    }
}

package com.oplus.tblplayer.config;

import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.wrapper.SSLSocketFactoryWrapper;
import com.oplus.tblplayer.wrapper.SocketFactoryWrapper;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class HttpConfig {
    public final CacheControl okhttpCacheControl;
    public final Call.Factory okhttpCallFactory;
    public final boolean okhttpEnable;
    public final boolean preferRedirectAddress;
    public final boolean preferSubrangeRequest;
    public final String userAgent;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private String userAgent = Constants.DEFAULT_USER_AGENT;
        private boolean okhttpEnable = false;
        private OkHttpClient.Builder okhttpClientBuilder = null;
        private CacheControl okhttpCacheControl = null;
        private boolean preferRedirectAddress = false;
        private boolean preferSubrangeRequest = false;

        public HttpConfig build() {
            if (!this.okhttpEnable) {
                return new HttpConfig(this.userAgent, false, null, null, false, false);
            }
            OkHttpClient.Builder builder = this.okhttpClientBuilder;
            Call.Factory factoryBuild = builder != null ? builder.build() : new OkHttpClient();
            String str = this.userAgent;
            if (this.preferRedirectAddress) {
                factoryBuild = HttpConfig.newOkHttpCallFactory(factoryBuild);
            }
            return new HttpConfig(str, true, factoryBuild, this.okhttpCacheControl, this.preferRedirectAddress, this.preferSubrangeRequest);
        }

        public Builder setOkhttpCacheControl(CacheControl cacheControl) {
            this.okhttpCacheControl = cacheControl;
            return this;
        }

        public Builder setOkhttpCallFactory(Call.Factory factory) {
            this.okhttpClientBuilder = factory instanceof OkHttpClient ? ((OkHttpClient) factory).newBuilder() : null;
            return this;
        }

        public Builder setOkhttpClientBuilder(OkHttpClient.Builder builder) {
            this.okhttpClientBuilder = builder;
            return this;
        }

        public Builder setOkhttpEnable(boolean z) {
            this.okhttpEnable = z;
            return this;
        }

        public Builder setPreferRedirectAddress(boolean z) {
            this.preferRedirectAddress = z;
            return this;
        }

        public Builder setPreferSubrangeRequest(boolean z) {
            this.preferSubrangeRequest = z;
            return this;
        }

        public Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }
    }

    public HttpConfig(String str, boolean z, Call.Factory factory, CacheControl cacheControl, boolean z2, boolean z3) {
        this.userAgent = str;
        this.okhttpEnable = z;
        this.okhttpCallFactory = factory;
        this.okhttpCacheControl = cacheControl;
        this.preferRedirectAddress = z2;
        this.preferSubrangeRequest = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Call.Factory newOkHttpCallFactory(Call.Factory factory) {
        if (!(factory instanceof OkHttpClient)) {
            return factory;
        }
        OkHttpClient okHttpClient = (OkHttpClient) factory;
        OkHttpClient.Builder builderNewBuilder = okHttpClient.newBuilder();
        SocketFactory socketFactory = okHttpClient.socketFactory();
        SSLSocketFactory sslSocketFactory = okHttpClient.sslSocketFactory();
        builderNewBuilder.socketFactory(new SocketFactoryWrapper(socketFactory));
        builderNewBuilder.sslSocketFactory(new SSLSocketFactoryWrapper(sslSocketFactory), Util.platformTrustManager());
        return builderNewBuilder.build();
    }

    public String toString() {
        return "HttpConfig{userAgent=" + this.userAgent + ", okhttpEnable=" + this.okhttpEnable + ", okhttpCallFactory=" + this.okhttpCallFactory + ", okhttpCacheControl=" + this.okhttpCacheControl + ", preferRedirectAddress=" + this.preferRedirectAddress + ", preferSubrangeRequest=" + this.preferSubrangeRequest + "}";
    }
}

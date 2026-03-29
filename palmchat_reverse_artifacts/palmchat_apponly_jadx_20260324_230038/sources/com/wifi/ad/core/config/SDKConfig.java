package com.wifi.ad.core.config;

import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.listener.IAdSensitiveTaker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/wifi/ad/core/config/SDKConfig;", "", "builder", "Lcom/wifi/ad/core/config/SDKConfig$Builder;", "(Lcom/wifi/ad/core/config/SDKConfig$Builder;)V", "alias", "Lcom/wifi/ad/core/SDKAlias;", "getAlias$core_release", "()Lcom/wifi/ad/core/SDKAlias;", "setAlias$core_release", "(Lcom/wifi/ad/core/SDKAlias;)V", "allowInit", "", "getAllowInit$core_release", "()Z", "setAllowInit$core_release", "(Z)V", "appId", "", "getAppId$core_release", "()Ljava/lang/String;", "setAppId$core_release", "(Ljava/lang/String;)V", "asyncInit", "getAsyncInit$core_release", "setAsyncInit$core_release", "taker", "Lcom/wifi/ad/core/listener/IAdSensitiveTaker;", "getTaker$core_release", "()Lcom/wifi/ad/core/listener/IAdSensitiveTaker;", "setTaker$core_release", "(Lcom/wifi/ad/core/listener/IAdSensitiveTaker;)V", "Builder", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SDKConfig {
    private SDKAlias alias;
    private boolean allowInit;
    private String appId;
    private boolean asyncInit;
    private IAdSensitiveTaker taker;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/wifi/ad/core/config/SDKConfig$Builder;", "", "()V", "alias", "Lcom/wifi/ad/core/SDKAlias;", "getAlias$core_release", "()Lcom/wifi/ad/core/SDKAlias;", "setAlias$core_release", "(Lcom/wifi/ad/core/SDKAlias;)V", "allowInit", "", "getAllowInit$core_release", "()Z", "setAllowInit$core_release", "(Z)V", "appId", "", "getAppId$core_release", "()Ljava/lang/String;", "setAppId$core_release", "(Ljava/lang/String;)V", "asyncInit", "getAsyncInit$core_release", "setAsyncInit$core_release", "taker", "Lcom/wifi/ad/core/listener/IAdSensitiveTaker;", "getTaker$core_release", "()Lcom/wifi/ad/core/listener/IAdSensitiveTaker;", "setTaker$core_release", "(Lcom/wifi/ad/core/listener/IAdSensitiveTaker;)V", "build", "Lcom/wifi/ad/core/config/SDKConfig;", "setAlias", "setAllowInit", "setAppId", "setAsyncInit", "setSensitiveTaker", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private SDKAlias alias;
        private boolean allowInit = true;
        private String appId;
        private boolean asyncInit;
        private IAdSensitiveTaker taker;

        public final SDKConfig build() {
            return new SDKConfig(this, null);
        }

        /* JADX INFO: renamed from: getAlias$core_release, reason: from getter */
        public final SDKAlias getAlias() {
            return this.alias;
        }

        /* JADX INFO: renamed from: getAllowInit$core_release, reason: from getter */
        public final boolean getAllowInit() {
            return this.allowInit;
        }

        /* JADX INFO: renamed from: getAppId$core_release, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* JADX INFO: renamed from: getAsyncInit$core_release, reason: from getter */
        public final boolean getAsyncInit() {
            return this.asyncInit;
        }

        /* JADX INFO: renamed from: getTaker$core_release, reason: from getter */
        public final IAdSensitiveTaker getTaker() {
            return this.taker;
        }

        public final Builder setAlias(SDKAlias alias) {
            this.alias = alias;
            return this;
        }

        public final void setAlias$core_release(SDKAlias sDKAlias) {
            this.alias = sDKAlias;
        }

        public final Builder setAllowInit(boolean allowInit) {
            this.allowInit = allowInit;
            return this;
        }

        public final void setAllowInit$core_release(boolean z) {
            this.allowInit = z;
        }

        public final Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public final void setAppId$core_release(String str) {
            this.appId = str;
        }

        public final Builder setAsyncInit(boolean asyncInit) {
            this.asyncInit = asyncInit;
            return this;
        }

        public final void setAsyncInit$core_release(boolean z) {
            this.asyncInit = z;
        }

        public final Builder setSensitiveTaker(IAdSensitiveTaker taker) {
            this.taker = taker;
            return this;
        }

        public final void setTaker$core_release(IAdSensitiveTaker iAdSensitiveTaker) {
            this.taker = iAdSensitiveTaker;
        }
    }

    private SDKConfig(Builder builder) {
        this.allowInit = true;
        this.appId = builder.getAppId();
        this.alias = builder.getAlias();
        this.asyncInit = builder.getAsyncInit();
        this.taker = builder.getTaker();
        this.allowInit = builder.getAllowInit();
    }

    /* JADX INFO: renamed from: getAlias$core_release, reason: from getter */
    public final SDKAlias getAlias() {
        return this.alias;
    }

    /* JADX INFO: renamed from: getAllowInit$core_release, reason: from getter */
    public final boolean getAllowInit() {
        return this.allowInit;
    }

    /* JADX INFO: renamed from: getAppId$core_release, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: getAsyncInit$core_release, reason: from getter */
    public final boolean getAsyncInit() {
        return this.asyncInit;
    }

    /* JADX INFO: renamed from: getTaker$core_release, reason: from getter */
    public final IAdSensitiveTaker getTaker() {
        return this.taker;
    }

    public final void setAlias$core_release(SDKAlias sDKAlias) {
        this.alias = sDKAlias;
    }

    public final void setAllowInit$core_release(boolean z) {
        this.allowInit = z;
    }

    public final void setAppId$core_release(String str) {
        this.appId = str;
    }

    public final void setAsyncInit$core_release(boolean z) {
        this.asyncInit = z;
    }

    public final void setTaker$core_release(IAdSensitiveTaker iAdSensitiveTaker) {
        this.taker = iAdSensitiveTaker;
    }

    public /* synthetic */ SDKConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }
}

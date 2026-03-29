package com.tide.host.model;

import com.tide.protocol.config.ITideHostConfig;
import com.tide.protocol.report.IFdaReporter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TideHostConfig implements ITideHostConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10806a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final double f;
    public final double g;
    public final String h;
    public final IFdaReporter i;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10807a;
        public String b;
        public String c;
        public String d;
        public String e;
        public double f;
        public double g;
        public String h;
        public IFdaReporter i;

        public Builder androidId(String str) {
            this.e = str;
            return this;
        }

        public Builder appId(String str) {
            this.c = str;
            return this;
        }

        public TideHostConfig build() {
            return new TideHostConfig(this);
        }

        public Builder hostCode(int i) {
            this.f10807a = i;
            return this;
        }

        public Builder hostVersion(String str) {
            this.b = str;
            return this;
        }

        public Builder latitude(double d) {
            this.f = d;
            return this;
        }

        public Builder longitude(double d) {
            this.g = d;
            return this;
        }

        public Builder oaId(String str) {
            this.d = str;
            return this;
        }

        public Builder pluginName(String str) {
            this.h = str;
            return this;
        }

        public Builder reporter(IFdaReporter iFdaReporter) {
            this.i = iFdaReporter;
            return this;
        }
    }

    public TideHostConfig(Builder builder) {
        this.f10806a = builder.f10807a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public String getAndroidId() {
        return this.e;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public String getAppId() {
        return this.c;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public IFdaReporter getFdaReporter() {
        return this.i;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public String getHostVersion() {
        return this.b;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public int getHostVersionCode() {
        return this.f10806a;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public double getLatitude() {
        return this.f;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public double getLongitude() {
        return this.g;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public String getOaId() {
        return this.d;
    }

    @Override // com.tide.protocol.config.ITideHostConfig
    public String getPluginName() {
        return this.h;
    }
}

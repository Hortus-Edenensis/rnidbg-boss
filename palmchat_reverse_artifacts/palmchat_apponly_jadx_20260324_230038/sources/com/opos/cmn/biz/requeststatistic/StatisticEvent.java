package com.opos.cmn.biz.requeststatistic;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StatisticEvent {
    public final String channel;
    public final long currentTime;
    public final String eventId;
    public final String ext;
    public final long maxResolveTime;

    /* JADX INFO: renamed from: net, reason: collision with root package name */
    public final String f7862net;
    public final long resolveTime;
    public final long ret;
    public final String sdkVersion;
    public final String url;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7863a;
        private String b;
        private long c;
        private String d;
        private long e;
        private long f;
        private long g;
        private String h = "";
        private String i;
        private String j;

        public Builder(String str, String str2, long j, long j2, long j3, String str3) {
            this.b = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.i = str3;
        }

        public StatisticEvent build() {
            return new StatisticEvent(this);
        }

        public Builder setCurrentTime(long j) {
            this.c = j;
            return this;
        }

        public Builder setExt(String str) {
            this.h = str;
            return this;
        }

        public Builder setNet(String str) {
            this.f7863a = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.j = str;
            return this;
        }
    }

    private StatisticEvent(Builder builder) {
        this.eventId = builder.b;
        this.url = builder.d;
        this.ret = builder.e;
        this.currentTime = builder.c;
        this.resolveTime = builder.f;
        this.maxResolveTime = builder.g;
        this.f7862net = builder.f7863a;
        this.ext = builder.h;
        this.channel = builder.i;
        this.sdkVersion = builder.j;
    }
}

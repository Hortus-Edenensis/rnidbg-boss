package com.huawei.hms.push.utils.ha;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PushAnalyticsCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f6844a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f6845a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f6845a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f6844a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f6844a = pushBaseAnalytics;
    }
}

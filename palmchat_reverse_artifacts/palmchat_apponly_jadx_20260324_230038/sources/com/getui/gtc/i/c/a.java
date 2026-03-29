package com.getui.gtc.i.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f5794a;

    /* JADX INFO: renamed from: com.getui.gtc.i.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0344a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f5795a = new a(0);
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f5794a = logger;
        logger.setGlobalTag("gtc");
        logger.setFileEnableProperty("gtc.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public static void a(String str) {
        C0344a.f5795a.f5794a.d(str);
    }

    public static void b(String str) {
        C0344a.f5795a.f5794a.w(str);
    }

    public static void c(String str) {
        C0344a.f5795a.f5794a.e(str);
    }

    public static void d(String str) {
        C0344a.f5795a.f5794a.filelog(2, null, str, null);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static void a(String str, Throwable th) {
        C0344a.f5795a.f5794a.e(str, th);
    }

    public static void b(Throwable th) {
        C0344a.f5795a.f5794a.w(th);
    }

    public static void c(Throwable th) {
        C0344a.f5795a.f5794a.e(th);
    }

    public static void d(Throwable th) {
        C0344a.f5795a.f5794a.filelog(2, null, null, th);
    }

    public static void a(Throwable th) {
        C0344a.f5795a.f5794a.d(th);
    }
}

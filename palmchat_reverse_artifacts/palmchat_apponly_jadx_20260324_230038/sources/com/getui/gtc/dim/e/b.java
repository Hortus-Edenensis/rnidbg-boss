package com.getui.gtc.dim.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f5742a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5743a = new b(0);
    }

    private b() {
        Logger logger = new Logger(GtcProvider.context());
        this.f5742a = logger;
        logger.setGlobalTag("gtc.dim");
        logger.setFileEnableProperty("dim.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public static void a(String str) {
        a.f5743a.f5742a.d(str);
    }

    public static void b(String str) {
        a.f5743a.f5742a.w(str);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static void a(String str, Throwable th) {
        a.f5743a.f5742a.e(str, th);
    }

    public static void b(Throwable th) {
        a.f5743a.f5742a.e(th);
    }

    public static void a(Throwable th) {
        a.f5743a.f5742a.w(th);
    }
}

package com.getui.gtc.dyc.a.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Logger f5750a;

    /* JADX INFO: renamed from: com.getui.gtc.dyc.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0341a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f5751a = new a();
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f5750a = logger;
        logger.setGlobalTag("gtc.dyc");
        this.f5750a.setFileEnableProperty("dyc.fileLog");
        this.f5750a.setLogcatEnable(false);
        this.f5750a.setLogFileNameSuffix("gtc");
        this.f5750a.setStackOffset(1);
    }

    public static Logger a() {
        return C0341a.f5751a.f5750a;
    }

    public static void c(Throwable th) {
        C0341a.f5751a.f5750a.e(th);
    }

    public static void a(String str) {
        C0341a.f5751a.f5750a.e(str);
    }

    public static void a(Throwable th) {
        C0341a.f5751a.f5750a.w(th);
    }
}

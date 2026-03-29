package com.baidu.mapsdkplatform.comapi.a.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3937a = 10240;
    private static volatile boolean b = false;
    private String c;
    private Thread.UncaughtExceptionHandler d;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3938a = new a();
    }

    public static a a() {
        return b.f3938a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (b) {
            return;
        }
        b = true;
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private a() {
        this.c = "";
        this.d = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void a(String str) {
        this.c = str;
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(Throwable th) {
        String str;
        if (th == null) {
            return;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            Throwable cause = th.getCause();
            if (cause != null) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            String string = stringWriter.toString();
            if (string.isEmpty()) {
                return;
            }
            int length = string.length();
            int i = f3937a;
            if (length > i) {
                string = string.substring(0, i);
            }
            if (string.contains("BDMapSDKException")) {
                return;
            }
            if ((string.contains("com.baidu.platform") || string.contains("com.baidu.mapsdkplatform") || string.contains("com.baidu.baidunavis") || string.contains("com.baidu.navisdk") || string.contains("com.baidu.navcore")) && (str = this.c) != null && !str.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.a.a.b.c().a(this.c + (System.currentTimeMillis() / 1000) + ".txt", string);
            }
        } catch (Exception unused) {
        }
    }
}

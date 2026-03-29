package com.baidu.mshield.x6.f;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f4087a;
    public static Handler b;

    public c() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f4087a == null) {
            f4087a = new c();
            f4087a.start();
            b = new Handler(f4087a.getLooper());
        }
    }

    public static Handler b() {
        Handler handler;
        try {
            synchronized (c.class) {
                a();
                handler = b;
            }
            return handler;
        } catch (Throwable th) {
            f.b(th);
            return b;
        }
    }
}

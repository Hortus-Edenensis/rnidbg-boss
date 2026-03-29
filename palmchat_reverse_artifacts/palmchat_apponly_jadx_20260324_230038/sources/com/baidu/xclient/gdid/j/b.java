package com.baidu.xclient.gdid.j;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f4314a;
    public static Handler b;

    public b() {
        super("BackgroundThread", 10);
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            c();
            bVar = f4314a;
        }
        return bVar;
    }

    public static Handler b() {
        Handler handler;
        synchronized (b.class) {
            c();
            handler = b;
        }
        return handler;
    }

    public static void c() {
        if (f4314a == null) {
            b bVar = new b();
            f4314a = bVar;
            bVar.start();
            b = new Handler(f4314a.getLooper());
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            b().post(runnable);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}

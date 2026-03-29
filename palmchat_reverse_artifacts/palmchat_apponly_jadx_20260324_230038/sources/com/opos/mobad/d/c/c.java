package com.opos.mobad.d.c;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f8757a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f8757a;
    }

    public static final void b(Runnable runnable) {
        f8757a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f8757a.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        f8757a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f8757a.postDelayed(runnable, j);
    }
}

package com.opos.mobad.service;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f9198a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f9198a;
    }

    public static final void b(Runnable runnable) {
        f9198a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f9198a.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        f9198a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f9198a.postDelayed(runnable, j);
    }
}

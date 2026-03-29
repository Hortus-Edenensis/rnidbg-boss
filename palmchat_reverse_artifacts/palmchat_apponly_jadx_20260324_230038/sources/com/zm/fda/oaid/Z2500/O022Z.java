package com.zm.fda.oaid.Z2500;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f16719a = new Handler(Looper.getMainLooper());

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (a()) {
            runnable.run();
        } else {
            f16719a.post(runnable);
        }
    }

    public static void a(Runnable runnable, int i) {
        if (runnable == null) {
            return;
        }
        f16719a.postDelayed(runnable, i);
    }
}

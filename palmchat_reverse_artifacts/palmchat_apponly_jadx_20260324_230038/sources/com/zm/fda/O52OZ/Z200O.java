package com.zm.fda.O52OZ;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z200O {
    public static Z200O b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f16630a = new Handler(Looper.getMainLooper());

    public static Z200O a() {
        if (b == null) {
            synchronized (Z200O.class) {
                if (b == null) {
                    b = new Z200O();
                }
            }
        }
        return b;
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (ZZ00Z.c()) {
            runnable.run();
        } else {
            this.f16630a.post(runnable);
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f16630a.post(runnable);
    }

    public void a(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f16630a.postDelayed(runnable, j);
    }
}

package com.zm.fissionsdk;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zzZVz {
    public static zzZVz b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f16764a = new Handler(Looper.getMainLooper());

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f16764a.post(runnable);
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f16764a.post(runnable);
        }
    }

    public void a(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f16764a.postDelayed(runnable, j);
    }

    public static zzZVz a() {
        if (b == null) {
            synchronized (zzZVz.class) {
                if (b == null) {
                    b = new zzZVz();
                }
            }
        }
        return b;
    }
}

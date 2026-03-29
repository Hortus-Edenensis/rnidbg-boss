package com.bytedance.sdk.openadsdk.upie.u;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static final Handler u = new Handler(Looper.getMainLooper());

    public static void fx(Runnable runnable) {
        jk.fx().post(runnable);
    }

    public static void nr(Runnable runnable) {
        u.post(runnable);
    }

    public static void u(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            u.post(runnable);
        }
    }
}

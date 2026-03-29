package com.bytedance.sdk.openadsdk.gi;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public static void b(Runnable runnable) {
        u(runnable, (ScheduledExecutorService) null);
    }

    public static void fx(Runnable runnable) {
        if (dw.nr().bo()) {
            com.bytedance.sdk.component.utils.jk.fx().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void nr(com.bytedance.sdk.component.jk.a aVar) {
        com.bytedance.sdk.component.jk.x.fx(aVar);
    }

    public static boolean u() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void nr(Runnable runnable) {
        if (dw.nr().ps() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            bg.iz().post(runnable);
        }
    }

    public static void u(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            bg.iz().post(runnable);
        }
    }

    public static void u(Runnable runnable, long j) {
        bg.iz().postDelayed(runnable, j);
    }

    public static Looper nr() {
        return dw.nr().bo() ? com.bytedance.sdk.component.utils.jk.fx().getLooper() : Looper.getMainLooper();
    }

    public static void u(com.bytedance.sdk.component.jk.a aVar) {
        com.bytedance.sdk.component.jk.x.nr(aVar);
    }

    public static void u(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!u()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("") { // from class: com.bytedance.sdk.openadsdk.gi.x.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }
}

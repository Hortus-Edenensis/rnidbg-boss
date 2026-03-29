package com.bytedance.sdk.openadsdk.core.iz;

import com.bytedance.sdk.openadsdk.core.dw;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile boolean nr = false;
    private static volatile Random u;

    private static Random fx() {
        if (u != null) {
            return u;
        }
        Random randomFx = com.bytedance.sdk.component.utils.u.fx();
        u = randomFx;
        return randomFx;
    }

    public static void nr() {
        u(dw.nr().yd(), true);
    }

    public static boolean u() {
        return nr;
    }

    public static boolean u(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                nr = false;
            }
            return false;
        }
        int iNextInt = fx().nextInt(10000);
        int i = (int) (f * 10000.0f);
        if (z) {
            nr = iNextInt < i;
        }
        return iNextInt < i;
    }
}

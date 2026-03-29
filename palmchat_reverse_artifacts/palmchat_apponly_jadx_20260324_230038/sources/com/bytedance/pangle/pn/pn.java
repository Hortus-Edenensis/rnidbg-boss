package com.bytedance.pangle.pn;

import com.bytedance.pangle.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static iz u;

    public static void fx(Runnable runnable) {
        u.fx(runnable);
    }

    public static void nr(Runnable runnable) {
        u.nr(runnable);
    }

    public static void u(iz izVar) {
        u = izVar;
    }

    public static void u(Runnable runnable, boolean z) {
        if (z) {
            u(runnable);
        } else {
            nr(runnable);
        }
    }

    public static void u(Runnable runnable) {
        u.u(runnable);
    }
}

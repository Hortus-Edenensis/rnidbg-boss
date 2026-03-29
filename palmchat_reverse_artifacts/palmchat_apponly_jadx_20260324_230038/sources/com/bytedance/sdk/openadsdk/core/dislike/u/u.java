package com.bytedance.sdk.openadsdk.core.dislike.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static b fx = null;
    private static fx nr = null;
    private static volatile boolean u = false;

    public static b nr() {
        return fx;
    }

    public static void u(fx fxVar, b bVar) {
        if (u) {
            return;
        }
        u = true;
        nr = fxVar;
        fx = bVar;
    }

    public static fx u() {
        return nr;
    }
}

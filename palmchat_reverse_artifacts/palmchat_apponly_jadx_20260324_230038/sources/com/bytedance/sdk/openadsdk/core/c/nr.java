package com.bytedance.sdk.openadsdk.core.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static boolean nr(long j) {
        return u(j, u.USE_PITAYA.u());
    }

    public static boolean u(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean u(long j) {
        return u(j, u.USE_ALOG.u());
    }
}

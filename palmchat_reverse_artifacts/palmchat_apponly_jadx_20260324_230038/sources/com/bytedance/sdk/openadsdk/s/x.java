package com.bytedance.sdk.openadsdk.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static u u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(String str, String str2, Throwable th);
    }

    public static void u(u uVar) {
        u = uVar;
    }

    public static boolean u() {
        return u != null;
    }

    public static void u(String str, String str2, Throwable th) {
        if (u == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        u.u(str, str2, th);
    }
}

package com.bytedance.embedapplog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ti {
    public static boolean nr = false;
    public static boolean u;

    public static void fx(String str, Throwable th) {
        com.bytedance.sdk.component.utils.k.u("TeaLog", str, th);
    }

    public static void nr(String str) {
    }

    public static void u(String str) {
    }

    public static void nr(String str, Throwable th) {
    }

    public static void u(String str, Throwable th) {
    }

    public static void nr(Throwable th) {
        if (th != null) {
            th.getMessage();
        }
    }

    public static void u(Throwable th) {
        com.bytedance.sdk.component.utils.k.u("TeaLog", "", th);
    }

    public static void b(String str, Throwable th) {
    }
}

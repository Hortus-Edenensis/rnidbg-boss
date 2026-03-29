package com.bytedance.sdk.component.u;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class a {
    private static boolean u;

    public static void nr(String str, Throwable th) {
        if (u) {
            com.bytedance.sdk.component.utils.k.u("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.k.nr("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void u(boolean z) {
        u = z;
    }

    public static void u(String str, Throwable th) {
        if (u) {
            Log.getStackTraceString(th);
        }
    }

    public static void u(RuntimeException runtimeException) {
        if (u) {
            throw runtimeException;
        }
    }
}

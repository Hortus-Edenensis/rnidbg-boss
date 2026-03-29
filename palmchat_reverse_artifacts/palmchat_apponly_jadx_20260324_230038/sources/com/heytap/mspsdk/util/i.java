package com.heytap.mspsdk.util;

import android.annotation.SuppressLint;
import com.heytap.mspsdk.log.MspLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f6415a;

    @SuppressLint({"PrivateApi"})
    private static Class<?> a() {
        try {
            return Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            MspLog.w("SystemPropertyReflect", e.getMessage());
            return null;
        }
    }

    private static boolean b() {
        if (f6415a != null) {
            return true;
        }
        Class<?> clsA = a();
        f6415a = clsA;
        return clsA != null;
    }

    public static String a(String str, String str2) {
        if (!b()) {
            return str2;
        }
        try {
            return (String) f6415a.getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
            MspLog.w("SystemPropertyReflect", th.getMessage());
            return str2;
        }
    }
}

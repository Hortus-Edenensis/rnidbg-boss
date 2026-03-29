package com.heytap.msp.ipc.a;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f6372a;

    private static void a(int i, String str, String str2, Throwable th) {
        if (f6372a == null || TextUtils.isEmpty(str2)) {
            return;
        }
        String strD = d(str, str2);
        if (th != null) {
            strD = strD + '\n' + Log.getStackTraceString(th);
        }
        int length = strD.length();
        int i2 = length / 1100;
        if (i2 <= 0) {
            f6372a.a(i, "ProcessBridge", strD);
            return;
        }
        int i3 = 1100;
        f6372a.a(i, "ProcessBridge", strD.substring(0, 1100));
        int i4 = 1;
        while (i4 < i2) {
            int i5 = i3 + 1100;
            f6372a.a(i, "ProcessBridge", strD.substring(i3, i5));
            i4++;
            i3 = i5;
        }
        if (i3 != length) {
            f6372a.a(i, "ProcessBridge", strD.substring(i3, length));
        }
    }

    public static void b(String str, String str2) {
        a(3, str, str2, null);
    }

    public static void c(String str, String str2) {
        a(6, str, str2, null);
    }

    private static String d(String str, String str2) {
        return "[" + str + "]:" + str2;
    }

    public static void a(String str, String str2) {
        a(2, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(6, str, str2, th);
    }
}

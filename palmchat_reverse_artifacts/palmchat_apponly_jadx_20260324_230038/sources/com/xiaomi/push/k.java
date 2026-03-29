package com.xiaomi.push;

import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f847a;

    public static synchronized String a() {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - f11654a) > 86400000) {
            f11654a = jCurrentTimeMillis;
            f847a = Build.MODEL;
        }
        str = f847a;
        if (str == null) {
            str = "";
        }
        return str;
    }
}

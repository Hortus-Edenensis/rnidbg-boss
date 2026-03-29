package com.zm.fda.O52OZ;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0225 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16628a = "WfSdk";
    public static final boolean b = a("WfSdk");

    public static boolean a(String str) {
        try {
            return Log.isLoggable(str, 2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        return b;
    }
}

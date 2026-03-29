package com.zm.fda.oaid.Z2500;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16720a = "WfSdk";
    public static final boolean b = a("WfSdk");
    public static Boolean c = Boolean.FALSE;
    public static char d = 'v';

    public static void a(String str, Object obj) {
        a(str, obj.toString(), 'd');
    }

    public static void b(String str, Object obj) {
        a(str, obj.toString(), 'e');
    }

    public static void c(String str, Object obj) {
        a(str, obj.toString(), 'i');
    }

    public static void a(String str, String str2) {
        a(str, str2, 'd');
    }

    public static void b(String str, String str2) {
        a(str, str2, 'e');
    }

    public static void c(String str, String str2) {
        a(str, str2, 'i');
    }

    public static void a(String str, String str2, char c2) {
        char c3;
        char c4;
        char c5;
        char c6;
        if (a()) {
            if ('e' == c2 && ('e' == (c6 = d) || 'v' == c6)) {
                Log.e(str, str2);
                return;
            }
            if ('w' == c2 && ('w' == (c5 = d) || 'v' == c5)) {
                Log.w(str, str2);
                return;
            }
            if ('d' == c2 && ('d' == (c4 = d) || 'v' == c4)) {
                Log.d(str, str2);
            } else if ('i' == c2 && ('d' == (c3 = d) || 'v' == c3)) {
                Log.i(str, str2);
            } else {
                Log.v(str, str2);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (a()) {
            StringBuilder sb = new StringBuilder();
            if (objArr != null && objArr.length > 0) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        sb.append(obj);
                        sb.append(" ");
                    }
                }
            }
            Log.d(str, sb.toString());
        }
    }

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

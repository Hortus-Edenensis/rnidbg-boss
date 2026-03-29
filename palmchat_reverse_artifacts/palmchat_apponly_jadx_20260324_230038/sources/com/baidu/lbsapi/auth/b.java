package com.baidu.lbsapi.auth;

import android.util.Log;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3368a = false;
    private static String b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, str);
    }

    public static void c(String str) {
        if (!f3368a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(b, a() + x.aQ + str);
    }

    public static void a(String str) {
        if (!f3368a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(b, a() + x.aQ + str);
    }
}

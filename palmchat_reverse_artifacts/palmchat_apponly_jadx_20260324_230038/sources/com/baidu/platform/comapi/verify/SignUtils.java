package com.baidu.platform.comapi.verify;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SignUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4240a = 621133959;

    private static int a(Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 28 ? context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.getSigningCertificateHistory() : context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures)[0].hashCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean b(Context context) {
        return a(context) == f4240a;
    }

    public static boolean verifySign(Context context) {
        return b(context);
    }
}

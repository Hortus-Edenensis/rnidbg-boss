package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6609a = "ApkUtil";
    private static final Map<String, List<String>> b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        map.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        map.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static String a(Context context, String str) {
        byte[] bArrC = c(context, str);
        if (bArrC == null || bArrC.length == 0) {
            return null;
        }
        return ae.a(ai.a(bArrC));
    }

    public static String b(Context context) {
        return d(context, "com.huawei.hwid") ? "com.huawei.hwid" : d(context, "com.huawei.hms") ? "com.huawei.hms" : d(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    private static byte[] c(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageArchiveInfo(str, 64));
            }
        } catch (Throwable th) {
            af.d(f6609a, "getPackageSignatureBytesByPath RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }

    private static boolean d(Context context, String str) {
        return e(context, str) != null;
    }

    private static PackageInfo e(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (Throwable unused) {
            af.c(f6609a, "getPackageInfo Exception");
            return null;
        }
    }

    private static byte[] f(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageInfo(str, 64));
            }
        } catch (Throwable th) {
            af.d(f6609a, "getPackageSignatureBytes RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }

    public static boolean a(Context context) {
        String strB = b(context);
        return a(b.get(strB), b(context, strB));
    }

    public static String b(Context context, String str) {
        byte[] bArrF = f(context, str);
        if (bArrF == null || bArrF.length == 0) {
            return null;
        }
        return ae.a(ai.a(bArrF));
    }

    public static boolean a(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static byte[] a(PackageInfo packageInfo) {
        ByteArrayInputStream byteArrayInputStream = null;
        if (packageInfo != null) {
            try {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr.length > 0) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                    try {
                        byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getEncoded();
                        aj.a(byteArrayInputStream2);
                        return encoded;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            af.d(f6609a, "getPackageSignatureBytes Exception:" + th.getClass().getSimpleName());
                            aj.a(byteArrayInputStream);
                            af.b(f6609a, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th2) {
                            aj.a(byteArrayInputStream);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        aj.a(byteArrayInputStream);
        af.b(f6609a, "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }
}

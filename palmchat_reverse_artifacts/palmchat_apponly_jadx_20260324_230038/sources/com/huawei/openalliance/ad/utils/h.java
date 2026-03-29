package com.huawei.openalliance.ad.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.kw;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h {
    private static final String Code = "ApkUtil";
    private static final Map<String, List<String>> V;

    static {
        HashMap map = new HashMap();
        V = map;
        map.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        map.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        map.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static boolean B(Context context, String str) {
        return Code(V.get(str), Z(context, str));
    }

    public static ApplicationInfo C(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getApplicationInfo(str, 128);
            }
            fh.V(Code, "pm is null");
            return null;
        } catch (Throwable th) {
            fh.I(Code, "getApplicationInfo " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static String Code(Context context, Intent intent) {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    public static int I(Context context, String str) {
        try {
            PackageInfo packageInfoV = V(context, str);
            if (packageInfoV == null) {
                return 0;
            }
            return packageInfoV.versionCode;
        } catch (AndroidRuntimeException | Exception unused) {
            fh.I(Code, "getAppVersionCode fail");
            return 0;
        }
    }

    private static byte[] S(Context context, String str) throws Throwable {
        String str2;
        PackageInfo packageInfo;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0) {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        try {
                            byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getEncoded();
                            bb.Code((Closeable) byteArrayInputStream2);
                            return encoded;
                        } catch (RuntimeException e) {
                            e = e;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes RuntimeException:" + e.getClass().getSimpleName();
                            fh.Z(Code, str2);
                            bb.Code((Closeable) byteArrayInputStream);
                            fh.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes Exception:" + e.getClass().getSimpleName();
                            fh.Z(Code, str2);
                            bb.Code((Closeable) byteArrayInputStream);
                            fh.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            bb.Code((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (RuntimeException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
        bb.Code((Closeable) byteArrayInputStream);
        fh.V(Code, "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public static Intent V(Context context, String str, String str2, kw kwVar) {
        String str3;
        try {
        } catch (URISyntaxException unused) {
            av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.Z);
            str3 = "parseAndCheckIntent, parse uri fail";
            fh.I(Code, str3);
        } catch (Exception e) {
            av.Code(context, kwVar, "unknown exception:" + e.getClass().getSimpleName());
            str3 = "handle intent url fail";
            fh.I(Code, str3);
        }
        if (TextUtils.isEmpty(str)) {
            av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.S);
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            boolean z = true;
            Intent uri = Intent.parseUri(Uri.decode(str), 1);
            if (!Code(uri, str2)) {
                av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.B);
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                uri.setPackage(str2);
            }
            if (uri.getData() != null) {
                uri = uri.setDataAndTypeAndNormalize(uri.getData(), uri.getType());
            }
            if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30 || as.Code(context, "android.permission.QUERY_ALL_PACKAGES")) {
                z = false;
            } else {
                fh.Code(Code, "has no QUERY_ALL_PACKAGES permission");
                av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.C);
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(uri, 0);
            if (ag.Code(listQueryIntentActivities)) {
                if (z) {
                    return null;
                }
                fh.I(Code, "can not find the activity");
                av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.Code);
                return null;
            }
            if (!Code(listQueryIntentActivities)) {
                fh.I(Code, "parseAndCheckIntent, activity not exists or not exported.");
                av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.I);
                return null;
            }
            if (eh.Code(context).S(uri.getPackage())) {
                Code(uri);
            }
            if (!listQueryIntentActivities.isEmpty() || !Code()) {
                return uri;
            }
        } else {
            av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.F);
        }
        return null;
    }

    public static String Z(Context context, String str) {
        byte[] bArrS = S(context, str);
        if (bArrS == null || bArrS.length == 0) {
            return null;
        }
        return y.Code(ay.Code(bArrS));
    }

    public static void Code(Context context, Intent intent, kw kwVar) {
        if (kwVar != null && bc.Code(kwVar.Z())) {
            kwVar.I(Code(context, intent));
        }
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(com.huawei.openalliance.ad.constant.x.cS);
            context.startActivity(intent);
            kv.Code(context, kwVar);
        } catch (Throwable th) {
            fh.I(Code, "start activity error");
            db.Code(context, kwVar, th.getMessage());
        }
    }

    public static String I(Context context) {
        return Code(context, "com.huawei.hwid") ? "com.huawei.hwid" : Code(context, "com.huawei.hms") ? "com.huawei.hms" : Code(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static PackageInfo V(Context context, String str) {
        String str2;
        if (fh.Code()) {
            fh.Code(Code, "getPackageInfo, packageName:%s", str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            fh.I(Code, str2);
            return null;
        } catch (Throwable unused2) {
            str2 = "getPackageInfo Exception";
            fh.I(Code, str2);
            return null;
        }
    }

    public static void Code(Intent intent) {
        intent.addFlags(536870912);
        intent.addFlags(32768);
        fh.V(Code, "addFlagsToIntent: Success");
    }

    public static String V(Context context) {
        String strI = I(context);
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        if (Code(V.get(strI), Z(context, strI))) {
            return strI;
        }
        return null;
    }

    public static boolean Code() {
        return Build.VERSION.SDK_INT <= 29 || !V();
    }

    public static boolean V() {
        try {
            return ((Boolean) Class.forName("com.huawei.openalliance.ad.ppskit.utils.AdsCoreScopeUtil").getMethod("isScopePrime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            fh.V(Code, "AdsCoreScopeUtil wrapper not found");
            fh.Code(Code, "is prime sdk: %s.", Boolean.FALSE);
            return false;
        }
    }

    public static boolean Code(Context context) {
        return !TextUtils.isEmpty(V(context));
    }

    public static boolean Code(Context context, String str) {
        return V(context, str) != null;
    }

    public static boolean Code(Context context, String str, kw kwVar) {
        try {
            fh.V(Code, "open app main page");
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.L);
                return false;
            }
            launchIntentForPackage.addFlags(268435456);
            launchIntentForPackage.setPackage(str);
            if (kwVar != null) {
                kwVar.Z(null);
            }
            Code(context, launchIntentForPackage, kwVar);
            return true;
        } catch (Throwable unused) {
            fh.Z(Code, "openAppMainPage err");
            return false;
        }
    }

    public static boolean Code(Context context, String str, String str2, kw kwVar) {
        String str3;
        fh.V(Code, "openApp intent");
        try {
        } catch (ActivityNotFoundException unused) {
            av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.V);
            str3 = "activity not exist";
            fh.I(Code, str3);
        } catch (Exception e) {
            av.Code(context, kwVar, "unknown exception:" + e.getClass().getSimpleName());
            str3 = "handle intent url fail";
            fh.I(Code, str3);
        }
        if (context.getPackageManager() == null) {
            av.Code(context, kwVar, com.huawei.openalliance.ad.constant.as.F);
            return false;
        }
        Intent intentV = V(context, str2, str, kwVar);
        if (intentV == null) {
            return false;
        }
        intentV.addFlags(268435456);
        if (kwVar == null) {
            return true;
        }
        kwVar.Code(intentV);
        Code(context, intentV, kwVar);
        return true;
    }

    private static boolean Code(Intent intent, String str) {
        ComponentName component;
        if (intent == null || TextUtils.isEmpty(str) || (component = intent.getComponent()) == null) {
            return true;
        }
        String packageName = component.getPackageName();
        return TextUtils.isEmpty(packageName) || str.equalsIgnoreCase(packageName);
    }

    public static boolean Code(String str) {
        return "com.huawei.hwid".equals(str) || "com.huawei.hms".equals(str) || "com.huawei.hwid.tv".equals(str);
    }

    public static boolean Code(List<ResolveInfo> list) {
        if (ag.Code(list)) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && activityInfo.exported) {
                return true;
            }
        }
        return false;
    }

    private static boolean Code(List<String> list, String str) {
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
}

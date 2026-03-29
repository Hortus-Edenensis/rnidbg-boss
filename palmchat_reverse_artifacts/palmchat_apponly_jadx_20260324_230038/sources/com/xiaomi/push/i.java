package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11643a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Set<String> f839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f840a = false;
    private static String b = null;
    private static String c = "";
    private static String d;
    private static String e;
    private static final String f = String.valueOf((char) 2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f841a = {HttpClient.ENDFLAG, "a-", "u-", "v-", "o-", "g-", "d-"};

    static {
        HashSet hashSet = new HashSet();
        f839a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f840a = true;
    }

    private static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String strTrim = str.trim();
        return strTrim.length() == 0 || strTrim.equalsIgnoreCase(com.igexin.push.core.b.m) || strTrim.equalsIgnoreCase("unknown");
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static synchronized String g(Context context) {
        String str = e;
        if (str != null) {
            return str;
        }
        String strB = bb.b(b(context) + a(context));
        e = strB;
        return strB;
    }

    public static synchronized String h(Context context) {
        return bb.b(b(context) + ((String) null));
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    private static String j(Context context) {
        return "";
    }

    private static String k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strL = l(context);
        a(context, strL);
        return strL;
    }

    private static String l(Context context) {
        return ay.a(Build.BRAND + "_" + k.a() + "_" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + "_" + Build.VERSION.INCREMENTAL + "_" + a() + "_" + context.getPackageName() + "_" + System.currentTimeMillis() + "_" + bb.a(16));
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    public static String c() {
        return b() + "KB";
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m639a(int i) {
        if (i > 0) {
            String[] strArr = f841a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f841a[0];
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private static boolean m645c(Context context) {
        Bundle bundle;
        ApplicationInfo applicationInfo;
        Bundle bundle2;
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (bundle2 = applicationInfo.metaData) != null && bundle2.containsKey("supportGetAndroidID")) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                com.xiaomi.channel.commonutils.logger.b.m79b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && (bundle = serviceInfo.metaData) != null && bundle.containsKey("supportGetAndroidID")) {
                com.xiaomi.channel.commonutils.logger.b.m79b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        com.xiaomi.channel.commonutils.logger.b.m79b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    public static String b(Context context) {
        String str = b;
        if (str != null || !f840a) {
            return str;
        }
        boolean zM645c = m645c(context);
        f840a = zM645c;
        if (!zM645c) {
            return null;
        }
        try {
            b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("failure to get androidId: " + th);
        }
        return b;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f841a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static synchronized String a(Context context, boolean z) {
        if (d == null) {
            String strB = b(context);
            String strC = "";
            if (!j.m656d()) {
                strC = z ? c(context) : j(context);
            }
            String strA = a(context);
            int i = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(strC) && b(strA)) {
                String strB2 = an.a(context).b();
                if (!TextUtils.isEmpty(strB2)) {
                    strB = strB2 + strB;
                    i = 2;
                } else {
                    String strMo160a = an.a(context).mo160a();
                    if (!TextUtils.isEmpty(strMo160a) && !strMo160a.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i = 4;
                        strB = strMo160a;
                    } else if (TextUtils.isEmpty(strB)) {
                        strB = k(context);
                        i = 6;
                    } else {
                        i = 5;
                    }
                }
            } else {
                strB = strC + strB + strA;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                d = strB;
            } else {
                d = m639a(i) + bb.b(strB);
            }
        }
        return d;
    }

    public static int b() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArrSplit;
        int i = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (IOException unused) {
                }
                try {
                    String line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line) && (strArrSplit = line.split("\\s+")) != null && strArrSplit.length >= 2 && TextUtils.isDigitsOnly(strArrSplit[1])) {
                        i = Integer.parseInt(strArrSplit[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m643b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m644b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    @TargetApi(17)
    public static int a() {
        Object objA = aw.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (objA == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(objA)).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m638a() {
        return a(b()) + "GB";
    }

    private static float a(int i) {
        float f2 = ((((((i + AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m641a(Context context) {
        Intent intentA = m.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (intentA == null) {
            return false;
        }
        int intExtra = intentA.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m640a() {
        return a() <= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m642a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) aw.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("default_id exist,do not change it.");
        }
    }
}

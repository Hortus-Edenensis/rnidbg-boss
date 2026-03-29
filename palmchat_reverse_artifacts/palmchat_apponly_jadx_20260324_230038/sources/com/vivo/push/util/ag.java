package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.AttributionReporter;
import com.qq.gdt.action.ActionUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ag {
    private static String[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f11296a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] d = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] e = new String[0];
    private static Map<String, Bundle> f = new ConcurrentHashMap();

    public static long a(Context context) {
        String strA = z.a(context);
        if (!TextUtils.isEmpty(strA)) {
            return a(context, strA);
        }
        t.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object objA = a(context, str, "verification_status");
        return objA != null ? objA.toString() : "";
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:58:0x00b6 */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa A[Catch: Exception -> 0x00b4, TRY_ENTER, TryCatch #4 {Exception -> 0x00b4, blocks: (B:39:0x0092, B:41:0x0097, B:43:0x009b, B:51:0x00aa, B:53:0x00af), top: B:73:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey c(Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery;
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        try {
            try {
                try {
                    i = Build.VERSION.SDK_INT;
                    if (i >= 24) {
                        ContentResolver contentResolver = context.getContentResolver();
                        Uri uri = com.vivo.push.x.f11313a;
                        contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            try {
                                t.a("Utility", "client is null");
                                cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                            } catch (Exception e2) {
                                e = e2;
                                cursorQuery = null;
                                e.printStackTrace();
                                if (cursorQuery != null) {
                                }
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception unused) {
                                        throw th;
                                    }
                                }
                                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                }
                                throw th;
                            }
                        } else {
                            cursorQuery = null;
                        }
                    } else {
                        contentProviderClientAcquireUnstableContentProviderClient = null;
                        cursorQuery = null;
                    }
                    if (cursorQuery == null) {
                        try {
                            cursorQuery = context.getContentResolver().query(com.vivo.push.x.f11313a, null, null, null, null);
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                }
            } catch (Exception e4) {
                e = e4;
                contentProviderClientAcquireUnstableContentProviderClient = null;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            }
        } catch (Exception unused2) {
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused3) {
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            return null;
        }
        while (cursorQuery.moveToNext()) {
            if ("pushkey".equals(cursorQuery.getString(cursorQuery.getColumnIndex("name")))) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                t.d("Utility", "result key : ".concat(String.valueOf(string)));
                PublicKey publicKeyA = aa.a(string);
                try {
                    cursorQuery.close();
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                } catch (Exception unused4) {
                }
                return publicKeyA;
            }
        }
        cursorQuery.close();
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
        return null;
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : c) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            for (String str2 : e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : d) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(Context context, String str) {
        String string;
        int iIntValue;
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            t.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
        Object objA = a(context, str, "sdk_version_vivo");
        if (objA instanceof String) {
            string = (String) objA;
        } else {
            if (objA instanceof Integer) {
                iIntValue = ((Integer) objA).intValue();
                str2 = "";
                if (iIntValue <= 0) {
                    return iIntValue;
                }
                try {
                    return Integer.parseInt(str2);
                } catch (Exception e2) {
                    t.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e2)));
                    return 0;
                }
            }
            if (objA == null) {
                return 0;
            }
            string = objA.toString();
        }
        str2 = string;
        iIntValue = 0;
        if (iIntValue <= 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
    
        r8 = r8 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String string;
        int i;
        t.d("Utility", "check PushService AndroidManifest declearation !");
        String strA = z.a(context);
        boolean zD = z.d(context, context.getPackageName());
        boolean zC = z.c(context, context.getPackageName());
        if (!zC && !zD) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        }
        if (zC) {
            c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
        } else {
            c = new String[]{"com.vivo.push.sdk.service.CommandService"};
        }
        d = new String[0];
        f11296a = new String[0];
        if (zD) {
            b = new String[]{com.kuaishou.weapon.p0.g.f7481a, "android.permission.WRITE_SETTINGS"};
        } else {
            b = new String[]{com.kuaishou.weapon.p0.g.f7481a};
        }
        if (zD) {
            long jA = a(context, context.getPackageName());
            long j = context.getPackageName().equals(strA) ? 1354L : 354L;
            if (jA == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (jA != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
            }
        }
        String[] strArr = b;
        if (strArr != null && strArr.length > 0) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (strArr2 != null) {
                        int length = strArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str = strArr[i2];
                            int length2 = strArr2.length;
                            while (i < length2) {
                                i = str.equals(strArr2[i]) ? 0 : i + 1;
                            }
                            throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr2));
                        }
                    }
                    throw new VivoPushException("Permissions is null!");
                }
                throw new VivoPushException("localPackageManager is null");
            } catch (Exception e2) {
                throw new VivoPushException(e2.getMessage());
            }
        }
        t.c("Utility", "checkPermissions sPermissions is empty");
        f(context, strA);
        d(context, strA);
        e(context, strA);
        try {
            if (a(context, context.getPackageName(), "local_iv") != null) {
                String packageName = context.getPackageName();
                Object objA = a(context, packageName, "com.vivo.push.api_key");
                String string2 = "";
                if (objA != null) {
                    string = objA.toString();
                } else {
                    Object objA2 = a(context, packageName, "api_key");
                    string = objA2 != null ? objA2.toString() : "";
                }
                if (!TextUtils.isEmpty(string)) {
                    String packageName2 = context.getPackageName();
                    Object objA3 = a(context, packageName2, "com.vivo.push.app_id");
                    if (objA3 != null) {
                        string2 = objA3.toString();
                    } else {
                        Object objA4 = a(context, packageName2, "app_id");
                        if (objA4 != null) {
                            string2 = objA4.toString();
                        }
                    }
                    if (TextUtils.isEmpty(string2)) {
                        throw new VivoPushException("com.vivo.push.app_id is null");
                    }
                    if (zD && a(context, context.getPackageName()) == -1) {
                        throw new VivoPushException("sdkversion is null");
                    }
                    return;
                }
                throw new VivoPushException("com.vivo.push.api_key is null");
            }
            throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
        } catch (Exception e3) {
            throw new VivoPushException("getMetaValue error " + e3.getMessage());
        }
    }

    public static long a(Context context, String str) {
        Object objA = a(context, str, "com.vivo.push.sdk_version");
        if (objA == null) {
            objA = a(context, str, "sdk_version");
        }
        if (objA != null) {
            try {
                return Long.parseLong(objA.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                t.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        t.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        ?? Query = 0;
        Query = 0;
        try {
            try {
                try {
                } catch (Exception e2) {
                    t.a("Utility", "close", e2);
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        Query.close();
                    } catch (Exception e3) {
                        t.a("Utility", "close", e3);
                        throw th;
                    }
                }
                if (0 == 0 && Build.VERSION.SDK_INT >= 24) {
                    Query.release();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 == 0) {
                throw th;
            }
            throw th;
        }
        if (context == null) {
            t.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = com.vivo.push.x.b;
            contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    t.a("Utility", "client is null");
                    Query = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"354", packageName, String.valueOf(i)}, null);
                } catch (Exception e5) {
                    e = e5;
                    t.a("Utility", "isSupport", e);
                    if (0 != 0) {
                        Query.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                }
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (Query == 0) {
            Query = context.getContentResolver().query(com.vivo.push.x.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"354", packageName, String.valueOf(i)}, null);
        }
        if (Query == 0) {
            t.a("Utility", "cursor is null");
            if (Query != 0) {
                try {
                    Query.close();
                } catch (Exception e6) {
                    t.a("Utility", "close", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && i2 >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            return false;
        }
        if (Query.moveToFirst() && (Query.getInt(Query.getColumnIndex(AttributionReporter.SYSTEM_PERMISSION)) & 1) != 0) {
            try {
                Query.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != null && i2 >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } catch (Exception e7) {
                t.a("Utility", "close", e7);
            }
            return true;
        }
        Query.close();
        if (contentProviderClientAcquireUnstableContentProviderClient != null && i2 >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
        return false;
    }

    public static Object a(Context context, String str, String str2) {
        Bundle bundle;
        Object obj = null;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f;
            Object obj2 = (map == null || map.size() <= 0 || (bundle = f.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                Bundle bundle2 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj3 = bundle2 != null ? bundle2.get(str2) : obj2;
                try {
                    if (f.size() > 300) {
                        return obj3;
                    }
                    f.put(str, bundle2);
                    return obj3;
                } catch (Exception e2) {
                    obj = obj3;
                    e = e2;
                    t.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return obj;
                }
            } catch (Exception e3) {
                e = e3;
                obj = obj2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int iA = (int) a(context, str);
            return iA <= 0 ? g(context, str) : iA;
        }
        t.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f11296a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2, long j) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery = 0;
        cursorQuery = 0;
        try {
            try {
                try {
                } catch (Exception e2) {
                    t.a("Utility", "close", e2);
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e3) {
                        t.a("Utility", "close", e3);
                        throw th;
                    }
                }
                if (0 == 0 && Build.VERSION.SDK_INT >= 24) {
                    cursorQuery.release();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 == 0) {
                throw th;
            }
            throw th;
        }
        if (context == null) {
            t.a("Utility", "context is null");
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = com.vivo.push.x.c;
            contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    t.a("Utility", "client is null");
                    cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
                } catch (Exception e5) {
                    e = e5;
                    t.a("Utility", "isOverdue", e);
                    if (0 != 0) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                }
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (cursorQuery == 0) {
            cursorQuery = context.getContentResolver().query(com.vivo.push.x.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
        }
        if (cursorQuery == 0) {
            t.a("Utility", "cursor is null");
            if (cursorQuery != 0) {
                try {
                    cursorQuery.close();
                } catch (Exception e6) {
                    t.a("Utility", "close", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            return false;
        }
        if (cursorQuery.moveToFirst()) {
            boolean z = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("clientState")));
            try {
                cursorQuery.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } catch (Exception e7) {
                t.a("Utility", "close", e7);
            }
            return z;
        }
        cursorQuery.close();
        if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
        return false;
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean a(Context context, String str, boolean z) {
        Cursor cursorA;
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            t.a("Utility", "close", e2);
        }
        try {
            try {
                Uri uri = com.vivo.push.x.e;
                String[] strArr = new String[2];
                strArr[0] = str;
                strArr[1] = z ? "1" : "0";
                cursorA = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        t.a("Utility", "close", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            t.a("Utility", "syncAgreePrivacyStatement", e4);
            if (0 != 0) {
                cursor.close();
            }
            return false;
        }
        if (cursorA == null) {
            t.a("Utility", "cursor is null");
            if (cursorA != null) {
                try {
                    cursorA.close();
                } catch (Exception e5) {
                    t.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (cursorA.moveToFirst()) {
            boolean z2 = Boolean.parseBoolean(cursorA.getString(cursorA.getColumnIndex("agreePrivacyStatement")));
            try {
                cursorA.close();
            } catch (Exception e6) {
                t.a("Utility", "close", e6);
            }
            return z2;
        }
        cursorA.close();
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:47:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Cursor a(Uri uri, String str, String[] strArr, Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        ContentProviderClient contentProviderClient;
        Cursor cursorQuery;
        ContentProviderClient contentProviderClient2 = null;
        try {
            try {
                if (context == null) {
                    t.a("Utility", "context is null");
                    return null;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            t.a("Utility", "client is null");
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, str, strArr, null);
                        } catch (Exception e2) {
                            e = e2;
                            t.a("Utility", "queryContentResolver", e);
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                try {
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClientAcquireUnstableContentProviderClient.release();
                                    }
                                } catch (Exception e3) {
                                    t.a("Utility", "close", e3);
                                }
                            }
                            return null;
                        }
                    } else {
                        cursorQuery = null;
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    cursorQuery = context.getContentResolver().query(uri, null, str, strArr, null);
                }
                if (cursorQuery != null) {
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                        try {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                        } catch (Exception e4) {
                            t.a("Utility", "close", e4);
                        }
                    }
                    return cursorQuery;
                }
                t.a("Utility", "cursor is null");
                if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    } catch (Exception e5) {
                        t.a("Utility", "close", e5);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                contentProviderClient2 = contentProviderClient;
                Throwable th2 = th;
                if (contentProviderClient2 == null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient2.release();
                            throw th2;
                        }
                        throw th2;
                    } catch (Exception e6) {
                        t.a("Utility", "close", e6);
                        throw th2;
                    }
                }
                throw th2;
            }
        } catch (Exception e7) {
            e = e7;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            Throwable th22 = th;
            if (contentProviderClient2 == null) {
            }
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }
}

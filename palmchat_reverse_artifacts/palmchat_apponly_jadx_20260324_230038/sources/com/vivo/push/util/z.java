package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f11311a;
    private static String b;

    public static com.vivo.push.model.a a(Context context, n nVar) {
        com.vivo.push.model.a aVarE;
        com.vivo.push.model.a aVarE2;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.a aVarC = c(applicationContext);
        if (aVarC != null) {
            t.d("PushPackageUtils", "get system push info :".concat(String.valueOf(aVarC)));
            return aVarC;
        }
        List<String> listA = nVar.a(applicationContext);
        com.vivo.push.model.a aVarE3 = e(applicationContext, applicationContext.getPackageName());
        if (listA == null || listA.size() <= 0) {
            if (aVarE3 != null && aVarE3.d()) {
                aVarC = aVarE3;
            }
            t.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            aVarE3 = aVarC;
        } else {
            com.vivo.push.model.a aVar = null;
            String strA = ae.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(strA) || !a(applicationContext, strA, "com.vivo.pushservice.action.METHOD") || (aVarE = e(applicationContext, strA)) == null || !aVarE.d()) {
                aVarE = null;
            }
            if (aVarE3 == null || !aVarE3.d()) {
                aVarE3 = null;
            }
            if (aVarE == null) {
                aVarE = null;
            }
            if (aVarE3 == null || (aVarE != null && (!aVarE3.c() ? !(aVarE.c() || aVarE3.b() > aVarE.b()) : !(aVarE.c() && aVarE3.b() > aVarE.b())))) {
                aVarE3 = aVarE;
            }
            HashMap map = new HashMap();
            if (aVarE3 == null) {
                aVarE3 = null;
            } else if (aVarE3.c()) {
                aVar = aVarE3;
                aVarE3 = null;
            }
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                String str = listA.get(i);
                if (!TextUtils.isEmpty(str) && (aVarE2 = e(applicationContext, str)) != null) {
                    map.put(str, aVarE2);
                    if (aVarE2.d()) {
                        if (aVarE2.c()) {
                            if (aVar == null || aVarE2.b() > aVar.b()) {
                                aVar = aVarE2;
                            }
                        } else if (aVarE3 == null || aVarE2.b() > aVarE3.b()) {
                            aVarE3 = aVarE2;
                        }
                    }
                }
            }
            if (aVarE3 == null) {
                t.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                aVarE3 = aVar;
            }
        }
        if (aVarE3 == null) {
            t.b(applicationContext, "查找最优包为空!");
            t.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (aVarE3.c()) {
            t.a(applicationContext, "查找最优包为:" + aVarE3.a() + "(" + aVarE3.b() + ", Black)");
            t.d("PushPackageUtils", "finSuitablePushPackage" + aVarE3.a() + "(" + aVarE3.b() + ", Black)");
        } else {
            t.a(applicationContext, "查找最优包为:" + aVarE3.a() + "(" + aVarE3.b() + ")");
            t.d("PushPackageUtils", "finSuitablePushPackage" + aVarE3.a() + "(" + aVarE3.b() + ")");
        }
        return aVarE3;
    }

    public static boolean b(Context context) {
        ProviderInfo providerInfoResolveContentProvider;
        Boolean bool = f11311a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = providerInfoResolveContentProvider.packageName;
        }
        Boolean boolValueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str)));
        f11311a = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private static com.vivo.push.model.a c(Context context) {
        String strA = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.vivo.push.model.a aVar = new com.vivo.push.model.a(strA);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 128);
            if (packageInfo != null) {
                aVar.a(packageInfo.versionCode);
                aVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                aVar.a(ag.a(context, strA));
            }
            aVar.a(a(context, strA));
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            t.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    private static com.vivo.push.model.a e(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.a aVar = new com.vivo.push.model.a(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        aVar.a(packageInfo.versionCode);
                        aVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        aVar.a(ag.a(context, str));
                    }
                    aVar.a(a(context, str));
                    return aVar;
                } catch (Exception e) {
                    t.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
            }
        }
        return null;
    }

    private static String f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : bArrDigest) {
                    String upperCase = Integer.toHexString(b2 & UByte.MAX_VALUE).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                t.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0100 A[Catch: Exception -> 0x00eb, TRY_ENTER, TryCatch #3 {Exception -> 0x00eb, blocks: (B:67:0x00de, B:69:0x00e3, B:71:0x00e7, B:83:0x0100, B:85:0x0105, B:87:0x0109), top: B:105:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0105 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:67:0x00de, B:69:0x00e3, B:71:0x00e7, B:83:0x0100, B:85:0x0105, B:87:0x0109), top: B:105:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        String string;
        int i;
        Cursor cursorQuery;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Cursor cursor = null;
        try {
            try {
                i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = com.vivo.push.x.f11313a;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            try {
                                t.a("PushPackageUtils", "client is null");
                                cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                }
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            e = e;
                            string = null;
                            t.a("PushPackageUtils", "getSystemPush", e);
                            if (cursor != null) {
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            }
                            return string;
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
                        try {
                            cursorQuery = context.getContentResolver().query(com.vivo.push.x.f11313a, null, null, null, null);
                        } catch (Exception e2) {
                            e = e2;
                            string = null;
                            cursor = cursorQuery;
                            t.a("PushPackageUtils", "getSystemPush", e);
                            if (cursor != null) {
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            }
                            return string;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                t.a("PushPackageUtils", "close", e3);
                                throw th;
                            }
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                t.a("PushPackageUtils", "close", e4);
            }
        } catch (Exception e5) {
            e = e5;
            string = null;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (cursorQuery == null) {
            t.a("PushPackageUtils", "cursor is null");
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e6) {
                    t.a("PushPackageUtils", "close", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            return null;
        }
        boolean z = false;
        string = null;
        while (cursorQuery.moveToNext()) {
            try {
                if ("pushPkgName".equals(cursorQuery.getString(cursorQuery.getColumnIndex("name")))) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                } else if ("pushEnable".equals(cursorQuery.getString(cursorQuery.getColumnIndex("name")))) {
                    z = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)));
                }
            } catch (Exception e7) {
                e = e7;
                cursor = cursorQuery;
                t.a("PushPackageUtils", "getSystemPush", e);
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            }
        }
        b = string;
        if (TextUtils.isEmpty(string)) {
            try {
                cursorQuery.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } catch (Exception e8) {
                t.a("PushPackageUtils", "close", e8);
            }
            return null;
        }
        if (!z) {
            try {
                cursorQuery.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } catch (Exception e9) {
                t.a("PushPackageUtils", "close", e9);
            }
            return null;
        }
        cursorQuery.close();
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
        return string;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                int size = listQueryIntentServices.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(i);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
            t.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = null;
        }
        return listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0;
    }
}

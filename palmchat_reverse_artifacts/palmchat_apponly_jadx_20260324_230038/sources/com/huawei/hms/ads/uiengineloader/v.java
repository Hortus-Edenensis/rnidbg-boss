package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.DynamicModule;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6640a = "ads_KitLoadStrategy";
    private static final String b = "content://com.huawei.hwid.pps.apiprovider/check_uiengine";
    private static final int c = 30472100;
    private static final byte[] d = new byte[0];

    private static Bundle a(Context context, String str, int i) throws com.huawei.hms.ads.dynamicloader.j {
        boolean zIsTrustApp;
        try {
            Uri uri = Uri.parse(b);
            if (context == null || uri == null) {
                zIsTrustApp = false;
            } else {
                PackageManager packageManager = context.getPackageManager();
                ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
                if (providerInfoResolveContentProvider != null) {
                    ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
                    if (applicationInfo != null) {
                        String str2 = applicationInfo.packageName;
                        af.b("HiAdTools", "Target provider service's package name is : ".concat(String.valueOf(str2)));
                        if (str2 != null) {
                            zIsTrustApp = packageManager.checkSignatures(context.getPackageName(), str2) == 0 || (applicationInfo.flags & 1) == 1;
                            if (!zIsTrustApp) {
                                String strB = aa.b(context, str2);
                                boolean zIsEmpty = TextUtils.isEmpty(strB);
                                af.b("HiAdTools", "is sign empty: ".concat(String.valueOf(zIsEmpty)));
                                if (!zIsEmpty) {
                                    if (DynamicModule.getCommonInter() != null) {
                                        zIsTrustApp = DynamicModule.getCommonInter().isTrustApp(str2, strB);
                                    } else {
                                        af.d("LoaderHandler", "DynamicModule.commonInter is null");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    af.d("HiAdTools", "Invalid param");
                }
                zIsTrustApp = false;
            }
            if (!zIsTrustApp) {
                throw new com.huawei.hms.ads.dynamicloader.j("apiProvider uri is invalid");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.huawei.openalliance.ad.constant.w.aB, i);
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(b), null, str, new String[]{jSONObject.toString()}, "");
            if (cursorQuery == null) {
                throw new com.huawei.hms.ads.dynamicloader.j("query ret is null");
            }
            af.b(f6640a, "query success.");
            return cursorQuery.getExtras();
        } catch (Exception e) {
            af.c(f6640a, "Failed to call checkNewModule: " + e.getMessage());
            throw new com.huawei.hms.ads.dynamicloader.j("call PPSKit checkNewModule error");
        }
    }

    public static /* synthetic */ void b(Context context, String str, int i, String str2) {
        int loaderEngin2KitUpdate;
        long kitloaderLastCheckTime;
        int loaderEngineInterval;
        try {
            af.b(f6640a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                loaderEngin2KitUpdate = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                loaderEngin2KitUpdate = 60000;
            }
            af.a(f6640a, "interval: ".concat(String.valueOf(loaderEngin2KitUpdate)));
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f6640a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f6640a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
        synchronized (d) {
            if (DynamicModule.getSpHandler() != null) {
                kitloaderLastCheckTime = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                kitloaderLastCheckTime = 0;
            }
            af.a(f6640a, "lastCheckTime: ".concat(String.valueOf(kitloaderLastCheckTime)));
            if (kitloaderLastCheckTime <= 0 || System.currentTimeMillis() - kitloaderLastCheckTime >= loaderEngin2KitUpdate) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (DynamicModule.getSpHandler() != null) {
                    DynamicModule.getSpHandler().setKitloaderLastCheckTime(jCurrentTimeMillis);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                }
                if (DynamicModule.getSpHandler() != null) {
                    loaderEngineInterval = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    loaderEngineInterval = 10080000;
                }
                af.a(f6640a, "engineInterval: ".concat(String.valueOf(loaderEngineInterval)));
                c.a(2, Integer.valueOf(i), null);
                Bundle bundleA = a(context, str, loaderEngineInterval);
                Integer numValueOf = Integer.valueOf(bundleA.getInt("module_version"));
                if (numValueOf.intValue() == 0) {
                    af.c(f6640a, "the query module:" + str + " is not existed in PPSKit.");
                    af.c(f6640a, "start call HMSLoadStrategy");
                    t.a(context, str, i);
                    return;
                }
                if (i >= numValueOf.intValue()) {
                    af.b(f6640a, "no update,localVersion: " + i + " reomoteVersion: " + numValueOf);
                    return;
                }
                c.a(3, Integer.valueOf(i), numValueOf);
                af.b(f6640a, "Ready to cp module.");
                boolean zA = x.a(context, bundleA);
                af.b(f6640a, "cp remote version by module name:" + str + " ,result:" + zA);
                if (!zA) {
                    throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                }
                c.a(4, Integer.valueOf(i), numValueOf);
                af.a(f6640a, "bundle info: moduleName:" + str + ", moduleVersion:" + numValueOf);
                af.b(f6640a, "end queryModule: ".concat(String.valueOf(str)));
            }
        }
    }

    private static void c(Context context, String str, int i, String str2) {
        int loaderEngin2KitUpdate;
        long kitloaderLastCheckTime;
        int loaderEngineInterval;
        try {
            af.b(f6640a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                loaderEngin2KitUpdate = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                loaderEngin2KitUpdate = 60000;
            }
            af.a(f6640a, "interval: ".concat(String.valueOf(loaderEngin2KitUpdate)));
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f6640a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f6640a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
        synchronized (d) {
            if (DynamicModule.getSpHandler() != null) {
                kitloaderLastCheckTime = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                kitloaderLastCheckTime = 0;
            }
            af.a(f6640a, "lastCheckTime: ".concat(String.valueOf(kitloaderLastCheckTime)));
            if (kitloaderLastCheckTime <= 0 || System.currentTimeMillis() - kitloaderLastCheckTime >= loaderEngin2KitUpdate) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (DynamicModule.getSpHandler() != null) {
                    DynamicModule.getSpHandler().setKitloaderLastCheckTime(jCurrentTimeMillis);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                }
                if (DynamicModule.getSpHandler() != null) {
                    loaderEngineInterval = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    loaderEngineInterval = 10080000;
                }
                af.a(f6640a, "engineInterval: ".concat(String.valueOf(loaderEngineInterval)));
                c.a(2, Integer.valueOf(i), null);
                Bundle bundleA = a(context, str, loaderEngineInterval);
                Integer numValueOf = Integer.valueOf(bundleA.getInt("module_version"));
                if (numValueOf.intValue() == 0) {
                    af.c(f6640a, "the query module:" + str + " is not existed in PPSKit.");
                    af.c(f6640a, "start call HMSLoadStrategy");
                    t.a(context, str, i);
                    return;
                }
                if (i >= numValueOf.intValue()) {
                    af.b(f6640a, "no update,localVersion: " + i + " reomoteVersion: " + numValueOf);
                    return;
                }
                c.a(3, Integer.valueOf(i), numValueOf);
                af.b(f6640a, "Ready to cp module.");
                boolean zA = x.a(context, bundleA);
                af.b(f6640a, "cp remote version by module name:" + str + " ,result:" + zA);
                if (!zA) {
                    throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                }
                c.a(4, Integer.valueOf(i), numValueOf);
                af.a(f6640a, "bundle info: moduleName:" + str + ", moduleVersion:" + numValueOf);
                af.b(f6640a, "end queryModule: ".concat(String.valueOf(str)));
            }
        }
    }

    public static void a(final Context context, final String str, final int i, final String str2) {
        new Thread() { // from class: com.huawei.hms.ads.uiengineloader.v.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                boolean loaderEngineUpdate;
                if (e.a(context) < v.c) {
                    af.b(v.f6640a, "PPSKit is below need version");
                    t.a(context, str, i);
                    return;
                }
                String str3 = str2;
                if (DynamicModule.getSpHandler() != null) {
                    loaderEngineUpdate = DynamicModule.getSpHandler().getLoaderEngineUpdate(str3);
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    loaderEngineUpdate = false;
                }
                if (loaderEngineUpdate) {
                    v.b(context, str, i, str2);
                } else {
                    af.b(v.f6640a, "engineUpdate is close");
                    t.a(context, str, i);
                }
            }
        }.start();
    }
}

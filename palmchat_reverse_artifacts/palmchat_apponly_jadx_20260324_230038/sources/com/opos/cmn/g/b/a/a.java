package com.opos.cmn.g.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8020a = "com." + com.opos.cmn.an.b.a.c + ".market";

    private static Intent a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String str2 = f8020a;
            if (b(context, str2)) {
                intent.setPackage(str2);
            } else if (b(context, "com.heytap.market")) {
                intent.setPackage("com.heytap.market");
            } else {
                com.opos.cmn.an.f.a.a("MarketDLTool", "not find market app");
                intent = null;
            }
            if (intent != null) {
                if (!com.opos.cmn.an.h.d.a.a(context, intent)) {
                    return null;
                }
            }
            return intent;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MarketDLTool", "getMarketDLIntent", th);
            return null;
        }
    }

    private static boolean b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                if (applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static boolean a(Activity activity, String str, com.opos.cmn.an.d.a aVar) {
        Bundle bundleB;
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "marketUrl is empty";
        } else {
            if (activity != null) {
                com.opos.cmn.an.f.a.a("MarketDLTool", "launchDownloadPageForActivity activityExtraParams:", aVar);
                try {
                    Intent intentA = a(activity.getApplicationContext(), str);
                    if (intentA != null) {
                        if (aVar != null) {
                            Bundle bundleB2 = com.opos.cmn.an.d.a.b(aVar.a());
                            com.opos.cmn.an.f.a.a("MarketDLTool", "launchDownloadPageForActivity intentBundle:", bundleB2);
                            if (bundleB2 != null) {
                                intentA.putExtras(bundleB2);
                            }
                        }
                        if (aVar != null) {
                            bundleB = com.opos.cmn.an.d.a.b(aVar.b());
                            com.opos.cmn.an.f.a.a("MarketDLTool", "launchDownloadPageForActivity optionsBundle:", bundleB);
                        } else {
                            bundleB = null;
                        }
                        if (bundleB != null) {
                            activity.startActivityForResult(intentA, 100, bundleB);
                        } else {
                            activity.startActivityForResult(intentA, 100);
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPageForActivity", th);
                }
                return false;
            }
            str2 = "activity is null";
        }
        com.opos.cmn.an.f.a.c("MarketDLTool", str2);
        return false;
    }

    public static boolean a(Context context, String str, com.opos.cmn.an.d.a aVar) {
        boolean zA = false;
        if (context == null) {
            com.opos.cmn.an.f.a.c("MarketDLTool", "context is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.c("MarketDLTool", "marketUrl is empty");
            return false;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (context instanceof Activity) {
                zA = a((Activity) context, str, aVar);
            } else if (a(applicationContext, str) != null) {
                com.opos.cmn.an.transactivity.api.a.a(context, new com.opos.cmn.g.b.b.a(str, aVar));
                zA = true;
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPage", th);
        }
        com.opos.cmn.an.f.a.a("MarketDLTool", "market url:" + str + " result:" + zA);
        return zA;
    }
}

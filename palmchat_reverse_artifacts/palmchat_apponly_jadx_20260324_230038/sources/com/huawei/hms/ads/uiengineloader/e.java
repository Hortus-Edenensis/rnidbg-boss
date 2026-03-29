package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.DynamicModule;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6626a = "HiAdTools";

    public static int a(Context context) {
        StringBuilder sb;
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(aa.b(context), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("ppskit_ver_code")) == null) {
                return 0;
            }
            String string = obj.toString();
            af.a(f6626a, "ppsKitVerCode: ".concat(String.valueOf(string)));
            return f.a(string);
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder("getPpsKitVerCode runtime ex: ");
            sb.append(e.getClass().getSimpleName());
            af.b(f6626a, sb.toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("getPpsKitVerCode ex: ");
            sb.append(e.getClass().getSimpleName());
            af.b(f6626a, sb.toString());
            return 0;
        }
    }

    private static boolean a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            af.d(f6626a, "Invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        af.b(f6626a, "Target provider service's package name is : ".concat(String.valueOf(str)));
        if (str == null) {
            return false;
        }
        boolean z = true;
        if (packageManager.checkSignatures(context.getPackageName(), str) != 0 && (applicationInfo.flags & 1) != 1) {
            z = false;
        }
        if (!z) {
            String strB = aa.b(context, str);
            boolean zIsEmpty = TextUtils.isEmpty(strB);
            af.b(f6626a, "is sign empty: ".concat(String.valueOf(zIsEmpty)));
            if (!zIsEmpty) {
                if (DynamicModule.getCommonInter() != null) {
                    return DynamicModule.getCommonInter().isTrustApp(str, strB);
                }
                af.d("LoaderHandler", "DynamicModule.commonInter is null");
                return false;
            }
        }
        return z;
    }
}

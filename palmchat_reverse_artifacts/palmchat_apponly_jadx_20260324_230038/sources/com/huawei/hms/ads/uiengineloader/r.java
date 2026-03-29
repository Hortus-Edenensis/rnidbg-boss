package com.huawei.hms.ads.uiengineloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6636a = "r";
    private static final String b = "presplits";
    private static final String c = ",";

    @SuppressLint({"NewApi"})
    private static HashMap<String, String> a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        String[] strArr;
        String[] strArr2;
        HashMap<String, String> map = new HashMap<>();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            strArr = packageInfo.splitNames;
        } catch (PackageManager.NameNotFoundException e) {
            af.c(f6636a, "getSourceDir:cannot find the package:" + str + " info." + e.getClass().getSimpleName());
        } catch (Throwable th) {
            af.c(f6636a, "getSourceDir ex: " + th.getClass().getSimpleName());
        }
        if (strArr != null && (strArr2 = applicationInfo.splitSourceDirs) != null) {
            int iMin = Math.min(strArr.length, strArr2.length);
            for (int i = 0; i < iMin; i++) {
                map.put(packageInfo.splitNames[i], applicationInfo.splitSourceDirs[i]);
            }
            return map;
        }
        af.c(f6636a, "splitNames or splitSourceDirs is null.");
        return map;
    }

    private static Set<q> b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable th) {
            af.d(f6636a, "getMetaSplits:cannot find the package:" + str + "info." + th.getClass().getSimpleName());
            applicationInfo = null;
        }
        return a(context, applicationInfo, str);
    }

    public static Set<q> a(Context context, ApplicationInfo applicationInfo, String str) {
        HashSet hashSet = new HashSet();
        if (context != null && applicationInfo != null) {
            try {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString(b);
                    if (TextUtils.isEmpty(string)) {
                        af.b(f6636a, "No metadata: presplits found.");
                        return hashSet;
                    }
                    String[] strArrSplit = string.split(",");
                    HashMap<String, String> mapA = a(context, str);
                    if (strArrSplit.length != 0 && !mapA.isEmpty()) {
                        for (String str2 : strArrSplit) {
                            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                                if (str2.equals(entry.getKey())) {
                                    hashSet.add(new q(new File(entry.getValue()), entry.getKey()));
                                }
                            }
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable th) {
                af.c(f6636a, "getSplitsInfo err: " + th.getClass().getSimpleName());
            }
        }
        return hashSet;
    }
}

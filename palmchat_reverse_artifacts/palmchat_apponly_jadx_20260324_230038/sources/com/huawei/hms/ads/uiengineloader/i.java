package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6630a = "ClassLoaderPathManager";
    private static final String b = "com.huawei.hff";
    private static HashMap<String, ArrayList<String>> c = new HashMap<>();

    public static String a(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f6630a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        if (c.containsKey(str)) {
            ArrayList<String> arrayList = c.get(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder(str);
                for (String str3 : arrayList) {
                    sb.append(File.pathSeparator);
                    sb.append(str3);
                }
                return sb.toString();
            }
            str2 = "No split apk path has set.";
        } else {
            str2 = "No split apk required, continue.";
        }
        af.b(f6630a, str2);
        return str;
    }

    public static String b(Context context, String str, PackageInfo packageInfo) {
        String string = null;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f6630a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        String strA = ag.a(context, str, z.a(context, str), packageInfo);
        packageInfo.applicationInfo.nativeLibraryDir = strA;
        if (!c.containsKey(str)) {
            af.b(f6630a, "No split apk required, continue.");
            return strA;
        }
        ArrayList<String> arrayList = c.get(str);
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f6630a, "No split apk path has set.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                if (sb.length() != 0) {
                    sb.append(File.pathSeparator);
                }
                sb.append(z.b(context, str2));
            }
            string = sb.toString();
        }
        if (TextUtils.isEmpty(strA)) {
            return string;
        }
        if (TextUtils.isEmpty(string)) {
            return strA;
        }
        return strA + File.pathSeparator + string;
    }

    private static void c(Context context, String str, PackageInfo packageInfo) {
        if (c.containsKey(str)) {
            af.b(f6630a, "HFF split info for dynamicApkPath has set.");
            return;
        }
        new r();
        Set<q> setA = r.a(context, packageInfo.applicationInfo, b);
        if (setA.isEmpty()) {
            af.b(f6630a, "No HFF split path need to add to classloader.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<q> it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(ad.a(it.next().f6635a));
        }
        c.put(str, arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f6630a, "No split apk path has set.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() != 0) {
                sb.append(File.pathSeparator);
            }
            sb.append(z.b(context, str));
        }
        return sb.toString();
    }
}

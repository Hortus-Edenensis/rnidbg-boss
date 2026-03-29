package com.zm.fda.oaid.Z200O.O20O5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16708a = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmh1YXdlaS5od2lk");
    public static final String b = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmh1YXdlaS5obXM=");
    public static final String c = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmh1YXdlaS5od2lkLnR2");

    public static PackageInfo a(Context context, String str) {
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
            Log.w("ApkUtil", "getPackageInfo NameNotFoundException");
            return null;
        } catch (Exception unused2) {
            Log.w("ApkUtil", "getPackageInfo Exception");
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        return a(context, str) != null;
    }

    public static String a(Context context) {
        String str = f16708a;
        if (b(context, str)) {
            return str;
        }
        String str2 = b;
        if (b(context, str2)) {
            return str2;
        }
        String str3 = c;
        return b(context, str3) ? str3 : str;
    }
}

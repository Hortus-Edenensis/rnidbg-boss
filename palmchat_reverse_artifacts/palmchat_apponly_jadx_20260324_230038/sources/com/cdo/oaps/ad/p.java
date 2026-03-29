package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5456a = 5100;
    public static final int b = 5000;
    public static final int c = 4600;
    public static final int d = 4550;
    public static final int e = 390;
    public static final int f = 6500;
    public static final int g = 6600;
    public static final int h = 2000000;
    public static final int i = 1;
    public static final int j = 7200;
    public static final int k = 8300;

    public static int a(Context context) {
        return a(context, "com.nearme.gamecenter");
    }

    public static int b(Context context) {
        int i2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a.b(), 0);
            if (packageInfo == null) {
                return 0;
            }
            i2 = packageInfo.versionCode;
        } catch (Exception e2) {
            if (!(e2 instanceof PackageManager.NameNotFoundException)) {
                return 0;
            }
            try {
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo("com.heytap.market", 0);
                if (packageInfo2 == null) {
                    return 0;
                }
                i2 = packageInfo2.versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return i2;
    }

    public static int a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8192) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, int i2) {
        try {
            return context.getPackageManager().getPackageInfo("com.nearme.gamecenter", 0).versionCode >= i2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return !Launcher.Host.GC.equals(OapsWrapper.wrapper(map).getHost()) || a(context, "com.nearme.gamecenter") >= 7300;
    }

    public static boolean a(Context context, String str, int i2) {
        int iA = a(context, str);
        return iA != 0 && iA >= i2;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return !Launcher.Host.MK.equals(OapsWrapper.wrapper(map).getHost()) || b(context) >= 5320 || TextUtils.isEmpty(BaseWrapper.wrapper(map).getBasePkg());
    }
}

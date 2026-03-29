package defpackage;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20948a = 1;

    public static String a(Context context, String str) {
        if (!ad.s(context, "android.permission.WRITE_SETTINGS")) {
            return str;
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "dig");
        } catch (Throwable unused) {
            k63.c("DeviceIdUtils", "Can not read from settings");
            return str;
        }
    }

    public static String b(Context context) {
        String str = (String) lg5.c(context, zz2.n());
        if (nl5.k(str)) {
            f20948a = 3;
            return str;
        }
        String strA = a(context, str);
        if (nl5.k(strA)) {
            f20948a = 1;
            f(context, strA);
            lg5.h(context, zz2.n().a0(strA));
            return strA;
        }
        String strC = c(context);
        if (nl5.k(strC)) {
            f20948a = 2;
            e(context, strC);
            lg5.h(context, zz2.n().a0(strC));
            return strC;
        }
        String strC2 = ad.c(context);
        String string = UUID.randomUUID().toString();
        String strG = nl5.g("" + strC2 + string);
        if (!TextUtils.isEmpty(strG)) {
            string = strG;
        }
        lg5.h(context, zz2.n().a0(string));
        f20948a = 0;
        e(context, string);
        f(context, string);
        return string;
    }

    public static String c(Context context) {
        if (!tv2.b(context, true, "do not get deviceId from SD") && ad.s(context, g.i)) {
            String strJ = ad.j();
            if (TextUtils.isEmpty(strJ)) {
                k63.c("DeviceIdUtils", "can't get sdcard data path");
            } else {
                String strI = hv1.i(new File(strJ + ".push_deviceid"));
                if (strI != null) {
                    int iIndexOf = strI.indexOf("\n");
                    return iIndexOf < 0 ? strI.trim() : strI.substring(0, iIndexOf).trim();
                }
            }
        }
        return null;
    }

    public static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(context, str);
        f(context, str);
        lg5.h(context, zz2.n().a0(str));
    }

    public static String e(Context context, String str) {
        if (!ad.s(context, "android.permission.WRITE_SETTINGS")) {
            return null;
        }
        try {
            if (Settings.System.putString(context.getContentResolver(), "dig", str)) {
                return str;
            }
            return null;
        } catch (Throwable unused) {
            k63.c("DeviceIdUtils", "Can not write settings");
            return null;
        }
    }

    public static String f(Context context, String str) {
        if (tv2.b(context, true, "not write deviceId to SD")) {
            return str;
        }
        if (!ad.s(context, g.j)) {
            return null;
        }
        try {
            String strJ = ad.j();
            if (TextUtils.isEmpty(strJ)) {
                k63.c("DeviceIdUtils", "can't get sdcard data path");
                return null;
            }
            hv1.j(new File(strJ + ".push_deviceid"), str);
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }
}

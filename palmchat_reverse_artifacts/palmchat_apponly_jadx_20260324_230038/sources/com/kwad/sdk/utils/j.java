package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.wifi.adsdk.utils.LxAdOSUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j {
    private static String bdJ = Build.BRAND;
    private static String bdK = "OPPO";
    private static String bdL = "vivo";
    private static String bdM = "Xiaomi";
    private static String bdN = "Meizu";
    private static String bdO = "HUAWEI";
    private static String bdP = "HONOR";

    private static Intent P(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    public static boolean RA() {
        return bdJ.equalsIgnoreCase(bdP);
    }

    private static boolean RB() {
        return bdJ.equalsIgnoreCase(bdK);
    }

    private static boolean RC() {
        return bdJ.equalsIgnoreCase(bdL);
    }

    private static String RD() {
        return aq("ro.miui.ui.version.name", "");
    }

    private static boolean Rw() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean Rx() {
        String str = Build.MANUFACTURER;
        return LxAdOSUtils.ROM_QIKU.equals(str.toUpperCase()) || "360".equals(str.toUpperCase());
    }

    private static boolean Ry() {
        return bdJ.equalsIgnoreCase(bdM);
    }

    public static boolean Rz() {
        return bdJ.equalsIgnoreCase(bdO);
    }

    private static String aq(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static void cJ(Context context) {
        Intent intentCK;
        if (context == null || (intentCK = cK(context)) == null) {
            return;
        }
        try {
            context.startActivity(intentCK);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cK(Context context) {
        Intent intent;
        if (Ry()) {
            return P(context, RD());
        }
        if (Rz() || RA()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        } else if (Rw()) {
            intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
        } else if (RB() || RC()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        } else if (Rx()) {
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        }
        return intent;
    }
}

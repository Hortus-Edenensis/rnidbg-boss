package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class m {
    private static Method f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11305a = ag.b("ro.vivo.product.overseas", "no").equals("yes");
    public static final boolean b = b("rom_1.0");
    public static final boolean c = b("rom_2.0");
    public static final boolean d = b("rom_2.5");
    public static final boolean e = b("rom_3.0");
    private static String g = null;
    private static String h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String strB = ag.b("ro.vivo.rom", "");
        String strB2 = ag.b("ro.vivo.rom.version", "");
        t.d("Device", "ro.vivo.rom = " + strB + " ; ro.vivo.rom.version = " + strB2);
        if (strB == null || !strB.contains(str)) {
            return strB2 != null && strB2.contains(str);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0085 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087 A[Catch: all -> 0x0097, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x000c, B:10:0x0053, B:11:0x005a, B:15:0x0087), top: B:24:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a() {
        String strA;
        if (g == null && h == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                f = declaredMethod;
                declaredMethod.setAccessible(true);
                g = (String) f.invoke(null, "ro.vivo.rom", "@><@");
                h = (String) f.invoke(null, "ro.vivo.rom.version", "@><@");
            } catch (Exception unused) {
                t.b("Device", "getRomCode error");
            }
            t.d("Device", "sRomProperty1 : " + g + " ; sRomProperty2 : " + h);
            strA = a(g);
            if (TextUtils.isEmpty(strA)) {
            }
        } else {
            t.d("Device", "sRomProperty1 : " + g + " ; sRomProperty2 : " + h);
            strA = a(g);
            if (TextUtils.isEmpty(strA)) {
                return strA;
            }
            String strA2 = a(h);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            return strA2;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            t.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        t.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}

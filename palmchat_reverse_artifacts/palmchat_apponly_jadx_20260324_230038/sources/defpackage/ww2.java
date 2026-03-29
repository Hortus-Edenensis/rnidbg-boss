package defpackage;

import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ww2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21820a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";

    public static String a() {
        if (!TextUtils.isEmpty(f21820a)) {
            return f21820a;
        }
        String strD = d(LxAdEmuiDevice.PROP_VERSION);
        f21820a = strD;
        return strD;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String strD = d("ro.build.display.id");
        f = strD;
        return strD;
    }

    public static String c() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String strD = d("ro.miui.ui.version.name");
        e = strD;
        return strD;
    }

    public static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            p63.d("JRomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            p63.c("JRomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static String e() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String strD = d("ro.rom.version");
        d = strD;
        return strD;
    }

    public static String f() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String strD = d(LxAdOppoDevice.PROP_VERSION);
        b = strD;
        return strD;
    }

    public static String g() {
        try {
            String lowerCase = lv2.b.toLowerCase();
            if (lowerCase.contains("huawei")) {
                return a();
            }
            if (lowerCase.contains("xiaomi")) {
                return c();
            }
            if (lowerCase.contains(AssistUtils.BRAND_MZ)) {
                return b();
            }
            if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                return lowerCase.contains("vivo") ? h() : lowerCase.contains("oneplus") ? e() : "";
            }
            return f();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strD = d(LxAdVivoDevice.PROP_VERSION);
        c = strD;
        return strD;
    }
}

package defpackage;

import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19438a;

    static {
        f19438a = na7.f(LxAdOppoDevice.PROP_VERSION) ? "oppo" : na7.f(LxAdEmuiDevice.PROP_VERSION) ? "huawei" : na7.f("ro.vivo.os.version") ? "vivo" : na7.f("ro.miui.ui.version.name") ? "xiaomi" : null;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = na7.b(str, "").trim();
        if (TextUtils.isEmpty(strTrim)) {
            return "";
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= strTrim.length()) {
                break;
            }
            if (Character.isDigit(strTrim.charAt(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        return strTrim.substring(i);
    }

    public static boolean b() {
        return TextUtils.equals(f19438a, "oppo");
    }

    public static boolean c() {
        return TextUtils.equals(f19438a, "huawei");
    }

    public static boolean d() {
        return TextUtils.equals(f19438a, "vivo");
    }

    public static boolean e() {
        return TextUtils.equals(f19438a, "xiaomi");
    }

    public static String f() {
        String str;
        if (b()) {
            str = LxAdOppoDevice.PROP_VERSION;
        } else if (c()) {
            str = LxAdEmuiDevice.PROP_VERSION;
        } else if (d()) {
            str = "ro.vivo.os.version";
        } else {
            if (!e()) {
                return "";
            }
            str = "ro.miui.ui.version.name";
        }
        return a(str);
    }
}

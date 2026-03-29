package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class py4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20136a;
    public static String b;

    public static boolean a(String str) {
        String str2 = f20136a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strC = c("ro.miui.ui.version.name");
        b = strC;
        if (TextUtils.isEmpty(strC)) {
            String strC2 = c(LxAdEmuiDevice.PROP_VERSION);
            b = strC2;
            if (TextUtils.isEmpty(strC2)) {
                String strC3 = c(LxAdOppoDevice.PROP_VERSION);
                b = strC3;
                if (TextUtils.isEmpty(strC3)) {
                    String strC4 = c("ro.vivo.os.version");
                    b = strC4;
                    if (TextUtils.isEmpty(strC4)) {
                        String strC5 = c("ro.smartisan.version");
                        b = strC5;
                        if (TextUtils.isEmpty(strC5)) {
                            String str3 = Build.DISPLAY;
                            b = str3;
                            if (str3.toUpperCase().contains(LxAdOSUtils.ROM_FLYME)) {
                                f20136a = LxAdOSUtils.ROM_FLYME;
                            } else {
                                b = "unknown";
                                f20136a = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            f20136a = LxAdOSUtils.ROM_SMARTISAN;
                        }
                    } else {
                        f20136a = LxAdOSUtils.ROM_VIVO;
                    }
                } else {
                    f20136a = "OPPO";
                }
            } else {
                f20136a = LxAdOSUtils.ROM_EMUI;
            }
        } else {
            f20136a = LxAdOSUtils.ROM_MIUI;
        }
        return f20136a.equals(str);
    }

    public static String b() {
        if (f20136a == null) {
            a("");
        }
        return f20136a;
    }

    public static String c(String str) {
        return sb1.c(str);
    }

    public static boolean d() {
        return a("OPPO");
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    private static final CharSequence u = "sony";
    private static final CharSequence nr = "amigo";
    private static final CharSequence fx = "funtouch";
    private static final u<Boolean> b = new u<Boolean>() { // from class: com.bytedance.embedapplog.a.1
        @Override // com.bytedance.embedapplog.a.u
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Boolean nr(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class u<T> {
        private volatile T u;

        public final T fx(Object... objArr) {
            if (this.u == null) {
                synchronized (this) {
                    if (this.u == null) {
                        this.u = nr(objArr);
                    }
                }
            }
            return this.u;
        }

        public abstract T nr(Object... objArr);
    }

    public static String a() {
        return Build.DISPLAY + "_" + nr("ro.gn.sv.version");
    }

    public static boolean b() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean bg() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean bq() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains(AssistUtils.BRAND_MZ);
    }

    private static String d() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String dw() {
        if (!bg()) {
            return "";
        }
        return "coloros_" + nr(LxAdOppoDevice.PROP_VERSION) + "_" + Build.DISPLAY;
    }

    public static String fx() {
        return nr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean gi() {
        return d().toUpperCase().contains("ASUS");
    }

    public static boolean iz() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static String jk() {
        if (!t()) {
            return "";
        }
        return "eui_" + nr("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean kj() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strNr = nr("ro.build.version.incremental");
        return !TextUtils.isEmpty(strNr) && strNr.contains("VIBEUI_V2");
    }

    public static boolean l() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("huawei")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("huawei");
    }

    public static boolean mv() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static String my() {
        if (!k()) {
            return "";
        }
        return "miui_" + nr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean n() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(nr);
    }

    public static String nr() {
        if (k()) {
            return my();
        }
        if (iz()) {
            return sx();
        }
        if (bg()) {
            return dw();
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            return strO;
        }
        if (x()) {
            return pn();
        }
        if (n()) {
            return a();
        }
        if (b()) {
            return fx();
        }
        String strJk = jk();
        return !TextUtils.isEmpty(strJk) ? strJk : Build.DISPLAY;
    }

    public static String o() {
        String strU = u();
        if (strU == null) {
            return "";
        }
        if (!strU.toLowerCase().contains("emotionui") && !strU.toLowerCase().contains("magicui")) {
            return "";
        }
        return strU + "_" + Build.DISPLAY;
    }

    public static String pn() {
        return nr(LxAdVivoDevice.PROP_VERSION) + "_" + nr("ro.vivo.product.version");
    }

    public static boolean q() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean qq() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean s() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("Honor", e.getMessage());
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION));
    }

    public static String sx() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean t() {
        return !TextUtils.isEmpty(nr("ro.letv.release.version"));
    }

    public static String u() {
        return nr(LxAdEmuiDevice.PROP_VERSION);
    }

    public static boolean x() {
        String strNr = nr(LxAdVivoDevice.PROP_VERSION);
        return !TextUtils.isEmpty(strNr) && strNr.toLowerCase().contains(fx);
    }

    public static boolean z() {
        return d().toUpperCase().contains("NUBIA");
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            str = u();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || l() || mv();
    }

    public static boolean u(Context context) {
        return d().toUpperCase().contains("HUAWEI");
    }

    private static String nr(String str) {
        String strU = te.u(str);
        return !TextUtils.isEmpty(strU) ? strU : gb.u(str);
    }
}

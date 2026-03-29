package com.bytedance.sdk.openadsdk.core.y;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5410a = null;
    private static int n = Integer.MAX_VALUE;
    public static int nr;
    public static int u;
    private static String x;
    private static final CharSequence fx = "sony";
    private static final CharSequence b = "amigo";
    private static final CharSequence pn = "funtouch";
    private static final CharSequence iz = "origin";

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Callable<String> {
        private String u;

        public u(String str) {
            this.u = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strNr = gi.nr(this.u);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strNr)) {
                try {
                    bf.u("rom_info").put("rom_property_info", strNr);
                } catch (Throwable unused) {
                }
            }
            return strNr;
        }
    }

    public static boolean a() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(b);
    }

    public static String b() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean bg() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("romUtils", e.getMessage());
            return false;
        }
    }

    public static boolean bq() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean c() {
        if (n == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strJk = jp.jk("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(strJk)) {
                n = 0;
            } else {
                n = 1;
            }
        }
        return n == 1;
    }

    private static String d() {
        try {
            return bf.u("rom_info").get("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String dw() {
        return fx(LxAdEmuiDevice.PROP_VERSION);
    }

    public static String fx() {
        if (!my()) {
            return "";
        }
        return "miui_" + nr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String gi() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (my()) {
            return "miui_".concat(String.valueOf(str));
        }
        if (o()) {
            return "huawei_".concat(String.valueOf(str));
        }
        Locale locale = Locale.ROOT;
        return str2.toLowerCase(locale).contains("oppo") ? "oppo_".concat(String.valueOf(str)) : str2.toLowerCase(locale).contains("vivo") ? "vivo_".concat(String.valueOf(str)) : str2.toLowerCase(locale).contains("oneplus") ? "oneplus_".concat(String.valueOf(str)) : str;
    }

    public static String iz() {
        String strDw = dw();
        if (strDw == null) {
            return "";
        }
        if (!strDw.toLowerCase().contains("emotionui") && !strDw.toLowerCase().contains("magicui")) {
            return "";
        }
        return strDw + "_" + Build.DISPLAY;
    }

    public static boolean jk() {
        try {
            return "FreemeOS".equalsIgnoreCase(nr("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String k() {
        if (TextUtils.isEmpty(f5410a)) {
            f5410a = z();
        }
        return f5410a;
    }

    public static int kj() {
        try {
            return (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable unused) {
            return 4097;
        }
    }

    public static boolean l() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String mv() {
        if (!s()) {
            return "";
        }
        return "eui_" + nr("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean my() {
        if (u == 0) {
            try {
                Class.forName("miui.os.Build");
                u = 1;
            } catch (Exception unused) {
            }
        }
        return u == 1;
    }

    public static String n() {
        return "vivo_" + nr(LxAdVivoDevice.PROP_VERSION) + "_" + nr("ro.vivo.product.version");
    }

    public static String nr() {
        return nr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean o() {
        if (nr == 0) {
            try {
                Class.forName("com.huawei.system.BuildEx");
                nr = 1;
            } catch (Exception unused) {
            }
        }
        return nr == 1;
    }

    public static String pn() {
        if (!c()) {
            return "";
        }
        return "coloros_" + nr("ro.build.version.kllkrom") + "_" + Build.DISPLAY;
    }

    public static boolean q() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean qq() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static boolean s() {
        return !TextUtils.isEmpty(nr("ro.letv.release.version"));
    }

    public static boolean sx() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if (str.toLowerCase().contains("oppo")) {
                    return true;
                }
                return str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("romUtil", e.getMessage());
        }
        return false;
    }

    public static String t() {
        return Build.DISPLAY + "_" + nr("ro.gn.sv.version");
    }

    public static String u() {
        if (TextUtils.isEmpty(x)) {
            x = gi();
        }
        return x;
    }

    public static boolean x() {
        String strNr = nr(LxAdVivoDevice.PROP_VERSION);
        if (TextUtils.isEmpty(strNr)) {
            return false;
        }
        return strNr.toLowerCase().contains(pn) || strNr.toLowerCase().contains("origin");
    }

    private static String z() {
        if (my()) {
            return fx();
        }
        if (bq()) {
            return b();
        }
        if (c()) {
            return pn();
        }
        String strIz = iz();
        if (!TextUtils.isEmpty(strIz)) {
            return strIz;
        }
        if (x()) {
            return n();
        }
        if (a()) {
            return t();
        }
        if (l()) {
            return nr();
        }
        String strMv = mv();
        if (!TextUtils.isEmpty(strMv)) {
            return strMv;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (qq()) {
            return "honor_" + dw();
        }
        if (jk()) {
            return "freeme_" + dw();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String nr(String str) {
        com.bytedance.sdk.component.b.t tVar = (com.bytedance.sdk.component.b.t) com.bytedance.sdk.openadsdk.ats.fx.u("system_info");
        return tVar != null ? tVar.get(str) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String fx(String str) {
        String strD;
        try {
            strD = d();
            try {
                if (TextUtils.isEmpty(strD)) {
                    final com.bytedance.sdk.component.jk.n nVar = new com.bytedance.sdk.component.jk.n(new u(str), 5, 2);
                    com.bytedance.sdk.component.jk.x.fx(new com.bytedance.sdk.component.jk.a("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.y.gi.1
                        @Override // java.lang.Runnable
                        public void run() {
                            nVar.run();
                        }
                    });
                    strD = (String) nVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strD = "";
        }
        return strD == null ? "" : strD;
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            str = dw();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || q();
    }
}

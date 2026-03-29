package com.ss.android.socialbase.appdownloader.iz;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.x;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    private static String b = "";
    public static String fx = null;
    private static String iz = null;
    private static Boolean n = null;
    public static String nr = "";
    private static String pn;
    public static String u;
    private static String x;

    public static String a() {
        if (iz == null) {
            u("");
        }
        return iz;
    }

    public static boolean b() {
        return u(LxAdOSUtils.ROM_VIVO);
    }

    private static void bg() {
        if (x == null) {
            try {
                x = b("ro.miui.ui.version.name");
            } catch (Exception unused) {
            }
            String str = x;
            if (str == null) {
                str = "";
            }
            x = str;
        }
    }

    public static boolean fx() {
        return u(LxAdOSUtils.ROM_MIUI);
    }

    public static boolean iz() {
        return u(LxAdOSUtils.ROM_FLYME);
    }

    public static String jk() {
        if (fx == null) {
            u("");
        }
        return fx;
    }

    public static boolean k() {
        bg();
        return "V12".equals(x);
    }

    @NonNull
    public static String l() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean mv() {
        bg();
        return "V10".equals(x);
    }

    public static boolean my() {
        if (n == null) {
            n = Boolean.valueOf(b.x().equals("harmony"));
        }
        return n.booleanValue();
    }

    public static String n() {
        if (pn == null) {
            u("");
        }
        return pn;
    }

    public static boolean nr() {
        return u("MAGICUI");
    }

    public static boolean o() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor");
    }

    public static boolean pn() {
        sx();
        return u(u);
    }

    public static boolean s() {
        bg();
        return "V11".equals(x);
    }

    private static void sx() {
        if (TextUtils.isEmpty(u)) {
            com.ss.android.socialbase.downloader.downloader.fx.wq();
            u = com.ss.android.socialbase.downloader.constants.pn.nr;
            b = "ro.build.version." + com.ss.android.socialbase.downloader.constants.pn.fx + "rom";
            nr = "com." + com.ss.android.socialbase.downloader.constants.pn.fx + ".market";
        }
    }

    @NonNull
    public static String t() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean u() {
        return u(LxAdOSUtils.ROM_EMUI) || u("MAGICUI");
    }

    public static boolean x() {
        return u("SAMSUNG");
    }

    public static String b(String str) {
        if (com.ss.android.socialbase.downloader.n.u.nr().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return fx(str);
            } catch (Throwable unused) {
            }
        }
        return nr(str);
    }

    public static String fx(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String nr(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            com.ss.android.socialbase.downloader.jk.iz.u(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            com.ss.android.socialbase.downloader.jk.iz.u(bufferedReader);
            return null;
        }
    }

    public static boolean u(String str) {
        sx();
        String str2 = pn;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strB = b("ro.miui.ui.version.name");
        iz = strB;
        if (TextUtils.isEmpty(strB)) {
            String strB2 = b(LxAdEmuiDevice.PROP_VERSION);
            iz = strB2;
            if (TextUtils.isEmpty(strB2)) {
                String strB3 = b("ro.build.version.magic");
                iz = strB3;
                if (TextUtils.isEmpty(strB3)) {
                    String strB4 = b(b);
                    iz = strB4;
                    if (TextUtils.isEmpty(strB4)) {
                        String strB5 = b("ro.vivo.os.version");
                        iz = strB5;
                        if (TextUtils.isEmpty(strB5)) {
                            String strB6 = b("ro.smartisan.version");
                            iz = strB6;
                            if (TextUtils.isEmpty(strB6)) {
                                String strB7 = b("ro.gn.sv.version");
                                iz = strB7;
                                if (TextUtils.isEmpty(strB7)) {
                                    String strB8 = b("ro.lenovo.lvp.version");
                                    iz = strB8;
                                    if (!TextUtils.isEmpty(strB8)) {
                                        pn = "LENOVO";
                                        fx = "com.lenovo.leos.appstore";
                                    } else if (t().toUpperCase().contains("SAMSUNG")) {
                                        pn = "SAMSUNG";
                                        fx = "com.sec.android.app.samsungapps";
                                    } else if (t().toUpperCase().contains("ZTE")) {
                                        pn = "ZTE";
                                        fx = "zte.com.market";
                                    } else if (t().toUpperCase().contains("NUBIA")) {
                                        pn = "NUBIA";
                                        fx = "cn.nubia.neostore";
                                    } else if (l().toUpperCase().contains(LxAdOSUtils.ROM_FLYME)) {
                                        pn = LxAdOSUtils.ROM_FLYME;
                                        fx = "com.meizu.mstore";
                                        iz = l();
                                    } else if (t().toUpperCase().contains("ONEPLUS")) {
                                        pn = "ONEPLUS";
                                        iz = b("ro.rom.version");
                                        if (x.u(nr) >= 0) {
                                            fx = nr;
                                        } else {
                                            fx = "com.heytap.market";
                                        }
                                    } else {
                                        pn = t().toUpperCase();
                                        fx = "";
                                        iz = "";
                                    }
                                } else {
                                    pn = "QIONEE";
                                    fx = "com.gionee.aora.market";
                                }
                            } else {
                                pn = LxAdOSUtils.ROM_SMARTISAN;
                                fx = "com.smartisanos.appstore";
                            }
                        } else {
                            pn = LxAdOSUtils.ROM_VIVO;
                            fx = BLPlatform.VIVO_APPSTORE_PN;
                        }
                    } else {
                        pn = u;
                        if (x.u(nr) >= 0) {
                            fx = nr;
                        } else {
                            fx = "com.heytap.market";
                        }
                    }
                } else {
                    pn = "MAGICUI";
                    fx = "com.hihonor.appmarket";
                }
            } else {
                String str3 = o() ? "MAGICUI" : LxAdOSUtils.ROM_EMUI;
                pn = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    fx = "com.hihonor.appmarket";
                } else {
                    fx = com.huawei.openalliance.ad.constant.x.ad;
                }
            }
        } else {
            pn = LxAdOSUtils.ROM_MIUI;
            fx = "com.xiaomi.market";
            x = iz;
        }
        return pn.equals(str);
    }
}

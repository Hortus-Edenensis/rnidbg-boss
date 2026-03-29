package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bb {
    private static String bfj;
    private static String bfk;

    public static boolean RB() {
        return hz("OPPO");
    }

    public static boolean RC() {
        return hz(LxAdOSUtils.ROM_VIVO);
    }

    public static boolean Ta() {
        return hz(LxAdOSUtils.ROM_EMUI);
    }

    public static boolean Tb() {
        return hz(LxAdOSUtils.ROM_MIUI);
    }

    public static boolean Tc() {
        return hz(LxAdOSUtils.ROM_FLYME);
    }

    public static boolean Td() {
        return hz(LxAdOSUtils.ROM_SMARTISAN);
    }

    public static String getName() {
        if (bfj == null) {
            hz("");
        }
        return bfj;
    }

    public static String getVersion() {
        if (bfk == null) {
            hz("");
        }
        return bfk;
    }

    private static boolean hz(String str) {
        String str2 = bfj;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bq.get(LxAdOppoDevice.PROP_VERSION);
        bfk = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bq.get("ro.vivo.os.version");
            bfk = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bq.get(LxAdEmuiDevice.PROP_VERSION);
                bfk = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bq.get("ro.miui.ui.version.name");
                    bfk = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bq.get("ro.product.system.manufacturer");
                        bfk = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bq.get("ro.smartisan.version");
                            bfk = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                bfj = LxAdOSUtils.ROM_SMARTISAN;
                            } else if (bq.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                bfj = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                bfk = str9;
                                if (str9.toUpperCase().contains(LxAdOSUtils.ROM_FLYME)) {
                                    bfj = LxAdOSUtils.ROM_FLYME;
                                } else {
                                    bfk = "unknown";
                                    bfj = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        } else {
                            bfj = "OnePlus";
                        }
                    } else {
                        bfj = LxAdOSUtils.ROM_MIUI;
                    }
                } else {
                    bfj = LxAdOSUtils.ROM_EMUI;
                }
            } else {
                bfj = LxAdOSUtils.ROM_VIVO;
            }
        } else {
            bfj = "OPPO";
        }
        return bfj.contains(str);
    }
}

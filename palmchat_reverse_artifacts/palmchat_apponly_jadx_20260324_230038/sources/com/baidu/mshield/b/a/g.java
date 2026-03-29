package com.baidu.mshield.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f4020a = new HashMap<>();

    public static String a(Context context) {
        return com.baidu.sec.privacy.e.a.a(context).b();
    }

    public static String b() {
        return a("arv");
    }

    public static String c(Context context) {
        try {
            String strA = a(context);
            String strA2 = com.baidu.sec.privacy.f.g.a("ro.build.display.id", "");
            if (TextUtils.isEmpty(strA)) {
                return strA2;
            }
            if (strA.equalsIgnoreCase("HUAWEI")) {
                return com.baidu.sec.privacy.f.g.a(LxAdEmuiDevice.PROP_VERSION, strA2);
            }
            if (strA.equalsIgnoreCase("XIAOMI")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", strA2);
            }
            if (strA.equalsIgnoreCase("OPPO")) {
                return com.baidu.sec.privacy.f.g.a(LxAdOppoDevice.PROP_VERSION, strA2);
            }
            if (strA.equalsIgnoreCase(LxAdOSUtils.ROM_VIVO)) {
                return com.baidu.sec.privacy.f.g.a("ro.vivo.rom.version", strA2);
            }
            if (strA.equalsIgnoreCase("BBK")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.version.bbk", strA2);
            }
            if (strA.equalsIgnoreCase("MEIZU")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", strA2);
            }
            if (strA.equalsIgnoreCase("SAMSUNG") || strA.equalsIgnoreCase("GiONEE")) {
                return strA2;
            }
            if (strA.equalsIgnoreCase("ZTE")) {
                String strA3 = com.baidu.sec.privacy.f.g.a("ro.build.rom.id", strA2);
                if (!strA2.equals(strA3)) {
                    return strA3;
                }
                String strA4 = com.baidu.sec.privacy.f.g.a("apps.setting.product.release", strA2);
                return strA2.equals(strA4) ? com.baidu.sec.privacy.f.g.a("ro.bliss.display.version", strA2) : strA4;
            }
            if (!strA.equalsIgnoreCase("LeMobile") && !strA.equalsIgnoreCase("Letv")) {
                if (strA.equalsIgnoreCase("LENOVO")) {
                    String strA5 = a();
                    if (!TextUtils.isEmpty(strA5)) {
                        if (strA5.equalsIgnoreCase("Lenovo A5800-D")) {
                            return com.baidu.sec.privacy.f.g.a("ro.build.cmccdisplay.id", strA2);
                        }
                        if (strA5.equalsIgnoreCase("Lenovo K900")) {
                            return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", strA2);
                        }
                    }
                } else {
                    if (strA.equalsIgnoreCase("YuLong")) {
                        return strA2;
                    }
                    if (strA.equalsIgnoreCase("OnePlus")) {
                        return com.baidu.sec.privacy.f.g.a("ro.rom.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("QiKU")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.uiversion", strA2);
                    }
                    if (strA.equalsIgnoreCase("nubia")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.rom.id", strA2);
                    }
                    if (strA.equalsIgnoreCase("motorola")) {
                        return strA2;
                    }
                    if (strA.equalsIgnoreCase("HTC")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.sense.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("ZUK")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.version.incremental", strA2);
                    }
                    if (strA.equalsIgnoreCase("K-Touch")) {
                        return com.baidu.sec.privacy.f.g.a("ro.yunos.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("MeiTu")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.version.meios", strA2);
                    }
                    if (strA.equalsIgnoreCase("DOOV")) {
                        return com.baidu.sec.privacy.f.g.a("ro.fota.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("hisense")) {
                        String strA6 = a();
                        if (!TextUtils.isEmpty(strA6)) {
                            if (strA6.equalsIgnoreCase("hisense e76")) {
                                return com.baidu.sec.privacy.f.g.a("ro.hs.ui.style", strA2);
                            }
                            if (strA6.equalsIgnoreCase("hisense e51-m")) {
                                return com.baidu.sec.privacy.f.g.a("hw.cabl.version", strA2);
                            }
                        }
                    } else {
                        if (strA.equalsIgnoreCase("Changhong")) {
                            return com.baidu.sec.privacy.f.g.a("ro.fota.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("smartisan")) {
                            return com.baidu.sec.privacy.f.g.a("ro.smartisan.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("NM")) {
                            return com.baidu.sec.privacy.f.g.a("ro.xh.display.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("HONOR")) {
                            return com.baidu.sec.privacy.f.g.a(LxAdEmuiDevice.PROP_VERSION, strA2);
                        }
                        if (strA.equalsIgnoreCase("REALME")) {
                            return com.baidu.sec.privacy.f.g.a(LxAdOppoDevice.PROP_VERSION, strA2);
                        }
                    }
                }
                return strA2;
            }
            return com.baidu.sec.privacy.f.g.a("ro.letv.release.version", strA2);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public static String a() {
        return a("mod");
    }

    public static String b(Context context) {
        String strA;
        try {
            strA = a(context);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        if (strA.equalsIgnoreCase("HUAWEI")) {
            return "EmotionUI";
        }
        if (strA.equalsIgnoreCase("HONOR")) {
            return "MagicUI";
        }
        if (strA.equalsIgnoreCase("XIAOMI")) {
            return com.baidu.sec.privacy.f.g.a("ro.miui.ui.version.name", LxAdOSUtils.ROM_MIUI);
        }
        if (strA.equalsIgnoreCase("OPPO")) {
            return "ColorOS";
        }
        if (strA.equalsIgnoreCase(LxAdOSUtils.ROM_VIVO)) {
            return com.baidu.sec.privacy.f.g.a("ro.vivo.os.name", "Funtouch");
        }
        if (strA.equalsIgnoreCase("BBK")) {
            return "BBK";
        }
        if (strA.equalsIgnoreCase("MEIZU")) {
            return com.baidu.sec.privacy.f.g.a("ro.build.user", "Flyme");
        }
        if (strA.equalsIgnoreCase("samsung")) {
            return "SAMSUNG";
        }
        if (strA.equalsIgnoreCase("GiONEE")) {
            return com.baidu.sec.privacy.f.g.a("ro.build.display.id", "Amigo");
        }
        if (!strA.equalsIgnoreCase("ZTE")) {
            return (strA.equalsIgnoreCase("LeMobile") || strA.equalsIgnoreCase("Letv")) ? "EUI" : strA.equalsIgnoreCase("LENOVO") ? "LENOVO" : strA.equalsIgnoreCase("YuLong") ? "COOLUI" : strA.equalsIgnoreCase("OnePlus") ? "H2OS" : strA.equalsIgnoreCase("QiKU") ? LxAdOSUtils.ROM_QIKU : strA.equalsIgnoreCase("nubia") ? com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", "NUBIAUI") : strA.equalsIgnoreCase("motorola") ? "MOTOROLA" : strA.equalsIgnoreCase("HTC") ? "HTC Sense" : strA.equalsIgnoreCase("ZUK") ? "ZUI" : strA.equalsIgnoreCase("coolpad") ? "COOLPAD" : strA.equalsIgnoreCase("360") ? com.baidu.sec.privacy.f.g.a("ro.build.uiversion", "360") : strA.equalsIgnoreCase("K-Touch") ? "KTOUCH" : strA.equalsIgnoreCase("MeiTu") ? com.baidu.sec.privacy.f.g.a("ro.build.user", "MEITU") : strA.equalsIgnoreCase("DOOV") ? com.baidu.sec.privacy.f.g.a("ro.fota.oem", "DOOV") : strA.equalsIgnoreCase("TCL") ? "TCL" : strA.equalsIgnoreCase("Yota Devices Limited") ? "Yota" : strA.equalsIgnoreCase("lge") ? com.baidu.sec.privacy.f.g.a("ro.build.product", "LGE") : strA.equalsIgnoreCase("hisense") ? "VISION" : strA.equalsIgnoreCase("Changhong") ? "CHANGHONG" : strA.equalsIgnoreCase("Sony") ? "Sony" : strA.equalsIgnoreCase("smartisan") ? "smartisan" : strA.equalsIgnoreCase("NM") ? "newman" : strA.equalsIgnoreCase("REALME") ? "realmeUI" : "";
        }
        String strA2 = a();
        return (TextUtils.isEmpty(strA2) || !strA2.equalsIgnoreCase("X9180")) ? com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", "ZTE") : "Bliss";
    }

    public static String a(String str) {
        try {
            HashMap<String, String> map = f4020a;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                if (!map.containsKey(str)) {
                    return "";
                }
                return map.get(str);
            }
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public static void a(HashMap<String, String> map) {
        if (map != null) {
            HashMap<String, String> map2 = f4020a;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    public static void b(HashMap<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                synchronized (f4020a) {
                    for (String str : map.keySet()) {
                        f4020a.put(str, map.get(str));
                    }
                }
            } catch (Throwable th) {
                com.baidu.sec.privacy.f.c.a(th);
            }
        }
    }
}

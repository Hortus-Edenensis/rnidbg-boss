package com.amap.api.col.p0002sl;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gy f2850a;
    private static Properties b;

    private gz() {
    }

    public static gy a() {
        if (f2850a == null) {
            synchronized (gz.class) {
                if (f2850a == null) {
                    try {
                        gy gyVarA = a(Build.MANUFACTURER);
                        if ("".equals(gyVarA.a())) {
                            Iterator it = Arrays.asList(gy.MIUI.a(), gy.Flyme.a(), gy.RH.a(), gy.ColorOS.a(), gy.FuntouchOS.a(), gy.SmartisanOS.a(), gy.AmigoOS.a(), gy.Sense.a(), gy.LG.a(), gy.Google.a(), gy.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    gyVarA = gy.Other;
                                    break;
                                }
                                gy gyVarA2 = a((String) it.next());
                                if (!"".equals(gyVarA2.a())) {
                                    gyVarA = gyVarA2;
                                    break;
                                }
                            }
                        }
                        f2850a = gyVarA;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f2850a;
    }

    private static String b(String str) {
        Properties properties = b;
        String property = null;
        if (properties != null) {
            property = properties.getProperty("[" + str + "]", null);
        }
        return TextUtils.isEmpty(property) ? c(str) : property.replace("[", "").replace("]", "");
    }

    private static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return line;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean d(gy gyVar) {
        String strB = b(LxAdOppoDevice.PROP_VERSION);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean e(gy gyVar) {
        String strB = b(LxAdVivoDevice.PROP_VERSION);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean f(gy gyVar) {
        String strB = b("ro.smartisan.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean g(gy gyVar) {
        String strB = b("ro.build.display.id");
        if (TextUtils.isEmpty(strB) || !strB.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean h(gy gyVar) {
        String strB = b("ro.letv.release.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean i(gy gyVar) {
        String strB = b("ro.build.sense.version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean j(gy gyVar) {
        String strB = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean k(gy gyVar) {
        if (!"android-google".equals(b("ro.com.google.clientidbase"))) {
            return false;
        }
        String strB = b("ro.build.version.release");
        gyVar.a(Build.VERSION.SDK_INT);
        gyVar.b(strB);
        return true;
    }

    private static boolean l(gy gyVar) {
        String strB = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static boolean b(gy gyVar) {
        String strB = b("ro.flyme.published");
        String strB2 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(strB) && TextUtils.isEmpty(strB2)) {
            return false;
        }
        String strB3 = b("ro.build.display.id");
        a(gyVar, strB3);
        gyVar.b(strB3);
        return true;
    }

    private static boolean c(gy gyVar) {
        String strB = b(LxAdEmuiDevice.PROP_VERSION);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }

    private static gy a(String str) {
        if (str != null && str.length() > 0) {
            gy gyVar = gy.MIUI;
            if (str.equalsIgnoreCase(gyVar.a())) {
                if (a(gyVar)) {
                    return gyVar;
                }
            } else {
                gy gyVar2 = gy.Flyme;
                if (str.equalsIgnoreCase(gyVar2.a())) {
                    if (b(gyVar2)) {
                        return gyVar2;
                    }
                } else {
                    gy gyVar3 = gy.RH;
                    if (str.equalsIgnoreCase(gyVar3.a())) {
                        if (c(gyVar3)) {
                            return gyVar3;
                        }
                    } else {
                        gy gyVar4 = gy.ColorOS;
                        if (str.equalsIgnoreCase(gyVar4.a())) {
                            if (d(gyVar4)) {
                                return gyVar4;
                            }
                        } else {
                            gy gyVar5 = gy.FuntouchOS;
                            if (str.equalsIgnoreCase(gyVar5.a())) {
                                if (e(gyVar5)) {
                                    return gyVar5;
                                }
                            } else {
                                gy gyVar6 = gy.SmartisanOS;
                                if (str.equalsIgnoreCase(gyVar6.a())) {
                                    if (f(gyVar6)) {
                                        return gyVar6;
                                    }
                                } else {
                                    gy gyVar7 = gy.AmigoOS;
                                    if (str.equalsIgnoreCase(gyVar7.a())) {
                                        if (g(gyVar7)) {
                                            return gyVar7;
                                        }
                                    } else {
                                        gy gyVar8 = gy.EUI;
                                        if (str.equalsIgnoreCase(gyVar8.a())) {
                                            if (h(gyVar8)) {
                                                return gyVar8;
                                            }
                                        } else {
                                            gy gyVar9 = gy.Sense;
                                            if (str.equalsIgnoreCase(gyVar9.a())) {
                                                if (i(gyVar9)) {
                                                    return gyVar9;
                                                }
                                            } else {
                                                gy gyVar10 = gy.LG;
                                                if (str.equalsIgnoreCase(gyVar10.a())) {
                                                    if (j(gyVar10)) {
                                                        return gyVar10;
                                                    }
                                                } else {
                                                    gy gyVar11 = gy.Google;
                                                    if (str.equalsIgnoreCase(gyVar11.a())) {
                                                        if (k(gyVar11)) {
                                                            return gyVar11;
                                                        }
                                                    } else {
                                                        gy gyVar12 = gy.NubiaUI;
                                                        if (str.equalsIgnoreCase(gyVar12.a()) && l(gyVar12)) {
                                                            return gyVar12;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return gy.Other;
        }
        return gy.Other;
    }

    private static void a(gy gyVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String strGroup = matcher.group(1);
                gyVar.a(strGroup);
                gyVar.a(Integer.parseInt(strGroup.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(gy gyVar) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            return false;
        }
        String strB = b("ro.build.version.incremental");
        a(gyVar, strB);
        gyVar.b(strB);
        return true;
    }
}

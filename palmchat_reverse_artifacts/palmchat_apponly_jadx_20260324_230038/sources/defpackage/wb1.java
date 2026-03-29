package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21650a;
    public static String b;
    public static Boolean c;
    public static Boolean d;

    public static String a() {
        try {
            File file = new File("/proc/cpuinfo");
            if (!file.exists()) {
                return null;
            }
            String[] strArrSplit = new BufferedReader(new FileReader(file)).readLine().split(":\\s+", 2);
            for (int i = 0; i < strArrSplit.length; i++) {
                LogUtil.i("DeviceInfoLog", "getCpuArchFromCpuInfo " + i + ": " + strArrSplit[i]);
            }
            return strArrSplit[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b() {
        if (f21650a == null) {
            LogUtil.i("DeviceInfoLog", "process getName");
            e();
        }
        LogUtil.i("DeviceInfoLog", "getName" + f21650a);
        return f21650a;
    }

    public static String c(String str) {
        return sb1.c(str);
    }

    public static String d() {
        if (b == null) {
            LogUtil.i("DeviceInfoLog", "process getVersion");
            e();
        }
        LogUtil.i("DeviceInfoLog", "getVersion" + b);
        return b;
    }

    public static void e() {
        String strC = c("ro.miui.ui.version.name");
        b = strC;
        if (!TextUtils.isEmpty(strC)) {
            f21650a = LxAdOSUtils.ROM_MIUI;
            return;
        }
        String strC2 = c(LxAdEmuiDevice.PROP_VERSION);
        b = strC2;
        if (!TextUtils.isEmpty(strC2)) {
            f21650a = LxAdOSUtils.ROM_EMUI;
            return;
        }
        String strC3 = c(LxAdOppoDevice.PROP_VERSION);
        b = strC3;
        if (!TextUtils.isEmpty(strC3)) {
            f21650a = "OPPO";
            return;
        }
        String strC4 = c("ro.vivo.os.version");
        b = strC4;
        if (!TextUtils.isEmpty(strC4)) {
            f21650a = LxAdOSUtils.ROM_VIVO;
            return;
        }
        String strC5 = c("ro.smartisan.version");
        b = strC5;
        if (!TextUtils.isEmpty(strC5)) {
            f21650a = LxAdOSUtils.ROM_SMARTISAN;
            return;
        }
        String str = Build.DISPLAY;
        b = str;
        if (str.toUpperCase().contains(LxAdOSUtils.ROM_FLYME)) {
            f21650a = LxAdOSUtils.ROM_FLYME;
        } else {
            b = "unknown";
            f21650a = Build.MANUFACTURER.toUpperCase();
        }
    }

    public static boolean f() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null && str.contains("arm64")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g() {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (new File("/system/bin/app_process64").exists()) {
            d = Boolean.TRUE;
            LogUtil.d("DeviceInfoLog", "get arch by app_process64");
        } else {
            String strC = c("ro.product.cpu.abilist64");
            LogUtil.d("DeviceInfoLog", "get arch from property: " + strC);
            if (TextUtils.isEmpty(strC)) {
                String property = System.getProperty("java.library.path");
                if (TextUtils.isEmpty(property)) {
                    try {
                        strC = a();
                    } catch (Exception unused) {
                    }
                    if (TextUtils.isEmpty(strC)) {
                        d = Boolean.FALSE;
                    } else {
                        d = Boolean.valueOf(strC.toLowerCase().contains("arch64"));
                    }
                } else {
                    String[] strArrSplit = property.split(":");
                    if (strArrSplit == null) {
                        strArrSplit = new String[]{property};
                    }
                    int i = 0;
                    while (true) {
                        if (i < strArrSplit.length) {
                            if (strArrSplit[i].endsWith("lib64")) {
                                d = Boolean.TRUE;
                                LogUtil.d("DeviceInfoLog", "get arch from property: java.library.path");
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                d = Boolean.valueOf(strC.toLowerCase().contains("arm64"));
            }
        }
        return d.booleanValue();
    }

    public static boolean h() {
        if (c == null) {
            LogUtil.i("DeviceInfoLog", "process isHarmony");
            c = Boolean.valueOf(i());
        }
        LogUtil.i("DeviceInfoLog", "isHarmony" + c);
        return c.booleanValue();
    }

    public static boolean i() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}

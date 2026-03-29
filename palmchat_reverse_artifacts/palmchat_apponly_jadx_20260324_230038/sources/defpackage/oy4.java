package defpackage;

import android.os.Environment;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdMiuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oy4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19900a = null;
    public static String b = null;
    public static int c = -1;

    public static String a() {
        if (!TextUtils.isEmpty(f19900a)) {
            return f19900a;
        }
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            String property = properties.getProperty("ro.miui.ui.version.name", null);
            b = property;
            if (property != null || properties.getProperty(LxAdMiuiDevice.PROP_VERSION, null) != null || properties.getProperty("ro.miui.internal.storage", null) != null) {
                f19900a = LxAdOSUtils.ROM_MIUI;
            } else if (properties.getProperty("ro.build.hw_emui_api_level", null) != null || properties.getProperty(LxAdEmuiDevice.PROP_VERSION, null) != null || properties.getProperty("ro.confg.hw_systemversion", null) != null) {
                f19900a = LxAdOSUtils.ROM_EMUI;
            } else if (properties.getProperty(LxAdOppoDevice.PROP_VERSION, null) != null) {
                f19900a = "OPPO";
            } else if (properties.getProperty("ro.vivo.os.version", null) != null) {
                f19900a = LxAdOSUtils.ROM_VIVO;
            }
        } catch (IOException unused) {
        }
        if (TextUtils.isEmpty(f19900a)) {
            f19900a = ny4.b();
        }
        if (TextUtils.isEmpty(f19900a)) {
            f19900a = b.m;
        }
        return f19900a;
    }

    public static boolean b() {
        if (c == -1) {
            String strC = ny4.c(LxAdEmuiDevice.PROP_VERSION);
            if (ny4.c("ro.build.version.magic") != null) {
                c = 1;
            } else if (strC == null || !strC.startsWith("MagicOS")) {
                c = 2;
            } else {
                c = 1;
            }
        }
        return c == 1;
    }

    public static boolean c() {
        return TextUtils.equals(a(), LxAdOSUtils.ROM_VIVO);
    }
}

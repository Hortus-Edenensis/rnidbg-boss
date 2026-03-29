package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mh7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f19219a = "sony";
    public static final CharSequence b = "amigo";
    public static final CharSequence c = "funtouch";

    public static boolean a() {
        return !TextUtils.isEmpty(n("ro.letv.release.version"));
    }

    public static String b() {
        return n(LxAdVivoDevice.PROP_VERSION) + "_" + n("ro.vivo.product.version");
    }

    public static boolean c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean d() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(b);
    }

    public static String e() {
        if (!ad7.b()) {
            return "";
        }
        return "miui_" + n("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String f() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean g() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String h() {
        if (!a()) {
            return "";
        }
        return "eui_" + n("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String i() {
        return n("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean j() {
        String strN = n(LxAdVivoDevice.PROP_VERSION);
        return !TextUtils.isEmpty(strN) && strN.toLowerCase(Locale.getDefault()).contains(c);
    }

    public static String k() {
        if (!g()) {
            return "";
        }
        return "coloros_" + n(LxAdOppoDevice.PROP_VERSION) + "_" + Build.DISPLAY;
    }

    public static String l() {
        String strE = ad7.e();
        if (strE == null || !strE.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return strE + "_" + Build.DISPLAY;
    }

    public static String m() {
        if (ad7.b()) {
            return e();
        }
        if (ad7.a()) {
            return f();
        }
        if (g()) {
            return k();
        }
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            return strL;
        }
        if (j()) {
            return b();
        }
        if (d()) {
            return o();
        }
        if (c()) {
            return i();
        }
        String strH = h();
        return !TextUtils.isEmpty(strH) ? strH : Build.DISPLAY;
    }

    public static String n(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
                xe7.a(bufferedReader);
                return line;
            } catch (Throwable unused) {
                xe7.a(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String o() {
        return Build.DISPLAY + "_" + n("ro.gn.sv.version");
    }
}

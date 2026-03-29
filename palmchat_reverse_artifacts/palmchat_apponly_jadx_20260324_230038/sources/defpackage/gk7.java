package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import com.wifi.adsdk.utils.LxAdVivoDevice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gk7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f17744a = "sony";
    public static final CharSequence b = "amigo";
    public static final CharSequence c = "funtouch";

    public static String a() {
        if (i77.f()) {
            return k();
        }
        if (i77.h()) {
            return m();
        }
        if (n()) {
            return o();
        }
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            return strL;
        }
        if (f()) {
            return e();
        }
        if (g()) {
            return h();
        }
        if (d()) {
            return c();
        }
        String strI = i();
        return !TextUtils.isEmpty(strI) ? strI : Build.DISPLAY;
    }

    public static String b(String str) {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            Process processExec = Runtime.getRuntime().exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader2.readLine();
                processExec.destroy();
                wf7.a(bufferedReader2);
                return line;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                wf7.a(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String c() {
        return b("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String e() {
        return b(LxAdVivoDevice.PROP_VERSION) + "_" + b("ro.vivo.product.version");
    }

    public static boolean f() {
        String strB = b(LxAdVivoDevice.PROP_VERSION);
        return !TextUtils.isEmpty(strB) && strB.toLowerCase(Locale.getDefault()).contains(c);
    }

    public static boolean g() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(b);
    }

    public static String h() {
        return Build.DISPLAY + "_" + b("ro.gn.sv.version");
    }

    public static String i() {
        if (!j()) {
            return "";
        }
        return "eui_" + b("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean j() {
        return !TextUtils.isEmpty(b("ro.letv.release.version"));
    }

    public static String k() {
        if (!i77.f()) {
            return "";
        }
        return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String l() {
        String strA = i77.a();
        if (strA == null || !strA.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return strA + "_" + Build.DISPLAY;
    }

    public static String m() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean n() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String o() {
        if (!n()) {
            return "";
        }
        return "coloros_" + b(LxAdOppoDevice.PROP_VERSION) + "_" + Build.DISPLAY;
    }
}

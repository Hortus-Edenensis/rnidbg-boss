package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.u.nr.x.nr;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ad7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1213a = false;

    public static boolean a() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean b() {
        if (!f1213a) {
            try {
                Class.forName("miui.os.Build");
                nr.f5442a = true;
                f1213a = true;
                return true;
            } catch (Exception unused) {
                f1213a = true;
            }
        }
        return nr.f5442a;
    }

    public static String c(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            bufferedReader.close();
            xe7.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            xe7.a(bufferedReader);
            return line;
        }
    }

    public static boolean d() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String e() {
        return c(LxAdEmuiDevice.PROP_VERSION);
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            str = e();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return d();
        }
        return true;
    }
}

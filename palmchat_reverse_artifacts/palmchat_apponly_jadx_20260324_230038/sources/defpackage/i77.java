package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.j.e;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i77 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f18119a = false;
    public static int b = -1;
    public static final Pattern c = Pattern.compile("^0-([\\d]+)$");

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f18120a = Pattern.compile("^cpu[\\d]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f18120a.matcher(str).matches();
        }
    }

    public static String a() {
        return c(LxAdEmuiDevice.PROP_VERSION);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return d();
        }
        return true;
    }

    public static String c(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            bufferedReader.close();
            wf7.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            wf7.a(bufferedReader);
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

    public static int e(String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        int iG = g(line);
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                        return iG;
                    }
                    bufferedReader2.close();
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        return -1;
                    }
                    bufferedReader.close();
                }
            } catch (Throwable unused3) {
            }
            return -1;
        } catch (IOException unused4) {
            return -1;
        }
    }

    public static boolean f() {
        if (!f18119a) {
            try {
                Class.forName("miui.os.Build");
                e.f3291a = true;
                f18119a = true;
                return true;
            } catch (Exception unused) {
                f18119a = true;
            }
        }
        return e.f3291a;
    }

    public static int g(String str) {
        Matcher matcher = c.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static boolean h() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int i() {
        int i = b;
        if (i > 0) {
            return i;
        }
        int iE = e("/sys/devices/system/cpu/possible");
        if (iE <= 0) {
            iE = e("/sys/devices/system/cpu/present");
        }
        if (iE <= 0) {
            iE = j("/sys/devices/system/cpu/");
        }
        if (iE <= 0) {
            iE = Runtime.getRuntime().availableProcessors();
        }
        if (iE <= 0) {
            iE = 1;
        }
        b = iE;
        return iE;
    }

    public static int j(String str) {
        try {
            File[] fileArrListFiles = new File(str).listFiles(new a());
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return -1;
            }
            return fileArrListFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}

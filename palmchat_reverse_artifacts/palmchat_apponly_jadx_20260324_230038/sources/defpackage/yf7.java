package defpackage;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class yf7 {
    public static long a() {
        try {
            if (k()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long b() {
        try {
            return i(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long c(Context context) {
        File fileU;
        try {
            if (!k() || (fileU = nr.u(context, null)) == null) {
                return 0L;
            }
            return d(fileU.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long d(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jD = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jD += file2.isDirectory() ? d(file2) : file2.length();
        }
        return jD;
    }

    public static long e() {
        try {
            return g(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long f(Context context) {
        try {
            return d(nr.u(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long g(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long h() {
        try {
            if (k()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long i(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", f(context));
            jSONObject.put("inner_free", e());
            jSONObject.put("inner_total", b());
            jSONObject.put("sdcard_app_used", c(context));
            jSONObject.put("sdcard_free", a());
            jSONObject.put("sdcard_total", h());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static boolean k() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}

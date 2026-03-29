package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class vh7 {
    @SuppressLint({"SdCardPath"})
    public static String a(@NonNull Context context) {
        String path;
        try {
            if (nr.u(context) != null) {
                path = nr.u(context).getPath();
            } else {
                File fileU = nr.u(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = fileU != null ? fileU.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception unused) {
            return "/sdcard/";
        }
    }

    public static File b(@NonNull Context context) {
        return new File(a(context), "crash_history");
    }

    public static String c() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static File d(@NonNull Context context) {
        return new File(a(context), "CrashLogJava");
    }

    public static String e() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }
}

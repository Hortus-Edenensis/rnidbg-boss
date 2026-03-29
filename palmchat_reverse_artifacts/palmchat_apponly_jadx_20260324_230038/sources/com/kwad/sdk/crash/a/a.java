package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static Context aMG;
    private static String aTS;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File Ns() {
        File file;
        if (TextUtils.isEmpty(aTS)) {
            Context contextEX = aMG;
            if (contextEX == null) {
                contextEX = ServiceProvider.Re();
            }
            if (contextEX == null) {
                try {
                    contextEX = z.EX();
                } catch (Throwable unused) {
                }
            }
            file = contextEX != null ? new File(getDataDir(contextEX), "kwad_ex") : null;
        } else {
            file = new File(aTS);
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Nt() {
        return new File(Ns(), "java_crash/dump");
    }

    public static File Nu() {
        return new File(Ns(), "anr_log/dump");
    }

    public static File Nv() {
        return new File(Ns(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        aMG = context;
        aTS = str;
        aTS = w.R(context, "kwad_ex");
    }
}

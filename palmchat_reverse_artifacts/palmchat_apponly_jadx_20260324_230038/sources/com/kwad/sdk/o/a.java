package com.kwad.sdk.o;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class a {
    private static File ayt;

    private static File bj(Context context) {
        if (ayt == null) {
            ayt = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return ayt;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.isDirectory();
        }
        return file;
    }

    private static String v(Context context, String str) {
        return i(new File(bj(context), "apk-" + str)).getPath();
    }

    public static String x(Context context, String str) {
        File file = new File(v(context, str), "dynamic.apk");
        return file.exists() ? file.getPath() : new File(v(context, str), "dynamic_apk").getPath();
    }
}

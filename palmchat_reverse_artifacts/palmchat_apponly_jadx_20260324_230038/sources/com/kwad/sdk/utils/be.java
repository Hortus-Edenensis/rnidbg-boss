package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class be {
    private static String bfn;
    private static File bfo;

    private static boolean Tm() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String dP(Context context) {
        if (!TextUtils.isEmpty(bfn)) {
            return bfn;
        }
        String path = null;
        if (Tm()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    path = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getFilesDir().getPath();
        }
        String str = path + File.separator + "ksadsdk";
        bfn = str;
        return str;
    }

    public static File dQ(Context context) {
        File file = bfo;
        if (file != null) {
            return file;
        }
        String path = null;
        if (Tm()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    path = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getCacheDir().getPath();
        }
        File file2 = new File(path + File.separator + "ksadsdk");
        bfo = file2;
        if (!file2.exists()) {
            bfo.mkdirs();
        }
        return bfo;
    }

    public static File dR(Context context) {
        File file = new File(dP(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dS(Context context) {
        File file = new File(dP(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dT(Context context) {
        String strDP;
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            strDP = dP(context);
        } else {
            strDP = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(strDP + File.separator + "ksadlog");
    }

    public static String dU(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return "";
        }
        return filesDir.getPath() + File.separator + "ksadsdk";
    }

    public static String dV(Context context) {
        return dQ(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String strDU = dU(context);
        StringBuilder sb = new StringBuilder();
        sb.append(strDU);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ksad/download/js");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return dU(context) + File.separator + "ksad/download/js";
    }
}

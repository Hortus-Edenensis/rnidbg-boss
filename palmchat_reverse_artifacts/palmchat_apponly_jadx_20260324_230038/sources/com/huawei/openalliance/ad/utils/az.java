package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class az {
    private static final String Code = "StoUtils";

    public static String B(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return u.V(externalCacheDir);
            }
            return null;
        } catch (Exception unused) {
            fh.I(Code, "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    public static String Code(Context context) {
        String strI;
        return (!V() || (strI = I(context)) == null) ? V(context) : strI;
    }

    public static String I(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return u.V(externalFilesDir);
            }
        } catch (Exception unused) {
            fh.I(Code, "getExternalFilesDir exception, use memory card folder.");
        }
        return null;
    }

    public static String V(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : u.V(filesDir);
    }

    public static String Z(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : u.V(cacheDir);
    }

    public static boolean Code() {
        try {
            if (bg.Code()) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        } catch (Throwable th) {
            fh.I(Code, "isExternalStorageRemovable, " + th.getClass().getSimpleName());
            return true;
        }
    }

    private static boolean V() {
        return TextUtils.equals("mounted", Environment.getExternalStorageState()) || !Code();
    }
}

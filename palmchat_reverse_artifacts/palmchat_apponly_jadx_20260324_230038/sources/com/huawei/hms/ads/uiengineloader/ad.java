package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6613a = "dl_FileUtil";

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a(context.createDeviceProtectedStorageContext().getDataDir());
        }
        String strA = a(context.getFilesDir());
        int iLastIndexOf = strA.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? strA : strA.substring(0, iLastIndexOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str) {
        boolean z;
        boolean z2 = true;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (!file.isDirectory() || list == null || list.length <= 0) {
                z = true;
            } else {
                z = true;
                for (String str2 : list) {
                    try {
                        if (z) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(File.separator);
                            sb.append(str2);
                            z = b(sb.toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                        af.b(f6613a, " delete err: " + th.getClass().getSimpleName());
                        return z2;
                    }
                }
            }
            if (z) {
                if (file.delete()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? str : str.substring(0, iLastIndexOf);
    }

    public static String a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            af.d(f6613a, "getFilePath Exception: " + e.getMessage());
            return null;
        }
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            af.d(f6613a, "makeDirectory Exception: " + e.getMessage());
            return false;
        }
    }
}

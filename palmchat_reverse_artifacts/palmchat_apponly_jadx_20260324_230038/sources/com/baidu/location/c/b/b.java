package com.baidu.location.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements a {
    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context) {
        String path;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            path = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().getPath() : null;
        }
        if (path == null && Build.VERSION.SDK_INT > 28 && context != null) {
            try {
                path = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            } catch (Exception unused) {
                path = null;
            }
        }
        if (path != null) {
            try {
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return path;
    }

    public static String a(Context context) {
        String strB = b(context);
        if (strB == null) {
            return null;
        }
        return strB + "/baidu/tempdata";
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            if (a.c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

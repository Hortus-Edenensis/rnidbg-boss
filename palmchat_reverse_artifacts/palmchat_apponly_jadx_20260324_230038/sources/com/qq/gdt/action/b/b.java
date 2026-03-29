package com.qq.gdt.action.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10463a;
    private static String b;

    public static String a(Context context) {
        if (f10463a == null) {
            c(context);
        }
        return f10463a;
    }

    public static String b(Context context) {
        if (b == null) {
            c(context);
        }
        return b;
    }

    public static void c(Context context) {
        if (f10463a == null || b == null) {
            try {
                File file = new File(d(context));
                b = c.a(file, -2012129808);
                String strA = c.a(file, -2012129793);
                f10463a = strA;
                if (strA == "") {
                    f10463a = f.a(file);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String d(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

package com.qq.gdt.action.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.core.content.ContextCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f10534a = {com.kuaishou.weapon.p0.g.c, com.kuaishou.weapon.p0.g.j};
    private static String[] b = {com.kuaishou.weapon.p0.g.f7481a, com.kuaishou.weapon.p0.g.b, com.kuaishou.weapon.p0.g.c, com.kuaishou.weapon.p0.g.j};

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            String[] strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
            if (strArr == null || strArr.length <= 0) {
                return false;
            }
            return Arrays.asList(strArr).containsAll(Arrays.asList(b));
        } catch (Exception e) {
            o.b(e.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        for (String str : f10534a) {
            if (!a(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        Class<ContextCompat> cls;
        Class<ContextCompat> cls2 = ContextCompat.class;
        try {
            int i = ContextCompat.f1266a;
            cls = cls2;
        } catch (Exception unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                int i2 = ContextCompat.f1266a;
            } catch (Exception unused2) {
                cls2 = cls;
            }
        } else {
            cls2 = cls;
        }
        try {
            if (cls2 == null) {
                o.a("PermissionUtil contextCompat is null", new Object[0]);
                return true;
            }
            if (((Integer) cls2.getMethod("checkSelfPermission", Context.class, String.class).invoke(null, context, str)).intValue() == 0) {
                return true;
            }
            o.a("请在AndroidManifest.xml文件中添加:\n<uses-permission android:name=\"" + str + "\" />", new Object[0]);
            return false;
        } catch (Exception e) {
            o.b("Exception while check has permission " + str, e);
            return true;
        }
    }
}

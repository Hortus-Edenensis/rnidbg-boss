package com.bytedance.sdk.openadsdk.core.h;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import com.bytedance.sdk.component.utils.k;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx {
    private static final String u = "fx";

    private fx() {
    }

    private static boolean fx(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean nr(Context context, String str) {
        byte b;
        int iCheckOp;
        String str2 = u;
        k.nr(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        boolean z = true;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode == -1888586689) {
                if (str.equals(g.g)) {
                    b = 1;
                }
                if (b != 0) {
                }
                iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
                k.nr(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
                if (iCheckOp == 0) {
                }
            } else if (iHashCode != -63024214) {
                b = (iHashCode == -5573545 && str.equals(g.c)) ? (byte) 2 : (byte) -1;
                String lowerCase = b != 0 ? b != 1 ? b != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state" : "android:fine_location" : "android:coarse_location";
                iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
                k.nr(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
                if (iCheckOp == 0) {
                    return true;
                }
                try {
                    k.nr(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                    return false;
                } catch (Exception e) {
                    e = e;
                    z = false;
                }
            } else {
                if (str.equals(g.h)) {
                    b = 0;
                }
                if (b != 0) {
                }
                iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
                k.nr(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
                if (iCheckOp == 0) {
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        k.nr(u, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)));
        return z;
    }

    public static boolean u(Context context, String str) {
        return nr(context, str);
    }
}

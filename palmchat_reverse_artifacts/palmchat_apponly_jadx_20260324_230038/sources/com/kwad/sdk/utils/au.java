package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class au {
    private static Map<String, Integer> bfa;
    private static Set<String> bfb;
    private static Method bfc;

    static {
        HashSet hashSet = new HashSet();
        bfb = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        bfb.add("android.permission.WRITE_SETTINGS");
        bfb.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int aw(Context context, String str) {
        int iAx;
        if (bfa == null) {
            h(y.cW(context));
        }
        if (bfb.contains(str) && (iAx = ax(context, str)) != -2) {
            return iAx;
        }
        int iAy = ay(context, str);
        if (iAy != -2) {
            return iAy;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return iAy;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int ax(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.WRITE_SETTINGS":
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.System.canWrite(context)) {
                        }
                    } catch (Throwable unused) {
                        return -2;
                    }
                }
                break;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.canDrawOverlays(context)) {
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return -2;
                    }
                }
                break;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                if (Build.VERSION.SDK_INT >= 26) {
                    if (y.cV(context)) {
                    }
                }
                break;
        }
        return 0;
    }

    private static int ay(Context context, String str) {
        if (bfa == null || str == null || !bfa.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = bfa.get(str);
            if (num == null) {
                return -2;
            }
            if (bfc == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                bfc = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) bfc.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    public static boolean dw(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        bfa = new HashMap();
        for (String str : strArr) {
            try {
                int iIntValue = ((Integer) z.c(AppOpsManager.class, AssistPushConsts.OPPO_PREFIX + hx(str))).intValue();
                if (iIntValue >= 0) {
                    bfa.put(str, Integer.valueOf(iIntValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String hx(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }
}

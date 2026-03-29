package com.huawei.hms.ads.uiengineloader;

import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.os.Build;
import com.huawei.hms.framework.common.EmuiUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6625a = 27;
    private static final String b = "DeviceUtil";

    public static String a(String str) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("android.os.SystemProperties");
                }
            } else {
                cls = Class.forName("android.os.SystemProperties");
            }
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            af.c(b, "getSystemProperties Exception:" + th.getClass().getSimpleName());
            return null;
        }
    }

    private static boolean b() {
        if (!a()) {
            String strA = a(com.huawei.hms.ads.dynamic.a.s);
            if (!(!TextUtils.isEmpty(strA) && strA.startsWith(com.huawei.hms.ads.dynamic.a.t))) {
                return false;
            }
        }
        return true;
    }

    private static boolean c() {
        String strA = a(com.huawei.hms.ads.dynamic.a.s);
        return !TextUtils.isEmpty(strA) && strA.startsWith(com.huawei.hms.ads.dynamic.a.t);
    }

    private static boolean d() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            af.d(b, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a() {
        boolean z;
        boolean z2 = false;
        try {
            String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI")) {
                String str2 = android.os.Build.MANUFACTURER;
                if (str2.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR")) {
                    z = true;
                    if (!z) {
                        return z;
                    }
                    try {
                        if (((Integer) Class.forName(EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get(null)).intValue() > 0) {
                            z2 = true;
                        }
                    } catch (Throwable th) {
                        z2 = z;
                        th = th;
                        af.d(b, "isHuaweiPhone Error:" + th.getClass().getSimpleName());
                    }
                } else {
                    if (!str2.equalsIgnoreCase("HONOR")) {
                        z = false;
                    }
                    if (!z) {
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z2;
    }
}

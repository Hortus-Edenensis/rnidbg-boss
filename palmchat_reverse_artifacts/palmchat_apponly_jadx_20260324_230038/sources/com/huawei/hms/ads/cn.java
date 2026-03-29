package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.os.Build;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.openalliance.ad.utils.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cn {
    private static final byte[] B = new byte[0];
    private static final String Code = "DeviceManager";
    private static final String I = "02";
    private static final String V = "ro.build.2b2c.partner.ext_channel";
    private static volatile cy Z;

    public static boolean B(Context context) {
        return V(context) || Code();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean C(Context context) {
        StringBuilder sb;
        String str;
        boolean z;
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(context.getApplicationContext());
        String strZ = atVarCode.Z();
        if (!TextUtils.isEmpty(strZ)) {
            return TextUtils.equals(String.valueOf(true), strZ);
        }
        boolean z2 = false;
        try {
            String str2 = Build.BRAND;
            if (!str2.equalsIgnoreCase("HUAWEI")) {
                String str3 = Build.MANUFACTURER;
                if (str3.equalsIgnoreCase("HUAWEI") || str2.equalsIgnoreCase("HONOR")) {
                    z = true;
                    if (!z) {
                        try {
                            z = ((Integer) Class.forName(d.I() ? "com.hihonor.android.os.Build$VERSION" : EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get(null)).intValue() > 0;
                        } catch (RuntimeException e) {
                            z2 = z;
                            e = e;
                            sb = new StringBuilder();
                            str = "isHuaweiPhone RuntimeException:";
                            sb.append(str);
                            sb.append(e.getClass().getSimpleName());
                            fh.Z(Code, sb.toString());
                        } catch (Throwable th) {
                            z2 = z;
                            e = th;
                            sb = new StringBuilder();
                            str = "isHuaweiPhone Error:";
                            sb.append(str);
                            sb.append(e.getClass().getSimpleName());
                            fh.Z(Code, sb.toString());
                        }
                    }
                    z2 = z;
                } else {
                    if (!str3.equalsIgnoreCase("HONOR")) {
                        z = false;
                    }
                    if (!z) {
                    }
                    z2 = z;
                }
            }
        } catch (RuntimeException e2) {
            e = e2;
        } catch (Throwable th2) {
            e = th2;
        }
        atVarCode.V(z2);
        return z2;
    }

    public static cy Code(Context context) {
        if (Z == null) {
            synchronized (B) {
                if (Z == null) {
                    Z = I(context) ? cv.V(context) : Z(context) ? ct.V(context) : Code() ? cs.V(context) : cx.V(context);
                }
            }
        }
        return Z;
    }

    public static boolean I(Context context) {
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(context);
        String strL = atVarCode.L();
        if (!TextUtils.isEmpty(strL)) {
            return TextUtils.equals(String.valueOf(true), strL);
        }
        boolean z = V(context) && !Z(context);
        atVarCode.Z(z);
        return z;
    }

    public static boolean V(Context context) {
        return C(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Z(Context context) {
        com.huawei.openalliance.ad.utils.at atVarCode = com.huawei.openalliance.ad.utils.at.Code(context);
        String strA = atVarCode.a();
        boolean z = true;
        if (!TextUtils.isEmpty(strA)) {
            return TextUtils.equals(String.valueOf(true), strA);
        }
        boolean z2 = false;
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                z = false;
                z2 = z;
            } else {
                if (Build.VERSION.MAGIC_SDK_INT < 33) {
                }
                z2 = z;
            }
        } catch (Throwable th) {
            fh.Z(Code, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
        }
        atVarCode.B(z2);
        return z2;
    }

    private static boolean Code() {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code("ro.build.2b2c.partner.ext_channel");
        return !TextUtils.isEmpty(strCode) && strCode.startsWith("02");
    }
}

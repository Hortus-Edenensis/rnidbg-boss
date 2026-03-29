package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cx extends cp {
    private static final int B = 32;
    private static final int C = 8;
    private static final byte[] F = new byte[0];
    public static final String I = "CN";
    private static cy S = null;
    private static final String Z = "ThirdDeviceImpl";

    public cx(Context context) {
        super(context);
    }

    private static cy I(Context context) {
        cy cyVar;
        synchronized (F) {
            if (S == null) {
                S = new cx(context);
            }
            cyVar = S;
        }
        return cyVar;
    }

    public static cy V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public int Code(View view) {
        int identifier;
        DisplayCutout displayCutout;
        int dimensionPixelSize = -1;
        if (view == null) {
            return -1;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && view.getRootWindowInsets() != null && (displayCutout = view.getRootWindowInsets().getDisplayCutout()) != null) {
                List boundingRects = displayCutout.getBoundingRects();
                if (!com.huawei.openalliance.ad.utils.ag.Code(boundingRects)) {
                    dimensionPixelSize = ((Rect) boundingRects.get(0)).height();
                }
            }
            if (dimensionPixelSize < 0 && (identifier = this.Code.getResources().getIdentifier("notch_height", "dimen", "android")) > 0) {
                dimensionPixelSize = this.Code.getResources().getDimensionPixelSize(identifier);
            }
            if (dimensionPixelSize >= 0) {
                return dimensionPixelSize;
            }
            int identifier2 = this.Code.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier2 > 0) {
                dimensionPixelSize = this.Code.getResources().getDimensionPixelSize(identifier2);
            }
            if (dimensionPixelSize == 0) {
                return 110;
            }
            return dimensionPixelSize;
        } catch (Throwable th) {
            fh.V(Z, "getNotchHeight err: %s", th.getClass().getSimpleName());
            return dimensionPixelSize;
        }
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code() {
        return "CN".equalsIgnoreCase(eh.Code(this.Code).Y());
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean V() {
        return Code();
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code(Context context) {
        String str;
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Throwable th) {
            fh.I(Z, "isNotchEnable mi Throwable:" + th.getClass().getSimpleName());
        }
        boolean zHasSystemFeature = ((Integer) cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "ro.miui.notch", 0)).intValue() != 0;
        fh.Code(Z, "isNotchEnable xiaomi, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        if (!zHasSystemFeature) {
            try {
                zHasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            } catch (Throwable th2) {
                fh.I(Z, "isNotchEnable oppo Throwable:" + th2.getClass().getSimpleName());
            }
        }
        fh.Code(Z, "isNotchEnable oppo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        if (!zHasSystemFeature) {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                Method method = clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE);
                ((Boolean) method.invoke(clsLoadClass, 32)).booleanValue();
                zHasSystemFeature = ((Boolean) method.invoke(clsLoadClass, 8)).booleanValue();
            } catch (ClassNotFoundException unused) {
                str = "hasNotchAtVivo ClassNotFoundException";
                fh.Z("Notch", str);
            } catch (NoSuchMethodException unused2) {
                str = "hasNotchAtVivo NoSuchMethodException";
                fh.Z("Notch", str);
            } catch (Exception unused3) {
                str = "hasNotchAtVivo Exception";
                fh.Z("Notch", str);
            }
        }
        fh.Code(Z, "isNotchEnable vivo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        return zHasSystemFeature;
    }
}

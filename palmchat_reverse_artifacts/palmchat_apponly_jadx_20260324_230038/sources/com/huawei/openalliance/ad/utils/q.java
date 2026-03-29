package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.app.PackageManagerEx;
import com.huawei.hms.ads.co;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class q {
    static final String B = "CN";
    private static final String C = "DeviceUtil";
    static final String Code = "content";
    private static final int D = 1;
    private static final float F = 1.5f;
    static final String I = "/switch/query";
    private static final int L = 7;
    private static final String S = "com.huawei.hardware.screen.type.eink";
    static final String V = "com.huawei.hwid.pps.apiprovider";
    static final String Z = "isSwitchChecked";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6961a = 2;

    public static boolean B(Context context) {
        return "1".equalsIgnoreCase(p.Code(context).Code());
    }

    public static boolean C(Context context) {
        return "0".equalsIgnoreCase(p.Code(context).Code());
    }

    public static String Code() {
        String strCode = bg.Code("ro.product.model");
        return TextUtils.isEmpty(strCode) ? Build.MODEL : strCode;
    }

    public static int D(Context context) {
        return ((float) d.B(context)) / ((float) d.Z(context)) > F ? 2 : 1;
    }

    public static boolean F(Context context) {
        int iD;
        try {
            iD = co.Code(context).S();
        } catch (Throwable th) {
            iD = D(context);
            fh.I(C, "getFoldableStatus %s", th.getClass().getSimpleName());
        }
        return iD == 1 || iD == 7;
    }

    public static int I(Context context) {
        at atVarCode = at.Code(context);
        if (atVarCode.S() != null) {
            return atVarCode.S().intValue();
        }
        int I2 = p.Code(context).I();
        atVarCode.Code(I2);
        return I2;
    }

    public static Context L(Context context) {
        return V() ? context.createDeviceProtectedStorageContext() : context;
    }

    public static boolean S(Context context) {
        try {
            return d.I() ? HwFoldScreenManagerEx.isFoldable() : com.huawei.android.fsm.HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable th) {
            fh.I(C, "isFoldablePhone exception: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean Z(Context context) {
        boolean z;
        boolean zBooleanValue;
        at atVarCode = at.Code(context);
        try {
            if (atVarCode.F() != null) {
                zBooleanValue = atVarCode.F().booleanValue();
            } else {
                zBooleanValue = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1) != null;
                try {
                    atVarCode.Code(Boolean.valueOf(zBooleanValue));
                } catch (Throwable th) {
                    z = zBooleanValue;
                    th = th;
                    fh.I(C, "getHasAccAndRotate err: %s", th.getClass().getSimpleName());
                    return z;
                }
            }
            return zBooleanValue;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    public static void Code(final at atVar, final Context context) {
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.q.1
            @Override // java.lang.Runnable
            public void run() {
                Uri uriBuild = new Uri.Builder().scheme("content").authority(q.V).path(q.I).build();
                if (!z.Code(context, uriBuild)) {
                    fh.I(q.C, "provider uri invalid.");
                    return;
                }
                Cursor cursorQuery = null;
                try {
                    cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        fh.I(q.C, "loc_tag isBaseLocationSwitch, cursor is null");
                    } else {
                        try {
                            atVar.Code(Boolean.TRUE.toString().equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(q.Z))));
                            cursorQuery.close();
                            return;
                        } catch (Throwable unused) {
                            fh.Z(q.C, "loc_tag isBaseLocationSwitch Exception");
                        }
                    }
                } catch (Throwable th) {
                    try {
                        fh.Z(q.C, "loc_tag isBaseLocationSwitch query error: " + th.getClass().getSimpleName());
                        if (cursorQuery != null) {
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                atVar.Code(false);
            }
        });
    }

    public static boolean I() {
        try {
            return PackageManagerEx.hasHwSystemFeature(S);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean V(Context context) {
        at atVarCode = at.Code(context);
        if (atVarCode.B() != null) {
            return atVarCode.B().booleanValue();
        }
        boolean zV = p.Code(context).V();
        atVarCode.I(zV);
        return zV;
    }

    public static boolean Code(Context context) {
        at atVarCode = at.Code(context);
        boolean zV = atVarCode.V();
        Code(atVarCode, context);
        return zV;
    }
}

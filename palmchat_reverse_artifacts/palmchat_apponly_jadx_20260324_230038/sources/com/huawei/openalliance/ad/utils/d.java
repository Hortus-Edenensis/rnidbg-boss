package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class d {
    private static final int B = 81;
    private static final int C = 90;
    private static final int Code = 32;
    private static final int D = 655;
    private static final int F = 720;
    private static final int I = 68;
    private static final int L = 632;
    private static final int S = 400;
    private static final int V = 50;
    private static final int Z = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6958a = 526;
    private static final int b = 432;
    private static final int c = 320;
    private static final int d = 468;
    private static final int e = 728;
    private static final float f = 0.15f;
    private static final float g = 0.12362637f;
    private static final float h = 0.12820514f;
    private static final float i = 0.15625f;
    private static final String j = "ex_splash_func_status";
    private static final String k = "ex_splash_list";
    private static final String l = "ex_splash_block_list";
    private static final String m = "d";

    public static int B(Context context) {
        if (context == null) {
            return 0;
        }
        int iCode = Code(context);
        int iV = V(context);
        return iCode > iV ? iCode : iV;
    }

    public static int C(Context context, int i2) {
        return i2 == 0 ? Z(context) : B(context);
    }

    public static int Code(int i2, int i3) {
        float f2;
        float f3;
        int iRound;
        int iMin = Math.min(90, Math.round(i3 * f));
        if (i2 > 432) {
            if (i2 <= f6958a) {
                iRound = 68;
            } else if (i2 <= 632) {
                f2 = i2;
                f3 = h;
            } else if (i2 <= 655) {
                iRound = 81;
            } else {
                f2 = i2;
                f3 = g;
            }
            return Math.max(Math.min(iRound, iMin), 50);
        }
        f2 = i2;
        f3 = i;
        iRound = Math.round(f2 * f3);
        return Math.max(Math.min(iRound, iMin), 50);
    }

    public static int D(Context context) {
        if (context == null) {
            return 0;
        }
        if (C(context).density == 0.0f) {
            return 0;
        }
        int I2 = z.I(context, r1.widthPixels);
        int iZ = Z(context, 0);
        if (I2 == 0 || iZ == 0) {
            return 0;
        }
        return Code(I2, iZ);
    }

    public static int F(Context context) {
        if (context == null) {
            return 0;
        }
        return z.V(context, D(context));
    }

    public static int I(Context context) {
        if (context == null) {
            return 0;
        }
        return z.I(context, Z(context));
    }

    public static boolean L(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), l);
                    if ((!TextUtils.isEmpty(string) && Arrays.asList(string.split(com.huawei.openalliance.ad.constant.x.aQ)).contains(packageName)) || Settings.Global.getInt(context.getContentResolver(), j, 0) == 0) {
                        return false;
                    }
                    String string2 = Settings.Global.getString(context.getContentResolver(), k);
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    return Arrays.asList(string2.split(com.huawei.openalliance.ad.constant.x.aQ)).contains(packageName);
                } catch (Throwable th) {
                    fh.I(m, "exception happen: " + th.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public static int S(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.heightPixels;
        float f3 = displayMetrics.density;
        int i2 = (int) (f2 / f3);
        return (int) ((i2 > F ? 90 : i2 > 400 ? 50 : 32) * f3);
    }

    public static int V(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).widthPixels;
    }

    public static int Z(Context context) {
        if (context == null) {
            return 0;
        }
        int iCode = Code(context);
        int iV = V(context);
        return iCode > iV ? iV : iCode;
    }

    public static float a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        } catch (RuntimeException | Exception unused) {
            fh.I(m, "getDensity fail");
            return 0.0f;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "secure_gesture_navigation", 0);
        } catch (Throwable th) {
            fh.I(m, "exception happen: " + th.getClass().getSimpleName());
            return 0;
        }
    }

    public static String c(Context context) {
        at atVarCode = at.Code(context);
        Code(atVarCode, context.getApplicationContext());
        return atVarCode.I();
    }

    public static Integer d(Context context) {
        Integer numB = at.Code(context).b();
        return numB == null ? e(context) : numB;
    }

    public static Integer e(final Context context) {
        final Integer numC = z.c(context);
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.2
            @Override // java.lang.Runnable
            public void run() {
                at.Code(context).Code(numC);
            }
        });
        return numC;
    }

    public static int B(Context context, int i2) {
        return i2 == 0 ? B(context) : Z(context);
    }

    public static DisplayMetrics C(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return displayMetrics;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int Code(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).heightPixels;
    }

    public static int I(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, C(context));
    }

    public static boolean S(Context context, int i2) {
        if (i2 != 1) {
            fh.Code(m, "ad type %s not support kit preload", Integer.valueOf(i2));
            return false;
        }
        if (!q.B(context) && !q.C(context)) {
            fh.Code(m, "kit preload only support phone or pad");
            return false;
        }
        if (!cn.B(context)) {
            fh.Code(m, "kit preload only support inner device");
            return false;
        }
        if (q.I()) {
            fh.Code(m, "kit preload not support eink");
            return false;
        }
        if (h.Code(context)) {
            return true;
        }
        fh.Code(m, "hms not installed");
        return false;
    }

    public static int V(Context context, int i2) {
        int I2 = z.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return z.V(context, I2 <= 432 ? 320 : I2 <= 632 ? d : e);
    }

    public static int Z(Context context, int i2) {
        Configuration configuration;
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetricsC = C(context);
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return Math.round(Code(displayMetricsC, configuration, i2, bg.I(context)) / displayMetricsC.density);
    }

    public static int Code(Context context, int i2) {
        int I2 = z.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return z.V(context, I2 <= 432 ? 50 : I2 <= 632 ? 60 : 90);
    }

    public static boolean I() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            Log.e(m, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }

    public static String V() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    private static int Code(DisplayMetrics displayMetrics, Configuration configuration, int i2, int i3) {
        if (i2 == 0) {
            i2 = configuration.orientation;
        }
        int i4 = displayMetrics.heightPixels;
        int i5 = displayMetrics.widthPixels;
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        return i2 == 1 ? i6 - i3 : i4;
    }

    public static String Code() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Code(String str) {
        byte b2 = 0;
        fh.Code(m, "convert content down method to downloadSource: %s", str);
        if (bc.Code(str)) {
            return "0";
        }
        switch (str.hashCode()) {
            case 50:
                b2 = !str.equals("2") ? (byte) -1 : (byte) 3;
                break;
            case 51:
                if (!str.equals("3")) {
                }
                break;
            case 52:
                if (str.equals("4")) {
                    b2 = 1;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b2 = 2;
                    break;
                }
                break;
        }
        return b2 != 0 ? (b2 == 1 || b2 == 2) ? "2" : "0" : "1";
    }

    private static void Code(final at atVar, final Context context) {
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.p, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            fh.V(d.m, "requestUuid failed");
                        } else {
                            fh.V(d.m, "requestUuid success");
                            atVar.Code(callResult.getData());
                        }
                    }
                }, String.class);
            }
        });
    }

    public static boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return false;
        }
        return z.Code(context, dVar.q());
    }
}

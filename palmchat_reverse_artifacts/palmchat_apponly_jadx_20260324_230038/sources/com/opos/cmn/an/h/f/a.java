package com.opos.cmn.an.h.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.opos.cmn.an.d.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f7793a;
    private static float b;
    private static float c;
    private static float d;
    private static float e;
    private static float f;
    private static int g;
    private static WindowManager h;
    private static float i;
    private static float j;
    private static final String k = "com." + com.opos.cmn.an.b.a.e + ".inner.view.WindowManagerWrapper";

    public static int a(Context context, float f2) {
        return context != null ? (int) ((f2 * l(context)) + 0.5f) : (int) f2;
    }

    public static int b(Context context) {
        return a(context, true)[0];
    }

    public static int c(Context context) {
        return a(context, true)[1];
    }

    public static boolean d(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                if (configuration.orientation != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return false;
        }
    }

    public static float e(Context context) {
        float f2 = d;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            d = n(context).density;
        }
        return d;
    }

    public static float f(Context context) {
        float f2 = b;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            b = o(context).density;
        }
        return b;
    }

    public static float g(Context context) {
        float f2 = e;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            e = n(context).scaledDensity;
        }
        return e;
    }

    public static float h(Context context) {
        float f2 = c;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            c = o(context).scaledDensity;
        }
        return c;
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            int iJ = j(context);
            if (iJ != 90) {
                return iJ != 180 ? iJ != 270 ? 0 : 90 : EffectConstants.ROTATION_DEGREES_180;
            }
            return 270;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static int j(Context context) {
        ?? r0 = "";
        int i2 = 0;
        if (context != null) {
            try {
                WindowManager windowManagerA = a(context);
                r0 = r0;
                if (windowManagerA != null) {
                    try {
                        int rotation = windowManagerA.getDefaultDisplay().getRotation();
                        r0 = 1;
                        if (rotation != 1) {
                            r0 = 2;
                            if (rotation != 2) {
                                r0 = 3;
                                r0 = 3;
                                if (rotation == 3) {
                                    i2 = 270;
                                }
                            } else {
                                i2 = EffectConstants.ROTATION_DEGREES_180;
                            }
                        } else {
                            i2 = 90;
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
                        r0 = r0;
                    }
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("WinMgrTool", r0, e3);
            }
        }
        return i2;
    }

    public static float k(Context context) {
        try {
            return c(context) / b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return 0.0f;
        }
    }

    public static float l(Context context) {
        float f2 = i;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && e(context) == f(context) && b(context) == 1080) {
                i = e(context) == 3.0f ? e(context) : 3.0f;
            } else {
                i = e(context);
            }
        }
        return i;
    }

    public static float m(Context context) {
        float f2 = j;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && g(context) == h(context) && b(context) == 1080) {
                j = g(context) == 3.0f ? g(context) : 3.0f;
            } else {
                j = g(context);
            }
        }
        return j;
    }

    private static DisplayMetrics n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "getAppDisplayMetrics", e2);
            return null;
        }
    }

    private static DisplayMetrics o(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Display defaultDisplay = a(context).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "getDisplayMetrics", e2);
                return context.getResources().getDisplayMetrics();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e3);
            return null;
        }
    }

    public static WindowManager a(Context context) {
        if (h == null && context != null) {
            h = (WindowManager) context.getApplicationContext().getSystemService("window");
        }
        return h;
    }

    public static int b(Context context, float f2) {
        return context != null ? (int) ((f2 / l(context)) + 0.5f) : (int) f2;
    }

    public static int c(Context context, float f2) {
        return context != null ? (int) ((f2 * m(context)) + 0.5f) : (int) f2;
    }

    public static void a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        try {
            WindowManager windowManagerA = a(context);
            if (windowManagerA != null) {
                windowManagerA.removeView(view);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static void a(Context context, View view, WindowManager.LayoutParams layoutParams) {
        if (context == null || view == null || layoutParams == null) {
            return;
        }
        try {
            WindowManager windowManagerA = a(context);
            if (windowManagerA != null) {
                windowManagerA.addView(view, layoutParams);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static boolean a() {
        return a(com.opos.cmn.an.b.a.f7732a);
    }

    public static boolean a(Activity activity) {
        if (activity != null) {
            try {
                return (activity.getWindow().getAttributes().flags & 1024) == 1024;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
                return false;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        try {
            if (b.a(str)) {
                return false;
            }
            String str2 = Build.BRAND;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = Build.MANUFACTURER;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = Build.MODEL;
            if (str4 == null) {
                str4 = "";
            }
            if (!str.equalsIgnoreCase(str2) && !str.equalsIgnoreCase(str3)) {
                if (b.a(str4)) {
                    return false;
                }
                if (!str4.toLowerCase().contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return false;
        }
    }

    private static int[] a(Context context, boolean z) {
        int i2;
        int i3;
        try {
            if (f7793a == null && context != null) {
                DisplayMetrics displayMetricsO = o(context);
                int[] iArr = new int[2];
                int i4 = displayMetricsO.widthPixels;
                int i5 = displayMetricsO.heightPixels;
                iArr[0] = i4 > i5 ? i5 : i4;
                if (i4 <= i5) {
                    i4 = i5;
                }
                iArr[1] = i4;
                f7793a = iArr;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
        if (f7793a == null) {
            return new int[]{-1, -1};
        }
        if (z || d(context)) {
            int[] iArr2 = f7793a;
            i2 = iArr2[0];
            i3 = iArr2[1];
        } else {
            int[] iArr3 = f7793a;
            i2 = iArr3[1];
            i3 = iArr3[0];
        }
        return new int[]{i2, i3};
    }
}

package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.q;
import com.opos.acs.st.STManager;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static boolean u;

    public static String b(Context context) {
        String language;
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? q.u(context).getConfiguration().getLocales().get(0) : Locale.getDefault();
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals(STManager.REGION_OF_TW)) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return u(language);
    }

    public static float fx(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        return f * pn(context);
    }

    public static int nr(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        float fPn = pn(context);
        if (fPn <= 0.0f) {
            fPn = 1.0f;
        }
        return (int) ((f / fPn) + 0.5f);
    }

    private static float pn(Context context) {
        try {
            if (u) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", new Class[0]).setAccessible(true);
                return ((Integer) r1.invoke(r0, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int u(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float u(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        return (f * pn(context)) + 0.5f;
    }

    public static int fx(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int nr(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int u(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String u(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}

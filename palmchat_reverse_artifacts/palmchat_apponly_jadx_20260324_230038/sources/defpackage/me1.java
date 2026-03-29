package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import com.zenmen.palmchat.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class me1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19198a;

    public static int a(Context context, float f) {
        try {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return (int) f;
        }
    }

    public static int b(Context context, int i) {
        try {
            return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int d(Context context) {
        try {
            boolean zHasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
            boolean zDeviceHasKey = KeyCharacterMap.deviceHasKey(4);
            boolean z = context.getResources().getBoolean(context.getResources().getIdentifier("config_showNavigationBar", "bool", "android"));
            int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier <= 0 || zHasPermanentMenuKey || zDeviceHasKey || !z) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String e() {
        if (f19198a == null) {
            f19198a = g() + "*" + f();
        }
        return f19198a;
    }

    public static int f() {
        WindowManager windowManager = (WindowManager) c.b().getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getHeight();
        }
        return 0;
    }

    public static int g() {
        WindowManager windowManager = (WindowManager) c.b().getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    public static int h(Context context) {
        int iB = b(context, 24);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) TypedValue.applyDimension(1, iB, Resources.getSystem().getDisplayMetrics());
    }

    public static int i(Context context) {
        Resources resources = context.getResources();
        try {
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int j(Context context, int i) {
        return (int) ((i / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void k(Window window, int i) {
        l(window, i, true);
    }

    public static void l(Window window, int i, boolean z) {
        m(window, i, z, false);
    }

    public static void m(Window window, int i, boolean z, boolean z2) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        if (!z) {
            window.setStatusBarColor(i);
            n(window);
        } else {
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
            r(window, !z2);
        }
    }

    public static void o(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static float p(Context context, float f) {
        try {
            return (f * context.getResources().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().scaledDensity;
        } catch (Exception unused) {
            return f;
        }
    }

    public static int q(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void r(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void n(Window window) {
    }
}

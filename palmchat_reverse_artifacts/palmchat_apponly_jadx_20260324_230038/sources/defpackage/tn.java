package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.zenmen.palmchat.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class tn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21025a;
    public static int b;
    public static Float c;
    public static Float d;
    public static Point e;

    public static float a(Context context, int i, float f, DisplayMetrics displayMetrics) {
        if (i == 1 || i == 2) {
            return TypedValue.applyDimension(i, f, displayMetrics);
        }
        switch (i) {
            case 6:
                return f / displayMetrics.density;
            case 7:
                return f / displayMetrics.scaledDensity;
            case 8:
                return TypedValue.applyDimension(1, f * e(context), displayMetrics);
            case 9:
                return f * e(context);
            case 10:
                return TypedValue.applyDimension(1, f * f(context), displayMetrics);
            default:
                return 0.0f;
        }
    }

    public static int b(Context context, int i) {
        try {
            return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int c(Context context, float f) {
        return (int) a(context, 1, f, context.getResources().getDisplayMetrics());
    }

    public static float d(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float e(Context context) {
        if (d == null) {
            d = Float.valueOf((g() * 2.0f) / (d(context) * 1280.0f));
        }
        return d.floatValue();
    }

    public static float f(Context context) {
        if (c == null) {
            c = Float.valueOf((i() * 2.0f) / (d(context) * 720.0f));
        }
        return c.floatValue();
    }

    public static int g() {
        WindowManager windowManager;
        if (b == 0 && (windowManager = (WindowManager) c.b().getSystemService("window")) != null) {
            b = windowManager.getDefaultDisplay().getHeight();
        }
        return b;
    }

    public static Point h(Context context) {
        Point point = e;
        if (point == null || point.x == 0 || point.y == 0) {
            Point point2 = new Point();
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            try {
                Point point3 = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point3);
                point2.x = point3.x;
                point2.y = point3.y;
            } catch (Exception unused) {
            }
            e = point2;
        }
        return e;
    }

    public static int i() {
        WindowManager windowManager;
        if (f21025a == 0 && (windowManager = (WindowManager) c.b().getSystemService("window")) != null) {
            f21025a = windowManager.getDefaultDisplay().getWidth();
        }
        return f21025a;
    }
}

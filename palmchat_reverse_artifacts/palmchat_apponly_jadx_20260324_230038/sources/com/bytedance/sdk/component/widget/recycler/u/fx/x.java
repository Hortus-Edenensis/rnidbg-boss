package com.bytedance.sdk.component.widget.recycler.u.fx;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static Field b;
    private static boolean fx;
    private static Method nr;
    private static boolean pn;
    private static Field u;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                nr = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int b(View view) {
        return view.getMinimumWidth();
    }

    private static float fx(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = nr) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static boolean iz(View view) {
        return view.hasTransientState();
    }

    public static void jk(View view) {
        view.stopNestedScroll();
    }

    public static boolean n(View view) {
        return view.isAttachedToWindow();
    }

    public static float nr(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : fx(viewConfiguration, context);
    }

    public static int pn(View view) {
        return view.getMinimumHeight();
    }

    public static int u(View view) {
        return view.getLayoutDirection();
    }

    public static Display x(View view) {
        return view.getDisplay();
    }

    public static int nr(View view) {
        return view.getImportantForAccessibility();
    }

    public static void u(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void nr(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static void u(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float u(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : fx(viewConfiguration, context);
    }

    public static void fx(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void u(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static boolean u(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}

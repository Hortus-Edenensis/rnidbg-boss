package com.opos.cmn.module.ui.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f8079a;
    private static float b;

    public static int a(float f) {
        return (int) ((f * c()) + 0.5f);
    }

    public static float b() {
        if (0.0f == f8079a) {
            f8079a = Resources.getSystem().getDisplayMetrics().density;
        }
        return f8079a;
    }

    public static float c() {
        if (0.0f == b) {
            if (Resources.getSystem().getDisplayMetrics().widthPixels == 1080) {
                b = b() == 3.0f ? b() : 3.0f;
            } else {
                b = b();
            }
        }
        return b;
    }

    public static int a(int i, float f) {
        if (f == 1.0f) {
            return i;
        }
        try {
            float[] fArr = new float[3];
            ColorUtils.colorToHSL(i, fArr);
            fArr[2] = fArr[2] * f;
            int iHSLToColor = ColorUtils.HSLToColor(fArr);
            return Color.argb(Color.alpha(i), Color.red(iHSLToColor), Color.green(iHSLToColor), Color.blue(iHSLToColor));
        } catch (Throwable unused) {
            return i;
        }
    }

    public static Drawable a(Context context, int i) {
        if (context == null) {
            return null;
        }
        int i2 = Build.VERSION.SDK_INT;
        Resources resources = context.getResources();
        return i2 > 21 ? resources.getDrawable(i, null) : resources.getDrawable(i);
    }

    public static void a(Activity activity, Dialog dialog) {
        if (dialog == null || activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            dialog.getWindow().setAttributes(attributes);
        }
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        int i = (systemUiVisibility & 1024) == 1024 ? 1280 : 0;
        if ((systemUiVisibility & 4) == 4) {
            i = i | 4 | 4096;
        }
        dialog.getWindow().getDecorView().setSystemUiVisibility(i);
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 29;
    }
}

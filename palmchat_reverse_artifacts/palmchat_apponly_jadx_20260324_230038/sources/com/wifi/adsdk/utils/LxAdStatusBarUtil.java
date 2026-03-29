package com.wifi.adsdk.utils;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdStatusBarUtil {
    public static final int TYPE_FLYME = 1;
    public static final int TYPE_M = 3;
    public static final int TYPE_MIUI = 0;

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean setCommonUI(Activity activity, boolean z) {
        View decorView;
        if (Build.VERSION.SDK_INT < 23 || (decorView = activity.getWindow().getDecorView()) == null) {
            return false;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        if (decorView.getSystemUiVisibility() == i) {
            return true;
        }
        decorView.setSystemUiVisibility(i);
        return true;
    }

    public static boolean setFlymeUI(Activity activity, boolean z) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            window.setAttributes(attributes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setMiuiUI(Activity activity, boolean z) {
        try {
            Window window = activity.getWindow();
            Class<?> cls = activity.getWindow().getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setExtraFlags", cls3, cls3);
            declaredMethod.setAccessible(true);
            if (z) {
                declaredMethod.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                declaredMethod.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
            return;
        }
        viewGroup.setFitsSystemWindows(z);
    }

    public static void setStatusBarColor(Activity activity, int i) {
        activity.getWindow().setStatusBarColor(i);
    }

    public static boolean setStatusBarDarkTheme(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            setStatusBarFontIconDark(activity, 3, z);
        } else if (LxAdOSUtils.isMiui()) {
            setStatusBarFontIconDark(activity, 0, z);
        } else {
            if (!LxAdOSUtils.isFlyme()) {
                return false;
            }
            setStatusBarFontIconDark(activity, 1, z);
        }
        return true;
    }

    public static boolean setStatusBarFontIconDark(Activity activity, int i, boolean z) {
        return i != 0 ? i != 1 ? setCommonUI(activity, z) : setFlymeUI(activity, z) : setMiuiUI(activity, z);
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}

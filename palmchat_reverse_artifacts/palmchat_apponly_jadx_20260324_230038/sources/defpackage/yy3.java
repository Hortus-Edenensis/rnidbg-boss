package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.bq;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yy3 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static int[] a(Context context) {
            int[] iArr = {0, 0};
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
            } catch (Throwable unused) {
                return iArr;
            }
        }

        public static boolean b(Context context) {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        }

        public static void c(Window window) {
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static boolean a(Context context) {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Throwable unused) {
                return false;
            }
        }

        public static void b(Window window) {
            try {
                Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(window, 768);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (dm1.d() && a.b(activity)) {
                a.c(window);
                return;
            } else {
                if (vp3.e() && b.a(activity)) {
                    b.b(window);
                    return;
                }
                return;
            }
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = attributes.getClass().getDeclaredField(bq.f.A);
            Field declaredField2 = attributes.getClass().getDeclaredField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES");
            declaredField.setAccessible(true);
            declaredField.set(attributes, declaredField2.get(attributes));
            window.setAttributes(attributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

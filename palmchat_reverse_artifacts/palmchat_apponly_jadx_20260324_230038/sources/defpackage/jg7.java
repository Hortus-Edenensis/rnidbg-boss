package defpackage;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class jg7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f18402a = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean a(String str, Class cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?> cls2 = Runtime.getRuntime().getClass();
            Class<?>[] clsArr = new Class[2];
            if (Build.VERSION.SDK_INT > 24) {
                clsArr[0] = ClassLoader.class;
                clsArr[1] = String.class;
                Method declaredMethod = cls2.getDeclaredMethod("loadLibrary0", clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(Runtime.getRuntime(), classLoader, str);
            } else {
                clsArr[0] = String.class;
                clsArr[1] = ClassLoader.class;
                Method declaredMethod2 = cls2.getDeclaredMethod("loadLibrary", clsArr);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(Runtime.getRuntime(), str, classLoader);
            }
            return true;
        } catch (IllegalAccessException e) {
            e = e;
            if (!k17.k()) {
                return false;
            }
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            e = e2;
            if (!k17.k()) {
                return false;
            }
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            if (!k17.k()) {
                return false;
            }
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            e = th;
            if (!k17.k()) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }
}

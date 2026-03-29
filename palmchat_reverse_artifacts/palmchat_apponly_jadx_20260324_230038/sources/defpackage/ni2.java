package defpackage;

import android.app.ActivityManager;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ni2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f19518a;

        public a(Object obj) {
            this.f19518a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method == null) {
                return null;
            }
            if (!"reportSizeConfigurations".equals(method.getName())) {
                try {
                    return method.invoke(this.f19518a, objArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if ("isTopOfTask".equals(method.getName())) {
                        return Boolean.TRUE;
                    }
                    return null;
                }
            }
            try {
                Log.w("HookActivityManager", "reportSizeConfigurations invoke execute ");
                return method.invoke(this.f19518a, objArr);
            } catch (Exception e2) {
                Log.w("HookActivityManager", "reportSizeConfigurations exception: " + e2.getMessage());
                return null;
            }
        }
    }

    public static void a() {
        Class<? super Object> superclass;
        int i = Build.VERSION.SDK_INT;
        if (i < 24 || i > 28) {
            Log.i("HookActivityManager", "hook return, not match version");
            return;
        }
        String str = Build.MANUFACTURER;
        if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str) || "vivo".equalsIgnoreCase(str)) {
            try {
                Field declaredField = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj == null || (superclass = obj.getClass().getSuperclass()) == null) {
                    return;
                }
                Field declaredField2 = superclass.getDeclaredField("mInstance");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Class<?> cls = Class.forName("android.app.IActivityManager");
                declaredField2.set(obj, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(obj2)));
                Log.i("HookActivityManager", "hook success!");
            } catch (Exception e) {
                Log.w("HookActivityManager", "" + e);
            }
        }
    }
}

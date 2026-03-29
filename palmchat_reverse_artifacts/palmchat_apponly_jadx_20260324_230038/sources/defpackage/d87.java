package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d87 {
    public static Map<Class<?>, z55> c = new HashMap();
    public static Map<Class<?>, Object> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Class<?>, z55> f16997a = new HashMap();
    public Map<Class<?>, Object> b = new HashMap();

    public d87(List<z55> list, Context context) {
        c(list, context);
    }

    public static Constructor a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public final void b(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb = new StringBuilder();
        sb.append("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb.toString());
    }

    public void c(List<z55> list, Context context) {
        Map<Class<?>, z55> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (z55 z55Var : list) {
            if (z55Var.d()) {
                if (!c.containsKey(z55Var.a())) {
                    map = c;
                }
                if (!z55Var.c() && z55Var.b() != null && !d.containsKey(z55Var.a())) {
                    try {
                        Constructor constructorA = a(z55Var.b(), Context.class);
                        d.put(z55Var.a(), constructorA != null ? constructorA.newInstance(context) : z55Var.b().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        b(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        b(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        b(str, e);
                    }
                }
            } else {
                map = this.f16997a;
            }
            map.put(z55Var.a(), z55Var);
            if (!z55Var.c()) {
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}

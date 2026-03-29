package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class xm5 {
    public static final Map<Class<?>, List<wm5>> d = new ConcurrentHashMap();
    public static final a[] e = new a[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<vm5> f22004a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<wm5> f22005a = new ArrayList();
        public final Map<Class, Object> b = new HashMap();
        public final Map<String, Class> c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class<?> e;
        public Class<?> f;
        public boolean g;

        public boolean a(Method method, Class<?> cls) {
            Object objPut = this.b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String string = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(string, clsPut);
            return false;
        }

        public void c(Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
        }

        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class<? super Object> superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f = null;
            }
        }

        public void e() {
            this.f22005a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
        }
    }

    public xm5(List<vm5> list, boolean z, boolean z2) {
        this.f22004a = list;
        this.b = z;
        this.c = z2;
    }

    public List<wm5> a(Class<?> cls) {
        Map<Class<?>, List<wm5>> map = d;
        List<wm5> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<wm5> listC = this.c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            map.put(cls, listC);
            return listC;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<wm5> b(Class<?> cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f != null) {
            f(aVarG);
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    public final List<wm5> c(Class<?> cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f != null) {
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    public final void d(a aVar) {
        Method[] methods;
        try {
            try {
                methods = aVar.f.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.f.getMethods();
                aVar.g = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        pm5 pm5Var = (pm5) method.getAnnotation(pm5.class);
                        if (pm5Var != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.f22005a.add(new wm5(method, cls, pm5Var.threadMode(), pm5Var.priority(), pm5Var.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(pm5.class)) {
                        throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.b && method.isAnnotationPresent(pm5.class)) {
                    throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e2) {
            String str = "Could not inspect methods of " + aVar.f.getName();
            throw new EventBusException(this.c ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e2);
        }
    }

    public final List<wm5> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f22005a);
        aVar.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                a[] aVarArr = e;
                if (aVarArr[i] == null) {
                    aVarArr[i] = aVar;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public final um5 f(a aVar) {
        aVar.getClass();
        List<vm5> list = this.f22004a;
        if (list == null) {
            return null;
        }
        Iterator<vm5> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(aVar.f);
        }
        return null;
    }

    public final a g() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                a[] aVarArr = e;
                a aVar = aVarArr[i];
                if (aVar != null) {
                    aVarArr[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}

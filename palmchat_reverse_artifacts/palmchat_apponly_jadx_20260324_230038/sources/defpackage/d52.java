package defpackage;

import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q94<List<Class<?>>> f16977a;
    public static final q94<Constructor<?>> b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void validateClass(Class<? extends Exception> cls);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16978a = a();

        /* JADX INFO: compiled from: SearchBox */
        public enum a implements a {
            INSTANCE;

            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

            @Override // d52.a
            public void validateClass(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = validClasses.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                d52.e(cls);
                Set<WeakReference<Class<? extends Exception>>> set = validClasses;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        public static a a() {
            return d52.o();
        }
    }

    static {
        q94<List<Class<?>>> q94VarS = q94.o().q(new u42() { // from class: a52
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return d52.i((List) obj);
            }
        }).a(q94.o().q(new u42() { // from class: b52
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return d52.j((List) obj);
            }
        })).s();
        f16977a = q94VarS;
        b = q94VarS.q(new u42() { // from class: c52
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return d52.k((Constructor) obj);
            }
        });
    }

    public static a d() {
        return b.f16978a;
    }

    public static void e(Class<? extends Exception> cls) {
        dm4.j(h(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        dm4.j(g(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        d().validateClass(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw m(cls, e);
        } catch (ExecutionException e2) {
            p(e2.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e3) {
            throw m(cls, e3);
        }
    }

    public static boolean g(Class<? extends Exception> cls) {
        try {
            m(cls, new Exception());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static /* synthetic */ Comparable i(List list) {
        return Boolean.valueOf(list.contains(String.class));
    }

    public static /* synthetic */ Comparable j(List list) {
        return Boolean.valueOf(list.contains(Throwable.class));
    }

    public static /* synthetic */ List k(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes());
    }

    public static <X> X l(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X m(Class<X> cls, Throwable th) {
        Iterator it = n(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x = (X) l((Constructor) it.next(), th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    public static <X extends Exception> List<Constructor<X>> n(List<Constructor<X>> list) {
        return (List<Constructor<X>>) b.t(list);
    }

    public static a o() {
        return b.a.INSTANCE;
    }

    public static <X extends Exception> void p(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw m(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }
}

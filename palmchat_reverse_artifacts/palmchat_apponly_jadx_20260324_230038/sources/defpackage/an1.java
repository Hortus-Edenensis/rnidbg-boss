package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class an1 {
    public static volatile an1 s;
    public static final bn1 t = new bn1();
    public static final Map<Class<?>, List<Class<?>>> u = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<an5>> f1256a;
    public final Map<Object, List<Class<?>>> b;
    public final Map<Class<?>, Object> c;
    public final ThreadLocal<c> d;
    public final jc3 e;
    public final wk4 f;
    public final oo g;
    public final bi h;
    public final xm5 i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final o63 r;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ThreadLocal<c> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c initialValue() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1258a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f1258a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1258a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1258a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1258a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1258a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f1259a = new ArrayList();
        public boolean b;
        public boolean c;
        public an5 d;
        public Object e;
        public boolean f;
    }

    public an1() {
        this(t);
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static an1 c() {
        an1 an1Var = s;
        if (an1Var == null) {
            synchronized (an1.class) {
                an1Var = s;
                if (an1Var == null) {
                    an1Var = new an1();
                    s = an1Var;
                }
            }
        }
        return an1Var;
    }

    public static List<Class<?>> k(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = u;
        synchronized (map) {
            arrayList = map.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                u.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public final void b(an5 an5Var, Object obj) {
        if (obj != null) {
            o(an5Var, obj, i());
        }
    }

    public ExecutorService d() {
        return this.j;
    }

    public o63 e() {
        return this.r;
    }

    public final void f(an5 an5Var, Object obj, Throwable th) {
        if (!(obj instanceof tm5)) {
            if (this.k) {
                throw new EventBusException("Invoking subscriber failed", th);
            }
            if (this.l) {
                this.r.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + an5Var.f1262a.getClass(), th);
            }
            if (this.n) {
                l(new tm5(this, th, obj, an5Var.f1262a));
                return;
            }
            return;
        }
        if (this.l) {
            o63 o63Var = this.r;
            Level level = Level.SEVERE;
            o63Var.b(level, "SubscriberExceptionEvent subscriber " + an5Var.f1262a.getClass() + " threw an exception", th);
            tm5 tm5Var = (tm5) obj;
            this.r.b(level, "Initial event " + tm5Var.c + " caused exception in " + tm5Var.d, tm5Var.b);
        }
    }

    public void g(ag4 ag4Var) {
        Object obj = ag4Var.f1226a;
        an5 an5Var = ag4Var.b;
        ag4.b(ag4Var);
        if (an5Var.c) {
            h(an5Var, obj);
        }
    }

    public void h(an5 an5Var, Object obj) {
        try {
            an5Var.b.f21753a.invoke(an5Var.f1262a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            f(an5Var, obj, e2.getCause());
        }
    }

    public final boolean i() {
        jc3 jc3Var = this.e;
        return jc3Var == null || jc3Var.a();
    }

    public synchronized boolean j(Object obj) {
        return this.b.containsKey(obj);
    }

    public void l(Object obj) {
        c cVar = this.d.get();
        List<Object> list = cVar.f1259a;
        list.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = i();
        cVar.b = true;
        if (cVar.f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    m(list.remove(0), cVar);
                }
            } finally {
                cVar.b = false;
                cVar.c = false;
            }
        }
    }

    public final void m(Object obj, c cVar) throws Error {
        boolean zN;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> listK = k(cls);
            int size = listK.size();
            zN = false;
            for (int i = 0; i < size; i++) {
                zN |= n(obj, cVar, listK.get(i));
            }
        } else {
            zN = n(obj, cVar, cls);
        }
        if (zN) {
            return;
        }
        if (this.m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == jy3.class || cls == tm5.class) {
            return;
        }
        l(new jy3(this, obj));
    }

    public final boolean n(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList<an5> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f1256a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (an5 an5Var : copyOnWriteArrayList) {
            cVar.e = obj;
            cVar.d = an5Var;
            try {
                o(an5Var, obj, cVar.c);
                if (cVar.f) {
                    return true;
                }
            } finally {
                cVar.e = null;
                cVar.d = null;
                cVar.f = false;
            }
        }
        return true;
    }

    public final void o(an5 an5Var, Object obj, boolean z) {
        int i = b.f1258a[an5Var.b.b.ordinal()];
        if (i == 1) {
            h(an5Var, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                h(an5Var, obj);
                return;
            } else {
                this.f.a(an5Var, obj);
                return;
            }
        }
        if (i == 3) {
            wk4 wk4Var = this.f;
            if (wk4Var != null) {
                wk4Var.a(an5Var, obj);
                return;
            } else {
                h(an5Var, obj);
                return;
            }
        }
        if (i == 4) {
            if (z) {
                this.g.a(an5Var, obj);
                return;
            } else {
                h(an5Var, obj);
                return;
            }
        }
        if (i == 5) {
            this.h.a(an5Var, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + an5Var.b.b);
    }

    public void p(Object obj) {
        List<wm5> listA = this.i.a(obj.getClass());
        synchronized (this) {
            Iterator<wm5> it = listA.iterator();
            while (it.hasNext()) {
                q(obj, it.next());
            }
        }
    }

    public final void q(Object obj, wm5 wm5Var) {
        Class<?> cls = wm5Var.c;
        an5 an5Var = new an5(obj, wm5Var);
        CopyOnWriteArrayList<an5> copyOnWriteArrayList = this.f1256a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f1256a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(an5Var)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || wm5Var.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, an5Var);
                break;
            }
        }
        List<Class<?>> arrayList = this.b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (wm5Var.e) {
            if (!this.p) {
                b(an5Var, this.c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(an5Var, entry.getValue());
                }
            }
        }
    }

    public synchronized void r(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                s(obj, it.next());
            }
            this.b.remove(obj);
        } else {
            this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public final void s(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<an5> copyOnWriteArrayList = this.f1256a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                an5 an5Var = copyOnWriteArrayList.get(i);
                if (an5Var.f1262a == obj) {
                    an5Var.c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    public an1(bn1 bn1Var) {
        this.d = new a();
        this.r = bn1Var.b();
        this.f1256a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        jc3 jc3VarC = bn1Var.c();
        this.e = jc3VarC;
        this.f = jc3VarC != null ? jc3VarC.b(this) : null;
        this.g = new oo(this);
        this.h = new bi(this);
        List<vm5> list = bn1Var.j;
        this.q = list != null ? list.size() : 0;
        this.i = new xm5(bn1Var.j, bn1Var.h, bn1Var.g);
        this.l = bn1Var.f1772a;
        this.m = bn1Var.b;
        this.n = bn1Var.c;
        this.o = bn1Var.d;
        this.k = bn1Var.e;
        this.p = bn1Var.f;
        this.j = bn1Var.i;
    }
}

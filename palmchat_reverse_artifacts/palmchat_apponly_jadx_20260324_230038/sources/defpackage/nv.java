package defpackage;

import android.util.Log;
import com.baidu.platform.comapi.map.MapController;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, Set<en1>> f19619a;
    public final ConcurrentMap<Class<?>, sn1> b;
    public final String c;
    public final ow5 d;
    public final jg2 e;
    public final ThreadLocal<ConcurrentLinkedQueue<c>> f;
    public final ThreadLocal<Boolean> g;
    public final Map<Class<?>, Set<Class<?>>> h;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ThreadLocal<ConcurrentLinkedQueue<c>> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConcurrentLinkedQueue<c> initialValue() {
            return new ConcurrentLinkedQueue<>();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ThreadLocal<Boolean> {
        public b() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f19622a;
        public final en1 b;

        public c(Object obj, en1 en1Var) {
            this.f19622a = obj;
            this.b = en1Var;
        }
    }

    public nv(ow5 ow5Var) {
        this(ow5Var, MapController.DEFAULT_LAYER_TAG);
    }

    public static void k(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            throw new RuntimeException(str + ": " + cause.getMessage(), cause);
        }
        throw new RuntimeException(str + ": " + invocationTargetException.getMessage(), invocationTargetException);
    }

    public void a(Object obj, en1 en1Var) {
        try {
            en1Var.a(obj);
        } catch (IllegalStateException e) {
            Log.e("ottoBus", "dispatch IllegalStateException " + e.toString());
        } catch (InvocationTargetException e2) {
            k("Could not dispatch event: " + obj.getClass() + " to handler " + en1Var, e2);
        }
    }

    public final void b(en1 en1Var, sn1 sn1Var) {
        Object objC;
        try {
            objC = sn1Var.c();
        } catch (InvocationTargetException e) {
            k("Producer " + sn1Var + " threw an exception.", e);
            objC = null;
        }
        if (objC == null) {
            return;
        }
        a(objC, en1Var);
    }

    public void c() {
        if (this.g.get().booleanValue()) {
            return;
        }
        this.g.set(Boolean.TRUE);
        while (true) {
            try {
                c cVarPoll = this.f.get().poll();
                if (cVarPoll == null) {
                    return;
                }
                if (cVarPoll.b.c()) {
                    a(cVarPoll.f19622a, cVarPoll.b);
                }
            } finally {
                this.g.set(Boolean.FALSE);
            }
        }
    }

    public void d(Object obj, en1 en1Var) {
        this.f.get().offer(new c(obj, en1Var));
    }

    public Set<Class<?>> e(Class<?> cls) {
        Set<Class<?>> set = this.h.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> setF = f(cls);
        this.h.put(cls, setF);
        return setF;
    }

    public final Set<Class<?>> f(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    public Set<en1> g(Class<?> cls) {
        return this.f19619a.get(cls);
    }

    public sn1 h(Class<?> cls) {
        return this.b.get(cls);
    }

    public void i(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Event to post must not be null.");
        }
        this.d.a(this);
        Iterator<Class<?>> it = e(obj.getClass()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            Set<en1> setG = g(it.next());
            if (setG != null && !setG.isEmpty()) {
                Iterator<en1> it2 = setG.iterator();
                while (it2.hasNext()) {
                    d(obj, it2.next());
                }
                z = true;
            }
        }
        if (!z && !(obj instanceof kv0)) {
            i(new kv0(this, obj));
        }
        c();
    }

    public void j(Object obj) {
        Set<en1> setPutIfAbsent;
        if (obj == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        this.d.a(this);
        Map<Class<?>, sn1> mapB = this.e.b(obj);
        for (Class<?> cls : mapB.keySet()) {
            sn1 sn1Var = mapB.get(cls);
            sn1 sn1VarPutIfAbsent = this.b.putIfAbsent(cls, sn1Var);
            if (sn1VarPutIfAbsent != null) {
                throw new IllegalArgumentException("Producer method for type " + cls + " found on type " + sn1Var.f20789a.getClass() + ", but already registered by type " + sn1VarPutIfAbsent.f20789a.getClass() + ".");
            }
            Set<en1> set = this.f19619a.get(cls);
            if (set != null && !set.isEmpty()) {
                Iterator<en1> it = set.iterator();
                while (it.hasNext()) {
                    b(it.next(), sn1Var);
                }
            }
        }
        Map<Class<?>, Set<en1>> mapA = this.e.a(obj);
        for (Class<?> cls2 : mapA.keySet()) {
            Set<en1> copyOnWriteArraySet = this.f19619a.get(cls2);
            if (copyOnWriteArraySet == null && (setPutIfAbsent = this.f19619a.putIfAbsent(cls2, (copyOnWriteArraySet = new CopyOnWriteArraySet<>()))) != null) {
                copyOnWriteArraySet = setPutIfAbsent;
            }
            if (!copyOnWriteArraySet.addAll(mapA.get(cls2))) {
                throw new IllegalArgumentException("Object already registered.");
            }
        }
        for (Map.Entry<Class<?>, Set<en1>> entry : mapA.entrySet()) {
            sn1 sn1Var2 = this.b.get(entry.getKey());
            if (sn1Var2 != null && sn1Var2.b()) {
                for (en1 en1Var : entry.getValue()) {
                    if (!sn1Var2.b()) {
                        break;
                    } else if (en1Var.c()) {
                        b(en1Var, sn1Var2);
                    }
                }
            }
        }
    }

    public void l(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to unregister must not be null.");
        }
        this.d.a(this);
        for (Map.Entry<Class<?>, sn1> entry : this.e.b(obj).entrySet()) {
            Class<?> key = entry.getKey();
            sn1 sn1VarH = h(key);
            sn1 value = entry.getValue();
            if (value == null || !value.equals(sn1VarH)) {
                throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + obj.getClass() + " registered?");
            }
            this.b.remove(key).a();
        }
        for (Map.Entry<Class<?>, Set<en1>> entry2 : this.e.a(obj).entrySet()) {
            Set<en1> setG = g(entry2.getKey());
            Set<en1> value2 = entry2.getValue();
            if (setG == null || !setG.containsAll(value2)) {
                throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + obj.getClass() + " registered?");
            }
            for (en1 en1Var : setG) {
                if (value2.contains(en1Var)) {
                    en1Var.b();
                }
            }
            setG.removeAll(value2);
        }
    }

    public String toString() {
        return "[Bus \"" + this.c + "\"]";
    }

    public nv(ow5 ow5Var, String str) {
        this(ow5Var, str, jg2.f18401a);
    }

    public nv(ow5 ow5Var, String str, jg2 jg2Var) {
        this.f19619a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.f = new a();
        this.g = new b();
        this.h = new HashMap();
        this.d = ow5Var;
        this.c = str;
        this.e = jg2Var;
    }
}

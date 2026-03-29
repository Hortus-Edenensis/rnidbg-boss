package defpackage;

import com.google.common.base.Equivalence;
import j$.util.concurrent.ConcurrentMap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import rc3.i;
import rc3.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class rc3<K, V, E extends i<K, V, E>, S extends m<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, j$.util.concurrent.ConcurrentMap {
    public static final a0<Object, Object, e> j = new a();
    private static final long serialVersionUID = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f20438a;
    public final transient int b;
    public final transient m<K, V, E, S>[] c;
    public final int d;
    public final Equivalence<Object> e;
    public final transient j<K, V, E, S> f;
    public transient Set<K> g;
    public transient Collection<V> h;
    public transient Set<Map.Entry<K, V>> i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a0<K, V, E extends i<K, V, E>> {
        a0<K, V, E> a(ReferenceQueue<V> referenceQueue, E e);

        E b();

        void clear();

        V get();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b<K, V> extends i12<K, V> implements Serializable {
        private static final long serialVersionUID = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f20439a;
        public final o b;
        public final Equivalence<Object> c;
        public final Equivalence<Object> d;
        public final int e;
        public transient ConcurrentMap<K, V> f;

        public b(o oVar, o oVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.f20439a = oVar;
            this.b = oVar2;
            this.c = equivalence;
            this.d = equivalence2;
            this.e = i;
            this.f = concurrentMap;
        }

        @Override // defpackage.n12, defpackage.p12
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConcurrentMap<K, V> delegate() {
            return this.f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void c(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.f.put(object, objectInputStream.readObject());
            }
        }

        public qc3 d(ObjectInputStream objectInputStream) throws IOException {
            return new qc3().g(objectInputStream.readInt()).j(this.f20439a).k(this.b).h(this.c).a(this.e);
        }

        public void e(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.f.size());
            for (Map.Entry<K, V> entry : this.f.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b0<K, V, E extends i<K, V, E>> extends WeakReference<V> implements a0<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f20440a;

        public b0(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.f20440a = e;
        }

        @Override // rc3.a0
        public a0<K, V, E> a(ReferenceQueue<V> referenceQueue, E e) {
            return new b0(referenceQueue, get(), e);
        }

        @Override // rc3.a0
        public E b() {
            return this.f20440a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c<K, V, E extends i<K, V, E>> implements i<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f20441a;
        public final int b;

        public c(K k, int i) {
            this.f20441a = k;
            this.b = i;
        }

        @Override // rc3.i
        public E b() {
            return null;
        }

        @Override // rc3.i
        public final int c() {
            return this.b;
        }

        @Override // rc3.i
        public final K getKey() {
            return this.f20441a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c0 extends m1<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f20442a;
        public V b;

        public c0(K k, V v) {
            this.f20442a = k;
            this.b = v;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f20442a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public K getKey() {
            return this.f20442a;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public int hashCode() {
            return this.f20442a.hashCode() ^ this.b.hashCode();
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) rc3.this.put(this.f20442a, v);
            this.b = v;
            return v2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<K, V, E extends i<K, V, E>> extends WeakReference<K> implements i<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20443a;

        public d(ReferenceQueue<K> referenceQueue, K k, int i) {
            super(k, referenceQueue);
            this.f20443a = i;
        }

        @Override // rc3.i
        public E b() {
            return null;
        }

        @Override // rc3.i
        public final int c() {
            return this.f20443a;
        }

        @Override // rc3.i
        public final K getKey() {
            return get();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements i<Object, Object, e> {
        public e() {
            throw new AssertionError();
        }

        @Override // rc3.i
        public int c() {
            throw new AssertionError();
        }

        @Override // rc3.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public e b() {
            throw new AssertionError();
        }

        @Override // rc3.i
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // rc3.i
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class f extends rc3<K, V, E, S>.h<Map.Entry<K, V>> {
        public f() {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            rc3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = rc3.this.get(key)) != null && rc3.this.p().p(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return rc3.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && rc3.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return rc3.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class h<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20445a;
        public int b = -1;
        public m<K, V, E, S> c;
        public AtomicReferenceArray<E> d;
        public E e;
        public rc3<K, V, E, S>.c0 f;
        public rc3<K, V, E, S>.c0 g;

        public h() {
            this.f20445a = rc3.this.c.length - 1;
            a();
        }

        public final void a() {
            this.f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.f20445a;
                if (i < 0) {
                    return;
                }
                m<K, V, E, S>[] mVarArr = rc3.this.c;
                this.f20445a = i - 1;
                m<K, V, E, S> mVar = mVarArr[i];
                this.c = mVar;
                if (mVar.b != 0) {
                    this.d = this.c.e;
                    this.b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e) {
            try {
                Object key = e.getKey();
                Object objC = rc3.this.c(e);
                if (objC == null) {
                    this.c.D();
                    return false;
                }
                this.f = new c0(key, objC);
                this.c.D();
                return true;
            } catch (Throwable th) {
                this.c.D();
                throw th;
            }
        }

        public rc3<K, V, E, S>.c0 c() {
            rc3<K, V, E, S>.c0 c0Var = this.f;
            if (c0Var == null) {
                throw new NoSuchElementException();
            }
            this.g = c0Var;
            a();
            return this.g;
        }

        public boolean d() {
            E e = this.e;
            if (e == null) {
                return false;
            }
            while (true) {
                this.e = (E) e.b();
                E e2 = this.e;
                if (e2 == null) {
                    return false;
                }
                if (b(e2)) {
                    return true;
                }
                e = this.e;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.d;
                this.b = i - 1;
                E e = atomicReferenceArray.get(i);
                this.e = e;
                if (e != null && (b(e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            sg0.e(this.g != null);
            rc3.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i<K, V, E extends i<K, V, E>> {
        E b();

        int c();

        K getKey();

        V getValue();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface j<K, V, E extends i<K, V, E>, S extends m<K, V, E, S>> {
        void a(S s, E e, V v);

        o b();

        o c();

        E d(S s, K k, int i, E e);

        S e(rc3<K, V, E, S> rc3Var, int i);

        E f(S s, E e, E e2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class k extends rc3<K, V, E, S>.h<K> {
        public k() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class l extends AbstractSet<K> {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            rc3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return rc3.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return rc3.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return rc3.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return rc3.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class n<K, V> extends b<K, V> {
        private static final long serialVersionUID = 3;

        public n(o oVar, o oVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(oVar, oVar2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f = d(objectInputStream).i();
            c(objectInputStream);
        }

        private Object readResolve() {
            return this.f;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            e(objectOutputStream);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class o {
        public static final o STRONG = new a("STRONG", 0);
        public static final o WEAK = new b("WEAK", 1);
        private static final /* synthetic */ o[] $VALUES = $values();

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends o {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // rc3.o
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.o();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b extends o {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // rc3.o
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.s();
            }
        }

        private static /* synthetic */ o[] $values() {
            return new o[]{STRONG, WEAK};
        }

        private o(String str, int i) {
        }

        public static o valueOf(String str) {
            return (o) Enum.valueOf(o.class, str);
        }

        public static o[] values() {
            return (o[]) $VALUES.clone();
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public /* synthetic */ o(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p<K, V> extends c<K, V, p<K, V>> {
        public volatile V c;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a<K, V> implements j<K, V, p<K, V>, q<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f20448a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f20448a;
            }

            @Override // rc3.j
            public o b() {
                return o.STRONG;
            }

            @Override // rc3.j
            public o c() {
                return o.STRONG;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public p<K, V> f(q<K, V> qVar, p<K, V> pVar, p<K, V> pVar2) {
                p<K, V> pVarD = d(qVar, pVar.f20441a, pVar.b, pVar2);
                pVarD.c = pVar.c;
                return pVarD;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public p<K, V> d(q<K, V> qVar, K k, int i, p<K, V> pVar) {
                return pVar == null ? new p<>(k, i, null) : new b(k, i, pVar);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public q<K, V> e(rc3<K, V, p<K, V>, q<K, V>> rc3Var, int i) {
                return new q<>(rc3Var, i);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(q<K, V> qVar, p<K, V> pVar, V v) {
                pVar.c = v;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b<K, V> extends p<K, V> {
            public final p<K, V> d;

            public b(K k, int i, p<K, V> pVar) {
                super(k, i, null);
                this.d = pVar;
            }

            @Override // rc3.c, rc3.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public p<K, V> b() {
                return this.d;
            }
        }

        public /* synthetic */ p(Object obj, int i, a aVar) {
            this(obj, i);
        }

        @Override // rc3.i
        public final V getValue() {
            return this.c;
        }

        public p(K k, int i) {
            super(k, i);
            this.c = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class r<K, V> extends c<K, V, r<K, V>> implements z<K, V, r<K, V>> {
        public volatile a0<K, V, r<K, V>> c;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a<K, V> implements j<K, V, r<K, V>, s<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f20449a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f20449a;
            }

            @Override // rc3.j
            public o b() {
                return o.STRONG;
            }

            @Override // rc3.j
            public o c() {
                return o.WEAK;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K, V> f(s<K, V> sVar, r<K, V> rVar, r<K, V> rVar2) {
                if (m.v(rVar)) {
                    return null;
                }
                r<K, V> rVarD = d(sVar, rVar.f20441a, rVar.b, rVar2);
                rVarD.c = rVar.c.a(sVar.g, rVarD);
                return rVarD;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K, V> d(s<K, V> sVar, K k, int i, r<K, V> rVar) {
                return rVar == null ? new r<>(k, i, null) : new b(k, i, rVar);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public s<K, V> e(rc3<K, V, r<K, V>, s<K, V>> rc3Var, int i) {
                return new s<>(rc3Var, i);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(s<K, V> sVar, r<K, V> rVar, V v) {
                a0 a0Var = rVar.c;
                rVar.c = new b0(sVar.g, v, rVar);
                a0Var.clear();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b<K, V> extends r<K, V> {
            public final r<K, V> d;

            public b(K k, int i, r<K, V> rVar) {
                super(k, i, null);
                this.d = rVar;
            }

            @Override // rc3.c, rc3.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public r<K, V> b() {
                return this.d;
            }
        }

        public /* synthetic */ r(Object obj, int i, a aVar) {
            this(obj, i);
        }

        @Override // rc3.z
        public final a0<K, V, r<K, V>> a() {
            return this.c;
        }

        @Override // rc3.i
        public final V getValue() {
            return this.c.get();
        }

        public r(K k, int i) {
            super(k, i);
            this.c = rc3.o();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class t extends rc3<K, V, E, S>.h<V> {
        public t() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class u extends AbstractCollection<V> {
        public u() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            rc3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return rc3.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return rc3.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new t();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return rc3.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class v<K, V> extends d<K, V, v<K, V>> {
        public volatile V b;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a<K, V> implements j<K, V, v<K, V>, w<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f20451a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f20451a;
            }

            @Override // rc3.j
            public o b() {
                return o.WEAK;
            }

            @Override // rc3.j
            public o c() {
                return o.STRONG;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public v<K, V> f(w<K, V> wVar, v<K, V> vVar, v<K, V> vVar2) {
                K key = vVar.getKey();
                if (key == null) {
                    return null;
                }
                v<K, V> vVarD = d(wVar, key, vVar.f20443a, vVar2);
                vVarD.b = vVar.b;
                return vVarD;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public v<K, V> d(w<K, V> wVar, K k, int i, v<K, V> vVar) {
                return vVar == null ? new v<>(wVar.g, k, i, null) : new b(wVar.g, k, i, vVar, null);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public w<K, V> e(rc3<K, V, v<K, V>, w<K, V>> rc3Var, int i) {
                return new w<>(rc3Var, i);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(w<K, V> wVar, v<K, V> vVar, V v) {
                vVar.b = v;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b<K, V> extends v<K, V> {
            public final v<K, V> c;

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i, v vVar, a aVar) {
                this(referenceQueue, obj, i, vVar);
            }

            @Override // rc3.d, rc3.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public v<K, V> b() {
                return this.c;
            }

            public b(ReferenceQueue<K> referenceQueue, K k, int i, v<K, V> vVar) {
                super(referenceQueue, k, i, null);
                this.c = vVar;
            }
        }

        public /* synthetic */ v(ReferenceQueue referenceQueue, Object obj, int i, a aVar) {
            this(referenceQueue, obj, i);
        }

        @Override // rc3.i
        public final V getValue() {
            return this.b;
        }

        public v(ReferenceQueue<K> referenceQueue, K k, int i) {
            super(referenceQueue, k, i);
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class x<K, V> extends d<K, V, x<K, V>> implements z<K, V, x<K, V>> {
        public volatile a0<K, V, x<K, V>> b;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a<K, V> implements j<K, V, x<K, V>, y<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f20452a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f20452a;
            }

            @Override // rc3.j
            public o b() {
                return o.WEAK;
            }

            @Override // rc3.j
            public o c() {
                return o.WEAK;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public x<K, V> f(y<K, V> yVar, x<K, V> xVar, x<K, V> xVar2) {
                K key = xVar.getKey();
                if (key == null || m.v(xVar)) {
                    return null;
                }
                x<K, V> xVarD = d(yVar, key, xVar.f20443a, xVar2);
                xVarD.b = xVar.b.a(yVar.h, xVarD);
                return xVarD;
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public x<K, V> d(y<K, V> yVar, K k, int i, x<K, V> xVar) {
                return xVar == null ? new x<>(yVar.g, k, i) : new b(yVar.g, k, i, xVar);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public y<K, V> e(rc3<K, V, x<K, V>, y<K, V>> rc3Var, int i) {
                return new y<>(rc3Var, i);
            }

            @Override // rc3.j
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(y<K, V> yVar, x<K, V> xVar, V v) {
                a0 a0Var = xVar.b;
                xVar.b = new b0(yVar.h, v, xVar);
                a0Var.clear();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b<K, V> extends x<K, V> {
            public final x<K, V> c;

            public b(ReferenceQueue<K> referenceQueue, K k, int i, x<K, V> xVar) {
                super(referenceQueue, k, i);
                this.c = xVar;
            }

            @Override // rc3.d, rc3.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public x<K, V> b() {
                return this.c;
            }
        }

        public x(ReferenceQueue<K> referenceQueue, K k, int i) {
            super(referenceQueue, k, i);
            this.b = rc3.o();
        }

        @Override // rc3.z
        public final a0<K, V, x<K, V>> a() {
            return this.b;
        }

        @Override // rc3.i
        public final V getValue() {
            return this.b.get();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface z<K, V, E extends i<K, V, E>> extends i<K, V, E> {
        a0<K, V, E> a();
    }

    public rc3(qc3 qc3Var, j<K, V, E, S> jVar) {
        this.d = Math.min(qc3Var.b(), 65536);
        this.e = qc3Var.d();
        this.f = jVar;
        int iMin = Math.min(qc3Var.c(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.d) {
            i5++;
            i4 <<= 1;
        }
        this.b = 32 - i5;
        this.f20438a = i4 - 1;
        this.c = e(i4);
        int i6 = iMin / i4;
        while (i3 < (i4 * i6 < iMin ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            m<K, V, E, S>[] mVarArr = this.c;
            if (i2 >= mVarArr.length) {
                return;
            }
            mVarArr[i2] = b(i3);
            i2++;
        }
    }

    public static <K, V> rc3<K, V, ? extends i<K, V, ?>, ?> a(qc3 qc3Var) {
        o oVarE = qc3Var.e();
        o oVar = o.STRONG;
        if (oVarE == oVar && qc3Var.f() == oVar) {
            return new rc3<>(qc3Var, p.a.h());
        }
        if (qc3Var.e() == oVar && qc3Var.f() == o.WEAK) {
            return new rc3<>(qc3Var, r.a.h());
        }
        o oVarE2 = qc3Var.e();
        o oVar2 = o.WEAK;
        if (oVarE2 == oVar2 && qc3Var.f() == oVar) {
            return new rc3<>(qc3Var, v.a.h());
        }
        if (qc3Var.e() == oVar2 && qc3Var.f() == oVar2) {
            return new rc3<>(qc3Var, x.a.h());
        }
        throw new AssertionError();
    }

    public static int h(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static <K, V, E extends i<K, V, E>> a0<K, V, E> o() {
        return (a0<K, V, E>) j;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    public m<K, V, E, S> b(int i2) {
        return this.f.e(this, i2);
    }

    public V c(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (m<K, V, E, S> mVar : this.c) {
            mVar.clear();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iD = d(obj);
        return i(iD).b(obj, iD);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        m<K, V, E, S>[] mVarArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (m<K, V, E, S> mVar : mVarArr) {
                int i3 = mVar.b;
                AtomicReferenceArray<E> atomicReferenceArray = mVar.e;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E eB = atomicReferenceArray.get(i4); eB != null; eB = eB.b()) {
                        V vT = mVar.t(eB);
                        if (vT != null && p().p(obj, vT)) {
                            return true;
                        }
                    }
                }
                j3 += (long) mVar.c;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    public int d(Object obj) {
        return h(this.e.q(obj));
    }

    public final m<K, V, E, S>[] e(int i2) {
        return new m[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.i;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.i = gVar;
        return gVar;
    }

    public void f(E e2) {
        int iC = e2.c();
        i(iC).H(e2, iC);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.CC.$default$forEach(this, biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g(a0<K, V, E> a0Var) {
        i iVarB = a0Var.b();
        int iC = iVarB.c();
        i(iC).I(iVarB.getKey(), iC, a0Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iD = d(obj);
        return i(iD).p(obj, iD);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return ConcurrentMap.CC.$default$getOrDefault(this, obj, obj2);
    }

    public m<K, V, E, S> i(int i2) {
        return this.c[(i2 >>> this.b) & this.f20438a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        m<K, V, E, S>[] mVarArr = this.c;
        long j2 = 0;
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            if (mVarArr[i2].b != 0) {
                return false;
            }
            j2 += (long) mVarArr[i2].c;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < mVarArr.length; i3++) {
            if (mVarArr[i3].b != 0) {
                return false;
            }
            j2 -= (long) mVarArr[i3].c;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.g;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.g = lVar;
        return lVar;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public Equivalence<Object> p() {
        return this.f.c().defaultEquivalence();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        dm4.o(k2);
        dm4.o(v2);
        int iD = d(k2);
        return i(iD).G(k2, iD, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k2, V v2) {
        dm4.o(k2);
        dm4.o(v2);
        int iD = d(k2);
        return i(iD).G(k2, iD, v2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iD = d(obj);
        return i(iD).J(obj, iD);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K k2, V v2, V v3) {
        dm4.o(k2);
        dm4.o(v3);
        if (v2 == null) {
            return false;
        }
        int iD = d(k2);
        return i(iD).N(k2, iD, v2, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (m<K, V, E, S> mVar : this.c) {
            j2 += (long) mVar.b;
        }
        return ku2.o(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.h;
        if (collection != null) {
            return collection;
        }
        u uVar = new u();
        this.h = uVar;
        return uVar;
    }

    public Object writeReplace() {
        return new n(this.f.b(), this.f.c(), this.e, this.f.c().defaultEquivalence(), this.d, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iD = d(obj);
        return i(iD).K(obj, iD, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V replace(K k2, V v2) {
        dm4.o(k2);
        dm4.o(v2);
        int iD = d(k2);
        return i(iD).M(k2, iD, v2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a0<Object, Object, e> {
        @Override // rc3.a0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public e b() {
            return null;
        }

        @Override // rc3.a0
        public Object get() {
            return null;
        }

        @Override // rc3.a0
        public void clear() {
        }

        @Override // rc3.a0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a0<Object, Object, e> a(ReferenceQueue<Object> referenceQueue, e eVar) {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class m<K, V, E extends i<K, V, E>, S extends m<K, V, E, S>> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rc3<K, V, E, S> f20447a;
        public volatile int b;
        public int c;
        public int d;
        public volatile AtomicReferenceArray<E> e;
        public final AtomicInteger f = new AtomicInteger();

        public m(rc3<K, V, E, S> rc3Var, int i) {
            this.f20447a = rc3Var;
            u(A(i));
        }

        public static <K, V, E extends i<K, V, E>> boolean v(E e) {
            return e.getValue() == null;
        }

        public AtomicReferenceArray<E> A(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public void D() {
            if ((this.f.incrementAndGet() & 63) == 0) {
                O();
            }
        }

        public void F() {
            Q();
        }

        public V G(K k, int i, V v, boolean z) {
            lock();
            try {
                F();
                int i2 = this.b + 1;
                if (i2 > this.d) {
                    o();
                    i2 = this.b + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(k, key)) {
                        V v2 = (V) iVarB.getValue();
                        if (v2 == null) {
                            this.c++;
                            V(iVarB, v);
                            this.b = this.b;
                            return null;
                        }
                        if (z) {
                            return v2;
                        }
                        this.c++;
                        V(iVarB, v);
                        return v2;
                    }
                }
                this.c++;
                i iVarD = this.f20447a.f.d(U(), k, i, iVar);
                V(iVarD, v);
                atomicReferenceArray.set(length, iVarD);
                this.b = i2;
                return null;
            } finally {
                unlock();
            }
        }

        public boolean H(E e, int i) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = i & (atomicReferenceArray.length() - 1);
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    if (iVarB == e) {
                        this.c++;
                        i iVarL = L(iVar, iVarB);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, iVarL);
                        this.b = i2;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        public boolean I(K k, int i, a0<K, V, E> a0Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(k, key)) {
                        if (((z) iVarB).a() != a0Var) {
                            return false;
                        }
                        this.c++;
                        i iVarL = L(iVar, iVarB);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, iVarL);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public V J(Object obj, int i) {
            lock();
            try {
                F();
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(obj, key)) {
                        V v = (V) iVarB.getValue();
                        if (v == null && !v(iVarB)) {
                            return null;
                        }
                        this.c++;
                        i iVarL = L(iVar, iVarB);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, iVarL);
                        this.b = i2;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        
            if (r8.f20447a.p().p(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            if (v(r4) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        
            r8.c++;
            r9 = L(r3, r4);
            r10 = r8.b - 1;
            r0.set(r1, r9);
            r8.b = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean K(Object obj, int i, Object obj2) {
            lock();
            try {
                F();
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                i iVarB = iVar;
                while (true) {
                    boolean z = false;
                    if (iVarB == null) {
                        return false;
                    }
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(obj, key)) {
                        break;
                    }
                    iVarB = iVarB.b();
                }
            } finally {
                unlock();
            }
        }

        public E L(E e, E e2) {
            int i = this.b;
            E e3 = (E) e2.b();
            while (e != e2) {
                i iVarC = c(e, e3);
                if (iVarC != null) {
                    e3 = (E) iVarC;
                } else {
                    i--;
                }
                e = (E) e.b();
            }
            this.b = i;
            return e3;
        }

        public V M(K k, int i, V v) {
            lock();
            try {
                F();
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(k, key)) {
                        V v2 = (V) iVarB.getValue();
                        if (v2 != null) {
                            this.c++;
                            V(iVarB, v);
                            return v2;
                        }
                        if (v(iVarB)) {
                            this.c++;
                            i iVarL = L(iVar, iVarB);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, iVarL);
                            this.b = i2;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        public boolean N(K k, int i, V v, V v2) {
            lock();
            try {
                F();
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVarB = iVar; iVarB != null; iVarB = iVarB.b()) {
                    Object key = iVarB.getKey();
                    if (iVarB.c() == i && key != null && this.f20447a.e.p(k, key)) {
                        Object value = iVarB.getValue();
                        if (value != null) {
                            if (!this.f20447a.p().p(v, value)) {
                                return false;
                            }
                            this.c++;
                            V(iVarB, v2);
                            return true;
                        }
                        if (v(iVarB)) {
                            this.c++;
                            i iVarL = L(iVar, iVarB);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, iVarL);
                            this.b = i2;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void O() {
            Q();
        }

        public void Q() {
            if (tryLock()) {
                try {
                    z();
                    this.f.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S U();

        public void V(E e, V v) {
            this.f20447a.f.a(U(), e, v);
        }

        public <T> void a(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        public void a0() {
            if (tryLock()) {
                try {
                    z();
                } finally {
                    unlock();
                }
            }
        }

        public boolean b(Object obj, int i) {
            try {
                boolean z = false;
                if (this.b == 0) {
                    return false;
                }
                i iVarS = s(obj, i);
                if (iVarS != null) {
                    if (iVarS.getValue() != null) {
                        z = true;
                    }
                }
                return z;
            } finally {
                D();
            }
        }

        public E c(E e, E e2) {
            return (E) this.f20447a.f.f(U(), e, e2);
        }

        public void clear() {
            if (this.b != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.e;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    w();
                    this.f.set(0);
                    this.c++;
                    this.b = 0;
                } finally {
                    unlock();
                }
            }
        }

        public void d(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f20447a.f((i) referencePoll);
                i++;
            } while (i != 16);
        }

        public void e(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f20447a.g((a0) referencePoll);
                i++;
            } while (i != 16);
        }

        public void o() {
            AtomicReferenceArray<E> atomicReferenceArray = this.e;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.b;
            AtomicReferenceArray<E> atomicReferenceArrayA = A(length << 1);
            this.d = (atomicReferenceArrayA.length() * 3) / 4;
            int length2 = atomicReferenceArrayA.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E eB = atomicReferenceArray.get(i2);
                if (eB != null) {
                    i iVarB = eB.b();
                    int iC = eB.c() & length2;
                    if (iVarB == null) {
                        atomicReferenceArrayA.set(iC, eB);
                    } else {
                        i iVar = eB;
                        while (iVarB != null) {
                            int iC2 = iVarB.c() & length2;
                            if (iC2 != iC) {
                                iVar = iVarB;
                                iC = iC2;
                            }
                            iVarB = iVarB.b();
                        }
                        atomicReferenceArrayA.set(iC, iVar);
                        while (eB != iVar) {
                            int iC3 = eB.c() & length2;
                            i iVarC = c(eB, (i) atomicReferenceArrayA.get(iC3));
                            if (iVarC != null) {
                                atomicReferenceArrayA.set(iC3, iVarC);
                            } else {
                                i--;
                            }
                            eB = eB.b();
                        }
                    }
                }
            }
            this.e = atomicReferenceArrayA;
            this.b = i;
        }

        public V p(Object obj, int i) {
            try {
                i iVarS = s(obj, i);
                if (iVarS == null) {
                    D();
                    return null;
                }
                V v = (V) iVarS.getValue();
                if (v == null) {
                    a0();
                }
                return v;
            } finally {
                D();
            }
        }

        public E q(Object obj, int i) {
            if (this.b == 0) {
                return null;
            }
            for (E e = (E) r(i); e != null; e = (E) e.b()) {
                if (e.c() == i) {
                    Object key = e.getKey();
                    if (key == null) {
                        a0();
                    } else if (this.f20447a.e.p(obj, key)) {
                        return e;
                    }
                }
            }
            return null;
        }

        public E r(int i) {
            return this.e.get(i & (r0.length() - 1));
        }

        public E s(Object obj, int i) {
            return (E) q(obj, i);
        }

        public V t(E e) {
            if (e.getKey() == null) {
                a0();
                return null;
            }
            V v = (V) e.getValue();
            if (v != null) {
                return v;
            }
            a0();
            return null;
        }

        public void u(AtomicReferenceArray<E> atomicReferenceArray) {
            this.d = (atomicReferenceArray.length() * 3) / 4;
            this.e = atomicReferenceArray;
        }

        public void w() {
        }

        public void z() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class q<K, V> extends m<K, V, p<K, V>, q<K, V>> {
        public q(rc3<K, V, p<K, V>, q<K, V>> rc3Var, int i) {
            super(rc3Var, i);
        }

        @Override // rc3.m
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public q<K, V> U() {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class s<K, V> extends m<K, V, r<K, V>, s<K, V>> {
        public final ReferenceQueue<V> g;

        public s(rc3<K, V, r<K, V>, s<K, V>> rc3Var, int i) {
            super(rc3Var, i);
            this.g = new ReferenceQueue<>();
        }

        @Override // rc3.m
        public void w() {
            a(this.g);
        }

        @Override // rc3.m
        public void z() {
            e(this.g);
        }

        @Override // rc3.m
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public s<K, V> U() {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class w<K, V> extends m<K, V, v<K, V>, w<K, V>> {
        public final ReferenceQueue<K> g;

        public w(rc3<K, V, v<K, V>, w<K, V>> rc3Var, int i) {
            super(rc3Var, i);
            this.g = new ReferenceQueue<>();
        }

        @Override // rc3.m
        public void w() {
            a(this.g);
        }

        @Override // rc3.m
        public void z() {
            d(this.g);
        }

        @Override // rc3.m
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public w<K, V> U() {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class y<K, V> extends m<K, V, x<K, V>, y<K, V>> {
        public final ReferenceQueue<K> g;
        public final ReferenceQueue<V> h;

        public y(rc3<K, V, x<K, V>, y<K, V>> rc3Var, int i) {
            super(rc3Var, i);
            this.g = new ReferenceQueue<>();
            this.h = new ReferenceQueue<>();
        }

        @Override // rc3.m
        public void w() {
            a(this.g);
        }

        @Override // rc3.m
        public void z() {
            d(this.g);
            e(this.h);
        }

        @Override // rc3.m
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public y<K, V> U() {
            return this;
        }
    }
}

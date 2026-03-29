package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bj0<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Object j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f1727a;
    public transient int[] b;
    public transient Object[] c;
    public transient Object[] d;
    public transient int e;
    public transient int f;
    public transient Set<K> g;
    public transient Set<Map.Entry<K, V>> h;
    public transient Collection<V> i;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends bj0<K, V>.e<K> {
        public a() {
            super(bj0.this, null);
        }

        @Override // bj0.e
        public K b(int i) {
            return (K) bj0.this.U(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends bj0<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(bj0.this, null);
        }

        @Override // bj0.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i) {
            return new g(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends bj0<K, V>.e<V> {
        public c() {
            super(bj0.this, null);
        }

        @Override // bj0.e
        public V b(int i) {
            return (V) bj0.this.p0(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            bj0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapI = bj0.this.I();
            if (mapI != null) {
                return mapI.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iR = bj0.this.R(entry.getKey());
            return iR != -1 && m54.a(bj0.this.p0(iR), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return bj0.this.K();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapI = bj0.this.I();
            if (mapI != null) {
                return mapI.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (bj0.this.c0()) {
                return false;
            }
            int iO = bj0.this.O();
            int iF = dj0.f(entry.getKey(), entry.getValue(), iO, bj0.this.g0(), bj0.this.e0(), bj0.this.f0(), bj0.this.h0());
            if (iF == -1) {
                return false;
            }
            bj0.this.b0(iF, iO);
            bj0.e(bj0.this);
            bj0.this.Q();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bj0.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            bj0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return bj0.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return bj0.this.a0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapI = bj0.this.I();
            return mapI != null ? mapI.keySet().remove(obj) : bj0.this.d0(obj) != bj0.j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bj0.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class g extends m1<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f1731a;
        public int b;

        public g(int i) {
            this.f1731a = (K) bj0.this.U(i);
            this.b = i;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public K getKey() {
            return this.f1731a;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapI = bj0.this.I();
            if (mapI != null) {
                return (V) a44.a(mapI.get(this.f1731a));
            }
            p();
            int i = this.b;
            return i == -1 ? (V) a44.b() : (V) bj0.this.p0(i);
        }

        public final void p() {
            int i = this.b;
            if (i == -1 || i >= bj0.this.size() || !m54.a(this.f1731a, bj0.this.U(this.b))) {
                this.b = bj0.this.R(this.f1731a);
            }
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V setValue(V v) {
            Map<K, V> mapI = bj0.this.I();
            if (mapI != null) {
                return (V) a44.a(mapI.put(this.f1731a, v));
            }
            p();
            int i = this.b;
            if (i == -1) {
                bj0.this.put(this.f1731a, v);
                return (V) a44.b();
            }
            V v2 = (V) bj0.this.p0(i);
            bj0.this.o0(this.b, v);
            return v2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            bj0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return bj0.this.q0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return bj0.this.size();
        }
    }

    public bj0() {
        S(3);
    }

    public static <K, V> bj0<K, V> A() {
        return new bj0<>();
    }

    public static <K, V> bj0<K, V> H(int i) {
        return new bj0<>(i);
    }

    public static /* synthetic */ int e(bj0 bj0Var) {
        int i = bj0Var.f;
        bj0Var.f = i - 1;
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Invalid size: " + i);
        }
        S(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itK = K();
        while (itK.hasNext()) {
            Map.Entry<K, V> next = itK.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public Set<Map.Entry<K, V>> D() {
        return new d();
    }

    public Map<K, V> E(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Set<K> F() {
        return new f();
    }

    public Collection<V> G() {
        return new h();
    }

    public Map<K, V> I() {
        Object obj = this.f1727a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int J(int i) {
        return e0()[i];
    }

    public Iterator<Map.Entry<K, V>> K() {
        Map<K, V> mapI = I();
        return mapI != null ? mapI.entrySet().iterator() : new b();
    }

    public int M() {
        return isEmpty() ? -1 : 0;
    }

    public int N(int i) {
        int i2 = i + 1;
        if (i2 < this.f) {
            return i2;
        }
        return -1;
    }

    public final int O() {
        return (1 << (this.e & 31)) - 1;
    }

    public void Q() {
        this.e += 32;
    }

    public final int R(Object obj) {
        if (c0()) {
            return -1;
        }
        int iD = vg2.d(obj);
        int iO = O();
        int iH = dj0.h(g0(), iD & iO);
        if (iH == 0) {
            return -1;
        }
        int iB = dj0.b(iD, iO);
        do {
            int i = iH - 1;
            int iJ = J(i);
            if (dj0.b(iJ, iO) == iB && m54.a(obj, U(i))) {
                return i;
            }
            iH = dj0.c(iJ, iO);
        } while (iH != 0);
        return -1;
    }

    public void S(int i) {
        dm4.e(i >= 0, "Expected size must be >= 0");
        this.e = ku2.h(i, 1, 1073741823);
    }

    public void T(int i, K k, V v, int i2, int i3) {
        l0(i, dj0.d(i2, 0, i3));
        n0(i, k);
        o0(i, v);
    }

    public final K U(int i) {
        return (K) f0()[i];
    }

    public Iterator<K> a0() {
        Map<K, V> mapI = I();
        return mapI != null ? mapI.keySet().iterator() : new a();
    }

    public void b0(int i, int i2) {
        Object objG0 = g0();
        int[] iArrE0 = e0();
        Object[] objArrF0 = f0();
        Object[] objArrH0 = h0();
        int size = size() - 1;
        if (i >= size) {
            objArrF0[i] = null;
            objArrH0[i] = null;
            iArrE0[i] = 0;
            return;
        }
        Object obj = objArrF0[size];
        objArrF0[i] = obj;
        objArrH0[i] = objArrH0[size];
        objArrF0[size] = null;
        objArrH0[size] = null;
        iArrE0[i] = iArrE0[size];
        iArrE0[size] = 0;
        int iD = vg2.d(obj) & i2;
        int iH = dj0.h(objG0, iD);
        int i3 = size + 1;
        if (iH == i3) {
            dj0.i(objG0, iD, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrE0[i4];
            int iC = dj0.c(i5, i2);
            if (iC == i3) {
                iArrE0[i4] = dj0.d(i5, i + 1, i2);
                return;
            }
            iH = iC;
        }
    }

    public boolean c0() {
        return this.f1727a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (c0()) {
            return;
        }
        Q();
        Map<K, V> mapI = I();
        if (mapI != null) {
            this.e = ku2.h(size(), 3, 1073741823);
            mapI.clear();
            this.f1727a = null;
            this.f = 0;
            return;
        }
        Arrays.fill(f0(), 0, this.f, (Object) null);
        Arrays.fill(h0(), 0, this.f, (Object) null);
        dj0.g(g0());
        Arrays.fill(e0(), 0, this.f, 0);
        this.f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapI = I();
        return mapI != null ? mapI.containsKey(obj) : R(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapI = I();
        if (mapI != null) {
            return mapI.containsValue(obj);
        }
        for (int i = 0; i < this.f; i++) {
            if (m54.a(obj, p0(i))) {
                return true;
            }
        }
        return false;
    }

    public final Object d0(Object obj) {
        if (c0()) {
            return j;
        }
        int iO = O();
        int iF = dj0.f(obj, null, iO, g0(), e0(), f0(), null);
        if (iF == -1) {
            return j;
        }
        V vP0 = p0(iF);
        b0(iF, iO);
        this.f--;
        Q();
        return vP0;
    }

    public final int[] e0() {
        int[] iArr = this.b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.h;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setD = D();
        this.h = setD;
        return setD;
    }

    public final Object[] f0() {
        Object[] objArr = this.c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object g0() {
        Object obj = this.f1727a;
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapI = I();
        if (mapI != null) {
            return mapI.get(obj);
        }
        int iR = R(obj);
        if (iR == -1) {
            return null;
        }
        u(iR);
        return p0(iR);
    }

    public final Object[] h0() {
        Object[] objArr = this.d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void i0(int i) {
        this.b = Arrays.copyOf(e0(), i);
        this.c = Arrays.copyOf(f0(), i);
        this.d = Arrays.copyOf(h0(), i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void j0(int i) {
        int iMin;
        int length = e0().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        i0(iMin);
    }

    public final int k0(int i, int i2, int i3, int i4) {
        Object objA = dj0.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            dj0.i(objA, i3 & i5, i4 + 1);
        }
        Object objG0 = g0();
        int[] iArrE0 = e0();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = dj0.h(objG0, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrE0[i7];
                int iB = dj0.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = dj0.h(objA, i9);
                dj0.i(objA, i9, iH);
                iArrE0[i7] = dj0.d(iB, iH2, i5);
                iH = dj0.c(i8, i);
            }
        }
        this.f1727a = objA;
        m0(i5);
        return i5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.g;
        if (set != null) {
            return set;
        }
        Set<K> setF = F();
        this.g = setF;
        return setF;
    }

    public final void l0(int i, int i2) {
        e0()[i] = i2;
    }

    public final void m0(int i) {
        this.e = dj0.d(this.e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final void n0(int i, K k) {
        f0()[i] = k;
    }

    public final void o0(int i, V v) {
        h0()[i] = v;
    }

    public final V p0(int i) {
        return (V) h0()[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        int iK0;
        int i;
        if (c0()) {
            w();
        }
        Map<K, V> mapI = I();
        if (mapI != null) {
            return mapI.put(k, v);
        }
        int[] iArrE0 = e0();
        Object[] objArrF0 = f0();
        Object[] objArrH0 = h0();
        int i2 = this.f;
        int i3 = i2 + 1;
        int iD = vg2.d(k);
        int iO = O();
        int i4 = iD & iO;
        int iH = dj0.h(g0(), i4);
        if (iH != 0) {
            int iB = dj0.b(iD, iO);
            int i5 = 0;
            while (true) {
                int i6 = iH - 1;
                int i7 = iArrE0[i6];
                if (dj0.b(i7, iO) == iB && m54.a(k, objArrF0[i6])) {
                    V v2 = (V) objArrH0[i6];
                    objArrH0[i6] = v;
                    u(i6);
                    return v2;
                }
                int iC = dj0.c(i7, iO);
                i5++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i5 >= 9) {
                        return z().put(k, v);
                    }
                    if (i3 > iO) {
                        iK0 = k0(iO, dj0.e(iO), iD, i2);
                    } else {
                        iArrE0[i6] = dj0.d(i7, i3, iO);
                    }
                }
            }
            i = iO;
        } else if (i3 > iO) {
            iK0 = k0(iO, dj0.e(iO), iD, i2);
            i = iK0;
        } else {
            dj0.i(g0(), i4, i3);
            i = iO;
        }
        j0(i3);
        T(i2, k, v, iD, i);
        this.f = i3;
        Q();
        return null;
    }

    public Iterator<V> q0() {
        Map<K, V> mapI = I();
        return mapI != null ? mapI.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapI = I();
        if (mapI != null) {
            return mapI.remove(obj);
        }
        V v = (V) d0(obj);
        if (v == j) {
            return null;
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapI = I();
        return mapI != null ? mapI.size() : this.f;
    }

    public int v(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.i;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionG = G();
        this.i = collectionG;
        return collectionG;
    }

    public int w() {
        dm4.u(c0(), "Arrays already allocated");
        int i = this.e;
        int iJ = dj0.j(i);
        this.f1727a = dj0.a(iJ);
        m0(iJ - 1);
        this.b = new int[i];
        this.c = new Object[i];
        this.d = new Object[i];
        return i;
    }

    public Map<K, V> z() {
        Map<K, V> mapE = E(O() + 1);
        int iM = M();
        while (iM >= 0) {
            mapE.put(U(iM), p0(iM));
            iM = N(iM);
        }
        this.f1727a = mapE;
        this.b = null;
        this.c = null;
        this.d = null;
        Q();
        return mapE;
    }

    public bj0(int i) {
        S(i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1729a;
        public int b;
        public int c;

        public e() {
            this.f1729a = bj0.this.e;
            this.b = bj0.this.M();
            this.c = -1;
        }

        public final void a() {
            if (bj0.this.e != this.f1729a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        public void c() {
            this.f1729a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            T tB = b(i);
            this.b = bj0.this.N(this.b);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            sg0.e(this.c >= 0);
            c();
            bj0 bj0Var = bj0.this;
            bj0Var.remove(bj0Var.U(this.c));
            this.b = bj0.this.v(this.b, this.c);
            this.c = -1;
        }

        public /* synthetic */ e(bj0 bj0Var, a aVar) {
            this();
        }
    }

    public void u(int i) {
    }
}

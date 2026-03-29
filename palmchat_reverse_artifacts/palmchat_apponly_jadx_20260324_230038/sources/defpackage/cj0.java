package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cj0<E> extends AbstractSet<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f1994a;
    public transient int[] b;
    public transient Object[] c;
    public transient int d;
    public transient int e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1995a;
        public int b;
        public int c = -1;

        public a() {
            this.f1995a = cj0.this.d;
            this.b = cj0.this.v();
        }

        public final void a() {
            if (cj0.this.d != this.f1995a) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f1995a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            E e = (E) cj0.this.t(i);
            this.b = cj0.this.w(this.b);
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            sg0.e(this.c >= 0);
            b();
            cj0 cj0Var = cj0.this;
            cj0Var.remove(cj0Var.t(this.c));
            this.b = cj0.this.c(this.b, this.c);
            this.c = -1;
        }
    }

    public cj0(int i) {
        B(i);
    }

    public static <E> cj0<E> r(int i) {
        return new cj0<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Invalid size: " + i);
        }
        B(i);
        for (int i2 = 0; i2 < i; i2++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public void A() {
        this.d += 32;
    }

    public void B(int i) {
        dm4.e(i >= 0, "Expected size must be >= 0");
        this.d = ku2.h(i, 1, 1073741823);
    }

    public void C(int i, E e, int i2, int i3) {
        P(i, dj0.d(i2, 0, i3));
        O(i, e);
    }

    public void D(int i, int i2) {
        Object objK = K();
        int[] iArrI = I();
        Object[] objArrG = G();
        int size = size() - 1;
        if (i >= size) {
            objArrG[i] = null;
            iArrI[i] = 0;
            return;
        }
        Object obj = objArrG[size];
        objArrG[i] = obj;
        objArrG[size] = null;
        iArrI[i] = iArrI[size];
        iArrI[size] = 0;
        int iD = vg2.d(obj) & i2;
        int iH = dj0.h(objK, iD);
        int i3 = size + 1;
        if (iH == i3) {
            dj0.i(objK, iD, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrI[i4];
            int iC = dj0.c(i5, i2);
            if (iC == i3) {
                iArrI[i4] = dj0.d(i5, i + 1, i2);
                return;
            }
            iH = iC;
        }
    }

    public boolean F() {
        return this.f1994a == null;
    }

    public final Object[] G() {
        Object[] objArr = this.c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int[] I() {
        int[] iArr = this.b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object K() {
        Object obj = this.f1994a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void L(int i) {
        this.b = Arrays.copyOf(I(), i);
        this.c = Arrays.copyOf(G(), i);
    }

    public final void M(int i) {
        int iMin;
        int length = I().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        L(iMin);
    }

    public final int N(int i, int i2, int i3, int i4) {
        Object objA = dj0.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            dj0.i(objA, i3 & i5, i4 + 1);
        }
        Object objK = K();
        int[] iArrI = I();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = dj0.h(objK, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrI[i7];
                int iB = dj0.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = dj0.h(objA, i9);
                dj0.i(objA, i9, iH);
                iArrI[i7] = dj0.d(iB, iH2, i5);
                iH = dj0.c(i8, i);
            }
        }
        this.f1994a = objA;
        Q(i5);
        return i5;
    }

    public final void O(int i, E e) {
        G()[i] = e;
    }

    public final void P(int i, int i2) {
        I()[i] = i2;
    }

    public final void Q(int i) {
        this.d = dj0.d(this.d, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        if (F()) {
            o();
        }
        Set<E> setS = s();
        if (setS != null) {
            return setS.add(e);
        }
        int[] iArrI = I();
        Object[] objArrG = G();
        int i = this.e;
        int i2 = i + 1;
        int iD = vg2.d(e);
        int iZ = z();
        int i3 = iD & iZ;
        int iH = dj0.h(K(), i3);
        if (iH != 0) {
            int iB = dj0.b(iD, iZ);
            int i4 = 0;
            while (true) {
                int i5 = iH - 1;
                int i6 = iArrI[i5];
                if (dj0.b(i6, iZ) == iB && m54.a(e, objArrG[i5])) {
                    return false;
                }
                int iC = dj0.c(i6, iZ);
                i4++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i4 >= 9) {
                        return p().add(e);
                    }
                    if (i2 > iZ) {
                        iZ = N(iZ, dj0.e(iZ), iD, i);
                    } else {
                        iArrI[i5] = dj0.d(i6, i2, iZ);
                    }
                }
            }
        } else if (i2 > iZ) {
            iZ = N(iZ, dj0.e(iZ), iD, i);
        } else {
            dj0.i(K(), i3, i2);
        }
        M(i2);
        C(i, e, iD, iZ);
        this.e = i2;
        A();
        return true;
    }

    public int c(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (F()) {
            return;
        }
        A();
        Set<E> setS = s();
        if (setS != null) {
            this.d = ku2.h(size(), 3, 1073741823);
            setS.clear();
            this.f1994a = null;
            this.e = 0;
            return;
        }
        Arrays.fill(G(), 0, this.e, (Object) null);
        dj0.g(K());
        Arrays.fill(I(), 0, this.e, 0);
        this.e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (F()) {
            return false;
        }
        Set<E> setS = s();
        if (setS != null) {
            return setS.contains(obj);
        }
        int iD = vg2.d(obj);
        int iZ = z();
        int iH = dj0.h(K(), iD & iZ);
        if (iH == 0) {
            return false;
        }
        int iB = dj0.b(iD, iZ);
        do {
            int i = iH - 1;
            int iU = u(i);
            if (dj0.b(iU, iZ) == iB && m54.a(obj, t(i))) {
                return true;
            }
            iH = dj0.c(iU, iZ);
        } while (iH != 0);
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> setS = s();
        return setS != null ? setS.iterator() : new a();
    }

    public int o() {
        dm4.u(F(), "Arrays already allocated");
        int i = this.d;
        int iJ = dj0.j(i);
        this.f1994a = dj0.a(iJ);
        Q(iJ - 1);
        this.b = new int[i];
        this.c = new Object[i];
        return i;
    }

    public Set<E> p() {
        Set<E> setQ = q(z() + 1);
        int iV = v();
        while (iV >= 0) {
            setQ.add(t(iV));
            iV = w(iV);
        }
        this.f1994a = setQ;
        this.b = null;
        this.c = null;
        A();
        return setQ;
    }

    public final Set<E> q(int i) {
        return new LinkedHashSet(i, 1.0f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (F()) {
            return false;
        }
        Set<E> setS = s();
        if (setS != null) {
            return setS.remove(obj);
        }
        int iZ = z();
        int iF = dj0.f(obj, null, iZ, K(), I(), G(), null);
        if (iF == -1) {
            return false;
        }
        D(iF, iZ);
        this.e--;
        A();
        return true;
    }

    public Set<E> s() {
        Object obj = this.f1994a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> setS = s();
        return setS != null ? setS.size() : this.e;
    }

    public final E t(int i) {
        return (E) G()[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (F()) {
            return new Object[0];
        }
        Set<E> setS = s();
        return setS != null ? setS.toArray() : Arrays.copyOf(G(), this.e);
    }

    public final int u(int i) {
        return I()[i];
    }

    public int v() {
        return isEmpty() ? -1 : 0;
    }

    public int w(int i) {
        int i2 = i + 1;
        if (i2 < this.e) {
            return i2;
        }
        return -1;
    }

    public final int z() {
        return (1 << (this.d & 31)) - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (F()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> setS = s();
        if (setS != null) {
            return (T[]) setS.toArray(tArr);
        }
        return (T[]) j54.h(G(), 0, this.e, tArr);
    }
}

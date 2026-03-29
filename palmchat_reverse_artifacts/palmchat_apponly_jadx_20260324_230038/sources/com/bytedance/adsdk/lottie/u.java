package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class u<E> implements Collection<E>, Set<E> {
    private static int iz;
    private static int n;
    private static Object[] pn;
    private static Object[] x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5006a;
    private k<E, E> jk;
    int nr;
    Object[] u;
    private static final int[] fx = new int[0];
    private static final Object[] b = new Object[0];

    public u() {
        this(0);
    }

    private void b(int i) {
        if (i == 8) {
            synchronized (u.class) {
                Object[] objArr = x;
                if (objArr != null) {
                    this.u = objArr;
                    x = (Object[]) objArr[0];
                    this.f5006a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    n--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (u.class) {
                Object[] objArr2 = pn;
                if (objArr2 != null) {
                    this.u = objArr2;
                    pn = (Object[]) objArr2[0];
                    this.f5006a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    iz--;
                    return;
                }
            }
        }
        this.f5006a = new int[i];
        this.u = new Object[i];
    }

    private int u(Object obj, int i) {
        int i2 = this.nr;
        if (i2 == 0) {
            return -1;
        }
        int iU = nr.u(this.f5006a, i2, i);
        if (iU < 0 || obj.equals(this.u[iU])) {
            return iU;
        }
        int i3 = iU + 1;
        while (i3 < i2 && this.f5006a[i3] == i) {
            if (obj.equals(this.u[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iU - 1; i4 >= 0 && this.f5006a[i4] == i; i4--) {
            if (obj.equals(this.u[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iU;
        if (e == null) {
            iU = u();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iU = u(e, iHashCode);
        }
        if (iU >= 0) {
            return false;
        }
        int i2 = ~iU;
        int i3 = this.nr;
        int[] iArr = this.f5006a;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.u;
            b(i4);
            int[] iArr2 = this.f5006a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.u, 0, objArr.length);
            }
            u(iArr, objArr, this.nr);
        }
        int i5 = this.nr;
        if (i2 < i5) {
            int[] iArr3 = this.f5006a;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.u;
            System.arraycopy(objArr2, i2, objArr2, i6, this.nr - i2);
        }
        this.f5006a[i2] = i;
        this.u[i2] = e;
        this.nr++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        u(this.nr + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.nr;
        if (i != 0) {
            u(this.f5006a, this.u, i);
            this.f5006a = fx;
            this.u = b;
            this.nr = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return u(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.nr; i++) {
                try {
                    if (!set.contains(nr(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E fx(int i) {
        Object[] objArr = this.u;
        E e = (E) objArr[i];
        int i2 = this.nr;
        if (i2 <= 1) {
            u(this.f5006a, objArr, i2);
            this.f5006a = fx;
            this.u = b;
            this.nr = 0;
        } else {
            int[] iArr = this.f5006a;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.nr = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.u;
                    System.arraycopy(objArr2, i4, objArr2, i, this.nr - i);
                }
                this.u[this.nr] = null;
            } else {
                b(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.nr--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f5006a, 0, i);
                    System.arraycopy(objArr, 0, this.u, 0, i);
                }
                int i5 = this.nr;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.f5006a, i, i5 - i);
                    System.arraycopy(objArr, i6, this.u, i, this.nr - i);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f5006a;
        int i = this.nr;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.nr <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return nr().b().iterator();
    }

    public E nr(int i) {
        return (E) this.u[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iU = u(obj);
        if (iU < 0) {
            return false;
        }
        fx(iU);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.nr - 1; i >= 0; i--) {
            if (!collection.contains(this.u[i])) {
                fx(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.nr;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.nr;
        Object[] objArr = new Object[i];
        System.arraycopy(this.u, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.nr * 14);
        sb.append('{');
        for (int i = 0; i < this.nr; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eNr = nr(i);
            if (eNr != this) {
                sb.append(eNr);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public u(int i) {
        if (i == 0) {
            this.f5006a = fx;
            this.u = b;
        } else {
            b(i);
        }
        this.nr = 0;
    }

    private k<E, E> nr() {
        if (this.jk == null) {
            this.jk = new k<E, E>() { // from class: com.bytedance.adsdk.lottie.u.1
                @Override // com.bytedance.adsdk.lottie.k
                public void fx() {
                    u.this.clear();
                }

                @Override // com.bytedance.adsdk.lottie.k
                public Map<E, E> nr() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.k
                public int u() {
                    return u.this.nr;
                }

                @Override // com.bytedance.adsdk.lottie.k
                public Object u(int i, int i2) {
                    return u.this.u[i];
                }

                @Override // com.bytedance.adsdk.lottie.k
                public int u(Object obj) {
                    return u.this.u(obj);
                }

                @Override // com.bytedance.adsdk.lottie.k
                public void u(int i) {
                    u.this.fx(i);
                }
            };
        }
        return this.jk;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.nr) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.nr));
        }
        System.arraycopy(this.u, 0, tArr, 0, this.nr);
        int length = tArr.length;
        int i = this.nr;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    private int u() {
        int i = this.nr;
        if (i == 0) {
            return -1;
        }
        int iU = nr.u(this.f5006a, i, 0);
        if (iU < 0 || this.u[iU] == null) {
            return iU;
        }
        int i2 = iU + 1;
        while (i2 < i && this.f5006a[i2] == 0) {
            if (this.u[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iU - 1; i3 >= 0 && this.f5006a[i3] == 0; i3--) {
            if (this.u[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void u(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (u.class) {
                if (n < 10) {
                    objArr[0] = x;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    x = objArr;
                    n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (u.class) {
                if (iz < 10) {
                    objArr[0] = pn;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    pn = objArr;
                    iz++;
                }
            }
        }
    }

    public void u(int i) {
        int[] iArr = this.f5006a;
        if (iArr.length < i) {
            Object[] objArr = this.u;
            b(i);
            int i2 = this.nr;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f5006a, 0, i2);
                System.arraycopy(objArr, 0, this.u, 0, this.nr);
            }
            u(iArr, objArr, this.nr);
        }
    }

    public int u(Object obj) {
        return obj == null ? u() : u(obj, obj.hashCode());
    }
}

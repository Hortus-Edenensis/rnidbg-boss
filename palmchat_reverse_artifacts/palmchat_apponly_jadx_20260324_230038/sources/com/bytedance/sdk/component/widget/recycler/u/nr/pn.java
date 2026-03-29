package com.bytedance.sdk.component.widget.recycler.u.nr;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn<K, V> {
    static int b;
    static Object[] fx;
    static int nr;
    static Object[] u;
    int[] pn = nr.u;
    Object[] iz = nr.fx;
    int x = 0;

    private void b(int i) {
        if (i == 8) {
            synchronized (u.class) {
                Object[] objArr = fx;
                if (objArr != null) {
                    this.iz = objArr;
                    fx = (Object[]) objArr[0];
                    this.pn = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    b--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (u.class) {
                Object[] objArr2 = u;
                if (objArr2 != null) {
                    this.iz = objArr2;
                    u = (Object[]) objArr2[0];
                    this.pn = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    nr--;
                    return;
                }
            }
        }
        this.pn = new int[i];
        this.iz = new Object[i << 1];
    }

    private static int u(int[] iArr, int i, int i2) {
        try {
            return nr.u(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.x;
        if (i > 0) {
            int[] iArr = this.pn;
            Object[] objArr = this.iz;
            this.pn = nr.u;
            this.iz = nr.fx;
            this.x = 0;
            u(iArr, objArr, i);
        }
        if (this.x > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return u(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return nr(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof pn) {
            pn pnVar = (pn) obj;
            if (size() != pnVar.size()) {
                return false;
            }
            for (int i = 0; i < this.x; i++) {
                try {
                    K kU = u(i);
                    V vNr = nr(i);
                    Object obj2 = pnVar.get(kU);
                    if (vNr == null) {
                        if (obj2 != null || !pnVar.containsKey(kU)) {
                            return false;
                        }
                    } else if (!vNr.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.x; i2++) {
            try {
                K kU2 = u(i2);
                V vNr2 = nr(i2);
                Object obj3 = map.get(kU2);
                if (vNr2 == null) {
                    if (obj3 != null || !map.containsKey(kU2)) {
                        return false;
                    }
                } else if (!vNr2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public V fx(int i) {
        Object[] objArr = this.iz;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.x;
        int i4 = 0;
        if (i3 <= 1) {
            u(this.pn, objArr, i3);
            this.pn = nr.u;
            this.iz = nr.fx;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.pn;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.iz;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.iz;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                b(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.x) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.pn, 0, i);
                    System.arraycopy(objArr, 0, this.iz, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.pn, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.iz, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.x) {
            throw new ConcurrentModificationException();
        }
        this.x = i4;
        return v;
    }

    public V get(Object obj) {
        int iU = u(obj);
        if (iU >= 0) {
            return (V) this.iz[(iU << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.pn;
        Object[] objArr = this.iz;
        int i = this.x;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.x <= 0;
    }

    public int nr(Object obj) {
        int i = this.x * 2;
        Object[] objArr = this.iz;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V put(K k, V v) {
        int i;
        int iU;
        int i2 = this.x;
        if (k == null) {
            iU = u();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iU = u(k, iHashCode);
        }
        if (iU >= 0) {
            int i3 = (iU << 1) + 1;
            Object[] objArr = this.iz;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iU;
        int[] iArr = this.pn;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.iz;
            b(i5);
            if (i2 != this.x) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.pn;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.iz, 0, objArr2.length);
            }
            u(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.pn;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.iz;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.x - i4) << 1);
        }
        int i7 = this.x;
        if (i2 == i7) {
            int[] iArr4 = this.pn;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.iz;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.x = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iU = u(obj);
        if (iU >= 0) {
            return fx(iU);
        }
        return null;
    }

    public int size() {
        return this.x;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.x * 28);
        sb.append('{');
        for (int i = 0; i < this.x; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kU = u(i);
            if (kU != this) {
                sb.append(kU);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vNr = nr(i);
            if (vNr != this) {
                sb.append(vNr);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int u(Object obj, int i) {
        int i2 = this.x;
        if (i2 == 0) {
            return -1;
        }
        int iU = u(this.pn, i2, i);
        if (iU < 0 || obj.equals(this.iz[iU << 1])) {
            return iU;
        }
        int i3 = iU + 1;
        while (i3 < i2 && this.pn[i3] == i) {
            if (obj.equals(this.iz[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iU - 1; i4 >= 0 && this.pn[i4] == i; i4--) {
            if (obj.equals(this.iz[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public V nr(int i) {
        return (V) this.iz[(i << 1) + 1];
    }

    int u() {
        int i = this.x;
        if (i == 0) {
            return -1;
        }
        int iU = u(this.pn, i, 0);
        if (iU < 0 || this.iz[iU << 1] == null) {
            return iU;
        }
        int i2 = iU + 1;
        while (i2 < i && this.pn[i2] == 0) {
            if (this.iz[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iU - 1; i3 >= 0 && this.pn[i3] == 0; i3--) {
            if (this.iz[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void u(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (u.class) {
                if (b < 10) {
                    objArr[0] = fx;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    fx = objArr;
                    b++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (u.class) {
                if (nr < 10) {
                    objArr[0] = u;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    u = objArr;
                    nr++;
                }
            }
        }
    }

    public int u(Object obj) {
        return obj == null ? u() : u(obj, obj.hashCode());
    }

    public K u(int i) {
        return (K) this.iz[i << 1];
    }
}

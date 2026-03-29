package com.bytedance.sdk.component.widget.recycler.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx<E> implements Cloneable {
    private static final Object u = new Object();
    private Object[] b;
    private long[] fx;
    private boolean nr;
    private int pn;

    public fx() {
        this(10);
    }

    private void b() {
        int i = this.pn;
        long[] jArr = this.fx;
        Object[] objArr = this.b;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != u) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.nr = false;
        this.pn = i2;
    }

    public void delete(long j) {
        int iU = nr.u(this.fx, this.pn, j);
        if (iU >= 0) {
            Object[] objArr = this.b;
            Object obj = objArr[iU];
            Object obj2 = u;
            if (obj != obj2) {
                objArr[iU] = obj2;
                this.nr = true;
            }
        }
    }

    public E fx(int i) {
        if (this.nr) {
            b();
        }
        return (E) this.b[i];
    }

    public void nr(long j, E e) {
        int iU = nr.u(this.fx, this.pn, j);
        if (iU >= 0) {
            this.b[iU] = e;
            return;
        }
        int i = ~iU;
        int i2 = this.pn;
        if (i < i2) {
            Object[] objArr = this.b;
            if (objArr[i] == u) {
                this.fx[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.nr && i2 >= this.fx.length) {
            b();
            i = ~nr.u(this.fx, this.pn, j);
        }
        int i3 = this.pn;
        if (i3 >= this.fx.length) {
            int iU2 = nr.u(i3 + 1);
            long[] jArr = new long[iU2];
            Object[] objArr2 = new Object[iU2];
            long[] jArr2 = this.fx;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.b;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.fx = jArr;
            this.b = objArr2;
        }
        int i4 = this.pn;
        if (i4 - i != 0) {
            long[] jArr3 = this.fx;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.b;
            System.arraycopy(objArr4, i, objArr4, i5, this.pn - i);
        }
        this.fx[i] = j;
        this.b[i] = e;
        this.pn++;
    }

    public String toString() {
        if (nr() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.pn * 28);
        sb.append('{');
        for (int i = 0; i < this.pn; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(nr(i));
            sb.append('=');
            E eFx = fx(i);
            if (eFx != this) {
                sb.append(eFx);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public fx<E> clone() {
        try {
            fx<E> fxVar = (fx) super.clone();
            fxVar.fx = (long[]) this.fx.clone();
            fxVar.b = (Object[]) this.b.clone();
            return fxVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public fx(int i) {
        this.nr = false;
        if (i == 0) {
            this.fx = nr.nr;
            this.b = nr.fx;
        } else {
            int iU = nr.u(i);
            this.fx = new long[iU];
            this.b = new Object[iU];
        }
        this.pn = 0;
    }

    public void fx() {
        int i = this.pn;
        Object[] objArr = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.pn = 0;
        this.nr = false;
    }

    public E u(long j) {
        return u(j, null);
    }

    public E u(long j, E e) {
        E e2;
        int iU = nr.u(this.fx, this.pn, j);
        return (iU < 0 || (e2 = (E) this.b[iU]) == u) ? e : e2;
    }

    public void u(int i) {
        Object[] objArr = this.b;
        Object obj = objArr[i];
        Object obj2 = u;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.nr = true;
        }
    }

    public int nr() {
        if (this.nr) {
            b();
        }
        return this.pn;
    }

    public long nr(int i) {
        if (this.nr) {
            b();
        }
        return this.fx[i];
    }
}

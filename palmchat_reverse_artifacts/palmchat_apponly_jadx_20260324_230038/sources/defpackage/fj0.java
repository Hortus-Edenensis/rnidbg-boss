package defpackage;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fj0<E> extends cj0<E> {
    public transient int[] f;
    public transient int[] g;
    public transient int h;
    public transient int i;

    public fj0(int i) {
        super(i);
    }

    public static <E> fj0<E> R(int i) {
        return new fj0<>(i);
    }

    @Override // defpackage.cj0
    public void B(int i) {
        super.B(i);
        this.h = -2;
        this.i = -2;
    }

    @Override // defpackage.cj0
    public void C(int i, E e, int i2, int i3) {
        super.C(i, e, i2, i3);
        c0(this.i, i);
        c0(i, -2);
    }

    @Override // defpackage.cj0
    public void D(int i, int i2) {
        int size = size() - 1;
        super.D(i, i2);
        c0(S(i), w(i));
        if (i < size) {
            c0(S(size), i);
            c0(i, w(size));
        }
        U()[size] = 0;
        a0()[size] = 0;
    }

    @Override // defpackage.cj0
    public void L(int i) {
        super.L(i);
        this.f = Arrays.copyOf(U(), i);
        this.g = Arrays.copyOf(a0(), i);
    }

    public final int S(int i) {
        return U()[i] - 1;
    }

    public final int[] U() {
        int[] iArr = this.f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int[] a0() {
        int[] iArr = this.g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final void b0(int i, int i2) {
        U()[i] = i2 + 1;
    }

    @Override // defpackage.cj0
    public int c(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    public final void c0(int i, int i2) {
        if (i == -2) {
            this.h = i2;
        } else {
            d0(i, i2);
        }
        if (i2 == -2) {
            this.i = i;
        } else {
            b0(i2, i);
        }
    }

    @Override // defpackage.cj0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (F()) {
            return;
        }
        this.h = -2;
        this.i = -2;
        int[] iArr = this.f;
        if (iArr != null && this.g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.g, 0, size(), 0);
        }
        super.clear();
    }

    public final void d0(int i, int i2) {
        a0()[i] = i2 + 1;
    }

    @Override // defpackage.cj0
    public int o() {
        int iO = super.o();
        this.f = new int[iO];
        this.g = new int[iO];
        return iO;
    }

    @Override // defpackage.cj0
    public Set<E> p() {
        Set<E> setP = super.p();
        this.f = null;
        this.g = null;
        return setP;
    }

    @Override // defpackage.cj0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return j54.f(this);
    }

    @Override // defpackage.cj0
    public int v() {
        return this.h;
    }

    @Override // defpackage.cj0
    public int w(int i) {
        return a0()[i] - 1;
    }

    @Override // defpackage.cj0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) j54.g(this, tArr);
    }
}

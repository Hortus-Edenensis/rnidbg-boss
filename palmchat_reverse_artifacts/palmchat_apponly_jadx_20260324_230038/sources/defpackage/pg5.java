package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class pg5<V> {
    public final ym0<V> c;
    public final SparseArray<V> b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20012a = -1;

    public pg5(ym0<V> ym0Var) {
        this.c = ym0Var;
    }

    public void a(int i, V v) {
        if (this.f20012a == -1) {
            vh.g(this.b.size() == 0);
            this.f20012a = 0;
        }
        if (this.b.size() > 0) {
            SparseArray<V> sparseArray = this.b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            vh.a(i >= iKeyAt);
            if (iKeyAt == i) {
                ym0<V> ym0Var = this.c;
                SparseArray<V> sparseArray2 = this.b;
                ym0Var.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.b.append(i, v);
    }

    public void b() {
        for (int i = 0; i < this.b.size(); i++) {
            this.c.accept(this.b.valueAt(i));
        }
        this.f20012a = -1;
        this.b.clear();
    }

    public void c(int i) {
        for (int size = this.b.size() - 1; size >= 0 && i < this.b.keyAt(size); size--) {
            this.c.accept(this.b.valueAt(size));
            this.b.removeAt(size);
        }
        this.f20012a = this.b.size() > 0 ? Math.min(this.f20012a, this.b.size() - 1) : -1;
    }

    public void d(int i) {
        int i2 = 0;
        while (i2 < this.b.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.b.keyAt(i3)) {
                return;
            }
            this.c.accept(this.b.valueAt(i2));
            this.b.removeAt(i2);
            int i4 = this.f20012a;
            if (i4 > 0) {
                this.f20012a = i4 - 1;
            }
            i2 = i3;
        }
    }

    public V e(int i) {
        if (this.f20012a == -1) {
            this.f20012a = 0;
        }
        while (true) {
            int i2 = this.f20012a;
            if (i2 <= 0 || i >= this.b.keyAt(i2)) {
                break;
            }
            this.f20012a--;
        }
        while (this.f20012a < this.b.size() - 1 && i >= this.b.keyAt(this.f20012a + 1)) {
            this.f20012a++;
        }
        return this.b.valueAt(this.f20012a);
    }

    public V f() {
        return this.b.valueAt(r0.size() - 1);
    }

    public boolean g() {
        return this.b.size() == 0;
    }
}

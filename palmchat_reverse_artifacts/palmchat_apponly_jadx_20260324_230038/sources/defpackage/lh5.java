package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class lh5<E> extends qh5<E> {
    public lh5(int i) {
        super(i);
    }

    public final long f() {
        return s46.f20665a.getLongVolatile(this, nh5.i);
    }

    public final long g() {
        return s46.f20665a.getLongVolatile(this, rh5.h);
    }

    public final void h(long j) {
        s46.f20665a.putOrderedLong(this, nh5.i, j);
    }

    public final void i(long j) {
        s46.f20665a.putOrderedLong(this, rh5.h, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return g() == f();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.b;
        long j = this.producerIndex;
        long jA = a(j);
        if (d(eArr, jA) != null) {
            return false;
        }
        e(eArr, jA, e);
        i(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return c(a(this.consumerIndex));
    }

    @Override // java.util.Queue, defpackage.yn3
    public E poll() {
        long j = this.consumerIndex;
        long jA = a(j);
        E[] eArr = this.b;
        E eD = d(eArr, jA);
        if (eD == null) {
            return null;
        }
        e(eArr, jA, null);
        h(j + 1);
        return eD;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jF = f();
        while (true) {
            long jG = g();
            long jF2 = f();
            if (jF == jF2) {
                return (int) (jG - jF2);
            }
            jF = jF2;
        }
    }
}

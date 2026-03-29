package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class sh5<E> extends bj<E> {
    public static final Integer g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final AtomicLong c;
    public long d;
    public final AtomicLong e;
    public final int f;

    public sh5(int i) {
        super(i);
        this.c = new AtomicLong();
        this.e = new AtomicLong();
        this.f = Math.min(i / 4, g.intValue());
    }

    @Override // defpackage.bj, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final long f() {
        return this.e.get();
    }

    public final long g() {
        return this.c.get();
    }

    public final void h(long j) {
        this.e.lazySet(j);
    }

    public final void i(long j) {
        this.c.lazySet(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return g() == f();
    }

    @Override // defpackage.bj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.f1726a;
        int i = this.b;
        long j = this.c.get();
        int iB = b(j, i);
        if (j >= this.d) {
            long j2 = ((long) this.f) + j;
            if (d(atomicReferenceArray, b(j2, i)) == null) {
                this.d = j2;
            } else if (d(atomicReferenceArray, iB) != null) {
                return false;
            }
        }
        e(atomicReferenceArray, iB, e);
        i(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return c(a(this.e.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.e.get();
        int iA = a(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f1726a;
        E eD = d(atomicReferenceArray, iA);
        if (eD == null) {
            return null;
        }
        e(atomicReferenceArray, iA, null);
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

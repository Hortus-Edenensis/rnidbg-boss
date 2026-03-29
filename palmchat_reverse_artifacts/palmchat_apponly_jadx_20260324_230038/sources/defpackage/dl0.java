package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class dl0<E> extends el0<E> {
    public static final int c;
    public static final long d;
    public static final int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17068a;
    public final E[] b;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        c = iIntValue;
        int iArrayIndexScale = s46.f20665a.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            e = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            e = iIntValue + 3;
        }
        d = r1.arrayBaseOffset(Object[].class) + (32 << (e - iIntValue));
    }

    public dl0(int i) {
        int iA = xk4.a(i);
        this.f17068a = iA - 1;
        this.b = (E[]) new Object[(iA << c) + 64];
    }

    public final long a(long j) {
        return b(j, this.f17068a);
    }

    public final long b(long j, long j2) {
        return d + ((j & j2) << e);
    }

    public final E c(long j) {
        return d(this.b, j);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(E[] eArr, long j) {
        return (E) s46.f20665a.getObjectVolatile(eArr, j);
    }

    public final void e(E[] eArr, long j, E e2) {
        s46.f20665a.putOrderedObject(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}

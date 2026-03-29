package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class r13<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f20373a = null;
    public b b = b.NOT_READY;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20374a;

        static {
            int[] iArr = new int[b.values().length];
            f20374a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20374a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T a();

    public final T b() {
        this.b = b.DONE;
        return null;
    }

    public boolean c() {
        this.b = b.FAILED;
        this.f20373a = a();
        if (this.b == b.DONE) {
            return false;
        }
        this.b = b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        b bVar = this.b;
        if (bVar == b.FAILED) {
            throw new IllegalStateException("This iterator is in an inconsistent state, and can no longer be used, due to an exception previously thrown by the computeNext() method");
        }
        int i = a.f20374a[bVar.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = b.NOT_READY;
        return this.f20373a;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Iterator.remove() is not supported");
    }
}

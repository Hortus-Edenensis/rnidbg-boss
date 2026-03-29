package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class j1<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f18300a = a.NOT_READY;
    public T b;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T a();

    public final T b() {
        this.f18300a = a.DONE;
        return null;
    }

    public final boolean c() {
        this.f18300a = a.FAILED;
        this.b = a();
        if (this.f18300a == a.DONE) {
            return false;
        }
        this.f18300a = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        dm4.t(this.f18300a != a.FAILED);
        int iOrdinal = this.f18300a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f18300a = a.NOT_READY;
        T t = (T) c44.a(this.b);
        this.b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

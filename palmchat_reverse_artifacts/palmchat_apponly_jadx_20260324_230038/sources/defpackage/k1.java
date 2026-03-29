package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class k1<T> extends o46<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f18548a = a.NOT_READY;
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
        this.f18548a = a.DONE;
        return null;
    }

    public final boolean c() {
        this.f18548a = a.FAILED;
        this.b = a();
        if (this.f18548a == a.DONE) {
            return false;
        }
        this.f18548a = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        dm4.t(this.f18548a != a.FAILED);
        int iOrdinal = this.f18548a.ordinal();
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
        this.f18548a = a.NOT_READY;
        T t = (T) a44.a(this.b);
        this.b = null;
        return t;
    }
}

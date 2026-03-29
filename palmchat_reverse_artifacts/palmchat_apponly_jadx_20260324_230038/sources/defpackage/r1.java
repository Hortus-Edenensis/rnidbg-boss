package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class r1<T> extends o46<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f20371a;

    public r1(T t) {
        this.f20371a = t;
    }

    public abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20371a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t = this.f20371a;
        if (t == null) {
            throw new NoSuchElementException();
        }
        this.f20371a = a(t);
        return t;
    }
}

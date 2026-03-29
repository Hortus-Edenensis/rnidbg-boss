package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class x06<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f21851a;

    public x06(Iterator<? extends F> it) {
        this.f21851a = (Iterator) dm4.o(it);
    }

    public abstract T a(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f21851a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f21851a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f21851a.remove();
    }
}

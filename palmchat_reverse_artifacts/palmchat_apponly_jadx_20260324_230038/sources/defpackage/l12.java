package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class l12<T> extends p12 implements Iterator<T> {
    public abstract Iterator<T> b();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return b().hasNext();
    }

    public T next() {
        return b().next();
    }
}

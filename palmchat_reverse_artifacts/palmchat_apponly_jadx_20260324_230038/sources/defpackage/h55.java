package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class h55<T> implements Iterator<f55> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator<T> f17874a;

    public h55(Iterator<T> it) {
        this.f17874a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f55 next() {
        return new g55(this.f17874a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17874a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f17874a.remove();
    }
}

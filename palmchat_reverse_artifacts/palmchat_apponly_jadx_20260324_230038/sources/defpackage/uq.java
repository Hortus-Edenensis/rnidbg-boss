package defpackage;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class uq<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<E>> f21269a = new AtomicReference<>();
    public final AtomicReference<LinkedQueueNode<E>> b = new AtomicReference<>();

    public final LinkedQueueNode<E> a() {
        return this.b.get();
    }

    public final LinkedQueueNode<E> b() {
        return this.f21269a.get();
    }

    public final LinkedQueueNode<E> c() {
        return this.b.get();
    }

    public final LinkedQueueNode<E> d() {
        return this.f21269a.get();
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.b.lazySet(linkedQueueNode);
    }

    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f21269a.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeLvNext;
        LinkedQueueNode<E> linkedQueueNodeC = c();
        LinkedQueueNode<E> linkedQueueNodeD = d();
        int i = 0;
        while (linkedQueueNodeC != linkedQueueNodeD && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeLvNext = linkedQueueNodeC.lvNext();
            } while (linkedQueueNodeLvNext == null);
            i++;
            linkedQueueNodeC = linkedQueueNodeLvNext;
        }
        return i;
    }
}

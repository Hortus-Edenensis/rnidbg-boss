package defpackage;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class vq<E> extends wq<E> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeLvNext;
        LinkedQueueNode<E> linkedQueueNodeC = c();
        LinkedQueueNode<E> linkedQueueNodeA = a();
        int i = 0;
        while (linkedQueueNodeC != linkedQueueNodeA && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeLvNext = linkedQueueNodeC.lvNext();
            } while (linkedQueueNodeLvNext == null);
            i++;
            linkedQueueNodeC = linkedQueueNodeLvNext;
        }
        return i;
    }
}

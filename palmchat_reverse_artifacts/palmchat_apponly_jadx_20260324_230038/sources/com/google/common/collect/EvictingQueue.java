package com.google.common.collect;

import defpackage.bv2;
import defpackage.dm4;
import defpackage.q12;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class EvictingQueue<E> extends q12<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int i) {
        dm4.f(i >= 0, "maxSize (%s) must >= 0", i);
        this.delegate = new ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> EvictingQueue<E> create(int i) {
        return new EvictingQueue<>(i);
    }

    @Override // defpackage.h12, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        dm4.o(e);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e);
        return true;
    }

    @Override // defpackage.h12, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return bv2.a(this, bv2.o(collection, size - this.maxSize));
    }

    @Override // defpackage.q12, java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // defpackage.h12, java.util.Collection
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // defpackage.q12, defpackage.h12, defpackage.p12
    public Queue<E> delegate() {
        return this.delegate;
    }
}

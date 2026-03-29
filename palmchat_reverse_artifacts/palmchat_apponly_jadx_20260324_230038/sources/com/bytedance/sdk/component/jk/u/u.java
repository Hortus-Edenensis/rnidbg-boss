package com.bytedance.sdk.component.jk.u;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u<T> implements BlockingQueue<T> {
    private final BlockingQueue<T> u;

    public u(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.u = new SynchronousQueue();
        } else {
            this.u = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.u.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.u.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.u.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.u.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.u.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.u.drainTo(collection);
    }

    @Override // java.util.Queue
    public T element() {
        return this.u.element();
    }

    public int fx() {
        return this.u.size();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.u.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.u.iterator();
    }

    public final BlockingQueue nr() {
        return this.u;
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.u.offer(t);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.u.peek();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.u.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.u.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.u.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.u.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.u.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.u.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return fx();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.u.take();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public final String u() {
        return this.u.getClass().getName();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.u.drainTo(collection, i);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.u.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T poll() {
        return this.u.poll();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.u.remove(obj);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}

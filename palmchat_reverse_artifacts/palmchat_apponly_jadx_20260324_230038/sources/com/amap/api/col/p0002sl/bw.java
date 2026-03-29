package com.amap.api.col.p0002sl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class bw<T> implements List<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<T> f2662a = new LinkedList<>();

    public final synchronized void a(T t) {
        add(t);
    }

    @Override // java.util.List
    public synchronized void add(int i, T t) {
        this.f2662a.add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f2662a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized void clear() {
        this.f2662a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean contains(Object obj) {
        return this.f2662a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f2662a.containsAll(collection);
    }

    @Override // java.util.List
    public synchronized T get(int i) {
        T t;
        try {
            t = this.f2662a.get(i);
        } catch (Exception e) {
            ct.a(e, "SyncList", "get");
            t = null;
        }
        return t;
    }

    @Override // java.util.List
    public synchronized int indexOf(Object obj) {
        return this.f2662a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean isEmpty() {
        return this.f2662a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public synchronized Iterator<T> iterator() {
        return this.f2662a.listIterator();
    }

    @Override // java.util.List
    public synchronized int lastIndexOf(Object obj) {
        return this.f2662a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public synchronized ListIterator<T> listIterator() {
        return this.f2662a.listIterator();
    }

    @Override // java.util.List
    public synchronized T remove(int i) {
        return this.f2662a.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f2662a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f2662a.retainAll(collection);
    }

    @Override // java.util.List
    public synchronized T set(int i, T t) {
        return this.f2662a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized int size() {
        return this.f2662a.size();
    }

    @Override // java.util.List
    public synchronized List<T> subList(int i, int i2) {
        return this.f2662a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized Object[] toArray() {
        return this.f2662a.toArray();
    }

    @Override // java.util.List
    public synchronized boolean addAll(int i, Collection<? extends T> collection) {
        return this.f2662a.addAll(i, collection);
    }

    @Override // java.util.List
    public synchronized ListIterator<T> listIterator(int i) {
        return this.f2662a.listIterator(i);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean remove(Object obj) {
        return this.f2662a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized <V> V[] toArray(V[] vArr) {
        return (V[]) this.f2662a.toArray(vArr);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean add(T t) {
        try {
        } catch (Throwable unused) {
            return true;
        }
        return this.f2662a.add(t);
    }
}

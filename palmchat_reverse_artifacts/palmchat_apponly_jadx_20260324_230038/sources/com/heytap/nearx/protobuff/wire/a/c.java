package com.heytap.nearx.protobuff.wire.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
final class c<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<T> f6420a;
    private final List<T> b;

    public c(List<T> list) {
        this.b = list;
        this.f6420a = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.f6420a);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (this.f6420a == this.b) {
            this.f6420a = new ArrayList(this.b);
        }
        this.f6420a.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f6420a.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        if (this.f6420a == this.b) {
            this.f6420a = new ArrayList(this.b);
        }
        return this.f6420a.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (this.f6420a == this.b) {
            this.f6420a = new ArrayList(this.b);
        }
        return this.f6420a.set(i, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6420a.size();
    }
}

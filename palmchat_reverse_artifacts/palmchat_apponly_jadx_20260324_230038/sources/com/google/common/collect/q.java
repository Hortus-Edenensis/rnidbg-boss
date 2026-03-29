package com.google.common.collect;

import com.google.common.collect.x;
import defpackage.cv2;
import defpackage.h12;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class q<E> extends h12<E> implements x<E> {
    @Override // com.google.common.collect.x
    public int add(E e, int i) {
        return b().add(e, i);
    }

    public abstract x<E> b();

    @Override // com.google.common.collect.x
    public int count(Object obj) {
        return b().count(obj);
    }

    public abstract Set<x.a<E>> entrySet();

    @Override // java.util.Collection, com.google.common.collect.x
    public boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.x
    public int hashCode() {
        return b().hashCode();
    }

    @Override // com.google.common.collect.x
    public int remove(Object obj, int i) {
        return b().remove(obj, i);
    }

    @Override // com.google.common.collect.x
    public int setCount(E e, int i) {
        return b().setCount(e, i);
    }

    @Override // defpackage.h12
    public boolean standardAddAll(Collection<? extends E> collection) {
        return y.c(this, collection);
    }

    @Override // defpackage.h12
    public void standardClear() {
        cv2.d(entrySet().iterator());
    }

    @Override // defpackage.h12
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    @Override // defpackage.h12
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // defpackage.h12
    public boolean standardRemoveAll(Collection<?> collection) {
        return y.j(this, collection);
    }

    @Override // defpackage.h12
    public boolean standardRetainAll(Collection<?> collection) {
        return y.k(this, collection);
    }

    @Override // defpackage.h12
    public String standardToString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.x
    public boolean setCount(E e, int i, int i2) {
        return b().setCount(e, i, i2);
    }
}

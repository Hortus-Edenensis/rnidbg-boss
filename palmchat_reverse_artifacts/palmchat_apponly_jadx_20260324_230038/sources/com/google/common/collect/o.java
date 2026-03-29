package com.google.common.collect;

import com.google.common.collect.p0;
import com.google.common.collect.x;
import com.google.common.collect.y;
import defpackage.q94;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class o<E> extends q<E> implements o0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Comparator<? super E> f6185a;
    public transient NavigableSet<E> b;
    public transient Set<x.a<E>> c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends y.d<E> {
        public a() {
        }

        @Override // com.google.common.collect.y.d
        public x<E> a() {
            return o.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<x.a<E>> iterator() {
            return o.this.p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o.this.s().entrySet().size();
        }
    }

    @Override // defpackage.h12, defpackage.p12
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x<E> delegate() {
        return s();
    }

    @Override // com.google.common.collect.o0, defpackage.jg5
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f6185a;
        if (comparator != null) {
            return comparator;
        }
        q94 q94VarS = q94.b(s().comparator()).s();
        this.f6185a = q94VarS;
        return q94VarS;
    }

    @Override // com.google.common.collect.o0
    public o0<E> descendingMultiset() {
        return s();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    public Set<x.a<E>> entrySet() {
        Set<x.a<E>> set = this.c;
        if (set != null) {
            return set;
        }
        Set<x.a<E>> setO = o();
        this.c = setO;
        return setO;
    }

    @Override // com.google.common.collect.o0
    public x.a<E> firstEntry() {
        return s().lastEntry();
    }

    @Override // com.google.common.collect.o0
    public o0<E> headMultiset(E e, BoundType boundType) {
        return s().tailMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.o0
    public x.a<E> lastEntry() {
        return s().firstEntry();
    }

    public Set<x.a<E>> o() {
        return new a();
    }

    public abstract Iterator<x.a<E>> p();

    @Override // com.google.common.collect.o0
    public x.a<E> pollFirstEntry() {
        return s().pollLastEntry();
    }

    @Override // com.google.common.collect.o0
    public x.a<E> pollLastEntry() {
        return s().pollFirstEntry();
    }

    public abstract o0<E> s();

    @Override // com.google.common.collect.o0
    public o0<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return s().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.o0
    public o0<E> tailMultiset(E e, BoundType boundType) {
        return s().headMultiset(e, boundType).descendingMultiset();
    }

    @Override // defpackage.h12, java.util.Collection
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // defpackage.p12
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.x
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.b;
        if (navigableSet != null) {
            return navigableSet;
        }
        p0.b bVar = new p0.b(this);
        this.b = bVar;
        return bVar;
    }

    @Override // defpackage.h12, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }
}

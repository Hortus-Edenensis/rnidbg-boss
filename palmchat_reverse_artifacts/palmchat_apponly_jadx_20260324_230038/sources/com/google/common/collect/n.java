package com.google.common.collect;

import com.google.common.collect.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class n<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableSortedMultiset<E> f6184a;

    public n(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f6184a = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public int count(Object obj) {
        return this.f6184a.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public x.a<E> firstEntry() {
        return this.f6184a.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public x.a<E> getEntry(int i) {
        return this.f6184a.entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f6184a.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public x.a<E> lastEntry() {
        return this.f6184a.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public int size() {
        return this.f6184a.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f6184a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.f6184a.tailMultiset((Object) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.f6184a.headMultiset((Object) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public ImmutableSortedSet<E> elementSet() {
        return this.f6184a.elementSet().descendingSet();
    }
}

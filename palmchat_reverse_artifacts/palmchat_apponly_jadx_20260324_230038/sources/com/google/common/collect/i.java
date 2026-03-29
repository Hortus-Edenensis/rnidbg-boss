package com.google.common.collect;

import com.google.common.collect.b;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class i<K, V> extends g<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public i(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.d, defpackage.ps3
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b
    public abstract SortedSet<V> createCollection();

    @Override // com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return collection instanceof NavigableSet ? new b.m(k, (NavigableSet) collection, null) : new b.o(k, (SortedSet) collection, null);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? k0.l((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, defpackage.ps3, defpackage.m33
    public SortedSet<V> get(K k) {
        return (SortedSet) super.get((Object) k);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, defpackage.ps3
    public SortedSet<V> removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, com.google.common.collect.d
    public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((Object) k, (Iterable) iterable);
    }
}

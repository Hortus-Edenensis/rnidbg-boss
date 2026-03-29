package com.google.common.collect;

import defpackage.m33;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<K, V> extends b<K, V> implements m33<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    public a(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.b
    public abstract List<V> createCollection();

    @Override // com.google.common.collect.d
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    @Override // com.google.common.collect.b
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.b
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return wrapList(k, (List) collection, null);
    }

    @Override // com.google.common.collect.b
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.b, defpackage.ps3, defpackage.m33
    public List<V> get(K k) {
        return (List) super.get((Object) k);
    }

    @Override // com.google.common.collect.b, defpackage.ps3
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((Object) k, (Iterable) iterable);
    }
}

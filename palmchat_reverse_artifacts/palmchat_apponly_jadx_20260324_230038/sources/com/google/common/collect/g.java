package com.google.common.collect;

import com.google.common.collect.b;
import defpackage.m65;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class g<K, V> extends b<K, V> implements m65<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public g(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.b
    public abstract Set<V> createCollection();

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
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.b
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new b.n(k, (Set) collection);
    }

    @Override // com.google.common.collect.b
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.b, defpackage.ps3, defpackage.m33
    public Set<V> get(K k) {
        return (Set) super.get((Object) k);
    }

    @Override // com.google.common.collect.b, defpackage.ps3
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((Object) k, (Iterable) iterable);
    }
}

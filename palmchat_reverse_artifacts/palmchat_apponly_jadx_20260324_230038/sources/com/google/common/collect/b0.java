package com.google.common.collect;

import com.google.common.collect.c0;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b0<K, V> extends ImmutableBiMap<K, V> {
    public static final b0<Object, Object> f = new b0<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f6154a;
    public final transient Object[] b;
    public final transient int c;
    public final transient int d;
    public final transient b0<V, K> e;

    /* JADX WARN: Multi-variable type inference failed */
    public b0() {
        this.f6154a = null;
        this.b = new Object[0];
        this.c = 0;
        this.d = 0;
        this.e = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new c0.a(this, this.b, this.c, this.d);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new c0.b(this, new c0.c(this.b, this.c, this.d));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v = (V) c0.e(this.f6154a, this.b, this.d, this.c, obj);
        if (v == null) {
            return null;
        }
        return v;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableBiMap, defpackage.ts
    public ImmutableBiMap<V, K> inverse() {
        return this.e;
    }

    public b0(Object[] objArr, int i) {
        this.b = objArr;
        this.d = i;
        this.c = 0;
        int iChooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        this.f6154a = c0.d(objArr, i, iChooseTableSize, 0);
        this.e = new b0<>(c0.d(objArr, i, iChooseTableSize, 1), objArr, i, this);
    }

    public b0(Object obj, Object[] objArr, int i, b0<V, K> b0Var) {
        this.f6154a = obj;
        this.b = objArr;
        this.c = 1;
        this.d = i;
        this.e = b0Var;
    }
}

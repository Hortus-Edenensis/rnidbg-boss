package com.google.common.collect;

import com.google.common.collect.u;
import defpackage.dm4;
import defpackage.m1;
import defpackage.ns0;
import defpackage.zs4;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class w0<K extends Comparable, V> implements zs4<K, V> {
    public static final zs4<Comparable<?>, Object> b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigableMap<ns0<K>, c<K, V>> f6232a = u.t();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements zs4<Comparable<?>, Object> {
        @Override // defpackage.zs4
        public Map<Range<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends u.l<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<Map.Entry<Range<K>, V>> f6233a;

        public b(Iterable<c<K, V>> iterable) {
            this.f6233a = iterable;
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<Range<K>, V>> a() {
            return this.f6233a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            c cVar = (c) w0.this.f6232a.get(range.lowerBound);
            if (cVar == null || !cVar.getKey().equals(range)) {
                return null;
            }
            return (V) cVar.getValue();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return w0.this.f6232a.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<K extends Comparable, V> extends m1<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<K> f6234a;
        public final V b;

        public c(ns0<K> ns0Var, ns0<K> ns0Var2, V v) {
            this(Range.create(ns0Var, ns0Var2), v);
        }

        public boolean a(K k) {
            return this.f6234a.contains(k);
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Range<K> getKey() {
            return this.f6234a;
        }

        public ns0<K> s() {
            return (ns0<K>) this.f6234a.lowerBound;
        }

        public ns0<K> u() {
            return (ns0<K>) this.f6234a.upperBound;
        }

        public c(Range<K> range, V v) {
            this.f6234a = range;
            this.b = v;
        }
    }

    public static <K extends Comparable, V> w0<K, V> b() {
        return new w0<>();
    }

    @Override // defpackage.zs4
    public Map<Range<K>, V> asMapOfRanges() {
        return new b(this.f6232a.values());
    }

    public V c(K k) {
        Map.Entry<Range<K>, V> entryD = d(k);
        if (entryD == null) {
            return null;
        }
        return entryD.getValue();
    }

    public Map.Entry<Range<K>, V> d(K k) {
        Map.Entry<ns0<K>, c<K, V>> entryFloorEntry = this.f6232a.floorEntry(ns0.p(k));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().a(k)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    public void e(Range<K> range, V v) {
        if (range.isEmpty()) {
            return;
        }
        dm4.o(v);
        h(range);
        this.f6232a.put(range.lowerBound, new c(range, v));
    }

    public boolean equals(Object obj) {
        if (obj instanceof zs4) {
            return asMapOfRanges().equals(((zs4) obj).asMapOfRanges());
        }
        return false;
    }

    public void f(zs4<K, ? extends V> zs4Var) {
        for (Map.Entry<Range<K>, ? extends V> entry : zs4Var.asMapOfRanges().entrySet()) {
            e(entry.getKey(), entry.getValue());
        }
    }

    public final void g(ns0<K> ns0Var, ns0<K> ns0Var2, V v) {
        this.f6232a.put(ns0Var, new c<>(ns0Var, ns0Var2, v));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry entryLowerEntry = this.f6232a.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            c cVar = (c) entryLowerEntry.getValue();
            if (cVar.u().compareTo(range.lowerBound) > 0) {
                if (cVar.u().compareTo(range.upperBound) > 0) {
                    g(range.upperBound, cVar.u(), ((c) entryLowerEntry.getValue()).getValue());
                }
                g(cVar.s(), range.lowerBound, ((c) entryLowerEntry.getValue()).getValue());
            }
        }
        Map.Entry entryLowerEntry2 = this.f6232a.lowerEntry(range.upperBound);
        if (entryLowerEntry2 != null) {
            c cVar2 = (c) entryLowerEntry2.getValue();
            if (cVar2.u().compareTo(range.upperBound) > 0) {
                g(range.upperBound, cVar2.u(), ((c) entryLowerEntry2.getValue()).getValue());
            }
        }
        this.f6232a.subMap(range.lowerBound, range.upperBound).clear();
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    public String toString() {
        return this.f6232a.values().toString();
    }
}

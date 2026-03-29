package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.n0;
import defpackage.d43;
import defpackage.dm4;
import defpackage.ns0;
import defpackage.o46;
import defpackage.xr2;
import defpackage.yr2;
import defpackage.zs4;
import j$.util.stream.Collector;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements zs4<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ImmutableList<Range<K>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6096a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Range c;
        public final /* synthetic */ ImmutableRangeMap d;

        public a(ImmutableRangeMap immutableRangeMap, int i, int i2, Range range) {
            this.f6096a = i;
            this.b = i2;
            this.c = range;
            this.d = immutableRangeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Range<K> get(int i) {
            dm4.m(i, this.f6096a);
            return (i == 0 || i == this.f6096a + (-1)) ? ((Range) this.d.ranges.get(i + this.b)).intersection(this.c) : (Range) this.d.ranges.get(i + this.b);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6096a;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ImmutableRangeMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Range f6097a;
        public final /* synthetic */ ImmutableRangeMap b;
        public final /* synthetic */ ImmutableRangeMap c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
            super(immutableList, immutableList2);
            this.f6097a = range;
            this.b = immutableRangeMap2;
            this.c = immutableRangeMap;
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        /* JADX INFO: renamed from: asDescendingMapOfRanges */
        public /* bridge */ /* synthetic */ Map mo50asDescendingMapOfRanges() {
            return super.mo50asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, defpackage.zs4
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        public Object writeReplace() {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableRangeMap
        /* JADX INFO: renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
        public ImmutableRangeMap<K, V> mo51subRangeMap(Range<K> range) {
            return this.f6097a.isConnected(range) ? this.b.mo51subRangeMap((Range) range.intersection(this.f6097a)) : ImmutableRangeMap.of();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Map.Entry<Range<K>, V>> f6098a = d43.h();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f6098a, Range.rangeLexOrdering().p());
            ImmutableList.a aVar = new ImmutableList.a(this.f6098a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f6098a.size());
            for (int i = 0; i < this.f6098a.size(); i++) {
                Range<K> key = this.f6098a.get(i).getKey();
                if (i > 0) {
                    Range<K> key2 = this.f6098a.get(i - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                aVar.a(key);
                aVar2.a(this.f6098a.get(i).getValue());
            }
            return new ImmutableRangeMap<>(aVar.e(), aVar2.e());
        }

        public c<K, V> b(c<K, V> cVar) {
            this.f6098a.addAll(cVar.f6098a);
            return this;
        }

        public c<K, V> c(Range<K> range, V v) {
            dm4.o(range);
            dm4.o(v);
            dm4.j(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f6098a.add(u.i(range, v));
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<Range<K>, V> f6099a;

        public d(ImmutableMap<Range<K>, V> immutableMap) {
            this.f6099a = immutableMap;
        }

        public Object b() {
            c cVar = new c();
            o46<Map.Entry<Range<K>, V>> it = this.f6099a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                cVar.c(next.getKey(), next.getValue());
            }
            return cVar.a();
        }

        public Object readResolve() {
            return this.f6099a.isEmpty() ? ImmutableRangeMap.of() : b();
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(zs4<K, ? extends V> zs4Var) {
        if (zs4Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) zs4Var;
        }
        Map<Range<K>, ? extends V> mapAsMapOfRanges = zs4Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(mapAsMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(mapAsMapOfRanges.size());
        for (Map.Entry entry : mapAsMapOfRanges.entrySet()) {
            aVar.a((Range) entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.e(), aVar2.e());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> function, Function<? super T, ? extends V> function2) {
        return k.T(function, function2);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof zs4) {
            return asMapOfRanges().equals(((zs4) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k) {
        int iA = n0.a(this.ranges, new xr2(), ns0.p(k), n0.c.ANY_PRESENT, n0.b.NEXT_LOWER);
        if (iA != -1 && this.ranges.get(iA).contains(k)) {
            return this.values.get(iA);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k) {
        int iA = n0.a(this.ranges, new xr2(), ns0.p(k), n0.c.ANY_PRESENT, n0.b.NEXT_LOWER);
        if (iA == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(iA);
        if (range.contains(k)) {
            return u.i(range, this.values.get(iA));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(zs4<K, ? extends V> zs4Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new d(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    @Override // 
    /* JADX INFO: renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo50asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new g0(this.ranges.reverse(), Range.rangeLexOrdering().s()), this.values.reverse());
    }

    @Override // defpackage.zs4
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new g0(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // 
    /* JADX INFO: renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo51subRangeMap(Range<K> range) {
        if (((Range) dm4.o(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        yr2 yr2Var = new yr2();
        Comparable comparable = range.lowerBound;
        n0.c cVar = n0.c.FIRST_AFTER;
        n0.b bVar = n0.b.NEXT_HIGHER;
        int iA = n0.a(immutableList, yr2Var, comparable, cVar, bVar);
        int iA2 = n0.a(this.ranges, new xr2(), range.upperBound, n0.c.ANY_PRESENT, bVar);
        return iA >= iA2 ? of() : new b(this, new a(this, iA2 - iA, iA, range), this.values.subList(iA, iA2), range, this);
    }
}

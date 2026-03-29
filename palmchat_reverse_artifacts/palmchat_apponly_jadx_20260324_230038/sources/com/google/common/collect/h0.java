package com.google.common.collect;

import com.google.common.collect.h0;
import com.google.common.collect.t0;
import defpackage.dm4;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class h0<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends t<t0.a<R, C, V>> {
        public b() {
        }

        @Override // com.google.common.collect.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t0.a<R, C, V> get(int i) {
            return h0.this.getCell(i);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof t0.a)) {
                return false;
            }
            t0.a aVar = (t0.a) obj;
            Object obj2 = h0.this.get(aVar.o(), aVar.b());
            return obj2 != null && obj2.equals(aVar.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.size();
        }

        @Override // com.google.common.collect.t, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends ImmutableList<V> {
        public c() {
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) h0.this.getValue(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return h0.this.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    public static <R, C, V> h0<R, C, V> c(List<t0.a<R, C, V>> list, final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        dm4.o(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator() { // from class: ev4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return h0.f(comparator, comparator2, (t0.a) obj, (t0.a) obj2);
                }
            });
        }
        return d(list, comparator, comparator2);
    }

    public static <R, C, V> h0<R, C, V> d(Iterable<t0.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(iterable);
        for (t0.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.o());
            linkedHashSet2.add(aVar.b());
        }
        return e(immutableListCopyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static <R, C, V> h0<R, C, V> e(ImmutableList<t0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new m(immutableList, immutableSet, immutableSet2) : new q0(immutableList, immutableSet, immutableSet2);
    }

    public static /* synthetic */ int f(Comparator comparator, Comparator comparator2, t0.a aVar, t0.a aVar2) {
        int iCompare = comparator == null ? 0 : comparator.compare(aVar.o(), aVar2.o());
        if (iCompare != 0) {
            return iCompare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(aVar.b(), aVar2.b());
    }

    public final void b(R r, C c2, V v, V v2) {
        dm4.l(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c2, v2, v);
    }

    public abstract t0.a<R, C, V> getCell(int i);

    public abstract V getValue(int i);

    @Override // com.google.common.collect.ImmutableTable
    public abstract Object writeReplace();

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.j
    public final ImmutableSet<t0.a<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new b();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.j
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new c();
    }
}

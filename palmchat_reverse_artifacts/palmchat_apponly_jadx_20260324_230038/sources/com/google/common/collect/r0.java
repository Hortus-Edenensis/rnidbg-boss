package com.google.common.collect;

import com.google.common.collect.u;
import defpackage.dm4;
import defpackage.qo5;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class r0<R, C, V> extends s0<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends s0<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return r0.this.sortedBackingMap().comparator();
        }

        @Override // com.google.common.collect.u.r
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> g() {
            return new u.o(this);
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) r0.this.sortedBackingMap().firstKey();
        }

        @Override // com.google.common.collect.u.r, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            dm4.o(r);
            return new r0(r0.this.sortedBackingMap().headMap(r), r0.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) r0.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            dm4.o(r);
            dm4.o(r2);
            return new r0(r0.this.sortedBackingMap().subMap(r, r2), r0.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            dm4.o(r);
            return new r0(r0.this.sortedBackingMap().tailMap(r), r0.this.factory).rowMap();
        }
    }

    public r0(SortedMap<R, Map<C, V>> sortedMap, qo5<? extends Map<C, V>> qo5Var) {
        super(sortedMap, qo5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.s0
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.t0
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}

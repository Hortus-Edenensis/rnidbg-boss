package com.google.common.collect;

import com.google.common.collect.TreeBasedTable;
import com.google.common.collect.u;
import defpackage.bv2;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.k1;
import defpackage.q94;
import defpackage.qo5;
import defpackage.u42;
import j$.util.Objects;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class TreeBasedTable<R, C, V> extends r0<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends k1<C> {
        public C c;
        public final /* synthetic */ Iterator d;
        public final /* synthetic */ Comparator e;
        public final /* synthetic */ TreeBasedTable f;

        public a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.d = it;
            this.e = comparator;
            this.f = treeBasedTable;
        }

        @Override // defpackage.k1
        public C a() {
            while (this.d.hasNext()) {
                C c = (C) this.d.next();
                C c2 = this.c;
                if (!(c2 != null && this.e.compare(c, c2) == 0)) {
                    this.c = c;
                    return c;
                }
            }
            this.c = null;
            return b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<C, V> implements qo5<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<? super C> f6132a;

        public b(Comparator<? super C> comparator) {
            this.f6132a = comparator;
        }

        @Override // defpackage.qo5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get2() {
            return new TreeMap(this.f6132a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends s0<R, C, V>.g implements SortedMap<C, V> {
        public final C d;
        public final C e;
        public transient SortedMap<C, V> f;

        public c(TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        @Override // com.google.common.collect.s0.g
        public void c() {
            j();
            SortedMap<C, V> sortedMap = this.f;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f6199a);
            this.f = null;
            this.b = null;
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.s0.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return i(obj) && super.containsKey(obj);
        }

        public int f(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            d();
            Map<C, V> map = this.b;
            if (map != null) {
                return (C) ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.s0.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> b() {
            j();
            SortedMap<C, V> sortedMapTailMap = this.f;
            if (sortedMapTailMap == null) {
                return null;
            }
            C c = this.d;
            if (c != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(c);
            }
            C c2 = this.e;
            return c2 != null ? sortedMapTailMap.headMap(c2) : sortedMapTailMap;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet<C> keySet() {
            return new u.o(this);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c) {
            dm4.d(i(dm4.o(c)));
            return new c(this.f6199a, this.d, c);
        }

        public boolean i(Object obj) {
            C c;
            C c2;
            return obj != null && ((c = this.d) == null || f(c, obj) <= 0) && ((c2 = this.e) == null || f(c2, obj) > 0);
        }

        public void j() {
            SortedMap<C, V> sortedMap = this.f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f6199a))) {
                this.f = (SortedMap) TreeBasedTable.this.backingMap.get(this.f6199a);
            }
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            d();
            Map<C, V> map = this.b;
            if (map != null) {
                return (C) ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.s0.g, java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            dm4.d(i(dm4.o(c)));
            return (V) super.put(c, v);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c, C c2) {
            dm4.d(i(dm4.o(c)) && i(dm4.o(c2)));
            return new c(this.f6199a, c, c2);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c) {
            dm4.d(i(dm4.o(c)));
            return new c(this.f6199a, c, this.e);
        }

        public c(R r, C c, C c2) {
            super(r);
            this.d = c;
            this.e = c2;
            dm4.d(c == null || c2 == null || f(c, c2) <= 0);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new b(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(q94.o(), q94.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.keySet().iterator();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.s0
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> comparatorColumnComparator = columnComparator();
        return new a(this, cv2.r(bv2.t(this.backingMap.values(), new u42() { // from class: m16
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
            }
        }), comparatorColumnComparator), comparatorColumnComparator);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ void putAll(t0 t0Var) {
        super.putAll(t0Var);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.j
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        dm4.o(comparator);
        dm4.o(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.t0
    public SortedMap<C, V> row(R r) {
        return new c(this, r);
    }

    @Override // com.google.common.collect.r0, com.google.common.collect.s0, com.google.common.collect.j, com.google.common.collect.t0
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.r0, com.google.common.collect.s0, com.google.common.collect.t0
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}

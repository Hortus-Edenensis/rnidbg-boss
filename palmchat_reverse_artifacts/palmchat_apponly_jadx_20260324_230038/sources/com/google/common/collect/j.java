package com.google.common.collect;

import com.google.common.collect.t0;
import defpackage.cv2;
import defpackage.x06;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class j<R, C, V> implements t0<R, C, V> {
    private transient Set<t0.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends x06<t0.a<R, C, V>, V> {
        public a(Iterator it) {
            super(it);
        }

        @Override // defpackage.x06
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(t0.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AbstractSet<t0.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof t0.a)) {
                return false;
            }
            t0.a aVar = (t0.a) obj;
            Map map = (Map) u.w(j.this.rowMap(), aVar.o());
            return map != null && l.c(map.entrySet(), u.i(aVar.b(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<t0.a<R, C, V>> iterator() {
            return j.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof t0.a)) {
                return false;
            }
            t0.a aVar = (t0.a) obj;
            Map map = (Map) u.w(j.this.rowMap(), aVar.o());
            return map != null && l.d(map.entrySet(), u.i(aVar.b(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return j.this.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return j.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return j.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return j.this.size();
        }
    }

    public abstract Iterator<t0.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.t0
    public Set<t0.a<R, C, V>> cellSet() {
        Set<t0.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<t0.a<R, C, V>> setCreateCellSet = createCellSet();
        this.cellSet = setCreateCellSet;
        return setCreateCellSet;
    }

    public void clear() {
        cv2.d(cellSet().iterator());
    }

    @Override // com.google.common.collect.t0
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) u.w(rowMap(), obj);
        return map != null && u.v(map, obj2);
    }

    public boolean containsColumn(Object obj) {
        return u.v(columnMap(), obj);
    }

    public boolean containsRow(Object obj) {
        return u.v(rowMap(), obj);
    }

    public boolean containsValue(Object obj) {
        Iterator<Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<t0.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    public boolean equals(Object obj) {
        return v0.a(this, obj);
    }

    @Override // com.google.common.collect.t0
    public V get(Object obj, Object obj2) {
        Map map = (Map) u.w(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) u.w(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.t0
    public V put(R r, C c2, V v) {
        return row(r).put(c2, v);
    }

    public void putAll(t0<? extends R, ? extends C, ? extends V> t0Var) {
        for (t0.a<? extends R, ? extends C, ? extends V> aVar : t0Var.cellSet()) {
            put(aVar.o(), aVar.b(), aVar.getValue());
        }
    }

    public V remove(Object obj, Object obj2) {
        Map map = (Map) u.w(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) u.x(map, obj2);
    }

    @Override // com.google.common.collect.t0
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.values = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        return new a(cellSet().iterator());
    }
}

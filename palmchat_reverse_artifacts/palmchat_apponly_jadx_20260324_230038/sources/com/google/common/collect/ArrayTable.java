package com.google.common.collect;

import com.google.common.collect.t0;
import com.google.common.collect.u;
import com.google.common.collect.v0;
import defpackage.dm4;
import defpackage.i1;
import defpackage.m1;
import defpackage.m54;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ArrayTable<R, C, V> extends j<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends i1<t0.a<R, C, V>> {
        public a(int i) {
            super(i);
        }

        @Override // defpackage.i1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t0.a<R, C, V> a(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends v0.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6057a;
        public final int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayTable d;

        public b(ArrayTable arrayTable, int i) {
            this.c = i;
            this.d = arrayTable;
            this.f6057a = i / arrayTable.columnList.size();
            this.b = i % arrayTable.columnList.size();
        }

        @Override // com.google.common.collect.t0.a
        public C b() {
            return (C) this.d.columnList.get(this.b);
        }

        @Override // com.google.common.collect.t0.a
        public V getValue() {
            return (V) this.d.at(this.f6057a, this.b);
        }

        @Override // com.google.common.collect.t0.a
        public R o() {
            return (R) this.d.rowList.get(this.f6057a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends i1<V> {
        public c(int i) {
            super(i);
        }

        @Override // defpackage.i1
        public V a(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<K, V> extends u.l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f6058a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends m1<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6059a;
            public final /* synthetic */ d b;

            public a(d dVar, int i) {
                this.f6059a = i;
                this.b = dVar;
            }

            @Override // defpackage.m1, java.util.Map.Entry
            public K getKey() {
                return (K) this.b.c(this.f6059a);
            }

            @Override // defpackage.m1, java.util.Map.Entry
            public V getValue() {
                return (V) this.b.e(this.f6059a);
            }

            @Override // defpackage.m1, java.util.Map.Entry
            public V setValue(V v) {
                return (V) this.b.f(this.f6059a, v);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends i1<Map.Entry<K, V>> {
            public b(int i) {
                super(i);
            }

            @Override // defpackage.i1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(int i) {
                return d.this.b(i);
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> b(int i) {
            dm4.m(i, size());
            return new a(this, i);
        }

        public K c(int i) {
            return this.f6058a.keySet().asList().get(i);
        }

        @Override // com.google.common.collect.u.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f6058a.containsKey(obj);
        }

        public abstract String d();

        public abstract V e(int i);

        public abstract V f(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f6058a.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f6058a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f6058a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.f6058a.get(k);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + " " + k + " not in " + this.f6058a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6058a.size();
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f6058a = immutableMap;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends d<R, V> {
        public final int b;

        public e(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(i, this.b);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(i, this.b, v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends d<C, Map<R, V>> {
        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<R, V> e(int i) {
            return new e(i);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends d<C, V> {
        public final int b;

        public g(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(this.b, i);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(this.b, i, v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends d<R, Map<C, V>> {
        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<C, V> e(int i) {
            return new g(i);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> immutableListCopyOf = ImmutableList.copyOf(iterable);
        this.rowList = immutableListCopyOf;
        ImmutableList<C> immutableListCopyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = immutableListCopyOf2;
        dm4.d(immutableListCopyOf.isEmpty() == immutableListCopyOf2.isEmpty());
        this.rowKeyToIndex = u.j(immutableListCopyOf);
        this.columnKeyToIndex = u.j(immutableListCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableListCopyOf.size(), immutableListCopyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t0.a<R, C, V> getCell(int i) {
        return new b(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public V at(int i, int i2) {
        dm4.m(i, this.rowList.size());
        dm4.m(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // com.google.common.collect.j
    public Iterator<t0.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public Set<t0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.j
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c2) {
        dm4.o(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? Collections.emptyMap() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.t0
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.j
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.j
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.j
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.j
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V v : vArr) {
                if (m54.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.j
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public V put(R r, C c2, V v) {
        dm4.o(r);
        dm4.o(c2);
        Integer num = this.rowKeyToIndex.get(r);
        dm4.k(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        dm4.k(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.j
    public void putAll(t0<? extends R, ? extends C, ? extends V> t0Var) {
        super.putAll(t0Var);
    }

    @Override // com.google.common.collect.j
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t0
    public Map<C, V> row(R r) {
        dm4.o(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? Collections.emptyMap() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.t0
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    public V set(int i, int i2, V v) {
        dm4.m(i, this.rowList.size());
        dm4.m(i2, this.columnList.size());
        V[] vArr = this.array[i];
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.t0
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = this.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.j
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.j
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(t0<R, C, ? extends V> t0Var) {
        return t0Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) t0Var) : new ArrayTable<>(t0Var);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(t0<R, C, ? extends V> t0Var) {
        this(t0Var.rowKeySet(), t0Var.columnKeySet());
        putAll(t0Var);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = arrayTable.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
    }
}

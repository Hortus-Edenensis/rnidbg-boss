package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.t0;
import com.google.common.collect.v0;
import com.qq.gdt.action.ActionUtils;
import defpackage.bv2;
import defpackage.d43;
import defpackage.dm4;
import defpackage.fr3;
import defpackage.o46;
import j$.util.stream.Collector;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ImmutableTable<R, C, V> extends j<R, C, V> implements Serializable {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<t0.a<R, C, V>> f6113a = d43.h();
        public Comparator<? super R> b;
        public Comparator<? super C> c;

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int size = this.f6113a.size();
            return size != 0 ? size != 1 ? h0.c(this.f6113a, this.b, this.c) : new m0((t0.a) bv2.j(this.f6113a)) : ImmutableTable.of();
        }

        public a<R, C, V> c(a<R, C, V> aVar) {
            this.f6113a.addAll(aVar.f6113a);
            return this;
        }

        public a<R, C, V> d(t0.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof v0.c) {
                dm4.p(aVar.o(), "row");
                dm4.p(aVar.b(), "column");
                dm4.p(aVar.getValue(), ActionUtils.PAYMENT_AMOUNT);
                this.f6113a.add(aVar);
            } else {
                e(aVar.o(), aVar.b(), aVar.getValue());
            }
            return this;
        }

        public a<R, C, V> e(R r, C c, V v) {
            this.f6113a.add(ImmutableTable.cellOf(r, c, v));
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f6114a;
        public final Object[] b;
        public final Object[] c;
        public final int[] d;
        public final int[] e;

        public b(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.f6114a = objArr;
            this.b = objArr2;
            this.c = objArr3;
            this.d = iArr;
            this.e = iArr2;
        }

        public static b a(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new b(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.c;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.f6114a[0], this.b[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.c;
                if (i >= objArr2.length) {
                    return h0.e(aVar.e(), ImmutableSet.copyOf(this.f6114a), ImmutableSet.copyOf(this.b));
                }
                aVar.a(ImmutableTable.cellOf(this.f6114a[this.d[i]], this.b[this.e[i]], objArr2[i]));
                i++;
            }
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> t0.a<R, C, V> cellOf(R r, C c, V v) {
        return v0.b(dm4.p(r, "rowKey"), dm4.p(c, "columnKey"), dm4.p(v, ActionUtils.PAYMENT_AMOUNT));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(t0<? extends R, ? extends C, ? extends V> t0Var) {
        return t0Var instanceof ImmutableTable ? (ImmutableTable) t0Var : copyOf(t0Var.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) q0.e;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3) {
        return u0.k(function, function2, function3);
    }

    @Override // com.google.common.collect.j
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t0
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.j
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.j
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.j
    public abstract ImmutableSet<t0.a<R, C, V>> createCellSet();

    @Override // com.google.common.collect.j
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j
    @Deprecated
    public final void putAll(t0<? extends R, ? extends C, ? extends V> t0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t0
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.t0
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.j
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public abstract Object writeReplace();

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new m0(r, c, v);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator) {
        return u0.l(function, function2, function3, binaryOperator);
    }

    @Override // com.google.common.collect.j
    public final o46<t0.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public ImmutableSet<t0.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // 
    /* JADX INFO: renamed from: column */
    public ImmutableMap<R, V> mo53column(C c) {
        dm4.p(c, "columnKey");
        return (ImmutableMap) fr3.a((ImmutableMap) columnMap().get(c), ImmutableMap.of());
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.t0
    public ImmutableMap<C, V> row(R r) {
        dm4.p(r, "rowKey");
        return (ImmutableMap) fr3.a((ImmutableMap) rowMap().get(r), ImmutableMap.of());
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.j
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends t0.a<? extends R, ? extends C, ? extends V>> iterable) {
        a aVarBuilder = builder();
        Iterator<? extends t0.a<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            aVarBuilder.d(it.next());
        }
        return aVarBuilder.a();
    }
}

package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.t0;
import defpackage.k1;
import defpackage.o46;
import j$.util.Objects;
import java.lang.reflect.Array;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class m<R, C, V> extends h0<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<R, Integer> f6181a;
    public final ImmutableMap<C, Integer> b;
    public final ImmutableMap<R, ImmutableMap<C, V>> c;
    public final ImmutableMap<C, ImmutableMap<R, V>> d;
    public final int[] e;
    public final int[] f;
    public final V[][] g;
    public final int[] h;
    public final int[] i;

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends d<R, V> {
        public final int b;

        public b(int i) {
            super(m.this.f[i]);
            this.b = i;
        }

        @Override // com.google.common.collect.m.d
        public V d(int i) {
            return (V) m.this.g[i][this.b];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.m.d
        public ImmutableMap<R, Integer> p() {
            return m.this.f6181a;
        }

        @Override // com.google.common.collect.m.d, com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends d<C, ImmutableMap<R, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.m.d
        public ImmutableMap<C, Integer> p() {
            return m.this.b;
        }

        @Override // com.google.common.collect.m.d
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public ImmutableMap<R, V> d(int i) {
            return new b(i);
        }

        @Override // com.google.common.collect.m.d, com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return super.writeReplace();
        }

        public c() {
            super(m.this.f.length);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<K, V> extends ImmutableMap.c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6182a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k1<Map.Entry<K, V>> {
            public int c = -1;
            public final int d;

            public a() {
                this.d = d.this.p().size();
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a() {
                int i = this.c;
                while (true) {
                    this.c = i + 1;
                    int i2 = this.c;
                    if (i2 >= this.d) {
                        return b();
                    }
                    Object objD = d.this.d(i2);
                    if (objD != null) {
                        return u.i(d.this.c(this.c), objD);
                    }
                    i = this.c;
                }
            }
        }

        public d(int i) {
            this.f6182a = i;
        }

        @Override // com.google.common.collect.ImmutableMap.c
        public o46<Map.Entry<K, V>> b() {
            return new a();
        }

        public K c(int i) {
            return p().keySet().asList().get(i);
        }

        @Override // com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return o() ? p().keySet() : super.createKeySet();
        }

        public abstract V d(int i);

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object obj) {
            Integer num = p().get(obj);
            if (num == null) {
                return null;
            }
            return d(num.intValue());
        }

        public final boolean o() {
            return this.f6182a == p().size();
        }

        public abstract ImmutableMap<K, Integer> p();

        @Override // java.util.Map
        public int size() {
            return this.f6182a;
        }

        @Override // com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class e extends d<C, V> {
        public final int b;

        public e(int i) {
            super(m.this.e[i]);
            this.b = i;
        }

        @Override // com.google.common.collect.m.d
        public V d(int i) {
            return (V) m.this.g[this.b][i];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.m.d
        public ImmutableMap<C, Integer> p() {
            return m.this.b;
        }

        @Override // com.google.common.collect.m.d, com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class f extends d<R, ImmutableMap<C, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.m.d
        public ImmutableMap<R, Integer> p() {
            return m.this.f6181a;
        }

        @Override // com.google.common.collect.m.d
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public ImmutableMap<C, V> d(int i) {
            return new e(i);
        }

        @Override // com.google.common.collect.m.d, com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return super.writeReplace();
        }

        public f() {
            super(m.this.e.length);
        }
    }

    public m(ImmutableList<t0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.g = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableSet.size(), immutableSet2.size()));
        ImmutableMap<R, Integer> immutableMapJ = u.j(immutableSet);
        this.f6181a = immutableMapJ;
        ImmutableMap<C, Integer> immutableMapJ2 = u.j(immutableSet2);
        this.b = immutableMapJ2;
        this.e = new int[immutableMapJ.size()];
        this.f = new int[immutableMapJ2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            t0.a<R, C, V> aVar = immutableList.get(i);
            R rO = aVar.o();
            C cB = aVar.b();
            Integer num = this.f6181a.get(rO);
            Objects.requireNonNull(num);
            int iIntValue = num.intValue();
            Integer num2 = this.b.get(cB);
            Objects.requireNonNull(num2);
            int iIntValue2 = num2.intValue();
            b(rO, cB, this.g[iIntValue][iIntValue2], aVar.getValue());
            this.g[iIntValue][iIntValue2] = aVar.getValue();
            int[] iArr3 = this.e;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.f;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i] = iIntValue;
            iArr2[i] = iIntValue2;
        }
        this.h = iArr;
        this.i = iArr2;
        this.c = new f();
        this.d = new c();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.j, com.google.common.collect.t0
    public V get(Object obj, Object obj2) {
        Integer num = this.f6181a.get(obj);
        Integer num2 = this.b.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.g[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.h0
    public t0.a<R, C, V> getCell(int i) {
        int i2 = this.h[i];
        int i3 = this.i[i];
        R r = rowKeySet().asList().get(i2);
        C c2 = columnKeySet().asList().get(i3);
        V v = this.g[i2][i3];
        Objects.requireNonNull(v);
        return ImmutableTable.cellOf(r, c2, v);
    }

    @Override // com.google.common.collect.h0
    public V getValue(int i) {
        V v = this.g[this.h[i]][this.i[i]];
        Objects.requireNonNull(v);
        return v;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public int size() {
        return this.h.length;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.ImmutableTable
    public Object writeReplace() {
        return ImmutableTable.b.a(this, this.h, this.i);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.d);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.c);
    }
}

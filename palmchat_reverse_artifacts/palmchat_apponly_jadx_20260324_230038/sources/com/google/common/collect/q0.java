package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.t0;
import defpackage.o46;
import j$.util.Objects;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class q0<R, C, V> extends h0<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> e = new q0(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<R, ImmutableMap<C, V>> f6189a;
    public final ImmutableMap<C, ImmutableMap<R, V>> b;
    public final int[] c;
    public final int[] d;

    /* JADX WARN: Multi-variable type inference failed */
    public q0(ImmutableList<t0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap immutableMapJ = u.j(immutableSet);
        LinkedHashMap linkedHashMapR = u.r();
        o46<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            linkedHashMapR.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapR2 = u.r();
        o46<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            linkedHashMapR2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            t0.a<R, C, V> aVar = immutableList.get(i);
            R rO = aVar.o();
            C cB = aVar.b();
            V value = aVar.getValue();
            Integer num = (Integer) immutableMapJ.get(rO);
            Objects.requireNonNull(num);
            iArr[i] = num.intValue();
            Map map = (Map) linkedHashMapR.get(rO);
            Objects.requireNonNull(map);
            Map map2 = map;
            iArr2[i] = map2.size();
            b(rO, cB, map2.put(cB, value), value);
            Map map3 = (Map) linkedHashMapR2.get(cB);
            Objects.requireNonNull(map3);
            map3.put(rO, value);
        }
        this.c = iArr;
        this.d = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(linkedHashMapR.size());
        for (Map.Entry entry : linkedHashMapR.entrySet()) {
            bVar.h(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.f6189a = bVar.d();
        ImmutableMap.b bVar2 = new ImmutableMap.b(linkedHashMapR2.size());
        for (Map.Entry entry2 : linkedHashMapR2.entrySet()) {
            bVar2.h(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.b = bVar2.d();
    }

    @Override // com.google.common.collect.h0
    public t0.a<R, C, V> getCell(int i) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.f6189a.entrySet().asList().get(this.c[i]);
        ImmutableMap<C, V> value = entry.getValue();
        Map.Entry<C, V> entry2 = value.entrySet().asList().get(this.d[i]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.h0
    public V getValue(int i) {
        ImmutableMap<C, V> immutableMap = this.f6189a.values().asList().get(this.c[i]);
        return immutableMap.values().asList().get(this.d[i]);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public int size() {
        return this.c.length;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.ImmutableTable
    public Object writeReplace() {
        ImmutableMap immutableMapJ = u.j(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        o46<t0.a<R, C, V>> it = cellSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Integer num = (Integer) immutableMapJ.get(it.next().b());
            Objects.requireNonNull(num);
            iArr[i] = num.intValue();
            i++;
        }
        return ImmutableTable.b.a(this, this.c, iArr);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.b);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.f6189a);
    }
}

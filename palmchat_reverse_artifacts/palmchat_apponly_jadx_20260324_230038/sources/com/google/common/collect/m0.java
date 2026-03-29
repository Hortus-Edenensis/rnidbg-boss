package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.t0;
import defpackage.dm4;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m0<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R f6183a;
    public final C b;
    public final V c;

    public m0(R r, C c, V v) {
        this.f6183a = (R) dm4.o(r);
        this.b = (C) dm4.o(c);
        this.c = (V) dm4.o(v);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable
    public Object writeReplace() {
        return ImmutableTable.b.a(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable
    /* JADX INFO: renamed from: column, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<R, V> mo53column(C c) {
        dm4.o(c);
        return containsColumn(c) ? ImmutableMap.of(this.f6183a, (Object) this.c) : ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.b, ImmutableMap.of(this.f6183a, (Object) this.c));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.j
    public ImmutableSet<t0.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.f6183a, this.b, this.c));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.j
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.c);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.t0
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.f6183a, ImmutableMap.of(this.b, (Object) this.c));
    }

    public m0(t0.a<R, C, V> aVar) {
        this(aVar.o(), aVar.b(), aVar.getValue());
    }
}

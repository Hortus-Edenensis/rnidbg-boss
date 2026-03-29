package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface t0<R, C, V> {

    /* JADX INFO: compiled from: SearchBox */
    public interface a<R, C, V> {
        C b();

        V getValue();

        R o();
    }

    Set<a<R, C, V>> cellSet();

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    V get(Object obj, Object obj2);

    V put(R r, C c, V v);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();
}

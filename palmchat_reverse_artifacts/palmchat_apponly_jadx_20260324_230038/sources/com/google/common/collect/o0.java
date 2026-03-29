package com.google.common.collect;

import com.google.common.collect.x;
import defpackage.jg5;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface o0<E> extends x, jg5<E> {
    Comparator<? super E> comparator();

    o0<E> descendingMultiset();

    @Override // com.google.common.collect.x
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.x
    Set<x.a<E>> entrySet();

    x.a<E> firstEntry();

    o0<E> headMultiset(E e, BoundType boundType);

    x.a<E> lastEntry();

    x.a<E> pollFirstEntry();

    x.a<E> pollLastEntry();

    o0<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2);

    o0<E> tailMultiset(E e, BoundType boundType);
}

package com.google.common.collect;

import com.google.common.collect.x;
import defpackage.dm4;
import defpackage.ku2;
import defpackage.q94;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class f0<E> extends ImmutableSortedMultiset<E> {
    public static final long[] e = {0};
    public static final ImmutableSortedMultiset<?> f = new f0(q94.o());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient g0<E> f6169a;
    public final transient long[] b;
    public final transient int c;
    public final transient int d;

    public f0(Comparator<? super E> comparator) {
        this.f6169a = ImmutableSortedSet.emptySet(comparator);
        this.b = e;
        this.c = 0;
        this.d = 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public int count(Object obj) {
        int iIndexOf = this.f6169a.indexOf(obj);
        if (iIndexOf >= 0) {
            return g(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public x.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    public final int g(int i) {
        long[] jArr = this.b;
        int i2 = this.c;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public x.a<E> getEntry(int i) {
        return y.g(this.f6169a.asList().get(i), g(i));
    }

    public ImmutableSortedMultiset<E> h(int i, int i2) {
        dm4.s(i, i2, this.d);
        return i == i2 ? ImmutableSortedMultiset.emptyMultiset(comparator()) : (i == 0 && i2 == this.d) ? this : new f0(this.f6169a.a(i, i2), this.b, this.c + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.c > 0 || this.d < this.b.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public x.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.d - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public int size() {
        long[] jArr = this.b;
        int i = this.c;
        return ku2.o(jArr[this.d + i] - jArr[i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return h(0, this.f6169a.b(e2, dm4.o(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.o0
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return h(this.f6169a.c(e2, dm4.o(boundType) == BoundType.CLOSED), this.d);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public ImmutableSortedSet<E> elementSet() {
        return this.f6169a;
    }

    public f0(g0<E> g0Var, long[] jArr, int i, int i2) {
        this.f6169a = g0Var;
        this.b = jArr;
        this.c = i;
        this.d = i2;
    }
}

package com.google.common.collect;

import defpackage.o46;
import defpackage.vg2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e0<E> extends ImmutableSet<E> {
    public static final Object[] f;
    public static final e0<Object> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object[] f6168a;
    public final transient int b;
    public final transient Object[] c;
    public final transient int d;
    public final transient int e;

    static {
        Object[] objArr = new Object[0];
        f = objArr;
        g = new e0<>(objArr, 0, objArr, 0, 0);
    }

    public e0(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f6168a = objArr;
        this.b = i;
        this.c = objArr2;
        this.d = i2;
        this.e = i3;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iD = vg2.d(obj);
        while (true) {
            int i = iD & this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iD = i + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.f6168a, 0, objArr, i, this.e);
        return i + this.e;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.f6168a, this.e);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.f6168a;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public o46<E> iterator() {
        return asList().iterator();
    }
}

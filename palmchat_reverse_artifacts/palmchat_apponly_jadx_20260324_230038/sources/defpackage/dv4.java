package defpackage;

import com.google.common.collect.ImmutableList;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dv4<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> c = new dv4(new Object[0], 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object[] f17142a;
    public final transient int b;

    public dv4(Object[] objArr, int i) {
        this.f17142a = objArr;
        this.b = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.f17142a, 0, objArr, i, this.b);
        return i + this.b;
    }

    @Override // java.util.List
    public E get(int i) {
        dm4.m(i, this.b);
        E e = (E) this.f17142a[i];
        Objects.requireNonNull(e);
        return e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.f17142a;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return super.writeReplace();
    }
}

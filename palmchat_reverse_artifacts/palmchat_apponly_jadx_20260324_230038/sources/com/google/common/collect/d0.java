package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.x;
import defpackage.ku2;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d0<E> extends ImmutableMultiset<E> {
    public static final d0<Object> d = new d0<>(z.b());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient z<E> f6163a;
    public final transient int b;
    public transient ImmutableSet<E> c;

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends t<E> {
        public b() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return d0.this.contains(obj);
        }

        @Override // com.google.common.collect.t
        public E get(int i) {
            return d0.this.f6163a.i(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d0.this.f6163a.C();
        }

        @Override // com.google.common.collect.t, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f6165a;
        public final int[] b;

        public c(x<? extends Object> xVar) {
            int size = xVar.entrySet().size();
            this.f6165a = new Object[size];
            this.b = new int[size];
            int i = 0;
            for (x.a<? extends Object> aVar : xVar.entrySet()) {
                this.f6165a[i] = aVar.getElement();
                this.b[i] = aVar.getCount();
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.f6165a.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.f6165a;
                if (i >= objArr.length) {
                    return bVar.e();
                }
                bVar.k(objArr[i], this.b[i]);
                i++;
            }
        }
    }

    public d0(z<E> zVar) {
        this.f6163a = zVar;
        long jK = 0;
        for (int i = 0; i < zVar.C(); i++) {
            jK += (long) zVar.k(i);
        }
        this.b = ku2.o(jK);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public int count(Object obj) {
        return this.f6163a.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public x.a<E> getEntry(int i) {
        return this.f6163a.g(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new c(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.c;
        if (immutableSet != null) {
            return immutableSet;
        }
        b bVar = new b();
        this.c = bVar;
        return bVar;
    }
}

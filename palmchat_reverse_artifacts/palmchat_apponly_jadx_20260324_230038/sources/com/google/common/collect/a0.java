package com.google.common.collect;

import defpackage.dm4;
import defpackage.o46;
import defpackage.q94;
import defpackage.qd1;
import defpackage.r1;
import defpackage.sr2;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a0<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Range<C> f6145a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends r1<C> {
        public final C b;

        public a(Comparable comparable) {
            super(comparable);
            this.b = (C) a0.this.last();
        }

        @Override // defpackage.r1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c) {
            if (a0.b(c, this.b)) {
                return null;
            }
            return (C) a0.this.domain.t(c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends r1<C> {
        public final C b;

        public b(Comparable comparable) {
            super(comparable);
            this.b = (C) a0.this.first();
        }

        @Override // defpackage.r1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c) {
            if (a0.b(c, this.b)) {
                return null;
            }
            return (C) a0.this.domain.v(c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends sr2<C> {
        public c() {
        }

        @Override // defpackage.sr2
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<C> b() {
            return a0.this;
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public C get(int i) {
            dm4.m(i, size());
            a0 a0Var = a0.this;
            return (C) a0Var.domain.u(a0Var.first(), i);
        }

        @Override // defpackage.sr2, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<C> f6147a;
        public final qd1<C> b;

        public /* synthetic */ d(Range range, qd1 qd1Var, a aVar) {
            this(range, qd1Var);
        }

        private Object readResolve() {
            return new a0(this.f6147a, this.b);
        }

        public d(Range<C> range, qd1<C> qd1Var) {
            this.f6147a = range;
            this.b = qd1Var;
        }
    }

    public a0(Range<C> range, qd1<C> qd1Var) {
        super(qd1Var);
        this.f6145a = range;
    }

    public static boolean b(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f6145a.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return l.a(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        return this.domain.f20230a ? new c() : super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            if (this.domain.equals(a0Var.domain)) {
                return first().equals(a0Var.first()) && last().equals(a0Var.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return k0.d(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (!contains(obj)) {
            return -1;
        }
        Objects.requireNonNull(obj);
        return (int) this.domain.a(first(), (Comparable) obj);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        dm4.o(contiguousSet);
        dm4.d(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) q94.o().d(first(), contiguousSet.first());
        Comparable comparable2 = (Comparable) q94.o().e(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new p(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public C first() {
        Comparable comparableX = this.f6145a.lowerBound.x(this.domain);
        Objects.requireNonNull(comparableX);
        return (C) comparableX;
    }

    public final ContiguousSet<C> p(Range<C> range) {
        return this.f6145a.isConnected(range) ? ContiguousSet.create(this.f6145a.intersection(range), this.domain) : new p(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public C last() {
        Comparable comparableV = this.f6145a.upperBound.v(this.domain);
        Objects.requireNonNull(comparableV);
        return (C) comparableV;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long jA = this.domain.a(first(), last());
        if (jA >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) jA) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new d(this.f6145a, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public o46<C> descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> headSetImpl(C c2, boolean z) {
        return p(Range.upTo(c2, BoundType.forBoolean(z)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public o46<C> iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.f6145a.lowerBound.B(boundType, this.domain), this.f6145a.upperBound.C(boundType2, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
        return (c2.compareTo(c3) != 0 || z || z2) ? p(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2))) : new p(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet<C> tailSetImpl(C c2, boolean z) {
        return p(Range.downTo(c2, BoundType.forBoolean(z)));
    }
}

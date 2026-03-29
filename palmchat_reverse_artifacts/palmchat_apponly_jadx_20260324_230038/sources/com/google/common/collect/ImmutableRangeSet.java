package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.n0;
import defpackage.at4;
import defpackage.bv2;
import defpackage.cv2;
import defpackage.d43;
import defpackage.dm4;
import defpackage.k1;
import defpackage.ku2;
import defpackage.ns0;
import defpackage.o1;
import defpackage.o46;
import defpackage.q94;
import defpackage.qd1;
import defpackage.xa1;
import defpackage.xr2;
import defpackage.yr2;
import defpackage.zf4;
import j$.util.Objects;
import j$.util.stream.Collector;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ImmutableRangeSet<C extends Comparable> extends o1<C> implements Serializable {
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ImmutableList<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6100a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Range c;
        public final /* synthetic */ ImmutableRangeSet d;

        public a(ImmutableRangeSet immutableRangeSet, int i, int i2, Range range) {
            this.f6100a = i;
            this.b = i2;
            this.c = range;
            this.d = immutableRangeSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Range<C> get(int i) {
            dm4.m(i, this.f6100a);
            return (i == 0 || i == this.f6100a + (-1)) ? ((Range) this.d.ranges.get(i + this.b)).intersection(this.c) : (Range) this.d.ranges.get(i + this.b);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6100a;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends ImmutableSortedSet<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qd1<C> f6101a;
        public transient Integer b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k1<C> {
            public final Iterator<Range<C>> c;
            public Iterator<C> d = cv2.h();

            public a() {
                this.c = ImmutableRangeSet.this.ranges.iterator();
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (C) b();
                    }
                    this.d = ContiguousSet.create(this.c.next(), b.this.f6101a).iterator();
                }
                return this.d.next();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.ImmutableRangeSet$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0370b extends k1<C> {
            public final Iterator<Range<C>> c;
            public Iterator<C> d = cv2.h();

            public C0370b() {
                this.c = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (C) b();
                    }
                    this.d = ContiguousSet.create(this.c.next(), b.this.f6101a).descendingIterator();
                }
                return this.d.next();
            }
        }

        public b(qd1<C> qd1Var) {
            super(q94.o());
            this.f6101a = qd1Var;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return c(Range.upTo(c, BoundType.forBoolean(z)));
        }

        public ImmutableSortedSet<C> c(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.f6101a);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new xa1(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            return (z || z2 || Range.compareOrThrow(c, c2) != 0) ? c(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2))) : ImmutableSortedSet.of();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return c(Range.downTo(c, BoundType.forBoolean(z)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Objects.requireNonNull(obj);
            Comparable comparable = (Comparable) obj;
            o46 it = ImmutableRangeSet.this.ranges.iterator();
            long size = 0;
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return ku2.o(size + ((long) ContiguousSet.create(range, this.f6101a).indexOf(comparable)));
                }
                size += (long) ContiguousSet.create(range, this.f6101a).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer numValueOf = this.b;
            if (numValueOf == null) {
                o46 it = ImmutableRangeSet.this.ranges.iterator();
                long size = 0;
                while (it.hasNext()) {
                    size += (long) ContiguousSet.create((Range) it.next(), this.f6101a).size();
                    if (size >= 2147483647L) {
                        break;
                    }
                }
                numValueOf = Integer.valueOf(ku2.o(size));
                this.b = numValueOf;
            }
            return numValueOf.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new c(ImmutableRangeSet.this.ranges, this.f6101a);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public o46<C> descendingIterator() {
            return new C0370b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public o46<C> iterator() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<Range<C>> f6102a;
        public final qd1<C> b;

        public c(ImmutableList<Range<C>> immutableList, qd1<C> qd1Var) {
            this.f6102a = immutableList;
            this.b = qd1Var;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.f6102a).asSet(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Range<C>> f6103a = d43.h();

        public d<C> a(Range<C> range) {
            dm4.j(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f6103a.add(range);
            return this;
        }

        public d<C> b(Iterable<Range<C>> iterable) {
            Iterator<Range<C>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.a aVar = new ImmutableList.a(this.f6103a.size());
            Collections.sort(this.f6103a, Range.rangeLexOrdering());
            zf4 zf4VarS = cv2.s(this.f6103a.iterator());
            while (zf4VarS.hasNext()) {
                Range rangeSpan = (Range) zf4VarS.next();
                while (zf4VarS.hasNext()) {
                    Range<C> range = (Range) zf4VarS.peek();
                    if (rangeSpan.isConnected(range)) {
                        dm4.k(rangeSpan.intersection(range).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", rangeSpan, range);
                        rangeSpan = rangeSpan.span((Range) zf4VarS.next());
                    }
                }
                aVar.a(rangeSpan);
            }
            ImmutableList immutableListE = aVar.e();
            return immutableListE.isEmpty() ? ImmutableRangeSet.of() : (immutableListE.size() == 1 && ((Range) bv2.j(immutableListE)).equals(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet<>(immutableListE);
        }

        public d<C> d(d<C> dVar) {
            b(dVar.f6103a);
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class e extends ImmutableList<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6104a;
        public final boolean b;
        public final int c;

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            boolean zHasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.f6104a = zHasLowerBound;
            boolean zHasUpperBound = ((Range) bv2.g(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.b = zHasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = zHasLowerBound ? size + 1 : size;
            this.c = zHasUpperBound ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Range<C> get(int i) {
            dm4.m(i, this.c);
            return Range.create(this.f6104a ? i == 0 ? ns0.o() : ((Range) ImmutableRangeSet.this.ranges.get(i - 1)).upperBound : ((Range) ImmutableRangeSet.this.ranges.get(i)).upperBound, (this.b && i == this.c + (-1)) ? ns0.b() : ((Range) ImmutableRangeSet.this.ranges.get(i + (!this.f6104a ? 1 : 0))).lowerBound);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<Range<C>> f6105a;

        public f(ImmutableList<Range<C>> immutableList) {
            this.f6105a = immutableList;
        }

        public Object readResolve() {
            return this.f6105a.isEmpty() ? ImmutableRangeSet.of() : this.f6105a.equals(ImmutableList.of(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet(this.f6105a);
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> d<C> builder() {
        return new d<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(at4<C> at4Var) {
        dm4.o(at4Var);
        if (at4Var.isEmpty()) {
            return of();
        }
        if (at4Var.encloses(Range.all())) {
            return all();
        }
        if (at4Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) at4Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) at4Var.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        int iA = range.hasLowerBound() ? n0.a(this.ranges, new yr2(), range.lowerBound, n0.c.FIRST_AFTER, n0.b.NEXT_HIGHER) : 0;
        int iA2 = (range.hasUpperBound() ? n0.a(this.ranges, new xr2(), range.upperBound, n0.c.FIRST_PRESENT, n0.b.NEXT_HIGHER) : this.ranges.size()) - iA;
        return iA2 == 0 ? ImmutableList.of() : new a(this, iA2, iA, range);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return k.U();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // defpackage.o1
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.o1
    @Deprecated
    public void addAll(at4<C> at4Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(qd1<C> qd1Var) {
        dm4.o(qd1Var);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> rangeCanonical = span().canonical(qd1Var);
        if (!rangeCanonical.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!rangeCanonical.hasUpperBound()) {
            try {
                qd1Var.p();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new b(qd1Var);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(at4<C> at4Var) {
        TreeRangeSet treeRangeSetCreate = TreeRangeSet.create(this);
        treeRangeSetCreate.removeAll(at4Var);
        return copyOf(treeRangeSetCreate);
    }

    @Override // defpackage.o1, defpackage.at4
    public boolean encloses(Range<C> range) {
        int iB = n0.b(this.ranges, new xr2(), range.lowerBound, q94.o(), n0.c.ANY_PRESENT, n0.b.NEXT_LOWER);
        return iB != -1 && this.ranges.get(iB).encloses(range);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean enclosesAll(at4 at4Var) {
        return super.enclosesAll(at4Var);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(at4<C> at4Var) {
        TreeRangeSet treeRangeSetCreate = TreeRangeSet.create(this);
        treeRangeSetCreate.removeAll(at4Var.complement());
        return copyOf(treeRangeSetCreate);
    }

    @Override // defpackage.o1
    public boolean intersects(Range<C> range) {
        int iB = n0.b(this.ranges, new xr2(), range.lowerBound, q94.o(), n0.c.ANY_PRESENT, n0.b.NEXT_HIGHER);
        if (iB < this.ranges.size() && this.ranges.get(iB).isConnected(range) && !this.ranges.get(iB).intersection(range).isEmpty()) {
            return true;
        }
        if (iB > 0) {
            int i = iB - 1;
            if (this.ranges.get(i).isConnected(range) && !this.ranges.get(i).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.o1, defpackage.at4
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // defpackage.o1
    public Range<C> rangeContaining(C c2) {
        int iB = n0.b(this.ranges, new xr2(), ns0.p(c2), q94.o(), n0.c.ANY_PRESENT, n0.b.NEXT_LOWER);
        if (iB == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(iB);
        if (range.contains(c2)) {
            return range;
        }
        return null;
    }

    @Override // defpackage.o1
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.o1, defpackage.at4
    @Deprecated
    public void removeAll(at4<C> at4Var) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    public ImmutableRangeSet<C> union(at4<C> at4Var) {
        return unionOf(bv2.d(asRanges(), at4Var.asRanges()));
    }

    public Object writeReplace() {
        return new f(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        dm4.o(range);
        return range.isEmpty() ? of() : range.equals(Range.all()) ? all() : new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // defpackage.o1
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: asDescendingSetOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Range<C>> m52asDescendingSetOfRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new g0(this.ranges.reverse(), Range.rangeLexOrdering().s());
    }

    @Override // defpackage.at4
    public ImmutableSet<Range<C>> asRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.of() : new g0(this.ranges, Range.rangeLexOrdering());
    }

    @Override // defpackage.at4
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> immutableRangeSetAll = all();
            this.complement = immutableRangeSetAll;
            return immutableRangeSetAll;
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSetOf = of();
            this.complement = immutableRangeSetOf;
            return immutableRangeSetOf;
        }
        ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new e(), this);
        this.complement = immutableRangeSet2;
        return immutableRangeSet2;
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // defpackage.o1
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.at4
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> rangeSpan = span();
            if (range.encloses(rangeSpan)) {
                return this;
            }
            if (range.isConnected(rangeSpan)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new d().b(iterable).c();
    }
}

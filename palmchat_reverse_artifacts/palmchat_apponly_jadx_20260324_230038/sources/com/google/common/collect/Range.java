package com.google.common.collect;

import defpackage.bv2;
import defpackage.dm4;
import defpackage.em4;
import defpackage.hj0;
import defpackage.ns0;
import defpackage.q94;
import defpackage.qd1;
import defpackage.ys4;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class Range<C extends Comparable> extends ys4 implements em4<C> {
    private static final Range<Comparable> ALL = new Range<>(ns0.o(), ns0.b());
    private static final long serialVersionUID = 0;
    final ns0<C> lowerBound;
    final ns0<C> upperBound;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6130a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f6130a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6130a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends q94<Range<?>> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q94<?> f6131a = new b();
        private static final long serialVersionUID = 0;

        @Override // defpackage.q94, java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(Range<?> range, Range<?> range2) {
            return hj0.k().f(range.lowerBound, range2.lowerBound).f(range.upperBound, range2.upperBound).j();
        }
    }

    private Range(ns0<C> ns0Var, ns0<C> ns0Var2) {
        this.lowerBound = (ns0) dm4.o(ns0Var);
        this.upperBound = (ns0) dm4.o(ns0Var2);
        if (ns0Var.compareTo(ns0Var2) > 0 || ns0Var == ns0.b() || ns0Var2 == ns0.o()) {
            throw new IllegalArgumentException("Invalid range: " + toString(ns0Var, ns0Var2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return create(ns0.p(c), ns0.b());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return create(ns0.o(), ns0.c(c));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return create(ns0.p(c), ns0.c(c2));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return create(ns0.p(c), ns0.p(c2));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(ns0<C> ns0Var, ns0<C> ns0Var2) {
        return new Range<>(ns0Var, ns0Var2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int i = a.f6130a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c);
        }
        if (i == 2) {
            return atLeast(c);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        dm4.o(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (q94.o().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) dm4.o(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) dm4.o(it.next());
            comparable = (Comparable) q94.o().e(comparable, comparable3);
            comparable2 = (Comparable) q94.o().d(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return create(ns0.c(c), ns0.b());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return create(ns0.o(), ns0.p(c));
    }

    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return create(ns0.c(c), ns0.p(c2));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return create(ns0.c(c), ns0.c(c2));
    }

    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        dm4.o(boundType);
        dm4.o(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? ns0.c(c) : ns0.p(c), boundType2 == boundType3 ? ns0.p(c2) : ns0.c(c2));
    }

    public static <C extends Comparable<?>> q94<Range<C>> rangeLexOrdering() {
        return (q94<Range<C>>) b.f6131a;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int i = a.f6130a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c);
        }
        if (i == 2) {
            return atMost(c);
        }
        throw new AssertionError();
    }

    public Range<C> canonical(qd1<C> qd1Var) {
        dm4.o(qd1Var);
        ns0<C> ns0VarQ = this.lowerBound.q(qd1Var);
        ns0<C> ns0VarQ2 = this.upperBound.q(qd1Var);
        return (ns0VarQ == this.lowerBound && ns0VarQ2 == this.upperBound) ? this : create(ns0VarQ, ns0VarQ2);
    }

    public boolean contains(C c) {
        dm4.o(c);
        return this.lowerBound.w(c) && !this.upperBound.w(c);
    }

    public boolean containsAll(Iterable<? extends C> iterable) {
        if (bv2.k(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (q94.o().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }

    @Override // defpackage.em4
    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public Range<C> gap(Range<C> range) {
        if (this.lowerBound.compareTo(range.upperBound) >= 0 || range.lowerBound.compareTo(this.upperBound) >= 0) {
            boolean z = this.lowerBound.compareTo(range.lowerBound) < 0;
            Range<C> range2 = z ? this : range;
            if (!z) {
                range = this;
            }
            return create(range2.upperBound, range.lowerBound);
        }
        throw new IllegalArgumentException("Ranges have a nonempty intersection: " + this + ", " + range);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != ns0.o();
    }

    public boolean hasUpperBound() {
        return this.upperBound != ns0.b();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo(range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo(range.upperBound);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return range;
        }
        ns0<C> ns0Var = iCompareTo >= 0 ? this.lowerBound : range.lowerBound;
        ns0<C> ns0Var2 = iCompareTo2 <= 0 ? this.upperBound : range.upperBound;
        dm4.k(ns0Var.compareTo(ns0Var2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return create(ns0Var, ns0Var2);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public ns0<C> lowerBound() {
        return this.lowerBound;
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.z();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.u();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo(range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo(range.upperBound);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo < 0 || iCompareTo2 > 0) {
            return create(iCompareTo <= 0 ? this.lowerBound : range.lowerBound, iCompareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public ns0<C> upperBound() {
        return this.upperBound;
    }

    public BoundType upperBoundType() {
        return this.upperBound.A();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.u();
    }

    private static String toString(ns0<?> ns0Var, ns0<?> ns0Var2) {
        StringBuilder sb = new StringBuilder(16);
        ns0Var.s(sb);
        sb.append("..");
        ns0Var2.t(sb);
        return sb.toString();
    }

    @Override // defpackage.em4
    @Deprecated
    public boolean apply(C c) {
        return contains(c);
    }
}

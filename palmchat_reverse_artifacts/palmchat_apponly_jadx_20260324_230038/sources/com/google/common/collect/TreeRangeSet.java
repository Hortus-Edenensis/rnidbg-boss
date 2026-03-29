package com.google.common.collect;

import defpackage.at4;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.fr3;
import defpackage.h12;
import defpackage.k1;
import defpackage.ns0;
import defpackage.o1;
import defpackage.q94;
import defpackage.zf4;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class TreeRangeSet<C extends Comparable<?>> extends o1<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient at4<C> complement;
    final NavigableMap<ns0<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends h12<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Range<C>> f6139a;

        public b(Collection<Range<C>> collection) {
            this.f6139a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return k0.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k0.d(this);
        }

        @Override // defpackage.h12, defpackage.p12
        public Collection<Range<C>> delegate() {
            return this.f6139a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends TreeRangeSet<C> {
        public c() {
            super(new d(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.at4
        public at4<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d<C extends Comparable<?>> extends com.google.common.collect.f<ns0<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<ns0<C>, Range<C>> f6141a;
        public final NavigableMap<ns0<C>, Range<C>> b;
        public final Range<ns0<C>> c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public ns0<C> c;
            public final /* synthetic */ ns0 d;
            public final /* synthetic */ zf4 e;
            public final /* synthetic */ d f;

            public a(d dVar, ns0 ns0Var, zf4 zf4Var) {
                this.d = ns0Var;
                this.e = zf4Var;
                this.f = dVar;
                this.c = ns0Var;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                Range rangeCreate;
                if (this.f.c.upperBound.w(this.c) || this.c == ns0.b()) {
                    return (Map.Entry) b();
                }
                if (this.e.hasNext()) {
                    Range range = (Range) this.e.next();
                    rangeCreate = Range.create(this.c, range.lowerBound);
                    this.c = range.upperBound;
                } else {
                    rangeCreate = Range.create(this.c, ns0.b());
                    this.c = ns0.b();
                }
                return u.i(rangeCreate.lowerBound, rangeCreate);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public ns0<C> c;
            public final /* synthetic */ ns0 d;
            public final /* synthetic */ zf4 e;
            public final /* synthetic */ d f;

            public b(d dVar, ns0 ns0Var, zf4 zf4Var) {
                this.d = ns0Var;
                this.e = zf4Var;
                this.f = dVar;
                this.c = ns0Var;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                if (this.c == ns0.o()) {
                    return (Map.Entry) b();
                }
                if (this.e.hasNext()) {
                    Range range = (Range) this.e.next();
                    Range rangeCreate = Range.create(range.upperBound, this.c);
                    this.c = range.lowerBound;
                    if (this.f.c.lowerBound.w(rangeCreate.lowerBound)) {
                        return u.i(rangeCreate.lowerBound, rangeCreate);
                    }
                } else if (this.f.c.lowerBound.w(ns0.o())) {
                    Range rangeCreate2 = Range.create(ns0.o(), this.c);
                    this.c = ns0.o();
                    return u.i(ns0.o(), rangeCreate2);
                }
                return (Map.Entry) b();
            }
        }

        public d(NavigableMap<ns0<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<ns0<C>, Range<C>>> a() {
            Collection<Range<C>> collectionValues;
            ns0 ns0VarO;
            if (this.c.hasLowerBound()) {
                collectionValues = this.b.tailMap((ns0) this.c.lowerEndpoint(), this.c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.b.values();
            }
            zf4 zf4VarS = cv2.s(collectionValues.iterator());
            if (this.c.contains(ns0.o()) && (!zf4VarS.hasNext() || ((Range) zf4VarS.peek()).lowerBound != ns0.o())) {
                ns0VarO = ns0.o();
            } else {
                if (!zf4VarS.hasNext()) {
                    return cv2.h();
                }
                ns0VarO = ((Range) zf4VarS.next()).upperBound;
            }
            return new a(this, ns0VarO, zf4VarS);
        }

        @Override // com.google.common.collect.f
        public Iterator<Map.Entry<ns0<C>, Range<C>>> b() {
            ns0<C> ns0VarHigherKey;
            zf4 zf4VarS = cv2.s(this.b.headMap(this.c.hasUpperBound() ? (ns0) this.c.upperEndpoint() : ns0.b(), this.c.hasUpperBound() && this.c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (zf4VarS.hasNext()) {
                ns0VarHigherKey = ((Range) zf4VarS.peek()).upperBound == ns0.b() ? ((Range) zf4VarS.next()).lowerBound : this.f6141a.higherKey(((Range) zf4VarS.peek()).upperBound);
            } else {
                if (!this.c.contains(ns0.o()) || this.f6141a.containsKey(ns0.o())) {
                    return cv2.h();
                }
                ns0VarHigherKey = this.f6141a.higherKey(ns0.o());
            }
            return new b(this, (ns0) fr3.a(ns0VarHigherKey, ns0.b()), zf4VarS);
        }

        @Override // java.util.SortedMap
        public Comparator<? super ns0<C>> comparator() {
            return q94.o();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof ns0) {
                try {
                    ns0<C> ns0Var = (ns0) obj;
                    Map.Entry<ns0<C>, Range<C>> entryFirstEntry = tailMap(ns0Var, true).firstEntry();
                    if (entryFirstEntry != null && entryFirstEntry.getKey().equals(ns0Var)) {
                        return entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> headMap(ns0<C> ns0Var, boolean z) {
            return g(Range.upTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> subMap(ns0<C> ns0Var, boolean z, ns0<C> ns0Var2, boolean z2) {
            return g(Range.range(ns0Var, BoundType.forBoolean(z), ns0Var2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<ns0<C>, Range<C>> g(Range<ns0<C>> range) {
            if (!this.c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.f6141a, range.intersection(this.c));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> tailMap(ns0<C> ns0Var, boolean z) {
            return g(Range.downTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return cv2.y(a());
        }

        public d(NavigableMap<ns0<C>, Range<C>> navigableMap, Range<ns0<C>> range) {
            this.f6141a = navigableMap;
            this.b = new e(navigableMap);
            this.c = range;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class f extends TreeRangeSet<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<C> f6143a;

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Range<C> range) {
            super(new g(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.f6143a = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public void add(Range<C> range) {
            dm4.k(this.f6143a.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.f6143a);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public void clear() {
            TreeRangeSet.this.remove(this.f6143a);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public boolean contains(C c) {
            return this.f6143a.contains(c) && TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1, defpackage.at4
        public boolean encloses(Range<C> range) {
            Range rangeRangeEnclosing;
            return (this.f6143a.isEmpty() || !this.f6143a.encloses(range) || (rangeRangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeRangeEnclosing.intersection(this.f6143a).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public Range<C> rangeContaining(C c) {
            Range<C> rangeRangeContaining;
            if (this.f6143a.contains(c) && (rangeRangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeRangeContaining.intersection(this.f6143a);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.o1
        public void remove(Range<C> range) {
            if (range.isConnected(this.f6143a)) {
                TreeRangeSet.this.remove(range.intersection(this.f6143a));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.at4
        public at4<C> subRangeSet(Range<C> range) {
            return range.encloses(this.f6143a) ? this : range.isConnected(this.f6143a) ? new f(this.f6143a.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g<C extends Comparable<?>> extends com.google.common.collect.f<ns0<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<ns0<C>> f6144a;
        public final Range<C> b;
        public final NavigableMap<ns0<C>, Range<C>> c;
        public final NavigableMap<ns0<C>, Range<C>> d;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ ns0 d;
            public final /* synthetic */ g e;

            public a(g gVar, Iterator it, ns0 ns0Var) {
                this.c = it;
                this.d = ns0Var;
                this.e = gVar;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (this.d.w(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(this.e.b);
                return u.i(rangeIntersection.lowerBound, rangeIntersection);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ g d;

            public b(g gVar, Iterator it) {
                this.c = it;
                this.d = gVar;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (this.d.b.lowerBound.compareTo(range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(this.d.b);
                return this.d.f6144a.contains(rangeIntersection.lowerBound) ? u.i(rangeIntersection.lowerBound, rangeIntersection) : (Map.Entry) b();
            }
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<ns0<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.b.isEmpty()) {
                return cv2.h();
            }
            if (this.f6144a.upperBound.w(this.b.lowerBound)) {
                return cv2.h();
            }
            if (this.f6144a.lowerBound.w(this.b.lowerBound)) {
                it = this.d.tailMap(this.b.lowerBound, false).values().iterator();
            } else {
                it = this.c.tailMap((ns0) this.f6144a.lowerBound.u(), this.f6144a.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new a(this, it, (ns0) q94.o().e(this.f6144a.upperBound, ns0.p(this.b.upperBound)));
        }

        @Override // com.google.common.collect.f
        public Iterator<Map.Entry<ns0<C>, Range<C>>> b() {
            if (this.b.isEmpty()) {
                return cv2.h();
            }
            ns0 ns0Var = (ns0) q94.o().e(this.f6144a.upperBound, ns0.p(this.b.upperBound));
            return new b(this, this.c.headMap((ns0) ns0Var.u(), ns0Var.A() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super ns0<C>> comparator() {
            return q94.o();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof ns0) {
                try {
                    ns0<C> ns0Var = (ns0) obj;
                    if (this.f6144a.contains(ns0Var) && ns0Var.compareTo(this.b.lowerBound) >= 0 && ns0Var.compareTo(this.b.upperBound) < 0) {
                        if (ns0Var.equals(this.b.lowerBound)) {
                            Range range = (Range) u.F(this.c.floorEntry(ns0Var));
                            if (range != null && range.upperBound.compareTo(this.b.lowerBound) > 0) {
                                return range.intersection(this.b);
                            }
                        } else {
                            Range<C> range2 = this.c.get(ns0Var);
                            if (range2 != null) {
                                return range2.intersection(this.b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> headMap(ns0<C> ns0Var, boolean z) {
            return h(Range.upTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> subMap(ns0<C> ns0Var, boolean z, ns0<C> ns0Var2, boolean z2) {
            return h(Range.range(ns0Var, BoundType.forBoolean(z), ns0Var2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<ns0<C>, Range<C>> h(Range<ns0<C>> range) {
            return !range.isConnected(this.f6144a) ? ImmutableSortedMap.of() : new g(this.f6144a.intersection(range), this.b, this.c);
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> tailMap(ns0<C> ns0Var, boolean z) {
            return h(Range.downTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return cv2.y(a());
        }

        public g(Range<ns0<C>> range, Range<C> range2, NavigableMap<ns0<C>, Range<C>> navigableMap) {
            this.f6144a = (Range) dm4.o(range);
            this.b = (Range) dm4.o(range2);
            this.c = (NavigableMap) dm4.o(navigableMap);
            this.d = new e(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        dm4.o(range);
        Map.Entry<ns0<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().encloses(range)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // defpackage.o1
    public void add(Range<C> range) {
        dm4.o(range);
        if (range.isEmpty()) {
            return;
        }
        ns0<C> ns0Var = range.lowerBound;
        ns0<C> ns0Var2 = range.upperBound;
        Map.Entry<ns0<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(ns0Var);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo(ns0Var) >= 0) {
                if (value.upperBound.compareTo(ns0Var2) >= 0) {
                    ns0Var2 = value.upperBound;
                }
                ns0Var = value.lowerBound;
            }
        }
        Map.Entry<ns0<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(ns0Var2);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (value2.upperBound.compareTo(ns0Var2) >= 0) {
                ns0Var2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(ns0Var, ns0Var2).clear();
        replaceRangeWithSameLowerBound(Range.create(ns0Var, ns0Var2));
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ void addAll(at4 at4Var) {
        super.addAll(at4Var);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // defpackage.at4
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // defpackage.at4
    public at4<C> complement() {
        at4<C> at4Var = this.complement;
        if (at4Var != null) {
            return at4Var;
        }
        c cVar = new c();
        this.complement = cVar;
        return cVar;
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // defpackage.o1, defpackage.at4
    public boolean encloses(Range<C> range) {
        dm4.o(range);
        Map.Entry<ns0<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean enclosesAll(at4 at4Var) {
        return super.enclosesAll(at4Var);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.o1
    public boolean intersects(Range<C> range) {
        dm4.o(range);
        Map.Entry<ns0<C>, Range<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<ns0<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // defpackage.o1, defpackage.at4
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // defpackage.o1
    public Range<C> rangeContaining(C c2) {
        dm4.o(c2);
        Map.Entry<ns0<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(ns0.p(c2));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().contains(c2)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    @Override // defpackage.o1
    public void remove(Range<C> range) {
        dm4.o(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<ns0<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<ns0<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // defpackage.o1, defpackage.at4
    public /* bridge */ /* synthetic */ void removeAll(at4 at4Var) {
        super.removeAll(at4Var);
    }

    public Range<C> span() {
        Map.Entry<ns0<C>, Range<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<ns0<C>, Range<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
    }

    @Override // defpackage.at4
    public at4<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new f(range);
    }

    private TreeRangeSet(NavigableMap<ns0<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(at4<C> at4Var) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(at4Var);
        return treeRangeSetCreate;
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // defpackage.o1
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<C extends Comparable<?>> extends com.google.common.collect.f<ns0<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<ns0<C>, Range<C>> f6142a;
        public final Range<ns0<C>> b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ e d;

            public a(e eVar, Iterator it) {
                this.c = it;
                this.d = eVar;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                return this.d.b.upperBound.w(range.upperBound) ? (Map.Entry) b() : u.i(range.upperBound, range);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends k1<Map.Entry<ns0<C>, Range<C>>> {
            public final /* synthetic */ zf4 c;
            public final /* synthetic */ e d;

            public b(e eVar, zf4 zf4Var) {
                this.c = zf4Var;
                this.d = eVar;
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<ns0<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                return this.d.b.lowerBound.w(range.upperBound) ? u.i(range.upperBound, range) : (Map.Entry) b();
            }
        }

        public e(NavigableMap<ns0<C>, Range<C>> navigableMap) {
            this.f6142a = navigableMap;
            this.b = Range.all();
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<ns0<C>, Range<C>>> a() {
            Map.Entry<ns0<C>, Range<C>> entryLowerEntry;
            Iterator<Range<C>> it = (this.b.hasLowerBound() && (entryLowerEntry = this.f6142a.lowerEntry((ns0) this.b.lowerEndpoint())) != null) ? this.b.lowerBound.w(entryLowerEntry.getValue().upperBound) ? this.f6142a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f6142a.tailMap((ns0) this.b.lowerEndpoint(), true).values().iterator() : this.f6142a.values().iterator();
            return new a(this, it);
        }

        @Override // com.google.common.collect.f
        public Iterator<Map.Entry<ns0<C>, Range<C>>> b() {
            zf4 zf4VarS = cv2.s((this.b.hasUpperBound() ? this.f6142a.headMap((ns0) this.b.upperEndpoint(), false).descendingMap().values() : this.f6142a.descendingMap().values()).iterator());
            if (zf4VarS.hasNext() && this.b.upperBound.w(((Range) zf4VarS.peek()).upperBound)) {
                zf4VarS.next();
            }
            return new b(this, zf4VarS);
        }

        @Override // java.util.SortedMap
        public Comparator<? super ns0<C>> comparator() {
            return q94.o();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            Map.Entry<ns0<C>, Range<C>> entryLowerEntry;
            if (obj instanceof ns0) {
                try {
                    ns0<C> ns0Var = (ns0) obj;
                    if (this.b.contains(ns0Var) && (entryLowerEntry = this.f6142a.lowerEntry(ns0Var)) != null && entryLowerEntry.getValue().upperBound.equals(ns0Var)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> headMap(ns0<C> ns0Var, boolean z) {
            return g(Range.upTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> subMap(ns0<C> ns0Var, boolean z, ns0<C> ns0Var2, boolean z2) {
            return g(Range.range(ns0Var, BoundType.forBoolean(z), ns0Var2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap<ns0<C>, Range<C>> g(Range<ns0<C>> range) {
            return range.isConnected(this.b) ? new e(this.f6142a, range.intersection(this.b)) : ImmutableSortedMap.of();
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<ns0<C>, Range<C>> tailMap(ns0<C> ns0Var, boolean z) {
            return g(Range.downTo(ns0Var, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.b.equals(Range.all()) ? this.f6142a.isEmpty() : !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.b.equals(Range.all()) ? this.f6142a.size() : cv2.y(a());
        }

        public e(NavigableMap<ns0<C>, Range<C>> navigableMap, Range<ns0<C>> range) {
            this.f6142a = navigableMap;
            this.b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(iterable);
        return treeRangeSetCreate;
    }
}

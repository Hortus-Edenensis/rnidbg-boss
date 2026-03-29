package com.google.common.collect;

import com.google.common.collect.x;
import com.google.common.collect.y;
import defpackage.a44;
import defpackage.bv2;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.fr3;
import defpackage.ku2;
import defpackage.q52;
import defpackage.q94;
import defpackage.sg0;
import j$.util.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient f<E> header;
    private final transient q52<E> range;
    private final transient g<f<E>> rootReference;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends y.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f6133a;
        public final /* synthetic */ TreeMultiset b;

        public a(TreeMultiset treeMultiset, f fVar) {
            this.f6133a = fVar;
            this.b = treeMultiset;
        }

        @Override // com.google.common.collect.x.a
        public int getCount() {
            int iW = this.f6133a.w();
            return iW == 0 ? this.b.count(getElement()) : iW;
        }

        @Override // com.google.common.collect.x.a
        public E getElement() {
            return (E) this.f6133a.x();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Iterator<x.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f<E> f6134a;
        public x.a<E> b;

        public b() {
            this.f6134a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            f<E> fVar = this.f6134a;
            Objects.requireNonNull(fVar);
            x.a<E> aVarWrapEntry = treeMultiset.wrapEntry(fVar);
            this.b = aVarWrapEntry;
            if (this.f6134a.L() == TreeMultiset.this.header) {
                this.f6134a = null;
            } else {
                this.f6134a = this.f6134a.L();
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6134a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.y(this.f6134a.x())) {
                return true;
            }
            this.f6134a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            dm4.u(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Iterator<x.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f<E> f6135a;
        public x.a<E> b = null;

        public c() {
            this.f6135a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f6135a);
            x.a<E> aVarWrapEntry = TreeMultiset.this.wrapEntry(this.f6135a);
            this.b = aVarWrapEntry;
            if (this.f6135a.z() == TreeMultiset.this.header) {
                this.f6135a = null;
            } else {
                this.f6135a = this.f6135a.z();
            }
            return aVarWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6135a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.z(this.f6135a.x())) {
                return true;
            }
            this.f6135a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            dm4.u(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6136a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f6136a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6136a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e {
        public static final e SIZE = new a("SIZE", 0);
        public static final e DISTINCT = new b("DISTINCT", 1);
        private static final /* synthetic */ e[] $VALUES = $values();

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends e {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public int nodeAggregate(f<?> fVar) {
                return fVar.b;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public long treeAggregate(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return fVar.d;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b extends e {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public int nodeAggregate(f<?> fVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public long treeAggregate(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return fVar.c;
            }
        }

        private static /* synthetic */ e[] $values() {
            return new e[]{SIZE, DISTINCT};
        }

        private e(String str, int i) {
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) $VALUES.clone();
        }

        public abstract int nodeAggregate(f<?> fVar);

        public abstract long treeAggregate(f<?> fVar);

        public /* synthetic */ e(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f6138a;

        public g() {
        }

        public void a(T t, T t2) {
            if (this.f6138a != t) {
                throw new ConcurrentModificationException();
            }
            this.f6138a = t2;
        }

        public void b() {
            this.f6138a = null;
        }

        public T c() {
            return this.f6138a;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public TreeMultiset(g<f<E>> gVar, q52<E> q52Var, f<E> fVar) {
        super(q52Var.b());
        this.rootReference = gVar;
        this.range = q52Var;
        this.header = fVar;
    }

    private long aggregateAboveRange(e eVar, f<E> fVar) {
        long jTreeAggregate;
        long jAggregateAboveRange;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(a44.a(this.range.u()), fVar.x());
        if (iCompare > 0) {
            return aggregateAboveRange(eVar, fVar.g);
        }
        if (iCompare == 0) {
            int i = d.f6136a[this.range.s().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return eVar.treeAggregate(fVar.g);
                }
                throw new AssertionError();
            }
            jTreeAggregate = eVar.nodeAggregate(fVar);
            jAggregateAboveRange = eVar.treeAggregate(fVar.g);
        } else {
            jTreeAggregate = eVar.treeAggregate(fVar.g) + ((long) eVar.nodeAggregate(fVar));
            jAggregateAboveRange = aggregateAboveRange(eVar, fVar.f);
        }
        return jTreeAggregate + jAggregateAboveRange;
    }

    private long aggregateBelowRange(e eVar, f<E> fVar) {
        long jTreeAggregate;
        long jAggregateBelowRange;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(a44.a(this.range.p()), fVar.x());
        if (iCompare < 0) {
            return aggregateBelowRange(eVar, fVar.f);
        }
        if (iCompare == 0) {
            int i = d.f6136a[this.range.o().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return eVar.treeAggregate(fVar.f);
                }
                throw new AssertionError();
            }
            jTreeAggregate = eVar.nodeAggregate(fVar);
            jAggregateBelowRange = eVar.treeAggregate(fVar.f);
        } else {
            jTreeAggregate = eVar.treeAggregate(fVar.f) + ((long) eVar.nodeAggregate(fVar));
            jAggregateBelowRange = aggregateBelowRange(eVar, fVar.g);
        }
        return jTreeAggregate + jAggregateBelowRange;
    }

    private long aggregateForEntries(e eVar) {
        f<E> fVarC = this.rootReference.c();
        long jTreeAggregate = eVar.treeAggregate(fVarC);
        if (this.range.v()) {
            jTreeAggregate -= aggregateBelowRange(eVar, fVarC);
        }
        return this.range.w() ? jTreeAggregate - aggregateAboveRange(eVar, fVarC) : jTreeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(q94.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> firstNode() {
        f<E> fVarL;
        f<E> fVarC = this.rootReference.c();
        if (fVarC == null) {
            return null;
        }
        if (this.range.v()) {
            Object objA = a44.a(this.range.p());
            fVarL = fVarC.s(comparator(), objA);
            if (fVarL == null) {
                return null;
            }
            if (this.range.o() == BoundType.OPEN && comparator().compare(objA, fVarL.x()) == 0) {
                fVarL = fVarL.L();
            }
        } else {
            fVarL = this.header.L();
        }
        if (fVarL == this.header || !this.range.c(fVarL.x())) {
            return null;
        }
        return fVarL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> lastNode() {
        f<E> fVarZ;
        f<E> fVarC = this.rootReference.c();
        if (fVarC == null) {
            return null;
        }
        if (this.range.w()) {
            Object objA = a44.a(this.range.u());
            fVarZ = fVarC.v(comparator(), objA);
            if (fVarZ == null) {
                return null;
            }
            if (this.range.s() == BoundType.OPEN && comparator().compare(objA, fVarZ.x()) == 0) {
                fVarZ = fVarZ.z();
            }
        } else {
            fVarZ = this.header.z();
        }
        if (fVarZ == this.header || !this.range.c(fVarZ.x())) {
            return null;
        }
        return fVarZ;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        Comparator comparator = (Comparator) object;
        i0.a(h.class, "comparator").b(this, comparator);
        i0.a(TreeMultiset.class, "range").b(this, q52.a(comparator));
        i0.a(TreeMultiset.class, "rootReference").b(this, new g(null));
        f fVar = new f();
        i0.a(TreeMultiset.class, "header").b(this, fVar);
        successor(fVar, fVar);
        i0.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(f<T> fVar, f<T> fVar2) {
        fVar.i = fVar2;
        fVar2.h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x.a<E> wrapEntry(f<E> fVar) {
        return new a(this, fVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        i0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int add(E e2, int i) {
        sg0.b(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        dm4.d(this.range.c(e2));
        f<E> fVarC = this.rootReference.c();
        if (fVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(fVarC, fVarC.o(comparator(), e2, i, iArr));
            return iArr[0];
        }
        comparator().compare(e2, e2);
        f<E> fVar = new f<>(e2, i);
        f<E> fVar2 = this.header;
        successor(fVar2, fVar, fVar2);
        this.rootReference.a(fVarC, fVar);
        return 0;
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.v() || this.range.w()) {
            cv2.d(entryIterator());
            return;
        }
        f<E> fVarL = this.header.L();
        while (true) {
            f<E> fVar = this.header;
            if (fVarL == fVar) {
                successor(fVar, fVar);
                this.rootReference.b();
                return;
            }
            f<E> fVarL2 = fVarL.L();
            fVarL.b = 0;
            fVarL.f = null;
            fVarL.g = null;
            fVarL.h = null;
            fVarL.i = null;
            fVarL = fVarL2;
        }
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0, defpackage.jg5
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.x
    public int count(Object obj) {
        try {
            f<E> fVarC = this.rootReference.c();
            if (this.range.c(obj) && fVarC != null) {
                return fVarC.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.h
    public Iterator<x.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ o0 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.e
    public int distinctElements() {
        return ku2.o(aggregateForEntries(e.DISTINCT));
    }

    @Override // com.google.common.collect.e
    public Iterator<E> elementIterator() {
        return y.e(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.e, com.google.common.collect.x
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.e
    public Iterator<x.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ x.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.o0
    public o0<E> headMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.x(q52.A(comparator(), e2, boundType)), this.header);
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return y.i(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ x.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ x.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ x.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int remove(Object obj, int i) {
        sg0.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        f<E> fVarC = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.c(obj) && fVarC != null) {
                this.rootReference.a(fVarC, fVarC.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int setCount(E e2, int i) {
        sg0.b(i, "count");
        if (!this.range.c(e2)) {
            dm4.d(i == 0);
            return 0;
        }
        f<E> fVarC = this.rootReference.c();
        if (fVarC == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(fVarC, fVarC.K(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public int size() {
        return ku2.o(aggregateForEntries(e.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ o0 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.o0
    public o0<E> tailMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.x(q52.d(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(q94.o()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(f<?> fVar) {
        if (fVar == null) {
            return 0;
        }
        return fVar.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(f<T> fVar, f<T> fVar2, f<T> fVar3) {
        successor(fVar, fVar2);
        successor(fVar2, fVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> treeMultisetCreate = create();
        bv2.a(treeMultisetCreate, iterable);
        return treeMultisetCreate;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = q52.a(comparator);
        f<E> fVar = new f<>();
        this.header = fVar;
        successor(fVar, fVar);
        this.rootReference = new g<>(null);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public boolean setCount(E e2, int i, int i2) {
        sg0.b(i2, "newCount");
        sg0.b(i, "oldCount");
        dm4.d(this.range.c(e2));
        f<E> fVarC = this.rootReference.c();
        if (fVarC != null) {
            int[] iArr = new int[1];
            this.rootReference.a(fVarC, fVarC.J(comparator(), e2, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e2, i2);
        }
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f6137a;
        public int b;
        public int c;
        public long d;
        public int e;
        public f<E> f;
        public f<E> g;
        public f<E> h;
        public f<E> i;

        public f(E e, int i) {
            dm4.d(i > 0);
            this.f6137a = e;
            this.b = i;
            this.d = i;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        public static long M(f<?> fVar) {
            if (fVar == null) {
                return 0L;
            }
            return fVar.d;
        }

        public static int y(f<?> fVar) {
            if (fVar == null) {
                return 0;
            }
            return fVar.e;
        }

        public final f<E> A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.g);
                if (this.g.r() > 0) {
                    this.g = this.g.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f);
            if (this.f.r() < 0) {
                this.f = this.f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.e = Math.max(y(this.f), y(this.g)) + 1;
        }

        public final void D() {
            this.c = TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g);
            this.d = ((long) this.b) + M(this.f) + M(this.g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f<E> E(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = fVar.E(comparator, e, i, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    if (i >= i2) {
                        this.c--;
                        this.d -= (long) i2;
                    } else {
                        this.d -= (long) i;
                    }
                }
                return i2 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                if (i >= i3) {
                    return u();
                }
                this.b = i3 - i;
                this.d -= (long) i;
                return this;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.g = fVar2.E(comparator, e, i, iArr);
            int i4 = iArr[0];
            if (i4 > 0) {
                if (i >= i4) {
                    this.c--;
                    this.d -= (long) i4;
                } else {
                    this.d -= (long) i;
                }
            }
            return A();
        }

        public final f<E> F(f<E> fVar) {
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                return this.f;
            }
            this.g = fVar2.F(fVar);
            this.c--;
            this.d -= (long) fVar.b;
            return A();
        }

        public final f<E> G(f<E> fVar) {
            f<E> fVar2 = this.f;
            if (fVar2 == null) {
                return this.g;
            }
            this.f = fVar2.G(fVar);
            this.c--;
            this.d -= (long) fVar.b;
            return A();
        }

        public final f<E> H() {
            dm4.t(this.g != null);
            f<E> fVar = this.g;
            this.g = fVar.f;
            fVar.f = this;
            fVar.d = this.d;
            fVar.c = this.c;
            B();
            fVar.C();
            return fVar;
        }

        public final f<E> I() {
            dm4.t(this.f != null);
            f<E> fVar = this.f;
            this.f = fVar.g;
            fVar.g = this;
            fVar.d = this.d;
            fVar.c = this.c;
            B();
            fVar.C();
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f<E> J(Comparator<? super E> comparator, E e, int i, int i2, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : p(e, i2);
                }
                this.f = fVar.J(comparator, e, i, i2, iArr);
                int i3 = iArr[0];
                if (i3 == i) {
                    if (i2 == 0 && i3 != 0) {
                        this.c--;
                    } else if (i2 > 0 && i3 == 0) {
                        this.c++;
                    }
                    this.d += (long) (i2 - i3);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i4 = this.b;
                iArr[0] = i4;
                if (i == i4) {
                    if (i2 == 0) {
                        return u();
                    }
                    this.d += (long) (i2 - i4);
                    this.b = i2;
                }
                return this;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : q(e, i2);
            }
            this.g = fVar2.J(comparator, e, i, i2, iArr);
            int i5 = iArr[0];
            if (i5 == i) {
                if (i2 == 0 && i5 != 0) {
                    this.c--;
                } else if (i2 > 0 && i5 == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - i5);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f<E> K(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return i > 0 ? p(e, i) : this;
                }
                this.f = fVar.K(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i2 = this.b;
                iArr[0] = i2;
                if (i == 0) {
                    return u();
                }
                this.d += (long) (i - i2);
                this.b = i;
                return this;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return i > 0 ? q(e, i) : this;
            }
            this.g = fVar2.K(comparator, e, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.c--;
            } else if (i > 0 && iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) (i - iArr[0]);
            return A();
        }

        public final f<E> L() {
            f<E> fVar = this.i;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f<E> o(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return p(e, i);
                }
                int i2 = fVar.e;
                f<E> fVarO = fVar.o(comparator, e, i, iArr);
                this.f = fVarO;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i;
                return fVarO.e == i2 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                long j = i;
                dm4.d(((long) i3) + j <= 2147483647L);
                this.b += i;
                this.d += j;
                return this;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return q(e, i);
            }
            int i4 = fVar2.e;
            f<E> fVarO2 = fVar2.o(comparator, e, i, iArr);
            this.g = fVarO2;
            if (iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) i;
            return fVarO2.e == i4 ? this : A();
        }

        public final f<E> p(E e, int i) {
            this.f = new f<>(e, i);
            TreeMultiset.successor(z(), this.f, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i;
            return this;
        }

        public final f<E> q(E e, int i) {
            f<E> fVar = new f<>(e, i);
            this.g = fVar;
            TreeMultiset.successor(this, fVar, L());
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i;
            return this;
        }

        public final int r() {
            return y(this.f) - y(this.g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f<E> s(Comparator<? super E> comparator, E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                return fVar == null ? this : (f) fr3.a(fVar.s(comparator, e), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.s(comparator, e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare < 0) {
                f<E> fVar = this.f;
                if (fVar == null) {
                    return 0;
                }
                return fVar.t(comparator, e);
            }
            if (iCompare <= 0) {
                return this.b;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                return 0;
            }
            return fVar2.t(comparator, e);
        }

        public String toString() {
            return y.g(x(), w()).toString();
        }

        public final f<E> u() {
            int i = this.b;
            this.b = 0;
            TreeMultiset.successor(z(), L());
            f<E> fVar = this.f;
            if (fVar == null) {
                return this.g;
            }
            f<E> fVar2 = this.g;
            if (fVar2 == null) {
                return fVar;
            }
            if (fVar.e >= fVar2.e) {
                f<E> fVarZ = z();
                fVarZ.f = this.f.F(fVarZ);
                fVarZ.g = this.g;
                fVarZ.c = this.c - 1;
                fVarZ.d = this.d - ((long) i);
                return fVarZ.A();
            }
            f<E> fVarL = L();
            fVarL.g = this.g.G(fVarL);
            fVarL.f = this.f;
            fVarL.c = this.c - 1;
            fVarL.d = this.d - ((long) i);
            return fVarL.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f<E> v(Comparator<? super E> comparator, E e) {
            int iCompare = comparator.compare(e, x());
            if (iCompare > 0) {
                f<E> fVar = this.g;
                return fVar == null ? this : (f) fr3.a(fVar.v(comparator, e), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.f;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.v(comparator, e);
        }

        public int w() {
            return this.b;
        }

        public E x() {
            return (E) a44.a(this.f6137a);
        }

        public final f<E> z() {
            f<E> fVar = this.h;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        public f() {
            this.f6137a = null;
            this.b = 1;
        }
    }
}

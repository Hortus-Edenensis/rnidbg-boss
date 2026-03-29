package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.x;
import defpackage.dm4;
import defpackage.o46;
import defpackage.wr2;
import j$.util.Objects;
import j$.util.function.Function$CC;
import j$.util.stream.Collector;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ImmutableMultiset<E> extends wr2<E> implements x<E> {
    private static final long serialVersionUID = 912559;
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<x.a<E>> entrySet;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o46<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6092a;
        public E b;
        public final /* synthetic */ Iterator c;
        public final /* synthetic */ ImmutableMultiset d;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.c = it;
            this.d = immutableMultiset;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6092a > 0 || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f6092a <= 0) {
                x.a aVar = (x.a) this.c.next();
                this.b = (E) aVar.getElement();
                this.f6092a = aVar.getCount();
            }
            this.f6092a--;
            E e = this.b;
            Objects.requireNonNull(e);
            return e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<E> extends ImmutableCollection.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z<E> f6093a;
        public boolean b;
        public boolean c;

        public b() {
            this(4);
        }

        public static <T> z<T> m(Iterable<T> iterable) {
            if (iterable instanceof d0) {
                return ((d0) iterable).f6163a;
            }
            if (iterable instanceof com.google.common.collect.c) {
                return ((com.google.common.collect.c) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e) {
            return k(e, 1);
        }

        public b<E> h(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b<E> i(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f6093a);
            if (iterable instanceof x) {
                x xVarD = y.d(iterable);
                z zVarM = m(xVarD);
                if (zVarM != null) {
                    z<E> zVar = this.f6093a;
                    zVar.d(Math.max(zVar.C(), zVarM.C()));
                    for (int iE = zVarM.e(); iE >= 0; iE = zVarM.s(iE)) {
                        k(zVarM.i(iE), zVarM.k(iE));
                    }
                } else {
                    Set<x.a<E>> setEntrySet = xVarD.entrySet();
                    z<E> zVar2 = this.f6093a;
                    zVar2.d(Math.max(zVar2.C(), setEntrySet.size()));
                    for (x.a<E> aVar : xVarD.entrySet()) {
                        k(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b<E> j(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public b<E> k(E e, int i) {
            Objects.requireNonNull(this.f6093a);
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.f6093a = new z<>(this.f6093a);
                this.c = false;
            }
            this.b = false;
            dm4.o(e);
            z<E> zVar = this.f6093a;
            zVar.u(e, i + zVar.f(e));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableMultiset<E> e() {
            Objects.requireNonNull(this.f6093a);
            if (this.f6093a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.c) {
                this.f6093a = new z<>(this.f6093a);
                this.c = false;
            }
            this.b = true;
            return new d0(this.f6093a);
        }

        public b(int i) {
            this.b = false;
            this.c = false;
            this.f6093a = z.c(i);
        }

        public b(boolean z) {
            this.b = false;
            this.c = false;
            this.f6093a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends t<x.a<E>> {
        private static final long serialVersionUID = 0;

        public c() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x.a<E> get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof x.a)) {
                return false;
            }
            x.a aVar = (x.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.t, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new d(ImmutableMultiset.this);
        }

        public /* synthetic */ c(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<E> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMultiset<E> f6095a;

        public d(ImmutableMultiset<E> immutableMultiset) {
            this.f6095a = immutableMultiset;
        }

        public Object readResolve() {
            return this.f6095a.entrySet();
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().h(eArr).e();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends x.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (x.a<? extends E> aVar : collection) {
            bVar.k(aVar.getElement(), aVar.getCount());
        }
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<x.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new c(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$toImmutableMultiset$0(Object obj) {
        return 1;
    }

    public static <E> ImmutableMultiset<E> of() {
        return d0.d;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return k.S(Function$CC.identity(), new ToIntFunction() { // from class: vr2
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ImmutableMultiset.lambda$toImmutableMultiset$0(obj);
            }
        });
    }

    @Override // com.google.common.collect.x
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListAsList = super.asList();
        this.asList = immutableListAsList;
        return immutableListAsList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        o46<x.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            x.a<E> next = it.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.x
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.x
    public boolean equals(Object obj) {
        return y.f(this, obj);
    }

    public abstract x.a<E> getEntry(int i);

    @Override // java.util.Collection, com.google.common.collect.x
    public int hashCode() {
        return k0.d(entrySet());
    }

    @Override // com.google.common.collect.x
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(y.h(iterable));
        bVar.i(iterable);
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return copyFromElements(e);
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        return k.S(function, toIntFunction);
    }

    @Override // com.google.common.collect.x
    public ImmutableSet<x.a<E>> entrySet() {
        ImmutableSet<x.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<x.a<E>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public o46<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.x
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new b().a(e).a(e2).a(e3).a(e4).a(e5).a(e6).h(eArr).e();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().j(it).e();
    }
}

package com.google.common.collect;

import com.google.common.collect.l;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.em4;
import defpackage.fm4;
import defpackage.k1;
import defpackage.o46;
import defpackage.y12;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class k0 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: SearchBox */
    public class a<E> extends e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f6177a;
        public final /* synthetic */ Set b;

        /* JADX INFO: renamed from: com.google.common.collect.k0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0376a extends k1<E> {
            public final Iterator<E> c;

            public C0376a() {
                this.c = a.this.f6177a.iterator();
            }

            @Override // defpackage.k1
            public E a() {
                while (this.c.hasNext()) {
                    E next = this.c.next();
                    if (a.this.b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f6177a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o46<E> iterator() {
            return new C0376a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f6177a.contains(obj) && this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f6177a.containsAll(collection) && this.b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.f6177a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f6177a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<E> extends l.a<E> implements Set<E> {
        public b(Set<E> set, em4<? super E> em4Var) {
            super(set, em4Var);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return k0.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k0.d(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<E> extends b<E> implements SortedSet<E> {
        public c(SortedSet<E> sortedSet, em4<? super E> em4Var) {
            super(sortedSet, em4Var);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f6179a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) cv2.l(this.f6179a.iterator(), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e) {
            return new c(((SortedSet) this.f6179a).headSet(e), this.b);
        }

        @Override // java.util.SortedSet
        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f6179a;
            while (true) {
                E e = (Object) sortedSetHeadSet.last();
                if (this.b.apply(e)) {
                    return e;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e, E e2) {
            return new c(((SortedSet) this.f6179a).subSet(e, e2), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e) {
            return new c(((SortedSet) this.f6179a).tailSet(e), this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return k0.j(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) dm4.o(collection));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e<E> extends AbstractSet<E> {
        public /* synthetic */ e(j0 j0Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public e() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<E> extends y12<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableSet<E> f6178a;
        public final SortedSet<E> b;
        public transient f<E> c;

        public f(NavigableSet<E> navigableSet) {
            this.f6178a = (NavigableSet) dm4.o(navigableSet);
            this.b = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SortedSet<E> delegate() {
            return this.b;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.f6178a.ceiling(e);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return cv2.B(this.f6178a.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            f<E> fVar = this.c;
            if (fVar != null) {
                return fVar;
            }
            f<E> fVar2 = new f<>(this.f6178a.descendingSet());
            this.c = fVar2;
            fVar2.c = this;
            return fVar2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return this.f6178a.floor(e);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            return k0.l(this.f6178a.headSet(e, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return this.f6178a.higher(e);
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return this.f6178a.lower(e);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return k0.l(this.f6178a.subSet(e, z, e2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return k0.l(this.f6178a.tailSet(e, z));
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> Set<E> b(Set<E> set, em4<? super E> em4Var) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, em4Var);
        }
        if (!(set instanceof b)) {
            return new b((Set) dm4.o(set), (em4) dm4.o(em4Var));
        }
        b bVar = (b) set;
        return new b((Set) bVar.f6179a, fm4.c(bVar.b, em4Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, em4<? super E> em4Var) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) dm4.o(sortedSet), (em4) dm4.o(em4Var));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.f6179a, fm4.c(bVar.b, em4Var));
    }

    public static int d(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static <E> e<E> e(Set<E> set, Set<?> set2) {
        dm4.p(set, "set1");
        dm4.p(set2, "set2");
        return new a(set, set2);
    }

    public static <E> Set<E> f() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> HashSet<E> g() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> h(int i) {
        return new HashSet<>(u.d(i));
    }

    public static <E> Set<E> i() {
        return Collections.newSetFromMap(u.q());
    }

    public static boolean j(Set<?> set, Collection<?> collection) {
        dm4.o(collection);
        if (collection instanceof x) {
            collection = ((x) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? k(set, collection.iterator()) : cv2.u(set.iterator(), collection);
    }

    public static boolean k(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static <E> NavigableSet<E> l(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof f)) ? navigableSet : new f(navigableSet);
    }
}

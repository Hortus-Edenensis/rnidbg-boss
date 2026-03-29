package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.collect.x;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.m54;
import defpackage.sg0;
import defpackage.x06;
import j$.util.Objects;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class y {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: SearchBox */
    public class a<E> extends x06<x.a<E>, E> {
        public a(Iterator it) {
            super(it);
        }

        @Override // defpackage.x06
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(x.a<E> aVar) {
            return aVar.getElement();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b<E> implements x.a<E> {
        public boolean equals(Object obj) {
            if (!(obj instanceof x.a)) {
                return false;
            }
            x.a aVar = (x.a) obj;
            return getCount() == aVar.getCount() && m54.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.x.a
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c<E> extends k0.d<E> {
        public abstract x<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<E> extends k0.d<x.a<E>> {
        public abstract x<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof x.a)) {
                return false;
            }
            x.a aVar = (x.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof x.a) {
                x.a aVar = (x.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f6235a;
        public final int b;

        public e(E e, int i) {
            this.f6235a = e;
            this.b = i;
            sg0.b(i, "count");
        }

        @Override // com.google.common.collect.x.a
        public final int getCount() {
            return this.b;
        }

        @Override // com.google.common.collect.x.a
        public final E getElement() {
            return this.f6235a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x<E> f6236a;
        public final Iterator<x.a<E>> b;
        public x.a<E> c;
        public int d;
        public int e;
        public boolean f;

        public f(x<E> xVar, Iterator<x.a<E>> it) {
            this.f6236a = xVar;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.d == 0) {
                x.a<E> next = this.b.next();
                this.c = next;
                int count = next.getCount();
                this.d = count;
                this.e = count;
            }
            this.d--;
            this.f = true;
            x.a<E> aVar = this.c;
            Objects.requireNonNull(aVar);
            return aVar.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            sg0.e(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                x<E> xVar = this.f6236a;
                x.a<E> aVar = this.c;
                Objects.requireNonNull(aVar);
                xVar.remove(aVar.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    public static <E> boolean a(x<E> xVar, com.google.common.collect.c<? extends E> cVar) {
        if (cVar.isEmpty()) {
            return false;
        }
        cVar.addTo(xVar);
        return true;
    }

    public static <E> boolean b(x<E> xVar, x<? extends E> xVar2) {
        if (xVar2 instanceof com.google.common.collect.c) {
            return a(xVar, (com.google.common.collect.c) xVar2);
        }
        if (xVar2.isEmpty()) {
            return false;
        }
        for (x.a<? extends E> aVar : xVar2.entrySet()) {
            xVar.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(x<E> xVar, Collection<? extends E> collection) {
        dm4.o(xVar);
        dm4.o(collection);
        if (collection instanceof x) {
            return b(xVar, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return cv2.a(xVar, collection.iterator());
    }

    public static <T> x<T> d(Iterable<T> iterable) {
        return (x) iterable;
    }

    public static <E> Iterator<E> e(Iterator<x.a<E>> it) {
        return new a(it);
    }

    public static boolean f(x<?> xVar, Object obj) {
        if (obj == xVar) {
            return true;
        }
        if (obj instanceof x) {
            x xVar2 = (x) obj;
            if (xVar.size() == xVar2.size() && xVar.entrySet().size() == xVar2.entrySet().size()) {
                for (x.a aVar : xVar2.entrySet()) {
                    if (xVar.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> x.a<E> g(E e2, int i) {
        return new e(e2, i);
    }

    public static int h(Iterable<?> iterable) {
        if (iterable instanceof x) {
            return ((x) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Iterator<E> i(x<E> xVar) {
        return new f(xVar, xVar.entrySet().iterator());
    }

    public static boolean j(x<?> xVar, Collection<?> collection) {
        if (collection instanceof x) {
            collection = ((x) collection).elementSet();
        }
        return xVar.elementSet().removeAll(collection);
    }

    public static boolean k(x<?> xVar, Collection<?> collection) {
        dm4.o(collection);
        if (collection instanceof x) {
            collection = ((x) collection).elementSet();
        }
        return xVar.elementSet().retainAll(collection);
    }

    public static <E> int l(x<E> xVar, E e2, int i) {
        sg0.b(i, "count");
        int iCount = xVar.count(e2);
        int i2 = i - iCount;
        if (i2 > 0) {
            xVar.add(e2, i2);
        } else if (i2 < 0) {
            xVar.remove(e2, -i2);
        }
        return iCount;
    }

    public static <E> boolean m(x<E> xVar, E e2, int i, int i2) {
        sg0.b(i, "oldCount");
        sg0.b(i2, "newCount");
        if (xVar.count(e2) != i) {
            return false;
        }
        xVar.setCount(e2, i2);
        return true;
    }
}

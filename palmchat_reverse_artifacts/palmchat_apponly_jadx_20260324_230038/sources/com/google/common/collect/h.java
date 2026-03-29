package com.google.common.collect;

import com.google.common.collect.p0;
import com.google.common.collect.x;
import defpackage.dm4;
import defpackage.q94;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class h<E> extends e<E> implements o0<E> {
    final Comparator<? super E> comparator;
    private transient o0<E> descendingMultiset;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o<E> {
        public a() {
        }

        @Override // defpackage.h12, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return h.this.descendingIterator();
        }

        @Override // com.google.common.collect.o
        public Iterator<x.a<E>> p() {
            return h.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.o
        public o0<E> s() {
            return h.this;
        }
    }

    public h() {
        this(q94.o());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public o0<E> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator<x.a<E>> descendingEntryIterator();

    Iterator<E> descendingIterator() {
        return y.i(descendingMultiset());
    }

    public o0<E> descendingMultiset() {
        o0<E> o0Var = this.descendingMultiset;
        if (o0Var != null) {
            return o0Var;
        }
        o0<E> o0VarCreateDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = o0VarCreateDescendingMultiset;
        return o0VarCreateDescendingMultiset;
    }

    public x.a<E> firstEntry() {
        Iterator<x.a<E>> itEntryIterator = entryIterator();
        if (itEntryIterator.hasNext()) {
            return itEntryIterator.next();
        }
        return null;
    }

    public x.a<E> lastEntry() {
        Iterator<x.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (itDescendingEntryIterator.hasNext()) {
            return itDescendingEntryIterator.next();
        }
        return null;
    }

    public x.a<E> pollFirstEntry() {
        Iterator<x.a<E>> itEntryIterator = entryIterator();
        if (!itEntryIterator.hasNext()) {
            return null;
        }
        x.a<E> next = itEntryIterator.next();
        x.a<E> aVarG = y.g(next.getElement(), next.getCount());
        itEntryIterator.remove();
        return aVarG;
    }

    public x.a<E> pollLastEntry() {
        Iterator<x.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (!itDescendingEntryIterator.hasNext()) {
            return null;
        }
        x.a<E> next = itDescendingEntryIterator.next();
        x.a<E> aVarG = y.g(next.getElement(), next.getCount());
        itDescendingEntryIterator.remove();
        return aVarG;
    }

    public o0<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        dm4.o(boundType);
        dm4.o(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    public h(Comparator<? super E> comparator) {
        this.comparator = (Comparator) dm4.o(comparator);
    }

    @Override // com.google.common.collect.e
    public NavigableSet<E> createElementSet() {
        return new p0.b(this);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}

package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class DescendableLinkedList<E> extends LinkedList<E> {

    /* JADX INFO: compiled from: SearchBox */
    public class b<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator<E> f19825a;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19825a.hasPrevious();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.f19825a.previous();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f19825a.remove();
        }

        public b(int i) {
            this.f19825a = DescendableLinkedList.this.listIterator(i);
        }
    }

    @Override // java.util.LinkedList, java.util.Deque
    public Iterator<E> descendingIterator() {
        return new b(size());
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void push(E e) {
        addFirst(e);
    }
}

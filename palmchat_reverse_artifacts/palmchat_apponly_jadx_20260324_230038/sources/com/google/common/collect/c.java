package com.google.common.collect;

import com.google.common.collect.x;
import defpackage.dm4;
import defpackage.ku2;
import defpackage.sg0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c<E> extends e<E> implements Serializable {
    private static final long serialVersionUID = 0;
    transient z<E> backingMap;
    transient long size;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends c<E>.AbstractC0374c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.c.AbstractC0374c
        public E b(int i) {
            return c.this.backingMap.i(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends c<E>.AbstractC0374c<x.a<E>> {
        public b() {
            super();
        }

        @Override // com.google.common.collect.c.AbstractC0374c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public x.a<E> b(int i) {
            return c.this.backingMap.g(i);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public abstract class AbstractC0374c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6155a;
        public int b = -1;
        public int c;

        public AbstractC0374c() {
            this.f6155a = c.this.backingMap.e();
            this.c = c.this.backingMap.d;
        }

        public final void a() {
            if (c.this.backingMap.d != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f6155a >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = b(this.f6155a);
            int i = this.f6155a;
            this.b = i;
            this.f6155a = c.this.backingMap.s(i);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            sg0.e(this.b != -1);
            c cVar = c.this;
            cVar.size -= (long) cVar.backingMap.x(this.b);
            this.f6155a = c.this.backingMap.t(this.f6155a, this.b);
            this.b = -1;
            this.c = c.this.backingMap.d;
        }
    }

    public c(int i) {
        this.backingMap = newBackingMap(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = i0.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        i0.g(this, objectInputStream, iH);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        i0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public final int add(E e, int i) {
        if (i == 0) {
            return count(e);
        }
        dm4.f(i > 0, "occurrences cannot be negative: %s", i);
        int iM = this.backingMap.m(e);
        if (iM == -1) {
            this.backingMap.u(e, i);
            this.size += (long) i;
            return 0;
        }
        int iK = this.backingMap.k(iM);
        long j = i;
        long j2 = ((long) iK) + j;
        dm4.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.B(iM, (int) j2);
        this.size += j;
        return iK;
    }

    public void addTo(x<? super E> xVar) {
        dm4.o(xVar);
        int iE = this.backingMap.e();
        while (iE >= 0) {
            xVar.add(this.backingMap.i(iE), this.backingMap.k(iE));
            iE = this.backingMap.s(iE);
        }
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.x
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.e
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.e
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.e
    public final Iterator<x.a<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return y.i(this);
    }

    public abstract z<E> newBackingMap(int i);

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public final int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        dm4.f(i > 0, "occurrences cannot be negative: %s", i);
        int iM = this.backingMap.m(obj);
        if (iM == -1) {
            return 0;
        }
        int iK = this.backingMap.k(iM);
        if (iK > i) {
            this.backingMap.B(iM, iK - i);
        } else {
            this.backingMap.x(iM);
            i = iK;
        }
        this.size -= (long) i;
        return iK;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public final int setCount(E e, int i) {
        sg0.b(i, "count");
        z<E> zVar = this.backingMap;
        int iV = i == 0 ? zVar.v(e) : zVar.u(e, i);
        this.size += (long) (i - iV);
        return iV;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public final int size() {
        return ku2.o(this.size);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public final boolean setCount(E e, int i, int i2) {
        sg0.b(i, "oldCount");
        sg0.b(i2, "newCount");
        int iM = this.backingMap.m(e);
        if (iM == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(e, i2);
                this.size += (long) i2;
            }
            return true;
        }
        if (this.backingMap.k(iM) != i) {
            return false;
        }
        if (i2 == 0) {
            this.backingMap.x(iM);
            this.size -= (long) i;
        } else {
            this.backingMap.B(iM, i2);
            this.size += (long) (i2 - i);
        }
        return true;
    }
}

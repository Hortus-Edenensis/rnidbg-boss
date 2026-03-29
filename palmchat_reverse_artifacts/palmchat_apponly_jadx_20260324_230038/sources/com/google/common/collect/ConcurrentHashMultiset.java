package com.google.common.collect;

import com.google.common.collect.i0;
import com.google.common.collect.x;
import defpackage.bv2;
import defpackage.cv2;
import defpackage.d43;
import defpackage.dm4;
import defpackage.k1;
import defpackage.ku2;
import defpackage.l12;
import defpackage.ot2;
import defpackage.r12;
import defpackage.sg0;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.e<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends k1<x.a<E>> {
        public final Iterator<Map.Entry<E, AtomicInteger>> c;

        public b() {
            this.c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        @Override // defpackage.k1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public x.a<E> a() {
            while (this.c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.c.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return y.g(next.getKey(), i);
                }
            }
            return b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends l12<x.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x.a<E> f6061a;
        public final /* synthetic */ Iterator b;
        public final /* synthetic */ ConcurrentHashMultiset c;

        public c(ConcurrentHashMultiset concurrentHashMultiset, Iterator it) {
            this.b = it;
            this.c = concurrentHashMultiset;
        }

        @Override // defpackage.p12
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Iterator<x.a<E>> delegate() {
            return this.b;
        }

        @Override // defpackage.l12, java.util.Iterator
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public x.a<E> next() {
            x.a<E> aVar = (x.a) super.next();
            this.f6061a = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            dm4.u(this.f6061a != null, "no calls to next() since the last call to remove()");
            this.c.setCount(this.f6061a.getElement(), 0);
            this.f6061a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends com.google.common.collect.e<E>.b {
        public d() {
            super();
        }

        @Override // com.google.common.collect.e.b, com.google.common.collect.y.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        public final List<x.a<E>> f() {
            ArrayList arrayListM = d43.m(size());
            cv2.a(arrayListM, iterator());
            return arrayListM;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return f().toArray();
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f().toArray(tArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i0.b<? super ConcurrentHashMultiset<?>> f6062a = i0.a(ConcurrentHashMultiset.class, "countMap");
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        dm4.j(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        e.f6062a.b(this, (ConcurrentMap) object);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList arrayListM = d43.m(size());
        for (x.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                arrayListM.add(element);
            }
        }
        return arrayListM;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int add(E e2, int i) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i2;
        AtomicInteger atomicInteger;
        dm4.o(e2);
        if (i == 0) {
            return count(e2);
        }
        sg0.d(i, "occurrences");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) u.w(this.countMap, e2);
            if (atomicIntegerPutIfAbsent == null && (atomicIntegerPutIfAbsent = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = atomicIntegerPutIfAbsent.get();
                if (i2 == 0) {
                    atomicInteger = new AtomicInteger(i);
                    if (this.countMap.putIfAbsent(e2, atomicInteger) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i2, ot2.a(i2, i)));
            return i2;
        } while (!this.countMap.replace(e2, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.x
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) u.w(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.e
    public Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // com.google.common.collect.e
    @Deprecated
    public Set<x.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.e
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.e
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.e
    public Iterator<x.a<E>> entryIterator() {
        return new c(this, new b());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return y.i(this);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int remove(Object obj, int i) {
        int i2;
        int iMax;
        if (i == 0) {
            return count(obj);
        }
        sg0.d(i, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) u.w(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            iMax = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, iMax));
        if (iMax == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    public boolean removeExactly(Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        sg0.d(i, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) u.w(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public int setCount(E e2, int i) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i2;
        AtomicInteger atomicInteger;
        dm4.o(e2);
        sg0.b(i, "count");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) u.w(this.countMap, e2);
            if (atomicIntegerPutIfAbsent == null && (i == 0 || (atomicIntegerPutIfAbsent = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) == null)) {
                return 0;
            }
            do {
                i2 = atomicIntegerPutIfAbsent.get();
                if (i2 == 0) {
                    if (i != 0) {
                        atomicInteger = new AtomicInteger(i);
                        if (this.countMap.putIfAbsent(e2, atomicInteger) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i2, i));
            if (i == 0) {
                this.countMap.remove(e2, atomicIntegerPutIfAbsent);
            }
            return i2;
        } while (!this.countMap.replace(e2, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
    public int size() {
        Iterator<AtomicInteger> it = this.countMap.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += (long) it.next().get();
        }
        return ku2.o(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends r12<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f6060a;
        public final /* synthetic */ ConcurrentHashMultiset b;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f6060a = set;
            this.b = concurrentHashMultiset;
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && l.c(this.f6060a, obj);
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && l.d(this.f6060a, obj);
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        public Set<E> delegate() {
            return this.f6060a;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> concurrentHashMultisetCreate = create();
        bv2.a(concurrentHashMultisetCreate, iterable);
        return concurrentHashMultisetCreate;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.x
    public boolean setCount(E e2, int i, int i2) {
        dm4.o(e2);
        sg0.b(i, "oldCount");
        sg0.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) u.w(this.countMap, e2);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}

package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class k<K, V> {
    k<K, V>.nr nr;

    /* JADX INFO: compiled from: SearchBox */
    public final class nr implements Set<K> {
        public nr() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            k.this.fx();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return k.this.u(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return k.u(k.this.nr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return k.u(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iU = k.this.u() - 1; iU >= 0; iU--) {
                Object objU = k.this.u(iU, 0);
                iHashCode += objU == null ? 0 : objU.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return k.this.u() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new u(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iU = k.this.u(obj);
            if (iU < 0) {
                return false;
            }
            k.this.u(iU);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return k.nr(k.this.nr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return k.fx(k.this.nr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return k.this.u();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return k.this.nr(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) k.this.u(tArr, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class u<T> implements Iterator<T> {
        boolean b = false;
        int fx;
        int nr;
        final int u;

        public u(int i) {
            this.u = i;
            this.nr = k.this.u();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.fx < this.nr;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) k.this.u(this.fx, this.u);
            this.fx++;
            this.b = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.b) {
                throw new IllegalStateException();
            }
            int i = this.fx - 1;
            this.fx = i;
            this.nr--;
            this.b = false;
            k.this.u(i);
        }
    }

    public static <K, V> boolean fx(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean nr(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean u(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Set<K> b() {
        if (this.nr == null) {
            this.nr = new nr();
        }
        return this.nr;
    }

    public abstract void fx();

    public abstract Map<K, V> nr();

    public abstract int u();

    public abstract int u(Object obj);

    public abstract Object u(int i, int i2);

    public abstract void u(int i);

    public <T> T[] u(T[] tArr, int i) {
        int iU = u();
        if (tArr.length < iU) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iU));
        }
        for (int i2 = 0; i2 < iU; i2++) {
            tArr[i2] = u(i2, i);
        }
        if (tArr.length > iU) {
            tArr[iU] = null;
        }
        return tArr;
    }

    public Object[] nr(int i) {
        int iU = u();
        Object[] objArr = new Object[iU];
        for (int i2 = 0; i2 < iU; i2++) {
            objArr[i2] = u(i2, i);
        }
        return objArr;
    }

    public static <T> boolean u(Set<T> set, Object obj) {
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
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}

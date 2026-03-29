package com.google.common.collect;

import com.google.common.collect.b;
import com.google.common.collect.u;
import com.google.common.collect.x;
import com.google.common.collect.y;
import defpackage.dm4;
import defpackage.m33;
import defpackage.m65;
import defpackage.ps3;
import defpackage.qo5;
import defpackage.sg0;
import defpackage.u42;
import defpackage.x06;
import j$.util.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class w {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<K, V> extends u.r<K, Collection<V>> {
        public final ps3<K, V> d;

        /* JADX INFO: renamed from: com.google.common.collect.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0382a extends u.j<K, Collection<V>> {
            public C0382a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Collection f(Object obj) {
                return a.this.d.get(obj);
            }

            @Override // com.google.common.collect.u.j
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return u.c(a.this.d.keySet(), new u42() { // from class: qs3
                    @Override // defpackage.u42
                    public final Object apply(Object obj) {
                        return this.f20312a.f(obj);
                    }
                });
            }

            @Override // com.google.common.collect.u.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.g(entry.getKey());
                return true;
            }
        }

        public a(ps3<K, V> ps3Var) {
            this.d = (ps3) dm4.o(ps3Var);
        }

        @Override // com.google.common.collect.u.r
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0382a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.d.removeAll(obj);
            }
            return null;
        }

        public void g(Object obj) {
            this.d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // com.google.common.collect.u.r, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.keySet().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<K, V> extends com.google.common.collect.a<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient qo5<? extends List<V>> f6228a;

        public b(Map<K, Collection<V>> map, qo5<? extends List<V>> qo5Var) {
            super(map);
            this.f6228a = (qo5) dm4.o(qo5Var);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.f6228a = (qo5) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f6228a);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.b, com.google.common.collect.d
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.b, com.google.common.collect.d
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.a, com.google.common.collect.b
        public List<V> createCollection() {
            return this.f6228a.get();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<K, V> extends g<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient qo5<? extends Set<V>> f6229a;

        public c(Map<K, Collection<V>> map, qo5<? extends Set<V>> qo5Var) {
            super(map);
            this.f6229a = (qo5) dm4.o(qo5Var);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.f6229a = (qo5) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f6229a);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.b, com.google.common.collect.d
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.b, com.google.common.collect.d
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.g, com.google.common.collect.b
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            return collection instanceof NavigableSet ? k0.l((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.g, com.google.common.collect.b
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            return collection instanceof NavigableSet ? new b.m(k, (NavigableSet) collection, null) : collection instanceof SortedSet ? new b.o(k, (SortedSet) collection, null) : new b.n(k, (Set) collection);
        }

        @Override // com.google.common.collect.g, com.google.common.collect.b
        public Set<V> createCollection() {
            return this.f6229a.get();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract ps3<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e<K, V> extends com.google.common.collect.e<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ps3<K, V> f6230a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends x06<Map.Entry<K, Collection<V>>, x.a<K>> {

            /* JADX INFO: renamed from: com.google.common.collect.w$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0383a extends y.b<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f6231a;
                public final /* synthetic */ a b;

                public C0383a(a aVar, Map.Entry entry) {
                    this.f6231a = entry;
                    this.b = aVar;
                }

                @Override // com.google.common.collect.x.a
                public int getCount() {
                    return ((Collection) this.f6231a.getValue()).size();
                }

                @Override // com.google.common.collect.x.a
                public K getElement() {
                    return (K) this.f6231a.getKey();
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // defpackage.x06
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public x.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0383a(this, entry);
            }
        }

        public e(ps3<K, V> ps3Var) {
            this.f6230a = ps3Var;
        }

        @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f6230a.clear();
        }

        @Override // com.google.common.collect.e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
        public boolean contains(Object obj) {
            return this.f6230a.containsKey(obj);
        }

        @Override // com.google.common.collect.x
        public int count(Object obj) {
            Collection collection = (Collection) u.w(this.f6230a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.e
        public int distinctElements() {
            return this.f6230a.asMap().size();
        }

        @Override // com.google.common.collect.e
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.e, com.google.common.collect.x
        public Set<K> elementSet() {
            return this.f6230a.keySet();
        }

        @Override // com.google.common.collect.e
        public Iterator<x.a<K>> entryIterator() {
            return new a(this.f6230a.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return u.l(this.f6230a.entries().iterator());
        }

        @Override // com.google.common.collect.e, com.google.common.collect.x
        public int remove(Object obj, int i) {
            sg0.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) u.w(this.f6230a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
        public int size() {
            return this.f6230a.size();
        }
    }

    public static boolean a(ps3<?, ?> ps3Var, Object obj) {
        if (obj == ps3Var) {
            return true;
        }
        if (obj instanceof ps3) {
            return ps3Var.asMap().equals(((ps3) obj).asMap());
        }
        return false;
    }

    public static <K, V> m33<K, V> b(Map<K, Collection<V>> map, qo5<? extends List<V>> qo5Var) {
        return new b(map, qo5Var);
    }

    public static <K, V> m65<K, V> c(Map<K, Collection<V>> map, qo5<? extends Set<V>> qo5Var) {
        return new c(map, qo5Var);
    }
}

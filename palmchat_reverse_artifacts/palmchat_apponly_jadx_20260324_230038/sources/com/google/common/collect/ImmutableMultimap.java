package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.i0;
import com.google.common.collect.x;
import defpackage.bv2;
import defpackage.cj4;
import defpackage.cv2;
import defpackage.o46;
import defpackage.ps3;
import defpackage.q94;
import defpackage.qq;
import defpackage.sg0;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ImmutableMultimap<K, V> extends qq<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o46<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f6084a;
        public K b = null;
        public Iterator<V> c = cv2.h();

        public a() {
            this.f6084a = ImmutableMultimap.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.c.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f6084a.next();
                this.b = next.getKey();
                this.c = next.getValue().iterator();
            }
            K k = this.b;
            Objects.requireNonNull(k);
            return u.i(k, this.c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c.hasNext() || this.f6084a.hasNext();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends o46<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends ImmutableCollection<V>> f6085a;
        public Iterator<V> b = cv2.h();

        public b() {
            this.f6085a = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext() || this.f6085a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.b.hasNext()) {
                this.b = this.f6085a.next().iterator();
            }
            return this.b.next();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMultimap<K, V> f6087a;

        public d(ImmutableMultimap<K, V> immutableMultimap) {
            this.f6087a = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f6087a.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f6087a.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f6087a.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public o46<Map.Entry<K, V>> iterator() {
            return this.f6087a.entryIterator();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i0.b<? super ImmutableMultimap<?, ?>> f6088a = i0.a(ImmutableMultimap.class, "map");
        public static final i0.b<? super ImmutableMultimap<?, ?>> b = i0.a(ImmutableMultimap.class, "size");
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends ImmutableMultiset<K> {
        public f() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public x.a<K> getEntry(int i) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i);
            return y.g(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.x
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new g(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.x
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMultimap<?, ?> f6090a;

        public g(ImmutableMultimap<?, ?> immutableMultimap) {
            this.f6090a = immutableMultimap;
        }

        public Object readResolve() {
            return this.f6090a.keys();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableMultimap<K, V> f6091a;

        public h(ImmutableMultimap<K, V> immutableMultimap) {
            this.f6091a = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f6091a.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            o46<? extends ImmutableCollection<V>> it = this.f6091a.map.values().iterator();
            while (it.hasNext()) {
                i = it.next().copyIntoArray(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f6091a.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public o46<V> iterator() {
            return this.f6091a.valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> c<K, V> builderWithExpectedKeys(int i) {
        sg0.b(i, "expectedKeys");
        return new c<>(i);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(ps3<? extends K, ? extends V> ps3Var) {
        if (ps3Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) ps3Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((ps3) ps3Var);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // defpackage.ps3
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // defpackage.ps3
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.d
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.d
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.d
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.ps3, defpackage.m33
    public abstract ImmutableCollection<V> get(K k);

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    @Deprecated
    public final boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public final boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.ps3
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<K, ImmutableCollection.b<V>> f6086a;
        public Comparator<? super K> b;
        public Comparator<? super V> c;
        public int d = 4;

        public c() {
        }

        public ImmutableMultimap<K, V> a() {
            Map<K, ImmutableCollection.b<V>> map = this.f6086a;
            if (map == null) {
                return ImmutableListMultimap.of();
            }
            Collection collectionEntrySet = map.entrySet();
            Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                collectionEntrySet = q94.b(comparator).p().c(collectionEntrySet);
            }
            return ImmutableListMultimap.fromMapBuilderEntries(collectionEntrySet, this.c);
        }

        public c<K, V> b(c<K, V> cVar) {
            Map<K, ImmutableCollection.b<V>> map = cVar.f6086a;
            if (map != null) {
                for (Map.Entry<K, ImmutableCollection.b<V>> entry : map.entrySet()) {
                    i(entry.getKey(), entry.getValue().e());
                }
            }
            return this;
        }

        public Map<K, ImmutableCollection.b<V>> c() {
            Map<K, ImmutableCollection.b<V>> map = this.f6086a;
            if (map != null) {
                return map;
            }
            Map<K, ImmutableCollection.b<V>> mapH = cj4.h();
            this.f6086a = mapH;
            return mapH;
        }

        public int d(int i, Iterable<?> iterable) {
            return iterable instanceof Collection ? Math.max(i, ((Collection) iterable).size()) : i;
        }

        public ImmutableCollection.b<V> e(int i) {
            return ImmutableList.builderWithExpectedSize(i);
        }

        public c<K, V> f(K k, V v) {
            sg0.a(k, v);
            ImmutableCollection.b<V> bVarE = c().get(k);
            if (bVarE == null) {
                bVarE = e(this.d);
                c().put(k, bVarE);
            }
            bVarE.a(v);
            return this;
        }

        public c<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public c<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public c<K, V> i(K k, Iterable<? extends V> iterable) {
            if (k == null) {
                throw new NullPointerException("null key in entry: null=" + bv2.s(iterable));
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            ImmutableCollection.b<V> bVarE = c().get(k);
            if (bVarE == null) {
                bVarE = e(d(this.d, iterable));
                c().put(k, bVarE);
            }
            while (it.hasNext()) {
                V next = it.next();
                sg0.a(k, next);
                bVarE.a(next);
            }
            return this;
        }

        public c<K, V> j(K k, V... vArr) {
            return i(k, Arrays.asList(vArr));
        }

        public c(int i) {
            if (i > 0) {
                this.f6086a = cj4.i(i);
            }
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.d
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new d(this);
    }

    @Override // com.google.common.collect.d
    public ImmutableMultiset<K> createKeys() {
        return new f();
    }

    @Override // com.google.common.collect.d
    public ImmutableCollection<V> createValues() {
        return new h(this);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.d
    public o46<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.d
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    @Deprecated
    public final boolean putAll(ps3<? extends K, ? extends V> ps3Var) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.ps3
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d
    public o46<V> valueIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }
}

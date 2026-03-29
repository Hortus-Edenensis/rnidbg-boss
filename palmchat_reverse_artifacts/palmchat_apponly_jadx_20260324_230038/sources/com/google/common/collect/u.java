package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.k0;
import defpackage.a44;
import defpackage.cv2;
import defpackage.dm4;
import defpackage.em4;
import defpackage.fm4;
import defpackage.m1;
import defpackage.m54;
import defpackage.n12;
import defpackage.q94;
import defpackage.sg0;
import defpackage.tr2;
import defpackage.u42;
import defpackage.x06;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class u {

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    /* JADX INFO: compiled from: SearchBox */
    public class a<K, V2> extends m1<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f6205a;
        public final /* synthetic */ k b;

        public a(Map.Entry entry, k kVar) {
            this.f6205a = entry;
            this.b = kVar;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public K getKey() {
            return (K) this.f6205a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.m1, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.b.a(this.f6205a.getKey(), this.f6205a.getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* JADX INFO: compiled from: SearchBox */
    public class b<K, V1, V2> implements u42<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f6206a;

        public b(k kVar) {
            this.f6206a = kVar;
        }

        @Override // defpackage.u42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return u.A(this.f6206a, entry);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: SearchBox */
    public class c<K, V> extends x06<Map.Entry<K, V>, K> {
        public c(Iterator it) {
            super(it);
        }

        @Override // defpackage.x06
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: SearchBox */
    public class d<K, V> extends x06<Map.Entry<K, V>, V> {
        public d(Iterator it) {
            super(it);
        }

        @Override // defpackage.x06
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: SearchBox */
    public class e<K, V> extends x06<K, Map.Entry<K, V>> {
        public final /* synthetic */ u42 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Iterator it, u42 u42Var) {
            super(it);
            this.b = u42Var;
        }

        @Override // defpackage.x06
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k) {
            return u.i(k, this.b.apply(k));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: compiled from: SearchBox */
    public class f<K, V> extends m1<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f6207a;

        public f(Map.Entry entry) {
            this.f6207a = entry;
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public K getKey() {
            return (K) this.f6207a.getKey();
        }

        @Override // defpackage.m1, java.util.Map.Entry
        public V getValue() {
            return (V) this.f6207a.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* JADX INFO: compiled from: SearchBox */
    public class g<K, V1, V2> implements k<K, V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u42 f6208a;

        public g(u42 u42Var) {
            this.f6208a = u42Var;
        }

        @Override // com.google.common.collect.u.k
        public V2 a(K k, V1 v1) {
            return (V2) this.f6208a.apply(v1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class h<K, V> extends n12<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Comparator<? super K> f6209a;
        public transient Set<Map.Entry<K, V>> b;
        public transient NavigableSet<K> c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.u.j
            public Map<K, V> a() {
                return h.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return h.this.o();
            }
        }

        public static <T> q94<T> q(Comparator<T> comparator) {
            return q94.b(comparator).s();
        }

        public Set<Map.Entry<K, V>> b() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return p().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return p().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f6209a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = p().comparator();
            if (comparator2 == null) {
                comparator2 = q94.o();
            }
            q94 q94VarQ = q(comparator2);
            this.f6209a = q94VarQ;
            return q94VarQ;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return p().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return p();
        }

        @Override // defpackage.n12, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setB = b();
            this.b = setB;
            return setB;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return p().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return p().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return p().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return p().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return p().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return p().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return p().lowerKey(k);
        }

        @Override // defpackage.n12, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return p().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return p().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return p().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return p().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.c;
            if (navigableSet != null) {
                return navigableSet;
            }
            n nVar = new n(this);
            this.c = nVar;
            return nVar;
        }

        public abstract Iterator<Map.Entry<K, V>> o();

        public abstract NavigableMap<K, V> p();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return p().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return p().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return p().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return p().headMap(k, z).descendingMap();
        }

        @Override // defpackage.p12
        public String toString() {
            return standardToString();
        }

        @Override // defpackage.n12, java.util.Map
        public Collection<V> values() {
            return new q(this);
        }

        @Override // defpackage.n12, defpackage.p12
        public final Map<K, V> delegate() {
            return p();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class i implements u42<Map.Entry<?, ?>, Object> {
        public static final i KEY = new a("KEY", 0);
        public static final i VALUE = new b("VALUE", 1);
        private static final /* synthetic */ i[] $VALUES = $values();

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends i {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.u.i, defpackage.u42
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b extends i {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.u.i, defpackage.u42
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        private static /* synthetic */ i[] $values() {
            return new i[]{KEY, VALUE};
        }

        private i(String str, int i) {
        }

        public static i valueOf(String str) {
            return (i) Enum.valueOf(i.class, str);
        }

        public static i[] values() {
            return (i[]) $VALUES.clone();
        }

        @Override // defpackage.u42
        public abstract /* synthetic */ Object apply(Map.Entry<?, ?> entry);

        public /* synthetic */ i(String str, int i, c cVar) {
            this(str, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class j<K, V> extends k0.d<Map.Entry<K, V>> {
        public abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objW = u.w(a(), key);
            if (m54.a(objW, entry.getValue())) {
                return objW != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.k0.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) dm4.o(collection));
            } catch (UnsupportedOperationException unused) {
                return k0.k(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) dm4.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetH = k0.h(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetH.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetH);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface k<K, V1, V2> {
        V2 a(K k, V1 v1);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class l<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.u.j
            public Map<K, V> a() {
                return l.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return l.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            cv2.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m<K, V> extends k0.d<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f6212a;

        public m(Map<K, V> map) {
            this.f6212a = (Map) dm4.o(map);
        }

        /* JADX INFO: renamed from: a */
        public Map<K, V> e() {
            return this.f6212a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return e().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return e().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return u.l(e().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            e().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n<K, V> extends o<K, V> implements NavigableSet<K> {
        public n(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return a().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // com.google.common.collect.u.o
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> e() {
            return (NavigableMap) this.f6212a;
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return a().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return a().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return a().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return a().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) u.m(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) u.m(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return a().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return a().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.u.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.u.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.u.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o<K, V> extends m<K, V> implements SortedSet<K> {
        public o(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return e().comparator();
        }

        @Override // com.google.common.collect.u.m
        public SortedMap<K, V> e() {
            return (SortedMap) super.e();
        }

        @Override // java.util.SortedSet
        public K first() {
            return e().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new o(e().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return e().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new o(e().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new o(e().tailMap(k));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p<K, V1, V2> extends l<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V1> f6213a;
        public final k<? super K, ? super V1, V2> b;

        public p(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
            this.f6213a = (Map) dm4.o(map);
            this.b = (k) dm4.o(kVar);
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<K, V2>> a() {
            return cv2.A(this.f6213a.entrySet().iterator(), u.a(this.b));
        }

        @Override // com.google.common.collect.u.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f6213a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f6213a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.f6213a.get(obj);
            if (v1 != null || this.f6213a.containsKey(obj)) {
                return this.b.a(obj, (Object) a44.a(v1));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f6213a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f6213a.containsKey(obj)) {
                return this.b.a(obj, (Object) a44.a(this.f6213a.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f6213a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new q(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class q<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f6214a;

        public q(Map<K, V> map) {
            this.f6214a = (Map) dm4.o(map);
        }

        public final Map<K, V> a() {
            return this.f6214a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return u.E(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (m54.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) dm4.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = k0.g();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetG.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) dm4.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = k0.g();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetG.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class r<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f6215a;
        public transient Set<K> b;
        public transient Collection<V> c;

        public abstract Set<Map.Entry<K, V>> a();

        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return new m(this);
        }

        public Collection<V> c() {
            return new q(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f6215a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f6215a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set != null) {
                return set;
            }
            Set<K> setG = g();
            this.b = setG;
            return setG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionC = c();
            this.c = collectionC;
            return collectionC;
        }
    }

    public static <V2, K, V1> Map.Entry<K, V2> A(k<? super K, ? super V1, V2> kVar, Map.Entry<K, V1> entry) {
        dm4.o(kVar);
        dm4.o(entry);
        return new a(entry, kVar);
    }

    public static <K, V1, V2> Map<K, V2> B(Map<K, V1> map, u42<? super V1, V2> u42Var) {
        return z(map, b(u42Var));
    }

    public static <K, V> Map.Entry<K, V> C(Map.Entry<? extends K, ? extends V> entry) {
        dm4.o(entry);
        return new f(entry);
    }

    public static <V> u42<Map.Entry<?, V>, V> D() {
        return i.VALUE;
    }

    public static <K, V> Iterator<V> E(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    public static <V> V F(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> em4<Map.Entry<?, V>> G(em4<? super V> em4Var) {
        return fm4.e(em4Var, D());
    }

    public static <K, V1, V2> u42<Map.Entry<K, V1>, Map.Entry<K, V2>> a(k<? super K, ? super V1, V2> kVar) {
        dm4.o(kVar);
        return new b(kVar);
    }

    public static <K, V1, V2> k<K, V1, V2> b(u42<? super V1, V2> u42Var) {
        dm4.o(u42Var);
        return new g(u42Var);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> c(Set<K> set, u42<? super K, V> u42Var) {
        return new e(set.iterator(), u42Var);
    }

    public static int d(int i2) {
        if (i2 < 3) {
            sg0.b(i2, "expectedSize");
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) Math.ceil(((double) i2) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> boolean e(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(C((Map.Entry) obj));
        }
        return false;
    }

    public static boolean f(Map<?, ?> map, Object obj) {
        return cv2.f(l(map.entrySet().iterator()), obj);
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        return cv2.f(E(map.entrySet().iterator()), obj);
    }

    public static boolean h(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> i(K k2, V v) {
        return new tr2(k2, v);
    }

    public static <E> ImmutableMap<E, Integer> j(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            bVar.h(it.next(), Integer.valueOf(i2));
            i2++;
        }
        return bVar.d();
    }

    public static <K> u42<Map.Entry<K, ?>, K> k() {
        return i.KEY;
    }

    public static <K, V> Iterator<K> l(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    public static <K> K m(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> em4<Map.Entry<K, ?>> n(em4<? super K> em4Var) {
        return fm4.e(em4Var, k());
    }

    public static <K, V> HashMap<K, V> o() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> p(int i2) {
        return new HashMap<>(d(i2));
    }

    public static <K, V> IdentityHashMap<K, V> q() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> r() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s(int i2) {
        return new LinkedHashMap<>(d(i2));
    }

    public static <K extends Comparable, V> TreeMap<K, V> t() {
        return new TreeMap<>();
    }

    public static <K, V> void u(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean v(Map<?, ?> map, Object obj) {
        dm4.o(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V w(Map<?, V> map, Object obj) {
        dm4.o(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V x(Map<?, V> map, Object obj) {
        dm4.o(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String y(Map<?, ?> map) {
        StringBuilder sbB = com.google.common.collect.l.b(map.size());
        sbB.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append('=');
            sbB.append(entry.getValue());
            z = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    public static <K, V1, V2> Map<K, V2> z(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
        return new p(map, kVar);
    }
}

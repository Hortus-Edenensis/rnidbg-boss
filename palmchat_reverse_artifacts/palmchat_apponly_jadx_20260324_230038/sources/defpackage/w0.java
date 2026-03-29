package defpackage;

import com.google.common.collect.u;
import j$.util.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class w0<K, V> extends n12<K, V> implements ts<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient w0<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, V> f21567a;
        public final /* synthetic */ Iterator b;
        public final /* synthetic */ w0 c;

        public a(w0 w0Var, Iterator it) {
            this.b = it;
            this.c = w0Var;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.b.next();
            this.f21567a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<K, V> entry = this.f21567a;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            V value = entry.getValue();
            this.b.remove();
            this.c.removeFromInverseMap(value);
            this.f21567a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends o12<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f21568a;

        public b(Map.Entry<K, V> entry) {
            this.f21568a = entry;
        }

        @Override // defpackage.p12
        /* JADX INFO: renamed from: b */
        public Map.Entry<K, V> delegate() {
            return this.f21568a;
        }

        @Override // defpackage.o12, java.util.Map.Entry
        public V setValue(V v) {
            w0.this.checkValue(v);
            dm4.u(w0.this.entrySet().contains(this), "entry no longer in map");
            if (m54.a(v, getValue())) {
                return v;
            }
            dm4.j(!w0.this.containsValue(v), "value already present: %s", v);
            V value = this.f21568a.setValue(v);
            dm4.u(m54.a(v, w0.this.get(getKey())), "entry no longer in map");
            w0.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends r12<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f21569a;

        public c() {
            this.f21569a = w0.this.delegate.entrySet();
        }

        @Override // defpackage.h12, java.util.Collection
        public void clear() {
            w0.this.clear();
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return u.e(delegate(), obj);
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // defpackage.h12, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return w0.this.entrySetIterator();
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f21569a.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((w0) w0.this.inverse).delegate.remove(entry.getValue());
            this.f21569a.remove(entry);
            return true;
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // defpackage.h12, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // defpackage.h12, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ c(w0 w0Var, a aVar) {
            this();
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        public Set<Map.Entry<K, V>> delegate() {
            return this.f21569a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<K, V> extends w0<K, V> {
        private static final long serialVersionUID = 0;

        public d(Map<K, V> map, w0<V, K> w0Var) {
            super(map, w0Var, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            setInverse((w0) object);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // defpackage.w0
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // defpackage.w0
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // defpackage.w0, defpackage.n12, defpackage.p12
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // defpackage.w0, defpackage.n12, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends r12<K> {
        public e() {
        }

        @Override // defpackage.h12, java.util.Collection
        public void clear() {
            w0.this.clear();
        }

        @Override // defpackage.h12, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return u.l(w0.this.entrySet().iterator());
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            w0.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // defpackage.h12, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public /* synthetic */ e(w0 w0Var, a aVar) {
            this();
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        public Set<K> delegate() {
            return w0.this.delegate.keySet();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends r12<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<V> f21571a;

        public f() {
            this.f21571a = w0.this.inverse.keySet();
        }

        @Override // defpackage.h12, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return u.E(w0.this.entrySet().iterator());
        }

        @Override // defpackage.h12, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // defpackage.p12
        public String toString() {
            return standardToString();
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ f(w0 w0Var, a aVar) {
            this();
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        public Set<V> delegate() {
            return this.f21571a;
        }
    }

    public /* synthetic */ w0(Map map, w0 w0Var, a aVar) {
        this(map, w0Var);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean zContainsKey = containsKey(k);
        if (zContainsKey && m54.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            dm4.j(!containsValue(v), "value already present: %s", v);
        }
        V vPut = this.delegate.put(k, v);
        updateInverseMap(k, zContainsKey, vPut, v);
        return vPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V v = (V) a44.a(this.delegate.remove(obj));
        removeFromInverseMap(v);
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(a44.a(v));
        }
        this.inverse.delegate.put(v2, k);
    }

    @Override // defpackage.n12, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // defpackage.n12, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // defpackage.n12, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this, this.delegate.entrySet().iterator());
    }

    public V forcePut(K k, V v) {
        return putInBothMaps(k, v, true);
    }

    public ts<V, K> inverse() {
        return this.inverse;
    }

    @Override // defpackage.n12, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.keySet = eVar;
        return eVar;
    }

    public w0<V, K> makeInverse(Map<V, K> map) {
        return new d(map, this);
    }

    @Override // defpackage.n12, java.util.Map
    public V put(K k, V v) {
        return putInBothMaps(k, v, false);
    }

    @Override // defpackage.n12, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // defpackage.n12, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        dm4.t(this.delegate == null);
        dm4.t(this.inverse == null);
        dm4.d(map.isEmpty());
        dm4.d(map2.isEmpty());
        dm4.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(w0<V, K> w0Var) {
        this.inverse = w0Var;
    }

    public w0(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    @Override // defpackage.n12, defpackage.p12
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // defpackage.n12, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f(this, null);
        this.valueSet = fVar;
        return fVar;
    }

    private w0(Map<K, V> map, w0<V, K> w0Var) {
        this.delegate = map;
        this.inverse = w0Var;
    }

    public K checkKey(K k) {
        return k;
    }

    public V checkValue(V v) {
        return v;
    }
}

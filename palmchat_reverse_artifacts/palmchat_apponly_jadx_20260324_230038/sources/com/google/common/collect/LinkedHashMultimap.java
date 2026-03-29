package com.google.common.collect;

import com.google.common.collect.k0;
import defpackage.cj4;
import defpackage.dm4;
import defpackage.j33;
import defpackage.m54;
import defpackage.ps3;
import defpackage.sg0;
import defpackage.tr2;
import defpackage.vg2;
import j$.util.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class LinkedHashMultimap<K, V> extends j33<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient b<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b<K, V> f6115a;
        public b<K, V> b;

        public a() {
            this.f6115a = LinkedHashMultimap.this.multimapHeaderEntry.s();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar = this.f6115a;
            this.b = bVar;
            this.f6115a = bVar.s();
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6115a != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            dm4.u(this.b != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.b.getKey(), this.b.getValue());
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<K, V> extends tr2<K, V> implements d<K, V> {
        public final int c;
        public b<K, V> d;
        public d<K, V> e;
        public d<K, V> f;
        public b<K, V> g;
        public b<K, V> h;

        public b(K k, V v, int i, b<K, V> bVar) {
            super(k, v);
            this.c = i;
            this.d = bVar;
        }

        public static <K, V> b<K, V> u() {
            return new b<>(null, null, 0, null);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            d<K, V> dVar = this.e;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void c(d<K, V> dVar) {
            this.f = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.e = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> o() {
            d<K, V> dVar = this.f;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        public b<K, V> p() {
            b<K, V> bVar = this.g;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public b<K, V> s() {
            b<K, V> bVar = this.h;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public boolean t(Object obj, int i) {
            return this.c == i && m54.a(getValue(), obj);
        }

        public void v(b<K, V> bVar) {
            this.g = bVar;
        }

        public void w(b<K, V> bVar) {
            this.h = bVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends k0.d<V> implements d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f6116a;
        public b<K, V>[] b;
        public int c = 0;
        public int d = 0;
        public d<K, V> e = this;
        public d<K, V> f = this;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public d<K, V> f6117a;
            public b<K, V> b;
            public int c;

            public a() {
                this.f6117a = c.this.e;
                this.c = c.this.d;
            }

            public final void a() {
                if (c.this.d != this.c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f6117a != c.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                b<K, V> bVar = (b) this.f6117a;
                V value = bVar.getValue();
                this.b = bVar;
                this.f6117a = bVar.o();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                dm4.u(this.b != null, "no calls to next() since the last call to remove()");
                c.this.remove(this.b.getValue());
                this.c = c.this.d;
                this.b = null;
            }
        }

        public c(K k, int i) {
            this.f6116a = k;
            this.b = new b[vg2.a(i, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            int iD = vg2.d(v);
            int iF = f() & iD;
            b<K, V> bVar = this.b[iF];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.t(v, iD)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.f6116a, v, iD, bVar);
            LinkedHashMultimap.succeedsInValueSet(this.f, bVar3);
            LinkedHashMultimap.succeedsInValueSet(bVar3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.p(), bVar3);
            LinkedHashMultimap.succeedsInMultimap(bVar3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.b[iF] = bVar3;
            this.c++;
            this.d++;
            g();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            return this.f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void c(d<K, V> dVar) {
            this.e = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.b, (Object) null);
            this.c = 0;
            for (d<K, V> dVarO = this.e; dVarO != this; dVarO = dVarO.o()) {
                LinkedHashMultimap.deleteFromMultimap((b) dVarO);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = vg2.d(obj);
            for (b<K, V> bVar = this.b[f() & iD]; bVar != null; bVar = bVar.d) {
                if (bVar.t(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.f = dVar;
        }

        public final int f() {
            return this.b.length - 1;
        }

        public final void g() {
            if (vg2.b(this.c, this.b.length, 1.0d)) {
                int length = this.b.length * 2;
                b<K, V>[] bVarArr = new b[length];
                this.b = bVarArr;
                int i = length - 1;
                for (d<K, V> dVarO = this.e; dVarO != this; dVarO = dVarO.o()) {
                    b<K, V> bVar = (b) dVarO;
                    int i2 = bVar.c & i;
                    bVar.d = bVarArr[i2];
                    bVarArr[i2] = bVar;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> o() {
            return this.e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = vg2.d(obj);
            int iF = f() & iD;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.b[iF]; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.t(obj, iD)) {
                    if (bVar == null) {
                        this.b[iF] = bVar2.d;
                    } else {
                        bVar.d = bVar2.d;
                    }
                    LinkedHashMultimap.deleteFromValueSet(bVar2);
                    LinkedHashMultimap.deleteFromMultimap(bVar2);
                    this.c--;
                    this.d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d<K, V> {
        d<K, V> b();

        void c(d<K, V> dVar);

        void d(d<K, V> dVar);

        d<K, V> o();
    }

    private LinkedHashMultimap(int i, int i2) {
        super(cj4.f(i));
        this.valueSetCapacity = 2;
        sg0.b(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        b<K, V> bVarU = b.u();
        this.multimapHeaderEntry = bVarU;
        succeedsInMultimap(bVarU, bVarU);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(b<K, V> bVar) {
        succeedsInMultimap(bVar.p(), bVar.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(d<K, V> dVar) {
        succeedsInValueSet(dVar.b(), dVar.o());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b<K, V> bVarU = b.u();
        this.multimapHeaderEntry = bVarU;
        succeedsInMultimap(bVarU, bVarU);
        this.valueSetCapacity = 2;
        int i = objectInputStream.readInt();
        Map mapF = cj4.f(12);
        for (int i2 = 0; i2 < i; i2++) {
            Object object = objectInputStream.readObject();
            mapF.put(object, createCollection(object));
        }
        int i3 = objectInputStream.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            Object object2 = objectInputStream.readObject();
            Object object3 = objectInputStream.readObject();
            Collection collection = (Collection) mapF.get(object2);
            Objects.requireNonNull(collection);
            collection.add(object3);
        }
        setMap(mapF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(b<K, V> bVar, b<K, V> bVar2) {
        bVar.w(bVar2);
        bVar2.v(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(d<K, V> dVar, d<K, V> dVar2) {
        dVar.c(dVar2);
        dVar2.d(dVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.g, com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.b, defpackage.ps3
    public void clear() {
        super.clear();
        b<K, V> bVar = this.multimapHeaderEntry;
        succeedsInMultimap(bVar, bVar);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.b, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.g, com.google.common.collect.b, defpackage.ps3, defpackage.m33
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ x keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.g, com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean putAll(ps3 ps3Var) {
        return super.putAll(ps3Var);
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, defpackage.ps3
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.common.collect.b, defpackage.ps3
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d
    public Iterator<V> valueIterator() {
        return u.E(entryIterator());
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(u.d(i), u.d(i2));
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b
    public Set<V> createCollection() {
        return cj4.g(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, com.google.common.collect.d, defpackage.ps3
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.b, com.google.common.collect.d
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.b
    public Collection<V> createCollection(K k) {
        return new c(k, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(ps3<? extends K, ? extends V> ps3Var) {
        LinkedHashMultimap<K, V> linkedHashMultimapCreate = create(ps3Var.keySet().size(), 2);
        linkedHashMultimapCreate.putAll(ps3Var);
        return linkedHashMultimapCreate;
    }
}

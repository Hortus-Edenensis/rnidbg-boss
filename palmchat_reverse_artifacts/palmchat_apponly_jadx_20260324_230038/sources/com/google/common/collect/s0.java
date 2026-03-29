package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.collect.t0;
import com.google.common.collect.u;
import defpackage.a44;
import defpackage.cv2;
import defpackage.d43;
import defpackage.dm4;
import defpackage.em4;
import defpackage.fm4;
import defpackage.k1;
import defpackage.m1;
import defpackage.o12;
import defpackage.qo5;
import defpackage.u42;
import j$.util.Objects;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class s0<R, C, V> extends j<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient s0<R, C, V>.f columnMap;
    final qo5<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Iterator<t0.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f6195a;
        public Map.Entry<R, Map<C, V>> b;
        public Iterator<Map.Entry<C, V>> c;

        public b() {
            this.f6195a = s0.this.backingMap.entrySet().iterator();
            this.c = cv2.j();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t0.a<R, C, V> next() {
            if (!this.c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f6195a.next();
                this.b = next;
                this.c = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.b);
            Map.Entry<C, V> next2 = this.c.next();
            return v0.b(this.b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6195a.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            Map.Entry<R, Map<C, V>> entry = this.b;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f6195a.remove();
                this.b = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends u.r<R, V> {
        public final C d;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends k0.d<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(fm4.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return s0.this.containsMapping(entry.getKey(), c.this.d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !s0.this.containsColumn(cVar.d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return s0.this.removeMapping(entry.getKey(), c.this.d, entry.getValue());
            }

            @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(fm4.i(fm4.g(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = s0.this.backingMap.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends k1<Map.Entry<R, V>> {
            public final Iterator<Map.Entry<R, Map<C, V>>> c;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends m1<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f6197a;
                public final /* synthetic */ b b;

                public a(b bVar, Map.Entry entry) {
                    this.f6197a = entry;
                    this.b = bVar;
                }

                @Override // defpackage.m1, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f6197a.getKey();
                }

                @Override // defpackage.m1, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f6197a.getValue()).get(c.this.d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // defpackage.m1, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) a44.a(((Map) this.f6197a.getValue()).put(c.this.d, dm4.o(v)));
                }
            }

            public b() {
                this.c = s0.this.backingMap.entrySet().iterator();
            }

            @Override // defpackage.k1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.c.next();
                    if (next.getValue().containsKey(c.this.d)) {
                        return new a(this, next);
                    }
                }
                return b();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.s0$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0379c extends u.m<R, V> {
            public C0379c() {
                super(c.this);
            }

            @Override // com.google.common.collect.u.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return s0.this.contains(obj, cVar.d);
            }

            @Override // com.google.common.collect.u.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return s0.this.remove(obj, cVar.d) != null;
            }

            @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(u.n(fm4.i(fm4.g(collection))));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends u.q<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(u.G(fm4.f(obj)));
            }

            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(u.G(fm4.g(collection)));
            }

            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(u.G(fm4.i(fm4.g(collection))));
            }
        }

        public c(C c) {
            this.d = (C) dm4.o(c);
        }

        @Override // com.google.common.collect.u.r
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.u.r
        /* JADX INFO: renamed from: b */
        public Set<R> g() {
            return new C0379c();
        }

        @Override // com.google.common.collect.u.r
        public Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return s0.this.contains(obj, this.d);
        }

        public boolean d(em4<? super Map.Entry<R, V>> em4Var) {
            Iterator<Map.Entry<R, Map<C, V>>> it = s0.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.d);
                if (v != null && em4Var.apply(u.i(next.getKey(), v))) {
                    value.remove(this.d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) s0.this.get(obj, this.d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) s0.this.put(r, this.d, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) s0.this.remove(obj, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends k1<C> {
        public final Map<C, V> c;
        public final Iterator<Map<C, V>> d;
        public Iterator<Map.Entry<C, V>> e;

        public d() {
            this.c = s0.this.factory.get();
            this.d = s0.this.backingMap.values().iterator();
            this.e = cv2.h();
        }

        @Override // defpackage.k1
        public C a() {
            while (true) {
                if (this.e.hasNext()) {
                    Map.Entry<C, V> next = this.e.next();
                    if (!this.c.containsKey(next.getKey())) {
                        this.c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.d.hasNext()) {
                        return b();
                    }
                    this.e = this.d.next().entrySet().iterator();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends s0<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return s0.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return s0.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = s0.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.k0.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            dm4.o(collection);
            Iterator<Map<C, V>> it = s0.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (cv2.u(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            dm4.o(collection);
            Iterator<Map<C, V>> it = s0.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return cv2.y(iterator());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends u.r<C, Map<R, V>> {

        /* JADX INFO: compiled from: SearchBox */
        public final class a extends s0<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.s0$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0380a implements u42<C, Map<R, V>> {
                public C0380a() {
                }

                @Override // defpackage.u42
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C c) {
                    return s0.this.column(c);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!s0.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return u.c(s0.this.columnKeySet(), new C0380a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                s0.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.k0.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                dm4.o(collection);
                return k0.k(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.k0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                dm4.o(collection);
                boolean z = false;
                for (Object obj : d43.j(s0.this.columnKeySet().iterator())) {
                    if (!collection.contains(u.i(obj, s0.this.column(obj)))) {
                        s0.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return s0.this.columnKeySet().size();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends u.q<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        s0.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                dm4.o(collection);
                boolean z = false;
                for (Object obj : d43.j(s0.this.columnKeySet().iterator())) {
                    if (collection.contains(s0.this.column(obj))) {
                        s0.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.u.q, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                dm4.o(collection);
                boolean z = false;
                for (Object obj : d43.j(s0.this.columnKeySet().iterator())) {
                    if (!collection.contains(s0.this.column(obj))) {
                        s0.this.removeColumn(obj);
                        z = true;
                    }
                }
                return z;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.u.r
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.u.r
        public Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return s0.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (!s0.this.containsColumn(obj)) {
                return null;
            }
            s0 s0Var = s0.this;
            Objects.requireNonNull(obj);
            return s0Var.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (s0.this.containsColumn(obj)) {
                return s0.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.u.r, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return s0.this.columnKeySet();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends u.l<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f6199a;
        public Map<C, V> b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f6200a;
            public final /* synthetic */ g b;

            public a(g gVar, Iterator it) {
                this.f6200a = it;
                this.b = gVar;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return this.b.e((Map.Entry) this.f6200a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6200a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f6200a.remove();
                this.b.c();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends o12<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f6201a;
            public final /* synthetic */ g b;

            public b(g gVar, Map.Entry entry) {
                this.f6201a = entry;
                this.b = gVar;
            }

            @Override // defpackage.p12
            /* JADX INFO: renamed from: b */
            public Map.Entry<C, V> delegate() {
                return this.f6201a;
            }

            @Override // defpackage.o12, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.o12, java.util.Map.Entry
            public V setValue(V v) {
                return (V) super.setValue(dm4.o(v));
            }
        }

        public g(R r) {
            this.f6199a = (R) dm4.o(r);
        }

        @Override // com.google.common.collect.u.l
        public Iterator<Map.Entry<C, V>> a() {
            d();
            Map<C, V> map = this.b;
            return map == null ? cv2.j() : new a(this, map.entrySet().iterator());
        }

        public Map<C, V> b() {
            return s0.this.backingMap.get(this.f6199a);
        }

        public void c() {
            d();
            Map<C, V> map = this.b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            s0.this.backingMap.remove(this.f6199a);
            this.b = null;
        }

        @Override // com.google.common.collect.u.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            d();
            Map<C, V> map = this.b;
            if (map != null) {
                map.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> map;
            d();
            return (obj == null || (map = this.b) == null || !u.v(map, obj)) ? false : true;
        }

        public final void d() {
            Map<C, V> map = this.b;
            if (map == null || (map.isEmpty() && s0.this.backingMap.containsKey(this.f6199a))) {
                this.b = b();
            }
        }

        public Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> map;
            d();
            if (obj == null || (map = this.b) == null) {
                return null;
            }
            return (V) u.w(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            dm4.o(c);
            dm4.o(v);
            Map<C, V> map = this.b;
            return (map == null || map.isEmpty()) ? (V) s0.this.put(this.f6199a, c, v) : this.b.put(c, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            d();
            Map<C, V> map = this.b;
            if (map == null) {
                return null;
            }
            V v = (V) u.x(map, obj);
            c();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            d();
            Map<C, V> map = this.b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends u.r<R, Map<C, V>> {

        /* JADX INFO: compiled from: SearchBox */
        public final class a extends s0<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.s0$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0381a implements u42<R, Map<C, V>> {
                public C0381a() {
                }

                @Override // defpackage.u42
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R r) {
                    return s0.this.row(r);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && l.c(s0.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return u.c(s0.this.backingMap.keySet(), new C0381a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && s0.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return s0.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.u.r
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return s0.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(Object obj) {
            if (!s0.this.containsRow(obj)) {
                return null;
            }
            s0 s0Var = s0.this;
            Objects.requireNonNull(obj);
            return s0Var.row(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return s0.this.backingMap.remove(obj);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class i<T> extends k0.d<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s0.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return s0.this.backingMap.isEmpty();
        }
    }

    public s0(Map<R, Map<C, V>> map, qo5<? extends Map<C, V>> qo5Var) {
        this.backingMap = map;
        this.factory = qo5Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V vRemove = next.getValue().remove(obj);
            if (vRemove != null) {
                linkedHashMap.put(next.getKey(), vRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.j
    public Iterator<t0.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public Set<t0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.j
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.t0
    public Map<C, Map<R, V>> columnMap() {
        s0<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        s0<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.j
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.j
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (u.v(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.j
    public boolean containsRow(Object obj) {
        return obj != null && u.v(this.backingMap, obj);
    }

    @Override // com.google.common.collect.j
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.j
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public V put(R r, C c2, V v) {
        dm4.o(r);
        dm4.o(c2);
        dm4.o(v);
        return getOrCreate(r).put(c2, v);
    }

    @Override // com.google.common.collect.j
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) u.w(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // com.google.common.collect.t0
    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.t0
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.t0
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapCreateRowMap = createRowMap();
        this.rowMap = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // com.google.common.collect.t0
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.common.collect.j
    public Collection<V> values() {
        return super.values();
    }
}

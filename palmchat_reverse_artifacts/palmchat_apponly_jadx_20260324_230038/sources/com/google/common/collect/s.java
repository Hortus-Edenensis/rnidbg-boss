package com.google.common.collect;

import defpackage.cv2;
import defpackage.o46;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class s<K, V> extends ImmutableCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<K, V> f6191a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o46<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o46<Map.Entry<K, V>> f6192a;

        public a() {
            this.f6192a = s.this.f6191a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6192a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f6192a.next().getValue();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ImmutableList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableList f6193a;
        public final /* synthetic */ s b;

        public b(s sVar, ImmutableList immutableList) {
            this.f6193a = immutableList;
            this.b = sVar;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((Map.Entry) this.f6193a.get(i)).getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6193a.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<?, V> f6194a;

        public c(ImmutableMap<?, V> immutableMap) {
            this.f6194a = immutableMap;
        }

        public Object readResolve() {
            return this.f6194a.values();
        }
    }

    public s(ImmutableMap<K, V> immutableMap) {
        this.f6191a = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        return new b(this, this.f6191a.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && cv2.f(iterator(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f6191a.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new c(this.f6191a);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public o46<V> iterator() {
        return new a();
    }
}

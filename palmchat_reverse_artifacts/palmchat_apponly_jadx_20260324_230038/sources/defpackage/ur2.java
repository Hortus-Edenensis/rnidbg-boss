package defpackage;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.t;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ur2<K, V> extends t<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<K, V> f21276a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a<K> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, ?> f21277a;

        public a(ImmutableMap<K, ?> immutableMap) {
            this.f21277a = immutableMap;
        }

        public Object readResolve() {
            return this.f21277a.keySet();
        }
    }

    public ur2(ImmutableMap<K, V> immutableMap) {
        this.f21276a = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f21276a.containsKey(obj);
    }

    @Override // com.google.common.collect.t
    public K get(int i) {
        return this.f21276a.entrySet().asList().get(i).getKey();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f21276a.size();
    }

    @Override // com.google.common.collect.t, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new a(this.f21276a);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public o46<K> iterator() {
        return this.f21276a.keyIterator();
    }
}

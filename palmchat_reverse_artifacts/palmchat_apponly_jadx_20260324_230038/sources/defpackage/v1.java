package defpackage;

import com.google.common.collect.i;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class v1<K, V> extends i<K, V> {
    public v1(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.d
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.g, com.google.common.collect.d, defpackage.ps3
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // com.google.common.collect.b
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }

    @Override // com.google.common.collect.d, defpackage.ps3
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}

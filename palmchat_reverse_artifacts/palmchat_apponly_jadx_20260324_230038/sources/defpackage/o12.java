package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class o12<K, V> extends p12 implements Map.Entry<K, V> {
    public abstract Map.Entry<K, V> b();

    public boolean equals(Object obj) {
        return b().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return b().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return b().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return b().hashCode();
    }

    public V setValue(V v) {
        return b().setValue(v);
    }

    public boolean standardEquals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m54.a(getKey(), entry.getKey()) && m54.a(getValue(), entry.getValue());
    }
}

package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class tr2<K, V> extends m1<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f21047a;
    public final V b;

    public tr2(K k, V v) {
        this.f21047a = k;
        this.b = v;
    }

    @Override // defpackage.m1, java.util.Map.Entry
    public final K getKey() {
        return this.f21047a;
    }

    @Override // defpackage.m1, java.util.Map.Entry
    public final V getValue() {
        return this.b;
    }

    @Override // defpackage.m1, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}

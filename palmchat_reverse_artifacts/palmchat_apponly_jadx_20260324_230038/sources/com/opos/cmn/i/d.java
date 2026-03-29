package com.opos.cmn.i;

import android.util.LruCache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d<K, V> extends LruCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8026a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<K, V> {
        void a(K k, V v);
    }

    public d(int i, a<K, V> aVar) {
        super(i);
        this.f8026a = aVar;
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean z, K k, V v, V v2) {
        a aVar;
        if (!z || (aVar = this.f8026a) == null) {
            return;
        }
        aVar.a(k, v);
    }
}

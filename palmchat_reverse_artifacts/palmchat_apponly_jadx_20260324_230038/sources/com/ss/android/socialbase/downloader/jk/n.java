package com.ss.android.socialbase.downloader.jk;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n<K, T> extends LinkedHashMap<K, T> {
    private int u;

    public n() {
        this(4, 4);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.u;
    }

    public void u(int i) {
        this.u = i;
    }

    public n(int i, int i2) {
        this(i, i2, true);
    }

    public n(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        u(i2);
    }
}

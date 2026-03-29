package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class l<V> {
    private final Throwable nr;
    private final V u;

    public l(V v) {
        this.u = v;
        this.nr = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (u() != null && u().equals(lVar.u())) {
            return true;
        }
        if (nr() == null || lVar.nr() == null) {
            return false;
        }
        return nr().toString().equals(nr().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{u(), nr()});
    }

    public Throwable nr() {
        return this.nr;
    }

    public V u() {
        return this.u;
    }

    public l(Throwable th) {
        this.nr = th;
        this.u = null;
    }
}

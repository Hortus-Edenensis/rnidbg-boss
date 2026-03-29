package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class av extends bw<cb> {
    public final synchronized void a(cb cbVar) {
        remove(cbVar);
    }

    public final synchronized boolean b(cb cbVar) {
        if (contains(cbVar)) {
            return false;
        }
        a(cbVar);
        return true;
    }
}

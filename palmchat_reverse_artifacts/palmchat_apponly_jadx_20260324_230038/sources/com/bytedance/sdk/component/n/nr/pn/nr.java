package com.bytedance.sdk.component.n.nr.pn;

import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr implements Comparable<nr>, Runnable {
    private String fx;
    private int u = 5;
    private String nr = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public nr(String str) {
        this.fx = str;
    }

    public void u(int i) {
        this.u = i;
    }

    public int u() {
        return this.u;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(nr nrVar) {
        if (u() < nrVar.u()) {
            return 1;
        }
        return u() >= nrVar.u() ? -1 : 0;
    }
}

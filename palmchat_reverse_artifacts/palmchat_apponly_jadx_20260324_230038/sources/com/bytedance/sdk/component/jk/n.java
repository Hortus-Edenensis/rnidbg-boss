package com.bytedance.sdk.component.jk;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n<V> extends FutureTask<V> implements Comparable<n<V>> {
    private int nr;
    private int u;

    public n(Callable<V> callable, int i, int i2) {
        super(callable);
        this.u = i == -1 ? 5 : i;
        this.nr = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        if (u() < nVar.u()) {
            return 1;
        }
        return u() > nVar.u() ? -1 : 0;
    }

    public int u() {
        return this.u;
    }
}

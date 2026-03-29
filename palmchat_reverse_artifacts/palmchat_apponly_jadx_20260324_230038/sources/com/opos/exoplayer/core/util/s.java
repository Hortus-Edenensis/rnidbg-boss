package com.opos.exoplayer.core.util;

import java.util.PriorityQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8402a;
    private final PriorityQueue<Integer> b;
    private int c;

    public void a(int i) {
        synchronized (this.f8402a) {
            this.b.add(Integer.valueOf(i));
            this.c = Math.max(this.c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f8402a) {
            this.b.remove(Integer.valueOf(i));
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f8402a.notifyAll();
        }
    }
}

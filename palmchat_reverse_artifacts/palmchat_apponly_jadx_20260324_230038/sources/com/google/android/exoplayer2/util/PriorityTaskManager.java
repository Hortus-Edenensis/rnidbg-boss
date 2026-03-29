package com.google.android.exoplayer2.util;

import defpackage.g86;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6030a = new Object();
    public final PriorityQueue<Integer> b = new PriorityQueue<>(10, Collections.reverseOrder());
    public int c = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: SearchBox */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void a(int i) {
        synchronized (this.f6030a) {
            this.b.add(Integer.valueOf(i));
            this.c = Math.max(this.c, i);
        }
    }

    public void b(int i) throws PriorityTooLowException {
        synchronized (this.f6030a) {
            if (this.c != i) {
                throw new PriorityTooLowException(i, this.c);
            }
        }
    }

    public void c(int i) {
        synchronized (this.f6030a) {
            this.b.remove(Integer.valueOf(i));
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : ((Integer) g86.j(this.b.peek())).intValue();
            this.f6030a.notifyAll();
        }
    }
}

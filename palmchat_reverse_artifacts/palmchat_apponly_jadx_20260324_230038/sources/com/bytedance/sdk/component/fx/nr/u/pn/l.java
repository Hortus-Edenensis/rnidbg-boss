package com.bytedance.sdk.component.fx.nr.u.pn;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class l {
    private final CountDownLatch u = new CountDownLatch(1);
    private long nr = -1;
    private long fx = -1;

    public void fx() {
        if (this.fx == -1) {
            long j = this.nr;
            if (j != -1) {
                this.fx = j - 1;
                this.u.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void nr() {
        if (this.fx != -1 || this.nr == -1) {
            throw new IllegalStateException();
        }
        this.fx = System.nanoTime();
        this.u.countDown();
    }

    public void u() {
        if (this.nr != -1) {
            throw new IllegalStateException();
        }
        this.nr = System.nanoTime();
    }
}

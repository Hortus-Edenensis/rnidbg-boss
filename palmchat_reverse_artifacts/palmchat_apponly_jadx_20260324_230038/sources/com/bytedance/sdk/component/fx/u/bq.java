package com.bytedance.sdk.component.fx.u;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq {
    public static final bq fx = new bq() { // from class: com.bytedance.sdk.component.fx.u.bq.1
        @Override // com.bytedance.sdk.component.fx.u.bq
        public bq u(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.fx.u.bq
        public bq u(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.component.fx.u.bq
        public void x() throws IOException {
        }
    };
    private long b;
    private long nr;
    private boolean u;

    public long f_() {
        return this.b;
    }

    public boolean fx() {
        return this.u;
    }

    public long g_() {
        if (this.u) {
            return this.nr;
        }
        throw new IllegalStateException("No deadline");
    }

    public bq iz() {
        this.u = false;
        return this;
    }

    public bq pn() {
        this.b = 0L;
        return this;
    }

    public bq u(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.b = timeUnit.toNanos(j);
        return this;
    }

    public void x() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.u && this.nr - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public bq u(long j) {
        this.u = true;
        this.nr = j;
        return this;
    }
}

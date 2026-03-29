package com.bytedance.sdk.component.jk.nr;

import com.bytedance.sdk.component.jk.nr.fx;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b<T extends fx> {
    private BlockingQueue<T> nr = new LinkedBlockingQueue();
    private int u;

    private b(int i) {
        this.u = i;
    }

    public static b u(int i) {
        return new b(i);
    }

    public T u() {
        return this.nr.poll();
    }

    public boolean u(T t) {
        if (t == null) {
            return false;
        }
        t.u();
        if (this.nr.size() >= this.u) {
            return false;
        }
        return this.nr.offer(t);
    }
}

package com.bytedance.sdk.component.jk.u;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.component.jk.jk;
import com.bytedance.sdk.component.jk.t;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements ThreadFactory {
    private final int nr;
    private final ThreadFactory u;

    public b(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.u = new jk(MapController.DEFAULT_LAYER_TAG);
        } else {
            this.u = threadFactory;
        }
        this.nr = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.u.newThread(runnable);
        return nr() ? new x(threadNewThread) : threadNewThread;
    }

    public boolean nr() {
        return t.nr.nr(this.nr);
    }

    public final String u() {
        return this.u.getClass().getName();
    }
}

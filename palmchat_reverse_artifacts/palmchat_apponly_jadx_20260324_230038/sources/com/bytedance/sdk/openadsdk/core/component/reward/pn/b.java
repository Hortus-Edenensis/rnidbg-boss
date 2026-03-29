package com.bytedance.sdk.openadsdk.core.component.reward.pn;

import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.u;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements u.nr {
    private long fx;
    private long nr;
    long u;

    public b() {
        n.o().u(this);
    }

    public void b() {
        if (this.nr == 0) {
            return;
        }
        this.u += System.currentTimeMillis() - this.nr;
        this.nr = 0L;
        this.fx = 0L;
    }

    public void fx() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.nr;
        if (j != 0) {
            this.u += jCurrentTimeMillis - j;
        }
        this.nr = jCurrentTimeMillis;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
        fx();
    }

    public void pn() {
        this.nr = 0L;
        this.fx = 0L;
        this.u = 0L;
    }

    public long u(TimeUnit timeUnit) {
        return timeUnit != null ? timeUnit.convert(this.u, TimeUnit.MILLISECONDS) : this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
        b();
    }
}

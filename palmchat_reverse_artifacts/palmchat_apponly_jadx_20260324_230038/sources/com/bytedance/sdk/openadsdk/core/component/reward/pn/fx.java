package com.bytedance.sdk.openadsdk.core.component.reward.pn;

import com.bytedance.sdk.openadsdk.core.component.reward.nr.iz;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private final int b;
    private final iz iz;
    private int pn;
    private final com.bytedance.sdk.openadsdk.core.component.reward.b.u x;
    protected int u = 0;
    protected int nr = 0;
    protected int fx = 1000;

    public fx(boolean z, bc bcVar, iz izVar, com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar) {
        this.iz = izVar;
        this.x = uVar;
        this.b = z ? dw.nr().b(jp.t(bcVar)) : dw.nr().pn(jp.t(bcVar));
    }

    public int a() {
        return this.fx;
    }

    public int b() {
        return this.x.m();
    }

    public int fx() {
        return this.b;
    }

    public int iz() {
        return this.nr;
    }

    public void n() {
        this.nr++;
    }

    public int nr() {
        return this.pn;
    }

    public int pn() {
        return this.u;
    }

    public long u() {
        return this.iz.rh();
    }

    public void x() {
        this.u++;
    }

    public void fx(int i) {
        this.fx = i;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void u(int i) {
        this.pn += i;
    }
}

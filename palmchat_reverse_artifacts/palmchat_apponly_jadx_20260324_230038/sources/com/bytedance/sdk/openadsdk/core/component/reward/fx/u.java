package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends nr {
    protected boolean b;
    protected boolean fx;
    protected boolean iz;
    protected int nr;
    protected boolean pn;
    protected int u;

    public u(Activity activity, bc bcVar) {
        super(activity, bcVar);
    }

    public void b(boolean z) {
        this.pn = z;
    }

    public void fx(boolean z) {
        this.iz = z;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public u(Activity activity, bc bcVar, ob obVar) {
        super(activity, bcVar, obVar);
    }

    public void nr(boolean z) {
        this.b = z;
    }

    public void u(boolean z) {
        this.fx = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(jk jkVar) {
        mv mvVar = new mv(this.n, this.x);
        mvVar.nr(this.b);
        mvVar.u(this.fx);
        mvVar.u(this.u);
        mvVar.nr(this.nr);
        mvVar.b(this.t);
        mvVar.fx(this.l);
        mvVar.u(this.my);
        mvVar.nr(this.k);
        mvVar.fx(this.iz);
        mvVar.b(this.pn);
        return mvVar.nr(jkVar);
    }
}

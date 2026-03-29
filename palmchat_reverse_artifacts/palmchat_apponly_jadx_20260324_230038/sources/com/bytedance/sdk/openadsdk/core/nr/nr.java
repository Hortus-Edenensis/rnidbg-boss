package com.bytedance.sdk.openadsdk.core.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends b {
    public int b;
    protected final int fx;
    protected final String nr;
    protected com.bytedance.sdk.openadsdk.core.nr.u.fx pn;
    protected final bc u;

    public nr(Context context, bc bcVar, String str, int i) {
        super(context);
        this.b = 1;
        this.u = bcVar;
        this.nr = str;
        this.fx = i;
        pn();
    }

    private void pn() {
        com.bytedance.sdk.openadsdk.core.nr.u.fx fxVarU = this.n.u(this.u, this.iz, this, u());
        this.pn = fxVarU;
        fxVarU.u(this.x);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.nr);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.nr);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
        if (u()) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).b(true);
        }
    }

    public void b(int i) {
        this.x.nr(i);
    }

    public void fx(int i) {
        this.x.fx(i);
    }

    public jk nr() {
        return this.x;
    }

    public boolean u() {
        return false;
    }

    public void nr(View view) {
        this.x.u(view);
    }

    public void u(int i) {
        this.b = i;
        jk jkVar = this.x;
        if (jkVar != null) {
            jkVar.u(i);
        }
    }

    public void nr(int i) {
        this.x.b(i);
    }

    public void u(jk jkVar) {
        this.x = jkVar;
    }

    public void u(View view) {
        this.x.nr(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void u(View view, jk jkVar) {
        if (bc.pn(this.u)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).pn());
        this.pn.u(view);
        if (jkVar == null) {
            jkVar = new jk();
        }
        this.pn.u(jkVar);
        this.pn.u();
        bc.iz(this.u);
    }
}

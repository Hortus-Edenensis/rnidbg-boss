package com.bytedance.sdk.openadsdk.core.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class pn extends u {
    public pn(Context context, bc bcVar, String str, int i) {
        super(context, bcVar, str, i);
    }

    public abstract void nr(View view, jk jkVar);

    @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
    public void u(View view, jk jkVar) {
        if (bc.pn(this.u)) {
            return;
        }
        super.u(view, jkVar);
        com.bytedance.sdk.openadsdk.core.nr.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.nr.u.nr) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.nr.class);
        if (nrVar == null || !nrVar.nr(view)) {
            return;
        }
        nr(view, jkVar);
    }
}

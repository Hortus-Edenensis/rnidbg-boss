package com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends com.bytedance.sdk.openadsdk.core.component.reward.fx.nr {
    protected String u;

    public u(Activity activity, bc bcVar) {
        super(activity, bcVar);
    }

    public void u(String str) {
        this.u = str;
    }

    public u(Activity activity, bc bcVar, ob obVar) {
        super(activity, bcVar, obVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u u(jk jkVar) {
        b bVar = new b(this.n, this.x);
        bVar.b(this.t);
        bVar.fx(this.l);
        bVar.nr(this.k);
        bVar.u(this.u);
        return bVar.u(jkVar);
    }
}

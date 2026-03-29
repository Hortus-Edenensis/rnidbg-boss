package com.bytedance.sdk.openadsdk.core.nr.u.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private int iz;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.fx pn;

    public u() {
    }

    public void u(com.bytedance.sdk.openadsdk.core.nativeexpress.fx fxVar) {
        this.pn = fxVar;
    }

    public u(bc bcVar, Context context) {
        this.u = bcVar;
        this.nr = context;
    }

    public void u(int i) {
        this.iz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.u
    public void u(View view) {
        this.b = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar) {
        if (this.pn == null) {
            return 0;
        }
        if (this.fx == null) {
            this.fx = new jk();
        }
        View viewN = this.fx.n();
        int[] iArrU = new int[2];
        int[] iArrFx = new int[2];
        if (viewN != null) {
            iArrU = y.u(viewN);
            iArrFx = y.fx(viewN);
        }
        this.pn.u(this.b, this.iz, new q.u().b(this.fx.my()).fx(this.fx.o()).nr(this.fx.sx()).u(this.fx.bg()).nr(this.fx.s()).u(this.fx.k()).u(iArrU[0]).nr(iArrU[1]).fx(iArrFx[0]).b(iArrFx[1]).u(this.fx.x()).u(this.fx.l()).u());
        return 1;
    }
}

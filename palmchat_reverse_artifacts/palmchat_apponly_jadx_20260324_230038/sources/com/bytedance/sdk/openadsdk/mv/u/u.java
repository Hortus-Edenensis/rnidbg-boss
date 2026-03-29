package com.bytedance.sdk.openadsdk.mv.u;

import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.n;
import com.bytedance.sdk.openadsdk.core.gi.u.u;
import com.bytedance.sdk.openadsdk.core.kj.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.gi.u.u {
    private p u;

    private boolean b() {
        p pVar = this.u;
        return pVar != null && pVar.c();
    }

    private void pn() {
        if (b()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            p pVar = this.u;
            pVar.n(jCurrentTimeMillis - pVar.bg());
            this.u.mv(jCurrentTimeMillis);
        }
    }

    private void u(my myVar) {
        n httpTime = myVar.getHttpTime();
        if (httpTime == null || !b()) {
            return;
        }
        u(httpTime.getStartRequestTime(), httpTime.getFirstFrameTime());
    }

    public p fx() {
        return this.u;
    }

    private void u(long j, long j2) {
        this.u.s(j2);
        p pVar = this.u;
        pVar.a(j2 - pVar.dw());
        this.u.bg(j2 - j);
    }

    public void u(p pVar) {
        this.u = pVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gi.u.u
    public void u(my myVar, u.nr nrVar) {
        u(myVar);
        super.u(myVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gi.u.u
    public void u() {
        pn();
    }
}

package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends com.bytedance.sdk.openadsdk.core.nr.nr {
    private com.bytedance.sdk.openadsdk.core.kj.q jk;
    protected int l;
    protected int mv;
    protected int s;
    private boolean t;

    public iz(Context context, bc bcVar, String str, int i) {
        super(context, bcVar, str, i);
        this.l = 0;
        this.mv = -1;
        this.s = -1;
        this.t = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void b() {
        this.s = 1;
        this.t = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void fx() {
        this.mv = 1;
        this.t = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void pn(int i) {
        this.l = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
    public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
        com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
        uVar.u(u(uVar.fx(), jkVar == null ? (byte) 0 : jkVar.nr()));
        super.u(view, jkVar);
    }

    private com.bytedance.sdk.openadsdk.core.kj.a u(String str, byte b) {
        int i;
        int i2;
        char c;
        int iFx;
        int iFx2;
        View viewA = this.x.a();
        int[] iArrU = y.u(viewA);
        if (iArrU == null || iArrU.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = iArrU[0];
            i2 = iArrU[1];
            if (this.l == 0 && this.t) {
                this.x.u((y.fx(this.iz, r8.my()) + i) - 0.5f);
                this.x.nr((y.fx(this.iz, r8.o()) + i2) - 0.5f);
                this.x.fx((y.fx(this.iz, r8.sx()) + i) - 0.5f);
                this.x.b((y.fx(this.iz, r8.bg()) + i2) - 0.5f);
            }
        }
        float fIz = y.iz(this.iz);
        int iN = y.n(this.iz);
        float fX = y.x(this.iz);
        int[] iArrU2 = {-1, -1};
        int[] iArrFx = {-1, -1};
        com.bytedance.sdk.openadsdk.core.kj.q qVar = this.jk;
        if (qVar != null && this.t) {
            this.x.u(qVar.pn);
            this.x.nr(this.jk.iz);
            if (this.l == 0) {
                iArrU2[0] = y.fx(this.iz, this.jk.x) + i;
                iArrU2[1] = y.fx(this.iz, this.jk.n) + i2;
                iFx2 = y.fx(this.iz, this.jk.f5320a);
                iFx = y.fx(this.iz, this.jk.jk);
                c = 1;
            } else {
                com.bytedance.sdk.openadsdk.core.kj.q qVar2 = this.jk;
                iArrU2[0] = qVar2.x;
                c = 1;
                iArrU2[1] = qVar2.n;
                int i3 = qVar2.f5320a;
                iFx = qVar2.jk;
                iFx2 = i3;
            }
            iArrFx[0] = iFx2;
            iArrFx[c] = iFx;
            View viewN = this.x.n();
            if (iFx2 == 0 && iFx == 0 && viewN != null) {
                iArrU2 = y.u(viewN);
                iArrFx = y.fx(viewN);
            }
        }
        this.l = 0;
        return new a.u().iz(this.x.my()).pn(this.x.o()).b(this.x.sx()).fx(this.x.bg()).nr(this.x.s()).u(this.x.k()).nr(iArrU).u(iArrU2).fx(y.fx(viewA)).b(iArrFx).fx(this.x.b()).b(this.x.pn()).pn(this.x.iz()).nr(com.bytedance.sdk.openadsdk.core.n.o().fx() ? 1 : 2).u(this.x.l()).u(str).u(fIz).u(iN).iz(this.mv).x(this.s).nr(fX).u(b).u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void u(com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        this.jk = qVar;
    }
}

package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends com.bytedance.sdk.openadsdk.core.nr.u {
    private com.bytedance.sdk.openadsdk.core.kj.q jk;
    protected int l;
    protected int mv;
    protected int s;
    private boolean t;

    public pn(Context context, bc bcVar, String str, int i) {
        super(context, bcVar, str, i);
        this.l = 0;
        this.mv = -1;
        this.s = -1;
        this.t = true;
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.component.t.pn.u.u().u(bcVar.hashCode() + bcVar.xx()).put("is_express_ad", Boolean.TRUE);
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

    public com.bytedance.sdk.openadsdk.core.kj.a u(String str, byte b) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
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
        int[] iArrU2 = {-1, -1};
        int[] iArrFx = new int[2];
        com.bytedance.sdk.openadsdk.core.kj.q qVar = this.jk;
        if (qVar == null || !this.t) {
            str2 = "";
            str3 = str;
            str4 = "";
            str5 = str4;
        } else {
            this.x.u(qVar.pn);
            this.x.nr(this.jk.iz);
            if (this.l == 0) {
                iArrU2[0] = y.fx(this.iz, this.jk.x) + i;
                iArrU2[1] = y.fx(this.iz, this.jk.n) + i2;
                iFx2 = y.fx(this.iz, this.jk.f5320a);
                iFx = y.fx(this.iz, this.jk.jk);
            } else {
                com.bytedance.sdk.openadsdk.core.kj.q qVar2 = this.jk;
                iArrU2[0] = qVar2.x;
                iArrU2[1] = qVar2.n;
                int i3 = qVar2.f5320a;
                iFx = qVar2.jk;
                iFx2 = i3;
            }
            str3 = TextUtils.isEmpty(str) ? this.jk.t : str;
            com.bytedance.sdk.openadsdk.core.kj.q qVar3 = this.jk;
            str2 = qVar3.l;
            str5 = qVar3.mv;
            str4 = qVar3.s;
            iArrFx[0] = iFx2;
            iArrFx[1] = iFx;
            View viewN = this.x.n();
            if (iFx2 == 0 && iFx == 0 && viewN != null) {
                iArrU2 = y.u(viewN);
                iArrFx = y.fx(viewN);
            }
        }
        this.l = 0;
        return new a.u().iz(this.x.my()).pn(this.x.o()).b(this.x.sx()).fx(this.x.bg()).nr(this.x.s()).u(this.x.k()).nr(iArrU).u(iArrU2).fx(y.fx(viewA)).b(iArrFx).fx(this.x.b()).b(this.x.pn()).pn(this.x.iz()).nr(com.bytedance.sdk.openadsdk.core.n.o().fx() ? 1 : 2).u(this.x.l()).u(str3).nr(str5).fx(str2).b(str4).u(y.iz(this.iz)).u(y.n(this.iz)).iz(this.mv).x(this.s).nr(y.x(this.iz)).pn(this.x.bq()).n(this.x.dw()).u(b).u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void u(com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        this.jk = qVar;
    }
}

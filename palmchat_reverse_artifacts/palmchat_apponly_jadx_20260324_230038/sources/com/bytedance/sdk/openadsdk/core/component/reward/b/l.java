package com.bytedance.sdk.openadsdk.core.component.reward.b;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.yd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends u {
    public l(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
    }

    public static int nr(bc bcVar) {
        return 1;
    }

    public static boolean u(bc bcVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return lf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        if (yd.o(this.nr)) {
            boolean z = !yd.fx();
            boolean zFx = yd.fx();
            this.u.fx(0);
            if (kj() > xw() || this.k) {
                com.bytedance.sdk.openadsdk.core.n.b.u = 0;
                com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar = this.sx;
                boolean z2 = this.s;
                pnVar.u(z2, z2 ? "领取成功" : "", z ? "跳过" : "", zFx, true);
                this.u.tk();
                return;
            }
            int iIz = iz(true);
            int iIz2 = iz(false);
            com.bytedance.sdk.openadsdk.core.n.b.u = iIz;
            boolean z3 = kj() > this.h.fx() || this.u.wi();
            boolean z4 = z && z3;
            boolean z5 = zFx && z3;
            com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar2 = this.sx;
            boolean z6 = this.s;
            StringBuilder sb = new StringBuilder();
            sb.append(iIz2);
            sb.append("s");
            sb.append(this.s ? "后可领取奖励" : "");
            pnVar2.u(z6, sb.toString(), z4 ? "跳过" : "", z5, z3);
            nr(iIz);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean kw() {
        return yd.o(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean mk() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void my() {
        super.my();
        this.u.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return !x() || yd.fx(this.nr, x());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean p() {
        if (!this.s) {
            return false;
        }
        if (tk.u(this.nr) == 2 && tk.nr(this.nr) == 3) {
            return false;
        }
        return (tk.u(this.nr) == 2 && tk.nr(this.nr) == 7) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void tm() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.iz izVar = this.c;
        if (izVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u((Object) this.u);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar = this.q;
        if (pnVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u((Object) this.u);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.sx.nr(this.nr.uo());
        if (iz()) {
            this.f5223a.pn(8);
            this.f5223a.iz(8);
            this.sx.u(false);
        } else {
            this.f5223a.pn(0);
            this.f5223a.iz(0);
            this.sx.pn(true);
        }
        this.u.w();
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    public pn(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
    }

    public static int nr(bc bcVar) {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        if (this.b != 100.0f) {
            return v();
        }
        if (this.fx == 2) {
            int iOl = this.nr.ol();
            return iOl != 3 ? iOl != 33 ? com.bytedance.sdk.openadsdk.res.pn.bg(this.u) : com.bytedance.sdk.openadsdk.res.pn.sx(this.u) : com.bytedance.sdk.openadsdk.res.pn.o(this.u);
        }
        int iOl2 = this.nr.ol();
        return iOl2 != 3 ? iOl2 != 33 ? com.bytedance.sdk.openadsdk.res.pn.c(this.u) : com.bytedance.sdk.openadsdk.res.pn.dw(this.u) : com.bytedance.sdk.openadsdk.res.pn.bq(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        super.f();
        if (kw()) {
            int iZ = z();
            int iKj = kj();
            if (!dw.nr().dr() && !nb() && yd.fx(this.nr, x()) && iZ > zx.x(this.nr)) {
                this.u.gc();
            }
            this.u.fx(0);
            if (n(false)) {
                if (this.bq.pb()) {
                    return;
                }
                if (iKj > xw() || this.k) {
                    com.bytedance.sdk.openadsdk.core.n.b.u = 0;
                    this.u.w();
                    if (this.jk == null || q() != 7) {
                        return;
                    }
                    this.jk.u("0", iKj, 0, false);
                    return;
                }
                int iIz = iz(true);
                int iIz2 = iz(false);
                com.bytedance.sdk.openadsdk.core.n.b.u = iIz;
                this.u.w();
                nr(iIz);
                if (this.jk == null || q() != 7) {
                    return;
                }
                this.jk.u(String.valueOf(iIz2), iKj, 0, false);
                return;
            }
            if (iKj > xw() || this.k) {
                this.u.tk();
                com.bytedance.sdk.openadsdk.core.n.b.u = 0;
                com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar = this.sx;
                boolean z = this.s;
                pnVar.u(z, z ? "领取成功" : "", null, true, true);
                if (this.jk == null || q() != 7) {
                    return;
                }
                this.jk.u("0", iKj, 0, false);
                return;
            }
            int iIz3 = iz(true);
            int iIz4 = iz(false);
            com.bytedance.sdk.openadsdk.core.n.b.u = iIz3;
            boolean z2 = iKj > this.h.fx() || this.u.wi();
            com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar2 = this.sx;
            boolean z3 = this.s;
            StringBuilder sb = new StringBuilder();
            sb.append(iIz4);
            sb.append("s");
            sb.append(this.s ? "后可领取奖励" : "");
            pnVar2.u(z3, sb.toString(), null, z2, z2);
            nr(iIz3);
            if (this.jk == null || q() != 7) {
                return;
            }
            this.jk.u(String.valueOf(iIz4), iKj, 0, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean kw() {
        if (!yd.fx(this.nr, x())) {
            return false;
        }
        if (yd.o(this.nr)) {
            return true;
        }
        return (dw.nr().dr() || nb()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean mk() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean n(boolean z) {
        if (dw.nr().dr()) {
            return false;
        }
        return (z || !yd.o(this.nr)) && !nb() && kw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        if (!dw.nr().dr()) {
            return yd.fx(this.nr, x()) && zx.l(this.nr);
        }
        if (this.nr.ba() != 100.0f) {
            return bc.nr(this.nr) || com.bytedance.sdk.openadsdk.gi.t.u(this.nr);
        }
        if (this.jk.iz()) {
            return this.jk.jk();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean p() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        if (this.b != 100.0f) {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.x(this.u, this.nr, z);
        } else {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.iz(this.u, this.nr, z);
        }
        return this.f5223a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int xw() {
        return n(false) ? (int) Math.min(yd.u() / 1000, (int) zx.x(this.nr)) : yd.o(this.nr) ? super.xw() : (int) zx.x(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.f5223a.pn(8);
        this.f5223a.iz(8);
        this.sx.pn(nb());
        this.sx.nr(this.nr.uo());
        this.u.w();
    }

    public static boolean u(bc bcVar) {
        return (bcVar == null || bc.nr(bcVar)) ? false : true;
    }
}

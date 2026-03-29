package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.cj;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.y.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends u {
    boolean bf;
    int ja;
    int rh;

    public x(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = 0;
        this.ja = 0;
        this.bf = false;
    }

    public static boolean u(bc bcVar) {
        return q.fx(bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        return com.bytedance.sdk.openadsdk.res.pn.u(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean bf() {
        if (m() > 0) {
            return false;
        }
        if (!bg.b(this.nr) && cj.u(this.nr) == 0) {
            return this.bq.dw();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        if (bg.t(this.nr)) {
            return;
        }
        int iKj = kj();
        int i = this.rh;
        int i2 = i - iKj;
        if (iKj >= i) {
            this.sx.u(false, null, null, true, true);
            if (!bg.t(this.nr)) {
                this.u.l();
            }
        } else {
            int i3 = this.ja;
            if (i3 >= i) {
                this.sx.u(false, String.valueOf(i2), null, false, false);
            } else if (iKj >= i3) {
                this.sx.u(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.sx.u(false, String.valueOf(i2), (this.ja - iKj) + "s后可跳过", false, false);
            }
        }
        this.u.fx(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        this.sx.u(4);
        this.bq.nr();
        this.u.sx();
        if (bg.t(this.nr)) {
            this.sx.nr(true);
        }
        this.rh = q.pn(this.nr);
        this.ja = q.iz(this.nr);
        if (bg.b(this.nr)) {
            this.u.iz();
        }
    }

    public void ge() {
        int iGs = this.nr.gs();
        if (iGs == 0) {
            this.f5223a.pn(0);
            this.sx.pn(true);
            this.sx.nr(this.nr.uo());
        } else {
            if (iGs != 1) {
                if (iGs != 3) {
                    return;
                }
                this.sx.pn(false);
                this.sx.nr(false);
                this.sx.u(false, null, null, true, true);
                return;
            }
            this.f5223a.pn(0);
            this.sx.nr(this.nr.uo());
            if (bg.b(this.nr)) {
                this.sx.pn(bc.nr(this.nr));
            } else {
                this.sx.pn(com.bytedance.sdk.openadsdk.gi.t.u(this.nr));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View jk() {
        if (bg.b(this.nr)) {
            this.t = new RewardJointEndCardFrameLayout(this.u, this.nr);
        }
        return super.jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int jp() {
        if (bg.t(this.nr) || this.rh == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.rh * this.nr.na()) / 100.0f, 27.0f)) - kj());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void k() {
        super.k();
        com.bytedance.sdk.openadsdk.core.playable.nr.u().nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean kw() {
        return yd.o(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void n() {
        super.n();
        com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return bg.b(this.nr) && bc.nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void nr(boolean z) {
        super.nr(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean p() {
        return bg.b(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void s() {
        super.s();
        this.u.jp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int x(boolean z) {
        int i;
        if (bg.t(this.nr) || (i = this.rh) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - kj());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.sx.u(true);
        this.f5223a.iz(8);
        if (bg.u(this.nr)) {
            ge();
        } else {
            this.sx.pn(true);
            this.sx.nr(this.nr.uo());
        }
    }

    public static int nr(bc bcVar) {
        return bg.u(bcVar) ? 6 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public nr.u u(bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        if (this.dw.pn()) {
            return new nr.u(false, 0, "");
        }
        this.u.y();
        this.u.jp();
        com.bytedance.sdk.openadsdk.core.component.reward.fx.n nVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.n(this.u, bcVar);
        nVar.u(this.bq.dw());
        nVar.u(y());
        return nVar.nr(new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.x.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
                x.this.u.bc();
            }
        });
    }
}

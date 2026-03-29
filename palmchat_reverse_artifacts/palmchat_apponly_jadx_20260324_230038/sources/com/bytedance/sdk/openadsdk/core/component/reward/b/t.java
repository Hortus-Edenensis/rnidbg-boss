package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.y.q;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends u {
    private com.bytedance.sdk.openadsdk.core.s.x bf;
    int ja;
    int rh;

    public t(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = 0;
        this.ja = 0;
        com.bytedance.sdk.openadsdk.core.s.x xVar = new com.bytedance.sdk.openadsdk.core.s.x(bcVar);
        this.bf = xVar;
        xVar.u(true);
    }

    public static boolean u(bc bcVar) {
        return bcVar.rh() == 1 && bg.u(bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        FrameLayout frameLayout = new FrameLayout(this.u);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean bf() {
        if (m() > 0) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr)) {
            return true;
        }
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).u(0);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void c() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).fx()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).u(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        int iKj = kj();
        int iMax = Math.max(0, this.rh - iKj);
        if (!this.bq.pb()) {
            int i = this.rh;
            if (iKj >= i) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.jk.fx(this.nr)) {
                    com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar = this.sx;
                    boolean z = this.s;
                    pnVar.u(z, z ? "领取成功" : "", null, true, true);
                } else {
                    this.sx.u(false, null, null, true, true);
                }
                this.u.l();
            } else if (this.ja >= i) {
                this.sx.u(false, String.valueOf(iMax), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.jk.fx(this.nr)) {
                com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar2 = this.sx;
                boolean z2 = this.s;
                StringBuilder sb = new StringBuilder();
                sb.append(iMax);
                sb.append("s");
                sb.append(this.s ? "后可领取奖励" : "");
                pnVar2.u(z2, sb.toString(), null, this.ja <= iKj, true);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
                if (iKj >= this.ja) {
                    this.sx.u(false, null, null, true, true);
                }
            } else if (iKj >= this.ja) {
                this.sx.u(false, String.valueOf(iMax), "跳过", false, true);
            } else {
                this.sx.u(false, String.valueOf(iMax), (this.ja - iKj) + "s后可跳过", false, false);
            }
        }
        this.u.fx(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).u(iMax);
        }
        if (iMax == 0) {
            com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
            if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.u) {
                ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) nrVar).x();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void fx(boolean z) {
        super.fx(z);
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.u) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) nrVar).iz()) {
                this.bf.u(((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).pn().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int jp() {
        if ((this.bq.pb() && bg.u(this.nr)) || this.rh == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            return Math.max(this.rh - kj(), 0);
        }
        return Math.max(((int) Math.min((this.rh * this.nr.na()) / 100.0f, 27.0f)) - kj(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void k() {
        super.k();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if ((nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.u) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) nrVar).iz()) {
            this.bf.b();
        }
        this.f5223a.jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void n() {
        JSONObject jSONObjectFx;
        super.n();
        com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.nr);
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf = this.nr.bf();
            this.rh = 30;
            if (uVarBf != null && (jSONObjectFx = uVarBf.fx()) != null) {
                this.rh = jSONObjectFx.optInt("reward_time", 30);
            }
        } else {
            this.rh = q.pn(this.nr);
        }
        this.ja = q.iz(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void nr(boolean z) {
        super.nr(z);
        this.bf.fx();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.u) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) nrVar).a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void pn(boolean z) {
        super.pn(z);
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).nr(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void s() {
        super.s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int x(boolean z) {
        if ((this.bq.pb() && bg.u(this.nr)) || this.rh == 0) {
            return 0;
        }
        return (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) ? Math.max(this.rh - kj(), 0) : Math.max(Math.min(this.rh, 27) - kj(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.f5223a.pn(0);
        this.sx.u(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            this.sx.pn(true);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            this.sx.nr(false);
        } else {
            this.sx.nr(this.nr.uo());
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.jk.fx(this.nr)) {
            this.sx.pn(false);
            this.sx.u(false, null, null, true, true);
            return;
        }
        this.sx.fx(true);
        this.sx.pn(true);
        com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar = this.sx;
        boolean z = this.s;
        StringBuilder sb = new StringBuilder();
        sb.append(m());
        sb.append("s");
        sb.append(this.s ? "后可领取奖励" : "");
        pnVar.u(z, sb.toString(), null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.u(this.u, this.nr, z, this.bf, this.sx);
        this.f5223a = uVar;
        return uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public nr.u u(final bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        this.u.y();
        this.u.jp();
        com.bytedance.sdk.openadsdk.core.component.reward.fx.n nVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.n(this.u, bcVar);
        nVar.u(this.bq.dw());
        nVar.u(y());
        return nVar.nr(new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.t.1
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
                if (com.bytedance.sdk.openadsdk.core.ugeno.jk.b(bcVar) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) t.this.f5223a).b()) {
                    return;
                }
                t.this.u.bc();
            }
        });
    }

    public static int nr(bc bcVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.jk.fx(bcVar) ? 6 : 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        this.sx.u(4);
        this.f5223a.fx(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.nr) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.u) this.f5223a).u(Math.max(0, this.rh - kj()));
        }
        this.u.nr(true, true);
    }
}

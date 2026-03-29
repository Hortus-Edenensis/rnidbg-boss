package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.mh;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.xg;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.qq;
import com.qiniu.android.collect.ReportItem;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends u {
    private boolean bf;
    protected final AtomicBoolean ja;
    private com.bytedance.sdk.openadsdk.core.nr.u pb;
    protected boolean rh;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.nr wq;

    public iz(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = false;
        this.ja = new AtomicBoolean(false);
    }

    private void b(int i) {
        com.bytedance.sdk.openadsdk.core.nr.pn pnVar = this.n;
        if (pnVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(i);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar2 = this.q;
        if (pnVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(i);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.iz izVar = this.c;
        if (izVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(i);
        }
    }

    private void ju() {
        com.bytedance.sdk.openadsdk.core.nr.pn pnVar;
        if (this.rh || (pnVar = this.n) == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).nr().t()) {
            this.rh = true;
            nr(8, 0);
            return;
        }
        if (su.u(this.nr)) {
            int iPn = su.pn(this.nr);
            if (this.nr.sv() == 2) {
                nr(0, -1);
            }
            if (iPn != 3) {
                return;
            }
            long jX = ((long) su.x(this.nr)) * 1000;
            if (this.bg.rh() < jX) {
                nr(0, (int) ((jX - this.bg.rh()) / 1000));
                return;
            }
            nr(8, 0);
            zx();
            this.rh = true;
        }
    }

    public static int nr(bc bcVar) {
        return 2;
    }

    private JSONObject ob() {
        JSONObject jSONObject = new JSONObject();
        xg xgVarMd = this.nr.md();
        if (xgVarMd == null) {
            return jSONObject;
        }
        String strB = xgVarMd.b();
        if (TextUtils.isEmpty(strB)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strB).optString("token");
            jSONObject.put(ReportItem.RequestKeyRequestId, xgVarMd.iz());
            jSONObject.put("token", strOptString);
            jSONObject.put("action", "query_box");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void zx() {
        if (this.n == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
        this.n.u(null, new com.bytedance.sdk.openadsdk.core.kj.jk());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        return this.b != 100.0f ? com.bytedance.sdk.openadsdk.res.pn.q(this.u) : this.fx == 2 ? com.bytedance.sdk.openadsdk.res.pn.k(this.u) : com.bytedance.sdk.openadsdk.res.pn.my(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void bq() {
        super.bq();
        ge();
        if (this.jk.iz()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.live.nr.u().nr(this.nr)) {
            ju();
            return;
        }
        if (su.u(this.nr) && this.wq == null && !com.bytedance.sdk.openadsdk.core.nr.u().get("is_reward_deep_link_to_live", false) && su.pn(this.nr) != 1 && this.bg.rh() >= ((long) su.x(this.nr)) * 1000) {
            this.ja.set(true);
            com.bytedance.sdk.openadsdk.core.component.reward.nr.iz izVar = this.bg;
            if (izVar != null && izVar.nr()) {
                this.u.y();
            }
            this.wq = new com.bytedance.sdk.openadsdk.core.component.reward.view.nr(this.u, this.nr, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.iz.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.nr.u
                public void nr(Dialog dialog) {
                    if (iz.this.pb != null) {
                        HashMap map = new HashMap();
                        map.put("is_auto_click", Boolean.TRUE);
                        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) iz.this.pb.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
                        iz.this.pb.u(null, new com.bytedance.sdk.openadsdk.core.kj.jk());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.nr.u
                public void u(Dialog dialog) {
                    iz.this.wq.dismiss();
                    iz.this.u.bc();
                    iz.this.ja.set(false);
                }
            });
            com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.u, this.nr, this.l, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.iz.3
                @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
                public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
                    super.u(view, jkVar);
                    iz.this.wq.dismiss();
                }
            };
            this.pb = uVar;
            this.u.u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
            this.wq.u(this.pb);
            if (this.u.isFinishing()) {
                return;
            }
            this.wq.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return lf() && tk.u(this.nr) == 1;
    }

    public void ge() {
        if (su.u(this.nr)) {
            xg xgVarMd = this.nr.md();
            if (xgVarMd != null || com.bytedance.sdk.openadsdk.core.live.nr.u().nr(this.nr)) {
                int iM = m();
                if (xgVarMd != null) {
                    xgVarMd.u(iM);
                }
                b(iM);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean ja() {
        return this.ja.get();
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
        this.f5223a.fx(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return yd.fx(this.nr, x());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean o() {
        if (this.bf) {
            return true;
        }
        return (com.bytedance.sdk.openadsdk.core.live.nr.u().nr(this.nr) || su.fx(this.nr)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        if (iz()) {
            this.sx.nr(false);
            this.sx.pn(false);
            this.f5223a.iz(8);
            this.f5223a.pn(8);
            this.f5223a.fx(8);
        } else {
            this.sx.nr(this.nr.uo());
            this.sx.pn(true);
            this.f5223a.iz(0);
            this.f5223a.pn(0);
            this.f5223a.fx(0);
        }
        this.u.w();
    }

    public static boolean u(bc bcVar) {
        return com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void nr(boolean z) {
        super.nr(z);
        if (!com.bytedance.sdk.openadsdk.core.nr.u().get("is_reward_deep_link_to_live", false) || su.fx(this.nr) || z) {
            return;
        }
        dw.u().u(ob(), new qq.b() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.iz.1
            @Override // com.bytedance.sdk.openadsdk.core.qq.b
            public void u(int i, String str) {
                iz.this.a(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.b
            public void u(kj.fx fxVar) {
                mh mhVar = fxVar.fx;
                if (mhVar == null) {
                    return;
                }
                boolean zU = mhVar.u();
                iz.this.a(zU);
                if (zU) {
                    iz.this.u.b(0);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        if (this.b != 100.0f) {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.x(this.u, this.nr, z);
        } else {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.n(this.u, this.nr, z);
        }
        return this.f5223a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
            if (pnVar != null) {
                pnVar.u("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(int i, int i2, Intent intent) {
        super.u(i, i2, intent);
        if (su.fx(this.nr) || i != 1 || intent == null || intent.getExtras() == null || this.bf) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iM = (int) (((long) m()) - j);
        this.u.u(iM, false);
        if (j <= 0) {
            a(true);
            b(0);
            this.bf = true;
            return;
        }
        u(iM);
    }

    private void nr(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar != null && (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.n)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.n) nrVar).u(i, i2);
        }
    }

    private void u(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
            if (pnVar == null || !pnVar.iz()) {
                return;
            }
            this.jk.u("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException unused) {
        }
    }
}

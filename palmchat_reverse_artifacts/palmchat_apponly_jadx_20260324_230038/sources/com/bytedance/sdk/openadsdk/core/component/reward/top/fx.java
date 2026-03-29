package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.qq.s;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx implements nr {
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.nr b;
    protected bc fx;
    protected TTBaseVideoActivity iz;
    protected bc nr;
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pn;
    protected boolean u;
    protected int x = 0;

    public fx(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar, boolean z) {
        this.iz = tTBaseVideoActivity;
        this.nr = bcVar;
        this.b = nrVar;
        this.pn = pnVar;
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void b(View view) {
        u(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void fx(View view) {
        u(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void iz(View view) {
        u(6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void nr(View view) {
        u(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void pn(View view) {
        u(5);
        this.iz.n(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void u(View view) {
        u(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.nr
    public void x(View view) {
        u(7);
    }

    public boolean u() {
        if (bg.t(this.nr) || yd.nr() <= 0) {
            return false;
        }
        int i = this.x;
        this.x = i + 1;
        if (i < yd.nr()) {
            return false;
        }
        s.u().u(this.nr, "stats_reward_full_close_force", this.iz.mh().u(new JSONObject()));
        this.iz.finish();
        return true;
    }

    public void u(int i) {
        this.iz.lf();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        s.u().u(this.nr, "stats_reward_full_top_handle", jSONObject);
    }

    public void u(bc bcVar) {
        this.fx = bcVar;
    }

    public boolean u(jk jkVar) {
        bc bcVar = this.fx;
        if (bcVar != null) {
            return this.iz.u(bcVar, jkVar);
        }
        return this.iz.u(this.nr, jkVar);
    }
}

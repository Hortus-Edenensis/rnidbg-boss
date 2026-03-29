package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.dc;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private boolean b = false;
    private String fx;
    private com.bytedance.sdk.openadsdk.core.s.pn iz;
    private bc nr;
    private View pn;
    private final TTBaseVideoActivity u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements com.bytedance.sdk.openadsdk.iz.u.u {
        private final JSONObject fx;
        private final long nr;
        private final int u;

        public u(int i, long j, JSONObject jSONObject) {
            this.u = i;
            this.nr = j;
            this.fx = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.iz.u.u
        public void u(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.fx;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.u);
            jSONObject2.put("duration", this.nr);
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        }
    }

    public fx(TTBaseVideoActivity tTBaseVideoActivity) {
        this.u = tTBaseVideoActivity;
    }

    private boolean iz() {
        bc bcVar = this.nr;
        return bcVar == null || bq.t(bcVar) != 1;
    }

    public JSONObject b() {
        try {
            long jS = this.u.su().s();
            int iK = this.u.su().k();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jS);
                jSONObject.put("percent", iK);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void fx() {
        final JSONObject jSONObjectU = u(new JSONObject());
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.fx.3
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObjectU, fx.this.nr);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectU);
            }
        });
    }

    public void nr() {
        final JSONObject jSONObjectU = u(new JSONObject());
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, "skip_endcard", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.fx.2
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObjectU, fx.this.nr);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectU);
            }
        });
    }

    public com.bytedance.sdk.openadsdk.core.s.pn pn() {
        if (this.iz == null) {
            this.iz = new com.bytedance.sdk.openadsdk.core.s.pn(this.nr, this.fx);
        }
        return this.iz;
    }

    public void u(bc bcVar, String str, View view) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.nr = bcVar;
        this.fx = str;
        this.pn = view;
    }

    private void fx(View view, jk jkVar) {
        if (iz() || this.nr == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int iN = y.n(dw.getContext());
            com.bytedance.sdk.openadsdk.core.s.b.u("click_other", this.nr, new a.u().iz(jkVar.my()).pn(jkVar.o()).b(jkVar.sx()).fx(jkVar.bg()).nr(System.currentTimeMillis()).u(0L).nr(y.u(this.pn)).u(y.u((View) null)).fx(y.fx(this.pn)).b(y.fx((View) null)).fx(jkVar.b()).b(jkVar.pn()).pn(jkVar.iz()).u(jkVar.l()).nr(n.o().fx() ? 1 : 2).u(iN).u(y.iz(dw.getContext())).nr(y.x(dw.getContext())).u(), this.fx, true, this.u.xw(), -1, false, jkVar.u());
        }
    }

    private void nr(View view, jk jkVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            u("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            u("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            u("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            u("click_play_logo", (JSONObject) null);
        } else if (view.getId() != 2114387649 && view.getId() != 2114387925 && view.getId() != 2114387964) {
            if (view.getId() == 2114387642) {
                u("click_video", b());
            } else if (view.getId() == 2114387864) {
                u("fallback_endcard_click", b());
            }
        } else {
            u("click_start_play_bar", b());
        }
        fx(view, jkVar);
    }

    public JSONObject u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.u.yd() != null) {
                jSONObject.put("reward_full_scene_type", this.u.yd().rh());
                this.u.yd().u(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void u(Map<String, Object> map) {
        if (map == null || this.u.yd() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.u.yd().rh()));
        this.u.yd().u(map);
    }

    public void u() {
        final JSONObject jSONObjectU = u(new JSONObject());
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, dc.F, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.fx.1
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObjectU, fx.this.nr);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectU);
            }
        });
    }

    public void u(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z);
            jSONObject2.put("isServerCallback", z2);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i);
            jSONObject2.put("errorCode", i2);
            jSONObject2.put(MediationConstant.KEY_ERROR_MSG, string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e) {
            k.nr("RewardFullEventManager", e.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, str, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.fx.4
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject3) throws JSONException {
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, fx.this.nr);
                jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, fx.this.u(jSONObject));
            }
        });
    }

    public void u(String str, int i, String str2) {
        final JSONObject jSONObjectU = u(new JSONObject());
        try {
            jSONObjectU.put("dialog_type", i);
            jSONObjectU.put("template_url", str2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, str, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.fx.5
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObjectU, fx.this.nr);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, fx.this.u(jSONObjectU));
            }
        });
    }

    public void u(boolean z, int i, long j) {
        new u.C0284u().pn(this.nr.lk()).u(this.fx).nr(z ? "scroll_up" : "scroll_down").b(this.nr.ap()).u(new u(i, j, u(new JSONObject())));
    }

    public void u(View view, jk jkVar) {
        try {
            nr(view, jkVar);
        } catch (Exception e) {
            k.nr("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    public void u(String str, JSONObject jSONObject) {
        bc bcVar = this.nr;
        String str2 = this.fx;
        if (!this.u.kj()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, str2, str, jSONObject);
    }
}

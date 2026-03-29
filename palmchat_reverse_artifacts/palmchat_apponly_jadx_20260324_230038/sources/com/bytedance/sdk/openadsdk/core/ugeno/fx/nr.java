package com.bytedance.sdk.openadsdk.core.ugeno.fx;

import android.content.Context;
import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.adsdk.ugeno.pn.fx.nr implements c {
    private qq t;

    public nr(Context context) {
        super(context);
        this.t = new qq(context, 2, n.o().pn(), dw.nr().jk());
    }

    private int a() {
        JSONObject jSONObjectU;
        com.bytedance.adsdk.ugeno.nr.fx fxVar = this.nr;
        if (fxVar == null) {
            return 0;
        }
        JSONObject jSONObjectJk = fxVar.jk();
        if (jSONObjectJk != null) {
            return jSONObjectJk.optInt("meta_hashcode", 0);
        }
        s sVarXg = this.nr.xg();
        if (sVarXg == null || (jSONObjectU = sVarXg.u()) == null) {
            return 0;
        }
        return jSONObjectU.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void fx() {
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void nr() {
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u() {
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void b() {
        if (this.t == null || !this.nr.a().isShown()) {
            return;
        }
        this.t.u(a());
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void pn() {
        qq qqVar = this.t;
        if (qqVar != null) {
            qqVar.nr(a());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(com.bytedance.adsdk.ugeno.fx.dw dwVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        this.nr.u(this);
        if (this.t == null) {
            this.t = new qq(this.jk, 2, n.o().pn(), dw.nr().jk());
        }
        s sVarXg = this.nr.xg();
        if (sVarXg == null) {
            return false;
        }
        Map<String, Object> mapNr = sVarXg.nr();
        if (mapNr != null) {
            Object obj = mapNr.get("rotation_angle");
            if (obj instanceof Integer) {
                this.t.nr(((Integer) obj).floatValue());
            }
            Object obj2 = mapNr.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.t.iz(((Integer) obj2).intValue());
            }
            Object obj3 = mapNr.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.t.u((JSONObject) obj3);
            }
            Object obj4 = mapNr.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.t.nr((JSONObject) obj4);
            }
        }
        this.t.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fx.nr.1
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i) {
                if (((com.bytedance.adsdk.ugeno.pn.fx.nr) nr.this).u == null || i != 2) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.pn.fx.nr) nr.this).u.u(((com.bytedance.adsdk.ugeno.pn.fx.nr) nr.this).nr, ((com.bytedance.adsdk.ugeno.pn.fx.nr) nr.this).iz, ((com.bytedance.adsdk.ugeno.pn.fx.nr) nr.this).fx.nr());
            }
        });
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(boolean z) {
        qq qqVar = this.t;
        if (qqVar != null) {
            if (z) {
                qqVar.u(a());
            } else {
                qqVar.nr(a());
            }
        }
    }
}

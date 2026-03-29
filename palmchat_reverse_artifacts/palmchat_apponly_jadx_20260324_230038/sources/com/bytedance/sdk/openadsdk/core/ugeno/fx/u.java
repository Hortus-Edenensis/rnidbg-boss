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
public class u extends com.bytedance.adsdk.ugeno.pn.fx.nr implements c {
    private qq t;

    public u(Context context) {
        super(context);
        this.t = new qq(context, 1, n.o().pn(), dw.nr().jk());
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
        this.t.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fx.u.1
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i) {
                if (((com.bytedance.adsdk.ugeno.pn.fx.nr) u.this).u == null || i != 1) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.pn.fx.nr) u.this).u.u(((com.bytedance.adsdk.ugeno.pn.fx.nr) u.this).nr, ((com.bytedance.adsdk.ugeno.pn.fx.nr) u.this).iz, ((com.bytedance.adsdk.ugeno.pn.fx.nr) u.this).fx.nr());
            }
        });
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
        Map<String, Object> mapNr;
        this.nr.u(this);
        if (this.t == null) {
            this.t = new qq(this.jk, 1, n.o().pn(), dw.nr().jk());
        }
        s sVarXg = this.nr.xg();
        if (sVarXg == null || (mapNr = sVarXg.nr()) == null) {
            return false;
        }
        Object obj = mapNr.get("shake_value");
        if (obj instanceof Integer) {
            this.t.u(((Integer) obj).floatValue());
        }
        Object obj2 = mapNr.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.t.pn(((Integer) obj2).intValue());
        }
        Object obj3 = mapNr.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.t.fx((JSONObject) obj3);
        }
        Object obj4 = mapNr.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.t.nr(((Integer) obj4).floatValue());
        }
        Object obj5 = mapNr.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.t.u((JSONObject) obj5);
        }
        Object obj6 = mapNr.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.t.nr((JSONObject) obj6);
        }
        Object obj7 = mapNr.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.t.iz(((Integer) obj7).intValue());
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

package com.bytedance.sdk.openadsdk.core.ugeno;

import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.sdk.component.t.u.nr;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends com.bytedance.adsdk.ugeno.fx.u.nr {
    private volatile u iz;

    /* JADX INFO: compiled from: SearchBox */
    public class u implements com.bytedance.sdk.component.t.b.nr {
        private sx.nr b;
        private my fx;
        sx.u u;

        public u() {
        }

        public void u(my myVar) {
            this.fx = myVar;
        }

        public void u(sx.nr nrVar) {
            this.b = nrVar;
        }

        public void u(sx.u uVar) {
            this.u = uVar;
        }

        @Override // com.bytedance.sdk.component.t.b.nr
        public void u() {
            a.this.nr(this.fx, this.b, this.u);
        }
    }

    public a(sx sxVar) {
        super(sxVar);
    }

    private u nr() {
        if (this.iz != null) {
            return this.iz;
        }
        synchronized (u.class) {
            if (this.iz != null) {
                return this.iz;
            }
            this.iz = new u();
            return this.iz;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.u.nr
    public void fx(my myVar, sx.nr nrVar, sx.u uVar) {
        if (this.iz == null) {
            this.iz = nr();
        }
        this.iz.u(myVar);
        this.iz.u(nrVar);
        this.iz.u(uVar);
        JSONObject jSONObjectFx = myVar.fx();
        if (jSONObjectFx == null) {
            return;
        }
        new nr.u(jSONObjectFx.optString("type")).nr(this.b).u(new com.bytedance.sdk.component.t.b.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.1
            @Override // com.bytedance.sdk.component.t.b.fx
            public void u(com.bytedance.sdk.component.t.u.u uVar2) {
                a.this.u(uVar2);
            }
        }).u().u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.t.u.u uVar) {
        if (this.pn) {
            return;
        }
        u uVarNr = nr();
        uVarNr.u(u(uVarNr.fx, uVar));
        uVar.u(uVarNr);
    }

    public my u(my myVar, com.bytedance.sdk.component.t.u.u uVar) {
        com.bytedance.sdk.component.t.fx.u uVar2;
        if (myVar == null || uVar == null) {
            return myVar;
        }
        my myVar2 = new my();
        com.bytedance.adsdk.ugeno.nr.fx fxVarU = myVar.u();
        if (fxVarU == null) {
            return myVar;
        }
        myVar2.u(myVar.nr());
        com.bytedance.sdk.component.t.fx.u uVarX = uVar.x();
        JSONObject jSONObjectU = u(fxVarU, myVar2, uVarX);
        com.bytedance.sdk.component.t.fx.fx fxVarU2 = com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(uVar.b());
        List<com.bytedance.sdk.component.t.fx.u> listU = fxVarU2.u(uVarX, fxVarU.jk(), new HashMap());
        myVar2.u(jSONObjectU);
        if (!listU.isEmpty()) {
            com.bytedance.sdk.component.t.fx.u uVar3 = listU.get(0);
            if (uVar3 == null) {
                return myVar2;
            }
            my myVar3 = new my();
            myVar3.u(u(fxVarU, myVar3, uVar3));
            myVar3.u(fxVarU);
            myVar2.u(myVar3);
        }
        List<com.bytedance.sdk.component.t.fx.u> listNr = fxVarU2.nr(uVarX, fxVarU.jk(), new HashMap());
        if (listNr.isEmpty() || (uVar2 = listNr.get(0)) == null) {
            return myVar2;
        }
        my myVar4 = new my();
        myVar4.u(u(fxVarU, myVar4, uVar2));
        myVar4.u(fxVarU);
        myVar2.nr(myVar4);
        return myVar2;
    }

    private JSONObject u(com.bytedance.adsdk.ugeno.nr.fx fxVar, my myVar, com.bytedance.sdk.component.t.fx.u uVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (uVar == null) {
                return jSONObject;
            }
            Map<String, String> mapFx = uVar.fx();
            String strU = uVar.u();
            myVar.u(fxVar);
            jSONObject.put("type", strU);
            if (mapFx != null && !mapFx.isEmpty()) {
                for (Map.Entry<String, String> entry : mapFx.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}

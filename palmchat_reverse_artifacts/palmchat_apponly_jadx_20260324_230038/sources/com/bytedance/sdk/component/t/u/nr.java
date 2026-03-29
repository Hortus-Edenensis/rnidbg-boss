package com.bytedance.sdk.component.t.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.t.b.b;
import com.bytedance.sdk.component.t.b.fx;
import com.bytedance.sdk.component.t.b.pn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements b {
    private fx b;
    private Map<String, Object> fx;
    private int iz;
    private JSONObject nr;
    private com.bytedance.sdk.component.t.u.u pn;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private JSONObject b;
        private StringBuilder fx;
        private fx iz;
        private String nr;
        private Map<String, Object> pn;
        private int u = 1;
        private JSONObject x;

        public u(String str) {
            this.nr = str;
        }

        public u nr(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public u u(JSONObject jSONObject) {
            this.b = jSONObject;
            return this;
        }

        public u u(Map<String, Object> map) {
            this.pn = map;
            return this;
        }

        public u u(fx fxVar) {
            this.iz = fxVar;
            return this;
        }

        public nr u() {
            return new nr(this);
        }
    }

    @Override // com.bytedance.sdk.component.t.b.b
    public pn nr() {
        return new pn() { // from class: com.bytedance.sdk.component.t.u.nr.1
            @Override // com.bytedance.sdk.component.t.b.pn
            public void nr(com.bytedance.sdk.component.t.u.u uVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.t.fx.u> it = com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(nr.this.u).nr(uVar.x(), uVar.fx(), map).iterator();
                while (it.hasNext()) {
                    nr.this.u(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.t.b.pn
            public void u(com.bytedance.sdk.component.t.u.u uVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.t.fx.u> it = com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(nr.this.u).u(uVar.x(), uVar.fx(), map).iterator();
                while (it.hasNext()) {
                    nr.this.u(it.next(), map);
                }
            }
        };
    }

    private nr(u uVar) {
        this.iz = 1;
        this.iz = uVar.u;
        if (uVar.u == 2) {
            this.pn = new com.bytedance.sdk.component.t.u.u(uVar.fx, uVar.b, (Map<String, Object>) uVar.pn);
            this.iz = 2;
        } else {
            this.u = uVar.nr;
            if (uVar.x != null) {
                com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(uVar.x);
            }
        }
        this.nr = uVar.b;
        this.fx = uVar.pn;
        this.b = uVar.iz;
    }

    public void u() {
        com.bytedance.sdk.component.t.fx.fx fxVarU;
        if (this.iz == 2) {
            fx fxVar = this.b;
            if (fxVar != null) {
                fxVar.u(this.pn);
            }
            this.pn.iz();
            return;
        }
        if (TextUtils.isEmpty(this.u) || (fxVarU = com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(this.u)) == null) {
            return;
        }
        u(fxVarU.u(), this.fx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.t.fx.u uVar, Map<String, Object> map) {
        if (uVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.t.u.u uVar2 = new com.bytedance.sdk.component.t.u.u(uVar, this.nr, map);
        uVar2.u(this.u);
        uVar2.u(this);
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(uVar2);
        }
        uVar2.iz();
        for (com.bytedance.sdk.component.t.fx.u uVar3 : com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(this.u).fx(uVar, uVar2.fx(), map)) {
            if (uVar3 != null) {
                u(uVar3, map);
            }
        }
    }
}

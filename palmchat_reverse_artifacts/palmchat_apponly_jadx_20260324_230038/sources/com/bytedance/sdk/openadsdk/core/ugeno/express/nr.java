package com.bytedance.sdk.openadsdk.core.ugeno.express;

import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.sdk.component.adexpress.nr.mv;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends mv {
    private float b;
    private float fx;
    private c nr;
    private boolean pn;
    private JSONObject u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends mv.u {
        private float b;
        private float fx;
        private c nr;
        private boolean pn;
        private JSONObject u;

        public u nr(float f) {
            this.b = f;
            return this;
        }

        public u pn(JSONObject jSONObject) {
            this.u = jSONObject;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.nr.mv.u
        /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
        public nr u() {
            return new nr(this);
        }

        public u pn(boolean z) {
            this.pn = z;
            return this;
        }

        public u u(c cVar) {
            this.nr = cVar;
            return this;
        }

        public u u(float f) {
            this.fx = f;
            return this;
        }
    }

    public nr(u uVar) {
        super(uVar);
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
    }

    public float bf() {
        return this.b;
    }

    public float ja() {
        return this.fx;
    }

    public c pb() {
        return this.nr;
    }

    public JSONObject wq() {
        return this.u;
    }

    public boolean xg() {
        return this.pn;
    }
}

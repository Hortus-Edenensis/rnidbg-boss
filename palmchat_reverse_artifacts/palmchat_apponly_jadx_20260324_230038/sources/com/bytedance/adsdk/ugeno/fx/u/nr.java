package com.bytedance.adsdk.ugeno.fx.u;

import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.pn.iz;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class nr implements sx {
    protected JSONObject b;
    protected String nr;
    protected sx u;
    protected boolean fx = true;
    protected boolean pn = false;

    public nr(sx sxVar) {
        this.u = sxVar;
    }

    public abstract void fx(my myVar, sx.nr nrVar, sx.u uVar);

    public void nr(boolean z) {
        this.pn = z;
    }

    public void u(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void nr(my myVar, sx.nr nrVar, sx.u uVar) {
        sx sxVar = this.u;
        if (sxVar == null) {
            return;
        }
        sxVar.u(myVar, nrVar, uVar);
    }

    public void u(String str) {
        this.nr = str;
    }

    public void u(boolean z) {
        this.fx = z;
    }

    public boolean u() {
        String str;
        return this.fx && (str = this.nr) != null && "3".compareTo(str) <= 0 && this.b != null;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        if (u()) {
            fx(myVar, nrVar, uVar);
        } else {
            nr(myVar, nrVar, uVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(fx fxVar, String str, iz.u uVar) {
        sx sxVar = this.u;
        if (sxVar == null) {
            return;
        }
        sxVar.u(fxVar, str, uVar);
    }
}

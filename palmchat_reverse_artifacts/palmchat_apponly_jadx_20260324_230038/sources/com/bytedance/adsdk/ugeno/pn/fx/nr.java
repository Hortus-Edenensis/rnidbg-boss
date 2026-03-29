package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.adsdk.ugeno.pn.jk;
import com.bytedance.adsdk.ugeno.pn.t;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f5038a;
    protected iz.u b;
    protected com.bytedance.adsdk.ugeno.pn.iz fx;
    protected String iz;
    protected Context jk;
    protected String n;
    protected com.bytedance.adsdk.ugeno.nr.fx nr;
    protected Map<String, String> pn;
    protected t u;
    protected String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public static nr u(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.pn.iz izVarU;
            iz.u uVarU;
            if (fxVar == null || jSONObject == null || (izVarU = com.bytedance.adsdk.ugeno.pn.iz.u(jSONObject, jSONObject2)) == null || (uVarU = izVarU.u()) == null) {
                return null;
            }
            String strU = uVarU.u();
            if (TextUtils.equals(strU, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                fx fxVar2 = new fx(context);
                fxVar2.u(fxVar);
                fxVar2.u(izVarU);
                fxVar2.iz();
                return fxVar2;
            }
            com.bytedance.adsdk.ugeno.pn.x xVarU = (TextUtils.isEmpty(strU) || TextUtils.equals(strU, "global")) ? jk.u(uVarU.nr()) : jk.u(uVarU.pn());
            if (xVarU == null) {
                return null;
            }
            nr nrVarU = xVarU.u(context);
            nrVarU.u(fxVar);
            nrVarU.u(izVarU);
            nrVarU.iz();
            return nrVarU;
        }
    }

    public nr(Context context) {
        this.jk = context;
    }

    public void iz() {
        this.b = this.fx.u();
        com.bytedance.adsdk.ugeno.pn.iz izVar = this.fx;
        if (izVar == null) {
            return;
        }
        iz.u uVarU = izVar.u();
        this.b = uVarU;
        if (uVarU == null) {
            return;
        }
        this.pn = uVarU.fx();
        this.iz = this.b.nr();
        this.x = this.b.u();
        this.n = this.b.b();
        this.f5038a = this.b.pn();
    }

    public String n() {
        return this.n;
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.nr = fxVar;
    }

    public abstract boolean u(Object... objArr);

    public String x() {
        return this.iz;
    }

    public void u(com.bytedance.adsdk.ugeno.pn.iz izVar) {
        this.fx = izVar;
    }

    public void u(t tVar) {
        this.u = tVar;
    }
}

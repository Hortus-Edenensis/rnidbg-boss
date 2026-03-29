package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv extends u {
    u o;

    public mv(Activity activity, bc bcVar) {
        super(activity, bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(jk jkVar) {
        ArrayList<ob> arrayListBq = yd.bq(this.x);
        if (arrayListBq == null) {
            return new nr.u(false, 0, "");
        }
        for (ob obVar : arrayListBq) {
            switch (obVar.fx()) {
                case 1:
                    this.o = new l(this.n, this.x, obVar);
                    break;
                case 2:
                    this.o = new t(this.n, this.x, obVar);
                    break;
                case 3:
                    this.o = new iz(this.n, this.x, obVar);
                    break;
                case 4:
                    this.o = new x(this.n, this.x, obVar);
                    break;
                case 5:
                    this.o = new a(this.n, this.x, obVar);
                    break;
                case 6:
                    this.o = new b(this.n, this.x, obVar);
                    break;
            }
            u uVar = this.o;
            if (uVar != null) {
                uVar.u(this.fx);
                this.o.u(this.u);
                this.o.nr(this.nr);
                this.o.nr(this.b);
                this.o.fx(this.l);
                this.o.b(this.t);
                this.o.fx(this.iz);
                this.o.b(this.pn);
                this.o.u(this.my);
                this.o.nr(a());
                nr.u uVarNr = this.o.nr(jkVar);
                if (uVarNr.fx()) {
                    return uVarNr;
                }
            }
        }
        return new nr.u(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        u uVar = this.o;
        if (uVar == null) {
            return null;
        }
        String strU = uVar.u();
        try {
            JSONObject jSONObject = new JSONObject(strU);
            jSONObject.put("is_need_click", this.pn);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return strU;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void nr(String str) {
        super.nr(str);
        u uVar = this.o;
        if (uVar == null) {
            return;
        }
        uVar.nr(str);
    }
}

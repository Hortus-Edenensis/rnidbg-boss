package com.bytedance.adsdk.ugeno.fx.nr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.fx.mv;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.iz.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr implements a.u {
    private my b;
    private Context fx;
    private Handler iz = new a(Looper.getMainLooper(), this);
    private sx nr;
    private com.bytedance.adsdk.ugeno.nr.fx pn;
    private int u;

    public nr(Context context, my myVar, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.fx = context;
        this.b = myVar;
        this.pn = fxVar;
    }

    public void u(sx sxVar) {
        this.nr = sxVar;
    }

    public void u() {
        my myVar = this.b;
        if (myVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.bytedance.adsdk.ugeno.b.nr.u(myVar.fx().optString("delay"), this.pn.jk()));
            this.u = i;
            this.iz.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.iz.a.u
    public void u(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectFx = this.b.fx();
        if (TextUtils.equals(jSONObjectFx.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectFx.optString("nodeId");
            com.bytedance.adsdk.ugeno.nr.fx fxVar = this.pn;
            com.bytedance.adsdk.ugeno.nr.fx fxVarB = fxVar.nr(fxVar).b(strOptString);
            new mv(fxVarB.a(), com.bytedance.adsdk.ugeno.fx.u.u(jSONObjectFx.optJSONObject("animatorSet"), fxVarB)).u();
        } else {
            sx sxVar = this.nr;
            if (sxVar != null) {
                my myVar = this.b;
                com.bytedance.adsdk.ugeno.nr.fx fxVar2 = this.pn;
                sxVar.u(myVar, fxVar2, fxVar2);
            }
        }
        this.iz.removeMessages(1001);
    }
}

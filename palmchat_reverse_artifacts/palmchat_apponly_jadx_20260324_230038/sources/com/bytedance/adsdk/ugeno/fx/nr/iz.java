package com.bytedance.adsdk.ugeno.fx.nr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.iz.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz implements a.u {
    private Context b;
    private sx fx;
    private com.bytedance.adsdk.ugeno.nr.fx iz;
    private int nr;
    private my pn;
    private boolean u;
    private Handler x = new a(Looper.getMainLooper(), this);

    public iz(Context context, my myVar, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.b = context;
        this.pn = myVar;
        this.iz = fxVar;
    }

    public void u(sx sxVar) {
        this.fx = sxVar;
    }

    public void u() {
        my myVar = this.pn;
        if (myVar == null) {
            return;
        }
        JSONObject jSONObjectFx = myVar.fx();
        try {
            this.nr = Integer.parseInt(com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("interval", "8000"), this.iz.jk()));
            this.u = jSONObjectFx.optBoolean("repeat");
            this.x.sendEmptyMessageDelayed(1001, this.nr);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.iz.a.u
    public void u(Message message) {
        if (message.what != 1001) {
            return;
        }
        sx sxVar = this.fx;
        if (sxVar != null) {
            my myVar = this.pn;
            com.bytedance.adsdk.ugeno.nr.fx fxVar = this.iz;
            sxVar.u(myVar, fxVar, fxVar);
        }
        if (this.u) {
            this.x.sendEmptyMessageDelayed(1001, this.nr);
        } else {
            this.x.removeMessages(1001);
        }
    }
}

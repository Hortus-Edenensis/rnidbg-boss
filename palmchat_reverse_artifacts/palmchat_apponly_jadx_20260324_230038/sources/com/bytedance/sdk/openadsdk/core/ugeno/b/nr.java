package com.bytedance.sdk.openadsdk.core.ugeno.b;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.s.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements bq, sx {
    private u b;
    private com.bytedance.adsdk.ugeno.nr.fx<View> fx;
    private String iz;
    private x nr;
    private bq pn;
    private Context u;
    private int x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(my myVar);
    }

    public nr(Context context, x xVar, String str, int i) {
        this.u = context;
        this.nr = xVar;
        this.iz = str;
        this.x = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        k kVar = new k(this.u);
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(jSONObject);
        this.fx = fxVarU;
        if (fxVarU == null) {
            x xVar2 = this.nr;
            if (xVar2 != null) {
                xVar2.u(-1, "ugeno render fail");
            }
            if (xVar != null) {
                xVar.u(-1, "");
                return;
            }
            return;
        }
        kVar.u((bq) this);
        kVar.u((sx) this);
        kVar.nr(jSONObject2);
        this.nr.u(0L);
        if (xVar != null) {
            xVar.u(this.fx);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
    }

    public void u(u uVar) {
        this.b = uVar;
    }

    public void u(bq bqVar) {
        this.pn = bqVar;
    }

    public void u(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(jSONObject, jSONObject2, xVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.nr(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        u uVar2;
        if (myVar == null || myVar.nr() != 1 || (uVar2 = this.b) == null) {
            return;
        }
        uVar2.u(myVar);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.bq
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        bq bqVar = this.pn;
        if (bqVar != null) {
            bqVar.u(fxVar, motionEvent);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.widget.fx;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements sx {
    private fx.u fx;
    private com.bytedance.adsdk.ugeno.nr.fx<View> nr;
    private Context u;

    public n(Context context) {
        this.u = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        k kVar = new k(this.u);
        s sVar = new s();
        sVar.u(this.u);
        kVar.u("ugen_download_dialog", sVar);
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(jSONObject);
        this.nr = fxVarU;
        if (fxVarU != null) {
            kVar.u(this);
            kVar.nr(jSONObject2);
        }
        if (xVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.nr;
        if (fxVar == null) {
            xVar.u(-1, "UGenWidget is null");
        } else {
            xVar.u(fxVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
    }

    public void u(fx.u uVar) {
        this.fx = uVar;
    }

    public void u(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(jSONObject, jSONObject2, xVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.nr(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // com.bytedance.adsdk.ugeno.fx.sx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        JSONObject jSONObjectFx;
        if (myVar == null || this.fx == null) {
            return;
        }
        if (myVar.nr() != 1 || (jSONObjectFx = myVar.fx()) == null) {
        }
        String strOptString = jSONObjectFx.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.fx.nr(null);
                break;
            case "openAppFunctionDesc":
                this.fx.pn(null);
                break;
            case "closeDialog":
                this.fx.fx(null);
                break;
            case "downloadEvent":
                this.fx.u(null);
                break;
            case "openAppPolicy":
                this.fx.b(null);
                break;
        }
    }
}

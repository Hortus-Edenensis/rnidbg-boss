package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.sdk.component.adexpress.nr.n;
import com.bytedance.sdk.component.adexpress.nr.x;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.bg;
import com.bytedance.sdk.openadsdk.core.ugeno.express.iz;
import com.bytedance.sdk.openadsdk.core.ugeno.express.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.fx;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements rh.u {
    private x b;
    private final bc fx;
    private nr iz;
    private iz nr;
    private n pn;
    rh u = new rh(Looper.getMainLooper(), this);

    public u(bc bcVar) {
        this.fx = bcVar;
    }

    public void u(n nVar) {
        this.pn = nVar;
    }

    public void u(x xVar) {
        this.b = xVar;
    }

    public void u(nr nrVar) {
        this.iz = nrVar;
    }

    public void u(String str, String str2, final int i, final int i2, int i3) {
        if (i3 > 0) {
            this.u.sendEmptyMessageDelayed(1, i3);
        }
        jk.u(str, str2, new fx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.u.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u(String str3) {
                try {
                    u uVar = u.this;
                    uVar.u(uVar.fx, new JSONObject(str3), i, i2);
                } catch (Throwable unused) {
                    if (u.this.b != null) {
                        u.this.b.u(-1, "render fail");
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u() {
                if (u.this.b != null) {
                    u.this.b.u(-1, "request fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
        } catch (Throwable unused) {
        }
        nr.u uVar = new nr.u();
        uVar.u(com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(bcVar, jSONObject2, jSONObject, false, null));
        uVar.u((c) new bg());
        uVar.u(i);
        uVar.nr(0.0f);
        iz izVar = new iz(dw.getContext(), null, uVar.u(), null);
        this.nr = izVar;
        x xVar = this.b;
        if (xVar != null) {
            izVar.u(xVar);
        }
        n nVar = this.pn;
        if (nVar != null) {
            this.nr.u(nVar);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr nrVar = this.iz;
        if (nrVar != null) {
            this.nr.u(nrVar);
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        x xVar;
        if (message.what == 1 && (xVar = this.b) != null) {
            xVar.u(-2, "render timeout");
        }
    }
}

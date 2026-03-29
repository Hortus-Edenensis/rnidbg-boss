package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.fx.nr.b;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.dw;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements b.u {
    private com.bytedance.adsdk.ugeno.nr.fx nr;
    private qq u;

    public iz(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.u = new qq(context, 1, com.bytedance.sdk.openadsdk.core.n.o().pn(), dw.nr().jk());
        this.nr = fxVar;
    }

    private int fx() {
        JSONObject jSONObjectJk;
        com.bytedance.adsdk.ugeno.nr.fx fxVar = this.nr;
        if (fxVar == null || (jSONObjectJk = fxVar.jk()) == null) {
            return 0;
        }
        return jSONObjectJk.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.nr.b.u
    public void nr() {
        qq qqVar = this.u;
        if (qqVar != null) {
            qqVar.nr(fx());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.nr.b.u
    public void u() {
        qq qqVar = this.u;
        if (qqVar != null) {
            qqVar.u(fx());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.nr.b.u
    public void u(float f) {
        qq qqVar = this.u;
        if (qqVar != null) {
            qqVar.u(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.nr.b.u
    public void u(final b.nr nrVar) {
        qq qqVar = this.u;
        if (qqVar != null) {
            qqVar.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.iz.1
                @Override // com.bytedance.sdk.component.utils.qq.u
                public void u(int i) {
                    b.nr nrVar2 = nrVar;
                    if (nrVar2 != null) {
                        nrVar2.u(i);
                    }
                }
            });
        }
    }
}

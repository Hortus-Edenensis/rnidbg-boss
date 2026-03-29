package com.bytedance.sdk.openadsdk.core.ugeno.u;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.adsdk.ugeno.pn.nr.u {
    public u(fx fxVar, String str, iz.u uVar) {
        super(fxVar, str, uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void u() {
        fx fxVar;
        fx fxVarNr;
        int i;
        int i2;
        Map<String, String> map = this.iz;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.iz.get("id");
        if (TextUtils.isEmpty(str) || (fxVarNr = (fxVar = this.fx).nr(fxVar)) == null) {
            return;
        }
        fx fxVarB = fxVarNr.b(str);
        if (fxVarB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u uVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u) fxVarB;
            int i3 = 3;
            try {
                i = Integer.parseInt(this.iz.get("col"));
                try {
                    i3 = Integer.parseInt(this.iz.get("row"));
                    i2 = Integer.parseInt(this.iz.get("duration"));
                } catch (Exception unused) {
                    i2 = 600;
                }
            } catch (Exception unused2) {
                i = 4;
            }
            uVar.u(i, i3, i2);
        }
    }
}

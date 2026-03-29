package com.bytedance.adsdk.ugeno.pn.nr;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends u {
    public pn(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        super(fxVar, str, uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void u() {
        Map<String, String> map = this.iz;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.iz.get("id");
        if (TextUtils.isEmpty(str)) {
            u(this.fx);
            return;
        }
        com.bytedance.adsdk.ugeno.nr.fx fxVar = this.fx;
        com.bytedance.adsdk.ugeno.nr.fx fxVarNr = fxVar.nr(fxVar);
        if (fxVarNr == null) {
            return;
        }
        u(fxVarNr.b(str));
    }

    private void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        for (String str : this.iz.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                fxVar.u(str, this.iz.get(str));
            }
        }
        fxVar.u(this.iz.containsKey("width"), this.iz.containsKey("height"));
        fxVar.nr();
    }
}

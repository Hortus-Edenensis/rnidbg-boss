package com.bytedance.adsdk.ugeno.pn.nr;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends u {
    public b(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        super(fxVar, str, uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void u() {
        com.bytedance.adsdk.ugeno.nr.fx fxVar;
        com.bytedance.adsdk.ugeno.nr.fx fxVarNr;
        com.bytedance.adsdk.ugeno.u.u uVarJk;
        Map<String, String> map = this.iz;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.iz.get("name");
        if (TextUtils.isEmpty(str) || (fxVarNr = (fxVar = this.fx).nr(fxVar)) == null || (uVarJk = fxVarNr.iz(str).jk(str)) == null) {
            return;
        }
        uVarJk.nr();
        uVarJk.u(new com.bytedance.adsdk.ugeno.u.nr() { // from class: com.bytedance.adsdk.ugeno.pn.nr.b.1
            @Override // com.bytedance.adsdk.ugeno.u.nr
            public void nr() {
                b.this.fx();
            }

            @Override // com.bytedance.adsdk.ugeno.u.nr
            public void u() {
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void nr() {
    }
}

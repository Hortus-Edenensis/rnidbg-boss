package com.bytedance.sdk.openadsdk.core.bf.u;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.gi.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    /* JADX INFO: Access modifiers changed from: private */
    public qq u() {
        qq qqVar = new qq(dw.getContext(), 1, n.o().pn(), dw.nr().jk());
        boolean zU = qqVar.u(0);
        u(zU ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            qqVar.nr(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void u(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.bf.u.u().nr() > u(i)) {
            x.u(new a("reg_sensor") { // from class: com.bytedance.sdk.openadsdk.core.bf.u.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.u();
                }
            });
        }
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.core.kj.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    u nr;

    public b(Activity activity, bc bcVar) {
        super(activity, bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void nr(String str) {
        super.nr(str);
        u uVar = this.nr;
        if (uVar == null) {
            return;
        }
        uVar.nr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u u(jk jkVar) {
        ArrayList<ob> arrayListPn = w.pn(this.x);
        if (arrayListPn == null) {
            return new nr.u(false, 0, "");
        }
        for (ob obVar : arrayListPn) {
            if (obVar.fx() == 1) {
                this.nr = new fx(this.n, this.x, obVar);
            }
            u uVar = this.nr;
            if (uVar != null) {
                uVar.fx(this.l);
                this.nr.b(this.t);
                this.nr.u(this.u);
                this.nr.nr(a());
                this.nr.u(this.my);
                nr.u uVarU = this.nr.u(jkVar);
                if (uVarU.fx()) {
                    return uVarU;
                }
            }
        }
        return new nr.u(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        u uVar = this.nr;
        if (uVar == null) {
            return null;
        }
        return uVar.u();
    }
}

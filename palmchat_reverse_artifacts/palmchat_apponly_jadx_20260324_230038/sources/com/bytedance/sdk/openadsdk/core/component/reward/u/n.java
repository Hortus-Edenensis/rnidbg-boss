package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends fx {
    private static final n nr = new n(dw.getContext());

    private n(Context context) {
        super(context);
    }

    public static n u() {
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.fx
    public int nr() {
        return 7;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, int i, b bVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.nr.fx();
        fxVar.u(str);
        fxVar.u(i + 1);
        u(nrVar, bVar, fxVar, (com.bytedance.sdk.openadsdk.core.component.reward.business.fx.pn) null);
    }
}

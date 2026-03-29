package com.bytedance.sdk.openadsdk.core.c;

import android.content.Context;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.s.n;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private com.bytedance.sdk.openadsdk.s.u nr;
    private n u;

    public n u(Context context, SSWebView sSWebView, com.bytedance.sdk.openadsdk.s.fx fxVar, com.bytedance.sdk.openadsdk.s.u uVar, Set<String> set, n.u uVar2) {
        if (this.u == null) {
            n nVarU = n.u(context, sSWebView, fxVar, uVar, set, uVar2, true);
            this.u = nVarU;
            nVarU.b(false);
        }
        this.nr = uVar;
        return this.u;
    }
}

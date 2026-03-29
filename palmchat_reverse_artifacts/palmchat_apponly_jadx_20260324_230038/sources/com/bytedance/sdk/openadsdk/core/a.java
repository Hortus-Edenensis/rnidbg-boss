package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.iz b;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx fx;
    private View iz;
    private final bc nr;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.pn pn;
    private final Context u;
    private String x;

    public a(Context context, bc bcVar, View view, String str) {
        this.x = "rewarded_video";
        this.nr = bcVar;
        this.u = context;
        this.iz = view;
        if (TextUtils.isEmpty(str)) {
            this.x = jp.nr(jp.jk(bcVar));
        } else {
            this.x = str;
        }
        if (bcVar.qf() == 4) {
            this.fx = com.bytedance.sdk.openadsdk.core.l.n.u(context, bcVar, this.x, false);
        }
        String str2 = this.x;
        com.bytedance.sdk.openadsdk.core.nativeexpress.iz izVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.iz(context, bcVar, str2, jp.nr(str2));
        this.b = izVar;
        izVar.u(this.iz);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.b.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
        String str3 = this.x;
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.pn(context, bcVar, str3, jp.nr(str3));
        this.pn = pnVar;
        pnVar.u(this.iz);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.pn.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
    }

    public void u(int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar;
        if (i == -1 || qVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kj.jk jkVar = new com.bytedance.sdk.openadsdk.core.kj.jk();
        jkVar.u(qVar.u);
        jkVar.nr(qVar.nr);
        jkVar.fx(qVar.fx);
        jkVar.b(qVar.b);
        jkVar.nr(qVar.k);
        jkVar.u(qVar.o);
        if (i != 1) {
            if (i == 2 && (pnVar = this.pn) != null) {
                pnVar.u(qVar);
                this.pn.u(jkVar);
                this.pn.u(this.iz, jkVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.iz izVar = this.b;
        if (izVar != null) {
            izVar.u(qVar);
            this.b.u(jkVar);
            this.b.u(this.iz, jkVar);
        }
    }
}

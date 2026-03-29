package com.bytedance.sdk.component.adexpress.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.nr.jk;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements jk {
    private n b;
    private ThemeStatusBroadcastReceiver fx;
    private int iz;
    private com.bytedance.sdk.component.adexpress.dynamic.u.u nr;
    private mv pn;
    private Context u;

    public nr(Context context, mv mvVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.b.n nVar, n nVar2, com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar) {
        this(context, mvVar, themeStatusBroadcastReceiver, z, nVar, nVar2, uVar, null);
    }

    public nr(Context context, mv mvVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.b.n nVar, n nVar2, com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar, com.bytedance.sdk.component.adexpress.dynamic.u.u uVar2) {
        this.u = context;
        this.pn = mvVar;
        this.fx = themeStatusBroadcastReceiver;
        this.b = nVar2;
        if (uVar2 != null) {
            this.nr = uVar2;
        } else {
            this.nr = new com.bytedance.sdk.component.adexpress.dynamic.u.u(context, themeStatusBroadcastReceiver, z, nVar, mvVar, uVar);
        }
        this.nr.u(this.b);
        if (nVar instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x) {
            this.iz = 3;
        } else {
            this.iz = 2;
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.b nr() {
        com.bytedance.sdk.component.adexpress.dynamic.u.u uVar = this.nr;
        if (uVar != null) {
            return uVar.iz();
        }
        return null;
    }

    public void u(boolean z) {
        this.nr.nr(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public boolean u(final jk.u uVar) {
        this.pn.x().u(this.iz);
        this.nr.u(new x() { // from class: com.bytedance.sdk.component.adexpress.nr.nr.1
            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(View view, s sVar) {
                if (uVar.fx()) {
                    return;
                }
                nr.this.pn.x().pn(nr.this.iz);
                nr.this.pn.x().iz(nr.this.iz);
                nr.this.pn.x().mv();
                k kVarNr = uVar.nr();
                if (kVarNr == null) {
                    return;
                }
                kVarNr.u(nr.this.nr, sVar);
                uVar.u(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(int i, String str) {
                nr.this.pn.x().u(nr.this.iz, i, str, uVar.nr(nr.this));
                if (uVar.nr(nr.this)) {
                    uVar.u(nr.this);
                    return;
                }
                k kVarNr = uVar.nr();
                if (kVarNr == null) {
                    return;
                }
                kVarNr.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public void u() {
        com.bytedance.sdk.component.adexpress.dynamic.u.u uVar = this.nr;
        if (uVar != null) {
            uVar.nr();
        }
    }
}

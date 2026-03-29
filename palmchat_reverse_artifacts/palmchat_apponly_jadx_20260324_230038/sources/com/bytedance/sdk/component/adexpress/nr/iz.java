package com.bytedance.sdk.component.adexpress.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.nr.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements jk {
    private mv fx;
    private u nr;
    private Context u;

    public iz(Context context, mv mvVar, u uVar) {
        this.u = context;
        this.nr = uVar;
        this.fx = mvVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public void u() {
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public boolean u(final jk.u uVar) {
        this.fx.x().a();
        this.nr.u(new x() { // from class: com.bytedance.sdk.component.adexpress.nr.iz.1
            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(View view, s sVar) {
                if (uVar.fx()) {
                    return;
                }
                k kVarNr = uVar.nr();
                if (kVarNr != null) {
                    kVarNr.u(iz.this.nr, sVar);
                }
                uVar.u(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.nr.x
            public void u(int i, String str) {
                k kVarNr = uVar.nr();
                if (kVarNr != null) {
                    kVarNr.a_(i);
                }
            }
        });
        return true;
    }

    public void u(fx fxVar) {
        this.nr.u(fxVar);
    }
}

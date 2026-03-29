package com.bytedance.sdk.component.n.nr.u.u.nr;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends iz {
    public pn(Context context, com.bytedance.sdk.component.n.nr.b.nr.u uVar, com.bytedance.sdk.component.n.u.pn pnVar) {
        super(context, uVar, pnVar);
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz
    public byte fx() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz
    public byte nr() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz, com.bytedance.sdk.component.n.nr.u.u.nr.nr
    public String u() {
        com.bytedance.sdk.component.n.u.iz izVarNr = ((iz) this).nr.nr();
        if (izVarNr != null) {
            return izVarNr.fx();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u.nr.iz, com.bytedance.sdk.component.n.nr.u.u
    public boolean u(com.bytedance.sdk.component.n.u.nr nrVar) {
        return com.bytedance.sdk.component.n.nr.fx.u.nr(nrVar);
    }
}

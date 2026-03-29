package com.bytedance.sdk.component.iz.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        com.bytedance.sdk.component.iz.nr nrVarMv = fxVar.mv();
        if (nrVarMv != null) {
            if (nrVarMv.isMemoryCache()) {
                fxVar.u(new jk());
                return;
            } else if (nrVarMv.isDiskCache()) {
                fxVar.u(new iz());
                return;
            }
        }
        fxVar.u(new t());
    }
}

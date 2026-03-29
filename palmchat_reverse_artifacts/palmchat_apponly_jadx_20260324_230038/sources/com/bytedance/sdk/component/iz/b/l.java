package com.bytedance.sdk.component.iz.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends u {
    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        byte[] bArrU = fxVar.l().nr(fxVar.mv()).u(fxVar.getRawCacheKey());
        if (bArrU == null) {
            fxVar.u(new iz());
        } else {
            fxVar.u(new nr(bArrU, null));
        }
    }
}

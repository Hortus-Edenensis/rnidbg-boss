package com.bytedance.sdk.component.iz.b;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends u {
    private byte[] nr(com.bytedance.sdk.component.iz.fx.fx fxVar, String str) {
        com.bytedance.sdk.component.iz.b bVarFx = fxVar.l().fx(fxVar.mv());
        if (bVarFx == null) {
            return null;
        }
        return bVarFx.u(str);
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        String rawCacheKey = fxVar.getRawCacheKey();
        com.bytedance.sdk.component.iz.nr nrVarMv = fxVar.mv();
        byte[] bArrU = (fxVar.s() || nrVarMv.isQueryAll()) ? u(fxVar, rawCacheKey) : nr(fxVar, rawCacheKey);
        if (bArrU == null) {
            fxVar.u(new t());
            return;
        }
        fxVar.u(new nr(bArrU, null));
        if (nrVarMv.isRawMemoryCache()) {
            fxVar.l().nr(nrVarMv).u(rawCacheKey, bArrU);
        }
    }

    private byte[] u(com.bytedance.sdk.component.iz.fx.fx fxVar, String str) {
        fxVar.l().fx(fxVar.mv());
        Collection<com.bytedance.sdk.component.iz.b> collectionFx = fxVar.l().fx();
        if (collectionFx == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.iz.b> it = collectionFx.iterator();
        while (it.hasNext()) {
            byte[] bArrU = it.next().u(str);
            if (bArrU != null) {
                return bArrU;
            }
        }
        return null;
    }
}

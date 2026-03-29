package com.bytedance.sdk.component.iz.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends u {
    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(final com.bytedance.sdk.component.iz.fx.fx fxVar) {
        final com.bytedance.sdk.component.iz.fx.iz izVarL = fxVar.l();
        com.bytedance.sdk.component.iz.pn pnVarB = izVarL.b();
        fxVar.u(false);
        try {
            com.bytedance.sdk.component.iz.x xVarCall = pnVarB.call(new com.bytedance.sdk.component.iz.nr.fx(fxVar.getUrl(), fxVar.iz(), fxVar.x(), fxVar.k()));
            int iNr = xVarCall.nr();
            fxVar.u(xVarCall.u());
            if (xVarCall.nr() != 200) {
                izVarL.n();
                String.valueOf(xVarCall);
                Object objFx = xVarCall.fx();
                u(iNr, xVarCall.b(), objFx instanceof Throwable ? (Throwable) objFx : null, fxVar);
                return;
            }
            final byte[] bArr = (byte[]) xVarCall.fx();
            fxVar.u(new nr(bArr, xVarCall));
            final String rawCacheKey = fxVar.getRawCacheKey();
            final com.bytedance.sdk.component.iz.nr nrVarMv = fxVar.mv();
            if (nrVarMv.isRawMemoryCache()) {
                izVarL.nr(fxVar.mv()).u(rawCacheKey, bArr);
            }
            izVarL.iz().submit(new Runnable() { // from class: com.bytedance.sdk.component.iz.b.t.1
                @Override // java.lang.Runnable
                public void run() {
                    if (nrVarMv.isDiskCache()) {
                        izVarL.fx(fxVar.mv()).u(rawCacheKey, bArr);
                    }
                }
            });
        } catch (Throwable th) {
            u(1004, "net request failed!", th, fxVar);
        }
    }

    private void u(int i, String str, Throwable th, com.bytedance.sdk.component.iz.fx.fx fxVar) {
        fxVar.u(new n(i, str, th));
    }
}

package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class d extends com.kwad.sdk.core.response.a.a {
    public String aNn;
    public String aNo;
    public int aNp;
    public int operatorType;

    public static d KE() {
        d dVar = new d();
        try {
            Context contextRe = ServiceProvider.Re();
            dVar.aNn = bd.dC(contextRe);
            dVar.aNo = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CX();
            dVar.aNp = ao.dp(contextRe);
            dVar.operatorType = ao.e(contextRe, bd.dF(contextRe), bc.useNetworkStateDisable());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d KF() {
        d dVar = new d();
        dVar.aNp = ao.dp(ServiceProvider.getContext());
        return dVar;
    }
}

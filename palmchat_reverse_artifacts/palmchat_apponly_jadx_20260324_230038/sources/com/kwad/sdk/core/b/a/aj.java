package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class aj implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aCc = jSONObject.optBoolean("retrySwitch");
        cVar.aCd = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.aCe = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.aCf = jSONObject.optInt("retryQueueSize", new Integer("10").intValue());
        cVar.aCg = jSONObject.optBoolean("retryCountFeeOnly");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = cVar.aCc;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retrySwitch", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountConfig", cVar.aCd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheExpireTime", cVar.aCe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryQueueSize", cVar.aCf);
        boolean z2 = cVar.aCg;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountFeeOnly", z2);
        }
        return jSONObject;
    }
}

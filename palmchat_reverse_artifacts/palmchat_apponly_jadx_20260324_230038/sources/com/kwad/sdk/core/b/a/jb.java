package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class jb implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aNE = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aNF = jSONObject.optBoolean("enablePreload");
        aVar.aNG = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aNH = jSONObject.optInt("adLoadStrategy");
        aVar.aNI = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.posId;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j);
        }
        int i = aVar.aNE;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = aVar.aNF;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "increaseAdLoadTime", aVar.aNG);
        int i2 = aVar.aNH;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadStrategy", i2);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aNI);
        return jSONObject;
    }
}

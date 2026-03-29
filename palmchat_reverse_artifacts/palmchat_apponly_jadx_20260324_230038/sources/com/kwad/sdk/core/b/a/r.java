package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class r implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.e.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.e.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aAH = jSONObject.optString("imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aAH)) {
            cVar.aAH = "";
        }
        cVar.aAI = jSONObject.optString("final_imp_ad_info");
        if (JSONObject.NULL.toString().equals(cVar.aAI)) {
            cVar.aAI = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.aAH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imp_ad_info", cVar.aAH);
        }
        String str2 = cVar.aAI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_imp_ad_info", cVar.aAI);
        }
        return jSONObject;
    }
}

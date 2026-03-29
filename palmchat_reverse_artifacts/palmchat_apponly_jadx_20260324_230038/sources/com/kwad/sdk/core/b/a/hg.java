package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class hg implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aAN = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(aVar.aAN)) {
            aVar.aAN = "";
        }
        aVar.aAO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(aVar.aAO)) {
            aVar.aAO = "";
        }
        aVar.aAF = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(aVar.aAF)) {
            aVar.aAF = "";
        }
        aVar.aAP = jSONObject.optString("macro_type");
        if (JSONObject.NULL.toString().equals(aVar.aAP)) {
            aVar.aAP = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aAN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", aVar.aAN);
        }
        String str2 = aVar.aAO;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", aVar.aAO);
        }
        String str3 = aVar.aAF;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_name", aVar.aAF);
        }
        String str4 = aVar.aAP;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "macro_type", aVar.aAP);
        }
        return jSONObject;
    }
}

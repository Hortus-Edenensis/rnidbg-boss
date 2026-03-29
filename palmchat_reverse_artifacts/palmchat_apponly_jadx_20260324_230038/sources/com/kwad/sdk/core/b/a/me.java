package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class me implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aNx = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(gVar.aNx)) {
            gVar.aNx = "";
        }
        gVar.aNy = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(gVar.aNy)) {
            gVar.aNy = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
        gVar.aNz = jSONObject.optString("authCode");
        if (JSONObject.NULL.toString().equals(gVar.aNz)) {
            gVar.aNz = "";
        }
        gVar.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(gVar.serviceToken)) {
            gVar.serviceToken = "";
        }
        gVar.aNA = jSONObject.optString("authAppId");
        if (JSONObject.NULL.toString().equals(gVar.aNA)) {
            gVar.aNA = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aNx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserId", gVar.aNx);
        }
        String str2 = gVar.aNy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserName", gVar.aNy);
        }
        int i = gVar.thirdAge;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = gVar.thirdGender;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", i2);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        String str4 = gVar.aNz;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authCode", gVar.aNz);
        }
        String str5 = gVar.serviceToken;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serviceToken", gVar.serviceToken);
        }
        String str6 = gVar.aNA;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authAppId", gVar.aNA);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bn implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aAl = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.aAl)) {
            bVar.aAl = "";
        }
        bVar.aAs = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.aAs)) {
            bVar.aAs = "";
        }
        bVar.aAt = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.aAt)) {
            bVar.aAt = "";
        }
        bVar.aAu = jSONObject.optInt("store_type");
        bVar.aAv = jSONObject.optInt("launch_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aAl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.aAl);
        }
        String str3 = bVar.aAs;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_path", bVar.aAs);
        }
        String str4 = bVar.aAt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "market_pkg_name", bVar.aAt);
        }
        int i2 = bVar.aAu;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "store_type", i2);
        }
        int i3 = bVar.aAv;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "launch_type", i3);
        }
        return jSONObject;
    }
}

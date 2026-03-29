package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ei implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aVc = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.aVc)) {
            bVar.aVc = "";
        }
        bVar.aVd = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.aVd)) {
            bVar.aVd = "";
        }
        bVar.aVe = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.aVe)) {
            bVar.aVe = "";
        }
        bVar.aVf = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aVf)) {
            bVar.aVf = "";
        }
        bVar.aVg = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aVg)) {
            bVar.aVg = "";
        }
        bVar.aVh = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.aVh)) {
            bVar.aVh = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.aVc;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pluginListenerName", bVar.aVc);
        }
        String str3 = bVar.aVd;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportMethodName", bVar.aVd);
        }
        String str4 = bVar.aVe;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherProxyClassName", bVar.aVe);
        }
        String str5 = bVar.aVf;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherFieldName", bVar.aVf);
        }
        String str6 = bVar.aVg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherLevelFieldName", bVar.aVg);
        }
        String str7 = bVar.aVh;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTag", bVar.aVh);
        }
        return jSONObject;
    }
}

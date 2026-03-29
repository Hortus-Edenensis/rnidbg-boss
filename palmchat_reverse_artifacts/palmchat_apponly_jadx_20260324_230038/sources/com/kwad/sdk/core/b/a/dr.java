package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class dr implements com.kwad.sdk.core.d<a.C0562a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0562a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0562a) bVar, jSONObject);
    }

    private static void a(a.C0562a c0562a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0562a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0562a.url)) {
            c0562a.url = "";
        }
        c0562a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0562a.packageName)) {
            c0562a.packageName = "";
        }
    }

    private static JSONObject b(a.C0562a c0562a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0562a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0562a.url);
        }
        String str2 = c0562a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", c0562a.packageName);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class am implements com.kwad.sdk.core.d<a.C0563a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0563a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0563a) bVar, jSONObject);
    }

    private static void a(a.C0563a c0563a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0563a.Om = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0563a.Om)) {
            c0563a.Om = "";
        }
        c0563a.agb = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0563a.agb)) {
            c0563a.agb = "";
        }
        c0563a.agc = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0563a.agc)) {
            c0563a.agc = "";
        }
    }

    private static JSONObject b(a.C0563a c0563a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0563a.Om;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0563a.Om);
        }
        String str2 = c0563a.agb;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0563a.agb);
        }
        String str3 = c0563a.agc;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0563a.agc);
        }
        return jSONObject;
    }
}

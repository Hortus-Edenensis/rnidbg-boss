package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cg implements com.kwad.sdk.core.d<a.C0564a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0564a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0564a) bVar, jSONObject);
    }

    private static void a(a.C0564a c0564a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0564a.aiE = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0564a.aiE)) {
            c0564a.aiE = "";
        }
    }

    private static JSONObject b(a.C0564a c0564a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0564a.aiE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "android", c0564a.aiE);
        }
        return jSONObject;
    }
}

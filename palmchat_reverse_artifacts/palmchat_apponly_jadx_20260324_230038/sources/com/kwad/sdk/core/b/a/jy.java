package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class jy implements com.kwad.sdk.core.d<a.C0628a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0628a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0628a) bVar, jSONObject);
    }

    private static void a(a.C0628a c0628a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0628a.aYq = jSONObject.optInt("ds");
        c0628a.sdkVersion = jSONObject.optString("sv");
        if (JSONObject.NULL.toString().equals(c0628a.sdkVersion)) {
            c0628a.sdkVersion = "";
        }
        c0628a.aTr = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(c0628a.aTr)) {
            c0628a.aTr = "";
        }
    }

    private static JSONObject b(a.C0628a c0628a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0628a.aYq;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", i);
        }
        String str = c0628a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0628a.sdkVersion);
        }
        String str2 = c0628a.aTr;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0628a.aTr);
        }
        return jSONObject;
    }
}

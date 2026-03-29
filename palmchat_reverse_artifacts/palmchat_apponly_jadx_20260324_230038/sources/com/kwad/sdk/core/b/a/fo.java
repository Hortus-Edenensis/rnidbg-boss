package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class fo implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aWc = jSONObject.optInt("apiLevel");
        aVar.aWd = jSONObject.optInt("colorModeSupport");
        aVar.aWe = jSONObject.optInt("screenHdrAvailable");
        aVar.aWf = jSONObject.optInt("hdrSupport");
    }

    private static JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.aWc;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiLevel", i);
        }
        int i2 = aVar.aWd;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "colorModeSupport", i2);
        }
        int i3 = aVar.aWe;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHdrAvailable", i3);
        }
        int i4 = aVar.aWf;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hdrSupport", i4);
        }
        return jSONObject;
    }
}

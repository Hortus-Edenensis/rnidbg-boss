package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bhQ = jSONObject.optInt("put_count");
        aVar.bhR = jSONObject.optInt("get_failed_count");
        aVar.bhS = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bhQ;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "put_count", i);
        }
        int i2 = aVar.bhR;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = aVar.bhS;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_success_count", i3);
        }
        return jSONObject;
    }
}

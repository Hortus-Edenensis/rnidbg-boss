package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.at;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bh implements com.kwad.sdk.core.d<at.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((at.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((at.a) bVar, jSONObject);
    }

    private static void a(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    private static JSONObject b(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.id;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "id", i);
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }
}

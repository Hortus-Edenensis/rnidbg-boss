package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.i;
import com.lantern.auth.server.WkParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class fv implements com.kwad.sdk.core.d<i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((i.a) bVar, jSONObject);
    }

    private static void a(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGW = jSONObject.optString(WkParams.IMEI);
        if (JSONObject.NULL.toString().equals(aVar.aGW)) {
            aVar.aGW = "";
        }
        aVar.aGX = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(aVar.aGX)) {
            aVar.aGX = "";
        }
    }

    private static JSONObject b(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aGW;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WkParams.IMEI, aVar.aGW);
        }
        String str2 = aVar.aGX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", aVar.aGX);
        }
        return jSONObject;
    }
}

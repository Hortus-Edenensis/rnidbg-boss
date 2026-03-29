package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.h.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ll implements com.kwad.sdk.core.d<a.C0613a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0613a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0613a) bVar, jSONObject);
    }

    private static void a(a.C0613a c0613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0613a.aOM = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdk_version");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0613a.aOM.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        c0613a.aON = jSONObject.optInt("os_version");
        c0613a.aOO = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("abi");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                c0613a.aOO.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        c0613a.aOP = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("brand");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                c0613a.aOP.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(a.C0613a c0613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdk_version", c0613a.aOM);
        int i = c0613a.aON;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "abi", c0613a.aOO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "brand", c0613a.aOP);
        return jSONObject;
    }
}

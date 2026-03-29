package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class lm implements com.kwad.sdk.core.d<b.C0632b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.C0632b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.C0632b) bVar, jSONObject);
    }

    private static void a(b.C0632b c0632b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0632b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c0632b.name)) {
            c0632b.name = "";
        }
        c0632b.bcC = jSONObject.optBoolean("isStatic");
        c0632b.bcD = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                b.a aVar = new b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c0632b.bcD.add(aVar);
            }
        }
    }

    private static JSONObject b(b.C0632b c0632b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0632b.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", c0632b.name);
        }
        boolean z = c0632b.bcC;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0632b.bcD);
        return jSONObject;
    }
}

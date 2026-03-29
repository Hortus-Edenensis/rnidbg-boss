package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class be implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcj = jSONObject.optInt("aggregationType");
        aVar.bck = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdkCheckList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bck.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
        aVar.bcl = bVar;
        bVar.parseJson(jSONObject.optJSONObject("anchorNode"));
        aVar.bcm = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("stackCheckList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                aVar.bcm.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        aVar.bcn = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("callStackList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                aVar.bcn.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bcj;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationType", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkCheckList", aVar.bck);
        com.kwad.sdk.utils.aa.a(jSONObject, "anchorNode", aVar.bcl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "stackCheckList", aVar.bcm);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "callStackList", aVar.bcn);
        return jSONObject;
    }
}

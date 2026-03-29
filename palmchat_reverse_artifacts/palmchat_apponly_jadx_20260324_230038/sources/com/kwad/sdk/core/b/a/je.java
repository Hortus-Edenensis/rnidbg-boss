package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class je implements com.kwad.sdk.core.d<com.kwad.sdk.n.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.bca = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                dVar.bca.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        dVar.bcb = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                d.a aVar = new d.a();
                aVar.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                dVar.bcb.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.bcc = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
                bVar.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                dVar.bcc.add(bVar);
            }
        }
        dVar.bbS = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                com.kwad.sdk.n.a.a aVar2 = new com.kwad.sdk.n.a.a();
                aVar2.parseJson(jSONArrayOptJSONArray4.optJSONObject(i4));
                dVar.bbS.add(aVar2);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = dVar.funcSwitch;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", j);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "urlList", dVar.bca);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "actConfigList", dVar.bcb);
        long j2 = dVar.byteCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "byteCount", j2);
        }
        double d = dVar.sampleRate;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sampleRate", d);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "anchorNodeList", dVar.bcc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationCheckConfigList", dVar.bbS);
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.kwad.sdk.o.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class la implements com.kwad.sdk.core.d<l.a.C0634a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((l.a.C0634a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((l.a.C0634a) bVar, jSONObject);
    }

    private static void a(l.a.C0634a c0634a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0634a.bje = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0634a.bje)) {
            c0634a.bje = "";
        }
        c0634a.bjf = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0634a.bjf)) {
            c0634a.bjf = "";
        }
    }

    private static JSONObject b(l.a.C0634a c0634a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0634a.bje;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0634a.bje);
        }
        String str2 = c0634a.bjf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0634a.bjf);
        }
        return jSONObject;
    }
}

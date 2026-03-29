package com.kwad.sdk.core.b.a;

import com.qq.gdt.action.ActionUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class fb implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.key = jSONObject.optString("key");
        if (JSONObject.NULL.toString().equals(bVar.key)) {
            bVar.key = "";
        }
        bVar.value = jSONObject.optInt(ActionUtils.PAYMENT_AMOUNT);
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "key", bVar.key);
        }
        int i = bVar.value;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ActionUtils.PAYMENT_AMOUNT, i);
        }
        return jSONObject;
    }
}

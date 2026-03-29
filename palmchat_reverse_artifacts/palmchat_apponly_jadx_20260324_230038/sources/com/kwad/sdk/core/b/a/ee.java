package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ee implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aUj = jSONObject.optInt("funcSwitch");
        bVar.aUk = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.aUk)) {
            bVar.aUk = "";
        }
        bVar.aUl = jSONObject.optString("maxSdkVersionExclude");
        if (JSONObject.NULL.toString().equals(bVar.aUl)) {
            bVar.aUl = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aUm = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.aUm)) {
            bVar.aUm = "";
        }
        bVar.aUn = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.aUn)) {
            bVar.aUn = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aUo = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.aUo)) {
            bVar.aUo = "";
        }
        bVar.aUp = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.aUp)) {
            bVar.aUp = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.aUj;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", i);
        }
        String str = bVar.aUk;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minSdkVersion", bVar.aUk);
        }
        String str2 = bVar.aUl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxSdkVersionExclude", bVar.aUl);
        }
        int i2 = bVar.sdkType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i2);
        }
        String str3 = bVar.aUm;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V7", bVar.aUm);
        }
        String str4 = bVar.aUn;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V8", bVar.aUn);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.aUo;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v7Url", bVar.aUo);
        }
        String str7 = bVar.aUp;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v8Url", bVar.aUp);
        }
        return jSONObject;
    }
}

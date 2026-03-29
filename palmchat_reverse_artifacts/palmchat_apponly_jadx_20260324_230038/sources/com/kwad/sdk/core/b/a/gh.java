package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.j.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class gh implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mh = jSONObject.optString("device_model");
        if (JSONObject.NULL.toString().equals(aVar.Mh)) {
            aVar.Mh = "";
        }
        aVar.Mi = jSONObject.optString(com.umeng.analytics.pro.bt.F);
        if (JSONObject.NULL.toString().equals(aVar.Mi)) {
            aVar.Mi = "";
        }
        aVar.Mj = jSONObject.optString("os_version");
        if (JSONObject.NULL.toString().equals(aVar.Mj)) {
            aVar.Mj = "";
        }
        aVar.Mk = jSONObject.optString("rom_name");
        if (JSONObject.NULL.toString().equals(aVar.Mk)) {
            aVar.Mk = "";
        }
        aVar.Ml = jSONObject.optString("device_id");
        if (JSONObject.NULL.toString().equals(aVar.Ml)) {
            aVar.Ml = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.Mm = jSONObject.optString("install_check_record");
        if (JSONObject.NULL.toString().equals(aVar.Mm)) {
            aVar.Mm = "";
        }
        aVar.Mn = jSONObject.optString("local_installer_pkgs");
        if (JSONObject.NULL.toString().equals(aVar.Mn)) {
            aVar.Mn = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Mh;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_model", aVar.Mh);
        }
        String str2 = aVar.Mi;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bt.F, aVar.Mi);
        }
        String str3 = aVar.Mj;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", aVar.Mj);
        }
        String str4 = aVar.Mk;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rom_name", aVar.Mk);
        }
        String str5 = aVar.Ml;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_id", aVar.Ml);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        String str6 = aVar.Mm;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "install_check_record", aVar.Mm);
        }
        String str7 = aVar.Mn;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_installer_pkgs", aVar.Mn);
        }
        return jSONObject;
    }
}

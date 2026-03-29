package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import com.wifi.adsdk.download.LxAdDLManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cn implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.c) bVar, jSONObject);
    }

    private static void a(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.sW = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.sW)) {
            cVar.sW = "";
        }
        cVar.sX = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.sX)) {
            cVar.sX = "";
        }
        cVar.sY = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.sY)) {
            cVar.sY = "";
        }
        cVar.sZ = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.sZ)) {
            cVar.sZ = "";
        }
        cVar.ta = jSONObject.optString(LxAdDLManager.ITEM_ICONURL);
        if (JSONObject.NULL.toString().equals(cVar.ta)) {
            cVar.ta = "";
        }
        cVar.tb = jSONObject.optString(LxAdDLManager.ITEM_DESC);
        if (JSONObject.NULL.toString().equals(cVar.tb)) {
            cVar.tb = "";
        }
        cVar.tc = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.tc)) {
            cVar.tc = "";
        }
        cVar.td = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.td)) {
            cVar.td = "";
        }
    }

    private static JSONObject b(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.style;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", i);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.sW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeBtnText", cVar.sW);
        }
        String str3 = cVar.sX;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueBtnText", cVar.sX);
        }
        String str4 = cVar.sY;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewDetailText", cVar.sY);
        }
        String str5 = cVar.sZ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unWatchedVideoTime", cVar.sZ);
        }
        String str6 = cVar.ta;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, LxAdDLManager.ITEM_ICONURL, cVar.ta);
        }
        String str7 = cVar.tb;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, LxAdDLManager.ITEM_DESC, cVar.tb);
        }
        String str8 = cVar.tc;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "descTxt", cVar.tc);
        }
        String str9 = cVar.td;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentPlayTime", cVar.td);
        }
        return jSONObject;
    }
}

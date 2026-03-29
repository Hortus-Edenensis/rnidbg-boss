package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aj;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class md implements com.kwad.sdk.core.d<aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aj.a) bVar, jSONObject);
    }

    private static void a(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString(WfConstant.EVENT_KEY_APP_NAME);
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.aW);
        aVar.ahn = jSONObject.optInt(LxAdDLManager.ITEM_APPSIZE);
        aVar.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.aho = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.aho)) {
            aVar.aho = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.tb = jSONObject.optString(LxAdDLManager.ITEM_DESC);
        if (JSONObject.NULL.toString().equals(aVar.tb)) {
            aVar.tb = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.ahp = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.ahp)) {
            aVar.ahp = "";
        }
        aVar.ahq = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.ahr = jSONObject.optBoolean("isLandscapeSupported");
        aVar.ahs = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WfConstant.EVENT_KEY_APP_NAME, aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", aVar.version);
        }
        int i2 = aVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.huawei.openalliance.ad.constant.az.aW, i2);
        }
        int i3 = aVar.ahn;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, LxAdDLManager.ITEM_APPSIZE, i3);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5", aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.aho;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appLink", aVar.aho);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.tb;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, LxAdDLManager.ITEM_DESC, aVar.tb);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.ahp;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUri", aVar.ahp);
        }
        boolean z = aVar.ahq;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.ahr;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.ahs;
        if (z3) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.huawei.hms.ads.jsb.constant.Constant;
import com.kwad.sdk.core.webview.d.a;
import com.lantern.auth.server.WkParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class fm implements com.kwad.sdk.core.d<a.C0620a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0620a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0620a) bVar, jSONObject);
    }

    private static void a(a.C0620a c0620a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0620a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0620a.SDKVersion)) {
            c0620a.SDKVersion = "";
        }
        c0620a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0620a.aMl = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0620a.aMl)) {
            c0620a.aMl = "";
        }
        c0620a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0620a.sdkApiVersion)) {
            c0620a.sdkApiVersion = "";
        }
        c0620a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0620a.sdkType = jSONObject.optInt("sdkType");
        c0620a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0620a.appVersion)) {
            c0620a.appVersion = "";
        }
        c0620a.appName = jSONObject.optString(WfConstant.EVENT_KEY_APP_NAME);
        if (JSONObject.NULL.toString().equals(c0620a.appName)) {
            c0620a.appName = "";
        }
        c0620a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0620a.appId)) {
            c0620a.appId = "";
        }
        c0620a.aSG = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0620a.aSG)) {
            c0620a.aSG = "";
        }
        c0620a.aNa = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0620a.aNa)) {
            c0620a.aNa = "";
        }
        c0620a.aMZ = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0620a.aMZ)) {
            c0620a.aMZ = "";
        }
        c0620a.ahc = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0620a.ahc)) {
            c0620a.ahc = "";
        }
        c0620a.ahd = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0620a.ahd)) {
            c0620a.ahd = "";
        }
        c0620a.model = jSONObject.optString(WkParams.MODEL);
        if (JSONObject.NULL.toString().equals(c0620a.model)) {
            c0620a.model = "";
        }
        c0620a.Mi = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0620a.Mi)) {
            c0620a.Mi = "";
        }
        c0620a.ahe = jSONObject.optInt("osType");
        c0620a.ahf = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0620a.ahf)) {
            c0620a.ahf = "";
        }
        c0620a.ahg = jSONObject.optInt("osApi");
        c0620a.ahh = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0620a.ahh)) {
            c0620a.ahh = "";
        }
        c0620a.ahi = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0620a.ahi)) {
            c0620a.ahi = "";
        }
        c0620a.aSH = jSONObject.optString(Constant.MAP_KEY_UUID);
        if (JSONObject.NULL.toString().equals(c0620a.aSH)) {
            c0620a.aSH = "";
        }
        c0620a.aSI = jSONObject.optBoolean("isDynamic");
        c0620a.QX = jSONObject.optInt("screenWidth");
        c0620a.QW = jSONObject.optInt("screenHeight");
        c0620a.aGW = jSONObject.optString(WkParams.IMEI);
        if (JSONObject.NULL.toString().equals(c0620a.aGW)) {
            c0620a.aGW = "";
        }
        c0620a.aGX = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0620a.aGX)) {
            c0620a.aGX = "";
        }
        c0620a.aMW = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0620a.aMW)) {
            c0620a.aMW = "";
        }
        c0620a.aNn = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0620a.aNn)) {
            c0620a.aNn = "";
        }
        c0620a.ahj = jSONObject.optInt("statusBarHeight");
        c0620a.ahk = jSONObject.optInt("titleBarHeight");
        c0620a.aSJ = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0620a.aSJ)) {
            c0620a.aSJ = "";
        }
    }

    private static JSONObject b(a.C0620a c0620a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0620a.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0620a.SDKVersion);
        }
        int i = c0620a.SDKVersionCode;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0620a.aMl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0620a.aMl);
        }
        String str3 = c0620a.sdkApiVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0620a.sdkApiVersion);
        }
        int i2 = c0620a.sdkApiVersionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0620a.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0620a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0620a.appVersion);
        }
        String str5 = c0620a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WfConstant.EVENT_KEY_APP_NAME, c0620a.appName);
        }
        String str6 = c0620a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", c0620a.appId);
        }
        String str7 = c0620a.aSG;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0620a.aSG);
        }
        String str8 = c0620a.aNa;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0620a.aNa);
        }
        String str9 = c0620a.aMZ;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0620a.aMZ);
        }
        String str10 = c0620a.ahc;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0620a.ahc);
        }
        String str11 = c0620a.ahd;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0620a.ahd);
        }
        String str12 = c0620a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WkParams.MODEL, c0620a.model);
        }
        String str13 = c0620a.Mi;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0620a.Mi);
        }
        int i4 = c0620a.ahe;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i4);
        }
        String str14 = c0620a.ahf;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0620a.ahf);
        }
        int i5 = c0620a.ahg;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0620a.ahh;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", c0620a.ahh);
        }
        String str16 = c0620a.ahi;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0620a.ahi);
        }
        String str17 = c0620a.aSH;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Constant.MAP_KEY_UUID, c0620a.aSH);
        }
        boolean z = c0620a.aSI;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c0620a.QX;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0620a.QW;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0620a.aGW;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WkParams.IMEI, c0620a.aGW);
        }
        String str19 = c0620a.aGX;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0620a.aGX);
        }
        String str20 = c0620a.aMW;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0620a.aMW);
        }
        String str21 = c0620a.aNn;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", c0620a.aNn);
        }
        int i8 = c0620a.ahj;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0620a.ahk;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c0620a.aSJ;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0620a.aSJ);
        }
        return jSONObject;
    }
}

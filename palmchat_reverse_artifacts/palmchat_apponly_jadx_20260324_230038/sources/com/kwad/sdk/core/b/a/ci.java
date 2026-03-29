package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ci implements com.kwad.sdk.core.d<a.C0601a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0601a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0601a) bVar, jSONObject);
    }

    private static void a(a.C0601a c0601a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0601a.aBs = jSONObject.optInt("ad_retry_type");
        c0601a.templateId = jSONObject.optString(WfConstant.EXTRA_KEY_TEMPLATE_ID);
        if (JSONObject.NULL.toString().equals(c0601a.templateId)) {
            c0601a.templateId = "";
        }
        c0601a.aBt = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c0601a.aBt)) {
            c0601a.aBt = "";
        }
        c0601a.aBu = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c0601a.aBu)) {
            c0601a.aBu = "";
        }
        c0601a.aBw = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0601a.aBw)) {
            c0601a.aBw = "";
        }
        c0601a.aBx = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0601a.aBy = jSONObject.optInt("award_task_name");
        c0601a.aBz = jSONObject.optInt("jumps_liveroom_type");
        c0601a.aBA = jSONObject.optInt("universe_feature_freg");
        c0601a.aBB = jSONObject.optInt("replace_url_succ");
        c0601a.aBC = jSONObject.optBoolean("is_dp_opt");
        c0601a.aBD = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c0601a.aBD)) {
            c0601a.aBD = "";
        }
        c0601a.aBF = jSONObject.optInt("is_carousel");
        c0601a.aBG = jSONObject.optInt("is_special_preload");
        c0601a.aBH = jSONObject.optInt("card_type");
        c0601a.aBI = jSONObject.optInt("is_closure");
        c0601a.aBJ = jSONObject.optString("authorization_status");
        if (JSONObject.NULL.toString().equals(c0601a.aBJ)) {
            c0601a.aBJ = "";
        }
        c0601a.aBK = jSONObject.optString("login_source");
        if (JSONObject.NULL.toString().equals(c0601a.aBK)) {
            c0601a.aBK = "";
        }
        c0601a.aBL = jSONObject.optInt("is_login");
        c0601a.aBM = jSONObject.optInt("coupon_receive_status");
    }

    private static JSONObject b(a.C0601a c0601a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0601a.aBs;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", i);
        }
        String str = c0601a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WfConstant.EXTRA_KEY_TEMPLATE_ID, c0601a.templateId);
        }
        String str2 = c0601a.aBt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0601a.aBt);
        }
        String str3 = c0601a.aBu;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0601a.aBu);
        }
        String str4 = c0601a.aBw;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0601a.aBw);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0601a.aBx);
        int i2 = c0601a.aBy;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", i2);
        }
        int i3 = c0601a.aBz;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", i3);
        }
        int i4 = c0601a.aBA;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", i4);
        }
        int i5 = c0601a.aBB;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", i5);
        }
        boolean z = c0601a.aBC;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", z);
        }
        String str5 = c0601a.aBD;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0601a.aBD);
        }
        int i6 = c0601a.aBF;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", i6);
        }
        int i7 = c0601a.aBG;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", i7);
        }
        int i8 = c0601a.aBH;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", i8);
        }
        int i9 = c0601a.aBI;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_closure", i9);
        }
        String str6 = c0601a.aBJ;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorization_status", c0601a.aBJ);
        }
        String str7 = c0601a.aBK;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "login_source", c0601a.aBK);
        }
        int i10 = c0601a.aBL;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_login", i10);
        }
        int i11 = c0601a.aBM;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coupon_receive_status", i11);
        }
        return jSONObject;
    }
}

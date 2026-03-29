package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.ja;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ja nr;
    private String u;

    public q(String str, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.nr = jaVar;
        this.u = str;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("appInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("appInfo", jaVar));
        oVar.u("adInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("adInfo", jaVar));
        oVar.u("getTemplateInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getTemplateInfo", jaVar));
        oVar.u("getTeMaiAds", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getTeMaiAds", jaVar));
        oVar.u("isViewable", (com.bytedance.sdk.component.u.pn<?, ?>) new q("isViewable", jaVar));
        oVar.u("getScreenSize", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getScreenSize", jaVar));
        oVar.u("getCloseButtonInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getCloseButtonInfo", jaVar));
        oVar.u("getVolume", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getVolume", jaVar));
        oVar.u("sendReward", (com.bytedance.sdk.component.u.pn<?, ?>) new q("sendReward", jaVar));
        oVar.u("subscribe_app_ad", (com.bytedance.sdk.component.u.pn<?, ?>) new q("subscribe_app_ad", jaVar));
        oVar.u("download_app_ad", (com.bytedance.sdk.component.u.pn<?, ?>) new q("download_app_ad", jaVar));
        oVar.u("cancel_download_app_ad", (com.bytedance.sdk.component.u.pn<?, ?>) new q("cancel_download_app_ad", jaVar));
        oVar.u("unsubscribe_app_ad", (com.bytedance.sdk.component.u.pn<?, ?>) new q("unsubscribe_app_ad", jaVar));
        oVar.u("clickEvent", (com.bytedance.sdk.component.u.pn<?, ?>) new q("clickEvent", jaVar));
        oVar.u("renderDidFinish", (com.bytedance.sdk.component.u.pn<?, ?>) new q("renderDidFinish", jaVar));
        oVar.u("dynamicTrack", (com.bytedance.sdk.component.u.pn<?, ?>) new q("dynamicTrack", jaVar));
        oVar.u("skipVideo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("skipVideo", jaVar));
        oVar.u("muteVideo", (com.bytedance.sdk.component.u.pn<?, ?>) new q("muteVideo", jaVar));
        oVar.u("changeVideoState", (com.bytedance.sdk.component.u.pn<?, ?>) new q("changeVideoState", jaVar));
        oVar.u("getCurrentVideoState", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getCurrentVideoState", jaVar));
        oVar.u("send_temai_product_ids", (com.bytedance.sdk.component.u.pn<?, ?>) new q("send_temai_product_ids", jaVar));
        oVar.u("getMaterialMeta", (com.bytedance.sdk.component.u.pn<?, ?>) new q("getMaterialMeta", jaVar));
        oVar.u("endcard_load", (com.bytedance.sdk.component.u.pn<?, ?>) new q("endcard_load", jaVar));
        oVar.u("pauseWebView", (com.bytedance.sdk.component.u.pn<?, ?>) new q("pauseWebView", jaVar));
        oVar.u("pauseWebViewTimers", (com.bytedance.sdk.component.u.pn<?, ?>) new q("pauseWebViewTimers", jaVar));
        oVar.u("webview_time_track", (com.bytedance.sdk.component.u.pn<?, ?>) new q("webview_time_track", jaVar));
        oVar.u("adInfoStash", (com.bytedance.sdk.component.u.pn<?, ?>) new q("adInfoStash", jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        ja.u uVar = new ja.u();
        uVar.u = NotificationCompat.CATEGORY_CALL;
        uVar.fx = this.u;
        uVar.b = jSONObject;
        return this.nr.u(uVar, 3);
    }
}

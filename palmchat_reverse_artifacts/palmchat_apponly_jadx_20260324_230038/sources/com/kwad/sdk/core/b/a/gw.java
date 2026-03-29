package com.kwad.sdk.core.b.a;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class gw implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    private static void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble(INativeAdvanceData.POSITION_TOP_LEFT);
        kSAdJSCornerModel.topRight = jSONObject.optDouble(INativeAdvanceData.POSITION_TOP_RIGHT);
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble(INativeAdvanceData.POSITION_BOTTOM_RIGHT);
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble(INativeAdvanceData.POSITION_BOTTOM_LEFT);
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kSAdJSCornerModel.topLeft;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, INativeAdvanceData.POSITION_TOP_LEFT, d);
        }
        double d2 = kSAdJSCornerModel.topRight;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, INativeAdvanceData.POSITION_TOP_RIGHT, d2);
        }
        double d3 = kSAdJSCornerModel.bottomRight;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, INativeAdvanceData.POSITION_BOTTOM_RIGHT, d3);
        }
        double d4 = kSAdJSCornerModel.bottomLeft;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, INativeAdvanceData.POSITION_BOTTOM_LEFT, d4);
        }
        return jSONObject;
    }
}

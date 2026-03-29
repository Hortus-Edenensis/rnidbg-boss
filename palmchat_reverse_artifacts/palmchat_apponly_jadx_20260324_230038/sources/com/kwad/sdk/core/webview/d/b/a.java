package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public final class a extends com.kwad.sdk.core.response.a.a {
    public String PU;

    @Deprecated
    public boolean Pt;
    public int aSM;
    public int aSN;
    public AdTemplate adTemplate;

    @Deprecated
    public boolean ahH;
    public int ahJ;
    public d ahK;
    public int mH;
    public boolean PG = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aSO = false;
    public boolean aSP = false;

    public final boolean MS() {
        return 1 == this.ahJ;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.mH == 0 && this.aSN == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logParam");
                    this.mH = jSONObjectOptJSONObject.getInt("itemClickType");
                    this.aSN = jSONObjectOptJSONObject.getInt("sceneType");
                    this.aSO = jSONObjectOptJSONObject.optBoolean("isCallbackOnly");
                }
                String strOptString = jSONObject.optString("adTemplate");
                if (bp.isNullString(strOptString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        } catch (Throwable unused) {
        }
    }
}

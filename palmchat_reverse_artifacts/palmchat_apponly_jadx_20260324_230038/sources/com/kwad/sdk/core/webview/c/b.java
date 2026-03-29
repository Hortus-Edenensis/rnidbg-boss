package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aSD;
    public String aSE;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aSD = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aSE = jSONObject.optString(bq.f.L);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "action", this.aSD);
        aa.putValue(jSONObject, "data", this.data);
        aa.putValue(jSONObject, bq.f.L, this.aSE);
        return jSONObject;
    }
}

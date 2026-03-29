package com.kwad.sdk.mobileid.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bp;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class UaidTokenResponse extends BaseResultData {
    private static final long serialVersionUID = -8501365728042530876L;
    public String uaid;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            e eVar = (e) d.f(e.class);
            if (bp.isNullString(strOptString)) {
                return;
            }
            String responseData = eVar.getResponseData(strOptString);
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.uaid = new JSONObject(responseData).optString("uaid");
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }
}

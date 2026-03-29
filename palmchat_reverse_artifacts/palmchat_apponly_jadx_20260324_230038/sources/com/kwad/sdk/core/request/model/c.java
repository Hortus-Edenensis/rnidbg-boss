package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aNm;
    private double latitude;
    private double longitude;
    private int type;

    public static c KD() {
        com.kwad.sdk.internal.api.a aVar;
        c cVar = aNm;
        if (cVar != null) {
            return cVar;
        }
        try {
            aNm = new c();
            com.kwad.sdk.utils.c.a aVarCU = bd.cU(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (aVarCU != null && (aVar = aVarCU.bhT) != null) {
                aNm.latitude = aVar.getLatitude();
                aNm.longitude = aVarCU.bhT.getLongitude();
                aNm.type = aVarCU.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aNm;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "latitude", this.latitude);
        aa.putValue(jSONObject, "longitude", this.longitude);
        aa.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}

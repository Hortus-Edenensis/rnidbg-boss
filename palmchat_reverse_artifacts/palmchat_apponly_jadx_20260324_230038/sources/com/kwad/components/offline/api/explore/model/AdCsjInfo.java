package com.kwad.components.offline.api.explore.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdCsjInfo extends BaseOfflineCompoJsonParse<AdCsjInfo> implements Serializable {
    private static final long serialVersionUID = -6149616231567033423L;
    public long adId;
    public int adOperationType;
    public String reqId;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(AdCsjInfo adCsjInfo, JSONObject jSONObject) {
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(AdCsjInfo adCsjInfo, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(AdCsjInfo adCsjInfo) {
        return toJson(adCsjInfo, (JSONObject) null);
    }
}

package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.utils.aa;
import com.wifi.ad.core.config.EventParams;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class KSAdLiveShopInfo extends BaseOfflineCompoJsonParse<KSAdLiveShopInfo> implements Serializable {
    private static final long serialVersionUID = -7139399767269744574L;
    public int changeType;
    public KSAdLiveRoomItemInfo itemInfo;
    public int shopCardType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveShopInfo.shopCardType = jSONObject.optInt("shopCardType");
        kSAdLiveShopInfo.changeType = jSONObject.optInt(EventParams.KEY_CHANGETYPE);
        KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo = new KSAdLiveRoomItemInfo();
        kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
        kSAdLiveRoomItemInfo.parseJson(jSONObject.optJSONObject("itemInfo"));
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "itemInfo", kSAdLiveShopInfo.itemInfo);
        int i = kSAdLiveShopInfo.shopCardType;
        if (i != 0) {
            aa.putValue(jSONObject, "shopCardType", i);
        }
        int i2 = kSAdLiveShopInfo.changeType;
        if (i2 != 0) {
            aa.putValue(jSONObject, EventParams.KEY_CHANGETYPE, i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo) {
        return toJson(kSAdLiveShopInfo, (JSONObject) null);
    }
}

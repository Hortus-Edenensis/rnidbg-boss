package com.baidu.platform.core.sug;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.hms.actions.SearchIntents;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends com.baidu.platform.base.c {
    public c(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.d.a(SearchIntents.EXTRA_QUERY, suggestionSearchOption.mKeyword);
        this.d.a("region", suggestionSearchOption.mCity);
        LatLng latLng = suggestionSearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            this.d.a("location", latLng2.latitude + "," + latLng2.longitude);
        }
        boolean zBooleanValue = suggestionSearchOption.mCityLimit.booleanValue();
        String str = ex.Code;
        if (zBooleanValue) {
            this.d.a("city_limit", ex.Code);
        } else {
            this.d.a("city_limit", ex.V);
        }
        if (suggestionSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        if (suggestionSearchOption.mHotWord) {
            this.d.a("hotword", ex.Code);
        } else {
            this.d.a("hotword", ex.V);
        }
        this.d.a("from", "android_map_sdk");
        this.d.a("output", BodyData.TYPE_JSON);
        com.baidu.platform.util.a aVar = this.d;
        if (!suggestionSearchOption.isExtendAdcode()) {
            str = ex.V;
        }
        aVar.a("extensions_adcode", str);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.l();
    }
}

package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e extends com.baidu.platform.base.c {
    public e(ReverseGeoCodeOption reverseGeoCodeOption) {
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.d.a("location", latLng.latitude + "," + latLng.longitude);
        }
        if (reverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        } else {
            this.d.a("language", "zh-CN");
        }
        this.d.a("coordtype", "bd09ll");
        this.d.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.d.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.d.a("pois", "1");
        this.d.a("extensions_poi", "1");
        this.d.a("extensions_town", ex.Code);
        if (reverseGeoCodeOption.getExtensionsRoad()) {
            this.d.a("extensions_road", ex.Code);
        } else {
            this.d.a("extensions_road", ex.V);
        }
        String poiType = reverseGeoCodeOption.getPoiType();
        if (!TextUtils.isEmpty(poiType)) {
            this.d.a("poi_types", poiType);
        }
        this.d.a("output", "jsonaes");
        this.d.a("from", "android_map_sdk");
        this.d.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.d.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.s();
    }
}

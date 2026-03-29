package com.baidu.platform.core.geocode;

import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.geocode.GeoCodeOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends com.baidu.platform.base.c {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.d.a(DistrictSearchQuery.KEYWORDS_CITY, geoCodeOption.mCity);
        this.d.a("address", geoCodeOption.mAddress);
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("ret_coordtype", "bd09ll");
        this.d.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.m();
    }
}

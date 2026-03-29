package com.baidu.platform.core.poi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.hms.actions.SearchIntents;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g extends com.baidu.platform.base.c {
    public g(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        PoiFilter poiFilter;
        if (poiNearbySearchOption == null) {
            return;
        }
        this.d.a(SearchIntents.EXTRA_QUERY, poiNearbySearchOption.mKeyword);
        if (poiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiNearbySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.d.a("from_language", inputLanguageType.getValue());
        }
        LatLng latLng = poiNearbySearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (latLng2 != null) {
                this.d.a("location", latLng2.latitude + "," + latLng2.longitude);
            }
        }
        this.d.a("photo_show", poiNearbySearchOption.isShowPhoto() ? ex.Code : ex.V);
        this.d.a("radius", poiNearbySearchOption.mRadius + "");
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("extensions_adcode", poiNearbySearchOption.isExtendAdcode() ? ex.Code : ex.V);
        this.d.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.d.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.d.a("scope", poiNearbySearchOption.mScope + "");
        this.d.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.d.a("radius_limit", ex.Code);
        } else {
            this.d.a("radius_limit", ex.V);
        }
        if (poiNearbySearchOption.mScope == 2 && (poiFilter = poiNearbySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.d.a("filter", poiNearbySearchOption.mPoiFilter.toString());
        }
        if (poiNearbySearchOption.isExtendChildPoi()) {
            this.d.a("extensions_child_poi", ex.Code);
        } else {
            this.d.a("extensions_child_poi", ex.V);
        }
        this.c = poiNearbySearchOption.getCustomExtra();
    }

    public g(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    public g(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        PoiFilter poiFilter;
        if (poiCitySearchOption == null) {
            return;
        }
        this.d.a(SearchIntents.EXTRA_QUERY, poiCitySearchOption.mKeyword);
        if (poiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiCitySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.d.a("from_language", inputLanguageType.getValue());
        }
        this.d.a("photo_show", poiCitySearchOption.isShowPhoto() ? ex.Code : ex.V);
        this.d.a("region", poiCitySearchOption.mCity);
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("extensions_adcode", poiCitySearchOption.isExtendAdcode() ? ex.Code : ex.V);
        this.d.a("page_num", poiCitySearchOption.mPageNum + "");
        this.d.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.d.a("scope", poiCitySearchOption.mScope + "");
        this.d.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.getCenter() != null) {
            LatLng latLng = new LatLng(poiCitySearchOption.getCenter().latitude, poiCitySearchOption.getCenter().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            if (latLng != null) {
                this.d.a("center", latLng.latitude + "," + latLng.longitude);
            }
        }
        if (poiCitySearchOption.getViewBound() != null && poiCitySearchOption.getViewBound().southwest != null && poiCitySearchOption.getViewBound().northeast != null) {
            LatLng latLng2 = new LatLng(poiCitySearchOption.getViewBound().southwest.latitude, poiCitySearchOption.getViewBound().southwest.longitude);
            LatLng latLng3 = new LatLng(poiCitySearchOption.getViewBound().northeast.latitude, poiCitySearchOption.getViewBound().northeast.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng3 = CoordTrans.gcjToBaidu(latLng3);
            }
            if (latLng2 != null && latLng3 != null) {
                this.d.a("view_bound", latLng2.latitude + "," + latLng2.longitude + "," + latLng3.latitude + "," + latLng3.longitude);
            }
        }
        if (poiCitySearchOption.getSearchBound() != null && poiCitySearchOption.getSearchBound().southwest != null && poiCitySearchOption.getSearchBound().northeast != null) {
            LatLng latLng4 = new LatLng(poiCitySearchOption.getSearchBound().southwest.latitude, poiCitySearchOption.getSearchBound().southwest.longitude);
            LatLng latLng5 = new LatLng(poiCitySearchOption.getSearchBound().northeast.latitude, poiCitySearchOption.getSearchBound().northeast.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
                latLng5 = CoordTrans.gcjToBaidu(latLng5);
            }
            if (latLng4 != null && latLng5 != null) {
                this.d.a("search_bound", latLng4.latitude + "," + latLng4.longitude + "," + latLng5.latitude + "," + latLng5.longitude);
            }
        }
        if (poiCitySearchOption.getFilterDistance() > 0) {
            this.d.a("view_distance", poiCitySearchOption.getFilterDistance() + "");
        }
        if (poiCitySearchOption.mIsCityLimit) {
            this.d.a("city_limit", ex.Code);
        } else {
            this.d.a("city_limit", ex.V);
        }
        if (poiCitySearchOption.mScope == 2 && (poiFilter = poiCitySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.d.a("filter", poiCitySearchOption.mPoiFilter.toString());
        }
        if (poiCitySearchOption.isExtendChildPoi()) {
            this.d.a("extensions_child_poi", ex.Code);
        } else {
            this.d.a("extensions_child_poi", ex.V);
        }
        this.c = poiCitySearchOption.getCustomExtra();
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        LatLng latLng;
        if (poiBoundSearchOption == null) {
            return;
        }
        this.d.a(SearchIntents.EXTRA_QUERY, poiBoundSearchOption.mKeyword);
        if (poiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiBoundSearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.d.a("from_language", inputLanguageType.getValue());
        }
        this.d.a("photo_show", poiBoundSearchOption.isShowPhoto() ? ex.Code : ex.V);
        this.d.a("tag", poiBoundSearchOption.mTag);
        LatLngBounds latLngBounds = poiBoundSearchOption.mBound;
        if (latLngBounds != null && (latLng = latLngBounds.southwest) != null && latLngBounds.northeast != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = poiBoundSearchOption.mBound.northeast;
            LatLng latLng4 = new LatLng(latLng3.latitude, latLng3.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
            }
            if (latLng2 != null && latLng4 != null) {
                this.d.a("bounds", latLng2.latitude + "," + latLng2.longitude + "," + latLng4.latitude + "," + latLng4.longitude);
            }
        }
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("extensions_adcode", poiBoundSearchOption.isExtendAdcode() ? ex.Code : ex.V);
        this.d.a("scope", poiBoundSearchOption.mScope + "");
        this.d.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.d.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope == 2 && (poiFilter = poiBoundSearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.d.a("filter", poiBoundSearchOption.mPoiFilter.toString());
        }
        if (poiBoundSearchOption.isExtendChildPoi()) {
            this.d.a("extensions_child_poi", ex.Code);
        } else {
            this.d.a("extensions_child_poi", ex.V);
        }
        this.c = poiBoundSearchOption.getCustomExtra();
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.u();
    }
}

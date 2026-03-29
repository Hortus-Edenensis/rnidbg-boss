package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IGeoCoder {
    void destroy();

    boolean geocode(GeoCodeOption geoCodeOption);

    boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption);

    void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener);
}

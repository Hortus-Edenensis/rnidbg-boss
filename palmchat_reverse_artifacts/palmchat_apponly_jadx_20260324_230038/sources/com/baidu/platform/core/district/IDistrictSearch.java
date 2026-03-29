package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IDistrictSearch {
    void destroy();

    boolean searchDistrict(DistrictSearchOption districtSearchOption);

    void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener);
}

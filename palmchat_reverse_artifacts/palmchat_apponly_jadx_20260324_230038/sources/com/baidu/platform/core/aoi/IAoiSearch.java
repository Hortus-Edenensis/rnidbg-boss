package com.baidu.platform.core.aoi;

import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IAoiSearch {
    void destroy();

    boolean searchAoi(AoiSearchOption aoiSearchOption);

    void setOnAoiSearchListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener);
}

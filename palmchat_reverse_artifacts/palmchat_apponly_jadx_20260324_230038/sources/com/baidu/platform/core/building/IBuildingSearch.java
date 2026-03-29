package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IBuildingSearch {
    void destroy();

    boolean searchBuilding(BuildingSearchOption buildingSearchOption);

    void setOnBuildingSearchListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener);
}

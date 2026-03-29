package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.platform.base.SearchType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.baidu.platform.base.a implements IBuildingSearch {
    private OnGetBuildingSearchResultListener g;

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public boolean searchBuilding(BuildingSearchOption buildingSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUILDING_SEARCH);
        return a(new c(buildingSearchOption), this.g, aVar);
    }

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public void setOnBuildingSearchListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        this.c.lock();
        this.g = onGetBuildingSearchResultListener;
        this.c.unlock();
    }
}

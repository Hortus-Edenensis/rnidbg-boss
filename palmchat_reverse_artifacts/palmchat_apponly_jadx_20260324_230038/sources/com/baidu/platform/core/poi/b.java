package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.baidu.platform.base.c {
    public b(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.d.a("qt", "indoor_s");
        this.d.a("x", "0");
        this.d.a("y", "0");
        this.d.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.d.a(MapBundleKey.MapObjKey.OBJ_BID, str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.d.a("wd", str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.d.a("floor", str3);
        }
        this.d.a("current", poiIndoorOption.currentPage + "");
        this.d.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.c();
    }
}

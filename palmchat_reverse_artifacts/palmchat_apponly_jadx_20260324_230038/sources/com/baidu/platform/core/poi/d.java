package com.baidu.platform.core.poi;

import android.util.Log;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.baidu.platform.base.c {
    public d(PoiDetailSearchOption poiDetailSearchOption) {
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(d.class.getSimpleName(), "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        if (poiDetailSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        com.baidu.platform.util.a aVar = this.d;
        boolean zIsShowPhoto = poiDetailSearchOption.isShowPhoto();
        String str = ex.Code;
        aVar.a("photo_show", zIsShowPhoto ? ex.Code : ex.V);
        this.d.a("uids", poiDetailSearchOption.getUids());
        com.baidu.platform.util.a aVar2 = this.d;
        if (!poiDetailSearchOption.isExtendAdcode()) {
            str = ex.V;
        }
        aVar2.a("extensions_adcode", str);
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("scope", "2");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.v();
    }
}

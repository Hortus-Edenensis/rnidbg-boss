package com.baidu.platform.core.share;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.baidu.platform.base.c {
    public a(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.d.a("qt", OapsKey.KEY_CHECKSUM);
        Point pointLl2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.d.a(MapBundleKey.MapObjKey.OBJ_GEO, pointLl2point.x + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + pointLl2point.y);
        this.d.a("t", locationShareURLOption.mName);
        this.d.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.h();
    }
}

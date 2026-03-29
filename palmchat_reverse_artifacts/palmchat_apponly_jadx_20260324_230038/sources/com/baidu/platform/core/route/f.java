package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f extends com.baidu.platform.base.c {
    public f(IndoorRoutePlanOption indoorRoutePlanOption) {
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.d.a("qt", "indoornavi");
        this.d.a("rp_format", BodyData.TYPE_JSON);
        this.d.a("version", "1");
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (geoPointLl2mc != null) {
            this.d.a("sn", (String.format("%f,%f", Double.valueOf(geoPointLl2mc.getLongitudeE6()), Double.valueOf(geoPointLl2mc.getLatitudeE6())) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(" ", ""));
        }
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (geoPointLl2mc2 != null) {
            this.d.a("en", (String.format("%f,%f", Double.valueOf(geoPointLl2mc2.getLongitudeE6()), Double.valueOf(geoPointLl2mc2.getLatitudeE6())) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + indoorRoutePlanOption.mTo.getFloor()).replaceAll(" ", ""));
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.q();
    }
}

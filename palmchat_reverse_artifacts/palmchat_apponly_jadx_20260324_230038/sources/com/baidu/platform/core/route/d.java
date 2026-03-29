package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.bi;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.baidu.platform.base.c {
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        this.d.a("qt", "cars");
        this.d.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.d.a("ie", "utf-8");
        this.d.a("lrn", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
        this.d.a("version", "6");
        this.d.a("extinfo", "32");
        this.d.a("mrs", "1");
        this.d.a("rp_format", BodyData.TYPE_JSON);
        this.d.a("rp_filter", "mobile");
        this.d.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.d.a("sn", a(drivingRoutePlanOption.mFrom));
        this.d.a("en", a(drivingRoutePlanOption.mTo));
        String str = drivingRoutePlanOption.mCityName;
        if (str != null) {
            this.d.a("c", str);
        }
        PlanNode planNode = drivingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.d.a(com.igexin.push.g.o.e, planNode.getCity());
        }
        PlanNode planNode2 = drivingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.d.a("ec", planNode2.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str2 = new String();
        String str3 = new String();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                PlanNode planNode3 = list.get(i);
                if (planNode3 != null) {
                    str2 = str2 + a(planNode3);
                    str3 = str3 + planNode3.getCity();
                    if (i != list.size() - 1) {
                        String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                        str3 = str3 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                        str2 = str4;
                    }
                }
            }
            this.d.a(bi.q, str2);
            this.d.a("wpc", str3);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.a();
    }
}

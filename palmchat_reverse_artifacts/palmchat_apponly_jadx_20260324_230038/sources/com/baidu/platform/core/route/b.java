package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.baidu.platform.base.c {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.d.a("mode", "riding");
        PlanNode planNode = bikingRoutePlanOption.mFrom;
        PlanNode planNode2 = bikingRoutePlanOption.mTo;
        if (planNode == null || planNode2 == null) {
            return;
        }
        LatLng location = planNode.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            if (location != null) {
                this.d.a("origin", location.latitude + "," + location.longitude);
            }
        } else {
            this.d.a("origin", planNode.getName());
            this.d.a("origin_region", planNode.getCity());
        }
        if (planNode.getPoiId() != null && planNode.getPoiId().length() > 0) {
            this.d.a("origin_uid", planNode.getPoiId());
        }
        LatLng location2 = planNode2.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            if (location2 != null) {
                this.d.a(az.au, location2.latitude + "," + location2.longitude);
            }
        } else {
            this.d.a(az.au, planNode2.getName());
            this.d.a("destination_region", planNode2.getCity());
        }
        if (planNode2.getPoiId() != null && planNode2.getPoiId().length() > 0) {
            this.d.a("destination_uid", planNode2.getPoiId());
        }
        int i = bikingRoutePlanOption.mRidingType;
        if (i == 1) {
            this.d.a("riding_type", String.valueOf(i));
        }
        List<PlanNode> wayPoints = bikingRoutePlanOption.getWayPoints();
        if (wayPoints != null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < wayPoints.size(); i2++) {
                PlanNode planNode3 = wayPoints.get(i2);
                if (i2 == 0) {
                    sb.append(a(planNode3, this.d));
                } else {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb.append(a(planNode3, this.d));
                }
            }
            this.d.a("waypoints", sb.toString());
        }
        this.d.a("output", BodyData.TYPE_JSON);
        this.d.a("from", "android_map_sdk");
        this.d.a("road_prefer", bikingRoutePlanOption.mRoadPrefer);
    }

    private String a(PlanNode planNode, com.baidu.platform.util.a aVar) {
        if (planNode != null && aVar != null) {
            LatLng location = planNode.getLocation();
            String poiId = planNode.getPoiId() != null ? planNode.getPoiId() : "";
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                if (location != null) {
                    return location.latitude + "," + location.longitude + x.aQ + poiId;
                }
            } else {
                String cityCode = planNode.getCityCode() != null ? planNode.getCityCode() : "";
                String cityName = planNode.getCityName() != null ? planNode.getCityName() : "";
                if (planNode.getName() != null && planNode.getName().length() > 0) {
                    return planNode.getName() + x.aQ + poiId + x.aQ + cityName + x.aQ + cityCode;
                }
            }
        }
        return "";
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.b();
    }
}

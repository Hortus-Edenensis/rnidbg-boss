package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class et extends da<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String g;
    private final String h;
    private final String i;

    public et(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.g = "/direction/truck?";
        this.h = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        this.i = ",";
    }

    private static TruckRouteRestult c(String str) throws AMapException {
        return dq.m(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.b() + "/direction/truck?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        if (((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(di.a(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(di.a(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getOriginType());
            }
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getDestinationType());
            }
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getPlateProvince());
            }
            if (!dq.i(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getMode());
        if (((RouteSearch.TruckRouteQuery) ((cz) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getTruckAxis());
        if (TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) ((cz) this).b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((cz) this).b).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}

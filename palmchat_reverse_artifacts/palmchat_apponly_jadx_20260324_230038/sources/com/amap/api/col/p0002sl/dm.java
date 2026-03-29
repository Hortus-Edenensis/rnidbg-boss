package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dm extends da<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public dm(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult c(String str) throws AMapException {
        return dq.c(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        if (((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(di.a(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(di.a(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getOriginType());
            }
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationType());
            }
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateProvince());
            }
            if (!dq.i(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getMode());
        stringBuffer.append(sb.toString());
        if (TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) ((cz) this).b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getExtensions());
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) ((cz) this).b).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) ((cz) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((cz) this).b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((cz) this).b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(da.b(((RouteSearch.DriveRouteQuery) ((cz) this).b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) ((cz) this).b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((cz) this).b).getExclude());
        }
        return stringBuffer.toString();
    }
}

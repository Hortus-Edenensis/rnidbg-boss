package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dn extends da<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public dn(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 c(String str) throws AMapException {
        return dq.d(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.c() + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        if (((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(di.a(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
            if (!dq.i(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(di.a(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
            if (!dq.i(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!dq.i(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getOriginType());
            }
            if (!dq.i(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getMode().getValue());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(di.a(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) ((cz) this).b).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) ((cz) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((cz) this).b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((cz) this).b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(da.b(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((cz) this).b).getExclude());
        }
        return stringBuffer.toString();
    }
}

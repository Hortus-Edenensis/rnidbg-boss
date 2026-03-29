package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class en extends da<RouteSearchV2.RideRouteQuery, RideRouteResultV2> {
    public en(Context context, RouteSearchV2.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResultV2 c(String str) throws AMapException {
        return dq.k(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.c() + "/direction/bicycling?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        stringBuffer.append("&origin=");
        stringBuffer.append(di.a(((RouteSearchV2.RideRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(di.a(((RouteSearchV2.RideRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.RideRouteQuery) ((cz) this).b).getAlternativeRoute());
        stringBuffer.append("&output=json");
        stringBuffer.append("&show_fields=");
        stringBuffer.append(di.a(((RouteSearchV2.RideRouteQuery) ((cz) this).b).getShowFields()));
        return stringBuffer.toString();
    }
}

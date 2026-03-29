package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ev extends da<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    public ev(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    private static WalkRouteResultV2 c(String str) throws AMapException {
        return dq.f(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.c() + "/direction/walking?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        stringBuffer.append("&origin=");
        stringBuffer.append(di.a(((RouteSearchV2.WalkRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(di.a(((RouteSearchV2.WalkRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) ((cz) this).b).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) ((cz) this).b).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(di.a(((RouteSearchV2.WalkRouteQuery) ((cz) this).b).getShowFields()));
        return stringBuffer.toString();
    }
}

package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class db extends da<RouteSearch.BusRouteQuery, BusRouteResult> {
    public db(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult c(String str) throws AMapException {
        return dq.a(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        stringBuffer.append("&origin=");
        stringBuffer.append(di.a(((RouteSearch.BusRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(di.a(((RouteSearch.BusRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) ((cz) this).b).getCity();
        if (!dq.i(city)) {
            city = da.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!dq.i(((RouteSearch.BusRouteQuery) ((cz) this).b).getCity())) {
            String strB = da.b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(strB);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) ((cz) this).b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) ((cz) this).b).getNightFlag());
        if (TextUtils.isEmpty(((RouteSearch.BusRouteQuery) ((cz) this).b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) ((cz) this).b).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}

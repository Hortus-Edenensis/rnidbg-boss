package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dc extends da<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public dc(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResultV2 c(String str) throws AMapException {
        return dq.b(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.c() + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        stringBuffer.append("&origin=");
        stringBuffer.append(di.a(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(di.a(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getCity();
        if (!dq.i(city)) {
            city = da.b(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!dq.i(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getCity())) {
            String strB = da.b(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(strB);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(di.a(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) ((cz) this).b).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((cz) this).b).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}

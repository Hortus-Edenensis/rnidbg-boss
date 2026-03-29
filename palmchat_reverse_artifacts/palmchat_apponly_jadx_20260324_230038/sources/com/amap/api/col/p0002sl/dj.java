package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dj extends da<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String g;
    private final String h;
    private final String i;

    public dj(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.g = "/distance?";
        this.h = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        this.i = ",";
    }

    private static DistanceResult c(String str) throws AMapException {
        return dq.l(str);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/distance?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(((cz) this).e));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) ((cz) this).b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i = 0; i < size; i++) {
                LatLonPoint latLonPoint = origins.get(i);
                if (latLonPoint != null) {
                    double dA = di.a(latLonPoint.getLatitude());
                    stringBuffer.append(di.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(dA);
                    if (i < size) {
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) ((cz) this).b).getDestination();
        if (destination != null) {
            double dA2 = di.a(destination.getLatitude());
            double dA3 = di.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(dA3);
            stringBuffer.append(",");
            stringBuffer.append(dA2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) ((cz) this).b).getType());
        if (TextUtils.isEmpty(((DistanceSearch.DistanceQuery) ((cz) this).b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((cz) this).b).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) ((cz) this).b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((cz) this).b).getMode());
        }
        return stringBuffer.toString();
    }
}

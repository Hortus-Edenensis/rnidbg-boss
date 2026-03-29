package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fe implements IDistanceSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2745a = "fe";
    private Context b;
    private Handler c;
    private DistanceSearch.OnDistanceSearchListener d;

    public fe(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.b = context.getApplicationContext();
        this.c = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            dr.a(this.b);
            if (distanceQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (a(distanceQuery)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DistanceSearch.DistanceQuery distanceQueryClone = distanceQuery.m26clone();
            DistanceResult distanceResultB = new dj(this.b, distanceQueryClone).b();
            if (distanceResultB != null) {
                distanceResultB.setDistanceQuery(distanceQueryClone);
            }
            return distanceResultB;
        } catch (AMapException e) {
            di.a(e, f2745a, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fe.1
            @Override // java.lang.Runnable
            public final void run() {
                Message messageObtainMessage = dt.a().obtainMessage();
                messageObtainMessage.what = 400;
                messageObtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResultCalculateRouteDistance = null;
                try {
                    try {
                        distanceResultCalculateRouteDistance = fe.this.calculateRouteDistance(distanceQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    }
                } finally {
                    messageObtainMessage.obj = fe.this.d;
                    bundle.putParcelable("result", distanceResultCalculateRouteDistance);
                    messageObtainMessage.setData(bundle);
                    fe.this.c.sendMessage(messageObtainMessage);
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.d = onDistanceSearchListener;
    }

    private static boolean a(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }
}

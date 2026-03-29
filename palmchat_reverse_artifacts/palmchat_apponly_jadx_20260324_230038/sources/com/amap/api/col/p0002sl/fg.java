package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fg implements IGeocodeSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2749a;
    private GeocodeSearch.OnGeocodeSearchListener b;
    private Handler c;

    public fg(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2749a = context.getApplicationContext();
        this.c = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            dr.a(this.f2749a);
            if (a(regeocodeQuery)) {
                return new el(this.f2749a, regeocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            di.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fg.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    try {
                        try {
                            messageObtainMessage.arg1 = 2;
                            messageObtainMessage.what = 201;
                            dt.l lVar = new dt.l();
                            lVar.b = fg.this.b;
                            messageObtainMessage.obj = lVar;
                            lVar.f2711a = new RegeocodeResult(regeocodeQuery, fg.this.getFromLocation(regeocodeQuery));
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            messageObtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        fg.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            dr.a(this.f2749a);
            if (geocodeQuery != null) {
                return new Cdo(this.f2749a, geocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            di.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fg.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    try {
                        try {
                            messageObtainMessage.what = 200;
                            messageObtainMessage.arg1 = 2;
                            messageObtainMessage.arg2 = 1000;
                            dt.f fVar = new dt.f();
                            fVar.b = fg.this.b;
                            messageObtainMessage.obj = fVar;
                            fVar.f2705a = new GeocodeResult(geocodeQuery, fg.this.getFromLocationName(geocodeQuery));
                        } catch (AMapException e) {
                            messageObtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        fg.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    private static boolean a(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }
}

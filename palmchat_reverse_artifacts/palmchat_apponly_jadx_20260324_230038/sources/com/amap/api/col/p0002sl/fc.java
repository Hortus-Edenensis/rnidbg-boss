package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fc implements IBusStationSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2740a;
    private BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public fc(Context context, BusStationQuery busStationQuery) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2740a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            dr.a(this.f2740a);
            if (!a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.m18clone();
                this.f = 0;
                ArrayList<BusStationResult> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f == 0) {
                BusStationResult busStationResult = (BusStationResult) new dd(this.f2740a, this.c).b();
                this.f = busStationResult.getPageCount();
                a(busStationResult);
                return busStationResult;
            }
            BusStationResult busStationResultB = b(this.c.getPageNumber());
            if (busStationResultB != null) {
                return busStationResultB;
            }
            BusStationResult busStationResult2 = (BusStationResult) new dd(this.f2740a, this.c).b();
            this.e.set(this.c.getPageNumber(), busStationResult2);
            return busStationResult2;
        } catch (AMapException e) {
            di.a(e, "BusStationSearch", "searchBusStation");
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            di.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fc.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    try {
                        try {
                            messageObtainMessage.arg1 = 7;
                            dt.c cVar = new dt.c();
                            cVar.b = fc.this.b;
                            messageObtainMessage.obj = cVar;
                            BusStationResult busStationResultSearchBusStation = fc.this.searchBusStation();
                            messageObtainMessage.what = 1000;
                            cVar.f2702a = busStationResultSearchBusStation;
                        } catch (AMapException e) {
                            messageObtainMessage.what = e.getErrorCode();
                        }
                    } finally {
                        fc.this.g.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.c)) {
            return;
        }
        this.c = busStationQuery;
    }

    private void a(BusStationResult busStationResult) {
        int i;
        this.e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f;
            if (i2 > i) {
                break;
            }
            this.e.add(null);
            i2++;
        }
        if (i > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.c;
        return (busStationQuery == null || di.a(busStationQuery.getQueryString())) ? false : true;
    }
}

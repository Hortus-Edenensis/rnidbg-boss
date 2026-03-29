package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fl implements IRoutePOISearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RoutePOISearchQuery f2765a;
    private Context b;
    private RoutePOISearch.OnRoutePOISearchListener c;
    private Handler d;

    public fl(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.d = null;
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.b = context;
        this.f2765a = routePOISearchQuery;
        this.d = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f2765a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            dr.a(this.b);
            if (!a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new eo(this.b, this.f2765a.m39clone()).b();
        } catch (AMapException e) {
            di.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fl.1
            @Override // java.lang.Runnable
            public final void run() {
                dt.m mVar;
                Message messageObtainMessage = fl.this.d.obtainMessage();
                messageObtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResultSearchRoutePOI = null;
                try {
                    try {
                        routePOISearchResultSearchRoutePOI = fl.this.searchRoutePOI();
                        bundle.putInt("errorCode", 1000);
                        mVar = new dt.m();
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        mVar = new dt.m();
                    }
                    mVar.b = fl.this.c;
                    mVar.f2712a = routePOISearchResultSearchRoutePOI;
                    messageObtainMessage.obj = mVar;
                    messageObtainMessage.setData(bundle);
                    fl.this.d.sendMessage(messageObtainMessage);
                } catch (Throwable th) {
                    dt.m mVar2 = new dt.m();
                    mVar2.b = fl.this.c;
                    mVar2.f2712a = routePOISearchResultSearchRoutePOI;
                    messageObtainMessage.obj = mVar2;
                    messageObtainMessage.setData(bundle);
                    fl.this.d.sendMessage(messageObtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f2765a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    private boolean a() {
        RoutePOISearchQuery routePOISearchQuery = this.f2765a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f2765a.getFrom() == null && this.f2765a.getTo() == null && this.f2765a.getPolylines() == null) ? false : true;
    }
}

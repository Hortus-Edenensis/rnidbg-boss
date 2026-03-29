package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fj implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PoiSearch.SearchBound f2759a;
    private PoiSearch.Query b;
    private Context c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j;

    public fj(Context context, PoiSearch.Query query) throws AMapException {
        this.j = null;
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.c = context.getApplicationContext();
        setQuery(query);
        this.j = dt.a();
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            return bound.getCenter() != null;
        }
        if (!bound.getShape().equals("Polygon")) {
            if (!bound.getShape().equals("Rectangle")) {
                return true;
            }
            LatLonPoint lowerLeft = bound.getLowerLeft();
            LatLonPoint upperRight = bound.getUpperRight();
            return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
        }
        List<LatLonPoint> polyGonList = bound.getPolyGonList();
        if (polyGonList == null || polyGonList.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < polyGonList.size(); i2++) {
            if (polyGonList.get(i2) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.f2759a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            dr.a(this.c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearch.Query query = this.b;
            if (query == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query.queryEquals(this.f) && this.f2759a == null) || (!this.b.queryEquals(this.f) && !this.f2759a.equals(this.g))) {
                this.h = 0;
                this.f = this.b.m22clone();
                PoiSearch.SearchBound searchBound = this.f2759a;
                if (searchBound != null) {
                    this.g = searchBound.m23clone();
                }
                HashMap<Integer, PoiResult> map = i;
                if (map != null) {
                    map.clear();
                }
            }
            PoiSearch.SearchBound searchBound2 = this.f2759a;
            PoiSearch.SearchBound searchBoundClone = searchBound2 != null ? searchBound2.m23clone() : null;
            ek.a().a(this.b.getQueryString());
            this.b.setPageNum(ek.a().k(this.b.getPageNum()));
            this.b.setPageSize(ek.a().l(this.b.getPageSize()));
            if (this.h == 0) {
                PoiResult poiResultB = new ea(this.c, new ee(this.b.m22clone(), searchBoundClone)).b();
                a(poiResultB);
                return poiResultB;
            }
            PoiResult poiResultA = a(this.b.getPageNum());
            if (poiResultA != null) {
                return poiResultA;
            }
            PoiResult poiResultB2 = new ea(this.c, new ee(this.b.m22clone(), searchBoundClone)).b();
            i.put(Integer.valueOf(this.b.getPageNum()), poiResultB2);
            return poiResultB2;
        } catch (AMapException e) {
            di.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fj.1
                @Override // java.lang.Runnable
                public final void run() {
                    dt.j jVar;
                    Message messageObtainMessage = fj.this.j.obtainMessage();
                    messageObtainMessage.arg1 = 6;
                    messageObtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResultSearchPOI = null;
                    try {
                        try {
                            poiResultSearchPOI = fj.this.searchPOI();
                            bundle.putInt("errorCode", 1000);
                            jVar = new dt.j();
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            jVar = new dt.j();
                        }
                        jVar.b = fj.this.d;
                        jVar.f2709a = poiResultSearchPOI;
                        messageObtainMessage.obj = jVar;
                        messageObtainMessage.setData(bundle);
                        fj.this.j.sendMessage(messageObtainMessage);
                    } catch (Throwable th) {
                        dt.j jVar2 = new dt.j();
                        jVar2.b = fj.this.d;
                        jVar2.f2709a = poiResultSearchPOI;
                        messageObtainMessage.obj = jVar2;
                        messageObtainMessage.setData(bundle);
                        fj.this.j.sendMessage(messageObtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        dr.a(this.c);
        PoiSearch.Query query = this.b;
        return new dy(this.c, str, query != null ? query.m22clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fj.2
            @Override // java.lang.Runnable
            public final void run() {
                dt.h hVar;
                Message messageObtainMessage = dt.a().obtainMessage();
                messageObtainMessage.arg1 = 6;
                messageObtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItemSearchPOIId = null;
                try {
                    try {
                        poiItemSearchPOIId = fj.this.searchPOIId(str);
                        bundle.putInt("errorCode", 1000);
                        hVar = new dt.h();
                    } catch (AMapException e) {
                        di.a(e, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        hVar = new dt.h();
                    }
                    hVar.b = fj.this.d;
                    hVar.f2707a = poiItemSearchPOIId;
                    messageObtainMessage.obj = hVar;
                    messageObtainMessage.setData(bundle);
                    fj.this.j.sendMessage(messageObtainMessage);
                } catch (Throwable th) {
                    dt.h hVar2 = new dt.h();
                    hVar2.b = fj.this.d;
                    hVar2.f2707a = poiItemSearchPOIId;
                    messageObtainMessage.obj = hVar2;
                    messageObtainMessage.setData(bundle);
                    fj.this.j.sendMessage(messageObtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f2759a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    private boolean a() {
        PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        return (di.a(query.getQueryString()) && di.a(this.b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }

    private void a(PoiResult poiResult) {
        int i2;
        i = new HashMap<>();
        PoiSearch.Query query = this.b;
        if (query == null || poiResult == null || (i2 = this.h) <= 0 || i2 <= query.getPageNum()) {
            return;
        }
        i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
    }

    private PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }
}

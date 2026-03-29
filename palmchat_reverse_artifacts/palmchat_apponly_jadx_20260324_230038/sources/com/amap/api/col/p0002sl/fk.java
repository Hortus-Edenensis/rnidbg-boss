package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fk implements IPoiSearchV2 {
    private static HashMap<Integer, PoiResultV2> i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PoiSearchV2.SearchBound f2762a;
    private PoiSearchV2.Query b;
    private Context c;
    private PoiSearchV2.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearchV2.Query f;
    private PoiSearchV2.SearchBound g;
    private int h;
    private Handler j;

    public fk(Context context, PoiSearchV2.Query query) throws AMapException {
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
        PoiSearchV2.SearchBound bound = getBound();
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

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.SearchBound getBound() {
        return this.f2762a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiResultV2 searchPOI() throws AMapException {
        try {
            dr.a(this.c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearchV2.Query query = this.b;
            if (query == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query.queryEquals(this.f) && this.f2762a == null) || (!this.b.queryEquals(this.f) && !this.f2762a.equals(this.g))) {
                this.h = 0;
                this.f = this.b.m24clone();
                PoiSearchV2.SearchBound searchBound = this.f2762a;
                if (searchBound != null) {
                    this.g = searchBound.m25clone();
                }
                HashMap<Integer, PoiResultV2> map = i;
                if (map != null) {
                    map.clear();
                }
            }
            PoiSearchV2.SearchBound searchBound2 = this.f2762a;
            PoiSearchV2.SearchBound searchBoundClone = searchBound2 != null ? searchBound2.m25clone() : null;
            ek.a().a(this.b.getQueryString());
            this.b.setPageNum(ek.a().k(this.b.getPageNum()));
            this.b.setPageSize(ek.a().l(this.b.getPageSize()));
            if (this.h == 0) {
                PoiResultV2 poiResultV2B = new eb(this.c, new ef(this.b.m24clone(), searchBoundClone)).b();
                a(poiResultV2B);
                return poiResultV2B;
            }
            PoiResultV2 poiResultV2A = a(this.b.getPageNum());
            if (poiResultV2A != null) {
                return poiResultV2A;
            }
            PoiResultV2 poiResultV2B2 = new eb(this.c, new ef(this.b.m24clone(), searchBoundClone)).b();
            i.put(Integer.valueOf(this.b.getPageNum()), poiResultV2B2);
            return poiResultV2B2;
        } catch (AMapException e) {
            di.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fk.1
                @Override // java.lang.Runnable
                public final void run() {
                    dt.k kVar;
                    Message messageObtainMessage = fk.this.j.obtainMessage();
                    messageObtainMessage.arg1 = 19;
                    messageObtainMessage.what = 603;
                    Bundle bundle = new Bundle();
                    PoiResultV2 poiResultV2SearchPOI = null;
                    try {
                        try {
                            poiResultV2SearchPOI = fk.this.searchPOI();
                            bundle.putInt("errorCode", 1000);
                            kVar = new dt.k();
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            kVar = new dt.k();
                        }
                        kVar.b = fk.this.d;
                        kVar.f2710a = poiResultV2SearchPOI;
                        messageObtainMessage.obj = kVar;
                        messageObtainMessage.setData(bundle);
                        fk.this.j.sendMessage(messageObtainMessage);
                    } catch (Throwable th) {
                        dt.k kVar2 = new dt.k();
                        kVar2.b = fk.this.d;
                        kVar2.f2710a = poiResultV2SearchPOI;
                        messageObtainMessage.obj = kVar2;
                        messageObtainMessage.setData(bundle);
                        fk.this.j.sendMessage(messageObtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiItemV2 searchPOIId(String str) throws AMapException {
        dr.a(this.c);
        PoiSearchV2.Query query = this.b;
        return new dz(this.c, str, query != null ? query.m24clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIIdAsyn(final String str) {
        es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fk.2
            @Override // java.lang.Runnable
            public final void run() {
                dt.i iVar;
                Message messageObtainMessage = dt.a().obtainMessage();
                messageObtainMessage.arg1 = 19;
                messageObtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN;
                Bundle bundle = new Bundle();
                PoiItemV2 poiItemV2SearchPOIId = null;
                try {
                    try {
                        poiItemV2SearchPOIId = fk.this.searchPOIId(str);
                        bundle.putInt("errorCode", 1000);
                        iVar = new dt.i();
                    } catch (AMapException e) {
                        di.a(e, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        iVar = new dt.i();
                    }
                    iVar.b = fk.this.d;
                    iVar.f2708a = poiItemV2SearchPOIId;
                    messageObtainMessage.obj = iVar;
                    messageObtainMessage.setData(bundle);
                    fk.this.j.sendMessage(messageObtainMessage);
                } catch (Throwable th) {
                    dt.i iVar2 = new dt.i();
                    iVar2.b = fk.this.d;
                    iVar2.f2708a = poiItemV2SearchPOIId;
                    messageObtainMessage.obj = iVar2;
                    messageObtainMessage.setData(bundle);
                    fk.this.j.sendMessage(messageObtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f2762a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setQuery(PoiSearchV2.Query query) {
        this.b = query;
    }

    private boolean a() {
        PoiSearchV2.Query query = this.b;
        if (query == null) {
            return false;
        }
        return (di.a(query.getQueryString()) && di.a(this.b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearchV2.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }

    private void a(PoiResultV2 poiResultV2) {
        int i2;
        i = new HashMap<>();
        PoiSearchV2.Query query = this.b;
        if (query == null || poiResultV2 == null || (i2 = this.h) <= 0 || i2 <= query.getPageNum()) {
            return;
        }
        i.put(Integer.valueOf(this.b.getPageNum()), poiResultV2);
    }

    private PoiResultV2 a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }
}

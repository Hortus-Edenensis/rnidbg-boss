package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ff implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2747a;
    private DistrictSearchQuery b;
    private DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g;

    public ff(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2747a = context.getApplicationContext();
        this.g = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult districtResultA;
        int i;
        try {
            DistrictResult districtResult = new DistrictResult();
            dr.a(this.f2747a);
            if (!a()) {
                this.b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.b.m21clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.m21clone();
                HashMap<Integer, DistrictResult> map = f;
                if (map != null) {
                    map.clear();
                }
            }
            if (this.e == 0) {
                districtResultA = new dk(this.f2747a, this.b.m21clone()).b();
                if (districtResultA == null) {
                    return districtResultA;
                }
                this.e = districtResultA.getPageCount();
                a(districtResultA);
            } else {
                districtResultA = a(this.b.getPageNum());
                if (districtResultA == null) {
                    districtResultA = new dk(this.f2747a, this.b.m21clone()).b();
                    DistrictSearchQuery districtSearchQuery = this.b;
                    if (districtSearchQuery != null && districtResultA != null && (i = this.e) > 0 && i > districtSearchQuery.getPageNum()) {
                        f.put(Integer.valueOf(this.b.getPageNum()), districtResultA);
                    }
                }
            }
            return districtResultA;
        } catch (AMapException e) {
            di.a(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.ff.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(ff.this.b);
                    try {
                        try {
                            districtResult = ff.this.searchDistrict();
                            if (districtResult != null) {
                                districtResult.setAMapException(new AMapException());
                            }
                        } finally {
                            messageObtainMessage.arg1 = 4;
                            messageObtainMessage.obj = ff.this.c;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("result", districtResult);
                            messageObtainMessage.setData(bundle);
                            if (ff.this.g != null) {
                                ff.this.g.sendMessage(messageObtainMessage);
                            }
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        messageObtainMessage.arg1 = 4;
                        messageObtainMessage.obj = ff.this.c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        messageObtainMessage.setData(bundle2);
                        if (ff.this.g != null) {
                            ff.this.g.sendMessage(messageObtainMessage);
                        }
                    } catch (Throwable th) {
                        di.a(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                        messageObtainMessage.arg1 = 4;
                        messageObtainMessage.obj = ff.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        messageObtainMessage.setData(bundle3);
                        if (ff.this.g != null) {
                            ff.this.g.sendMessage(messageObtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    private void a(DistrictResult districtResult) {
        int i;
        f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery == null || districtResult == null || (i = this.e) <= 0 || i <= districtSearchQuery.getPageNum()) {
            return;
        }
        f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
    }

    private boolean b(int i) {
        return i < this.e && i >= 0;
    }

    private boolean a() {
        return this.b != null;
    }

    private DistrictResult a(int i) throws AMapException {
        if (b(i)) {
            return f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}

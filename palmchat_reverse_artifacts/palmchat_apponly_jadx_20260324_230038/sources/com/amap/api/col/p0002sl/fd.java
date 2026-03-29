package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fd implements ICloudSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2742a;
    private CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    private Handler f;

    public fd(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2742a = context.getApplicationContext();
        this.f = dt.a();
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fd.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    try {
                        try {
                            messageObtainMessage.arg1 = 12;
                            messageObtainMessage.what = 700;
                            dt.e eVar = new dt.e();
                            eVar.b = fd.this.b;
                            messageObtainMessage.obj = eVar;
                            eVar.f2704a = fd.this.a(query);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            messageObtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        fd.this.f.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fd.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    try {
                        try {
                            messageObtainMessage.arg1 = 12;
                            messageObtainMessage.what = 701;
                            dt.d dVar = new dt.d();
                            dVar.b = fd.this.b;
                            messageObtainMessage.obj = dVar;
                            dVar.f2703a = fd.this.a(str, str2);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            messageObtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        fd.this.f.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    private boolean b(int i) {
        return i <= this.d && i > 0;
    }

    private static boolean b(CloudSearch.Query query) {
        if (query == null || di.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        ?? r0;
        ?? r02 = 0;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (b(query)) {
            if (!query.queryEquals(this.c)) {
                this.d = 0;
                this.c = query.m19clone();
                HashMap<Integer, CloudResult> map = this.e;
                if (map != null) {
                    map.clear();
                }
            }
            ?? r1 = this.d;
            try {
            } catch (Throwable th2) {
                th = th2;
                r02 = r1;
                di.a(th, "CloudSearch", "searchCloud");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    r0 = r02;
                } else {
                    throw th;
                }
            }
            if (r1 == 0) {
                CloudResult cloudResultB = new dg(this.f2742a, query).b();
                a(cloudResultB, query);
                r1 = cloudResultB;
            } else {
                CloudResult cloudResultA = a(query.getPageNum());
                r0 = cloudResultA;
                if (cloudResultA == null) {
                    CloudResult cloudResultB2 = new dg(this.f2742a, query).b();
                    this.e.put(Integer.valueOf(query.getPageNum()), cloudResultB2);
                    r1 = cloudResultB2;
                }
                return r0;
            }
            return r1;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new df(this.f2742a, new ed(str, str2)).b();
                } catch (Throwable th) {
                    di.a(th, "CloudSearch", "searchCloudDetail");
                    if (!(th instanceof AMapException)) {
                        th.printStackTrace();
                        return null;
                    }
                    throw th;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> map = new HashMap<>();
        this.e = map;
        if (this.d > 0) {
            map.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private CloudResult a(int i) {
        if (b(i)) {
            return this.e.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }
}

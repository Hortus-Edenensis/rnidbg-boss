package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ei;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.je;
import com.huawei.hms.ads.jh;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.inner.NativeAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.listeners.j;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.al;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n implements i {
    private static final String V = "n";
    private String A;
    private a B;
    private final String[] C;
    boolean Code;
    private String D;
    private DelayInfo E;
    private j F;
    private List<String> I;
    private boolean L;
    private com.huawei.openalliance.ad.inter.listeners.n S;
    private com.huawei.openalliance.ad.inter.listeners.e Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6946a;
    private boolean b;
    private boolean c;
    private String d;
    private Context e;
    private int f;
    private RequestOptions g;
    private Location h;
    private Integer i;
    private int j;
    private String k;
    private String l;
    private Set<String> m;
    private int n;
    private Integer o;
    private Integer p;
    private Integer q;
    private NativeAdConfiguration r;
    private String s;
    private long t;
    private long u;
    private long v;
    private String w;
    private App x;
    private List<Integer> y;
    private Integer z;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        IDLE,
        LOADING
    }

    public n(Context context, String[] strArr, int i) {
        this(context, strArr, false);
        this.f = i;
    }

    public n(Context context, String[] strArr, int i, List<String> list) {
        this(context, strArr, false);
        this.f = i;
        this.I = list;
    }

    private List<AdContentData> I(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>> entry : map.entrySet()) {
            if (entry != null && !ag.Code(entry.getValue())) {
                for (com.huawei.openalliance.ad.inter.data.g gVar : entry.getValue()) {
                    if (gVar instanceof l) {
                        l lVar = (l) gVar;
                        if (99 == lVar.f()) {
                            AdContentData adContentDataQ = lVar.q();
                            if (adContentDataQ != null) {
                                adContentDataQ.b(true);
                            }
                            arrayList.add(adContentDataQ);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void B(Integer num) {
        this.z = num;
        this.E.I(num);
    }

    public void C(String str) {
        fh.V(V, "setJssdkVersion: %s", str);
        this.d = str;
    }

    public n(Context context, String[] strArr, boolean z) {
        this.B = a.IDLE;
        this.c = false;
        this.f = 3;
        this.E = new DelayInfo();
        if (!z.Code(context)) {
            this.C = new String[0];
            return;
        }
        this.e = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.C = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.C = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        this.L = z;
    }

    public void I(int i) {
        this.f = i;
    }

    public void V(int i) {
        this.n = i;
    }

    public void Z(Integer num) {
        this.i = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(Integer num) {
        this.q = num;
    }

    public void V(final int i, final boolean z) {
        String str = V;
        fh.V(str, "onAdFailed, errorCode:" + i);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.E.j().D(jCurrentTimeMillis);
        if (!this.Code) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.n.5
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.inter.listeners.n nVar = n.this.S;
                    n.this.u = System.currentTimeMillis();
                    n.this.E.j().V(n.this.u);
                    long j = n.this.u - jCurrentTimeMillis;
                    n.this.E.D(j);
                    fh.V(n.V, "onAdFailed main thread switch: %s ms", Long.valueOf(j));
                    if (nVar != null) {
                        nVar.Code(i);
                    }
                    j jVar = n.this.F;
                    if (jVar != null) {
                        jVar.Code(i, z);
                    }
                    db.Code(n.this.e, i, n.this.w, n.this.f, null, n.this.u - n.this.t, n.this.E);
                }
            });
            return;
        }
        fh.V(str, "onAdFailed thread");
        com.huawei.openalliance.ad.inter.listeners.n nVar = this.S;
        if (nVar != null) {
            nVar.Code(i);
        }
        j jVar = this.F;
        if (jVar != null) {
            jVar.Code(i, z);
        }
        db.Code(this.e, i, this.w, this.f, null, this.t, jCurrentTimeMillis, this.v);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Z(String str) {
        this.A = str;
    }

    public Map<String, List<com.huawei.openalliance.ad.inter.data.g>> Code(Context context, Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        try {
            Map<String, String> mapAs = eh.Code(context).as();
            if (!al.Code(mapAs) && !al.Code(map)) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>> entry : map.entrySet()) {
                    if (mapAs.containsKey(entry.getKey())) {
                        fh.V(V, "slot is special");
                        arrayList.clear();
                        int iIntValue = bc.F(mapAs.get(entry.getKey())) == null ? 0 : bc.F(mapAs.get(entry.getKey())).intValue();
                        if (Code(context, entry.getKey(), entry.getValue(), iIntValue, arrayList)) {
                            map.put(entry.getKey(), arrayList.subList(0, Math.min(iIntValue, arrayList.size())));
                        } else {
                            arrayList.clear();
                            map.put(entry.getKey(), arrayList);
                        }
                    }
                }
            }
            return map;
        } catch (Throwable th) {
            fh.Z(V, "handleSpecialSlot err: %s", th.getClass().getSimpleName());
            return map;
        }
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(String str) {
        this.l = str;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(Integer num) {
        this.p = num;
    }

    public void Z(boolean z) {
        fh.V(V, "setSupportTptAd: %s", Boolean.valueOf(z));
        this.c = z;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i) {
        this.j = i;
    }

    public void I(boolean z) {
        this.Code = z;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(String str) {
        this.k = str;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i, String str, boolean z) {
        this.t = System.currentTimeMillis();
        this.E.j().Code(this.t);
        String str2 = V;
        fh.V(str2, "loadAds");
        if (!z.Code(this.e)) {
            V(1001, true);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.B) {
            fh.V(str2, "waiting for request finish");
            V(701, true);
            return;
        }
        String[] strArr = this.C;
        if (strArr == null || strArr.length == 0) {
            fh.I(str2, "empty ad ids");
            V(702, true);
            return;
        }
        if (this.x != null && !z.I(this.e)) {
            fh.I(str2, "hms ver not support set appInfo.");
            V(706, true);
            return;
        }
        ai.Code(this.e, this.g);
        this.B = aVar;
        final AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.C)).V(i).Code(str).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.e)).Z(com.huawei.openalliance.ad.utils.d.B(this.e)).Code(z).Code(com.huawei.hms.ads.utils.c.Code(this.g)).Code(this.h).C(this.f).S(this.j).V(this.k).B(this.n).Code(this.m).I(this.l).Code(this.o).Code(this.x).C(this.i).Z(this.s).V(this.y).C(this.A).Z(this.c);
        Integer num = this.p;
        if (num != null && this.q != null) {
            aVar2.V(num);
            aVar2.I(this.q);
        }
        Integer num2 = this.z;
        if (num2 != null) {
            aVar2.S(num2);
        }
        if (this.r != null) {
            aVar2.V(!r11.isReturnUrlsForImages());
            aVar2.I(this.r.isRequestMultiImages());
        }
        String str3 = this.d;
        if (str3 != null) {
            aVar2.S(str3);
        }
        final NativeAdReqParam nativeAdReqParam = new NativeAdReqParam();
        nativeAdReqParam.I(this.D);
        nativeAdReqParam.V(this.f6946a);
        nativeAdReqParam.Code(this.L);
        nativeAdReqParam.I(this.b);
        nativeAdReqParam.Code(this.I);
        nativeAdReqParam.Code(this.t);
        BaseAdReqParam baseAdReqParamCode = com.huawei.openalliance.ad.utils.c.Code(this.e);
        if (baseAdReqParamCode != null) {
            nativeAdReqParam.V(baseAdReqParamCode.I());
            nativeAdReqParam.Code(baseAdReqParamCode.V());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.E.Z(System.currentTimeMillis() - jCurrentTimeMillis);
                n.this.Code(aVar2, nativeAdReqParam);
            }
        });
    }

    public void V(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        if (al.Code(map)) {
            fh.Code(V, "nativeAdsMap is empty");
            return false;
        }
        List<AdContentData> listI = I(map);
        if (ag.Code(listI)) {
            fh.Code(V, "tpt ads is empty");
            return false;
        }
        if (com.huawei.openalliance.ad.utils.c.V() && com.huawei.hms.ads.h.V() != null) {
            try {
                Bundle bundle = new Bundle();
                String strV = ad.V(listI);
                fh.Code(V, "contentJson : %s", strV);
                bundle.putBoolean(bq.f.q, this.L);
                bundle.putBoolean("directCacheVideo", this.b);
                com.huawei.hms.ads.h.V().Code(strV, bundle);
                return true;
            } catch (Throwable th) {
                fh.I(V, "down err: %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public void Code(int i, boolean z) {
        Code(i, (String) null, z);
    }

    private void Code(final Context context, final String str, final int i, final int i2) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.n.6
            @Override // java.lang.Runnable
            public void run() {
                db.Code(context, str, i, i2);
            }
        });
    }

    public void Code(Location location) {
        this.h = location;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(RequestOptions requestOptions) {
        this.g = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.x = app;
        }
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.r = nativeAdConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, NativeAdReqParam nativeAdReqParam) {
        je.Code(this.e.getApplicationContext(), "reqNativeAd", aVar.S(), ad.V(nativeAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.n.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                n.this.v = System.currentTimeMillis();
                n.this.E.j().c(n.this.v);
                boolean zBooleanValue = false;
                if (callResult.getCode() == 200) {
                    Map map = (Map) ad.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    if (map == null || map.size() <= 0) {
                        n.this.V(204, true);
                    } else {
                        HashMap map2 = new HashMap(map.size());
                        boolean zAf = false;
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ei.Code(n.this.e).Code(0);
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (n.this.w == null) {
                                        n.this.w = adContentData.M();
                                    }
                                    if (com.huawei.openalliance.ad.utils.c.Code(n.this.e, adContentData.aV(), adContentData.L(), adContentData.Z())) {
                                        fh.Code(n.V, "set creativeType to %s", 99);
                                        adContentData.a(99);
                                    }
                                    l lVar = new l(adContentData);
                                    lVar.Code(n.this.r);
                                    arrayList.add(lVar);
                                    if (!zAf) {
                                        zAf = adContentData.af();
                                    }
                                    com.huawei.openalliance.ad.utils.c.Code(n.this.e, adContentData);
                                    jh.Code(n.this.e).V();
                                }
                                map2.put(str2, arrayList);
                            }
                        }
                        n.this.Code(map2, zAf);
                        zBooleanValue = zAf;
                    }
                } else if (callResult.getCode() == 602) {
                    List<String> list2 = (List) ad.V(callResult.getMsg(), List.class, new Class[0]);
                    if (n.this.Z != null && list2 != null) {
                        fh.Code(n.V, "InValidContentIdsGot: %s", list2.toString());
                        n.this.Z.Code(list2);
                    }
                } else if (callResult.getCode() == 204) {
                    com.huawei.openalliance.ad.utils.c.Code(n.this.e, callResult.getMsg());
                    jh.Code(n.this.e).V();
                } else {
                    zBooleanValue = Boolean.valueOf(callResult.getMsg()).booleanValue();
                    if (-10 != callResult.getCode()) {
                        n.this.V(callResult.getCode(), zBooleanValue);
                    }
                }
                if (zBooleanValue) {
                    n.this.B = a.IDLE;
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(com.huawei.openalliance.ad.inter.listeners.e eVar) {
        this.Z = eVar;
    }

    public void Code(j jVar) {
        this.F = jVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(com.huawei.openalliance.ad.inter.listeners.n nVar) {
        this.S = nVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Integer num) {
        this.o = num;
    }

    public void Code(String str) {
        this.D = str;
    }

    public void Code(List<Integer> list) {
        this.y = list;
    }

    private void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        com.huawei.openalliance.ad.utils.i.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.n.4
            @Override // java.lang.Runnable
            public void run() {
                n.this.V((Map<String, List<com.huawei.openalliance.ad.inter.data.g>>) map);
            }
        });
    }

    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, final boolean z) {
        String str = V;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.S);
        sb.append(" innerlistener: ");
        sb.append(this.F);
        fh.V(str, sb.toString());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.E.j().D(jCurrentTimeMillis);
        if (this.Code) {
            this.E.L(jCurrentTimeMillis);
            fh.V(str, "onAdsLoaded thread");
            com.huawei.openalliance.ad.inter.listeners.n nVar = this.S;
            if (nVar != null) {
                nVar.Code(Code(this.e, map));
            }
            j jVar = this.F;
            if (jVar != null) {
                jVar.Code(map, z);
            }
            db.Code(this.e, 200, this.w, this.f, map, this.t, jCurrentTimeMillis, this.v);
        } else {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.n.3
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.inter.listeners.n nVar2 = n.this.S;
                    n.this.u = System.currentTimeMillis();
                    n.this.E.j().V(n.this.u);
                    long j = n.this.u - jCurrentTimeMillis;
                    n.this.E.D(j);
                    fh.V(n.V, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j));
                    if (nVar2 != null) {
                        n nVar3 = n.this;
                        nVar2.Code(nVar3.Code(nVar3.e, map));
                    }
                    j jVar2 = n.this.F;
                    if (jVar2 != null) {
                        jVar2.Code(map, z);
                    }
                    db.Code(n.this.e, 200, n.this.w, n.this.f, map, n.this.u - n.this.t, n.this.E);
                }
            });
        }
        Code(map);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Set<String> set) {
        this.m = set;
    }

    public void Code(boolean z) {
        this.f6946a = z;
    }

    public boolean Code(Context context, String str, List<com.huawei.openalliance.ad.inter.data.g> list, int i, List<com.huawei.openalliance.ad.inter.data.g> list2) {
        if (ag.Code(list)) {
            Code(context, str, list.size(), list2.size());
            fh.V(V, "nativeAdList is null");
            return false;
        }
        for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
            if (z.V(gVar.q())) {
                list2.add(gVar);
            }
        }
        if (list2.size() >= i) {
            return true;
        }
        fh.V(V, "satisfyAdList.size is %s, not enough", Integer.valueOf(list2.size()));
        Code(context, str, list.size(), list2.size());
        return false;
    }
}

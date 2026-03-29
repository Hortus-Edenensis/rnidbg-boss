package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.je;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.al;
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
public class r {
    private com.huawei.openalliance.ad.inter.listeners.q B;
    private RequestOptions C;
    private String D;
    private int F;
    private final String[] I;
    private String L;
    private Location S;
    private Context V;
    private a Z = a.IDLE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f6949a;
    private String b;
    private long c;
    private long d;
    private long e;
    private App f;
    private Integer g;
    private String h;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        IDLE,
        LOADING
    }

    public r(Context context, String[] strArr) {
        if (!z.Code(context)) {
            this.I = new String[0];
            return;
        }
        this.V = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.I = new String[0];
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.I = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void I(String str) {
        this.L = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i) {
        fh.V("RewardAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.r.3
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.q qVar = r.this.B;
                r.this.d = System.currentTimeMillis();
                if (qVar != null) {
                    qVar.Code(i);
                }
                db.Code(r.this.V, i, r.this.b, 7, null, r.this.c, r.this.d, r.this.e);
            }
        });
    }

    public void V(String str) {
        this.D = str;
    }

    public void Code(int i) {
        this.F = i;
    }

    public void Code(int i, boolean z) {
        this.c = z.Code();
        fh.V("RewardAdLoader", "loadAds");
        if (!z.Code(this.V)) {
            V(1001);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.Z) {
            fh.V("RewardAdLoader", "waiting for request finish");
            V(901);
            return;
        }
        String[] strArr = this.I;
        if (strArr == null || strArr.length == 0) {
            fh.I("RewardAdLoader", "empty ad ids");
            V(902);
            return;
        }
        if (this.f != null && !z.I(this.V)) {
            fh.I("RewardAdLoader", "hms ver not support set appInfo.");
            V(706);
            return;
        }
        ai.Code(this.V, this.C);
        this.Z = aVar;
        AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.I)).V(i).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.V)).Z(com.huawei.openalliance.ad.utils.d.B(this.V)).Code(this.S).Code(com.huawei.hms.ads.utils.c.Code(this.C)).Code(z).S(this.F).V(this.D).Code(this.f6949a).Code(this.f).I(this.L).C(this.h);
        Integer num = this.g;
        if (num != null) {
            aVar2.S(num);
        }
        BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
        baseAdReqParam.Code(this.c);
        je.Code(this.V, "reqRewardAd", aVar2.S(), ad.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.r.1
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                r rVar;
                int code;
                r.this.e = System.currentTimeMillis();
                if (callResult.getCode() == 200) {
                    Map map = (Map) ad.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    code = 204;
                    if (map != null && map.size() > 0) {
                        HashMap map2 = new HashMap(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (r.this.b == null) {
                                        r.this.b = adContentData.M();
                                    }
                                    arrayList.add(new com.huawei.openalliance.ad.inter.data.q(adContentData));
                                }
                                map2.put(str2, arrayList);
                            }
                        }
                        if (!al.Code(map2)) {
                            r.this.Code(map2);
                            r.this.Z = a.IDLE;
                        }
                    }
                    rVar = r.this;
                } else {
                    rVar = r.this;
                    code = callResult.getCode();
                }
                rVar.V(code);
                r.this.Z = a.IDLE;
            }
        }, String.class);
    }

    public void Code(Location location) {
        this.S = location;
    }

    public void Code(RequestOptions requestOptions) {
        this.C = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.f = app;
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.q qVar) {
        this.B = qVar;
    }

    public void Code(Integer num) {
        this.g = num;
    }

    public void Code(String str) {
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.B);
        fh.V("RewardAdLoader", sb.toString());
        if (this.B == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.r.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.q qVar = r.this.B;
                r.this.d = System.currentTimeMillis();
                if (qVar != null) {
                    qVar.Code(map);
                }
                db.Code(r.this.V, 200, r.this.b, 7, map, r.this.c, r.this.d, r.this.e);
            }
        });
    }

    public void Code(Set<String> set) {
        this.f6949a = set;
    }
}

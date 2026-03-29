package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.je;
import com.huawei.hms.ads.jh;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.inner.PlacementAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.p;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class q {
    private p B;
    private int C;
    private boolean D;
    private int F;
    private Context I;
    private boolean L;
    private String S;
    private b V;
    private final String[] Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RequestOptions f6947a;
    private Location b;
    private String c;
    private long d;
    private long e;
    private long f;
    private int g;
    private String h;
    private String i;
    private Set<String> j;
    private Integer k;
    private String l;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private int B;
        private boolean C;
        private Context Code;
        private Location D;
        private RequestOptions F;
        private int I = 4;
        private Integer L;
        private boolean S;
        private String[] V;
        private String Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6948a;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        public int B() {
            return this.B;
        }

        public boolean C() {
            return this.C;
        }

        public Context F() {
            return this.Code;
        }

        public int I() {
            return this.I;
        }

        public boolean S() {
            return this.S;
        }

        public a Code(int i) {
            this.I = i;
            return this;
        }

        public a V(boolean z) {
            this.S = z;
            return this;
        }

        public String Z() {
            return this.Z;
        }

        public a Code(Location location) {
            this.D = location;
            return this;
        }

        public String[] V() {
            String[] strArr = this.V;
            return strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : new String[0];
        }

        public a Code(RequestOptions requestOptions) {
            this.F = requestOptions;
            return this;
        }

        public a Code(Integer num) {
            this.L = num;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public a Code(boolean z) {
            this.C = z;
            return this;
        }

        public a Code(String[] strArr) {
            if (strArr != null) {
                this.V = (String[]) Arrays.copyOf(strArr, strArr.length);
            } else {
                this.V = null;
            }
            return this;
        }

        public q Code() {
            return new q(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        IDLE,
        LOADING
    }

    private q(a aVar) {
        this.V = b.IDLE;
        if (!z.Code(aVar.Code)) {
            this.Z = new String[0];
            return;
        }
        this.I = aVar.F();
        String[] strArrV = aVar.V();
        if (ag.Code(strArrV)) {
            this.Z = new String[0];
        } else {
            String[] strArr = new String[strArrV.length];
            this.Z = strArr;
            System.arraycopy(strArrV, 0, strArr, 0, strArrV.length);
        }
        this.C = aVar.I();
        this.S = aVar.Z();
        this.F = aVar.B();
        this.D = aVar.C();
        this.L = aVar.S();
        this.b = aVar.D;
        this.f6947a = aVar.F;
        this.k = aVar.L;
        this.l = aVar.f6948a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final int i) {
        fh.V("PlacementAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B != null) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.q.4
                @Override // java.lang.Runnable
                public void run() {
                    p pVar = q.this.B;
                    q.this.e = System.currentTimeMillis();
                    if (pVar != null) {
                        pVar.I(i);
                    }
                    db.Code(q.this.I, i, q.this.c, 60, null, q.this.d, q.this.e, q.this.f);
                }
            });
        }
    }

    private boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            fh.I("PlacementAdLoader", "extra info is not json string");
            return false;
        }
    }

    public void I(String str) {
        this.i = str;
    }

    public void V(int i) {
        this.g = i;
    }

    public void V(String str) {
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, PlacementAdReqParam placementAdReqParam) {
        je.Code(this.I, "reqPlaceAd", aVar.S(), ad.V(placementAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.q.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                q qVar;
                int code;
                q.this.f = System.currentTimeMillis();
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
                                    if (q.this.c == null) {
                                        q.this.c = adContentData.M();
                                    }
                                    arrayList.add(new com.huawei.openalliance.ad.inter.data.n(adContentData));
                                    com.huawei.openalliance.ad.utils.c.Code(q.this.I, adContentData);
                                    jh.Code(q.this.I).V();
                                }
                                map2.put(str2, arrayList);
                            }
                        }
                        if (!al.Code(map2)) {
                            q.this.Code(map2);
                            q.this.V = b.IDLE;
                        }
                    }
                    qVar = q.this;
                } else {
                    qVar = q.this;
                    code = callResult.getCode();
                }
                qVar.I(code);
                q.this.V = b.IDLE;
            }
        }, String.class);
    }

    public void Code(p pVar) {
        this.B = pVar;
        Code(false, 300, 1);
    }

    public void Code(p pVar, int i) {
        Code(pVar, i, 0);
    }

    public void Code(p pVar, int i, int i2) {
        this.B = pVar;
        Code(false, i, i2);
    }

    public void Code(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map == null ? 0 : map.size());
        fh.V("PlacementAdLoader", sb.toString());
        if (this.B != null) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.q.3
                @Override // java.lang.Runnable
                public void run() {
                    p pVar = q.this.B;
                    q.this.e = System.currentTimeMillis();
                    if (pVar != null) {
                        pVar.Code(map);
                    }
                    db.Code(q.this.I, 200, q.this.c, 60, map, q.this.d, q.this.e, q.this.f);
                }
            });
        }
    }

    public void Code(Set<String> set) {
        this.j = set;
    }

    private void Code(boolean z, int i, int i2) {
        this.d = z.Code();
        fh.V("PlacementAdLoader", "loadAds");
        if (!z.Code(this.I)) {
            fh.I("PlacementAdLoader", "api level too low");
            I(1001);
            return;
        }
        if (!Z(this.S)) {
            fh.I("PlacementAdLoader", "extra info is invalid");
            I(804);
            return;
        }
        b bVar = b.LOADING;
        if (bVar == this.V) {
            fh.V("PlacementAdLoader", "waiting for request finish");
            I(801);
            return;
        }
        String[] strArr = this.Z;
        if (strArr == null || strArr.length == 0) {
            fh.I("PlacementAdLoader", "empty ad ids");
            I(802);
            return;
        }
        if (i <= 0) {
            fh.I("PlacementAdLoader", "invalid totalDuration.");
            I(804);
            return;
        }
        if (i2 < 0) {
            fh.I("PlacementAdLoader", "invalid maxCount");
            I(804);
            return;
        }
        this.V = bVar;
        ai.Code(this.I, this.f6947a);
        Video video = new Video(this.F);
        final AdSlotParam.a aVar = new AdSlotParam.a();
        aVar.Code(Arrays.asList(this.Z)).V(this.C).Code(Boolean.valueOf(z)).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.I)).Z(com.huawei.openalliance.ad.utils.d.B(this.I)).Code(this.D).Code(com.huawei.hms.ads.utils.c.Code(this.f6947a)).Code(this.b).B(i2).D(i).C(this.l).Code(video);
        Integer num = this.k;
        if (num != null) {
            aVar.S(num);
        }
        final PlacementAdReqParam placementAdReqParam = new PlacementAdReqParam();
        placementAdReqParam.I(this.S);
        placementAdReqParam.Code(this.L);
        placementAdReqParam.Code(this.d);
        BaseAdReqParam baseAdReqParamCode = com.huawei.openalliance.ad.utils.c.Code(this.I);
        if (baseAdReqParamCode != null) {
            placementAdReqParam.V(baseAdReqParamCode.I());
            placementAdReqParam.Code(baseAdReqParamCode.V());
        }
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.Code(aVar, placementAdReqParam);
            }
        });
    }
}

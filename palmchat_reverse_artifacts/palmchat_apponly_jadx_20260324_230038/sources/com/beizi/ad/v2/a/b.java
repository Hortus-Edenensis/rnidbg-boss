package com.beizi.ad.v2.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.internal.f;
import com.beizi.ad.lance.a.c;
import com.beizi.ad.model.f;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.huawei.hms.ads.ld;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    private String G;
    private String H;
    private Map<String, Object> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f4518a;
    protected com.beizi.ad.internal.b b;
    protected com.beizi.ad.internal.d.a c;
    protected boolean d;
    protected String e;
    protected String f;
    protected String k;
    protected String l;
    protected f m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected com.beizi.ad.internal.a.b r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected boolean v;
    protected EventBean w;
    protected boolean x;
    protected String y;
    protected AdSpacesBean.BuyerBean z;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    private boolean J = false;
    protected Handler F = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.v2.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 16) {
                return;
            }
            b.this.n();
        }
    };

    public b(Context context, f fVar) {
        this.b = null;
        this.f4518a = context.getApplicationContext();
        String strA = n.a();
        this.l = strA;
        this.k = strA;
        this.m = fVar;
        com.beizi.ad.internal.b bVar = new com.beizi.ad.internal.b(context, this.l);
        this.b = bVar;
        bVar.a(fVar);
    }

    private void u() {
        if (this.q <= 0) {
            return;
        }
        v();
        int i = this.p;
        if (i <= 0) {
            n();
            return;
        }
        Handler handler = this.F;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(16, i);
        }
    }

    private void v() {
        Object obj;
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(this.y);
        Map<String, Object> map = this.I;
        if (map != null && map.containsKey("orderList") && (obj = this.I.get("orderList")) != null && (obj instanceof List)) {
            List<String> list = (List) obj;
            if (list.size() > 0) {
                bVar.a(list);
            }
        }
        com.beizi.ad.internal.a.a.a().a(this.w, this.q, bVar, this.m);
    }

    private void w() {
        if (this.v || !this.t || this.u) {
            return;
        }
        this.v = true;
        com.beizi.ad.internal.a.a.a().a(this.r, 1, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.beizi.ad.model.b x() {
        Object obj;
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(this.y);
        bVar.b(this.l);
        bVar.a(false);
        Map<String, Object> map = this.I;
        if (map != null && map.containsKey("orderList") && (obj = this.I.get("orderList")) != null && (obj instanceof List)) {
            List<String> list = (List) obj;
            if (list.size() > 0) {
                bVar.a(list);
            }
        }
        return bVar;
    }

    private void y() {
        c.b().d().execute(new Runnable() { // from class: com.beizi.ad.v2.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventBean eventBeanM43clone = b.this.w.m43clone();
                    eventBeanM43clone.setEventCode("280.000");
                    if (b.this.t) {
                        eventBeanM43clone.setIsCacheAd("1");
                    }
                    EventCar.getInstance(b.this.f4518a).goRoad(eventBeanM43clone);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void a(com.beizi.ad.internal.d.a aVar) {
    }

    public void b(int i) {
    }

    public void c() {
    }

    public String d() {
        return this.y;
    }

    public String e() {
        return this.l;
    }

    public boolean f() {
        return this.x;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public boolean j() {
        return this.d;
    }

    public Map k() {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.B();
    }

    public String l() {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.C();
    }

    public com.beizi.ad.internal.d.a m() {
        return this.c;
    }

    public boolean n() {
        com.beizi.ad.internal.d.a aVarA;
        if (this.J) {
            return false;
        }
        this.J = true;
        if (this.q <= 0 || this.s) {
            return false;
        }
        try {
            com.beizi.ad.internal.a.b bVarB = com.beizi.ad.internal.a.a.a().b(d());
            if (bVarB == null || (aVarA = com.beizi.ad.internal.a.a.a().a(bVarB, this.m)) == null) {
                return false;
            }
            if (this.s) {
                com.beizi.ad.internal.a.a.a().a(bVarB, 1, this.q);
                return false;
            }
            if (!a(aVarA, bVarB)) {
                return false;
            }
            a(false, null, bVarB, aVarA);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean o() {
        return this.t;
    }

    public long p() {
        com.beizi.ad.internal.a.b bVar;
        try {
            if (this.t && (bVar = this.r) != null) {
                return bVar.b();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void q() {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar != null) {
            aVar.d(false);
        }
        w();
        r();
    }

    public void r() {
        Handler handler = this.F;
        if (handler != null) {
            handler.removeMessages(16);
        }
    }

    public int s() {
        int i = this.n;
        if (i <= 0) {
            return 5;
        }
        return i;
    }

    public JSONObject t() {
        int iIntValue;
        try {
            Map<String, Object> map = this.I;
            if (map == null || !map.containsKey("materialInfo")) {
                return null;
            }
            Object obj = this.I.get("materialInfo");
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) == 0) {
                return null;
            }
            if (iIntValue != 1 && iIntValue != 101 && iIntValue != 1001) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.c != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (iIntValue == 1 || iIntValue == 101 || iIntValue == 1001) {
                    f fVar = this.m;
                    String strD = (fVar == f.NEW_SPLASH || fVar == f.NATIVE) ? this.c.D() : (fVar == f.INTERSTITIAL || fVar == f.REWARDEDVIDEO) ? this.c.w() : fVar == f.SPLASHUNIFIED ? this.c.F() : null;
                    if (!TextUtils.isEmpty(strD) && strD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        jSONObject2.put(ld.f6599a, strD);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(strD);
                        jSONObject2.put("imageUrls", jSONArray);
                    }
                    String strX = this.c.x();
                    if (!TextUtils.isEmpty(strX)) {
                        jSONObject2.put("videoUrl", strX);
                    }
                    String strS = this.c.S();
                    if (!TextUtils.isEmpty(strS)) {
                        jSONObject2.put("crid", strS);
                    }
                }
                if (iIntValue == 101 || iIntValue == 1001) {
                    String strM = this.c.M();
                    if (!TextUtils.isEmpty(strM)) {
                        jSONObject2.put("deeplinkUrl", strM);
                    }
                    String strN = this.c.N();
                    if (!TextUtils.isEmpty(strN)) {
                        jSONObject2.put("landingPageUrl", strN);
                    }
                    String strO = this.c.O();
                    if (!TextUtils.isEmpty(strO)) {
                        jSONObject2.put("downloadUrl", strO);
                    }
                    String strP = this.c.P();
                    if (!TextUtils.isEmpty(strP)) {
                        jSONObject2.put("miniProgramId", strP);
                    }
                    String strQ = this.c.Q();
                    if (!TextUtils.isEmpty(strQ)) {
                        jSONObject2.put("miniProgramPath", strQ);
                    }
                }
                if (iIntValue == 1001) {
                    String strR = this.c.R();
                    if (!TextUtils.isEmpty(strR)) {
                        jSONObject2.put("orderId", strR);
                    }
                }
                jSONObject.put("materialInfo", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (TextUtils.isEmpty(this.G)) {
            if ("S2S".equalsIgnoreCase(this.H)) {
                b(3);
                return;
            } else {
                u();
                c.b().c().execute(new Runnable() { // from class: com.beizi.ad.v2.a.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        new com.beizi.ad.v2.e.b().a(b.this.x(), new com.beizi.ad.v2.e.a() { // from class: com.beizi.ad.v2.a.b.2.1
                            @Override // com.beizi.ad.v2.e.a
                            public void a(String str) {
                                try {
                                    com.beizi.ad.internal.d.a aVar = new com.beizi.ad.internal.d.a(str, null, b.this.b.a());
                                    b bVar = b.this;
                                    if (bVar.t) {
                                        bVar.a(aVar, str);
                                        return;
                                    }
                                    bVar.r();
                                    if (aVar.d()) {
                                        b.this.a(true, aVar.H(), null, aVar);
                                    } else {
                                        if (b.this.n()) {
                                            return;
                                        }
                                        b.this.b(3);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override // com.beizi.ad.v2.e.a
                            public void a(int i) {
                                b bVar = b.this;
                                bVar.h = false;
                                if (bVar.t) {
                                    return;
                                }
                                bVar.r();
                                if (b.this.n()) {
                                    return;
                                }
                                b.this.b(i);
                            }
                        });
                    }
                });
                return;
            }
        }
        com.beizi.ad.internal.d.a aVar = new com.beizi.ad.internal.d.a(this.G, null, this.b.a());
        if (!aVar.d()) {
            b(3);
        } else if (!a(aVar.i())) {
            b(12);
        } else {
            this.l = aVar.L();
            a(true, aVar.H(), null, aVar);
        }
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.G = str;
    }

    public void e(String str) {
        this.H = str;
    }

    public void c(Map<String, Object> map) {
        this.I = map;
    }

    public void a(int i) {
        this.o = i;
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        if (buyerBean == null) {
            return;
        }
        this.z = buyerBean;
        int cacheNum = buyerBean.getCacheNum();
        this.q = cacheNum;
        if (cacheNum > 0) {
            int waitTime = buyerBean.getWaitTime();
            int lastTime = buyerBean.getLastTime();
            if (lastTime <= 0) {
                lastTime = 100;
            }
            if (waitTime >= 0) {
                this.p = Math.min(waitTime, this.o - lastTime);
            } else {
                this.p = this.o - lastTime;
            }
            if (this.p <= 0) {
                this.p = 100;
            }
        }
        this.B = buyerBean.getIsImageSpeed() == 1;
        this.C = buyerBean.getIsHideInteraction() == 1;
        this.D = buyerBean.getIsPlaceHolder() == 1;
        this.E = buyerBean.getIsAnimation() == 1;
    }

    public b(Context context, String str, f fVar) {
        this.b = null;
        this.f4518a = context.getApplicationContext();
        String strA = n.a();
        this.l = strA;
        this.k = strA;
        this.y = str;
        this.m = fVar;
        com.beizi.ad.internal.b bVar = new com.beizi.ad.internal.b(context, this.l);
        this.b = bVar;
        bVar.b(str);
        this.b.a(fVar);
    }

    public AdSpacesBean.BuyerBean a() {
        return this.z;
    }

    public void a(EventBean eventBean) {
        this.w = eventBean;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(String str) {
        this.y = str;
        com.beizi.ad.internal.b bVar = this.b;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public void b(Map map) {
        if (this.c == null || map == null) {
            return;
        }
        w();
        this.c.b(map);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(Map map) {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar == null || map == null) {
            return;
        }
        aVar.a(map);
    }

    private boolean a(com.beizi.ad.internal.d.a aVar, com.beizi.ad.internal.a.b bVar) {
        Object obj;
        try {
            Map<String, Object> map = this.I;
            if (map == null || !map.containsKey("orderList") || (obj = this.I.get("orderList")) == null || !(obj instanceof List)) {
                return true;
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                return true;
            }
            String strR = aVar.R();
            if (TextUtils.isEmpty(strR) || list.contains(strR)) {
                return true;
            }
            com.beizi.ad.internal.a.a.a().a(bVar);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str, com.beizi.ad.internal.a.b bVar, com.beizi.ad.internal.d.a aVar) {
        if (this.A) {
            if (z) {
                a(aVar, str);
            } else if (this.s) {
                com.beizi.ad.internal.a.a.a().a(bVar, 1, this.q);
            }
            return;
        }
        this.A = true;
        this.c = aVar;
        if (z) {
            this.s = true;
        } else {
            this.t = true;
            if (bVar != null) {
                String strD = bVar.d();
                this.l = strD;
                com.beizi.ad.internal.b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.a(strD);
                }
            }
            this.r = bVar;
            com.beizi.ad.internal.d.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.c(true);
            }
        }
        y();
        a(aVar);
    }

    public void a(com.beizi.ad.internal.d.a aVar, String str) {
        if (aVar == null || !aVar.d() || TextUtils.isEmpty(str)) {
            return;
        }
        com.beizi.ad.internal.a.a.a().a(aVar, str, this.k, this.y, this.m);
    }

    public boolean a(f.a aVar) {
        com.beizi.ad.internal.f fVar = this.m;
        return (fVar == com.beizi.ad.internal.f.NEW_SPLASH || fVar == com.beizi.ad.internal.f.SPLASHUNIFIED || fVar == com.beizi.ad.internal.f.SPLASH) ? aVar == f.a.ADP_LOADING : fVar == com.beizi.ad.internal.f.NATIVE ? aVar == f.a.ADP_NATIVE : fVar == com.beizi.ad.internal.f.INTERSTITIAL ? aVar == f.a.ADP_TABLE : fVar == com.beizi.ad.internal.f.REWARDEDVIDEO && aVar == f.a.ADP_IVIDEO;
    }
}

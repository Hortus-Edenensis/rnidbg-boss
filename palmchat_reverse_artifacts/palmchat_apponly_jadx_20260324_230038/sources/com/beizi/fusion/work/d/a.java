package com.beizi.fusion.work.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.beizi.ad.f;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.b;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.an;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.fusion.work.a {
    private Context o;
    private String p;
    private long q;
    private long r;
    private com.beizi.ad.v2.f.a s;
    private AdSpacesBean.UniteControlBean t;
    private int u;
    private boolean x;
    private long y;
    protected String n = null;
    private boolean v = false;
    private boolean w = false;

    public a(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar) {
        this.o = context;
        this.p = str;
        this.q = j;
        this.r = j2;
        this.e = buyerBean;
        this.d = dVar;
        this.f = forwardBean;
        r();
    }

    private void aA() {
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = this.e.getRegionalClickView();
        if (regionalClickView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanA = a(regionalClickView.getOrderData(), this.s.b());
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView2 = (orderDataRegionalClickViewBeanA == null || orderDataRegionalClickViewBeanA.getRegionalClickView() == null) ? null : orderDataRegionalClickViewBeanA.getRegionalClickView();
        if (regionalClickView2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(regionalClickView2.getRegionalClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setRegionalClickUuid(regionalClickView.getRegionalClickUuid());
            ao();
        }
    }

    private void aB() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = this.e.getFullScreenClick();
        if (fullScreenClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanB = b(fullScreenClick.getOrderData(), this.s.b());
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick2 = (orderDataFullScreenClickBeanB == null || orderDataFullScreenClickBeanB.getFullScreenClick() == null) ? null : orderDataFullScreenClickBeanB.getFullScreenClick();
        if (fullScreenClick2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setFullScreenClickUuid(fullScreenClick2.getFullScreenClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setFullScreenClickUuid(fullScreenClick.getFullScreenClickUuid());
            ao();
        }
    }

    private void aC() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        if (shakeView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanC = c(shakeView.getOrderData(), this.s.b());
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView2 = (orderDataShakeViewBeanC == null || orderDataShakeViewBeanC.getShakeView() == null) ? null : orderDataShakeViewBeanC.getShakeView();
        if (shakeView2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(shakeView2.getShakeViewUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setShakeViewUuid(shakeView.getShakeViewUuid());
            ao();
        }
    }

    private void aD() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = this.e.getScrollClick();
        if (scrollClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanD = d(scrollClick.getOrderData(), this.s.b());
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick2 = (orderDataScrollViewOrderBeanD == null || orderDataScrollViewOrderBeanD.getScrollClick() == null) ? null : orderDataScrollViewOrderBeanD.getScrollClick();
        if (scrollClick2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(scrollClick2.getScrollClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setScrollClickUuid(scrollClick.getScrollClickUuid());
            ao();
        }
    }

    private void aE() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.e.getEulerAngleRule();
        if (eulerAngleRule == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanE = e(eulerAngleRule.getOrderData(), this.s.b());
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (orderDataEulerAngleViewBeanE == null || orderDataEulerAngleViewBeanE.getEulerAngleRule() == null) ? null : orderDataEulerAngleViewBeanE.getEulerAngleRule();
        if (eulerAngleRule2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setEulerAngleUuid(eulerAngleRule.getEulerAngleUuid());
            ao();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        Log.d("BeiZis", "splashWorkers:" + dVar.q().toString());
        Z();
        e eVar = this.g;
        if (eVar == e.SUCCESS) {
            this.d.a(f(), (View) null);
            return;
        }
        if (eVar == e.FAIL) {
            Log.d("BeiZis", "other worker shown," + f() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        aA();
        aB();
        aC();
        aD();
        aE();
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.f.a aVar = this.s;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.f.a aVar = this.s;
        if (aVar == null) {
            return null;
        }
        return aVar.m();
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean c(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        r6.w = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r3.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        this.n = "complain_config_" + this.i;
        AdSpacesBean.FilterBean filter = this.e.getFilter();
        if (filter != null) {
            this.t = filter.getUniteControl();
        }
        this.u = af.b(100);
        if (!b()) {
            a(String.valueOf(10170), 10170);
            return;
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.v = true;
                int i = 0;
                while (true) {
                    if (i >= callBackStrategy.size()) {
                        break;
                    }
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                t();
                l.a(this.o, this.h);
                u();
            }
        }
        Log.d("BeiZis", f() + ":requestAd:" + this.h + "====" + this.i + "===" + this.r);
        long j = this.r;
        if (j > 0) {
            this.m.sendEmptyMessageDelayed(1, j);
            return;
        }
        d dVar = this.d;
        if (dVar == null || dVar.s() >= 1 || this.d.r() == 2) {
            return;
        }
        k();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.f.a aVar = this.s;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.e;
    }

    @Override // com.beizi.fusion.work.a
    public void k() {
        v();
        ab();
        com.beizi.ad.v2.f.a aVar = new com.beizi.ad.v2.f.a(this.o);
        this.s = aVar;
        aVar.a(this.i);
        this.s.a(this.e);
        this.s.a(this.i);
        this.s.a(new f() { // from class: com.beizi.fusion.work.d.a.1
            @Override // com.beizi.ad.f
            public void a() {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdLoaded()");
                ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADLOAD;
                if (a.this.s.a() != null) {
                    try {
                        a aVar2 = a.this;
                        aVar2.a(Double.parseDouble(aVar2.s.a()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                a aVar3 = a.this;
                aVar3.x = aVar3.s.i();
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdLoaded isUseCacheAd:" + a.this.x);
                if (a.this.x) {
                    a aVar4 = a.this;
                    aVar4.y = aVar4.s.j();
                    ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                    if (a.this.y > 0) {
                        ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.y));
                    }
                    a.this.ao();
                }
                a.this.x();
                if (a.this.Y()) {
                    a.this.ay();
                } else {
                    a.this.P();
                }
                a.this.az();
            }

            @Override // com.beizi.ad.f
            public void b() {
                if (((com.beizi.fusion.work.a) a.this).d != null) {
                    ((com.beizi.fusion.work.a) a.this).d.k();
                }
            }

            @Override // com.beizi.ad.f
            public void c() {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdShown()");
                ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADSHOW;
                if (a.this.x) {
                    ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                    if (a.this.y > 0) {
                        ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.y));
                    }
                    a.this.ao();
                }
                if (((com.beizi.fusion.work.a) a.this).d != null && ((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                    ((com.beizi.fusion.work.a) a.this).d.b(a.this.f());
                    a.this.ac();
                }
                a.this.B();
                a.this.V();
                a.this.C();
            }

            @Override // com.beizi.ad.f
            public void d() {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdClosed()");
                if (((com.beizi.fusion.work.a) a.this).d != null && ((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                    ((com.beizi.fusion.work.a) a.this).d.c(a.this.f());
                }
                a.this.F();
            }

            @Override // com.beizi.ad.f
            public void e() {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdClick()");
                if (a.this.v && ((com.beizi.fusion.work.a) a.this).e != null) {
                    ((com.beizi.fusion.work.a) a.this).b.setCallBackStrategyUuid(((com.beizi.fusion.work.a) a.this).e.getCallBackStrategyUuid());
                    a.this.ao();
                }
                a.this.E();
                if (!a.this.v || a.this.w) {
                    if (((com.beizi.fusion.work.a) a.this).d != null && ((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                        ((com.beizi.fusion.work.a) a.this).d.d(a.this.f());
                    }
                    a.this.D();
                    a.this.ad();
                }
            }

            @Override // com.beizi.ad.f
            public void f() {
                if (((com.beizi.fusion.work.a) a.this).d != null) {
                    ((com.beizi.fusion.work.a) a.this).d.j();
                }
            }

            @Override // com.beizi.ad.f
            public void g() {
                if (((com.beizi.fusion.work.a) a.this).d != null) {
                    ((com.beizi.fusion.work.a) a.this).d.l();
                }
            }

            @Override // com.beizi.ad.f
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onAdFailedToLoad: " + i);
                a.this.a(String.valueOf(i), i);
            }

            @Override // com.beizi.ad.f
            public void a(Map<String, Object> map) {
                Log.d("BeiZis", "showBeiZiRewardedVideoAd onReward()");
                a.this.I();
                if (((com.beizi.fusion.work.a) a.this).d != null) {
                    ((com.beizi.fusion.work.a) a.this).d.i();
                }
            }

            @Override // com.beizi.ad.f
            public void a(String str) {
                try {
                    an.a(a.this.o, a.this.n, (Object) Long.valueOf(System.currentTimeMillis()));
                    ((com.beizi.fusion.work.a) a.this).b.setComplain(str);
                    a.this.ao();
                    a.this.H();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.s.a(true);
        try {
            this.s.a(this.b.m43clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.s.a((int) this.q);
        this.s.a(this.e);
        if ("S2S".equals(g())) {
            this.s.c(g());
            d dVar = this.d;
            if (dVar != null) {
                String strZ = dVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    this.s.b(strZ);
                }
            }
        }
        d dVar2 = this.d;
        if (dVar2 != null) {
            this.s.c(dVar2.A());
        }
        this.s.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        com.beizi.ad.v2.f.a aVar = this.s;
        if (aVar != null) {
            aVar.f();
        }
        this.o = null;
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        com.beizi.ad.v2.f.a aVar;
        if (y() && (aVar = this.s) != null && aVar.d()) {
            ag();
        }
    }

    private boolean b() {
        try {
            AdSpacesBean.UniteControlBean uniteControlBean = this.t;
            if (uniteControlBean == null) {
                return true;
            }
            int random = uniteControlBean.getRandom();
            long duration = this.t.getDuration();
            long jLongValue = ((Long) an.b(this.o, "uniteTime", 0L)).longValue();
            if (jLongValue <= 0 || duration <= 0 || System.currentTimeMillis() - jLongValue >= duration) {
                return true;
            }
            return random >= this.u || random == 100;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean e(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        Log.d("BeiZis", f() + " out make show ad");
        try {
            if (!b()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            com.beizi.ad.v2.f.a aVar = this.s;
            if (aVar == null || !aVar.d()) {
                return;
            }
            this.s.a(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            com.beizi.ad.v2.f.a aVar = this.s;
            if (aVar == null) {
                return;
            }
            aVar.b(map);
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                String str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setLossReason(str3);
                }
            }
            ao();
            N();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.f.a aVar = this.s;
            if (aVar == null) {
                return;
            }
            aVar.a(map);
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str = (String) obj4;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                String str2 = (String) obj3;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                String str3 = (String) obj2;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setHighestLossPrice(str3);
                }
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.b.setSecondPrice(str4);
                }
            }
            ao();
            M();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }
}

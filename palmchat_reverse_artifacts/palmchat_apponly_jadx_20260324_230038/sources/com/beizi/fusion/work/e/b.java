package com.beizi.fusion.work.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.ad.e;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.v2.d.c;
import com.beizi.fusion.R;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.aj;
import com.beizi.fusion.tool.al;
import com.beizi.fusion.tool.ap;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends a implements View.OnClickListener, aj.a, al.a {
    private ViewGroup W;
    private FrameLayout X;
    private c Y;
    private e Z;
    private AdSpacesBean.BuyerBean.ShakeViewBean aa;
    private AdSpacesBean.BuyerBean.ScrollClickBean ab;
    private List<View> ac;
    private Boolean ad;

    public b(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i) {
        super(context, j, buyerBean, forwardBean, dVar, i);
        this.ac = new ArrayList();
    }

    private void aR() {
        if (this.Y == null) {
            ap();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shakeViewBean != null ? ");
        sb.append(this.aa != null);
        aa.a("BeiZis", sb.toString());
        ((a) this).x.removeAllViews();
        ((a) this).x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.e.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup viewGroup = ((a) b.this).x;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                b.this.aS();
                b.this.aT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS() {
        if (com.beizi.fusion.c.b.a().o()) {
            return;
        }
        if (this.P == null) {
            this.P = new al(this.N);
        }
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.aa;
        if (shakeViewBean == null || this.P == null || shakeViewBean.getPosition() == null) {
            return;
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setShakeViewUuid(this.aa.getShakeViewUuid());
            ao();
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.aa.getOrderData(), this.Y.b());
        if (orderDataShakeViewBeanA != null) {
            this.P.a(orderDataShakeViewBeanA.getShakeView());
        } else {
            this.P.a(this.aa);
        }
        this.P.a(this.ad);
        View viewA = this.P.a(ap.b(this.N, ((a) this).x.getWidth()), ap.b(this.N, ((a) this).x.getHeight()), this.aa.getPosition());
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((a) this).x.addView(viewA, layoutParams2);
                    this.P.a(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.ab;
        if (scrollClickBean == null || this.Q == null || scrollClickBean.getPosition() == null) {
            return;
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setScrollClickUuid(this.ab.getScrollClickUuid());
            ao();
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanB = b(this.ab.getOrderData(), this.Y.b());
        if (orderDataScrollViewOrderBeanB != null) {
            this.Q.a(orderDataScrollViewOrderBeanB.getScrollClick());
        } else {
            this.Q.a(this.ab);
        }
        this.Q.a(this.ad);
        View viewA = this.Q.a(ap.b(this.N, ((a) this).x.getWidth()), ap.b(this.N, ((a) this).x.getHeight()), this.ab.getPosition());
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    ((a) this).x.addView(viewA, layoutParams2);
                    this.Q.a(this);
                    a(((a) this).x, this.ab.getScrollDirection(), this.ab.getScrollDistance(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.beizi.fusion.work.e.a
    public void aA() {
        t();
        l.a(this.N, this.h);
        u();
        Log.d("BeiZis", f() + ":requestAd:" + this.h + "====" + this.i + "===" + ((a) this).H);
        long j = ((a) this).H;
        if (j > 0) {
            this.m.sendEmptyMessageDelayed(1, j);
        } else {
            d dVar = this.d;
            if (dVar != null && dVar.s() < 1 && this.d.r() != 2) {
                k();
            }
        }
        this.Q = new aj(this.N);
    }

    @Override // com.beizi.fusion.work.e.a
    public void aB() {
        this.aa = this.e.getShakeView();
        this.ab = this.e.getScrollClick();
        c cVar = new c(this.N, this.i, new com.beizi.ad.d() { // from class: com.beizi.fusion.work.e.b.1
            @Override // com.beizi.ad.d
            public void a(e eVar) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdLoaded()");
                ((com.beizi.fusion.work.a) b.this).j = com.beizi.fusion.e.a.ADLOAD;
                b bVar = b.this;
                bVar.ad = Boolean.valueOf(bVar.Y.l());
                if (b.this.Y.a() != null) {
                    try {
                        b bVar2 = b.this;
                        bVar2.a(Double.parseDouble(bVar2.Y.a()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                b.this.x();
                if (eVar == null) {
                    b.this.c(-991);
                } else {
                    b.this.Z = eVar;
                    b.this.aE();
                }
            }

            @Override // com.beizi.ad.d
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdFailed: " + i);
                b.this.a(String.valueOf(i), i);
            }
        });
        this.Y = cVar;
        cVar.a(true);
        if ("S2S".equals(g())) {
            this.Y.c(g());
            d dVar = this.d;
            if (dVar != null) {
                String strZ = dVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    this.Y.b(strZ);
                }
            }
        }
        d dVar2 = this.d;
        if (dVar2 != null) {
            this.Y.c(dVar2.A());
        }
        this.Y.c();
    }

    @Override // com.beizi.fusion.work.e.a
    public void aG() {
        if (af.a(this.T.getCec())) {
            b("regionalClick");
        } else {
            aQ();
        }
    }

    @Override // com.beizi.fusion.work.e.a
    public void aH() {
        aR();
        List<View> list = this.ac;
        if (list == null || list.size() <= 0) {
            com.beizi.ad.internal.c.d.a(this.Z, this.X, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.e.b.4
                @Override // com.beizi.ad.internal.c.b
                public void a() {
                    b.this.aC();
                }

                @Override // com.beizi.ad.internal.c.b
                public void b() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        } else {
            com.beizi.ad.internal.c.d.a(this.Z, this.X, this.ac, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.e.b.3
                @Override // com.beizi.ad.internal.c.b
                public void a() {
                    b.this.aC();
                }

                @Override // com.beizi.ad.internal.c.b
                public void b() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
                }
            });
        }
        c cVar = this.Y;
        if (cVar != null) {
            cVar.a(this.X, new com.beizi.ad.internal.c.c() { // from class: com.beizi.fusion.work.e.b.5
                @Override // com.beizi.ad.internal.c.c
                public void a() {
                    b.this.aD();
                }
            });
        }
        if (af.a(this.T.getRmc())) {
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.e.b.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b("optimize");
                }
            }, (long) ((Math.random() * 1000.0d) + 1000.0d));
        }
    }

    @Override // com.beizi.fusion.work.e.a
    public void aJ() {
        ((a) this).t.removeAllViews();
        ((a) this).t.addView(this.X, new FrameLayout.LayoutParams(-1, -1));
        this.W.setLayoutParams(((a) this).t.getLayoutParams());
    }

    @Override // com.beizi.fusion.work.e.a
    public String aK() {
        return this.Z.a();
    }

    @Override // com.beizi.fusion.work.e.a
    public String aL() {
        return this.Z.c();
    }

    @Override // com.beizi.fusion.work.e.a
    public String aM() {
        return this.Z.d();
    }

    @Override // com.beizi.fusion.work.e.a
    public String aN() {
        ArrayList<String> arrayListI;
        String strE = this.Z.e();
        return (!TextUtils.isEmpty(strE) || (arrayListI = this.Z.i()) == null || arrayListI.size() < 3) ? strE : arrayListI.get(2);
    }

    @Override // com.beizi.fusion.work.e.a
    public void aP() {
        if (this.Z == null) {
            c(-991);
        } else {
            h.a((Context) null).a(this.Z.b(), new h.a() { // from class: com.beizi.fusion.work.e.b.2
                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    b bVar = b.this;
                    bVar.X = com.beizi.ad.internal.c.d.a(bVar.N, bitmap, bVar.Z);
                    b.this.aF();
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    b.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            });
        }
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void a_() {
        if (this.ab != null) {
            aa.a("BeiZis", "enter showBeiZiUnifiedCustomAd onScrollDistanceMeet  ");
            b("scroll");
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        c cVar = this.Y;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        c cVar = this.Y;
        if (cVar == null) {
            return null;
        }
        return cVar.m();
    }

    @Override // com.beizi.fusion.work.e.a
    public int ay() {
        return R.layout.beizi_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.e.a
    public void az() {
        super.az();
        this.W = (ViewGroup) ((a) this).o.findViewById(R.id.fl_container_mask);
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
    }

    @Override // com.beizi.fusion.work.e.a, com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.e.a, com.beizi.fusion.work.a
    public void l() {
        e eVar = this.Z;
        if (eVar != null) {
            eVar.g();
        }
        c cVar = this.Y;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b("regionalClick");
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        if (!y() || this.Y == null) {
            return;
        }
        ag();
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean b(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
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

    @Override // com.beizi.fusion.tool.al.a
    public void b() {
        aa.a("BeiZis", "enter showBeiZiUnifiedCustomAd onShakeHappened  ");
        b("shake");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.Y != null) {
                this.b.setClickType(str);
                ao();
                aa.a("BeiZis", "enter showBeiZiUnifiedCustomAd clickUnifiedAd clickEventType:" + str);
                int[] iArr = new int[2];
                this.X.getLocationOnScreen(iArr);
                this.X.measure(0, 0);
                int[] iArrA = af.a(this.X.getMeasuredWidth() / 2, this.X.getMeasuredHeight() / 2);
                com.beizi.ad.internal.c.d.a(this.Z, this.X, String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.e.a
    public void a(List<View> list) {
        List<String> clickView = this.T.getClickView();
        if (clickView != null && clickView.size() > 0) {
            if (!clickView.contains(OapsKey.KEY_BG) && !clickView.contains("ad") && !clickView.contains("image")) {
                this.W.setVisibility(0);
            } else {
                this.W.setVisibility(8);
            }
            this.ac.clear();
            this.ac.addAll(list);
            return;
        }
        this.W.setVisibility(0);
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            c cVar = this.Y;
            if (cVar == null) {
                return;
            }
            cVar.a(map);
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

    @Override // com.beizi.fusion.work.e.a
    public void b(boolean z) {
        boolean zA = af.a(this.T.getSlc());
        boolean zA2 = af.a(this.T.getSlac());
        if (z && zA) {
            b("regionalClick");
        } else if (!z && zA2) {
            b("regionalClick");
        } else {
            aQ();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            c cVar = this.Y;
            if (cVar == null) {
                return;
            }
            cVar.b(map);
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
}

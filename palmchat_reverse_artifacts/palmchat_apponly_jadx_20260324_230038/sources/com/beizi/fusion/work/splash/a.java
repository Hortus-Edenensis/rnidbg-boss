package com.beizi.fusion.work.splash;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.beizi.fusion.c.b;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ag;
import com.beizi.fusion.tool.ah;
import com.beizi.fusion.tool.aj;
import com.beizi.fusion.tool.al;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.f;
import com.beizi.fusion.tool.r;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.widget.SkipView;
import com.opos.mobad.activity.VideoActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.fusion.work.a implements ag.a, aj.a, al.a {
    private long I;
    private long J;
    private boolean K;
    private CircleProgressView L;
    private AdSpacesBean.PositionBean M;
    private AdSpacesBean.PositionBean N;
    private float O;
    private float P;
    private AdSpacesBean.RenderViewBean Q;
    private int R;
    private int S;
    private String T;
    private String U;
    private String V;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean W;
    private al ab;
    private ag ac;
    private aj ad;
    private AdSpacesBean.BuyerBean.RollViewBean ae;
    private AdSpacesBean.BuyerBean.CoolRollViewBean af;
    private ah ag;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean ah;
    private r ai;
    private List<AdSpacesBean.ScreenConfigVoBean> aj;
    private View ak;
    private Boolean al;
    private int ao;
    private int ap;
    private boolean aq;
    private int ar;
    private boolean as;
    private long at;
    private boolean av;
    AdSpacesBean.BuyerBean.ShakeViewBean n;
    AdSpacesBean.BuyerBean.RegionalClickViewBean o;
    AdSpacesBean.BuyerBean.ScrollClickBean p;
    AdSpacesBean.BuyerBean.FullScreenClickBean q;
    View.OnClickListener r;
    private Context s;
    private String t;
    private long u;
    private com.beizi.ad.v2.g.a v;
    private ViewGroup w;
    private ViewGroup x;
    private View y;
    private List<AdSpacesBean.RenderViewBean> z;
    private List<AdSpacesBean.RenderViewBean> A = new ArrayList();
    private List<AdSpacesBean.RenderViewBean> B = new ArrayList();
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private long H = 5000;
    private String X = null;
    private boolean Y = false;
    private int Z = -1;
    private String aa = "full";
    private boolean am = false;
    private boolean an = false;
    private int au = 5;

    public a(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i, int i2, d dVar) {
        this.s = context;
        this.t = str;
        this.u = j;
        this.w = viewGroup;
        this.e = buyerBean;
        this.f = forwardBean;
        this.d = dVar;
        this.x = new SplashContainer(context);
        this.y = view;
        this.z = list;
        this.ao = i;
        this.ap = i2;
        r();
    }

    private void aA() {
        ViewGroup viewGroup;
        final boolean z;
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar == null || !aVar.d() || (viewGroup = this.w) == null) {
            ap();
            return;
        }
        viewGroup.removeAllViews();
        this.w.addView(this.x);
        AdSpacesBean.BuyerBean buyerBean = this.e;
        if (buyerBean != null) {
            boolean z2 = buyerBean.getIsImageSpeed() == 1;
            z = z2;
            z = this.e.getIsHideInteraction() == 1;
        } else {
            z = false;
        }
        if (!z) {
            aB();
            aC();
        } else {
            this.v.a(new com.beizi.ad.v2.b.a() { // from class: com.beizi.fusion.work.splash.a.5
                @Override // com.beizi.ad.v2.b.a
                public void a() {
                    if (z) {
                        a.this.aB();
                    }
                }
            });
            if (!z) {
                aB();
            }
            aC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        StringBuilder sb = new StringBuilder();
        sb.append("shakeViewBean != null ? ");
        sb.append(this.n != null);
        sb.append(",regionalClickViewBean != null ? ");
        sb.append(this.o != null);
        sb.append(",fullScreenClickBean != null ? ");
        sb.append(this.q != null);
        aa.a("BeiZis", sb.toString());
        this.x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.a.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f4901a;
            boolean b;

            public void a(boolean z) {
                if (z || a.this.v == null) {
                    return;
                }
                a.this.v.a(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.a.6.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0127  */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onGlobalLayout() {
                byte b;
                try {
                    if (a.this.x == null) {
                        return;
                    }
                    a.this.x.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    if (((com.beizi.fusion.work.a) a.this).e == null) {
                        return;
                    }
                    a aVar = a.this;
                    if (aVar.q != null) {
                        if (((com.beizi.fusion.work.a) aVar).b != null) {
                            ((com.beizi.fusion.work.a) a.this).b.setFullScreenClickUuid(a.this.q.getFullScreenClickUuid());
                            a.this.ao();
                        }
                        a aVar2 = a.this;
                        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanD = aVar2.d(aVar2.q.getOrderData(), a.this.v.b());
                        if (orderDataFullScreenClickBeanD == null) {
                            this.f4901a = af.a(a.this.q.getRandomClickNum());
                            aa.a("BeiZis", "beizi clickable Two = " + this.f4901a);
                            a(this.f4901a);
                        } else if (orderDataFullScreenClickBeanD.getFullScreenClick() != null) {
                            this.b = af.a(orderDataFullScreenClickBeanD.getFullScreenClick().getRandomClickNum());
                            aa.a("BeiZis", "beizi clickable = " + this.b);
                            a(this.b);
                        }
                    }
                    a.this.aQ();
                    if (((com.beizi.fusion.work.a) a.this).e.getInteractionRules() == null || ((com.beizi.fusion.work.a) a.this).e.getInteractionRules().size() <= 0) {
                        if (b.a().o()) {
                            a.this.aM();
                            a.this.aN();
                            return;
                        }
                        a.this.aD();
                        a.this.aM();
                        a.this.aN();
                        a.this.aO();
                        a.this.aP();
                        return;
                    }
                    String strA = com.beizi.fusion.e.b.a(((com.beizi.fusion.work.a) a.this).e.getInteractionRules(), af.b(100));
                    switch (strA.hashCode()) {
                        case -1671124246:
                            b = !strA.equals("eulerAngle") ? (byte) -1 : (byte) 4;
                            break;
                        case -907680051:
                            if (strA.equals("scroll")) {
                                b = 2;
                                break;
                            }
                            break;
                        case -690338273:
                            if (strA.equals("regional")) {
                                b = 1;
                                break;
                            }
                            break;
                        case 3506301:
                            if (strA.equals("roll")) {
                                b = 3;
                                break;
                            }
                            break;
                        case 109399814:
                            if (strA.equals("shake")) {
                                b = 0;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    if (b == 0) {
                        if (b.a().o()) {
                            a.this.aM();
                            return;
                        } else {
                            a.this.aD();
                            return;
                        }
                    }
                    if (b == 1) {
                        a.this.aM();
                        return;
                    }
                    if (b == 2) {
                        a.this.aN();
                        return;
                    }
                    if (b == 3) {
                        if (b.a().o()) {
                            a.this.aM();
                            return;
                        } else {
                            a.this.aO();
                            return;
                        }
                    }
                    if (b != 4) {
                        return;
                    }
                    if (b.a().o()) {
                        a.this.aM();
                    } else {
                        a.this.aP();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void aC() {
        View viewAH = aH();
        if (this.L != null) {
            this.w.addView(this.L, new FrameLayout.LayoutParams(-2, -2));
        }
        this.v.a(viewAH);
        aI();
        if (this.K) {
            aG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD() {
        try {
            if (this.ab == null) {
                this.ab = new al(this.s);
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.n;
            if (shakeViewBean == null || this.ab == null || shakeViewBean.getPosition() == null) {
                return;
            }
            this.am = true;
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(this.n.getShakeViewUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.n.getOrderData(), this.v.b());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) ? null : orderDataShakeViewBeanA.getShakeView();
            this.ab.a(this.al);
            View viewA = this.ab.a(ap.b(this.s, this.x.getWidth()), ap.b(this.s, this.x.getHeight()), this.n.getPosition());
            if (viewA != null) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    this.w.addView(viewA, layoutParams2);
                }
            }
            aE();
            a(shakeView);
            this.ab.a(this);
            a(shakeView, viewA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aE() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.n;
        if (shakeViewBean == null) {
            return;
        }
        int sensorParam = shakeViewBean.getSensorParam();
        int compliantAngle = this.n.getCompliantAngle();
        boolean zIsReturnAngle = this.n.isReturnAngle();
        com.beizi.ad.v2.g.a aVar = this.v;
        Map mapG = aVar != null ? aVar.g() : null;
        al alVar = this.ab;
        if (alVar == null || this.av) {
            return;
        }
        alVar.a(sensorParam, compliantAngle, zIsReturnAngle, mapG);
    }

    private void aF() {
        int passPercent;
        for (int i = 0; i < this.z.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.z.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.B.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.A.add(renderViewBean);
            }
        }
        if (this.B.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.B.get(0);
            this.Q = renderViewBean2;
            if (renderViewBean2 != null) {
                this.N = renderViewBean2.getTapPosition();
                this.M = this.Q.getLayerPosition();
                long skipViewTotalTime = this.Q.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.H = skipViewTotalTime;
                }
                long skipUnavailableTime = this.Q.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.J = skipUnavailableTime;
                }
                this.R = this.Q.getShowCountDown();
                this.S = this.Q.getShowBorder();
                String skipText = this.Q.getSkipText();
                this.T = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.T = "跳过";
                }
                String textColor = this.Q.getTextColor();
                this.U = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.U = "#FFFFFF";
                }
                String countDownColor = this.Q.getCountDownColor();
                this.V = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.V = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.Q.getPassPolicy();
                if (passPolicy != null && passPolicy.size() > 0) {
                    for (AdSpacesBean.PassPolicyBean passPolicyBean : passPolicy) {
                        String passType = passPolicyBean.getPassType();
                        passPercent = passPolicyBean.getPassPercent();
                        passType.hashCode();
                        switch (passType) {
                            case "RANDOMPASS":
                                this.D = af.a(passPercent);
                                break;
                            case "WAITPASS":
                                this.C = af.a(passPercent);
                                break;
                            case "LAYERPASS":
                                AdSpacesBean.PositionBean positionBean = this.M;
                                if (positionBean != null && this.N != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.M.getCenterY();
                                    double width = this.M.getWidth();
                                    double height = this.M.getHeight();
                                    double centerX2 = this.N.getCenterX();
                                    double centerY2 = this.N.getCenterY();
                                    double width2 = this.N.getWidth();
                                    double height2 = this.N.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.E = af.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.F = true;
                                    }
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                }
            }
        }
        if (this.A.size() > 0) {
            Collections.sort(this.A, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.a.10
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    private void aG() {
        if (this.C) {
            R();
        }
        if (this.D) {
            S();
        }
        if (this.E) {
            T();
        }
        if (this.F) {
            U();
        }
        this.I = this.H - this.J;
    }

    private View aH() {
        View view;
        String str;
        this.r = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (a.this.v != null) {
                        a.this.v.e();
                    }
                    a.this.G();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        if (this.K) {
            View view2 = this.y;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.s);
            this.y = skipView;
            skipView.setOnClickListener(this.r);
            CircleProgressView circleProgressView = new CircleProgressView(this.s);
            this.L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.L;
            str = "beizi";
        } else {
            view = this.y;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.s);
                this.L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.L;
                str = "app";
            } else {
                str = "buyer";
            }
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setSkipType(str);
            ao();
        }
        return view;
    }

    private void aI() {
        if (!this.K) {
            View view = this.y;
            if (view != null) {
                view.setVisibility(0);
                this.y.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (this.M == null || this.Q == null) {
            aJ();
            return;
        }
        float f = this.O;
        float height = this.w.getHeight();
        if (height == 0.0f) {
            height = this.P - ap.a(this.s, 100.0f);
        }
        int width = (int) (((double) f) * this.M.getWidth() * 0.01d);
        if (this.M.getHeight() < 12.0d) {
            aJ();
            return;
        }
        int height2 = (int) (((double) width) * this.M.getHeight() * 0.01d);
        int paddingHeight = (int) (((double) height2) * this.Q.getPaddingHeight() * 0.01d);
        if (paddingHeight < 0) {
            paddingHeight = 0;
        }
        ((SkipView) this.y).setData(this.S, paddingHeight);
        d(this.au);
        this.w.addView(this.y, new FrameLayout.LayoutParams(width, height2));
        float centerX = (f * ((float) (this.M.getCenterX() * 0.01d))) - (width / 2);
        float centerY = (height * ((float) (this.M.getCenterY() * 0.01d))) - (height2 / 2);
        this.y.setX(centerX);
        this.y.setY(centerY);
        View view2 = this.y;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void aJ() {
        int i = (int) (((double) this.O) * 0.15d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (int) (((double) i) * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = ap.a(this.s, 20.0f);
        layoutParams.rightMargin = ap.a(this.s, 20.0f);
        ViewGroup viewGroup = this.w;
        if (viewGroup != null) {
            viewGroup.addView(this.y, layoutParams);
        }
        View view = this.y;
        if (view != null) {
            this.R = 1;
            this.S = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.y).setText(String.format("跳过 %d", Integer.valueOf(this.au)));
            this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        float pivotX;
        float pivotY;
        float height;
        try {
            View view = this.y;
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(new int[2]);
            if (this.N != null) {
                float f = this.O;
                float height2 = this.w.getHeight();
                if (height2 == 0.0f) {
                    height2 = this.P - ap.a(this.s, 100.0f);
                }
                int width = (int) (((double) f) * this.N.getWidth() * 0.01d);
                int height3 = (int) (((double) width) * this.N.getHeight() * 0.01d);
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = height3;
                this.L.setLayoutParams(layoutParams);
                pivotX = (f * ((float) (this.N.getCenterX() * 0.01d))) - (width / 2);
                pivotY = height2 * ((float) (this.N.getCenterY() * 0.01d));
                height = height3 / 2;
            } else {
                pivotX = (r2[0] + this.y.getPivotX()) - (this.L.getWidth() / 2);
                pivotY = r2[1] + this.y.getPivotY();
                height = this.L.getHeight() / 2;
            }
            float f2 = pivotY - height;
            this.L.setX(pivotX);
            this.L.setY(f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aL() {
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar != null) {
            aVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM() {
        try {
            if (this.o == null && b.a().o()) {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                this.o = regionalClickViewBean;
                regionalClickViewBean.setTitleColor("#FFFFFF");
                this.o.setTitle("点击跳转至网页或第三方应用");
                this.o.setRegionalClickUuid("-4");
                this.o.setIsDisableClick(0);
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = new AdSpacesBean.BuyerBean.PercentPositionBean();
                percentPositionBean.setCenterX("50%");
                percentPositionBean.setCenterY("80%");
                this.o.setPosition(percentPositionBean);
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.o;
            if (regionalClickViewBean2 == null || this.ac == null || regionalClickViewBean2.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(this.o.getRegionalClickUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanB = b(this.o.getOrderData(), this.v.b());
            if (orderDataRegionalClickViewBeanB != null) {
                this.ac.a(orderDataRegionalClickViewBeanB.getRegionalClickView());
            } else {
                this.ac.a(this.o);
            }
            this.ac.a(this.al);
            View viewA = this.ac.a(ap.b(this.s, this.x.getWidth()), ap.b(this.s, this.x.getHeight()), this.o.getPosition(), true);
            this.ak = viewA;
            if (viewA != null) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.w.addView(this.ak, layoutParams2);
                        this.ac.a(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.p;
            if (scrollClickBean == null || this.ad == null || scrollClickBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(this.p.getScrollClickUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanC = c(this.p.getOrderData(), this.v.b());
            if (orderDataScrollViewOrderBeanC != null) {
                this.ad.a(orderDataScrollViewOrderBeanC.getScrollClick());
            } else {
                this.ad.a(this.p);
            }
            this.ad.a(this.al);
            View viewA = this.ad.a(ap.b(this.s, this.x.getWidth()), ap.b(this.s, this.x.getHeight()), this.p.getPosition());
            if (viewA != null) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.w.addView(viewA, layoutParams2);
                        this.ad.a(this);
                        a(this.p.getScrollDirection(), this.p.getScrollDistance(), this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        try {
            AdSpacesBean.BuyerBean.RollViewBean rollView = this.e.getRollView();
            this.ae = rollView;
            if (rollView == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBeanE = e(rollView.getOrderData(), this.v.b());
            AdSpacesBean.BuyerBean.RollViewBean rollView2 = (orderDataRollViewBeanE == null || orderDataRollViewBeanE.getRollView() == null) ? null : orderDataRollViewBeanE.getRollView();
            if (rollView2 == null) {
                rollView2 = this.ae;
            }
            if (rollView2.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRollViewUuid(rollView2.getRollViewUuid());
                ao();
            }
            if (this.ag == null) {
                this.ag = new ah(this.s);
            }
            this.ag.a(this.al);
            this.ag.a(this.w, ap.b(this.s, this.x.getWidth()), ap.b(this.s, this.x.getHeight()), rollView2);
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean = this.ae;
            if (rollViewBean != null) {
                this.af = rollViewBean.getCoolRollView();
            }
            a(rollView2);
            this.ag.a();
            final int isClick = rollView2.getIsClick();
            this.ag.a(new ah.a() { // from class: com.beizi.fusion.work.splash.a.12
                @Override // com.beizi.fusion.tool.ah.a
                public void a() {
                    if (a.this.Y && a.this.af != null) {
                        an.a(a.this.s, a.this.X, (Object) Long.valueOf(System.currentTimeMillis()));
                    }
                    a.this.aa = "roll";
                    ((com.beizi.fusion.work.a) a.this).b.setClickType("roll");
                    a.this.ao();
                    aa.a("BeiZis", "enter onRollHappened  ");
                    a.this.a("", "", "", "", "", "", "", "", 5);
                }

                @Override // com.beizi.fusion.tool.ah.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (isClick == 1) {
                        a.this.aa = "regionalClick";
                        ((com.beizi.fusion.work.a) a.this).b.setClickType("regionalClick");
                        a.this.ao();
                        aa.a("BeiZis", "enter onClickHappened  ");
                        a.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                        a.this.ag.c();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.e.getEulerAngleRule();
            this.ah = eulerAngleRule;
            if (eulerAngleRule == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanF = f(eulerAngleRule.getOrderData(), this.v.b());
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (orderDataEulerAngleViewBeanF == null || orderDataEulerAngleViewBeanF.getEulerAngleRule() == null) ? null : orderDataEulerAngleViewBeanF.getEulerAngleRule();
            if (eulerAngleRule2 != null) {
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                    ao();
                }
            } else {
                EventBean eventBean2 = this.b;
                if (eventBean2 != null) {
                    eventBean2.setEulerAngleUuid(this.ah.getEulerAngleUuid());
                    ao();
                }
            }
            if (this.ai == null) {
                this.ai = new r(this.s, this.i, this.ah, eulerAngleRule2);
            }
            this.ai.a(this.al);
            this.ai.a(this.w, ap.b(this.s, this.x.getWidth()), ap.b(this.s, this.x.getHeight()));
            this.ai.a(new r.a() { // from class: com.beizi.fusion.work.splash.a.2
                @Override // com.beizi.fusion.tool.r.a
                public void a() {
                    try {
                        a.this.aa = "eulerAngle";
                        ((com.beizi.fusion.work.a) a.this).b.setClickType("eulerAngle");
                        a.this.ao();
                        a.this.a("", "", "", "", "", "", "", "", 2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.ai.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ() {
        try {
            List<AdSpacesBean.ScreenConfigVoBean> list = this.aj;
            if (list != null && list.size() != 0) {
                for (AdSpacesBean.ScreenConfigVoBean screenConfigVoBean : this.aj) {
                    float width = this.x.getWidth();
                    float height = this.x.getHeight();
                    if (width == 0.0f) {
                        width = this.O;
                    }
                    if (height == 0.0f) {
                        height = this.P;
                    }
                    String screenW = screenConfigVoBean.getScreenW();
                    String screenH = screenConfigVoBean.getScreenH();
                    String screenX = screenConfigVoBean.getScreenX();
                    String screenY = screenConfigVoBean.getScreenY();
                    int i = (TextUtils.isEmpty(screenW) || screenW.equals("0")) ? (int) width : screenW.endsWith("%") ? (((int) width) * Integer.parseInt(screenW.substring(0, screenW.indexOf("%")))) / 100 : ap.a(this.s, Integer.parseInt(screenW));
                    int i2 = (TextUtils.isEmpty(screenH) || screenH.equals("0")) ? (int) height : screenH.endsWith("%") ? (((int) height) * Integer.parseInt(screenH.substring(0, screenH.indexOf("%")))) / 100 : ap.a(this.s, Integer.parseInt(screenH));
                    int i3 = (TextUtils.isEmpty(screenX) || screenX.equals("0")) ? (int) width : screenX.endsWith("%") ? (((int) width) * Integer.parseInt(screenX.substring(0, screenX.indexOf("%")))) / 100 : ap.a(this.s, Integer.parseInt(screenX));
                    int i4 = (TextUtils.isEmpty(screenY) || screenY.equals("0")) ? (int) height : screenY.endsWith("%") ? (((int) height) * Integer.parseInt(screenY.substring(0, screenY.indexOf("%")))) / 100 : ap.a(this.s, Integer.parseInt(screenY));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
                    int i5 = i4 - (i2 / 2);
                    int i6 = i3 - (i / 2);
                    if (i5 < 0) {
                        i5 = 0;
                    }
                    if (i6 < 0) {
                        i6 = 0;
                    }
                    layoutParams.topMargin = i5;
                    layoutParams.leftMargin = i6;
                    final ImageView imageView = new ImageView(this.s);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setVisibility(0);
                    imageView.setLayoutParams(layoutParams);
                    String screenImage = screenConfigVoBean.getScreenImage();
                    if (!TextUtils.isEmpty(screenImage) && screenImage.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        f.a(this.s).a(screenImage).a(imageView);
                    }
                    final float[] fArr = new float[1];
                    final float[] fArr2 = new float[1];
                    final float[] fArr3 = new float[1];
                    final float[] fArr4 = new float[1];
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.a.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                float f = fArr[0] / imageView.getLayoutParams().width;
                                float f2 = fArr2[0] / imageView.getLayoutParams().height;
                                int i7 = a.this.ak.getLayoutParams().width;
                                int i8 = (int) (i7 * f);
                                int i9 = (int) (a.this.ak.getLayoutParams().height * f2);
                                int left = a.this.ak.getLeft() + i8;
                                int top = a.this.ak.getTop() + i9;
                                a.this.a(i8 + ".0", i9 + ".0", left + ".0", top + ".0", i8 + ".0", i9 + ".0", left + ".0", top + ".0");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.a.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr2[0] = motionEvent.getY();
                                    fArr3[0] = motionEvent.getRawX();
                                    fArr4[0] = motionEvent.getRawY();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    });
                    this.w.addView(imageView, layoutParams);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void a_() {
        this.aa = "scroll";
        this.b.setClickType("scroll");
        ao();
        aa.a("BeiZis", "enter onScrollDistanceMeet ");
        aL();
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    private void ay() {
        View view;
        View.OnClickListener onClickListener;
        if (this.K || (view = this.y) == null || (onClickListener = this.r) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        Log.d("BeiZis", "splashWorkers:" + dVar.q().toString());
        Z();
        e eVar = this.g;
        if (eVar == e.SUCCESS) {
            ay();
            this.d.a(f(), (View) null);
        } else if (eVar == e.FAIL) {
            Log.d("BeiZis", "other worker shown," + f() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public Map av() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.an) {
            return null;
        }
        if (this.av) {
            if (!this.am) {
                HashMap map = new HashMap();
                map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 0);
                return map;
            }
            al alVar = this.ab;
            if (alVar != null) {
                return alVar.f();
            }
            return null;
        }
        if (this.am) {
            al alVar2 = this.ab;
            if (alVar2 == null) {
                return null;
            }
            return alVar2.e();
        }
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.n;
        if (shakeViewBean == null || shakeViewBean.getSensorParam() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        map2.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 0);
        return map2;
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar == null) {
            return null;
        }
        return aVar.m();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.g.a aVar = this.v;
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
        Object obj;
        EventBean eventBean;
        v();
        ab();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.n = shakeView;
        if (shakeView != null) {
            this.W = shakeView.getCoolShakeView();
        }
        this.o = this.e.getRegionalClickView();
        this.q = this.e.getFullScreenClick();
        this.p = this.e.getScrollClick();
        this.aj = this.e.getScreenConfigVo();
        try {
            AdSpacesBean.BuyerBean buyerBean = this.e;
            if (buyerBean != null && buyerBean.getIsImageSpeed() == 1 && (eventBean = this.b) != null) {
                eventBean.setIsImageSpeed("1");
                ao();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.beizi.ad.a aVar = new com.beizi.ad.a() { // from class: com.beizi.fusion.work.splash.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f4893a = false;

            @Override // com.beizi.ad.a
            public void a() {
                if (b.a().i() && a.this.u - (System.currentTimeMillis() - ((com.beizi.fusion.work.a) a.this).d.x()) < a.this.ar) {
                    Log.d("BeiZis", "showBeiZiSplash onAdLoaded slow");
                    a.this.aq = true;
                    a.this.a(String.valueOf(3), 3);
                    return;
                }
                Log.d("BeiZis", "showBeiZiSplash onAdLoaded:" + System.currentTimeMillis());
                a aVar2 = a.this;
                aVar2.au = aVar2.v.k();
                ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADLOAD;
                if (a.this.v.a() != null) {
                    try {
                        a aVar3 = a.this;
                        aVar3.a(Double.parseDouble(aVar3.v.a()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                a aVar4 = a.this;
                aVar4.al = Boolean.valueOf(aVar4.v.l());
                a aVar5 = a.this;
                aVar5.as = aVar5.v.i();
                if (a.this.as) {
                    a aVar6 = a.this;
                    aVar6.at = aVar6.v.j();
                    ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                    if (a.this.at > 0) {
                        ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.at));
                    }
                    a.this.ao();
                }
                a.this.x();
                if (a.this.Y()) {
                    a.this.az();
                } else {
                    a.this.P();
                }
            }

            @Override // com.beizi.ad.a
            public void b() {
                Log.d("BeiZis", "showBeiZiSplash onAdShown()");
                ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADSHOW;
                if (a.this.as) {
                    ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                    if (a.this.at > 0) {
                        ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.at));
                    }
                    a.this.ao();
                }
                if (((com.beizi.fusion.work.a) a.this).d != null) {
                    if (((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                        ((com.beizi.fusion.work.a) a.this).d.b(a.this.f());
                    }
                    a.this.ac();
                }
                a.this.B();
                a.this.V();
                a.this.C();
            }

            @Override // com.beizi.ad.a
            public void c() {
                Log.d("BeiZis", "showBeiZiSplash onAdClosed()");
                try {
                    if (((com.beizi.fusion.work.a) a.this).d != null) {
                        ((com.beizi.fusion.work.a) a.this).d.c(a.this.f());
                    }
                    a.this.F();
                    if (a.this.ab != null) {
                        a.this.ab.c();
                    }
                    if (a.this.ac != null) {
                        a.this.ac.a();
                    }
                    if (a.this.ad != null) {
                        a.this.ad.b();
                    }
                    if (a.this.ag != null) {
                        a.this.ag.b();
                    }
                    if (a.this.ai != null) {
                        a.this.ai.b();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[PHI: r1
              0x0066: PHI (r1v4 boolean) = (r1v5 boolean), (r1v3 boolean), (r1v3 boolean), (r1v10 boolean) binds: [B:20:0x0062, B:4:0x0026, B:6:0x002c, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // com.beizi.ad.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void d() {
                Exception exc;
                boolean z;
                boolean zA;
                List<AdSpacesBean.CallBackStrategyBean> callBackStrategy;
                Log.d("BeiZis", "showBeiZiSplash onAdClicked()");
                an.a(a.this.s, "uniteTime", (Object) Long.valueOf(System.currentTimeMillis()));
                boolean z2 = false;
                try {
                    callBackStrategy = ((com.beizi.fusion.work.a) a.this).e.getCallBackStrategy();
                } catch (Exception e2) {
                    exc = e2;
                    z = false;
                }
                if (callBackStrategy != null) {
                    if (callBackStrategy.size() > 0) {
                        for (int i = 0; i < callBackStrategy.size(); i++) {
                            try {
                                AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                                if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                                    zA = af.a(Integer.parseInt(callBackStrategyBean.getRate()));
                                    z2 = true;
                                    break;
                                }
                            } catch (Exception e3) {
                                exc = e3;
                                z = true;
                                exc.printStackTrace();
                                z2 = z;
                            }
                            zA = false;
                        }
                        z2 = true;
                        zA = false;
                    } else {
                        zA = false;
                    }
                }
                if (z2 && ((com.beizi.fusion.work.a) a.this).e != null) {
                    ((com.beizi.fusion.work.a) a.this).b.setCallBackStrategyUuid(((com.beizi.fusion.work.a) a.this).e.getCallBackStrategyUuid());
                    a.this.ao();
                }
                a.this.E();
                if (!z2 || zA) {
                    a.this.an = true;
                    if (((com.beizi.fusion.work.a) a.this).d != null) {
                        ((com.beizi.fusion.work.a) a.this).d.d(a.this.f());
                        a.this.ad();
                    }
                    a.this.D();
                }
            }

            @Override // com.beizi.ad.a
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad:" + i);
                a.this.a(String.valueOf(i), i);
            }

            @Override // com.beizi.ad.a
            public void a(long j) {
                try {
                    if (!this.f4893a) {
                        a.this.aK();
                        this.f4893a = true;
                    }
                    if (a.this.K) {
                        if (a.this.J > 0 && a.this.J <= a.this.H) {
                            if (a.this.C) {
                                if (a.this.I <= 0 || j <= a.this.I) {
                                    a.this.G = false;
                                    a.this.y.setAlpha(1.0f);
                                } else {
                                    a.this.G = true;
                                    a.this.y.setAlpha(0.2f);
                                }
                            }
                            if (a.this.J == a.this.H) {
                                a.this.y.setEnabled(false);
                            } else {
                                a.this.y.setEnabled(true);
                            }
                        }
                        a.this.d(Math.round(j / 1000.0f));
                    }
                    if (((com.beizi.fusion.work.a) a.this).d == null || ((com.beizi.fusion.work.a) a.this).d.r() == 2) {
                        return;
                    }
                    ((com.beizi.fusion.work.a) a.this).d.a(j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        com.beizi.ad.v2.g.a aVar2 = new com.beizi.ad.v2.g.a(this.s, this.x, null, this.i);
        this.v = aVar2;
        aVar2.a((int) this.u);
        this.v.a(this.e);
        try {
            this.v.a(this.b.m43clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.v.a(10, 20, 10, 10);
        this.v.a(true);
        this.v.a(aVar);
        this.v.a(ap.a(this.s, this.ao), ap.a(this.s, this.ap));
        if ("S2S".equals(g())) {
            this.v.c(g());
            d dVar = this.d;
            if (dVar != null) {
                String strZ = dVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    this.v.b(strZ);
                }
            }
        }
        d dVar2 = this.d;
        if (dVar2 != null) {
            Map<String, Object> mapA = dVar2.A();
            this.v.c(mapA);
            if (mapA != null && mapA.containsKey("returnInteraction") && (obj = mapA.get("returnInteraction")) != null && (obj instanceof Boolean)) {
                this.av = ((Boolean) obj).booleanValue();
            }
        }
        this.v.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        super.l();
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar != null) {
            aVar.f();
            this.v = null;
        }
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        if (!y() || this.v == null) {
            return;
        }
        ag();
    }

    private boolean c(long j) {
        try {
            return System.currentTimeMillis() - ap.p(this.s).longValue() < j;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean f(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
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
    public void d() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        this.X = "splash_cool_" + this.i;
        this.ar = this.e.getMinShowTime();
        aa.b("BeiZis", "AdWorker chanel = " + this.c);
        com.beizi.fusion.events.b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                t();
                l.a(this.s, this.h);
                u();
            }
        }
        long sleepTime = this.f.getSleepTime();
        if (this.d.t()) {
            sleepTime = Math.max(sleepTime, this.f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.z;
        boolean z = list != null && list.size() > 0;
        this.K = z;
        if (z) {
            aF();
        }
        Log.d("BeiZis", f() + ":requestAd:" + this.h + "====" + this.i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            d dVar = this.d;
            if (dVar != null && dVar.s() < 1 && this.d.r() != 2) {
                k();
            }
        }
        this.O = ap.k(this.s);
        this.P = ap.l(this.s);
        this.ac = new ag(this.s);
        this.ad = new aj(this.s);
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", f() + " out make show ad");
        try {
            aA();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(long j) {
        long jLongValue = ((Long) an.b(this.s, this.X, 0L)).longValue();
        return jLongValue != 0 && System.currentTimeMillis() - jLongValue < j;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean c(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
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

    private AdSpacesBean.BuyerBean.OrderDataRollViewBean e(List<AdSpacesBean.BuyerBean.OrderDataRollViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBean : list) {
                List<String> orderList = orderDataRollViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRollViewBean;
                }
            }
        }
        return null;
    }

    private boolean b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView != null && aliaseShakeView.getPassivationTime() > 0 && (aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0)) {
                return true;
            }
        } else {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = this.n.getAliaseShakeView();
            if (this.n.getAliaseShakeView() != null && aliaseShakeView2.getPassivationTime() > 0 && (aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.beizi.fusion.work.a
    public void a(Message message) {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            int i = message.what;
            if (this.aq) {
                i = 10180;
            }
            eventBean.setError(String.valueOf(i));
            this.b.setErrorCode(String.valueOf(i));
            ao();
            A();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean b(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
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

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = shakeViewBean != null ? shakeViewBean : this.n;
        int regulatoryAngle = shakeViewBean2.getRegulatoryAngle();
        al alVar = this.ab;
        if (alVar != null) {
            alVar.h(regulatoryAngle);
        }
        if (this.av) {
            com.beizi.ad.v2.g.a aVar = this.v;
            this.ab.a(shakeViewBean2, aVar != null ? aVar.g() : null);
        }
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.W;
        if (coolShakeViewBean == null) {
            if (b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.ab.a(aliaseShakeView);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Y = true;
                            a.this.ab.a(shakeViewBean2);
                        }
                    }, af.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.Y = true;
            this.ab.a(shakeViewBean2);
            return;
        }
        if (b(coolShakeViewBean.getCoolTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
            return;
        }
        if (c(this.W.getUserProtectTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
        } else {
            if (b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView2 != null) {
                    this.ab.a(aliaseShakeView2);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Y = true;
                            a.this.ab.a(shakeViewBean2);
                        }
                    }, af.b(aliaseShakeView2.getPassivationTime()));
                    return;
                }
                return;
            }
            this.Y = true;
            this.ab.a(shakeViewBean2);
        }
    }

    @Override // com.beizi.fusion.tool.al.a
    public void b() {
        if (this.Y && this.W != null) {
            an.a(this.s, this.X, (Object) Long.valueOf(System.currentTimeMillis()));
        }
        this.aa = "shake";
        this.b.setClickType("shake");
        ao();
        aa.a("BeiZis", "enter onShakeHappened  ");
        a("", "", "", "", "", "", "", "", 2);
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "scroll";
        this.b.setClickType("scroll");
        ao();
        aa.a("BeiZis", "enter onScrollDistanceMeetByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean d(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.R == 1) {
            String strValueOf = String.valueOf(i);
            String str = this.T + " ";
            String str2 = str + strValueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.V)), str2.indexOf(strValueOf), str2.length(), 33);
            ((SkipView) this.y).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.T);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, this.T.length(), 33);
        ((SkipView) this.y).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            com.beizi.ad.v2.g.a aVar = this.v;
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

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, View view) {
        if (this.Z == -1) {
            this.Z = this.n.getFeedback();
            if (shakeViewBean != null) {
                this.Z = shakeViewBean.getFeedback();
            }
        }
        if (this.Z == 0 || view == null || this.ab == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ShakeArcView shakeArcView = new ShakeArcView(this.s);
            shakeArcView.setLineRadius(5);
            int i = (int) (((double) marginLayoutParams.width) * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.leftMargin = marginLayoutParams.leftMargin + (((marginLayoutParams.width - i) - 12) / 2);
            layoutParams2.topMargin = (int) (((double) marginLayoutParams.topMargin) + (((double) marginLayoutParams.height) * 0.08d));
            this.w.addView(shakeArcView, layoutParams2);
            this.ab.a(shakeArcView, this.Z);
        }
    }

    private void a(final String str, int i, final aj.a aVar) {
        final int iA = ap.a(this.s, i);
        this.v.b(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.a.9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f4905a;
            float b;
            float c;
            float d;
            float e;
            float f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                aj.a aVar2;
                aj.a aVar3;
                aj.a aVar4;
                aj.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f4905a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                } else if (action == 1) {
                    aa.b("ScrollClickUtil", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f4905a + ",mPosY = " + this.b);
                    float f = this.d;
                    float f2 = this.b;
                    if (f - f2 <= 0.0f || Math.abs(f - f2) <= iA) {
                        float f3 = this.d;
                        float f4 = this.b;
                        if (f3 - f4 >= 0.0f || Math.abs(f3 - f4) <= iA) {
                            float f5 = this.c;
                            float f6 = this.f4905a;
                            if (f5 - f6 >= 0.0f || Math.abs(f5 - f6) <= iA) {
                                float f7 = this.c;
                                float f8 = this.f4905a;
                                if (f7 - f8 > 0.0f && Math.abs(f7 - f8) > iA && "right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                    aVar2.b(this.f4905a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else if ("left".equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                aVar3.b(this.f4905a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                            aVar4.b(this.f4905a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                        aVar5.b(this.f4905a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else if (action == 2) {
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                }
                return true;
            }
        });
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

    @Override // com.beizi.fusion.tool.ag.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "regionalClick";
        this.b.setClickType("regionalClick");
        ao();
        aa.a("BeiZis", "enter onRegionClickByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.beizi.ad.v2.g.a aVar = this.v;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4, str5, str6, str7, str8, i);
        }
    }

    private void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean = this.af;
        if (coolRollViewBean == null) {
            this.Y = true;
            this.ag.a(rollViewBean);
        } else if (b(coolRollViewBean.getCoolTime())) {
            this.ag.a(this.af);
        } else if (c(this.af.getUserProtectTime())) {
            this.ag.a(this.af);
        } else {
            this.Y = true;
            this.ag.a(rollViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.g.a aVar = this.v;
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
}

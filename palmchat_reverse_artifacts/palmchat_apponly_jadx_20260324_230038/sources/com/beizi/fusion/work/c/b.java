package com.beizi.fusion.work.c;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.beizi.ad.e;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.d.a;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.v2.d.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends a {
    private String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private View H;
    private String I;
    private boolean J;
    private boolean K;
    private Boolean L;
    private boolean M;
    private long N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private long S;
    private int T;
    private int U;
    private FrameLayout V;
    private boolean W;
    private String[] X;
    private long Y;
    private String Z;
    private boolean aa;
    private boolean ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private ViewGroup af;
    private FrameLayout ag;
    private long ah;
    private boolean ai;
    private ViewTreeObserver.OnScrollChangedListener aj;
    private ViewTreeObserver.OnScrollChangedListener ak;
    private c v;
    private e w;
    private AdSpacesBean.BuyerBean.ShakeViewBean x;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean y;
    private ab z;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bb, code lost:
    
        r10.D = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r2.getRate()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i, boolean z, boolean z2) {
        super(context, j2, buyerBean, forwardBean, dVar, i);
        this.A = null;
        int i2 = 0;
        this.B = false;
        this.C = false;
        this.D = false;
        this.G = 0;
        this.I = null;
        this.X = new String[4];
        this.ac = "#00000000";
        this.aj = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.c.b.11
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                try {
                    if (b.this.W && !b.this.Q && !b.this.aa && System.currentTimeMillis() - b.this.Y >= b.this.S && System.currentTimeMillis() - b.this.P >= 50) {
                        b.this.P = System.currentTimeMillis();
                        if (ar.a(((a) b.this).s, 0.8d)) {
                            int[] iArr = new int[2];
                            FrameLayout frameLayout = ((a) b.this).s;
                            if (frameLayout != null) {
                                frameLayout.getLocationOnScreen(iArr);
                            }
                            if (iArr[1] > 0 && b.this.U == 0) {
                                b.this.U = iArr[1];
                            }
                            aa.c("BeiZis", "mOnScrollChangedListener mAdSlideScrollDistance:" + b.this.U + ";mAdSlideClickDistance:" + b.this.T + ";screenLocation[1]:" + iArr[1]);
                            if (Math.abs(b.this.U - iArr[1]) < b.this.T) {
                                return;
                            }
                            b bVar = b.this;
                            bVar.a(bVar.X, 0);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.ak = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.c.b.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                try {
                    if (((a) b.this).s != null && System.currentTimeMillis() - b.this.ah >= 100) {
                        b.this.ah = System.currentTimeMillis();
                        int[] iArr = new int[2];
                        ((a) b.this).s.getLocationOnScreen(iArr);
                        if (iArr[1] < 0) {
                            ((a) b.this).s.getViewTreeObserver().removeOnScrollChangedListener(this);
                            if (b.this.ag == null || b.this.af == null) {
                                return;
                            }
                            b.this.af.removeView(b.this.ag);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.O = j;
        this.J = z;
        this.K = z2;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.Z = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.R = af.a(adSlide.getRandomNum());
                this.S = adSlide.getNeedTime();
                this.T = adSlide.getDistance();
            }
            this.ab = af.a(nativeOptimize.getCloseClickNum());
            this.ad = af.a(nativeOptimize.getTouchDownNum());
            this.ae = af.a(nativeOptimize.getHoldSlideNum());
            this.ai = af.a(nativeOptimize.getAddClickNum());
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.C = true;
                while (true) {
                    if (i2 >= callBackStrategy.size()) {
                        break;
                    }
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i2);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.x = shakeView;
        if (shakeView != null) {
            this.y = shakeView.getCoolShakeView();
            this.G = this.x.getClkremove();
            this.I = this.x.getTitle();
        }
        this.A = "cool_" + this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        this.Y = System.currentTimeMillis();
        float fK = ap.k(((a) this).n);
        int iA = ap.a(((a) this).n, 40.0f);
        if (this.E < fK / 4.0f || this.F < iA) {
            return;
        }
        this.j = com.beizi.fusion.e.a.ADSHOW;
        if (this.M) {
            this.b.setIsCacheAd("1");
            if (this.N > 0) {
                this.b.setCacheTime(String.valueOf(System.currentTimeMillis() - this.N));
            }
            ao();
        }
        d dVar = this.d;
        if (dVar != null && dVar.r() != 2) {
            this.d.b(f());
        }
        if (!((a) this).t) {
            ((a) this).t = true;
            B();
            C();
            ac();
        }
        aS();
        aU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        ab abVar;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            this.Q = true;
            this.aa = false;
            this.ab = false;
            aT();
            if (this.C && (buyerBean = this.e) != null) {
                this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
                ao();
            }
            E();
            if (!this.C || this.D) {
                d dVar = this.d;
                if (dVar != null && dVar.r() != 2) {
                    this.d.d(f());
                }
                D();
                ad();
                if (this.G != 0 && (abVar = this.z) != null && this.H != null) {
                    abVar.c();
                    this.H.setVisibility(8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean aP() {
        try {
            return System.currentTimeMillis() - ap.p(((a) this).n).longValue() < this.y.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean aQ() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.x;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR() {
        View viewA;
        try {
            e eVar = this.w;
            if (eVar == null || this.K || eVar.m() == null || (viewA = com.beizi.ad.internal.c.d.a(((a) this).n, this.w)) == null) {
                return;
            }
            viewA.setLayoutParams(new FrameLayout.LayoutParams((((a) this).s.getLayoutParams().width * 2) / 3, -2));
            ((a) this).s.addView(viewA, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aS() {
        try {
            if (this.R && ((a) this).s != null && ((a) this).n != null) {
                this.V = new FrameLayout(((a) this).n);
                int width = ((a) this).s.getWidth();
                int height = ((a) this).s.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.V.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.V.setBackgroundColor(Color.parseColor(this.ac));
                ((a) this).s.addView(this.V);
                this.V.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.10
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            b.this.W = true;
                            b.this.X[0] = motionEvent.getX() + "";
                            b.this.X[1] = motionEvent.getY() + "";
                            b.this.X[2] = motionEvent.getRawX() + "";
                            b.this.X[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.V.getViewTreeObserver().addOnScrollChangedListener(this.aj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aT() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.V;
            if (frameLayout3 != null && this.aj != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.aj);
            }
            FrameLayout frameLayout4 = ((a) this).s;
            if (frameLayout4 != null && (frameLayout2 = this.V) != null) {
                frameLayout4.removeView(frameLayout2);
                this.V = null;
            }
            FrameLayout frameLayout5 = ((a) this).s;
            if (frameLayout5 != null && this.ak != null) {
                frameLayout5.getViewTreeObserver().removeOnScrollChangedListener(this.ak);
            }
            ViewGroup viewGroup = this.af;
            if (viewGroup == null || (frameLayout = this.ag) == null) {
                return;
            }
            viewGroup.removeView(frameLayout);
            this.ag = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aU() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (((a) this).s != null && ((a) this).n != null && (buyerBean = this.e) != null) {
                if ((this.ad || this.ae) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = ((a) this).s.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.af = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iM = ap.m(((a) this).n);
                    int iN = ap.n(((a) this).n);
                    int width2 = ((a) this).s.getWidth();
                    int height2 = ((a) this).s.getHeight();
                    int[] iArr = new int[2];
                    ((a) this).s.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int i3 = -1;
                    if (reference == 0) {
                        iM = width2;
                        iN = height2;
                    } else if (reference != 1) {
                        iM = -1;
                        iN = -1;
                    }
                    try {
                        if (!TextUtils.isEmpty(width)) {
                            iM = width.endsWith("%") ? (Integer.parseInt(width.substring(0, width.indexOf("%"))) * iM) / 100 : Integer.parseInt(width);
                        }
                        if (!TextUtils.isEmpty(height)) {
                            iN = height.endsWith("%") ? (Integer.parseInt(height.substring(0, height.indexOf("%"))) * iN) / 100 : Integer.parseInt(height);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (iM < 0) {
                        iM = -1;
                    }
                    if (iN >= 0) {
                        i3 = iN;
                    }
                    this.ag = new FrameLayout(((a) this).n);
                    this.ag.setLayoutParams(new FrameLayout.LayoutParams(iM, i3));
                    int iA = a(horizontalSpace, iM, width2, i);
                    int iB = b(verticalSpace, i3, height2, i2);
                    int iA2 = ap.a(((a) this).n, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.ag.setX(iA);
                    this.ag.setY(iB);
                    this.ag.setBackgroundColor(Color.parseColor(this.ac));
                    this.af.addView(this.ag);
                    final float[] fArr = new float[4];
                    this.ag.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.12
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (b.this.ad) {
                                        b bVar = b.this;
                                        FrameLayout frameLayout = bVar.ag;
                                        FrameLayout frameLayout2 = ((a) b.this).s;
                                        float[] fArr2 = fArr;
                                        b.this.a(bVar.a(frameLayout, frameLayout2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && b.this.ae) {
                                    b bVar2 = b.this;
                                    FrameLayout frameLayout3 = bVar2.ag;
                                    FrameLayout frameLayout4 = ((a) b.this).s;
                                    float[] fArr3 = fArr;
                                    b.this.a(bVar2.a(frameLayout3, frameLayout4, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (!b.this.ad) {
                                if (!b.this.ae) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    ((a) this).s.getViewTreeObserver().addOnScrollChangedListener(this.ak);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public String aA() {
        ArrayList<String> arrayListI;
        e eVar = this.w;
        if (eVar == null || TextUtils.isEmpty(eVar.c())) {
            return null;
        }
        String strC = this.w.c();
        return (!TextUtils.isEmpty(strC) || (arrayListI = this.w.i()) == null || arrayListI.size() < 2) ? strC : arrayListI.get(1);
    }

    @Override // com.beizi.fusion.work.c.a
    public String aB() {
        e eVar = this.w;
        if (eVar == null || TextUtils.isEmpty(eVar.d())) {
            return null;
        }
        return this.w.d();
    }

    @Override // com.beizi.fusion.work.c.a
    public String aC() {
        e eVar = this.w;
        if (eVar == null || TextUtils.isEmpty(eVar.b())) {
            return null;
        }
        return this.w.b();
    }

    @Override // com.beizi.fusion.work.c.a
    public List<String> aD() {
        e eVar = this.w;
        if (eVar == null) {
            return null;
        }
        if ((eVar.h() != null) && (this.w.h().size() > 0)) {
            return this.w.h();
        }
        return null;
    }

    @Override // com.beizi.fusion.work.c.a
    public int aE() {
        return 1;
    }

    @Override // com.beizi.fusion.work.c.a
    public String aF() {
        String strE;
        ArrayList<String> arrayListI;
        e eVar = this.w;
        if (eVar != null) {
            strE = eVar.e();
            if (TextUtils.isEmpty(strE) && (arrayListI = this.w.i()) != null && arrayListI.size() >= 3) {
                strE = arrayListI.get(2);
            }
        } else {
            strE = null;
        }
        return TextUtils.isEmpty(strE) ? "查看详情" : strE;
    }

    @Override // com.beizi.fusion.work.c.a
    public boolean aG() {
        return false;
    }

    @Override // com.beizi.fusion.work.c.a
    public ViewGroup aH() {
        return ((a) this).s;
    }

    @Override // com.beizi.fusion.work.c.a
    public void aJ() {
        try {
            if (this.w == null || this.J) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((a) this).n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(((a) this).n, this.w.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewB = t.b(((a) this).n, this.w.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            ((a) this).s.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = ap.a(((a) this).n, 6.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public String aK() {
        if (this.v == null) {
            return null;
        }
        try {
            a.C0114a c0114aK = this.w.k();
            if (c0114aK == null) {
                return null;
            }
            return c0114aK.a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public UnifiedAdDownloadAppInfo aL() {
        try {
            ApkBean apkBeanM = this.w.m();
            if (apkBeanM == null) {
                return null;
            }
            UnifiedAdDownloadAppInfo unifiedAdDownloadAppInfo = new UnifiedAdDownloadAppInfo();
            unifiedAdDownloadAppInfo.setAppName(apkBeanM.getApkName());
            unifiedAdDownloadAppInfo.setAppVersion(apkBeanM.getAppVersion());
            unifiedAdDownloadAppInfo.setAppDeveloper(apkBeanM.getAppDeveloper());
            String appPermissionsUrl = apkBeanM.getAppPermissionsUrl();
            if (TextUtils.isEmpty(appPermissionsUrl)) {
                String appPermissionsDesc = apkBeanM.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsDesc)) {
                    unifiedAdDownloadAppInfo.setAppPermission(appPermissionsDesc);
                }
            } else {
                unifiedAdDownloadAppInfo.setAppPermission(appPermissionsUrl);
            }
            if (!TextUtils.isEmpty(apkBeanM.getAppPrivacyUrl())) {
                unifiedAdDownloadAppInfo.setAppPrivacy(apkBeanM.getAppPrivacyUrl());
            }
            unifiedAdDownloadAppInfo.setAppIntro(apkBeanM.getAppintro());
            return unifiedAdDownloadAppInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        c cVar = this.v;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        c cVar = this.v;
        if (cVar == null) {
            return null;
        }
        return cVar.m();
    }

    @Override // com.beizi.fusion.work.c.a
    public void ay() {
        ((a) this).s = new FrameLayout(((a) this).n);
        c cVar = new c(((a) this).n, this.i, new com.beizi.ad.d() { // from class: com.beizi.fusion.work.c.b.1
            @Override // com.beizi.ad.d
            public void a(e eVar) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
                ((com.beizi.fusion.work.a) b.this).j = com.beizi.fusion.e.a.ADLOAD;
                b bVar = b.this;
                bVar.L = Boolean.valueOf(bVar.v.l());
                b bVar2 = b.this;
                bVar2.M = bVar2.v.i();
                if (b.this.M) {
                    b bVar3 = b.this;
                    bVar3.N = bVar3.v.j();
                    ((com.beizi.fusion.work.a) b.this).b.setIsCacheAd("1");
                    if (b.this.N > 0) {
                        ((com.beizi.fusion.work.a) b.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - b.this.N));
                    }
                    b.this.ao();
                }
                if (b.this.v.a() != null) {
                    try {
                        b bVar4 = b.this;
                        bVar4.a(Double.parseDouble(bVar4.v.a()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                b.this.x();
                if (eVar == null) {
                    b.this.c(-991);
                } else {
                    b.this.w = eVar;
                    b.this.aM();
                }
            }

            @Override // com.beizi.ad.d
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
                b.this.a(String.valueOf(i), i);
            }
        });
        this.v = cVar;
        cVar.a(true);
        try {
            this.v.a(this.b.m43clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.v.a((int) this.O);
        this.v.a(this.e);
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
            this.v.c(dVar2.A());
        }
        this.v.c();
    }

    @Override // com.beizi.fusion.work.c.a
    public String az() {
        ArrayList<String> arrayListI;
        e eVar = this.w;
        if (eVar == null) {
            return null;
        }
        String strA = eVar.a();
        return (!TextUtils.isEmpty(strA) || (arrayListI = this.w.i()) == null || arrayListI.size() < 1) ? strA : arrayListI.get(0);
    }

    @Override // com.beizi.fusion.work.c.a, com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        c cVar = this.v;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        e eVar = this.w;
        if (eVar != null) {
            eVar.g();
        }
        c cVar = this.v;
        if (cVar != null) {
            cVar.f();
        }
        ab abVar = this.z;
        if (abVar != null) {
            abVar.c();
        }
        aT();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.z) == null) {
                return;
            }
            abVar.d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.z) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        if (!y() || this.v == null) {
            return;
        }
        ag();
    }

    @Override // com.beizi.fusion.work.c.a
    public void b() {
        t();
        l.a(((a) this).n, this.h);
        u();
        Log.d("BeiZis", f() + ":requestAd:" + this.h + "====" + this.i + "===" + ((a) this).o);
        long j = ((a) this).o;
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

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) an.b(((a) this).n, this.A, 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.y.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.z.a(shakeViewBean);
                    }
                }, this.y.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            ak.a().a(this.A);
        }
        return false;
    }

    @Override // com.beizi.fusion.work.c.a
    public void a(final List<View> list) {
        try {
            if (((a) this).s != null) {
                aJ();
                ((a) this).s.post(new Runnable() { // from class: com.beizi.fusion.work.c.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b bVar = b.this;
                            if (((a) bVar).s != null) {
                                bVar.aR();
                                b bVar2 = b.this;
                                bVar2.E = ((a) bVar2).s.getWidth();
                                b bVar3 = b.this;
                                bVar3.F = ((a) bVar3).s.getHeight();
                                b bVar4 = b.this;
                                bVar4.a(bVar4.E, b.this.F, b.this.F);
                            }
                            if (b.this.ad || b.this.ae) {
                                b.this.b((List<View>) list);
                            } else {
                                List list2 = list;
                                if (list2 == null || list2.size() <= 0) {
                                    com.beizi.ad.internal.c.d.a(b.this.w, ((a) b.this).s, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.c.b.5.2
                                        @Override // com.beizi.ad.internal.c.b
                                        public void a() {
                                            b.this.aO();
                                        }

                                        @Override // com.beizi.ad.internal.c.b
                                        public void b() {
                                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                                        }
                                    });
                                } else {
                                    com.beizi.ad.internal.c.d.a(b.this.w, ((a) b.this).s, list, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.c.b.5.1
                                        @Override // com.beizi.ad.internal.c.b
                                        public void a() {
                                            b.this.aO();
                                        }

                                        @Override // com.beizi.ad.internal.c.b
                                        public void b() {
                                            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
                                        }
                                    });
                                }
                            }
                            if (b.this.v != null) {
                                b.this.v.a(((a) b.this).s, new com.beizi.ad.internal.c.c() { // from class: com.beizi.fusion.work.c.b.5.3
                                    @Override // com.beizi.ad.internal.c.c
                                    public void a() {
                                        b.this.aN();
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final int i2, int i3) {
        try {
            if (!com.beizi.fusion.c.b.a().o() && aQ()) {
                if (this.z == null) {
                    this.z = new ab(((a) this).n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.x;
                if (shakeViewBean == null || this.z == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.x.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.x.getOrderData(), this.v.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) ? null : orderDataShakeViewBeanA.getShakeView();
                if (i2 <= 0) {
                    i2 = i3;
                }
                this.z.a(this.L);
                View viewA = this.z.a(ap.b(((a) this).n, i), ap.b(((a) this).n, i2), this.x.getPosition(), this.I);
                this.H = viewA;
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.x;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            ((a) this).s.addView(this.H, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.z.a(new ab.a() { // from class: com.beizi.fusion.work.c.b.6
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        try {
                            if (!ar.a(((a) b.this).s) || b.this.aa) {
                                return;
                            }
                            b.this.Q = true;
                            b.this.aa = true;
                            int[] iArr = new int[2];
                            ((a) b.this).s.getLocationOnScreen(iArr);
                            int[] iArrA = af.a(i / 2, i2 / 2);
                            if (b.this.w != null) {
                                b bVar = b.this;
                                if (((a) bVar).s != null) {
                                    bVar.w.a(((a) b.this).s, String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), 2, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.c.b.6.1
                                        @Override // com.beizi.ad.internal.c.b
                                        public void a() {
                                            b.this.aO();
                                        }

                                        @Override // com.beizi.ad.internal.c.b
                                        public void b() {
                                        }
                                    });
                                }
                            }
                            if (!b.this.B || b.this.y == null) {
                                return;
                            }
                            b.this.B = false;
                            b.this.z.a(b.this.y);
                            b bVar2 = b.this;
                            an.a(((a) bVar2).n, bVar2.A, (Object) Long.valueOf(System.currentTimeMillis()));
                            ak.a().a(b.this.A, System.currentTimeMillis());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.y;
                if (coolShakeViewBean != null) {
                    this.z.a(coolShakeViewBean, this.A);
                }
                this.z.a(((a) this).s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            c cVar = this.v;
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

    private int b(String str, int i, int i2, int i3) {
        int i4;
        int i5;
        try {
            if (TextUtils.isEmpty(str)) {
                return i3;
            }
            if (!Constant.MAP_KEY_TOP.equals(str)) {
                if ("center".equals(str)) {
                    if (i > i2) {
                        i5 = (i - i2) / 2;
                        i3 -= i5;
                    } else {
                        i4 = (i2 - i) / 2;
                        i3 += i4;
                    }
                } else if (!"bottom".equals(str)) {
                    i3 = 0;
                } else if (i > i2) {
                    i5 = i - i2;
                    i3 -= i5;
                } else {
                    i4 = i2 - i;
                    i3 += i4;
                }
            }
            if (i3 < 0) {
                return 0;
            }
            return i3;
        } catch (Exception e) {
            e.printStackTrace();
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<View> list) {
        FrameLayout frameLayout;
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
        }
        if (this.ai && (frameLayout = ((a) this).s) != null) {
            list.add(frameLayout);
        }
        if (list.size() == 0) {
            return;
        }
        for (final View view : list) {
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.3

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    String[] f4870a = new String[4];

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        View view3;
                        ViewParent parent;
                        try {
                            if (motionEvent.getAction() == 0) {
                                if ((b.this.ad || b.this.ae) && (view3 = view) != null && (parent = view3.getParent()) != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                this.f4870a[0] = motionEvent.getX() + "";
                                this.f4870a[1] = motionEvent.getY() + "";
                                this.f4870a[2] = motionEvent.getRawX() + "";
                                this.f4870a[3] = motionEvent.getRawY() + "";
                                if (b.this.ad) {
                                    b.this.a(this.f4870a);
                                }
                            }
                            if (motionEvent.getAction() == 1 && b.this.ae) {
                                b.this.a(this.f4870a);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!b.this.ad) {
                            if (!b.this.ae) {
                                return false;
                            }
                        }
                        return true;
                    }
                });
            }
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.x;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.z;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.y == null) {
            this.B = true;
            this.z.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.z.a(this.y);
        } else if (aP()) {
            this.z.a(this.y);
        } else {
            this.B = true;
            this.z.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            c cVar = this.v;
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

    @Override // com.beizi.fusion.work.c.a
    public void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.c.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ApkBean apkBeanM;
                try {
                    b bVar = b.this;
                    if (((a) bVar).n == null || (apkBeanM = bVar.w.m()) == null) {
                        return;
                    }
                    String apkName = apkBeanM.getApkName();
                    String appPermissionsUrl = apkBeanM.getAppPermissionsUrl();
                    String appPermissionsDesc = apkBeanM.getAppPermissionsDesc();
                    if (TextUtils.isEmpty(appPermissionsUrl)) {
                        appPermissionsUrl = appPermissionsDesc;
                    }
                    String appPrivacyUrl = apkBeanM.getAppPrivacyUrl();
                    String appintro = apkBeanM.getAppintro();
                    Intent intent = new Intent(((a) b.this).n, (Class<?>) DownloadAppInfoActivity.class);
                    intent.putExtra("title_content_key", apkName);
                    intent.putExtra("privacy_content_key", appPrivacyUrl);
                    intent.putExtra("permission_content_key", appPermissionsUrl);
                    intent.putExtra("intro_content_key", appintro);
                    intent.setFlags(268435456);
                    ((a) b.this).n.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i) {
        FrameLayout frameLayout;
        try {
            aT();
            if (this.w != null && ((a) this).s != null && !this.aa && !this.Q) {
                this.Q = true;
                this.aa = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.Z);
                    ao();
                }
                e eVar = this.w;
                if (eVar == null || (frameLayout = ((a) this).s) == null) {
                    return;
                }
                eVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], i, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.c.b.9
                    @Override // com.beizi.ad.internal.c.b
                    public void a() {
                        b.this.aO();
                    }

                    @Override // com.beizi.ad.internal.c.b
                    public void b() {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int a(String str, int i, int i2, int i3) {
        int i4;
        int i5;
        try {
            if (TextUtils.isEmpty(str)) {
                return i3;
            }
            if (!"left".equals(str)) {
                if ("center".equals(str)) {
                    if (i > i2) {
                        i5 = (i - i2) / 2;
                        i3 -= i5;
                    } else {
                        i4 = (i2 - i) / 2;
                        i3 += i4;
                    }
                } else if (!"right".equals(str)) {
                    i3 = 0;
                } else if (i > i2) {
                    i5 = i - i2;
                    i3 -= i5;
                } else {
                    i4 = i2 - i;
                    i3 += i4;
                }
            }
            if (i3 < 0) {
                return 0;
            }
            return i3;
        } catch (Exception e) {
            e.printStackTrace();
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] a(View view, View view2, float f, float f2, float f3, float f4) {
        String[] strArr = new String[0];
        try {
            String[] strArr2 = {f + "", f2 + "", f3 + "", f4 + ""};
            if (view == null || view2 == null) {
                return strArr2;
            }
            try {
                view.getLocationOnScreen(new int[2]);
                int width = (int) ((((double) f) * 100.0d) / ((double) view.getWidth()));
                int height = (int) ((((double) f2) * 100.0d) / ((double) view.getHeight()));
                int width2 = view2.getWidth();
                int height2 = view2.getHeight();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int i = (width2 * width) / 100;
                int i2 = (height2 * height) / 100;
                int i3 = iArr[0] + i;
                int i4 = iArr[1] + i2;
                strArr2[0] = i + "";
                strArr2[1] = i2 + "";
                strArr2[2] = i3 + "";
                strArr2[3] = i4 + "";
                return strArr2;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    return strArr2;
                } catch (Exception e2) {
                    e = e2;
                    strArr = strArr2;
                    e.printStackTrace();
                    return strArr;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        FrameLayout frameLayout;
        try {
            aT();
            if (this.w == null || ((a) this).s == null || this.aa) {
                return;
            }
            this.Q = true;
            this.aa = true;
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setNativeRuleUuid(this.Z);
                ao();
            }
            e eVar = this.w;
            if (eVar == null || (frameLayout = ((a) this).s) == null) {
                return;
            }
            eVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.c.b.4
                @Override // com.beizi.ad.internal.c.b
                public void a() {
                    b.this.aO();
                }

                @Override // com.beizi.ad.internal.c.b
                public void b() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

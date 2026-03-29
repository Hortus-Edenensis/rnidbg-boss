package com.beizi.fusion.work.b;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.e;
import com.beizi.ad.internal.e.h;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.beizi.fusion.tool.o;
import com.beizi.fusion.widget.dialog.dislike.a;
import com.beizi.fusion.work.splash.SplashContainer;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.fusion.work.a {
    protected ab A;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean D;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean E;
    protected e K;
    protected com.beizi.ad.v2.d.c L;
    protected View M;
    protected AdSpacesBean.ComplainBean N;
    protected Boolean R;
    protected int S;
    protected int T;
    protected boolean U;
    private boolean V;
    private long W;
    private long X;
    private boolean Y;
    private boolean Z;
    private long aa;
    private int ab;
    private int ac;
    private FrameLayout ad;
    private boolean ae;
    private long ag;
    private String ah;
    private boolean ai;
    private boolean ak;
    private boolean al;
    private ViewGroup am;
    private FrameLayout an;
    private long ao;
    protected Context n;
    protected String o;
    protected long p;
    protected long q;
    protected float r;
    protected float s;
    protected ViewGroup t;
    protected View u;
    protected List<AdSpacesBean.RenderViewBean> v;
    protected AdSpacesBean.RenderViewBean w;
    protected List<Pair<String, Integer>> x;
    protected AdSpacesBean.BuyerBean.ShakeViewBean y;
    protected AdSpacesBean.BuyerBean.CoolShakeViewBean z;
    protected String B = null;
    protected boolean C = false;
    protected float F = 0.0f;
    protected float G = 0.0f;
    protected float H = 0.0f;
    protected float I = 0.0f;
    protected String J = null;
    protected String O = null;
    protected boolean P = false;
    protected boolean Q = false;
    private String[] af = new String[4];
    private String aj = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener ap = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.a.3
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (a.this.ae && !a.this.Y && !a.this.ai && System.currentTimeMillis() - a.this.ag >= a.this.aa && System.currentTimeMillis() - a.this.X >= 50) {
                    a.this.X = System.currentTimeMillis();
                    if (ar.a(a.this.u, 0.8d)) {
                        int[] iArr = new int[2];
                        View view = a.this.u;
                        if (view != null) {
                            view.getLocationOnScreen(iArr);
                        }
                        if (iArr[1] > 0 && a.this.ac == 0) {
                            a.this.ac = iArr[1];
                        }
                        if (Math.abs(a.this.ac - iArr[1]) < a.this.ab) {
                            return;
                        }
                        a aVar = a.this;
                        aVar.a(aVar.af, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private ViewTreeObserver.OnScrollChangedListener aq = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.a.5
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (a.this.t != null && System.currentTimeMillis() - a.this.ao >= 50) {
                    a.this.ao = System.currentTimeMillis();
                    int[] iArr = new int[2];
                    a.this.t.getLocationOnScreen(iArr);
                    if (iArr[1] < 0) {
                        a.this.t.getViewTreeObserver().removeOnScrollChangedListener(this);
                        if (a.this.an == null || a.this.am == null) {
                            return;
                        }
                        a.this.am.removeView(a.this.an);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public a(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f, float f2) {
        this.n = context;
        this.o = str;
        this.p = j;
        this.q = j2;
        this.e = buyerBean;
        this.d = dVar;
        this.f = forwardBean;
        this.r = f;
        this.s = f2;
        this.t = new SplashContainer(context);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        AdSpacesBean.BuyerBean buyerBean;
        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
        this.Y = true;
        this.ai = false;
        this.U = false;
        aK();
        if (this.P && (buyerBean = this.e) != null) {
            this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            ao();
        }
        E();
        if (!this.P || this.Q) {
            com.beizi.fusion.c.d dVar = this.d;
            if (dVar != null && dVar.r() != 2) {
                this.d.d(f());
            }
            D();
            ad();
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar != null) {
                cVar.o();
            }
        }
    }

    private boolean aF() {
        try {
            return System.currentTimeMillis() - ap.p(this.n).longValue() < this.z.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void aG() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBeanB;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.e.getDislikeConfig();
        this.D = dislikeConfig;
        if (dislikeConfig == null || (dislikeConfigBeanB = b(dislikeConfig.getOrderData(), this.L.b())) == null) {
            return;
        }
        this.E = dislikeConfigBeanB;
    }

    private boolean aH() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean aI() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.y;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        try {
            if (this.Z && this.t != null && this.n != null) {
                this.ad = new FrameLayout(this.n);
                int width = this.t.getWidth();
                int height = this.t.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.ad.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.ad.setBackgroundColor(Color.parseColor(this.aj));
                this.t.addView(this.ad);
                this.ad.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            a.this.ae = true;
                            a.this.af[0] = motionEvent.getX() + "";
                            a.this.af[1] = motionEvent.getY() + "";
                            a.this.af[2] = motionEvent.getRawX() + "";
                            a.this.af[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.ad.getViewTreeObserver().addOnScrollChangedListener(this.ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aK() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.ad;
            if (frameLayout3 != null && this.ap != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.ap);
            }
            ViewGroup viewGroup = this.t;
            if (viewGroup != null && (frameLayout2 = this.ad) != null) {
                viewGroup.removeView(frameLayout2);
                this.ad = null;
            }
            ViewGroup viewGroup2 = this.t;
            if (viewGroup2 != null && this.aq != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.aq);
            }
            ViewGroup viewGroup3 = this.am;
            if (viewGroup3 == null || (frameLayout = this.an) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.an = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.t != null && this.n != null && (buyerBean = this.e) != null) {
                if ((this.ak || this.al) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.t.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.am = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iM = ap.m(this.n);
                    int iN = ap.n(this.n);
                    int width2 = this.t.getWidth();
                    int height2 = this.t.getHeight();
                    int[] iArr = new int[2];
                    this.t.getLocationOnScreen(iArr);
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
                    this.an = new FrameLayout(this.n);
                    this.an.setLayoutParams(new FrameLayout.LayoutParams(iM, i3));
                    int iA = a(horizontalSpace, iM, width2, i);
                    int iB = b(verticalSpace, i3, height2, i2);
                    int iA2 = ap.a(this.n, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.an.setX(iA);
                    this.an.setY(iB);
                    this.an.setBackgroundColor(Color.parseColor(this.aj));
                    this.am.addView(this.an);
                    final float[] fArr = new float[4];
                    this.an.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (a.this.ak) {
                                        a aVar = a.this;
                                        FrameLayout frameLayout = aVar.an;
                                        ViewGroup viewGroup2 = a.this.t;
                                        float[] fArr2 = fArr;
                                        a.this.a(aVar.a(frameLayout, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && a.this.al) {
                                    a aVar2 = a.this;
                                    FrameLayout frameLayout2 = aVar2.an;
                                    ViewGroup viewGroup3 = a.this.t;
                                    float[] fArr3 = fArr;
                                    a.this.a(aVar2.a(frameLayout2, viewGroup3, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (!a.this.ak) {
                                if (!a.this.al) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    this.t.getViewTreeObserver().addOnScrollChangedListener(this.aq);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void aM() {
        ViewGroup viewGroup = this.t;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String[] f4833a = new String[4];

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewGroup viewGroup2;
                ViewParent parent;
                try {
                    if (motionEvent.getAction() == 0) {
                        if ((a.this.ak || a.this.al) && (viewGroup2 = a.this.t) != null && (parent = viewGroup2.getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f4833a[0] = motionEvent.getX() + "";
                        this.f4833a[1] = motionEvent.getY() + "";
                        this.f4833a[2] = motionEvent.getRawX() + "";
                        this.f4833a[3] = motionEvent.getRawY() + "";
                        if (a.this.ak) {
                            a.this.a(this.f4833a);
                        }
                    }
                    if (motionEvent.getAction() == 1 && a.this.al) {
                        a.this.a(this.f4833a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!a.this.ak) {
                    if (!a.this.al) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    public void a(e eVar) {
    }

    public void aA() {
        View view;
        try {
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar != null && (view = this.M) != null) {
                cVar.a(view, new com.beizi.ad.internal.c.c() { // from class: com.beizi.fusion.work.b.a.11
                    @Override // com.beizi.ad.internal.c.c
                    public void a() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                        a.this.ag = System.currentTimeMillis();
                        ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADSHOW;
                        if (a.this.V) {
                            ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                            if (a.this.W > 0) {
                                ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.W));
                            }
                            a.this.ao();
                        }
                        if (((com.beizi.fusion.work.a) a.this).d != null && ((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                            ((com.beizi.fusion.work.a) a.this).d.b(a.this.f());
                        }
                        a.this.B();
                        a.this.C();
                        a.this.ac();
                        a.this.aJ();
                        a.this.aL();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean aB() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    public boolean aC() {
        return this.U;
    }

    public void aD() {
        try {
            if (aH()) {
                a.C0144a c0144a = new a.C0144a(this.n);
                c0144a.a(new a.c() { // from class: com.beizi.fusion.work.b.a.14
                    @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                    public void a() {
                        try {
                            if (((com.beizi.fusion.work.a) a.this).d != null && ((com.beizi.fusion.work.a) a.this).d.r() != 2) {
                                ((com.beizi.fusion.work.a) a.this).d.b(a.this.f(), a.this.u);
                            }
                            a.this.F();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                c0144a.a().show();
            } else {
                com.beizi.fusion.c.d dVar = this.d;
                if (dVar != null && dVar.r() != 2) {
                    this.d.b(f(), this.u);
                }
                F();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.m();
    }

    public void ay() {
        try {
            if (Y()) {
                com.beizi.fusion.c.d dVar = this.d;
                if (dVar == null) {
                    return;
                }
                Log.d("BeiZis", f() + " NativeAdWorker:" + dVar.q().toString());
                Z();
                com.beizi.fusion.c.e eVar = this.g;
                if (eVar == com.beizi.fusion.c.e.SUCCESS) {
                    if (this.u != null) {
                        this.d.a(f(), this.u);
                    } else {
                        this.d.a(10140);
                    }
                } else if (eVar == com.beizi.fusion.c.e.FAIL) {
                    Log.d("BeiZis", "other worker shown," + f() + " remove");
                }
            } else {
                P();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void az() {
        View view;
        try {
            e eVar = this.K;
            if (eVar != null && (view = this.M) != null) {
                if (this.ak || this.al) {
                    aM();
                } else {
                    com.beizi.ad.internal.c.d.a(eVar, view, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.a.10

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        boolean f4822a = false;

                        @Override // com.beizi.ad.internal.c.b
                        public void a() {
                            a.this.aE();
                        }

                        @Override // com.beizi.ad.internal.c.b
                        public void b() {
                            Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.e;
    }

    @Override // com.beizi.fusion.work.a
    public void k() {
        v();
        ab();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.y = shakeView;
        if (shakeView != null) {
            this.z = shakeView.getCoolShakeView();
        }
        this.B = "cool_" + this.i;
        this.J = "dl_cool_" + this.i;
        if (this.r <= 0.0f) {
            this.r = ap.i(this.n);
        }
        if (this.s <= 0.0f) {
            this.s = 0.0f;
        }
        com.beizi.ad.v2.d.c cVar = new com.beizi.ad.v2.d.c(this.n, this.i, new com.beizi.ad.d() { // from class: com.beizi.fusion.work.b.a.1
            @Override // com.beizi.ad.d
            public void a(e eVar) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
                ((com.beizi.fusion.work.a) a.this).j = com.beizi.fusion.e.a.ADLOAD;
                a aVar = a.this;
                aVar.R = Boolean.valueOf(aVar.L.l());
                a aVar2 = a.this;
                aVar2.V = aVar2.L.i();
                if (a.this.V) {
                    a aVar3 = a.this;
                    aVar3.W = aVar3.L.j();
                    ((com.beizi.fusion.work.a) a.this).b.setIsCacheAd("1");
                    if (a.this.W > 0) {
                        ((com.beizi.fusion.work.a) a.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.W));
                    }
                    a.this.ao();
                }
                if (a.this.L.a() != null) {
                    try {
                        a aVar4 = a.this;
                        aVar4.a(Double.parseDouble(aVar4.L.a()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                a.this.x();
                if (eVar == null) {
                    a.this.c(-991);
                    return;
                }
                a aVar5 = a.this;
                aVar5.K = eVar;
                aVar5.b();
            }

            @Override // com.beizi.ad.d
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
                a.this.a(String.valueOf(i), i);
            }
        });
        this.L = cVar;
        cVar.a(true);
        try {
            this.L.a(this.b.m43clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.L.a((int) this.p);
        this.L.a(this.e);
        if ("S2S".equals(g())) {
            this.L.c(g());
            com.beizi.fusion.c.d dVar = this.d;
            if (dVar != null) {
                String strZ = dVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    this.L.b(strZ);
                }
            }
        }
        com.beizi.fusion.c.d dVar2 = this.d;
        if (dVar2 != null) {
            this.L.c(dVar2.A());
        }
        this.L.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        e eVar = this.K;
        if (eVar != null) {
            eVar.g();
        }
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar != null) {
            cVar.f();
        }
        ab abVar = this.A;
        if (abVar != null) {
            abVar.c();
        }
        aK();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.A) == null) {
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
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.A) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.u;
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        if (!y() || this.L == null) {
            return;
        }
        ag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ae, code lost:
    
        r7.Q = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r4.getRate()));
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
        this.N = this.e.getComplain();
        this.O = "complain_config_" + this.i;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.ah = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.Z = af.a(adSlide.getRandomNum());
                this.aa = adSlide.getNeedTime();
                this.ab = adSlide.getDistance();
            }
            this.U = af.a(nativeOptimize.getCloseClickNum());
            this.ak = af.a(nativeOptimize.getTouchDownNum());
            this.al = af.a(nativeOptimize.getHoldSlideNum());
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.P = true;
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
        List<AdSpacesBean.RenderViewBean> renderView = this.e.getRenderView();
        this.v = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.v.get(0);
            this.w = renderViewBean;
            this.x = o.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.events.b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                t();
                l.a(this.n, this.h);
                u();
            }
        }
        Log.d("BeiZis", f() + ":requestAd:" + this.h + "====" + this.i + "===" + this.q);
        long j = this.q;
        if (j > 0) {
            this.m.sendEmptyMessageDelayed(1, j);
            return;
        }
        com.beizi.fusion.c.d dVar = this.d;
        if (dVar == null || dVar.s() >= 1 || this.d.r() == 2) {
            return;
        }
        k();
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) an.b(this.n, this.B, 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.z.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.A.a(shakeViewBean);
                    }
                }, this.z.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            ak.a().a(this.B);
        }
        return false;
    }

    public void a(final TextView textView, final ImageView imageView) {
        ArrayList<String> arrayListI;
        try {
            e eVar = this.K;
            if (eVar == null) {
                return;
            }
            String strE = eVar.e();
            if (TextUtils.isEmpty(strE) && (arrayListI = this.K.i()) != null && arrayListI.size() >= 3) {
                strE = arrayListI.get(2);
            }
            if (TextUtils.isEmpty(strE)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            if (strE.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                h.a((Context) null).a(strE, new h.a() { // from class: com.beizi.fusion.work.b.a.8
                    @Override // com.beizi.ad.internal.e.h.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.e.h.a
                    public void a(Bitmap bitmap) {
                        try {
                            TextView textView2 = textView;
                            if (textView2 != null) {
                                textView2.setVisibility(8);
                            }
                            ImageView imageView2 = imageView;
                            if (imageView2 != null) {
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(strE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.DislikeConfigBean b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislike;
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean orderDataDislikeConfigBean : list) {
                List<String> orderList = orderDataDislikeConfigBean.getOrderList();
                if (orderList != null && orderList.contains(str) && (dislike = orderDataDislikeConfigBean.getDislike()) != null) {
                    return dislike;
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
            com.beizi.ad.v2.d.c cVar = this.L;
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

    public void a(final View view) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean;
        try {
            int iA = ap.a(this.n, this.r);
            float f = this.s;
            int iA2 = f > 0.0f ? ap.a(this.n, f) : -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA2);
            ViewGroup viewGroup = this.t;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                StringBuilder sb = new StringBuilder();
                sb.append("mNativeAd != null ? ");
                boolean z = true;
                sb.append(this.L != null);
                sb.append(",renderViewBean != null ? ");
                if (this.w == null) {
                    z = false;
                }
                sb.append(z);
                aa.a("BeiZis", sb.toString());
                this.t.addView(this.M, layoutParams);
                this.M.measure(0, 0);
                a(this.K, iA, iA2, this.M.getMeasuredHeight());
                aG();
                EventBean eventBean = this.b;
                if (eventBean != null && (dislikeConfigBean = this.D) != null) {
                    eventBean.setDislikeUuid(dislikeConfigBean.getDislikeUuid());
                    ao();
                }
                if (aB()) {
                    a(this.K);
                }
                ViewGroup viewGroup2 = this.t;
                this.u = viewGroup2;
                ab abVar = this.A;
                if (abVar != null) {
                    abVar.a(viewGroup2);
                }
            }
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar == null || this.w == null) {
                return;
            }
            cVar.a(this.x);
            this.L.b(this.w.getOptimizePercent());
            aa.a("BeiZis", "percent = " + this.w.getOptimizePercent());
            this.t.post(new Runnable() { // from class: com.beizi.fusion.work.b.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    com.beizi.ad.v2.d.c cVar2 = aVar.L;
                    int optimizeSize = aVar.w.getOptimizeSize();
                    View view2 = view;
                    a aVar2 = a.this;
                    cVar2.a(optimizeSize, view2, aVar2.t, aVar2.w.getDirection());
                }
            });
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

    private void a(final e eVar, final int i, final int i2, int i3) {
        try {
            if (!com.beizi.fusion.c.b.a().o() && aI()) {
                if (this.A == null) {
                    this.A = new ab(this.n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.y;
                if (shakeViewBean == null || this.A == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.y.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.y.getOrderData(), this.L.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) ? null : orderDataShakeViewBeanA.getShakeView();
                if (i2 <= 0) {
                    i2 = i3;
                }
                this.A.a(this.R);
                View viewA = this.A.a(ap.b(this.n, i), ap.b(this.n, i2), this.y.getPosition());
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.y;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.t.addView(viewA, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.A.a(new ab.a() { // from class: com.beizi.fusion.work.b.a.12
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
                        View view;
                        try {
                            if (!ar.a(a.this.u) || a.this.ai) {
                                return;
                            }
                            a.this.Y = true;
                            a.this.ai = true;
                            int[] iArr = new int[2];
                            a.this.u.getLocationOnScreen(iArr);
                            int[] iArrA = af.a(i / 2, i2 / 2);
                            e eVar2 = eVar;
                            if (eVar2 != null && (view = a.this.u) != null) {
                                eVar2.a(view, String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), 2, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.a.12.1
                                    @Override // com.beizi.ad.internal.c.b
                                    public void a() {
                                        a.this.aE();
                                    }

                                    @Override // com.beizi.ad.internal.c.b
                                    public void b() {
                                    }
                                });
                            }
                            a aVar = a.this;
                            if (!aVar.C || (coolShakeViewBean = aVar.z) == null) {
                                return;
                            }
                            aVar.C = false;
                            aVar.A.a(coolShakeViewBean);
                            a aVar2 = a.this;
                            an.a(aVar2.n, aVar2.B, (Object) Long.valueOf(System.currentTimeMillis()));
                            ak.a().a(a.this.B, System.currentTimeMillis());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.z;
                if (coolShakeViewBean != null) {
                    this.A.a(coolShakeViewBean, this.B);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.y;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.A;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.z == null) {
            this.C = true;
            this.A.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.A.a(this.z);
        } else if (aF()) {
            this.A.a(this.z);
        } else {
            this.C = true;
            this.A.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.d.c cVar = this.L;
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

    public void a(String[] strArr, int i) {
        View view;
        try {
            aK();
            if (this.K != null && this.u != null && !this.ai && !this.Y) {
                this.Y = true;
                this.ai = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ah);
                    ao();
                }
                e eVar = this.K;
                if (eVar == null || (view = this.u) == null) {
                    return;
                }
                eVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.a.15
                    @Override // com.beizi.ad.internal.c.b
                    public void a() {
                        a.this.aE();
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
        View view;
        try {
            aK();
            if (this.K == null || this.u == null || this.ai) {
                return;
            }
            this.Y = true;
            this.ai = true;
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setNativeRuleUuid(this.ah);
                ao();
            }
            e eVar = this.K;
            if (eVar == null || (view = this.u) == null) {
                return;
            }
            eVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.a.7
                @Override // com.beizi.ad.internal.c.b
                public void a() {
                    a.this.aE();
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

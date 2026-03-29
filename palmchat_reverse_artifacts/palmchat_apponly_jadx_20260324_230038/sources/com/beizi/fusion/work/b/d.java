package com.beizi.fusion.work.b;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.e;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.t;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.o;
import com.beizi.fusion.tool.w;
import com.beizi.fusion.widget.dialog.dislike.a;
import com.beizi.fusion.work.splash.SplashContainer;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.beizi.fusion.work.a {
    private AdSpacesBean.BuyerBean.CoolShakeViewBean A;
    private ab B;
    private AdSpacesBean.BuyerBean.DislikeConfigBean E;
    private AdSpacesBean.BuyerBean.DislikeConfigBean F;
    private e L;
    private Boolean P;
    private long Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private long V;
    private int W;
    private int X;
    private FrameLayout Y;
    private boolean Z;
    private long ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private boolean ag;
    private boolean ah;
    private ViewGroup ai;
    private FrameLayout aj;
    private long ak;
    private AdSpacesBean.ComplainBean al;
    private boolean am;
    private long an;
    private Context n;
    private String o;
    private long p;
    private long q;
    private float r;
    private float s;
    private com.beizi.ad.v2.d.a t;
    private ViewGroup u;
    private View v;
    private List<AdSpacesBean.RenderViewBean> w;
    private AdSpacesBean.RenderViewBean x;
    private List<Pair<String, Integer>> y;
    private AdSpacesBean.BuyerBean.ShakeViewBean z;
    private String C = null;
    private boolean D = false;
    private float G = 0.0f;
    private float H = 0.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private String K = null;
    private String M = null;
    private boolean N = false;
    private boolean O = false;
    private String[] aa = new String[4];
    private String af = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener ao = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.d.5
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (d.this.Z && !d.this.T && !d.this.ad && System.currentTimeMillis() - d.this.ab >= d.this.V && System.currentTimeMillis() - d.this.Q >= 50) {
                    d.this.Q = System.currentTimeMillis();
                    if (ar.a(d.this.v, 0.8d)) {
                        int[] iArr = new int[2];
                        if (d.this.v != null) {
                            d.this.v.getLocationOnScreen(iArr);
                        }
                        if (iArr[1] > 0 && d.this.X == 0) {
                            d.this.X = iArr[1];
                        }
                        if (Math.abs(d.this.X - iArr[1]) < d.this.W) {
                            return;
                        }
                        d dVar = d.this;
                        dVar.a(dVar.aa, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private ViewTreeObserver.OnScrollChangedListener ap = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.d.7
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (d.this.u != null && System.currentTimeMillis() - d.this.ak >= 100) {
                    d.this.ak = System.currentTimeMillis();
                    int[] iArr = new int[2];
                    d.this.u.getLocationOnScreen(iArr);
                    if (iArr[1] < 0) {
                        d.this.u.getViewTreeObserver().removeOnScrollChangedListener(this);
                        if (d.this.aj == null || d.this.ai == null) {
                            return;
                        }
                        d.this.ai.removeView(d.this.aj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public d(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f, float f2) {
        this.n = context;
        this.o = str;
        this.p = j;
        this.q = j2;
        this.e = buyerBean;
        this.d = dVar;
        this.f = forwardBean;
        this.r = f;
        this.s = f2;
        this.u = new SplashContainer(context);
        r();
    }

    private boolean aA() {
        try {
            return System.currentTimeMillis() - ap.p(this.n).longValue() < this.A.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBeanB;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.e.getDislikeConfig();
        this.E = dislikeConfig;
        if (dislikeConfig == null || (dislikeConfigBeanB = b(dislikeConfig.getOrderData(), this.t.b())) == null) {
            return;
        }
        this.F = dislikeConfigBeanB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aC() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    private boolean aD() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aE() {
        return this.ae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        try {
            if (aD()) {
                a.C0144a c0144a = new a.C0144a(this.n);
                c0144a.a(new a.c() { // from class: com.beizi.fusion.work.b.d.2
                    @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                    public void a() {
                        try {
                            if (((com.beizi.fusion.work.a) d.this).d != null && ((com.beizi.fusion.work.a) d.this).d.r() != 2) {
                                ((com.beizi.fusion.work.a) d.this).d.b(d.this.f(), d.this.v);
                            }
                            d.this.F();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                c0144a.a().show();
            } else {
                com.beizi.fusion.c.d dVar = this.d;
                if (dVar != null && dVar.r() != 2) {
                    this.d.b(f(), this.v);
                }
                F();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean aG() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.z;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        try {
            if (this.U && this.u != null && this.n != null) {
                this.Y = new FrameLayout(this.n);
                int width = this.u.getWidth();
                int height = this.u.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.Y.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.Y.setBackgroundColor(Color.parseColor(this.af));
                this.u.addView(this.Y);
                this.Y.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.4
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            d.this.Z = true;
                            d.this.aa[0] = motionEvent.getX() + "";
                            d.this.aa[1] = motionEvent.getY() + "";
                            d.this.aa[2] = motionEvent.getRawX() + "";
                            d.this.aa[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.Y.getViewTreeObserver().addOnScrollChangedListener(this.ao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aI() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.Y;
            if (frameLayout3 != null && this.ao != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.ao);
            }
            ViewGroup viewGroup = this.u;
            if (viewGroup != null && (frameLayout2 = this.Y) != null) {
                viewGroup.removeView(frameLayout2);
                this.Y = null;
            }
            ViewGroup viewGroup2 = this.u;
            if (viewGroup2 != null && this.ap != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.ap);
            }
            ViewGroup viewGroup3 = this.ai;
            if (viewGroup3 == null || (frameLayout = this.aj) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.aj = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.u != null && this.n != null && (buyerBean = this.e) != null) {
                if ((this.ag || this.ah) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.u.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.ai = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iM = ap.m(this.n);
                    int iN = ap.n(this.n);
                    int width2 = this.u.getWidth();
                    int height2 = this.u.getHeight();
                    int[] iArr = new int[2];
                    this.u.getLocationOnScreen(iArr);
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
                    this.aj = new FrameLayout(this.n);
                    this.aj.setLayoutParams(new FrameLayout.LayoutParams(iM, i3));
                    int iA = a(horizontalSpace, iM, width2, i);
                    int iB = b(verticalSpace, i3, height2, i2);
                    int iA2 = ap.a(this.n, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.aj.setX(iA);
                    this.aj.setY(iB);
                    this.aj.setBackgroundColor(Color.parseColor(this.af));
                    this.ai.addView(this.aj);
                    final float[] fArr = new float[4];
                    this.aj.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.6
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (d.this.ag) {
                                        d dVar = d.this;
                                        FrameLayout frameLayout = dVar.aj;
                                        ViewGroup viewGroup2 = d.this.u;
                                        float[] fArr2 = fArr;
                                        d.this.a(dVar.a(frameLayout, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && d.this.ah) {
                                    d dVar2 = d.this;
                                    FrameLayout frameLayout2 = dVar2.aj;
                                    ViewGroup viewGroup3 = d.this.u;
                                    float[] fArr3 = fArr;
                                    d.this.a(dVar2.a(frameLayout2, viewGroup3, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (!d.this.ag) {
                                if (!d.this.ah) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    this.u.getViewTreeObserver().addOnScrollChangedListener(this.ap);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void aK() {
        ViewGroup viewGroup = this.u;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String[] f4862a = new String[4];

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent;
                try {
                    if (motionEvent.getAction() == 0) {
                        if ((d.this.ag || d.this.ah) && d.this.u != null && (parent = d.this.u.getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f4862a[0] = motionEvent.getX() + "";
                        this.f4862a[1] = motionEvent.getY() + "";
                        this.f4862a[2] = motionEvent.getRawX() + "";
                        this.f4862a[3] = motionEvent.getRawY() + "";
                        if (d.this.ag) {
                            d.this.a(this.f4862a);
                        }
                    }
                    if (motionEvent.getAction() == 1 && d.this.ah) {
                        d.this.a(this.f4862a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!d.this.ag) {
                    if (!d.this.ah) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.al;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(this.n, this.u, "1");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.d.13
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            an.a(d.this.n, d.this.M, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) d.this).b.setComplain(str);
                            d.this.ao();
                            d.this.H();
                            d.this.az();
                            if (((com.beizi.fusion.work.a) d.this).d != null && ((com.beizi.fusion.work.a) d.this).d.r() != 2) {
                                ((com.beizi.fusion.work.a) d.this).d.b(d.this.f(), d.this.v);
                            }
                            d.this.F();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.n);
            imageView.setImageResource(com.beizi.fusion.R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.v.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.v.getMeasuredWidth(), this.v.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.u.addView(linearLayout, layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.d.a aVar = this.t;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.d.a aVar = this.t;
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

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.d.a aVar = this.t;
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
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.z = shakeView;
        if (shakeView != null) {
            this.A = shakeView.getCoolShakeView();
        }
        this.C = "cool_" + this.i;
        this.K = "dl_cool_" + this.i;
        if (this.r <= 0.0f) {
            this.r = ap.i(this.n);
        }
        if (this.s <= 0.0f) {
            this.s = 0.0f;
        }
        com.beizi.ad.v2.d.a aVar = new com.beizi.ad.v2.d.a(this.n, this.i, 3, new com.beizi.ad.d() { // from class: com.beizi.fusion.work.b.d.1
            @Override // com.beizi.ad.d
            public void a(e eVar) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdLoaded()");
                ((com.beizi.fusion.work.a) d.this).j = com.beizi.fusion.e.a.ADLOAD;
                d.this.L = eVar;
                d dVar = d.this;
                dVar.P = Boolean.valueOf(dVar.t.l());
                d dVar2 = d.this;
                dVar2.am = dVar2.t.i();
                if (d.this.am) {
                    d dVar3 = d.this;
                    dVar3.an = dVar3.t.j();
                    ((com.beizi.fusion.work.a) d.this).b.setIsCacheAd("1");
                    if (d.this.an > 0) {
                        ((com.beizi.fusion.work.a) d.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - d.this.an));
                    }
                    d.this.ao();
                }
                if (d.this.t.a() != null) {
                    try {
                        d dVar4 = d.this;
                        dVar4.a(Double.parseDouble(dVar4.t.a()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                d.this.x();
                if (eVar == null) {
                    d.this.c(-991);
                } else {
                    d.this.c(eVar);
                }
            }

            @Override // com.beizi.ad.d
            public void a(int i) {
                Log.d("BeiZis", "showBeiZiNativeAd onAdFailed: " + i);
                d.this.a(String.valueOf(i), i);
            }
        });
        this.t = aVar;
        aVar.a(true);
        try {
            this.t.a(this.b.m43clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.t.a((int) this.p);
        this.t.a(this.e);
        if ("S2S".equals(g())) {
            this.t.c(g());
            com.beizi.fusion.c.d dVar = this.d;
            if (dVar != null) {
                String strZ = dVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    this.t.b(strZ);
                }
            }
        }
        com.beizi.fusion.c.d dVar2 = this.d;
        if (dVar2 != null) {
            this.t.c(dVar2.A());
        }
        this.t.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        e eVar = this.L;
        if (eVar != null) {
            eVar.g();
        }
        com.beizi.ad.v2.d.a aVar = this.t;
        if (aVar != null) {
            aVar.f();
        }
        ab abVar = this.B;
        if (abVar != null) {
            abVar.c();
        }
        aI();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.B) == null) {
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
            if (!com.beizi.fusion.c.b.a().n() || (abVar = this.B) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.v;
    }

    @Override // com.beizi.fusion.work.a
    public void z() {
        if (!y() || this.t == null) {
            return;
        }
        ag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(e eVar) {
        View viewA;
        if (eVar == null) {
            return;
        }
        try {
            if (eVar.m() == null || (viewA = com.beizi.ad.internal.c.d.a(this.n, eVar)) == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.u.getLayoutParams().width * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.u.addView(viewA, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(e eVar) {
        ImageView imageView = new ImageView(this.n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(85, 85);
        imageView.setPadding(25, 15, 15, 25);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageResource(com.beizi.fusion.R.drawable.beizi_close);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(85, 85);
        layoutParams2.gravity = 5;
        this.u.addView(imageView, layoutParams2);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                d.this.G = motionEvent.getX();
                d.this.H = motionEvent.getY();
                d.this.I = motionEvent.getRawX();
                d.this.J = motionEvent.getRawY();
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.d.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.aE()) {
                    d.this.aF();
                    return;
                }
                d.this.ae = false;
                d.this.a(new String[]{String.valueOf(d.this.G), String.valueOf(d.this.H), String.valueOf(d.this.I), String.valueOf(d.this.J)}, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final e eVar) {
        if (eVar == null) {
            c(-991);
            return;
        }
        ArrayList<String> arrayListH = eVar.h();
        if (arrayListH != null && arrayListH.size() != 0) {
            final ImageView imageView = new ImageView(this.n);
            imageView.setVisibility(0);
            h.a((Context) null).a(arrayListH.get(0), new h.a() { // from class: com.beizi.fusion.work.b.d.10
                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    try {
                        Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded");
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        float f = (float) ((((double) width) * 1.0d) / ((double) height));
                        int iA = ap.a(d.this.n, d.this.r);
                        int iA2 = d.this.s > 0.0f ? ap.a(d.this.n, d.this.s) : (int) (iA / f);
                        ImageView imageView2 = imageView;
                        if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                            layoutParams.width = iA;
                            layoutParams.height = iA2;
                            imageView.setLayoutParams(layoutParams);
                        }
                        if (imageView != null) {
                            imageView.setBackground(new BitmapDrawable(w.a(d.this.n, bitmap, 20.0f)));
                            imageView.setImageBitmap(bitmap);
                        }
                        d.this.R = iA;
                        d.this.S = iA2;
                        if (d.this.S < 0) {
                            d.this.S = height;
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA2);
                        if (d.this.u != null) {
                            d.this.u.removeAllViews();
                            d.this.u.setLayoutParams(layoutParams2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("mNativeAd != null ? ");
                            boolean z = true;
                            sb.append(d.this.t != null);
                            sb.append(",renderViewBean != null ? ");
                            if (d.this.x == null) {
                                z = false;
                            }
                            sb.append(z);
                            aa.a("BeiZis", sb.toString());
                            d.this.u.addView(imageView, layoutParams2);
                            d.this.d(eVar);
                            d.this.ay();
                            d.this.e(eVar);
                            d.this.a(eVar, iA, iA2, bitmap.getHeight());
                            d.this.aB();
                            if (((com.beizi.fusion.work.a) d.this).b != null && d.this.E != null) {
                                ((com.beizi.fusion.work.a) d.this).b.setDislikeUuid(d.this.E.getDislikeUuid());
                                d.this.ao();
                            }
                            if (d.this.aC()) {
                                d.this.f(eVar);
                            }
                            d dVar = d.this;
                            dVar.v = dVar.u;
                            if (d.this.B != null) {
                                d.this.B.a(d.this.v);
                            }
                        }
                        if (d.this.t != null && d.this.x != null) {
                            d.this.t.a(d.this.y);
                            d.this.t.b(d.this.x.getOptimizePercent());
                            aa.a("BeiZis", "percent = " + d.this.x.getOptimizePercent());
                            d.this.u.post(new Runnable() { // from class: com.beizi.fusion.work.b.d.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.beizi.ad.v2.d.a aVar = d.this.t;
                                    int optimizeSize = d.this.x.getOptimizeSize();
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    aVar.a(optimizeSize, imageView, d.this.u, d.this.x.getDirection());
                                }
                            });
                        }
                        d.this.b(eVar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
                    d.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            });
            if (!this.ag && !this.ah) {
                com.beizi.ad.internal.c.d.a(eVar, imageView, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.d.11

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    boolean f4848a = false;

                    @Override // com.beizi.ad.internal.c.b
                    public void a() {
                        d.this.b();
                    }

                    @Override // com.beizi.ad.internal.c.b
                    public void b() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
                    }
                });
            } else {
                aK();
            }
            com.beizi.ad.v2.d.a aVar = this.t;
            if (aVar != null) {
                aVar.a(imageView, new com.beizi.ad.internal.c.c() { // from class: com.beizi.fusion.work.b.d.12
                    @Override // com.beizi.ad.internal.c.c
                    public void a() {
                        Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
                        d.this.ab = System.currentTimeMillis();
                        ((com.beizi.fusion.work.a) d.this).j = com.beizi.fusion.e.a.ADSHOW;
                        if (d.this.am) {
                            ((com.beizi.fusion.work.a) d.this).b.setIsCacheAd("1");
                            if (d.this.an > 0) {
                                ((com.beizi.fusion.work.a) d.this).b.setCacheTime(String.valueOf(System.currentTimeMillis() - d.this.an));
                            }
                            d.this.ao();
                        }
                        if (((com.beizi.fusion.work.a) d.this).d != null && ((com.beizi.fusion.work.a) d.this).d.r() != 2) {
                            ((com.beizi.fusion.work.a) d.this).d.b(d.this.f());
                        }
                        d.this.B();
                        d.this.C();
                        d.this.ac();
                        d.this.aH();
                        d.this.aJ();
                    }
                });
                return;
            }
            return;
        }
        Log.d("BeiZis", "showBeiZiNativeAd imageUrls address is null");
        c(-991);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ae, code lost:
    
        r7.O = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r4.getRate()));
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
        this.al = this.e.getComplain();
        this.M = "complain_config_" + this.i;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.ac = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.U = af.a(adSlide.getRandomNum());
                this.V = adSlide.getNeedTime();
                this.W = adSlide.getDistance();
            }
            this.ae = af.a(nativeOptimize.getCloseClickNum());
            this.ag = af.a(nativeOptimize.getTouchDownNum());
            this.ah = af.a(nativeOptimize.getHoldSlideNum());
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.N = true;
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
        this.w = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.w.get(0);
            this.x = renderViewBean;
            this.y = o.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.events.b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                t();
                com.beizi.fusion.c.l.a(this.n, this.h);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (Y()) {
            a(eVar);
        } else {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        AdSpacesBean.BuyerBean buyerBean;
        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
        this.T = true;
        this.ad = false;
        this.ae = false;
        aI();
        if (this.N && (buyerBean = this.e) != null) {
            this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            ao();
        }
        E();
        if (!this.N || this.O) {
            com.beizi.fusion.c.d dVar = this.d;
            if (dVar != null && dVar.r() != 2) {
                this.d.d(f());
            }
            D();
            ad();
            com.beizi.ad.v2.d.a aVar = this.t;
            if (aVar != null) {
                aVar.o();
            }
        }
    }

    private void a(e eVar) {
        com.beizi.fusion.c.d dVar = this.d;
        if (dVar == null) {
            return;
        }
        Log.d("BeiZis", f() + " NativeAdWorker:" + dVar.q().toString());
        Z();
        com.beizi.fusion.c.e eVar2 = this.g;
        if (eVar2 == com.beizi.fusion.c.e.SUCCESS) {
            if (this.v != null) {
                this.d.a(f(), this.v);
                return;
            } else {
                this.d.a(10140);
                return;
            }
        }
        if (eVar2 == com.beizi.fusion.c.e.FAIL) {
            Log.d("BeiZis", "other worker shown," + f() + " remove");
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

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) an.b(this.n, this.C, 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.A.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.B.a(shakeViewBean);
                    }
                }, this.A.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            ak.a().a(this.C);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final e eVar, final int i, final int i2, int i3) {
        try {
            if (!com.beizi.fusion.c.b.a().o() && aG()) {
                if (this.B == null) {
                    this.B = new ab(this.n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.z;
                if (shakeViewBean == null || this.B == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.z.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.z.getOrderData(), this.t.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) ? null : orderDataShakeViewBeanA.getShakeView();
                if (i2 <= 0) {
                    i2 = i3;
                }
                this.B.a(this.P);
                View viewA = this.B.a(ap.b(this.n, i), ap.b(this.n, i2), this.z.getPosition());
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.z;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.u.addView(viewA, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.B.a(new ab.a() { // from class: com.beizi.fusion.work.b.d.14
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        try {
                            if (!ar.a(d.this.v) || d.this.ad) {
                                return;
                            }
                            d.this.T = true;
                            d.this.ad = true;
                            int[] iArr = new int[2];
                            d.this.v.getLocationOnScreen(iArr);
                            int[] iArrA = af.a(i / 2, i2 / 2);
                            if (eVar != null && d.this.v != null) {
                                eVar.a(d.this.v, String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), 2, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.d.14.1
                                    @Override // com.beizi.ad.internal.c.b
                                    public void a() {
                                        d.this.b();
                                    }

                                    @Override // com.beizi.ad.internal.c.b
                                    public void b() {
                                    }
                                });
                            }
                            if (!d.this.D || d.this.A == null) {
                                return;
                            }
                            d.this.D = false;
                            d.this.B.a(d.this.A);
                            an.a(d.this.n, d.this.C, (Object) Long.valueOf(System.currentTimeMillis()));
                            ak.a().a(d.this.C, System.currentTimeMillis());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.A;
                if (coolShakeViewBean != null) {
                    this.B.a(coolShakeViewBean, this.C);
                }
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
            com.beizi.ad.v2.d.a aVar = this.t;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(e eVar) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(this.n, eVar.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewB = t.b(this.n, eVar.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            this.u.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = ap.a(this.n, 12.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.z;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.B;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.A == null) {
            this.D = true;
            this.B.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.B.a(this.A);
        } else if (aA()) {
            this.B.a(this.A);
        } else {
            this.D = true;
            this.B.a(shakeViewBean);
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

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.d.a aVar = this.t;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i) {
        View view;
        try {
            aI();
            if (this.L != null && this.v != null && !this.ad && !this.T) {
                this.T = true;
                this.ad = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ac);
                    ao();
                }
                e eVar = this.L;
                if (eVar == null || (view = this.v) == null) {
                    return;
                }
                eVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.d.3
                    @Override // com.beizi.ad.internal.c.b
                    public void a() {
                        d.this.b();
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
            aI();
            if (this.L == null || this.v == null || this.ad) {
                return;
            }
            this.T = true;
            this.ad = true;
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setNativeRuleUuid(this.ac);
                ao();
            }
            e eVar = this.L;
            if (eVar == null || (view = this.v) == null) {
                return;
            }
            eVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.c.b() { // from class: com.beizi.fusion.work.b.d.9
                @Override // com.beizi.ad.internal.c.b
                public void a() {
                    d.this.b();
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

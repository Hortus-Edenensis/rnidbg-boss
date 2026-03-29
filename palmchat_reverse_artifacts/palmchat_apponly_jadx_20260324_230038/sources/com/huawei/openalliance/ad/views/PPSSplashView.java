package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.fq;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.ie;
import com.huawei.hms.ads.iq;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.lt;
import com.huawei.hms.ads.lv;
import com.huawei.hms.ads.me;
import com.huawei.hms.ads.mg;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.dialog.PPSAdvertiserInfoDialog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSSplashView extends PPSSafeRelativeLayout implements lt, me {
    private PPSSplashProView A;
    protected eh B;
    protected long C;
    SloganView Code;
    private AdSlotParam D;
    private PPSSplashSwipeView E;
    private PPSSplashTwistView G;
    private PPSSplashSwipeClickView H;
    PPSSkipButton I;
    private PPSSplashTwistClickView J;
    private b K;
    private View L;
    private AdContentData M;
    private SplashLoadListener N;
    private SplashListener O;
    private boolean P;
    RelativeLayout V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6977a;
    private PPSWLSView b;
    private PPSSplashAdSourceView c;
    private ft d;
    private jc e;
    private com.huawei.openalliance.ad.inter.listeners.b f;
    private com.huawei.openalliance.ad.inter.listeners.a g;
    private boolean h;
    private int i;
    private Bitmap j;
    private View k;
    private lv l;
    private int m;
    private String n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private View u;
    private boolean v;
    private int w;
    private final String x;
    private int y;
    private RewardVerifyConfig z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSSplashView> Code;
        private AdContentData V;

        public a(PPSSplashView pPSSplashView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSSplashView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSSplashView pPSSplashView = this.Code.get();
            if (pPSSplashView != null) {
                final int[] choiceViewLoc = pPSSplashView.b.getChoiceViewLoc();
                final int[] choiceViewSize = pPSSplashView.b.getChoiceViewSize();
                if (z.Code(choiceViewLoc, 2) && z.Code(choiceViewSize, 2)) {
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSSplashView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d.b {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.inter.d.b
        public void Code() {
            fh.V("PPSSplashView", "onStart");
            PPSSplashView.this.i();
        }
    }

    public PPSSplashView(Context context) {
        super(context);
        this.f6977a = 8;
        this.h = false;
        this.m = 0;
        this.o = 0;
        this.p = 1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.v = true;
        this.w = 0;
        this.x = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private PPSSkipButton Code(String str, int i, String str2, boolean z, float f, int i2) {
        int i3;
        boolean z2;
        PPSSkipButton pPSSkipButton;
        int iV = this.D.V();
        int I = this.D.I();
        e();
        if (1 == iV) {
            pPSSkipButton = new PPSSkipButton(getContext(), str, iV, I, i, str2, z, z.V(getContext(), 24.0f), f, i2, false);
        } else {
            fh.V("PPSSplashView", "createSkipAdButton, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iV), Integer.valueOf(this.r), Integer.valueOf(this.s));
            int i4 = this.r;
            if (i4 > 0) {
                i3 = i4;
                z2 = true;
            } else {
                i3 = this.s;
                z2 = false;
            }
            pPSSkipButton = new PPSSkipButton(getContext(), str, iV, I, i, str2, z, i3, f, i2, z2);
        }
        pPSSkipButton.setAdMediator(this.d);
        return pPSSkipButton;
    }

    private void D() {
        String str;
        int I;
        int i;
        int i2;
        int i3;
        View view;
        try {
            if (this.k == null) {
                View viewInflate = ((ViewStub) findViewById(R.id.hiad_logo_stub)).inflate();
                this.k = viewInflate;
                viewInflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            if (1 == this.D.V()) {
                e();
                int iV = z.V(getContext(), 24.0f);
                fh.Code("PPSSplashView", "left: %s, top: %s, right: %s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + iV, layoutParams.rightMargin, layoutParams.bottomMargin);
                view = this.k;
            } else {
                fh.V("PPSSplashView", "showFullModeLogo, orientation: %s, leftNotchHeight: %s", Integer.valueOf(this.D.V()), Integer.valueOf(this.r));
                fh.Code("PPSSplashView", "left:%s, top:%s, right:%s, leftNotchHeight:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(this.r));
                if (!cn.V(getContext()) || this.r <= 0) {
                    if (!cn.V(getContext()) || (cn.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 && !q.B(getContext()))) {
                        if (layoutParams.isMarginRelative()) {
                            layoutParams.setMarginStart(bg.I(getContext()));
                        } else {
                            I = bg.I(getContext());
                            i = layoutParams.topMargin;
                            i2 = layoutParams.rightMargin;
                            i3 = layoutParams.bottomMargin;
                            layoutParams.setMargins(I, i, i2, i3);
                        }
                    }
                    layoutParams.topMargin += z.V(getContext(), 12.0f);
                    view = this.k;
                } else if (layoutParams.isMarginRelative()) {
                    layoutParams.setMarginStart(layoutParams.leftMargin + this.r);
                    layoutParams.topMargin += z.V(getContext(), 12.0f);
                    view = this.k;
                } else {
                    I = layoutParams.leftMargin + this.r;
                    i = layoutParams.topMargin;
                    i2 = layoutParams.rightMargin;
                    i3 = layoutParams.bottomMargin;
                    layoutParams.setMargins(I, i, i2, i3);
                    layoutParams.topMargin += z.V(getContext(), 12.0f);
                    view = this.k;
                }
            }
            view.setLayoutParams(layoutParams);
            d();
            a();
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            fh.I("PPSSplashView", str);
        } catch (Exception e) {
            str = "showFullModeLogo " + e.getClass().getSimpleName();
            fh.I("PPSSplashView", str);
        }
    }

    private void F() {
        List<String> listCode = this.D.Code();
        this.e.Code(!ag.Code(listCode) ? listCode.get(0) : null, 1);
        this.e.F();
        com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
    }

    private void L() {
        if (this.k == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.a();
            }
        });
    }

    private int Z(AdContentData adContentData) {
        return (adContentData.aA() == null || adContentData.aA().Code() == null) ? this.B.y() : adContentData.aA().Code().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        View view = this.k;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.hiad_media_name);
        int i = this.m;
        if (i > 0) {
            textView.setText(i);
        } else {
            String str = this.n;
            if (str == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
        }
        textView.setVisibility(0);
    }

    private void c() {
        if (this.k == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.2
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        View view = this.k;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.hiad_full_mode_logo);
        int i = this.i;
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            Bitmap bitmap = this.j;
            if (bitmap == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
        imageView.setVisibility(0);
    }

    private void e() {
        if (this.q > 0 || cn.Code(getContext().getApplicationContext()).Code(getContext().getApplicationContext())) {
            return;
        }
        this.q = z.g(getContext().getApplicationContext());
    }

    private void f() {
        if (this.I != null) {
            fh.Code("PPSSplashView", "%d delay, skip btn show", Integer.valueOf(this.w));
            if (this.w > 0) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashView.this.I != null) {
                            fh.Code("PPSSplashView", "skip btn show");
                            PPSSplashView.this.I.setVisibility(0);
                        }
                    }
                }, this.x, this.w);
            } else {
                fh.Code("PPSSplashView", "skip btn show");
                this.I.setVisibility(0);
            }
        }
    }

    private boolean g() {
        if (this.B.g()) {
            return !q.Z(getContext().getApplicationContext());
        }
        return true;
    }

    private void h() {
        int iA = this.B.A();
        if (iA > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
            int iV = z.V(getContext(), iA);
            this.A.setPadding(iV, iV, iV, iV);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - iV);
                layoutParams.setMarginEnd(layoutParams.rightMargin - iV);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - iV, layoutParams.topMargin, layoutParams.rightMargin - iV, layoutParams.bottomMargin);
            }
            this.A.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!this.h || this.D == null) {
            return;
        }
        fh.V("PPSSplashView", " exsplash start, dismiss");
        F();
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.ar() <= 0) {
            return;
        }
        this.w = adContentData.ar();
    }

    @Override // com.huawei.hms.ads.lt
    public void B() {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.u;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.hms.ads.lt
    public boolean S() {
        return this.P;
    }

    @Override // com.huawei.hms.ads.lt
    public lv V(int i) {
        if (i == 2) {
            return new PPSImageView(getContext());
        }
        if (i != 9) {
            return null;
        }
        return new PPSVideoView(getContext(), this.D.V(), Math.max(this.s, 0), this.D.I(), 1);
    }

    public void destroyView() {
        lv lvVar = this.l;
        if (lvVar != null) {
            lvVar.destroyView();
        }
        try {
            PPSSplashProView pPSSplashProView = this.A;
            if (pPSSplashProView != null) {
                pPSSplashProView.Code();
            }
            PPSSplashSwipeView pPSSplashSwipeView = this.E;
            if (pPSSplashSwipeView != null) {
                pPSSplashSwipeView.V();
            }
            PPSSplashSwipeClickView pPSSplashSwipeClickView = this.H;
            if (pPSSplashSwipeClickView != null) {
                pPSSplashSwipeClickView.V();
            }
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).V(this.K);
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
            RelativeLayout relativeLayout = this.V;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable th) {
            fh.V("PPSSplashView", "destroy err: %s", th.getClass().getSimpleName());
        }
        this.h = false;
    }

    public Context getActivityContext() {
        return getContext();
    }

    public AdContentData getAdContentData() {
        ft ftVar = this.d;
        return ftVar != null ? ftVar.s() : new AdContentData();
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.f;
    }

    public ft getAdMediator() {
        return this.d;
    }

    @Override // com.huawei.hms.ads.lt
    public AdSlotParam getAdSlotParam() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.lt
    public int getAdType() {
        return 1;
    }

    @Override // com.huawei.hms.ads.lt
    public int getAudioFocusType() {
        return this.p;
    }

    public BiddingInfo getBiddingInfo() {
        ft ftVar = this.d;
        return (ftVar == null || ftVar.p() == null) ? new BiddingInfo() : this.d.p();
    }

    public AdContentData getContentRecord() {
        ft ftVar = this.d;
        if (ftVar != null) {
            return ftVar.m();
        }
        return null;
    }

    public View getLogo() {
        return this.L;
    }

    public Bitmap getLogoBitmap() {
        return this.j;
    }

    public int getLogoResId() {
        return this.i;
    }

    public int getMediaNameResId() {
        return this.m;
    }

    public String getMediaNameString() {
        return this.n;
    }

    public View getSloganView() {
        return this.u;
    }

    public jc getSplashPresenter() {
        return this.e;
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout
    public String getTAG() {
        return "PPSSplashView";
    }

    public String getUniqueId() {
        ft ftVar = this.d;
        if (ftVar != null) {
            return ftVar.o();
        }
        return null;
    }

    public boolean isLoaded() {
        ft ftVar = this.d;
        return ftVar != null && ftVar.V() == com.huawei.openalliance.ad.constant.b.LOADED;
    }

    public boolean isLoading() {
        ft ftVar = this.d;
        return ftVar == null ? this.h : ftVar.V() == com.huawei.openalliance.ad.constant.b.LOADING;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        fh.V("PPSSplashView", "onApplyWindowInsets");
        if (bg.V() && windowInsets != null && (displayCutout = windowInsets.getDisplayCutout()) != null) {
            List boundingRects = displayCutout.getBoundingRects();
            if (!ag.Code(boundingRects)) {
                this.q = ((Rect) boundingRects.get(0)).height();
            }
            this.r = displayCutout.getSafeInsetLeft();
            fh.V("PPSSplashView", "notchHeight left:" + this.r);
            this.s = displayCutout.getSafeInsetRight();
            fh.V("PPSSplashView", "notchHeight right:" + this.s);
        }
        if (this.q <= 0 && Build.VERSION.SDK_INT >= 26 && cn.Code(getContext()).Code(getContext())) {
            this.q = Math.max(this.q, cn.Code(getContext()).Code(this));
        }
        fh.V("PPSSplashView", "notchHeight:" + this.q);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fh.V("PPSSplashView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bj.Code(this.x);
        PPSSplashProView pPSSplashProView = this.A;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.E;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.H;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void pauseView() {
        lv lvVar = this.l;
        if (lvVar != null) {
            lvVar.pauseView();
        }
        PPSSplashProView pPSSplashProView = this.A;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.E;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.H;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void resumeView() {
        lv lvVar = this.l;
        if (lvVar != null) {
            lvVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.g = aVar;
        ft ftVar = this.d;
        if (ftVar != null) {
            ftVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.f = bVar;
        this.e.Code(bVar);
        ft ftVar = this.d;
        if (ftVar != null) {
            ftVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (z.Code(getContext())) {
            int iCode = bf.Code(getContext(), adSlotParam.V());
            int iV = bf.V(getContext(), adSlotParam.V());
            adSlotParam.Z(iCode);
            adSlotParam.B(iV);
            adSlotParam.I(this.y);
            adSlotParam.L(Integer.valueOf(this.t));
            adSlotParam.Code(com.huawei.hms.ads.utils.c.Code(adSlotParam.B()));
            adSlotParam.Z((Integer) 0);
            boolean zIsNewProcess = HiAd.Code(getContext()).isNewProcess();
            this.P = zIsNewProcess;
            adSlotParam.B(Integer.valueOf((zIsNewProcess && com.huawei.openalliance.ad.utils.d.L(getContext())) ? 0 : 1));
            this.D = adSlotParam;
            com.huawei.openalliance.ad.inter.h hVarCode = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (hVarCode instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) hVarCode).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.p = i;
        lv lvVar = this.l;
        if (lvVar != null) {
            lvVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.t = i;
    }

    public void setLogo(View view) {
        setLogo(view, 8);
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.j = bitmap;
        this.i = 0;
        c();
    }

    public void setLogoResId(int i) {
        this.i = i;
        this.j = null;
        c();
    }

    public void setMediaNameResId(int i) {
        this.m = i;
        this.n = null;
        L();
    }

    public void setMediaNameString(String str) {
        this.n = str;
        this.m = 0;
        L();
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.z = rewardVerifyConfig;
    }

    public void setSloganResId(int i) {
        if (z.Code(getContext())) {
            if (I(getContext())) {
                fh.I("PPSSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.D == null && !(this instanceof SplashView)) {
                throw new dt("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.Code == null) {
                SloganView sloganView = new SloganView(getContext(), i, 1);
                this.Code = sloganView;
                int i2 = this.o;
                if (i2 > 0) {
                    sloganView.setWideSloganResId(i2);
                }
                this.V.addView(this.Code, new RelativeLayout.LayoutParams(-1, -1));
                this.Code.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.u = view;
            view.setVisibility(8);
        }
    }

    public void setSplashListener(SplashListener splashListener) {
        this.O = splashListener;
    }

    public void setSplashLoadListener(SplashLoadListener splashLoadListener) {
        this.N = splashLoadListener;
    }

    public void setWideSloganResId(int i) {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.setWideSloganResId(i);
        } else {
            this.o = i;
        }
    }

    public PPSSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6977a = 8;
        this.h = false;
        this.m = 0;
        this.o = 0;
        this.p = 1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.v = true;
        this.w = 0;
        this.x = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private String Code(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.a();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.lt
    public Integer V(AdContentData adContentData) {
        int iC = jg.C(adContentData.v());
        if (iC == 0) {
            return null;
        }
        int iZ = Z(adContentData);
        fh.V("PPSSplashView", "initial mode: %s", Integer.valueOf(iZ));
        if (iZ == 0) {
            return Integer.valueOf(iZ);
        }
        Map<String, String> mapCode = ad.Code(eh.Code(getContext()).aj());
        if (mapCode != null) {
            if (Z(iZ)) {
                boolean zJ = bg.j(getContext());
                if (Code(bc.I(mapCode.get(x.cz))) || !zJ) {
                    iZ = 4;
                }
            }
            if (B(iZ) && Code(bc.I(mapCode.get(x.cy)))) {
                return 0;
            }
        }
        int i = (!Z(iZ) || bg.j(getContext())) ? iZ : 4;
        if (1 != this.D.V() || 2 != iC) {
            return 0;
        }
        if (!Z(i) || !g()) {
            return Integer.valueOf(i);
        }
        fh.V("PPSSplashView", "can't use twist, enable : %s", Boolean.valueOf(this.B.g()));
        return 0;
    }

    public void setLogo(View view, int i) {
        this.L = view;
        view.setVisibility(i);
        this.f6977a = i;
    }

    public PPSSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6977a = 8;
        this.h = false;
        this.m = 0;
        this.o = 0;
        this.p = 1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.v = true;
        this.w = 0;
        this.x = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private boolean B(int i) {
        return 1 == i || 4 == i;
    }

    private String Code(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.b() == null) ? this.B.E() : interactCfg.b();
    }

    private String V(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    public void I() {
        AdSlotParam adSlotParam;
        fh.V("PPSSplashView", "loadAdOnly");
        this.C = System.currentTimeMillis();
        if (!this.e.V()) {
            SplashLoadListener splashLoadListener = this.N;
            if (splashLoadListener != null) {
                splashLoadListener.onAdFailed(1001);
                return;
            }
            return;
        }
        if (this.e.S() && (adSlotParam = this.D) != null) {
            Integer numF = adSlotParam.F();
            boolean zCode = com.huawei.openalliance.ad.inter.d.Code(getContext()).Code();
            fh.V("PPSSplashView", "startMode: %s, isExSplashStart: %s", numF, Boolean.valueOf(zCode));
            if (iq.Code(numF, zCode)) {
                SplashLoadListener splashLoadListener2 = this.N;
                if (splashLoadListener2 != null) {
                    splashLoadListener2.onAdFailed(1203);
                    return;
                }
                return;
            }
        }
        if (this.d == null) {
            this.d = fq.Code(2, this);
        }
        this.d.Code(this.N);
        this.d.Code(this.O);
        this.d.Code(0);
        this.d.V(this.C);
        this.d.Code(this.z);
        this.d.V(false);
    }

    public boolean Z() {
        ft ftVar = this.d;
        if (ftVar == null) {
            return true;
        }
        return ftVar.j();
    }

    private String Code(String str) {
        String strCode = com.huawei.openalliance.ad.utils.c.Code(getContext(), this.M, 0);
        return !TextUtils.isEmpty(strCode) ? strCode : !TextUtils.isEmpty(this.B.z()) ? this.B.z() : str;
    }

    private String V(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.b() == null) ? this.B.H() : interactCfg.b();
    }

    private boolean Z(int i) {
        return 2 == i || 3 == i;
    }

    @Override // com.huawei.hms.ads.lt
    public void I(int i) {
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            pPSSkipButton.Code(i);
        }
    }

    private void I(AdContentData adContentData) {
        int i;
        boolean z;
        PPSSplashAdSourceView pPSSplashAdSourceView;
        boolean z2;
        int i2;
        boolean z3;
        PPSWLSView pPSWLSView;
        boolean z4;
        if (adContentData != null) {
            int iV = this.D.V();
            Integer numV = V(adContentData);
            InteractCfg interactCfgAA = adContentData.aA();
            Integer numC = interactCfgAA == null ? null : interactCfgAA.C();
            e();
            if (this.v) {
                this.c.setAdMediator(this.d);
                this.c.Code(this, numV, numC, z.Code(true, adContentData.aQ(), adContentData.aP()));
                this.c.setVisibility(0);
                if (1 == iV) {
                    pPSSplashAdSourceView = this.c;
                    z2 = adContentData.c() == 1;
                    i = this.q;
                    z = false;
                } else {
                    fh.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iV), Integer.valueOf(this.r), Integer.valueOf(this.s));
                    int i3 = this.r;
                    if (i3 > 0) {
                        i = i3;
                        z = true;
                    } else {
                        i = this.s;
                        z = false;
                    }
                    pPSSplashAdSourceView = this.c;
                    z2 = adContentData.c() == 1;
                }
                pPSSplashAdSourceView.Code(adContentData, z2, i, iV, z);
                return;
            }
            this.b.setAdMediator(this.d);
            this.b.Code(numV, numC);
            this.b.setVisibility(0);
            if (1 == iV) {
                pPSWLSView = this.b;
                z4 = adContentData.c() == 1;
                i2 = this.q;
                z3 = false;
            } else {
                fh.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iV), Integer.valueOf(this.r), Integer.valueOf(this.s));
                int i4 = this.r;
                if (i4 > 0) {
                    i2 = i4;
                    z3 = true;
                } else {
                    i2 = this.s;
                    z3 = false;
                }
                pPSWLSView = this.b;
                z4 = adContentData.c() == 1;
            }
            pPSWLSView.Code(adContentData, z4, i2, iV, z3);
            if (ag.Code(adContentData.aL())) {
                return;
            }
            this.b.setChoiceViewOnClickListener(new a(this, adContentData));
        }
    }

    private void V(Context context) {
        View.inflate(context, R.layout.hiad_view_splash_ad, this);
        this.V = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.b = (PPSWLSView) findViewById(R.id.splash_wls_view);
        this.c = (PPSSplashAdSourceView) findViewById(R.id.splash_ad_source_view);
        this.v = cn.Code(context).V();
        this.A = (PPSSplashProView) findViewById(R.id.hiad_splash_pro_view);
        this.E = (PPSSplashSwipeView) findViewById(R.id.hiad_splash_swipe_view);
        this.G = (PPSSplashTwistView) findViewById(R.id.hiad_splash_twist_view);
        this.J = (PPSSplashTwistClickView) findViewById(R.id.hiad_splash_twist_click_view);
        this.H = (PPSSplashSwipeClickView) findViewById(R.id.hiad_splash_swipe_click_view);
    }

    public void Code(int i) {
        fp fpVarCode = fq.Code(i, this);
        this.d = fpVarCode;
        fpVarCode.Code(this.f);
        this.d.Code(this.g);
        this.d.Code(this.t);
        this.d.V(this.C);
        this.d.Code(this.z);
        this.d.q();
    }

    private static boolean I(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    private void V(AdContentData adContentData, int i) {
        String str;
        String str2;
        boolean z;
        float f;
        int iAh;
        if (I(getContext())) {
            fh.I("PPSSplashView", "addSkipAdButton - activity finished, not add view");
            return;
        }
        if (adContentData != null) {
            boolean z2 = adContentData.c() == 1;
            String strB = adContentData.B();
            String strP = adContentData.p();
            float fAg = adContentData.ag();
            iAh = adContentData.ah();
            z = z2;
            str = strB;
            str2 = strP;
            f = fAg;
        } else {
            str = null;
            str2 = null;
            z = false;
            f = 0.0f;
            iAh = 0;
        }
        PPSSkipButton pPSSkipButtonCode = Code(str, i, str2, z, f, iAh);
        this.I = pPSSkipButtonCode;
        pPSSkipButtonCode.setId(R.id.hiad_btn_skip);
        addView(this.I);
        this.I.setVisibility(4);
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(int i, int i2, String str, boolean z, Integer num) {
        if (this.A == null) {
            return;
        }
        fh.V("PPSSplashView", "set splashpro mode: %d", Integer.valueOf(i));
        fh.V("PPSSplashView", "interactCfg = %s", num);
        if (num == null) {
            this.A.setVisibility(8);
        } else if (num.intValue() == 0) {
            Code(i2, str, z);
        } else {
            Code(z, num.intValue());
        }
        this.A.setMode(i);
    }

    private void Code(int i, String str, boolean z) {
        fh.V("PPSSplashView", "showClickButton");
        h();
        this.A.setVisibility(4);
        this.A.setDesc(Code(str));
        this.A.setOrientation(this.D.V());
        this.A.Code(z, i);
        if (i != 0) {
            this.A.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(int i, boolean z) {
        View view = this.L;
        if (view == null) {
            return;
        }
        if (1 == i) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
        if (z) {
            D();
        }
    }

    private void Code(Context context) {
        V(context);
        this.e = new iq(context, this);
        this.B = eh.Code(context);
        this.y = q.I(context.getApplicationContext());
        this.K = new b();
        com.huawei.openalliance.ad.inter.d.Code(context.getApplicationContext()).Code(this.K);
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(View view) {
        fh.V("PPSSplashView", "showTemplateView");
        if (I(getContext())) {
            fh.I("PPSSplashView", "showAdView - activity finished, not add view");
        } else {
            this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.lt
    public void Code(lv lvVar, Integer num) {
        if (I(getContext())) {
            fh.I("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (lvVar == 0 || !(lvVar instanceof View)) {
            return;
        }
        View view = (View) lvVar;
        this.l = lvVar;
        ViewParent parent = view.getParent();
        if (parent == this.V) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
        lvVar.setAudioFocusType(this.p);
        fh.V("PPSSplashView", "set splashpro view to adview");
        if (num != null && num.intValue() == 4) {
            lvVar.Code(this.H.getClickAreaView(), num);
        } else if (num == null || num.intValue() != 3) {
            lvVar.Code(this.A, num);
        } else {
            lvVar.Code(this.J.getClickAreaView(), num);
        }
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(mg mgVar) {
        View view = this.L;
        if (view != null) {
            view.setVisibility(this.f6977a);
        }
        View view2 = this.u;
        if (view2 != null) {
            view2.setVisibility(0);
            new ie(this.B, mgVar).V();
            return;
        }
        SloganView sloganView = this.Code;
        if (sloganView == null) {
            fh.V("PPSSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.Code;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(mgVar);
        this.Code.Code();
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(AdContentData adContentData) {
        super.setAdData(adContentData);
        super.b();
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(AdContentData adContentData, int i) {
        this.M = adContentData;
        setSkipBtnDelayTime(adContentData);
        if (this.I == null) {
            V(adContentData, i);
        }
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            lv lvVar = this.l;
            if (lvVar != null) {
                pPSSkipButton.setShowLeftTime(lvVar.C());
            }
            if (adContentData != null && adContentData.l() == 9) {
                if (this.l instanceof PPSVideoView) {
                    this.I.Code((int) Math.ceil((((PPSVideoView) r5).getSplashDuration() * 1.0f) / 1000.0f));
                }
            }
            f();
        }
        I(adContentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (z.Code(iArr, 2) && z.Code(iArr2, 2) && adContentData != null) {
            if (fh.Code()) {
                fh.Code("PPSSplashView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                fh.Code("PPSSplashView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            addView(pPSAdvertiserInfoDialog, layoutParams);
            pPSAdvertiserInfoDialog.setScreenWidth(getMeasuredWidth());
            pPSAdvertiserInfoDialog.setScreenHeight(getMeasuredHeight());
            pPSAdvertiserInfoDialog.setAdContent(adContentData);
        }
    }

    public void Code(boolean z) {
        if (this.d == null) {
            fh.I("PPSSplashView", "adMediator is null, load ad first");
            SplashListener splashListener = this.O;
            if (splashListener != null) {
                splashListener.onAdError(ai.u);
                return;
            }
        }
        this.d.I(z);
    }

    private void Code(boolean z, int i) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        View view;
        fh.V("PPSSplashView", "showNewStyle, cfg= %s", Integer.valueOf(i));
        String strCode = com.huawei.openalliance.ad.utils.c.Code(getContext(), this.M, i);
        AdContentData adContentData = this.M;
        InteractCfg interactCfgAA = adContentData != null ? adContentData.aA() : null;
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.E;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.E.Code(Code(interactCfgAA), Code(interactCfgAA, strCode));
            this.E.setOrientation(this.D.V());
            this.E.setShowLogo(z);
            view = this.E;
        } else if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.G;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.G.Code(V(interactCfgAA), V(interactCfgAA, strCode));
            this.G.setOrientation(this.D.V());
            this.G.setShowLogo(z);
            view = this.G;
        } else if (3 == i) {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.J;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(4);
            this.J.Code(Z(interactCfgAA), V(interactCfgAA, strCode));
            this.J.setOrientation(this.D.V());
            this.J.setShowLogo(z);
            view = this.J;
        } else {
            if (4 != i || (pPSSplashSwipeClickView = this.H) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.H.Code(I(interactCfgAA), Code(interactCfgAA, strCode));
            this.H.setOrientation(this.D.V());
            this.H.setShowLogo(z);
            view = this.H;
        }
        view.setVisibility(0);
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long jAi = eh.Code(getContext()).ai();
        return jAi == -1 || System.currentTimeMillis() < (jAi * 86400000) + l.longValue();
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }
}

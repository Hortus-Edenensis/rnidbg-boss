package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.Cif;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.dk;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ei;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fu;
import com.huawei.hms.ads.fv;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.hm;
import com.huawei.hms.ads.hx;
import com.huawei.hms.ads.is;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.kh;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.ll;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.ln;
import com.huawei.hms.ads.lr;
import com.huawei.hms.ads.mf;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.activity.FeedbackActivity;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.bp;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSNativeView extends PPSSafeRelativeLayout implements fu, gl, lr {
    public static final /* synthetic */ int e0 = 0;
    private ImageView A;
    private kh B;
    private boolean C;
    protected hb Code;
    private l D;
    private AdContentData E;
    private fv F;
    private boolean G;
    private MultiAdsTemplateView H;
    private Map<String, ll> J;
    private View.OnClickListener K;
    private View L;
    private is<lr> S;
    boolean V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ChoicesView f6973a;
    private int b;
    private CusWhyThisAdView c;
    private boolean d;
    private b e;
    private d f;
    private e g;
    private c h;
    private lm i;
    private ln j;
    private List<View> k;
    private boolean l;
    private final String m;
    private boolean n;
    private boolean o;
    private DislikeAdListener p;
    private String q;
    private String r;
    private MaterialClickInfo s;
    private CusWhyThisAdView.a t;
    private hm u;
    private AdFeedbackListener v;
    private AdCloseBtnClickListener w;
    private IRemoteCreator x;
    private ck y;
    private View z;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void Code(View view);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void Code();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void Code();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void B();

        void I();

        void V();

        void Z();
    }

    public PPSNativeView(Context context) {
        super(context);
        this.B = new kh() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // com.huawei.hms.ads.kh
            public void Code(Bundle bundle) {
                if (PPSNativeView.this.y == null) {
                    fh.V("PPSNativeView", "nativeApi is null handleUrlResult failed");
                } else {
                    PPSNativeView.this.y.Code("handleUrlResult", bundle);
                }
            }
        };
        this.C = true;
        this.Code = new gp();
        this.l = false;
        this.m = x.ao + hashCode();
        this.n = false;
        this.t = CusWhyThisAdView.a.NONE;
        this.G = false;
        this.J = new HashMap();
        this.K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView pPSNativeView = PPSNativeView.this;
                pPSNativeView.Code(view, 7, true, pPSNativeView.D);
            }
        };
        Code(context);
    }

    private void c() {
        fh.Code("PPSNativeView", "initChoicesView start");
        if (this.f6973a == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_choices_wrapper, (ViewGroup) null);
            this.L = viewInflate;
            this.f6973a = (ChoicesView) viewInflate.findViewById(R.id.hiad_choices_icon);
            this.A = (ImageView) this.L.findViewById(R.id.compliance_icon);
            addView(this.L);
            View view = this.L;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        setChoiceViewPosition(1);
        this.f6973a.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.Code() || PPSNativeView.this.D == null) {
                    return;
                }
                if (PPSNativeView.this.D.q() == null) {
                    fh.V("PPSNativeView", "adInfo is null");
                } else if (ag.Code(PPSNativeView.this.D.q().aL())) {
                    com.huawei.openalliance.ad.utils.d.Code(PPSNativeView.this.getContext(), PPSNativeView.this.D);
                } else {
                    ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.D.q(), true);
                }
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.o || PPSNativeView.this.D == null) {
                    return;
                }
                ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.D.q(), false);
            }
        });
    }

    private void d() {
        fh.Code("PPSNativeView", "update choiceView start.");
        if (this.f6973a == null) {
            fh.Code("PPSNativeView", "do not need update choiceView");
            return;
        }
        if (this.c == null) {
            Z();
        }
        if (!this.o && this.c != null) {
            fh.Code("PPSNativeView", "cusWhyView is not null, set choiceView as close.");
            this.f6973a.V();
        } else {
            if (TextUtils.isEmpty(this.q)) {
                return;
            }
            fh.Code("PPSNativeView", "update choiceView.");
            if (TextUtils.isEmpty(this.r)) {
                this.f6973a.I();
            } else {
                this.f6973a.setAdChoiceIcon(this.r);
            }
        }
    }

    private boolean e() {
        fh.Code("PPSNativeView", "checkAndDealWithV3 ApiVer:%s , CreativeType:%s", this.D.ay(), Integer.valueOf(this.D.f()));
        if (!Code(this.D.ay(), this.D.f())) {
            return false;
        }
        V(getContext());
        return true;
    }

    private boolean f() {
        l lVar;
        return (this.z == null || (lVar = this.D) == null || (lVar.ay() != null && 3 == this.D.ay().intValue())) ? false : true;
    }

    private boolean g() {
        l lVar;
        return (this.A == null || this.o || (lVar = this.D) == null || lVar.q() == null || ag.Code(this.D.q().aL())) ? false : true;
    }

    private CusWhyThisAdView.a getWhyAdViewStatus() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        CusWhyThisAdView cusWhyThisAdView = this.c;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                Code(viewGroup, 4);
            }
            this.c.setVisibility(0);
            setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    @AllApi
    public static void hideFeedback(Context context) {
        if (context != null) {
            com.huawei.openalliance.ad.msgnotify.b.Code(context, bp.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
        }
    }

    private void i() {
        Code(this.b);
        V(this.f6973a);
        if (this.d || !j()) {
            return;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.NONE);
        this.C = true;
        Code(this, 0);
    }

    private boolean j() {
        return getWhyAdViewStatus() != CusWhyThisAdView.a.NONE && getWhyAdViewStatus() == CusWhyThisAdView.a.INIT;
    }

    private void k() {
        View view;
        IRemoteCreator iRemoteCreator = this.x;
        if (iRemoteCreator != null && (view = this.z) != null) {
            try {
                iRemoteCreator.destroyView(ObjectWrapper.wrap(view));
            } catch (Throwable th) {
                fh.V("PPSNativeView", "destroy remote view err: %s", th.getClass().getSimpleName());
            }
        }
        this.x = null;
        this.z = null;
        ck ckVar = this.y;
        if (ckVar != null) {
            ckVar.C();
            this.y = null;
        }
    }

    private void l() {
        ez.Code(getContext()).V();
        this.F.V();
        lm lmVar = this.i;
        if (lmVar != null) {
            lmVar.S();
            this.i.setPpsNativeView(null);
        }
        this.i = null;
        this.p = null;
        this.v = null;
        o();
        k();
        MultiAdsTemplateView multiAdsTemplateView = this.H;
        if (multiAdsTemplateView != null) {
            removeView(multiAdsTemplateView);
        }
    }

    private void m() {
        ll llVarCode = Code(this.D);
        if (llVarCode != null) {
            llVarCode.setClickActionListener(new mf() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.10
                private void Z(AppDownloadButton appDownloadButton) {
                    if (PPSNativeView.this.e != null) {
                        fh.V("PPSNativeView", "listener.onClick");
                        PPSNativeView.this.e.Code(appDownloadButton);
                    }
                }

                @Override // com.huawei.hms.ads.mf
                public void Code(AppDownloadButton appDownloadButton) {
                    fh.V("PPSNativeView", "downloadBtn.onClickActionFailed");
                    Z(appDownloadButton);
                    PPSNativeView.this.S.Code(null, null, PPSNativeView.this.getAdTag(), true);
                }

                @Override // com.huawei.hms.ads.mf
                public void I(AppDownloadButton appDownloadButton) {
                    fh.V("PPSNativeView", "downloadBtn.onLeftAdPage");
                    Z(appDownloadButton);
                    if (PPSNativeView.this.g != null) {
                        PPSNativeView.this.g.V();
                        PPSNativeView.this.g.I();
                    }
                }

                @Override // com.huawei.hms.ads.mf
                public void V(AppDownloadButton appDownloadButton) {
                    fh.V("PPSNativeView", "downloadBtn.onClickActionValid");
                    Z(appDownloadButton);
                }
            });
        }
    }

    private void n() {
        l lVar;
        if (!C() || (lVar = this.D) == null || lVar.al()) {
            return;
        }
        fh.V("PPSNativeView", " maybe report show start.");
        I();
    }

    private void o() {
        List<View> list = this.k;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.k) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.k = arrayList;
        if (this.G) {
            arrayList = null;
        }
        I(arrayList);
    }

    private void q() {
        r();
        Code((Integer) 3, false);
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.d();
            this.Code.I();
        }
        lm lmVar = this.i;
        if (lmVar != null) {
            lmVar.S();
        }
        DislikeAdListener dislikeAdListener = this.p;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        l();
    }

    private void r() {
        final ll llVarCode = Code(this.D);
        if (llVarCode != null) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.4
                @Override // java.lang.Runnable
                public void run() {
                    llVarCode.cancel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        r();
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.d();
            this.Code.I();
        }
        lm lmVar = this.i;
        if (lmVar != null) {
            lmVar.S();
        }
        DislikeAdListener dislikeAdListener = this.p;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        l();
    }

    private void setNativeVideoViewClickable(lm lmVar) {
        if (lmVar instanceof NativeVideoView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeVideoView) lmVar);
            I(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhyAdViewStatus(CusWhyThisAdView.a aVar) {
        this.t = aVar;
    }

    private void setWindowImageViewClickable(ln lnVar) {
        if (lnVar instanceof NativeWindowImageView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeWindowImageView) lnVar);
            I(arrayList);
        }
    }

    @Override // com.huawei.hms.ads.fu
    public void I() {
        e eVar;
        if (this.G) {
            return;
        }
        this.l = false;
        long jCode = z.Code();
        String strValueOf = String.valueOf(jCode);
        l lVar = this.D;
        if (lVar == null) {
            fh.V("PPSNativeView", "nativeAd is null, please register first");
            return;
        }
        lVar.I(false);
        this.D.C(false);
        this.D.Z(true);
        this.D.B(strValueOf);
        this.D.V(jCode);
        if (this.n && (eVar = this.g) != null) {
            this.n = false;
            eVar.Z();
        }
        if (!this.D.aj()) {
            this.D.V(true);
            if (this.f != null) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSNativeView.this.f != null) {
                            PPSNativeView.this.f.Code();
                        }
                    }
                });
            }
        }
        this.S.Code(strValueOf);
        this.S.Code(jCode);
        lm lmVar = this.i;
        if (lmVar != null) {
            lmVar.Code(strValueOf);
            this.i.Code(jCode);
        }
        ll llVarCode = Code(this.D);
        if (llVarCode != null) {
            llVarCode.Z(strValueOf);
            llVarCode.Code(jCode);
        }
        ck ckVar = this.y;
        if (ckVar != null) {
            ckVar.Code(strValueOf);
            this.y.Code(jCode);
        }
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.L();
        }
        this.S.Code();
        ck ckVar2 = this.y;
        if (ckVar2 != null) {
            ckVar2.Code("attachToWindow", (Bundle) null);
        }
    }

    public void L() {
        AdCloseBtnClickListener adCloseBtnClickListener = this.w;
        if (adCloseBtnClickListener != null) {
            adCloseBtnClickListener.onCloseBtnClick();
        }
    }

    public void Z() {
        if (this.c == null || getWhyAdViewStatus() != CusWhyThisAdView.a.INIT) {
            View view = this.c;
            if (view != null) {
                Code(view);
                this.c = null;
            }
            setWhyAdViewStatus(CusWhyThisAdView.a.INIT);
            CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this);
            this.c = cusWhyThisAdView;
            addView(cusWhyThisAdView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c.getLayoutParams());
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
        }
        this.c.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.8
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                PPSNativeView.this.h();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSNativeView.this.D != null) {
                    return PPSNativeView.this.D.L();
                }
                fh.I("PPSNativeView", "getKeyWords nativaAd is null");
                return null;
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSNativeView.this.D != null) {
                    com.huawei.openalliance.ad.utils.d.Code(PPSNativeView.this.getContext(), PPSNativeView.this.D);
                } else {
                    fh.I("PPSNativeView", "processWhyThisAdEvent nativaAd is null");
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                PPSNativeView.this.h();
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSNativeView.this.setWhyAdViewStatus(CusWhyThisAdView.a.DISLIKED);
                PPSNativeView.this.V(arrayList);
            }
        });
    }

    public boolean a() {
        return this.G;
    }

    @Override // com.huawei.hms.ads.fu
    public void a_() {
        l lVar;
        if (this.G || (lVar = this.D) == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.9
            @Override // java.lang.Runnable
            public void run() {
                l lVar2 = PPSNativeView.this.D;
                if (lVar2 != null) {
                    PPSNativeView.this.Code(Long.valueOf(lVar2.x()), Integer.valueOf(PPSNativeView.this.F.I()), (Integer) null, false);
                }
            }
        }, this.m, lVar.x());
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iCode = kx.Code(motionEvent);
            ll llVarCode = Code(this.D);
            if (iCode == 0) {
                MaterialClickInfo materialClickInfoCode = kx.Code(this, motionEvent);
                this.s = materialClickInfoCode;
                if (llVarCode != null) {
                    ((AppDownloadButton) llVarCode).Code(materialClickInfoCode);
                }
            }
            if (1 == iCode) {
                kx.Code(this, motionEvent, null, this.s);
                if (llVarCode != null) {
                    ((AppDownloadButton) llVarCode).Code(this.s);
                }
            }
        } catch (Throwable th) {
            fh.I("PPSNativeView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @AllApi
    public void focusPlay() {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            View view = this.z;
            if (view == null || dVarV == null) {
                return;
            }
            dVarV.I(ObjectWrapper.wrap(view), null);
        } catch (Throwable th) {
            fh.I("PPSNativeView", "focusPlay err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void focusStop() {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            View view = this.z;
            if (view == null || dVarV == null) {
                return;
            }
            dVarV.Z(ObjectWrapper.wrap(view), null);
        } catch (Throwable th) {
            fh.I("PPSNativeView", "focusStop err: %s", th.getClass().getSimpleName());
        }
    }

    public hm getAdSessionAgent() {
        return this.u;
    }

    @Override // com.huawei.hms.ads.lr
    public String getAdTag() {
        if (!f() || this.D.aD() == null) {
            return null;
        }
        return this.D.aD().Code();
    }

    public MaterialClickInfo getClickInfo() {
        return this.s;
    }

    @AllApi
    public View getFeedBackView() {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            View view = this.z;
            if (view == null || dVarV == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(dVarV.Code(ObjectWrapper.wrap(view)));
        } catch (Throwable th) {
            fh.I("PPSNativeView", "get anchor view err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public l getNativeAd() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout
    public String getTAG() {
        return "PPSNativeView";
    }

    @AllApi
    public void gotoWhyThisAdPage() {
        if (this.D != null) {
            com.huawei.openalliance.ad.utils.d.Code(getContext(), this.D);
        } else {
            fh.I("PPSNativeView", "skipWhyThisAdPage nativaAd is null");
        }
    }

    @AllApi
    public void hideAdvertiserInfoDialog() {
        hideFeedback(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
        if (this.E != null) {
            b();
        }
        fv fvVar = this.F;
        if (fvVar != null) {
            fvVar.D();
        }
        l lVar = this.D;
        if (lVar != null) {
            Code((com.huawei.openalliance.ad.inter.data.d) lVar);
        }
        jf.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.V = false;
        fh.V("PPSNativeView", "onDetechedFromWindow");
        fv fvVar = this.F;
        if (fvVar != null) {
            fvVar.L();
        }
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.I();
        }
    }

    public void onViewUpdate() {
        if (fh.Code()) {
            fh.Code("PPSNativeView", "manual updateView");
        }
        this.F.onGlobalLayout();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fv fvVar = this.F;
        if (fvVar != null) {
            fvVar.a();
        }
    }

    @AllApi
    public void pause() {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            View view = this.z;
            if (view == null || dVarV == null) {
                return;
            }
            dVarV.Code(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th) {
            fh.I("PPSNativeView", "pauseVideo err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void resume() {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            View view = this.z;
            if (view == null || dVarV == null) {
                return;
            }
            dVarV.V(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th) {
            fh.I("PPSNativeView", "resumeVideo err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener) {
        this.w = adCloseBtnClickListener;
    }

    public void setAdContainerSizeMatched(String str) {
        this.S.V(str);
    }

    @AllApi
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.v = adFeedbackListener;
    }

    public void setChoiceViewPosition(int i) {
        fh.Code("PPSNativeView", "setChoiceViewPosition option = " + i);
        if (this.D == null) {
            this.b = i;
        } else {
            Code(i);
        }
    }

    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        if (this.d) {
            fh.I("PPSNativeView", "china rom should not call setChoiceViewPosition method");
        } else {
            this.p = dislikeAdListener;
        }
    }

    public void setImageInfos(List<ImageInfo> list) {
        this.S.Code(list);
    }

    public void setIsCustomDislikeThisAdEnabled(boolean z) {
        if (this.d) {
            fh.I("PPSNativeView", "china rom should not call this method and isCustomDislikeThisAdEnabled = " + z);
            return;
        }
        this.o = z;
        if (z) {
            fh.Code("PPSNativeView", "dont like default feedback!");
            return;
        }
        fh.Code("PPSNativeView", "like default feedback!");
        ChoicesView choicesView = this.f6973a;
        if (choicesView != null) {
            choicesView.V();
            fh.Code("PPSNativeView", "setCustomLikeBackgroundResource");
        }
        Z();
    }

    public void setMaterialClickInfo(MaterialClickInfo materialClickInfo) {
        this.s = materialClickInfo;
    }

    public void setNativeAd(l lVar) {
        this.D = lVar;
    }

    public void setOnNativeAdClickListener(b bVar) {
        this.e = bVar;
    }

    public void setOnNativeAdImpressionListener(c cVar) {
        this.h = cVar;
    }

    public void setOnNativeAdStatusChangedListener(d dVar) {
        this.f = dVar;
    }

    public void setOnNativeAdStatusTrackingListener(e eVar) {
        this.g = eVar;
        this.S.Code(eVar);
    }

    public void setVideoAlias(String str) {
        this.S.I(str);
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.S.Code(videoInfo);
    }

    @AllApi
    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            fh.I("PPSNativeView", "anchorView is null");
        }
        try {
            l lVar = this.D;
            if (lVar == null) {
                fh.I("PPSNativeView", "adInfo is null");
                return;
            }
            AdContentData adContentDataQ = lVar.q();
            if (ag.Code(adContentDataQ.aL())) {
                fh.I("PPSNativeView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, adContentDataQ, z);
            }
        } catch (Throwable th) {
            fh.I("PPSNativeView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void showFeedback(View view) {
        com.huawei.openalliance.ad.feedback.a aVar = new com.huawei.openalliance.ad.feedback.a();
        aVar.Code(view);
        aVar.V(this.v);
        aVar.Code(new a(this));
        dk.Code(this.D);
        FeedbackActivity.Code(getContext(), aVar);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = new kh() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // com.huawei.hms.ads.kh
            public void Code(Bundle bundle) {
                if (PPSNativeView.this.y == null) {
                    fh.V("PPSNativeView", "nativeApi is null handleUrlResult failed");
                } else {
                    PPSNativeView.this.y.Code("handleUrlResult", bundle);
                }
            }
        };
        this.C = true;
        this.Code = new gp();
        this.l = false;
        this.m = x.ao + hashCode();
        this.n = false;
        this.t = CusWhyThisAdView.a.NONE;
        this.G = false;
        this.J = new HashMap();
        this.K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView pPSNativeView = PPSNativeView.this;
                pPSNativeView.Code(view, 7, true, pPSNativeView.D);
            }
        };
        Code(context);
    }

    private ll Code(l lVar) {
        if (lVar == null) {
            fh.I("PPSNativeView", "nativeAd is null, get dwnBtn fail");
            return null;
        }
        Map<String, ll> map = this.J;
        if (map == null || !map.containsKey(lVar.d())) {
            return null;
        }
        return this.J.get(lVar.d());
    }

    private void I(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.K);
            } else if (view != null) {
                view.setOnClickListener(this.K);
            }
        }
    }

    private HashMap<String, String> V(l lVar) {
        AppInfo appInfo;
        ll llVarCode = Code(lVar);
        if (!(llVarCode instanceof AppDownloadButton) || (appInfo = ((AppDownloadButton) llVarCode).getAppInfo()) == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put(be.aM, appInfo.l());
        map.put(be.aN, appInfo.m());
        return map;
    }

    public void B() {
        l();
        ez.Code(getContext()).V();
        if (!this.d) {
            Code(this.L);
            this.L = null;
            this.f6973a = null;
            Code(this.c);
            this.c = null;
        }
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.I();
        }
    }

    public boolean C() {
        fv fvVar = this.F;
        if (fvVar != null) {
            return fvVar.d();
        }
        return false;
    }

    @Override // com.huawei.hms.ads.lr
    public void D() {
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.Code(hx.CLICK);
        }
    }

    public void F() {
        fh.V("PPSNativeView", "onClose");
        V((List<String>) null);
    }

    public void S() {
        hb hbVar = this.Code;
        if (hbVar != null) {
            hbVar.I();
        }
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = new kh() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // com.huawei.hms.ads.kh
            public void Code(Bundle bundle) {
                if (PPSNativeView.this.y == null) {
                    fh.V("PPSNativeView", "nativeApi is null handleUrlResult failed");
                } else {
                    PPSNativeView.this.y.Code("handleUrlResult", bundle);
                }
            }
        };
        this.C = true;
        this.Code = new gp();
        this.l = false;
        this.m = x.ao + hashCode();
        this.n = false;
        this.t = CusWhyThisAdView.a.NONE;
        this.G = false;
        this.J = new HashMap();
        this.K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView pPSNativeView = PPSNativeView.this;
                pPSNativeView.Code(view, 7, true, pPSNativeView.D);
            }
        };
        Code(context);
    }

    public void Code(int i) {
        fh.Code("PPSNativeView", "changeChoiceViewPosition option = " + i);
        if (this.d) {
            fh.I("PPSNativeView", "china rom should not call this method");
            return;
        }
        if (this.L == null) {
            fh.Code("PPSNativeView", "choicesView is null, error");
            return;
        }
        if (g()) {
            this.A.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.L.getLayoutParams());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.hiad_10_dp);
        if (i != 0) {
            if (i == 2) {
                layoutParams.addRule(12);
            } else if (i == 3) {
                layoutParams.addRule(12);
            } else {
                if (i == 4) {
                    if (this.o) {
                        fh.Code("PPSNativeView", "ADCHOICES_INVISIBLE is called and not default feedback!");
                        Code(this.L, 8);
                        return;
                    }
                    this.L.setVisibility(0);
                    this.L.setLayoutParams(layoutParams);
                    this.L.bringToFront();
                }
                layoutParams.addRule(10);
            }
            layoutParams.addRule(21);
            layoutParams.setMargins(0, 0, dimensionPixelOffset, 0);
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.L.setVisibility(0);
            this.L.setLayoutParams(layoutParams);
            this.L.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, 0, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.L.setScaleX(-1.0f);
        this.f6973a.setScaleX(-1.0f);
        this.L.setVisibility(0);
        this.L.setLayoutParams(layoutParams);
        this.L.bringToFront();
    }

    @Override // com.huawei.hms.ads.fu
    public void V(long j, int i) {
        if (this.G) {
            return;
        }
        bj.Code(this.m);
        l lVar = this.D;
        if (lVar != null) {
            lVar.Z(false);
        }
        this.S.Code(j, i);
    }

    @SuppressLint({"NewApi"})
    public PPSNativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.B = new kh() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // com.huawei.hms.ads.kh
            public void Code(Bundle bundle) {
                if (PPSNativeView.this.y == null) {
                    fh.V("PPSNativeView", "nativeApi is null handleUrlResult failed");
                } else {
                    PPSNativeView.this.y.Code("handleUrlResult", bundle);
                }
            }
        };
        this.C = true;
        this.Code = new gp();
        this.l = false;
        this.m = x.ao + hashCode();
        this.n = false;
        this.t = CusWhyThisAdView.a.NONE;
        this.G = false;
        this.J = new HashMap();
        this.K = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView pPSNativeView = PPSNativeView.this;
                pPSNativeView.Code(view, 7, true, pPSNativeView.D);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f8 A[Catch: all -> 0x012f, TRY_LEAVE, TryCatch #0 {all -> 0x012f, blocks: (B:8:0x0099, B:11:0x00a0, B:13:0x00b2, B:15:0x00b6, B:17:0x00ba, B:18:0x00c5, B:24:0x00f2, B:26:0x00f8, B:19:0x00c9, B:21:0x00db, B:23:0x00df), top: B:32:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void V(Context context) {
        IRemoteCreator iRemoteCreator;
        IObjectWrapper iObjectWrapperWrap;
        fh.V("PPSNativeView", "showV3Ad");
        IRemoteCreator iRemoteCreatorCode = com.huawei.hms.ads.h.Code(getContext().getApplicationContext());
        this.x = iRemoteCreatorCode;
        if (iRemoteCreatorCode == null) {
            fh.V("PPSNativeView", "Creator is null");
            return;
        }
        this.y = new ck(context, this, this.D);
        String strV = ad.V(this.D.q());
        fh.Code("PPSNativeView", "showV3Ad contentJson: %s", strV);
        Bundle bundle = new Bundle();
        bundle.putBinder("context", (IBinder) ObjectWrapper.wrap(getContext()));
        bundle.putString("content", strV);
        bundle.putInt("sdkVersion", com.huawei.hms.ads.base.a.B);
        boolean zF = bg.f(getContext().getApplicationContext());
        bundle.putBoolean(bq.f.p, com.huawei.openalliance.ad.utils.c.Code(getContext(), this.D.aD(), this.D.r(), this.D.s()));
        if (fh.Code()) {
            fh.Code("PPSNativeView", "emui9 dark %s", Boolean.valueOf(zF));
        }
        bundle.putBoolean(bq.f.t, zF);
        try {
            if (this.G) {
                View view = (View) ObjectWrapper.unwrap(this.x.newNativeTemplateView(bundle, this.y));
                this.z = view;
                if (view == null) {
                    fh.I("PPSNativeView", "templateView is null");
                    return;
                }
                MultiAdsTemplateView multiAdsTemplateView = this.H;
                if (multiAdsTemplateView != null) {
                    multiAdsTemplateView.Code(view);
                    iRemoteCreator = this.x;
                    iObjectWrapperWrap = ObjectWrapper.wrap(this.z);
                }
                if (f()) {
                    return;
                }
                ei.Code(getContext().getApplicationContext()).Code(this.D.r(), System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slotid", this.D.r());
                com.huawei.openalliance.ad.ipc.g.V(context).Code(s.J, jSONObject.toString(), null, null);
                return;
            }
            View view2 = (View) ObjectWrapper.unwrap(this.x.newNativeTemplateView(bundle, this.y));
            this.z = view2;
            if (view2 == null) {
                fh.I("PPSNativeView", "templateView is null");
                return;
            }
            this.Code = null;
            removeAllViews();
            addView(this.z);
            iRemoteCreator = this.x;
            iObjectWrapperWrap = ObjectWrapper.wrap(this.z);
            iRemoteCreator.bindData(iObjectWrapperWrap, strV);
            if (f()) {
            }
        } catch (Throwable th) {
            fh.I("PPSNativeView", "create newNativeTemplateView err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.fu
    public void Code(long j, int i) {
        if (this.G) {
            return;
        }
        bj.Code(this.m);
        if (!this.F.Code(j) || this.l) {
            return;
        }
        this.l = true;
        Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null, false);
    }

    private void Code(Context context) {
        this.S = new Cif(context, this);
        this.F = new fv(this, this);
        boolean zV = cn.Code(context).V();
        this.d = zV;
        if (!zV) {
            c();
        }
        is<lr> isVar = this.S;
        if (isVar != null) {
            isVar.Code(this.B);
        }
    }

    private void V(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.bringToFront();
    }

    private void Code(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void V(ll llVar) {
        if (llVar != null) {
            llVar.setPpsNativeView(null);
            llVar.Code((com.huawei.openalliance.ad.inter.data.g) null);
        }
    }

    private void Code(View view, int i) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                viewGroup.getChildAt(i2).setVisibility(i);
            }
        }
    }

    private void V(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.D = (l) gVar;
        i();
        if (!e()) {
            this.q = gVar.m();
            this.r = gVar.n();
            d();
        }
        this.F.V(this.D.x(), this.D.y());
        this.S.Code(this.D);
        this.S.V();
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
        n();
        p();
        AdContentData adContentDataQ = gVar.q();
        this.E = adContentDataQ;
        super.setAdData(adContentDataQ);
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // java.lang.Runnable
            public void run() {
                PPSNativeView pPSNativeView = PPSNativeView.this;
                if (pPSNativeView.V) {
                    pPSNativeView.b();
                }
            }
        }, 100L);
    }

    public void Code(View view, int i, String str) {
        hb hbVar;
        if (this.C) {
            this.C = false;
            fh.V("PPSNativeView", "onClick");
            if (this.G) {
                this.S.Code(this.D);
            }
            this.n = true;
            b bVar = this.e;
            if (bVar != null) {
                bVar.Code(view);
            }
            ez.Code(getContext()).Code();
            Code((Integer) 1, true);
            t.V();
            if (this.S.Code(this.s, Integer.valueOf(i), getAdTag(), str, V(this.D)) && (hbVar = this.Code) != null) {
                hbVar.Code(hx.CLICK);
            }
            this.s = null;
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.3
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.C = true;
                }
            }, 500L);
        }
    }

    public void V(List<String> list) {
        fh.V("PPSNativeView", "onClose keyWords");
        this.S.V(list);
        q();
    }

    public void Code(View view, int i, boolean z, l lVar) {
        l lVar2;
        if (this.C) {
            this.C = false;
            fh.V("PPSNativeView", "onClick");
            if (this.G) {
                this.S.Code(lVar);
            }
            this.n = true;
            if (this.e != null) {
                fh.V("PPSNativeView", "listener.onClick");
                this.e.Code(view);
            }
            ez.Code(getContext()).Code();
            Code((Integer) 1, true);
            t.V();
            HashMap<String, String> mapV = V(lVar);
            ll llVarCode = Code(lVar);
            if (this.S.Code(this.s, Integer.valueOf(i), getAdTag(), z, mapV)) {
                hb hbVar = this.Code;
                if (hbVar != null) {
                    hbVar.Code(hx.CLICK);
                }
            } else if (llVarCode instanceof AppDownloadButton) {
                AppDownloadButton appDownloadButton = (AppDownloadButton) llVarCode;
                if (AppStatus.DOWNLOAD == appDownloadButton.getStatus() && (lVar2 = this.D) != null && lVar2.b() && jg.I(this.D.K())) {
                    fh.V("PPSNativeView", "download app directly");
                    appDownloadButton.performClick();
                }
            }
            this.s = null;
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.C = true;
                }
            }, 500L);
        }
    }

    private void Code(hb hbVar, l lVar) {
        lm lmVar = this.i;
        if (lmVar instanceof NativeVideoView) {
            ((NativeVideoView) lmVar).Code(hbVar, lVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        hb hbVar;
        if (dVar instanceof l) {
            l lVar = (l) dVar;
            AdContentData adContentDataQ = lVar.q();
            if (adContentDataQ.aF() == 3 || (hbVar = this.Code) == null) {
                return;
            }
            hbVar.Code(getContext(), adContentDataQ, this, true);
            this.Code.Code(false);
            this.Code.Z();
            hm hmVarV = this.Code.V();
            this.u = hmVarV;
            if (hmVarV != null) {
                ChoicesView choicesView = this.f6973a;
                hl hlVar = hl.OTHER;
                hmVarV.Code(choicesView, hlVar, null);
                this.u.Code(this.c, hlVar, null);
                this.u.Code(this.L, hlVar, null);
            }
            Code(this.Code, lVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.C = true;
        if (gVar == null) {
            return;
        }
        fh.Code("PPSNativeView", "register nativeAd");
        V(gVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list) {
        this.C = true;
        if (gVar == null) {
            return;
        }
        fh.Code("PPSNativeView", "register nativeAd");
        this.D = (l) gVar;
        i();
        if (!e()) {
            this.q = gVar.m();
            this.r = gVar.n();
            d();
        }
        this.F.V(this.D.x(), this.D.y());
        this.S.Code(this.D);
        this.S.V();
        n();
        this.k = list;
        I(list);
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, lm lmVar) {
        this.i = lmVar;
        Code(gVar);
        if (lmVar != null) {
            lmVar.setPpsNativeView(this);
            lmVar.setNativeAd(gVar);
            setNativeVideoViewClickable(lmVar);
        }
        this.k = list;
        I(list);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, ln lnVar) {
        Code(gVar);
        this.j = lnVar;
        if (lnVar != null) {
            lnVar.setNativeAd(gVar);
            setWindowImageViewClickable(this.j);
        }
        this.k = list;
        I(list);
    }

    @Override // com.huawei.hms.ads.lr
    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.F.Z()), Integer.valueOf(this.F.I()), num, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements AdFeedbackListener {
        private final WeakReference<PPSNativeView> Code;

        public a(PPSNativeView pPSNativeView) {
            this.Code = new WeakReference<>(pPSNativeView);
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            PPSNativeView pPSNativeView = this.Code.get();
            if (pPSNativeView != null) {
                pPSNativeView.s();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        l lVar = this.D;
        if (lVar == null) {
            return;
        }
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(lVar.h_(), num2);
        if (!this.D.ak() || (zCode && !this.D.ab())) {
            if (this.G) {
                this.S.Code(this.D);
            }
            this.S.Code(l, num, num2, z, getAdTag());
            if (zCode) {
                this.D.C(true);
            }
            if (this.D.ak()) {
                return;
            }
            this.D.I(true);
            e eVar = this.g;
            if (eVar != null) {
                eVar.B();
            }
            hb hbVar = this.Code;
            if (hbVar != null) {
                hbVar.D();
            }
            c cVar = this.h;
            if (cVar != null) {
                cVar.Code();
            }
        }
    }

    public boolean Code() {
        if (this.o || this.c == null) {
            return false;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.SHOWN);
        h();
        this.c.V();
        o();
        this.C = false;
        return true;
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }

    public boolean Code(ll llVar) {
        boolean zCode;
        if (this.D == null) {
            throw new IllegalStateException("Register INativeAd first");
        }
        if (llVar != null) {
            llVar.setPpsNativeView(this);
            zCode = llVar.Code(this.D);
            m();
            llVar.setHandleUrlCallBack(this.B);
        } else {
            zCode = false;
        }
        Map<String, ll> map = this.J;
        if (map != null && !map.containsKey(this.D.d()) && !bc.Code(this.D.d())) {
            this.J.put(this.D.d(), llVar);
        }
        if (fh.Code()) {
            fh.Code("PPSNativeView", "register downloadbutton, succ:" + zCode);
        }
        return zCode;
    }

    private boolean Code(Integer num, int i) {
        return (num != null && 3 == num.intValue()) || 99 == i;
    }
}

package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.banner.R;
import com.huawei.hms.ads.cm;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.gc;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.hm;
import com.huawei.hms.ads.ib;
import com.huawei.hms.ads.ir;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.lo;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bp;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.o;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bm;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSBannerView extends PPSSafeRelativeLayout implements gl, lo, PPSLabelView.a {
    private eh A;
    private String E;
    private ImageView G;
    private final byte[] H;
    private boolean J;
    private String K;
    private TextView M;
    private int O;
    private b P;
    private c Q;
    private a R;
    private int T;
    private List<String> U;
    Handler V;
    private String W;
    private String aa;
    private RequestOptions ab;
    private Location ac;
    private r ad;
    private Integer ae;
    private float af;
    private RewardVerifyConfig ag;
    private fy ah;
    private ir d;
    private long e;
    private long f;
    private String g;
    private com.huawei.openalliance.ad.inter.listeners.d h;
    private o i;
    private com.huawei.openalliance.ad.inter.data.b j;
    private PPSNativeView k;
    private PPSNativeView l;
    private ImageView m;
    private ImageView n;
    private ChoicesView o;
    private CusWhyThisAdView p;
    private ImageView q;
    private boolean r;
    private LinearLayout s;
    private PPSLabelSourceView t;
    private PPSLabelView u;
    private TextView v;
    private AutoScaleSizeRelativeLayout w;
    private com.huawei.openalliance.ad.inter.data.g x;
    private com.huawei.openalliance.ad.inter.data.g y;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        STARTED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements AppDownloadListener {
        private TextView Code;
        private final WeakReference<PPSBannerView> I;
        private TextView V;

        public b(PPSBannerView pPSBannerView) {
            this.I = new WeakReference<>(pPSBannerView);
            if (pPSBannerView != null) {
                this.Code = pPSBannerView.M;
                this.V = pPSBannerView.v;
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppStatus appStatus, AppInfo appInfo) {
            final PPSBannerView pPSBannerView = this.I.get();
            if (appInfo == null || TextUtils.isEmpty(appInfo.Code()) || pPSBannerView == null || appStatus != AppStatus.INSTALLED || this.Code == null || this.V == null) {
                return;
            }
            final String jumpText = pPSBannerView.getJumpText();
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.b.1
                @Override // java.lang.Runnable
                public void run() {
                    pPSBannerView.Code(jumpText);
                }
            });
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppInfo appInfo, int i) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void V(AppInfo appInfo) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        IDLE,
        LOADING
    }

    public PPSBannerView(Context context) {
        super(context);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.Q = c.IDLE;
        this.R = a.STARTED;
        this.T = 0;
        this.af = 0.05f;
        this.ah = new fy(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                fh.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i) {
                fh.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.f();
                PPSBannerView.this.k();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(context);
    }

    private long Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = gVar.j();
            j = jCurrentTimeMillis < j ? j - jCurrentTimeMillis : 0L;
            fh.Code("PPSBannerView", "calcAdLeftTime,currentTime:" + jCurrentTimeMillis + ",expireTime:" + j + ",leftTime:" + j);
        }
        return j;
    }

    private void F() {
        if (this.G == null) {
            return;
        }
        fh.V("PPSBannerView", "init compliance activity");
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.x == null || !(PPSBannerView.this.x instanceof l)) {
                    return;
                }
                ComplianceActivity.Code(PPSBannerView.this.getContext(), view, ((l) PPSBannerView.this.x).q(), false);
            }
        });
    }

    private long V(long j) {
        eh ehVar;
        if (0 == j || (ehVar = this.A) == null) {
            return 0L;
        }
        long jP = ehVar.p();
        long jR = this.A.r();
        if (fh.Code()) {
            fh.Code("PPSBannerView", "setBannerRefresh,minInterval:%s,maxInterval:%s", Long.valueOf(jP), Long.valueOf(jR));
        }
        if (jP > jR) {
            return 0L;
        }
        return j < jP ? jP : Math.min(j, jR);
    }

    private void c() {
        TextView textView;
        int i;
        String str = this.E;
        if (str == null || str.isEmpty()) {
            textView = this.v;
            i = 8;
        } else {
            this.v.setText(this.E);
            textView = this.v;
            i = 0;
        }
        textView.setVisibility(i);
    }

    private c getAdLoadState() {
        c cVar;
        synchronized (this.H) {
            cVar = this.Q;
        }
        return cVar;
    }

    private int getBannerVisibility() {
        int i;
        synchronized (this.H) {
            i = this.T;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getJumpText() {
        int iJ;
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        if (gVar == null || (iJ = gVar.q().j()) == 0 || iJ == 1) {
            return null;
        }
        if (iJ == 9) {
            PPSAbilityDataContent pPSAbilityDataContent = (PPSAbilityDataContent) ad.V(this.x.q().aG(), PPSAbilityDataContent.class, new Class[0]);
            return V(pPSAbilityDataContent != null ? pPSAbilityDataContent.V() : null);
        }
        PromoteInfo promoteInfoZ = this.x.q().z();
        if (iJ == 10) {
            return Code(promoteInfoZ);
        }
        if (iJ == 11) {
            return d();
        }
        if (iJ == 8) {
            return com.huawei.openalliance.ad.utils.c.Code(getContext(), 8);
        }
        if (promoteInfoZ != null && promoteInfoZ.getType() == 1) {
            String name = promoteInfoZ.getName();
            return !TextUtils.isEmpty(name) ? getResources().getString(R.string.hiad_click_open_to, name) : getResources().getString(R.string.hiad_click_to_open_quick_app);
        }
        AppInfo appInfoY = this.x.q().y();
        if (appInfoY == null) {
            return getResources().getString(R.string.hiad_click_to_learn_more);
        }
        if (com.huawei.openalliance.ad.utils.h.Code(getContext(), appInfoY.Code())) {
            return (TextUtils.isEmpty(appInfoY.L()) || !com.huawei.openalliance.ad.utils.h.Code(getContext(), appInfoY.Code())) ? getResources().getString(R.string.hiad_click_to_learn_more) : getResources().getString(R.string.hiad_click_open_to, appInfoY.L());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1001)) {
            return;
        }
        fh.Code("PPSBannerView", "stopCloseAdWhenExpire");
        this.V.removeMessages(1001);
    }

    private void setAdLoadState(c cVar) {
        synchronized (this.H) {
            this.Q = cVar;
        }
    }

    private void setAdViewParam(Context context) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.w;
        if (autoScaleSizeRelativeLayout == null || this.j == null || context == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autoScaleSizeRelativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.w.setLayoutParams(layoutParams);
        this.w.setRatio(Float.valueOf((this.j.Code() * 1.0f) / this.j.V()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerVisibility(int i) {
        synchronized (this.H) {
            this.T = i;
        }
    }

    private void setChildrenViewsInVisible(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setVisibility(4);
            }
        }
    }

    private void setChoiceViewPosition(int i) {
        fh.Code("PPSBannerView", "bannerView option = %s", Integer.valueOf(i));
        if (this.o == null) {
            fh.Code("PPSBannerView", "choicesView is null, error");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.o.getLayoutParams());
        Resources resources = getResources();
        int i2 = R.dimen.hiad_banner_choice_custom_margin;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i2);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(i2);
        if (i != 0) {
            if (i == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, dimensionPixelOffset2);
            } else if (i == 3) {
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                layoutParams.setMargins(dimensionPixelOffset, 0, 0, dimensionPixelOffset2);
            } else if (i == 4) {
                this.o.setVisibility(8);
                this.o.setLayoutParams(layoutParams);
                this.o.bringToFront();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, dimensionPixelOffset2, dimensionPixelOffset, 0);
            }
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.o.setLayoutParams(layoutParams);
            this.o.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset2, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.o.setLayoutParams(layoutParams);
        this.o.bringToFront();
    }

    public boolean C() {
        return getAdLoadState() == c.LOADING;
    }

    public void I() {
        if (getBannerState() == a.DESTROYED) {
            fh.V("PPSBannerView", "hasDestroyed");
            return;
        }
        fh.V("PPSBannerView", "pause");
        setBannerState(a.PAUSED);
        f();
    }

    public void Z() {
        if (getBannerState() == a.DESTROYED) {
            fh.V("PPSBannerView", "hasDestroyed");
            return;
        }
        fh.V("PPSBannerView", az.ag);
        setBannerState(a.RESUMED);
        e();
    }

    public String getAdId() {
        return this.g;
    }

    public long getBannerRefresh() {
        return this.e;
    }

    public com.huawei.openalliance.ad.inter.data.b getBannerSize() {
        return this.j;
    }

    public a getBannerState() {
        a aVar;
        synchronized (this.H) {
            aVar = this.R;
        }
        return aVar;
    }

    @Deprecated
    public BiddingInfo getBiddingInfo() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        return (gVar == null || gVar.ah() == null) ? new BiddingInfo() : this.x.ah();
    }

    public Integer getIsSmart() {
        return this.ae;
    }

    public Location getLocation() {
        return this.ac;
    }

    public RequestOptions getRequestOptions() {
        return this.ab;
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout
    public String getTAG() {
        return "PPSBannerView";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fy fyVar = this.ah;
        if (fyVar != null) {
            fyVar.D();
        }
        jf.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fy fyVar = this.ah;
        if (fyVar != null) {
            fyVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fy fyVar = this.ah;
        if (fyVar != null) {
            fyVar.a();
        }
        String jumpText = getJumpText();
        if (this.M != null) {
            if (!this.r || TextUtils.isEmpty(jumpText)) {
                this.M.setVisibility(8);
                c();
            }
        }
    }

    public void setAdContainerSizeMatched(boolean z) {
        this.J = z;
    }

    public void setAdId(String str) {
        this.g = str;
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.d dVar) {
        this.h = dVar;
    }

    public void setBannerRefresh(long j) {
        long jV = V(j);
        this.e = jV;
        fh.V("PPSBannerView", "setBannerRefresh:%s", Long.valueOf(jV));
    }

    public void setBannerSize(com.huawei.openalliance.ad.inter.data.b bVar) {
        this.j = bVar;
        setAdViewParam(getContext());
    }

    public void setBannerState(a aVar) {
        synchronized (this.H) {
            this.R = aVar;
        }
    }

    public void setContentBundle(String str) {
        this.K = str;
    }

    public void setIsSmart(Integer num) {
        this.ae = num;
    }

    public void setLocation(Location location) {
        this.ac = location;
    }

    public void setOnBannerAdStatusTrackingListener(o oVar) {
        this.i = oVar;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.ab = requestOptions;
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.ag = rewardVerifyConfig;
    }

    public void setTargetingInfo(r rVar) {
        this.ad = rVar;
    }

    public PPSBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.Q = c.IDLE;
        this.R = a.STARTED;
        this.T = 0;
        this.af = 0.05f;
        this.ah = new fy(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                fh.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i) {
                fh.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.f();
                PPSBannerView.this.k();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private String Code(PromoteInfo promoteInfo) {
        return (promoteInfo == null || promoteInfo.getType() != 2 || TextUtils.isEmpty(promoteInfo.getName())) ? getResources().getString(R.string.hiad_click_to_open_wechat_mini_spec) : getResources().getString(R.string.hiad_click_open_to, promoteInfo.getName());
    }

    private void D() {
        fh.Code("PPSBannerView", "initChoicesView start");
        if (this.o == null) {
            ChoicesView choicesView = new ChoicesView(getContext());
            this.o = choicesView;
            choicesView.setId(R.id.hiad_choice_view);
            this.w.addView(this.o);
        }
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.p != null) {
                    PPSBannerView.this.L();
                    PPSBannerView.this.p.V();
                } else if (PPSBannerView.this.x instanceof l) {
                    z.Code(PPSBannerView.this.getContext(), ((l) PPSBannerView.this.x).q());
                }
                PPSBannerView.this.o.setVisibility(8);
            }
        });
        if (com.huawei.openalliance.ad.inter.data.b.Code == getBannerSize()) {
            this.o.V();
            this.o.Code(R.dimen.hiad_banner_choice_view_size);
        }
    }

    private void I(long j) {
        Handler handler = this.V;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.V.removeMessages(1000);
        }
        if (getBannerVisibility() == 4 || getBannerState() == a.PAUSED || getBannerState() == a.DESTROYED) {
            fh.V("PPSBannerView", "stopRefreshAd");
        } else if (0 != j) {
            fh.V("PPSBannerView", "start refreshAd ad will be refreshed in %s", Long.valueOf(j));
            this.V.sendEmptyMessageDelayed(1000, j * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        CusWhyThisAdView cusWhyThisAdView = this.p;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                setChildrenViewsInVisible(viewGroup);
            }
            this.p.setVisibility(0);
        }
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.w;
        if (autoScaleSizeRelativeLayout != null) {
            autoScaleSizeRelativeLayout.setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private String V(String str) {
        return !TextUtils.isEmpty(str) ? getResources().getString(R.string.hiad_click_open_to, str) : getResources().getString(R.string.hiad_click_to_open_harmony_service);
    }

    private void a() {
        if (this.p != null) {
            fh.Code("PPSBannerView", "SDK-banner cusWhyView is not null");
            return;
        }
        CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this.w);
        this.p = cusWhyThisAdView;
        cusWhyThisAdView.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.9
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSBannerView.this.x == null) {
                    return null;
                }
                return PPSBannerView.this.x.L();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSBannerView.this.x instanceof l) {
                    z.Code(PPSBannerView.this.getContext(), ((l) PPSBannerView.this.x).q());
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSBannerView pPSBannerView = PPSBannerView.this;
                pPSBannerView.Code(0, pPSBannerView.x, arrayList);
                PPSBannerView pPSBannerView2 = PPSBannerView.this;
                pPSBannerView2.Code(pPSBannerView2.g(), 2, 0);
            }
        });
        this.w.addView(this.p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.p.getLayoutParams());
        layoutParams.addRule(13);
        this.p.setLayoutParams(layoutParams);
    }

    private String d() {
        return getResources().getString(R.string.hiad_click_open_to, getResources().getString(R.string.hiad_share_wx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j = this.e;
        if (j == 0) {
            j = this.f;
        }
        I(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1000)) {
            return;
        }
        fh.V("PPSBannerView", "stopRefreshAd");
        this.V.removeMessages(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.e > 0 || this.f > 0;
    }

    private void h() {
        fh.V("PPSBannerView", "hide activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bp.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    private void i() {
        fh.V("PPSBannerView", "hide dsa activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), com.huawei.openalliance.ad.utils.h.I(getContext()), bp.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.V == null || this.x == null || g()) {
            return;
        }
        if (this.V.hasMessages(1001)) {
            this.V.removeMessages(1001);
        }
        fh.Code("PPSBannerView", "start closeAdWhenExpire");
        this.V.sendEmptyMessageDelayed(1001, Code(this.x));
    }

    @Override // com.huawei.hms.ads.lo
    public void B() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        db.Code(getContext(), gVar instanceof l ? ((l) gVar).j_() : "", this.g, 8, ai.y, "Fail to display ad because of missing presentation material");
    }

    public void S() {
        PPSNativeView pPSNativeView = this.k;
        if (pPSNativeView != null) {
            pPSNativeView.S();
        }
        PPSNativeView pPSNativeView2 = this.l;
        if (pPSNativeView2 != null) {
            pPSNativeView2.S();
        }
    }

    public PPSBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.Q = c.IDLE;
        this.R = a.STARTED;
        this.T = 0;
        this.af = 0.05f;
        this.ah = new fy(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                fh.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i2) {
                fh.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.f();
                PPSBannerView.this.k();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i2 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private void I(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        fh.Code("PPSBannerView", "reportAdCancelled");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.V, gVar, 0L);
    }

    public void Code() {
        if (!this.d.S()) {
            Code(g(), 1, 1001);
            return;
        }
        if (getAdLoadState() != c.IDLE) {
            fh.I("PPSBannerView", "ad is loading now!");
            Code(g(), 1, 701);
            return;
        }
        setAdLoadState(c.LOADING);
        ArrayList arrayList = new ArrayList();
        String str = this.W;
        if (str == null || str.isEmpty()) {
            arrayList = null;
        } else {
            arrayList.add(this.W);
        }
        this.d.Code(this.ac);
        this.d.Code(this.ab);
        this.d.Code(this.ad);
        this.d.Code(this.ae);
        this.d.V(Integer.valueOf(this.j.Code()));
        this.d.I(Integer.valueOf(this.j.V()));
        this.d.V(this.K);
        this.d.Code(this.g, 8, arrayList, this.e == 0 ? 0 : 1);
        e();
    }

    public void V() {
        fh.V("PPSBannerView", "destroy");
        setBannerState(a.DESTROYED);
        f();
        k();
        i();
        com.huawei.openalliance.ad.download.a.Code().I(this.P);
        this.V = null;
    }

    private void V(Context context) {
        View.inflate(context, R.layout.hiad_view_banner_ad, this);
        this.k = (PPSNativeView) findViewById(R.id.hiad_banner_layout_1);
        this.l = (PPSNativeView) findViewById(R.id.hiad_banner_layout_2);
        this.m = (ImageView) findViewById(R.id.hiad_banner_image_1);
        this.n = (ImageView) findViewById(R.id.hiad_banner_image_2);
        this.t = (PPSLabelSourceView) findViewById(R.id.custom_ad_bg_layout);
        this.s = (LinearLayout) findViewById(R.id.custom_ad_bg_layout_container);
        this.G = (ImageView) findViewById(R.id.compliance_icon_banner);
        this.w = (AutoScaleSizeRelativeLayout) findViewById(R.id.hiad_banner_ad);
        setAdViewParam(context);
        this.w.setVisibility(8);
        boolean zV = cn.Code(context).V();
        this.r = zV;
        fh.Code("PPSBannerView", "isChinaRom = %s", Boolean.valueOf(zV));
        if (this.r) {
            ImageView imageView = (ImageView) findViewById(R.id.hiad_banner_close_button);
            this.q = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(0, pPSBannerView.x, (List<String>) null);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.Code(pPSBannerView2.g(), 2, 0);
                }
            });
        } else {
            a();
            D();
            F();
        }
        Code(this.k);
        Code(this.l);
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i) {
        fh.Code("PPSBannerView", "onReqAdFail ");
        if (Code(this.W, this.U)) {
            Code(2, this.x, (List<String>) null);
            Code(false, 1, 705);
        } else {
            Code(g(), 1, i);
        }
        setAdLoadState(c.IDLE);
    }

    private void Code(int i, int i2) {
        com.huawei.openalliance.ad.inter.listeners.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        if (i == 0) {
            dVar.D();
        } else if (i == 1) {
            dVar.Code(i2);
        } else {
            if (i != 2) {
                return;
            }
            dVar.c();
        }
    }

    private void I(PPSNativeView pPSNativeView) {
        if (this.i == null) {
            return;
        }
        pPSNativeView.setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                PPSBannerView.this.i.L();
            }
        });
        pPSNativeView.setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                PPSBannerView.this.i.d();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                PPSBannerView.this.i.b();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                PPSBannerView.this.i.a();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                PPSBannerView.this.i.c();
            }
        });
    }

    private void V(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        fh.Code("PPSBannerView", "reportAdExpire");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.Code, gVar, gVar.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        r4.V(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Code(int i, com.huawei.openalliance.ad.inter.data.g gVar, List<String> list) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.w;
        if (autoScaleSizeRelativeLayout != null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        I(gVar);
                    }
                } else if (autoScaleSizeRelativeLayout.getVisibility() == 0) {
                    V(gVar);
                }
            } else if ((this.z - 1) % 2 == 0) {
            }
            PPSNativeView pPSNativeView = this.k;
            if (pPSNativeView != null) {
                pPSNativeView.setVisibility(8);
            }
            PPSNativeView pPSNativeView2 = this.l;
            if (pPSNativeView2 != null) {
                pPSNativeView2.setVisibility(8);
            }
            this.w.setVisibility(8);
            fy fyVar = this.ah;
            if (fyVar != null) {
                fyVar.onGlobalLayout();
            }
            S();
        }
    }

    private void V(PPSNativeView pPSNativeView) {
        hm adSessionAgent = pPSNativeView.getAdSessionAgent();
        if (adSessionAgent != null) {
            adSessionAgent.Code(this.q, hl.CLOSE_AD, null);
            PPSLabelView pPSLabelView = this.u;
            hl hlVar = hl.OTHER;
            adSessionAgent.Code(pPSLabelView, hlVar, null);
            adSessionAgent.Code(this.v, hlVar, null);
            adSessionAgent.Code(this.o, hlVar, null);
            adSessionAgent.Code(this.p, hlVar, null);
        }
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(long j) {
        this.f = V(j);
        e();
    }

    private void Code(Context context) {
        this.d = new ib(context, this);
        eh ehVarCode = eh.Code(context);
        this.A = ehVarCode;
        this.af = ehVarCode.u();
        this.O = z.V(getContext(), getResources().getDimension(R.dimen.hiad_2_dp));
        V(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Code(Drawable drawable) {
        ImageView imageView;
        int i;
        PPSNativeView pPSNativeView;
        com.huawei.openalliance.ad.inter.data.g gVar;
        com.huawei.openalliance.ad.inter.data.g gVar2;
        fh.Code("PPSBannerView", "show Ad");
        com.huawei.openalliance.ad.inter.data.g gVar3 = this.x;
        if (gVar3 instanceof l) {
            RewardVerifyConfig rewardVerifyConfig = this.ag;
            if (rewardVerifyConfig != null) {
                gVar3.Code(rewardVerifyConfig);
            }
            this.d.Code((l) this.x);
            l lVar = (l) this.x;
            boolean zCode = z.Code(this.r, lVar.ad(), lVar.ac());
            this.t.Code(getContext(), zCode);
            this.t.Code(this, this, lVar.q(), zCode);
            this.u = this.t.getAdLabel();
            this.v = this.t.getAdSource();
            this.M = this.t.getAdJumpText();
            this.u.setDataAndRefreshUi(lVar.q());
            if (zCode) {
                this.M.setBackground(getResources().getDrawable(R.drawable.hiad_bg_ad_source));
                TextView textView = this.M;
                int i2 = this.O;
                textView.setPadding(i2, 0, i2, 0);
            }
            this.M.setTextColor(getResources().getColor(R.color.hiad_ad_source_color));
            this.M.setTextSize(1, 10.0f);
            Code(getJumpText());
            this.u.setText(getResources().getString(R.string.hiad_ad_label_new));
            this.u.Code(lVar.R(), lVar.T(), lVar.U());
        }
        this.w.setVisibility(0);
        com.huawei.openalliance.ad.inter.data.g gVar4 = this.x;
        if (gVar4 == null || TextUtils.equals(gVar4.e(), "1")) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
        }
        this.v.setText(this.E);
        if (!this.r) {
            CusWhyThisAdView cusWhyThisAdView = this.p;
            if (cusWhyThisAdView != null) {
                cusWhyThisAdView.Code();
            }
            ChoicesView choicesView = this.o;
            if (choicesView != null) {
                choicesView.setVisibility(0);
                setChoiceViewPosition(1);
            }
            if (this.G != null && (gVar2 = this.x) != null && !ag.Code(gVar2.q().aL())) {
                imageView = this.G;
            }
            i = this.z;
            this.z = i + 1;
            if (i % 2 != 0) {
                this.n.setBackground(null);
                this.n.setImageDrawable(null);
                this.l.setVisibility(8);
                this.d.Code(getContext(), this.m, drawable);
                this.m.setImageDrawable(drawable);
                Code(drawable, this.m);
                if (!this.r) {
                    this.k.setIsCustomDislikeThisAdEnabled(true);
                    this.k.setChoiceViewPosition(4);
                }
                S();
                this.k.Code(this.x);
                I(this.k);
                V(this.k);
                pPSNativeView = this.k;
            } else {
                this.m.setBackground(null);
                this.m.setImageDrawable(null);
                this.k.setVisibility(8);
                this.d.Code(getContext(), this.n, drawable);
                this.n.setImageDrawable(drawable);
                Code(drawable, this.n);
                if (!this.r) {
                    this.l.setIsCustomDislikeThisAdEnabled(true);
                    this.l.setChoiceViewPosition(4);
                }
                S();
                this.l.Code(this.x);
                I(this.l);
                V(this.l);
                pPSNativeView = this.l;
            }
            pPSNativeView.setVisibility(0);
            bm.Code(this.t);
            bm.Code(this.s);
            this.w.requestLayout();
            super.setAdData(this.x.q());
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.10
                @Override // java.lang.Runnable
                public void run() {
                    PPSBannerView.this.b();
                }
            }, 100L);
            gVar = this.x;
            if (gVar != null || gVar.E() == null) {
            }
            this.P = new b(this);
            com.huawei.openalliance.ad.download.a.Code().V(this.P);
            return;
        }
        imageView = this.q;
        imageView.setVisibility(0);
        i = this.z;
        this.z = i + 1;
        if (i % 2 != 0) {
        }
        pPSNativeView.setVisibility(0);
        bm.Code(this.t);
        bm.Code(this.s);
        this.w.requestLayout();
        super.setAdData(this.x.q());
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.10
            @Override // java.lang.Runnable
            public void run() {
                PPSBannerView.this.b();
            }
        }, 100L);
        gVar = this.x;
        if (gVar != null) {
        }
    }

    private void Code(Drawable drawable, final ImageView imageView) {
        if (drawable instanceof dw) {
            ((dw) drawable).Code(new dy() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.11
                @Override // com.huawei.hms.ads.dy
                public void Code() {
                    imageView.requestLayout();
                }

                @Override // com.huawei.hms.ads.dy
                public void I() {
                }

                @Override // com.huawei.hms.ads.dy
                public void V() {
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(Drawable drawable, com.huawei.openalliance.ad.inter.data.g gVar) {
        if (drawable == null || gVar == null) {
            Code(g(), 1, ai.y);
            fh.I("PPSBannerView", "onAdContentLoaded,content is null");
        } else {
            this.x = gVar;
            this.E = gVar.h();
            this.W = gVar.d();
            if (0 == Code(gVar)) {
                V(gVar);
                fh.Code("PPSBannerView", "do not show ad due to ad expired");
                Code(false, 1, 704);
                if (Code(this.aa, this.U)) {
                    Code(2, this.y, (List<String>) null);
                }
            } else if (Code(this.W, this.U)) {
                fh.Code("PPSBannerView", "do not show ad due to ad cancelled");
                I(gVar);
                Code(false, 1, 705);
            } else {
                h();
                i();
                Code(drawable);
                Code(g(), 0, 0);
                j();
            }
            this.aa = this.W;
            this.y = gVar;
        }
        setAdLoadState(c.IDLE);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        com.huawei.openalliance.ad.inter.data.b bVar;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PPSBannerView);
        try {
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    String string = typedArrayObtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_adId);
                    if (string != null && !string.isEmpty()) {
                        this.g = string;
                    }
                    String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.equals("BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.Code;
                        } else if (string2.equals("LARGE_BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.V;
                        }
                        this.j = bVar;
                    }
                } catch (RuntimeException e) {
                    str = "initDefAttr " + e.getClass().getSimpleName();
                    fh.I("PPSBannerView", str);
                } catch (Throwable th) {
                    str = "initDefAttr " + th.getClass().getSimpleName();
                    fh.I("PPSBannerView", str);
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView.a
    public void Code(gc gcVar, int[] iArr, int[] iArr2) {
        fh.Code("PPSBannerView", "on label click");
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        if (gVar == null || !(gVar instanceof l)) {
            return;
        }
        cm.Code(getContext(), this.u, this.x.q());
    }

    private void Code(final PPSNativeView pPSNativeView) {
        pPSNativeView.setOnNativeAdImpressionListener(new PPSNativeView.c() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.6
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.c
            public void Code() {
                pPSNativeView.setAdContainerSizeMatched(PPSBannerView.this.ae == x.aU ? PPSBannerView.this.J : PPSBannerView.this.d.Code(PPSBannerView.this.j, PPSBannerView.this.af) ? "1" : "0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        if (!this.r || TextUtils.isEmpty(str)) {
            this.M.setVisibility(8);
            c();
        } else {
            this.M.setText(str);
            this.v.setVisibility(8);
            this.M.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(List<String> list) {
        this.U = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i, int i2) {
        fh.Code("PPSBannerView", "notifyResult isRefreshAd:%s,resultType:%s", Boolean.valueOf(z), Integer.valueOf(i));
        Code(i, i2);
        if (z) {
            return;
        }
        f();
    }

    private boolean Code(String str, List<String> list) {
        fh.Code("PPSBannerView", "invalidcontentIds is %s", list);
        fh.Code("PPSBannerView", "currentContentId is %s", str);
        return (TextUtils.isEmpty(str) || list == null || list.isEmpty() || !list.contains(str)) ? false : true;
    }
}

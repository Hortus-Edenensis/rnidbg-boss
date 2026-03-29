package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.fq;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.ie;
import com.huawei.hms.ads.iq;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.lt;
import com.huawei.hms.ads.lv;
import com.huawei.hms.ads.me;
import com.huawei.hms.ads.mg;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class SmartScreenSplashView extends RelativeLayout implements lt, me {
    private AdSlotParam B;
    private com.huawei.openalliance.ad.inter.listeners.b C;
    protected eh Code;
    private jc D;
    private com.huawei.openalliance.ad.inter.listeners.a F;
    private int I;
    private SloganView L;
    private ft S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6983a;
    private View b;
    private lv c;
    private TextView d;
    private PPSCircleProgressBar e;
    private PPSLabelView f;
    private TextView g;
    private int h;
    private RelativeLayout i;
    private RelativeLayout j;
    private long k;
    private int l;
    private final String m;
    private long n;
    private boolean o;
    private boolean p;
    private int q;
    private a r;
    private float s;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private WeakReference<lv> Code;

        public a(lv lvVar) {
            this.Code = new WeakReference<>(lvVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            lv lvVar;
            if (intent == null || !x.cm.equals(intent.getAction()) || (lvVar = this.Code.get()) == null || !(lvVar instanceof PPSVideoView)) {
                return;
            }
            ((PPSVideoView) lvVar).L();
        }
    }

    public SmartScreenSplashView(Context context) {
        super(context);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    private void F() {
        if (this.d == null || this.e == null) {
            return;
        }
        int i = this.l;
        if (i > 0) {
            fh.V("SmartScreenSplashView", "%d delay, skip btn show", Integer.valueOf(i));
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SmartScreenSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartScreenSplashView.this.d != null) {
                        fh.Code("SmartScreenSplashView", "skip hint show");
                        SmartScreenSplashView.this.d.setVisibility(0);
                    }
                    if (SmartScreenSplashView.this.e != null) {
                        fh.Code("SmartScreenSplashView", "coutDownView show");
                        SmartScreenSplashView.this.e.setVisibility(0);
                    }
                    SmartScreenSplashView.this.p = true;
                }
            }, this.m, this.l);
        } else {
            fh.V("SmartScreenSplashView", "direct show skip hint");
            this.p = true;
            this.d.setVisibility(0);
            this.e.setVisibility(0);
        }
    }

    private void setVisibleAndBringToFont(View view) {
        if (view != null) {
            view.setVisibility(0);
            view.bringToFront();
        }
    }

    @Override // com.huawei.hms.ads.lt
    public void B() {
        SloganView sloganView = this.L;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.f6983a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.hms.ads.lt
    public void I(int i) {
        fh.Code("SmartScreenSplashView", "update left time, total: %s, left: %s", Long.valueOf(this.n), Integer.valueOf(i));
        long j = this.n;
        int iDoubleValue = j > 0 ? (int) ((1.0d - am.Code(Double.valueOf(((double) ((i - 1) * 1000)) / j), 2, 4).doubleValue()) * 100.0d) : 0;
        if (iDoubleValue >= 100) {
            iDoubleValue = 100;
        }
        PPSCircleProgressBar pPSCircleProgressBar = this.e;
        if (pPSCircleProgressBar != null) {
            pPSCircleProgressBar.Code(iDoubleValue, bc.Code(Integer.valueOf(i)));
        }
    }

    @Override // com.huawei.hms.ads.lt
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.lt
    public lv V(int i) {
        if (i == 2) {
            return new PPSImageView(getContext());
        }
        if (i != 9) {
            return null;
        }
        PPSVideoView pPSVideoView = new PPSVideoView(getContext(), this.B.V(), 0, this.B.I(), 18);
        pPSVideoView.setHideSoundIcon(true);
        pPSVideoView.setIgnoreSoundCtrl(false);
        pPSVideoView.setStartVol(this.s);
        return pPSVideoView;
    }

    @Override // com.huawei.hms.ads.me
    public void destroyView() {
        fh.V("SmartScreenSplashView", "destroyView ");
        lv lvVar = this.c;
        if (lvVar != null) {
            lvVar.destroyView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ft ftVar;
        fh.V("SmartScreenSplashView", "dispatchKeyEvent:" + keyEvent.getKeyCode() + ", " + keyEvent.getAction());
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (ftVar = this.S) != null) {
            ftVar.Code(0, 0);
        }
        return true;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.lt
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.B;
        if (adSlotParam != null) {
            adSlotParam.Code(18);
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.lt
    public int getAdType() {
        return 18;
    }

    @Override // com.huawei.hms.ads.lt
    public int getAudioFocusType() {
        return 0;
    }

    public float getStartMaxVol() {
        return this.s;
    }

    public String getUniqueId() {
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ft ftVar;
        fh.V("SmartScreenSplashView", "onKeyDown, keyCode: %s", Integer.valueOf(keyEvent.getKeyCode()));
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (ftVar = this.S) != null) {
            ftVar.Code(0, 0);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.me
    public void pauseView() {
        fh.V("SmartScreenSplashView", "pauseView ");
        lv lvVar = this.c;
        if (lvVar != null) {
            lvVar.pauseView();
        }
        if (getContext() != null) {
            try {
                if (this.r != null) {
                    getContext().unregisterReceiver(this.r);
                    this.r = null;
                }
            } catch (Throwable th) {
                fh.I("SmartScreenSplashView", "unregister err: %s", th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.me
    public void resumeView() {
        fh.V("SmartScreenSplashView", "resumeView ");
        lv lvVar = this.c;
        if (lvVar != null) {
            lvVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.F = aVar;
        ft ftVar = this.S;
        if (ftVar != null) {
            ftVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.C = bVar;
        this.D.Code(bVar);
        ft ftVar = this.S;
        if (ftVar != null) {
            ftVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (z.Code(getContext())) {
            int iB = com.huawei.openalliance.ad.utils.d.B(getContext(), adSlotParam.V());
            int iC = com.huawei.openalliance.ad.utils.d.C(getContext(), adSlotParam.V());
            adSlotParam.Z(iB);
            adSlotParam.B(iC);
            adSlotParam.I(8);
            adSlotParam.L(Integer.valueOf(this.I));
            adSlotParam.Z((Integer) 0);
            adSlotParam.B(Integer.valueOf((HiAd.Code(getContext()).isNewProcess() && com.huawei.openalliance.ad.utils.d.L(getContext())) ? 0 : 1));
            this.B = adSlotParam;
            com.huawei.openalliance.ad.inter.h hVarCode = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (hVarCode instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) hVarCode).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.q = i;
        lv lvVar = this.c;
        if (lvVar != null) {
            lvVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.I = i;
    }

    public void setLogo(View view) {
        Code(view, 0);
    }

    public void setSloganResId(int i) {
        if (z.Code(getContext())) {
            if (bg.D(getContext())) {
                fh.I("SmartScreenSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.B == null) {
                throw new dt("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.L == null) {
                SloganView sloganView = new SloganView(getContext(), this.B.V(), i, 18);
                this.L = sloganView;
                this.i.addView(sloganView, new RelativeLayout.LayoutParams(-1, -1));
                this.L.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.f6983a = view;
            view.setVisibility(8);
        }
    }

    public void setStartMaxVol(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                fh.V("SmartScreenSplashView", "music max %s, current %s， maxVol： %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
                float f2 = streamVolume;
                float f3 = streamMaxVolume * 1.0f * f;
                float fFloatValue = f2 * 1.0f >= f3 ? Float.valueOf(f3 / f2).floatValue() : 1.0f;
                if (fh.Code()) {
                    fh.Code("SmartScreenSplashView", "maxVol end: %s", Float.valueOf(fFloatValue));
                }
                this.s = fFloatValue;
                return;
            }
        }
        fh.I("SmartScreenSplashView", "valid max vol is from 0.0 to 1.0");
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    private void I(AdContentData adContentData) {
        MetaData metaDataS;
        if (adContentData == null) {
            return;
        }
        if (this.f != null) {
            String strR = adContentData.r();
            this.f.setDataAndRefreshUi(adContentData);
            if (TextUtils.isEmpty(strR) || !this.f.Code()) {
                this.f.setVisibility(8);
            } else {
                MetaData metaDataS2 = adContentData.S();
                if (metaDataS2 == null || AdSource.Code(metaDataS2.l()) == null) {
                    this.f.setText(strR);
                } else {
                    this.f.V(AdSource.Code(metaDataS2.l()), strR);
                }
                this.f.setVisibility(0);
            }
        }
        if (this.g == null || (metaDataS = adContentData.S()) == null) {
            return;
        }
        String strV = bc.V(metaDataS.L());
        if (TextUtils.isEmpty(strV)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(strV);
            this.g.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(int i) {
        fp fpVarCode = fq.Code(i, this);
        this.S = fpVarCode;
        fpVarCode.Code(this.C);
        this.S.Code(this.F);
        this.S.Code(this.I);
        this.S.V(this.k);
        this.S.q();
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(int i, int i2, String str, boolean z, Integer num) {
    }

    @Override // com.huawei.hms.ads.lt
    public Integer V(AdContentData adContentData) {
        return null;
    }

    private void V(Context context) {
        View.inflate(context, z.f(context) ? R.layout.hiad_view_tv_splash_ad_elderly : R.layout.hiad_view_tv_splash_ad, this);
        this.i = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.j = (RelativeLayout) findViewById(R.id.hiad_logo_container);
        this.d = (TextView) findViewById(R.id.hiad_skip_text);
        this.e = (PPSCircleProgressBar) findViewById(R.id.hiad_count_progress);
        this.f = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.g = (TextView) findViewById(R.id.hiad_ad_source);
        setFocusable(true);
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(int i, boolean z) {
    }

    private void Code(Context context) {
        V(context);
        this.Code = eh.Code(context.getApplicationContext());
        this.D = new iq(context.getApplicationContext(), this);
        this.l = this.Code.ad();
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(View view) {
    }

    public void Code(View view, int i) {
        this.b = view;
        view.setVisibility(i);
        this.h = i;
    }

    private void Code(lv lvVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.cm);
        if (this.r == null) {
            this.r = new a(lvVar);
        }
        z.Code(getContext(), this.r, intentFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.lt
    public void Code(lv lvVar, Integer num) {
        if (bg.D(getContext())) {
            fh.I("SmartScreenSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (lvVar == 0 || !(lvVar instanceof View)) {
            return;
        }
        View view = (View) lvVar;
        this.c = lvVar;
        lvVar.setAudioFocusType(this.q);
        Code(this.c);
        ViewParent parent = view.getParent();
        if (parent == this.i) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            fh.V("SmartScreenSplashView", "showAdView, remove adView.");
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        setVisibleAndBringToFont(this.j);
        setVisibleAndBringToFont(this.b);
        this.i.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(mg mgVar) {
        View view = this.f6983a;
        if (view != null) {
            view.setVisibility(0);
            new ie(this.Code, mgVar).V();
            return;
        }
        SloganView sloganView = this.L;
        if (sloganView == null) {
            fh.V("SmartScreenSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.L;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(mgVar);
        this.L.Code();
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(AdContentData adContentData) {
    }

    @Override // com.huawei.hms.ads.lt
    public void Code(AdContentData adContentData, int i) {
        fh.Code("SmartScreenSplashView", "showLabelView and logo.");
        if (this.d != null && this.e != null) {
            if (adContentData != null && adContentData.S() != null && adContentData.l() == 9) {
                long jK = adContentData.S().k();
                this.n = jK;
                this.e.Code(0, bc.Code(Integer.valueOf((int) ((jK * 1.0f) / 1000.0f))));
            }
            F();
        }
        if (this.j != null && this.b != null) {
            fh.V("SmartScreenSplashView", "show logo, visibility: %s", Integer.valueOf(this.h));
            this.j.addView(this.b);
            this.b.setVisibility(this.h);
        }
        I(adContentData);
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }
}

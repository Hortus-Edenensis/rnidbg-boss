package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class s extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.j.c {
    private com.kwad.components.ad.splashscreen.e.b Ie;
    private boolean If;
    private long Ih;
    private az Ii;
    private ViewGroup Ik;

    @Nullable
    private KsAdWebView eN;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean Ig = false;
    private boolean Ij = false;
    private final Runnable Il = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.1
        @Override // java.lang.Runnable
        public final void run() {
            s.a(s.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cy(s.this.mAdTemplate), SystemClock.elapsedRealtime() - s.this.Ih, 1, "");
            s.this.mL();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    private void bb() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.eQ;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.GC.mRootContainer;
        bVar2.aRL = adBaseFrameLayout;
        bVar2.Vs = adBaseFrameLayout;
        bVar2.UA = this.eN;
        bVar2.mReportExtData = null;
        bVar2.aRN = false;
        bVar2.aRO = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    private void be() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE() {
        if (this.gX != null || this.Ig) {
            return;
        }
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.dn(this.GC.mAdTemplate));
        this.gX = dVar;
        dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.6
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                boolean zPl = com.kwad.components.core.e.c.b.pl();
                if (!s.this.GC.FP.xM() || zPl) {
                    return;
                }
                s.this.h(d);
                if (s.this.gZ == null) {
                    s sVar = s.this;
                    sVar.gZ = sVar.F(sVar.getContext());
                }
                bw.a(s.this.getContext(), s.this.gZ);
                s.this.gX.bQ(s.this.getContext());
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cc() {
            }
        });
        this.gX.bP(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL() {
        this.Ig = true;
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.Ik;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter presenterY = y(this.mAdInfo);
        if (presenterY != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.8
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.a(presenterY, true);
                }
            });
        } else {
            mM();
        }
    }

    private void mM() {
        mK();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.eg(this.mAdTemplate), this.GC.mApkDownloadHelper);
        this.Ie = bVar;
        bVar.av(this.mAdTemplate);
        this.Ie.a(this);
        this.Ie.mL();
    }

    private z mN() {
        return new z(this.eQ, this.GC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.c.a.a.Fq()) {
                    return;
                }
                if (aVar.MS() || com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.ahJ, aVar.mH, aVar.ahK.PI);
                }
            }
        });
    }

    private ac mO() {
        return new ac(this.eQ, this.GC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.ahH || !com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.ahH ? 1 : 3, aVar.mH, "");
                }
            }
        }, (byte) 0);
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.dp(com.kwad.sdk.core.response.b.e.er(this.GC.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.b.dV(adInfo)) {
                return new m();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.b.b.dT(this.mAdInfo)) {
            return new o();
        }
        if (com.kwad.sdk.core.response.b.b.dV(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.dY(this.mAdInfo)) {
            return new q();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dZ(this.mAdInfo)) {
            return new l();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.ea(this.mAdInfo)) {
            return new n();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.eb(this.mAdInfo)) {
            return new p();
        }
        return null;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.GC.FP.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.Ik = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.eN = new KsAdWebView(getContext());
            this.eN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Ik.addView(this.eN);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.GC.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.er(adTemplate);
        this.If = false;
        this.Ig = false;
        String strCy = com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate);
        if (this.eN == null || TextUtils.isEmpty(strCy) || this.GC.FU) {
            mL();
        } else {
            this.Ih = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.au(this.mAdTemplate);
            a(this.eN, strCy);
            bw.a(this.Il, null, com.kwad.sdk.core.response.b.b.ef(this.mAdInfo));
        }
        this.GC.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bs() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bP(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bQ(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lR() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bQ(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void mK() {
        if (this.If) {
            return;
        }
        this.If = true;
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBv = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.GC.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dx(123).b(c0601a));
        com.kwad.components.core.webview.tachikoma.e.a.xj().bE(123);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.j.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Ie;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bQ(getContext());
        }
        az azVar = this.Ii;
        if (azVar != null) {
            azVar.wi();
            this.Ii.wj();
        }
        com.kwad.components.ad.splashscreen.h hVar = this.GC;
        if (hVar != null && (aVar = hVar.FP) != null) {
            aVar.b(this);
        }
        be();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d) {
        com.kwad.components.ad.splashscreen.h hVar = this.GC;
        if (hVar != null) {
            hVar.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z, boolean z2) {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, null);
    }

    public static /* synthetic */ boolean a(s sVar, boolean z) {
        sVar.Ij = true;
        return true;
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        bb();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eP(this.GC.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.s.3
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.Ih);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bw.c(s.this.Il);
                s.this.mL();
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.Ih, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            mL();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        be();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.eP = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.eP, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new bc(this.eQ, this.GC.mApkDownloadHelper));
        aVar.a(mO());
        aVar.a(mN());
        aVar.a(new af(this.eQ));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new as(new as.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.4
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bw.c(s.this.Il);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.Ih, 3, "");
                    s.this.mL();
                    return;
                }
                s.this.GC.Gf = SystemClock.elapsedRealtime() - s.this.mStartTime;
                if (s.this.Ij) {
                    s.this.GC.isWebTimeout = true;
                } else if (s.this.Ii != null) {
                    s.this.Ii.wg();
                    s.this.Ii.wh();
                }
                if (com.kwad.sdk.core.response.b.b.ed(s.this.mAdInfo)) {
                    s.this.mK();
                }
            }
        }, str));
        aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.5
            @Override // com.kwad.components.core.webview.jshandler.bb.a
            public final void cK() {
                s.this.cE();
            }
        }));
        aVar.a(new am(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.eQ));
        az azVar = new az();
        this.Ii = azVar;
        aVar.a(azVar);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void am(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, int i2, String str) {
        this.GC.X();
        boolean z2 = !TextUtils.isEmpty(str);
        int i3 = 0;
        boolean z3 = i == 1;
        if (!z2) {
            JSONObject jSONObject = new JSONObject();
            try {
                com.kwad.components.ad.splashscreen.h hVar = this.GC;
                if (hVar != null) {
                    com.kwad.components.ad.splashscreen.d.a aVar = hVar.FN;
                    if (aVar != null) {
                        jSONObject.put("duration", aVar.getCurrentPosition());
                    }
                    if (z) {
                        i3 = 153;
                    } else if (z3) {
                        i3 = MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA;
                    }
                    try {
                        com.kwad.sdk.core.adlog.c.a(this.GC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dv(i3), jSONObject);
                    } catch (JSONException e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                } else {
                    i3 = i2;
                }
            } catch (JSONException e2) {
                e = e2;
                i3 = i2;
            }
        }
        a.C0539a c0539aAD = new a.C0539a(this.GC.mRootContainer.getContext()).aE(this.GC.mAdTemplate).b(this.GC.mApkDownloadHelper).as(z3).aD(i);
        if (!z2) {
            i2 = i3;
        }
        com.kwad.components.core.e.d.a.a(c0539aAD.aC(i2).ap(str).aB(1).au(z2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }));
    }
}

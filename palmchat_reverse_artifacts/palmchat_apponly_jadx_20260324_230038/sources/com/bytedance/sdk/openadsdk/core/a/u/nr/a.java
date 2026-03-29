package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.xg;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.openalliance.ad.constant.bq;
import com.oplus.tblplayer.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class a implements com.bytedance.sdk.component.t.u.u.fx {
    protected ja b;
    private double bf;

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    private String bg;

    @com.bytedance.sdk.component.t.nr.u(u = "is_reward")
    private boolean bq;

    @com.bytedance.sdk.component.t.nr.u(u = "close_button")
    private View c;

    @com.bytedance.sdk.component.t.nr.u(u = "end_card_height")
    private int d;

    @com.bytedance.sdk.component.t.nr.u(u = "extra_map")
    private Map<String, Object> dw;

    @com.bytedance.sdk.component.t.nr.u(u = "end_card_width")
    private int gi;

    @com.bytedance.sdk.component.t.nr.u(u = "action_type")
    private int h;
    protected String iz;
    private double ja;

    @com.bytedance.sdk.component.t.nr.u(u = "end_card_param")
    private com.bytedance.sdk.openadsdk.core.a.u.fx.u kj;
    private boolean m;
    com.bytedance.sdk.openadsdk.core.s.iz n;

    @com.bytedance.sdk.component.t.nr.u(u = "web_view")
    private WeakReference<SSWebView> o;
    private double pb;
    protected com.bytedance.sdk.openadsdk.core.s.jk pn;

    @com.bytedance.sdk.component.t.nr.u(u = "download_listener")
    private DownloadListener q;

    @com.bytedance.sdk.component.t.nr.u(u = "show_type")
    private int qq;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc sx;

    @com.bytedance.sdk.component.t.nr.u(u = "activity")
    protected TTBaseVideoActivity u;
    private double wq;
    protected com.bytedance.sdk.openadsdk.core.widget.u.b x;
    private String xg;

    @com.bytedance.sdk.component.t.nr.u(u = bq.f.V)
    private int z;
    private final Map<String, Bitmap> rh = new HashMap();
    int nr = 0;
    int fx = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5196a = 0;
    String jk = "";
    protected boolean t = false;
    protected boolean l = false;
    protected final AtomicBoolean mv = new AtomicBoolean(true);

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private Handler f5197jp = new Handler(Looper.myLooper()) { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.mv();
                    break;
                case 2:
                    a.this.pn();
                    break;
                case 3:
                    a.this.x();
                    break;
                case 4:
                    a.this.n();
                    break;
                case 5:
                    a.this.a();
                    break;
                case 6:
                    a.this.jk();
                    break;
                case 7:
                    a.this.t();
                    break;
                case 8:
                    a.this.l();
                    break;
                case 9:
                    a.this.s();
                    break;
                case 10:
                    a.this.k();
                    break;
                case 11:
                    a.this.my();
                    break;
                case 12:
                    a.this.o();
                    break;
                case 13:
                    a.this.sx();
                    break;
                case 14:
                    a.this.bg();
                    break;
            }
        }
    };
    protected AtomicBoolean s = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.dw.u k = new com.bytedance.sdk.openadsdk.core.dw.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.6
        @Override // com.bytedance.sdk.openadsdk.core.dw.u
        public int nr() {
            SSWebView sSWebView = a.this.o != null ? (SSWebView) a.this.o.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? y.b((Context) a.this.u) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.core.dw.u
        public int u() {
            SSWebView sSWebView = a.this.o != null ? (SSWebView) a.this.o.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? y.pn((Context) a.this.u) : measuredHeight;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.dw.iz my = new com.bytedance.sdk.openadsdk.core.dw.iz() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.7
        @Override // com.bytedance.sdk.openadsdk.core.dw.iz
        public void nr() {
            SSWebView sSWebView = a.this.o != null ? (SSWebView) a.this.o.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }

        @Override // com.bytedance.sdk.openadsdk.core.dw.iz
        public void u() {
            SSWebView sSWebView = a.this.o != null ? (SSWebView) a.this.o.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }
    };
    private final com.bytedance.sdk.openadsdk.core.dw.nr y = new com.bytedance.sdk.openadsdk.core.dw.nr() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.8
        @Override // com.bytedance.sdk.openadsdk.core.dw.nr
        public void u(boolean z, int i, String str) {
            if (z) {
                a aVar = a.this;
                aVar.l = true;
                if (aVar.m) {
                    a aVar2 = a.this;
                    aVar2.u(aVar2.ja, a.this.bf, a.this.wq, a.this.pb, a.this.xg);
                    a.this.m = false;
                }
            }
            if (zx.t(a.this.sx)) {
                a.this.u(z, i, str);
            }
        }
    };
    private final com.bytedance.sdk.openadsdk.jk.u bc = new com.bytedance.sdk.openadsdk.jk.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.9
        @Override // com.bytedance.sdk.openadsdk.jk.u
        public void u() {
            a.this.u.n(1);
        }
    };

    private void bq() {
        com.bytedance.sdk.openadsdk.core.a.u.fx.u uVar = this.kj;
        if (uVar == null) {
            return;
        }
        uVar.u(new com.bytedance.sdk.openadsdk.core.a.u.fx.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.10
        });
    }

    private void c() {
        WeakReference<SSWebView> weakReference;
        if (this.s.getAndSet(true) || (weakReference = this.o) == null) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", y.pn((Context) this.u), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.s.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable unused) {
        }
    }

    private void dw() {
        this.iz = zx.a(this.sx);
        float fBa = this.sx.ba();
        if (TextUtils.isEmpty(this.iz)) {
            return;
        }
        if (this.z == 1) {
            if (this.iz.contains(Constants.STRING_VALUE_UNSET)) {
                this.iz += "&orientation=portrait";
            } else {
                this.iz += "?orientation=portrait";
            }
        }
        if (this.iz.contains(Constants.STRING_VALUE_UNSET)) {
            this.iz += "&height=" + this.d + "&width=" + this.gi + "&aspect_ratio=" + fBa;
        } else {
            this.iz += "?height=" + this.d + "&width=" + this.gi + "&aspect_ratio=" + fBa;
        }
        this.iz = com.bytedance.sdk.openadsdk.core.component.reward.pn.u.u(this.iz);
    }

    private void q() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.s.getAndSet(true) || (weakReference = this.o) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, y.pn((Context) this.u));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                y.u((View) sSWebView, 8);
                a.this.s.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void qq() {
        ja jaVar = this.b;
        if (jaVar == null) {
            return;
        }
        jaVar.u(new SSWebView.nr() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.nr
            public void u(int i) {
                ja jaVar2 = a.this.b;
                if (jaVar2 != null) {
                    jaVar2.u(i);
                }
            }
        });
    }

    public void a() {
        this.pn = null;
    }

    public void bg() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl("about:blank");
    }

    public void jk() {
        WeakReference<SSWebView> weakReference = this.o;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        ja jaVar = this.b;
        if (jaVar != null) {
            jaVar.d();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.b.iz(true);
                    u(true);
                    u(false, true);
                } else {
                    this.b.iz(false);
                    u(false);
                    u(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.n;
        if (izVar != null) {
            izVar.b();
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.x;
        if (bVar != null) {
            bVar.nr(false);
        }
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar != null) {
            jkVar.a();
        }
    }

    public void l() {
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.n;
        if (izVar != null) {
            izVar.pn();
        }
    }

    public void mv() {
        WeakReference<SSWebView> weakReference = this.o;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            xg.u(this.u, sSWebView);
            xg.u(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.o;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        ja jaVar = this.b;
        if (jaVar != null) {
            jaVar.rh();
        }
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar != null) {
            jkVar.u(true);
            this.pn.my();
        }
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.n;
        if (izVar != null) {
            izVar.iz();
        }
        this.rh.clear();
    }

    public void my() {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar != null) {
            jkVar.t();
        }
    }

    public void o() {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar != null) {
            jkVar.l();
        }
    }

    public void s() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        y.u((View) sSWebView, 1.0f);
        qq();
    }

    public void sx() {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar != null) {
            jkVar.fx();
            this.pn.b();
        }
    }

    public void t() {
        WeakReference<SSWebView> weakReference = this.o;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        ja jaVar = this.b;
        if (jaVar != null) {
            jaVar.h();
            this.b.iz(false);
            u(false);
            u(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.x;
        if (bVar != null) {
            bVar.fx();
        }
    }

    public boolean b() {
        String str = this.iz;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void fx() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = new com.bytedance.sdk.openadsdk.core.widget.u.b(this.u, this.b, this.sx.lk(), this.n) { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                com.bytedance.sdk.openadsdk.core.s.jk jkVar = a.this.pn;
                if (jkVar != null) {
                    jkVar.x();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                com.bytedance.sdk.openadsdk.core.s.jk jkVar = a.this.pn;
                if (jkVar != null) {
                    jkVar.iz();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                a.this.mv.set(false);
                a aVar = a.this;
                aVar.f5196a = i;
                aVar.jk = str;
                if (aVar.pn != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i);
                            jSONObject.put("msg", str);
                        }
                        a.this.pn.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (a.this.pn != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        a.this.pn.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (a.this.iz.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        a.this.mv.set(false);
                    }
                    if (webResourceResponse != null) {
                        a.this.f5196a = webResourceResponse.getStatusCode();
                        a.this.jk = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseU = a.this.u(str);
                return webResourceResponseU != null ? webResourceResponseU : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (a.this.sx != null) {
                        WebResourceResponse webResourceResponseU = a.this.u(string);
                        if (webResourceResponseU != null) {
                            return webResourceResponseU;
                        }
                        if (TextUtils.isEmpty(a.this.sx.wv())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        a.this.nr++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    a.this.mv.set(false);
                }
                if (a.this.pn != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        a.this.pn.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                a.this.f5196a = webResourceError.getErrorCode();
                a.this.jk = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.x = bVar;
        sSWebView.setWebViewClient(bVar);
        u(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.b, this.n) { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.fx, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.q);
    }

    public void iz() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        y.u((View) sSWebView, 0);
        if (this.qq == 1) {
            y.u((View) sSWebView, 0.0f);
        }
        if (this.qq == 2) {
            c();
        }
        ja jaVar = this.b;
        if (jaVar != null) {
            jaVar.u(jp.sx(this.sx), false);
        }
        u(true);
        nr(true);
        u(false, true);
    }

    public void n() {
        if (this.u.yd() instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.n) {
            q();
            return;
        }
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null) {
            return;
        }
        y.u((View) weakReference.get(), 8);
    }

    public void nr() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = new com.bytedance.sdk.openadsdk.core.s.jk(this.bg, this.sx, jSONObject);
        this.pn = jkVar;
        jkVar.u(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.s.iz izVarNr = new com.bytedance.sdk.openadsdk.core.s.iz(this.sx, sSWebView).nr(true);
        this.n = izVarNr;
        izVarNr.u(true);
        dw();
        this.n.u(b() ? "landingpage_endcard" : this.bq ? "reward_endcard" : "fullscreen_endcard");
        ja jaVar = new ja(this.u) { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.12
        };
        this.b = jaVar;
        jaVar.nr(sSWebView).u(this.sx).nr(this.sx.lk()).b(this.sx.ap()).fx(this.bq ? 7 : 5).u(this.k).pn(jp.sx(this.sx)).u(sSWebView).nr(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.sx)).u(this.pn).u(this.bg).u(this.dw).u(this.my).u(this.c).u(this.bc);
        this.b.u(this.y);
    }

    public void pn() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.t) {
            return;
        }
        sSWebView.loadUrl(this.iz);
        this.t = true;
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.n;
        if (izVar != null) {
            izVar.u(System.currentTimeMillis());
        }
    }

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        if (this.h != 0) {
            iz();
            return true;
        }
        u();
        nr();
        fx();
        bq();
        return true;
    }

    public void u(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.pn;
        if (jkVar == null) {
            return;
        }
        if (z) {
            jkVar.nr();
        } else {
            jkVar.u(i, str);
        }
    }

    public void u() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.o;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    a.this.u(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2) {
        if (this.b == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.b.nr("resize", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.u).u(false).nr(false).u(sSWebView);
        c.u(sSWebView, d.fx, bc.b(this.sx));
        y.u((com.bytedance.sdk.component.mv.fx) sSWebView);
        int i = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i < 24) {
            sSWebView.setLayerType(0, null);
        }
    }

    public void nr(boolean z) {
        if (this.b == null || this.u.isFinishing()) {
            return;
        }
        try {
            this.b.iz(z);
        } catch (Exception unused) {
        }
    }

    public void u(boolean z) {
        if (this.b == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.b.nr("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(boolean z, boolean z2) {
        if (this.b == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.b.nr("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(double d, double d2, double d3, double d4, String str) {
        if (this.b == null || this.u.isFinishing()) {
            return;
        }
        if (!this.l) {
            this.ja = d;
            this.bf = d2;
            this.pb = d4;
            this.wq = d3;
            this.xg = str;
            this.m = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.b.nr("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse u(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.rh.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}

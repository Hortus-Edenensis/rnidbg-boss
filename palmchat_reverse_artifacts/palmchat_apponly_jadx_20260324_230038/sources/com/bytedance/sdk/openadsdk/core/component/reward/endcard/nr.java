package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bykv.vk.openvk.component.video.u.pn.nr;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.pn;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.s.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.oplus.tblplayer.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private String bf;
    private double d;
    private final com.bytedance.sdk.openadsdk.core.dw.nr gi;
    private double h;
    private double ja;
    private final Map<String, Bitmap> kj;
    private double rh;
    private boolean wq;
    private final com.bytedance.sdk.openadsdk.jk.u z;

    public nr(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, bcVar, str, i, i2, z);
        this.kj = new HashMap();
        this.z = new com.bytedance.sdk.openadsdk.jk.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr.1
            @Override // com.bytedance.sdk.openadsdk.jk.u
            public void u() {
                nr.this.u.n(1);
            }
        };
        this.gi = new com.bytedance.sdk.openadsdk.core.dw.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr.2
            @Override // com.bytedance.sdk.openadsdk.core.dw.nr
            public void u(boolean z2, int i3, String str2) {
                if (z2) {
                    nr nrVar = nr.this;
                    nrVar.my = true;
                    if (nrVar.wq) {
                        nr nrVar2 = nr.this;
                        nrVar2.u(nrVar2.d, nr.this.h, nr.this.rh, nr.this.ja, nr.this.bf);
                        nr.this.wq = false;
                    }
                }
                if (zx.t(nr.this.nr)) {
                    nr.this.u(z2, i3, str2);
                }
                SSWebView sSWebView = nr.this.x;
                if (sSWebView != null) {
                    if (sSWebView.getVisibility() == 0) {
                        nr.this.n.iz(true);
                        nr.this.u(true);
                        nr.this.u(false, true);
                    } else {
                        nr.this.n.iz(false);
                        nr.this.u(false);
                        nr.this.u(true, false);
                    }
                }
            }
        };
        this.x = abstractEndCardFrameLayout.getEndCardWebView();
        u();
    }

    private void h() {
        this.jk = zx.a(this.nr);
        float fBa = this.nr.ba();
        if (TextUtils.isEmpty(this.jk)) {
            return;
        }
        String strTrim = this.jk.trim();
        this.jk = strTrim;
        if (this.bg == 1) {
            if (strTrim.contains(Constants.STRING_VALUE_UNSET)) {
                this.jk += "&orientation=portrait";
            } else {
                this.jk += "?orientation=portrait";
            }
        }
        if (this.jk.contains(Constants.STRING_VALUE_UNSET)) {
            this.jk += "&height=" + this.dw + "&width=" + this.bq + "&aspect_ratio=" + fBa;
        } else {
            this.jk += "?height=" + this.dw + "&width=" + this.bq + "&aspect_ratio=" + fBa;
        }
        this.jk = com.bytedance.sdk.openadsdk.core.component.reward.pn.u.u(this.jk);
    }

    public void d() {
        SSWebView sSWebView;
        if (this.k || (sSWebView = this.x) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.x.loadUrl(this.jk);
        this.k = true;
    }

    public boolean gi() {
        String str = this.jk;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void k() {
        super.k();
        this.kj.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public String qq() {
        return "endcard";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(boolean z, Map<String, Object> map, View view) {
        if (this.x == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jk jkVar = new jk(this.fx, this.nr, jSONObject);
        this.f5232a = jkVar;
        jkVar.u(jSONObject, "webview_source", (Object) 2);
        iz izVarNr = new iz(this.nr, this.x).nr(true);
        this.l = izVarNr;
        izVarNr.u(true);
        h();
        this.l.u(gi() ? "landingpage_endcard" : z ? "reward_endcard" : "fullscreen_endcard");
        ja jaVar = new ja(this.u);
        this.n = jaVar;
        jaVar.nr(this.x).u(this.nr).nr(this.nr.lk()).b(this.nr.ap()).fx(z ? 7 : 5).u(this.q).pn(jp.sx(this.nr)).u(this.x).nr(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.nr)).u(this.f5232a).u(this.fx).u(map).u(this.qq).u(view).fx(this.u.u()).u(this.z);
        this.n.u(this.gi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        if (this.x == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = new com.bytedance.sdk.openadsdk.core.widget.u.b(this.u, this.n, this.nr.lk(), this.l) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                jk jkVar = nr.this.f5232a;
                if (jkVar != null) {
                    jkVar.x();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                jk jkVar = nr.this.f5232a;
                if (jkVar != null) {
                    jkVar.iz();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                nr.this.o.set(false);
                nr.this.sx = this.n;
                nr nrVar2 = nr.this;
                nrVar2.mv = i;
                nrVar2.s = str;
                if (nrVar2.f5232a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i);
                            jSONObject.put("msg", str);
                        }
                        nr.this.f5232a.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (nr.this.f5232a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        nr.this.f5232a.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (nr.this.jk.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        nr.this.o.set(false);
                        nr.this.sx = this.n;
                    }
                    if (webResourceResponse != null) {
                        nr.this.mv = webResourceResponse.getStatusCode();
                        nr.this.s = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseU = nr.this.u(str);
                return webResourceResponseU != null ? webResourceResponseU : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    nr nrVar2 = nr.this;
                    if (nrVar2.nr != null) {
                        WebResourceResponse webResourceResponseU = nrVar2.u(string);
                        if (webResourceResponseU != null) {
                            return webResourceResponseU;
                        }
                        if (TextUtils.isEmpty(nr.this.nr.wv())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        nr.this.pn++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    k.u("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    nr.this.o.set(false);
                    nr.this.sx = this.n;
                }
                if (nr.this.f5232a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        nr.this.f5232a.nr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                nr.this.mv = webResourceError.getErrorCode();
                nr.this.s = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.t = bVar;
        this.x.setWebViewClient(bVar);
        u(this.x);
        this.x.setBackgroundColor(-1);
        this.x.setDisplayZoomControls(false);
        this.x.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.n, this.l) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.fx, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.x.setDownloadListener(downloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(int i) {
        super.u(i);
        u(true);
        fx(true);
        u(false, true);
    }

    public void u(double d, double d2, double d3, double d4, String str) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        if (!this.my) {
            this.d = d;
            this.h = d2;
            this.ja = d4;
            this.rh = d3;
            this.bf = str;
            this.wq = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.n.nr("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void u(s sVar) {
        double dN;
        double dA;
        double d;
        double dX;
        if (yd.qq(this.nr)) {
            double d2 = this.bq;
            double d3 = this.dw;
            if (sVar == null || !this.u.yd().x() || (sVar.n() == 0.0d && sVar.a() == 0.0d)) {
                dN = d2;
                dA = d3;
                d = 0.0d;
                dX = 0.0d;
            } else {
                double dIz = sVar.iz();
                d = dIz;
                dX = sVar.x();
                dN = sVar.n();
                dA = sVar.a();
            }
            u(d, dX, dN, dA, null);
            if (this.u.yd() instanceof pn) {
                return;
            }
            final double d4 = d;
            final double d5 = dX;
            final double d6 = dN;
            final double d7 = dA;
            com.bykv.vk.openvk.component.video.u.pn.nr.u(2147483647L, zx.u(this.nr), new nr.InterfaceC0162nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr.5
                @Override // com.bykv.vk.openvk.component.video.u.pn.nr.InterfaceC0162nr
                public void u(Bitmap bitmap) {
                    if (bitmap != null) {
                        String strValueOf = String.valueOf(bitmap.hashCode());
                        nr.this.kj.put(strValueOf, bitmap);
                        nr.this.u(d4, d5, d6, d7, strValueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse u(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.kj.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}

package com.bytedance.sdk.openadsdk.core.widget.u;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.adexpress.pn.pn;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bf;
import com.bytedance.sdk.openadsdk.core.kj.d;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.x;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.oa;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.huawei.openalliance.ad.constant.bh;
import com.umeng.commonsdk.framework.UMModuleRegister;
import j$.util.Map;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends WebViewClient implements SSWebView.fx {
    private static final HashSet<String> t;
    protected final String b;
    protected final Context fx;
    protected final ja nr;
    protected iz pn;
    private com.bytedance.sdk.openadsdk.l.b u;
    protected boolean iz = true;
    protected boolean x = true;
    protected volatile AtomicInteger n = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5407a = -1;
    private boolean jk = false;

    static {
        HashSet<String> hashSet = new HashSet<>();
        t = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add(bh.V);
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public b(Context context, ja jaVar, String str) {
        this.fx = context;
        this.nr = jaVar;
        this.b = str;
    }

    private static String nr(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !t.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }

    private boolean u(Uri uri) {
        File fileNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext());
        if (uri == null) {
            return false;
        }
        try {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                return false;
            }
            File canonicalFile = new File(fileNr, lastPathSegment).getCanonicalFile();
            if (canonicalFile.exists()) {
                return !canonicalFile.getPath().startsWith(fileNr.toString());
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void fx() {
        this.jk = true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u(webView);
        }
        if (webView != null && this.iz) {
            try {
                String strU = nr.u(dw.nr().wi(), this.b);
                if (!TextUtils.isEmpty(strU)) {
                    s.u(webView, strU);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u(webView, str, bitmap);
        }
        if (this.x) {
            nr.u(this.fx).u(true).u(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u(i, str, str2, nr(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.pn == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey(HttpHeaders.ACCEPT)) {
            str = requestHeaders.get(HttpHeaders.ACCEPT);
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.pn.u(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.pn != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.pn.u(primaryError, str, url, nr(url));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash()) {
            k.nr("WebChromeClient", "The WebView rendering process crashed!");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                pn.u().nr();
            }
            return true;
        }
        k.nr("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            pn.u().nr();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && u(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.u != null) {
            webResourceResponseShouldInterceptRequest = this.u.u(webView, new com.bytedance.sdk.openadsdk.l.nr(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (u(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        List<d.fx> listU = oa.u().u(webResourceRequest.getUrl().toString());
        if (listU == null || listU.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        oa oaVarU = oa.u();
        String string = webResourceRequest.getUrl().toString();
        iz izVar = this.pn;
        return oaVarU.u(webResourceResponseShouldInterceptRequest, string, listU, izVar != null ? izVar.n() : null);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ja jaVar;
        u(str);
        try {
            if (u(webView, str)) {
                return true;
            }
            com.bytedance.sdk.openadsdk.l.b bVar = this.u;
            if (bVar != null) {
                bVar.u(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                c.u(uri, this.nr);
                return true;
            }
            if (n.o().y() != null) {
                boolean zU = false;
                if (((Boolean) n.o().y().apply(com.bytedance.sdk.openadsdk.my.b.u().u(15).u(Boolean.class).u(0, new wq().u(ContentProviderManager.PROVIDER_URI, uri)).nr())).booleanValue()) {
                    ja jaVar2 = this.nr;
                    if (jaVar2 != null && jaVar2.n() != null) {
                        boolean z = dw.nr().ol() != 1;
                        if (com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(str) && z) {
                            bc bcVarN = this.nr.n();
                            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarNr = com.bytedance.sdk.openadsdk.core.l.n.nr(this.fx, bcVarN, this.nr.gi(), true);
                            if (fxVarNr instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                                ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVarNr).iz(true);
                            }
                            fxVarNr.u(bcVarN, false);
                            zU = true;
                        } else {
                            zU = com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(uri, this.nr.n(), this.fx, this.nr.gi(), hashCode());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.nr.u().put("is_landing_page_open_market", true);
                    if (zU) {
                        return true;
                    }
                }
            }
            if (!o.u(str) && (jaVar = this.nr) != null && jaVar.n() != null) {
                final String strGi = this.nr.gi();
                final bc bcVarN2 = this.nr.n();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(268435456);
                com.bytedance.sdk.openadsdk.core.s.b.nr(bcVarN2, strGi, "lp_open_dpl", lowerCase);
                if (!jp.nr(this.fx)) {
                    try {
                        u(this.fx, intent);
                        com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_openurl", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_deeplink_success_realtime", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.s.n.u().u(bcVarN2, strGi, true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_openurl_failed", th);
                        com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_deeplink_fail_realtime", th);
                    }
                } else if (jp.u(this.fx, intent)) {
                    com.bytedance.sdk.component.utils.nr.u(this.fx, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.b.1
                        @Override // com.bytedance.sdk.component.utils.nr.u
                        public void u() {
                            com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_deeplink_success_realtime", (Throwable) null);
                        }

                        @Override // com.bytedance.sdk.component.utils.nr.u
                        public void u(Throwable th2) {
                            com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_openurl_failed", th2);
                            com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_deeplink_fail_realtime", th2);
                        }
                    }, TextUtils.equals("main", UMModuleRegister.INNER));
                    com.bytedance.sdk.openadsdk.core.s.n.u().u(bcVarN2, strGi, true);
                } else {
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_openurl_failed", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVarN2, strGi, "lp_deeplink_fail_realtime", (Throwable) null);
                }
                return true;
            }
        } catch (Exception unused) {
            ja jaVar3 = this.nr;
            if (jaVar3 != null && jaVar3.a()) {
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.pn == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey(HttpHeaders.ACCEPT)) {
            str = requestHeaders.get(HttpHeaders.ACCEPT);
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.pn.u(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
    }

    public boolean u(WebView webView, WebResourceRequest webResourceRequest) {
        return bf.u(webView, this.n, this.nr, webResourceRequest, false, nr()) && !(this instanceof x);
    }

    public boolean u(WebView webView, String str) {
        return bf.u(webView, this.n, this.nr, str, false, nr()) && !(this instanceof x);
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.bytedance.sdk.openadsdk.core.s.b.fx(this.nr.n(), com.huawei.openalliance.ad.constant.x.df, "lp_pay");
        }
    }

    public boolean nr() {
        return System.currentTimeMillis() - this.f5407a < ((long) dw.nr().up());
    }

    public void nr(boolean z) {
        if (!z || this.jk) {
            this.f5407a = System.currentTimeMillis();
        }
    }

    public b(Context context, ja jaVar, String str, iz izVar) {
        this.fx = context;
        this.nr = jaVar;
        this.b = str;
        this.pn = izVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && u(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.u != null) {
            webResourceResponseShouldInterceptRequest = this.u.u(webView, new com.bytedance.sdk.openadsdk.l.nr(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (u(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        List<d.fx> listU = oa.u().u(str);
        if (listU == null || listU.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        oa oaVarU = oa.u();
        iz izVar = this.pn;
        return oaVarU.u(webResourceResponseShouldInterceptRequest, str, listU, izVar != null ? izVar.n() : null);
    }

    private void u(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.nr.u(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.fx
    public void u(boolean z) {
        ja jaVar = this.nr;
        if (jaVar != null) {
            jaVar.fx(z);
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.fx
    public void u(MotionEvent motionEvent) {
        bc bcVarN;
        JSONObject jSONObjectTq;
        ja jaVar = this.nr;
        if (jaVar == null || (bcVarN = jaVar.n()) == null || (jSONObjectTq = bcVarN.tq()) == null) {
            return;
        }
        final int iOptInt = jSONObjectTq.optInt("rit", 0);
        int toolType = motionEvent.getToolType(0);
        if (motionEvent.getActionMasked() == 0) {
            kj.u(motionEvent);
            if (toolType == 0) {
                jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SoftDecTool.codeIdCountMap.put(Integer.valueOf(iOptInt), Integer.valueOf(((Integer) Map.EL.getOrDefault(SoftDecTool.codeIdCountMap, Integer.valueOf(iOptInt), 0)).intValue() + 1));
                    }
                });
            }
        }
    }

    public b(Context context, ja jaVar, String str, iz izVar, com.bytedance.sdk.openadsdk.l.b bVar) {
        this.fx = context;
        this.nr = jaVar;
        this.b = str;
        this.pn = izVar;
        this.u = bVar;
    }
}

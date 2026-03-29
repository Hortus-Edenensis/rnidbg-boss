package com.opos.mobad.video.player.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static final WebView a(Context context, com.opos.cmn.biz.web.b.a.a.a aVar, Map<String, Object> map, a aVar2) {
        WebView webView = new WebView(context);
        a(webView, aVar, map, aVar2);
        return webView;
    }

    private static void b(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.opos.mobad.video.player.c.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(j2 * 2);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
            }
        });
    }

    private static void a(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(webView.getContext().getApplicationContext().getDir("database", 0).getPath());
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(false);
    }

    private static void a(WebView webView, final com.opos.cmn.biz.web.b.a.a.a aVar, final a aVar2) {
        webView.setWebViewClient(new WebViewClient() { // from class: com.opos.mobad.video.player.c.c.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f10303a = false;

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                a aVar3;
                super.onPageFinished(webView2, str);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageFinished:url=");
                if (str == null) {
                    str = com.igexin.push.core.b.m;
                }
                sb.append(str);
                com.opos.cmn.an.f.a.a("web_creator", sb.toString());
                if (this.f10303a || (aVar3 = aVar2) == null) {
                    return;
                }
                aVar3.a();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageStarted:url=");
                if (str == null) {
                    str = com.igexin.push.core.b.m;
                }
                sb.append(str);
                com.opos.cmn.an.f.a.a("web_creator", sb.toString());
                this.f10303a = false;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError:errorCode=");
                sb.append(i);
                sb.append(",description=");
                if (str == null) {
                    str = com.igexin.push.core.b.m;
                }
                sb.append(str);
                sb.append(",failingUrl=");
                if (str2 == null) {
                    str2 = com.igexin.push.core.b.m;
                }
                sb.append(str2);
                com.opos.cmn.an.f.a.c("web_creator", sb.toString());
                this.f10303a = true;
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.b();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                com.opos.cmn.biz.web.b.a.a.a aVar3;
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedSslError:error=");
                sb.append(sslError != null ? sslError.toString() : com.igexin.push.core.b.m);
                com.opos.cmn.an.f.a.c("web_creator", sb.toString());
                if (sslErrorHandler == null || (aVar3 = aVar) == null) {
                    super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                } else {
                    aVar3.a(sslErrorHandler, sslError);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView2, renderProcessGoneDetail);
                }
                com.opos.cmn.an.f.a.c("web_creator", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
                a aVar3 = aVar2;
                if (aVar3 == null) {
                    return true;
                }
                aVar3.c();
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView2, KeyEvent keyEvent) {
                super.onUnhandledKeyEvent(webView2, keyEvent);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView2, String str) {
                WebResourceResponse webResourceResponseA = com.opos.cmn.biz.web.a.b.c.a().a(str);
                return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                return super.shouldOverrideUrlLoading(webView2, str);
            }
        });
    }

    private static void a(WebView webView, com.opos.cmn.biz.web.b.a.a.a aVar, Map<String, Object> map, a aVar2) {
        a(webView);
        b(webView);
        a(webView, aVar, aVar2);
        a(webView, map);
        webView.requestFocusFromTouch();
        webView.requestFocus();
    }

    private static void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!com.opos.cmn.an.d.b.a(key) && value != null) {
                    com.opos.cmn.an.f.a.a("web_creator", "addJavascriptInterface jsName=" + key + ",object=" + value);
                    webView.addJavascriptInterface(value, key);
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("web_creator", "", e);
        }
    }
}

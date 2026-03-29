package com.opos.cmn.biz.web.b.b.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7902a;
    private Map<String, Object> b;
    private Map<String, Object> c;
    private boolean d;
    private WebView e;
    private RelativeLayout f;
    private RelativeLayout g;
    private String k;
    private com.opos.cmn.biz.web.b.a.a.b m;
    private com.opos.cmn.biz.web.b.a.a.a n;
    private com.opos.cmn.biz.web.b.a.a.c o;
    private RelativeLayout h = null;
    private TextView i = null;
    private ProgressBar j = null;
    private boolean l = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.a(bVar.k);
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.b.b.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC0661b implements View.OnClickListener {
        public ViewOnClickListenerC0661b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            quotaUpdater.updateQuota(j2 * 2);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            b.this.j.setProgress(i);
            if (i < 100 || b.this.j == null) {
                return;
            }
            b.this.j.setVisibility(8);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished:url=");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.toString());
            if (b.this.l) {
                return;
            }
            b.this.p();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageStarted:url=");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.toString());
            b.this.l = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
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
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
            b.this.l = true;
            b.this.q();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedSslError:error=");
            sb.append(sslError != null ? sslError.toString() : com.igexin.push.core.b.m);
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
            b.this.a(sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
            b.this.c();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse webResourceResponseA = com.opos.cmn.biz.web.a.b.c.a().a(str);
            return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (com.opos.cmn.an.d.b.a(str) || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            b.this.b(str);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f7907a;

        public e(b bVar, SslErrorHandler sslErrorHandler) {
            this.f7907a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7907a.proceed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f7908a;

        public f(SslErrorHandler sslErrorHandler) {
            this.f7908a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7908a.cancel();
            b.this.r();
        }
    }

    public b(Context context, com.opos.cmn.biz.web.b.a.b bVar) {
        this.f7902a = context;
        this.b = bVar.b;
        this.m = bVar.f7899a;
        this.n = bVar.d;
        this.d = bVar.c;
        this.o = bVar.e;
        this.c = bVar.f;
        f();
        k();
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7902a);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f.setFitsSystemWindows(true);
        View viewG = g();
        this.f.addView(viewG);
        if (!this.d) {
            viewG.setVisibility(8);
        }
        h();
        i();
        j();
    }

    private View g() {
        LinearLayout linearLayout = new LinearLayout(this.f7902a);
        linearLayout.setId(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f7902a, 43.33f)));
        if (com.opos.cmn.biz.web.b.b.a.a.b(this.f7902a)) {
            linearLayout.setBackgroundColor(Color.parseColor("#F5EEEEEE"));
        } else {
            com.opos.cmn.biz.web.b.b.a.a.a(linearLayout, com.opos.cmn.an.e.a.a.c(this.f7902a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        }
        this.i = new TextView(this.f7902a);
        Drawable drawableC = com.opos.cmn.an.e.a.a.c(this.f7902a, "o_cmn_biz_ui_web_close_bn.png");
        drawableC.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f7902a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f7902a, 24.0f));
        this.i.setCompoundDrawables(drawableC, null, null, null);
        this.i.setGravity(17);
        this.i.setTextSize(2, 15.0f);
        this.i.setTextColor(Color.parseColor("#2ac795"));
        this.i.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f7902a, 2.0f));
        this.i.setText("返回");
        linearLayout.addView(this.i, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f7902a, 43.33f)));
        return linearLayout;
    }

    private void h() {
        this.g = new RelativeLayout(this.f7902a);
        WebView webView = new WebView(this.f7902a);
        this.e = webView;
        this.g.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.f.addView(this.g, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7902a);
        this.h = relativeLayout;
        relativeLayout.setVisibility(8);
        this.h.setGravity(17);
        ImageView imageView = new ImageView(this.f7902a);
        imageView.setId(2);
        imageView.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.f7902a, "o_cmn_biz_ui_web_err_tag_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f7902a, 39.33f), com.opos.cmn.an.h.f.a.a(this.f7902a, 40.0f));
        layoutParams.addRule(14, -1);
        this.h.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f7902a);
        textView.setId(3);
        textView.setText("网络繁忙，请刷新");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#ababab"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, 2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f7902a, 15.0f);
        this.h.addView(textView, layoutParams2);
        com.opos.cmn.biz.web.b.b.b.a aVar = new com.opos.cmn.biz.web.b.b.b.a(this.f7902a, "o_cmn_biz_ui_web_err_refresh_normal_img.png", "o_cmn_biz_ui_web_err_refresh_press_img.png");
        aVar.setGravity(17);
        aVar.setText("刷新");
        aVar.setTextSize(2, 12.0f);
        aVar.setTextColor(Color.parseColor("#36ae9e"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f7902a, 52.67f), com.opos.cmn.an.h.f.a.a(this.f7902a, 23.33f));
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(3, 3);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f7902a, 37.67f);
        aVar.setOnClickListener(new a());
        this.h.addView(aVar, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, 1);
        this.f.addView(this.h, layoutParams4);
    }

    private void j() {
        ProgressBar progressBar = new ProgressBar(this.f7902a);
        this.j = progressBar;
        com.opos.cmn.biz.web.b.b.a.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.j.setIndeterminate(false);
        this.j.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#33cc9c")), 3, 1));
        this.j.setBackgroundColor(Color.parseColor("#cfcfcf"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f7902a, 1.33f));
        layoutParams.addRule(3, 1);
        this.f.addView(this.j, layoutParams);
    }

    private void k() {
        this.i.setOnClickListener(new ViewOnClickListenerC0661b());
        m();
        n();
        o();
        l();
        this.e.requestFocusFromTouch();
        this.e.requestFocus();
    }

    private void l() {
        Map<String, Object> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!com.opos.cmn.an.d.b.a(key) && value != null) {
                    com.opos.cmn.an.f.a.a("WebWidgetImpl", "addJavascriptInterface jsName=" + key + ",object=" + value);
                    this.e.addJavascriptInterface(value, key);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
        }
    }

    private void m() {
        WebSettings settings = this.e.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f7902a.getApplicationContext().getDir("database", 0).getPath());
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.e, true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(false);
    }

    private void n() {
        this.e.setWebChromeClient(new c());
    }

    private void o() {
        this.e.setWebViewClient(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.cmn.biz.web.b.a.a.b bVar = this.m;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void s() {
        if (this.e != null) {
            com.opos.cmn.an.f.a.a("WebWidgetImpl", "destoryWebView");
            this.e.removeAllViews();
            this.g.removeView(this.e);
            this.e.stopLoading();
            this.e.getSettings().setJavaScriptEnabled(false);
            this.e.clearHistory();
            this.e.clearCache(true);
            this.e.destroyDrawingCache();
            this.e.destroy();
            this.e = null;
        }
    }

    public View a() {
        return this.f;
    }

    public void d() {
        com.opos.cmn.an.f.a.a("WebWidgetImpl", "reInitWebView");
        s();
        h();
        k();
    }

    public boolean b() {
        RelativeLayout relativeLayout = this.h;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void c() {
        if (this.e != null) {
            com.opos.cmn.an.f.a.a("WebWidgetImpl", "closeWebView");
            s();
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.f = null;
            }
            this.f7902a = null;
        }
    }

    public boolean e() {
        WebView webView = this.e;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.e.goBack();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                com.opos.cmn.biz.web.b.a.a.a aVar = this.n;
                if (aVar != null) {
                    aVar.a(sslErrorHandler, sslError);
                } else if (this.f7902a instanceof Activity) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f7902a);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new e(this, sslErrorHandler));
                    builder.setNegativeButton("取消", new f(sslErrorHandler));
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setCancelable(false);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    alertDialogCreate.show();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        boolean z = false;
        if (!com.opos.cmn.an.d.b.a(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                Bundle bundleB = null;
                intent.setComponent(null);
                intent.setSelector(null);
                intent.addFlags(268435456);
                if (com.opos.cmn.an.h.d.a.a(this.f7902a, intent)) {
                    com.opos.cmn.biz.web.b.a.a.c cVar = this.o;
                    if (cVar != null && !cVar.b(str)) {
                        return false;
                    }
                    Map<String, Object> map = this.c;
                    Object obj = map != null ? map.get("activityExtraParams") : null;
                    if (obj instanceof com.opos.cmn.an.d.a) {
                        Bundle bundleB2 = com.opos.cmn.an.d.a.b(((com.opos.cmn.an.d.a) obj).a());
                        com.opos.cmn.an.f.a.a("WebWidgetImpl", "checkLaunchApp intentBundle:", bundleB2);
                        if (bundleB2 != null) {
                            intent.putExtras(bundleB2);
                        }
                    }
                    if (obj instanceof com.opos.cmn.an.d.a) {
                        bundleB = com.opos.cmn.an.d.a.b(((com.opos.cmn.an.d.a) obj).b());
                        com.opos.cmn.an.f.a.a("WebWidgetImpl", "checkLaunchApp optionsBundle:", bundleB);
                    }
                    if (bundleB != null) {
                        this.f7902a.startActivity(intent, bundleB);
                    } else {
                        this.f7902a.startActivity(intent);
                    }
                    com.opos.cmn.biz.web.b.a.a.c cVar2 = this.o;
                    if (cVar2 != null) {
                        cVar2.a(str);
                    }
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("checkLaunchApp url=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append("result=");
        sb.append(z);
        com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.toString());
        return z;
    }

    public void a(String str) {
        if (this.e == null || com.opos.cmn.an.d.b.a(str)) {
            return;
        }
        this.e.loadUrl(str);
        this.k = str;
    }
}

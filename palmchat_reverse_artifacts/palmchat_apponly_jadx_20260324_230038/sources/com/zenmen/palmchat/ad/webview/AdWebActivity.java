package com.zenmen.palmchat.ad.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.framework.R$attr;
import com.zenmen.palmchat.framework.R$dimen;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.is0;
import defpackage.m5;
import defpackage.me1;
import defpackage.sd3;
import org.apache.cordovaNew.CordovaActivity;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.engine.SystemWebView;
import org.apache.cordovaNew.engine.SystemWebViewClient;
import org.apache.cordovaNew.engine.SystemWebViewEngine;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdWebActivity extends CordovaActivity implements View.OnClickListener {
    public static String n = "AdWebActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12456a;
    public RelativeLayout b;
    public Toolbar c;
    public View d;
    public WebViewProgressBar e;
    public View h;
    public String[] j;
    public int[] k;
    public int f = -1;
    public int g = -1;
    public is0 i = new is0();
    public DownloadListener l = new c();
    public is0.f m = new h();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SystemWebViewClient {
        public a(SystemWebViewEngine systemWebViewEngine) {
            super(systemWebViewEngine);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Log.i(AdWebActivity.n, "onPageFinished");
            super.onPageFinished(webView, str);
            AdWebActivity.this.e.stop();
            if (TextUtils.isEmpty(AdWebActivity.this.c.getTitle())) {
                AdWebActivity.this.c.setTitle(webView.getTitle());
            }
            if (AdWebActivity.this.d.getVisibility() == 0) {
                AdWebActivity.this.c.setTitle("");
            }
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.i(AdWebActivity.n, "onPageStarted url= " + str);
            super.onPageStarted(webView, str, bitmap);
            AdWebActivity.this.e.start();
            AdWebActivity.this.d.setVisibility(8);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            Log.i(AdWebActivity.n, "shouldInterceptRequest url = " + str);
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.i(AdWebActivity.n, "shouldOverrideUrlLoading url = " + str);
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !str.startsWith(BaseConstants.SCHEME_HTTPS)) {
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdWebActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DownloadListener {
        public c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Log.i(AdWebActivity.n, "download url = " + str);
            Log.i(AdWebActivity.n, "userAgent = " + str2);
            Log.i(AdWebActivity.n, "contentDisposition = " + str3);
            Log.i(AdWebActivity.n, "mimetype = " + str4);
            Log.i(AdWebActivity.n, "contentLength = " + j);
            new sd3(AdWebActivity.this).O(R$string.alert_dialog_ok).j(R$string.ad_download_by_system_browser).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((SystemWebView) ((CordovaActivity) AdWebActivity.this).appView.getView()).reload();
            AdWebActivity adWebActivity = AdWebActivity.this;
            adWebActivity.d.setOnClickListener(adWebActivity);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdWebActivity.this.c.setTitle("");
            AdWebActivity.this.d.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends WebChromeClient {
        public f() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LogUtil.i(AdWebActivity.n, "onProgressChanged progress:" + i);
            AdWebActivity.this.e.setProgress((float) i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (AdWebActivity.this.d.getVisibility() == 0) {
                AdWebActivity.this.c.setTitle("");
            } else {
                AdWebActivity.this.c.setTitle(str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((CordovaActivity) AdWebActivity.this).appView != null) {
                LogUtil.d(AdWebActivity.n, "onMenuClick");
                AdWebActivity adWebActivity = AdWebActivity.this;
                adWebActivity.o(adWebActivity, adWebActivity.c, AdWebActivity.this.j, AdWebActivity.this.k, AdWebActivity.this.m, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements is0.f {
        public h() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            LogUtil.d(AdWebActivity.n, "onItemClicked index = " + i);
            if (i != 0) {
                return;
            }
            try {
                String url = AdWebActivity.this.f12456a;
                if (TextUtils.isEmpty(url)) {
                    url = ((CordovaActivity) AdWebActivity.this).appView.getUrl();
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.setFlags(268435456);
                intent.putExtra("com.android.browser.application_id", AdWebActivity.this.getPackageName());
                AdWebActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void createViews() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.b = relativeLayout;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.0f));
        j();
        this.c.setId(89);
        this.b.addView(this.c);
        h();
        this.e = new WebViewProgressBar(this, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) getResources().getDimension(R$dimen.web_page_progressbar_height));
        layoutParams.addRule(3, 89);
        this.b.addView(this.e, layoutParams);
        View viewInflate = getLayoutInflater().inflate(R$layout.layout_error_page, (ViewGroup) null);
        this.d = viewInflate;
        this.b.addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 89);
        this.d.setLayoutParams(layoutParams2);
        this.d.setClickable(true);
        this.d.setOnClickListener(this);
        this.b.setBackgroundColor(-1);
        setContentView(this.b);
        n(this.f);
        this.appView.getView().requestFocusFromTouch();
        i();
        this.h.bringToFront();
        m();
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        k(this.appView);
        systemWebView.setWebViewClient(new a((SystemWebViewEngine) this.appView.getEngine()));
    }

    public final void h() {
        Log.i(n, "addAppView");
        this.appView.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ViewParent parent = this.appView.getView().getParent();
        if (parent != null && parent != this.b) {
            Log.d(n, "removing appView from existing parent");
            ((ViewGroup) parent).removeView(this.appView.getView());
        }
        this.appView.getView().setDrawingCacheEnabled(true);
        ((SystemWebView) this.appView.getView()).setDownloadListener(this.l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 89);
        this.b.addView(this.appView.getView(), layoutParams);
    }

    public final void i() {
        this.h = View.inflate(this, R$layout.layout_adwebview_menu, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(me1.b(this, 24), me1.b(this, 19));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = me1.b(this, 12);
        layoutParams.topMargin = me1.b(this, 10);
        this.h.setLayoutParams(layoutParams);
        this.b.addView(this.h);
        ((ImageView) this.h.findViewById(R$id.ad_webview_more)).setOnClickListener(new g());
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void init() {
        super.init();
    }

    public final void j() {
        Toolbar toolbar = new Toolbar(this);
        this.c = toolbar;
        int i = this.g;
        if (i != -1) {
            toolbar.setTitleTextColor(i);
        }
        this.c.setTitle("");
        this.c.setMinimumHeight((int) getResources().getDimension(R$dimen.title_bar_height));
        this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        int i2 = R$attr.colorPrimary;
        theme.resolveAttribute(i2, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i3 = this.f;
        if (i3 != -1) {
            this.c.setBackgroundColor(i3);
        } else {
            this.c.setBackgroundColor(color);
        }
        this.c.setNavigationIcon(R$drawable.selector_arrow_back);
        this.c.setNavigationOnClickListener(new b());
    }

    public WebChromeClient k(CordovaWebView cordovaWebView) {
        return new f();
    }

    public final void l() {
        if (getIntent().getExtras() != null) {
            this.f12456a = getIntent().getExtras().getString("web_url", null);
        }
    }

    public final void m() {
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        systemWebView.removeJavascriptInterface("accessibility");
        systemWebView.removeJavascriptInterface("accessibilityTraversal");
        systemWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        systemWebView.getSettings().setSavePassword(false);
    }

    @TargetApi(21)
    public void n(int i) {
        me1.k(getWindow(), i);
    }

    public void o(Activity activity, View view, String[] strArr, int[] iArr, is0.f fVar, is0.h hVar) {
        this.i.d(activity, view, strArr, iArr, fVar, hVar, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2 = this.d;
        if (view == view2) {
            view2.setOnClickListener(null);
            this.appView.loadUrl("javascript:document.getElementsByTagName(\"body\")[0].innerHTML = \"\"");
            this.appView.getView().postDelayed(new d(), 300L);
        }
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        l();
        m5.c(this, bundle);
        super.onCreate(bundle);
        if (!TextUtils.isEmpty(this.f12456a)) {
            loadUrl(this.f12456a);
        }
        this.j = new String[]{getString(R$string.string_open_in_browser)};
        this.k = new int[]{R$drawable.icon_menu_open_browser};
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void onReceivedError(int i, String str, String str2) {
        LogUtil.d(n, "onReceivedError");
        runOnUiThread(new e());
    }
}

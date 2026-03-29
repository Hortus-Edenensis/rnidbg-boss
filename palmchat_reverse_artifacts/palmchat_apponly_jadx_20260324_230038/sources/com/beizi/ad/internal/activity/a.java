package com.beizi.ad.internal.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.c;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.internal.view.b;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.bq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements AdActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LinkedList<WebView> f4370a = new LinkedList<>();
    private Activity b;
    private WebView c;
    private ImageView d;
    private boolean e;
    private boolean f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;

    public a(Activity activity, boolean z, boolean z2, String str, int i) {
        this.b = activity;
        this.e = z;
        this.f = z2;
        this.g = str;
        this.j = i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.j && !this.h && !TextUtils.isEmpty(this.g)) {
                this.h = true;
                Uri uri = Uri.parse(this.g);
                if (uri.getScheme() == null || !uri.getScheme().equals("bzopen") || TextUtils.isEmpty(uri.getHost()) || uri.getPathSegments().size() <= 0) {
                    if (this.g.startsWith("hwpps://landingpage")) {
                        Intent intent = new Intent();
                        intent.setData(uri);
                        intent.addFlags(268435456);
                        this.b.startActivity(intent);
                        return;
                    }
                    if (this.g.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                        Intent uri2 = Intent.parseUri(this.g, 1);
                        uri2.addFlags(268435456);
                        this.b.startActivity(uri2);
                        return;
                    } else {
                        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                        intent2.addFlags(805339136);
                        this.b.startActivity(intent2);
                        return;
                    }
                }
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.MAIN");
                intent3.setFlags(268435456);
                intent3.addCategory("android.intent.category.LAUNCHER");
                String queryParameter = uri.getQueryParameter(bq.f.z);
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        if (queryParameter.startsWith("0x") || queryParameter.startsWith("0X")) {
                            intent3.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                        } else {
                            intent3.setFlags(Integer.parseInt(queryParameter));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                intent3.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
                String queryParameter2 = uri.getQueryParameter("rect");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        String[] strArrSplit = queryParameter2.split(":");
                        if (strArrSplit.length == 4) {
                            Rect rect = new Rect();
                            rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                            intent3.setSourceBounds(rect);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                this.b.startActivity(intent3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Activity activity = this.b;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView d() {
        return this.c;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
        WebView webView = this.c;
        if (webView == null) {
            return;
        }
        t.a(webView);
        this.c.destroy();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        m.a("lance", "...........................backPressed...........................");
        if (this.c.canGoBack()) {
            this.c.goBack();
            m.a("lance", " mWebView.goBack()");
        } else {
            f();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    @TargetApi(17)
    public void a() {
        this.b.setTheme(R.style.BeiZiTheme);
        this.b.setContentView(R.layout.activity_in_app_browser);
        WebView webViewPoll = f4370a.poll();
        this.c = webViewPoll;
        if (webViewPoll != null && webViewPoll.getSettings() != null) {
            if (this.c.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.c.getContext()).setBaseContext(this.b);
            }
            WebView webView = (WebView) this.b.findViewById(R.id.web_view);
            webView.getSettings().setSavePassword(false);
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(webView);
            viewGroup.removeView(webView);
            t.a(this.c);
            this.c.setLayoutParams(layoutParams);
            this.c.getSettings().setUseWideViewPort(true);
            this.c.getSettings().setLoadWithOverviewMode(true);
            this.c.getSettings().setJavaScriptEnabled(true);
            this.c.getSettings().setGeolocationEnabled(false);
            WebView.setWebContentsDebuggingEnabled(false);
            viewGroup.addView(this.c, iIndexOfChild);
            final ProgressBar progressBar = (ProgressBar) this.b.findViewById(R.id.progress_bar);
            try {
                if (this.j) {
                    this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.activity.a.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 0) {
                                return false;
                            }
                            a.this.i = true;
                            return false;
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.setDownloadListener(new DownloadListener() { // from class: com.beizi.ad.internal.activity.a.2
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                }
            });
            this.c.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.activity.a.3
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                    if (cookieSyncManager != null) {
                        cookieSyncManager.sync();
                    }
                    a.this.e();
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                    try {
                        Uri url = webResourceRequest.getUrl();
                        if (url == null) {
                            return false;
                        }
                        String string = url.toString();
                        if (!string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (a.this.b(string)) {
                                a.this.a(string);
                            }
                            return true;
                        }
                        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                        if (requestHeaders == null || requestHeaders.size() == 0) {
                            requestHeaders = new HashMap<>();
                        }
                        requestHeaders.put("X-Requested-With", "");
                        webView2.loadUrl(string, requestHeaders);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                    if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        return false;
                    }
                    if (!a.this.b(str)) {
                        return true;
                    }
                    a.this.a(str);
                    return true;
                }
            });
            this.c.setWebChromeClient(new b(this.b) { // from class: com.beizi.ad.internal.activity.a.4
                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return true;
                }

                @Override // com.beizi.ad.internal.view.b, android.webkit.WebChromeClient
                public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    if (callback != null) {
                        try {
                            callback.invoke(str, false, false);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    jsResult.confirm();
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i) {
                    if (i < 100 && progressBar.getVisibility() == 8) {
                        progressBar.setVisibility(0);
                    }
                    progressBar.setProgress(i);
                    if (i == 100) {
                        progressBar.setVisibility(8);
                    }
                }

                @Override // com.beizi.ad.internal.view.b, android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (view instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        if (frameLayout.getFocusedChild() instanceof VideoView) {
                            VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                            frameLayout.removeView(videoView);
                            if (a.this.c.getContext() instanceof Activity) {
                                ((Activity) a.this.c.getContext()).setContentView(videoView);
                            }
                            videoView.start();
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.b.findViewById(R.id.close_iv);
            this.d = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.f();
                }
            });
            return;
        }
        f();
    }

    private boolean c(String str) {
        List<String> listG = c.a().g();
        if (listG != null && listG.size() > 0) {
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return !c(str) || this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.j) {
            if (this.h && !this.i) {
                return;
            } else {
                this.h = true;
            }
        }
        Uri uri = n.a(str) ? null : Uri.parse(str);
        if (uri == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        try {
            this.b.startActivity(intent);
            c();
            f();
        } catch (Exception unused) {
        }
    }
}

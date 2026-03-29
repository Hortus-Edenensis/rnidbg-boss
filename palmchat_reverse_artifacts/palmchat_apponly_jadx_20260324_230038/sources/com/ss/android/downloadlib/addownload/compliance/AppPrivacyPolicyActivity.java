package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.t;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AppPrivacyPolicyActivity extends Activity {
    private long b;
    private long fx;
    private WebView nr;
    private String pn;
    private ImageView u;

    private void nr() {
        this.u = (ImageView) findViewById(R.id.iv_privacy_back);
        this.nr = (WebView) findViewById(R.id.privacy_webview);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.u("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.b);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.nr.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.nr.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean u(Uri uri) {
                String scheme = uri.getScheme();
                return (HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || BaseConstants.SCHEME_HTTPS.equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    t.u("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                t.u("System killed the WebView rendering process to reclaim memory. Recreating...");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return u(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return u(Uri.parse(str));
            }
        });
        u(this.nr);
        this.nr.setScrollBarStyle(0);
        this.nr.loadUrl(this.pn);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        x.u("lp_app_privacy_click_close", this.b);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (u()) {
            nr();
        } else {
            com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
        }
    }

    public static void u(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean u() {
        this.fx = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.nr.nr nrVarU = fx.u().u(this.fx);
        if (nrVarU == null) {
            return false;
        }
        this.b = nrVarU.nr;
        String str = nrVarU.f10589a;
        this.pn = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.pn = l.a().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void u(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}

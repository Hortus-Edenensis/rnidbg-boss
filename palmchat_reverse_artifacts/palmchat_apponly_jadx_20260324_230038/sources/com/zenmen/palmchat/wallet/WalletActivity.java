package com.zenmen.palmchat.wallet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.sdk.PushConsts;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.gi6;
import defpackage.hi6;
import defpackage.ii6;
import defpackage.ji6;
import defpackage.mt2;
import defpackage.qp3;
import defpackage.ve;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.apache.cordova.PluginManager;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class WalletActivity extends BaseActionBarActivity {
    public String A;
    public boolean B;
    public String C;
    public WebView q;
    public View r;
    public ProgressBar s;
    public ImageView t;
    public LocalBroadcastManager u;
    public boolean v = false;
    public String w;
    public hi6 x;
    public gi6 y;
    public ii6 z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements mt2.c {
        public a() {
        }

        @Override // mt2.c
        public void onSoftKeyboardStatusChanged(int i, int i2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletActivity.this.q.getLayoutParams();
            if (i == 0) {
                layoutParams.setMargins(0, 0, 0, i2);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            WalletActivity.this.q.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WalletActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WalletActivity walletActivity = WalletActivity.this;
            walletActivity.P1(walletActivity.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WalletActivity walletActivity = WalletActivity.this;
            walletActivity.P1(walletActivity.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends WebChromeClient {
        public g() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            WalletActivity.this.K1(str2);
            jsPromptResult.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            WalletActivity.this.s.setProgress(i);
            if (i == 100) {
                WalletActivity.this.s.setVisibility(8);
            }
        }
    }

    public static boolean R1(Context context, String str) {
        Intent uri;
        try {
            uri = Intent.parseUri(str, 1);
        } catch (URISyntaxException | Exception unused) {
        }
        if (context.getPackageManager().resolveActivity(uri, 0) == null) {
            return false;
        }
        if (context instanceof Activity) {
            return ((Activity) context).startActivityIfNeeded(uri, -1);
        }
        context.startActivity(uri);
        return true;
    }

    public void I1(String str) {
        getWindow().setBackgroundDrawable(new ColorDrawable(Q1(str)));
    }

    public String J1() {
        return this.A;
    }

    public final void K1(String str) {
        LogUtil.i("LxWallet", "handlerJSCall " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith("__jsapi__:")) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(str.indexOf("__jsapi__:") + 10));
                ji6.d(this, jSONObject.optString(ActionUtils.METHOD), jSONObject.optString("params"), jSONObject.optString(bq.f.L));
            } catch (JSONException e2) {
                LogUtil.e("LxWallet", e2);
            }
        }
    }

    public final void L1() {
        this.u = LocalBroadcastManager.getInstance(this);
        new IntentFilter().addAction("BROADCAST_WALLET_LOGIN_SUCCEED");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        ArrayList arrayList = new ArrayList();
        arrayList.add("/payment/v3/unifiedpay/authorize.htm");
        arrayList.add("/payment/v3/unifiedpay.htm");
        arrayList.add("/deposit/v3/receiveOrder.htm");
        arrayList.add("/withdraw/v3/withCharge.htm");
        arrayList.add("/trans/v3/cardTrans.htm");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void M1() {
        WebSettings settings = this.q.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(-1);
        settings.setSavePassword(false);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setTextZoom(100);
        settings.setUserAgentString(settings.getUserAgentString() + " peoplematch");
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        this.q.removeJavascriptInterface("accessibility");
        this.q.removeJavascriptInterface("accessibilityTraversal");
        this.q.removeJavascriptInterface("searchBoxJavaBridge_");
        this.q.setLongClickable(true);
        this.q.setHapticFeedbackEnabled(false);
        this.q.setOnLongClickListener(new e());
        settings.setMixedContentMode(0);
        this.q.setWebViewClient(new f());
        this.q.setWebChromeClient(new g());
    }

    public boolean N1(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            URL url = new URL(str);
            for (String str2 : PluginManager.JSSDK_WHITELIST) {
                if (url.getUserInfo() == null) {
                    String host = url.getHost();
                    if (host.endsWith("." + str2) || host.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public void O1(String str, String str2) {
        if (this.q == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.q.loadUrl("javascript:" + str + "()");
            return;
        }
        this.q.loadUrl("javascript:" + str + "('" + str2 + "')");
    }

    public void P1(String str) {
        this.w = str;
        this.q.loadUrl(str);
        this.q.setBackgroundColor(0);
    }

    public final int Q1(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("0x")) {
            try {
                return Integer.parseInt(str.substring(2), 16);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (!this.B || TextUtils.isEmpty(this.C)) {
            return;
        }
        qp3.a().b(this.C, Pair.create(-3, "点击返回关闭"));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.q.canGoBack()) {
            super.onBackPressed();
        } else {
            this.q.goBack();
            this.q.removeAllViews();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LogUtil.d("LxWallet", "onCreate");
        getWindow().requestFeature(1);
        super.onCreate(bundle);
        this.x = new hi6(this);
        this.y = new gi6(this);
        this.z = new ii6(this);
        this.B = getIntent().getBooleanExtra("isRechargeOnly", false);
        this.C = getIntent().getStringExtra("rechargeCallbackId");
        getWindow().setBackgroundDrawable(new ColorDrawable(Q1(getIntent().getStringExtra("bgColor"))));
        setContentView(R.layout.layout_people_match_wallet);
        this.q = (WebView) findViewById(R.id.webView);
        mt2.a(this, new a());
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.s = progressBar;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) progressBar.getLayoutParams();
        layoutParams.setMargins(0, a46.n(getApplicationContext()), 0, 0);
        this.s.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) findViewById(R.id.backBtn);
        this.t = imageView;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.setMargins(0, a46.n(getApplicationContext()), 0, 0);
        this.t.setLayoutParams(layoutParams2);
        this.t.setOnClickListener(new b());
        M1();
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        if (stringExtra.startsWith("https%3") || !stringExtra.startsWith("http%3") || stringExtra.startsWith("file%3")) {
            stringExtra = URLDecoder.decode(stringExtra);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.w = stringExtra;
        this.A = stringExtra;
        LogUtil.d("LxWallet", "loadUrl:" + stringExtra);
        P1(stringExtra);
        L1();
        initToolbar("");
        this.r = findViewById(R.id.errorView);
        findViewById(R.id.errorIv).setOnClickListener(new c());
        findViewById(R.id.refreshBtn).setOnClickListener(new d());
        this.x.q();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.x.onCancel();
        this.y.b();
        this.z.e();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.q.destroy();
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.q.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.q.goBack();
        this.q.removeAllViews();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WebView webView = this.q;
        if (webView == null) {
            return;
        }
        webView.loadUrl("javascript:(function(){if(resume) resume()})()");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.v) {
            this.v = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WalletActivity.this.s.setVisibility(8);
            WalletActivity.this.t.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WalletActivity.this.r.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (Build.VERSION.SDK_INT >= 23) {
                return;
            }
            WalletActivity.this.r.setVisibility(0);
            WalletActivity.this.t.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !str.startsWith("Http")) {
                WalletActivity walletActivity = WalletActivity.this;
                if (walletActivity.N1(walletActivity.A) && (ve.s(WalletActivity.this, str, false) || WalletActivity.R1(WalletActivity.this, str))) {
                    return true;
                }
            }
            WalletActivity.this.A = str;
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
                WalletActivity.this.r.setVisibility(8);
                WalletActivity.this.t.setVisibility(8);
            } else {
                WalletActivity.this.r.setVisibility(0);
                WalletActivity.this.t.setVisibility(0);
            }
        }
    }
}

package com.zenmen.palmchat.webplatform;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.hq3;
import defpackage.m5;
import defpackage.me1;
import defpackage.nl0;
import defpackage.om1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordovaNew.CordovaActivity;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.engine.SystemWebView;
import org.apache.cordovaNew.engine.SystemWebViewClient;
import org.apache.cordovaNew.engine.SystemWebViewEngine;
import org.apache.webplatform.jssdk.WebPlatformPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LyWebActivity extends CordovaActivity {
    public static String h = "LyWebActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15877a;
    public String b;
    public String c;
    public Bundle d;
    public ViewGroup e;
    public long f;
    public boolean g = true;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15881a;

        public c(String str) {
            this.f15881a = str;
            put("action", "loadMinApp");
            put("startLoad_time", Long.valueOf(LyWebActivity.this.f));
            put("endLoad_time", Long.valueOf(System.currentTimeMillis()));
            put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
            put("appId", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15882a;

        public d(String str) {
            this.f15882a = str;
            put("action", "loadMinApp");
            put("startLoad_time", Long.valueOf(LyWebActivity.this.f));
            put("endLoad_time", Long.valueOf(System.currentTimeMillis()));
            put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
            put("appId", str);
        }
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void createViews() {
        f();
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        j();
        StringBuilder sb = new StringBuilder(systemWebView.getSettings().getUserAgentString());
        String strC = nl0.c();
        if (strC.equals("release") && ac1.m.equals(ac1.r)) {
            strC = "pre";
        }
        sb.append(" uitype/");
        sb.append("green");
        sb.append(" serverType/");
        sb.append(strC);
        sb.append(" uiVersion/");
        sb.append(5);
        sb.append(" density/");
        sb.append(getResources().getDisplayMetrics().density);
        sb.append(" statusBarHeight/");
        sb.append(me1.h(this));
        systemWebView.getSettings().setUserAgentString(sb.toString());
        systemWebView.setWebViewClient(new a((SystemWebViewEngine) this.appView.getEngine()));
        systemWebView.setLongClickable(true);
        systemWebView.setHapticFeedbackEnabled(false);
        systemWebView.setOnLongClickListener(new b());
    }

    public final void f() {
        Log.i(h, "addAppView");
        this.appView.getView().setId(R$id.web_module_view);
        this.appView.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ViewParent parent = this.appView.getView().getParent();
        if (parent != null && parent != this.e) {
            Log.d(h, "removing appView from existing parent");
            ((ViewGroup) parent).removeView(this.appView.getView());
        }
        this.appView.getView().setDrawingCacheEnabled(true);
        this.e.addView(this.appView.getView());
    }

    public final String g(String str) {
        String string;
        Bundle bundle = this.d;
        if (bundle == null || bundle.size() <= 0) {
            string = str;
        } else {
            StringBuilder sb = new StringBuilder(str);
            if (str.endsWith("index.html") || str.endsWith("index.htm")) {
                sb.append(Constants.STRING_VALUE_UNSET);
            } else {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str2 : this.d.keySet()) {
                sb.append(str2);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(String.valueOf(this.d.get(str2)));
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.deleteCharAt(sb.length() - 1);
            string = sb.toString();
        }
        LogUtil.d(h, "url:" + str + " targetUrl:" + string);
        return string;
    }

    public final void h(String str) {
        this.f = System.currentTimeMillis();
        Cursor cursorQuery = getContentResolver().query(hq3.f18029a, null, "web_id=?", new String[]{str}, null);
        if (cursorQuery == null) {
            LogUtil.i(h, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new d(str), (Throwable) null);
            finish();
            return;
        }
        if (cursorQuery.moveToFirst()) {
            String strM = com.zenmen.palmchat.webplatform.b.m(cursorQuery.getString(cursorQuery.getColumnIndex("web_id")), cursorQuery.getInt(cursorQuery.getColumnIndex("version")));
            if (strM != null) {
                String strG = g(strM);
                this.f15877a = strG;
                loadUrl(strG);
            }
        } else {
            LogUtil.i(h, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(str), (Throwable) null);
            finish();
        }
        cursorQuery.close();
    }

    public final void i() {
        if (getIntent().getExtras() != null) {
            this.f15877a = getIntent().getExtras().getString("web_url", null);
            this.b = getIntent().getStringExtra("app_id");
            this.c = getIntent().getStringExtra("extra_url_extension");
            this.d = getIntent().getBundleExtra("Url_params");
        }
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void init() {
        CordovaPlugin plugin;
        super.init();
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (plugin = cordovaWebView.getPluginManager().getPlugin("webPlatform")) == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("extra_info");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String strOptString = jSONObject.optString("skey");
                String strOptString2 = jSONObject.optString("iv");
                if (om1.f() != null && om1.f().h() == null && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    om1.f().i(strOptString, strOptString2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ((WebPlatformPlugin) plugin).setExtraInfo(stringExtra);
    }

    public final void j() {
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        systemWebView.removeJavascriptInterface("accessibility");
        systemWebView.removeJavascriptInterface("accessibilityTraversal");
        systemWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        systemWebView.getSettings().setSavePassword(false);
    }

    @TargetApi(21)
    public void k(int i) {
        me1.k(getWindow(), i);
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        i();
        m5.c(this, bundle);
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.0f));
        setContentView(this.e);
        k(getResources().getColor(R$color.status_bar_color));
        if (TextUtils.isEmpty(this.f15877a)) {
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            h(this.b);
            return;
        }
        if (!TextUtils.isEmpty(this.c)) {
            this.f15877a += this.c;
        }
        String strG = g(this.f15877a);
        this.f15877a = strG;
        loadUrl(strG);
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SystemWebViewClient {

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.LyWebActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1132a extends HashMap<String, Object> {
            public C1132a() {
                put("action", "loadMinApp");
                put("startLoad_time", Long.valueOf(LyWebActivity.this.f));
                put("endLoad_time", Long.valueOf(System.currentTimeMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
                put("appId", LyWebActivity.this.b);
            }
        }

        public a(SystemWebViewEngine systemWebViewEngine) {
            super(systemWebViewEngine);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Log.i(LyWebActivity.h, "onPageFinished");
            super.onPageFinished(webView, str);
            if (LyWebActivity.this.g) {
                LyWebActivity.this.g = false;
                LogUtil.i(LyWebActivity.h, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1132a(), (Throwable) null);
            }
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.i(LyWebActivity.h, "onPageStarted");
            super.onPageStarted(webView, str, bitmap);
            LyWebActivity.this.f = System.currentTimeMillis();
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            Log.e("LyWebActivity", "onReceivedError" + i + " description=" + str + " failingUrl=" + str2);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            Log.i(LyWebActivity.h, "shouldInterceptRequest");
            if (str.contains(CordovaWebViewClient.ZX_LOCAL_RES)) {
                String str2 = com.zenmen.palmchat.webplatform.b.n().p(LyWebActivity.this) + File.separator + str.substring(str.indexOf(CordovaWebViewClient.ZX_LOCAL_RES) + 14);
                try {
                    Log.i(LyWebActivity.h, "shouldInterceptRequest, filePath = " + str2);
                    return new WebResourceResponse("application/javascript", "UTF-8", new FileInputStream(str2));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 23) {
                Log.e("LyWebActivity", ReportItem.LogTypeRequest + webResourceRequest.getUrl() + " error" + ((Object) webResourceError.getDescription()) + " " + webResourceError.getErrorCode());
            }
        }
    }
}

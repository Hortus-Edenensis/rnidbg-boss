package com.zenmen.palmchat.activity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import com.bytedance.bpea.entry.common.DataType;
import com.huawei.hms.framework.common.ContainerUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.a;
import com.zenmen.palmchat.activity.webview.widget.WebBannerView;
import com.zenmen.palmchat.browser.SRobotCompModel;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.route.share.a;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.WebViewProgressBar;
import com.zenmen.palmchat.widget.ZXWebView;
import defpackage.ad1;
import defpackage.dn0;
import defpackage.fo;
import defpackage.h05;
import defpackage.h13;
import defpackage.iq5;
import defpackage.is0;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.mu4;
import defpackage.qp3;
import defpackage.r75;
import defpackage.rl0;
import defpackage.rp2;
import defpackage.ru;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.tp2;
import defpackage.uj6;
import defpackage.zy4;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.cordova.Config;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.apache.cordova.jssdk.IPermissionCallbackPlugin;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CordovaWebActivity extends BaseActionBarActivity implements CordovaInterface, View.OnClickListener {
    public static String M0 = "CordovaWebActivity";
    public static int N0 = 0;
    public static int O0 = 1;
    public static int P0 = 2;
    public int A;
    public RelativeLayout A0;
    public Toolbar B0;
    public WebViewProgressBar C0;
    public View D0;
    public MenuItem E0;
    public boolean F;
    public String G;
    public String H0;
    public String I0;
    public WebBannerView K;
    public SRobotCompModel T;
    public com.zenmen.palmchat.activity.webview.a V;
    public CordovaWebView X;
    public String[] Z;
    public int[] e0;
    public int f0;
    public CordovaPlugin g0;
    public boolean h0;
    public IPermissionCallbackPlugin i0;
    public String n0;
    public CordovaPreferences o0;
    public Whitelist p0;
    public Whitelist q0;
    public String r0;
    public String s0;
    public boolean t;
    public String t0;
    public boolean u0;
    public ArrayList<PluginEntry> v0;
    public boolean x0;
    public boolean y0;
    public int z;
    public boolean z0;
    public r q = null;
    public int r = -1;
    public AtomicBoolean s = new AtomicBoolean(true);
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;
    public int H = -1;
    public int I = -1;
    public int J = 0;
    public boolean L = false;
    public long M = 0;
    public long N = 0;
    public long O = 0;
    public long P = 0;
    public float Q = 0.0f;
    public float R = 0.0f;
    public long S = 0;
    public h13 U = new h13();
    public DownloadListener W = new f();
    public int Y = 0;

    @Deprecated
    public int j0 = 0;

    @Deprecated
    public int k0 = -1;
    public int l0 = 20000;
    public boolean m0 = true;
    public ChatItem w0 = null;
    public boolean F0 = false;
    public Handler G0 = new p(this);
    public is0.f J0 = new h();
    public boolean K0 = false;
    public boolean L0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CordovaWebActivity.this.O > 0) {
                CordovaWebActivity.this.P += System.currentTimeMillis() - CordovaWebActivity.this.O;
                CordovaWebActivity.this.O = 0L;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends IceCreamCordovaWebViewClient {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SslError f12398a;

            public a(SslError sslError) {
                this.f12398a = sslError;
                put("action", "load_https");
                put("error", sslError.toString());
            }
        }

        public b(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LogUtil.i(CordovaWebActivity.M0, "onPageFinished url:" + str);
            CordovaWebActivity.this.H0 = str;
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            cordovaWebActivity.X.loadedUrl = str;
            cordovaWebActivity.C0.stop();
            CordovaWebActivity cordovaWebActivity2 = CordovaWebActivity.this;
            cordovaWebActivity2.U2(cordovaWebActivity2.X);
            if (TextUtils.isEmpty(CordovaWebActivity.this.B0.getTitle())) {
                CordovaWebActivity.this.B0.setTitle(webView.getTitle());
            }
            CordovaWebActivity cordovaWebActivity3 = CordovaWebActivity.this;
            cordovaWebActivity3.F0 = true;
            if (cordovaWebActivity3.D0.getVisibility() == 0) {
                CordovaWebActivity.this.B0.setTitle("");
            } else if (CordovaWebActivity.this.E0 != null) {
                CordovaWebActivity.this.E0.setEnabled(true);
            }
            CordovaWebActivity.this.U.j(str, CordovaWebActivity.this.D0.getVisibility() == 8);
            CordovaWebActivity.this.X2();
            CordovaWebActivity cordovaWebActivity4 = CordovaWebActivity.this;
            cordovaWebActivity4.V2(cordovaWebActivity4.X);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            CordovaWebActivity.this.W2();
            CordovaWebActivity.this.L2();
            CordovaWebActivity.this.C0.start();
            CordovaWebActivity.this.D0.setVisibility(8);
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            cordovaWebActivity.F0 = false;
            cordovaWebActivity.H0 = str;
            CordovaWebActivity.this.X.loadedUrl = str;
            LogUtil.i(CordovaWebActivity.M0, "onPageStarted url:" + str);
            CordovaWebActivity.this.j2(str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            LogUtil.i(CordovaWebActivity.M0, 3, new a(sslError), (Throwable) null);
            CordovaWebActivity.this.U.o(sslError.toString());
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                WebResourceResponse webResourceResponseB = new uj6().b(webView, webResourceRequest);
                if (webResourceResponseB != null) {
                    return webResourceResponseB;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends CordovaChromeClient {
        public c(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LogUtil.i(CordovaWebActivity.M0, "onProgressChanged progress:" + i);
            CordovaWebActivity.this.C0.setProgress((float) i);
            CordovaWebActivity.this.U.m(i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (CordovaWebActivity.this.D0.getVisibility() == 0) {
                CordovaWebActivity.this.B0.setTitle("");
            } else {
                CordovaWebActivity.this.B0.setTitle(str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12400a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(int i, String str, String str2) {
            this.f12400a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CordovaWebActivity.this.B0.setTitle("");
            CordovaWebActivity.this.D0.setVisibility(0);
            CordovaWebActivity.this.U.n(this.f12400a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DownloadListener {
        public f() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Log.i(CordovaWebActivity.M0, "download url = " + str);
            Log.i(CordovaWebActivity.M0, "userAgent = " + str2);
            Log.i(CordovaWebActivity.M0, "contentDisposition = " + str3);
            Log.i(CordovaWebActivity.M0, "mimetype = " + str4);
            Log.i(CordovaWebActivity.M0, "contentLength = " + j);
            CordovaWebActivity.this.M2(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12403a;

        public g(String str) {
            this.f12403a = str;
        }

        @Override // com.zenmen.palmchat.activity.webview.a.d
        public void a(ru ruVar) {
            r75.o(AppContext.getContext(), "sp_browser_ones", true);
            com.zenmen.palmchat.activity.webview.b.e(CordovaWebActivity.this, this.f12403a, ruVar.e(), ruVar.d());
        }

        @Override // com.zenmen.palmchat.activity.webview.a.d
        public void b(ru ruVar) {
            r75.o(AppContext.getContext(), "sp_browser_ones", false);
            com.zenmen.palmchat.activity.webview.b.e(CordovaWebActivity.this, this.f12403a, ruVar.e(), ruVar.d());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements is0.f {
        public h() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (CordovaWebActivity.this.u) {
                if (i == 0) {
                    CordovaWebActivity.this.X.reload();
                    return;
                }
                if (i != 1) {
                    return;
                }
                try {
                    String url = TextUtils.isEmpty(CordovaWebActivity.this.I0) ? CordovaWebActivity.this.r0 : CordovaWebActivity.this.I0;
                    if (TextUtils.isEmpty(url)) {
                        url = CordovaWebActivity.this.X.getUrl();
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                    intent.setFlags(268435456);
                    intent.putExtra("com.android.browser.application_id", CordovaWebActivity.this.getPackageName());
                    CordovaWebActivity.this.startActivity(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (i == 0) {
                CordovaWebActivity.this.P2(1);
                CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
                CordovaWebActivity.this.I2(cordovaWebActivity.U2(cordovaWebActivity.X), 2000L);
                return;
            }
            if (i == 1) {
                String url2 = CordovaWebActivity.this.X.getUrl();
                if (TextUtils.isEmpty(url2)) {
                    return;
                }
                ((ClipboardManager) CordovaWebActivity.this.getSystemService(DataType.CLIPBOARD)).setText(url2);
                sy5.e(CordovaWebActivity.this, R.string.string_copied_to_clipboard, 0).g();
                return;
            }
            if (i == 2) {
                CordovaWebActivity.this.X.reload();
                return;
            }
            if (i == 3) {
                CordovaWebActivity.this.k2();
                return;
            }
            if (i != 4) {
                return;
            }
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(CordovaWebActivity.this.X.getUrl()));
                intent2.setFlags(268435456);
                intent2.putExtra("com.android.browser.application_id", CordovaWebActivity.this.getPackageName());
                CordovaWebActivity.this.startActivity(intent2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("from", Integer.valueOf(CordovaWebActivity.this.A));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CordovaWebActivity.this.F0 && !l50.a()) {
                CordovaWebActivity.this.P2(0);
                CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
                CordovaWebActivity.this.I2(cordovaWebActivity.U2(cordovaWebActivity.X), 2000L);
                LogUtil.onClickEvent("N12", null, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements CordovaWebView.OnScrollChangeListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CordovaWebActivity.this.F0 && !l50.a()) {
                    CordovaWebActivity.this.P2(0);
                    CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
                    CordovaWebActivity.this.I2(cordovaWebActivity.U2(cordovaWebActivity.X), 2000L);
                    LogUtil.onClickEvent("N22", null, null);
                }
            }
        }

        public k() {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageEnd(int i, int i2, int i3, int i4) {
            LogUtil.d(CordovaWebActivity.M0, "onPageEnd");
            CordovaWebActivity.this.K.showBottomBanner(new a());
            if ("88888002".equals(CordovaWebActivity.this.s0) && rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEWSONEKFBOTTOM).isEnable() && !CordovaWebActivity.this.K0) {
                LogUtil.onClickEvent("N21", null, null);
                CordovaWebActivity.this.K0 = true;
            }
            if (CordovaWebActivity.this.A == h13.s && !CordovaWebActivity.this.L0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("fromuid", CordovaWebActivity.this.s0);
                    jSONObject.put("mid", CordovaWebActivity.this.t0);
                    jSONObject.put("url", CordovaWebActivity.this.I0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("read-end", null, jSONObject.toString());
                CordovaWebActivity.this.L0 = true;
            }
            CordovaWebActivity.this.X2();
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageTop(int i, int i2, int i3, int i4) {
            LogUtil.d(CordovaWebActivity.M0, "onPageTop");
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            LogUtil.d(CordovaWebActivity.M0, "onScrollChanged");
            CordovaWebActivity.this.X2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CordovaWebActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CordovaWebActivity.this.X.reload();
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            cordovaWebActivity.D0.setOnClickListener(cordovaWebActivity);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n {
        @JavascriptInterface
        public void checkBodySource(String str) {
            if (TextUtils.isEmpty(str)) {
                CordovaWebActivity.this.G0.sendEmptyMessage(1);
            }
        }

        @JavascriptInterface
        public void getIcon(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                Log.e(CordovaWebActivity.M0, "get icon pageSource is empty");
            } else {
                CordovaWebActivity.this.I2(CordovaWebActivity.this.s2(str, str2), 0L);
            }
        }

        public n() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements rp2 {
        @Override // defpackage.rp2
        public Intent a(Context context, rp2.a aVar) {
            int i;
            Intent intent = new Intent();
            if (aVar.f()) {
                LogUtil.i(CordovaWebActivity.M0, "buildWebViewLauncherIntent dialogMessage");
                intent.setClass(context, TransparentCordovaWebActivity.class);
                Bundle bundle = new Bundle();
                String strD = aVar.d();
                bundle.putString("web_url_origin", strD);
                bundle.putString("web_url", mu4.b(strD, new Map[0]));
                bundle.putString("page_index", ad1.l);
                bundle.putBoolean("extra_key_full_window", true);
                bundle.putBoolean("hide_progressbar", true);
                bundle.putSerializable("extra_key_feed_robot_info", (SRobotCompModel) aVar.b());
                intent.putExtras(bundle);
            } else {
                intent.setClass(context, CordovaWebActivity.class);
                Bundle bundle2 = new Bundle();
                String strD2 = aVar.d();
                bundle2.putString("web_url_origin", strD2);
                bundle2.putString("web_url", mu4.b(strD2, new Map[0]));
                bundle2.putBoolean("web_show_right_menu", aVar.e());
                bundle2.putInt("BackgroundColor", aVar.a());
                bundle2.putInt("from_source", aVar.c());
                bundle2.putSerializable("extra_key_feed_robot_info", (SRobotCompModel) aVar.b());
                String str = zy4.e(strD2).get("sourceType");
                if (TextUtils.isEmpty(str)) {
                    i = 600;
                    bundle2.putInt("sourceType", i);
                    intent.putExtras(bundle2);
                } else {
                    try {
                        i = Integer.parseInt(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        i = 600;
                    }
                    bundle2.putInt("sourceType", i);
                    intent.putExtras(bundle2);
                }
            }
            return intent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<CordovaWebActivity> f12412a;

        public p(CordovaWebActivity cordovaWebActivity) {
            this.f12412a = new WeakReference<>(cordovaWebActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CordovaWebActivity cordovaWebActivity = this.f12412a.get();
            if (cordovaWebActivity != null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    cordovaWebActivity.finish();
                    return;
                }
                r rVar = (r) message.obj;
                if (cordovaWebActivity.B0 != null && rVar != null && rVar.b != null) {
                    cordovaWebActivity.B0.setTitle(rVar.b);
                }
                if (cordovaWebActivity.s.get()) {
                    return;
                }
                cordovaWebActivity.S2(rVar);
                cordovaWebActivity.P2(-1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q {
        @JavascriptInterface
        public void onEnd() {
            LogUtil.d("logrobot", "video: onEnd");
            CordovaWebActivity.this.L2();
        }

        @JavascriptInterface
        public void onFound() {
            LogUtil.d("logrobot", "video: onFound");
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            if (cordovaWebActivity.B2(cordovaWebActivity.I0, CordovaWebActivity.this.H0)) {
                CordovaWebActivity.this.L = true;
            }
        }

        @JavascriptInterface
        public void onPause() {
            LogUtil.d("logrobot", "video: onPause");
            CordovaWebActivity.this.L2();
        }

        @JavascriptInterface
        public void onPlay(long j) {
            LogUtil.d("logrobot", "video: onPlay=" + j);
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            if (cordovaWebActivity.B2(cordovaWebActivity.I0, CordovaWebActivity.this.H0)) {
                CordovaWebActivity.this.O = System.currentTimeMillis();
                CordovaWebActivity.this.M = j;
            }
        }

        @JavascriptInterface
        public void onTimeUpdate(long j) {
            LogUtil.d("logrobot", "video: onTimeUpdate=" + j);
            CordovaWebActivity cordovaWebActivity = CordovaWebActivity.this;
            if (cordovaWebActivity.B2(cordovaWebActivity.I0, CordovaWebActivity.this.H0)) {
                CordovaWebActivity cordovaWebActivity2 = CordovaWebActivity.this;
                cordovaWebActivity2.N = Math.max(cordovaWebActivity2.N, j);
            }
        }

        public q() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12414a;
        public String b;

        public r() {
        }
    }

    public static String T2(String str) {
        if (str == null || str.equals("")) {
            LogUtil.i(M0, "toURLEncoded error:" + str);
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (Exception e2) {
            LogUtil.e(M0, "toURLEncoded error:" + str, e2);
            return "";
        }
    }

    public static void u2(Activity activity, boolean z, int i2, ChatItem chatItem, int i3) {
        v2(activity, i2, z ? 2 : 1, chatItem, i3);
    }

    public static void v2(Context context, int i2, int i3, ChatItem chatItem, int i4) {
        w2(context, i2, i3, chatItem, null, i4);
    }

    public static void w2(Context context, int i2, int i3, ChatItem chatItem, HashMap<String, String> map, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        String chatId = chatItem.getChatId();
        String str = tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=" + i2 + "&uidTo=" + chatId + "&type=" + i3 + "&from=" + i4;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
            }
        }
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putInt("sourceType", i2);
        bundle.putParcelable("contactInfoItem", chatItem);
        bundle.putString("uidTo", chatId);
        intent.putExtras(bundle);
        intent.addFlags(335544320);
        context.startActivity(intent);
        fo.a(i4);
    }

    public static void x2(Context context, int i2, String str, int i3, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=" + i2 + "&exidTo=" + str + "&type=" + i3 + "&from=" + i4);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putInt("sourceType", i2);
        ContactInfoItem contactInfoItemB = dn0.b(str);
        if (contactInfoItemB != null) {
            bundle.putParcelable("contactInfoItem", contactInfoItemB);
        }
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        fo.a(i4);
    }

    public static void y2(Context context, int i2, int i3, long j2, long j3, String str, String str2, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=" + i2 + "&type=" + i3 + "&feedId=" + j2 + "&commentId=" + j3 + "&exToUid=" + str + "&exidTo=" + str2 + "&from=" + i4);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putInt("sourceType", i2);
        ContactInfoItem contactInfoItemB = dn0.b(str2);
        if (contactInfoItemB != null) {
            bundle.putParcelable("contactInfoItem", contactInfoItemB);
        }
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        fo.a(i4);
    }

    public final void A2() {
        Toolbar toolbar = new Toolbar(this);
        this.B0 = toolbar;
        int i2 = this.I;
        if (i2 != -1) {
            toolbar.setTitleTextColor(i2);
        }
        if (this.J == 1) {
            this.B0.setTitleTextColor(-1);
        }
        this.B0.setTitle("");
        this.B0.setMinimumHeight((int) getResources().getDimension(R.dimen.title_bar_height));
        int iH = this.E ? 0 : me1.h(this);
        this.B0.setPadding(0, iH, 0, 0);
        this.B0.setLayoutParams(new ViewGroup.LayoutParams(-1, iH + me1.b(this, 48)));
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(typedValue.resourceId, new int[]{R.attr.colorPrimary});
        typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i3 = this.H;
        if (i3 != -1) {
            this.B0.setBackgroundColor(i3);
            setStatusBarColor(this.H);
        } else {
            this.B0.setBackgroundResource(R.drawable.ic_top_bg);
        }
        if (!this.w) {
            if (this.J == 1) {
                this.B0.setNavigationIcon(R.drawable.selector_arrow_back_light);
            } else {
                this.B0.setNavigationIcon(R.drawable.selector_arrow_back);
            }
            this.B0.setNavigationOnClickListener(new l());
        }
        setSupportActionBar(this.B0);
    }

    public final boolean B2(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        try {
            Uri uri = Uri.parse(str);
            Uri uri2 = Uri.parse(str2);
            String queryParameter = uri.getQueryParameter("newsId");
            String queryParameter2 = uri2.getQueryParameter("newsId");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return TextUtils.equals(queryParameter, queryParameter2);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean C2() {
        return this.A == h13.s;
    }

    public void D2() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(this);
        CordovaPreferences preferences = configXmlParser.getPreferences();
        this.o0 = preferences;
        preferences.setPreferencesBundle(getIntent().getExtras());
        this.p0 = configXmlParser.getInternalWhitelist();
        this.q0 = configXmlParser.getExternalWhitelist();
        this.r0 = configXmlParser.getLaunchUrl();
        this.v0 = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    public void E2(String str) {
        if (this.X == null) {
            try {
                init();
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        this.m0 = this.o0.getBoolean("KeepRunning", true);
        this.X.loadUrlIntoView(str, true);
    }

    public CordovaChromeClient F2(CordovaWebView cordovaWebView) {
        return new c(this, cordovaWebView);
    }

    public CordovaWebView G2() {
        return new ZXWebView(this);
    }

    public CordovaWebViewClient H2(CordovaWebView cordovaWebView) {
        return new b(this, cordovaWebView);
    }

    public final void I2(r rVar, long j2) {
        Message message = new Message();
        message.what = 0;
        message.obj = rVar;
        this.G0.removeMessages(0);
        if (rVar != null) {
            this.G0.sendMessageDelayed(message, 0L);
        } else {
            this.G0.sendMessageDelayed(message, j2);
        }
    }

    public void J2() {
        Bundle extras = getIntent().getExtras();
        Uri data = getIntent().getData();
        if (data != null) {
            LogUtil.uploadInfoImmediate("03", null, null, null);
            this.needCheckAccount = false;
            this.mNeedCheckAppIsBackground = false;
            this.r0 = data.toString();
            this.x0 = false;
            return;
        }
        if (extras != null) {
            try {
                if (getIntent().getExtras().getBoolean("from_out_web_url", false)) {
                    this.needCheckAccount = false;
                    this.mNeedCheckAppIsBackground = false;
                }
                this.r0 = getIntent().getExtras().getString("web_url", null);
                this.I0 = getIntent().getExtras().getString("web_url_origin", null);
                this.w0 = (ChatItem) extras.getParcelable("back_jump_chatItem");
                this.u0 = getIntent().getExtras().getBoolean("extra_key_from_ads", false);
                this.s0 = getIntent().getExtras().getString("extra_key_from_uid", null);
                this.t0 = getIntent().getExtras().getString("extra_key_mid", null);
                this.x0 = getIntent().getExtras().getBoolean("web_show_right_menu", true);
                this.y0 = getIntent().getExtras().getBoolean("extra_key_full_window", false);
                this.z0 = getIntent().getExtras().getBoolean("extra_key_override_status_bar", false);
                this.t = getIntent().getExtras().getBoolean("extra_use_light_status_bar", false);
                this.w = getIntent().getExtras().getBoolean("hide_close", false);
                this.v = getIntent().getExtras().getBoolean("disable_back_keycode", false);
                this.x = getIntent().getExtras().getBoolean("hide_progressbar", false);
                this.y = getIntent().getExtras().getBoolean("hide_toolbar", false);
                this.needCheckAccount = getIntent().getBooleanExtra("needCheckAccount", true);
                this.H = getIntent().getExtras().getInt("extra_key_top_bar_color", -1);
                this.I = getIntent().getExtras().getInt("extra_key_top_bar_text_color", -1);
                this.z = getIntent().getExtras().getInt("sourceType", -1);
                this.A = getIntent().getExtras().getInt("from_source", -1);
                this.C = getIntent().getExtras().getBoolean("extra_key_disable_text_zoom", false);
                this.B = getIntent().getExtras().getBoolean("extra_key_should_go_back", false);
                this.E = getIntent().getExtras().getBoolean("extra_key_not_set_status_bar", false);
                this.F = getIntent().getExtras().getBoolean("extra_key_sync_profile", false);
                this.G = getIntent().getStringExtra("K_RECHARGE_CALLBACK_ID");
                if (TextUtils.isEmpty(this.r0) || !tj2.m().equals(this.r0)) {
                    return;
                }
                this.B = true;
                this.E = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void K2(int i2, String str, String str2) {
        runOnUiThread(new d(i2, str, str2));
    }

    public final void L2() {
        if (B2(this.I0, this.H0)) {
            runOnUiThread(new a());
        }
    }

    public final void M2(String str) {
        boolean zD = r75.d(AppContext.getContext(), "sp_browser_ones", true);
        if (!com.zenmen.palmchat.activity.webview.b.d(str) && com.zenmen.palmchat.activity.webview.b.a(str) && !com.zenmen.palmchat.activity.webview.b.c(str)) {
            new sd3(this).O(R.string.alert_dialog_ok).j(R.string.download_by_system_browser).e().show();
            return;
        }
        if (zD) {
            this.V = com.zenmen.palmchat.activity.webview.b.g(this, str, new g(str));
            return;
        }
        String strI = r75.i(AppContext.getContext(), "sp_browser_pkg");
        String strI2 = r75.i(AppContext.getContext(), "sp_browser_class");
        if (com.zenmen.palmchat.activity.webview.b.b(AppContext.getContext(), strI, strI2)) {
            com.zenmen.palmchat.activity.webview.b.e(this, str, strI, strI2);
        } else {
            r75.o(AppContext.getContext(), "sp_browser_ones", true);
            M2(str);
        }
    }

    public void N2(String str, Object obj) {
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null) {
            cordovaWebView.postMessage(str, obj);
        }
    }

    public final void O2() {
        this.X.removeJavascriptInterface("accessibility");
        this.X.removeJavascriptInterface("accessibilityTraversal");
        this.X.removeJavascriptInterface("searchBoxJavaBridge_");
        this.X.getSettings().setSavePassword(false);
    }

    public void P2(int i2) {
        if (i2 == -1) {
            this.s.set(true);
            this.r = i2;
        } else {
            this.s.set(false);
            this.r = i2;
        }
    }

    public void Q2(IPermissionCallbackPlugin iPermissionCallbackPlugin) {
        this.i0 = iPermissionCallbackPlugin;
    }

    public void R2() {
        this.u = true;
        this.Z = new String[]{getString(R.string.string_refresh), getString(R.string.string_open_in_browser)};
        this.e0 = new int[]{R.drawable.icon_menu_refresh, R.drawable.icon_menu_open_browser};
    }

    public final void S2(r rVar) {
        if (rVar == null || rVar.f12414a == null) {
            ShareLinkBean shareLinkBean = new ShareLinkBean();
            shareLinkBean.setUrl(this.X.getUrl());
            com.zenmen.palmchat.route.share.a.e(shareLinkBean, new e());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", t2(rVar));
        intent.putExtra("android.intent.extra.TEXT", this.X.getUrl());
        intent.putExtra("android.intent.extra.shortcut.ICON", rVar.f12414a);
        intent.putExtra("extra_url", this.X.getUrl());
        intent.putExtra("extra_share_mode", 2);
        startActivity(intent);
    }

    public final r U2(CordovaWebView cordovaWebView) {
        r rVar = this.q;
        if (rVar != null) {
            return rVar;
        }
        cordovaWebView.loadUrl("javascript:window.IconGetter.getIcon(document.getElementsByTagName(\"head\")[0].innerHTML, \"" + cordovaWebView.getUrl() + "\")");
        return null;
    }

    public final void V2(CordovaWebView cordovaWebView) {
        if (this.T == null) {
            return;
        }
        cordovaWebView.loadUrl((((((((((((((((((((("javascript:var videos = document.getElementsByTagName('video');") + "var video = videos[videos.length-1];") + "if (video != undefined) {") + "window.VideoListener.onFound();") + "function video_play() {") + "window.VideoListener.onPlay(video.duration);") + "}") + "video.addEventListener('play', video_play);") + "function video_update() {") + "window.VideoListener.onTimeUpdate(video.currentTime);") + "}") + "video.addEventListener('timeupdate', video_update);") + "function video_pause() {") + "window.VideoListener.onPause();") + "}") + "video.addEventListener('pause', video_pause);") + "function video_ended() {") + "window.VideoListener.onEnd();") + "}") + "video.addEventListener('ended', video_ended);") + "}");
    }

    public final void W2() {
        LogUtil.d("logrobot", "originUrl: " + this.I0);
        LogUtil.d("logrobot", "complainUrl: " + this.H0);
        if (B2(this.I0, this.H0)) {
            this.S = Math.max(this.S, this.U.c() / 1000);
            LogUtil.d("logrobot", "updateReadPercent: lastMaxShowTime=" + this.S);
        }
    }

    public final void X2() {
        if (this.X != null && this.F0 && this.D0.getVisibility() == 8 && B2(this.I0, this.H0)) {
            if (this.A == h13.n) {
                float contentHeight = this.X.getContentHeight() * this.X.getScale();
                if (contentHeight <= 0.0f) {
                    return;
                }
                float height = this.X.getHeight();
                if (this.X.getScrollY() >= 0) {
                    height = this.X.getHeight() + this.X.getScrollY();
                }
                float f2 = height / contentHeight;
                if (contentHeight != this.Q) {
                    this.R = Math.min(1.0f, f2);
                } else {
                    this.R = Math.min(1.0f, Math.max(f2, this.R));
                }
                this.Q = contentHeight;
                LogUtil.d("logrobot", "updateReadPercent: webcontent=" + contentHeight + ", webnow=" + this.X.getHeight() + ", scroll=" + this.X.getScrollY());
            }
            LogUtil.d("logrobot", "updateReadPercent: precent=" + this.R);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.F) {
            LogUtil.d(M0, "startOperation when cordova finish");
            iq5.d().g(false, new String[0]);
        }
        if (!TextUtils.isEmpty(this.G)) {
            qp3.a().b(this.G, Pair.create(-3, "点击返回关闭"));
        }
        if (this.w0 != null) {
            this.needBack2MainTab = false;
            Intent intent = new Intent(getActivity(), (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", this.w0);
            intent.putExtra("thread_biz_type", this.w0.getBizType());
            k86.X(intent);
            startActivity(intent);
        }
        super.finish();
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 105;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return ZXWebView.getThreadPool();
    }

    public void init() {
        z2(this.X, null, null);
    }

    public final void j2(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("lx_back");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equalsIgnoreCase("pre")) {
            return;
        }
        this.B = true;
    }

    public final void k2() {
        if (this.z != -1) {
            String str = tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=" + this.z + "&type=4&toUrl=" + T2(this.H0) + "&from=999";
            LogUtil.i(M0, "complaint, url = " + str);
            Intent intent = new Intent();
            intent.setClass(getActivity(), CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            bundle.putInt("sourceType", this.z);
            bundle.putString("uidTo", AccountUtils.p(AppContext.getContext()));
            intent.putExtras(bundle);
            startActivity(intent);
            fo.a(999);
        }
    }

    public void l2() {
        this.X.setId(R.id.codova_webview);
        this.X.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        A2();
        this.B0.setId(99);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.A0 = relativeLayout;
        if (!this.y0 && !this.y) {
            relativeLayout.addView(this.B0);
        }
        ViewParent parent = this.X.getParent();
        if (parent != null && parent != this.A0) {
            LOG.d(M0, "removing appView from existing parent");
            ((ViewGroup) parent).removeView(this.X);
        }
        WebBannerView webBannerView = new WebBannerView(this);
        webBannerView.showTopBanner(new j());
        webBannerView.setId(101);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, 99);
        this.A0.addView(webBannerView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 101);
        this.A0.addView(this.X, layoutParams2);
        this.C0 = new WebViewProgressBar(this, null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.web_page_progressbar_height));
        layoutParams3.addRule(3, 99);
        if (!this.x) {
            this.A0.addView(this.C0, layoutParams3);
        }
        this.K = new WebBannerView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(12, -1);
        this.A0.addView(this.K, layoutParams4);
        this.X.setOnScrollChangeListener(new k());
        if (!"88888002".equals(this.s0) || this.u0) {
            webBannerView.setVisibility(8);
            this.K.setVisibility(8);
        } else {
            boolean zIsEnable = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEWSONEKFTOP).isEnable();
            boolean zIsEnable2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEWSONEKFBOTTOM).isEnable();
            if (zIsEnable) {
                LogUtil.onClickEvent("N11", null, null);
            }
            webBannerView.setVisibility(zIsEnable ? 0 : 8);
            this.K.setVisibility(zIsEnable2 ? 0 : 8);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_error_page, (ViewGroup) null);
        this.D0 = viewInflate;
        this.A0.addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, 99);
        this.D0.setLayoutParams(layoutParams5);
        this.D0.setClickable(true);
        this.D0.setOnClickListener(this);
        this.A0.setBackgroundColor(-1);
        this.X.setBackgroundColor(-1);
        setContentView(this.A0);
        this.X.requestFocusFromTouch();
    }

    @TargetApi(11)
    public final void m2() {
        this.X.removeJavascriptInterface("searchBoxJavaBridge_");
        this.X.removeJavascriptInterface("accessibility");
        this.X.removeJavascriptInterface("accessibilityTraversal");
    }

    public void n2() {
        this.Y = P0;
        super.finish();
    }

    public String o2() {
        return this.t0;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        LOG.e(M0, "Incoming Result. Request code = " + i2);
        super.onActivityResult(i2, i3, intent);
        CordovaPlugin plugin = this.g0;
        if (plugin == null && (str = this.n0) != null) {
            plugin = this.X.pluginManager.getPlugin(str);
        }
        this.n0 = null;
        this.g0 = null;
        if (plugin == null) {
            LOG.w(M0, "Got an activity result, but no plugin was registered to receive it.");
        } else {
            LOG.d(M0, "We have a callback to send this result to");
            plugin.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2 = this.D0;
        if (view == view2) {
            view2.setOnClickListener(null);
            this.X.loadUrl("javascript:document.getElementsByTagName(\"body\")[0].innerHTML = \"\"");
            this.X.postDelayed(new m(), 300L);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LOG.i(M0, "Apache Cordova native platform version 3.7.2 is starting");
        LOG.d(M0, "CordovaActivity.onCreate()");
        D2();
        J2();
        if (!this.o0.getBoolean("ShowTitle", false)) {
            getWindow().requestFeature(1);
        }
        if (this.z0) {
            me1.l(getWindow(), 0, true);
        } else if (this.o0.getBoolean("SetFullscreen", false)) {
            Log.d(M0, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
            getWindow().setFlags(1024, 1024);
        } else if (this.o0.getBoolean("Fullscreen", false) || this.y0) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().setFlags(2048, 2048);
        }
        super.onCreate(bundle);
        if (bundle != null) {
            this.n0 = bundle.getString("callbackClass");
        }
        this.Z = new String[]{getString(R.string.string_forward), getString(R.string.string_copy_url), getString(R.string.string_refresh), getString(R.string.string_complaint), getString(R.string.string_open_in_browser)};
        this.e0 = new int[]{R.drawable.icon_menu_forward, R.drawable.icon_menu_copy, R.drawable.icon_menu_refresh, R.drawable.icon_menu_complain, R.drawable.icon_menu_open_browser};
        if (this.A == h13.n) {
            this.T = (SRobotCompModel) getIntent().getSerializableExtra("extra_key_feed_robot_info");
        }
        this.U.h(this, this.r0, this.A, this.T);
        if (!TextUtils.isEmpty(this.r0)) {
            try {
                Uri uri = Uri.parse(this.r0);
                String queryParameter = uri.getQueryParameter("titleTextStyle");
                if (TextUtils.isEmpty(queryParameter)) {
                    String queryParameter2 = uri.getQueryParameter(com.umeng.ccg.a.F);
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        queryParameter = Uri.parse(queryParameter2).getQueryParameter("titleTextStyle");
                    }
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.J = Integer.parseInt(queryParameter);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            E2(this.r0);
            this.U.k(this.r0);
        }
        updateCurrentPageInfo(this, new i());
        if (this.t) {
            me1.r(getWindow(), false);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.x0) {
            N2("onCreateOptionsMenu", menu);
            if (menu != null) {
                this.E0 = menu.add(0, 1, 0, R.string.string_more).setIcon(R.drawable.actionbar_icon_more).setTitle(R.string.string_more).setShowAsActionFlags(2).setEnabled(true);
                return true;
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        List<String> list;
        LOG.d(M0, "CordovaActivity.onDestroy()");
        super.onDestroy();
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null) {
            cordovaWebView.resumeTimers();
            this.X.handleDestroy();
            this.X.stopLoading();
            this.A0.removeView(this.X);
            this.X.removeAllViews();
            this.X.destroy();
        } else {
            this.Y = P0;
        }
        this.U.i();
        SRobotCompModel sRobotCompModel = this.T;
        if (sRobotCompModel == null || (list = sRobotCompModel.exitUrl) == null) {
            return;
        }
        for (String str : list) {
            int i2 = (int) (this.R * 100.0f);
            long jMax = Math.max(this.S, this.U.j / 1000);
            if (this.L) {
                long j2 = this.M;
                if (j2 > 0) {
                    i2 = (int) ((this.N * 100.0f) / j2);
                    jMax = this.P / 1000;
                } else {
                    i2 = 0;
                    jMax = 0;
                }
            }
            h05.h(str, i2, jMax);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null && cordovaWebView.getFocusedChild() != null && (i2 == 4 || i2 == 82)) {
            return this.X.onKeyDown(i2, keyEvent);
        }
        if (i2 == 4 && this.v) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        View view;
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null && ((cordovaWebView.isCustomViewShowing() || this.X.getFocusedChild() != null) && (i2 == 4 || i2 == 82))) {
            return this.X.onKeyUp(i2, keyEvent);
        }
        if (i2 == 4 && (view = this.D0) != null && view.getVisibility() != 0) {
            this.X.loadUrl("javascript:window.IconGetter.checkBodySource(document.getElementsByTagName(\"body\")[0].innerHTML)");
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!"onScrollChanged".equals(str)) {
            LOG.d(M0, "onMessage(" + str + "," + obj + ")");
        }
        if (!"onReceivedError".equals(str)) {
            if (!com.alipay.sdk.m.x.d.z.equals(str)) {
                return null;
            }
            n2();
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            K2(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString("url"));
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null) {
            cordovaWebView.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        CordovaWebView cordovaWebView;
        N2("onOptionsItemSelected", menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            Toolbar toolbar = this.B0;
            if (toolbar != null) {
                showPopupMenu(this, toolbar, this.Z, this.e0, this.J0, null);
            }
        } else if (itemId == 16908332 && (!this.B || (cordovaWebView = this.X) == null || !cordovaWebView.backHistory())) {
            finish();
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        CordovaWebView cordovaWebView;
        super.onPause();
        this.U.l();
        LOG.d(M0, "Paused the application!");
        if (this.Y == P0 || (cordovaWebView = this.X) == null) {
            return;
        }
        cordovaWebView.handlePause(this.m0);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        IPermissionCallbackPlugin iPermissionCallbackPlugin = this.i0;
        if (iPermissionCallbackPlugin != null) {
            iPermissionCallbackPlugin.onPermissionDenied(permissionType, permissionUsage);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        IPermissionCallbackPlugin iPermissionCallbackPlugin = this.i0;
        if (iPermissionCallbackPlugin != null) {
            iPermissionCallbackPlugin.onPermissionGrant(permissionType, permissionUsage, z);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        N2("onPrepareOptionsMenu", menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        CordovaWebView cordovaWebView;
        CordovaWebView cordovaWebView2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        CordovaWebView cordovaWebView3 = this.X;
        if (cordovaWebView3 != null) {
            try {
                cordovaWebView3.onRequestPermissionResult(i2, strArr, iArr);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (i2 == 567834 && (cordovaWebView2 = this.X) != null && cordovaWebView2.getWebChromeClient() != null) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                this.X.getWebChromeClient().cancelShowingCamera();
                return;
            } else {
                this.X.getWebChromeClient().showCamera();
                return;
            }
        }
        if (i2 != 567835 || iArr == null || iArr.length != 2 || (cordovaWebView = this.X) == null || cordovaWebView.getWebChromeClient() == null) {
            return;
        }
        this.X.getWebChromeClient().grantRecordAudio();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean z;
        super.onResume();
        this.U.p();
        LOG.d(M0, "Resuming the App");
        if (this.Y == N0) {
            this.Y = O0;
            return;
        }
        if (this.X == null) {
            return;
        }
        getWindow().getDecorView().requestFocus();
        this.X.handleResume(this.m0, this.h0);
        if ((!this.m0 || this.h0) && (z = this.h0)) {
            this.m0 = z;
            this.h0 = false;
        }
        com.zenmen.palmchat.activity.webview.a aVar = this.V;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.V.h();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CordovaPlugin cordovaPlugin = this.g0;
        if (cordovaPlugin != null) {
            bundle.putString("callbackClass", cordovaPlugin.getClass().getName());
        }
    }

    public String p2() {
        return this.s0;
    }

    public String q2() {
        return this.I0;
    }

    public String r2() {
        return this.G;
    }

    public final r s2(String str, String str2) {
        r rVar = new r();
        synchronized (r.class) {
            if (this.q == null) {
                String strE = tp2.e(str, str2);
                String strJ = tp2.j(str, str2);
                if (strE != null && strJ != null) {
                    rVar.f12414a = strE;
                    rVar.b = strJ;
                    this.q = rVar;
                }
            }
        }
        r rVar2 = this.q;
        if (rVar2 != null) {
            return rVar2;
        }
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        CordovaPlugin cordovaPlugin2 = this.g0;
        if (cordovaPlugin2 != null) {
            cordovaPlugin2.onActivityResult(this.f0, 0, null);
        }
        this.g0 = cordovaPlugin;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void setStatusBarColor() {
        if (this.E) {
            return;
        }
        super.setStatusBarColor();
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i2) {
        setActivityResultCallback(cordovaPlugin);
        this.h0 = this.m0;
        if (cordovaPlugin != null) {
            this.m0 = false;
        }
        try {
            startActivityForResult(intent, i2);
        } catch (RuntimeException e2) {
            this.g0 = null;
            throw e2;
        }
    }

    public String t2(r rVar) {
        return (rVar == null || rVar.b == null) ? this.X.getTitle() : (this.X.getUrl() == null || !this.X.getUrl().equals(this.X.getTitle())) ? this.X.getTitle() : rVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    @Deprecated
    public void z2(CordovaWebView cordovaWebView, CordovaWebViewClient cordovaWebViewClient, CordovaChromeClient cordovaChromeClient) {
        LOG.d(M0, "CordovaActivity.init()");
        int i2 = this.k0;
        if (i2 >= 0) {
            this.o0.set("SplashScreenDelay", i2);
        }
        int i3 = this.j0;
        if (i3 != 0) {
            this.o0.set("SplashDrawableId", i3);
        }
        if (cordovaWebView == null) {
            cordovaWebView = G2();
        }
        this.X = cordovaWebView;
        O2();
        this.X.addJavascriptInterface(new n(), "IconGetter");
        this.X.addJavascriptInterface(new q(), "VideoListener");
        m2();
        this.X.setDownloadListener(this.W);
        this.X.getSettings().setCacheMode(2);
        this.X.getSettings().setTextZoom(100);
        this.X.setScrollBarStyle(33554432);
        this.X.setVerticalScrollBarEnabled(true);
        this.X.setScrollBarSize((int) getResources().getDimension(R.dimen.webview_scrollbar_size));
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.X);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, getResources().getDrawable(R.drawable.webview_scrollbar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.o0.getBoolean("DisallowOverscroll", false)) {
            this.X.setOverScrollMode(2);
        }
        l2();
        CordovaWebView cordovaWebView2 = this.X;
        if (cordovaWebView2.pluginManager == null) {
            if (cordovaWebViewClient == null) {
                cordovaWebViewClient = H2(cordovaWebView2);
            }
            CordovaWebViewClient cordovaWebViewClient2 = cordovaWebViewClient;
            if (cordovaChromeClient == null) {
                cordovaChromeClient = F2(this.X);
            }
            cordovaWebView2.init(this, cordovaWebViewClient2, cordovaChromeClient, this.v0, this.p0, this.q0, this.o0);
        }
        if ("media".equals(this.o0.getString("DefaultVolumeStream", "").toLowerCase(Locale.ENGLISH))) {
            setVolumeControlStream(3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        this.f0 = i2;
        try {
            super.startActivityForResult(intent, i2, bundle);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a.e {
        public e() {
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void a(ShareLinkBean shareLinkBean) {
            Intent intent = new Intent(CordovaWebActivity.this, (Class<?>) SendMessageActivity.class);
            intent.setAction("android.intent.action.SEND");
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            intent.putExtra("android.intent.extra.SUBJECT", CordovaWebActivity.this.t2(null));
            intent.putExtra("android.intent.extra.TEXT", CordovaWebActivity.this.X.getUrl());
            intent.putExtra("android.intent.extra.shortcut.ICON", shareLinkBean.getIcon());
            intent.putExtra("extra_url", CordovaWebActivity.this.X.getUrl());
            intent.putExtra("extra_share_mode", 2);
            CordovaWebActivity.this.startActivity(intent);
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void onStart() {
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public Activity getActivity() {
        return this;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showPermissionDenyDialog(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
    }
}

package com.zenmen.openapi.webapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.openapi.webapp.floatview.RemainTimeFloat;
import com.zenmen.openapi.webapp.widget.ProgressBar;
import com.zenmen.openapi.webapp.widget.WebAppActionBar;
import com.zenmen.palmchat.R;
import defpackage.a46;
import defpackage.ah;
import defpackage.ei0;
import defpackage.f84;
import defpackage.g84;
import defpackage.ka3;
import defpackage.ma3;
import defpackage.oa3;
import defpackage.om4;
import defpackage.pa3;
import defpackage.pm5;
import defpackage.qa3;
import defpackage.tn2;
import defpackage.vw5;
import defpackage.wn6;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.Config;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WebViewFragment extends Fragment implements CordovaInterface, View.OnClickListener {
    public double A;
    public double B;
    public double C;
    public double E;
    public om4 F;
    public CordovaWebView d;
    public View e;
    public CordovaPreferences f;
    public Whitelist g;
    public Whitelist h;
    public String i;
    public String j;
    public ArrayList<PluginEntry> k;
    public final ExecutorService l = vw5.a(WebViewFragment.class.getSimpleName());
    public int m;
    public CordovaPlugin n;
    public ProgressBar o;
    public WebAppActionBar p;
    public ah q;
    public MainActivity r;
    public oa3 s;
    public pa3 t;
    public qa3 u;
    public JSONObject v;
    public wn6 w;
    public RemainTimeFloat x;
    public double y;
    public double z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewFragment.this.e.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnTouchListener {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                WebViewFragment.this.y = rawX;
                WebViewFragment.this.z = rawY;
            } else if (action == 1) {
                WebViewFragment.this.c0();
            } else if (action == 2) {
                WebViewFragment.this.u0(rawX - WebViewFragment.this.y, rawY - WebViewFragment.this.z);
                WebViewFragment.this.y = rawX;
                WebViewFragment.this.z = rawY;
            } else if (action == 3) {
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends IceCreamCordovaWebViewClient {
        public d(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ma3.a("onPageFinished url:" + str, new Object[0]);
            WebViewFragment.this.o.stop();
            WebViewFragment.this.d.loadedUrl = str;
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ma3.a("onPageStarted url:" + str, new Object[0]);
            WebViewFragment.this.e.setVisibility(8);
            WebViewFragment.this.o.start();
            WebViewFragment.this.d.loadedUrl = str;
            WebViewFragment.this.A0();
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends CordovaChromeClient {
        public e(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // org.apache.cordova.CordovaChromeClient, android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.cancel();
            return true;
        }

        @Override // org.apache.cordova.CordovaChromeClient, android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.cancel();
            return true;
        }

        @Override // org.apache.cordova.CordovaChromeClient, android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            try {
                String strPromptOnJsPrompt = this.appView.getBridge().promptOnJsPrompt(str, str2, str3);
                if (strPromptOnJsPrompt != null) {
                    jsPromptResult.confirm(strPromptOnJsPrompt);
                    return true;
                }
                jsPromptResult.cancel();
                return true;
            } catch (Exception unused) {
                ma3.d("handle js prompt err");
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            ma3.a("onProgressChanged progress:" + i, new Object[0]);
            WebViewFragment.this.o.setProgress((float) i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements om4.d {
        public f() {
        }

        @Override // om4.d
        public void onCancel() {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.finishAndRemoveTask();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ wn6 f12043a;

            public a(wn6 wn6Var) {
                this.f12043a = wn6Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null) {
                    return;
                }
                WebViewFragment.this.x0(this.f12043a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12044a;

            public b(boolean z) {
                this.f12044a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null) {
                    return;
                }
                WebViewFragment.this.r.d2(this.f12044a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null) {
                    return;
                }
                WebViewFragment.this.r.m2();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12046a;

            public d(String str) {
                this.f12046a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null || WebViewFragment.this.p == null) {
                    return;
                }
                WebViewFragment.this.p.setActionBarTitle(this.f12046a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12047a;

            public e(boolean z) {
                this.f12047a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null) {
                    return;
                }
                WebViewFragment.this.r.c2(this.f12047a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12048a;

            public f(boolean z) {
                this.f12048a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null) {
                    return;
                }
                WebViewFragment.this.r.e2(this.f12048a);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.openapi.webapp.WebViewFragment$g$g, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0945g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12049a;

            public RunnableC0945g(boolean z) {
                this.f12049a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WebViewFragment.this.r == null || WebViewFragment.this.d == null) {
                    return;
                }
                WebViewFragment.this.d.setKeepScreenOn(this.f12049a);
            }
        }

        @JavascriptInterface
        public void setActionBarTitle(String str) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new d(str));
        }

        @JavascriptInterface
        public void setKeepScreenOn(boolean z) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new RunnableC0945g(z));
        }

        @JavascriptInterface
        public void setLandScape(boolean z) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new f(z));
        }

        @JavascriptInterface
        public void setWindowStyle(String str) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new a(wn6.g(str)));
        }

        @JavascriptInterface
        public void showBottomMenuBox() {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new c());
        }

        @JavascriptInterface
        public void showFloatIcon(boolean z) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new e(z));
        }

        @JavascriptInterface
        public void showFloatMenu(boolean z) {
            if (WebViewFragment.this.r == null) {
                return;
            }
            WebViewFragment.this.r.runOnUiThread(new b(z));
        }

        public g() {
        }
    }

    public final void A0() {
        View view = getView();
        if (view instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int childCount = relativeLayout.getChildCount();
            ArrayList arrayList = new ArrayList();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    View childAt = relativeLayout.getChildAt(i);
                    if (childAt.getTag(R.id.tag_adtype) instanceof Integer) {
                        arrayList.add(childAt);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    relativeLayout.removeView((View) it.next());
                }
            }
        }
    }

    public final void B0() {
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.removeJavascriptInterface("accessibility");
            this.d.removeJavascriptInterface("accessibilityTraversal");
            this.d.removeJavascriptInterface("searchBoxJavaBridge_");
            this.d.getSettings().setSavePassword(false);
        }
    }

    public final void T(wn6 wn6Var) {
        if (this.r == null) {
            return;
        }
        W(wn6Var);
        WebAppActionBar webAppActionBar = this.p;
        if (webAppActionBar != null) {
            webAppActionBar.setVisibility(0);
            this.p.setBackgroundColor(wn6Var.b());
            this.p.setBlackStyle(wn6Var.a().equals("#000000"));
        }
    }

    public final void V(wn6 wn6Var) {
        MainActivity mainActivity = this.r;
        if (mainActivity == null) {
            return;
        }
        a46.z(mainActivity.getWindow(), wn6Var.a().equals("#ffffff"));
        this.r.f2(wn6Var);
        WebAppActionBar webAppActionBar = this.p;
        if (webAppActionBar != null) {
            webAppActionBar.setVisibility(8);
        }
    }

    public final void W(wn6 wn6Var) {
        MainActivity mainActivity = this.r;
        if (mainActivity == null) {
            return;
        }
        a46.B(mainActivity.getWindow(), wn6Var.a().equals("#ffffff"), wn6Var.b());
        this.r.f2(wn6Var);
        WebAppActionBar webAppActionBar = this.p;
        if (webAppActionBar != null) {
            webAppActionBar.setVisibility(8);
        }
    }

    public final void Y(wn6 wn6Var) {
        MainActivity mainActivity = this.r;
        if (mainActivity == null) {
            return;
        }
        mainActivity.f2(wn6Var);
        WebAppActionBar webAppActionBar = this.p;
        if (webAppActionBar != null) {
            webAppActionBar.setVisibility(8);
        }
        this.r.h2();
    }

    public final View Z(LayoutInflater layoutInflater) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_openapi_webview, (ViewGroup) null);
        this.p = (WebAppActionBar) relativeLayout.findViewById(R.id.rl_openapi_actionbar);
        View viewFindViewById = relativeLayout.findViewById(R.id.rl_webapp_error);
        this.e = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.e.setVisibility(8);
        this.d = (CordovaWebView) relativeLayout.findViewById(R.id.openapi_webapp_view);
        B0();
        this.o = (ProgressBar) relativeLayout.findViewById(R.id.openapi_webapp_progressbar);
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView.pluginManager == null) {
            cordovaWebView.init(this, t0(cordovaWebView), s0(this.d), this.k, this.g, this.h, this.f);
            m0();
            this.d.addJavascriptInterface(new g(), "LxUIWindow");
        }
        this.d.setOnScrollChangeListener(new b());
        RemainTimeFloat remainTimeFloat = (RemainTimeFloat) relativeLayout.findViewById(R.id.lx_webapp_float_timeremain);
        this.x = remainTimeFloat;
        remainTimeFloat.setVisibility(8);
        l0();
        return relativeLayout;
    }

    public final void c0() {
        Point pointM = a46.m(this.x.getContext());
        int iB = a46.b(this.x.getContext(), 70.0f);
        this.B = iB - this.x.getTop();
        int height = pointM.y;
        int width = pointM.x;
        if (this.x.getParent() instanceof ViewGroup) {
            height = ((ViewGroup) this.x.getParent()).getHeight();
            width = ((ViewGroup) this.x.getParent()).getWidth();
        }
        this.A = (height - this.x.getBottom()) - iB;
        int iB2 = a46.b(this.x.getContext(), 14.0f);
        this.E = iB2 - this.x.getLeft();
        this.C = (width - this.x.getRight()) - iB2;
        double translationY = this.x.getTranslationY();
        double translationX = this.x.getTranslationX();
        double d2 = this.B;
        if (translationY < d2) {
            this.x.setTranslationY((float) d2);
        } else {
            double d3 = this.A;
            if (translationY > d3) {
                this.x.setTranslationY((float) d3);
            }
        }
        double d4 = this.E;
        if (translationX < d4) {
            this.x.setTranslationX((float) d4);
            return;
        }
        double d5 = this.C;
        if (translationX > d5) {
            this.x.setTranslationX((float) d5);
        }
    }

    public ka3.b e0() {
        CordovaWebView cordovaWebView = this.d;
        return cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
    }

    @Override // org.apache.cordova.CordovaInterface
    @Nullable
    /* JADX INFO: renamed from: getActivity */
    public /* bridge */ /* synthetic */ Activity getOwnerActivity2() {
        return super.getActivity();
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return this.j;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return this.i;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return this.l;
    }

    public CordovaWebView h0() {
        return this.d;
    }

    public ah j0() {
        return this.q;
    }

    public wn6 k0() {
        return this.w;
    }

    public final void l0() {
        this.x.setOnTouchListener(new c());
    }

    public final void m0() {
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            this.d.getSettings().setUserAgentString(ei0.a(cordovaWebView, "lx-webapp"));
        }
    }

    public final void n0(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("windowStyle");
            if (string == null) {
                this.w = new wn6();
            } else {
                try {
                    this.w = wn6.g(new String(Base64.decode(URLDecoder.decode(string, "UTF-8"), 0)));
                } catch (Exception e2) {
                    ma3.c(e2);
                }
            }
        }
        if (this.w == null) {
            this.w = new wn6();
        }
        x0(this.w);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CordovaPlugin cordovaPlugin = this.n;
        if (cordovaPlugin != null) {
            cordovaPlugin.onActivityResult(i, i2, intent);
            this.n = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.rl_webapp_error) {
            y0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.r = (MainActivity) getActivity();
        r0();
        this.r.W1(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.j = getArguments().getString("appId");
        this.i = getArguments().getString("url");
        View viewZ = Z(layoutInflater);
        this.s = new oa3(getClass().getSimpleName());
        this.t = new pa3(getClass().getSimpleName());
        this.u = new qa3(getClass().getSimpleName());
        String string = getArguments().getString("scene");
        n0(getArguments());
        this.v = new JSONObject();
        if (TextUtils.isEmpty(this.j)) {
            this.j = "unKnow";
            try {
                this.v.put("url", this.i);
            } catch (JSONException e2) {
                ma3.c(e2);
            }
        }
        ah ahVarC = ah.c(this.j, string);
        this.q = ahVarC;
        ahVarC.f = this.v.toString();
        tn2 tn2Var = (tn2) g84.a(tn2.class);
        if (tn2Var != null && tn2Var.isEnable()) {
            String strB = tn2Var.b(this.j);
            if (!TextUtils.isEmpty(strB)) {
                File file = new File(strB);
                if (file.exists() && file.isDirectory()) {
                    this.q.l = true;
                }
            }
        }
        f84.e(this.q, "open");
        this.d.loadUrlIntoView(this.i, true);
        return viewZ;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            this.v.put("dura", this.s.b());
            this.v.put("duraB", this.t.b());
            this.v.put("duraC", this.u.b());
        } catch (JSONException e2) {
            ma3.c(e2);
        }
        this.q.f = this.v.toString();
        f84.e(this.q, com.alipay.sdk.m.x.d.z);
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.resumeTimers();
            this.d.handleDestroy();
            this.d.stopLoading();
            this.d.removeAllViews();
            this.d.destroy();
        }
        this.r.n2(this);
        this.r = null;
        om4 om4Var = this.F;
        if (om4Var != null) {
            om4Var.h();
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onGrantSuccess(ka3.b bVar) {
        MainActivity mainActivity;
        if (!p0(bVar) || bVar.d != 5 || (mainActivity = this.r) == null || mainActivity.isFinishing()) {
            return;
        }
        if (this.F == null) {
            om4 om4Var = new om4(this.r, new f(), bVar.f21948a);
            this.F = om4Var;
            om4Var.p(this.x);
        }
        this.F.s();
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!"onScrollChanged".equals(str)) {
            ma3.a("onMessage(" + str + "," + obj + ")", new Object[0]);
        }
        if ("onReceivedError".equals(str)) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                w0(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString("url"));
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        if (!com.alipay.sdk.m.x.d.z.equals(str)) {
            return null;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof WebAppCenterActivity) {
            activity.finish();
            return null;
        }
        a46.c(activity);
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.handlePause(true);
        }
        try {
            this.v.put("dura", this.s.a());
            this.v.put("duraB", this.t.a());
            this.v.put("duraC", this.u.a());
        } catch (JSONException e2) {
            ma3.c(e2);
        }
        this.q.f = this.v.toString();
        f84.e(this.q, "pause");
        om4 om4Var = this.F;
        if (om4Var != null) {
            om4Var.m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        CordovaWebView cordovaWebView;
        super.onRequestPermissionsResult(i, strArr, iArr);
        CordovaWebView cordovaWebView2 = this.d;
        if (cordovaWebView2 != null) {
            try {
                cordovaWebView2.onRequestPermissionResult(i, strArr, iArr);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (i != 567835 || iArr == null || iArr.length != 2 || (cordovaWebView = this.d) == null || cordovaWebView.getWebChromeClient() == null) {
            return;
        }
        this.d.getWebChromeClient().grantRecordAudio();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.handleResume(true, true);
        }
        this.v.remove("dura");
        this.v.remove("duraB");
        this.v.remove("duraC");
        this.q.f = this.v.toString();
        f84.e(this.q, az.ag);
        this.s.c();
        this.t.c();
        this.u.c();
        om4 om4Var = this.F;
        if (om4Var != null) {
            om4Var.o();
        }
    }

    public final boolean p0(ka3.b bVar) {
        ka3.b bVarE0 = e0();
        return bVarE0 != null && bVarE0.f21948a.equals(bVar.f21948a);
    }

    public void r0() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(getActivity());
        this.f = configXmlParser.getPreferences();
        this.g = configXmlParser.getInternalWhitelist();
        this.h = configXmlParser.getExternalWhitelist();
        this.k = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    public CordovaChromeClient s0(CordovaWebView cordovaWebView) {
        return new e(this, cordovaWebView);
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        CordovaPlugin cordovaPlugin2 = this.n;
        if (cordovaPlugin2 != null) {
            cordovaPlugin2.onActivityResult(this.m, 0, null);
        }
        this.n = cordovaPlugin;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
        setActivityResultCallback(cordovaPlugin);
        try {
            startActivityForResult(intent, i);
        } catch (RuntimeException e2) {
            this.n = null;
            throw e2;
        }
    }

    public CordovaWebViewClient t0(CordovaWebView cordovaWebView) {
        return new d(this, cordovaWebView);
    }

    public final void u0(double d2, double d3) {
        RemainTimeFloat remainTimeFloat = this.x;
        remainTimeFloat.setTranslationX((float) (((double) remainTimeFloat.getTranslationX()) + d2));
        RemainTimeFloat remainTimeFloat2 = this.x;
        remainTimeFloat2.setTranslationY((float) (((double) remainTimeFloat2.getTranslationY()) + d3));
    }

    public void w0(int i, String str, String str2) {
        ma3.d("received error " + i + " " + str2 + ": " + str);
        this.d.loadUrl("javascript:document.body.innerHTML= \"\"");
        getActivity().runOnUiThread(new a());
    }

    public void x0(wn6 wn6Var) {
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.setKeepScreenOn(wn6Var.d());
        }
        String strC = wn6Var.c();
        if ("fullscreen".equals(strC)) {
            V(wn6Var);
            return;
        }
        if ("statusbar".equals(strC)) {
            W(wn6Var);
            return;
        }
        if ("actionbar".equals(strC)) {
            T(wn6Var);
            return;
        }
        if ("transparent".equals(strC)) {
            Y(wn6Var);
            return;
        }
        ma3.d("unknown windowStyle: " + strC);
    }

    public void y0() {
        this.d.reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        this.m = i;
        super.startActivityForResult(intent, i, bundle);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CordovaWebView.OnScrollChangeListener {
        public b() {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageEnd(int i, int i2, int i3, int i4) {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageTop(int i, int i2, int i3, int i4) {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onScrollChanged(int i, int i2, int i3, int i4) {
        }
    }
}

package com.zenmen.palmchat.circle.app.keep.ui;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import defpackage.ac1;
import defpackage.k36;
import defpackage.ma3;
import java.util.ArrayList;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionDetailDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f13020a;
    public Activity b;
    public String c;
    public CordovaWebView d;
    public CordovaInterface e;
    public CordovaPreferences f;
    public Whitelist g;
    public Whitelist h;
    public ArrayList<PluginEntry> i;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CordovaChromeClient {
        public a(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
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
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends IceCreamCordovaWebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CordovaWebView f13022a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView, CordovaWebView cordovaWebView2) {
            super(cordovaInterface, cordovaWebView);
            this.f13022a = cordovaWebView2;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ma3.a("onPageFinished url:" + str, new Object[0]);
            this.f13022a.loadedUrl = str;
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ma3.a("onPageStarted url:" + str, new Object[0]);
            this.f13022a.loadedUrl = str;
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {
        public c() {
        }
    }

    public final BottomSheetBehavior m() {
        return BottomSheetBehavior.from((View) this.f13020a.getParent());
    }

    public final void n() {
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            StringBuilder sb = new StringBuilder(cordovaWebView.getSettings().getUserAgentString());
            sb.append(" lx-webapp");
            sb.append(" uitype/");
            sb.append("green");
            sb.append(" uiVersion/");
            sb.append(5);
            sb.append(" density/");
            sb.append(this.b.getResources().getDisplayMetrics().density);
            try {
                PackageInfo packageInfo = AppContext.getContext().getPackageManager().getPackageInfo(AppContext.getContext().getPackageName(), 0);
                sb.append(" appVerCode/");
                sb.append(packageInfo.versionCode);
                sb.append(" appVerName/");
                sb.append(packageInfo.versionName);
            } catch (PackageManager.NameNotFoundException e) {
                ma3.c(e);
            }
            sb.append(" osVer/");
            sb.append(Build.VERSION.SDK_INT);
            sb.append(" channelId/");
            sb.append(ac1.m);
            this.d.getSettings().setUserAgentString(sb.toString());
        }
    }

    public CordovaChromeClient o(CordovaWebView cordovaWebView) {
        return new a(this.e, cordovaWebView);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.keep_motion_guide_dialog);
        this.f13020a = (ViewGroup) findViewById(R.id.root);
        this.d = (CordovaWebView) findViewById(R.id.web);
        q();
        CordovaWebViewClient.setJSSDKPath(com.zenmen.palmchat.webplatform.b.n().o(this.b));
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView.pluginManager == null) {
            cordovaWebView.init(this.e, p(cordovaWebView), o(this.d), this.i, this.g, this.h, this.f);
            n();
            this.d.addJavascriptInterface(new c(), "LxUIWindow");
        }
        this.d.loadUrlIntoView(this.c);
        s();
        r(k36.c(getContext()));
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public CordovaWebViewClient p(CordovaWebView cordovaWebView) {
        return new b(this.e, cordovaWebView, cordovaWebView);
    }

    public final void q() {
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.removeJavascriptInterface("accessibility");
            this.d.removeJavascriptInterface("accessibilityTraversal");
            this.d.removeJavascriptInterface("searchBoxJavaBridge_");
            this.d.getSettings().setSavePassword(false);
        }
    }

    public final void r(int i) {
        if (i <= 0) {
            return;
        }
        m().setPeekHeight(i);
    }

    public final void s() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = k36.c(getContext());
            attributes.flags &= 2;
            attributes.windowAnimations = R.style.DialogOutAndInStyle;
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}

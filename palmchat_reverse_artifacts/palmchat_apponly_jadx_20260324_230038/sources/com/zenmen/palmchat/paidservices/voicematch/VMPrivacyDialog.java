package com.zenmen.palmchat.paidservices.voicematch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.ZXWebView;
import defpackage.ir5;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VMPrivacyDialog extends LXBottomSheetDialog implements CordovaInterface {
    public Activity h;
    public f i;
    public ZXWebView j;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends IceCreamCordovaWebViewClient {
        public b(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LogUtil.i("VMPrivacyDialog", "onPageFinished url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LogUtil.i("VMPrivacyDialog", "onPageStarted url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VMPrivacyDialog.this.dismiss();
            VMPrivacyDialog.this.i.onCheck(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VMPrivacyDialog.this.dismiss();
            VMPrivacyDialog.this.i.onCheck(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void onCheck(boolean z);
    }

    public VMPrivacyDialog(@NonNull Activity activity, f fVar) {
        super(activity);
        this.h = activity;
        this.i = fVar;
    }

    public static void D(Activity activity, f fVar) {
        VMPrivacyDialog vMPrivacyDialog = new VMPrivacyDialog(activity, fVar);
        vMPrivacyDialog.x(3);
        vMPrivacyDialog.setCancelable(false);
        vMPrivacyDialog.setCanceledOnTouchOutside(false);
        vMPrivacyDialog.show();
    }

    public final void A(ZXWebView zXWebView) {
        zXWebView.removeJavascriptInterface("accessibility");
        zXWebView.removeJavascriptInterface("accessibilityTraversal");
        zXWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        zXWebView.getSettings().setSavePassword(false);
        zXWebView.setScrollBarStyle(33554432);
        zXWebView.setVerticalScrollBarEnabled(false);
        zXWebView.setOnScrollChangeListener(new c());
        if (zXWebView.pluginManager == null) {
            long jB = ir5.b();
            if (!Config.isInitialized()) {
                Config.init(this.h);
            }
            LogUtil.i("VMPrivacyDialog", "init time =" + ir5.e(jB));
            zXWebView.init(this, C(zXWebView), B(zXWebView), Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        }
    }

    public CordovaChromeClient B(CordovaWebView cordovaWebView) {
        return new a(this, cordovaWebView);
    }

    public CordovaWebViewClient C(CordovaWebView cordovaWebView) {
        return new b(this, cordovaWebView);
    }

    @Override // org.apache.cordova.CordovaInterface
    /* JADX INFO: renamed from: getActivity */
    public Activity getOwnerActivity2() {
        return this.h;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return ZXWebView.getThreadPool();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_voice_match_privacy, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.contentLayout);
        try {
            ZXWebView zXWebView = new ZXWebView(this.h);
            zXWebView.setBackgroundColor(0);
            frameLayout.addView(zXWebView, new FrameLayout.LayoutParams(-1, -1));
            A(zXWebView);
            zXWebView.loadUrlIntoView("https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-cdf6fb3259b0439c9e6d4a43cc2cc7e4-t58tba", false);
            this.j = zXWebView;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        viewGroup.findViewById(R.id.btnLayout1).setOnClickListener(new d());
        viewGroup.findViewById(R.id.btnLayout2).setOnClickListener(new e());
        return viewGroup;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZXWebView zXWebView = this.j;
        if (zXWebView != null) {
            zXWebView.stopLoading();
            this.j.handleDestroy();
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CordovaChromeClient {
        public a(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LogUtil.i("VMPrivacyDialog", "onProgressChanged progress:" + i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CordovaWebView.OnScrollChangeListener {
        public c() {
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

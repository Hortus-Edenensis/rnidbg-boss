package com.zenmen.palmchat.webplatform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.nl0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordovaNew.ConfigXmlParser;
import org.apache.cordovaNew.CordovaInterfaceImpl;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaPreferences;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.CordovaWebViewEngine;
import org.apache.cordovaNew.CordovaWebViewImpl;
import org.apache.cordovaNew.LOG;
import org.apache.cordovaNew.PluginEntry;
import org.apache.cordovaNew.engine.SystemWebView;
import org.apache.cordovaNew.engine.SystemWebViewClient;
import org.apache.cordovaNew.engine.SystemWebViewEngine;
import org.apache.webplatform.jssdk.WebPlatformPlugin;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WebModuleFragment extends Fragment {
    public static final String j = "WebModuleFragment";
    public CordovaWebView d;
    public CordovaPreferences e;
    public String f;
    public ArrayList<PluginEntry> g;
    public CordovaInterfaceImpl h;
    public String i;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CordovaInterfaceImpl {
        public a(Activity activity) {
            super(activity);
        }

        @Override // org.apache.cordovaNew.CordovaInterfaceImpl, org.apache.cordovaNew.CordovaInterface
        public Object onMessage(String str, Object obj) {
            return WebModuleFragment.this.onMessage(str, obj);
        }
    }

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
    public class c extends SystemWebViewClient {
        public c(SystemWebViewEngine systemWebViewEngine) {
            super(systemWebViewEngine);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.contains(CordovaWebViewClient.ZX_LOCAL_RES)) {
                String str2 = com.zenmen.palmchat.webplatform.b.n().p(WebModuleFragment.this.getContext()) + File.separator + str.substring(str.indexOf(CordovaWebViewClient.ZX_LOCAL_RES) + 14);
                try {
                    LogUtil.i(WebModuleFragment.j, "shouldInterceptRequest, filePath = " + str2);
                    return new WebResourceResponse("application/javascript", "UTF-8", new FileInputStream(str2));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    public View D() {
        this.d.getView().setId(R$id.web_module_view);
        this.d.getView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.getView().requestFocusFromTouch();
        K();
        SystemWebView systemWebView = (SystemWebView) this.d.getView();
        String userAgentString = systemWebView.getSettings().getUserAgentString();
        String strC = nl0.c();
        if (strC.equals("release") && ac1.m.equals(ac1.r)) {
            strC = "pre";
        }
        systemWebView.getSettings().setUserAgentString(userAgentString + " uitype/green serverType/" + strC);
        systemWebView.setLongClickable(true);
        systemWebView.setHapticFeedbackEnabled(false);
        systemWebView.setOnLongClickListener(new b());
        systemWebView.setWebViewClient(new c((SystemWebViewEngine) this.d.getEngine()));
        return systemWebView;
    }

    public View E() {
        try {
            this.d = I();
            View viewD = D();
            if (!this.d.isInitialized()) {
                this.d.init(this.h, this.g, this.e);
            }
            this.h.onCordovaInit(this.d.getPluginManager());
            if (!TextUtils.isEmpty(this.f)) {
                this.d.loadUrlIntoView(this.f, true);
            }
            CordovaPlugin plugin = this.d.getPluginManager().getPlugin("webPlatform");
            if (plugin != null) {
                ((WebPlatformPlugin) plugin).setExtraInfo(this.i);
            }
            return viewD;
        } catch (Exception unused) {
            return null;
        }
    }

    public void F() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(getContext());
        CordovaPreferences preferences = configXmlParser.getPreferences();
        this.e = preferences;
        preferences.setPreferencesBundle(getArguments());
        this.g = configXmlParser.getPluginEntries();
    }

    public CordovaInterfaceImpl G() {
        return new a(getActivity());
    }

    public CordovaWebView I() {
        return new CordovaWebViewImpl(J());
    }

    public CordovaWebViewEngine J() {
        return CordovaWebViewImpl.createEngine(getContext(), this.e);
    }

    public final void K() {
        SystemWebView systemWebView = (SystemWebView) this.d.getView();
        systemWebView.removeJavascriptInterface("accessibility");
        systemWebView.removeJavascriptInterface("accessibilityTraversal");
        systemWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        systemWebView.getSettings().setSavePassword(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        LOG.d(j, "Incoming Result. Request code = " + i);
        super.onActivityResult(i, i2, intent);
        this.h.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        F();
        CordovaInterfaceImpl cordovaInterfaceImplG = G();
        this.h = cordovaInterfaceImplG;
        if (bundle != null) {
            cordovaInterfaceImplG.restoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return E();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        LOG.d(j, "WebModuleFragment.fragment()");
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.handleDestroy();
        }
        super.onDestroy();
    }

    public Object onMessage(String str, Object obj) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LOG.d(j, "Paused the fragment.");
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView != null) {
            cordovaWebView.handlePause(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            this.h.onRequestPermissionResult(i, strArr, iArr);
        } catch (JSONException e) {
            LOG.d(j, "JSONException: Parameters fed into the method are not valid");
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LOG.d(j, "Resumed the fragment.");
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView == null) {
            return;
        }
        cordovaWebView.handleResume(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LOG.d(j, "Started the fragment.");
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView == null) {
            return;
        }
        cordovaWebView.handleStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LOG.d(j, "Stopped the fragment.");
        CordovaWebView cordovaWebView = this.d;
        if (cordovaWebView == null) {
            return;
        }
        cordovaWebView.handleStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        this.h.setActivityResultRequestCode(i);
        super.startActivityForResult(intent, i, bundle);
    }
}

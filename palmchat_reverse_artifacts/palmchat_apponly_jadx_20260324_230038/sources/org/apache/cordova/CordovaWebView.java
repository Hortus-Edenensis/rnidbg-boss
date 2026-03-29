package org.apache.cordova;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.az;
import com.igexin.sdk.PushConsts;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaWebView extends WebView {
    public static final String CORDOVA_VERSION = "3.7.2";
    static final FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new FrameLayout.LayoutParams(-1, -1, 17);
    private static final int MESSAGE_TIMEOUT_CHECK = 10000;
    public static final String TAG = "CordovaWebView";
    private App appPlugin;
    private HashSet<Integer> boundKeyCodes;
    CordovaBridge bridge;
    private CordovaChromeClient chromeClient;
    private CordovaInterface cordova;
    private Whitelist externalWhitelist;
    private Whitelist internalWhitelist;
    private long lastMenuEventTime;
    public OnScrollChangeListener listener;
    int loadUrlTimeout;
    public String loadedUrl;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private UIHandler mHandler;
    private boolean paused;
    protected CallbackMap permissionResultCallbacks;
    public PluginManager pluginManager;
    private CordovaPreferences preferences;
    private BroadcastReceiver receiver;
    private CordovaResourceApi resourceApi;
    CordovaWebViewClient viewClient;

    /* JADX INFO: compiled from: SearchBox */
    public class ActivityResult {
        Intent incoming;
        int request;
        int result;

        public ActivityResult(int i, int i2, Intent intent) {
            this.request = i;
            this.result = i2;
            this.incoming = intent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(16)
    public static final class Level16Apis {
        private Level16Apis() {
        }

        public static void enableUniversalAccess(WebSettings webSettings) {
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(17)
    public static final class Level17Apis {
        private Level17Apis() {
        }

        public static void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z) {
            webSettings.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnScrollChangeListener {
        void onPageEnd(int i, int i2, int i3, int i4);

        void onPageTop(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class UIHandler extends Handler {
        private WeakReference<CordovaWebView> mRef;

        public UIHandler(CordovaWebView cordovaWebView) {
            this.mRef = new WeakReference<>(cordovaWebView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CordovaWebView cordovaWebView = this.mRef.get();
            if (message.what != 10000 || cordovaWebView == null) {
                return;
            }
            cordovaWebView.createTimeoutPage(cordovaWebView, (String) message.obj);
        }
    }

    public CordovaWebView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTimeoutPage(final CordovaWebView cordovaWebView, final String str) {
        Activity activity;
        int i = cordovaWebView.loadUrlTimeout;
        Runnable runnable = new Runnable() { // from class: org.apache.cordova.CordovaWebView.2
            @Override // java.lang.Runnable
            public void run() {
                cordovaWebView.stopLoading();
                LOG.e(CordovaWebView.TAG, "CordovaWebView: TIMEOUT ERROR!");
                CordovaWebViewClient cordovaWebViewClient = CordovaWebView.this.viewClient;
                if (cordovaWebViewClient != null) {
                    cordovaWebViewClient.onReceivedError(cordovaWebView, -6, "The connection to the server was unsuccessful.", str);
                }
            }
        };
        if (cordovaWebView.loadUrlTimeout != i || (activity = cordovaWebView.cordova.getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(runnable);
    }

    @TargetApi(19)
    private void enableRemoteDebugging() {
        try {
            WebView.setWebContentsDebuggingEnabled(true);
        } catch (IllegalArgumentException e) {
            Log.d(TAG, "You have one job! To turn on Remote Web Debugging! YOU HAVE FAILED! ");
            e.printStackTrace();
        }
    }

    private void exposeJsInterface() {
        addJavascriptInterface(new ExposedJsApi(this.bridge), "_cordovaNative");
    }

    private void initIfNecessary() {
        if (this.pluginManager == null) {
            Log.w(TAG, "CordovaWebView.init() was not called. This will soon be required.");
            CordovaInterface cordovaInterface = (CordovaInterface) getContext();
            if (!Config.isInitialized()) {
                Config.init(cordovaInterface.getActivity());
            }
            init(cordovaInterface, makeWebViewClient(cordovaInterface), makeWebChromeClient(cordovaInterface), Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebViewSettings() {
        setInitialScale(0);
        if (shouldRequestFocusOnInit()) {
            requestFocusFromTouch();
        }
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        try {
            WebSettings.class.getMethod("setNavDump", Boolean.TYPE);
            Log.d(TAG, "CordovaWebView is running on device made by: " + Build.MANUFACTURER);
        } catch (IllegalAccessException unused) {
            Log.d(TAG, "This should never happen: IllegalAccessException means this isn't Android anymore");
        } catch (IllegalArgumentException unused2) {
            Log.d(TAG, "Doing the NavDump failed with bad arguments");
        } catch (NoSuchMethodException unused3) {
            Log.d(TAG, "We are on a modern version of Android, we will deprecate HTC 2.3 devices in 2.8");
        } catch (InvocationTargetException unused4) {
            Log.d(TAG, "This should never happen: InvocationTargetException means this isn't Android anymore.");
        }
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        Level17Apis.setMediaPlaybackRequiresUserGesture(settings, false);
        String path = getContext().getApplicationContext().getDir("database", 0).getPath();
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(path);
        if ((getContext().getApplicationContext().getApplicationInfo().flags & 2) != 0) {
            enableRemoteDebugging();
        }
        settings.setGeolocationDatabasePath(path);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
    }

    private void sendJavascriptEvent(String str) {
        callJavascriptEventCallback(str);
        if (this.appPlugin == null) {
            this.appPlugin = (App) this.pluginManager.getPlugin(App.PLUGIN_NAME);
        }
        App app = this.appPlugin;
        if (app == null) {
            LOG.w(TAG, "Unable to fire event without existing plugin");
        } else {
            app.fireJavascriptEvent(str);
        }
    }

    public boolean backHistory() {
        if (!super.canGoBack()) {
            return false;
        }
        super.goBack();
        return true;
    }

    @Deprecated
    public void bindButton(boolean z) {
        setButtonPlumbedToJs(4, z);
    }

    public void callJavascriptEventCallback(String str) {
        if (az.ag.equals(str)) {
            loadUrl("javascript:(function(){if(resume) resume()})()");
        } else if ("pause".equals(str)) {
            loadUrl("javascript:(function(){if(pause) pause()})()");
        }
    }

    public CordovaBridge getBridge() {
        return this.bridge;
    }

    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }

    public CordovaPreferences getPreferences() {
        return this.preferences;
    }

    public String getProperty(String str, String str2) {
        Object obj;
        try {
            Bundle extras = this.cordova.getActivity().getIntent().getExtras();
            return (extras == null || (obj = extras.get(str.toLowerCase(Locale.getDefault()))) == null) ? str2 : obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public CordovaResourceApi getResourceApi() {
        return this.resourceApi;
    }

    public Whitelist getWhitelist() {
        return this.internalWhitelist;
    }

    @Deprecated
    public boolean hadKeyEvent() {
        return false;
    }

    public void handleDestroy() {
        this.loadUrlTimeout++;
        stopErrorPageTimeout();
        loadUrl("about:blank");
        this.chromeClient.destroyLastDialog();
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            pluginManager.onDestroy();
        }
    }

    public void handlePause(boolean z) {
        LOG.d(TAG, "Handle the pause");
        sendJavascriptEvent("pause");
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            pluginManager.onPause(z);
        }
        if (!z) {
            pauseTimers();
        }
        onPause();
        this.paused = true;
    }

    public void handleResume(boolean z, boolean z2) {
        sendJavascriptEvent(az.ag);
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            pluginManager.onResume(z);
        }
        resumeTimers();
        onResume();
        this.paused = false;
    }

    public boolean hasPermission(String str) {
        if (this.cordova.getActivity() == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || this.cordova.getActivity().checkSelfPermission(str) == 0;
    }

    public void hideCustomView() {
        Log.d(TAG, "Hiding Custom View");
        View view = this.mCustomView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        ((ViewGroup) getParent()).removeView(this.mCustomView);
        this.mCustomView = null;
        this.mCustomViewCallback.onCustomViewHidden();
        setVisibility(0);
    }

    public void init(CordovaInterface cordovaInterface, CordovaWebViewClient cordovaWebViewClient, CordovaChromeClient cordovaChromeClient, List<PluginEntry> list, Whitelist whitelist, Whitelist whitelist2, CordovaPreferences cordovaPreferences) {
        if (this.cordova != null) {
            throw new IllegalStateException();
        }
        this.permissionResultCallbacks = new CallbackMap();
        this.cordova = cordovaInterface;
        this.viewClient = cordovaWebViewClient;
        this.chromeClient = cordovaChromeClient;
        this.internalWhitelist = whitelist;
        this.externalWhitelist = whitelist2;
        this.preferences = cordovaPreferences;
        super.setWebChromeClient(cordovaChromeClient);
        super.setWebViewClient(cordovaWebViewClient);
        PluginManager pluginManager = new PluginManager(this, this.cordova, list);
        this.pluginManager = pluginManager;
        this.bridge = new CordovaBridge(pluginManager, new NativeToJsMessageQueue(this, cordovaInterface), this.cordova.getActivity().getPackageName());
        this.resourceApi = new CordovaResourceApi(getContext(), this.pluginManager);
        this.pluginManager.init();
        initWebViewSettings();
        exposeJsInterface();
    }

    @Deprecated
    public boolean isBackButtonBound() {
        return isButtonPlumbedToJs(4);
    }

    public boolean isButtonPlumbedToJs(int i) {
        return this.boundKeyCodes.contains(Integer.valueOf(i));
    }

    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }

    public boolean isInitialized() {
        return this.cordova != null;
    }

    public boolean isPaused() {
        return this.paused;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (str.equals("about:blank") || str.startsWith("javascript:")) {
            loadUrlNow(str);
        } else {
            loadUrlIntoView(str);
        }
    }

    public void loadUrlIntoView(String str) {
        loadUrlIntoView(str, true);
    }

    public void loadUrlNow(String str) {
        if (LOG.isLoggable(3) && !str.startsWith("javascript:")) {
            LOG.d(TAG, ">>> loadUrlNow()");
        }
        if (str.startsWith("file://") || str.startsWith("javascript:") || str.startsWith("about:") || this.internalWhitelist.isUrlWhiteListed(str)) {
            super.loadUrl(str);
        }
    }

    public CordovaChromeClient makeWebChromeClient(CordovaInterface cordovaInterface) {
        return new CordovaChromeClient(cordovaInterface, this);
    }

    public CordovaWebViewClient makeWebViewClient(CordovaInterface cordovaInterface) {
        return new IceCreamCordovaWebViewClient(cordovaInterface, this);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.boundKeyCodes.contains(Integer.valueOf(i))) {
            if (i == 25) {
                sendJavascriptEvent("volumedownbutton");
                return true;
            }
            if (i != 24) {
                return super.onKeyDown(i, keyEvent);
            }
            sendJavascriptEvent("volumeupbutton");
            return true;
        }
        if (i == 4) {
            return !startOfHistory() || isButtonPlumbedToJs(4);
        }
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null) {
            return super.onKeyDown(i, keyEvent);
        }
        ((InputMethodManager) this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        this.cordova.getActivity().openOptionsMenu();
        return true;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCustomView != null) {
                hideCustomView();
                return true;
            }
            PluginManager pluginManager = this.pluginManager;
            if (pluginManager != null && pluginManager.postMessage("webappbackkeyup", keyEvent) != null) {
                return true;
            }
            if (isButtonPlumbedToJs(4)) {
                sendJavascriptEvent("backbutton");
                return true;
            }
            if (backHistory()) {
                return true;
            }
        } else {
            if (i == 82) {
                if (this.lastMenuEventTime < keyEvent.getEventTime()) {
                    sendJavascriptEvent("menubutton");
                }
                this.lastMenuEventTime = keyEvent.getEventTime();
                return super.onKeyUp(i, keyEvent);
            }
            if (i == 84) {
                sendJavascriptEvent("searchbutton");
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            pluginManager.onNewIntent(intent);
        }
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        Pair<CordovaPlugin, Integer> andRemoveCallback = this.permissionResultCallbacks.getAndRemoveCallback(i);
        if (andRemoveCallback != null) {
            ((CordovaPlugin) andRemoveCallback.first).onRequestPermissionResult(((Integer) andRemoveCallback.second).intValue(), strArr, iArr);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        postMessage("onScrollChanged", new ScrollEvent(i, i2, i3, i4, this));
        float contentHeight = getContentHeight() * getScale();
        float height = getHeight() + getScrollY();
        Log.i(TAG, "web height:" + contentHeight + " current height:" + height);
        if (Math.abs(contentHeight - height) < 10.0f) {
            this.listener.onPageEnd(i, i2, i3, i4);
        } else if (getScrollY() == 0) {
            this.listener.onPageTop(i, i2, i3, i4);
        } else {
            this.listener.onScrollChanged(i, i2, i3, i4);
        }
        Log.d(TAG, "L:" + i + " t:" + i2);
    }

    public void postMessage(String str, Object obj) {
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            pluginManager.postMessage(str, obj);
        }
    }

    public void printBackForwardList() {
        WebBackForwardList webBackForwardListCopyBackForwardList = copyBackForwardList();
        int size = webBackForwardListCopyBackForwardList.getSize();
        for (int i = 0; i < size; i++) {
            LOG.d(TAG, "The URL at index: " + Integer.toString(i) + " is " + webBackForwardListCopyBackForwardList.getItemAtIndex(i).getUrl());
        }
    }

    public void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    public void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        Activity activity = this.cordova.getActivity();
        if (activity == null) {
            return;
        }
        int iRegisterCallback = this.permissionResultCallbacks.registerCallback(cordovaPlugin, i);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, iRegisterCallback);
        }
    }

    @Override // android.webkit.WebView
    public WebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList webBackForwardListRestoreState = super.restoreState(bundle);
        Log.d(TAG, "WebView restoration crew now restoring!");
        this.pluginManager.init();
        return webBackForwardListRestoreState;
    }

    @Deprecated
    public void sendJavascript(String str) {
        this.bridge.getMessageQueue().addJavaScript(str);
    }

    public void sendPluginResult(PluginResult pluginResult, String str) {
        this.bridge.getMessageQueue().addPluginResult(pluginResult, str);
    }

    public void setButtonPlumbedToJs(int i, boolean z) {
        if (i != 4 && i != 24 && i != 25) {
            throw new IllegalArgumentException("Unsupported keycode: " + i);
        }
        if (z) {
            this.boundKeyCodes.add(Integer.valueOf(i));
        } else {
            this.boundKeyCodes.remove(Integer.valueOf(i));
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.listener = onScrollChangeListener;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = (CordovaChromeClient) webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.viewClient = (CordovaWebViewClient) webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public boolean shouldRequestFocusOnInit() {
        return true;
    }

    public void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Log.d(TAG, "showing Custom View");
        if (this.mCustomView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.mCustomView = view;
        this.mCustomViewCallback = customViewCallback;
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.addView(view, COVER_SCREEN_GRAVITY_CENTER);
        setVisibility(8);
        viewGroup.setVisibility(0);
        viewGroup.bringToFront();
    }

    public void showWebPage(String str, boolean z, boolean z2, HashMap<String, Object> map) {
        LOG.d(TAG, "showWebPage(%s, %b, %b, HashMap", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            clearHistory();
        }
        if (!z) {
            if (str.startsWith("file://") || this.internalWhitelist.isUrlWhiteListed(str)) {
                loadUrl(str);
                return;
            }
            LOG.w(TAG, "showWebPage: Cannot load URL into webview since it is not in white list.  Loading into browser instead. (URL=" + str + ")");
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri uri = Uri.parse(str);
            if ("file".equals(uri.getScheme())) {
                intent.setDataAndType(uri, this.resourceApi.getMimeType(uri));
            } else {
                intent.setData(uri);
            }
            this.cordova.getActivity().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            LOG.e(TAG, "Error loading url " + str, e);
        }
    }

    public boolean startOfHistory() {
        WebHistoryItem itemAtIndex = copyBackForwardList().getItemAtIndex(0);
        if (itemAtIndex == null) {
            return false;
        }
        String url = itemAtIndex.getUrl();
        String url2 = getUrl();
        LOG.d(TAG, "The current URL is: " + url2);
        LOG.d(TAG, "The URL at item 0 is: " + url);
        return url2.equals(url);
    }

    public void stopErrorPageTimeout() {
        this.mHandler.removeMessages(10000);
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        this.viewClient.isCurrentlyLoading = false;
        super.stopLoading();
    }

    public CordovaWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boundKeyCodes = new HashSet<>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
        this.mHandler = new UIHandler(this);
    }

    @Deprecated
    public void bindButton(String str, boolean z) {
        if (str.compareTo("volumeup") == 0) {
            setButtonPlumbedToJs(24, z);
        } else if (str.compareTo("volumedown") == 0) {
            setButtonPlumbedToJs(25, z);
        }
    }

    @Override // android.webkit.WebView
    public CordovaChromeClient getWebChromeClient() {
        return this.chromeClient;
    }

    @Override // android.webkit.WebView
    public CordovaWebViewClient getWebViewClient() {
        return this.viewClient;
    }

    public void loadUrlIntoView(final String str, boolean z) {
        LOG.d(TAG, ">>> loadUrl(" + str + ")");
        initIfNecessary();
        if (z) {
            if (this.loadedUrl != null) {
                this.pluginManager.init();
            }
            this.loadedUrl = str;
        }
        final int i = Integer.parseInt(getProperty("LoadUrlTimeoutValue", PushConsts.SEND_MESSAGE_ERROR));
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaWebView.1
            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 10000;
                message.obj = str;
                CordovaWebView.this.mHandler.sendMessageDelayed(message, i);
                this.loadUrlNow(str);
            }
        });
    }

    @Deprecated
    public void loadUrl(String str, int i) {
        if (str == null) {
            loadUrlIntoView(Config.getStartUrl());
        } else {
            loadUrlIntoView(str);
        }
    }

    @Deprecated
    public void bindButton(int i, boolean z, boolean z2) {
        setButtonPlumbedToJs(i, z2);
    }

    @Deprecated
    public CordovaWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boundKeyCodes = new HashSet<>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
        this.mHandler = new UIHandler(this);
    }

    public void loadUrlIntoView(String str, int i) {
        if (!str.startsWith("javascript:") && !canGoBack()) {
            LOG.d(TAG, "loadUrlIntoView(%s, %d)", str, Integer.valueOf(i));
        }
        loadUrlIntoView(str);
    }

    @TargetApi(11)
    @Deprecated
    public CordovaWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.boundKeyCodes = new HashSet<>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
        this.mHandler = new UIHandler(this);
    }

    @Deprecated
    public void storeResult(int i, int i2, Intent intent) {
    }
}

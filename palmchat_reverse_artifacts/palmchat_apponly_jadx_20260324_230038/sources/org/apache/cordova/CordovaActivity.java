package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.alipay.sdk.m.x.d;
import com.huawei.openalliance.ad.constant.bq;
import defpackage.m5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaActivity extends Activity implements CordovaInterface {
    private static int ACTIVITY_EXITING = 2;
    private static int ACTIVITY_RUNNING = 1;
    private static int ACTIVITY_STARTING = 0;
    public static String TAG = "CordovaActivity";
    protected CordovaPlugin activityResultCallback;
    protected boolean activityResultKeepRunning;
    protected int activityResultRequestCode;
    protected CordovaWebView appView;
    protected Whitelist externalWhitelist;
    private String initCallbackClass;
    protected Whitelist internalWhitelist;
    protected String launchUrl;
    protected ArrayList<PluginEntry> pluginEntries;
    protected CordovaPreferences preferences;

    @Deprecated
    protected LinearLayout root;

    @Deprecated
    protected CordovaWebViewClient webViewClient;
    private final ExecutorService threadPool = Executors.newCachedThreadPool(new DefaultThreadFactory("poolCached-" + TAG));
    private int activityState = 0;

    @Deprecated
    protected int splashscreen = 0;

    @Deprecated
    protected int splashscreenTime = -1;
    protected int loadUrlTimeoutValue = 20000;
    protected boolean keepRunning = true;

    /* JADX INFO: compiled from: SearchBox */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public DefaultThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private void doSplashScreenAction(String str, JSONArray jSONArray) {
        CordovaPlugin plugin = this.appView.pluginManager.getPlugin("org.apache.cordova.splashscreeninternal");
        if (plugin != null) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            try {
                plugin.execute(str, jSONArray, (CallbackContext) null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public void addService(String str, String str2) {
        PluginManager pluginManager;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (pluginManager = cordovaWebView.pluginManager) == null) {
            return;
        }
        pluginManager.addService(str, str2);
    }

    @Deprecated
    public boolean backHistory() {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            return cordovaWebView.backHistory();
        }
        return false;
    }

    public void clearAuthenticationTokens() {
        CordovaWebViewClient cordovaWebViewClient;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (cordovaWebViewClient = cordovaWebView.viewClient) == null) {
            return;
        }
        cordovaWebViewClient.clearAuthenticationTokens();
    }

    @Deprecated
    public void clearCache() {
        if (this.appView == null) {
            init();
        }
        this.appView.clearCache(true);
    }

    @Deprecated
    public void clearHistory() {
        this.appView.clearHistory();
    }

    public void createViews() {
        LOG.d(TAG, "CordovaActivity.createViews()");
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        LinearLayoutSoftKeyboardDetect linearLayoutSoftKeyboardDetect = new LinearLayoutSoftKeyboardDetect(this, this.appView.pluginManager, defaultDisplay.getWidth(), defaultDisplay.getHeight());
        this.root = linearLayoutSoftKeyboardDetect;
        linearLayoutSoftKeyboardDetect.setOrientation(1);
        this.root.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.0f));
        this.appView.setId(100);
        this.appView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        ViewParent parent = this.appView.getParent();
        if (parent != null && parent != this.root) {
            LOG.d(TAG, "removing appView from existing parent");
            ((ViewGroup) parent).removeView(this.appView);
        }
        this.root.addView(this.appView);
        setContentView(this.root);
        this.root.setBackgroundColor(this.preferences.getInteger("BackgroundColor", -16777216));
    }

    public void displayError(final String str, final String str2, final String str3, final boolean z) {
        runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(str2);
                    builder.setTitle(str);
                    builder.setCancelable(false);
                    builder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaActivity.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            if (z) {
                                this.endActivity();
                            }
                        }
                    });
                    builder.create();
                    builder.show();
                } catch (Exception unused) {
                    CordovaActivity.this.finish();
                }
            }
        });
    }

    public void endActivity() {
        this.activityState = ACTIVITY_EXITING;
        super.finish();
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    public AuthenticationToken getAuthenticationToken(String str, String str2) {
        CordovaWebViewClient cordovaWebViewClient;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (cordovaWebViewClient = cordovaWebView.viewClient) == null) {
            return null;
        }
        return cordovaWebViewClient.getAuthenticationToken(str, str2);
    }

    @Deprecated
    public boolean getBooleanProperty(String str, boolean z) {
        return this.preferences.getBoolean(str, z);
    }

    @Deprecated
    public Context getContext() {
        LOG.d(TAG, "This will be deprecated December 2012");
        return this;
    }

    @Deprecated
    public double getDoubleProperty(String str, double d) {
        return this.preferences.getDouble(str, d);
    }

    @Deprecated
    public int getIntegerProperty(String str, int i) {
        return this.preferences.getInteger(str, i);
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Deprecated
    public String getStringProperty(String str, String str2) {
        return this.preferences.getString(str, str2);
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void init() {
        init(this.appView, null, null);
    }

    @Deprecated
    public boolean isUrlWhiteListed(String str) {
        return this.internalWhitelist.isUrlWhiteListed(str);
    }

    public void loadConfig() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(this);
        CordovaPreferences preferences = configXmlParser.getPreferences();
        this.preferences = preferences;
        preferences.setPreferencesBundle(getIntent().getExtras());
        this.internalWhitelist = configXmlParser.getInternalWhitelist();
        this.externalWhitelist = configXmlParser.getExternalWhitelist();
        this.launchUrl = configXmlParser.getLaunchUrl();
        this.pluginEntries = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    public void loadUrl(String str) {
        if (this.appView == null) {
            init();
        }
        this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
        this.appView.loadUrlIntoView(str, true);
    }

    public CordovaChromeClient makeChromeClient(CordovaWebView cordovaWebView) {
        return cordovaWebView.makeWebChromeClient(this);
    }

    public CordovaWebView makeWebView() {
        return new CordovaWebView(this);
    }

    public CordovaWebViewClient makeWebViewClient(CordovaWebView cordovaWebView) {
        return cordovaWebView.makeWebViewClient(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        LOG.d(TAG, "Incoming Result. Request code = " + i);
        super.onActivityResult(i, i2, intent);
        CordovaPlugin plugin = this.activityResultCallback;
        if (plugin == null && (str = this.initCallbackClass) != null) {
            plugin = this.appView.pluginManager.getPlugin(str);
        }
        this.initCallbackClass = null;
        this.activityResultCallback = null;
        if (plugin == null) {
            LOG.w(TAG, "Got an activity result, but no plugin was registered to receive it.");
        } else {
            LOG.d(TAG, "We have a callback to send this result to");
            plugin.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        LOG.i(TAG, "Apache Cordova native platform version 3.7.2 is starting");
        LOG.d(TAG, "CordovaActivity.onCreate()");
        loadConfig();
        if (!this.preferences.getBoolean("ShowTitle", false)) {
            getWindow().requestFeature(1);
        }
        if (this.preferences.getBoolean("SetFullscreen", false)) {
            Log.d(TAG, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
            getWindow().setFlags(1024, 1024);
        } else if (this.preferences.getBoolean("Fullscreen", false)) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().setFlags(2048, 2048);
        }
        m5.c(this, bundle);
        super.onCreate(bundle);
        if (bundle != null) {
            this.initCallbackClass = bundle.getString("callbackClass");
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        postMessage("onCreateOptionsMenu", menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        LOG.d(TAG, "CordovaActivity.onDestroy()");
        super.onDestroy();
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.handleDestroy();
        } else {
            this.activityState = ACTIVITY_EXITING;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        CordovaWebView cordovaWebView = this.appView;
        return (cordovaWebView == null || cordovaWebView.getFocusedChild() == null || !(i == 4 || i == 82)) ? super.onKeyDown(i, keyEvent) : this.appView.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        CordovaWebView cordovaWebView = this.appView;
        return (cordovaWebView == null || (!cordovaWebView.isCustomViewShowing() && this.appView.getFocusedChild() == null) || !(i == 4 || i == 82)) ? super.onKeyUp(i, keyEvent) : this.appView.onKeyUp(i, keyEvent);
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!"onScrollChanged".equals(str)) {
            LOG.d(TAG, "onMessage(" + str + "," + obj + ")");
        }
        if (!"onReceivedError".equals(str)) {
            if (!d.z.equals(str)) {
                return null;
            }
            endActivity();
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            onReceivedError(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString("url"));
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        postMessage("onOptionsItemSelected", menuItem);
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        CordovaWebView cordovaWebView;
        super.onPause();
        LOG.d(TAG, "Paused the application!");
        if (this.activityState == ACTIVITY_EXITING || (cordovaWebView = this.appView) == null) {
            return;
        }
        cordovaWebView.handlePause(this.keepRunning);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        postMessage("onPrepareOptionsMenu", menu);
        return true;
    }

    public void onReceivedError(int i, final String str, final String str2) {
        final String string = this.preferences.getString("errorUrl", null);
        if (string != null && ((string.startsWith("file://") || this.internalWhitelist.isUrlWhiteListed(string)) && !str2.equals(string))) {
            runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    this.appView.showWebPage(string, false, true, null);
                }
            });
        } else {
            final boolean z = i != -2;
            runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        this.appView.setVisibility(8);
                        this.displayError("Application Error", str + " (" + str2 + ")", "OK", z);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        boolean z;
        super.onResume();
        LOG.d(TAG, "Resuming the App");
        if (this.activityState == ACTIVITY_STARTING) {
            this.activityState = ACTIVITY_RUNNING;
            return;
        }
        if (this.appView == null) {
            return;
        }
        getWindow().getDecorView().requestFocus();
        this.appView.handleResume(this.keepRunning, this.activityResultKeepRunning);
        if ((!this.keepRunning || this.activityResultKeepRunning) && (z = this.activityResultKeepRunning)) {
            this.keepRunning = z;
            this.activityResultKeepRunning = false;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CordovaPlugin cordovaPlugin = this.activityResultCallback;
        if (cordovaPlugin != null) {
            bundle.putString("callbackClass", cordovaPlugin.getClass().getName());
        }
    }

    public void postMessage(String str, Object obj) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.postMessage(str, obj);
        }
    }

    public AuthenticationToken removeAuthenticationToken(String str, String str2) {
        CordovaWebViewClient cordovaWebViewClient;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (cordovaWebViewClient = cordovaWebView.viewClient) == null) {
            return null;
        }
        return cordovaWebViewClient.removeAuthenticationToken(str, str2);
    }

    @Deprecated
    public void removeSplashScreen() {
        doSplashScreenAction("hide", null);
    }

    @Deprecated
    public void sendJavascript(String str) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.bridge.getMessageQueue().addJavaScript(str);
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        CordovaPlugin cordovaPlugin2 = this.activityResultCallback;
        if (cordovaPlugin2 != null) {
            cordovaPlugin2.onActivityResult(this.activityResultRequestCode, 0, null);
        }
        this.activityResultCallback = cordovaPlugin;
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String str, String str2) {
        CordovaWebViewClient cordovaWebViewClient;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (cordovaWebViewClient = cordovaWebView.viewClient) == null) {
            return;
        }
        cordovaWebViewClient.setAuthenticationToken(authenticationToken, str, str2);
    }

    @Deprecated
    public void setBooleanProperty(String str, boolean z) {
        Log.d(TAG, "Setting boolean properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        getIntent().putExtra(str.toLowerCase(), z);
    }

    @Deprecated
    public void setDoubleProperty(String str, double d) {
        Log.d(TAG, "Setting double properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        getIntent().putExtra(str.toLowerCase(), d);
    }

    @Deprecated
    public void setIntegerProperty(String str, int i) {
        Log.d(TAG, "Setting integer properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        getIntent().putExtra(str.toLowerCase(), i);
    }

    @Deprecated
    public void setStringProperty(String str, String str2) {
        Log.d(TAG, "Setting string properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        getIntent().putExtra(str.toLowerCase(), str2);
    }

    @Deprecated
    public void showSplashScreen(int i) {
        this.preferences.set("SplashScreenDelay", i);
        doSplashScreenAction(bq.b.V, null);
    }

    @Deprecated
    public void showWebPage(String str, boolean z, boolean z2, HashMap<String, Object> map) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.showWebPage(str, z, z2, map);
        }
    }

    @Deprecated
    public void spinnerStart(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        doSplashScreenAction("spinnerStart", jSONArray);
    }

    @Deprecated
    public void spinnerStop() {
        doSplashScreenAction("spinnerStop", null);
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
        setActivityResultCallback(cordovaPlugin);
        this.activityResultKeepRunning = this.keepRunning;
        if (cordovaPlugin != null) {
            this.keepRunning = false;
        }
        try {
            startActivityForResult(intent, i);
        } catch (RuntimeException e) {
            this.activityResultCallback = null;
            throw e;
        }
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public void init(CordovaWebView cordovaWebView, CordovaWebViewClient cordovaWebViewClient, CordovaChromeClient cordovaChromeClient) {
        LOG.d(TAG, "CordovaActivity.init()");
        int i = this.splashscreenTime;
        if (i >= 0) {
            this.preferences.set("SplashScreenDelay", i);
        }
        int i2 = this.splashscreen;
        if (i2 != 0) {
            this.preferences.set("SplashDrawableId", i2);
        }
        if (cordovaWebView == null) {
            cordovaWebView = makeWebView();
        }
        this.appView = cordovaWebView;
        if (this.preferences.getBoolean("DisallowOverscroll", false)) {
            this.appView.setOverScrollMode(2);
        }
        createViews();
        CordovaWebView cordovaWebView2 = this.appView;
        if (cordovaWebView2.pluginManager == null) {
            if (cordovaWebViewClient == null) {
                cordovaWebViewClient = makeWebViewClient(cordovaWebView2);
            }
            CordovaWebViewClient cordovaWebViewClient2 = cordovaWebViewClient;
            if (cordovaChromeClient == null) {
                cordovaChromeClient = makeChromeClient(this.appView);
            }
            cordovaWebView2.init(this, cordovaWebViewClient2, cordovaChromeClient, this.pluginEntries, this.internalWhitelist, this.externalWhitelist, this.preferences);
        }
        if ("media".equals(this.preferences.getString("DefaultVolumeStream", "").toLowerCase(Locale.ENGLISH))) {
            setVolumeControlStream(3);
        }
    }

    @Deprecated
    public void loadUrl(String str, int i) {
        this.splashscreenTime = i;
        loadUrl(str);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.activityResultRequestCode = i;
        super.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void cancelLoadUrl() {
    }

    @Override // org.apache.cordova.CordovaInterface
    public Activity getActivity() {
        return this;
    }
}

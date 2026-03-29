package org.apache.cordova;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e84;
import defpackage.ka3;
import defpackage.ma3;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.PluginResult;
import org.apache.cordova.jssdk.LxAdPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PluginManager {
    public static final String[] JSSDK_WHITELIST;
    private static final int SLOW_EXEC_WARNING_THRESHOLD;
    public static final Map<String, String[]> SUPPORT_API;
    public static final Set<String> SUPPORT_API_DEFUALT;
    private static String TAG = "PluginManager";
    private final CordovaWebView app;
    private final CordovaInterface ctx;
    private final HashMap<String, PluginEntry> entryMap;
    private final ka3 jsApiManager;
    private final HashMap<String, CordovaPlugin> pluginMap;
    protected HashMap<String, List<String>> urlMap;

    static {
        SLOW_EXEC_WARNING_THRESHOLD = Debug.isDebuggerConnected() ? 60 : 16;
        JSSDK_WHITELIST = new String[]{"youni.im", "lianxinapp.com", "lx-qa.com", "zjjianxin.com", "palmchat.com.cn", "handymsg.com", "handymsg.cn", "shengpay.com", "yuanyipos.com", "wap.wifimall.zhuisu100.cn", "ttz.snmi.cn", "test.lianwifi.com"};
        HashMap map = new HashMap();
        SUPPORT_API = map;
        HashSet hashSet = new HashSet();
        SUPPORT_API_DEFUALT = hashSet;
        map.put("GrantApp", new String[]{"grantApp", "lx_checkJsApi"});
        map.put("LxLocation", new String[]{"lx_getLocation", "lx_selectLocation", "lx_showLocation"});
        map.put("LxPay", new String[]{"lx_pay", "lx_getPaySupportPlatform"});
        map.put("LxComm", new String[]{"lx_getUserAgent", "lx_getDeviceInfo", "lx_getPrivDeviceInfo", "lx_getDeviceId", "lx_getWebViewSize", "lx_closeWebView", "lx_openNativeApp", "lx_checkNativeApp", "lx_reportEvent", "lx_reportEventExtra", "lx_reportAppState", "lx_alert", "lx_showToast"});
        map.put("LxLogin", new String[]{"lx_login", "lx_auth", "lx_getUserInfo", "lx_getPhoneNumber"});
        map.put("LxShare", new String[]{"lx_shareText", "lx_shareWeb", "lx_shareNameCard", "lx_shareSVideo", "lx_shareApp", "lx_shareWebApp"});
        map.put("LxStorage", new String[]{"lx_setStorage", "lx_getStorage", "lx_removeStorage", "lx_clearStorage", "lx_commitStorage"});
        map.put(LxAdPlugin.PLUGIN_NAME, new String[]{"lx_preloadAd", "lx_showAd", "lx_getAdRequestId", "lx_getAdSDKVersion", "lx_hideAdView"});
        map.put("LxCircleGroup", new String[]{"lx_addCircleGroup"});
        map.put("LxUserRelation", new String[]{"lx_showContactDetails"});
        map.put("LxKeep", new String[]{"lx_keepJumpGroup", "lx_keepPlayVideo"});
        hashSet.add("lx_getWebViewSize");
        hashSet.add("lx_closeWebView");
        hashSet.add("lx_getDeviceInfo");
        hashSet.add("lx_showToast");
        hashSet.add("lx_alert");
    }

    @Deprecated
    public PluginManager(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface) {
        this(cordovaWebView, cordovaInterface, null);
    }

    private boolean canExecPlugin(String str, String str2, String str3) {
        if (str3.startsWith("lx_") || str3.equals("grantApp")) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            if ((str.contains("javascript") && str.contains("zx.")) || SafeChecker.checkUxssAttackForDangerAction(str, str2)) {
                LogUtil.i(TAG, "canExecPlugin check fail url =" + str + " service=" + str2);
                return false;
            }
            if (str.equals("file:///android_asset/test.html") || str.equals("file:///android_asset/lxopenapi.html") || "PublicUtils".equals(str2)) {
                return true;
            }
            try {
                URL url = new URL(str);
                for (String str4 : JSSDK_WHITELIST) {
                    if (url.getUserInfo() == null) {
                        String host = url.getHost();
                        if (host.endsWith("." + str4) || host.equals(str4)) {
                            return true;
                        }
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkApiPermission(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("lx_") || SUPPORT_API_DEFUALT.contains(str)) {
            return true;
        }
        return this.jsApiManager.e(this.app.loadedUrl, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CordovaPlugin instantiatePlugin(String str) {
        Class<?> cls;
        if (str != null) {
            try {
                cls = !"".equals(str) ? Class.forName(str) : null;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error adding plugin " + str + ".");
                return null;
            }
        }
        if ((cls != null) && CordovaPlugin.class.isAssignableFrom(cls)) {
            return (CordovaPlugin) cls.newInstance();
        }
        return null;
    }

    private boolean isApiSupport(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("lx_")) {
            return true;
        }
        Iterator<String> it = SUPPORT_API.keySet().iterator();
        while (it.hasNext()) {
            for (String str2 : SUPPORT_API.get(it.next())) {
                ma3.a("apiName: " + str2 + " action:" + str, new Object[0]);
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addService(String str, String str2) {
        addService(new PluginEntry(str, str2, false));
    }

    public JSONObject checkJsApi(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                jSONObject.putOpt(string.substring(3), Boolean.valueOf(isApiSupport(string)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Deprecated
    public void clearPluginObjects() {
        this.pluginMap.clear();
    }

    public void exec(String str, String str2, String str3, String str4) {
        ma3.f("exec plugin service:" + str + " action:" + str2 + "url=" + this.app.loadedUrl);
        if (canExecPlugin(this.app.loadedUrl, str, str2)) {
            CordovaPlugin plugin = getPlugin(str);
            if (plugin == null) {
                Log.d(TAG, "exec() call to unknown plugin: " + str);
                this.app.sendPluginResult(new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION), str3);
                return;
            }
            CallbackContext callbackContext = new CallbackContext(str3, this.app);
            if (!checkApiPermission(str2)) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.PERMISSION_DENIED));
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean zExecute = plugin.execute(str2, str4, callbackContext);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis2 > SLOW_EXEC_WARNING_THRESHOLD) {
                    Log.w(TAG, "THREAD WARNING: exec() call to " + str + "." + str2 + " blocked the main thread for " + jCurrentTimeMillis2 + "ms. Plugin should use CordovaInterface.getThreadPool().");
                }
                if (zExecute) {
                    return;
                }
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
            } catch (JSONException e) {
                ma3.c(e);
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
            } catch (Exception e2) {
                Log.e(TAG, "Uncaught exception from plugin", e2);
                callbackContext.error(e2.getMessage());
            }
        }
    }

    public ka3.b getAppInfo(String str) {
        return this.jsApiManager.b(str);
    }

    public CordovaPlugin getPlugin(String str) {
        CordovaPlugin cordovaPluginInstantiatePlugin = this.pluginMap.get(str);
        if (cordovaPluginInstantiatePlugin == null) {
            PluginEntry pluginEntry = this.entryMap.get(str);
            if (pluginEntry == null) {
                return null;
            }
            CordovaPlugin cordovaPlugin = pluginEntry.plugin;
            cordovaPluginInstantiatePlugin = cordovaPlugin != null ? cordovaPlugin : instantiatePlugin(pluginEntry.pluginClass);
            CordovaInterface cordovaInterface = this.ctx;
            CordovaWebView cordovaWebView = this.app;
            cordovaPluginInstantiatePlugin.privateInitialize(cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
            this.pluginMap.put(str, cordovaPluginInstantiatePlugin);
        }
        return cordovaPluginInstantiatePlugin;
    }

    public void grantApp(String str, e84 e84Var) {
        this.jsApiManager.d(this.app.loadedUrl, str, e84Var);
    }

    public void init() {
        LOG.d(TAG, "init()");
        onPause(false);
        onDestroy();
        this.pluginMap.clear();
        startupPlugins();
    }

    public boolean isInWhiteList(String str) {
        try {
            URL url = new URL(str);
            for (String str2 : JSSDK_WHITELIST) {
                if (url.getUserInfo() == null) {
                    String host = url.getHost();
                    if (host.endsWith("." + str2) || host.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onDestroy() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onDestroy();
            }
        }
    }

    public void onNewIntent(Intent intent) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onNewIntent(intent);
            }
        }
    }

    public boolean onOverrideUrlLoading(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            List<String> list = this.urlMap.get(pluginEntry.service);
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (str.startsWith(it.next())) {
                        return getPlugin(pluginEntry.service).onOverrideUrlLoading(str);
                    }
                }
            } else {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
                if (cordovaPlugin != null && cordovaPlugin.onOverrideUrlLoading(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onPause(boolean z) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onPause(z);
            }
        }
    }

    public boolean onReceivedClientCertRequest(CordovaWebView cordovaWebView, ICordovaClientCertRequest iCordovaClientCertRequest) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && cordovaPlugin.onReceivedClientCertRequest(cordovaWebView, iCordovaClientCertRequest)) {
                return true;
            }
        }
        return false;
    }

    public boolean onReceivedHttpAuthRequest(CordovaWebView cordovaWebView, ICordovaHttpAuthHandler iCordovaHttpAuthHandler, String str, String str2) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && cordovaPlugin.onReceivedHttpAuthRequest(cordovaWebView, iCordovaHttpAuthHandler, str, str2)) {
                return true;
            }
        }
        return false;
    }

    public void onReset() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onReset();
            }
        }
    }

    public void onResume(boolean z) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onResume(z);
            }
        }
    }

    public Object postMessage(String str, Object obj) {
        Object objOnMessage;
        Object objOnMessage2 = this.ctx.onMessage(str, obj);
        if (objOnMessage2 != null) {
            return objOnMessage2;
        }
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && (objOnMessage = cordovaPlugin.onMessage(str, obj)) != null) {
                return objOnMessage;
            }
        }
        return null;
    }

    public Uri remapUri(Uri uri) {
        Uri uriRemapUri;
        try {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null && (uriRemapUri = cordovaPlugin.remapUri(uri)) != null) {
                    return uriRemapUri;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPluginEntries(List<PluginEntry> list) {
        onPause(false);
        onDestroy();
        this.pluginMap.clear();
        this.urlMap.clear();
        Iterator<PluginEntry> it = list.iterator();
        while (it.hasNext()) {
            addService(it.next());
        }
    }

    @Deprecated
    public void startupPlugins() {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            if (pluginEntry.onload) {
                getPlugin(pluginEntry.service);
            } else {
                this.pluginMap.put(pluginEntry.service, null);
            }
        }
    }

    public PluginManager(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface, List<PluginEntry> list) {
        this.pluginMap = new HashMap<>();
        this.entryMap = new HashMap<>();
        this.jsApiManager = new ka3();
        this.urlMap = new HashMap<>();
        this.ctx = cordovaInterface;
        this.app = cordovaWebView;
        if (list == null) {
            ConfigXmlParser configXmlParser = new ConfigXmlParser();
            configXmlParser.parse(cordovaInterface.getActivity());
            list = configXmlParser.getPluginEntries();
        }
        setPluginEntries(list);
    }

    public void addService(PluginEntry pluginEntry) {
        this.entryMap.put(pluginEntry.service, pluginEntry);
        List<String> urlFilters = pluginEntry.getUrlFilters();
        if (urlFilters != null) {
            this.urlMap.put(pluginEntry.service, urlFilters);
        }
        CordovaPlugin cordovaPlugin = pluginEntry.plugin;
        if (cordovaPlugin != null) {
            CordovaInterface cordovaInterface = this.ctx;
            CordovaWebView cordovaWebView = this.app;
            cordovaPlugin.privateInitialize(cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
            this.pluginMap.put(pluginEntry.service, pluginEntry.plugin);
        }
    }

    @Deprecated
    public void exec(String str, String str2, String str3, String str4, boolean z) {
        exec(str, str2, str3, str4);
    }

    @Deprecated
    public void loadPlugins() {
    }
}

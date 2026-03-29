package org.apache.cordova.jssdk;

import android.app.Activity;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.H5CallListener;
import defpackage.ka3;
import defpackage.l6;
import defpackage.ma3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxBaseAdPlugin extends CordovaPlugin {
    public static final String KEY_REQUEST_ID = "requestId";
    protected Map<String, String> mCallbacks = new HashMap();
    protected Set<String> mRequestIds = new HashSet();
    private boolean mIsDestroyed = false;

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        synchronized (this) {
            this.mIsDestroyed = true;
            try {
                for (String str : this.mRequestIds) {
                    if (str != null) {
                        AdHelperH5Ad.INSTANCE.destroyAd(str);
                    }
                }
            } catch (Exception e) {
                ma3.c(e);
            }
        }
        super.onDestroy();
    }

    public void requestH5Banner(String str, final CallbackContext callbackContext) {
        ma3.f("requestH5Banner: " + str);
        Activity activity = this.cordova.getActivity();
        if (activity == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            CordovaWebView cordovaWebView = this.webView;
            ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
            HashMap map = new HashMap();
            String string = jSONObject.getString("requestId");
            int iOptInt = jSONObject.optInt("adType", 1);
            int iOptInt2 = jSONObject.optInt("scene", 1);
            if (!l6.f(iOptInt2)) {
                ma3.f("[H5Ad] ad config has not opened.");
                callbackContext.error("ad config has not opened.");
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("default_config");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            String strOptString = jSONObject.optString("domId");
            map.put("requestId", string);
            map.put("appId", appInfo.f21948a);
            map.put("h5EventExt", jSONObject.optString("h5EventExt"));
            AdParams adParamsBuild = new AdParams.Builder().setAppId(appInfo.f21948a).setScene(iOptInt2).setExt(map).setH5AdType(iOptInt).setAdUnitId(strOptString).setDefaultConfig(jSONObjectOptJSONObject.toString()).build();
            ma3.f("real start " + str);
            synchronized (this) {
                if (this.mIsDestroyed) {
                    return;
                }
                this.mRequestIds.add(string);
                AdHelperH5Ad.INSTANCE.getH5Ad(activity, adParamsBuild, new H5CallListener() { // from class: org.apache.cordova.jssdk.LxBaseAdPlugin.1
                    @Override // com.wifi.ad.core.listener.H5CallListener
                    public void onResult(String str2, String str3, String str4) {
                        ma3.f(String.format("requestOnResult: s:%s s1:%s s2:%s", str2, str3, str4));
                        if ("onStart".equals(str3)) {
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("requestId", str2);
                            jSONObject2.put("action", str3);
                            try {
                                jSONObject2.put("msg", new JSONObject(str4));
                            } catch (JSONException e) {
                                ma3.c(e);
                                jSONObject2.put("msg", str4);
                            }
                        } catch (JSONException e2) {
                            ma3.c(e2);
                        }
                        callbackContext.success(jSONObject2.toString());
                    }
                });
            }
        } catch (JSONException e) {
            ma3.c(e);
        }
    }
}

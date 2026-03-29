package com.lantern.auth.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.conf.WkSDKConfig;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpPostManager;
import com.lantern.auth.http.HttpSign;
import com.lantern.auth.server.WkPlatform;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSDKManager {
    private static WkSDKManager mInstance = new WkSDKManager();
    private String channel;
    private WkSDKConfig config;
    private Context context;
    private String deviceId;
    private HttpSign hs;
    private TransferRevceiver mTReceiver;
    private String thirdAppId;
    private boolean isInit = false;
    private int permissions = 0;

    public static String getAppId() {
        return mInstance.thirdAppId;
    }

    public static String getChannel() {
        BLLog.d("mInstance.channel" + mInstance.channel, new Object[0]);
        return TextUtils.isEmpty(mInstance.channel) ? WkPlatform.getChannelName(mInstance.context) : mInstance.channel;
    }

    private WkSDKConfig getConfigFromCache() {
        try {
            String string = this.context.getSharedPreferences("wk_sdk_conf", 0).getString(b.Y, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new WkSDKConfig(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new WkSDKConfig();
    }

    public static Context getContext() {
        return mInstance.context;
    }

    public static String getDeviceId() {
        return mInstance.deviceId;
    }

    public static int getPermissions() {
        return mInstance.permissions;
    }

    public static WkSDKConfig getSdkConfig() {
        WkSDKManager wkSDKManager = mInstance;
        if (wkSDKManager.config == null) {
            wkSDKManager.config = new WkSDKConfig();
        }
        return mInstance.config;
    }

    public static HttpSign getSign() {
        return mInstance.hs;
    }

    public static synchronized void init(Application application, String str, String str2, int i, String str3) {
        WkSDKManager wkSDKManager = mInstance;
        if (wkSDKManager.isInit) {
            return;
        }
        try {
            wkSDKManager.context = application;
            wkSDKManager.thirdAppId = str;
            wkSDKManager.permissions = i;
            wkSDKManager.hs = new HttpSign(application);
            mInstance.loadConfig();
            WkSDKManager wkSDKManager2 = mInstance;
            wkSDKManager2.channel = str2;
            wkSDKManager2.initDeviceId(str3);
            HttpPostManager.init();
            WkSDKManager wkSDKManager3 = mInstance;
            if (wkSDKManager3.mTReceiver == null) {
                wkSDKManager3.mTReceiver = new TransferRevceiver();
                mInstance.mTReceiver.registTransferReceiver(application);
            }
            mInstance.isInit = true;
        } catch (Throwable unused) {
            mInstance.isInit = false;
        }
    }

    private void initDeviceId(String str) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("wk_sdk_conf", 0);
        String string = sharedPreferences.getString("deviceId", "");
        if (!TextUtils.isEmpty(string)) {
            this.deviceId = string;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString().replace("-", "");
        }
        this.deviceId = str;
        sharedPreferences.edit().putString("deviceId", this.deviceId).apply();
    }

    public static synchronized boolean isInit() {
        return mInstance.isInit;
    }

    private void loadConfig() {
        WkSDKConfig configFromCache = getConfigFromCache();
        this.config = configFromCache;
        if (configFromCache.needFresh()) {
            loadConfigFromServer(null);
        }
    }

    public static void loadConfigFromServer(final BLCallback bLCallback) {
        try {
            HashMap<String, String> publicParams = mInstance.hs.getPublicParams();
            publicParams.put("thirdAppId", mInstance.thirdAppId);
            mInstance.hs.signParams(null, publicParams);
            HttpPostManager.postMap(publicParams, new BLCallback() { // from class: com.lantern.auth.app.WkSDKManager.1
                @Override // com.lantern.auth.core.BLCallback
                public void run(int i, String str, Object obj) {
                    BLLog.d("loadconfig " + obj, new Object[0]);
                    if (i == 1) {
                        if (obj == null) {
                            obj = "";
                        }
                        try {
                            String strOptString = new JSONObject(obj.toString()).optString("data");
                            if (TextUtils.isEmpty(strOptString)) {
                                WkSDKManager.mInstance.config = new WkSDKConfig();
                            } else {
                                WkSDKManager.mInstance.config = new WkSDKConfig(strOptString);
                            }
                            WkSDKManager.saveConf(WkSDKManager.mInstance.config);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    BLCallback bLCallback2 = bLCallback;
                    if (bLCallback2 != null) {
                        bLCallback2.run(1, null, WkSDKManager.getSdkConfig());
                    }
                }
            }, WkConstants.ServerConsts.getUrl(WkConstants.ServerConsts.URL_GET_CONFIG));
        } catch (Throwable th) {
            th.printStackTrace();
            if (bLCallback != null) {
                bLCallback.run(1, null, getSdkConfig());
            }
        }
    }

    public static void saveConf(WkSDKConfig wkSDKConfig) {
        try {
            if (wkSDKConfig != null) {
                try {
                    wkSDKConfig.put("update_time", System.currentTimeMillis());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                WkSDKManager wkSDKManager = mInstance;
                wkSDKManager.config = wkSDKConfig;
                wkSDKManager.context.getSharedPreferences("wk_sdk_conf", 0).edit().putString(b.Y, wkSDKConfig.toString()).apply();
                BLLog.d("save config", new Object[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setPermissions(int i) {
        mInstance.permissions = i;
    }

    public static void updateTransferSid(String str) {
        mInstance.mTReceiver.updateSid(str);
    }
}

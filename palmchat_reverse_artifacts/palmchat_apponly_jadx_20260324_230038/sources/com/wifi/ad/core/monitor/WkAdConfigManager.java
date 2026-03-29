package com.wifi.ad.core.monitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.wifi.ad.core.data.FilterConfigBean;
import com.wifi.ad.core.monitor.WkAdConfigResponse;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.DeviceUtils;
import com.wifi.ad.core.utils.JsonUtil;
import com.wifi.ad.core.utils.SharePreferenceUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkAdConfigManager implements IWkConfigCallBack<WkAdConfigResponse.SdkResponse> {
    private static final String DEFAULT_APPID = "lxf48f512f7d6a47c2";
    public static final String FILTER_CONFIG = "adsdk_filter_config";
    public static Map<String, FilterConfigBean> configMap = new HashMap();
    private static final String mSpName = "wkadsdk_config_adx_";
    private Context mContext;
    private final String mSpSceneKey = "_scene";
    private final String mSpDiDKey = "wkadsdk_did_key";
    private final String mSpLastUpdateKey = "wkadsdk_last_update_key";

    public WkAdConfigManager(Context context) {
        this.mContext = context;
    }

    private byte[] encrypt(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(MessageDigest.getInstance("md5").digest(str2.getBytes("utf-8")), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAidUser(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String string = SharePreferenceUtils.INSTANCE.getString("ad_js_s23", "ymsmx0yt8o6dgr63cy6u6vlwmocq9y7i", null);
                String strDoGet = WkConfigHttp.doGet("http://openapi.51y5.net/alps-openapi/api/v2/530c24d641696ce0eba82bf5ef7c2d62?p=device&q=" + toString(encrypt("[\"appId=" + str2 + "\",\"aid=__AID__\"]".replaceAll("__AID__", str), string)));
                Log.d("WkAdConfigManager", "wwwws getAidUser " + strDoGet);
                if (!TextUtils.isEmpty(strDoGet)) {
                    JSONObject jSONObject = new JSONObject(strDoGet);
                    if (jSONObject.optInt("code") == 0) {
                        return jSONObject.optString("object", "");
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String getAppId(String str) {
        return TextUtils.isEmpty(str) ? DEFAULT_APPID : str;
    }

    private static String getConfigInfo(SharedPreferences sharedPreferences) {
        return sharedPreferences == null ? "" : sharedPreferences.getString(FILTER_CONFIG, "");
    }

    private long getLastUpdateTime(SharedPreferences sharedPreferences, int i) {
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("wkadsdk_last_update_key" + i, 0L);
    }

    public static FilterConfigBean getLocalFilterConfig(Context context, String str) {
        String appId = getAppId(str);
        if (configMap.get(appId) != null) {
            return configMap.get(appId);
        }
        String configInfo = getConfigInfo(getSp(context, mSpName, appId));
        if (TextUtils.isEmpty(configInfo)) {
            return null;
        }
        return (FilterConfigBean) JsonUtil.INSTANCE.fromJson(configInfo, FilterConfigBean.class);
    }

    private static SharedPreferences getSp(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(str + str2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(int i, String str, String str2, String str3, String str4, String str5) {
        WkConfigHttp.postResponseData(this.mContext, str, i, str3, str2, this, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAidUser(String str, String str2, SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    private void saveBlockinfo(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    private void saveCurrTime(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong("wkadsdk_last_update_key" + str, System.currentTimeMillis()).apply();
    }

    private void saveStrategy(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    private void saveSuccess(WkAdConfigResponse.SdkResponse sdkResponse, String str, String str2) {
        if (sdkResponse != null) {
            SharedPreferences sp = getSp(this.mContext, mSpName, str2);
            String strategy = sdkResponse.getStrategy();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strategy) && sdkResponse.getCode() == 0) {
                saveStrategy(sp, str, strategy);
            }
            String blockinfo = sdkResponse.getBlockinfo();
            if (TextUtils.isEmpty(blockinfo)) {
                return;
            }
            saveCurrTime(sp, str);
            saveBlockinfo(sp, FILTER_CONFIG, blockinfo);
            configMap.put(str2, (FilterConfigBean) JsonUtil.INSTANCE.fromJson(blockinfo, FilterConfigBean.class));
        }
    }

    private String toString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public String getDidBySp(SharedPreferences sharedPreferences) {
        return sharedPreferences == null ? "" : sharedPreferences.getString("wkadsdk_did_key", "");
    }

    public void requestConfig(final int i, final String str, final String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String appId = getAppId(str3);
        final SharedPreferences sp = getSp(this.mContext, mSpName, appId);
        long lastUpdateTime = getLastUpdateTime(sp, i);
        if (System.currentTimeMillis() - lastUpdateTime >= (getLocalFilterConfig(this.mContext, appId) != null ? r14.getUpdate_interval() : 0L) * 60 * 60 * 1000) {
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.monitor.WkAdConfigManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String didBySp = WkAdConfigManager.this.getDidBySp(sp);
                    NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                    String androidId = nestInfoTaker.getAndroidId();
                    String aidUser = WkAdConfigManager.getAidUser(androidId, sp);
                    if (TextUtils.isEmpty(aidUser)) {
                        String packageName = DeviceUtils.getPackageName(WkAdConfigManager.this.mContext);
                        aidUser = "com.snda.lantern.wifilocating".equals(packageName) ? WkAdConfigManager.this.getAidUser(androidId, "A0016") : "com.snda.wifilocating".equals(packageName) ? WkAdConfigManager.this.getAidUser(androidId, "A0008") : "";
                        if (!TextUtils.isEmpty(aidUser) && !"0".equals(aidUser)) {
                            WkAdConfigManager.this.saveAidUser(androidId, aidUser, sp);
                        }
                    }
                    String str4 = aidUser;
                    if (TextUtils.isEmpty(didBySp)) {
                        didBySp = DeviceUtils.getAesRes(nestInfoTaker.getImEI1(WkAdConfigManager.this.mContext), "", androidId, nestInfoTaker.getOaId());
                        if (!TextUtils.isEmpty(didBySp)) {
                            WkAdConfigManager.this.saveDidSp(sp, didBySp);
                        }
                    }
                    WkAdConfigManager.this.requestAdHttp(i, str, didBySp, str2, str4, appId);
                }
            });
        }
    }

    public void saveDidSp(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null || TextUtils.isEmpty(str)) {
            return;
        }
        sharedPreferences.edit().putString("wkadsdk_did_key", str).apply();
    }

    @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
    public void dataSuccess(WkAdConfigResponse.SdkResponse sdkResponse, int i, String str) {
        saveSuccess(sdkResponse, i + "", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAidUser(String str, SharedPreferences sharedPreferences) {
        return sharedPreferences == null ? "" : sharedPreferences.getString(str, "");
    }

    @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
    public void dataError(String str) {
    }
}

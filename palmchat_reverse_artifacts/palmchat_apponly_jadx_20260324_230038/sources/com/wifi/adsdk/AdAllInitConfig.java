package com.wifi.adsdk;

import android.text.TextUtils;
import com.wifi.adsdk.utils.AesEcbUtils;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdUtil;
import com.wifi.adsdk.utils.OkHttpUtils;
import java.io.IOException;
import java.util.concurrent.Executors;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdAllInitConfig {
    public static JSONObject adShowConfigObj = null;
    public static int adTimeOut = 10000;
    public static boolean allowMac = false;
    public static boolean isCanUseInstalledPackages = false;
    public static JSONObject replaceConfigObj;

    public static int getInterstitialDelayTime(String str) {
        int iOptInt;
        if (adShowConfigObj == null || TextUtils.isEmpty(str) || !adShowConfigObj.has(str) || (iOptInt = adShowConfigObj.optJSONObject(str).optInt("interstitial_delay_time", 0)) <= 0) {
            return 0;
        }
        return iOptInt;
    }

    public static int getNativeDelayPp(String str) {
        int iOptInt;
        if (adShowConfigObj == null || TextUtils.isEmpty(str) || !adShowConfigObj.has(str) || (iOptInt = adShowConfigObj.optJSONObject(str).optInt("native_delay_pp", 0)) <= 0) {
            return 0;
        }
        if (iOptInt >= 100) {
            return 100;
        }
        return iOptInt;
    }

    public static int getSplashDelayTime(String str) {
        int iOptInt;
        if (adShowConfigObj == null || TextUtils.isEmpty(str) || !adShowConfigObj.has(str) || (iOptInt = adShowConfigObj.optJSONObject(str).optInt("splash_delay_time", 0)) <= 0) {
            return 0;
        }
        return iOptInt;
    }

    public static void initAllConfig(final String str, final String str2, final boolean z) {
        Executors.newCachedThreadPool().execute(new Runnable() { // from class: com.wifi.adsdk.AdAllInitConfig.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", str);
                    String strEncrypt = AesEcbUtils.encrypt(jSONObject.toString());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appId", str);
                    jSONObject2.put("token", str2);
                    jSONObject2.put("data", strEncrypt);
                    LxAdLog.d("LxAd initAllConfig OkHttpUtils start reqObj " + jSONObject2.toString());
                    String str3 = LxAdUtil.URL_CONFIG_RELEASE;
                    if (z) {
                        str3 = LxAdUtil.URL_CONFIG_TEST;
                    }
                    OkHttpUtils.getInstance().getOkHttpClient().newCall(new Request.Builder().url(str3).post(RequestBody.create(MediaType.parse("application/json"), jSONObject2.toString())).addHeader("Content-type", "application/json").build()).enqueue(new Callback() { // from class: com.wifi.adsdk.AdAllInitConfig.1.1
                        @Override // okhttp3.Callback
                        public void onFailure(Call call, IOException iOException) {
                            LxAdLog.d("LxAd initAllConfig OkHttpUtils onFailure e " + iOException.toString());
                        }

                        @Override // okhttp3.Callback
                        public void onResponse(Call call, Response response) {
                            if (response != null) {
                                try {
                                    String strString = response.body().string();
                                    LxAdLog.d("LxAd initAllConfig OkHttpUtils onResponse result " + strString);
                                    JSONObject jSONObject3 = new JSONObject(strString);
                                    if (jSONObject3.optInt("resultCode") == 0) {
                                        String strOptString = jSONObject3.optString("data");
                                        if (TextUtils.isEmpty(strOptString)) {
                                            return;
                                        }
                                        String strDecrypt = AesEcbUtils.decrypt(strOptString);
                                        JSONObject jSONObject4 = new JSONObject(strDecrypt);
                                        AdAllInitConfig.adTimeOut = jSONObject4.optInt("adTimeOut");
                                        LxAdLog.d("LxAd initAllConfig OkHttpUtils onResponse aes end " + strDecrypt + " adTimeOut " + AdAllInitConfig.adTimeOut);
                                        String chanId = LxAdManager.getAdManager().getConfig().getRealAppRuntime().getChanId();
                                        if (!TextUtils.isEmpty(chanId)) {
                                            JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray("isCanUseInstalledPackages");
                                            int i = 0;
                                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                                int i2 = 0;
                                                while (true) {
                                                    if (i2 >= jSONArrayOptJSONArray.length()) {
                                                        break;
                                                    }
                                                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                                                    String strOptString2 = jSONObjectOptJSONObject.optString("channelId");
                                                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("channelSwitch");
                                                    if (chanId.equals(strOptString2)) {
                                                        AdAllInitConfig.isCanUseInstalledPackages = zOptBoolean;
                                                        break;
                                                    } else {
                                                        if ("all".equals(strOptString2)) {
                                                            AdAllInitConfig.isCanUseInstalledPackages = zOptBoolean;
                                                            break;
                                                        }
                                                        i2++;
                                                    }
                                                }
                                            }
                                            JSONArray jSONArrayOptJSONArray2 = jSONObject4.optJSONArray("mac");
                                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                                while (true) {
                                                    if (i >= jSONArrayOptJSONArray2.length()) {
                                                        break;
                                                    }
                                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i);
                                                    String strOptString3 = jSONObjectOptJSONObject2.optString("channelId");
                                                    boolean zOptBoolean2 = jSONObjectOptJSONObject2.optBoolean("channelSwitch");
                                                    if (chanId.equals(strOptString3)) {
                                                        AdAllInitConfig.allowMac = zOptBoolean2;
                                                        break;
                                                    } else {
                                                        if ("all".equals(strOptString3)) {
                                                            AdAllInitConfig.allowMac = zOptBoolean2;
                                                            break;
                                                        }
                                                        i++;
                                                    }
                                                }
                                            }
                                        }
                                        LxAdLog.d("LxAd initAllConfig OkHttpUtils onResponse allowMac " + AdAllInitConfig.allowMac + " isCanUseInstalledPackages " + AdAllInitConfig.isCanUseInstalledPackages);
                                        AdAllInitConfig.replaceConfigObj = jSONObject4.optJSONObject("replaceConfig");
                                        AdAllInitConfig.adShowConfigObj = jSONObject4.optJSONObject("adShowConfig");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
        });
    }
}

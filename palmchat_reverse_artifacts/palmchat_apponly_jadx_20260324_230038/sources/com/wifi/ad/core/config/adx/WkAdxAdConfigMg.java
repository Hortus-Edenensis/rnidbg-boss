package com.wifi.ad.core.config.adx;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.config.adx.model.WkAdFreqControl;
import com.wifi.ad.core.config.adx.model.WkAdMutliPrice;
import com.wifi.ad.core.config.adx.model.WkAdStrategyModel;
import com.wifi.ad.core.monitor.AesAdUtils;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.monitor.WkAdConfigResponse;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkAdxAdConfigMg {
    public static final String DSP_NAME_BAIDU = "B";
    public static final String DSP_NAME_CSJ = "C";
    public static final String DSP_NAME_GDT = "G";
    public static final String DSP_NAME_KS = "K";
    public static final String DSP_NAME_WIFI = "W";
    public static HashMap<String, Integer> mAllDspIdMap = new HashMap<>();
    private Context mContext;
    private SharedPreferences mSp;
    private final String NEST_SDK_AD_CONFIG_START = "nest_sdk_ad_config_start";
    private final String NEST_SDK_AD_CONFIG_ERROR = "nest_sdk_ad_config_error";
    private final String NEST_SDK_AD_CONFIG_SUCCESS = "nest_sdk_ad_config_success";
    private final String mSpName = "wkadx_config_sdk";
    private final String mSpDiDKey = "wkadsdk_did_key";
    private final String mSpLastUpdateKey = "wkadsdk_adx_last_update_key";
    private long mUpDateTime = 24;

    public WkAdxAdConfigMg(Context context) {
        this.mSp = null;
        this.mContext = context;
        this.mSp = context.getSharedPreferences("wkadx_config_sdk", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configMda(String str, AdParams adParams, String str2) {
        try {
            WifiNestAd.reporter.onEvent(str, new EventParams.Builder().setNestType(adParams.getNestType()).setErrorCode(str2).build(), adParams.getExt());
        } catch (Exception unused) {
        }
    }

    private WkAdConfigModel createAdModel(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                WkAdConfigModel wkAdConfigModel = new WkAdConfigModel();
                try {
                    wkAdConfigModel.setRequestId(str2);
                    int iOptInt = jSONObject.optInt(WkAdConfigModel.TAG_BIDTYPE);
                    wkAdConfigModel.setBidType(iOptInt);
                    wkAdConfigModel.setUpdateTime(jSONObject.optInt(WkAdConfigModel.TAG_UPDATETIME, 24));
                    wkAdConfigModel.setTimeOut(jSONObject.optInt(WkAdConfigModel.TAG_TIMEOUT));
                    wkAdConfigModel.setSourceId(jSONObject.optString("srcid"));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(WkAdConfigModel.TAG_FREQCONTROL);
                    if (jSONObjectOptJSONObject != null) {
                        WkAdFreqControl wkAdFreqControl = new WkAdFreqControl();
                        wkAdFreqControl.setInterval(jSONObjectOptJSONObject.optInt("interval"));
                        wkAdConfigModel.setFreqControl(wkAdFreqControl);
                    }
                    wkAdConfigModel.setOther4BidType(jSONObject.optInt(WkAdConfigModel.TAG_OTHER_BIDTYPE));
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(WkAdConfigModel.TAG_STRATEGY);
                    if (jSONArrayOptJSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            WkAdStrategyModel wkAdStrategyModel = new WkAdStrategyModel();
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                            wkAdStrategyModel.setDspId(jSONObjectOptJSONObject2.optInt("dspid"));
                            String strOptString = jSONObjectOptJSONObject2.optString("dspname");
                            if (!TextUtils.isEmpty(strOptString)) {
                                if (strOptString.contains("W")) {
                                    wkAdConfigModel.setHasWifiAd(true);
                                }
                                if (strOptString.contains(DSP_NAME_GDT)) {
                                    wkAdConfigModel.setHasGdtAd(true);
                                }
                                if (strOptString.contains(DSP_NAME_CSJ)) {
                                    wkAdConfigModel.setHasCsjAd(true);
                                }
                                if (strOptString.contains(DSP_NAME_BAIDU)) {
                                    wkAdConfigModel.setHasBaiDuAd(true);
                                }
                                if (strOptString.contains("K")) {
                                    wkAdConfigModel.setHasKSAd(true);
                                }
                            }
                            wkAdStrategyModel.setDspName(strOptString);
                            int iOptInt2 = jSONObjectOptJSONObject2.optInt("dspid");
                            wkAdStrategyModel.setDspId(iOptInt2);
                            mAllDspIdMap.put(strOptString, Integer.valueOf(iOptInt2));
                            wkAdStrategyModel.setAllBlock(jSONObjectOptJSONObject2.optInt("block"));
                            wkAdStrategyModel.setPriority(jSONObjectOptJSONObject2.optInt("priority"));
                            if (iOptInt == 3) {
                                wkAdStrategyModel.setPriority(i + 1);
                            }
                            wkAdStrategyModel.setEcpm(jSONObjectOptJSONObject2.optInt("ecpm"));
                            wkAdStrategyModel.setRatio(jSONObjectOptJSONObject2.optInt("ratio"));
                            wkAdStrategyModel.setSlotId(jSONObjectOptJSONObject2.optString("slotid"));
                            wkAdStrategyModel.setGdtPopCloseTime(jSONObjectOptJSONObject2.optInt(WkAdConfigModel.TAG_GDT_CLOSETIME));
                            wkAdStrategyModel.setAdTimeOut(jSONObjectOptJSONObject2.optInt(WkAdConfigModel.TAG_TIMEOUT));
                            wkAdStrategyModel.setAdTemplate(jSONObjectOptJSONObject2.optInt(WkAdConfigModel.TAG_ADTEMPLETE));
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray(WkAdConfigModel.TAG_ECPMMAP);
                            if (jSONArrayOptJSONArray2 != null) {
                                wkAdStrategyModel.setEcpmLevelArray(jSONArrayOptJSONArray2);
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                    WkAdMutliPrice wkAdMutliPrice = new WkAdMutliPrice();
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                    wkAdMutliPrice.setCpmlevel(jSONObjectOptJSONObject3.optString(WkAdMutliPrice.TAG_CPMLEVEL));
                                    wkAdMutliPrice.setEcpm(jSONObjectOptJSONObject3.optInt("ecpm"));
                                    wkAdMutliPrice.setRatio(jSONObjectOptJSONObject3.optInt("ratio"));
                                    arrayList2.add(wkAdMutliPrice);
                                }
                                wkAdStrategyModel.setEcpmLevelMap(arrayList2);
                            }
                            arrayList.add(wkAdStrategyModel);
                        }
                        wkAdConfigModel.setAllModels(arrayList);
                    }
                    try {
                        return resetAdModel(wkAdConfigModel);
                    } catch (Exception unused) {
                        return wkAdConfigModel;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAesRes(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WkParams.IMEI, str);
            jSONObject.put("mac", str2);
            jSONObject.put("aid", str3);
            jSONObject.put("oaid", str4);
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            jSONObject.put("longitude", nestInfoTaker.getLongitude());
            jSONObject.put("latitude", nestInfoTaker.getLatitude());
            DeviceInfoUtil.INSTANCE.addDeviceInfo(jSONObject);
            String string = jSONObject.toString();
            WifiLog.d("aesStart WkAdxAdConfigMg " + string);
            return AesAdUtils.encryptAES(string);
        } catch (Exception unused) {
            return "";
        }
    }

    private String getDidBySp() {
        return this.mSp.getString("wkadsdk_did_key", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSceneKey(int i, String str) {
        return i + "_" + str;
    }

    private String parseAdDefaultConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("default_ad_config");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String popDefConfig(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            WifiLog.d("H5BannerAd getAdSdkConfig: 默认配置=" + str3);
            return str3;
        }
        if (getSceneKey(1, str2).equals(str)) {
            WifiLog.d("H5BannerAd getAdSdkConfig: 获取底部横幅默认配置 ");
            return "{\"bidtype\": 3,\"strategy\": [{\"ratio\": 1,\"ecpm\": 450,\"dspid\": 1,\"dspname\": \"C\",\"slotid\": \"946596697\",\"adtemplate\": 1,\"block\": 1}],\"srcid\": \"43\"}";
        }
        if (getSceneKey(13, str2).equals(str)) {
            WifiLog.d("H5BannerAd getAdSdkConfig: 获取H5激励视频默认配置 ");
            return "{\"bidtype\":3,\"strategy\":[{\"ratio\":1,\"ecpm\":10000,\"dspid\":1,\"dspname\":\"C\",\"slotid\":\"946597576\",\"adtemplate\":1,\"block\":1}],\"srcid\":\"46\"}";
        }
        if (getSceneKey(2, str2).equals(str)) {
            WifiLog.d("H5BannerAd getAdSdkConfig: 获取H5文中插屏默认配置 ");
            return "{\"bidtype\":3,\"strategy\":[{\"ratio\":1,\"ecpm\":450,\"dspid\":1,\"dspname\":\"C\",\"slotid\":\"946597458\",\"adtemplate\":1,\"block\":1}],\"srcid\":\"44\"}";
        }
        if (!getSceneKey(20, str2).equals(str)) {
            return "";
        }
        WifiLog.d("H5BannerAd getAdSdkConfig: 获取H5新插屏模板渲染默认配置 ");
        return "{\"bidtype\":3,\"strategy\":[{\"ratio\":1,\"ecpm\":5000,\"dspid\":1,\"dspname\":\"C\",\"slotid\":\"946597529\",\"adtemplate\":1,\"block\":1}],\"srcid\":\"45\"}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(int i, String str, String str2, String str3, String str4, String str5, final AdParams adParams) {
        configMda("nest_sdk_ad_config_start", adParams, "");
        WkAdxConfigHttp.postResponseData(this.mContext, str, i, str3, str4, str2, new IWkConfigCallBack<WkAdConfigResponse.SdkResponse>() { // from class: com.wifi.ad.core.config.adx.WkAdxAdConfigMg.2
            @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
            public void dataError(String str6) {
                WifiLog.d("H5BannerAd requestAdHttp dataError msg " + str6);
                WkAdxAdConfigMg.this.configMda("nest_sdk_ad_config_error", adParams, str6);
            }

            @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
            public void dataSuccess(WkAdConfigResponse.SdkResponse sdkResponse, int i2, String str6) {
                WifiLog.d("H5BannerAd requestAdHttp dataSuccess ");
                WkAdxAdConfigMg wkAdxAdConfigMg = WkAdxAdConfigMg.this;
                wkAdxAdConfigMg.saveSuccess(sdkResponse, wkAdxAdConfigMg.getSceneKey(i2, str6));
                WkAdxAdConfigMg.this.configMda("nest_sdk_ad_config_success", adParams, "");
            }
        }, str5);
    }

    private void requestConfig(final int i, final String str, final String str2, final String str3, final String str4, final AdParams adParams) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (System.currentTimeMillis() - this.mSp.getLong("wkadsdk_adx_last_update_key" + getSceneKey(i, str4), 0L) < this.mUpDateTime * 60 * 60 * 1000) {
            WifiLog.d("H5BannerAd requestConfig not allow ");
        } else {
            WifiLog.d("H5BannerAd requestConfig allow ");
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.config.adx.WkAdxAdConfigMg.1
                @Override // java.lang.Runnable
                public void run() {
                    NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                    String androidId = nestInfoTaker.getAndroidId();
                    WkAdxAdConfigMg wkAdxAdConfigMg = WkAdxAdConfigMg.this;
                    WkAdxAdConfigMg.this.requestAdHttp(i, str, wkAdxAdConfigMg.getAesRes(nestInfoTaker.getImEI1(wkAdxAdConfigMg.mContext), "", androidId, nestInfoTaker.getOaId()), str2, str3, str4, adParams);
                }
            });
        }
    }

    private void saveDidSp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSp.edit().putString("wkadsdk_did_key", str).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSuccess(WkAdConfigResponse.SdkResponse sdkResponse, String str) {
        if (sdkResponse != null) {
            String strategy = sdkResponse.getStrategy();
            WifiLog.d("H5BannerAd saveSuccess result " + strategy);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strategy) || sdkResponse.getCode() != 0) {
                return;
            }
            this.mSp.edit().putString(str, strategy).apply();
            this.mSp.edit().putLong("wkadsdk_adx_last_update_key" + str, System.currentTimeMillis()).apply();
        }
    }

    public WkAdConfigModel getAdSdkConfig(int i, String str, String str2, String str3, String str4, AdParams adParams) {
        WkAdConfigModel wkAdConfigModelCreateAdModel;
        if (this.mSp != null) {
            String adDefaultConfig = parseAdDefaultConfig(adParams.getDefaultConfig());
            String sceneKey = getSceneKey(i, str);
            WifiLog.d("H5BannerAd key:" + sceneKey);
            wkAdConfigModelCreateAdModel = createAdModel(this.mSp.getString(sceneKey, popDefConfig(sceneKey, str, adDefaultConfig)), str2);
            if (wkAdConfigModelCreateAdModel != null && wkAdConfigModelCreateAdModel.getUpdateTime() > 0) {
                this.mUpDateTime = wkAdConfigModelCreateAdModel.getUpdateTime();
            }
        } else {
            wkAdConfigModelCreateAdModel = null;
        }
        requestConfig(i, str2, str3, str4, str, adParams);
        WifiLog.d("H5BannerAd getAdSdkConfig: curAdConfigModel " + wkAdConfigModelCreateAdModel);
        return wkAdConfigModelCreateAdModel;
    }

    public List<WkAdStrategyModel> priorityAdModel(List<WkAdStrategyModel> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                WkAdStrategyModel wkAdStrategyModel = list.get(i);
                int priority = wkAdStrategyModel.getPriority();
                arrayList.add(Integer.valueOf(priority));
                map.put(Integer.valueOf(priority), wkAdStrategyModel);
            }
            Collections.sort(arrayList);
            list = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int iIntValue = ((Integer) arrayList.get(i2)).intValue();
                if (map.containsKey(Integer.valueOf(iIntValue))) {
                    WkAdStrategyModel wkAdStrategyModel2 = (WkAdStrategyModel) map.get(Integer.valueOf(iIntValue));
                    wkAdStrategyModel2.setPriority(i2 + 1);
                    list.add(wkAdStrategyModel2);
                }
            }
        }
        return list;
    }

    public List<WkAdStrategyModel> ratioAdModel(List<WkAdStrategyModel> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            int i = 0;
            if (size > 1) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        int ratio = list.get(i4).getRatio();
                        if (ratio == 0) {
                            ratio = 100;
                        }
                        i3 += ratio;
                    }
                    Random random = new Random();
                    random.nextInt();
                    int iNextInt = random.nextInt(i3);
                    int i5 = 0;
                    int ratio2 = 0;
                    while (true) {
                        if (i5 < list.size()) {
                            WkAdStrategyModel wkAdStrategyModel = list.get(i5);
                            ratio2 += wkAdStrategyModel.getRatio();
                            if (iNextInt < ratio2) {
                                arrayList.add(wkAdStrategyModel);
                                list.remove(i5);
                                break;
                            }
                            i5++;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    while (i < arrayList.size()) {
                        WkAdStrategyModel wkAdStrategyModel2 = (WkAdStrategyModel) arrayList.get(i);
                        i++;
                        wkAdStrategyModel2.setPriority(i);
                    }
                    return arrayList;
                }
            } else {
                list.get(0).setPriority(1);
            }
        }
        return list;
    }

    public WkAdConfigModel resetAdModel(WkAdConfigModel wkAdConfigModel) {
        List<WkAdStrategyModel> allModels;
        if (wkAdConfigModel != null && (allModels = wkAdConfigModel.getAllModels()) != null && allModels.size() > 0) {
            int bidType = wkAdConfigModel.getBidType();
            if (bidType == 2) {
                wkAdConfigModel.setAllModels(priorityAdModel(allModels));
            } else if (bidType == 1) {
                wkAdConfigModel.setAllModels(ratioAdModel(allModels));
            }
        }
        return wkAdConfigModel;
    }
}

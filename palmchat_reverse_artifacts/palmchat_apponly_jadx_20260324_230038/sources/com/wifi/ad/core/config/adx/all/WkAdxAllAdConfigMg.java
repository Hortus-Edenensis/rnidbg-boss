package com.wifi.ad.core.config.adx.all;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.adx.all.WkAdxAllResponse;
import com.wifi.ad.core.monitor.AesAdUtils;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkAdxAllAdConfigMg {
    private Context mContext;
    private SharedPreferences mSp;
    private final String NEST_SDK_INIT_AD_CONFIG_START = "nest_sdk_init_config_get";
    private final String NEST_SDK_INIT_AD_CONFIG_ERROR = "nest_sdk_init_config_fail";
    private final String NEST_SDK_INIT_AD_CONFIG_SUCCESS = "nest_sdk_init_config_return";
    private final String mSpName = "wkadx_config_sdk";
    private final String mSpLastUpdateKey = "wkadsdk_all_adx_last_update_key";
    private final String mSpFreqUpdateTimeKey = "wkadsdk_all_adx_freq_update_time_key";

    public WkAdxAllAdConfigMg(Context context) {
        this.mSp = null;
        this.mContext = context;
        this.mSp = context.getSharedPreferences("wkadx_config_sdk", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configMda(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("requestType", "2");
            map.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(this.mContext));
            WifiNestAd.reporter.onEvent(str, new EventParams.Builder().setErrorCode(str2).build(), new AdParams.Builder().setExt(map).build().getExt());
        } catch (Exception unused) {
        }
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
            jSONObject.put("os", "android");
            DeviceInfoUtil.INSTANCE.addDeviceInfo(jSONObject);
            String string = jSONObject.toString();
            WifiLog.d("aesStart WkAdxAllAdConfigMg " + string);
            return AesAdUtils.encryptAES(string);
        } catch (Exception unused) {
            return "";
        }
    }

    private String getSceneKey(int i, String str) {
        return i + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(String str, String str2, String str3) {
        configMda("nest_sdk_init_config_get", "");
        WkAdxAllConfigHttp.postResponseData(this.mContext, str, str2, str3, new IWkConfigCallBack<WkAdxAllResponse.AllStrategiesResponse>() { // from class: com.wifi.ad.core.config.adx.all.WkAdxAllAdConfigMg.2
            @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
            public void dataError(String str4) {
                WifiLog.d("H5Ad allConfig requestAdHttp dataError msg " + str4);
                WkAdxAllAdConfigMg.this.configMda("nest_sdk_init_config_fail", str4);
            }

            @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
            public void dataSuccess(WkAdxAllResponse.AllStrategiesResponse allStrategiesResponse, int i, String str4) {
                WifiLog.d("H5Ad allConfig requestAdHttp dataSuccess ");
                WkAdxAllAdConfigMg.this.saveSuccess(allStrategiesResponse);
                WkAdxAllAdConfigMg.this.configMda("nest_sdk_init_config_return", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSuccess(WkAdxAllResponse.AllStrategiesResponse allStrategiesResponse) {
        List<WkAdxAllResponse.AdStrategyData> dataList;
        if (allStrategiesResponse == null || (dataList = allStrategiesResponse.getDataList()) == null || dataList.isEmpty()) {
            return;
        }
        WifiLog.d("H5Ad allConfig adStrategyDataList.size " + dataList.size());
        for (WkAdxAllResponse.AdStrategyData adStrategyData : dataList) {
            String strategy = adStrategyData.getStrategy();
            int scene = adStrategyData.getScene();
            String appid = adStrategyData.getAppid();
            WifiLog.d("H5Ad allConfig saveSuccess result= " + strategy + " ::::  scene = " + scene + ":::  appId = " + appid);
            if (!TextUtils.isEmpty(appid) && !TextUtils.isEmpty(strategy) && allStrategiesResponse.getCode() == 0) {
                this.mSp.edit().putString(getSceneKey(scene, appid), strategy).apply();
            }
        }
        WifiLog.d("H5Ad allConfig updateInterval = " + allStrategiesResponse.getUpdateInterval());
        this.mSp.edit().putLong("wkadsdk_all_adx_last_update_key", System.currentTimeMillis()).apply();
        this.mSp.edit().putLong("wkadsdk_all_adx_freq_update_time_key", (long) allStrategiesResponse.getUpdateInterval()).apply();
    }

    public void requestAdxAllConfig(final String str, final String str2) {
        if (System.currentTimeMillis() - this.mSp.getLong("wkadsdk_all_adx_last_update_key", 0L) < this.mSp.getLong("wkadsdk_all_adx_freq_update_time_key", 180L) * 60 * 1000) {
            WifiLog.d("H5Ad allConfig requestConfig not allow ");
        } else {
            WifiLog.d("H5Ad allConfig requestConfig allow ");
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.config.adx.all.WkAdxAllAdConfigMg.1
                @Override // java.lang.Runnable
                public void run() {
                    NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                    String androidId = nestInfoTaker.getAndroidId();
                    WkAdxAllAdConfigMg wkAdxAllAdConfigMg = WkAdxAllAdConfigMg.this;
                    WkAdxAllAdConfigMg.this.requestAdHttp(str, str2, wkAdxAllAdConfigMg.getAesRes(nestInfoTaker.getImEI1(wkAdxAllAdConfigMg.mContext), "", androidId, nestInfoTaker.getOaId()));
                }
            });
        }
    }
}

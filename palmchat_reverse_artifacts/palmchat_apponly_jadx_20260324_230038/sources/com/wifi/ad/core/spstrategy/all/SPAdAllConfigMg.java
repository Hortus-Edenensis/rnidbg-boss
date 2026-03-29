package com.wifi.ad.core.spstrategy.all;

import android.content.Context;
import android.content.SharedPreferences;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.callback.LXRespHttpCallBack;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.monitor.AesAdUtils;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.spstrategy.SPStrategyMdaUtil;
import com.wifi.ad.core.spstrategy.all.WkSPAllResponse;
import com.wifi.ad.core.spstrategy.data.AdStrategy;
import com.wifi.ad.core.spstrategy.data.AdStrategyData;
import com.wifi.ad.core.spstrategy.data.AllStrategiesResponse;
import com.wifi.ad.core.spstrategy.data.SdkRequest;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SPAdAllConfigMg {
    private Context mContext;
    private SharedPreferences mSp;
    private final String NEST_SDK_AD_CONFIG_START = "nest_sdk_init_config_get";
    private final String NEST_SDK_AD_CONFIG_SUCCESS = "nest_sdk_init_config_return";
    private final String NEST_SDK_AD_CONFIG_ERROR = "nest_sdk_init_config_fail";
    private final String mSpName = "wksp_ad_config_sdk";
    private final String mSpLastUpdateKey = "wksp_ad_last_update_key_all";
    private long mUpDateDefTime = 180;
    private String strategy_ver = "";

    public SPAdAllConfigMg(Context context) {
        this.mSp = null;
        this.mContext = context;
        this.mSp = context.getSharedPreferences("wksp_ad_config_sdk", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configMda(String str, AdParams adParams, String str2) {
        try {
            WifiNestAd.reporter.onEvent(str, new EventParams.Builder().setNestType(adParams.getNestType()).setErrorCode(str2).build(), adParams.getExt());
        } catch (Exception unused) {
        }
    }

    private String createAdJson(WkSPAllResponse.AdStrategy adStrategy, String str, String str2) {
        String str3;
        if (adStrategy == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EventParams.KEY_STRATEGY_ID, adStrategy.getStrategyId());
            this.strategy_ver = adStrategy.getStrategyVer();
            jSONObject.put(EventParams.KEY_USERTYPE, adStrategy.getUserType());
            jSONObject.put(EventParams.KEY_STRATEGY_VER, this.strategy_ver);
            jSONObject.put(WkAdConfigModel.TAG_TIMEOUT, adStrategy.getTimeout());
            jSONObject.put("taiChi", str);
            jSONObject.put(WkAdConfigModel.TAG_UPDATETIME, adStrategy.getUpdateInterval());
            jSONObject.put("expids", str2);
            JSONObject jSONObject2 = new JSONObject();
            WkSPAllResponse.Switch r4 = adStrategy.getSwitch();
            if (r4 != null) {
                jSONObject2.put("whilelist", r4.getWhitelist());
                jSONObject2.put("blacklist", r4.getBlacklist());
                jSONObject2.put("realtime_ad_high_priority", r4.getRealtimeAdHighPriority());
                jSONObject2.put("response_strategy_optimize", r4.getResponseStrategyOptimize());
                jSONObject2.put("max_price_switch", r4.getMaxpriceSwitch());
                jSONObject2.put("prime_rit_switch", r4.getPrimeRitSwitch());
                jSONObject2.put("shake_switch", r4.getShakeSwitch());
                jSONObject.put("strategy_type", r4.getStrategyType());
                jSONObject.put("strategy_show", r4.getStrategyShow());
                jSONObject.put("debug", r4.getDebugReport());
                jSONObject.put("switch", jSONObject2);
            }
            WkSPAllResponse.MaterialControl materialControl = adStrategy.getMaterialControl();
            if (materialControl != null) {
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (materialControl.getUrlPrefixList() != null && !materialControl.getUrlPrefixList().isEmpty()) {
                    for (int i = 0; i < materialControl.getUrlPrefixList().size(); i++) {
                        jSONArray.put(materialControl.getUrlPrefixList().get(i));
                    }
                }
                jSONObject3.put("url_prefix", jSONArray);
                jSONObject3.put("frequency_time", materialControl.getFrequencyTime());
                jSONObject3.put("frequency_pv", materialControl.getFrequencyPv());
                jSONObject.put("material_control", jSONObject3);
            }
            List<WkSPAllResponse.PkCfg> pkCfgList = adStrategy.getPkCfgList();
            String str4 = "dspname";
            if (pkCfgList != null && pkCfgList.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < pkCfgList.size(); i2++) {
                    WkSPAllResponse.PkCfg pkCfg = pkCfgList.get(i2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("price_tag", pkCfg.getPriceTag());
                    List<WkSPAllResponse.DspWeight> dspWeightList = pkCfg.getDspWeightList();
                    if (dspWeightList != null && dspWeightList.size() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (int i3 = 0; i3 < dspWeightList.size(); i3++) {
                            WkSPAllResponse.DspWeight dspWeight = dspWeightList.get(i3);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("dspname", dspWeight.getDspname());
                            jSONObject5.put("weight", dspWeight.getWeight());
                            jSONArray3.put(jSONObject5);
                        }
                        jSONObject4.put("dsp_weight", jSONArray3);
                    }
                    jSONArray2.put(jSONObject4);
                }
                jSONObject.put("pk_cfg", jSONArray2);
            }
            List<WkSPAllResponse.SdkCfg> sdkCfgList = adStrategy.getSdkCfgList();
            if (sdkCfgList != null && sdkCfgList.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                for (int i4 = 0; i4 < sdkCfgList.size(); i4++) {
                    WkSPAllResponse.SdkCfg sdkCfg = sdkCfgList.get(i4);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("dspname", sdkCfg.getDspname());
                    jSONObject6.put("dspid", sdkCfg.getDspid());
                    jSONObject6.put("type", sdkCfg.getType());
                    jSONObject6.put(WkAdConfigModel.TAG_TIMEOUT, sdkCfg.getTimeout());
                    jSONObject6.put("cache_sec", sdkCfg.getCacheSec());
                    jSONArray4.put(jSONObject6);
                }
                jSONObject.put("sdk_cfg", jSONArray4);
            }
            WkSPAllResponse.CacheCfg cacheCfg = adStrategy.getCacheCfg();
            if (cacheCfg != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("queue_len", cacheCfg.getQueueLen());
                jSONObject.put("cache_cfg", jSONObject7);
            }
            List<WkSPAllResponse.GroupCfg> groupCfgList = adStrategy.getGroupCfgList();
            if (groupCfgList == null || groupCfgList.size() <= 0) {
                return "";
            }
            JSONArray jSONArray5 = new JSONArray();
            int i5 = 0;
            while (i5 < groupCfgList.size()) {
                WkSPAllResponse.GroupCfg groupCfg = groupCfgList.get(i5);
                JSONObject jSONObject8 = new JSONObject();
                List<WkSPAllResponse.SlotCfg> slotCfgList = groupCfg.getSlotCfgList();
                if (slotCfgList == null || slotCfgList.size() <= 0) {
                    str3 = str4;
                } else {
                    JSONArray jSONArray6 = new JSONArray();
                    int i6 = 0;
                    while (i6 < slotCfgList.size()) {
                        WkSPAllResponse.SlotCfg slotCfg = slotCfgList.get(i6);
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put(str4, slotCfg.getDspname());
                        jSONObject9.put("slotid", slotCfg.getSlotid());
                        jSONObject9.put("ecpm", slotCfg.getEcpm());
                        jSONObject9.put("freezetime", slotCfg.getFreezetime());
                        jSONObject9.put("ecpm_tag", slotCfg.getEcpmTag());
                        jSONObject9.put("pre_request", slotCfg.getPreRequest());
                        jSONObject9.put("adcost_type", slotCfg.getAdcostType());
                        jSONObject9.put(EventParams.KEY_ECPM_RATIO, slotCfg.getEcpmRatio());
                        jSONObject9.put(EventParams.KEY_ECPM_LOW_PRICE, slotCfg.getEcpmLowPrice());
                        jSONObject9.put(EventParams.KEY_PRICE_SWITCH, slotCfg.getPriceSwitch());
                        jSONArray6.put(jSONObject9);
                        i6++;
                        str4 = str4;
                    }
                    str3 = str4;
                    jSONObject8.put("slot_cfg", jSONArray6);
                    jSONObject8.put("group_minprice", groupCfg.getGroupMinprice());
                    jSONObject8.put("group_maxprice", groupCfg.getGroupMaxprice());
                    jSONObject8.put("group_timeout", groupCfg.getGroupTimeout());
                }
                jSONArray5.put(jSONObject8);
                i5++;
                str4 = str3;
            }
            jSONObject.put("group_cfg", jSONArray5);
            return jSONObject.toString();
        } catch (Exception e) {
            WifiLog.d("SPAD createAdJson Exception " + e.toString());
            return e.toString();
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
            jSONObject.put("os", "android");
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            jSONObject.put("longitude", nestInfoTaker.getLongitude());
            jSONObject.put("latitude", nestInfoTaker.getLatitude());
            jSONObject.put("cityCode", nestInfoTaker.getCityCode());
            jSONObject.put("vpnStatus", nestInfoTaker.getVpnStatus());
            DeviceInfoUtil.INSTANCE.addDeviceInfo(jSONObject);
            String string = jSONObject.toString();
            WifiLog.d("aesStart SPAdAllConfigMg " + string);
            return AesAdUtils.encryptAES(string);
        } catch (Exception unused) {
            return "";
        }
    }

    private String getSceneKey(int i, String str) {
        return i + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(String str, final String str2, String str3) {
        HashMap map = new HashMap();
        final String str4 = System.currentTimeMillis() + "";
        map.put("requestType", "1");
        map.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(this.mContext));
        final AdParams adParamsBuild = new AdParams.Builder().setExt(map).build();
        configMda("nest_sdk_init_config_get", adParamsBuild, "");
        String adUnitId = adParamsBuild != null ? adParamsBuild.getAdUnitId() : null;
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (!wifiNestAd.getNewRequestUrl() || wifiNestAd.getMLxRequestCallBack() == null) {
            IWkConfigCallBack<WkSPAllResponse.AllStrategiesResponse> iWkConfigCallBack = new IWkConfigCallBack<WkSPAllResponse.AllStrategiesResponse>() { // from class: com.wifi.ad.core.spstrategy.all.SPAdAllConfigMg.3
                @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
                public void dataError(String str5) {
                    WifiLog.d("SPADAll requestAdHttp dataError msg " + str5);
                    SPAdAllConfigMg.this.configMda("nest_sdk_init_config_fail", adParamsBuild, str5);
                    SPStrategyMdaUtil.startRespMda(str4, "1", str2, "", "", "", "2", str5, SPAdAllConfigMg.this.mContext);
                }

                @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
                public void dataSuccess(WkSPAllResponse.AllStrategiesResponse allStrategiesResponse, int i, String str5) {
                    WifiLog.d("SPADAll requestAdHttp dataSuccess ");
                    SPAdAllConfigMg.this.saveSuccess(allStrategiesResponse, str2, str4);
                    SPAdAllConfigMg.this.configMda("nest_sdk_init_config_return", adParamsBuild, "");
                }
            };
            SPStrategyMdaUtil.startRequestMda(str4, "1", str2, "", this.mContext);
            SPAllConfigHttp.postResponseData(this.mContext, str2, str, iWkConfigCallBack, str3, adUnitId);
        } else {
            LXRespHttpCallBack lXRespHttpCallBack = new LXRespHttpCallBack() { // from class: com.wifi.ad.core.spstrategy.all.SPAdAllConfigMg.2
                @Override // com.wifi.ad.core.callback.LXRespHttpCallBack
                public void onError(String str5) {
                    WifiLog.d("MLxReq SPADAll requestAdHttp dataError msg " + str5);
                    SPAdAllConfigMg.this.configMda("nest_sdk_init_config_fail", adParamsBuild, str5);
                    SPStrategyMdaUtil.startRespMda(str4, "3", str2, "", "", "", "2", str5, SPAdAllConfigMg.this.mContext);
                }

                @Override // com.wifi.ad.core.callback.LXRespHttpCallBack
                public void onSuccess(Object obj, int i, String str5) {
                    if (obj instanceof AllStrategiesResponse) {
                        SPAdAllConfigMg.this.saveLxRespSuccess((AllStrategiesResponse) obj, str2, str4);
                    } else {
                        SPStrategyMdaUtil.startRespMda(str4, "3", str2, "", "", "", "2", "response == null", SPAdAllConfigMg.this.mContext);
                    }
                    SPAdAllConfigMg.this.configMda("nest_sdk_init_config_return", adParamsBuild, "");
                }
            };
            SPStrategyMdaUtil.startRequestMda(str4, "3", str2, "", this.mContext);
            wifiNestAd.getMLxRequestCallBack().startRequest(SdkRequest.createSdkRequest(4, this.mContext, str, str2, str3, adUnitId, 0, ""), lXRespHttpCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLxRespSuccess(AllStrategiesResponse allStrategiesResponse, String str, String str2) {
        if (allStrategiesResponse != null) {
            List<AdStrategyData> list = allStrategiesResponse.data;
            String str3 = allStrategiesResponse.expids;
            if (list == null || allStrategiesResponse.code != 0) {
                SPStrategyMdaUtil.startRespMda(str2, "3", str, "", "", "", "2", "response.getCode() != 0", this.mContext);
                return;
            }
            WifiLog.d("MLxReq SPADAll dataSuccess allDatas " + list.size());
            for (int i = 0; i < list.size(); i++) {
                AdStrategyData adStrategyData = list.get(i);
                AdStrategy adStrategy = adStrategyData.strategy;
                WifiLog.d("MLxReq SPADAll saveSuccess adStrategy " + adStrategy);
                if (adStrategy != null) {
                    String str4 = adStrategyData.taichi;
                    int i2 = adStrategyData.scene;
                    String str5 = adStrategyData.appid;
                    this.strategy_ver = adStrategy.strategy_ver;
                    String strCreateAdJson = SdkRequest.createAdJson(adStrategy, str4, str3);
                    String sceneKey = getSceneKey(i2, str5);
                    this.mSp.edit().putString(sceneKey, strCreateAdJson).apply();
                    WifiLog.d("MLxReq SPADAll dataSuccess 保存成功 adScene " + i2 + " appId " + str5 + " key " + sceneKey);
                }
            }
            int i3 = allStrategiesResponse.update_interval;
            this.mSp.edit().putLong("wksp_ad_last_update_key_all", System.currentTimeMillis()).apply();
            this.mSp.edit().putLong("wksp_ad_last_update_key_all_updateTime", i3).apply();
            SPStrategyMdaUtil.startRespMda(str2, "3", str, "", this.strategy_ver, "", "1", "", this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSuccess(WkSPAllResponse.AllStrategiesResponse allStrategiesResponse, String str, String str2) {
        if (allStrategiesResponse == null) {
            SPStrategyMdaUtil.startRespMda(str2, "1", str, "", "", "", "2", "response == null", this.mContext);
            return;
        }
        List<WkSPAllResponse.AdStrategyData> dataList = allStrategiesResponse.getDataList();
        String expids = allStrategiesResponse.getExpids();
        if (dataList == null || allStrategiesResponse.getCode() != 0) {
            SPStrategyMdaUtil.startRespMda(str2, "1", str, "", "", "", "2", "response.getCode() != 0", this.mContext);
            return;
        }
        WifiLog.d("SPADAll dataSuccess allDatas " + dataList.size());
        for (int i = 0; i < dataList.size(); i++) {
            WkSPAllResponse.AdStrategyData adStrategyData = dataList.get(i);
            WkSPAllResponse.AdStrategy strategy = adStrategyData.getStrategy();
            WifiLog.d("SPADAll saveSuccess adStrategy " + strategy);
            String taichi = adStrategyData.getTaichi();
            int scene = adStrategyData.getScene();
            String appid = adStrategyData.getAppid();
            int updateInterval = allStrategiesResponse.getUpdateInterval();
            String strCreateAdJson = createAdJson(strategy, taichi, expids);
            String sceneKey = getSceneKey(scene, appid);
            this.mSp.edit().putString(sceneKey, strCreateAdJson).apply();
            this.mSp.edit().putLong("wksp_ad_last_update_key_all", System.currentTimeMillis()).apply();
            this.mSp.edit().putLong("wksp_ad_last_update_key_all_updateTime", updateInterval).apply();
            WifiLog.d("SPADAll dataSuccess 保存成功 adScene " + scene + " appId " + appid + " key " + sceneKey);
        }
        SPStrategyMdaUtil.startRespMda(str2, "1", str, "", this.strategy_ver, "", "1", "", this.mContext);
    }

    public String getDhRedDotStrategy() {
        return this.mSp.getString(getSceneKey(49, "lxf48f512f7d6a47c2"), "");
    }

    public void requestConfig(final String str, final String str2) {
        long j = this.mSp.getLong("wksp_ad_last_update_key_all", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.mSp.getLong("wksp_ad_last_update_key_all_updateTime", this.mUpDateDefTime);
        WifiLog.d("SPADAll requestConfig lastUpdateTime " + j + " curTime " + jCurrentTimeMillis + " mUpDateTime " + j2);
        if (jCurrentTimeMillis - j < j2 * 60 * 1000) {
            WifiLog.d("SPADAll requestConfig not allow ");
        } else {
            WifiLog.d("SPADAll requestConfig allow ");
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.spstrategy.all.SPAdAllConfigMg.1
                @Override // java.lang.Runnable
                public void run() {
                    NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                    String androidId = nestInfoTaker.getAndroidId();
                    SPAdAllConfigMg sPAdAllConfigMg = SPAdAllConfigMg.this;
                    SPAdAllConfigMg.this.requestAdHttp(sPAdAllConfigMg.getAesRes(nestInfoTaker.getImEI1(sPAdAllConfigMg.mContext), "", androidId, nestInfoTaker.getOaId()), str, str2);
                }
            });
        }
    }
}

package com.wifi.ad.core.spstrategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.callback.LXRespHttpCallBack;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.monitor.AesAdUtils;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.spstrategy.WkSPResponse;
import com.wifi.ad.core.spstrategy.data.AdStrategy;
import com.wifi.ad.core.spstrategy.data.Response;
import com.wifi.ad.core.spstrategy.data.SdkRequest;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.WifiLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SPAdConfigMg {
    private Context mContext;
    private SharedPreferences mSp;
    private final String NEST_SDK_AD_CONFIG_START = "nest_sdk_ad_sp_config_start";
    private final String NEST_SDK_AD_CONFIG_ERROR = "nest_sdk_ad_sp_config_error";
    private final String NEST_SDK_AD_CONFIG_SUCCESS = "nest_sdk_ad_sp_config_success";
    private final String mSpName = "wksp_ad_config_sdk";
    private final String mSpLastUpdateKey = "wksp_ad_last_update_key";
    private long mUpDateTime = 60;

    public SPAdConfigMg(Context context) {
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

    private String createAdJson(WkSPResponse.AdStrategy adStrategy, String str, String str2, String str3, int i, String str4) {
        String str5;
        if (adStrategy != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String strategyId = adStrategy.getStrategyId();
                String strategyVer = adStrategy.getStrategyVer();
                try {
                    SPStrategyMdaUtil.startRespMda(str3, "2", str4, i + "", strategyVer, strategyId, "1", "", this.mContext);
                    jSONObject.put(EventParams.KEY_STRATEGY_ID, strategyId);
                    jSONObject.put(EventParams.KEY_STRATEGY_VER, strategyVer);
                    jSONObject.put(EventParams.KEY_USERTYPE, adStrategy.getUserType());
                    jSONObject.put(WkAdConfigModel.TAG_TIMEOUT, adStrategy.getTimeout());
                    jSONObject.put("taiChi", str);
                    jSONObject.put(WkAdConfigModel.TAG_UPDATETIME, adStrategy.getUpdateInterval());
                    jSONObject.put("expids", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    WkSPResponse.Switch r4 = adStrategy.getSwitch();
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
                    WkSPResponse.MaterialControl materialControl = adStrategy.getMaterialControl();
                    if (materialControl != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        if (materialControl.getUrlPrefixList() != null && !materialControl.getUrlPrefixList().isEmpty()) {
                            for (int i2 = 0; i2 < materialControl.getUrlPrefixList().size(); i2++) {
                                jSONArray.put(materialControl.getUrlPrefixList().get(i2));
                            }
                        }
                        jSONObject3.put("url_prefix", jSONArray);
                        jSONObject3.put("frequency_time", materialControl.getFrequencyTime());
                        jSONObject3.put("frequency_pv", materialControl.getFrequencyPv());
                        jSONObject.put("material_control", jSONObject3);
                    }
                    List<WkSPResponse.PkCfg> pkCfgList = adStrategy.getPkCfgList();
                    String str6 = "dspname";
                    if (pkCfgList != null && pkCfgList.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < pkCfgList.size(); i3++) {
                            WkSPResponse.PkCfg pkCfg = pkCfgList.get(i3);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("price_tag", pkCfg.getPriceTag());
                            List<WkSPResponse.DspWeight> dspWeightList = pkCfg.getDspWeightList();
                            if (dspWeightList != null && dspWeightList.size() > 0) {
                                JSONArray jSONArray3 = new JSONArray();
                                for (int i4 = 0; i4 < dspWeightList.size(); i4++) {
                                    WkSPResponse.DspWeight dspWeight = dspWeightList.get(i4);
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
                    List<WkSPResponse.SdkCfg> sdkCfgList = adStrategy.getSdkCfgList();
                    if (sdkCfgList != null && sdkCfgList.size() > 0) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (int i5 = 0; i5 < sdkCfgList.size(); i5++) {
                            WkSPResponse.SdkCfg sdkCfg = sdkCfgList.get(i5);
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
                    WkSPResponse.CacheCfg cacheCfg = adStrategy.getCacheCfg();
                    if (cacheCfg != null) {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("queue_len", cacheCfg.getQueueLen());
                        jSONObject.put("cache_cfg", jSONObject7);
                    }
                    List<WkSPResponse.GroupCfg> groupCfgList = adStrategy.getGroupCfgList();
                    if (groupCfgList != null && groupCfgList.size() > 0) {
                        JSONArray jSONArray5 = new JSONArray();
                        int i6 = 0;
                        while (i6 < groupCfgList.size()) {
                            WkSPResponse.GroupCfg groupCfg = groupCfgList.get(i6);
                            JSONObject jSONObject8 = new JSONObject();
                            List<WkSPResponse.SlotCfg> slotCfgList = groupCfg.getSlotCfgList();
                            if (slotCfgList == null || slotCfgList.size() <= 0) {
                                str5 = str6;
                            } else {
                                JSONArray jSONArray6 = new JSONArray();
                                int i7 = 0;
                                while (i7 < slotCfgList.size()) {
                                    WkSPResponse.SlotCfg slotCfg = slotCfgList.get(i7);
                                    JSONObject jSONObject9 = new JSONObject();
                                    jSONObject9.put(str6, slotCfg.getDspname());
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
                                    i7++;
                                    str6 = str6;
                                }
                                str5 = str6;
                                jSONObject8.put("slot_cfg", jSONArray6);
                                jSONObject8.put("group_minprice", groupCfg.getGroupMinprice());
                                jSONObject8.put("group_maxprice", groupCfg.getGroupMaxprice());
                                jSONObject8.put("group_timeout", groupCfg.getGroupTimeout());
                            }
                            jSONArray5.put(jSONObject8);
                            i6++;
                            str6 = str5;
                        }
                        jSONObject.put("group_cfg", jSONArray5);
                        return jSONObject.toString();
                    }
                } catch (Exception e) {
                    e = e;
                    WifiLog.d("SPAD createAdJson Exception " + e.toString());
                    return e.toString();
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return "";
    }

    public static SPModel createAdModel(String str, String str2) {
        SPModel sPModel = new SPModel();
        if (TextUtils.isEmpty(str)) {
            sPModel.setParError("res is null");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                sPModel.setRequestId(str2);
                sPModel.setExPids(jSONObject.optString("expids"));
                sPModel.setSourceId(jSONObject.optString("srcid"));
                sPModel.setMdaLogType(jSONObject.optInt("debug"));
                sPModel.setAllTimeOut(jSONObject.optInt(WkAdConfigModel.TAG_TIMEOUT));
                sPModel.setAllNewSP(jSONObject.optInt("strategy_type"));
                sPModel.setAllowRequestAd(jSONObject.optInt("strategy_show"));
                sPModel.setUpdateTime(jSONObject.optInt(WkAdConfigModel.TAG_UPDATETIME, 60));
                sPModel.setUserType(jSONObject.optInt(EventParams.KEY_USERTYPE));
                sPModel.setStrategy_id(jSONObject.optString(EventParams.KEY_STRATEGY_ID));
                sPModel.setStrategy_ver(jSONObject.optString(EventParams.KEY_STRATEGY_VER));
                sPModel.setTaiChiId(jSONObject.optString("taiChi"));
                SPSwitchModel sPSwitchModel = new SPSwitchModel();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("switch");
                int iOptInt = jSONObjectOptJSONObject.optInt("strategy_show", -1);
                if (iOptInt != -1) {
                    sPModel.setAllowRequestAd(iOptInt);
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("strategy_type", -1);
                if (iOptInt2 != -1) {
                    sPModel.setAllNewSP(iOptInt2);
                }
                int iOptInt3 = jSONObjectOptJSONObject.optInt("debug", -1);
                if (iOptInt3 != -1) {
                    sPModel.setMdaLogType(iOptInt3);
                }
                sPSwitchModel.setBlackSwitch(jSONObjectOptJSONObject.optInt("blacklist"));
                sPSwitchModel.setWhiteSwitch(jSONObjectOptJSONObject.optInt("whilelist"));
                sPSwitchModel.setAdHighPrioritySwitch(jSONObjectOptJSONObject.optInt("realtime_ad_high_priority"));
                sPSwitchModel.setAdStrategyOptimizeSwitch(jSONObjectOptJSONObject.optInt("response_strategy_optimize"));
                sPSwitchModel.setAdMaxPriceSwitch(jSONObjectOptJSONObject.optInt("max_price_switch"));
                sPSwitchModel.setPrimeRitSwitch(jSONObjectOptJSONObject.optInt("prime_rit_switch"));
                sPSwitchModel.setShakeSwitch(jSONObjectOptJSONObject.optInt("shake_switch"));
                sPSwitchModel.setShakeSwitchLxad(jSONObjectOptJSONObject.optInt("shake_switch_lxad"));
                sPSwitchModel.setInteractSettings(jSONObjectOptJSONObject.optString("interact_settings"));
                sPModel.setSwitchModel(sPSwitchModel);
                SPMaterialModel sPMaterialModel = new SPMaterialModel();
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("material_control");
                if (jSONObjectOptJSONObject2 != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("url_prefix");
                    ArrayList arrayList = new ArrayList();
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            if (jSONArrayOptJSONArray.get(i) != null) {
                                arrayList.add((String) jSONArrayOptJSONArray.get(i));
                            }
                        }
                    }
                    sPMaterialModel.setUrl_prefix(arrayList);
                    sPMaterialModel.setFrequency_time(jSONObjectOptJSONObject2.optInt("frequency_time"));
                    sPMaterialModel.setFrequency_pv(jSONObjectOptJSONObject2.optInt("frequency_pv"));
                }
                sPModel.setMaterialModel(sPMaterialModel);
                sPModel.setPkCfgObject(jSONObject.optJSONArray("pk_cfg"));
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdk_cfg");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        SPSdkcfgModel sPSdkcfgModel = new SPSdkcfgModel();
                        sPSdkcfgModel.setCaschSes(jSONObjectOptJSONObject3.optInt("cache_sec"));
                        sPSdkcfgModel.setDspId(jSONObjectOptJSONObject3.optInt("dspid"));
                        sPSdkcfgModel.setDspName(jSONObjectOptJSONObject3.optString("dspname"));
                        sPSdkcfgModel.setType(jSONObjectOptJSONObject3.optInt("type"));
                        sPSdkcfgModel.setTimeOut(jSONObjectOptJSONObject3.optInt(WkAdConfigModel.TAG_TIMEOUT));
                        arrayList2.add(sPSdkcfgModel);
                    }
                    sPModel.setSdkCfgModels(arrayList2);
                }
                SPCachecfgModel sPCachecfgModel = new SPCachecfgModel();
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("cache_cfg");
                sPCachecfgModel.setCount(jSONObjectOptJSONObject4.optInt("queue_len"));
                sPCachecfgModel.setDefTime(jSONObjectOptJSONObject4.optInt("default_sec"));
                sPModel.setCachecfgModel(sPCachecfgModel);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("group_cfg");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i3);
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject5.optJSONArray("slot_cfg");
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                            SPGroupcfgModel sPGroupcfgModel = new SPGroupcfgModel();
                            sPGroupcfgModel.setGroupId(i3 + 1);
                            ArrayList arrayList4 = new ArrayList();
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray4.optJSONObject(i4);
                                SPSlotcfgModel sPSlotcfgModel = new SPSlotcfgModel();
                                sPSlotcfgModel.setDspName(jSONObjectOptJSONObject6.optString("dspname"));
                                sPSlotcfgModel.setEcpmTag(jSONObjectOptJSONObject6.optString("ecpm_tag"));
                                sPSlotcfgModel.setEcpm(jSONObjectOptJSONObject6.optInt("ecpm"));
                                sPSlotcfgModel.setFreezetime(jSONObjectOptJSONObject6.optInt("freezetime"));
                                sPSlotcfgModel.setSlotid(jSONObjectOptJSONObject6.optString("slotid"));
                                sPSlotcfgModel.setPreRequest(jSONObjectOptJSONObject6.optInt("pre_request"));
                                sPSlotcfgModel.setAdCostType(jSONObjectOptJSONObject6.optInt("adcost_type"));
                                sPSlotcfgModel.setEcpmLowPrice(jSONObjectOptJSONObject6.optInt(EventParams.KEY_ECPM_LOW_PRICE));
                                sPSlotcfgModel.setPriceSwitch(jSONObjectOptJSONObject6.optInt(EventParams.KEY_PRICE_SWITCH, 1));
                                if (jSONObjectOptJSONObject6.has(EventParams.KEY_ECPM_RATIO)) {
                                    float fFloatValue = BigDecimal.valueOf(jSONObjectOptJSONObject6.optDouble(EventParams.KEY_ECPM_RATIO, 1.0d)).floatValue();
                                    WifiLog.d("slotcfgModel ecpm_ratio " + fFloatValue);
                                    sPSlotcfgModel.setEcpmRatio(fFloatValue);
                                }
                                WifiLog.d("slotcfgModel AdCostType " + sPSlotcfgModel.getAdCostType() + " slotid " + sPSlotcfgModel.getSlotid());
                                arrayList4.add(sPSlotcfgModel);
                            }
                            sPGroupcfgModel.setMaxEcpm(jSONObjectOptJSONObject5.optInt("group_maxprice"));
                            sPGroupcfgModel.setMinEcpm(jSONObjectOptJSONObject5.optInt("group_minprice"));
                            sPGroupcfgModel.setTimeOut(jSONObjectOptJSONObject5.optInt("group_timeout"));
                            sPGroupcfgModel.setSlotcfgModels(arrayList4);
                            arrayList3.add(sPGroupcfgModel);
                        }
                    }
                    sPModel.setGroupcfgModels(arrayList3);
                }
            } catch (Exception e) {
                sPModel.setParError(e.toString());
            }
        }
        return sPModel;
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
            jSONObject.put("cityCode", nestInfoTaker.getCityCode());
            jSONObject.put("vpnStatus", nestInfoTaker.getVpnStatus());
            DeviceInfoUtil.INSTANCE.addDeviceInfo(jSONObject);
            String string = jSONObject.toString();
            WifiLog.d("aesStart SPAdConfigMg " + string);
            return AesAdUtils.encryptAES(string);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSceneKey(int i, String str) {
        return i + "_" + str;
    }

    private String popDefConfig(String str) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(final int i, final String str, String str2, final String str3, String str4, final AdParams adParams) throws Throwable {
        configMda("nest_sdk_ad_sp_config_start", adParams, "");
        String adUnitId = adParams != null ? adParams.getAdUnitId() : null;
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (!wifiNestAd.getNewRequestUrl() || wifiNestAd.getMLxRequestCallBack() == null) {
            IWkConfigCallBack<WkSPResponse.Response> iWkConfigCallBack = new IWkConfigCallBack<WkSPResponse.Response>() { // from class: com.wifi.ad.core.spstrategy.SPAdConfigMg.3
                @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
                public void dataError(String str5) {
                    WifiLog.d(str + " scene:" + i + " SPAD requestAdHttp dataError msg " + str5);
                    SPAdConfigMg.this.configMda("nest_sdk_ad_sp_config_error", adParams, str5);
                    SPStrategyMdaUtil.startRespMda(str, "2", str3, i + "", "", "", "2", str5, SPAdConfigMg.this.mContext);
                }

                @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
                public void dataSuccess(WkSPResponse.Response response, int i2, String str5) {
                    WifiLog.d(str + " scene:" + i2 + " SPAD requestAdHttp dataSuccess ");
                    SPAdConfigMg sPAdConfigMg = SPAdConfigMg.this;
                    sPAdConfigMg.saveSuccess(response, sPAdConfigMg.getSceneKey(i2, str5), str, i2, str3);
                    SPAdConfigMg.this.configMda("nest_sdk_ad_sp_config_success", adParams, "");
                }
            };
            SPStrategyMdaUtil.startRequestMda(str, "2", str3, i + "", this.mContext);
            SPConfigHttp.postResponseData(this.mContext, str, i, str3, str2, iWkConfigCallBack, str4, adUnitId);
            return;
        }
        LXRespHttpCallBack lXRespHttpCallBack = new LXRespHttpCallBack() { // from class: com.wifi.ad.core.spstrategy.SPAdConfigMg.2
            @Override // com.wifi.ad.core.callback.LXRespHttpCallBack
            public void onError(String str5) {
                WifiLog.d(str + " scene:" + i + " MLxReq SPAD requestAdHttp dataError msg " + str5);
                SPAdConfigMg.this.configMda("nest_sdk_ad_sp_config_error", adParams, str5);
                SPStrategyMdaUtil.startRespMda(str, "4", str3, i + "", "", "", "2", str5, SPAdConfigMg.this.mContext);
            }

            @Override // com.wifi.ad.core.callback.LXRespHttpCallBack
            public void onSuccess(Object obj, int i2, String str5) {
                if (obj instanceof Response) {
                    SPAdConfigMg sPAdConfigMg = SPAdConfigMg.this;
                    sPAdConfigMg.saveLxRespSuccess((Response) obj, sPAdConfigMg.getSceneKey(i2, str5), str, i2, str3);
                } else {
                    SPStrategyMdaUtil.startRespMda(str, "4", str3, i2 + "", "", "", "2", "response == null", SPAdConfigMg.this.mContext);
                }
                SPAdConfigMg.this.configMda("nest_sdk_ad_sp_config_success", adParams, "");
            }
        };
        SPStrategyMdaUtil.startRequestMda(str, "4", str3, i + "", this.mContext);
        wifiNestAd.getMLxRequestCallBack().startRequest(SdkRequest.createSdkRequest(3, this.mContext, str2, str3, str4, adUnitId, i, str), lXRespHttpCallBack);
    }

    private void requestConfig(final int i, final String str, final String str2, final String str3, final AdParams adParams) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (System.currentTimeMillis() - this.mSp.getLong("wksp_ad_last_update_key" + getSceneKey(i, str3), 0L) < this.mUpDateTime * 60 * 1000) {
            WifiLog.d(str + " scene:" + i + " SPAD requestConfig not allow ");
            return;
        }
        WifiLog.d(str + " scene:" + i + " SPAD requestConfig allow ");
        Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.spstrategy.SPAdConfigMg.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                String androidId = nestInfoTaker.getAndroidId();
                SPAdConfigMg sPAdConfigMg = SPAdConfigMg.this;
                SPAdConfigMg.this.requestAdHttp(i, str, sPAdConfigMg.getAesRes(nestInfoTaker.getImEI1(sPAdConfigMg.mContext), "", androidId, nestInfoTaker.getOaId()), str2, str3, adParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLxRespSuccess(Response response, String str, String str2, int i, String str3) {
        if (response != null) {
            if (TextUtils.isEmpty(str) || response.code != 0 || response.strategy == null) {
                SPStrategyMdaUtil.startRespMda(str2, "4", str3, i + "", "", "", "2", "response.getCode() != 0", this.mContext);
                return;
            }
            AdStrategy adStrategy = response.strategy;
            SPStrategyMdaUtil.startRespMda(str2, "4", str3, i + "", adStrategy.strategy_ver, adStrategy.strategy_id, "1", "", this.mContext);
            this.mSp.edit().putString(str, SdkRequest.createAdJson(response.strategy, response.taichi, response.expids)).apply();
            this.mSp.edit().putLong("wksp_ad_last_update_key" + str, System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSuccess(WkSPResponse.Response response, String str, String str2, int i, String str3) {
        if (response == null) {
            SPStrategyMdaUtil.startRespMda(str2, "2", str3, i + "", "", "", "2", "response == null", this.mContext);
            return;
        }
        WkSPResponse.AdStrategy strategy = response.getStrategy();
        WifiLog.d(str2 + " scene:" + i + " SPAD saveSuccess adStrategy " + strategy);
        if (TextUtils.isEmpty(str) || response.getCode() != 0) {
            SPStrategyMdaUtil.startRespMda(str2, "2", str3, i + "", "", "", "2", "response.getCode() != 0", this.mContext);
            return;
        }
        this.mSp.edit().putString(str, createAdJson(strategy, response.getTaichi(), response.getExpids(), str2, i, str3)).apply();
        this.mSp.edit().putLong("wksp_ad_last_update_key" + str, System.currentTimeMillis()).apply();
    }

    public SPModel getAdSdkConfig(int i, String str, String str2, String str3, AdParams adParams) {
        SPModel sPModelCreateAdModel;
        if (this.mSp != null) {
            if (TextUtils.isEmpty(str)) {
                str = "lxf48f512f7d6a47c2";
            }
            String sceneKey = getSceneKey(i, str);
            WifiLog.d(str2 + " scene:" + i + " SPAD key:" + sceneKey);
            sPModelCreateAdModel = createAdModel(this.mSp.getString(sceneKey, popDefConfig(sceneKey)), str2);
            if (sPModelCreateAdModel != null && sPModelCreateAdModel.getUpdateTime() > 0) {
                this.mUpDateTime = sPModelCreateAdModel.getUpdateTime();
            }
        } else {
            sPModelCreateAdModel = null;
        }
        requestConfig(i, str2, str3, str, adParams);
        return sPModelCreateAdModel;
    }
}

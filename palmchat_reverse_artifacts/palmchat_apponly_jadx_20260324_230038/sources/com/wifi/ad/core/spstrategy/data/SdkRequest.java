package com.wifi.ad.core.spstrategy.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class SdkRequest {
    public static final int TYPE_ALL_SCENE = 4;
    public static final int TYPE_ONE_SCENE = 3;
    public int apiversion = 0;
    public String requestid = "";
    public Device device = null;
    public App app = null;
    public String did = "";
    public int scene = 0;
    public String taichi = "";
    public String regtime = "";
    public int pv = 0;
    public int valuetype = 0;
    public String ad_unit_id = "";
    public String uid = "";
    public String device_id = "";

    public static String createAdJson(AdStrategy adStrategy, String str, String str2) {
        if (adStrategy == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EventParams.KEY_STRATEGY_ID, adStrategy.strategy_id);
            jSONObject.put(EventParams.KEY_USERTYPE, adStrategy.user_type);
            jSONObject.put(EventParams.KEY_STRATEGY_VER, adStrategy.strategy_ver);
            jSONObject.put(WkAdConfigModel.TAG_TIMEOUT, adStrategy.timeout);
            jSONObject.put("taiChi", str);
            jSONObject.put(WkAdConfigModel.TAG_UPDATETIME, adStrategy.update_interval);
            jSONObject.put("expids", str2);
            JSONObject jSONObject2 = new JSONObject();
            Switch r15 = adStrategy.switchKey;
            if (r15 != null) {
                jSONObject2.put("whilelist", r15.whitelist);
                jSONObject2.put("blacklist", r15.blacklist);
                jSONObject2.put("realtime_ad_high_priority", r15.realtime_ad_high_priority);
                jSONObject2.put("response_strategy_optimize", r15.response_strategy_optimize);
                jSONObject2.put("prime_rit_switch", r15.prime_rit_switch);
                jSONObject2.put("max_price_switch", r15.maxprice_switch);
                jSONObject2.put("shake_switch", r15.shake_switch);
                jSONObject2.put("shake_switch_lxad", r15.shake_switch_lxad);
                Interact interact = r15.interact_settings;
                if (interact != null) {
                    jSONObject2.put("interact_settings", interact.toString());
                }
                jSONObject.put("strategy_type", r15.strategy_type);
                jSONObject.put("strategy_show", r15.strategy_show);
                jSONObject.put("debug", r15.debug_report);
                jSONObject.put("switch", jSONObject2);
            }
            MaterialControl materialControl = adStrategy.material_control;
            if (materialControl != null) {
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<String> list = materialControl.url_prefix;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < materialControl.url_prefix.size(); i++) {
                        jSONArray.put(materialControl.url_prefix.get(i));
                    }
                }
                jSONObject3.put("url_prefix", jSONArray);
                jSONObject3.put("frequency_time", materialControl.frequency_time);
                jSONObject3.put("frequency_pv", materialControl.frequency_pv);
                jSONObject.put("material_control", jSONObject3);
            }
            List<PkCfg> list2 = adStrategy.pk_cfg;
            if (list2 != null && list2.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    PkCfg pkCfg = list2.get(i2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("price_tag", pkCfg.price_tag);
                    List<DspWeight> list3 = pkCfg.dsp_weight;
                    if (list3 != null && list3.size() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (int i3 = 0; i3 < list3.size(); i3++) {
                            DspWeight dspWeight = list3.get(i3);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("dspname", dspWeight.dspname);
                            jSONObject5.put("weight", dspWeight.weight);
                            jSONArray3.put(jSONObject5);
                        }
                        jSONObject4.put("dsp_weight", jSONArray3);
                    }
                    jSONArray2.put(jSONObject4);
                }
                jSONObject.put("pk_cfg", jSONArray2);
            }
            List<SdkCfg> list4 = adStrategy.sdk_cfg;
            if (list4 != null && list4.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    SdkCfg sdkCfg = list4.get(i4);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("dspname", sdkCfg.dspname);
                    jSONObject6.put("dspid", sdkCfg.dspid);
                    jSONObject6.put("type", sdkCfg.type);
                    jSONObject6.put(WkAdConfigModel.TAG_TIMEOUT, sdkCfg.timeout);
                    jSONObject6.put("cache_sec", sdkCfg.cache_sec);
                    jSONArray4.put(jSONObject6);
                }
                jSONObject.put("sdk_cfg", jSONArray4);
            }
            CacheCfg cacheCfg = adStrategy.cache_cfg;
            if (cacheCfg != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("queue_len", cacheCfg.queue_len);
                jSONObject.put("cache_cfg", jSONObject7);
            }
            List<GroupCfg> list5 = adStrategy.group_cfg;
            if (list5 == null || list5.size() <= 0) {
                return "";
            }
            JSONArray jSONArray5 = new JSONArray();
            for (int i5 = 0; i5 < list5.size(); i5++) {
                GroupCfg groupCfg = list5.get(i5);
                JSONObject jSONObject8 = new JSONObject();
                List<SlotCfg> list6 = groupCfg.slot_cfg;
                if (list6 != null && list6.size() > 0) {
                    JSONArray jSONArray6 = new JSONArray();
                    for (int i6 = 0; i6 < list6.size(); i6++) {
                        SlotCfg slotCfg = list6.get(i6);
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("dspname", slotCfg.dspname);
                        jSONObject9.put("slotid", slotCfg.slotid);
                        jSONObject9.put("ecpm", slotCfg.ecpm);
                        jSONObject9.put("freezetime", slotCfg.freezetime);
                        jSONObject9.put("ecpm_tag", slotCfg.ecpm_tag);
                        jSONObject9.put("pre_request", slotCfg.pre_request);
                        jSONObject9.put("adcost_type", slotCfg.adcost_type);
                        jSONObject9.put(EventParams.KEY_ECPM_RATIO, slotCfg.ecpm_ratio);
                        jSONObject9.put(EventParams.KEY_ECPM_LOW_PRICE, slotCfg.ecpm_low_price);
                        jSONObject9.put(EventParams.KEY_PRICE_SWITCH, slotCfg.price_switch);
                        jSONArray6.put(jSONObject9);
                    }
                    jSONObject8.put("slot_cfg", jSONArray6);
                    jSONObject8.put("group_minprice", groupCfg.group_minprice);
                    jSONObject8.put("group_maxprice", groupCfg.group_maxprice);
                    jSONObject8.put("group_timeout", groupCfg.group_timeout);
                }
                jSONArray5.put(jSONObject8);
            }
            jSONObject.put("group_cfg", jSONArray5);
            return jSONObject.toString();
        } catch (Exception e) {
            WifiLog.d("MLxReq SPAD createAdJson Exception " + e.toString());
            return e.toString();
        }
    }

    public static SdkRequest createSdkRequest(int i, Context context, String str, String str2, String str3, String str4, int i2, String str5) {
        SdkRequest sdkRequest = new SdkRequest();
        sdkRequest.valuetype = i;
        sdkRequest.apiversion = 1001;
        sdkRequest.did = str;
        App app = new App();
        app.appid = str3;
        app.pkgname = context.getPackageName();
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        if (!TextUtils.isEmpty(nestInfoTaker.getChannel())) {
            app.market = nestInfoTaker.getChannel();
        }
        if (!TextUtils.isEmpty(nestInfoTaker.getAppVer())) {
            app.version = nestInfoTaker.getAppVer();
        }
        NestSdkVersion nestSdkVersion = NestSdkVersion.INSTANCE;
        if (!TextUtils.isEmpty(nestSdkVersion.getVersion(context))) {
            app.sdk_ver = nestSdkVersion.getVersion(context);
        }
        String appVerName = nestInfoTaker.getAppVerName();
        if (!TextUtils.isEmpty(appVerName)) {
            app.version_name = appVerName;
        }
        sdkRequest.app = app;
        String deviceId = nestInfoTaker.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            sdkRequest.device_id = deviceId;
        }
        String uId = nestInfoTaker.getUId();
        if (!TextUtils.isEmpty(uId)) {
            sdkRequest.uid = uId;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = nestInfoTaker.getConfigTai();
            if (!TextUtils.isEmpty(str2)) {
                WifiNestAd.INSTANCE.setAdConfigTais(str2);
            }
        }
        sdkRequest.taichi = str2;
        if (!TextUtils.isEmpty(str5)) {
            sdkRequest.requestid = str5;
        }
        if (!TextUtils.isEmpty(str4)) {
            sdkRequest.ad_unit_id = str4;
        }
        sdkRequest.scene = i2;
        return sdkRequest;
    }
}

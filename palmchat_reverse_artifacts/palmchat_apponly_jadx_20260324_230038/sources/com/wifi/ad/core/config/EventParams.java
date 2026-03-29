package com.wifi.ad.core.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class EventParams {
    public static final String KEY_ADCOST = "adcost";
    public static final String KEY_ADREALNAME = "adRealLevel";
    public static final String KEY_AD_DESC = "ad_desc";
    public static final String KEY_AD_IMAGE = "ad_image";
    public static final String KEY_AD_LEVEL = "adlevel";
    public static final String KEY_AD_TITLE = "ad_title";
    public static final String KEY_BAIDU = "baidu";
    public static final String KEY_BEIZI = "beizi";
    public static final String KEY_CACHE_ALL_NUM = "cache_all_num";
    public static final String KEY_CACHE_EXT = "cache_ext";
    public static final String KEY_CACHE_EXT_NEW = "cache_ext_new";
    public static final String KEY_CACHE_FAILED_SIZE = "cache_failed_size";
    public static final String KEY_CACHE_MAX_ECPM = "cache_max_ecpm";
    public static final String KEY_CACHE_SIZE = "cache_size";
    public static final String KEY_CACHE_SUCCESS_SIZE = "cache_success_size";
    public static final String KEY_CHANGETYPE = "changeType";
    public static final String KEY_COST_TIME = "costtime";
    public static final String KEY_CREATE_REQUESTID = "createrequestid";
    public static final String KEY_CSJ = "csj";
    public static final String KEY_CT_ADBTNSHOW = "ct_adbtnshow";
    public static final String KEY_CT_SDK_FROM = "sdk_from";
    public static final String KEY_CT_SDK_POSITION = "position";
    public static final String KEY_DISCOUNT_INFO = "discount_info";
    public static final String KEY_DOMAIN_NAME = "domainname";
    public static final String KEY_DSPID = "dspid";
    public static final String KEY_ECPM_LOW_PRICE = "ecpm_low_price";
    public static final String KEY_ECPM_RATIO = "ecpm_ratio";
    public static final String KEY_FEISUO = "feisuo";
    public static final String KEY_FREEZE_LAST_TIME = "freeze_last_time";
    public static final String KEY_FREEZE_TIME = "freeze_time";
    public static final String KEY_GDT = "gdt";
    public static final String KEY_GROUP = "group";
    public static final String KEY_HUAWEI = "huawei";
    public static final String KEY_INTERACTIVETYPE = "interactive_type";
    public static final String KEY_INVENTORYID = "inventoryId";
    public static final String KEY_KS = "ks";
    public static final String KEY_LOADAD_TIME = "ad_load_time";
    public static final String KEY_LXAD = "lxad";
    public static final String KEY_NEST = "nest";
    public static final String KEY_OPPO = "oppo";
    public static final String KEY_PARAM_ADBTNSTATE = "adbtn_state";
    public static final String KEY_PARAM_ADSCENE_CLICK = "ad_scene_click";
    public static final String KEY_PARAM_ADTYPE = "ad_type";
    public static final String KEY_PARAM_ADXSID = "adxsid";
    public static final String KEY_PARAM_AD_MODE = "ad_mode";
    public static final String KEY_PARAM_BUDGETTYPE = "budgetType";
    public static final String KEY_PARAM_CP = "cp";
    public static final String KEY_PARAM_DSPNAME = "dspname";
    public static final String KEY_PARAM_ERRPR_CODE = "code";
    public static final String KEY_PARAM_ERRPR_MSG = "msg";
    public static final String KEY_PARAM_MEDIAID = "mediaid";
    public static final String KEY_PARAM_NEST_SID = "nest_sid";
    public static final String KEY_PARAM_NEST_TYPE = "nest_type";
    public static final String KEY_PARAM_NETSUBTYPE = "netSubType";
    public static final String KEY_PARAM_NETTYPE = "netType";
    public static final String KEY_PARAM_NUMBER = "number";
    public static final String KEY_PARAM_PVID = "pvid";
    public static final String KEY_PARAM_RENDER_STYLE = "xuanran_way";
    public static final String KEY_PARAM_REQUESTID = "requestId";
    public static final String KEY_PARAM_SCENE = "scene";
    public static final String KEY_PARAM_SDKVER = "sdkver";
    public static final String KEY_PARAM_SID = "sid";
    public static final String KEY_PARAM_SRCID = "srcid";
    public static final String KEY_PARAM_TEMPLATE = "template";
    public static final String KEY_PKGNAME = "pkgname";
    public static final String KEY_PRICE_RESPONSE = "price_response";
    public static final String KEY_PRICE_SWITCH = "price_switch";
    public static final String KEY_QUMENG = "qumeng";
    public static final String KEY_RED_ADBTNSHOW = "red_adbtnshow";
    public static final String KEY_RENDERTYPE = "renderType";
    public static final String KEY_REQUEST_FAID_REASON = "request_fail_reason";
    public static final String KEY_SENSITIVEWORDS = "sensitivewords";
    public static final String KEY_SOURCEID = "slotid";
    public static final String KEY_STRATEGY_ID = "strategy_id";
    public static final String KEY_STRATEGY_VER = "strategy_ver";
    public static final String KEY_TM_ADBTNSHOW = "tm_adbtnshow";
    public static final String KEY_TYPE_STATUS = "ab_type_status";
    public static final String KEY_USERTYPE = "user_type";
    public static final String KEY_USE_REQUESTID = "userequestid";
    public static final String KEY_WIFI = "wifi";
    public static final String KEY_WXEVENTEXT = "wxEventExt";
    public static final String KEY_WX_ADID = "adid";
    public static final String KEY_WX_APPKEY = "pl_appkey";
    public static final String KEY_WX_DSPID = "dsp_id";
    public static final String KEY_WX_INDENTITYID = "indentity_id";
    public static final String KEY_WX_SRCID = "pl_slotid";
    private String ab_type_status;
    private String adBtnState;
    private String adDesc;
    private String adImage;
    private String adMode;
    private String adRealLevel;
    private String adSceneClick;
    private String adTitle;
    private String adType;
    private int adcost;
    private int adlevel;
    private String adxSid;
    private String baidu;
    private String beizi;
    private int budgetType;
    private int cache_all_num;
    private String cache_ext;
    private String cache_ext_new;
    private int cache_failed_size;
    private int cache_max_ecpm;
    private int cache_size;
    private int cache_success_size;
    private String cfgfrom;
    private int changeType;
    private String code;
    private long costtime;
    private String cp;
    private String createRequestId;
    private String csj;
    private int ctAdBtnShow;
    private String discountInfo;
    private String domainname;
    private int dspId;
    private String dspName;
    private int ecpm_low_price;
    private float ecpm_ratio;
    private String feisuo;
    private long freeze_last_time;
    private int freeze_time;
    private String gdt;
    private int group;
    private String huawei;
    private int interactive_type;
    private String inventoryId;
    private String isDnld;
    private String ks;
    private String lxad;
    private String mediaId;
    private String msg;
    private String nest;
    private String nestSid;
    private String nestType;
    private long netSubType;
    private long netType;
    private String number;
    private String oaid;
    private String oppo;
    private String pkgname;
    private int position;
    private int price_response;
    private int price_switch;
    private String pvId;
    private String qumeng;
    private int redAdBtnShow;
    private int renderStyle;
    private int renderType;
    private int requestFailReason;
    private String requestId;
    private String respbtnwd;
    private String scene;
    private String sdkFrom;
    private String sdkVersion;
    private String sensitivewords;
    private String showbtnwd;
    private String sid;
    private String sourceId;
    private String srcId;
    private String strategy_id;
    private String strategy_ver;
    private String template;
    private String thirdSdkInfo;
    private int tmAdBtnShow;
    private String useRequestId;
    private int user_type;
    private String wifi;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private final EventParams params = new EventParams();

        public EventParams build() {
            return this.params;
        }

        public Builder setAbTypeStatus(String str) {
            this.params.ab_type_status = str;
            return this;
        }

        public Builder setAdBtnState(String str) {
            this.params.adBtnState = str;
            return this;
        }

        public Builder setAdCost(int i) {
            this.params.adcost = i;
            return this;
        }

        public Builder setAdDesc(String str) {
            this.params.adDesc = str;
            return this;
        }

        public Builder setAdImage(String str) {
            this.params.adImage = str;
            return this;
        }

        public Builder setAdLevel(int i) {
            this.params.adlevel = i;
            return this;
        }

        public Builder setAdMode(String str) {
            this.params.adMode = str;
            return this;
        }

        public Builder setAdSceneClick(String str) {
            this.params.adSceneClick = str;
            return this;
        }

        public Builder setAdTitle(String str) {
            this.params.adTitle = str;
            return this;
        }

        public Builder setAdType(String str) {
            this.params.adType = str;
            return this;
        }

        public Builder setAdxSid(String str) {
            this.params.adxSid = str;
            return this;
        }

        public Builder setBaiduVersion(String str) {
            this.params.baidu = str;
            return this;
        }

        public Builder setBeiziVersion(String str) {
            this.params.beizi = str;
            return this;
        }

        public Builder setBudgetType(int i) {
            this.params.budgetType = i;
            return this;
        }

        public Builder setCacheAllNum(int i) {
            this.params.cache_all_num = i;
            return this;
        }

        public Builder setCacheExt(String str) {
            this.params.cache_ext = str;
            return this;
        }

        public Builder setCacheExtNew(String str) {
            this.params.cache_ext_new = str;
            return this;
        }

        public Builder setCacheFailedSize(int i) {
            this.params.cache_failed_size = i;
            return this;
        }

        public Builder setCacheMaxEcpm(int i) {
            this.params.cache_max_ecpm = i;
            return this;
        }

        public Builder setCacheSize(int i) {
            this.params.cache_size = i;
            return this;
        }

        public Builder setCacheSuccessSize(int i) {
            this.params.cache_success_size = i;
            return this;
        }

        public Builder setCfgfrom(String str) {
            this.params.cfgfrom = str;
            return this;
        }

        public Builder setChangeType(int i) {
            this.params.changeType = i;
            return this;
        }

        public Builder setCostTime(long j) {
            this.params.costtime = j;
            return this;
        }

        public Builder setCp(String str) {
            this.params.cp = str;
            return this;
        }

        public Builder setCreateRequestId(String str) {
            this.params.createRequestId = str;
            return this;
        }

        public Builder setCsjVersion(String str) {
            this.params.csj = str;
            return this;
        }

        public Builder setCtAdBtnShow(int i) {
            this.params.ctAdBtnShow = i;
            return this;
        }

        public Builder setDiscountInfo(String str) {
            this.params.discountInfo = str;
            return this;
        }

        public Builder setDomainName(String str) {
            this.params.domainname = str;
            return this;
        }

        public Builder setDspId(int i) {
            this.params.dspId = i;
            return this;
        }

        public Builder setDspName(String str) {
            this.params.dspName = str;
            return this;
        }

        public Builder setEcpmLowPrice(int i) {
            this.params.ecpm_low_price = i;
            return this;
        }

        public Builder setEcpmRatio(float f) {
            this.params.ecpm_ratio = f;
            return this;
        }

        public Builder setErrorCode(String str) {
            this.params.code = str;
            return this;
        }

        public Builder setErrorMsg(String str) {
            this.params.msg = str;
            return this;
        }

        public Builder setFeisuoVersion(String str) {
            this.params.feisuo = str;
            return this;
        }

        public Builder setFreezeLastTime(long j) {
            this.params.freeze_last_time = j;
            return this;
        }

        public Builder setFreezeTime(int i) {
            this.params.freeze_time = i;
            return this;
        }

        public Builder setGdtVersion(String str) {
            this.params.gdt = str;
            return this;
        }

        public Builder setGroup(int i) {
            this.params.group = i;
            return this;
        }

        public Builder setHuaweiVersion(String str) {
            this.params.huawei = str;
            return this;
        }

        public Builder setInteractiveType(int i) {
            this.params.interactive_type = i;
            return this;
        }

        public Builder setInventoryId(String str) {
            this.params.inventoryId = str;
            return this;
        }

        public Builder setIsDnId(int i) {
            this.params.isDnld = String.valueOf(i);
            return this;
        }

        public Builder setKsVersion(String str) {
            this.params.ks = str;
            return this;
        }

        public Builder setLxAdVersion(String str) {
            this.params.lxad = str;
            return this;
        }

        public Builder setMediaId(String str) {
            this.params.mediaId = str;
            return this;
        }

        public Builder setNestSid(String str) {
            this.params.nestSid = str;
            return this;
        }

        public Builder setNestType(String str) {
            this.params.nestType = str;
            return this;
        }

        public Builder setNestVersion(String str) {
            this.params.nest = str;
            return this;
        }

        public Builder setNetSubType(long j) {
            this.params.netSubType = j;
            return this;
        }

        public Builder setNetType(long j) {
            this.params.netType = j;
            return this;
        }

        public Builder setNumber(String str) {
            this.params.number = str;
            return this;
        }

        public Builder setOaid(String str) {
            this.params.oaid = str;
            return this;
        }

        public Builder setOppoVersion(String str) {
            this.params.oppo = str;
            return this;
        }

        public Builder setPkgname(String str) {
            this.params.pkgname = str;
            return this;
        }

        public Builder setPosition(int i) {
            this.params.position = i;
            return this;
        }

        public Builder setPriceResponse(int i) {
            this.params.price_response = i;
            return this;
        }

        public Builder setPriceSwitch(int i) {
            this.params.price_switch = i;
            return this;
        }

        public Builder setPvId(String str) {
            this.params.pvId = str;
            return this;
        }

        public Builder setQmVersion(String str) {
            this.params.qumeng = str;
            return this;
        }

        public Builder setRealLevel(String str) {
            this.params.adRealLevel = str;
            return this;
        }

        public Builder setRedAdBtnShow(int i) {
            this.params.redAdBtnShow = i;
            return this;
        }

        public Builder setRenderStyle(int i) {
            this.params.renderStyle = i;
            return this;
        }

        public Builder setRenderType(int i) {
            this.params.renderType = i;
            return this;
        }

        public Builder setRequestFailReason(int i) {
            this.params.requestFailReason = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.params.requestId = str;
            return this;
        }

        public Builder setRespbtnwd(String str) {
            this.params.respbtnwd = str;
            return this;
        }

        public Builder setScene(String str) {
            this.params.scene = str;
            return this;
        }

        public Builder setSdkFrom(String str) {
            this.params.sdkFrom = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.params.sdkVersion = str;
            return this;
        }

        public Builder setSensitiveWords(String str) {
            this.params.sensitivewords = str;
            return this;
        }

        public Builder setShowbtnwd(String str) {
            this.params.showbtnwd = str;
            return this;
        }

        public Builder setSid(String str) {
            this.params.sid = str;
            return this;
        }

        public Builder setSourceId(String str) {
            this.params.sourceId = str;
            return this;
        }

        public Builder setSrcId(String str) {
            this.params.srcId = str;
            return this;
        }

        public Builder setStrategyId(String str) {
            this.params.strategy_id = str;
            return this;
        }

        public Builder setStrategyVer(String str) {
            this.params.strategy_ver = str;
            return this;
        }

        public Builder setTemplate(String str) {
            this.params.template = str;
            return this;
        }

        public Builder setTmAdBtnShow(int i) {
            this.params.tmAdBtnShow = i;
            return this;
        }

        public Builder setUseRequestId(String str) {
            this.params.useRequestId = str;
            return this;
        }

        public Builder setUserType(int i) {
            this.params.user_type = i;
            return this;
        }

        public Builder setWifiVersion(String str) {
            this.params.wifi = str;
            return this;
        }
    }

    public static EventParams addEventParamsByAdData(Builder builder, NestAdData nestAdData) {
        if (builder == null) {
            return new Builder().build();
        }
        if (nestAdData == null) {
            return builder.build();
        }
        builder.setOaid(NestInfoTaker.INSTANCE.getOaId());
        builder.setGroup(nestAdData.getGroupId());
        builder.setCacheSize(nestAdData.getCacheCount());
        builder.setFreezeTime(nestAdData.getFreezetime());
        builder.setEcpmLowPrice(nestAdData.getEcpmLowPrice());
        builder.setPriceSwitch(nestAdData.getPriceSwitch());
        builder.setPriceResponse(nestAdData.getPriceResponse());
        builder.setEcpmRatio(nestAdData.getEcpmRatio());
        if (nestAdData.getZhiboAd().booleanValue()) {
            builder.setBudgetType(1);
        }
        builder.setAdCost(nestAdData.getAdCost());
        builder.setRealLevel(nestAdData.getAdRealLevelName());
        builder.setDspId(nestAdData.getDspId());
        builder.setChangeType(nestAdData.getChangeType());
        builder.setDiscountInfo(nestAdData.getDiscountInfo());
        builder.setCreateRequestId(nestAdData.getCreateRequestId());
        builder.setUseRequestId(nestAdData.getUseRequestId());
        return builder.build();
    }

    public static EventParams addFailedEventParams(Builder builder, NestAdData nestAdData, String str, String str2) {
        if (builder == null) {
            return new Builder().build();
        }
        if (nestAdData == null) {
            return builder.build();
        }
        builder.setErrorCode(str);
        builder.setGroup(nestAdData.getGroupId());
        builder.setCacheSize(nestAdData.getCacheCount());
        builder.setFreezeTime(nestAdData.getFreezetime());
        builder.setEcpmLowPrice(nestAdData.getEcpmLowPrice());
        builder.setPriceSwitch(nestAdData.getPriceSwitch());
        builder.setPriceResponse(nestAdData.getPriceResponse());
        builder.setEcpmRatio(nestAdData.getEcpmRatio());
        builder.setAdCost(nestAdData.getAdCost());
        if (nestAdData.getZhiboAd().booleanValue()) {
            builder.setBudgetType(1);
        }
        builder.setDspId(nestAdData.getDspId());
        builder.setChangeType(nestAdData.getChangeType());
        builder.setCreateRequestId(nestAdData.getCreateRequestId());
        builder.setUseRequestId(nestAdData.getUseRequestId());
        builder.setErrorMsg(str2);
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static EventParams getEventParamsByAdData(NestAdData nestAdData) {
        String str;
        if (nestAdData == null) {
            return new Builder().build();
        }
        String dspName = nestAdData.getDspName();
        if (!TextUtils.isEmpty(dspName)) {
            WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
            if (wifiNestAd.getAppIds() == null) {
                str = "";
            } else if (dspName.contains(NestKsProvider.SDK_FROM)) {
                str = wifiNestAd.getAppIds().get(SDKAlias.KS);
            } else if (dspName.contains("guangdiantong")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.GDT);
            } else if (dspName.contains(NestCsjProvider.SDK_FROM)) {
                str = wifiNestAd.getAppIds().get(SDKAlias.CSJ);
            } else if (dspName.contains(NestWifiProvider.SDK_FROM)) {
                str = wifiNestAd.getAppIds().get(SDKAlias.WIFI);
            } else if (dspName.contains("oppo")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.OPPO);
            } else if (dspName.contains("huawei")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.HUAWEI);
            } else if (dspName.contains("beizi")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.BEIZI);
            } else if (dspName.contains("feisuo")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.FEISUO);
            } else if (dspName.contains("lxad")) {
                str = wifiNestAd.getAppIds().get(SDKAlias.LXAD);
            }
        }
        return new Builder().setDspId(nestAdData.getDspId()).setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdButtonTime()).setSdkFrom(nestAdData.getSdkFrom()).setInventoryId(nestAdData.getInventoryId()).setRenderStyle(nestAdData.getRenderStyle()).setMediaId(str).setBudgetType(nestAdData.getZhiboAd().booleanValue() ? 1 : 0).setSrcId(nestAdData.getAdCode()).setNestType(nestAdData.getAdParams() != null ? nestAdData.getAdParams().getNestType() : "").setAdMode(nestAdData.getAdMode() + "").setStrategyVer(nestAdData.getStrategyVer()).setStrategyId(nestAdData.getStrategyId()).setUseRequestId(nestAdData.getUseRequestId()).setCreateRequestId(nestAdData.getCreateRequestId()).setAbTypeStatus(nestAdData.getStartegyTaiChi()).setGroup(nestAdData.getGroupId()).setCacheSize(nestAdData.getCacheCount()).setFreezeLastTime(nestAdData.getFreezeLastTime()).setRequestFailReason(nestAdData.getRequestFailReason()).setFreezeTime(nestAdData.getFreezetime()).setEcpmLowPrice(nestAdData.getEcpmLowPrice()).setPriceSwitch(nestAdData.getPriceSwitch()).setPriceResponse(nestAdData.getPriceResponse()).setEcpmRatio(nestAdData.getEcpmRatio()).setAdCost(nestAdData.getAdCost()).setSourceId(nestAdData.getSourceId()).setDspId(nestAdData.getDspId()).setChangeType(nestAdData.getChangeType()).build();
    }

    public static String toJson(@NonNull EventParams eventParams) {
        try {
            JSONObject jSONObject = new JSONObject();
            String requestId = eventParams.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                jSONObject.put("requestId", requestId);
            }
            long netType = eventParams.getNetType();
            if (netType != -1) {
                jSONObject.put(KEY_PARAM_NETTYPE, netType);
            }
            long netSubType = eventParams.getNetSubType();
            if (netSubType != -1) {
                jSONObject.put(KEY_PARAM_NETSUBTYPE, netSubType);
            }
            String template = eventParams.getTemplate();
            if (!TextUtils.isEmpty(template)) {
                jSONObject.put(KEY_PARAM_TEMPLATE, template);
            }
            String adRealLevel = eventParams.getAdRealLevel();
            if (!TextUtils.isEmpty(adRealLevel)) {
                jSONObject.put(KEY_ADREALNAME, adRealLevel);
            }
            String inventoryId = eventParams.getInventoryId();
            if (!TextUtils.isEmpty(inventoryId)) {
                jSONObject.put(KEY_INVENTORYID, inventoryId);
            }
            int adcost = eventParams.getAdcost();
            if (adcost > 0) {
                jSONObject.put("adcost", adcost);
            }
            int interactiveType = eventParams.getInteractiveType();
            if (interactiveType > 0) {
                jSONObject.put(KEY_INTERACTIVETYPE, interactiveType);
            }
            int changeType = eventParams.getChangeType();
            if (changeType > 0) {
                jSONObject.put(KEY_CHANGETYPE, changeType);
            }
            String strategy_ver = eventParams.getStrategy_ver();
            if (!TextUtils.isEmpty(strategy_ver)) {
                jSONObject.put(KEY_STRATEGY_VER, strategy_ver);
            }
            String sourceId = eventParams.getSourceId();
            if (!TextUtils.isEmpty(sourceId)) {
                jSONObject.put("slotid", sourceId);
            }
            String useRequestId = eventParams.getUseRequestId();
            if (!TextUtils.isEmpty(useRequestId)) {
                jSONObject.put(KEY_USE_REQUESTID, useRequestId);
            }
            String createRequestId = eventParams.getCreateRequestId();
            if (!TextUtils.isEmpty(createRequestId)) {
                jSONObject.put(KEY_CREATE_REQUESTID, createRequestId);
            }
            String strategy_id = eventParams.getStrategy_id();
            if (!TextUtils.isEmpty(strategy_id)) {
                jSONObject.put(KEY_STRATEGY_ID, strategy_id);
            }
            String ab_type_status = eventParams.getAb_type_status();
            if (!TextUtils.isEmpty(ab_type_status)) {
                jSONObject.put(KEY_TYPE_STATUS, ab_type_status);
            }
            String errorCode = eventParams.getErrorCode();
            if (!TextUtils.isEmpty(errorCode)) {
                jSONObject.put("code", errorCode);
            }
            String errorMsg = eventParams.getErrorMsg();
            if (!TextUtils.isEmpty(errorMsg)) {
                jSONObject.put("msg", errorMsg);
            }
            String cache_ext = eventParams.getCache_ext();
            if (!TextUtils.isEmpty(cache_ext)) {
                jSONObject.put(KEY_CACHE_EXT, cache_ext);
            }
            String cache_ext_new = eventParams.getCache_ext_new();
            if (!TextUtils.isEmpty(cache_ext_new)) {
                jSONObject.put(KEY_CACHE_EXT_NEW, cache_ext_new);
            }
            long freeze_last_time = eventParams.getFreeze_last_time();
            if (freeze_last_time > 0) {
                jSONObject.put(KEY_FREEZE_LAST_TIME, freeze_last_time);
            }
            int budgetType = eventParams.getBudgetType();
            if (budgetType > 0) {
                jSONObject.put(KEY_PARAM_BUDGETTYPE, budgetType);
            }
            int cache_failed_size = eventParams.getCache_failed_size();
            if (cache_failed_size > 0) {
                jSONObject.put(KEY_CACHE_FAILED_SIZE, cache_failed_size);
            }
            int cache_success_size = eventParams.getCache_success_size();
            if (cache_success_size > 0) {
                jSONObject.put(KEY_CACHE_SUCCESS_SIZE, cache_success_size);
            }
            int cache_max_ecpm = eventParams.getCache_max_ecpm();
            if (cache_max_ecpm > 0) {
                jSONObject.put(KEY_CACHE_MAX_ECPM, cache_max_ecpm);
            }
            int cache_all_num = eventParams.getCache_all_num();
            if (cache_all_num > 0) {
                jSONObject.put(KEY_CACHE_ALL_NUM, cache_all_num);
            }
            int dspId = eventParams.getDspId();
            if (dspId > 0) {
                jSONObject.put("dspid", dspId);
            }
            int requestFailReason = eventParams.getRequestFailReason();
            if (requestFailReason != 0) {
                jSONObject.put(KEY_REQUEST_FAID_REASON, requestFailReason);
            }
            int group = eventParams.getGroup();
            if (group > 0) {
                jSONObject.put(KEY_GROUP, group);
            }
            int cache_size = eventParams.getCache_size();
            if (cache_size > 0) {
                jSONObject.put(KEY_CACHE_SIZE, cache_size);
            }
            int freeze_time = eventParams.getFreeze_time();
            if (freeze_time > 0) {
                jSONObject.put(KEY_FREEZE_TIME, freeze_time);
            }
            String pvId = eventParams.getPvId();
            if (!TextUtils.isEmpty(pvId)) {
                jSONObject.put(KEY_PARAM_PVID, pvId);
            }
            String sid = eventParams.getSid();
            if (!TextUtils.isEmpty(sid)) {
                jSONObject.put("sid", sid);
            }
            String adxSid = eventParams.getAdxSid();
            if (!TextUtils.isEmpty(adxSid)) {
                jSONObject.put(KEY_PARAM_ADXSID, adxSid);
            }
            String cp = eventParams.getCp();
            if (!TextUtils.isEmpty(cp)) {
                jSONObject.put(KEY_PARAM_CP, cp);
            }
            String scene = eventParams.getScene();
            if (!TextUtils.isEmpty(scene)) {
                jSONObject.put("scene", scene);
            }
            String dspName = eventParams.getDspName();
            if (!TextUtils.isEmpty(dspName)) {
                jSONObject.put("dspname", dspName);
            }
            String sdkVersion = eventParams.getSdkVersion();
            if (!TextUtils.isEmpty(sdkVersion)) {
                jSONObject.put(KEY_PARAM_SDKVER, sdkVersion);
            }
            String mediaId = eventParams.getMediaId();
            if (!TextUtils.isEmpty(mediaId)) {
                jSONObject.put(KEY_PARAM_MEDIAID, mediaId);
            }
            String srcId = eventParams.getSrcId();
            if (!TextUtils.isEmpty(srcId)) {
                jSONObject.put("srcid", srcId);
            }
            String adSceneClick = eventParams.getAdSceneClick();
            if (!TextUtils.isEmpty(adSceneClick)) {
                jSONObject.put(KEY_PARAM_ADSCENE_CLICK, adSceneClick);
            }
            String adType = eventParams.getAdType();
            if (!TextUtils.isEmpty(adType)) {
                jSONObject.put(KEY_PARAM_ADTYPE, adType);
            }
            String adBtnState = eventParams.getAdBtnState();
            if (!TextUtils.isEmpty(adBtnState)) {
                jSONObject.put(KEY_PARAM_ADBTNSTATE, adBtnState);
            }
            String number = eventParams.getNumber();
            if (!TextUtils.isEmpty(number)) {
                jSONObject.put(KEY_PARAM_NUMBER, number);
            }
            int renderStyle = eventParams.getRenderStyle();
            if (renderStyle != 0) {
                jSONObject.put(KEY_PARAM_RENDER_STYLE, renderStyle);
            }
            String nestSid = eventParams.getNestSid();
            if (!TextUtils.isEmpty(nestSid)) {
                jSONObject.put(KEY_PARAM_NEST_SID, nestSid);
            }
            int tmAdBtnShow = eventParams.getTmAdBtnShow();
            if (tmAdBtnShow != -1) {
                jSONObject.put(KEY_TM_ADBTNSHOW, tmAdBtnShow);
            }
            int redAdBtnShow = eventParams.getRedAdBtnShow();
            if (redAdBtnShow != -1) {
                jSONObject.put(KEY_RED_ADBTNSHOW, redAdBtnShow);
            }
            int ctAdBtnShow = eventParams.getCtAdBtnShow();
            if (ctAdBtnShow != -1) {
                jSONObject.put(KEY_CT_ADBTNSHOW, ctAdBtnShow);
            }
            String sdkFrom = eventParams.getSdkFrom();
            if (!TextUtils.isEmpty(sdkFrom)) {
                jSONObject.put(KEY_CT_SDK_FROM, sdkFrom);
            }
            jSONObject.put(KEY_USERTYPE, eventParams.getUser_type());
            int position = eventParams.getPosition();
            if (position != -1) {
                jSONObject.put(KEY_CT_SDK_POSITION, position);
            }
            String nestType = eventParams.getNestType();
            if (!TextUtils.isEmpty(nestType)) {
                jSONObject.put(KEY_PARAM_NEST_TYPE, nestType);
            }
            String adMode = eventParams.getAdMode();
            if (!TextUtils.isEmpty(adMode)) {
                jSONObject.put(KEY_PARAM_AD_MODE, adMode);
            }
            int adlevel = eventParams.getAdlevel();
            if (adlevel != -1) {
                jSONObject.put(KEY_AD_LEVEL, adlevel);
            }
            String sensitivewords = eventParams.getSensitivewords();
            if (!TextUtils.isEmpty(sensitivewords)) {
                jSONObject.put(KEY_SENSITIVEWORDS, sensitivewords);
            }
            String pkgname = eventParams.getPkgname();
            if (!TextUtils.isEmpty(pkgname)) {
                jSONObject.put("pkgname", pkgname);
            }
            String domainname = eventParams.getDomainname();
            if (!TextUtils.isEmpty(domainname)) {
                jSONObject.put(KEY_DOMAIN_NAME, domainname);
            }
            long costtime = eventParams.getCosttime();
            if (costtime != -1) {
                jSONObject.put(KEY_COST_TIME, costtime);
            }
            String csj = eventParams.getCsj();
            if (!TextUtils.isEmpty(csj)) {
                jSONObject.put("csj", csj);
            }
            String oppo = eventParams.getOppo();
            if (!TextUtils.isEmpty(oppo)) {
                jSONObject.put("oppo", oppo);
            }
            String huawei = eventParams.getHuawei();
            if (!TextUtils.isEmpty(huawei)) {
                jSONObject.put("huawei", huawei);
            }
            String gdt = eventParams.getGdt();
            if (!TextUtils.isEmpty(gdt)) {
                jSONObject.put("gdt", gdt);
            }
            String ks = eventParams.getKs();
            if (!TextUtils.isEmpty(ks)) {
                jSONObject.put("ks", ks);
            }
            float ecpm_ratio = eventParams.getEcpm_ratio();
            if (ecpm_ratio > 0.0f) {
                jSONObject.put(KEY_ECPM_RATIO, ecpm_ratio);
            }
            jSONObject.put(KEY_PRICE_RESPONSE, eventParams.getPrice_response());
            jSONObject.put(KEY_PRICE_SWITCH, eventParams.getPrice_switch());
            int ecpm_low_price = eventParams.getEcpm_low_price();
            if (ecpm_low_price > 0) {
                jSONObject.put(KEY_ECPM_LOW_PRICE, ecpm_low_price);
            }
            String nest = eventParams.getNest();
            if (!TextUtils.isEmpty(nest)) {
                jSONObject.put(KEY_NEST, nest);
            }
            String wifi = eventParams.getWifi();
            if (!TextUtils.isEmpty(wifi)) {
                jSONObject.put("wifi", wifi);
            }
            String baidu = eventParams.getBaidu();
            if (!TextUtils.isEmpty(baidu)) {
                jSONObject.put("baidu", baidu);
            }
            String feisuo = eventParams.getFeisuo();
            if (!TextUtils.isEmpty(feisuo)) {
                jSONObject.put("feisuo", feisuo);
            }
            String lxAd = eventParams.getLxAd();
            if (!TextUtils.isEmpty(lxAd)) {
                jSONObject.put("lxad", lxAd);
            }
            String beizi = eventParams.getBeizi();
            if (!TextUtils.isEmpty(beizi)) {
                jSONObject.put("beizi", beizi);
            }
            String quMeng = eventParams.getQuMeng();
            if (!TextUtils.isEmpty(quMeng)) {
                jSONObject.put("qumeng", quMeng);
            }
            String isDnld = eventParams.getIsDnld();
            if (!TextUtils.isEmpty(isDnld)) {
                jSONObject.put("isDnld", isDnld);
            }
            String respbtnwd = eventParams.getRespbtnwd();
            if (!TextUtils.isEmpty(respbtnwd)) {
                jSONObject.put("respbtnwd", respbtnwd);
            }
            String showbtnwd = eventParams.getShowbtnwd();
            if (!TextUtils.isEmpty(showbtnwd)) {
                jSONObject.put("showbtnwd", showbtnwd);
            }
            String discountInfo = eventParams.getDiscountInfo();
            if (!TextUtils.isEmpty(discountInfo)) {
                jSONObject.put(KEY_DISCOUNT_INFO, discountInfo);
            }
            int renderType = eventParams.getRenderType();
            if (renderType != -1) {
                jSONObject.put(KEY_RENDERTYPE, renderType);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAb_type_status() {
        return this.ab_type_status;
    }

    public String getAdBtnState() {
        return this.adBtnState;
    }

    public String getAdDesc() {
        return this.adDesc;
    }

    public String getAdImage() {
        return this.adImage;
    }

    public String getAdMode() {
        return this.adMode;
    }

    public String getAdRealLevel() {
        return this.adRealLevel;
    }

    public String getAdSceneClick() {
        return this.adSceneClick;
    }

    public String getAdTitle() {
        return this.adTitle;
    }

    public String getAdType() {
        return this.adType;
    }

    public int getAdcost() {
        return this.adcost;
    }

    public int getAdlevel() {
        return this.adlevel;
    }

    public String getAdxSid() {
        return this.adxSid;
    }

    public String getBaidu() {
        return this.baidu;
    }

    public String getBeizi() {
        return this.beizi;
    }

    public int getBudgetType() {
        return this.budgetType;
    }

    public int getCache_all_num() {
        return this.cache_all_num;
    }

    public String getCache_ext() {
        return this.cache_ext;
    }

    public String getCache_ext_new() {
        return this.cache_ext_new;
    }

    public int getCache_failed_size() {
        return this.cache_failed_size;
    }

    public int getCache_max_ecpm() {
        return this.cache_max_ecpm;
    }

    public int getCache_size() {
        return this.cache_size;
    }

    public int getCache_success_size() {
        return this.cache_success_size;
    }

    public String getCfgfrom() {
        return this.cfgfrom;
    }

    public int getChangeType() {
        return this.changeType;
    }

    public long getCosttime() {
        return this.costtime;
    }

    public String getCp() {
        return this.cp;
    }

    public String getCreateRequestId() {
        return this.createRequestId;
    }

    public String getCsj() {
        return this.csj;
    }

    public int getCtAdBtnShow() {
        return this.ctAdBtnShow;
    }

    public String getDiscountInfo() {
        return this.discountInfo;
    }

    public String getDomainname() {
        return this.domainname;
    }

    public int getDspId() {
        return this.dspId;
    }

    public String getDspName() {
        return this.dspName;
    }

    public int getEcpm_low_price() {
        return this.ecpm_low_price;
    }

    public float getEcpm_ratio() {
        return this.ecpm_ratio;
    }

    public String getErrorCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return this.msg;
    }

    public String getFeisuo() {
        return this.feisuo;
    }

    public long getFreeze_last_time() {
        return this.freeze_last_time;
    }

    public int getFreeze_time() {
        return this.freeze_time;
    }

    public String getGdt() {
        return this.gdt;
    }

    public int getGroup() {
        return this.group;
    }

    public String getHuawei() {
        return this.huawei;
    }

    public int getInteractiveType() {
        return this.interactive_type;
    }

    public String getInventoryId() {
        return this.inventoryId;
    }

    public String getIsDnld() {
        return this.isDnld;
    }

    public String getKs() {
        return this.ks;
    }

    public String getLxAd() {
        return this.lxad;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getNest() {
        return this.nest;
    }

    public String getNestSid() {
        return this.nestSid;
    }

    public String getNestType() {
        return this.nestType;
    }

    public long getNetSubType() {
        return this.netSubType;
    }

    public long getNetType() {
        return this.netType;
    }

    public String getNumber() {
        return this.number;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOppo() {
        return this.oppo;
    }

    public String getPkgname() {
        return this.pkgname;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPrice_response() {
        return this.price_response;
    }

    public int getPrice_switch() {
        return this.price_switch;
    }

    public String getPvId() {
        return this.pvId;
    }

    public String getQuMeng() {
        return this.qumeng;
    }

    public int getRedAdBtnShow() {
        return this.redAdBtnShow;
    }

    public int getRenderStyle() {
        return this.renderStyle;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public int getRequestFailReason() {
        return this.requestFailReason;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getRespbtnwd() {
        return this.respbtnwd;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSdkFrom() {
        return this.sdkFrom;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSensitivewords() {
        return this.sensitivewords;
    }

    public String getShowbtnwd() {
        return this.showbtnwd;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSrcId() {
        return this.srcId;
    }

    public String getStrategy_id() {
        return this.strategy_id;
    }

    public String getStrategy_ver() {
        return this.strategy_ver;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getThirdSdkInfo() {
        return this.thirdSdkInfo;
    }

    public int getTmAdBtnShow() {
        return this.tmAdBtnShow;
    }

    public String getUseRequestId() {
        return this.useRequestId;
    }

    public int getUser_type() {
        return this.user_type;
    }

    public String getWifi() {
        return this.wifi;
    }

    public void setAb_type_status(String str) {
        this.ab_type_status = str;
    }

    public void setAdBtnState(String str) {
        this.adBtnState = str;
    }

    public void setAdDesc(String str) {
        this.adDesc = str;
    }

    public void setAdImage(String str) {
        this.adImage = str;
    }

    public void setAdMode(String str) {
        this.adMode = str;
    }

    public void setAdRealLevel(String str) {
        this.adRealLevel = str;
    }

    public void setAdSceneClick(String str) {
        this.adSceneClick = str;
    }

    public void setAdTitle(String str) {
        this.adTitle = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdcost(int i) {
        this.adcost = i;
    }

    public void setAdlevel(int i) {
        this.adlevel = i;
    }

    public void setBaidu(String str) {
        this.baidu = str;
    }

    public void setBeizi(String str) {
        this.beizi = str;
    }

    public void setBudgetType(int i) {
        this.budgetType = i;
    }

    public void setCache_all_num(int i) {
        this.cache_all_num = i;
    }

    public void setCache_ext(String str) {
        this.cache_ext = str;
    }

    public void setCache_ext_new(String str) {
        this.cache_ext_new = str;
    }

    public void setCache_failed_size(int i) {
        this.cache_failed_size = i;
    }

    public void setCache_max_ecpm(int i) {
        this.cache_max_ecpm = i;
    }

    public void setCache_size(int i) {
        this.cache_size = i;
    }

    public void setCache_success_size(int i) {
        this.cache_success_size = i;
    }

    public void setCfgfrom(String str) {
        this.cfgfrom = str;
    }

    public void setChangeType(int i) {
        this.changeType = i;
    }

    public void setCosttime(long j) {
        this.costtime = j;
    }

    public void setCsj(String str) {
        this.csj = str;
    }

    public void setDiscountInfo(String str) {
        this.discountInfo = str;
    }

    public void setDomainname(String str) {
        this.domainname = str;
    }

    public void setDspId(int i) {
        this.dspId = i;
    }

    public void setEcpm_low_price(int i) {
        this.ecpm_low_price = i;
    }

    public void setEcpm_ratio(float f) {
        this.ecpm_ratio = f;
    }

    public void setFeisuo(String str) {
        this.feisuo = str;
    }

    public void setFreeze_last_time(int i) {
        this.freeze_last_time = i;
    }

    public void setFreeze_time(int i) {
        this.freeze_time = i;
    }

    public void setGdt(String str) {
        this.gdt = str;
    }

    public void setGroup(int i) {
        this.group = i;
    }

    public void setHuawei(String str) {
        this.huawei = str;
    }

    public void setInteractiveType(int i) {
        this.interactive_type = i;
    }

    public void setInventoryId(String str) {
        this.inventoryId = str;
    }

    public void setIsDnld(String str) {
        this.isDnld = str;
    }

    public void setKs(String str) {
        this.ks = str;
    }

    public void setLxAd(String str) {
        this.lxad = str;
    }

    public void setNest(String str) {
        this.nest = str;
    }

    public void setNestType(String str) {
        this.nestType = str;
    }

    public void setNetSubType(long j) {
        this.netSubType = j;
    }

    public void setNetType(long j) {
        this.netType = j;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOppo(String str) {
        this.oppo = str;
    }

    public void setPkgname(String str) {
        this.pkgname = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setPrice_response(int i) {
        this.price_response = i;
    }

    public void setPrice_switch(int i) {
        this.price_switch = i;
    }

    public void setQuMeng(String str) {
        this.qumeng = str;
    }

    public void setRenderStyle(int i) {
        this.renderStyle = i;
    }

    public void setRenderType(int i) {
        this.renderType = i;
    }

    public void setRequestFailReason(int i) {
        this.requestFailReason = i;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRespbtnwd(String str) {
        this.respbtnwd = str;
    }

    public void setSdkFrom(String str) {
        this.sdkFrom = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setSensitivewords(String str) {
        this.sensitivewords = str;
    }

    public void setShowbtnwd(String str) {
        this.showbtnwd = str;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setStrategy_id(String str) {
        this.strategy_id = str;
    }

    public void setStrategy_ver(String str) {
        this.strategy_ver = str;
    }

    public void setThirdSdkInfo(String str) {
        this.thirdSdkInfo = str;
    }

    public void setUser_type(int i) {
        this.user_type = i;
    }

    public void setWifi(String str) {
        this.wifi = str;
    }

    private EventParams() {
        this.user_type = 0;
        this.position = -1;
        this.tmAdBtnShow = -1;
        this.redAdBtnShow = -1;
        this.ctAdBtnShow = -1;
        this.ecpm_low_price = 0;
        this.price_switch = 1;
        this.price_response = 0;
        this.ecpm_ratio = 1.0f;
    }
}

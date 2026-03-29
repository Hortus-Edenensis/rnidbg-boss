package defpackage;

import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bw3 {
    public static void a(String str, String str2, String str3, int i, NestAdData nestAdData) {
        b(str, str2, str3, i, nestAdData, null);
    }

    public static void b(String str, String str2, String str3, int i, NestAdData nestAdData, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (nestAdData != null) {
            try {
                if (nestAdData.getHasReportExpose()) {
                    return;
                }
                nestAdData.setHasReportExpose(true);
                jSONObject2.put("requestId", str);
                jSONObject2.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject2.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject2.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject2.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject2.put("appid", nestAdData.getAppId());
                jSONObject2.put("srcid", nestAdData.getAdCode());
                jSONObject2.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject2.put("scene", i);
                jSONObject2.put("taichi", str2);
                jSONObject2.put("exp_group", str3);
                jSONObject2.put("dspname", nestAdData.getDspName());
                jSONObject2.put("adcost", nestAdData.getAdCost());
                jSONObject2.put(EventParams.KEY_ECPM_RATIO, nestAdData.getEcpmRatio());
                jSONObject2.put(EventParams.KEY_ECPM_LOW_PRICE, nestAdData.getEcpmLowPrice());
                jSONObject2.put(EventParams.KEY_ADREALNAME, nestAdData.getAdRealLevelName());
                jSONObject2.put(EventParams.KEY_PRICE_SWITCH, nestAdData.getPriceSwitch());
                jSONObject2.put(EventParams.KEY_PRICE_RESPONSE, nestAdData.getPriceResponse());
                jSONObject2.put(EventParams.KEY_AD_LEVEL, nestAdData.getAdLevel());
                jSONObject2.put(EventParams.KEY_GROUP, nestAdData.getGroupId());
                jSONObject2.put(EventParams.KEY_USE_REQUESTID, nestAdData.getUseRequestId());
                jSONObject2.put(EventParams.KEY_CREATE_REQUESTID, nestAdData.getCreateRequestId());
                jSONObject2.put("newRequestId", nestAdData.getUseRequestId());
                if (nestAdData.getZhiboAd().booleanValue()) {
                    jSONObject2.put(EventParams.KEY_PARAM_BUDGETTYPE, 1);
                }
                if (jSONObject != null) {
                    jSONObject2.put("data", jSONObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.d("", "NestSdkEventHelper NEST_SDK_AD_SHOW :" + jSONObject2);
            zn6.d("nest_sdk_ad_show", null, jSONObject2.toString());
        }
    }
}

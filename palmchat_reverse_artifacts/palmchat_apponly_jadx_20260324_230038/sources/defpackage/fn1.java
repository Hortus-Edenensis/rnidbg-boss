package defpackage;

import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class fn1 {
    public static void a(String str, NestAdData nestAdData, int i, String str2, int i2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
            jSONObject.put("appid", nestAdData.getAppId());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
            jSONObject.put("taichi", str3);
            jSONObject.put("exp_group", str4);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
            jSONObject.put("loadid", str2);
            jSONObject.put("pageType", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_click", null, jSONObject.toString());
    }

    public static void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", "LX-35416");
            jSONObject.put("exp_group", wh5.P());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
    }

    public static void c(String str, NestAdData nestAdData, String str2, int i, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
            jSONObject.put("appid", nestAdData.getAppId());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
            jSONObject.put("taichi", str3);
            jSONObject.put("exp_group", str4);
            jSONObject.put("loadid", str2);
            jSONObject.put("pageType", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get", null, jSONObject.toString());
    }

    public static void d(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put("loadid", str3);
            jSONObject.put("pageType", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
    }

    public static void e(String str, int i, String str2, int i2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", str3);
            jSONObject.put("exp_group", str4);
            jSONObject.put("reqType", i);
            jSONObject.put("loadid", str2);
            jSONObject.put("pageType", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void f(String str, NestAdData nestAdData, int i, String str2, int i2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
            jSONObject.put("appid", nestAdData.getAppId());
            jSONObject.put("srcid", nestAdData.getAdCode());
            jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
            jSONObject.put("taichi", str3);
            jSONObject.put("exp_group", str4);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
            jSONObject.put("loadid", str2);
            jSONObject.put("pageType", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_show", null, jSONObject.toString());
    }
}

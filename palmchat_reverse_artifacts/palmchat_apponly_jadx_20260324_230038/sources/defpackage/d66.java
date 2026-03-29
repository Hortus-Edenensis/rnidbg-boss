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
/* JADX INFO: loaded from: classes4.dex */
public final class d66 {
    public static void a(String str, NestAdData nestAdData, int i, String str2) {
        if (nestAdData == null) {
            return;
        }
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
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
            jSONObject.put("sid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_click ext " + jSONObject);
        zn6.d("lx_client_nestad_click", null, jSONObject.toString());
    }

    public static void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_getConfig ext " + jSONObject);
        zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
    }

    public static void c(String str, NestAdData nestAdData, String str2) {
        if (nestAdData == null) {
            return;
        }
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
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
            jSONObject.put("sid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_get ext " + jSONObject);
        zn6.d("lx_client_nestad_get", null, jSONObject.toString());
    }

    public static void d(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
            jSONObject.put("sid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_get_fail ext " + jSONObject);
        zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
    }

    public static void e(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
            jSONObject.put("sid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_req ext " + jSONObject);
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void f(String str, NestAdData nestAdData, int i, String str2) {
        if (nestAdData == null) {
            return;
        }
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
            jSONObject.put("taichi", "LX-44444");
            jSONObject.put("exp_group", p66.b());
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
            jSONObject.put("sid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("UserDetailAd", "event lx_client_nestad_show ext " + jSONObject);
        zn6.d("lx_client_nestad_show", null, jSONObject.toString());
    }
}

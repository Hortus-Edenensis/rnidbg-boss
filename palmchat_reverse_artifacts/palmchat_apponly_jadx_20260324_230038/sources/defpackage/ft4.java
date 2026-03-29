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
public final class ft4 {
    public static void a(String str, NestAdData nestAdData) {
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
            jSONObject.put("taichi", ju3.o());
            jSONObject.put("exp_group", ju3.p());
            jSONObject.put("loadid", ju3.m());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_click", null, jSONObject.toString());
    }

    public static void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", ju3.o());
            jSONObject.put("exp_group", ju3.p());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
    }

    public static void c(String str, NestAdData nestAdData) {
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
            jSONObject.put("taichi", ju3.o());
            jSONObject.put("exp_group", ju3.p());
            jSONObject.put("loadid", ju3.m());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get", null, jSONObject.toString());
    }

    public static void d(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put("loadid", ju3.m());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
    }

    public static void e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", ju3.o());
            jSONObject.put("exp_group", ju3.p());
            jSONObject.put("loadid", ju3.m());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void f(String str, NestAdData nestAdData) {
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
            jSONObject.put("taichi", ju3.o());
            jSONObject.put("exp_group", ju3.p());
            jSONObject.put("loadid", ju3.m());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_show", null, jSONObject.toString());
    }

    public static void g() {
        zn6.d("friend_nearby_reward_video_click", null, new JSONObject().toString());
    }

    public static void h() {
        zn6.d("friend_nearby_reward_given", null, new JSONObject().toString());
    }

    public static void i() {
        zn6.d("friend_nearby_reward_video_show", null, new JSONObject().toString());
    }

    public static void j() {
        zn6.d("friend_nearby_vip_click", null, new JSONObject().toString());
    }

    public static void k() {
        zn6.d("friend_nearby_vip_show", null, new JSONObject().toString());
    }
}

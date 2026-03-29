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
public final class gn1 {
    public static void a(String str, String str2, String str3, int i, NestAdData nestAdData, String str4, int i2) {
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
            jSONObject.put("scene", i);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, str4 + "," + i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_click", null, jSONObject.toString());
    }

    public static void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", str);
            jSONObject.put("exp_group", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
    }

    public static void c(String str) {
        String str2;
        String strD;
        JSONObject jSONObject = new JSONObject();
        try {
            if ("tab_mine".equals(str)) {
                str2 = "LX-34097";
                strD = gp3.f();
            } else {
                str2 = "LX-33784";
                strD = ns5.d();
            }
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", strD);
            jSONObject.put("tabName", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_entertab", null, jSONObject.toString());
    }

    public static void d(String str, String str2, String str3, int i, NestAdData nestAdData) {
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
            jSONObject.put("scene", i);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get", null, jSONObject.toString());
    }

    public static void e(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
            jSONObject.put("scene", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
    }

    public static void f(String str, String str2, String str3, int i) {
        if (gp3.b) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taichi", str);
                jSONObject.put("exp_group", str2);
                jSONObject.put("tabName", str3);
                jSONObject.put("reason", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_noreq", null, jSONObject.toString());
        }
    }

    public static void g(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", str);
            jSONObject.put("exp_group", str2);
            jSONObject.put("tabName", str3);
            jSONObject.put("reason", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_noshow", null, jSONObject.toString());
    }

    public static void h(String str, String str2, String str3, Integer num) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
            if (num != null) {
                jSONObject.put("reqType", num);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void i(String str, String str2, String str3, int i, NestAdData nestAdData, String str4, int i2) {
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
            jSONObject.put("scene", i);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, str4 + "," + i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_show", null, jSONObject.toString());
    }
}

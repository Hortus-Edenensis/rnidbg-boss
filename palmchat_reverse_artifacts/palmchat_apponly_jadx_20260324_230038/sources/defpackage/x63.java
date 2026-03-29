package defpackage;

import com.lantern.auth.server.WkParams;
import com.lantern.auth.stub.WkSDKFeature;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class x63 {
    public static HashMap<String, Object> a(int i) {
        HashMap<String, Object> mapD = d();
        mapD.put("registfrom", Integer.valueOf(i));
        return mapD;
    }

    public static JSONObject b(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("netstate", hx3.h());
            jSONObject.put(DeviceInfoUtil.UID_TAG, str);
            jSONObject.put("registfrom", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String c(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WkSDKFeature.WHAT_LOGIN, i);
            jSONObject.put("type", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static HashMap<String, Object> d() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("channelId", ac1.m);
        map.put("deviceId", ac1.h);
        map.put(WkParams.IMEI, ac1.i);
        map.put("androidId", ac1.p);
        map.put("netstate", hx3.h());
        return map;
    }

    public static HashMap<String, Object> e(int i) {
        HashMap<String, Object> mapD = d();
        mapD.put("pageFrom", Integer.valueOf(i));
        return mapD;
    }

    public static String f() {
        return g().toString();
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("netstate", hx3.h());
            jSONObject.put("ver", ym4.d(true));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

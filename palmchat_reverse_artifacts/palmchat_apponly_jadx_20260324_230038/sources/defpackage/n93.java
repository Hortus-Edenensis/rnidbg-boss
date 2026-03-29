package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class n93 {
    public static void a(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("reqId", str);
            jSONObject.put("targetuid", str2);
            jSONObject.put("report_type", "click");
            int i2 = 1;
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            if (!fg6.d(AppContext.getContext())) {
                i2 = 0;
            }
            jSONObject.put("svip_status", i2);
            jSONObject.put("num", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_popup_click", null, jSONObject.toString());
    }

    public static void b(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("reqId", str);
            jSONObject.put("targetuid", str2);
            jSONObject.put("report_type", "view");
            int i2 = 1;
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            if (!fg6.d(AppContext.getContext())) {
                i2 = 0;
            }
            jSONObject.put("svip_status", i2);
            jSONObject.put("num", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_popup_show", null, jSONObject.toString());
    }

    public static void c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            int i = 1;
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            jSONObject.put("from_uid", str);
            if (!fg6.d(AppContext.getContext())) {
                i = 0;
            }
            jSONObject.put("svip_status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_reminder_click", null, jSONObject.toString());
    }

    public static void d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("from_uid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_reminder_get", null, jSONObject.toString());
    }

    public static void e(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            int i2 = 1;
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            jSONObject.put("reason", i);
            jSONObject.put("from_uid", str);
            if (!fg6.d(AppContext.getContext())) {
                i2 = 0;
            }
            jSONObject.put("svip_status", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_reminder_noshow", null, jSONObject.toString());
    }

    public static void f(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            int i = 1;
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            jSONObject.put("from_uid", str);
            if (!fg6.d(AppContext.getContext())) {
                i = 0;
            }
            jSONObject.put("svip_status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_reminder_show", null, jSONObject.toString());
    }

    public static void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("reqId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_popup_req", null, jSONObject.toString());
    }

    public static void h(String str, boolean z, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("reqId", str);
            jSONObject.put("result", z ? 1 : 0);
            jSONObject.put("targetuid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("heartbeat_popup_result", null, jSONObject.toString());
    }
}

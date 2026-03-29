package defpackage;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pu3 {
    public static void a(String str, int i, int i2, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put(DeviceInfoUtil.DEVICEID_TAG, ac1.h);
            jSONObject.put("scene", i2);
            jSONObject.put("inventoryid", str);
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_REQUESTID, str2);
            jSONObject.put("noADreason", i);
            zn6.d("lx_client_nestad_inventory", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String b() {
        return rb3.c(Long.toString(System.currentTimeMillis()) + UUID.randomUUID());
    }

    public static void c(int i, String str, String str2) {
        d(i, str, str2, 0);
    }

    public static void d(int i, String str, String str2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frequency_reason", i);
            jSONObject.put("frequency_type", i2);
            jSONObject.put("taichi", str);
            jSONObject.put("exp_group", str2);
            zn6.d("lx_frequency_contrl", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void e(int i, String str, String str2, int i2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frequency_reason", i);
            jSONObject.put("frequency_type", i2);
            jSONObject.put("taichi", str);
            jSONObject.put("exp_group", str2);
            jSONObject.put("frequency_page", str3);
            zn6.d("lx_frequency_contrl", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void f(String str, String str2, int i, int i2, int i3, int i4, int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put(DeviceInfoUtil.DEVICEID_TAG, ac1.h);
            jSONObject.put("result", i5);
            jSONObject.put("inventoryid", str);
            jSONObject.put("type", str2);
            jSONObject.put("taichi", "LX-31249");
            jSONObject.put("exp_group", dw3.y());
            jSONObject.put(HiAnalyticsConstant.Direction.REQUEST, i);
            jSONObject.put("noreqReason", i2);
            jSONObject.put(bq.b.V, i3);
            jSONObject.put("noshowReason", i4);
            zn6.d("splash_inventory", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

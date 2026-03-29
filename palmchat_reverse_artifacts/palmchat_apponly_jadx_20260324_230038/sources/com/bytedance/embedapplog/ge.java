package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.oplus.tblplayer.Constants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ge {
    private static final String[] u = {"ab_version", bt.F, "language", "os_api", "resolution", "google_aid", "build_serial", bt.P, "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] nr = {"ab_version", bt.F, "language", "os_api", "resolution", "google_aid", "build_serial", bt.P, "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bt.ac, Constant.MAP_KEY_UUID, "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String u(Context context, JSONObject jSONObject, String str, boolean z, nr nrVar) {
        HashMap<String, String> mapU;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(u.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = u;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(nr[i], strOptString);
            }
            i++;
        }
        if (nrVar != null) {
            try {
                mapU = nrVar.u(context);
            } catch (Exception e) {
                ti.nr(e);
            }
        } else {
            mapU = null;
        }
        if (gb.fx(context) && mapU != null) {
            map.putAll(mapU);
        }
        try {
            HashMap<String, String> mapU2 = u.fx() == null ? null : u.fx().u();
            if (mapU2 != null) {
                map.putAll(mapU2);
            }
        } catch (Exception e2) {
            ti.nr(e2);
        }
        if (u.fx.size() > 0) {
            map.putAll(u.fx);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strU = df.u(context);
        if (!TextUtils.isEmpty(strU)) {
            map.put(OapsKey.KEY_ACTIVE_CODE, strU);
        }
        String str2 = (String) u.u("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) u.u("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) u.u("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) u.u("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) u.u("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strU2 = ec.u(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strU2)) {
            map.put("oaid", strU2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? Typography.amp : '?');
        return gb.u(sb.toString(), map, "UTF-8");
    }

    public static String[] u(xg xgVar, Context context, JSONObject jSONObject) {
        String[] strArrNr = xgVar.n().nr();
        String[] strArr = new String[strArrNr.length];
        String str = u.n() ? "?tt_data=a" : Constants.STRING_VALUE_UNSET;
        for (int i = 0; i < strArrNr.length; i++) {
            String strU = u(context, jSONObject, strArrNr[i] + str, true, u.b());
            strArr[i] = strU;
            strArr[i] = rv.u(strU, rv.nr);
        }
        return strArr;
    }
}

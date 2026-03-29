package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class n implements Runnable {
    private final Map<String, String> b = iz.nr();
    private String fx;
    private String nr;
    private final Context u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5194a;
        public String b;
        public String fx;
        public int iz;
        public boolean jk;
        public int n;
        public int nr;
        public String pn;
        public String u;
        public int x;

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.u).put("version_code", this.nr).put("sign", this.b).put("max_version", this.x).put("min_version", this.iz).put("is_revert", this.jk).put("md5", this.pn).put("plugin_file", this.f5194a).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    public n(Context context) {
        this.u = context;
    }

    private String b() {
        Context context;
        if (TextUtils.isEmpty(this.nr) && (context = this.u) != null) {
            try {
                this.fx = context.getPackageName();
                this.nr = this.u.getPackageManager().getPackageInfo(this.fx, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.nr;
    }

    private JSONObject fx() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("app_id", this.b.get("appid"));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
        jSONObject2.put("sdk_version", "7.2.3.2");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    private JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.bytedance.sdk.openadsdk.api.plugin.fx.pn.nr(this.u));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.2.3.2");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("app_version", b());
            jSONObject.put("package_name", this.fx);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.b.get("appid");
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", str);
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.api.plugin.fx.b.u(str != null ? str.concat(String.valueOf(jCurrentTimeMillis)).concat("7.2.3.2") : ""));
            jSONObject.put("channel", "main");
            jSONObject.put(WkParams.IMEI, this.b.get(WkParams.IMEI));
            jSONObject.put(az.at, 0);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", fx());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        pn.u("plugin_download", "start run");
        String strU = com.bytedance.sdk.openadsdk.api.plugin.nr.fx.u().u(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.bytedance.sdk.openadsdk.api.plugin.fx.nr.u(nr()).toString().getBytes());
        if (strU == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strU);
            if (jSONObject.optInt("cypher") == 3) {
                String strNr = com.bytedance.sdk.openadsdk.api.plugin.fx.nr.nr(jSONObject.optString("message"));
                if (TextUtils.isEmpty(strNr)) {
                    return;
                }
                fx.u(this.u).u(u(new JSONObject(strNr).optJSONArray("plugins")));
            }
        } catch (JSONException e) {
            pn.u("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    public void u() throws Throwable {
        if (com.bytedance.sdk.openadsdk.api.plugin.fx.pn.u(this.u)) {
            run();
        }
    }

    private List<u> u(JSONArray jSONArray) {
        pn.u("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                u uVar = new u();
                uVar.u = jSONObjectOptJSONObject.optString("package_name");
                uVar.nr = jSONObjectOptJSONObject.optInt("version_code");
                uVar.fx = jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
                uVar.b = jSONObjectOptJSONObject.optString("sign");
                uVar.iz = u(jSONObjectOptJSONObject.optString("min_version"));
                uVar.x = u(jSONObjectOptJSONObject.optString("max_version"));
                uVar.n = jSONObjectOptJSONObject.optInt("plugin_update_network");
                arrayList.add(uVar);
                pn.u("plugin_download", "parse " + i + " : " + uVar);
            }
        }
        return arrayList;
    }

    private int u(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(".", ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }
}

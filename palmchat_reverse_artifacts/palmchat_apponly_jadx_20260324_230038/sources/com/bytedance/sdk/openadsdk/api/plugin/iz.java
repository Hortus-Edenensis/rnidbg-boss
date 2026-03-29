package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.lantern.auth.server.WkParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class iz {
    private static SharedPreferences nr;
    private static final List<Pair<String, JSONObject>> fx = new CopyOnWriteArrayList();
    static final Map<String, String> u = new HashMap();

    private static void b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            pn(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject iz(String str, JSONObject jSONObject) {
        String str2 = "7.2.3.2";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.bytedance.sdk.openadsdk.api.plugin.fx.fx.fx());
            jSONObject2.put("ad_sdk_version", "7.2.3.2");
            a.u(TTAppContextHolder.getContext());
            String strU = a.u("com.byted.pangle");
            if (!TextUtils.isEmpty(strU)) {
                str2 = strU;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = u;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WkParams.MODEL, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put(WkParams.IMEI, map.get(WkParams.IMEI));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(int i, String str, boolean z, x xVar, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (xVar != null) {
            try {
                xVar.u(jSONObject);
            } catch (Throwable th2) {
                u("report_failed", null, th2);
                return;
            }
        }
        jSONObject.putOpt("code", Integer.valueOf(i));
        jSONObject.putOpt("message", str);
        jSONObject.putOpt("is_plugin", Boolean.valueOf(z));
        jSONObject.putOpt("api", Boolean.TRUE);
        a.u(TTAppContextHolder.getContext());
        jSONObject.putOpt("install_version", Integer.valueOf(Zeus.getPlugin("com.byted.pangle").getVersion()));
        jSONObject.putOpt("load_record", pn.u());
        u("init_failed", jSONObject, th);
    }

    private static void pn(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.iz.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iz.iz(str, jSONObject));
                iz.nr(arrayList);
            }
        });
    }

    public static void u(String str, JSONObject jSONObject) {
        b("zeus_".concat(String.valueOf(str)), jSONObject);
    }

    public static void u() {
        List<Pair<String, JSONObject>> list = fx;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    b((String) pair.first, (JSONObject) pair.second);
                }
            }
            fx.clear();
        } catch (Exception unused) {
        }
    }

    public static void u(final int i, final String str, final boolean z, final x xVar, final Throwable th) {
        if (com.bytedance.sdk.openadsdk.api.pn.u()) {
            return;
        }
        com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.c
            @Override // java.lang.Runnable
            public final void run() {
                iz.nr(i, str, z, xVar, th);
            }
        });
    }

    public static void u(String str, JSONObject jSONObject, Throwable th) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            jSONObject2.putOpt("exception", Log.getStackTraceString(th));
            pn("exception", jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void nr(String str, JSONObject jSONObject) {
        fx.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(List<JSONObject> list) throws Throwable {
        if (list == null) {
            return;
        }
        if (nr == null) {
            nr = nr.nr(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String str = String.format("https://%s%s", nr.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = fx;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(iz((String) pair.first, (JSONObject) pair.second));
                }
                fx.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.nr.fx.u().u(true, str, com.bytedance.sdk.openadsdk.api.plugin.fx.nr.u(jSONObject).toString().getBytes());
    }

    public static void u(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = u;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put(WkParams.IMEI, customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    public static Map<String, String> nr() {
        return u;
    }
}

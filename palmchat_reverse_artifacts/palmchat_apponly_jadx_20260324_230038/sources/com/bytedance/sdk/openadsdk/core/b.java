package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static String u = "AppEnvironment";
    private boolean b;
    private long fx;
    private Map<String, String> nr;
    private String pn;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public static final b u = new b();
    }

    private void b() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) dw.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.k.nr(u, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.k.nr(u, "maxMemory: ".concat(String.valueOf(fMaxMemory)));
        com.bytedance.sdk.component.utils.k.nr(u, "totalMemory: ".concat(String.valueOf(f)));
        com.bytedance.sdk.component.utils.k.nr(u, "freeMemory: ".concat(String.valueOf((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d))));
        int i = (int) ((f / fMaxMemory) * 100.0f);
        com.bytedance.sdk.component.utils.k.nr(u, "totalMaxRate: ".concat(String.valueOf(i)));
        this.nr.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.nr.put("total_max_memory_rate", String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pn() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = dw.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", n.o().c());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void fx(String str) {
        this.nr.put("show_ad_info", str);
    }

    public void nr(String str) {
        this.nr.put("request_ad_info", str);
    }

    private b() {
        this.pn = "";
        HashMap map = new HashMap();
        this.nr = map;
        map.put(MapBundleKey.MapObjKey.OBJ_AD_STYLE, MapController.DEFAULT_LAYER_TAG);
        this.nr.put(MediationConstant.EXTRA_ADID, MapController.DEFAULT_LAYER_TAG);
        this.nr.put("rit", MapController.DEFAULT_LAYER_TAG);
        this.nr.put(be.g, MapController.DEFAULT_LAYER_TAG);
        this.nr.put("ad_slot_type", MapController.DEFAULT_LAYER_TAG);
        this.nr.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, MapController.DEFAULT_LAYER_TAG);
        this.nr.put("low_memory", MapController.DEFAULT_LAYER_TAG);
        this.nr.put("total_max_memory_rate", MapController.DEFAULT_LAYER_TAG);
        this.nr.put("commit_hash", "a5b2d15");
        this.nr.put("branch", BuildConfig.BRANCH);
        this.nr.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
        this.nr.put("sdk_api_version", d.b);
        this.nr.put("setting_ab_version", com.bytedance.sdk.openadsdk.core.fx.pn.u().pn());
        this.fx = com.bytedance.sdk.openadsdk.core.y.bf.u("tt_sp_app_env").get("last_app_env_time", 0L);
        this.b = false;
    }

    public void fx() {
        if (this.b || jp.u(this.fx, System.currentTimeMillis())) {
            return;
        }
        this.b = true;
        com.bytedance.sdk.openadsdk.core.qq.s.u().n(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.b.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                b.this.b = false;
                com.bytedance.sdk.openadsdk.core.qq.u.nr<com.bytedance.sdk.openadsdk.core.qq.u.nr> nrVarNr = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr();
                JSONObject jSONObjectPn = b.this.pn();
                if (jSONObjectPn != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    b.this.fx = jCurrentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.y.bf.u("tt_sp_app_env").put("last_app_env_time", jCurrentTimeMillis);
                    nrVarNr.nr(jSONObjectPn.toString());
                }
                return nrVarNr;
            }
        });
    }

    public void nr(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        this.nr.put(MediationConstant.EXTRA_ADID, bcVar.lk());
        Map<String, String> map = this.nr;
        StringBuilder sb = new StringBuilder();
        sb.append(jp.t(bcVar));
        map.put("rit", sb.toString());
        this.nr.put(be.g, jp.k(bcVar));
        Map<String, String> map2 = this.nr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jp.jk(bcVar));
        map2.put("ad_slot_type", sb2.toString());
        this.nr.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, com.bytedance.sdk.component.utils.o.x(dw.getContext()));
        if (com.bytedance.sdk.openadsdk.core.y.q.nr(bcVar)) {
            this.nr.put(MapBundleKey.MapObjKey.OBJ_AD_STYLE, "is_playable");
        }
        b();
    }

    public static b u() {
        return u.u;
    }

    public void u(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        String strYf = bcVar.yf();
        Map<String, String> map = this.nr;
        if (TextUtils.isEmpty(strYf)) {
            strYf = "";
        }
        map.put("ad_info", strYf);
    }

    public void u(String str) {
        this.nr.put("dynamic_ptpl_id", str);
    }

    public Map<String, String> nr() {
        return this.nr;
    }
}

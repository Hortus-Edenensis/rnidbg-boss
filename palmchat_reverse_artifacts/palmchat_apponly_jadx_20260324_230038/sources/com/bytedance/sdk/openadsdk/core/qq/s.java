package com.bytedance.sdk.openadsdk.core.qq;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.location.LocationConst;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.v;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qiniu.android.collect.ReportItem;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private static volatile s u;

    private s() {
    }

    public static boolean fx(String str, String str2) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), str2);
        if (TextUtils.equals(str, com.bytedance.sdk.openadsdk.gi.b.u(file))) {
            return false;
        }
        com.bytedance.sdk.openadsdk.gi.b.u(str, file);
        com.bytedance.sdk.openadsdk.core.nr.u().remove("plugin_first_load");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void iz(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_".concat(str);
            }
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "7.2.3.2");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
                jSONObject.put("max_retry_count", com.bytedance.sdk.openadsdk.core.pb.jk.nr(jSONObject.optString("plugin_package_name")));
                jSONObject.put(Constant.MAP_KEY_UUID, com.bytedance.sdk.openadsdk.core.y.jk.sx());
            }
            final JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
            final int iOptInt = jSONObject2.has(ReportItem.RequestKeyStatusCode) ? jSONObject2.optInt(ReportItem.RequestKeyStatusCode) : jSONObject2.optInt("code");
            final String strOptString = jSONObject2.optString("message");
            final String strOptString2 = jSONObject2.optString("duration");
            final String string = jSONObject2.toString();
            final String str3 = str;
            nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.46
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    if (!"zeus_load_finish".equals(str3)) {
                        return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str3).nr(string).nr(iOptInt).pn(strOptString2).x(strOptString);
                    }
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str3).nr(string).nr(iOptInt).x(strOptString).pn(strOptString2).u(s.fx(jSONObject2.optString("version_code"), jSONObject2.optString("plugin_package_name")) ? 1 : 0);
                }
            }, str, true);
        } catch (Throwable unused) {
        }
    }

    private boolean nr(com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar) {
        return nrVar == null;
    }

    public static s u() {
        if (u == null) {
            synchronized (s.class) {
                if (u == null) {
                    u = new s();
                }
            }
        }
        return u;
    }

    public void a(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.43
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("type_realtime_feature_cost");
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "type_realtime_feature_cost", true);
    }

    public void b(final String str, final String str2) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.47
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("lp_monitor").iz(str2).nr(str);
            }
        }, "lp_monitor", true);
    }

    public void n(final com.bytedance.sdk.openadsdk.t.u.u uVar) {
        if (uVar == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.11
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return ((com.bytedance.sdk.openadsdk.core.qq.u.nr) uVar.u()).u("app_env").u(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void x(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        fx(uVar, "splash_creative_check");
    }

    private void b(final com.bytedance.sdk.openadsdk.t.u.u uVar, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.6
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.qq.u.nr) uVar.u();
                nrVar.u(str);
                nrVar.u(jCurrentTimeMillis);
                return nrVar;
            }
        }, str, true);
    }

    public void n(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.40
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("landingpage_check_info");
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "landingpage_check_info", true);
    }

    public void nr(final String str, final String str2) {
        com.bytedance.sdk.component.jk.x.fx(new com.bytedance.sdk.component.jk.a("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.qq.s.45
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    s.iz(str, str2);
                    return;
                }
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
                    if (str2 != null) {
                        s.this.u(jSONObject.optString("scene"), jSONObject, (Throwable) null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public void pn(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        b(uVar, "express_ad_render");
    }

    public void x(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.39
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("render_timeout_opt");
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "render_timeout_opt", true);
    }

    public void nr() {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.48
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.my.fx.fx.b bVarBq = com.bytedance.sdk.openadsdk.core.n.o().bq();
                boolean zNr = bVarBq.nr();
                boolean zU = bVarBq.u();
                boolean zPn = bVarBq.pn();
                boolean zB = bVarBq.b();
                boolean zFx = bVarBq.fx();
                boolean zIz = bVarBq.iz();
                String strL = bVarBq.l();
                JSONObject jSONObject = new JSONObject();
                int i = 1;
                try {
                    jSONObject.put("access_fine_location", zU ? 1 : 0);
                    jSONObject.put("applist", zNr ? 1 : 0);
                    jSONObject.put("external_storage", zPn ? 1 : 0);
                    jSONObject.put("wifi_state", zB ? 1 : 0);
                    jSONObject.put("phone_state", zFx ? 1 : 0);
                    jSONObject.put("can_use_androidId", zIz ? 1 : 0);
                    jSONObject.put("dev_oaid", strL);
                    if (!com.bytedance.sdk.openadsdk.core.n.o().s()) {
                        i = 0;
                    }
                    jSONObject.put("uip", i);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("sdk_permission").nr(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void pn(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.37
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("device_qty_compare");
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "device_qty_compare", true);
    }

    public void b(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        fx(uVar, "load_timeout");
    }

    public void nr(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        fx(uVar, "outer_call_send");
    }

    public void b(JSONObject jSONObject) {
        u("live_init_start", jSONObject);
    }

    public void nr(final int i) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.20
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("get_ad_cache_failed").nr(i);
            }
        }, "get_ad_cache_failed", true);
    }

    public void b(bc bcVar, String str) {
        u(bcVar, str, (JSONObject) null);
    }

    public void nr(com.bytedance.sdk.openadsdk.t.u.u uVar, String str) {
        nr.fx().u(uVar, str, true);
    }

    private void fx(com.bytedance.sdk.openadsdk.t.u.u uVar, String str) {
        u(uVar, str, true);
    }

    public void nr(final JSONObject jSONObject) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.26
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("saas_schema").nr(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public void u(com.bytedance.sdk.openadsdk.t.u.u uVar, String str) {
        nr.fx().u(uVar, str, true);
    }

    public void fx(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        fx(uVar, "outer_call_no_rsp");
    }

    public void nr(final bc bcVar, final String str) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.32
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("uttie_start");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "uttie_start");
    }

    public void u(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("render_backup").nr(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public static void u(SparseArray<Object> sparseArray, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        com.bytedance.sdk.openadsdk.my.u uVar = new com.bytedance.sdk.openadsdk.my.u(sparseArray);
        PluginValueSet pluginValueSetB = uVar.b();
        boolean zU = uVar.u();
        int iNr = uVar.nr();
        String strFx = uVar.fx();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("success", zU);
            jSONObject4.put("code", iNr);
            jSONObject4.put("message", strFx);
        } catch (JSONException unused) {
        }
        if (pluginValueSetB != null) {
            JSONObject jSONObject5 = (JSONObject) pluginValueSetB.objectValue(10, JSONObject.class);
            String strStringValue = pluginValueSetB.stringValue(5);
            jCurrentTimeMillis = jSONObject5 != null ? System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L) : -1L;
            JSONObject jSONObject6 = (JSONObject) pluginValueSetB.objectValue(3, JSONObject.class);
            jSONObject3 = (JSONObject) pluginValueSetB.objectValue(4, JSONObject.class);
            jSONObject2 = jSONObject6;
            str = strStringValue;
        } else {
            str = null;
            jSONObject2 = null;
            jSONObject3 = null;
        }
        u().u(str, jSONObject != null ? jSONObject.optString("business_type") : "", zU, jCurrentTimeMillis, jSONObject2, jSONObject3, jSONObject4);
    }

    public void fx(JSONObject jSONObject) {
        u("live_init_success", jSONObject);
    }

    public void fx(final bc bcVar, final String str) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.35
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("uttie_close");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "uttie_close");
    }

    public void iz(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        b(uVar, "show_backup_endcard");
    }

    public void iz(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.38
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("device_bytebench");
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "device_bytebench", true);
    }

    public void u(final long j, final long j2, final int i) {
        final long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.12
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("general_label");
                StringBuilder sb = new StringBuilder();
                sb.append(j3);
                return nrVarU.pn(sb.toString()).nr(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void u(final String str, final String str2) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.22
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("sdk_retention").pn(str).nr(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void u(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.33
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put(ReportItem.RequestKeyRequestId, str2);
                    jSONObject.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("obm_result").nr(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void u(String str, int i, int i2, String str2, final int i3, final String str3, final long j, boolean z) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put("package_name", str);
            jSONObject.put("url", str2);
            try {
                jSONObject.put("duration", j);
                jSONObject.put("max_retry_count", com.bytedance.sdk.openadsdk.core.pb.jk.nr(str));
                jSONObject.put(Constant.MAP_KEY_UUID, com.bytedance.sdk.openadsdk.core.y.jk.sx());
                jSONObject.put("isRetry", z);
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.42
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarX = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("plugin_download").nr(i3).x(str3);
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                return nrVarX.pn(sb.toString()).nr(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public void u(final bc bcVar, final JSONObject jSONObject) {
        if (bcVar == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarIz = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("jsb_video_action").iz(bcVar.xx());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    nrVarIz.nr(jSONObject2.toString());
                }
                nrVarIz.fx(jp.u(bcVar, ""));
                return nrVarIz;
            }
        }, "jsb_video_action", true);
    }

    public static void u(final String str, final long j, final boolean z) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.3
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z);
                jSONObject.put("timestamp", j);
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("over_freq").fx(str).nr(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    public static void u(final int i, final int i2) {
        k.nr("xgc_report", "volume:" + i + " bright:" + i2);
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.4
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                int i3 = i;
                if (i3 != -1) {
                    jSONObject.put("user_volume_change", i3);
                }
                int i4 = i2;
                if (i4 != -1) {
                    jSONObject.put("user_bright_change", i4);
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("system_change").nr(jSONObject.toString());
            }
        }, "system_change", true);
    }

    private void u(final com.bytedance.sdk.openadsdk.t.u.u uVar, final String str, boolean z) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.5
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.qq.u.nr) uVar.u();
                nrVar.u(str);
                nrVar.u(jCurrentTimeMillis);
                return nrVar;
            }
        }, str, true);
    }

    public void u(com.bytedance.sdk.openadsdk.t.u.u uVar) {
        fx(uVar, "outer_call");
    }

    public void u(final long j, final com.bytedance.sdk.openadsdk.t.u.u uVar) {
        if (uVar == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.7
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.qq.u.nr) uVar.u();
                nrVar.u("ad_node_line");
                nrVar.u(j);
                return nrVar;
            }
        }, "ad_node_line", true);
    }

    private boolean u(String str, int i) {
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        int i2 = fxVarU.get(str, 0);
        boolean z = (i2 & 2) == 0 || (i2 & 1) != i;
        if (z) {
            fxVarU.put(str, i + 2);
        }
        return z;
    }

    public void u(final int i, bc bcVar, final boolean z) {
        final String strValueOf = String.valueOf(jp.t(bcVar));
        if (u(strValueOf, z ? 1 : 0)) {
            nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.8
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarFx = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(i).fx(strValueOf);
                    if (z) {
                        nrVarFx.u("reg_creative");
                    } else {
                        nrVarFx.u("no_reg_creative");
                    }
                    return nrVarFx;
                }
            }, z ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar) {
        if (nr(nrVar)) {
            return;
        }
        nrVar.u("load_icon_error");
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.9
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return nrVar;
            }
        }, "load_icon_error", true);
    }

    public void u(final boolean z, final String[] strArr) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.10
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append(",");
                            }
                        }
                        jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("download_permission").u(System.currentTimeMillis() / 1000).nr(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void u(final String str, final String str2, final String str3, final boolean z) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.13
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("get_bidding_token");
                boolean zNr = dw.nr().nr(str);
                JSONObject jSONObject = new JSONObject();
                if (zNr) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z) {
                    jSONObject.put("opt_sample", 1);
                }
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "get_bidding_token", z);
    }

    public void u(final long j, final com.bytedance.sdk.openadsdk.core.rh.pn pnVar) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.14
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                jSONObject.put("ext_plugin_code", bf.nr());
                com.bytedance.sdk.openadsdk.core.rh.pn pnVar2 = pnVar;
                if (pnVar2 != null) {
                    jSONObject.put("success", pnVar2.u() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.rh.x xVarNr = pnVar.nr();
                    if (xVarNr != null) {
                        jSONObject.put("msg", xVarNr.toString());
                        jSONObject.put("code", xVarNr.u());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pitaya_init").nr(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void u(final String str, final String str2, final boolean z, final long j, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.15
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", bf.nr());
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pitaya_run_task").nr(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void u(final int i, q qVar) {
        if (qVar == null) {
            return;
        }
        final JSONObject jSONObjectU = qVar.u(-1L);
        final long jNr = qVar.nr();
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.16
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("bid_token_time");
                try {
                    jSONObjectU.put("total", jNr);
                    jSONObjectU.put("opt_sample", 1);
                    jSONObjectU.put("slot_type", i);
                    nrVarU.nr(jSONObjectU.toString());
                } catch (Throwable unused) {
                }
                return nrVarU;
            }
        }, "get_bidding_token", true);
    }

    public void u(int i, long j, String str) {
        u(i, j, (Boolean) null, str);
    }

    public void u(final int i, final long j, final Boolean bool, final String str) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.17
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put(HiAnalyticsConstant.BI_KEY_COST_TIME, j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    nrVarU.nr(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return nrVarU;
            }
        }, "encrypt_track", true);
    }

    public void u(final int i) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.18
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("has_pre_req").nr(i);
            }
        }, "has_pre_req", true);
    }

    public void u(final int i, final String str, final String str2, final String str3, final String str4) {
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.19
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject.put("code", i);
                jSONObject.put("msg", str);
                jSONObject.put("material_keys", str4);
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("fetch_adm_status").nr(i).fx(str3).iz(str2).nr(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void u(final String str) {
        if (str == null) {
            return;
        }
        nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.21
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("error_ad_info").u(System.currentTimeMillis() / 1000).a(str);
            }
        }, "error_ad_info", true);
    }

    public void u(final String str, final JSONObject jSONObject, final JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.23
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str);
                JSONObject jSONObject3 = jSONObject2;
                if (jSONObject3 != null) {
                    nrVarU.nr(jSONObject3.toString());
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    String strOptString = jSONObject4.optString("rit");
                    String strOptString2 = jSONObject.optString("cid");
                    int iOptInt = jSONObject.optInt("adtype");
                    String strOptString3 = jSONObject.optString(ReportItem.RequestKeyRequestId);
                    String strOptString4 = jSONObject.optString("duration");
                    nrVarU.fx(strOptString);
                    nrVarU.u(iOptInt);
                    nrVarU.b(strOptString2);
                    nrVarU.iz(strOptString3);
                    nrVarU.pn(strOptString4);
                }
                return nrVarU;
            }
        }, str);
    }

    public void u(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.24
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    nrVarU.nr(jSONObject2.toString());
                }
                return nrVarU;
            }
        }, str);
    }

    public void u(bc bcVar, String str) {
        if (bcVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", str);
            jSONObject.putOpt(ReportItem.RequestKeyRequestId, bcVar.xx());
            jSONObject.putOpt("aid", bcVar.en());
            jSONObject.putOpt("cid", bcVar.lk());
        } catch (JSONException unused) {
        }
        u("showTime", jSONObject, (Throwable) null);
    }

    public void u(String str, Throwable th) {
        u(str, (JSONObject) null, th);
    }

    public void u(final String str, final JSONObject jSONObject, final Throwable th) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.25
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("exception").nr(jSONObject2.toString());
            }
        }, "exception");
    }

    public void u(final bc bcVar, final long j, final boolean z, final boolean z2) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.27
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportItem.RequestKeyRequestId, bcVar.xx());
                jSONObject.put("auth", z);
                jSONObject.put("duration", j);
                jSONObject.put("time_out", z2);
                v vVarEj = bcVar.ej();
                if (vVarEj != null) {
                    jSONObject.put("saas_info", vVarEj.u());
                }
                jSONObject.put("ext", bcVar.ap());
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("auth_time").nr(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void u(final String str, final String str2, final int i, final JSONObject jSONObject) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.28
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("event_type", str2);
                jSONObject2.putOpt("event", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt(LocationConst.HDYawConst.KEY_HD_YAW_STATE, Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("convert_event").nr(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void u(final bc bcVar, final int i, final int i2, final View view) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.29
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().fx(String.valueOf(jp.t(bcVar))).u(i).u("register_info");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i2);
                jSONObject.put("targetIsNull", view == null ? 1 : 0);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "register_info");
    }

    public void u(final bc bcVar, final Object obj) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.30
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("upie_img_play_success");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", obj);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "upie_img_play_success");
    }

    public void u(final bc bcVar, final int i, final String str) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.31
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("upie_img_play_fail");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                nrVarU.nr(i);
                nrVarU.x(str);
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "upie_img_play_fail");
    }

    public void u(final bc bcVar, final String str, final long j) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.34
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("uttie_played");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put("duration", j);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "uttie_played");
    }

    public void u(final bc bcVar, final String str, final JSONObject jSONObject) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.36
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str);
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx()).n(bcVar.ap());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    nrVarU.nr(jSONObject2.toString());
                }
                return nrVarU;
            }
        }, str);
    }

    public static void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        u().x(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.41
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                int i4 = i3 > 0 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i4));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject.putOpt("total_duration", Long.valueOf(j3));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i));
                jSONObject.putOpt("check_count", Integer.valueOf(i2));
                jSONObject.putOpt("success_count", Integer.valueOf(i3));
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(i).fx(nrVar.b()).nr((int) j).nr(jSONObject.toString());
            }
        });
    }

    public void u(final bc bcVar, final float f, final float f2, final float f3, final float f4, final View view) {
        nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.s.44
            /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                float fAbs;
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("video_size_gap");
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nrVarU.iz(bcVar2.xx());
                }
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                bc bcVar3 = bcVar;
                jSONObject.put("image_mode", bcVar3 != null ? bcVar3.ol() : 0);
                bc bcVar4 = bcVar;
                jSONObject.put("slot_type", bcVar4 != null ? jp.jk(bcVar4) : 0);
                jSONObject.put("resolution_w", f3);
                jSONObject.put("resolution_h", f4);
                jSONObject.put("container_w", f);
                jSONObject.put("container_h", f2);
                float f5 = f3;
                float fAbs2 = -1.0f;
                if (f5 != 0.0f) {
                    float f6 = f4;
                    if (f6 != 0.0f) {
                        float f7 = f;
                        if (f7 != 0.0f) {
                            float f8 = f2;
                            fAbs = f8 != 0.0f ? Math.abs((f7 / f8) - (f5 / f6)) : -1.0f;
                        }
                    }
                }
                jSONObject.put("size_gap_value", fAbs);
                float width = view != null ? r2.getWidth() : 0.0f;
                float height = view != null ? r6.getHeight() : 0.0f;
                jSONObject.put("dev_container_w", width);
                jSONObject.put("dev_container_h", height);
                float f9 = f3;
                if (f9 != 0.0f) {
                    float f10 = f4;
                    if (f10 != 0.0f && width != 0.0f && height != 0.0f) {
                        fAbs2 = Math.abs((width / height) - (f9 / f10));
                    }
                }
                jSONObject.put("dev_size_gap_value", fAbs2);
                jSONObject.put("gap_gaosi_fill", 0);
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "video_size_gap");
    }
}

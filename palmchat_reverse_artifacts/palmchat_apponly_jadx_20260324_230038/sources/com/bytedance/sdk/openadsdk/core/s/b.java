package com.bytedance.sdk.openadsdk.core.s;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.v;
import com.bytedance.sdk.openadsdk.core.rh.l;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.t;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dc;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static int u;

    public static void b(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    public static void fx(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void iz(bc bcVar, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm;
        if (d.x() && (nrVarTm = bcVar.tm()) != null) {
            String strMv = nrVarTm.mv();
            if (TextUtils.isEmpty(strMv)) {
                return;
            }
            jSONObject.putOpt("media_extra", strMv);
        }
    }

    public static void n(bc bcVar, String str, String str2, Map<String, Object> map) {
        jw jwVarKg = bcVar.kg();
        if (map == null) {
            map = new HashMap<>();
        }
        if (jwVarKg != null) {
            map.put("wc_type", Integer.valueOf(jwVarKg.pn()));
        }
        map.put("rom_new_version", gi.k());
        map.put("is_background", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.n.o().u()));
        map.put(WfConstant.EXTRA_KEY_INTERACTION_TYPE, Integer.valueOf(bcVar.qf()));
        u(bcVar, str, str2, map);
    }

    public static void nr(final bc bcVar, final String str, final Map<String, Object> map, final Double d) {
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.gi.nr();
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - jp.s(bcVar)).floatValue();
        final String strU = kj.u(str, t.nr(), jp.t(bcVar), com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
        bcVar.pm().fx();
        u++;
        u(bcVar, str, bq.b.V, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.37
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.a.u(str)).toString());
                jSONObject2.put("is_cache", bcVar.ah() ? 1 : 0);
                jSONObject2.put("cache_type", bcVar.db());
                jSONObject2.put("correct_action_code", bcVar.ps());
                jSONObject2.put("correct_result_code", bcVar.bo());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - bg.pn);
                jSONObject2.put("start_type", !bg.nr.get() ? 1 : 0);
                jSONObject2.put("show_count", b.u);
                String strIz = com.bytedance.sdk.openadsdk.core.n.o().iz();
                if (!TextUtils.isEmpty(strIz)) {
                    jSONObject2.put("can_use_sensor", strIz);
                }
                if (!com.bytedance.sdk.openadsdk.core.n.o().t()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!com.bytedance.sdk.openadsdk.core.n.o().n()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.n.o().bg());
                jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.bytedance.sdk.openadsdk.core.bf.u.u().iz());
                b.iz(bcVar, str, jSONObject2);
                String str2 = strU;
                if (str2 != null) {
                    y.u(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.bytedance.sdk.openadsdk.core.live.nr.u().fx());
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject2.put("shakeLiSize", dw.nr().jk() ? com.bytedance.sdk.component.utils.pn.u(dw.getContext()).u() : com.bytedance.sdk.component.utils.iz.u(dw.getContext()).u());
                b.u(jSONObject2);
                bcVar.pm().u(jSONObject2, true);
                l.u(bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.bytedance.sdk.openadsdk.core.k.fx.pn().u(bcVar, fFloatValue);
                String strIr = bcVar.ir();
                if (!TextUtils.isEmpty(strIr)) {
                    try {
                        double d2 = Double.parseDouble(strIr);
                        if (d2 <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        } else {
                            if (d.fx < 4400) {
                                d2 *= 100000.0d;
                            }
                            jSONObject.put("ttdsp_price", d2);
                        }
                    } catch (Throwable unused) {
                        jSONObject.put("ttdsp_price", 0);
                    }
                }
                u(bcVar, d, jSONObject);
            }

            public void u(bc bcVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapSj = bcVar2.sj();
                    if (mapSj == null || (obj = mapSj.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (bcVar2.jq() && (obj2 = mapSj.get(OapsKey.KEY_PRICE)) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String strFx = sx.fx();
        List<String> listAd = bcVar.ad();
        if (!TextUtils.isEmpty(strFx)) {
            HashMap map2 = new HashMap();
            map2.put("aid", bcVar.en());
            map2.put("cid", bcVar.lk());
            map2.put(ReportItem.RequestKeyRequestId, bcVar.xx());
            map2.put("customer_id", jp.mv(bcVar));
            com.bytedance.sdk.openadsdk.core.qq.nr.u(strFx, listAd, true, map2, u(bcVar, str, bq.b.V));
        } else if (listAd != null && listAd.size() != 0) {
            u(bcVar, listAd, str, "no did", bq.b.V);
        }
        if (u % 5 == 0 && com.bytedance.sdk.openadsdk.u.u.u.u() != null) {
            com.bytedance.sdk.openadsdk.u.u.u.u().nr("AdShow" + System.currentTimeMillis());
        }
        if (com.bytedance.sdk.openadsdk.core.live.nr.u().iz(bcVar)) {
            com.bytedance.sdk.openadsdk.core.video.fx.u.u("tobsdk_livesdk_live_show", bcVar, 0L);
        }
        jp.fx();
        com.bytedance.sdk.openadsdk.k.nr.fx();
        com.bytedance.sdk.openadsdk.core.live.nr.u().b();
        com.bytedance.sdk.openadsdk.core.n.o().b().b();
        kj.u(u, 1);
        com.bytedance.sdk.openadsdk.core.b.u().fx(bcVar.yf());
        com.bytedance.sdk.openadsdk.core.l.u.u(bcVar);
        com.bytedance.sdk.openadsdk.core.k.fx.pn().n();
    }

    public static void u(bc bcVar) {
    }

    public static void x(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    public static void b(bc bcVar, String str, final long j) {
        u(bcVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.21
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, new JSONObject().toString());
            }
        });
    }

    public static void fx(final bc bcVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.13
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void pn(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    public static void u(String str, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.iz.u.u uVar) {
        new u.C0284u().pn(str3).b(str4).u(str).nr(str2).u(uVar);
    }

    public static void b(bc bcVar, String str, final JSONObject jSONObject) {
        if (bcVar == null || jSONObject == null) {
            return;
        }
        u(bcVar, str, "splash_ad_showstat", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.35
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void fx(bc bcVar, String str, String str2) {
        u(bcVar, str, str2, (com.bytedance.sdk.openadsdk.iz.u.u) null);
    }

    public static void fx(bc bcVar, String str, String str2, JSONObject jSONObject) {
        if (bcVar == null) {
            return;
        }
        new u.C0284u().pn(bcVar.lk()).b(bcVar.ap()).u(str).nr(str2).u(jSONObject).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
    }

    public static void iz(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    public static void u(bc bcVar, String str, String str2, com.bytedance.sdk.openadsdk.iz.u.u uVar) {
        if (bcVar == null) {
            return;
        }
        new u.C0284u().pn(bcVar.lk()).b(bcVar.ap()).u(str).nr(str2).x(bcVar.xx()).u(uVar);
    }

    public static void fx(final bc bcVar, String str, final long j) {
        u(bcVar, str, "load", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.20
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put("duration", Math.min(j, 600000L));
            }
        });
    }

    public static void fx(bc bcVar, String str, final JSONObject jSONObject) {
        if (bcVar == null || jSONObject == null) {
            return;
        }
        u(bcVar, str, "cache_correct_details", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.30
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void fx(final bc bcVar, String str) {
        u(bcVar, str, "cache_ana_upload", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.36
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                bcVar.pm().u(jSONObject2, false);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void u(bc bcVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.iz.u.u uVar) {
        if (bcVar == null) {
            return;
        }
        new u.C0284u().pn(bcVar.lk()).b(bcVar.ap()).u(str).nr(str2).u(jSONObject).x(bcVar.xx()).u(uVar);
    }

    public static void u(final bc bcVar, String str, String str2, final JSONObject jSONObject) {
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.1
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject3, bcVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
            }
        });
    }

    public static void u(final bc bcVar, String str, String str2, final Map<String, Object> map) {
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.12
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void u(final bc bcVar, final String str, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.gi.x.u((Runnable) new com.bytedance.sdk.component.jk.a("repost_show_check") { // from class: com.bytedance.sdk.openadsdk.core.s.b.22
            @Override // java.lang.Runnable
            public void run() {
                if (bcVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - jp.s(bcVar)).floatValue();
                b.u(bcVar, str, "show_check", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.22.1
                    @Override // com.bytedance.sdk.openadsdk.iz.u.u
                    public void u(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.a.u(str)).toString());
                        jSONObject2.put("is_cache", bcVar.ah() ? 1 : 0);
                        jSONObject2.put("cache_type", bcVar.db());
                        jSONObject2.put("correct_action_code", bcVar.ps());
                        jSONObject2.put("correct_result_code", bcVar.bo());
                        Map map2 = map;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - bg.pn);
                        jSONObject2.put("start_type", !bg.nr.get() ? 1 : 0);
                        jSONObject2.put("show_count", b.u);
                        jSONObject2.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.n.o().iz());
                        jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.n.o().bg());
                        jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.bytedance.sdk.openadsdk.core.bf.u.u().iz());
                        AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                        b.iz(bcVar, str, jSONObject2);
                        com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                        jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                        float f = fFloatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                    }
                });
            }
        });
    }

    public static void u(final bc bcVar, final String str, final Map<String, Object> map, final Double d) {
        com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("report_show") { // from class: com.bytedance.sdk.openadsdk.core.s.b.33
            @Override // java.lang.Runnable
            public void run() {
                b.nr(bcVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    private static void u(bc bcVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        u(str, bcVar.lk(), bcVar.ap(), jSONObject);
    }

    public static void nr(bc bcVar, String str, String str2, Map<String, Object> map) {
        u(bcVar, str, str2, map);
    }

    public static void nr(bc bcVar, String str) {
        if (bcVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.fx.fx fxVar = new com.bytedance.sdk.openadsdk.core.dislike.fx.fx();
            fxVar.u("0:00");
            fxVar.nr(str);
            com.bytedance.sdk.openadsdk.core.k.fx.pn().u(dc.F, bcVar.lk(), bcVar.xx(), bcVar.tq(), (String) null);
            u(bcVar.vz(), fxVar);
        }
    }

    public static void nr(bc bcVar, String str, final JSONObject jSONObject) {
        u(bcVar, jp.nr(bcVar), str, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.7
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3);
                }
            }
        });
    }

    public static void nr(bc bcVar, String str, String str2, final long j) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.10
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("timestamp", j);
            }
        });
    }

    public static void u(final bc bcVar, final String str, final long j) {
        u(bcVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.38
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.a.u(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void nr(final bc bcVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (bcVar == null || jSONObject == null) {
            return;
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.11
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void u(final String str, bc bcVar, String str2, final int i, final Map<String, Long> map) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.39
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(az.at, Integer.valueOf(i));
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        jSONObject2.putOpt((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                jSONObject.put("duration", str);
            }
        });
    }

    public static void nr(bc bcVar, String str, String str2) {
        u(bcVar, str, str2, (com.bytedance.sdk.openadsdk.iz.u.u) null);
    }

    public static void u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("tag");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String strOptString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        u(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void nr(bc bcVar, String str, String str2, JSONObject jSONObject) {
        u(bcVar, str, str2, jSONObject);
    }

    public static void nr(bc bcVar, String str, long j) {
        String str2;
        if (dw.nr().ju()) {
            final long jCurrentTimeMillis = System.currentTimeMillis() - j;
            str.hashCode();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.14
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", jCurrentTimeMillis);
                }
            });
        }
    }

    public static void u(String str, String str2, String str3, final JSONObject jSONObject) {
        u(str, "show_url", str2, str3, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.40
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                }
            }
        });
    }

    public static void nr(final bc bcVar, String str, String str2, final String str3) {
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.17
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(final bc bcVar, final String str) {
        String strNr;
        if (bcVar == null || str == null || (strNr = jp.nr(bcVar)) == null) {
            return;
        }
        u(bcVar, strNr, "page_on_create", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.41
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(f.v, str);
                y.u(jSONObject2, "");
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void nr(final bc bcVar) {
        u(bcVar, com.huawei.openalliance.ad.constant.x.df, "open_url_h5", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.19
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void nr(final bc bcVar, String str, final int i) {
        u(bcVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.29
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i);
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void u(String str, final bc bcVar, final com.bytedance.sdk.openadsdk.core.kj.a aVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2, final boolean z3) {
        if (bcVar == null || z2) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - jp.s(bcVar)).floatValue();
        u(bcVar, str2, str, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.2
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.core.kj.a aVar2 = aVar;
                if (aVar2 != null) {
                    JSONObject jSONObjectU = aVar2.u();
                    jSONObjectU.put("device", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.a.u(str2)).toString());
                    jSONObjectU.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectU.put("user_behavior_type", i2);
                    }
                    y.u(jSONObjectU, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectU.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    b.iz(bcVar, str2, jSONObjectU);
                    jSONObjectU.putOpt("obm_convert", com.bytedance.sdk.openadsdk.core.kj.bq.fx(bcVar));
                    jSONObjectU.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.n.o().iz());
                    if (!com.bytedance.sdk.openadsdk.core.n.o().t()) {
                        jSONObjectU.put("mcod", "0");
                    }
                    if (!com.bytedance.sdk.openadsdk.core.n.o().n()) {
                        jSONObjectU.put("od", "0");
                    }
                    jSONObjectU.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.n.o().bg());
                    jSONObjectU.put("live_sdk_config", com.bytedance.sdk.openadsdk.core.live.nr.u().n());
                    jSONObjectU.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.bytedance.sdk.openadsdk.core.bf.u.u().iz());
                    jSONObjectU.put("is_cache", bcVar.ah() ? 1 : 0);
                    jSONObjectU.put("cache_type", bcVar.db());
                    jSONObjectU.put("correct_action_code", bcVar.ps());
                    jSONObjectU.put("correct_result_code", bcVar.bo());
                    jSONObjectU.put(az.at, z3 ? 1 : 0);
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObjectU, bcVar);
                    b.u(jSONObjectU);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectU.toString());
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
            }
        });
        String strFx = sx.fx();
        List<String> listMx = bcVar.mx();
        if (!TextUtils.isEmpty(strFx) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", bcVar.en());
            map2.put("cid", bcVar.lk());
            map2.put(ReportItem.RequestKeyRequestId, bcVar.xx());
            map2.put("customer_id", jp.mv(bcVar));
            com.bytedance.sdk.openadsdk.core.qq.nr.u(strFx, listMx, true, map2, u(bcVar, str2, "click"));
        } else if (listMx != null && listMx.size() != 0 && "click".equals(str)) {
            u(bcVar, listMx, str2, "no did", "click");
        }
        if (str == "click") {
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
                com.bytedance.sdk.openadsdk.core.video.fx.u.u("tobsdk_livesdk_rec_live_play", bcVar, 0L);
            }
            com.bytedance.sdk.openadsdk.core.live.nr.u().b(bcVar);
        }
        kj.u(1, 2);
    }

    public static void nr(long j, final bc bcVar) {
        if (bcVar != null && bc.nr(bcVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "play_duration_sum", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.31
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static JSONObject u(bc bcVar, String str, String str2) {
        return u(bcVar.ap(), bcVar.lk(), bcVar.xx(), str, str2);
    }

    public static JSONObject u(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put(ReportItem.RequestKeyRequestId, str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void u(final bc bcVar, String str, String str2, final long j) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.3
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j);
                jSONObject2.put("rom_new_version", gi.k());
                jSONObject2.put("is_background", com.bytedance.sdk.openadsdk.core.n.o().u());
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, com.bytedance.sdk.openadsdk.my.fx.nr.iz izVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(izVar);
        dw.u().u(nrVar, arrayList);
    }

    public static void u(Context context, bc bcVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || bcVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt(ActionUtils.PAYMENT_AMOUNT);
        if (objOpt == null) {
            objOpt = bcVar.lk();
        }
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cw);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "app_union";
        }
        Object objOpt2 = jSONObject.opt("log_extra");
        if (objOpt2 == null) {
            objOpt2 = bcVar.ap();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(o.fx(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.2.3.2");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            k.u(e.getMessage());
        }
        new u.C0284u().pn(objOpt == null ? "" : objOpt.toString()).fx(strOptString).b(objOpt2 != null ? objOpt2.toString() : "").u(str).u(jSONObject).nr(str2).u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.4
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void u(final long j, final bc bcVar) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, dc.F, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.5
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(final bc bcVar, String str, final JSONObject jSONObject) {
        u(bcVar, jp.nr(bcVar), str, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.6
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject3, bcVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            }
        });
    }

    public static void u(final bc bcVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.8
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void u(final bc bcVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (bcVar == null || jSONObject == null) {
            return;
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.9
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void u(String str, String str2, String str3, String str4) {
        new u.C0284u().u(str3).nr(str4).pn(str).b(str2).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
    }

    public static void u(bc bcVar, String str, String str2, Throwable th) {
        jw jwVarKg = bcVar.kg();
        JSONObject jSONObject = null;
        if (jwVarKg != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", jwVarKg.pn());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        u(bcVar, str, str2, jSONObject);
    }

    public static void u(bc bcVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, bcVar);
            }
        } catch (Throwable unused) {
        }
        u(bcVar, str, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.15
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            }
        });
    }

    public static void u(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - jp.iz(jSONObject.optString("log_extra"))).floatValue();
        new u.C0284u().u(str2).nr(str3).fx(str).pn(String.valueOf(j)).iz(String.valueOf(j2)).u(jSONObject).u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.16
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.bytedance.sdk.openadsdk.core.fx.u.u(dw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.a.u(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f = fFloatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
            }
        });
    }

    public static void u(final long j, String str, String str2) {
        bc bcVarU;
        try {
            bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(str2));
        } catch (Throwable unused) {
            bcVarU = null;
        }
        if (bcVarU == null) {
            return;
        }
        u(bcVarU, str, "open_appback", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.18
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
            }
        });
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        fxVarU.put("save_jump_success_time", 0L);
        fxVarU.put("save_jump_success_ad_tag", "");
    }

    public static void u(bc bcVar, String str, final int i, final String str2) {
        u(bcVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.23
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(bc bcVar, String str, final long j, final String str2) {
        u(bcVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.24
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(bc bcVar, String str, final int i, final String str2, final String str3) {
        u(bcVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.25
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(bc bcVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        u(bcVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.26
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                jSONObject2.put("duration", j);
            }
        });
    }

    public static void u(final bc bcVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (bcVar != null && bcVar.ud() == 1) {
            u(bcVar, str, "open_live", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.27
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int iGq = bcVar.gq();
                    jSONObject2.put("live_interaction_type", iGq);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", su.nr(bcVar));
                    jSONObject2.put("is_inner", z);
                    v vVarEj = bcVar.ej();
                    if (vVarEj != null) {
                        jSONObject2.putOpt("saas_info", vVarEj.u());
                    }
                    my myVarKv = bcVar.kv();
                    if (myVarKv != null) {
                        String strNr = myVarKv.nr();
                        if (strNr.length() > 500) {
                            strNr = strNr.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", strNr);
                        if (!strNr.startsWith("snssdk1128") && !strNr.startsWith("snssdk2329") && iGq == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static void u(final bc bcVar, String str, final int i) {
        u(bcVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.28
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i);
                    com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, bcVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void u(final int i, String str, final bc bcVar) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.32
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                v vVarEj = bcVar.ej();
                if (vVarEj != null) {
                    jSONObject2.put("saas_auth_type", vVarEj.nr());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(String str, bc bcVar) {
        if (bcVar == null) {
            return;
        }
        u(bcVar, str, "ec_mall_task", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.b.34
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isCanUseLocation", com.bytedance.sdk.openadsdk.core.n.o().sx().u());
            jSONObject2.put("isCanUsePhoneState", com.bytedance.sdk.openadsdk.core.n.o().sx().fx());
            jSONObject2.put("isCanUseWifiState", com.bytedance.sdk.openadsdk.core.n.o().sx().b());
            jSONObject2.put("isCanUseWriteExternal", com.bytedance.sdk.openadsdk.core.n.o().sx().pn());
            jSONObject2.put("alist", com.bytedance.sdk.openadsdk.core.n.o().sx().nr());
            jSONObject2.put("isCanUseAndroidId", com.bytedance.sdk.openadsdk.core.n.o().sx().iz());
            jSONObject2.put("isCanUsePermissionRecordAudio", com.bytedance.sdk.openadsdk.core.n.o().sx().x());
            if (com.bytedance.sdk.openadsdk.core.n.o().sx().k() != null && !com.bytedance.sdk.openadsdk.core.n.o().sx().k().isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : com.bytedance.sdk.openadsdk.core.n.o().sx().k().entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}

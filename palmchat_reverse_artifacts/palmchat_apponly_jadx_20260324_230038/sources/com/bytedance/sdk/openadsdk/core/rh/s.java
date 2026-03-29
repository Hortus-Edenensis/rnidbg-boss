package com.bytedance.sdk.openadsdk.core.rh;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private JSONObject b;
    private JSONObject fx;
    private static final ConcurrentHashMap<String, JSONObject> u = new ConcurrentHashMap<>();
    private static AtomicInteger nr = new AtomicInteger();

    private JSONObject nr(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            bc bcVarU = com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVar);
            if (bcVarU != null) {
                String strU = jp.u(bcVarU, "");
                int i = !TextUtils.isEmpty(strU) ? Integer.parseInt(strU) : 0;
                int iJk = jp.jk(bcVarU);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.iz.nr.nr.u());
                JSONObject jSONObjectU = u();
                jSONObject.put("device", jSONObjectU);
                JSONObject jSONObjectU2 = u(izVar, i, iJk);
                jSONObject.put("current_video", jSONObjectU2);
                jSONObject.put("predict_use", u(String.valueOf(i)));
                jSONObject.put("csj_plugin", nr());
                jSONObject.put("package", nr("video_cache"));
                jSONObject.put("hour", jSONObjectU.optInt("hour"));
                jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, izVar.l());
                jSONObject.put("rit", i);
                jSONObject.put("preload_size", izVar.iz());
                jSONObject.put(bt.Q, jSONObjectU.optString(bt.Q));
                jSONObject.put("sdk_fg_time", jSONObjectU.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", jSONObjectU2.optInt("ad_slot_type"));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static String u(int i, String str) {
        int iIncrementAndGet = nr.incrementAndGet();
        return i + "-" + sx.fx() + "-" + iIncrementAndGet + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u.get(str);
    }

    public static void u(int i, long j, bc bcVar, com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm;
        if (bcVar == null || izVar == null || (nrVarTm = bcVar.tm()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectU = u(nrVarTm.b());
            if (jSONObjectU != null) {
                String strO = izVar.o();
                String strOptString = jSONObjectU.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(strO)) {
                    jSONObjectU.put("play_type", i);
                    jSONObjectU.put(EventParams.KEY_CACHE_SIZE, j);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void u(long j, bc bcVar, com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm;
        if (bcVar == null || izVar == null || (nrVarTm = bcVar.tm()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectU = u(nrVarTm.b());
            if (jSONObjectU != null) {
                String strOptString = jSONObjectU.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(izVar.o())) {
                    jSONObjectU.put("play_duration", j);
                    jSONObjectU.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bt.Q, o.x(dw.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.y.u.nr;
            if (jCurrentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", jCurrentTimeMillis);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject nr(final String str) {
        fx fxVar = (fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya");
        if (fxVar != null) {
            fxVar.queryPackage(str, new n() { // from class: com.bytedance.sdk.openadsdk.core.rh.s.1
                @Override // com.bytedance.sdk.openadsdk.core.rh.n
                public PluginValueSet nr(int i, SparseArray<Object> sparseArray) {
                    if (sparseArray == null) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.my.u uVar = new com.bytedance.sdk.openadsdk.my.u(sparseArray);
                    PluginValueSet pluginValueSetB = uVar.b();
                    boolean zU = uVar.u();
                    if (pluginValueSetB != null) {
                        if (TextUtils.equals(str, pluginValueSetB.stringValue(5))) {
                            if (zU) {
                                s.this.fx = (JSONObject) pluginValueSetB.objectValue(3, JSONObject.class);
                                JSONObject unused = s.this.fx;
                            } else {
                                s.this.b = (JSONObject) pluginValueSetB.objectValue(4, JSONObject.class);
                            }
                        }
                    }
                    return super.nr(i, sparseArray);
                }
            });
        } else {
            this.fx = new JSONObject();
        }
        return this.fx;
    }

    private JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", d.fx);
            jSONObject.put("core_plugin_code", 7232);
            jSONObject.put("ext_api_code", d.pn);
            jSONObject.put("ext_plugin_code", bf.nr());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, izVar.l());
            jSONObject.put("preload_size", izVar.iz());
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, izVar.kj().iz());
            jSONObject.put("ad_slot_type", i2);
            jSONObject.put("rit", i);
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_URL, izVar.my());
            jSONObject.put("preload_all", izVar.mv());
            jSONObject.put("trace_id", u(i, izVar.o()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, JSONObject jSONObject, int i, int i2) {
        int iOptInt;
        if (izVar == null || jSONObject == null || (iOptInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        u.put(String.valueOf(iOptInt), jSONObject);
    }

    public JSONObject u(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        return nr(izVar);
    }
}

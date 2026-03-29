package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.p;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static volatile boolean u = false;

    public static void b(p pVar, long j) {
        if (pVar != null) {
            pVar.my(System.currentTimeMillis() - j);
        }
    }

    public static void fx(p pVar, long j) {
        if (pVar == null) {
            return;
        }
        pVar.t(j);
    }

    public static void nr(p pVar, long j) {
        if (pVar == null) {
            return;
        }
        pVar.fx(j);
    }

    public static void u(Context context, p pVar, bc bcVar, boolean z, long j) {
        if (context == null || bcVar == null || pVar == null || !dw.nr().ju()) {
            return;
        }
        boolean z2 = pVar.b() == 1;
        boolean z3 = pVar.n() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", pVar.u());
            jSONObject.put("server_load_type", pVar.nr());
            jSONObject.put("tmax_type", pVar.wq());
            if (z) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", pVar.fx());
            jSONObject.put("splash_creative_type", pVar.b());
            if (pVar.q() > 0) {
                if (pVar.q() == 22) {
                    jSONObject.put("check_cloud_error_code", pVar.d());
                }
                jSONObject.put("splash_get_cache_error_code", pVar.q());
            }
            if (z2) {
                if (z3) {
                    jSONObject.put("cache_image_duration", pVar.x());
                } else {
                    jSONObject.put("download_image_duration", pVar.iz());
                    jSONObject.put("download_client_start_time", pVar.my());
                    jSONObject.put("download_net_time", pVar.o());
                    jSONObject.put("download_client_end_time", pVar.sx());
                    jSONObject.put("img_conttype", pVar.gi());
                    jSONObject.put("img_net_bframe_time", pVar.h());
                    jSONObject.put("img_net_aframe_time", pVar.rh());
                }
                if (!z) {
                    jSONObject.put("client_start_time", pVar.l());
                    jSONObject.put("network_time", pVar.mv());
                    jSONObject.put("sever_time", pVar.s());
                    jSONObject.put("client_end_time", pVar.k());
                }
                jSONObject.put("load_duration", pVar.pn());
                jSONObject.put("image_resolution", pVar.jk());
                jSONObject.put("image_cachetype", pVar.n());
                jSONObject.put("image_size", pVar.a());
            }
            if (pVar.qq() > 0) {
                jSONObject.put("real_user_duration", j - pVar.qq());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", pVar.kj());
            jSONObject.put("on_call_back_time", pVar.z());
            jSONObject.put("load_suc_time", pVar.ja());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.b.u.b());
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_ad_loadtime", j - pVar.bq(), jSONObject);
    }

    public static void nr(bc bcVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b bVar) {
        if (bcVar == null || bVar == null || !dw.nr().ju()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", bVar.b());
            jSONObject.put("load_resource_duration", bVar.pn());
            jSONObject.put("render_duration", bVar.iz());
            jSONObject.put("ren_seq", bVar.nr());
            jSONObject.put("real_ren_seq", bVar.fx());
            jSONObject.put("final_t", bVar.n() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", bVar.a());
            jSONObject.put("meta_load_Optimization", bcVar.df());
            jSONObject.put("serial_render", bVar.jk());
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.fx(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_total_duration", bVar.x(), jSONObject);
    }

    public static void u(p pVar) {
        if (pVar == null) {
            return;
        }
        pVar.u(System.currentTimeMillis() - pVar.bq());
    }

    public static void u(p pVar, p pVar2) {
        if (pVar == null || pVar2 == null) {
            return;
        }
        pVar.l(System.currentTimeMillis());
        pVar2.l(System.currentTimeMillis());
        if (bg.fx.get()) {
            pVar.fx(0);
            pVar2.fx(0);
            bg.fx.set(false);
        } else {
            pVar.fx(1);
            pVar2.fx(1);
        }
    }

    public static void u(p pVar, long j) {
        if (pVar == null) {
            return;
        }
        pVar.nr(j);
    }

    public static void u(p pVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
        if (pVar == null || nVar == null) {
            return;
        }
        if (nVar.pn()) {
            pVar.b(2);
        } else {
            pVar.b(1);
        }
    }

    public static void u(p pVar, boolean z) {
        if (pVar == null) {
            return;
        }
        if (z) {
            pVar.pn(1);
        } else {
            pVar.pn(2);
        }
    }

    public static void u(p pVar, com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar, Map<String, String> map) {
        if (nrVar == null || pVar == null) {
            return;
        }
        int iNr = nrVar.nr();
        if (pVar.a() == 0.0d) {
            pVar.u(iNr / 1024.0f);
        }
        Bitmap bitmapU = nrVar.u();
        if (bitmapU != null && TextUtils.isEmpty(pVar.jk())) {
            pVar.u(bitmapU.getWidth() + "X" + bitmapU.getHeight());
        }
        if (map == null || map.size() <= 0 || pVar.t() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        pVar.u(jSONObject);
    }

    public static void u(p pVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
        if (pVar == null || izVar == null) {
            return;
        }
        long jIz = izVar.iz();
        long jN = izVar.n();
        long jX = izVar.x();
        long jA = izVar.a();
        pVar.b(jIz);
        pVar.pn(jX);
        pVar.iz(jN);
        pVar.x(jA);
    }

    public static void u(bc bcVar, p pVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
        if (bcVar == null || pVar == null || nVar == null || nVar.pn() || pVar.n() == 1 || !dw.nr().ju()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", pVar.a());
            jSONObject.put("image_resolution", pVar.jk());
            jSONObject.put("download_client_start_time", pVar.my());
            jSONObject.put("download_net_time", pVar.o());
            jSONObject.put("download_client_end_time", pVar.sx());
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "download_image_duration", System.currentTimeMillis() - pVar.bg(), jSONObject);
    }

    public static void u(p pVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, long j) {
        if (pVar == null || nVar == null) {
            return;
        }
        long jX = nVar.x();
        pVar.jk(j - jX);
        pVar.bq(nVar.n() - jX);
    }

    public static void u(boolean z, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
        if (nrVar == null || xVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = u(nrVar, z ? 4 : 3, bcVar);
        if (nrVarU == null) {
            return;
        }
        s.u().fx(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.iz.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                int iX;
                int iB;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar2 = xVar;
                if (xVar2 != null) {
                    iX = xVar2.x();
                    iB = xVar.b();
                } else {
                    iX = 1;
                    iB = -1;
                }
                try {
                    jSONObject.put("if_have_cache", iX);
                    jSONObject.put("if_have_rt_ads", iB);
                } catch (Throwable unused) {
                }
                return nrVarU.nr(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.qq.u.nr u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i, bc bcVar) {
        String strLk;
        String strN;
        String strAp;
        if (bcVar != null) {
            strLk = bcVar.lk();
            strAp = bcVar.ap();
            strN = jp.k(bcVar);
        } else {
            strLk = null;
            strN = null;
            strAp = null;
        }
        if (TextUtils.isEmpty(strN)) {
            strN = jp.n();
        }
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarFx = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().iz(strN).u(i).fx(nrVar.b());
        if (strLk != null) {
            nrVarFx.b(strLk);
        }
        if (strAp != null) {
            nrVarFx.n(strAp);
        }
        return nrVarFx;
    }

    public static void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final long j) {
        if (nrVar == null) {
            return;
        }
        s.u().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.iz.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(3).fx(nrVar.b()).iz(jp.n()).nr(jSONObject.toString());
            }
        });
    }

    public static void u(p pVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, long j, bc bcVar) {
        if (nVar == null || pVar == null || bcVar == null) {
            return;
        }
        if (!nVar.pn()) {
            x.u(j, false, true, bcVar, 0L, "loadSuccess");
            if (!nVar.iz()) {
                u(pVar, SystemClock.elapsedRealtime() - j);
                com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, SystemClock.elapsedRealtime() - j);
            } else {
                nr(pVar, SystemClock.elapsedRealtime() - j);
            }
        }
        u(pVar, nVar.iz());
        u(pVar, nVar.b(), nVar.a());
        u(pVar, nVar, System.currentTimeMillis());
        u(pVar, nVar.mv());
    }

    public static void u(p pVar, String str) {
        if (pVar == null) {
            return;
        }
        pVar.nr(str);
    }

    public static void u(boolean z, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final boolean z2, final boolean z3) {
        if (bcVar == null || nrVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = u(nrVar, z ? 4 : 3, bcVar);
        if (nrVarU == null) {
            return;
        }
        s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.iz.3
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z3) {
                        jSONObject.put("image_CacheType", z2 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return nrVarU.nr(jSONObject.toString());
            }
        });
    }

    public static void u(boolean z, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (bcVar == null || nrVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = u(nrVar, z ? 4 : 3, bcVar);
        if (nrVarU == null) {
            return;
        }
        s.u().b(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.iz.4
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return nrVarU;
            }
        });
    }

    public static void u(bc bcVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b bVar) {
        if (bVar == null || bcVar == null || !dw.nr().ju()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", bVar.u());
            jSONObject.put("render_sequence", bVar.nr());
            jSONObject.put("real_render_sequence", bVar.fx());
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_render_duration", bVar.iz(), jSONObject);
    }

    public static void u(bc bcVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b bVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar) {
        if (bcVar == null || aVar == null) {
            return;
        }
        if (tk.u(bcVar) == 1) {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "自渲染 ");
            bVar.fx(99);
        } else if (!aVar.nr()) {
            int iNr = tk.nr(bcVar);
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "模版渲染 ".concat(String.valueOf(iNr)));
            bVar.fx(iNr);
        } else {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "模版兜底 ");
            bVar.fx(99);
        }
    }

    public static void u(p pVar, p pVar2, oa oaVar, int i, int i2) {
        if (pVar == null || pVar2 == null) {
            return;
        }
        pVar.u(i);
        pVar.nr(i2);
        pVar.k(oaVar.n);
        pVar2.u(i);
        pVar2.nr(i2);
        pVar2.k(oaVar.n);
    }

    public static void u(p pVar, int i) {
        if (pVar == null || pVar.wq() >= i) {
            return;
        }
        pVar.x(i);
    }

    public static void u(int i, bc bcVar, String str, int i2) {
        if (i == 2) {
            if (u) {
                return;
            } else {
                u = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.bytedance.sdk.openadsdk.core.s.b.b(bcVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}

package com.bytedance.sdk.openadsdk.core.nativeexpress.nr;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.openalliance.ad.constant.az;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static String b(bc bcVar) {
        if (tk.iz(bcVar) == null) {
            return null;
        }
        return tk.iz(bcVar).nr();
    }

    public static boolean fx(bc bcVar) {
        return bcVar != null && bq.l(bcVar) == 2;
    }

    private static JSONObject iz(bc bcVar) {
        JSONObject jSONObject = new JSONObject();
        if (bcVar != null && com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            try {
                jSONObject.put("live_show_time", m.nr(bcVar));
                jSONObject.put("live_author_nickname", m.fx(bcVar));
                if (m.b(bcVar) > 0) {
                    jSONObject.put("live_author_follower_count", m.b(bcVar));
                }
                if (m.pn(bcVar) > 0) {
                    jSONObject.put("live_watch_count", m.pn(bcVar));
                }
                jSONObject.put("live_description", m.iz(bcVar));
                jSONObject.put("live_feed_url", m.x(bcVar));
                jSONObject.put("live_cover_image_url", m.n(bcVar));
                jSONObject.put("live_avatar_url", m.a(bcVar));
                jSONObject.put("live_cover_image_width", m.l(bcVar));
                jSONObject.put("live_cover_image_height", m.mv(bcVar));
                jSONObject.put("live_avatar_width", m.jk(bcVar));
                jSONObject.put("live_avatar_height", m.t(bcVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject nr(bc bcVar) {
        int[] iArrPn;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", bcVar.yb());
            if (bcVar.dd() != null) {
                jSONObject.put("icon", bcVar.dd().u());
            }
            JSONArray jSONArray = new JSONArray();
            if (bcVar.zu() != null) {
                for (int i = 0; i < bcVar.zu().size(); i++) {
                    rh rhVar = bcVar.zu().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", rhVar.fx());
                    jSONObject2.put("width", rhVar.nr());
                    jSONObject2.put("url", rhVar.u());
                    jSONObject2.put("image_key", rhVar.x());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", bcVar.ol());
            jSONObject.put(WfConstant.EXTRA_KEY_INTERACTION_TYPE, bcVar.qf());
            jSONObject.put("is_compliance_template", fx(bcVar));
            jSONObject.put("title", bcVar.wf());
            jSONObject.put("description", bcVar.ym());
            jSONObject.put(az.at, bcVar.j());
            if (bcVar.pu() != null) {
                jSONObject.put("comment_num", bcVar.pu().iz());
                jSONObject.put("score", bcVar.pu().pn());
                jSONObject.put("app_size", bcVar.pu().x());
                jSONObject.put("app", bcVar.pu().n());
            }
            if (zx.k(bcVar) != null) {
                JSONObject jSONObjectBg = zx.s(bcVar).bg();
                if (bcVar.de() > 0 && zx.x(bcVar) > bcVar.de()) {
                    jSONObjectBg.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, bcVar.de());
                }
                if (com.bytedance.sdk.openadsdk.pn.u.u(bcVar) && (iArrPn = zx.pn(bcVar)) != null && iArrPn.length >= 2 && !com.bytedance.sdk.openadsdk.pn.u.x(bcVar)) {
                    jSONObjectBg.put("cover_width", iArrPn[0]);
                    jSONObjectBg.put("cover_height", iArrPn[1]);
                }
                zx.x(bcVar);
                jSONObject.put("video", jSONObjectBg);
            }
            if (yd.o(bcVar)) {
                jSONObject.put("reward_full_play_time", yd.k(bcVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", yd.gi(bcVar));
            if (tk.iz(bcVar) != null) {
                jSONObject.put("dynamic_creative", tk.iz(bcVar).x());
            }
            jSONObject.put("live_ad", iz(bcVar));
            u(bcVar, jSONObject);
            if (com.bytedance.sdk.openadsdk.core.live.nr.u().nr(bcVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", bcVar.uc());
            jSONObject.put("can_show_interactive", bcVar.of());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> pn(bc bcVar) {
        HashMap map = null;
        if (bcVar == null) {
            return null;
        }
        List<rh> listZu = bcVar.zu();
        if (listZu != null && listZu.size() > 0) {
            map = new HashMap();
            for (rh rhVar : listZu) {
                if (rhVar != null) {
                    map.put(rhVar.u(), rhVar.x());
                }
            }
        }
        return map;
    }

    public static JSONObject u(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = dw.getContext();
            jSONObject.put("width", y.b(context, width) * 1.0f);
            jSONObject.put("height", y.b(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(bc bcVar) {
        tm tmVarX = tk.x(bcVar);
        if (tmVarX == null) {
            return null;
        }
        String strB = tmVarX.b();
        try {
            if (!TextUtils.isEmpty(strB)) {
                return new JSONObject(strB);
            }
            String strU = com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.u().u("ad", tmVarX.u(), tmVarX.nr());
            if (!TextUtils.isEmpty(strU)) {
                return new JSONObject(strU);
            }
            k.nr("TemplateUtils", "template is null");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(bc bcVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str) {
        JSONObject jSONObjectEt = bcVar.et();
        try {
            jSONObjectEt.put("xSetting", ja.u(bcVar, (AtomicBoolean) null));
            jSONObjectEt.put("xAdInfo", u(bcVar, str));
            JSONObject jSONObject3 = new JSONObject();
            ja.u(jSONObject3, jp.jk(bcVar));
            jSONObject3.put("platform", "android");
            jSONObjectEt.put("xAppInfo", jSONObject3);
            jSONObjectEt.put("xCreative", nr(bcVar));
            if (jSONObject2 != null) {
                jSONObjectEt.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                float fOptDouble = (float) jSONObject.optDouble("width");
                float fOptDouble2 = (float) jSONObject.optDouble("height");
                if (!Float.isNaN(fOptDouble) && !Float.isNaN(fOptDouble2)) {
                    if (dw.nr().uc()) {
                        float f = dw.getContext().getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        jSONObject.put("width", y.nr(f2, y.u(f, fOptDouble)));
                        jSONObject.put("height", y.nr(f2, y.u(f, fOptDouble2)));
                    } else {
                        jSONObject.put("width", fOptDouble);
                        jSONObject.put("height", fOptDouble2);
                    }
                } else {
                    jSONObject.put("width", 0.0d);
                    jSONObject.put("height", 0.0d);
                }
                jSONObjectEt.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = dw.getContext();
            jSONObject5.put("width", y.b(context, y.b(context)));
            jSONObject5.put("height", y.b(context, y.pn(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            jSONObjectEt.put("xEnvInfo", jSONObject4);
            jSONObjectEt.put("gesture_through_enable", z && dw.nr().uk());
        } catch (Exception unused) {
        }
        return jSONObjectEt;
    }

    public static String nr(bc bcVar, String str) {
        List<rh> listZu;
        if (bcVar != null && (listZu = bcVar.zu()) != null && listZu.size() > 0) {
            for (rh rhVar : listZu) {
                if (rhVar != null && TextUtils.equals(str, rhVar.u())) {
                    return rhVar.x();
                }
            }
        }
        return null;
    }

    public static JSONObject u(bc bcVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strLk = bcVar.lk();
            if (!TextUtils.isEmpty(strLk)) {
                jSONObject.put("cid", strLk);
            }
            String strAp = bcVar.ap();
            if (!TextUtils.isEmpty(strAp)) {
                jSONObject.put("log_extra", strAp);
            }
            String strSx = jp.sx(bcVar);
            if (!TextUtils.isEmpty(strSx)) {
                jSONObject.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, strSx);
            }
            jSONObject.put("isDirectDownload", bcVar.bg());
            jSONObject.put("dynamic_configs", bcVar.qp());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (bg.t(bcVar)) {
                jSONObject.put("voice_btn_position", bg.k(bcVar));
            }
            jSONObject.put("if_show_win", bcVar.ky());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject u(float f, float f2, boolean z, bc bcVar) {
        String strPn;
        String strIz;
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (dw.nr().uc()) {
                float f3 = dw.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", y.nr(f4, y.u(f3, f)));
                jSONObject2.put("height", y.nr(f4, y.u(f3, f2)));
            } else {
                jSONObject2.put("width", f);
                jSONObject2.put("height", f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put(ClickAreaSource.CREATIVE, nr(bcVar));
            if (tk.iz(bcVar) != null) {
                strPn = tk.iz(bcVar).pn();
                strIz = tk.iz(bcVar).iz();
            } else {
                strPn = null;
                strIz = null;
            }
            if (TextUtils.isEmpty(strPn)) {
                strPn = (tk.iz(bcVar) == null || (nrVarU = com.bytedance.sdk.component.adexpress.u.nr.nr.u(tk.iz(bcVar).nr())) == null) ? null : nrVarU.pn();
            }
            jSONObject.put("template_Plugin", strPn);
            jSONObject.put("diff_template_Plugin", strIz);
            jSONObject.put("dynamic_configs", bcVar.qp());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("keys");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void u(bc bcVar, JSONObject jSONObject) {
        if (jp.jk(bcVar) == 7 && su.u(bcVar)) {
            bcVar.qj().u(jSONObject);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class zx {
    private com.bykv.vk.openvk.component.video.api.fx.u fx;
    private com.bykv.vk.openvk.component.video.api.fx.b nr;
    private com.bykv.vk.openvk.component.video.api.fx.b u;

    public zx() {
    }

    public static String a(bc bcVar) {
        com.bykv.vk.openvk.component.video.api.fx.b bVar;
        zx zxVarBg = bg(bcVar);
        return (zxVarBg == null || (bVar = zxVarBg.u) == null) ? "" : bVar.mv();
    }

    public static int b(bc bcVar) {
        com.bykv.vk.openvk.component.video.api.fx.b bVar;
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null || (bVar = zxVarBg.u) == null) {
            return 0;
        }
        return bVar.fx();
    }

    private static zx bg(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.r();
    }

    public static int fx(bc bcVar) {
        com.bykv.vk.openvk.component.video.api.fx.b bVar;
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null || (bVar = zxVarBg.u) == null) {
            return 0;
        }
        return bVar.nr();
    }

    public static boolean iz(bc bcVar) {
        return bcVar != null && bcVar.oi() == 1 && com.bytedance.sdk.openadsdk.core.d.b() && bcVar.uk() == 1 && my(bcVar) != null;
    }

    public static int jk(bc bcVar) {
        if (bg(bcVar) == null) {
            return 413;
        }
        if (TextUtils.isEmpty(u(bcVar))) {
            return 414;
        }
        return TextUtils.isEmpty(nr(bcVar)) ? 415 : 200;
    }

    public static com.bykv.vk.openvk.component.video.api.fx.b k(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar = zxVarBg.u;
        if (bVar != null) {
            return bVar;
        }
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar) && tk.nr(bcVar) == 3) {
            return bVar;
        }
        if (!com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            return zxVarBg.u;
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar2 = new com.bykv.vk.openvk.component.video.api.fx.b();
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            bVar2.fx(zxVarBg.fx.pn());
            bVar2.pn(0);
            bVar2.b(0);
            bVar2.pn(zxVarBg.fx.nr());
            bVar2.u(zxVarBg.fx.fx());
            bVar2.u(zxVarBg.fx.iz() * ((double) (zxVarBg.fx.x() + 1)));
        }
        zxVarBg.u = bVar2;
        return bVar2;
    }

    public static boolean l(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        return (zxVarBg == null || zxVarBg.fx == null) ? false : true;
    }

    public static boolean mv(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return false;
        }
        return zxVarBg.u.c();
    }

    public static com.bykv.vk.openvk.component.video.api.fx.b my(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return null;
        }
        return zxVarBg.nr;
    }

    public static String n(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        return zxVarBg == null ? "" : com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar) ? com.bykv.vk.openvk.component.video.api.iz.nr.u(m.x(bcVar)) : com.bytedance.sdk.openadsdk.gi.t.u(bcVar) ? o(bcVar).nr() : zxVarBg.u.k();
    }

    public static String nr(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            return m.n(bcVar);
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar = zxVarBg.u;
        return bVar == null ? "" : bVar.t();
    }

    public static com.bykv.vk.openvk.component.video.api.fx.u o(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return null;
        }
        return zxVarBg.fx;
    }

    public static int[] pn(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        if (bcVar.ol() == 166 && m.u(bcVar)) {
            return new int[]{m.l(bcVar), m.mv(bcVar)};
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVarMy = my(bcVar);
        if (iz(bcVar) && bVarMy != null) {
            return bVarMy.jk();
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVarK = k(bcVar);
        if (bVarK != null) {
            return bVarK.jk();
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.api.fx.b s(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar = new com.bykv.vk.openvk.component.video.api.fx.b();
        com.bykv.vk.openvk.component.video.api.fx.b bVar2 = zxVarBg.u;
        if (bVar2 != null) {
            bVar.nr(bVar2.nr());
            bVar.fx(zxVarBg.u.fx());
            bVar.u(zxVarBg.u.a());
            bVar.u(zxVarBg.u.pn());
            bVar.u(zxVarBg.u.iz());
            bVar.nr(zxVarBg.u.t());
            bVar.fx(zxVarBg.u.l());
            bVar.b(zxVarBg.u.mv());
            bVar.pn(zxVarBg.u.k());
            bVar.u(zxVarBg.u.u());
            bVar.b(zxVarBg.u.my());
            bVar.pn(zxVarBg.u.o());
            bVar.iz(zxVarBg.u.sx());
            bVar.u(zxVarBg.u.n());
            bVar.nr(zxVarBg.u.x());
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            bVar.nr(m.n(bcVar));
            bVar.fx(m.x(bcVar));
            bVar.pn(com.bykv.vk.openvk.component.video.api.iz.nr.u(m.x(bcVar)));
            bVar.u(-1L);
            bVar.u(m.nr(bcVar));
            bVar.b(0);
            bVar.pn(1);
        }
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            bVar.fx(zxVarBg.fx.pn());
            bVar.pn(0);
            bVar.b(0);
            bVar.pn(zxVarBg.fx.nr());
            bVar.u(zxVarBg.fx.fx());
            bVar.nr(zxVarBg.fx.b());
            bVar.u(zxVarBg.fx.iz() * ((double) (zxVarBg.fx.x() + 1)));
        }
        return bVar;
    }

    public static com.bykv.vk.openvk.component.video.api.fx.iz sx(bc bcVar) {
        zx zxVarR;
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU = u(4, bcVar);
        izVarU.u(true);
        if (bcVar != null && (zxVarR = bcVar.r()) != null) {
            com.bykv.vk.openvk.component.video.api.fx.b bVarKj = izVarU.kj();
            com.bykv.vk.openvk.component.video.api.fx.u uVar = zxVarR.fx;
            if (uVar != null && bVarKj != null) {
                bVarKj.fx(uVar.pn());
                bVarKj.pn(0);
                bVarKj.b(0);
                bVarKj.pn(zxVarR.fx.nr());
                bVarKj.u(zxVarR.fx.fx());
                bVarKj.nr(zxVarR.fx.b());
                bVarKj.u(zxVarR.fx.iz() * ((double) (zxVarR.fx.x() + 1)));
            }
        }
        return izVarU;
    }

    public static boolean t(bc bcVar) {
        com.bykv.vk.openvk.component.video.api.fx.b bVar;
        zx zxVarBg = bg(bcVar);
        return (zxVarBg == null || (bVar = zxVarBg.u) == null || bVar.u() != 1) ? false : true;
    }

    public static double x(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            int iNr = m.nr(bcVar);
            com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = bcVar.tm();
            if (nrVarTm != null && nrVarTm.bq() == 9) {
                iNr *= 2;
            }
            return iNr;
        }
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            return ((int) o(bcVar).iz()) * (o(bcVar).x() + 1);
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar = zxVarBg.u;
        if (bVar == null) {
            return 0.0d;
        }
        return bVar.iz();
    }

    public void u(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.fx.b bVar = this.u;
            if (bVar != null) {
                jSONObject.put("video", bVar.bg());
            }
        } catch (JSONException unused) {
        }
        try {
            com.bykv.vk.openvk.component.video.api.fx.b bVar2 = this.nr;
            if (bVar2 != null) {
                jSONObject.put("h265_video", bVar2.bg());
            }
        } catch (JSONException unused2) {
        }
        try {
            com.bykv.vk.openvk.component.video.api.fx.u uVar = this.fx;
            if (uVar != null) {
                jSONObject.put("audio", uVar.u());
            }
        } catch (JSONException unused3) {
        }
    }

    public zx(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        zx zxVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.fx.b bVar = new com.bykv.vk.openvk.component.video.api.fx.b();
            bVar.nr(jSONObjectOptJSONObject.optInt("cover_height"));
            bVar.fx(jSONObjectOptJSONObject.optInt("cover_width"));
            bVar.u(jSONObjectOptJSONObject.optString("resolution"));
            str2 = "resolution";
            str3 = "cover_width";
            bVar.u(jSONObjectOptJSONObject.optLong("size"));
            bVar.u(jSONObjectOptJSONObject.optDouble(WfConstant.EXTRA_KEY_VIDEO_DURATION));
            bVar.nr(jSONObjectOptJSONObject.optString("cover_url"));
            bVar.fx(jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_VIDEO_URL));
            bVar.b(jSONObjectOptJSONObject.optString("endcard"));
            bVar.pn(jSONObjectOptJSONObject.optString("file_hash"));
            str = "file_hash";
            bVar.u((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            bVar.u(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            bVar.b(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            bVar.pn(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            bVar.iz(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            bVar.nr(jSONObjectOptJSONObject.optDouble("start", -1.0d));
            zxVar = this;
            str4 = "size";
            zxVar.u = bVar;
        } else {
            str = "file_hash";
            str2 = "resolution";
            str3 = "cover_width";
            str4 = "size";
            zxVar = this;
        }
        String str5 = str;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.fx.b bVar2 = new com.bykv.vk.openvk.component.video.api.fx.b();
            bVar2.nr(jSONObjectOptJSONObject2.optInt("cover_height"));
            bVar2.fx(jSONObjectOptJSONObject2.optInt(str3));
            bVar2.u(jSONObjectOptJSONObject2.optString(str2));
            bVar2.u(jSONObjectOptJSONObject2.optLong(str4));
            bVar2.u(jSONObjectOptJSONObject2.optDouble(WfConstant.EXTRA_KEY_VIDEO_DURATION));
            bVar2.nr(jSONObjectOptJSONObject2.optString("cover_url"));
            bVar2.fx(jSONObjectOptJSONObject2.optString(WfConstant.EXTRA_KEY_VIDEO_URL));
            bVar2.b(jSONObjectOptJSONObject2.optString("endcard"));
            bVar2.pn(jSONObjectOptJSONObject2.optString(str5));
            bVar2.u((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            bVar2.u(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            bVar2.b(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            bVar2.pn(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            bVar2.iz(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            bVar2.nr(jSONObjectOptJSONObject2.optDouble("start", -1.0d));
            zxVar.nr = bVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("audio");
        if (jSONObjectOptJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.fx.u uVar = new com.bykv.vk.openvk.component.video.api.fx.u();
            uVar.nr(jSONObjectOptJSONObject3.optString("audio_url"));
            uVar.u(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            uVar.nr(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            uVar.u(jSONObjectOptJSONObject3.optLong(str4, -2147483648L));
            uVar.u(jSONObjectOptJSONObject3.optString(str5));
            uVar.nr(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            uVar.u(jSONObjectOptJSONObject3.optDouble("start", -1.0d));
            uVar.nr(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            zxVar.fx = uVar;
        }
    }

    public void u(com.bykv.vk.openvk.component.video.api.fx.b bVar) {
        this.u = bVar;
    }

    public static String u(bc bcVar) {
        zx zxVarBg = bg(bcVar);
        if (zxVarBg == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            return m.x(bcVar);
        }
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            return o(bcVar).pn();
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVar = zxVarBg.u;
        return bVar == null ? "" : bVar.l();
    }

    public static com.bykv.vk.openvk.component.video.api.fx.iz u(int i, bc bcVar) {
        String strU;
        if (bcVar.oi() == 1 && !com.bytedance.sdk.openadsdk.core.d.b()) {
            bcVar.v(0);
        }
        if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
            bcVar.v(0);
        }
        if (i == 1) {
            strU = com.bytedance.sdk.openadsdk.gi.jk.u(bcVar.oi()).u();
        } else if (i == 2) {
            strU = com.bytedance.sdk.openadsdk.gi.jk.u(bcVar.oi()).nr();
        } else if (i != 3) {
            strU = i != 4 ? "" : com.bytedance.sdk.openadsdk.gi.jk.u(bcVar.oi()).b();
        } else {
            strU = com.bytedance.sdk.openadsdk.gi.jk.u(bcVar.oi()).fx();
        }
        com.bykv.vk.openvk.component.video.api.fx.iz izVar = new com.bykv.vk.openvk.component.video.api.fx.iz(strU, s(bcVar), my(bcVar), bcVar.oi(), bcVar.uk());
        izVar.u(bcVar.mf());
        return izVar;
    }
}

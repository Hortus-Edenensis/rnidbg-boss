package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class yd {
    private static int fx = 0;
    private static int nr = 0;
    private static long u = 27000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5325a;
    private String b;
    private int bf;
    private double bg;
    private int bq;
    private int c;
    private boolean d;
    private int dw;
    private boolean gi;
    private int h;
    private boolean iz;
    private float ja;
    private double jk;
    private int k;
    private ArrayList<ob> kj;
    private int l;
    private int mv;
    private boolean my;
    private double n;
    private double o;
    private int pn;
    private boolean q;
    private boolean qq;
    private boolean rh;
    private int s;
    private boolean sx;
    private String t;
    private int wq;
    private boolean x;
    private ay z;

    public yd(JSONObject jSONObject) {
        this.c = 0;
        this.q = false;
        this.qq = false;
        this.kj = new ArrayList<>();
        this.ja = 1.0f;
        this.wq = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.kj = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.kj.add(new ob(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.z = new ay(jSONObjectOptJSONObject);
            this.d = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
            this.wq = jSONObjectOptJSONObject.optInt("video_no_play_start", 0);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.pn = jSONObjectOptJSONObject3.optInt(MediationConstant.REWARD_AMOUNT, 0);
            this.b = jSONObjectOptJSONObject3.optString(MediationConstant.REWARD_NAME, "");
            this.iz = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.mv = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.s = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.k = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.h = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.rh = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            this.ja = (float) jSONObjectOptJSONObject3.optDouble("reward_speed_time", 1.0d);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.x = jSONObjectOptJSONObject5.optBoolean("enable");
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.n = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.n = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.f5325a = jSONObjectOptJSONObject6.optBoolean("enable");
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.jk = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.jk = 0.0d;
                    }
                    this.t = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.l = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.my = jSONObjectOptJSONObject7.optBoolean("enable");
                    this.o = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.sx = jSONObjectOptJSONObject8.optBoolean("enable");
                    this.bg = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.bq = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.dw = jSONObject.optInt("reward_full_play_time", 30);
        this.c = jSONObject.optInt("reward_full_time_type", 0);
        this.gi = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.bf = jSONObject.optInt("template_sign", 0);
        this.q = jSONObject.optBoolean("__is_use_local_time", false);
        this.qq = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static String a(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH == null ? "" : TextUtils.isEmpty(ydVarH.t) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : ydVarH.t;
    }

    public static boolean b(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH != null && ydVarH.mv == 1;
    }

    public static boolean bg(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null && ydVarH.qq) {
            return mv(bcVar);
        }
        return false;
    }

    public static ArrayList<ob> bq(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH != null ? ydVarH.kj : new ArrayList<>();
    }

    public static ay c(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null) {
            return ydVarH.z;
        }
        return null;
    }

    public static int d(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0;
        }
        return ydVarH.bf;
    }

    public static boolean dw(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH != null && ydVarH.s == 1;
    }

    public static boolean fx(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.iz;
    }

    public static boolean gi(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.rh;
    }

    private static yd h(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.wi();
    }

    public static double iz(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0.0d;
        }
        return ydVarH.n;
    }

    public static int jk(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 30000;
        }
        int iMax = Math.max(ydVarH.l, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static int k(bc bcVar) {
        int i;
        yd ydVarH = h(bcVar);
        if (ydVarH != null && (i = ydVarH.dw) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static boolean kj(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH != null && ydVarH.h == 1;
    }

    public static double l(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0.0d;
        }
        return ydVarH.o;
    }

    public static boolean mv(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.sx;
    }

    public static int my(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0;
        }
        return ydVarH.c;
    }

    public static double n(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0.0d;
        }
        return ydVarH.jk;
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        u = fxVar.get("reward_time_limited", 27000L);
        nr = fxVar.get("reward_force_close_max_count", 0);
        fx = fxVar.get("reward_local_countdown_close_style", 0);
    }

    public static boolean o(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null && ydVarH.q) {
            return bg.b(bcVar) || my(bcVar) == 1 || my(bcVar) == 2;
        }
        return false;
    }

    public static boolean pn(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.x;
    }

    public static boolean q(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null) {
            return ydVarH.gi;
        }
        return false;
    }

    public static boolean qq(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.d;
    }

    public static int s(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 5;
        }
        return Math.max(5, ydVarH.bq);
    }

    public static boolean sx(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH != null && ydVarH.q && my(bcVar) == 1;
    }

    public static boolean t(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.my;
    }

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                u = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                nr = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 0);
                fx = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean x(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return false;
        }
        return ydVarH.f5325a;
    }

    public static float z(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 1.0f;
        }
        return ydVarH.ja;
    }

    public static boolean fx() {
        return fx == 1;
    }

    public static boolean fx(bc bcVar, boolean z) {
        yd ydVarH = h(bcVar);
        return (ydVarH != null && z && ydVarH.wq == 1) ? false : true;
    }

    public void nr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<ob> arrayList = this.kj;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ob> it = this.kj.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().u());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            ay ayVar = this.z;
            if (ayVar != null) {
                ayVar.u(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.d);
            jSONObject2.put("video_no_play_start", this.wq);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException unused) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MediationConstant.REWARD_NAME, this.b);
            jSONObject3.put(MediationConstant.REWARD_AMOUNT, this.pn);
            jSONObject3.put("reward_info_show", this.iz);
            jSONObject3.put("reward_back_type", this.mv);
            jSONObject3.put("reward_backup_timing", this.s);
            jSONObject3.put("reward_backup_duration", this.k);
            jSONObject3.put("reward_is_callback", this.h);
            jSONObject3.put("reward_need_click", this.rh);
            jSONObject3.put("reward_speed_time", this.ja);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.x);
            jSONObject5.put("propose_reward", this.n);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.f5325a);
            jSONObject6.put("propose_reward", this.jk);
            jSONObject6.put("tip_toast", this.t);
            jSONObject6.put("min_duration", this.l);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.my);
            jSONObject7.put("propose_reward", this.o);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.sx);
            jSONObject8.put("propose_reward", this.bg);
            jSONObject8.put("landing_view_time", this.bq);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("reward_full_play_time", this.dw);
            jSONObject.put("reward_full_time_type", this.c);
            jSONObject.put("interstitial_bg_transparent", this.gi);
            jSONObject.put("template_sign", this.bf);
            jSONObject.put("__is_use_local_time", this.q);
            jSONObject.put("__is_click_landing_reward", this.qq);
        } catch (JSONException unused3) {
        }
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        fxVar.put("reward_time_limited", u);
        fxVar.put("reward_force_close_max_count", nr);
        fxVar.put("reward_local_countdown_close_style", fx);
    }

    public static String u(bc bcVar) {
        yd ydVarH = h(bcVar);
        return ydVarH == null ? "" : ydVarH.b;
    }

    public static long u() {
        return u;
    }

    public static float u(bc bcVar, int i) {
        double dIz;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            dIz = iz(bcVar);
        } else if (i == 2) {
            dIz = n(bcVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            dIz = l(bcVar);
        }
        return (float) dIz;
    }

    public static void u(bc bcVar, boolean z) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null) {
            ydVarH.q = z;
        }
    }

    public static int nr(bc bcVar) {
        yd ydVarH = h(bcVar);
        if (ydVarH == null) {
            return 0;
        }
        return ydVarH.pn;
    }

    public static long nr() {
        return nr;
    }

    public static void nr(bc bcVar, boolean z) {
        yd ydVarH = h(bcVar);
        if (ydVarH != null) {
            ydVarH.qq = z;
        }
    }

    public static int nr(bc bcVar, int i) {
        int i2;
        yd ydVarH = h(bcVar);
        return (ydVarH != null && (i2 = ydVarH.k) > 0) ? Math.min(i, i2) : i;
    }
}

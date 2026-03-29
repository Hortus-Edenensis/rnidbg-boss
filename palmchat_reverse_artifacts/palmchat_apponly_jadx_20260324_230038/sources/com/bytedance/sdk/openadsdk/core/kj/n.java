package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.huawei.hms.ads.ex;
import com.umeng.analytics.pro.bd;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static nr b;
    private static nr fx;
    private static nr iz;
    private static final nr n = new nr(null);
    private static nr nr;
    private static nr pn;
    private static nr u;
    private static nr x;

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        private int b;
        private int fx;
        private LinkedHashMap<Integer, Integer> iz;
        private int nr;
        private int pn;
        private int u;

        public fx(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.u = jSONObject.optInt("device_score_threshold", 0);
                this.nr = jSONObject.optInt("net_type_threshold", 0);
                this.fx = jSONObject.optInt("base_score", 60);
                this.b = jSONObject.optInt("score_threshold", 60);
                this.pn = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        int iOptInt = jSONArrayOptJSONArray2.optInt(0);
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(1);
                        if (iOptInt > 0) {
                            linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                        }
                    }
                }
                this.iz = linkedHashMap;
            }
        }

        public int b() {
            return this.b;
        }

        public int fx() {
            return this.nr;
        }

        public LinkedHashMap<Integer, Integer> iz() {
            return this.iz;
        }

        public int nr() {
            return this.u;
        }

        public int pn() {
            return this.pn;
        }

        public JSONObject u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.u);
                jSONObject.put("net_type_threshold", this.nr);
                jSONObject.put("base_score", this.fx);
                jSONObject.put("score_threshold", this.b);
                jSONObject.put("backup_score_threshold", this.pn);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.iz;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.iz.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.iz.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int x() {
            return this.fx;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fx f5316a;
        private int b;
        private int fx;
        private boolean iz;
        private u jk;
        private int l;
        private int mv;
        private int n;
        private int nr;
        private int pn;
        private boolean s;
        private int t;
        private int u;
        private int x;

        public nr(JSONObject jSONObject) {
            this.t = 1;
            this.l = 0;
            this.mv = 0;
            this.s = true;
            if (jSONObject != null) {
                this.u = jSONObject.optInt("get_type", 1);
                this.nr = jSONObject.optInt("max_count", 1);
                this.fx = jSONObject.optInt("strategy_type", -1);
                this.b = jSONObject.optInt("store_type", 1);
                this.pn = jSONObject.optInt("online_timeout", 10000);
                this.iz = jSONObject.optBoolean("enable", false);
                this.x = jSONObject.optInt("load_type", -1);
                this.n = jSONObject.optInt("trans_cache", 0);
                this.t = jSONObject.optInt("ad_count_max", 1);
                this.l = jSONObject.optInt("libra_group", 0);
                this.mv = jSONObject.optInt("record_interval_minute", 0);
                this.f5316a = new fx(jSONObject.optJSONObject("score_config"));
                this.jk = new u(jSONObject.optJSONObject("control_el"));
                this.s = jSONObject.optBoolean("is_filter_version", true);
            }
        }

        public int a() {
            return this.x;
        }

        public int b() {
            return this.fx;
        }

        public int fx() {
            if (this.nr <= 0) {
                this.nr = 1;
            }
            return this.nr;
        }

        public int iz() {
            return this.pn;
        }

        public int jk() {
            return this.n;
        }

        public int l() {
            return Math.max(this.t, 1);
        }

        public int mv() {
            return this.l;
        }

        public boolean n() {
            return this.s;
        }

        public int nr() {
            return this.u;
        }

        public int pn() {
            return this.b;
        }

        public int s() {
            return this.mv;
        }

        public fx t() {
            return this.f5316a;
        }

        public boolean x() {
            return this.iz;
        }

        public String u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.u);
                jSONObject.put("max_count", this.nr);
                jSONObject.put("strategy_type", this.fx);
                jSONObject.put("store_type", this.b);
                jSONObject.put("online_timeout", this.pn);
                jSONObject.put("enable", this.iz);
                jSONObject.put("is_filter_version", this.s);
                jSONObject.put("load_type", this.x);
                jSONObject.put("trans_cache", this.n);
                jSONObject.put("score_config", this.f5316a.u());
                jSONObject.put("control_el", this.jk.u());
                jSONObject.put("ad_count_max", this.t);
                jSONObject.put("libra_group", this.l);
                jSONObject.put("record_interval_minute", this.mv);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public boolean u(String str, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
            u uVar = this.jk;
            if (uVar == null) {
                return false;
            }
            return uVar.u(str, nrVar, bcVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private String fx;
        private String nr;
        private String pn;
        JSONObject u;

        public u(JSONObject jSONObject) {
            this.u = jSONObject;
            if (jSONObject != null) {
                this.nr = jSONObject.optString("mix_ad");
                this.fx = jSONObject.optString("disable_trans_cache");
                this.b = jSONObject.optString("delete_on_load");
                this.pn = jSONObject.optString("load_only_online");
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean nr(String str, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
            String str2;
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1085434702:
                    if (str.equals("delete_on_load")) {
                        b = 0;
                    }
                    break;
                case -1073750810:
                    if (str.equals("mix_ad")) {
                        b = 1;
                    }
                    break;
                case -883700652:
                    if (str.equals("disable_trans_cache")) {
                        b = 2;
                    }
                    break;
                case 1290851437:
                    if (str.equals("load_only_online")) {
                        b = 3;
                    }
                    break;
            }
            String strU = null;
            switch (b) {
                case 0:
                    str2 = this.b;
                    break;
                case 1:
                    str2 = !TextUtils.isEmpty(this.nr) ? this.nr : "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1)}";
                    break;
                case 2:
                    str2 = this.fx;
                    break;
                case 3:
                    str2 = this.pn;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            System.currentTimeMillis();
            try {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(str2, u(nrVar, bcVar, null, null));
            } catch (Exception unused) {
            }
            return TextUtils.equals(strU, ex.Code);
        }

        public JSONObject u() {
            return this.u;
        }

        private JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, JSONObject jSONObject, JSONObject jSONObject2) {
            JSONObject jSONObject3 = new JSONObject();
            if (nrVar != null) {
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("adType", nrVar.bq());
                    jSONObject4.put("adCount", nrVar.l());
                    jSONObject4.put("userData", com.bytedance.sdk.openadsdk.gi.a.u(nrVar.c()));
                    jSONObject3.put("adSlot", jSONObject4);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bcVar != null) {
                jSONObject3.put("meta", bcVar.et());
            }
            jSONObject3.put("cache", jSONObject);
            jSONObject3.put(bd.f10871a, jSONObject2);
            return jSONObject3;
        }

        public boolean u(String str, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
            return nr(str, nrVar, bcVar);
        }
    }

    private static nr b() {
        nr nrVar = b;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    private static nr fx() {
        nr nrVar = nr;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    private static nr iz() {
        nr nrVar = iz;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        nr nrVar = u;
        if (nrVar != null) {
            fxVar.put("cache_strategy_reward", nrVar.u());
        }
        nr nrVar2 = nr;
        if (nrVar2 != null) {
            fxVar.put("cache_strategy_full", nrVar2.u());
        }
        nr nrVar3 = b;
        if (nrVar3 != null) {
            fxVar.put("cache_strategy_banner", nrVar3.u());
        }
        nr nrVar4 = pn;
        if (nrVar4 != null) {
            fxVar.put("cache_strategy_feed", nrVar4.u());
        }
        nr nrVar5 = iz;
        if (nrVar5 != null) {
            fxVar.put("cache_strategy_draw", nrVar5.u());
        }
        nr nrVar6 = x;
        if (nrVar6 != null) {
            fxVar.put("cache_strategy_stream", nrVar6.u());
        }
        if (fx != null) {
            com.bytedance.sdk.openadsdk.core.fx.b.u().nr("cache_strategy_splash", fx.u());
        }
    }

    private static nr pn() {
        nr nrVar = pn;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            u = new nr(new JSONObject(fxVar.get("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            nr = new nr(new JSONObject(fxVar.get("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
        try {
            b = new nr(new JSONObject(fxVar.get("cache_strategy_banner", "")));
        } catch (JSONException unused3) {
        }
        try {
            pn = new nr(new JSONObject(fxVar.get("cache_strategy_feed", "")));
        } catch (JSONException unused4) {
        }
        try {
            iz = new nr(new JSONObject(fxVar.get("cache_strategy_draw", "")));
        } catch (JSONException unused5) {
        }
        try {
            x = new nr(new JSONObject(fxVar.get("cache_strategy_stream", "")));
        } catch (JSONException unused6) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.pn.fx.u();
        } catch (Exception unused7) {
        }
    }

    private static nr x() {
        nr nrVar = x;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    public static nr u() {
        if (fx == null) {
            String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("cache_strategy_splash", (String) null);
            try {
                if (TextUtils.isEmpty(strFx)) {
                    nr nrVar = new nr(new JSONObject());
                    fx = nrVar;
                    nrVar.b = 0;
                } else {
                    fx = new nr(new JSONObject(strFx));
                }
            } catch (JSONException unused) {
            }
        }
        return fx;
    }

    private static nr nr() {
        nr nrVar = u;
        return nrVar == null ? new nr(new JSONObject()) : nrVar;
    }

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
                if (jSONObjectOptJSONObject2 != null) {
                    u = new nr(jSONObjectOptJSONObject2);
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
                if (jSONObjectOptJSONObject3 != null) {
                    nr = new nr(jSONObjectOptJSONObject3);
                }
            } catch (Exception unused2) {
            }
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_banner");
                if (jSONObjectOptJSONObject4 != null) {
                    b = new nr(jSONObjectOptJSONObject4);
                }
            } catch (Exception unused3) {
            }
            try {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_feed");
                if (jSONObjectOptJSONObject5 != null) {
                    pn = new nr(jSONObjectOptJSONObject5);
                }
            } catch (Exception unused4) {
            }
            try {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_draw");
                if (jSONObjectOptJSONObject6 != null) {
                    iz = new nr(jSONObjectOptJSONObject6);
                }
            } catch (Exception unused5) {
            }
            try {
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
                if (jSONObjectOptJSONObject7 != null) {
                    fx = new nr(jSONObjectOptJSONObject7);
                }
            } catch (Exception unused6) {
            }
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_stream");
                if (jSONObjectOptJSONObject8 != null) {
                    x = new nr(jSONObjectOptJSONObject8);
                }
            } catch (Exception unused7) {
            }
        }
    }

    public static nr u(int i) {
        switch (i) {
            case 1:
                return b();
            case 2:
            default:
                return n;
            case 3:
            case 4:
                return u();
            case 5:
                return pn();
            case 6:
                return x();
            case 7:
                return nr();
            case 8:
                return fx();
            case 9:
                return iz();
        }
    }
}

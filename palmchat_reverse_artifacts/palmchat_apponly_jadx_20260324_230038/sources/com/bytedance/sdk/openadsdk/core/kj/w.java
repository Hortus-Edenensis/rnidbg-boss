package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class w {
    private String b;
    private String fx;
    private ArrayList<ob> iz;
    private String nr;
    private String pn;
    private int u;

    public w(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.u = 0;
        this.fx = "再看一个获取";
        this.b = "更多奖励";
        this.iz = new ArrayList<>();
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.u = jSONObjectOptJSONObject.optInt("again_type", 0);
        this.fx = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
        this.b = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
        this.nr = jSONObjectOptJSONObject.optString("pre_sessions");
        this.pn = jSONObjectOptJSONObject.optString("play_again_rit");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
        if (jSONArrayOptJSONArray != null) {
            this.iz = new ArrayList<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.iz.add(new ob(jSONObjectOptJSONObject2));
                }
            }
        }
    }

    public static String b(bc bcVar) {
        w wVarIz = iz(bcVar);
        if (wVarIz == null) {
            return null;
        }
        return wVarIz.pn;
    }

    public static String fx(bc bcVar) {
        w wVarIz = iz(bcVar);
        if (wVarIz == null) {
            return null;
        }
        return wVarIz.nr;
    }

    private static w iz(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.bj();
    }

    public static boolean nr(bc bcVar) {
        w wVarIz = iz(bcVar);
        if (wVarIz == null) {
            return false;
        }
        int i = wVarIz.u;
        return (i == 1 || i == 3) && u(bcVar);
    }

    public static ArrayList<ob> pn(bc bcVar) {
        w wVarIz = iz(bcVar);
        return wVarIz != null ? wVarIz.iz : new ArrayList<>();
    }

    public void u(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.u);
        } catch (JSONException unused) {
        }
        try {
            jSONObject2.put("entrance_prefix", this.fx);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject2.put("entrance_suffix", this.b);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject2.put("pre_sessions", this.nr);
        } catch (JSONException unused4) {
        }
        try {
            jSONObject2.put("play_again_rit", this.pn);
        } catch (JSONException unused5) {
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<ob> arrayList = this.iz;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ob> it = this.iz.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().u());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException unused6) {
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String nr(String str) {
        return str + "custom_again";
    }

    public static boolean u(bc bcVar) {
        w wVarIz = iz(bcVar);
        if (wVarIz == null || wi.u(bcVar)) {
            return false;
        }
        int i = wVarIz.u;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(wVarIz.nr);
    }

    public static String u(String str) {
        return str + "again";
    }

    public static String u(bc bcVar, String str, String str2) {
        w wVarIz = iz(bcVar);
        if (wVarIz == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "再看一个获取更多奖励";
            }
            return "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(wVarIz.fx) ? "再看一个获取" : wVarIz.fx);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sb.append(TextUtils.isEmpty(wVarIz.b) ? "更多奖励" : wVarIz.b);
        } else {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }
}

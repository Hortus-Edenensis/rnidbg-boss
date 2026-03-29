package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5322a;
    private int b;
    private int fx;
    private za iz;
    private JSONObject n;
    private int nr;
    private int pn;
    private int u;
    private tm x;

    public tk(JSONObject jSONObject, String str, oa oaVar) {
        this.u = 2;
        this.nr = 0;
        this.fx = 1;
        this.b = 0;
        this.pn = 100;
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optInt("render_control", oaVar != null ? oaVar.iz : 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject != null) {
            this.nr = jSONObjectOptJSONObject.optInt("render_sequence", 0);
            this.fx = jSONObjectOptJSONObject.optInt("backup_render_control", 1);
            this.b = jSONObjectOptJSONObject.optInt("render_thread", 0);
            this.pn = jSONObjectOptJSONObject.optInt("reserve_time", 100);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject2 != null) {
            za zaVar = new za();
            zaVar.nr(jSONObjectOptJSONObject2.optString("id"));
            zaVar.fx(jSONObjectOptJSONObject2.optString("md5"));
            zaVar.b(jSONObjectOptJSONObject2.optString("url"));
            zaVar.pn(jSONObjectOptJSONObject2.optString("data"));
            zaVar.iz(jSONObjectOptJSONObject2.optString("diff_data"));
            zaVar.x(jSONObjectOptJSONObject2.optString("dynamic_creative"));
            zaVar.u(jSONObjectOptJSONObject2.optString("version"));
            zaVar.n(jSONObjectOptJSONObject2.optString(WfConstant.EXTRA_KEY_MATERIAL_TYPE));
            zaVar.a(jSONObjectOptJSONObject2.optString("ugen_url"));
            zaVar.jk(jSONObjectOptJSONObject2.optString("ugen_md5"));
            zaVar.l(jSONObjectOptJSONObject2.optString("express_gesture_priority"));
            zaVar.t(jSONObjectOptJSONObject2.optString("engine_version"));
            this.iz = zaVar;
            com.bytedance.sdk.component.adexpress.u.fx.b bVarU = u(str);
            if (bVarU != null) {
                com.bytedance.sdk.component.adexpress.u.nr.nr.u(bVarU);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.jk.u(zaVar.a(), zaVar.jk(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject3 != null) {
            tm tmVarU = tm.u(jSONObjectOptJSONObject3);
            this.x = tmVarU;
            com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.u().u(tmVarU, str, "ad");
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject4 != null) {
            this.n = jSONObjectOptJSONObject4;
        }
    }

    public static com.bytedance.sdk.component.adexpress.u.fx.b a(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return null;
        }
        return tkVarMv.u(String.valueOf(com.bytedance.sdk.openadsdk.core.y.jp.t(bcVar)));
    }

    public static int b(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return 0;
        }
        return tkVarMv.b;
    }

    public static int fx(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return 1;
        }
        return tkVarMv.fx;
    }

    public static za iz(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return null;
        }
        return tkVarMv.iz;
    }

    public static boolean jk(bc bcVar) {
        return bcVar != null && nr(bcVar) == 7;
    }

    public static boolean l(bc bcVar) {
        return bcVar != null && nr(bcVar) == 10;
    }

    private static tk mv(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.v();
    }

    public static boolean n(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return false;
        }
        za zaVar = tkVarMv.iz;
        if (zaVar != null) {
            return !TextUtils.isEmpty(zaVar.t());
        }
        int i = tkVarMv.nr;
        return i == 9 || i == 10;
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            f5322a = new JSONObject(fxVar.getString("dark_mode_config", ""));
        } catch (Exception unused) {
        }
    }

    public static int pn(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return 100;
        }
        return tkVarMv.pn;
    }

    public static boolean t(bc bcVar) {
        return bcVar != null && nr(bcVar) == 3;
    }

    public static void u(bc bcVar, int i) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return;
        }
        tkVarMv.u = i;
    }

    public static tm x(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return null;
        }
        return tkVarMv.x;
    }

    public void nr(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.u);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.nr);
            jSONObject2.put("backup_render_control", this.fx);
            jSONObject2.put("render_thread", this.b);
            jSONObject2.put("reserve_time", this.pn);
            jSONObject.put("render", jSONObject2);
            if (this.iz != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.iz.nr());
                jSONObject3.put("md5", this.iz.fx());
                jSONObject3.put("url", this.iz.b());
                jSONObject3.put("data", this.iz.pn());
                jSONObject3.put("diff_data", this.iz.iz());
                jSONObject3.put("version", this.iz.u());
                jSONObject3.put("dynamic_creative", this.iz.x());
                jSONObject3.put(WfConstant.EXTRA_KEY_MATERIAL_TYPE, this.iz.n());
                jSONObject3.put("ugen_url", this.iz.a());
                jSONObject3.put("ugen_md5", this.iz.jk());
                jSONObject3.put("engine_version", this.iz.t());
                jSONObject3.put("express_gesture_priority", this.iz.l());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.n);
            tm tmVar = this.x;
            if (tmVar != null) {
                jSONObject.put("tpl_info_v3", tmVar.a());
            }
        } catch (JSONException unused) {
        }
    }

    public static void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                if (jSONObjectOptJSONObject != null) {
                    f5322a = jSONObjectOptJSONObject.optJSONObject("dark_mode_config");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            fxVar.put("dark_mode_config", f5322a.toString());
        } catch (Exception unused) {
        }
    }

    public static JSONObject u() {
        return f5322a;
    }

    private com.bytedance.sdk.component.adexpress.u.fx.b u(String str) {
        za zaVar = this.iz;
        if (zaVar == null) {
            return null;
        }
        String strNr = zaVar.nr();
        String strB = this.iz.b();
        String strFx = this.iz.fx();
        String strPn = this.iz.pn();
        return com.bytedance.sdk.component.adexpress.u.fx.b.u().u(strNr).nr(strFx).fx(strB).b(strPn).pn(this.iz.u()).iz(String.valueOf(str));
    }

    public static int u(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return 2;
        }
        return tkVarMv.u;
    }

    public static boolean u(int i) {
        JSONObject jSONObject = f5322a;
        if (jSONObject == null) {
            return i == 1 || i == 5 || i == 8;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("support_slot_type");
            if (jSONArrayOptJSONArray == null) {
                return i == 1 || i == 5 || i == 8;
            }
            int length = jSONArrayOptJSONArray.length();
            if (length == 0) {
                return i == 1 || i == 5 || i == 8;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (i == jSONArrayOptJSONArray.optInt(i2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return i == 1 || i == 5 || i == 8;
        }
    }

    public static int nr(bc bcVar) {
        tk tkVarMv = mv(bcVar);
        if (tkVarMv == null) {
            return 0;
        }
        return tkVarMv.nr;
    }
}

package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5305a;
    private int b;
    private int fx;
    private int iz;
    private int jk;
    private String n;
    private int nr;
    private int pn;
    private String u;
    private boolean x;

    public bg(JSONObject jSONObject) {
        this.nr = 0;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("reward_browse_type", 0);
        this.nr = iOptInt;
        if (iOptInt < 0 || iOptInt > 3) {
            this.nr = 0;
        }
        if (this.nr == 2) {
            this.nr = 3;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (jSONObjectOptJSONObject != null) {
            this.u = jSONObjectOptJSONObject.optString("direct_landing_url");
            this.fx = jSONObjectOptJSONObject.optInt("display_duration", 0);
            this.b = jSONObjectOptJSONObject.optInt(WkAdConfigModel.TAG_GDT_CLOSETIME, 0);
            this.pn = jSONObjectOptJSONObject.optInt("page_type");
            this.iz = jSONObjectOptJSONObject.optInt("show_type");
            this.x = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
            if (jSONObjectOptJSONObject2 != null) {
                this.n = jSONObjectOptJSONObject2.optString("ugen_url");
                this.f5305a = jSONObjectOptJSONObject2.optString("ugen_md5");
            }
            this.jk = jSONObjectOptJSONObject.optInt("close_btn_position");
        }
    }

    public static int a(bc bcVar) {
        int i;
        bg bgVarMy = my(bcVar);
        if (bgVarMy != null && (i = bgVarMy.fx) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean b(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy != null && u(bcVar) && bgVarMy.nr == 1 && bgVarMy.pn == 2;
    }

    public static boolean fx(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy != null && bgVarMy.nr == 1 && bgVarMy.pn == 1;
    }

    public static String iz(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy == null ? "" : bgVarMy.u;
    }

    public static int jk(bc bcVar) {
        int i;
        bg bgVarMy = my(bcVar);
        if (bgVarMy != null && (i = bgVarMy.b) >= 0) {
            return i;
        }
        return 0;
    }

    public static int k(bc bcVar) {
        bg bgVarMy = my(bcVar);
        if (bgVarMy == null) {
            return 0;
        }
        return bgVarMy.jk;
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.x.u l(bc bcVar) {
        bg bgVarMy = my(bcVar);
        if (bgVarMy == null || TextUtils.isEmpty(bgVarMy.n)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.x.u();
        uVar.fx(bgVarMy.n);
        uVar.nr(bgVarMy.f5305a);
        uVar.u(bgVarMy.n);
        return uVar;
    }

    public static boolean mv(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy != null && bgVarMy.jk == 1;
    }

    private static bg my(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.nb();
    }

    public static int n(bc bcVar) {
        bg bgVarMy = my(bcVar);
        if (bgVarMy == null) {
            return 0;
        }
        return bgVarMy.nr;
    }

    public static boolean nr(bc bcVar) {
        if (u(bcVar)) {
            return x(bcVar);
        }
        return false;
    }

    public static boolean pn(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy != null && bgVarMy.iz == 3;
    }

    public static boolean s(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return bgVarMy != null && bgVarMy.jk == 2;
    }

    public static boolean t(bc bcVar) {
        return my(bcVar) != null && n(bcVar) == 3 && u(bcVar);
    }

    public static boolean x(bc bcVar) {
        bg bgVarMy = my(bcVar);
        if (bgVarMy == null) {
            return false;
        }
        return bgVarMy.x;
    }

    public void u(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.nr);
        } catch (Exception unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.u);
            jSONObject2.put("display_duration", this.fx);
            jSONObject2.put(WkAdConfigModel.TAG_GDT_CLOSETIME, this.b);
            jSONObject2.put("page_type", this.pn);
            jSONObject2.put("show_type", this.iz);
            jSONObject2.put("close_btn_position", this.jk);
            jSONObject2.put("is_landing_with_sound", this.x);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.n);
            jSONObject3.put("ugen_md5", this.f5305a);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception unused2) {
        }
    }

    public static boolean u(bc bcVar) {
        bg bgVarMy = my(bcVar);
        return (bgVarMy == null || n(bcVar) == 0 || TextUtils.isEmpty(bgVarMy.u)) ? false : true;
    }
}

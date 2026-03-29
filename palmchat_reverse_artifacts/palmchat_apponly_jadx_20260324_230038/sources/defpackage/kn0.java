package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18726a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;

    public static kn0 e(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("ContactConfig", "parseContactConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("contactConfig")) == null) {
            return null;
        }
        kn0 kn0Var = new kn0();
        kn0Var.f18726a = jSONObjectOptJSONObject.optString("thread_banner_tip");
        kn0Var.b = jSONObjectOptJSONObject.optString("nearby_banner_tip");
        kn0Var.g = jSONObjectOptJSONObject.optBoolean("switchEnabled");
        kn0Var.h = jSONObjectOptJSONObject.optString("cardDelRefreshHour");
        kn0Var.i = jSONObjectOptJSONObject.optString("cardExpireDay");
        kn0Var.j = jSONObjectOptJSONObject.optString("applyExpireHour");
        kn0Var.k = jSONObjectOptJSONObject.optString("cardPullDuration");
        kn0Var.l = jSONObjectOptJSONObject.optString("cardCarouselDuration");
        kn0Var.m = jSONObjectOptJSONObject.optString("contactForwardMaxSize");
        kn0Var.n = jSONObjectOptJSONObject.optString("contactBackwardMaxSize");
        kn0Var.o = jSONObjectOptJSONObject.optString("otherSuggestMaxSize");
        kn0Var.p = jSONObjectOptJSONObject.optString("oneKeySuggestMaxSize");
        kn0Var.q = jSONObjectOptJSONObject.optString("showMoreSize");
        kn0Var.r = jSONObjectOptJSONObject.optString("friendModulesSort");
        kn0Var.s = jSONObjectOptJSONObject.optString("friendModulesShow");
        kn0Var.t = jSONObjectOptJSONObject.optString("dismissModulesDur");
        kn0Var.u = jSONObjectOptJSONObject.optString("contactShowDur");
        kn0Var.v = jSONObjectOptJSONObject.optString("rollbackLX9067");
        LogUtil.i("ContactConfig", "contactConfig=" + jSONObjectOptJSONObject);
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("newEntranceTip");
        if (jSONObjectOptJSONObject2 == null) {
            return kn0Var;
        }
        kn0Var.c = jSONObjectOptJSONObject2.optString("mainTitle_en");
        kn0Var.d = jSONObjectOptJSONObject2.optString("subTitle_en");
        kn0Var.e = jSONObjectOptJSONObject2.optString("mainTitle_zh");
        kn0Var.f = jSONObjectOptJSONObject2.optString("subTitle_zh");
        LogUtil.i("ContactConfig", "newEntranceTip=" + jSONObjectOptJSONObject2);
        return kn0Var;
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.b;
    }
}

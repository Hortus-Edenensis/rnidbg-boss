package com.zenmen.palmchat.peoplenearby.ad;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.peoplenearby.ad.PeopleNearbyAdLoadMore;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cg4;
import defpackage.eg4;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l6;
import defpackage.rl0;
import defpackage.zn6;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e {
    public static String b = "PeopleNearbyAdNewStyle";
    public static JSONObject c = null;
    public static String d = "";
    public static Boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f14988a;

    public e(Activity activity) {
        this.f14988a = new d(activity);
    }

    public static boolean A() {
        return !"A".equals(s());
    }

    public static boolean B() {
        if (!z() || !x()) {
            return false;
        }
        LogUtil.d(b, "isTaichiEnableAndMaskStyle = true");
        return true;
    }

    public static boolean C() {
        if (!z() || !w()) {
            return false;
        }
        LogUtil.d(b, "isTaichiEnableAndPullUp = true");
        return true;
    }

    public static void H() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taichi", "LX-29613");
            jSONObject.put("exp_group", s());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
    }

    public static void J(String str) {
        LogUtil.d(b, "updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d = str;
    }

    public static void K() {
        String str;
        LogUtil.d(b, "updateConfigData extra = " + d);
        if (!TextUtils.isEmpty(d) && c == null) {
            try {
                JSONObject jSONObject = new JSONObject(d);
                JSONArray jSONArray = jSONObject.has("taichikey") ? jSONObject.getJSONArray("taichikey") : null;
                String string = "";
                if (jSONArray == null || jSONArray.length() < 1) {
                    str = "";
                } else {
                    String str2 = (String) jSONArray.get(0);
                    str = str2 + "_" + v(str2);
                }
                if (jSONObject.has(str)) {
                    c = jSONObject.getJSONObject(str);
                }
                H();
                String str3 = b;
                StringBuilder sb = new StringBuilder();
                sb.append("config = ");
                JSONObject jSONObject2 = c;
                if (jSONObject2 != null) {
                    string = jSONObject2.toString();
                }
                sb.append(string);
                LogUtil.d(str3, sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        M();
    }

    public static void L() {
        if (A()) {
            K();
        }
        d.p();
    }

    public static void M() {
        if (!A() || c() == 0) {
            e = Boolean.FALSE;
        } else {
            e = Boolean.TRUE;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_nest_nearby_reward_newStyle_enable"), e);
    }

    public static int c() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 0;
        }
        try {
            if (jSONObject.has("adEnterStyle")) {
                return c.optInt("adEnterStyle", 0);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static int d() {
        return (B() || C()) ? e() : d.b();
    }

    public static int e() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 200;
        }
        try {
            if (jSONObject.has("bannerP")) {
                return Math.max(1, c.optInt("bannerP", 200));
            }
        } catch (Exception unused) {
        }
        return 200;
    }

    public static String f() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return "预计解锁%d个用户";
        }
        try {
            if (jSONObject.has("bottomText")) {
                return c.optString("bottomText", "预计解锁%d个用户");
            }
        } catch (Exception unused) {
        }
        return "预计解锁%d个用户";
    }

    public static JSONObject g() {
        return c;
    }

    public static String h() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return "看视频解锁全部附近的人";
        }
        try {
            if (jSONObject.has("dialogTitle")) {
                return c.optString("dialogTitle", "看视频解锁全部附近的人");
            }
        } catch (Exception unused) {
        }
        return "看视频解锁全部附近的人";
    }

    public static String i() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return "上拉观看视频，查看更多附近的人";
        }
        try {
            if (jSONObject.has("imageText1")) {
                return c.optString("imageText1", "上拉观看视频，查看更多附近的人");
            }
        } catch (Exception unused) {
        }
        return "上拉观看视频，查看更多附近的人";
    }

    public static String j() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return "下滑不看视频，放弃看更多附近的人";
        }
        try {
            if (jSONObject.has("imageText2")) {
                return c.optString("imageText2", "下滑不看视频，放弃看更多附近的人");
            }
        } catch (Exception unused) {
        }
        return "下滑不看视频，放弃看更多附近的人";
    }

    public static int k() {
        return (B() || C()) ? l() : d.d();
    }

    public static int l() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 3;
        }
        try {
            if (jSONObject.has("limit")) {
                return Math.max(1, c.optInt("limit", 3));
            }
        } catch (Exception unused) {
        }
        return 3;
    }

    public static int m() {
        return (B() || C()) ? n() : d.e();
    }

    public static int n() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 10;
        }
        try {
            if (jSONObject.has("interval")) {
                return c.optInt("interval", 10);
            }
        } catch (Exception unused) {
        }
        return 10;
    }

    public static int o() {
        return (B() || C()) ? p() : d.f();
    }

    public static int p() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 300;
        }
        try {
            if (jSONObject.has("minValue")) {
                return c.optInt("minValue", 300);
            }
        } catch (Exception unused) {
        }
        return 300;
    }

    public static int q() {
        return (B() || C()) ? r() : d.g();
    }

    public static int r() {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return 150;
        }
        try {
            if (jSONObject.has("requestTime")) {
                return c.optInt("requestTime", 150);
            }
        } catch (Exception unused) {
        }
        return 150;
    }

    public static String s() {
        String strC = jo6.c("LX-29613", "A");
        LogUtil.i(b, "getTaichiValue " + strC);
        return strC;
    }

    public static String v(String str) {
        return jo6.e(str);
    }

    public static boolean w() {
        return 1 == c();
    }

    public static boolean x() {
        return 2 == c() && !l6.c();
    }

    public static boolean y() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_NESTAD_CONFIG);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return true;
    }

    public static boolean z() {
        if (e == null) {
            e = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.AD, k86.a("key_nest_nearby_reward_newStyle_enable"), false));
        }
        LogUtil.d(b, "isNewStyleEnable = " + e);
        return e.booleanValue();
    }

    public void D(eg4 eg4Var, boolean z) {
        d dVar = this.f14988a;
        if (dVar != null) {
            dVar.k(eg4Var, z);
        }
    }

    public void E() {
        d dVar = this.f14988a;
        if (dVar != null) {
            dVar.l();
        }
    }

    public void F() {
        if (B() || C()) {
            G();
            return;
        }
        d dVar = this.f14988a;
        if (dVar != null) {
            dVar.m();
        }
    }

    public final void G() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = cg4.b(sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_time_newstyle"), 0L), System.currentTimeMillis()) ? 1 + sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_count_newstyle"), 0L) : 1L;
        sPUtil.t(scene, k86.a("nearby_ad_nest_reward_verify_time_newstyle"), Long.valueOf(System.currentTimeMillis()));
        sPUtil.t(scene, k86.a("nearby_ad_nest_reward_verify_count_newstyle"), Long.valueOf(jI));
    }

    public boolean I() {
        d dVar = this.f14988a;
        if (dVar != null) {
            return dVar.n();
        }
        return false;
    }

    public PeopleNearbyAdLoadMore.Status a() {
        if (B() || C()) {
            return b();
        }
        d dVar = this.f14988a;
        return dVar != null ? dVar.a() : PeopleNearbyAdLoadMore.Status.DISABLE;
    }

    public PeopleNearbyAdLoadMore.Status b() {
        if (!A() || !y()) {
            return PeopleNearbyAdLoadMore.Status.DISABLE;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        long jI = sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_time_newstyle"), 0L);
        return (cg4.b(jI, System.currentTimeMillis()) ? sPUtil.i(scene, k86.a("nearby_ad_nest_reward_verify_count_newstyle"), 0L) : 0L) >= ((long) k()) ? PeopleNearbyAdLoadMore.Status.LIMITED_COUNT : System.currentTimeMillis() - jI < ((long) (m() * 60)) * 1000 ? PeopleNearbyAdLoadMore.Status.LIMITED_INTERVAL : PeopleNearbyAdLoadMore.Status.NORMAL;
    }

    public long t() {
        if (B() || C()) {
            return u();
        }
        d dVar = this.f14988a;
        if (dVar != null) {
            return dVar.i();
        }
        return 0L;
    }

    public final long u() {
        return SPUtil.f14322a.i(SPUtil.SCENE.NEARBY, k86.a("nearby_ad_nest_reward_verify_count_newstyle"), 0L);
    }
}

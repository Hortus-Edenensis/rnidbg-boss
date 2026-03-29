package com.zenmen.palmchat.peoplenearby.ad;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.peoplenearby.ad.PeopleNearbyAdLoadMore;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.eg4;
import defpackage.fg6;
import defpackage.jo6;
import defpackage.k86;
import defpackage.rl0;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d {
    public static String d = "PeopleNearbyAdLoadMoreNew";
    public static String e = "";
    public static String f = "";
    public static Boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f14987a;
    public PeopleNearbyAdLoadMore b;
    public a c;

    public d(Activity activity) {
        this.f14987a = activity;
        if (j()) {
            this.c = new a(activity);
        } else {
            this.b = new PeopleNearbyAdLoadMore(activity);
        }
    }

    public static int b() {
        return j() ? a.f() : PeopleNearbyAdLoadMore.h();
    }

    public static String c() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_TV);
        if (dynamicConfig == null) {
            return "观看视频，本次可立即查看更多附近的人!";
        }
        String extra = dynamicConfig.getExtra();
        if (!TextUtils.isEmpty(extra)) {
            try {
                return new JSONObject(extra).optString("bannerText", "观看视频，本次可立即查看更多附近的人!");
            } catch (Exception unused) {
            }
        }
        return "观看视频，本次可立即查看更多附近的人!";
    }

    public static int d() {
        return j() ? a.g() : PeopleNearbyAdLoadMore.j();
    }

    public static int e() {
        return j() ? a.h() : PeopleNearbyAdLoadMore.k();
    }

    public static int f() {
        return j() ? a.i() : PeopleNearbyAdLoadMore.l();
    }

    public static int g() {
        return j() ? a.j() : PeopleNearbyAdLoadMore.m();
    }

    public static String h() {
        String strC = jo6.c("LX-28916", "A");
        LogUtil.i(d, "getTaichiValue " + strC);
        return strC;
    }

    public static boolean j() {
        if (g == null) {
            g = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.AD, k86.a("key_nest_nearby_reward_enable"), false));
        }
        LogUtil.d(d, "isNestRewardEnable = " + g);
        return g.booleanValue();
    }

    public static void o(String str) {
        LogUtil.d(d, "updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
        try {
            e = new JSONObject(str).getString(h());
            LogUtil.d(d, "strategyJson = " + e);
        } catch (Exception unused) {
        }
    }

    public static void p() {
        LogUtil.d(d, "updateEnableWithTaichi strategyJson = " + e + ", configExtra =" + f);
        if (TextUtils.isEmpty(e) && !TextUtils.isEmpty(f)) {
            try {
                e = new JSONObject(f).getString(h());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("taichi", "LX-28916");
                    jSONObject.put("exp_group", h());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        boolean z = !"A".equals(h());
        LogUtil.i(d, "updateEnableWithTaichi  isNestEnable " + z + ", strategyJson = " + e + ", getTaichiValue = " + h());
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_nest_nearby_reward_enable"), Boolean.valueOf(z));
        g = Boolean.valueOf(z);
    }

    public PeopleNearbyAdLoadMore.Status a() {
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                return aVar.e();
            }
        } else {
            PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
            if (peopleNearbyAdLoadMore != null) {
                return peopleNearbyAdLoadMore.f();
            }
        }
        return PeopleNearbyAdLoadMore.Status.DISABLE;
    }

    public long i() {
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                return aVar.l();
            }
            return 0L;
        }
        PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
        if (peopleNearbyAdLoadMore != null) {
            return peopleNearbyAdLoadMore.n();
        }
        return 0L;
    }

    public void k(eg4 eg4Var, boolean z) {
        if (fg6.d(AppContext.getContext())) {
            return;
        }
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.o(eg4Var, e, z);
                return;
            }
            return;
        }
        PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
        if (peopleNearbyAdLoadMore != null) {
            peopleNearbyAdLoadMore.q(eg4Var, z);
        }
    }

    public void l() {
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.p();
                return;
            }
            return;
        }
        PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
        if (peopleNearbyAdLoadMore != null) {
            peopleNearbyAdLoadMore.r();
        }
    }

    public void m() {
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.q();
                return;
            }
            return;
        }
        PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
        if (peopleNearbyAdLoadMore != null) {
            peopleNearbyAdLoadMore.s();
        }
    }

    public boolean n() {
        if (j()) {
            a aVar = this.c;
            if (aVar != null) {
                return aVar.r();
            }
            return false;
        }
        PeopleNearbyAdLoadMore peopleNearbyAdLoadMore = this.b;
        if (peopleNearbyAdLoadMore != null) {
            return peopleNearbyAdLoadMore.t();
        }
        return false;
    }
}

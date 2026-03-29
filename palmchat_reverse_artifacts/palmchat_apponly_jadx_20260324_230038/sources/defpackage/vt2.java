package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.modulemanager.module.LXAdRequestInitManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vt2 {
    public static void a(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tab_name", str);
            jSONObject.put(f.v, str2);
            jSONObject.put("taichi", uv3.q());
            jSONObject.put("exp_group", uv3.r());
            zn6.d(str3, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String b(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("source_page_tag")) == null) ? "" : string;
    }

    public static String c(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("source_tab_tag")) == null) ? "" : string;
    }

    public static void d(Activity activity, Bundle bundle) {
        e(activity, bundle, true);
    }

    public static void e(Activity activity, Bundle bundle, boolean z) {
        if (activity == null || bundle == null) {
            return;
        }
        String string = bundle.getString("source_tab_tag");
        String string2 = bundle.getString("source_page_tag");
        if (il5.l(string) || il5.l(string2)) {
            return;
        }
        a(string, string2, "lx_client_enter_sencond");
        LogUtil.d("InterAdManager", "onPageEnter, tabTag=" + string + ", pageTag=" + string2);
        if (z) {
            i42.c(activity, string2);
        }
        uv3.A(activity, string, string2);
    }

    public static void f(Activity activity, String str) {
        LogUtil.d("InterAdManager", "onTabEnter, " + str);
        if (LXAdRequestInitManager.isAllowUIReadyRequestAd() && !LXAdRequestInitManager.isMainTabUIReady) {
            LogUtil.d("InterAdManager", "onTabEnter, LXAdRequestInitManager.isMainTabUIReady false not allow " + str);
            return;
        }
        a(str, "", "lx_client_enter_first");
        i42.c(activity, str);
        if (WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(uv3.t())) {
            LogUtil.d("", "lx_frequency_contrl58421 popAd onTabEnter Switch58421 is C tabTag " + str + " 不允许请求广告");
        } else {
            LogUtil.d("", "lx_frequency_contrl58421 popAd onTabEnter Switch58421 is not C tabTag " + str + " 可以请求广告");
            uv3.C(activity, str);
        }
        gn1.c(str);
        ns5.g(activity, false, str);
        if ("tab_mine".equals(str)) {
            gp3.j(activity, 2, str);
            np3.n = true;
        } else {
            gp3.j(activity, 3, str);
        }
        vu3.o(activity, str);
        if ("tab_square".equals(str)) {
            wh5.Y(activity, 1, 0);
            wh5.V(activity, 1, 0);
            wh5.W(activity, 1, 0);
            wh5.X(activity, 1, 0);
        }
        p93.r(activity);
        if (v8.h()) {
            if ("tab_mine".equals(str) || "tab_msg".equals(str)) {
                v8.R();
            }
        }
    }
}

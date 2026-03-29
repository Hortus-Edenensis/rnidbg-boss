package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.dw;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.kuaishou.weapon.p0.g;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static String u;

    public static String b() {
        return "";
    }

    public static void fx(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", jk.n());
            jSONObject.put(bt.A, jk.l());
        } catch (Exception unused) {
        }
    }

    public static void nr(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(WkParams.IMEI, jk.n());
        } catch (JSONException unused) {
        }
    }

    private static String pn() {
        if (TextUtils.isEmpty(u)) {
            String strN = jk.n();
            if (!TextUtils.isEmpty(strN)) {
                u = x.nr(strN);
            }
        }
        return u;
    }

    public static void u(Context context, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.b.u.fx fxVarMy = jk.my();
            float longitude = 0.0f;
            float latitude = fxVarMy == null ? 0.0f : fxVarMy.getLatitude();
            if (fxVarMy != null) {
                longitude = fxVarMy.getLongitude();
            }
            jSONObject.put("latitude", latitude);
            jSONObject.put("longitude", longitude);
        } catch (JSONException unused) {
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayU = dw.u(context);
            if (jSONArrayU != null) {
                jSONObject.put("app_list", jSONArrayU);
            }
        } catch (JSONException unused) {
        }
    }

    public static void nr() {
        jk.my();
    }

    public static void fx() {
        com.bytedance.sdk.openadsdk.core.pb.fx.u().nr();
    }

    public static void u(com.bytedance.sdk.openadsdk.my.fx.fx.b bVar, List<String> list) {
        if (bVar.u()) {
            list.add(g.h);
            list.add(g.g);
        }
    }

    public static void u(JSONObject jSONObject, int i) {
        if (jk.my() != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r5.getLatitude());
                jSONObject2.put("longitude", r5.getLongitude());
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_GEO, jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static String u() {
        if (n.o().sx().b()) {
            return jk.a();
        }
        return null;
    }

    public static boolean u(String str) {
        return dw.u(str);
    }

    public static void u(Context context) {
        if ((com.bytedance.sdk.openadsdk.core.dw.nr().la() & 8) != 0) {
            return;
        }
        u.u(context);
    }
}

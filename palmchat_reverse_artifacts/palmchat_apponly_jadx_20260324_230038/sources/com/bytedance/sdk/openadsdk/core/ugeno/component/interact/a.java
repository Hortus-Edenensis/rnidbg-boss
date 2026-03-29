package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static void nr(bc bcVar, int i) {
        JSONObject jSONObject = new JSONObject();
        u(bcVar, jSONObject, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_start_render", jSONObject);
    }

    private static boolean u(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static void u(bc bcVar, int i) {
        JSONObject jSONObject = new JSONObject();
        u(bcVar, jSONObject, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_start_load", jSONObject);
    }

    public static void u(bc bcVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        u(bcVar, jSONObject, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_load_result", jSONObject);
    }

    public static void u(bc bcVar, boolean z, int i, Map<String, Object> map) {
        JSONObject jSONObjectU = jp.u(map);
        if (jSONObjectU == null) {
            jSONObjectU = new JSONObject();
        }
        try {
            jSONObjectU.put("success", z ? 1 : 0);
        } catch (JSONException unused) {
        }
        u(bcVar, jSONObjectU, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_render_result", jSONObjectU);
    }

    public static void u(bc bcVar, boolean z, int i, int i2, Map<String, Object> map) {
        JSONObject jSONObjectU = jp.u(map);
        if (jSONObjectU == null) {
            jSONObjectU = new JSONObject();
        }
        try {
            jSONObjectU.put("success", z ? 1 : 0);
            jSONObjectU.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        u(bcVar, jSONObjectU, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_show", jSONObjectU);
    }

    public static void u(bc bcVar, boolean z, int i, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("area_type", z ? 1 : 2);
            jSONObject.put("click_type", i2);
        } catch (JSONException unused) {
        }
        u(bcVar, jSONObject, i);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, "easy_play_click", jSONObject);
    }

    public static void u(bc bcVar, JSONObject jSONObject, int i) {
        if (bcVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_STYLE_ID, z.fx(bcVar));
            jSONObject.put("style_category", z.b(bcVar));
            jSONObject.put("component_type", i);
            if (z.iz(bcVar) != null) {
                jSONObject.put("render_sequence", z.iz(bcVar).u());
                jSONObject.put("display_area", z.iz(bcVar).fx());
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean u(View view, com.bytedance.sdk.component.adexpress.fx fxVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (fxVar instanceof q) {
                q qVar = (q) fxVar;
                return u(i, i2, width, height, qVar.u, qVar.nr);
            }
        }
        return false;
    }
}

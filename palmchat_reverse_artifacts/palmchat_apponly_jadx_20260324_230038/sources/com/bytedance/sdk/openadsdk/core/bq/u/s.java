package com.bytedance.sdk.openadsdk.core.bq.u;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc nr;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public s(com.bytedance.sdk.openadsdk.core.ja jaVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = new WeakReference<>(jaVar);
        this.nr = bcVar;
    }

    private JSONObject fx() {
        com.bytedance.sdk.openadsdk.core.ja jaVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference == null || (jaVar = weakReference.get()) == null || (context = jaVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.MAP_KEY_TOP, displayCutout.getSafeInsetTop());
            jSONObject.put("bottom", displayCutout.getSafeInsetBottom());
            jSONObject.put("left", displayCutout.getSafeInsetLeft());
            jSONObject.put("right", displayCutout.getSafeInsetRight());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("getDeviceInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new s(jaVar, bcVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", fx());
        com.bytedance.sdk.openadsdk.core.kj.bc bcVar = this.nr;
        if (bcVar != null) {
            jSONObject2.put("disableSafeArea", bcVar.x());
        }
        return jSONObject2;
    }
}

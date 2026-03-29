package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.ja;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static void u(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        ja jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.nr("notifyAdClicked", (JSONObject) null);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.iz uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.u("notifyAdClicked", (Map<String, String>) null);
        }
    }
}

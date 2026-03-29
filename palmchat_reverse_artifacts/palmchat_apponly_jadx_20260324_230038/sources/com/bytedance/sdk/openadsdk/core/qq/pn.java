package com.bytedance.sdk.openadsdk.core.qq;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static boolean u(String str, double d) {
        JSONObject jSONObjectJw = dw.nr().jw();
        if (jSONObjectJw != null && !TextUtils.isEmpty(str)) {
            try {
                double dOptDouble = jSONObjectJw.optDouble(str, d);
                if (dOptDouble >= 1.0d || dOptDouble < 0.0d || com.bytedance.sdk.openadsdk.core.s.fx.u.contains(str)) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.iz.nr.u((float) dOptDouble, false);
            } catch (Throwable th) {
                k.u("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}

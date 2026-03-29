package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class dw {
    private static long nr = -1;
    private static final String u = null;

    private static List<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(Context context) {
        try {
            List<String> listU = com.bytedance.sdk.openadsdk.core.pb.fx.u().u(context);
            if (listU != null && !listU.isEmpty()) {
                List<String> listB = b(com.bytedance.sdk.openadsdk.core.nr.u().get("install_app_string", u));
                nr(u(listU));
                if (listB != null && !listB.isEmpty()) {
                    listU.removeAll(listB);
                }
                fx(u(listU));
            }
        } catch (Exception unused) {
        }
    }

    public static JSONArray u(final Context context) {
        if (System.currentTimeMillis() - nr <= 1000) {
            return null;
        }
        nr = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.pb.n.b() || !nr() || !com.bytedance.sdk.openadsdk.core.dw.nr().bl() || !com.bytedance.sdk.openadsdk.core.n.o().sx().nr()) {
            return null;
        }
        com.bytedance.sdk.component.jk.x.u(new com.bytedance.sdk.component.jk.a("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.y.dw.1
            @Override // java.lang.Runnable
            public void run() {
                dw.fx(context);
            }
        }, 1);
        return u();
    }

    private static void nr(String str) {
        com.bytedance.sdk.openadsdk.core.nr.u().put("install_app_string", str);
    }

    private static boolean nr() {
        long j = com.bytedance.sdk.openadsdk.core.nr.u().get("apptime", -1L);
        return j == -1 || System.currentTimeMillis() - j > com.heytap.mcssdk.constant.a.g;
    }

    private static void fx(String str) {
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        fxVarU.put("install_app_incremental_string", str);
        fxVarU.put("apptime", System.currentTimeMillis());
    }

    private static JSONArray u() {
        try {
            String str = com.bytedance.sdk.openadsdk.core.nr.u().get("install_app_incremental_string", u);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONArray((Collection) b(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String u(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            u(0, 0, null);
            return false;
        }
        if (jp.nr(com.bytedance.sdk.openadsdk.core.dw.getContext()) && !jp.fx(com.bytedance.sdk.openadsdk.core.dw.getContext(), str)) {
            u(0, 0, null);
        }
        return false;
    }

    private static void u(final int i, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.core.qq.nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.dw.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i);
                    jSONObject.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("call_active_api").nr(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}

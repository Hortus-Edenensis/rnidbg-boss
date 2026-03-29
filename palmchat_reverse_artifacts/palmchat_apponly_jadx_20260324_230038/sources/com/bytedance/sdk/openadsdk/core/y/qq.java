package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.pn;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qq {
    private static volatile boolean b = false;
    private static volatile boolean fx = false;
    private static volatile String nr = "";
    private static volatile String u = "";

    public static String fx(com.bytedance.sdk.openadsdk.k.b bVar) {
        if (bVar == null) {
            return null;
        }
        String type = bVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, WkAdConfigModel.TAG_TIMEOUT)) {
            return WkAdConfigModel.TAG_TIMEOUT;
        }
        pn.u uVarU = bVar.u();
        return (uVarU == null || TextUtils.isEmpty(uVarU.u)) ? "error" : uVarU.u;
    }

    public static String nr(com.bytedance.sdk.openadsdk.k.b bVar) {
        JSONObject jSONObjectU;
        if (bVar != null) {
            String type = bVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, WkAdConfigModel.TAG_TIMEOUT)) {
                return WkAdConfigModel.TAG_TIMEOUT;
            }
            pn.u uVarU = bVar.u();
            if (uVarU != null && !TextUtils.isEmpty(uVarU.u) && (jSONObjectU = u(uVarU)) != null) {
                return jSONObjectU.toString();
            }
        }
        return "error";
    }

    public static void u(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            fx = true;
            u = str;
            com.bytedance.sdk.openadsdk.tools.nr.nr(7, u == null ? "" : u);
            b = false;
            update(false);
        } catch (Throwable unused) {
        }
    }

    private static void update(boolean z) {
        if (TextUtils.isEmpty(u)) {
            return;
        }
        String strNr = com.bytedance.sdk.component.utils.u.nr(u);
        com.bytedance.sdk.openadsdk.core.fx.b.u().b("app_log_oaid", u);
        com.bytedance.sdk.openadsdk.core.fx.b.u().b("new_app_log_oaid", strNr);
        com.bytedance.sdk.openadsdk.core.fx.b.u().u("is_use_dev_oaid", z);
    }

    public static void u(com.bytedance.sdk.openadsdk.k.b bVar) {
        com.bytedance.sdk.openadsdk.u.u.u.u(bVar);
        com.bytedance.sdk.openadsdk.core.live.nr.u().u(bVar);
    }

    public static pn.u fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new pn.u(str, false, u(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(u(com.bytedance.sdk.openadsdk.core.dw.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    private static JSONObject u(pn.u uVar) {
        if (uVar == null) {
            return null;
        }
        String str = uVar.u;
        long j = uVar.fx;
        boolean z = uVar.nr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void nr() {
        b = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("is_use_dev_oaid", false);
    }

    private static int u(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String u(boolean z) {
        long j;
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        if (z && !TextUtils.isEmpty(nr)) {
            return nr;
        }
        try {
            String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(strFx)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strFx);
                nr = com.bytedance.sdk.component.utils.u.fx(jSONObject.getString(ActionUtils.PAYMENT_AMOUNT));
                j = jSONObject.getLong("time");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(nr) && (z || System.currentTimeMillis() - j < 86400000)) {
            nr();
            return nr;
        }
        if (!fx) {
            com.bytedance.sdk.openadsdk.core.iz.u().nr();
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarBq = com.bytedance.sdk.openadsdk.core.n.o().bq();
            if (bVarBq != null && !TextUtils.isEmpty(bVarBq.l())) {
                u = bVarBq.l();
                boolean z2 = !TextUtils.isEmpty(bVarBq.l());
                b = z2;
                update(z2);
            }
            com.bytedance.sdk.openadsdk.tools.nr.nr(7, u == null ? "" : u);
        }
        return u == null ? "" : u;
    }

    public static int u() {
        return b ? 1 : 0;
    }
}

package com.bytedance.sdk.openadsdk.core.n;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static String fx;
    private static volatile String nr;
    private static volatile String u;

    public static String b() {
        return jp.t();
    }

    public static String fx() {
        return "7.2.3.2";
    }

    public static String iz() {
        return o.x(dw.getContext());
    }

    public static String n() {
        if (!TextUtils.isEmpty(fx)) {
            return fx;
        }
        String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("app_sha1", 2592000000L);
        fx = strFx;
        if (!TextUtils.isEmpty(strFx)) {
            return fx;
        }
        String strU = com.bytedance.sdk.component.utils.fx.u(dw.getContext());
        fx = strU;
        if (u(strU)) {
            fx = fx.toUpperCase(Locale.getDefault());
            com.bytedance.sdk.openadsdk.core.fx.b.u().b("app_sha1", fx);
            return fx;
        }
        return "";
    }

    public static String nr() {
        return "1371";
    }

    public static String pn() {
        return n.o().q();
    }

    public static String u() {
        return "open_news";
    }

    public static String x() {
        return sx.fx();
    }

    public static int fx(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static String nr(Context context) {
        if (nr != null) {
            return nr;
        }
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            nr = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return nr;
    }

    public static String u(Context context) {
        if (u != null) {
            return u;
        }
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.keySet() != null) {
            for (String str : bundle.keySet()) {
                if (str != null && str.toLowerCase().contains("channel")) {
                    Object obj = bundle.get(str);
                    jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                }
            }
        }
        u = jSONObject.toString();
        return u;
    }

    private static boolean u(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(":")) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }
}

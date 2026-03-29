package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import com.baidu.location.LocationConst;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.igexin.push.core.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fv2 {
    public static void a(String str, String str2) {
        f5.c().a(str, str2);
    }

    public static JSONObject b(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", mg5.b(context));
            jSONObject.put("type", str);
            jSONObject.put("account_id", lg5.c(context, zz2.D()));
        } catch (JSONException e) {
            k63.l("JBridgeHelper", "fillBase exception:" + e);
        }
        return jSONObject;
    }

    public static String c(Context context) {
        return (String) lg5.c(context, zz2.D());
    }

    public static Object d() {
        return f5.b();
    }

    public static String e(Context context) {
        return m50.d(context);
    }

    public static String f(Context context) {
        return m50.c(context);
    }

    public static String g(Context context) {
        return (String) lg5.c(context, zz2.n());
    }

    public static int h(Context context) {
        return ((Integer) lg5.c(context, zz2.F())).intValue();
    }

    public static String i(Context context) {
        return (String) lg5.f(context, zz2.E());
    }

    public static String j(Context context) {
        return (String) lg5.c(context, zz2.H());
    }

    public static String k(Context context) {
        return (String) lg5.c(context, zz2.I());
    }

    public static Object l(Context context) {
        HashMap map = new HashMap();
        String str = (String) lg5.c(context, zz2.z());
        long jLongValue = ((Long) lg5.c(context, zz2.A())).longValue();
        int iIntValue = ((Integer) lg5.c(context, zz2.y())).intValue();
        map.put(Constant.MAP_KEY_UUID, str);
        map.put("ct", Long.valueOf(jLongValue));
        map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, Integer.valueOf(iIntValue));
        return map;
    }

    public static int m(Context context) {
        return ((Integer) lg5.c(context, zz2.y())).intValue();
    }

    public static long n(Context context) {
        return ((Long) lg5.c(context, zz2.K())).longValue();
    }

    public static synchronized void o(Context context) {
        try {
            if (tv2.g && (context instanceof Application)) {
                String strI = ad.i(context);
                String packageName = context.getPackageName();
                if (strI == null || packageName == null || !context.getPackageName().equals(strI)) {
                    k63.a("JBridgeHelper", "need not registerActivityLifecycleCallbacks in other process :" + strI);
                } else {
                    tv2.g = false;
                    ((Application) context).registerActivityLifecycleCallbacks(new o5());
                    k63.a("JBridgeHelper", "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + strI);
                }
            }
        } finally {
        }
    }

    public static JSONObject p(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                k63.a("JBridgeHelper", "file_name is null , give up read ");
                return null;
            }
            String strI = hv1.i(hv1.e(context, str));
            if (!nl5.i(strI)) {
                return new JSONObject(strI.trim());
            }
            k63.a("JBridgeHelper", "read String is empty");
            return null;
        } catch (Throwable th) {
            k63.a("JBridgeHelper", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static void q(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCore", 14, null, null, obj);
    }

    public static void r(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    JCoreManager.onEvent(context, "JCore", 3, "asm", intent.getExtras(), new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                k63.l("JBridgeHelper", "shareActionRun error:" + th.getMessage());
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shareActionRun intent error:");
        sb.append(intent == null ? b.m : intent.getAction());
        k63.a("JBridgeHelper", sb.toString());
    }
}

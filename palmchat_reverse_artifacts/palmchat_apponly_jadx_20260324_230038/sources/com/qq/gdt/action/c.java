package com.qq.gdt.action;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.lantern.core.configuration.ConfigConstant;
import com.qq.gdt.action.ActionParam;
import com.qq.gdt.action.a.a;
import com.qq.gdt.action.e.d;
import com.qq.gdt.action.j.h;
import com.qq.gdt.action.j.i;
import com.qq.gdt.action.j.m;
import com.qq.gdt.action.j.n;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.p;
import com.qq.gdt.action.j.r;
import com.qq.gdt.action.j.t;
import com.qq.gdt.action.j.u;
import com.qq.gdt.action.j.v;
import com.qq.gdt.action.j.x;
import com.qq.gdt.action.j.y;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Locale;
import javax.crypto.SecretKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10466a;

    public static com.qq.gdt.action.c.a a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectD = d(jSONObject, d.a().g());
        com.qq.gdt.action.c.a aVar = new com.qq.gdt.action.c.a(d.a().n(), com.qq.gdt.action.j.b.b(str), System.currentTimeMillis(), jSONObjectD, d.a().o());
        com.qq.gdt.action.h.a.a(4000, aVar);
        return aVar;
    }

    public static String b(String str) {
        String strA = u.a(str);
        String strJ = d.a().j();
        String strA2 = i.a(d.a().l().getEncoded());
        return r.a(strA + "," + strA2 + "," + u.a(strA + strJ + strA2));
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        Context contextG = d.a().g();
        jSONObject.putOpt("gdt_traceid", t.g(contextG) ? "" : d.a().b(contextG));
        jSONObject.putOpt(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, t.h(contextG) ? "" : d.a().c(contextG));
    }

    private static JSONObject d(JSONObject jSONObject, Context context) {
        if (context != null) {
            try {
                if (b.a(context).z()) {
                    if (TextUtils.isEmpty(f10466a)) {
                        JSONObject jSONObjectY = d.a().y();
                        if (n.a(jSONObjectY)) {
                            return jSONObject;
                        }
                        f10466a = jSONObjectY.toString();
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.putOpt("ylhExt", f10466a);
                    long jC = t.c(context);
                    if (jC > 0) {
                        jSONObject.put("ams_reserved_last_revised_activate_time", jC);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private static void e(JSONObject jSONObject) {
        try {
            a.C0834a c0834aB = com.qq.gdt.action.a.a.b(d.a().g());
            if (jSONObject != null) {
                jSONObject.putOpt("native_oaid", c0834aB.a());
                jSONObject.putOpt("is_oaid_track_limited", Boolean.valueOf(c0834aB.b()));
            }
        } catch (Throwable unused) {
            o.a("appendOpenDeviceIdentifier err", new Object[0]);
        }
    }

    public static String a(String str) {
        String strA = u.a(str);
        String strH = d.a().h();
        String strI = d.a().i();
        String strA2 = i.a(d.a().k().getEncoded());
        return r.a(strA + "," + strA2 + "," + u.a(strA + strH + strI + strA2));
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        jSONObject.putOpt("install_package_time", h.g(d.a().g()));
    }

    private static void c(JSONObject jSONObject, Context context) throws JSONException {
        d.a aVarE = h.e(context);
        jSONObject.putOpt("hash_android_id", aVarE.j);
        jSONObject.putOpt("uuid_standard", aVarE.k);
        jSONObject.putOpt("ua_standard", d.a().x());
    }

    private static void d(JSONObject jSONObject) throws JSONException {
        int iB = e.b();
        jSONObject.putOpt("sdkv", e.a());
        jSONObject.putOpt("sdkvc", Integer.valueOf(iB));
        jSONObject.putOpt("report_session_id", d.a().n());
    }

    public static String a(JSONObject jSONObject) throws Exception {
        return a(jSONObject, d.a().k());
    }

    private static void b(JSONObject jSONObject, Context context) throws JSONException {
        String strA = com.qq.gdt.action.e.b.a();
        Object language = Locale.getDefault().getLanguage();
        Object obj = Build.VERSION.RELEASE;
        Object objE = h.e();
        Object objA = p.a();
        int i = Build.VERSION.SDK_INT;
        m.a(jSONObject);
        jSONObject.putOpt(LiveConfigKey.MEDIUM, strA);
        jSONObject.putOpt("lg", language);
        jSONObject.putOpt("os", AnalyticsConstants.SDK_TYPE);
        jSONObject.putOpt("osv", obj);
        jSONObject.putOpt(ConfigConstant.COLUMN_OP, objE);
        jSONObject.putOpt("apil", Integer.valueOf(i));
        jSONObject.putOpt("dn", objA);
        jSONObject.putOpt("tz", h.f());
        try {
            if (b.a(context).B() || !d.a().B()) {
                return;
            }
            jSONObject.putOpt("acaid", com.qq.gdt.action.e.a.b.a(strA).a());
        } catch (Throwable th) {
            o.b("getAnid error: ", th);
        }
    }

    public static String a(JSONObject jSONObject, SecretKey secretKey) throws Exception {
        return com.qq.gdt.action.j.a.a(secretKey, y.a(jSONObject.toString().getBytes()));
    }

    public static JSONArray a(List<com.qq.gdt.action.c.a> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (com.qq.gdt.action.c.a aVar : list) {
            jSONArray.put(a(aVar));
            com.qq.gdt.action.h.a.a(9001, aVar);
        }
        return jSONArray;
    }

    public static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context contextG = d.a().g();
        c(jSONObject, contextG);
        b(jSONObject, contextG);
        a(jSONObject, contextG);
        d(jSONObject);
        c(jSONObject);
        b(jSONObject);
        e(jSONObject);
        jSONObject.putOpt("conf_version", b.a(contextG).a());
        x.a(jSONObject, contextG);
        jSONObject.putOpt("ak", d.a().i());
        return jSONObject;
    }

    private static JSONObject a(com.qq.gdt.action.c.a aVar) throws JSONException {
        if (aVar == null) {
            return null;
        }
        if (v.a(aVar.c())) {
            o.b("ActionType must not be empty.");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("session_id", aVar.g());
        jSONObject.putOpt("action_time", Long.valueOf(aVar.d() / 1000));
        jSONObject.putOpt("action_time_mills", Long.valueOf(aVar.d()));
        jSONObject.putOpt("action_type", aVar.c());
        jSONObject.putOpt("revised_action_time", Long.valueOf(aVar.h()));
        jSONObject.putOpt("retry", Boolean.valueOf(aVar.i() == 2));
        jSONObject.putOpt("action_id", aVar.a());
        jSONObject.putOpt("action_log_id", Long.valueOf(aVar.b()));
        JSONObject jSONObjectE = aVar.e();
        if (jSONObjectE != null && jSONObjectE.has(ActionParam.Key.OUTER_ACTION_ID)) {
            jSONObject.putOpt(ActionParam.Key.OUTER_ACTION_ID, jSONObjectE.optString(ActionParam.Key.OUTER_ACTION_ID));
            jSONObjectE.remove(ActionParam.Key.OUTER_ACTION_ID);
        }
        jSONObject.putOpt("action_param", jSONObjectE);
        if (ActionType.START_APP.equals(aVar.c())) {
            Context contextG = d.a().g();
            JSONObject jSONObject2 = new JSONObject();
            try {
                long jD = t.d(contextG);
                long jE = t.e(contextG);
                long jC = t.c(contextG);
                boolean zA = t.a(contextG);
                boolean zB = t.b(contextG);
                if (jD > 0) {
                    jSONObject2.putOpt("ams_reserved_last_start_time", Long.valueOf(jD));
                }
                if (jE > 0) {
                    jSONObject2.putOpt("ams_reserved_last_revised_start_time", Long.valueOf(jE));
                }
                if (jC > 0) {
                    jSONObject2.putOpt("ams_reserved_last_revised_activate_time", Long.valueOf(jC));
                }
                jSONObject2.putOpt("ams_reserved_last_revised_with_imei", Boolean.valueOf(zA));
                jSONObject2.putOpt("ams_reserved_last_revised_with_oaid", Boolean.valueOf(zB));
            } catch (JSONException e) {
                o.a("JSON exception while add last start time info.", e);
            }
            jSONObject.putOpt("inner_action_param", jSONObject2);
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, Context context) throws JSONException {
        String strD = h.d();
        String strC = h.c(context);
        String strA = h.a(context);
        int iB = h.b(context);
        jSONObject.putOpt("pkg_name", strD);
        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, d.a().r());
        jSONObject.putOpt("appn", strC);
        jSONObject.putOpt("app_version_name", strA);
        jSONObject.putOpt("gk", com.qq.gdt.action.j.d.f());
        jSONObject.putOpt(Constants.EXTRA_KEY_APP_VERSION_CODE, String.valueOf(iB));
        jSONObject.putOpt("channel", d.a().s());
        jSONObject.putOpt("channel_id", d.a().t());
        jSONObject.putOpt("user_unique_id", d.a().u());
        try {
            if (!b.a(context).A()) {
                String strA2 = com.qq.gdt.action.b.b.a(context);
                String strB = com.qq.gdt.action.b.b.b(context);
                jSONObject.putOpt("channel_id_inner", strA2);
                jSONObject.putOpt(AdBaseConstants.MARKET_OPEN_CLICK_ID, strB);
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject.put("install_time", packageInfo.firstInstallTime);
            jSONObject.put("update_time", packageInfo.lastUpdateTime);
        } catch (PackageManager.NameNotFoundException unused) {
            o.a("getPackageInfo err", new Object[0]);
        }
    }
}

package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.u.nr.x.nr;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.hj7;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class il7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile JSONObject f18197a;

    public static String a() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    public static JSONObject b(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (f18197a == null) {
            Context contextB = uh7.b();
            try {
                JSONObject jSONObject2 = new JSONObject();
                f18197a = jSONObject2;
                jSONObject2.put("os", AnalyticsConstants.SDK_TYPE);
                f18197a.put("platform", AnalyticsConstants.SDK_TYPE);
                f18197a.put("sdk_lib", AnalyticsConstants.SDK_TYPE);
                f18197a.put("os_version", a());
                f18197a.put("os_api", Build.VERSION.SDK_INT);
                f18197a.put("use_apm_sdk", "1");
                f18197a.put("sdk_version", 138);
                f18197a.put("sdk_version_code", 138);
                f18197a.put("sdk_version_name", "0.0.1-alpha.18-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                f18197a.put("device_model", str);
                f18197a.put(bt.F, str2);
                f18197a.put(bt.H, Build.MANUFACTURER);
                if (map != null) {
                    f18197a.put("aid", String.valueOf(map.get("aid")));
                    f18197a.put("app_version", map.get("app_version"));
                    f18197a.put("version_code", map.get("version_code"));
                    f18197a.put("update_version_code", map.get("update_version_code"));
                    f18197a.put("manifest_version_code", map.get("version_code"));
                    f18197a.put("channel", map.get("channel"));
                }
                f18197a.put("bd_did", uh7.c().a());
                f18197a.put("package", contextB.getPackageName());
                f18197a.put(bt.s, contextB.getApplicationInfo().name);
                d(f18197a);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", f18197a);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    public static void c(li7 li7Var) {
        Map<String, Object> mapE = uh7.j().e();
        if (mapE == null && mapE.get("aid") == null) {
            return;
        }
        try {
            nr.i(new hj7.a().a(nr.b(mapE) + "?device_platform=android&version_code=138&iid=iid&aid=" + mapE.get("aid")).b(true).c(b(mapE).toString().getBytes("UTF-8")).d());
        } catch (Throwable unused) {
        }
    }

    public static void d(JSONObject jSONObject) {
        Map<String, Object> mapC;
        Object obj;
        fl7 fl7VarJ = uh7.j();
        if (fl7VarJ == null || jSONObject == null || (mapC = fl7VarJ.c()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapC.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapC.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        } catch (Exception e) {
            mf7.a(e);
        }
    }
}

package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<Object> f19627a = new ConcurrentLinkedQueue<>();

    public static int a(int i, String... strArr) {
        return gg7.a(d(), i, strArr);
    }

    public static int b(String... strArr) {
        return gg7.a(d(), -1, strArr);
    }

    public static String c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("npth");
    }

    public static JSONObject d() {
        return ca7.e(x97.a().g());
    }

    public static JSONObject e(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i).optJSONObject(str);
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject;
                }
            }
        }
        return null;
    }

    public static void f(JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        kj7.c("apmconfig", "fromnet " + z + " : " + jSONArray);
        if (z) {
            ef7.i();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String next = jSONObjectOptJSONObject.keys().next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                kj7.a("update config " + next + " : " + jSONObjectOptJSONObject2);
                ca7.b(next, jSONObjectOptJSONObject2);
                if (z) {
                    ef7.a(next);
                }
            } catch (Throwable unused) {
            }
        }
        xf7.a(e(jSONArray, String.valueOf(x97.a().g())));
        if (z) {
            ef7.b(false, jSONArray);
        }
    }

    public static boolean g(String str) {
        if (!ca7.d(str)) {
            jv6.b();
        }
        return ca7.j(str);
    }

    public static boolean h() {
        return cg7.r();
    }

    public static boolean i(String str) {
        if (!ca7.d(str)) {
            jv6.b();
        }
        return ca7.m(str);
    }

    public static JSONArray j() {
        return gg7.c(d(), "custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore");
    }

    public static boolean k(String str) {
        if (!ca7.d(str)) {
            jv6.b();
        }
        return ca7.l(str);
    }

    public static boolean l() {
        return b("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean m() {
        return b("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    public static boolean n() {
        return b("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    public static boolean o() {
        return b("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    public static boolean p() {
        return b("custom_event_settings", "npth_simple_setting", "enable_killed_anr") == 1;
    }

    public static boolean q() {
        return b("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }
}

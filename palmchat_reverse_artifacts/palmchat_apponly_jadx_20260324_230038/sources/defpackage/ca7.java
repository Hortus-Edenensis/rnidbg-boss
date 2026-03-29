package defpackage;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ca7 {
    public static HashMap<String, ca7> e = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f1937a = null;
    public JSONObject b = null;
    public boolean c = false;
    public String d;

    public ca7(JSONObject jSONObject, String str) {
        this.d = str;
        c(jSONObject);
        e.put(this.d, this);
        kj7.a("after update aid " + str);
    }

    public static void b(String str, JSONObject jSONObject) {
        ca7 ca7Var = e.get(str);
        if (ca7Var != null) {
            ca7Var.c(jSONObject);
        } else {
            new ca7(jSONObject, str);
        }
    }

    public static boolean d(String str) {
        return e.get(str) != null;
    }

    public static JSONObject e(String str) {
        ca7 ca7Var = e.get(str);
        if (ca7Var != null) {
            return ca7Var.a();
        }
        return null;
    }

    public static long g(String str) {
        ca7 ca7Var = e.get(str);
        if (ca7Var == null) {
            return 3600000L;
        }
        try {
            return Long.decode(gg7.i(ca7Var.a(), "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean j(String str) {
        ca7 ca7Var = e.get(str);
        return ca7Var != null && ca7Var.f() && ca7Var.k();
    }

    public static boolean l(String str) {
        ca7 ca7Var = e.get(str);
        return ca7Var != null && ca7Var.h() && ca7Var.k();
    }

    public static boolean m(String str) {
        ca7 ca7Var = e.get(str);
        return ca7Var != null && ca7Var.i() && ca7Var.k();
    }

    public static boolean n(String str) {
        ca7 ca7Var = e.get(str);
        return ca7Var == null || ca7Var.k();
    }

    public JSONObject a() {
        return this.f1937a;
    }

    public final void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.f1937a = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.c = jSONObjectOptJSONObject.optInt("switcher") == 1 && jSONObjectOptJSONObject.optInt("err_sampling_rate") == 1;
    }

    public boolean f() {
        JSONObject jSONObject = this.f1937a;
        return jSONObject != null && 1 == gg7.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean h() {
        JSONObject jSONObject = this.f1937a;
        return jSONObject != null && 1 == gg7.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean i() {
        JSONObject jSONObject = this.f1937a;
        return jSONObject != null && 1 == gg7.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean k() {
        try {
            JSONObject jSONObject = this.f1937a;
            if (jSONObject != null) {
                return jSONObject.optInt("status") == 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}

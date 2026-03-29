package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ev6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f17368a;
    public q37 b;

    public ev6() {
        this.f17368a = new JSONObject();
    }

    public static boolean B(String str) {
        return z77.c(str) > 350;
    }

    public static void k(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            try {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put(str, jSONObjectOptJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        jSONObjectOptJSONObject.put(str2, str3);
    }

    public static void l(JSONObject jSONObject, Throwable th) {
        String str = "npth_err_info";
        if (jSONObject.opt("npth_err_info") != null) {
            for (int i = 0; i < 5; i++) {
                if (jSONObject.opt("npth_err_info" + i) == null) {
                    try {
                        str = "npth_err_info" + i;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
            return;
        }
        jSONObject.put(str, yl7.b(th));
    }

    public static void m(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put("storage", jSONObject2);
        } catch (Throwable unused) {
        }
        long jOptLong = jSONObject2.optLong("inner_free");
        long jOptLong2 = jSONObject2.optLong("sdcard_free");
        long jOptLong3 = jSONObject2.optLong("inner_free_real");
        String str = "1M - 64M";
        String str2 = jOptLong <= 1024 ? "0 - 1K" : jOptLong <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? "1K - 64K" : jOptLong <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "64K - 512K" : jOptLong <= 1048576 ? "512K - 1M" : jOptLong <= 67108864 ? "1M - 64M" : "64M - ";
        String str3 = jOptLong3 <= 1024 ? "0 - 1K" : jOptLong3 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? "1K - 64K" : jOptLong3 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "64K - 512K" : jOptLong3 <= 1048576 ? "512K - 1M" : jOptLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        if (jOptLong2 <= 1024) {
            str = "0 - 1K";
        } else if (jOptLong2 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            str = "1K - 64K";
        } else if (jOptLong2 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            str = "64K - 512K";
        } else if (jOptLong2 <= 1048576) {
            str = "512K - 1M";
        } else if (jOptLong2 > 67108864) {
            str = "64M - ";
        }
        k(jSONObject, "filters", "inner_free", str2);
        k(jSONObject, "filters", "inner_free_real", str3);
        k(jSONObject, "filters", "sdcard_free", str);
    }

    public static boolean p(String str) {
        return wi7.n(str).exists();
    }

    public static void u(JSONObject jSONObject, JSONObject jSONObject2) {
        Object objOpt;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt2 = jSONObject.opt(next);
                if (objOpt2 == null) {
                    objOpt = jSONObject2.opt(next);
                } else {
                    if (objOpt2 instanceof JSONObject) {
                        jSONObject3 = jSONObject.getJSONObject(next);
                        jSONObject4 = jSONObject2.getJSONObject(next);
                    } else if (objOpt2 instanceof JSONArray) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            JSONArray jSONArray = (JSONArray) objOpt2;
                            if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (jSONArrayOptJSONArray.opt(0) instanceof JSONObject)) {
                                jSONObject3 = jSONArray.getJSONObject(0);
                                jSONObject4 = jSONArrayOptJSONArray.getJSONObject(0);
                            } else {
                                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    jSONArray.put(jSONArrayOptJSONArray.get(i));
                                }
                            }
                        }
                    } else {
                        objOpt = jSONObject2.opt(next);
                    }
                    u(jSONObject3, jSONObject4);
                }
                jSONObject.put(next, objOpt);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean v(String str) {
        return ((long) z77.d(str)) > w37.u();
    }

    public static boolean z(String str) {
        return z77.a(str) > 960;
    }

    public boolean A() {
        return z(x97.l());
    }

    public JSONObject C(String str) {
        Object objOpt = G().opt("data");
        JSONObject jSONObjectOptJSONObject = objOpt instanceof JSONArray ? ((JSONArray) objOpt).optJSONObject(0) : G();
        if (jSONObjectOptJSONObject == null) {
            return new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2;
        }
        JSONObject jSONObject = new JSONObject();
        j(str, jSONObject);
        return jSONObject;
    }

    public boolean D() {
        return B(x97.l());
    }

    public boolean E() {
        return v(x97.l());
    }

    public boolean F() {
        return p(x97.l());
    }

    public JSONObject G() {
        return this.f17368a;
    }

    public q37 H() {
        if (this.b == null) {
            q37 q37Var = new q37(x97.m());
            this.b = q37Var;
            d(q37Var);
        }
        return this.b;
    }

    public ev6 a(int i, String str) {
        try {
            this.f17368a.put("miniapp_id", i);
            this.f17368a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ev6 b(long j) {
        try {
            j("app_start_time", Long.valueOf(j));
            j("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public ev6 c(nz6 nz6Var) {
        j("activity_trace", nz6Var.J());
        f("activity_track", nz6Var.N());
        return this;
    }

    public ev6 d(q37 q37Var) {
        j("header", q37Var.s());
        this.b = q37Var;
        return this;
    }

    public ev6 e(String str, String str2) {
        Object objOpt = G().opt("data");
        k(objOpt instanceof JSONArray ? ((JSONArray) objOpt).optJSONObject(0) : G(), "filters", str, str2);
        return this;
    }

    public ev6 f(String str, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject = G().optJSONObject("custom_long");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            j("custom_long", jSONObjectOptJSONObject);
        }
        try {
            jSONObjectOptJSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
        return this;
    }

    public ev6 g(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            j("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        j("patch_info", jSONArray);
        return this;
    }

    public ev6 h(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f17368a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f17368a.put("plugin_info", jSONArray);
        return this;
    }

    public ev6 i(JSONObject jSONObject) {
        j("header", jSONObject);
        return this;
    }

    public void j(String str, Object obj) {
        try {
            this.f17368a.put(str, obj);
        } catch (Exception e) {
            kj7.g(e);
        }
    }

    public boolean o() {
        return G().opt("data") instanceof JSONArray ? !gg7.h(((JSONArray) r0).optJSONObject(0), "logcat") : !gg7.h(this.f17368a, "logcat");
    }

    public ev6 q(String str, String str2) {
        Object objOpt = G().opt("data");
        k(objOpt instanceof JSONArray ? ((JSONArray) objOpt).optJSONObject(0) : G(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str, str2);
        return this;
    }

    public ev6 r(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    kj7.g(e);
                }
            }
            try {
                this.f17368a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public ev6 s(JSONObject jSONObject) {
        n(this.f17368a, jSONObject);
        return this;
    }

    public void t() {
        e("has_logcat", String.valueOf(o()));
    }

    public ev6 w(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObjectC = C("filters");
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                try {
                    jSONObjectC.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            j("filters", jSONObjectC);
        }
        return this;
    }

    public void x() {
        e("is_64_devices", String.valueOf(q37.f()));
        e("is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
        e("is_x86_devices", String.valueOf(q37.j()));
    }

    public void y(JSONObject jSONObject) {
        u(this.f17368a, jSONObject);
    }

    public ev6(JSONObject jSONObject) {
        this.f17368a = jSONObject;
    }
}

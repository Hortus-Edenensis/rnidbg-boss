package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.umeng.analytics.pro.f;
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
/* JADX INFO: loaded from: classes7.dex */
public class ql7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f20276a;

    public ql7() {
        this.f20276a = new JSONObject();
    }

    public static ql7 g(long j, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        ql7 ql7Var = new ql7();
        ql7Var.n("isJava", 1);
        ql7Var.n("event_type", "java_crash");
        ql7Var.n("timestamp", Long.valueOf(System.currentTimeMillis()));
        ql7Var.n("data", tj7.d(th));
        ql7Var.n("isOOM", Boolean.valueOf(tj7.c(th)));
        ql7Var.n("crash_time", Long.valueOf(j));
        ql7Var.n(ContentProviderManager.PLUGIN_PROCESS_NAME, sl7.a(context));
        if (!sl7.e(context)) {
            ql7Var.n("remote_process", 1);
        }
        sl7.i(context, ql7Var.d());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            ql7Var.n("crash_thread_name", name);
        }
        ql7Var.n("all_thread_stacks", tj7.g(name));
        return ql7Var;
    }

    public ql7 a(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException unused) {
                }
            }
            n("filters", jSONObject);
        }
        return this;
    }

    public ql7 b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        n("logcat", jSONArray);
        return this;
    }

    public ql7 c(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    mf7.a(e);
                }
            }
            try {
                this.f20276a.put("sdk_info", jSONObject);
            } catch (JSONException unused) {
            }
        }
        return this;
    }

    public JSONObject d() {
        return this.f20276a;
    }

    public ql7 e(int i, String str) {
        try {
            this.f20276a.put("miniapp_id", i);
            this.f20276a.put("miniapp_version", str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public ql7 f(long j) {
        try {
            n(f.p, Long.valueOf(j));
            n("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception unused) {
        }
        return this;
    }

    public ql7 h(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            n("session_id", str);
        }
        return this;
    }

    public ql7 i(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            n("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        n("patch_info", jSONArray);
        return this;
    }

    public ql7 j(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f20276a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f20276a.put("plugin_info", jSONArray);
        return this;
    }

    public ql7 k(oi7 oi7Var) {
        n("header", oi7Var.j());
        return this;
    }

    public ql7 l(ui7 ui7Var) {
        n("activity_trace", ui7Var.x());
        n("running_tasks", ui7Var.p());
        return this;
    }

    public ql7 m(JSONObject jSONObject) {
        n("storage", jSONObject);
        return this;
    }

    public void n(@NonNull String str, @Nullable Object obj) {
        try {
            this.f20276a.put(str, obj);
        } catch (Exception e) {
            mf7.a(e);
        }
    }

    public ql7(JSONObject jSONObject) {
        this.f20276a = jSONObject;
    }
}

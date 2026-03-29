package com.bytedance.sdk.openadsdk.core.fx;

import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private volatile String iz;
    public String u;
    private volatile String x;
    private volatile int fx = -1;
    private volatile long b = -1;
    private volatile float pn = -1.0f;
    private volatile int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f5282a = -1;
    private volatile int jk = -1;
    private volatile int t = -1;
    private volatile int l = 0;
    private volatile int mv = -1;
    private volatile int s = -1;
    private volatile int k = -1;
    private volatile SharedPreferences nr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), sx(), 0);

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static pn u = new pn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sx() {
        return "sp_exec_getad_config_bst";
    }

    public int k() {
        if (this.k == -1) {
            this.k = u("splash_policy", 0);
        }
        return this.k;
    }

    public void my() {
        try {
            SharedPreferences.Editor editorEdit = this.nr.edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public boolean jk() {
        return u("is_spl_cache_remove_change", false);
    }

    public int l() {
        if (this.jk == -1) {
            this.jk = u("spl_thread_conf", 1);
        }
        return this.jk;
    }

    public int mv() {
        if (this.t == -1) {
            this.t = u("spl_common_conf", 0);
        }
        return this.t;
    }

    public int s() {
        if (this.l <= 0) {
            this.l = u("splash_render_timeout_backup", 100);
        }
        return this.l;
    }

    public int t() {
        if (this.n == -1) {
            this.n = u("spl_cache_conf", 14);
        }
        return this.n;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private Map<String, Object> u = new HashMap();

        public nr b(int i) {
            if (pn.u().jk == i) {
                return this;
            }
            pn.u().jk = i;
            this.u.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public nr fx(int i) {
            if (pn.u().n == i) {
                return this;
            }
            pn.u().n = i;
            this.u.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public nr iz(int i) {
            if (pn.u().f5282a == i) {
                return this;
            }
            pn.u().f5282a = i;
            this.u.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public nr n(int i) {
            if (pn.u().mv == i) {
                return this;
            }
            pn.u().mv = i;
            this.u.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public nr nr(String str) {
            if (str != null && str.equals(pn.u().x)) {
                return this;
            }
            pn.u().x = str;
            Map<String, Object> map = this.u;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public nr pn(int i) {
            if (pn.u().t == i) {
                return this;
            }
            pn.u().t = i;
            this.u.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public nr u(long j) {
            if (pn.u().b == j) {
                return this;
            }
            pn.u().b = j;
            this.u.put("duration", Long.valueOf(j));
            return this;
        }

        public nr x(int i) {
            if (pn.u().l == i) {
                return this;
            }
            pn.u().l = i;
            this.u.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public nr fx(String str) {
            if (str != null && str.equals(pn.u().u)) {
                return this;
            }
            pn.u().u = str;
            Map<String, Object> map = this.u;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public nr nr(int i) {
            if (pn.u().s == i) {
                return this;
            }
            pn.u().s = i;
            this.u.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public nr u(int i) {
            if (pn.u().fx == i) {
                return this;
            }
            pn.u().fx = i;
            this.u.put("max", Integer.valueOf(i));
            return this;
        }

        public nr u(float f) {
            if (pn.u().pn == f) {
                return this;
            }
            pn.u().pn = f;
            this.u.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public nr u(String str) {
            if (str != null && str.equals(pn.u().iz)) {
                return this;
            }
            pn.u().iz = str;
            Map<String, Object> map = this.u;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public nr u(boolean z) {
            this.u.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public nr u(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject == null || pn.u().k == (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            pn.u().k = iOptInt;
            this.u.put("splash_policy", Integer.valueOf(iOptInt));
            return this;
        }

        public void u() {
            try {
                if (fx.u().nr()) {
                    String strSx = pn.sx();
                    for (Map.Entry<String, Object> entry : this.u.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.x.fx.u.nr.u(strSx, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.x.fx.u.nr.u(strSx, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.x.fx.u.nr.u(strSx, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.x.fx.u.nr.u(strSx, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.x.fx.u.nr.u(strSx, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = pn.u().nr.edit();
                for (Map.Entry<String, Object> entry2 : this.u.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public int a() {
        if (this.s == -1) {
            this.s = u("cypher_version", 40001);
        }
        return this.s;
    }

    public float b() {
        if (this.pn == -1.0f) {
            this.pn = u("aggMultiple", -1.0f);
        }
        return this.pn;
    }

    public int fx() {
        if (this.fx == -1) {
            this.fx = u("max", 50);
        }
        return this.fx;
    }

    public String iz() {
        if (this.x == null) {
            this.x = nr("ab_test_param", "");
        }
        return this.x;
    }

    public boolean n() {
        if (this.mv == -1) {
            this.mv = u("dl_storage_internal", 1);
        }
        return this.mv == 1;
    }

    public String pn() {
        if (this.iz == null) {
            this.iz = nr("ab_test_version", "");
        }
        return this.iz;
    }

    public void x() {
        this.x = "";
        this.iz = "";
        u("ab_test_version", "");
        u("ab_test_param", "");
    }

    public long nr() {
        if (this.b == -1) {
            this.b = u("duration", 10000L);
        }
        return this.b;
    }

    public static pn u() {
        return u.u;
    }

    public String nr(String str, String str2) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.nr(sx(), str, str2);
            }
            return this.nr.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public boolean u(String str, boolean z) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u(sx(), str, z);
            }
            return this.nr.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public long u(String str, long j) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u(sx(), str, j);
            }
            return this.nr.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float u(String str, float f) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u(sx(), str, f);
            }
            return this.nr.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int u(String str, int i) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u(sx(), str, i);
            }
            return this.nr.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void u(String str, String str2) {
        try {
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u(sx(), str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = this.nr.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}

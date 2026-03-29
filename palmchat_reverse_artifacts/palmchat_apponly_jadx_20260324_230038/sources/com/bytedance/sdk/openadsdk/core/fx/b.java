package com.bytedance.sdk.openadsdk.core.fx;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.dw;
import com.qq.gdt.action.ActionUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile String f5280a;
    protected volatile String b;
    private volatile String c;
    private volatile String d;
    private volatile String dw;
    protected volatile String fx;
    private volatile String gi;
    protected volatile String iz;
    protected volatile String jk;
    private volatile JSONArray kj;
    private volatile String mv;
    protected volatile String n;
    protected volatile String nr;
    private volatile String o;
    protected volatile String pn;
    private volatile String q;
    private volatile String qq;
    private volatile String rh;
    private volatile String s;
    private volatile String sx;
    protected volatile String u;
    protected volatile String x;
    private volatile String z;
    private volatile int l = -1;
    private volatile int k = -1;
    private volatile int my = -1;
    private volatile int bg = -1;
    private volatile int bq = -1;
    private volatile int h = -1;
    private volatile SharedPreferences t = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sp_exec_getad_config", 0);

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static b u = new b();
    }

    private void qq() {
        try {
            this.q = com.bytedance.sdk.openadsdk.core.iz.u().pn();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7232);
            jSONObject.put("log_version", this.q);
            nr("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public static b u() {
        return u.u;
    }

    public void a(String str) {
        if (str == null || !str.equals(this.c)) {
            this.c = str;
            nr("extra_internal_data", str);
        }
    }

    public String b() {
        if (this.mv == null) {
            this.mv = fx("app_id", "");
        }
        return this.mv;
    }

    public String bg() {
        if (this.gi == null) {
            this.gi = fx("dev15", (String) null);
        }
        return this.gi;
    }

    public int bq() {
        return nr("sp_device_app_direction", -1);
    }

    public String c() {
        if (this.rh == null) {
            this.rh = fx("spl_strategy", "");
        }
        return this.rh;
    }

    public String dw() {
        if (this.d == null) {
            this.d = fx("dev16", "");
        }
        return this.d;
    }

    public int fx() {
        if (this.l == -1) {
            this.l = nr("live_ad_clk_cnt", 0);
        }
        return this.l;
    }

    public String iz(String str) {
        if (this.sx == null) {
            this.sx = fx("keywords", str);
        }
        return this.sx;
    }

    public String jk(String str) {
        if (this.c == null) {
            this.c = fx("extra_internal_data", str);
        }
        return this.c;
    }

    public String k() {
        if (this.qq == null) {
            this.qq = fx("dev10", (String) null);
        }
        return this.qq;
    }

    public String l() {
        if (this.x == null) {
            this.x = fx("dev17", (String) null);
        }
        return this.x;
    }

    public String mv() {
        if (this.n == null) {
            this.n = fx("dev18", (String) null);
        }
        return this.n;
    }

    public String my() {
        if (this.jk == null) {
            this.jk = fx("dev11", (String) null);
        }
        return this.jk;
    }

    public String n(String str) {
        if (this.dw == null) {
            this.dw = fx("extra_data", str);
        }
        return this.dw;
    }

    public SharedPreferences nr() {
        return this.t;
    }

    public JSONArray o() {
        String strFx;
        if (this.kj == null && (strFx = fx("dev12", (String) null)) != null) {
            try {
                this.kj = new JSONArray(strFx);
            } catch (JSONException unused) {
            }
        }
        return this.kj;
    }

    public String pn() {
        if (this.s == null) {
            this.s = fx("app_name", "");
        }
        return this.s;
    }

    public void q() {
        try {
            SharedPreferences.Editor editorEdit = nr().edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String s() {
        if (this.f5280a == null) {
            this.f5280a = fx("dev09", (String) null);
        }
        return this.f5280a;
    }

    public String sx() {
        if (this.z == null) {
            this.z = fx("dev13", (String) null);
        }
        return this.z;
    }

    public String t(String str) {
        if (this.u == null) {
            this.u = fx("dev01", str);
        }
        return this.u;
    }

    public boolean x(int i) {
        return i == 3 || i == 4;
    }

    public void nr(String str) {
        if (str == null || !str.equals(this.s)) {
            this.s = str;
            nr("app_name", str);
        }
    }

    public void u(int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
        u("live_ad_clk_cnt", i);
    }

    public void x(String str) {
        if (str == null || !str.equals(this.dw)) {
            this.dw = str;
            nr("extra_data", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private Map<String, Object> u = new HashMap();

        public nr a(String str) {
            if (str == null || str.equals(b.u().n)) {
                return this;
            }
            b.u().n = str;
            this.u.put("dev18", str);
            return this;
        }

        public nr b(String str) {
            if (str == null || str.equals(b.u().b)) {
                return this;
            }
            b.u().b = str;
            this.u.put("dev05", str);
            return this;
        }

        public nr fx(String str) {
            if (str == null || str.equals(b.u().fx)) {
                return this;
            }
            b.u().fx = str;
            this.u.put("dev04", str);
            return this;
        }

        public nr iz(String str) {
            if (str == null || str.equals(b.u().pn)) {
                return this;
            }
            b.u().pn = str;
            this.u.put("dev07", str);
            return this;
        }

        public nr jk(String str) {
            if (str == null || str.equals(b.u().f5280a)) {
                return this;
            }
            b.u().f5280a = str;
            this.u.put("dev09", str);
            return this;
        }

        public nr n(String str) {
            if (str == null || str.equals(b.u().x)) {
                return this;
            }
            b.u().x = str;
            this.u.put("dev17", str);
            return this;
        }

        public nr nr(String str) {
            if (str == null || str.equals(b.u().nr)) {
                return this;
            }
            b.u().nr = str;
            this.u.put("dev02", com.bytedance.sdk.component.utils.u.nr(str));
            return this;
        }

        public nr pn(String str) {
            if (str == null || str.equals(b.u().jk)) {
                return this;
            }
            b.u().jk = str;
            this.u.put("dev11", str);
            return this;
        }

        public nr u(String str) {
            if (str == null || str.equals(b.u().u)) {
                return this;
            }
            b.u().u = str;
            this.u.put("dev01", str);
            return this;
        }

        public nr x(String str) {
            if (str == null || str.equals(b.u().iz)) {
                return this;
            }
            b.u().iz = str;
            this.u.put("dev08", str);
            return this;
        }

        public void u() {
            try {
                if (fx.u().nr()) {
                    for (Map.Entry<String, Object> entry : this.u.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = b.u().nr().edit();
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
                editorEdit.apply();
            } catch (Exception unused) {
            }
        }
    }

    public String a() {
        if (this.b == null) {
            this.b = fx("dev05", (String) null);
        }
        return this.b;
    }

    public void b(String str) {
        this.o = str;
        nr("dev03", str);
    }

    public String fx(String str) {
        if (this.o == null) {
            this.o = fx("dev03", str);
        }
        return this.o;
    }

    public int iz() {
        if (this.bg == -1) {
            this.bg = nr("age_group", Integer.MIN_VALUE);
        }
        return this.bg;
    }

    public String jk() {
        if (this.pn == null) {
            this.pn = fx("dev07", (String) null);
        }
        return this.pn;
    }

    public void k(String str) {
        if (str == null || !str.equals(this.d)) {
            this.d = str;
            nr("dev16", str);
        }
    }

    public void l(String str) {
        if (str == null || str.equals(this.qq)) {
            return;
        }
        this.qq = str;
        nr("dev10", str);
    }

    public void mv(String str) {
        if (str == null || str.equals(this.z)) {
            return;
        }
        this.z = str;
        b("dev13", str);
    }

    public void my(String str) {
        if (str == null || !str.equals(this.rh)) {
            this.rh = str;
            nr("spl_strategy", this.rh);
        }
    }

    public String n() {
        if (this.fx == null) {
            this.fx = fx("dev04", (String) null);
        }
        return this.fx;
    }

    public void pn(String str) {
        if (str == null || !str.equals(this.sx)) {
            this.sx = str;
            nr("keywords", str);
        }
    }

    public void s(String str) {
        if (str == null || str.equals(this.gi)) {
            return;
        }
        this.gi = str;
        b("dev15", str);
    }

    public String t() {
        if (this.iz == null) {
            this.iz = fx("dev08", (String) null);
        }
        return this.iz;
    }

    public void nr(boolean z) {
        this.k = z ? 1 : 2;
        u("is_paid", this.k);
    }

    public void u(String str) {
        if (str == null || !str.equals(this.mv)) {
            this.mv = str;
            nr("app_id", str);
        }
    }

    public String x() {
        if (this.nr == null) {
            this.nr = com.bytedance.sdk.component.utils.u.fx(fx("dev02", (String) null));
        }
        return this.nr;
    }

    public int b(int i) {
        if (this.bq == -1) {
            this.bq = nr("sdk_theme_status", i);
        }
        return this.bq;
    }

    public void fx(int i) {
        if (i == this.bq) {
            return;
        }
        this.bq = i;
        u("sdk_theme_status", i);
    }

    public void iz(int i) {
        u("sp_device_app_direction", i);
    }

    public void n(int i) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        u("dev_level", i);
    }

    public void nr(int i) {
        if (i == this.bg) {
            return;
        }
        this.bg = i;
        u("age_group", i);
    }

    public String pn(int i) {
        if (TextUtils.isEmpty(this.q)) {
            try {
                String strFx = fx("logsdk_version", "");
                if (!TextUtils.isEmpty(strFx)) {
                    JSONObject jSONObject = new JSONObject(strFx);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.q = jSONObject.optString("log_version");
                    if (iOptInt != 7232 || TextUtils.isEmpty(this.q)) {
                        qq();
                    }
                } else {
                    qq();
                }
            } catch (Exception unused) {
            }
        }
        return this.q;
    }

    public boolean u(boolean z) {
        if (this.k == -1) {
            this.k = nr("is_paid", z ? 1 : 2);
        }
        return this.k == 1;
    }

    public void b(boolean z) {
        int i = z ? 1 : 2;
        if (this.my != i) {
            this.my = i;
            u("is_use_mediation", i);
        }
    }

    public boolean fx(boolean z) {
        if (this.my == -1) {
            this.my = nr("is_use_mediation", z ? 1 : 2);
        }
        return this.my == 1;
    }

    public boolean nr(String str, boolean z) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, z);
            }
            return nr().getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public String u(String str, String str2) {
        return fx("code_group_rit_".concat(String.valueOf(str)), str2);
    }

    public String b(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strFx = fx(str, "");
            if (TextUtils.isEmpty(strFx)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strFx);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(ActionUtils.PAYMENT_AMOUNT);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void u(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.kj == null ? null : this.kj.toString())) {
            return;
        }
        this.kj = jSONArray;
        nr("dev12", jSONArray.toString());
    }

    public String fx(String str, String str2) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.nr("sp_exec_getad_config", str, str2);
            }
            return nr().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public long nr(String str, long j) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, j);
            }
            return nr().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public String fx(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strFx = fx(str, "");
            if (TextUtils.isEmpty(strFx)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strFx);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(ActionUtils.PAYMENT_AMOUNT);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public int nr(String str, int i) {
        try {
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, i);
            }
            return nr().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void u(String str, boolean z) {
        try {
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, Boolean.valueOf(z));
                return;
            }
            SharedPreferences.Editor editorEdit = nr().edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ActionUtils.PAYMENT_AMOUNT, str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7232);
            nr(str, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void nr(String str, String str2) {
        try {
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = nr().edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void u(String str, long j) {
        try {
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor editorEdit = nr().edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void u(String str, int i) {
        try {
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_exec_getad_config", str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor editorEdit = nr().edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}

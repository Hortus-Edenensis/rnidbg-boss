package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mh {
    private final SharedPreferences b;
    private final SharedPreferences fx;
    private volatile JSONObject iz;
    private final n nr;
    private final SharedPreferences pn;
    private final Context u;
    private volatile JSONObject x;

    public mh(Context context, n nVar) {
        this.u = context;
        this.nr = nVar;
        this.pn = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "embed_applog_stats", 0);
        this.fx = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "embed_header_custom", 0);
        this.b = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "embed_last_sp_session", 0);
    }

    public static String u() {
        return "embed_applog_stats";
    }

    public int a() {
        return this.pn.getInt("bav_monitor_rate", 0);
    }

    public int b() {
        return this.b.getInt("session_order", 0);
    }

    public String bc() {
        return this.nr.rh() == null ? "" : this.nr.rh();
    }

    public int bf() {
        return this.nr.o();
    }

    public long bg() {
        return this.pn.getLong("abtest_fetch_interval", 0L);
    }

    public String bq() {
        return !TextUtils.isEmpty(this.nr.bq()) ? this.nr.bq() : this.fx.getString("ab_version", null);
    }

    public boolean c() {
        return this.pn.getBoolean("bav_ab_config", false);
    }

    public String cj() {
        return this.nr.h();
    }

    @Nullable
    public String d() {
        return this.pn.getString("user_agent", null);
    }

    public JSONObject dw() {
        JSONObject jSONObject = this.iz;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (c()) {
                        jSONObject = new JSONObject(this.fx.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.iz = jSONObject;
            }
        }
        return jSONObject;
    }

    public String fx() {
        return this.b.getString("session_last_day", "");
    }

    public String gi() {
        return this.nr.u();
    }

    public String h() {
        return this.nr.l();
    }

    public boolean iz() {
        return this.nr.nr();
    }

    public int ja() {
        return this.nr.my();
    }

    public String jk() {
        return this.nr.fx();
    }

    public String jp() {
        return this.nr.c();
    }

    public String k() {
        return this.fx.getString("header_custom_info", null);
    }

    public long kj() {
        return this.pn.getLong("batch_event_interval", 30000L);
    }

    public String l() {
        return this.nr.pn();
    }

    public String m() {
        return this.nr.dw();
    }

    public String mv() {
        return this.nr.iz();
    }

    public String my() {
        return this.fx.getString("ab_sdk_version", "");
    }

    public long n() {
        return this.pn.getLong("app_log_last_config_time", 0L);
    }

    public String nr() {
        return this.nr.n();
    }

    public String o() {
        return this.fx.getString("user_unique_id", null);
    }

    public boolean oa() {
        return this.nr.z();
    }

    public String pb() {
        return this.nr.s();
    }

    public SharedPreferences pn() {
        return this.pn;
    }

    public boolean q() {
        return this.pn.getBoolean("bav_log_collect", false);
    }

    public long qq() {
        return this.pn.getLong("session_interval", 30000L);
    }

    public int rh() {
        return this.nr.k();
    }

    public String s() {
        return this.nr.x();
    }

    public boolean sx() {
        if (this.nr.a() == 0) {
            String strU = gb.u(this.u);
            if (TextUtils.isEmpty(strU)) {
                this.nr.u(0);
            } else {
                this.nr.u(strU.contains(":") ? 2 : 1);
            }
        }
        return this.nr.a() == 1;
    }

    public String t() {
        return this.nr.b();
    }

    public n tk() {
        return this.nr;
    }

    public boolean w() {
        return this.nr.gi();
    }

    public CharSequence wi() {
        return this.nr.qq();
    }

    public String wq() {
        return this.nr.mv();
    }

    public JSONObject x() {
        return this.x;
    }

    public String xg() {
        return this.nr.bg();
    }

    public String xw() {
        return this.nr.ja() == null ? "" : this.nr.ja();
    }

    public String y() {
        return this.nr.q();
    }

    public String z() {
        return null;
    }

    public void fx(JSONObject jSONObject) {
        ti.u("setAbConfig, " + jSONObject.toString(), null);
        this.fx.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.iz = null;
    }

    public void nr(JSONObject jSONObject) {
        this.fx.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public boolean u(ArrayList<ju> arrayList) {
        return true;
    }

    public void u(String str, int i) {
        this.b.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public void u(JSONObject jSONObject) {
        if (ti.nr) {
            ti.u("setConfig, " + jSONObject.toString(), null);
        }
        this.x = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.pn.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt > 0 && jOptInt <= 604800) {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        } else {
            editorEdit.remove("session_interval");
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 > 0 && jOptInt2 <= 604800) {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        } else {
            editorEdit.remove("batch_event_interval");
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt > 0 && iOptInt <= 604800) {
            editorEdit.putInt("send_launch_timely", iOptInt);
        } else {
            editorEdit.remove("send_launch_timely");
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 > 20 && jOptInt3 <= 604800) {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        } else {
            editorEdit.remove("abtest_fetch_interval");
        }
        boolean zOptBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (zOptBoolean) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        ti.u = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            ki.u(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            ki.u(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }
}

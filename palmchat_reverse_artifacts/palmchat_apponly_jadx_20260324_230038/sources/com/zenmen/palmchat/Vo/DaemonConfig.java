package com.zenmen.palmchat.Vo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.jo6;
import defpackage.rl0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DaemonConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f12150a;
    public static Boolean b;
    public static Boolean c;

    public static boolean a(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("wifi_social_daemon", 4).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static String b(Context context) {
        return d(context, "sp_daemon_dynamic_config_extra", null);
    }

    public static long c(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("wifi_social_daemon", 4).getLong(str, j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static String d(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("wifi_social_daemon", 4).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean e() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = Boolean.TRUE;
        b = bool2;
        return bool2.booleanValue();
    }

    public static boolean f(Context context) {
        String strD = d(context, "sp_daemon_dynamic_config_extra", null);
        if (!TextUtils.isEmpty(strD)) {
            try {
                return new JSONObject(strD).optBoolean("router2", false);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean g(Context context) {
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(a(context, "sp_daemon_syncacc_taichi", false));
            c = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void h(Context context) {
        long jC = c(context, "sp_daemon_last_pull_time", -1L);
        if (jC > 0 ? DateUtils.isToday(jC) : false) {
            k(context, "sp_daemon_last_pull_count", c(context, "sp_daemon_last_pull_count", 0L) + 1);
        } else {
            k(context, "sp_daemon_last_pull_count", 1L);
        }
        k(context, "sp_daemon_last_pull_time", System.currentTimeMillis());
    }

    public static DaemonConfig i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("daemonConfig");
        if (jSONObjectOptJSONObject == null) {
            l(c.b(), "sp_daemon_config", null);
            return null;
        }
        DaemonConfig daemonConfig = new DaemonConfig();
        l(c.b(), "sp_daemon_config", jSONObjectOptJSONObject.toString());
        return daemonConfig;
    }

    public static void j(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("wifi_social_daemon", 4).edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void k(Context context, String str, long j) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("wifi_social_daemon", 4).edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void l(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("wifi_social_daemon", 4).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.DAEMON);
        l(c.b(), "sp_daemon_dynamic_config_extra", dynamicConfig != null ? dynamicConfig.getExtra() : null);
    }

    public static void n() {
        try {
            f12150a = Boolean.valueOf(jo6.a("LX-10793", false));
            c = Boolean.valueOf(jo6.a("LX-39951", false));
            j(c.b(), "sp_daemon_read_taichi", f12150a.booleanValue());
            j(c.b(), "sp_daemon_syncacc_taichi", c.booleanValue());
        } catch (Exception unused) {
        }
    }
}

package com.apm.lite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.lite.MonitorCrash;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.ef7;
import defpackage.gg7;
import defpackage.nz6;
import defpackage.s07;
import defpackage.v07;
import defpackage.x97;
import defpackage.yl7;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static volatile MonitorCrash b;
    public static volatile ConcurrentHashMap<String, MonitorCrash> c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MonitorCrash f3290a;

    public b(MonitorCrash monitorCrash) {
        this.f3290a = monitorCrash;
        s07.g(this);
        v07.e();
        ef7.h();
    }

    public static MonitorCrash a(String str) {
        return c.get(str);
    }

    public static Object b() {
        return b;
    }

    public static void i(MonitorCrash monitorCrash) {
        new b(monitorCrash);
        if (monitorCrash == null || monitorCrash.mConfig == null) {
            return;
        }
        c.put(monitorCrash.mConfig.f3285a, monitorCrash);
    }

    public static String l(String str) {
        MonitorCrash monitorCrash;
        if (b != null && TextUtils.equals(str, b.mConfig.f3285a)) {
            monitorCrash = b;
        } else if (c == null || (monitorCrash = c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.b;
    }

    public static String q() {
        if (b == null) {
            return null;
        }
        return b.mConfig.f3285a;
    }

    public JSONArray c(StackTraceElement[] stackTraceElementArr, Throwable th) {
        String[] strArr = this.f3290a.mConfig.f;
        if (strArr == null) {
            return new JSONArray().put(new yl7.a(0, stackTraceElementArr.length).a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        return yl7.g(stackTraceElementArr, strArr);
    }

    public JSONArray d(String[] strArr) {
        if (this.f3290a.config().f == null) {
            return new JSONArray().put(new yl7.a(0, strArr.length).a());
        }
        JSONArray jSONArrayH = yl7.h(strArr, this.f3290a.mConfig.f);
        try {
            if (gg7.f(jSONArrayH) && this.f3290a.mConfig.k) {
                String strK = nz6.y().K();
                if (!TextUtils.isEmpty(strK)) {
                    for (String str : this.f3290a.mConfig.f) {
                        if (strK.contains(str)) {
                            return new JSONArray().put(new yl7.a(0, strArr.length).a());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArrayH;
    }

    public JSONObject e(CrashType crashType) {
        return f(crashType, null);
    }

    public JSONObject f(CrashType crashType, JSONArray jSONArray) {
        return g(crashType, jSONArray, false);
    }

    public JSONObject g(CrashType crashType, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", h(z));
            if (crashType != null) {
                jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, m(crashType));
                jSONObject.put("filters", o(crashType));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final JSONObject h(boolean z) {
        MonitorCrash monitorCrash;
        a aVar;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f3290a.mConfig.f == null) {
                Context contextM = x97.m();
                PackageInfo packageInfo = contextM.getPackageManager().getPackageInfo(contextM.getPackageName(), 128);
                if (packageInfo != null) {
                    MonitorCrash.Config config = this.f3290a.mConfig;
                    if (config.d == -1) {
                        config.d = packageInfo.versionCode;
                    }
                    if (config.e == null) {
                        config.e = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if ((TextUtils.isEmpty(this.f3290a.mConfig.getDeviceId()) || "0".equals(this.f3290a.mConfig.getDeviceId())) && (aVar = (monitorCrash = this.f3290a).mAppLog) != null) {
            monitorCrash.mConfig.setDeviceId(aVar.a(), false);
        }
        try {
            jSONObject.put("aid", String.valueOf(this.f3290a.mConfig.f3285a));
            if (z && !TextUtils.isEmpty(this.f3290a.mConfig.b)) {
                jSONObject.put("x-auth-token", this.f3290a.mConfig.b);
            }
            jSONObject.put("update_version_code", this.f3290a.mConfig.d);
            jSONObject.put("version_code", this.f3290a.mConfig.d);
            jSONObject.put("app_version", this.f3290a.mConfig.e);
            jSONObject.put("channel", this.f3290a.mConfig.c);
            jSONObject.put("package", gg7.d(this.f3290a.mConfig.f));
            jSONObject.put("device_id", this.f3290a.mConfig.getDeviceId());
            jSONObject.put("user_id", this.f3290a.mConfig.getUID());
            jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("so_list", gg7.d(this.f3290a.mConfig.g));
            jSONObject.put("single_upload", p() ? 1 : 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public boolean j(Object obj) {
        return this.f3290a == obj;
    }

    public String k() {
        return this.f3290a.mConfig.f3285a;
    }

    public final JSONObject m(CrashType crashType) {
        Map<? extends String, ? extends String> userData;
        AttachUserData attachUserData = this.f3290a.mCustomData;
        if (attachUserData == null || (userData = attachUserData.getUserData(crashType)) == null) {
            return null;
        }
        return new JSONObject(userData);
    }

    public JSONObject n() {
        return h(true);
    }

    public final JSONObject o(CrashType crashType) {
        return new JSONObject(this.f3290a.mTagMap);
    }

    public boolean p() {
        return false;
    }
}

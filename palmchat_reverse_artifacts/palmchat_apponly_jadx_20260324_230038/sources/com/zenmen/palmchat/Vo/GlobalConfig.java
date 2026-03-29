package com.zenmen.palmchat.Vo;

import com.oplus.tblplayer.config.PreCacheConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GlobalConfig {
    public String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12151a = true;
    public int b = PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE;
    public double c = 1.0d;
    public double d = 1.0d;
    public int e = 10;
    public boolean f = false;
    public long h = 0;

    public GlobalConfig() {
        g();
    }

    public static GlobalConfig h(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("GlobalConfig", "parseLogConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("globalConfig")) == null) {
            return null;
        }
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.f12151a = jSONObjectOptJSONObject.optBoolean("autoFriendApplyEnabled", true);
        globalConfig.f = jSONObjectOptJSONObject.optBoolean("minProgExType3Enabled", false);
        globalConfig.b = jSONObjectOptJSONObject.optInt("uploadFileMaxSize", PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE);
        globalConfig.i(jSONObjectOptJSONObject.optDouble("connHbFactor", 1.0d));
        globalConfig.j(jSONObjectOptJSONObject.optDouble("connRcFactor", 1.0d));
        globalConfig.k(jSONObjectOptJSONObject.optLong("connPingTimeout", 0L));
        globalConfig.e = jSONObjectOptJSONObject.optInt("connRcMaxCnt", 10);
        globalConfig.g = jSONObjectOptJSONObject.optString("mpIcon");
        LogUtil.i("GlobalConfig", "result.autoFriendApplyEnabled " + globalConfig.f12151a);
        return globalConfig;
    }

    public double a() {
        return this.c;
    }

    public double b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public long e() {
        return this.h;
    }

    public int f() {
        return this.b;
    }

    public final void g() {
        this.f12151a = true;
    }

    public final void i(double d) {
        if (d <= 0.0d) {
            this.c = 1.0d;
        } else {
            this.c = d;
        }
    }

    public final void j(double d) {
        if (d <= 0.0d) {
            this.d = 1.0d;
        } else {
            this.d = d;
        }
    }

    public final void k(long j) {
        this.h = j;
    }
}

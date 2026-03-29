package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class HbConfig {
    public static HbConfig c = new HbConfig();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12156a = true;
    public long b = 10000;

    public HbConfig() {
        c();
    }

    public static HbConfig a() {
        return c;
    }

    public static HbConfig e(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("HbConfig", "parseHbConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("hbConfig")) == null) {
            return null;
        }
        HbConfig hbConfig = new HbConfig();
        hbConfig.f12156a = jSONObjectOptJSONObject.optBoolean("enable");
        hbConfig.b = jSONObjectOptJSONObject.optLong("uploadIntervalSec") * 1000;
        LogUtil.i("HbConfig", "hbConfig=" + jSONObjectOptJSONObject);
        return hbConfig;
    }

    public static void f(HbConfig hbConfig) {
        c = hbConfig;
    }

    public long b() {
        return this.b;
    }

    public boolean d() {
        return this.f12156a;
    }

    public final void c() {
    }
}

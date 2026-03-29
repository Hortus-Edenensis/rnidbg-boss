package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WifiConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12171a;

    public WifiConfig() {
        a();
    }

    public static WifiConfig b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("WifiConfig", "parseLogConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("wifiConfig")) == null) {
            return null;
        }
        WifiConfig wifiConfig = new WifiConfig();
        wifiConfig.f12171a = jSONObjectOptJSONObject.optString("key");
        LogUtil.i("WifiConfig", "result.key " + wifiConfig.f12171a);
        return wifiConfig;
    }

    public final void a() {
        this.f12171a = "";
    }
}

package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WkPromptConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12172a;
    public String b;
    public int c;
    public int d;
    public int e;

    public WkPromptConfig() {
        a();
    }

    public static WkPromptConfig b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        LogUtil.i("WkPromptConfig", "parseWkPromptConfig" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("wkPrompt")) == null) {
            return null;
        }
        WkPromptConfig wkPromptConfig = new WkPromptConfig();
        wkPromptConfig.f12172a = jSONObjectOptJSONObject.optString("label1");
        wkPromptConfig.b = jSONObjectOptJSONObject.optString("label2");
        wkPromptConfig.c = jSONObjectOptJSONObject.optInt("interval");
        wkPromptConfig.d = jSONObjectOptJSONObject.optInt("limited");
        wkPromptConfig.e = jSONObjectOptJSONObject.optInt("tryCount");
        LogUtil.i("WkPromptConfig", "result.label1 " + wkPromptConfig.f12172a);
        LogUtil.i("WkPromptConfig", "result.label2 " + wkPromptConfig.b);
        LogUtil.i("WkPromptConfig", "result.interval " + wkPromptConfig.c);
        LogUtil.i("WkPromptConfig", "result.limited " + wkPromptConfig.d);
        LogUtil.i("WkPromptConfig", "result.tryCount " + wkPromptConfig.e);
        return wkPromptConfig;
    }

    public final void a() {
        this.f12172a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }
}

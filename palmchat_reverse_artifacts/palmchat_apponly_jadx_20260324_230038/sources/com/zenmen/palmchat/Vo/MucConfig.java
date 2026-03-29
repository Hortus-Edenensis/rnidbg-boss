package com.zenmen.palmchat.Vo;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MucConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12161a = 40;

    public static MucConfig b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("mucConfig")) == null) {
            return null;
        }
        MucConfig mucConfig = new MucConfig();
        mucConfig.f12161a = jSONObjectOptJSONObject.optInt("mucMemAddStepMax", 40);
        return mucConfig;
    }

    public int a() {
        return this.f12161a;
    }
}

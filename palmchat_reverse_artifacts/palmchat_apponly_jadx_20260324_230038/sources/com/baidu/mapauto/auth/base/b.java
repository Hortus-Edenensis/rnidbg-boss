package com.baidu.mapauto.auth.base;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3855a;
    public final JSONObject b;

    public b(String str) {
        JSONObject jSONObject;
        this.f3855a = str;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        this.b = jSONObject;
    }
}

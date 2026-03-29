package com.bytedance.adsdk.ugeno.fx;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s {
    private Map<String, Object> b;
    private JSONObject fx;
    private JSONObject nr;
    private Context u;

    public Context getContext() {
        return this.u;
    }

    public void nr(JSONObject jSONObject) {
        this.fx = jSONObject;
    }

    public void u(Context context) {
        this.u = context;
    }

    public Map<String, Object> nr() {
        return this.b;
    }

    public void u(JSONObject jSONObject) {
        this.nr = jSONObject;
    }

    public JSONObject u() {
        return this.fx;
    }

    public void u(Map<String, Object> map) {
        this.b = map;
    }
}

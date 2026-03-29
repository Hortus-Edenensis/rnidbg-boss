package com.xiaomi.push;

import com.tencent.matrix.trace.config.SharePluginInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f185a;
    private long b;
    private long c;

    public cb() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.f11464a;
    }

    public cb(int i, long j, long j2, Exception exc) {
        this.f11464a = i;
        this.f184a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f185a = exc.getClass().getSimpleName();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m241a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SharePluginInfo.ISSUE_COST, this.f184a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.f11464a);
        jSONObject.put("expt", this.f185a);
        return jSONObject;
    }

    public cb a(JSONObject jSONObject) {
        this.f184a = jSONObject.getLong(SharePluginInfo.ISSUE_COST);
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.f11464a = jSONObject.getInt("wt");
        this.f185a = jSONObject.optString("expt");
        return this;
    }
}

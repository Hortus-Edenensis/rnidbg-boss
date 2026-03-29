package com.bytedance.sdk.openadsdk.nr;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private long b;
    private String fx;
    private String nr;
    private long pn;
    private long u;

    public u(JSONObject jSONObject) {
        this.u = jSONObject.optLong("cid");
        this.nr = jSONObject.optString("url");
        this.fx = jSONObject.optString("file_hash");
        this.b = jSONObject.optLong("effective_time");
        this.pn = jSONObject.optLong("expiration_time");
    }

    public boolean b() {
        return System.currentTimeMillis() >= this.pn;
    }

    public long fx() {
        return this.b;
    }

    public String nr() {
        return this.fx;
    }

    public JSONObject pn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.u);
            jSONObject.put("url", this.nr);
            jSONObject.put("file_hash", this.fx);
            jSONObject.put("effective_time", this.b);
            jSONObject.put("expiration_time", this.pn);
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public String u() {
        return this.nr;
    }

    public boolean nr(String str) {
        File file = new File(str, this.fx);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public long u(String str) {
        File file = new File(str, this.fx);
        return file.exists() ? file.lastModified() : System.currentTimeMillis();
    }
}

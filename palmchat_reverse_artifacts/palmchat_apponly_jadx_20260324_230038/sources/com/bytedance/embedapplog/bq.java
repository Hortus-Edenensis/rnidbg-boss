package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class bq {
    protected JSONObject b;
    protected String fx = "";
    protected final h nr = new h();
    protected Context u;

    public bq(Context context, JSONObject jSONObject) {
        this.u = context;
        this.b = jSONObject;
    }

    private String b() {
        return this.fx;
    }

    public abstract String fx();

    public abstract String nr();

    public h u() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strNr = nr();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.nr.nr(strNr);
            this.nr.u(fx());
            this.nr.u(jCurrentTimeMillis2 - jCurrentTimeMillis);
            this.nr.fx(b());
            this.nr.fx();
            if (this.b.has("index")) {
                this.nr.u(this.b.optInt("index"));
            }
            return this.nr;
        } catch (Exception e) {
            bg.nr("__kite" + fx() + " doLoad# error " + e.getMessage());
            return this.nr;
        }
    }
}

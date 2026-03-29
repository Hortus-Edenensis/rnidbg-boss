package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class lf extends w {
    private final Context pn;

    public lf(Context context) {
        super(true, true);
        this.pn = context;
    }

    @Override // com.bytedance.embedapplog.w
    @SuppressLint({"MissingPermission"})
    public boolean u(JSONObject jSONObject) throws JSONException {
        yd.u(jSONObject, bt.Q, df.u(this.pn));
        return true;
    }
}

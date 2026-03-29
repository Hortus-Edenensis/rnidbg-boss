package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class xw extends w {
    private final mh iz;
    private final Context pn;

    public xw(Context context, mh mhVar) {
        super(true, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.iz.xg())) {
            jSONObject.put("ab_client", this.iz.xg());
        }
        if (!TextUtils.isEmpty(this.iz.bq())) {
            if (ti.nr) {
                ti.u("init config has abversion:" + this.iz.bq(), null);
            }
            jSONObject.put("ab_version", this.iz.bq());
        }
        if (!TextUtils.isEmpty(this.iz.m())) {
            jSONObject.put("ab_group", this.iz.m());
        }
        if (TextUtils.isEmpty(this.iz.jp())) {
            return true;
        }
        jSONObject.put("ab_feature", this.iz.jp());
        return true;
    }
}

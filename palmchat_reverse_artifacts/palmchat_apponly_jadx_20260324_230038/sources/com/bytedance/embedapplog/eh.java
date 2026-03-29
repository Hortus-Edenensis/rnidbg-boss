package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class eh extends w {
    private final mh iz;
    private final Context pn;

    public eh(Context context, mh mhVar) {
        super(true, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        String strU = u.mv() != null ? u.mv().bf().u() : "";
        if (TextUtils.isEmpty(strU)) {
            return true;
        }
        jSONObject.put(bt.A, strU);
        return true;
    }
}

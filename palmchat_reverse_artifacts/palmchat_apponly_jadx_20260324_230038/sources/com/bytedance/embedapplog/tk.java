package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class tk extends w {
    private final mh pn;

    public tk(Context context, mh mhVar) {
        super(true, false);
        this.pn = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        String strU = ec.u(this.pn.pn());
        if (TextUtils.isEmpty(strU)) {
            return false;
        }
        jSONObject.put("cdid", strU);
        return true;
    }
}

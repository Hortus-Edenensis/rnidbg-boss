package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class nb extends w {
    private final mh iz;
    private final Context pn;

    public nb(Context context, mh mhVar) {
        super(true, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) {
        Map<String, String> mapU = ec.u(this.pn, this.iz.pn());
        if (mapU == null) {
            return !u.nr;
        }
        jSONObject.put("oaid", new JSONObject(mapU));
        return true;
    }
}

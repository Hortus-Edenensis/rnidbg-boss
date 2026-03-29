package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {
    private final kj u;

    public d(Context context) {
        gi giVar = new gi(context);
        this.u = new kj(context, new dw(context, giVar), giVar);
    }

    public void u(JSONObject jSONObject, String str) {
        this.u.u(jSONObject, str);
    }
}

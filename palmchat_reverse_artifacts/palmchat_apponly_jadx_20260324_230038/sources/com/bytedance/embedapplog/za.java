package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class za extends w {
    private final Context pn;

    public za(Context context) {
        super(true, false);
        this.pn = context;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        yd.u(jSONObject, "sim_region", ((TelephonyManager) this.pn.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}

package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class kw extends w {
    private final mh pn;

    public kw(mh mhVar) {
        super(true, false, false);
        this.pn = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesPn = this.pn.pn();
        String string = sharedPreferencesPn.getString("install_id", null);
        String string2 = sharedPreferencesPn.getString("device_id", null);
        String string3 = sharedPreferencesPn.getString("ssid", null);
        yd.u(jSONObject, "install_id", string);
        yd.u(jSONObject, "device_id", string2);
        yd.u(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesPn.getLong("register_time", 0L);
        if ((yd.nr(string) && yd.nr(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesPn.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}

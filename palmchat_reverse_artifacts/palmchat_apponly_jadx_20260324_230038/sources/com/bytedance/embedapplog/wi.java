package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class wi extends w {
    private final Context pn;

    public wi(Context context) {
        super(false, false);
        this.pn = context;
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws Throwable {
        SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.pn, "snssdk_openudid", 0);
        String strNr = nr(sharedPreferencesNr.getString("custom_a", null));
        if (TextUtils.isEmpty(strNr)) {
            strNr = sharedPreferencesNr.getString("clientudid", null);
        }
        if (!yd.u(strNr)) {
            try {
                strNr = UUID.randomUUID().toString();
                strNr = u("clientudid.dat", strNr);
            } catch (Exception unused) {
            }
            String strU = u(strNr);
            SharedPreferences.Editor editorEdit = sharedPreferencesNr.edit();
            editorEdit.putString("custom_a", strU);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strNr);
        return true;
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}

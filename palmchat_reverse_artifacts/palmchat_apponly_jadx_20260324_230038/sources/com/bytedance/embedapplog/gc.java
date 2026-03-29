package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class gc extends w {
    private final mh iz;
    private final Context pn;

    public gc(Context context, mh mhVar) {
        super(false, false);
        this.pn = context;
        this.iz = mhVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please report as a decompilation issue!!! */
    @Override // com.bytedance.embedapplog.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(JSONObject jSONObject) throws Throwable {
        String strCj;
        mh mhVar;
        try {
            mhVar = this.iz;
        } catch (Exception e) {
            ti.fx("", e);
        }
        if (mhVar == null) {
            strCj = null;
        } else if (mhVar.w()) {
            strCj = Settings.Secure.getString(this.pn.getContentResolver(), "android_id");
        } else {
            strCj = this.iz.cj();
            if (TextUtils.isEmpty(strCj)) {
            }
        }
        if (!yd.u(strCj) || "9774d56d682e549c".equals(strCj)) {
            SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.pn, "snssdk_openudid", 0);
            String strNr = wi.nr(sharedPreferencesNr.getString("custom_b", null));
            String string = TextUtils.isEmpty(strNr) ? sharedPreferencesNr.getString("openudid", null) : strNr;
            if (!yd.u(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = u("openudid.dat", string);
                } catch (Exception unused) {
                }
                String strU = wi.u(string);
                SharedPreferences.Editor editorEdit = sharedPreferencesNr.edit();
                editorEdit.putString("custom_b", strU);
                editorEdit.apply();
            }
            strCj = string;
        }
        jSONObject.put("openudid", strCj);
        return true;
    }
}

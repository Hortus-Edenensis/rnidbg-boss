package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.cdo.oaps.ad.OapsWrapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class qq extends bq {
    public qq(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.bq
    public String fx() {
        return "d_i0";
    }

    @Override // com.bytedance.embedapplog.bq
    public String nr() {
        JSONArray jSONArrayOptJSONArray = this.b.optJSONArray(OapsWrapper.KEY_PATH);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return "";
        }
        int length = jSONArrayOptJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e) {
                bg.nr("__kite" + fx() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (bg.nr()) {
            bg.u("__kite" + fx() + " plist size: " + length);
        }
        try {
            return u(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.fx = e2.getCause().getMessage();
            } else {
                this.fx = e2.getMessage();
            }
            return "";
        }
    }

    public String u(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result == null || dI0Result.length <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < dI0Result.length; i++) {
                jSONObject.put(strArr[i], dI0Result[i]);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}

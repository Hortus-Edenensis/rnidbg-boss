package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.cdo.oaps.ad.OapsWrapper;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class q extends bq {
    public q(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.bq
    public String fx() {
        return "d_a0";
    }

    @Override // com.bytedance.embedapplog.bq
    public String nr() {
        JSONArray jSONArrayOptJSONArray = this.b.optJSONArray(OapsWrapper.KEY_PATH);
        if (jSONArrayOptJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String string = jSONArrayOptJSONArray.getString(i);
                jSONObject.put(string, u(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.fx = e.getCause().getMessage();
                } else {
                    this.fx = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    public String u(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (bg.nr()) {
                bg.u("__kite", "p：" + str + " r:" + dA0Result);
            }
            return !TextUtils.isEmpty(dA0Result) ? dA0Result : "";
        } catch (Exception unused) {
            return "";
        }
    }
}

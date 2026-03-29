package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.io.Serializable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c {
    private static final String Code = "MsgConverter";

    public static Intent Code(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            String strOptString = jSONObject.optString(be.v);
            intent.setAction(jSONObject.optString(be.y));
            intent.putExtra(be.v, strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(be.w);
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObjectOptJSONObject.get(next);
                    if (obj instanceof Serializable) {
                        intent.putExtra(next, (Serializable) obj);
                    }
                }
            }
            return intent;
        } catch (JSONException unused) {
            fh.I(Code, "convertMsgJsonToIntent JSONException");
            return null;
        }
    }

    public static String Code(String str, String str2, Intent intent) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            Bundle extras = safeIntent.getExtras();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(be.u, str);
                jSONObject2.put(be.v, str2);
                jSONObject2.put(be.y, safeIntent.getAction());
                if (extras != null) {
                    for (String str3 : extras.keySet()) {
                        try {
                            jSONObject.putOpt(str3, extras.get(str3));
                        } catch (JSONException unused) {
                            fh.I(Code, "convertMsgToJson - msg json set exception");
                        }
                    }
                    jSONObject2.put(be.w, jSONObject);
                }
                return jSONObject2.toString();
            } catch (Throwable unused2) {
                fh.I(Code, "convertMsgToJson - param json set exception");
            }
        }
        return "";
    }
}

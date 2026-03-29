package com.bytedance.sdk.openadsdk.core.my;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.bf;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static void fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("fsswiper_freq");
        try {
            String str2 = fxVarU.get(str, "");
            JSONObject jSONObject = TextUtils.isEmpty(str2) ? new JSONObject() : new JSONObject(str2);
            String strU = u();
            int iOptInt = jSONObject.optInt(strU, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(strU, iOptInt + 1);
            fxVarU.put(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    public static void nr(String str) {
        fx(str);
    }

    public static boolean u(String str) {
        int iCb;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = bf.u("fsswiper_freq").get(str, "");
            if (TextUtils.isEmpty(str2) || (iCb = dw.nr().cb()) <= 0) {
                return false;
            }
            if (new JSONObject(str2).optInt(u(), 0) >= iCb) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String u() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.bytedance.sdk.openadsdk.api.plugin.fx;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static SecureRandom fx() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strU = u(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strU == null) ? str : u.nr(str.substring(49), strSubstring, strU);
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strU = u();
        String strU2 = u(strU, 32);
        String strNr = nr();
        return 3 + strU + strNr + ((strU2 == null || strNr == null) ? null : u.u(str, strNr, strU2));
    }

    public static String nr() {
        String strU = u(8);
        if (strU == null || strU.length() != 16) {
            return null;
        }
        return strU;
    }

    public static JSONObject u(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strU = u(jSONObject.toString());
                if (!TextUtils.isEmpty(strU)) {
                    jSONObject2.put("message", strU);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String u() {
        String strU = u(16);
        if (strU == null || strU.length() != 32) {
            return null;
        }
        return strU;
    }

    public static String u(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String u(int i) {
        try {
            byte[] bArr = new byte[i];
            fx().nextBytes(bArr);
            return b.u(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

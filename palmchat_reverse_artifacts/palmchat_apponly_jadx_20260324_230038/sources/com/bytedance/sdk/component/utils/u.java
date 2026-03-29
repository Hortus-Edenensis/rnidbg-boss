package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0231u {
        static final Random u = u.fx();
    }

    public static String fx(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strU = u(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strU == null) ? str : com.bytedance.sdk.component.pn.u.nr(str.substring(49), strSubstring, strU);
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strU = u();
        String strU2 = u(strU, 32);
        String strNr = nr();
        return 3 + strU + strNr + ((strU2 == null || strNr == null) ? null : com.bytedance.sdk.component.pn.u.u(str, strNr, strU2));
    }

    public static JSONObject u(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : u(jSONObject.toString());
    }

    public static JSONObject u(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strNr = nr(str);
                if (!TextUtils.isEmpty(strNr)) {
                    jSONObject.put("message", strNr);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable unused) {
            jSONObject.put("message", str);
            jSONObject.put("cypher", 0);
        }
        return jSONObject;
    }

    public static Random fx() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public static String nr() {
        String strU = u(8);
        if (strU == null || strU.length() != 16) {
            return null;
        }
        return strU;
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
            C0231u.u.nextBytes(bArr);
            return x.u(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

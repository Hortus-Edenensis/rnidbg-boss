package com.qq.gdt.action.j;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    char c = 0;
                    boolean z = false;
                    int i2 = 0;
                    while (i < str.length()) {
                        char cCharAt = str.charAt(i);
                        if (cCharAt != '\"') {
                            if (cCharAt != ',') {
                                if (cCharAt != '[') {
                                    if (cCharAt == ']') {
                                        if (!z) {
                                            sb.append('\n');
                                            i2--;
                                            a(sb, i2);
                                        }
                                    } else if (cCharAt != '{') {
                                        if (cCharAt == '}') {
                                        }
                                    }
                                }
                                sb.append(cCharAt);
                                if (!z) {
                                    sb.append('\n');
                                    i2++;
                                    a(sb, i2);
                                }
                            } else {
                                sb.append(cCharAt);
                                if (c != '\\' && !z) {
                                    sb.append('\n');
                                    a(sb, i2);
                                }
                            }
                            i++;
                            c = cCharAt;
                        } else if (c != '\\') {
                            z = !z;
                        }
                        sb.append(cCharAt);
                        i++;
                        c = cCharAt;
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static JSONObject a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(str, Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }
}

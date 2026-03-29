package com.bytedance.sdk.component.t.n;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static JSONObject u(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            int iIndexOf = strDecode.indexOf(63);
            if (iIndexOf == -1) {
                return jSONObject;
            }
            Matcher matcher = Pattern.compile("([^&=]+)=((?:\\$\\{[^}]+\\})|[^&]+)").matcher(strDecode.substring(iIndexOf + 1));
            while (matcher.find()) {
                jSONObject.put(matcher.group(1), matcher.group(2));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}

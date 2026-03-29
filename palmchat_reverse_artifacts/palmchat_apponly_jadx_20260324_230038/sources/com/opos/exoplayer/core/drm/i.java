package com.opos.exoplayer.core.drm;

import com.kuaishou.weapon.p0.t;
import com.opos.exoplayer.core.util.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8152a = Pattern.compile("\"kids\":\\[\"(.*?)\"]");

    private static String a(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    public static byte[] b(byte[] bArr) {
        if (y.f8407a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(y.a(bArr));
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                jSONObject2.put(t.f7496a, a(jSONObject2.getString(t.f7496a)));
                jSONObject2.put("kid", a(jSONObject2.getString("kid")));
            }
            return y.c(jSONObject.toString());
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.d("ClearKeyUtil", "Failed to adjust response data: " + y.a(bArr), e);
            return bArr;
        }
    }

    private static void a(StringBuilder sb, int i, int i2) {
        char c;
        while (i < i2) {
            char cCharAt = sb.charAt(i);
            if (cCharAt == '+') {
                c = '-';
            } else if (cCharAt != '/') {
                i++;
            } else {
                c = '_';
            }
            sb.setCharAt(i, c);
            i++;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (y.f8407a >= 27) {
            return bArr;
        }
        String strA = y.a(bArr);
        Matcher matcher = f8152a.matcher(strA);
        if (matcher.find()) {
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            StringBuilder sb = new StringBuilder(strA);
            a(sb, iStart, iEnd);
            return y.c(sb.toString());
        }
        com.opos.cmn.an.f.a.d("ClearKeyUtil", "Failed to adjust request data: " + strA);
        return bArr;
    }
}

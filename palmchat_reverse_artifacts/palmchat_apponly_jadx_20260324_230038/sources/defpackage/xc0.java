package defpackage;

import com.kuaishou.weapon.p0.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xc0 {
    public static byte[] a(byte[] bArr) {
        return g86.f17680a >= 27 ? bArr : g86.o0(c(g86.D(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (g86.f17680a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(g86.D(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString(t.f7496a)));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return g86.o0(sb.toString());
        } catch (JSONException e) {
            y53.d("ClearKeyUtil", "Failed to adjust response data: " + g86.D(bArr), e);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}

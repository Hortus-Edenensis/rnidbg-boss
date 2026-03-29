package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.fv;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2844a = ge.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String b = ge.c("FbGJzX3Nkaw");
    private static final String c = ge.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String d = ge.c("FQU5EU0RLMTA");
    private static final String e = ge.c("FMTAw");
    private static boolean f = false;
    private String g = "";

    public static fv.a a() {
        return new fv.a() { // from class: com.amap.api.col.2sl.gt.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private gt f2845a = new gt();

            @Override // com.amap.api.col.2sl.fv.a
            public final id a(byte[] bArr, Map<String, String> map) {
                return new hw(bArr, map);
            }

            @Override // com.amap.api.col.2sl.fv.a
            public final Map<String, String> b() {
                return this.f2845a.b();
            }

            @Override // com.amap.api.col.2sl.fv.a
            public final String a() {
                return gt.c();
            }

            @Override // com.amap.api.col.2sl.fv.a
            public final String a(Context context, String str) {
                return gt.a(context, str);
            }

            @Override // com.amap.api.col.2sl.fv.a
            public final String a(String str, String str2, String str3, String str4) {
                return this.f2845a.a(str, str2, str3, str4);
            }
        };
    }

    public static String c() {
        return gu.a();
    }

    private String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String strA = fw.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strA.length(); i++) {
            stringBuffer.append((char) (strA.charAt(i) - (i % 48)));
        }
        String string = stringBuffer.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < string.length() / 2; i2++) {
            stringBuffer2.append((char) ((string.charAt(i2) + string.charAt((string.length() - 1) - i2)) / 2));
        }
        String string2 = stringBuffer2.toString();
        this.g = string2;
        return string2;
    }

    public final synchronized Map<String, String> b() {
        if (f) {
            return null;
        }
        f = true;
        HashMap map = new HashMap();
        map.put(ge.c("FZW50"), ge.c("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(ge.c("SY2hhbm5lbD0"));
        String str = b;
        sb.append(str);
        sb.append(ge.c("SJmRpdj0"));
        String str2 = d;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(ge.c("FQA"));
        stringBuffer.append(c);
        String strA = gw.a(stringBuffer.toString());
        sb.append(ge.c("FJnNpZ249"));
        sb.append(strA.toUpperCase(Locale.US));
        sb.append(ge.c("SJm91dHB1dD1qc29u") + "\u0000");
        map.put(ge.c("FaW4"), gr.a(ht.a(sb.toString().getBytes(), f2844a.getBytes())));
        map.put(ge.c("Sa2V5dA"), e);
        return map;
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(ge.c("UY29kZQ")) != 1) {
                return "";
            }
            String strOptString = new JSONObject(jSONObject.optString(ge.c("FZGF0YQ"))).optString(ge.c("FYWRpdQ"));
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            gu.a(strOptString);
            gp.a(context).a(strOptString);
            return strOptString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ge.c("LdGlk"), str);
            jSONObject.put(ge.c("FZGl1"), str2);
            jSONObject.put(ge.c("AZGl1Mg"), str3);
            jSONObject.put(ge.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String strA = gw.a();
        if (!TextUtils.isEmpty(strA)) {
            String strA2 = gr.a(ht.a((string + "\u0000").getBytes(), strA.getBytes()));
            if (!TextUtils.isEmpty(strA2)) {
                try {
                    return ge.c("Fa2V5PQ") + URLEncoder.encode(gr.a(gv.a(strA.getBytes("utf-8"), gv.a(d())))) + ge.c("SJmRhdGE9") + URLEncoder.encode(strA2);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }
}

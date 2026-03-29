package defpackage;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class wq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21773a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;

    public void a(HashMap<String, String> map) {
        String str = this.f21773a;
        if (str != null) {
            map.put("exceptionClassName", str);
        }
        String str2 = this.b;
        if (str2 != null) {
            map.put("exceptionMessage", str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            map.put("throwFileName", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            map.put("throwClassName", str4);
        }
        String str5 = this.e;
        if (str5 != null) {
            map.put("throwMethodName", str5);
        }
        map.put("throwLineNumber", String.valueOf(this.f));
        String str6 = this.g;
        if (str6 != null) {
            map.put("stackTrace", str6);
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f21773a;
            if (str != null) {
                jSONObject.put("exceptionClassName", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put("exceptionMessage", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("throwFileName", str3);
            }
            String str4 = this.d;
            if (str4 != null) {
                jSONObject.put("throwClassName", str4);
            }
            String str5 = this.e;
            if (str5 != null) {
                jSONObject.put("throwMethodName", str5);
            }
            jSONObject.put("throwLineNumber", String.valueOf(this.f));
            String str6 = this.g;
            if (str6 != null) {
                jSONObject.put("stackTrace", str6);
            }
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}

package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18670a;
    public String b;
    public String c;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f18670a;
            if (str != null) {
                jSONObject.put("activity", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put("cause", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("info", str3);
            }
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}

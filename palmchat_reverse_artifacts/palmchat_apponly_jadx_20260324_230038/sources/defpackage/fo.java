package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fo {
    public static void a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", i);
            zn6.g("common_complain", jSONObject);
        } catch (Exception unused) {
        }
    }
}

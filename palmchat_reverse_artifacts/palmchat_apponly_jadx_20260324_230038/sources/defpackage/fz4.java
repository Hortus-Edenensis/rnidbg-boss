package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fz4 extends JSONObject {
    public String a(String str) {
        return optString(str);
    }

    public void b(String str, Object obj) {
        try {
            put(str, obj);
        } catch (JSONException e) {
            ma3.c(e);
        }
    }
}

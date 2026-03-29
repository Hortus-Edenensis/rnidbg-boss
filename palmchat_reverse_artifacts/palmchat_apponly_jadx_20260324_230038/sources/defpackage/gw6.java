package defpackage;

import android.os.Process;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class gw6 {
    public final String a(String str, String str2, byte b) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("m", str2);
            jSONObject.put("t", str);
            jSONObject.put("l", (int) b);
            jSONObject.put("p", o17.j(o17.a()));
            jSONObject.put("pid", Process.myPid());
            return jSONObject.toString();
        } catch (JSONException e) {
            if (k17.k()) {
                e.printStackTrace();
            }
            return "format exception:" + e.toString();
        }
    }
}

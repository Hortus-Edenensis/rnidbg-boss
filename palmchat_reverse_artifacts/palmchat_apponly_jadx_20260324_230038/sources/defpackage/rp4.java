package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class rp4 extends gu3 {
    public rp4(int i, String str) {
        super(i, str);
    }

    public final JSONObject W(boolean z) {
        JSONObject jSONObjectO = O(z);
        try {
            if (z) {
                jSONObjectO.put("version", 0);
            } else {
                jSONObjectO.put("version", this.w);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectO;
    }

    @Override // defpackage.gu3, defpackage.om2
    public JSONObject a() {
        return W(false);
    }

    @Override // defpackage.gu3, defpackage.om2
    public JSONObject b() {
        return W(true);
    }

    @Override // defpackage.gu3, defpackage.br
    public boolean t() {
        return true;
    }

    @Override // defpackage.gu3, defpackage.br
    public boolean u() {
        return false;
    }
}

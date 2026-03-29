package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class cu3 extends au4 {
    public cu3(String str, int i) {
        super(str, i);
    }

    @Override // defpackage.au4, defpackage.yt1
    public boolean E() {
        return false;
    }

    @Override // defpackage.au4
    public JSONObject T(boolean z) {
        JSONObject jSONObjectT = super.T(z);
        if (this.d != null) {
            return jSONObjectT;
        }
        s(1);
        if (!a46.p()) {
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return m("获取位置信息失败");
        }
        try {
            jSONObjectT.put("needServerLocate", 1);
            return jSONObjectT;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObjectT;
        }
    }

    @Override // defpackage.au4, defpackage.om2
    public JSONObject a() {
        return super.a();
    }

    @Override // defpackage.au4, defpackage.om2
    public JSONObject b() {
        return super.b();
    }

    @Override // defpackage.au4, defpackage.br
    public boolean t() {
        return true;
    }

    @Override // defpackage.au4, defpackage.yt1, defpackage.br
    public boolean u() {
        return true;
    }
}

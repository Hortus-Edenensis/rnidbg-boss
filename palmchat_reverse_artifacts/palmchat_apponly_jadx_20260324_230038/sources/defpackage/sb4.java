package defpackage;

import android.os.Bundle;
import com.zenmen.palmchat.greendao.model.Feed;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sb4 extends wq3 {
    public sb4(int i, String str, Bundle bundle) {
        super(i, str, bundle);
    }

    @Override // defpackage.wq3, defpackage.om2
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        Feed feedV = v();
        try {
            if (feedV != null) {
                jSONObjectA.put("outboxUid", feedV.getUid());
                jSONObjectA.put("version", feedV.getVersion());
            } else {
                jSONObjectA.put("version", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObjectA;
    }
}

package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vb4 extends ut1 {
    public long k;

    public vb4(int i, String str, Bundle bundle) {
        super(i, str, bundle);
        this.k = System.currentTimeMillis() / 100;
    }

    @Override // defpackage.ut1, defpackage.om2
    public JSONObject a() {
        ContactInfoItem contactInfoItemA;
        JSONObject jSONObjectA = super.a();
        try {
            String strE = v4.e(c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                jSONObjectA.put("sex", contactInfoItemA.getGender());
            }
            int i = this.h;
            if (i == 47) {
                jSONObjectA.put("cityCode", this.j.getString("key_city_code"));
                jSONObjectA.put("type", "hotCity");
            } else if (i == 6) {
                jSONObjectA.put("type", "topic");
                jSONObjectA.put("topicId", z().topicId);
            }
            jSONObjectA.put("pageKey", this.k);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObjectA;
    }
}

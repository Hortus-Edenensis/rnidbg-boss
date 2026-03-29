package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kq3 f18808a;

    public static kq3 a() {
        if (f18808a == null) {
            synchronized (kq3.class) {
                if (f18808a == null) {
                    f18808a = new kq3();
                }
            }
        }
        return f18808a;
    }

    public final String b() {
        return k86.a("MomentKey");
    }

    public final String c() {
        return k86.a("MomentKey_public");
    }

    public boolean d() {
        return r75.g(AppContext.getContext(), c(), 1) == 1;
    }

    public void e(int i) {
        r75.p(AppContext.getContext(), c(), i);
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            LogUtil.i("MomentHelper", "updateInfo: " + jSONObject.toString());
            g(jSONObject);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cover");
            if (jSONArrayOptJSONArray == null) {
                LogUtil.i("MomentHelper", "coverArray null: " + jSONObject.toString());
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
            ContactInfoItem contactInfoItemA = dn0.a(v4.e(c.b()));
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            if (contactInfoItemA == null) {
                r75.r(AppContext.getContext(), b(), jSONObject.toString());
                return;
            }
            LogUtil.i("MomentHelper", "self null");
            contactInfoItemA.setAlbum_cover(jSONObjectOptJSONObject);
            dn0.e(contactInfoItemA);
        }
    }

    public final void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("public_", Integer.MIN_VALUE);
            if (iOptInt != Integer.MIN_VALUE) {
                e(iOptInt);
            }
        } catch (Exception unused) {
        }
    }
}

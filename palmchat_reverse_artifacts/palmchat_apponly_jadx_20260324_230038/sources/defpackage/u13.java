package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class u13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u13 f21114a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21115a;
        public boolean b;

        public static a a(String str) {
            a aVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar2 = new a();
                try {
                    aVar2.b = jSONObject.optBoolean("display");
                    aVar2.f21115a = jSONObject.optString("headImgUrl");
                    return aVar2;
                } catch (JSONException e) {
                    e = e;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }

        public String b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("display", this.b);
                jSONObject.put("headImgUrl", this.f21115a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public static u13 b() {
        if (f21114a == null) {
            synchronized (u13.class) {
                if (f21114a == null) {
                    f21114a = new u13();
                }
            }
        }
        return f21114a;
    }

    public void a() {
        if (nx3.a("key_people_nearby")) {
            nx3.e("key_people_nearby");
        }
        a aVarC = c();
        if (aVarC != null && aVarC.b) {
            aVarC.b = false;
            e(aVarC.b());
        }
        st2.k(true);
    }

    public a c() {
        a aVarA = a.a(r75.i(AppContext.getContext(), d()));
        LogUtil.i("LbsTabHelper", aVarA == null ? "lbsInfo is null" : aVarA.b());
        return aVarA;
    }

    public final String d() {
        return k86.a("LbsTabKey");
    }

    public final void e(String str) {
        if (str == null || a.a(str) == null) {
            return;
        }
        r75.r(AppContext.getContext(), d(), str);
    }

    public void f(JSONObject jSONObject) {
        LogUtil.i("LbsTabHelper", "updateInfo" + jSONObject);
        if (jSONObject != null) {
            e(jSONObject.toString());
            Intent intent = new Intent();
            intent.setAction(mo3.h);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        }
    }
}

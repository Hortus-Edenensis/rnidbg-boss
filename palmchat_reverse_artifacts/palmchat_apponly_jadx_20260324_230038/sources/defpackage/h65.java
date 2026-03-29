package defpackage;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class h65 {
    public static String g = "sessionstorage";
    public static String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JsonArray f17879a;
    public long b;
    public long c;
    public long d;
    public JSONObject e = new JSONObject();
    public String f;

    public final void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionid", h);
            jSONObject.put("activity", this.f17879a.toString());
            jSONObject.put("start", this.b);
            jSONObject.put("end", ir5.b());
            String string = jSONObject.toString();
            zn6.d(g, null, string);
            z53.a("SessionStorageManager", string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(long j, long j2, String str) {
        try {
            this.e.put("astart", j);
            this.e.put("aname", str);
            this.e.put("aend", j2);
            this.f17879a.add(this.e.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void c() {
        if (TextUtils.isEmpty(h)) {
            d();
        }
    }

    public final void d() {
        this.b = ir5.b();
        this.f17879a = new JsonArray();
        h = rb3.c(AccountUtils.p(AppContext.getContext()) + UUID.randomUUID().toString().replace("-", ""));
        this.d = -1L;
        this.f = "";
        z53.a("SessionStorageManager", "initUUID");
    }

    public void e(String str) {
        c();
        this.d = ir5.b();
        if (!TextUtils.isEmpty(this.f)) {
            b(this.c, this.d, this.f);
        }
        long jB = ir5.b();
        this.c = jB;
        this.f = str;
        this.d = jB;
        z53.a("SessionStorageManager", "reportActivity");
    }

    public void f() {
        z53.a("SessionStorageManager", "reportAppOnDestroyed");
        b(this.c, ir5.b(), this.f);
        a();
        h = null;
    }

    public void g() {
        c();
        z53.a("SessionStorageManager", "reportAppOnCreate");
    }
}

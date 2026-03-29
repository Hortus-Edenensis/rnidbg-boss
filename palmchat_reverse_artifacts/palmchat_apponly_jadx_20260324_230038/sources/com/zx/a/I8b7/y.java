package com.zx.a.I8b7;

import com.huawei.hms.api.FailedBinderCallBack;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.v3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f16885a = new JSONArray();
    public JSONArray b = new JSONArray();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16886a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String str, String str2, String str3) {
            this.f16886a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (y.this.f16885a.length() >= 100) {
                    r2.a("events length > MAX_COUNT " + y.this.f16885a.length());
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", jCurrentTimeMillis);
                jSONObject.put(FailedBinderCallBack.CALLER_ID, this.f16886a);
                jSONObject.put("action", this.b);
                jSONObject.put("params", this.c);
                y.this.f16885a.put(jSONObject);
                r2.a("events add:" + jSONObject.toString());
                if (m3.G) {
                    r2.a("events save:" + y.this.f16885a.toString());
                    l2 l2Var = l2.a.f16824a;
                    u3 u3Var = l2Var.f16823a;
                    String string = y.this.f16885a.toString();
                    u3Var.getClass();
                    l2Var.f16823a.a(23, string, true);
                }
            } catch (Throwable th) {
                r2.a(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f16887a = new y();
    }

    public final void a(Runnable runnable) {
        try {
            v3.f.f16875a.b.execute(runnable);
        } catch (Throwable th) {
            r2.a(th);
        }
    }

    public final JSONArray a(JSONArray jSONArray, JSONArray jSONArray2, int i) throws JSONException {
        JSONArray jSONArray3 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray3.length() >= i) {
                return jSONArray3;
            }
            jSONArray3.put(jSONArray.get(i2));
        }
        for (int i3 = 0; i3 < jSONArray2.length() && jSONArray3.length() < i; i3++) {
            jSONArray3.put(jSONArray2.get(i3));
        }
        return jSONArray3;
    }

    public void a(String str, String str2, String str3) {
        try {
            a(new a(str, str2, str3));
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}

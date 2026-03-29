package com.zx.a.I8b7;

import com.zx.a.I8b7.n3;
import com.zx.module.base.Callback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class o1 implements Runnable {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callback {
        public a(o1 o1Var) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("code") == 0) {
                    v1.b(jSONObject.getJSONObject("data").getString("type"), jSONObject.getJSONObject("data").getString("code"));
                }
            } catch (Throwable th) {
                r2.a(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            n3.b.f16836a.b(new JSONObject(), new a(this), 2);
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}

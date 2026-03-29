package com.zx.a.I8b7;

import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.n3;
import com.zx.module.base.Callback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class g implements Runnable {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callback {
        public a(g gVar) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                if (new JSONObject(str).getInt("code") == 10010) {
                    l2 l2Var = l2.a.f16824a;
                    l2Var.f16823a.getClass();
                    l2Var.f16823a.a(322, str, true);
                    r2.a("isp net Err had changed refresh: value");
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

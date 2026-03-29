package com.unicom.xiaowo.account.shield.b;

import android.os.Handler;
import android.os.Looper;
import com.unicom.xiaowo.account.shield.ResultListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11184a = false;
    private static volatile c b;
    private Handler c = new Handler(Looper.getMainLooper());
    private ResultListener d = null;

    private c() {
    }

    public static c b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public void a(ResultListener resultListener) {
        f11184a = false;
        if (this.d != null) {
            this.d = null;
        }
        this.d = resultListener;
    }

    public void b(String str) {
        this.c.post(new a(this, str));
    }

    public void a(String str) {
        this.c.post(new b(this, str));
    }

    public static void a(ResultListener resultListener, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("traceId", "");
            jSONObject.put("operatorType", "CU");
            resultListener.onResult(jSONObject.toString());
        } catch (Exception e) {
            com.unicom.xiaowo.account.shield.c.b.b("sendLoginFail error:" + e.getMessage());
        }
    }
}

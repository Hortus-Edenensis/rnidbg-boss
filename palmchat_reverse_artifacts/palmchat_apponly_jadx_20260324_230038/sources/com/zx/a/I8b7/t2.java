package com.zx.a.I8b7;

import android.content.Context;
import android.text.TextUtils;
import com.zx.a.I8b7.l2;
import com.zx.sdk.api.Callback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class t2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f16865a;
    public final /* synthetic */ Callback b;

    public t2(x2 x2Var, Context context, Callback callback) {
        this.f16865a = context;
        this.b = callback;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005c -> B:27:0x007b). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        String strA;
        try {
            Context context = this.f16865a;
            if (TextUtils.isEmpty(m3.j) || "{}".equals(m3.j)) {
                m3.f16830a = context.getApplicationContext();
                l2 l2Var = l2.a.f16824a;
                m3.a(l2Var.f16823a);
                strA = l2Var.f16823a.a(16);
                m3.j = strA;
            } else {
                strA = m3.j;
            }
            try {
                String strOptString = new JSONObject(strA).optString("openid");
                if ("OPENID_CLOSED".equals(strOptString)) {
                    this.b.onFailed(10001, "未开通");
                } else {
                    Callback callback = this.b;
                    if (TextUtils.isEmpty(strOptString)) {
                        strOptString = "";
                    }
                    callback.onSuccess(strOptString);
                }
            } catch (Throwable th) {
                this.b.onFailed(10000, th.getMessage());
            }
        } catch (Throwable th2) {
            Callback callback2 = this.b;
            if (callback2 != null) {
                callback2.onFailed(10000, th2.getMessage());
            }
            g3.a(th2, f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}

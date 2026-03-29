package com.zx.a.I8b7;

import android.content.Context;
import android.text.TextUtils;
import com.zx.a.I8b7.v;
import com.zx.module.annotation.Java2C;
import com.zx.module.base.Callback;
import com.zx.module.base.ZXModule;
import com.zx.module.context.ContextHolder;
import com.zx.module.exception.ZXModuleInvokeException;
import com.zx.sdk.api.SAIDCallback;
import com.zx.sdk.api.ZXIDListener;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class h3 {
    public static final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZXModule f16804a = null;
    public final y0 b;
    public final q2 c;
    public final p2 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ContextHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16805a;

        public a(h3 h3Var, Context context) {
            this.f16805a = context;
        }

        @Override // com.zx.module.context.ContextHolder
        public Object getContext() {
            return this.f16805a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SAIDCallback f16806a;

        public b(h3 h3Var, SAIDCallback sAIDCallback) {
            this.f16806a = sAIDCallback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f16806a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f16806a.onFailed(i, jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                r2.a(th);
                SAIDCallback sAIDCallback = this.f16806a;
                if (sAIDCallback != null) {
                    sAIDCallback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zx.sdk.api.Callback f16807a;

        public c(h3 h3Var, com.zx.sdk.api.Callback callback) {
            this.f16807a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f16807a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f16807a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (Throwable th) {
                r2.a(th);
                com.zx.sdk.api.Callback callback = this.f16807a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zx.sdk.api.Callback f16808a;

        public d(h3 h3Var, com.zx.sdk.api.Callback callback) {
            this.f16808a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.f16808a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.f16808a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (Throwable th) {
                r2.a(th);
                com.zx.sdk.api.Callback callback = this.f16808a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h3 f16809a = new h3();
    }

    public h3() {
        y0 y0Var = new y0();
        this.b = y0Var;
        q2 q2Var = new q2();
        this.c = q2Var;
        p2 p2Var = new p2();
        this.d = p2Var;
        y0Var.a("MESSAGE_ON_ZXID_CHANGED", q2Var);
        y0Var.a("MESSAGE_ON_ZXID_RECEIVED", p2Var);
        try {
            a(m3.f16830a);
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXModule init failed: "));
        }
    }

    @Java2C.Method2C
    public native String a(String str, String str2, String str3, String str4, String str5, String str6, SAIDCallback sAIDCallback) throws JSONException, ZXModuleInvokeException;

    public void a(Context context) throws i2 {
        try {
            if (e.getAndSet(true)) {
                return;
            }
            this.f16804a = v.a.f16871a.a(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "3.3.4.43514");
            this.f16804a.invoke("setSDKVersion", jSONObject.toString());
            this.f16804a.onCreate(new a(this, context));
            this.f16804a.setMessageListener(this.b);
        } catch (Exception e2) {
            e.set(false);
            StringBuilder sbA = f3.a("Raised exception while initializing: ");
            sbA.append(e2.getMessage());
            throw new i2(sbA.toString(), e2);
        }
    }

    @Java2C.Method2C
    public native void a(String str, com.zx.sdk.api.Callback callback) throws JSONException, ZXModuleInvokeException;

    @Java2C.Method2C
    public native void a(boolean z) throws JSONException, ZXModuleInvokeException;

    @Java2C.Method2C
    public native void b(String str, com.zx.sdk.api.Callback callback) throws JSONException, ZXModuleInvokeException;

    public void a() throws i2 {
        try {
            this.f16804a.start();
        } catch (Exception e2) {
            StringBuilder sbA = f3.a("Raised exception in start: ");
            sbA.append(e2.getMessage());
            throw new i2(sbA.toString(), e2);
        }
    }

    public void a(String str, ZXIDListener zXIDListener) throws i2 {
        if (zXIDListener != null) {
            try {
                p2 p2Var = this.d;
                p2Var.getClass();
                if (!TextUtils.isEmpty(str)) {
                    LinkedList<ZXIDListener> linkedList = p2Var.f16843a.get(str);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(zXIDListener);
                    p2Var.f16843a.put(str, linkedList);
                }
            } catch (Exception e2) {
                r2.a(e2);
                StringBuilder sbA = f3.a("Raised exception while getZXID: nested exception is ");
                sbA.append(e2.getMessage());
                throw new i2(sbA.toString(), e2);
            }
        }
        a();
    }
}

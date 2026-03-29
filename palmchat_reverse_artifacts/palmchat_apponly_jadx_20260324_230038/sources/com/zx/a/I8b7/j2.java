package com.zx.a.I8b7;

import android.content.Context;
import com.zx.a.I8b7.v3;
import com.zx.module.base.Callback;
import com.zx.module.base.Listener;
import com.zx.module.base.ZXModule;
import com.zx.module.context.ContextHolder;
import com.zx.module.exception.ZXModuleInvokeException;
import com.zx.module.exception.ZXModuleOnCreateException;
import com.zx.module.exception.ZXModuleOnDestroyException;
import com.zx.module.exception.ZXModuleStartException;
import com.zx.sdk.common.utils.ZXTask;
import java.lang.reflect.Method;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class j2 implements ZXModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o3 f16814a;
    public final h2 b = new h2();

    @Override // com.zx.module.base.ZXModule
    public String getModuleIdentifier() {
        return "core-n";
    }

    @Override // com.zx.module.base.ZXModule
    public String getModuleVersion() {
        return "3.3.4.43514";
    }

    @Override // com.zx.module.base.ZXModule
    public String invoke(String str, String str2) throws ZXModuleInvokeException {
        h2 h2Var = this.b;
        h2Var.getClass();
        try {
            String strSubstring = p.a(str, "SHA256").substring(0, 16);
            if (!((HashSet) h2.b).contains(strSubstring)) {
                return h2Var.a(str + " not in invokableMethods", 3);
            }
            Method declaredMethod = h2.class.getDeclaredMethod("f" + strSubstring, String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(h2Var, str2);
        } catch (Exception e) {
            r2.a(e);
            throw new ZXModuleInvokeException("Cannot invoke " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public String invokeAsync(String str, String str2, Callback callback) throws ZXModuleInvokeException {
        h2 h2Var = this.b;
        h2Var.getClass();
        try {
            String strSubstring = p.a(str, "SHA256").substring(0, 16);
            if (!((HashSet) h2.b).contains(strSubstring)) {
                String strA = h2Var.a(str + " not in invokableMethods", 3);
                callback.callback(strA);
                return strA;
            }
            r2.a("开始执行invokeAsync: method:" + str + "; " + str2 + ":cb");
            StringBuilder sb = new StringBuilder();
            sb.append("f");
            sb.append(strSubstring);
            Method declaredMethod = h2.class.getDeclaredMethod(sb.toString(), String.class, Callback.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(h2Var, str2, callback);
        } catch (Exception e) {
            StringBuilder sbA = f3.a("开始执行invokeAsync:");
            sbA.append(e.getMessage());
            r2.b(sbA.toString());
            throw new ZXModuleInvokeException("Cannot invokeAsync " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public void onCreate(ContextHolder contextHolder) throws ZXModuleOnCreateException {
        t3 t3Var = new t3();
        this.f16814a = t3Var;
        Context context = (Context) contextHolder.getContext();
        try {
            if (!t3Var.b.getAndSet(true)) {
                v3.f.f16875a.f16874a.execute(new s3(t3Var, context));
            }
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXCore init failed: "));
            t3Var.b.set(false);
        }
        this.b.f16803a = this.f16814a;
    }

    @Override // com.zx.module.base.ZXModule
    public void setMessageListener(Listener listener) {
        t3 t3Var = (t3) this.f16814a;
        t3Var.getClass();
        t3Var.c = new p3(t3Var, listener);
    }

    @Override // com.zx.module.base.ZXModule
    public void start() throws ZXModuleStartException {
        t3 t3Var = (t3) this.f16814a;
        if (t3Var.f16866a.compareAndSet(false, true)) {
            try {
                v3.f.f16875a.f16874a.execute(new ZXTask(new q3(t3Var), new r3(t3Var)));
            } catch (Throwable th) {
                t3Var.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", e2.a(10007, th.getMessage()));
                StringBuilder sb = new StringBuilder();
                sb.append("ZXCore start failed: ");
                g3.a(th, sb);
            }
        }
    }

    @Override // com.zx.module.base.ZXModule
    public void onDestroy() throws ZXModuleOnDestroyException {
    }
}

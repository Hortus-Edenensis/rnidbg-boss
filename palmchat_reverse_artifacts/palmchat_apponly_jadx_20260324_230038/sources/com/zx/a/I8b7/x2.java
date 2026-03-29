package com.zx.a.I8b7;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.zx.a.I8b7.h3;
import com.zx.a.I8b7.k3;
import com.zx.a.I8b7.v3;
import com.zx.module.annotation.Java2C;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f16882a = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16883a;

        public a(Context context) {
            this.f16883a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                m3.b(this.f16883a);
                try {
                    x2.a().a();
                } catch (Throwable th) {
                    Log.i("core info Except", "can ignore," + th.getMessage());
                }
            } catch (Throwable th2) {
                g3.a(th2, f3.a("ZXCore init failed: "));
                x2.f16882a.set(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x2 f16884a = new x2();
    }

    public static h3 a() {
        Handler handler = k3.f16820a;
        k3 k3Var = k3.a.f16821a;
        if (k3Var.b()) {
            throw new RuntimeException("请先调用 ZXManager.checkPermission() 检查用户是否已授权");
        }
        if (!k3Var.a()) {
            throw new RuntimeException("用户未授权");
        }
        AtomicBoolean atomicBoolean = h3.e;
        return h3.e.f16809a;
    }

    public static final x2 b() {
        if (f16882a.get()) {
            return b.f16884a;
        }
        throw new IllegalStateException("ZXManager not init, should init firstly");
    }

    @Java2C.Method2C
    public native String a(String str, String str2) throws Throwable;

    public static void a(Context context) {
        try {
            if (f16882a.getAndSet(true)) {
                return;
            }
            v3.f.f16875a.f16874a.execute(new a(context));
        } catch (Throwable th) {
            f16882a.set(false);
            r.b("ZXManager.init failed:" + th);
        }
    }
}

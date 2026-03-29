package com.qq.gdt.action.j;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f10527a;
    private volatile boolean b = false;

    private c() {
    }

    public static c a() {
        if (f10527a == null) {
            synchronized (c.class) {
                if (f10527a == null) {
                    f10527a = new c();
                }
            }
        }
        return f10527a;
    }

    public void a(Context context) {
        try {
            o.a("registerApplicationLifeCallback register = " + this.b, new Object[0]);
            com.qq.gdt.action.h.a.a(1006);
            if (this.b) {
                com.qq.gdt.action.h.a.a(1007);
                return;
            }
            if (context == null) {
                o.c("传入的Context对象为空，请参考接入文档");
                return;
            }
            if (!(context.getApplicationContext() instanceof Application)) {
                com.qq.gdt.action.h.a.a(1008);
                o.c("传入的Context对象不是Application类的实例，请参考接入文档");
                return;
            }
            Application application = (Application) context.getApplicationContext();
            o.a("registerApplicationLifeCallback begin register", new Object[0]);
            application.registerActivityLifecycleCallbacks(new com.qq.gdt.action.f(com.qq.gdt.action.d.a()));
            this.b = true;
            com.qq.gdt.action.h.a.a(1009);
        } catch (Throwable th) {
            o.a("registerApplicationLifeCallback", th);
        }
    }
}

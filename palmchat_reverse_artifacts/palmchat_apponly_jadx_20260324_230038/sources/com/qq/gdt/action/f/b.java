package com.qq.gdt.action.f;

import com.qq.gdt.action.f.b.a.g;
import com.qq.gdt.action.f.b.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f10496a;
    private com.qq.gdt.action.f.b.c b;
    private com.qq.gdt.action.f.b.c c;

    private b() {
        a(null);
        b(null);
    }

    public static b a() {
        if (f10496a == null) {
            synchronized (b.class) {
                if (f10496a == null) {
                    f10496a = new b();
                }
            }
        }
        return f10496a;
    }

    public static e d() {
        return new e();
    }

    public com.qq.gdt.action.f.b.c b() {
        return this.b;
    }

    public com.qq.gdt.action.f.b.c c() {
        return this.c;
    }

    private void a(com.qq.gdt.action.f.b.c cVar) {
        if (cVar == null) {
            cVar = new c.a().a(new com.qq.gdt.action.f.b.a.e()).a(new com.qq.gdt.action.f.b.a.f(3)).a(new g()).a(new com.qq.gdt.action.f.b.a.a()).a();
        }
        this.b = cVar;
    }

    private void b(com.qq.gdt.action.f.b.c cVar) {
        if (this.c == null) {
            cVar = new c.a().a(new com.qq.gdt.action.f.b.a.e()).a(new com.qq.gdt.action.f.b.a.f(3)).a();
        }
        this.c = cVar;
    }
}

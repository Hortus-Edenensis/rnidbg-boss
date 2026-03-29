package com.zx.a.I8b7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0 f16852a = new t0();
    public o0 b;
    public q0 c;

    public r0() {
        q0 q0Var = new q0(new p0());
        this.c = q0Var;
        o0 o0Var = new o0(q0Var);
        this.b = o0Var;
        this.f16852a.a(o0Var);
    }

    public void a(String str) {
        this.f16852a.a(2, null, str, null);
    }

    public void b(String str) {
        this.c.b = str;
    }

    public void a(boolean z) {
        this.b.b = z;
    }

    public void a(int i) {
        this.c.c = i + 8;
    }
}

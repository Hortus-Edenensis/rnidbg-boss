package com.zx.a.I8b7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class o0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f16838a;
    public boolean b = true;

    public o0(l0 l0Var) {
        this.f16838a = (l0) f2.a(l0Var);
    }

    @Override // com.zx.a.I8b7.j0
    public boolean a(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.b;
        }
        return false;
    }

    @Override // com.zx.a.I8b7.j0
    public void a(int i, String str, String str2, Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.f16838a.a(i, str, str2, th);
    }
}

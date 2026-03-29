package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ou {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ht f19875a;
    public sx4 b;
    public sx4 c;
    public sx4 d;
    public sx4 e;
    public int f;
    public int g;
    public int h;
    public int i;

    public ou(ht htVar, sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4) throws NotFoundException {
        if ((sx4Var == null && sx4Var3 == null) || ((sx4Var2 == null && sx4Var4 == null) || ((sx4Var != null && sx4Var2 == null) || (sx4Var3 != null && sx4Var4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        k(htVar, sx4Var, sx4Var2, sx4Var3, sx4Var4);
    }

    public static ou l(ou ouVar, ou ouVar2) throws NotFoundException {
        return ouVar == null ? ouVar2 : ouVar2 == null ? ouVar : new ou(ouVar.f19875a, ouVar.b, ouVar.c, ouVar2.d, ouVar2.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ou a(int i, int i2, boolean z) throws NotFoundException {
        sx4 sx4Var;
        sx4 sx4Var2;
        sx4 sx4Var3;
        sx4 sx4Var4;
        sx4 sx4Var5 = this.b;
        sx4 sx4Var6 = this.c;
        sx4 sx4Var7 = this.d;
        sx4 sx4Var8 = this.e;
        if (i > 0) {
            sx4 sx4Var9 = z ? sx4Var5 : sx4Var7;
            int iD = ((int) sx4Var9.d()) - i;
            if (iD < 0) {
                iD = 0;
            }
            sx4 sx4Var10 = new sx4(sx4Var9.c(), iD);
            if (!z) {
                sx4Var2 = sx4Var10;
                sx4Var = sx4Var5;
                if (i2 <= 0) {
                    sx4 sx4Var11 = z ? this.c : this.e;
                    int iD2 = ((int) sx4Var11.d()) + i2;
                    if (iD2 >= this.f19875a.h()) {
                        iD2 = this.f19875a.h() - 1;
                    }
                    sx4 sx4Var12 = new sx4(sx4Var11.c(), iD2);
                    if (!z) {
                        sx4Var4 = sx4Var12;
                        sx4Var3 = sx4Var6;
                        b();
                        return new ou(this.f19875a, sx4Var, sx4Var3, sx4Var2, sx4Var4);
                    }
                    sx4Var3 = sx4Var12;
                } else {
                    sx4Var3 = sx4Var6;
                }
                sx4Var4 = sx4Var8;
                b();
                return new ou(this.f19875a, sx4Var, sx4Var3, sx4Var2, sx4Var4);
            }
            sx4Var = sx4Var10;
        } else {
            sx4Var = sx4Var5;
        }
        sx4Var2 = sx4Var7;
        if (i2 <= 0) {
        }
        sx4Var4 = sx4Var8;
        b();
        return new ou(this.f19875a, sx4Var, sx4Var3, sx4Var2, sx4Var4);
    }

    public final void b() {
        if (this.b == null) {
            this.b = new sx4(0.0f, this.d.d());
            this.c = new sx4(0.0f, this.e.d());
        } else if (this.d == null) {
            this.d = new sx4(this.f19875a.k() - 1, this.b.d());
            this.e = new sx4(this.f19875a.k() - 1, this.c.d());
        }
        this.f = (int) Math.min(this.b.c(), this.c.c());
        this.g = (int) Math.max(this.d.c(), this.e.c());
        this.h = (int) Math.min(this.b.d(), this.d.d());
        this.i = (int) Math.max(this.c.d(), this.e.d());
    }

    public sx4 c() {
        return this.c;
    }

    public sx4 d() {
        return this.e;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.h;
    }

    public sx4 i() {
        return this.b;
    }

    public sx4 j() {
        return this.d;
    }

    public final void k(ht htVar, sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4) {
        this.f19875a = htVar;
        this.b = sx4Var;
        this.c = sx4Var2;
        this.d = sx4Var3;
        this.e = sx4Var4;
        b();
    }

    public ou(ou ouVar) {
        k(ouVar.f19875a, ouVar.b, ouVar.c, ouVar.d, ouVar.e);
    }
}

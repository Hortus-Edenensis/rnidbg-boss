package defpackage;

import com.oplus.log.core.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class l17 implements dw6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i87 f18890a;

    public l17(f47 f47Var) {
        t97 t97Var = new t97();
        this.f18890a = t97Var;
        t97Var.c(f47Var);
    }

    @Override // defpackage.dw6
    public final void a() {
        i87 i87Var = this.f18890a;
        if (i87Var != null) {
            i87Var.a();
        }
    }

    @Override // defpackage.dw6
    public final void b(String str, String str2, byte b, int i) {
        i87 i87Var = this.f18890a;
        if (i87Var != null) {
            i87Var.b(str, str2, b, i);
        }
    }

    @Override // defpackage.dw6
    public final void a(e.b bVar) {
        i87 i87Var = this.f18890a;
        if (i87Var != null) {
            i87Var.a(bVar);
        }
    }
}

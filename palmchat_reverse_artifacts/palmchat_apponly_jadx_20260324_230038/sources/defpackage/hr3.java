package defpackage;

import android.view.View;
import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hr3 extends of6 {
    public static l54<hr3> i;

    static {
        l54<hr3> l54VarA = l54.a(2, new hr3(null, 0.0f, 0.0f, null, null));
        i = l54VarA;
        l54VarA.g(0.5f);
    }

    public hr3(nf6 nf6Var, float f, float f2, h16 h16Var, View view) {
        super(nf6Var, f, f2, h16Var, view);
    }

    public static hr3 b(nf6 nf6Var, float f, float f2, h16 h16Var, View view) {
        hr3 hr3Var = (hr3) i.b();
        hr3Var.d = nf6Var;
        hr3Var.e = f;
        hr3Var.f = f2;
        hr3Var.g = h16Var;
        hr3Var.h = view;
        return hr3Var;
    }

    public static void c(hr3 hr3Var) {
        i.c(hr3Var);
    }

    @Override // l54.a
    public l54.a a() {
        return new hr3(this.d, this.e, this.f, this.g, this.h);
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = this.c;
        fArr[0] = this.e;
        fArr[1] = this.f;
        this.g.k(fArr);
        this.d.e(this.c, this.h);
        c(this);
    }
}

package defpackage;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"NewApi"})
public class zd extends de {
    public static l54<zd> m;

    static {
        l54<zd> l54VarA = l54.a(4, new zd(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        m = l54VarA;
        l54VarA.g(0.5f);
    }

    public zd(nf6 nf6Var, float f, float f2, h16 h16Var, View view, float f3, float f4, long j) {
        super(nf6Var, f, f2, h16Var, view, f3, f4, j);
    }

    public static zd d(nf6 nf6Var, float f, float f2, h16 h16Var, View view, float f3, float f4, long j) {
        zd zdVar = (zd) m.b();
        zdVar.d = nf6Var;
        zdVar.e = f;
        zdVar.f = f2;
        zdVar.g = h16Var;
        zdVar.h = view;
        zdVar.k = f3;
        zdVar.l = f4;
        zdVar.i.setDuration(j);
        return zdVar;
    }

    public static void e(zd zdVar) {
        m.c(zdVar);
    }

    @Override // l54.a
    public l54.a a() {
        return new zd(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }

    @Override // defpackage.de
    public void b() {
        e(this);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.c;
        float f = this.k;
        float f2 = this.e - f;
        float f3 = this.j;
        fArr[0] = f + (f2 * f3);
        float f4 = this.l;
        fArr[1] = f4 + ((this.f - f4) * f3);
        this.g.k(fArr);
        this.d.e(this.c, this.h);
    }
}

package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ip6 implements jp6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f18223a = new RectF();

    @Override // defpackage.jp6
    public void a(hp6 hp6Var, int i) {
        o(hp6Var).m(i);
    }

    @Override // defpackage.jp6
    public float b(hp6 hp6Var) {
        return o(hp6Var).i();
    }

    @Override // defpackage.jp6
    public void c(hp6 hp6Var) {
        Rect rect = new Rect();
        o(hp6Var).g(rect);
        hp6Var.setMinWidthHeightInternal((int) Math.ceil(e(hp6Var)), (int) Math.ceil(b(hp6Var)));
        hp6Var.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // defpackage.jp6
    public float d(hp6 hp6Var) {
        return o(hp6Var).f();
    }

    @Override // defpackage.jp6
    public float e(hp6 hp6Var) {
        return o(hp6Var).j();
    }

    @Override // defpackage.jp6
    public void f(hp6 hp6Var, float f) {
        o(hp6Var).n(f);
        c(hp6Var);
    }

    @Override // defpackage.jp6
    public void g(hp6 hp6Var, Context context, int i, float f, float f2, float f3, int i2, int i3) {
        lp6 lp6VarN = n(context, i, f, f2, f3, i2, i3);
        lp6VarN.l(hp6Var.getPreventCornerOverlap());
        hp6Var.setCardBackground(lp6VarN);
        c(hp6Var);
    }

    @Override // defpackage.jp6
    public void h(hp6 hp6Var, float f) {
        o(hp6Var).o(f);
        c(hp6Var);
    }

    @Override // defpackage.jp6
    public float i(hp6 hp6Var) {
        return o(hp6Var).k();
    }

    @Override // defpackage.jp6
    public void j(hp6 hp6Var) {
        o(hp6Var).l(hp6Var.getPreventCornerOverlap());
        c(hp6Var);
    }

    @Override // defpackage.jp6
    public float k(hp6 hp6Var) {
        return o(hp6Var).h();
    }

    @Override // defpackage.jp6
    public void m(hp6 hp6Var, float f) {
        o(hp6Var).p(f);
    }

    public final lp6 n(Context context, int i, float f, float f2, float f3, int i2, int i3) {
        return new lp6(context.getResources(), i, f, f2, f3, i2, i3);
    }

    public final lp6 o(hp6 hp6Var) {
        return (lp6) hp6Var.getCardBackground();
    }

    @Override // defpackage.jp6
    public void l(hp6 hp6Var) {
    }
}

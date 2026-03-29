package defpackage;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import defpackage.tp;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s25 extends u23 {
    public u25 i;
    public float[] j;

    public s25(u25 u25Var, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.j = new float[2];
        this.i = u25Var;
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        for (T t : this.i.getScatterData().h()) {
            if (t.isVisible()) {
                k(canvas, t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        t25 scatterData = this.i.getScatterData();
        for (vh2 vh2Var : vh2VarArr) {
            mo2 mo2Var = (mo2) scatterData.e(vh2Var.d());
            if (mo2Var != null && mo2Var.O()) {
                ?? O0 = mo2Var.o0(vh2Var.h(), vh2Var.j());
                if (h(O0, mo2Var)) {
                    ub3 ub3VarE = this.i.getTransformer(mo2Var.i0()).e(O0.getX(), O0.getY() * this.b.i());
                    vh2Var.m((float) ub3VarE.c, (float) ub3VarE.d);
                    j(canvas, (float) ub3VarE.c, (float) ub3VarE.d, mo2Var);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    @Override // defpackage.su0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(Canvas canvas) {
        mo2 mo2Var;
        Entry entry;
        if (g(this.i)) {
            List<T> listH = this.i.getScatterData().h();
            for (int i = 0; i < this.i.getScatterData().f(); i++) {
                mo2 mo2Var2 = (mo2) listH.get(i);
                if (i(mo2Var2) && mo2Var2.K0() >= 1) {
                    a(mo2Var2);
                    this.g.a(this.i, mo2Var2);
                    h16 transformer = this.i.getTransformer(mo2Var2.i0());
                    float fH = this.b.h();
                    float fI = this.b.i();
                    tp.a aVar = this.g;
                    float[] fArrD = transformer.d(mo2Var2, fH, fI, aVar.f21030a, aVar.b);
                    float fE = s86.e(mo2Var2.k());
                    h96 h96VarZ = mo2Var2.Z();
                    vb3 vb3VarD = vb3.d(mo2Var2.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    int i2 = 0;
                    while (i2 < fArrD.length && this.f20113a.C(fArrD[i2])) {
                        if (this.f20113a.B(fArrD[i2])) {
                            int i3 = i2 + 1;
                            if (this.f20113a.F(fArrD[i3])) {
                                int i4 = i2 / 2;
                                Entry entryH = mo2Var2.h(this.g.f21030a + i4);
                                if (mo2Var2.h0()) {
                                    entry = entryH;
                                    mo2Var = mo2Var2;
                                    l(canvas, h96VarZ.h(entryH), fArrD[i2], fArrD[i3] - fE, mo2Var2.l(i4 + this.g.f21030a));
                                } else {
                                    entry = entryH;
                                    mo2Var = mo2Var2;
                                }
                                if (entry.getIcon() != null && mo2Var.B()) {
                                    Drawable icon = entry.getIcon();
                                    s86.f(canvas, icon, (int) (fArrD[i2] + vb3VarD.c), (int) (fArrD[i3] + vb3VarD.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                mo2Var = mo2Var2;
                            }
                        }
                        i2 += 2;
                        mo2Var2 = mo2Var;
                    }
                    vb3.f(vb3VarD);
                }
            }
        }
    }

    public void k(Canvas canvas, mo2 mo2Var) {
        if (mo2Var.K0() < 1) {
            return;
        }
        this.i.getTransformer(mo2Var.i0());
        this.b.i();
        mo2Var.H();
        Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
    }

    public void l(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    @Override // defpackage.su0
    public void f() {
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
    }
}

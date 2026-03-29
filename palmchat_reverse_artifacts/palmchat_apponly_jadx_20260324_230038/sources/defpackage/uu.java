package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BubbleEntry;
import defpackage.tp;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class uu extends tp {
    public wu h;
    public float[] i;
    public float[] j;
    public float[] k;

    public uu(wu wuVar, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.i = new float[4];
        this.j = new float[2];
        this.k = new float[3];
        this.h = wuVar;
        this.c.setStyle(Paint.Style.FILL);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(s86.e(1.5f));
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        for (T t : this.h.getBubbleData().h()) {
            if (t.isVisible()) {
                j(canvas, t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013c  */
    @Override // defpackage.su0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        vu bubbleData = this.h.getBubbleData();
        float fI = this.b.i();
        for (vh2 vh2Var : vh2VarArr) {
            ok2 ok2Var = (ok2) bubbleData.e(vh2Var.d());
            if (ok2Var != null && ok2Var.O()) {
                BubbleEntry bubbleEntry = (BubbleEntry) ok2Var.o0(vh2Var.h(), vh2Var.j());
                if (bubbleEntry.getY() == vh2Var.j() && h(bubbleEntry, ok2Var)) {
                    h16 transformer = this.h.getTransformer(ok2Var.i0());
                    float[] fArr = this.i;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    transformer.k(fArr);
                    boolean zV = ok2Var.v();
                    float[] fArr2 = this.i;
                    float fMin = Math.min(Math.abs(this.f20113a.f() - this.f20113a.j()), Math.abs(fArr2[2] - fArr2[0]));
                    this.j[0] = bubbleEntry.getX();
                    this.j[1] = bubbleEntry.getY() * fI;
                    transformer.k(this.j);
                    float[] fArr3 = this.j;
                    vh2Var.m(fArr3[0], fArr3[1]);
                    float fL = l(bubbleEntry.getSize(), ok2Var.getMaxSize(), fMin, zV) / 2.0f;
                    if (this.f20113a.D(this.j[1] + fL) && this.f20113a.A(this.j[1] - fL) && this.f20113a.B(this.j[0] + fL)) {
                        if (!this.f20113a.C(this.j[0] - fL)) {
                            return;
                        }
                        int iZ0 = ok2Var.z0((int) bubbleEntry.getX());
                        Color.RGBToHSV(Color.red(iZ0), Color.green(iZ0), Color.blue(iZ0), this.k);
                        float[] fArr4 = this.k;
                        fArr4[2] = fArr4[2] * 0.5f;
                        this.d.setColor(Color.HSVToColor(Color.alpha(iZ0), this.k));
                        this.d.setStrokeWidth(ok2Var.g0());
                        float[] fArr5 = this.j;
                        canvas.drawCircle(fArr5[0], fArr5[1], fL, this.d);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void e(Canvas canvas) {
        int i;
        BubbleEntry bubbleEntry;
        float f;
        float f2;
        vu bubbleData = this.h.getBubbleData();
        if (bubbleData != null && g(this.h)) {
            List<T> listH = bubbleData.h();
            float fA = s86.a(this.f, "1");
            for (int i2 = 0; i2 < listH.size(); i2++) {
                ok2 ok2Var = (ok2) listH.get(i2);
                if (i(ok2Var) && ok2Var.K0() >= 1) {
                    a(ok2Var);
                    float fMax = Math.max(0.0f, Math.min(1.0f, this.b.h()));
                    float fI = this.b.i();
                    this.g.a(this.h, ok2Var);
                    h16 transformer = this.h.getTransformer(ok2Var.i0());
                    tp.a aVar = this.g;
                    float[] fArrA = transformer.a(ok2Var, fI, aVar.f21030a, aVar.b);
                    float f3 = fMax == 1.0f ? fI : fMax;
                    h96 h96VarZ = ok2Var.Z();
                    vb3 vb3VarD = vb3.d(ok2Var.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    for (int i3 = 0; i3 < fArrA.length; i3 = i + 2) {
                        int i4 = i3 / 2;
                        int iL = ok2Var.l(this.g.f21030a + i4);
                        int iArgb = Color.argb(Math.round(255.0f * f3), Color.red(iL), Color.green(iL), Color.blue(iL));
                        float f4 = fArrA[i3];
                        float f5 = fArrA[i3 + 1];
                        if (!this.f20113a.C(f4)) {
                            break;
                        }
                        if (this.f20113a.B(f4) && this.f20113a.F(f5)) {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) ok2Var.h(i4 + this.g.f21030a);
                            if (ok2Var.h0()) {
                                bubbleEntry = bubbleEntry2;
                                f = f5;
                                f2 = f4;
                                i = i3;
                                k(canvas, h96VarZ.d(bubbleEntry2), f4, f5 + (0.5f * fA), iArgb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f = f5;
                                f2 = f4;
                                i = i3;
                            }
                            if (bubbleEntry.getIcon() != null && ok2Var.B()) {
                                Drawable icon = bubbleEntry.getIcon();
                                s86.f(canvas, icon, (int) (f2 + vb3VarD.c), (int) (f + vb3VarD.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        } else {
                            i = i3;
                        }
                    }
                    vb3.f(vb3VarD);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(Canvas canvas, ok2 ok2Var) {
        if (ok2Var.K0() < 1) {
            return;
        }
        h16 transformer = this.h.getTransformer(ok2Var.i0());
        float fI = this.b.i();
        this.g.a(this.h, ok2Var);
        float[] fArr = this.i;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        transformer.k(fArr);
        boolean zV = ok2Var.v();
        float[] fArr2 = this.i;
        float fMin = Math.min(Math.abs(this.f20113a.f() - this.f20113a.j()), Math.abs(fArr2[2] - fArr2[0]));
        int i = this.g.f21030a;
        while (true) {
            tp.a aVar = this.g;
            if (i > aVar.c + aVar.f21030a) {
                return;
            }
            BubbleEntry bubbleEntry = (BubbleEntry) ok2Var.h(i);
            this.j[0] = bubbleEntry.getX();
            this.j[1] = bubbleEntry.getY() * fI;
            transformer.k(this.j);
            float fL = l(bubbleEntry.getSize(), ok2Var.getMaxSize(), fMin, zV) / 2.0f;
            if (this.f20113a.D(this.j[1] + fL) && this.f20113a.A(this.j[1] - fL) && this.f20113a.B(this.j[0] + fL)) {
                if (!this.f20113a.C(this.j[0] - fL)) {
                    return;
                }
                this.c.setColor(ok2Var.z0((int) bubbleEntry.getX()));
                float[] fArr3 = this.j;
                canvas.drawCircle(fArr3[0], fArr3[1], fL, this.c);
            }
            i++;
        }
    }

    public void k(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    public float l(float f, float f2, float f3, boolean z) {
        if (z) {
            f = f2 == 0.0f ? 1.0f : (float) Math.sqrt(f / f2);
        }
        return f3 * f;
    }

    @Override // defpackage.su0
    public void f() {
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
    }
}

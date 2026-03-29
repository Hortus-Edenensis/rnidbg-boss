package defpackage;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wo6 extends uo6 {
    public RadarChart p;

    public wo6(nf6 nf6Var, XAxis xAxis, RadarChart radarChart) {
        super(nf6Var, xAxis, null);
        this.p = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.uo6
    public void i(Canvas canvas) {
        if (this.h.f() && this.h.z()) {
            float fH = this.h.H();
            vb3 vb3VarC = vb3.c(0.5f, 0.25f);
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            float sliceAngle = this.p.getSliceAngle();
            float factor = this.p.getFactor();
            vb3 centerOffsets = this.p.getCenterOffsets();
            vb3 vb3VarC2 = vb3.c(0.0f, 0.0f);
            for (int i = 0; i < ((is4) this.p.getData()).m().K0(); i++) {
                float f = i;
                String strA = this.h.u().a(f, this.h);
                s86.r(centerOffsets, (this.p.getYRange() * factor) + (this.h.L / 2.0f), ((f * sliceAngle) + this.p.getRotationAngle()) % 360.0f, vb3VarC2);
                f(canvas, strA, vb3VarC2.c, vb3VarC2.d - (this.h.M / 2.0f), vb3VarC, fH);
            }
            vb3.f(centerOffsets);
            vb3.f(vb3VarC2);
            vb3.f(vb3VarC);
        }
    }

    @Override // defpackage.uo6
    public void n(Canvas canvas) {
    }
}

package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cg5 extends a {
    public final RectF D;
    public final Paint E;
    public final float[] F;
    public final Path G;
    public final Layer H;

    @Nullable
    public sq<ColorFilter, ColorFilter> I;

    public cg5(u83 u83Var, Layer layer) {
        super(u83Var, layer);
        this.D = new RectF();
        o03 o03Var = new o03();
        this.E = o03Var;
        this.F = new float[8];
        this.G = new Path();
        this.H = layer;
        o03Var.setAlpha(0);
        o03Var.setStyle(Paint.Style.FILL);
        o03Var.setColor(layer.o());
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.D.set(0.0f, 0.0f, this.H.q(), this.H.p());
        this.o.mapRect(this.D);
        rectF.set(this.D);
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.K) {
            if (i93Var == null) {
                this.I = null;
            } else {
                this.I = new f96(i93Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.H.o());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.x.h() == null ? 100 : this.x.h().h().intValue())) / 100.0f) * 255.0f);
        this.E.setAlpha(iIntValue);
        sq<ColorFilter, ColorFilter> sqVar = this.I;
        if (sqVar != null) {
            this.E.setColorFilter(sqVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.q();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.q();
            this.F[5] = this.H.p();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.p();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }
}

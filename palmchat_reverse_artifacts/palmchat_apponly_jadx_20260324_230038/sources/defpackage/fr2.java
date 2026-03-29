package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fr2 extends a {
    public final Paint D;
    public final Rect E;
    public final Rect F;

    @Nullable
    public final x83 G;

    @Nullable
    public sq<ColorFilter, ColorFilter> H;

    @Nullable
    public sq<Bitmap, Bitmap> I;

    public fr2(u83 u83Var, Layer layer) {
        super(u83Var, layer);
        this.D = new o03(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = u83Var.R(layer.m());
    }

    @Nullable
    public final Bitmap O() {
        Bitmap bitmapH;
        sq<Bitmap, Bitmap> sqVar = this.I;
        if (sqVar != null && (bitmapH = sqVar.h()) != null) {
            return bitmapH;
        }
        Bitmap bitmapJ = this.p.J(this.q.m());
        if (bitmapJ != null) {
            return bitmapJ;
        }
        x83 x83Var = this.G;
        if (x83Var != null) {
            return x83Var.a();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (this.G != null) {
            float fE = r86.e();
            rectF.set(0.0f, 0.0f, this.G.e() * fE, this.G.c() * fE);
            this.o.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.K) {
            if (i93Var == null) {
                this.H = null;
                return;
            } else {
                this.H = new f96(i93Var);
                return;
            }
        }
        if (t == d93.N) {
            if (i93Var == null) {
                this.I = null;
            } else {
                this.I = new f96(i93Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapO = O();
        if (bitmapO == null || bitmapO.isRecycled() || this.G == null) {
            return;
        }
        float fE = r86.e();
        this.D.setAlpha(i);
        sq<ColorFilter, ColorFilter> sqVar = this.H;
        if (sqVar != null) {
            this.D.setColorFilter(sqVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, bitmapO.getWidth(), bitmapO.getHeight());
        if (this.p.S()) {
            this.F.set(0, 0, (int) (this.G.e() * fE), (int) (this.G.c() * fE));
        } else {
            this.F.set(0, 0, (int) (bitmapO.getWidth() * fE), (int) (bitmapO.getHeight() * fE));
        }
        canvas.drawBitmap(bitmapO, this.E, this.F, this.D);
        canvas.restore();
    }
}

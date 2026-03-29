package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.zenmen.imageeditengine.views.cropimage.CropOverlayView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class gr0 extends Animation implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f17774a;
    public final CropOverlayView b;
    public final float[] c = new float[8];
    public final float[] d = new float[8];
    public final RectF e = new RectF();
    public final RectF f = new RectF();
    public final float[] g = new float[9];
    public final float[] h = new float[9];
    public final RectF i = new RectF();
    public final float[] j = new float[8];
    public final float[] k = new float[9];

    public gr0(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f17774a = imageView;
        this.b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void a(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.d, 0, 8);
        this.f.set(this.b.getCropWindowRect());
        matrix.getValues(this.h);
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.i;
        RectF rectF2 = this.e;
        float f2 = rectF2.left;
        RectF rectF3 = this.f;
        rectF.left = f2 + ((rectF3.left - f2) * f);
        float f3 = rectF2.top;
        rectF.top = f3 + ((rectF3.top - f3) * f);
        float f4 = rectF2.right;
        rectF.right = f4 + ((rectF3.right - f4) * f);
        float f5 = rectF2.bottom;
        rectF.bottom = f5 + ((rectF3.bottom - f5) * f);
        this.b.setCropWindowRect(rectF);
        int i = 0;
        int i2 = 0;
        while (true) {
            fArr = this.j;
            if (i2 >= fArr.length) {
                break;
            }
            float f6 = this.c[i2];
            fArr[i2] = f6 + ((this.d[i2] - f6) * f);
            i2++;
        }
        this.b.setBounds(fArr, this.f17774a.getWidth(), this.f17774a.getHeight());
        while (true) {
            float[] fArr2 = this.k;
            if (i >= fArr2.length) {
                Matrix imageMatrix = this.f17774a.getImageMatrix();
                imageMatrix.setValues(this.k);
                this.f17774a.setImageMatrix(imageMatrix);
                this.f17774a.invalidate();
                this.b.invalidate();
                return;
            }
            float f7 = this.g[i];
            fArr2[i] = f7 + ((this.h[i] - f7) * f);
            i++;
        }
    }

    public void b(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.c, 0, 8);
        this.e.set(this.b.getCropWindowRect());
        matrix.getValues(this.g);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f17774a.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}

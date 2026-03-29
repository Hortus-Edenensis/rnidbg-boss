package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vq2 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f21507a;
    public BitmapShader b;
    public int e;
    public int f;
    public ValueAnimator h;
    public RectF c = new RectF();
    public Matrix d = new Matrix();
    public float g = 0.0f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            vq2.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            vq2.this.invalidateSelf();
        }
    }

    public vq2(Context context, Bitmap bitmap) {
        Paint paint = new Paint();
        this.f21507a = paint;
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.b = bitmapShader;
        this.f21507a.setShader(bitmapShader);
        this.e = bitmap.getWidth();
        this.f = bitmap.getHeight();
        b();
    }

    public void b() {
        if (this.h != null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.h = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.h.setRepeatMode(1);
        this.h.setDuration(45000L);
        this.h.setInterpolator(new LinearInterpolator());
        this.h.addUpdateListener(new a());
        this.h.start();
    }

    public void c() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float fWidth = bounds.width();
        float fHeight = bounds.height();
        int i = this.e;
        if (i > 0) {
            float f = fWidth / i;
            int i2 = (int) (this.f * f);
            this.c.set(0.0f, 0.0f, fWidth, fHeight);
            this.d.reset();
            this.d.setScale(f, f);
            this.d.postTranslate(0.0f, (-i2) * this.g);
            this.b.setLocalMatrix(this.d);
            canvas.drawRect(this.c, this.f21507a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f21507a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f21507a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (z) {
            b();
        } else {
            c();
        }
        return super.setVisible(z, z2);
    }
}

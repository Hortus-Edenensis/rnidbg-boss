package com.bytedance.adsdk.ugeno.widget.image;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import defpackage.td;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f5053a;
    private final Bitmap b;
    private ColorStateList bg;
    private ImageView.ScaleType bq;
    private final RectF fx;
    private final int iz;
    private final Matrix jk;
    private float k;
    private Shader.TileMode l;
    private Shader.TileMode mv;
    private final boolean[] my;
    private final RectF n;
    private boolean o;
    private final Paint pn;
    private boolean s;
    private float sx;
    private final RectF t;
    private final int x;
    private final RectF u = new RectF();
    private final RectF nr = new RectF();

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.u$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            u = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                u[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public u(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.fx = rectF;
        this.n = new RectF();
        this.jk = new Matrix();
        this.t = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.mv = tileMode;
        this.s = true;
        this.k = 0.0f;
        this.my = new boolean[]{true, true, true, true};
        this.o = false;
        this.sx = 0.0f;
        this.bg = ColorStateList.valueOf(-16777216);
        this.bq = ImageView.ScaleType.FIT_CENTER;
        this.b = bitmap;
        int width = bitmap.getWidth();
        this.iz = width;
        int height = bitmap.getHeight();
        this.x = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.pn = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f5053a = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.bg.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.sx);
    }

    public static Bitmap nr(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static u u(Bitmap bitmap) {
        if (bitmap != null) {
            return new u(bitmap);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.s) {
            BitmapShader bitmapShader = new BitmapShader(this.b, this.l, this.mv);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.mv == tileMode2) {
                bitmapShader.setLocalMatrix(this.jk);
            }
            this.pn.setShader(bitmapShader);
            this.s = false;
        }
        if (this.o) {
            if (this.sx <= 0.0f) {
                canvas.drawOval(this.nr, this.pn);
                return;
            } else {
                canvas.drawOval(this.nr, this.pn);
                canvas.drawOval(this.n, this.f5053a);
                return;
            }
        }
        if (!u(this.my)) {
            canvas.drawRect(this.nr, this.pn);
            if (this.sx > 0.0f) {
                canvas.drawRect(this.n, this.f5053a);
                return;
            }
            return;
        }
        float f = this.k;
        if (this.sx <= 0.0f) {
            canvas.drawRoundRect(this.nr, f, f, this.pn);
            u(canvas);
        } else {
            canvas.drawRoundRect(this.nr, f, f, this.pn);
            canvas.drawRoundRect(this.n, f, f, this.f5053a);
            u(canvas);
            nr(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.pn.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.pn.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.iz;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.bg.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.u.set(rect);
        u();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.bg.getColorForState(iArr, 0);
        if (this.f5053a.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f5053a.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pn.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pn.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pn.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pn.setFilterBitmap(z);
        invalidateSelf();
    }

    public static Drawable u(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof u) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && td.a(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), u(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapNr = nr(drawable);
        return bitmapNr != null ? new u(bitmapNr) : drawable;
    }

    private void nr(Canvas canvas) {
        float f;
        if (nr(this.my) || this.k == 0.0f) {
            return;
        }
        RectF rectF = this.nr;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = f3 + this.nr.height();
        float f4 = this.k;
        float f5 = this.sx / 2.0f;
        if (!this.my[0]) {
            canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.f5053a);
            canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.f5053a);
        }
        if (!this.my[1]) {
            canvas.drawLine((fWidth - f4) - f5, f3, fWidth, f3, this.f5053a);
            canvas.drawLine(fWidth, f3 - f5, fWidth, f3 + f4, this.f5053a);
        }
        if (this.my[2]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine((fWidth - f4) - f5, fHeight, fWidth + f5, fHeight, this.f5053a);
            canvas.drawLine(fWidth, fHeight - f, fWidth, fHeight, this.f5053a);
        }
        if (this.my[3]) {
            return;
        }
        canvas.drawLine(f2 - f5, fHeight, f2 + f, fHeight, this.f5053a);
        canvas.drawLine(f2, fHeight - f, f2, fHeight, this.f5053a);
    }

    private void u() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.u[this.bq.ordinal()];
        if (i == 1) {
            this.n.set(this.u);
            RectF rectF = this.n;
            float f = this.sx;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.jk.reset();
            this.jk.setTranslate((int) (((this.n.width() - this.iz) * 0.5f) + 0.5f), (int) (((this.n.height() - this.x) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.n.set(this.u);
            RectF rectF2 = this.n;
            float f2 = this.sx;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.jk.reset();
            float fWidth2 = 0.0f;
            if (this.iz * this.n.height() > this.n.width() * this.x) {
                fWidth = this.n.height() / this.x;
                fWidth2 = (this.n.width() - (this.iz * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.n.width() / this.iz;
                fHeight = (this.n.height() - (this.x * fWidth)) * 0.5f;
            }
            this.jk.setScale(fWidth, fWidth);
            Matrix matrix = this.jk;
            float f3 = this.sx;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.jk.reset();
            float fMin = (((float) this.iz) > this.u.width() || ((float) this.x) > this.u.height()) ? Math.min(this.u.width() / this.iz, this.u.height() / this.x) : 1.0f;
            float fWidth3 = (int) (((this.u.width() - (this.iz * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.u.height() - (this.x * fMin)) * 0.5f) + 0.5f);
            this.jk.setScale(fMin, fMin);
            this.jk.postTranslate(fWidth3, fHeight2);
            this.n.set(this.fx);
            this.jk.mapRect(this.n);
            RectF rectF3 = this.n;
            float f4 = this.sx;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.jk.setRectToRect(this.fx, this.n, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.n.set(this.fx);
            this.jk.setRectToRect(this.fx, this.u, Matrix.ScaleToFit.END);
            this.jk.mapRect(this.n);
            RectF rectF4 = this.n;
            float f5 = this.sx;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.jk.setRectToRect(this.fx, this.n, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.n.set(this.fx);
            this.jk.setRectToRect(this.fx, this.u, Matrix.ScaleToFit.START);
            this.jk.mapRect(this.n);
            RectF rectF5 = this.n;
            float f6 = this.sx;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.jk.setRectToRect(this.fx, this.n, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.n.set(this.fx);
            this.jk.setRectToRect(this.fx, this.u, Matrix.ScaleToFit.CENTER);
            this.jk.mapRect(this.n);
            RectF rectF6 = this.n;
            float f7 = this.sx;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.jk.setRectToRect(this.fx, this.n, Matrix.ScaleToFit.FILL);
        } else {
            this.n.set(this.u);
            RectF rectF7 = this.n;
            float f8 = this.sx;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.jk.reset();
            this.jk.setRectToRect(this.fx, this.n, Matrix.ScaleToFit.FILL);
        }
        this.nr.set(this.n);
        this.s = true;
    }

    public u nr(Shader.TileMode tileMode) {
        if (this.mv != tileMode) {
            this.mv = tileMode;
            this.s = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean nr(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private void u(Canvas canvas) {
        if (nr(this.my) || this.k == 0.0f) {
            return;
        }
        RectF rectF = this.nr;
        float f = rectF.left;
        float f2 = rectF.top;
        float fWidth = rectF.width() + f;
        float fHeight = this.nr.height() + f2;
        float f3 = this.k;
        if (!this.my[0]) {
            this.t.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.t, this.pn);
        }
        if (!this.my[1]) {
            this.t.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.t, this.pn);
        }
        if (!this.my[2]) {
            this.t.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.t, this.pn);
        }
        if (this.my[3]) {
            return;
        }
        this.t.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.t, this.pn);
    }

    public u u(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(fFloatValue) && !Float.isNaN(fFloatValue) && fFloatValue >= 0.0f) {
                    this.k = fFloatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
                }
            } else {
                this.k = 0.0f;
            }
            boolean[] zArr = this.my;
            zArr[0] = f > 0.0f;
            zArr[1] = f2 > 0.0f;
            zArr[2] = f3 > 0.0f;
            zArr[3] = f4 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public u u(float f) {
        this.sx = f;
        this.f5053a.setStrokeWidth(f);
        return this;
    }

    public u u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.bg = colorStateList;
        this.f5053a.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public u u(boolean z) {
        this.o = z;
        return this;
    }

    public u u(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.bq != scaleType) {
            this.bq = scaleType;
            u();
        }
        return this;
    }

    public u u(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.s = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean u(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }
}

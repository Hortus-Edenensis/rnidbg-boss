package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.adsdk.ugeno.fx.pn;
import com.bytedance.adsdk.ugeno.u.n;
import com.bytedance.adsdk.ugeno.u.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RoundImageView extends ImageView implements pn, x {
    static final /* synthetic */ boolean nr = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorFilter f5052a;
    private Shader.TileMode bg;
    private fx bq;
    private n dw;
    private float fx;
    private Drawable iz;
    private boolean jk;
    private int k;
    private boolean l;
    private boolean mv;
    private int my;
    private float n;
    private ImageView.ScaleType o;
    private final float[] pn;
    private boolean s;
    private Shader.TileMode sx;
    private Drawable t;
    private ColorStateList x;
    public static final Shader.TileMode u = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] b = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            u = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                u[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.pn = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.x = ColorStateList.valueOf(-16777216);
        this.n = 0.0f;
        this.f5052a = null;
        this.jk = false;
        this.l = false;
        this.mv = false;
        this.s = false;
        Shader.TileMode tileMode = u;
        this.sx = tileMode;
        this.bg = tileMode;
        this.dw = new n(this);
    }

    private void b() {
        Drawable drawable = this.t;
        if (drawable == null || !this.jk) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.t = drawableMutate;
        if (this.l) {
            drawableMutate.setColorFilter(this.f5052a);
        }
    }

    private void fx() {
        u(this.t, this.o);
    }

    private Drawable nr() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.my;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                this.my = 0;
            }
        }
        return u.u(drawable);
    }

    private Drawable u() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.k;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                this.k = 0;
            }
        }
        return u.u(drawable);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.nr(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.x.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.x;
    }

    public float getBorderRadius() {
        return this.dw.u();
    }

    public float getBorderWidth() {
        return this.n;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.pn) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.pn, com.bytedance.adsdk.ugeno.u.x
    public float getRipple() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRubIn() {
        return this.dw.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.o;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getShine() {
        return this.dw.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getStretch() {
        return this.dw.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.sx;
    }

    public Shader.TileMode getTileModeY() {
        return this.bg;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.u(canvas, this);
            this.bq.u(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.bq;
        if (fxVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrU = fxVar.u(i, i2);
            super.onMeasure(iArrU[0], iArrU[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i3);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.iz = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.iz = drawable;
        u(true);
        super.setBackgroundDrawable(this.iz);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.my != i) {
            this.my = i;
            Drawable drawableNr = nr();
            this.iz = drawableNr;
            setBackgroundDrawable(drawableNr);
        }
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderRadius(float f) {
        n nVar = this.dw;
        if (nVar != null) {
            nVar.u(f);
        }
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5052a != colorFilter) {
            this.f5052a = colorFilter;
            this.l = true;
            this.jk = true;
            b();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        u(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        u(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.k = 0;
        this.t = u.u(bitmap);
        fx();
        super.setImageDrawable(this.t);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.k = 0;
        this.t = u.u(drawable);
        fx();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.k != i) {
            this.k = i;
            this.t = u();
            fx();
            super.setImageDrawable(this.t);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.mv = z;
        fx();
        u(false);
        invalidate();
    }

    public void setRipple(float f) {
        this.fx = f;
        n nVar = this.dw;
        if (nVar != null) {
            nVar.nr(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        n nVar = this.dw;
        if (nVar != null) {
            nVar.pn(f);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!nr && scaleType == null) {
            throw new AssertionError();
        }
        if (this.o != scaleType) {
            this.o = scaleType;
            int i = AnonymousClass1.u[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            fx();
            u(false);
            invalidate();
        }
    }

    public void setShine(float f) {
        n nVar = this.dw;
        if (nVar != null) {
            nVar.fx(f);
        }
    }

    public void setStretch(float f) {
        n nVar = this.dw;
        if (nVar != null) {
            nVar.b(f);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.sx == tileMode) {
            return;
        }
        this.sx = tileMode;
        fx();
        u(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.bg == tileMode) {
            return;
        }
        this.bg = tileMode;
        fx();
        u(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.x.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.x = colorStateList;
        fx();
        u(false);
        if (this.n > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.n == f) {
            return;
        }
        this.n = f;
        fx();
        u(false);
        invalidate();
    }

    private void u(boolean z) {
        if (this.s) {
            if (z) {
                this.iz = u.u(this.iz);
            }
            u(this.iz, ImageView.ScaleType.FIT_XY);
        }
    }

    private void u(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof u) {
            u uVar = (u) drawable;
            uVar.u(scaleType).u(this.n).u(this.x).u(this.mv).u(this.sx).nr(this.bg);
            float[] fArr = this.pn;
            if (fArr != null) {
                uVar.u(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            b();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                u(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    public void u(float f, float f2, float f3, float f4) {
        float[] fArr = this.pn;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        fx();
        u(false);
        invalidate();
    }

    public void u(fx fxVar) {
        this.bq = fxVar;
    }
}

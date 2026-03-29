package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.zenmen.palmchat.framework.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EffectiveShapeView extends ImageView {
    private static final String TAG = "EffectiveShapeView";
    private int mBorderColor;
    private int mBorderWidth;
    private Drawable mDecorationsView;
    private int mDirection;
    private boolean mInvalidated;
    private Paint mMaskPaint;
    private Path mMaskPath;
    private Matrix mMatrix;
    private Object mObj;
    private int mPadding;
    private int mPolygonSides;
    private boolean mReBuildShader;
    private RectF mRectF;
    private int mResource;
    private float mRx;
    private float mRy;
    private final Matrix mShaderMatrix;
    private Paint mShaderPaint;
    private int mShapeType;

    public EffectiveShapeView(Context context) {
        this(context, null);
    }

    private void createMask(int i, int i2) {
        try {
            this.mMaskPath.reset();
        } catch (Exception unused) {
            this.mMaskPath = new Path();
        }
        this.mMaskPaint.setStyle(Paint.Style.FILL);
        int i3 = this.mBorderWidth / 2;
        int i4 = this.mShapeType;
        if (i4 == 1) {
            if (this.mRectF == null) {
                this.mRectF = new RectF();
            }
            float f = i3;
            this.mRectF.set(f, f, i - i3, i2 - i3);
            float fMin = Math.min(i, i2) / 2.0f;
            this.mMaskPath.addCircle(fMin, fMin, fMin - f, Path.Direction.CW);
            return;
        }
        if (i4 == 2) {
            float f2 = i3;
            this.mMaskPath.addRect(f2, f2, i - i3, i2 - i3, Path.Direction.CW);
            return;
        }
        if (i4 == 3) {
            if (this.mRectF == null) {
                this.mRectF = new RectF();
            }
            float f3 = i3;
            this.mRectF.set(f3, f3, i - i3, i2 - i3);
            this.mMaskPath.addRoundRect(this.mRectF, this.mRx, this.mRy, Path.Direction.CW);
            return;
        }
        if (i4 != 4) {
            if (i4 != 5) {
                return;
            }
            createPolygonPath(i, i2, this.mPolygonSides);
        } else {
            float f4 = i3;
            float fMin2 = Math.min(i, i2) - i3;
            this.mMaskPath.addRect(f4, f4, fMin2, fMin2, Path.Direction.CW);
        }
    }

    private void createPolygonPath(int i, int i2, int i3) {
        int iAbs = Math.abs(i3);
        float fMin = Math.min(i, i2) / 2;
        float f = fMin - (this.mBorderWidth / 2);
        float f2 = (float) ((((double) 0.0f) * 3.141592653589793d) / 180.0d);
        int i4 = 0;
        while (i4 < iAbs) {
            double d = fMin;
            double d2 = f;
            double d3 = f2;
            float fCos = (float) ((Math.cos(d3) * d2) + d);
            float fSin = (float) (d + (d2 * Math.sin(d3)));
            float f3 = (float) (d3 + (6.283185307179586d / ((double) iAbs)));
            if (i4 == 0) {
                this.mMaskPath.moveTo(fCos, fSin);
            } else {
                this.mMaskPath.lineTo(fCos, fSin);
            }
            i4++;
            f2 = f3;
        }
        this.mMaskPath.close();
        if (iAbs % 2 != 0) {
            Matrix matrix = this.mMatrix;
            if (matrix == null) {
                this.mMatrix = new Matrix();
            } else {
                matrix.reset();
            }
            this.mMatrix.postRotate(-90.0f, fMin, fMin);
            this.mMaskPath.transform(this.mMatrix);
        }
    }

    private void createShader() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmapDrawableToBitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(updateShaderMatrix(bitmapDrawableToBitmap.getWidth(), bitmapDrawableToBitmap.getHeight(), this.mRectF));
            this.mShaderPaint.setShader(bitmapShader);
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Drawable fromDrawable(Drawable drawable) {
        Bitmap bitmapDrawableToBitmap;
        this.mReBuildShader = true;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            drawable = ((LayerDrawable) drawable).getDrawable(0);
        } else if (drawable instanceof StateListDrawable) {
            drawable = ((StateListDrawable) drawable).getCurrent();
        }
        return ((drawable instanceof BitmapDrawable) || (bitmapDrawableToBitmap = drawableToBitmap(drawable)) == null) ? drawable : new BitmapDrawable(getResources(), bitmapDrawableToBitmap);
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.mResource;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                this.mResource = 0;
            }
        }
        return fromDrawable(drawable);
    }

    private Matrix updateShaderMatrix(int i, int i2, RectF rectF) {
        float fWidth;
        float fHeight;
        int i3 = this.mShapeType;
        if (3 != i3 && 1 != i3) {
            return getImageMatrix();
        }
        this.mShaderMatrix.set(null);
        float f = i;
        float f2 = i2;
        float fWidth2 = 0.0f;
        if (rectF.height() * f > rectF.width() * f2) {
            fWidth = rectF.height() / f2;
            fWidth2 = (rectF.width() - (f * fWidth)) * 0.5f;
            fHeight = 0.0f;
        } else {
            fWidth = rectF.width() / f;
            fHeight = (rectF.height() - (f2 * fWidth)) * 0.5f;
        }
        this.mShaderMatrix.setScale(fWidth, fWidth);
        this.mShaderMatrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF.left, ((int) (fHeight + 0.5f)) + rectF.top);
        return this.mShaderMatrix;
    }

    public void changeShapeType(int i) {
        changeShapeType(i, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        synchronized (this.mObj) {
            if (this.mInvalidated) {
                this.mInvalidated = false;
                createMask(getMeasuredWidth(), getMeasuredHeight());
            }
            if (this.mReBuildShader) {
                this.mReBuildShader = false;
                createShader();
            }
        }
        if (this.mShaderPaint.getShader() != null) {
            canvas.drawPath(this.mMaskPath, this.mShaderPaint);
            if (this.mBorderWidth > 0) {
                this.mMaskPaint.setStyle(Paint.Style.STROKE);
                this.mMaskPaint.setColor(this.mBorderColor);
                this.mMaskPaint.setStrokeWidth(this.mBorderWidth);
                canvas.drawPath(this.mMaskPath, this.mMaskPaint);
            }
            Drawable drawable = this.mDecorationsView;
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                int intrinsicWidth = this.mDecorationsView.getIntrinsicWidth();
                int intrinsicHeight = this.mDecorationsView.getIntrinsicHeight();
                int i = this.mDirection;
                if (i == 1) {
                    int i2 = this.mPadding;
                    canvas.drawBitmap(bitmap, i2, i2, this.mShaderPaint);
                    return;
                }
                if (i == 2) {
                    canvas.drawBitmap(bitmap, this.mPadding, (getHeight() - intrinsicHeight) - this.mPadding, this.mShaderPaint);
                    return;
                }
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    canvas.drawBitmap(bitmap, (getWidth() - intrinsicWidth) - this.mPadding, (getHeight() - intrinsicHeight) - this.mPadding, this.mShaderPaint);
                } else {
                    int width = getWidth() - intrinsicWidth;
                    canvas.drawBitmap(bitmap, width - r1, this.mPadding, this.mShaderPaint);
                }
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mShapeType == 3) {
            this.mRectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.mInvalidated = true;
        this.mReBuildShader = true;
        invalidate();
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
        invalidate();
    }

    public void setDecorations(int i, int i2, Drawable drawable) {
        this.mDirection = i;
        this.mPadding = i2;
        this.mDecorationsView = fromDrawable(drawable);
        invalidate();
    }

    public void setDegreeForRoundRectangle(int i, int i2) {
        this.mRx = i;
        this.mRy = i2;
    }

    public void setFilterBitmap(boolean z) {
        this.mShaderPaint.setFilterBitmap(z);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.mResource = 0;
        super.setImageDrawable(fromDrawable(drawable));
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.mResource != i) {
            this.mResource = i;
            setImageDrawable(resolveResource());
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (ImageView.ScaleType.FIT_XY == scaleType) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        super.setScaleType(scaleType);
    }

    public EffectiveShapeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void changeShapeType(int i, int i2) {
        if (5 == i && this.mPolygonSides != i2) {
            this.mInvalidated = true;
            if (i2 < 3) {
                i2 = 6;
            }
            this.mPolygonSides = i2;
        } else if (this.mShapeType != i) {
            this.mInvalidated = true;
        }
        this.mShapeType = i;
        invalidate();
    }

    public EffectiveShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 4;
        this.mBorderColor = -16776961;
        this.mShapeType = 2;
        this.mPolygonSides = 6;
        this.mRx = 24.0f;
        this.mRy = 24.0f;
        this.mInvalidated = true;
        this.mReBuildShader = true;
        this.mObj = new Object();
        this.mMaskPaint = new Paint(1);
        this.mShaderPaint = new Paint(1);
        this.mMaskPath = new Path();
        this.mShaderMatrix = new Matrix();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EffectiveShapeView);
            this.mShapeType = typedArrayObtainStyledAttributes.getInt(R$styleable.EffectiveShapeView_esv_shape, this.mShapeType);
            this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.EffectiveShapeView_border_width, 0);
            this.mDirection = typedArrayObtainStyledAttributes.getInt(R$styleable.EffectiveShapeView_decorations_direction, this.mDirection);
            this.mPolygonSides = typedArrayObtainStyledAttributes.getInt(R$styleable.EffectiveShapeView_sides, this.mPolygonSides);
            float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.EffectiveShapeView_radius_x, typedArrayObtainStyledAttributes.getDimension(R$styleable.EffectiveShapeView_radius_x_dp, this.mRx));
            this.mRx = f;
            this.mRy = typedArrayObtainStyledAttributes.getFloat(R$styleable.EffectiveShapeView_radius_y, typedArrayObtainStyledAttributes.getDimension(R$styleable.EffectiveShapeView_radius_y_dp, f));
            this.mDecorationsView = typedArrayObtainStyledAttributes.getDrawable(R$styleable.EffectiveShapeView_decorations_src);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mShaderPaint.setFilterBitmap(false);
    }
}

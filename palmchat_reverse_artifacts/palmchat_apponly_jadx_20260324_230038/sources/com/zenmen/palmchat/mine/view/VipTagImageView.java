package com.zenmen.palmchat.mine.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VipTagImageView extends ImageView {
    private static final int DEFAULT_CORNER_DISTANCE = 20;
    private static final int DEFAULT_TAG_BACKGROUND_COLOR = -1624781376;
    private static final int DEFAULT_TAG_TEXT_COLOR = -1;
    private static final int DEFAULT_TAG_TEXT_SIZE = 15;
    private static final int DEFAULT_TAG_TEXT_STYLE = 0;
    private static final int DEFAULT_TAG_WIDTH = 20;
    public static final byte LEFT_BOTTOM = 2;
    public static final byte LEFT_TOP = 0;
    public static final byte RIGHT_BOTTOM = 3;
    public static final byte RIGHT_TOP = 1;
    public static final String TAG = "SimpleTagImageView";
    public static final byte TEXT_STYLE_BOLD = 1;
    public static final byte TEXT_STYLE_BOLD_ITALIC = 3;
    public static final byte TEXT_STYLE_ITALIC = 2;
    public static final byte TEXT_STYLE_NORMAL = 0;
    private static final float THE_SQUARE_ROOT_OF_2 = (float) Math.sqrt(2.0d);
    private a endPoint;
    private Paint mBitmapPaint;
    private float mCornerDistance;
    private float mDensity;
    private Paint mPaint;
    private Path mPath;
    private int mRoundRadius;
    private RectF mRoundRect;
    private int mTagBackgroundColor;
    private boolean mTagEnable;
    private int mTagOrientation;
    private String mTagText;
    private Rect mTagTextBound;
    private int mTagTextColor;
    private int mTagTextOffsetX;
    private int mTagTextOffsetY;
    private int mTagTextSize;
    private int mTagTextStyle;
    private float mTagWidth;
    private Paint mTextPaint;
    private a startPoint;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f14762a;
        public float b;
    }

    public VipTagImageView(Context context) {
        this(context, null);
    }

    private void chooseTagOrientation(float f) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = this.mTagOrientation;
        if (i == 0) {
            a aVar = this.startPoint;
            aVar.f14762a = 0.0f;
            aVar.b = f;
            a aVar2 = this.endPoint;
            aVar2.f14762a = f;
            aVar2.b = 0.0f;
            return;
        }
        if (i == 1) {
            a aVar3 = this.startPoint;
            float f2 = measuredWidth;
            aVar3.f14762a = f2 - f;
            aVar3.b = 0.0f;
            a aVar4 = this.endPoint;
            aVar4.f14762a = f2;
            aVar4.b = f;
            return;
        }
        if (i == 2) {
            a aVar5 = this.startPoint;
            aVar5.f14762a = 0.0f;
            float f3 = measuredHeight;
            aVar5.b = f3 - f;
            a aVar6 = this.endPoint;
            aVar6.f14762a = f;
            aVar6.b = f3;
            return;
        }
        if (i != 3) {
            return;
        }
        a aVar7 = this.startPoint;
        float f4 = measuredWidth;
        aVar7.f14762a = f4 - f;
        float f5 = measuredHeight;
        aVar7.b = f5;
        a aVar8 = this.endPoint;
        aVar8.f14762a = f4;
        aVar8.b = f5 - f;
    }

    private int dip2px(int i) {
        return (int) ((this.mDensity * i) + 0.5f);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private int px2dip(float f) {
        return (int) ((f / this.mDensity) + 0.5f);
    }

    private void setupBitmapPaint() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapDrawableToBitmap, tileMode, tileMode);
        if (getScaleType() != ImageView.ScaleType.FIT_XY) {
            Log.w(TAG, String.format("Now scale type just support fitXY,other type invalid", new Object[0]));
        }
        Matrix matrix = new Matrix();
        matrix.setScale((getWidth() * 1.0f) / bitmapDrawableToBitmap.getWidth(), (getHeight() * 1.0f) / bitmapDrawableToBitmap.getHeight());
        bitmapShader.setLocalMatrix(matrix);
        if (this.mBitmapPaint == null) {
            Paint paint = new Paint();
            this.mBitmapPaint = paint;
            paint.setDither(false);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(bitmapShader);
        }
    }

    public int getCornerDistance() {
        return px2dip(this.mCornerDistance);
    }

    public int getTagBackgroundColor() {
        return this.mTagBackgroundColor;
    }

    public boolean getTagEnable() {
        return this.mTagEnable;
    }

    public int getTagOrientation() {
        return this.mTagOrientation;
    }

    public int getTagRoundRadius() {
        return this.mRoundRadius;
    }

    public String getTagText() {
        return this.mTagText;
    }

    public int getTagTextColor() {
        return this.mTagTextColor;
    }

    public int getTagTextSize() {
        return this.mTagTextSize;
    }

    public int getTagTextStyle() {
        return this.mTagTextStyle;
    }

    public int getTagWidth() {
        return px2dip(this.mTagWidth);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mRoundRadius == 0) {
            super.onDraw(canvas);
        } else {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                return;
            }
            setupBitmapPaint();
            this.mRoundRect.set(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
            RectF rectF = this.mRoundRect;
            int i = this.mRoundRadius;
            canvas.drawRoundRect(rectF, i, i, this.mBitmapPaint);
        }
        float f = this.mTagWidth;
        if (f <= 0.0f || !this.mTagEnable) {
            return;
        }
        float f2 = this.mCornerDistance + (f / 2.0f);
        chooseTagOrientation(f2);
        this.mTextPaint.setTextSize(this.mTagTextSize);
        Paint paint = this.mTextPaint;
        String str = this.mTagText;
        paint.getTextBounds(str, 0, str.length(), this.mTagTextBound);
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mTagBackgroundColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setStrokeWidth(this.mTagWidth);
        this.mPath.reset();
        Path path = this.mPath;
        a aVar = this.startPoint;
        path.moveTo(aVar.f14762a, aVar.b);
        Path path2 = this.mPath;
        a aVar2 = this.endPoint;
        path2.lineTo(aVar2.f14762a, aVar2.b);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mTextPaint.setColor(this.mTagTextColor);
        this.mTextPaint.setTextSize(this.mTagTextSize);
        this.mTextPaint.setTypeface(Typeface.defaultFromStyle(this.mTagTextStyle));
        this.mTextPaint.setAntiAlias(true);
        canvas.drawTextOnPath(this.mTagText, this.mPath, (((THE_SQUARE_ROOT_OF_2 * f2) / 2.0f) - (this.mTagTextBound.width() / 2)) + dip2px(this.mTagTextOffsetX), (this.mTagTextBound.height() / 2) + dip2px(this.mTagTextOffsetY), this.mTextPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (getDrawable().getIntrinsicHeight() * size) / getDrawable().getIntrinsicWidth());
    }

    public void setCornerDistance(int i) {
        if (this.mCornerDistance == i) {
            return;
        }
        this.mCornerDistance = dip2px(i);
        invalidate();
    }

    public void setTagBackgroundColor(int i) {
        if (this.mTagBackgroundColor == i) {
            return;
        }
        this.mTagBackgroundColor = i;
        invalidate();
    }

    public void setTagEnable(boolean z) {
        if (this.mTagEnable == z) {
            return;
        }
        this.mTagEnable = z;
        invalidate();
    }

    public void setTagOrientation(int i) {
        if (i == this.mTagOrientation) {
            return;
        }
        this.mTagOrientation = i;
        invalidate();
    }

    public void setTagRoundRadius(int i) {
        if (this.mRoundRadius == i) {
            return;
        }
        this.mRoundRadius = i;
        invalidate();
    }

    public void setTagText(String str) {
        if (str.equals(this.mTagText)) {
            return;
        }
        this.mTagText = str;
        invalidate();
    }

    public void setTagTextColor(int i) {
        if (this.mTagTextColor == i) {
            return;
        }
        this.mTagTextColor = i;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.mTagTextSize = dip2px(i);
        invalidate();
    }

    public void setTagTextStyle(int i) {
        if (this.mTagTextStyle == i) {
            return;
        }
        this.mTagTextStyle = i;
        invalidate();
    }

    public void setTagWidth(int i) {
        this.mTagWidth = dip2px(i);
        invalidate();
    }

    public VipTagImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VipTagImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDensity = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleTagImageView, i, 0);
        this.mTagOrientation = typedArrayObtainStyledAttributes.getInteger(3, 0);
        this.mTagWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dip2px(20));
        this.mCornerDistance = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, dip2px(20));
        this.mTagBackgroundColor = typedArrayObtainStyledAttributes.getColor(1, DEFAULT_TAG_BACKGROUND_COLOR);
        this.mTagText = typedArrayObtainStyledAttributes.getString(5);
        this.mTagTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, dip2px(15));
        this.mTagTextOffsetX = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        this.mTagTextOffsetY = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.mTagTextStyle = typedArrayObtainStyledAttributes.getInteger(8, 0);
        this.mTagTextColor = typedArrayObtainStyledAttributes.getColor(6, -1);
        this.mTagEnable = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.mRoundRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(this.mTagText)) {
            this.mTagText = "";
        }
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mTextPaint = new Paint();
        this.mTagTextBound = new Rect();
        this.startPoint = new a();
        this.endPoint = new a();
        this.mRoundRect = new RectF();
    }
}

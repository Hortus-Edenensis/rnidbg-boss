package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.zenmen.giftkit.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NoRepetCircleFlowIndicator extends View {
    private static final int STYLE_FILL = 1;
    private static final int STYLE_STROKE = 0;
    private int currentPosition;
    private float currentScroll;
    private int fadeOutTime;
    private boolean mCentered;
    private final Paint mPaintActive;
    private final Paint mPaintInactive;
    private float mRadius;
    private float mRadiusActive;
    private float mRadiusInactive;
    private NoRepetViewFlow mViewFlow;
    private float spacing;

    public NoRepetCircleFlowIndicator(Context context) {
        super(context);
        this.mRadius = 4.0f;
        this.mRadiusInactive = 4.0f;
        this.mRadiusActive = 4.0f;
        this.spacing = 4.0f;
        this.fadeOutTime = 0;
        this.mPaintInactive = new Paint(1);
        this.mPaintActive = new Paint(1);
        this.currentScroll = 0.0f;
        this.currentPosition = 0;
        this.mCentered = false;
        initColors(-1, -1, 1, 0);
    }

    private void initColors(int i, int i2, int i3, int i4) {
        if (i4 != 1) {
            this.mPaintInactive.setStyle(Paint.Style.STROKE);
            float strokeWidth = this.mPaintInactive.getStrokeWidth();
            if (strokeWidth == 0.0f) {
                strokeWidth = 1.0f / getResources().getDisplayMetrics().density;
            }
            this.mRadiusInactive -= strokeWidth / 2.0f;
        } else {
            this.mPaintInactive.setStyle(Paint.Style.FILL);
        }
        this.mPaintInactive.setColor(i2);
        if (i3 != 0) {
            this.mPaintActive.setStyle(Paint.Style.FILL);
        } else {
            this.mPaintActive.setStyle(Paint.Style.STROKE);
            float strokeWidth2 = this.mPaintInactive.getStrokeWidth();
            if (strokeWidth2 == 0.0f) {
                strokeWidth2 = 1.0f / getResources().getDisplayMetrics().density;
            }
            this.mRadiusActive -= strokeWidth2 / 2.0f;
        }
        this.mPaintActive.setColor(i);
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.mRadius * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        NoRepetViewFlow noRepetViewFlow = this.mViewFlow;
        int viewsCount = noRepetViewFlow != null ? noRepetViewFlow.getViewsCount() : 0;
        int paddingLeft = viewsCount == 0 ? getPaddingLeft() + getPaddingRight() : viewsCount == 1 ? (int) (getPaddingLeft() + getPaddingRight() + this.mRadius) : (int) (getPaddingLeft() + getPaddingRight() + (this.mRadius * 2.0f) + ((viewsCount - 1) * this.spacing));
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        NoRepetViewFlow noRepetViewFlow = this.mViewFlow;
        int viewsCount = noRepetViewFlow != null ? noRepetViewFlow.getViewsCount() : 0;
        if (viewsCount < 2) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i = 0; i < viewsCount; i++) {
            canvas.drawCircle(paddingLeft + this.mRadius + (i * this.spacing), getPaddingTop() + this.mRadius, this.mRadiusInactive, this.mPaintInactive);
        }
        int i2 = this.currentPosition;
        float f = i2 * this.spacing;
        if ((i2 != 0 || this.currentScroll >= 0.0f) && (i2 != this.mViewFlow.getViewsCount() - 1 || this.currentScroll <= 0.0f)) {
            f += this.currentScroll * this.spacing;
        }
        canvas.drawCircle(paddingLeft + this.mRadius + f, getPaddingTop() + this.mRadius, this.mRadiusActive, this.mPaintActive);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    public void onSwitched(int i, float f) {
        this.currentPosition = Math.round(i + f);
        invalidate();
    }

    public void setFillColor(int i) {
        this.mPaintActive.setColor(i);
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.mPaintInactive.setColor(i);
        invalidate();
    }

    public void setViewFlow(NoRepetViewFlow noRepetViewFlow) {
        this.mViewFlow = noRepetViewFlow;
        invalidate();
    }

    public NoRepetCircleFlowIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRadius = 4.0f;
        this.mRadiusInactive = 4.0f;
        this.mRadiusActive = 4.0f;
        this.spacing = 4.0f;
        this.fadeOutTime = 0;
        this.mPaintInactive = new Paint(1);
        this.mPaintActive = new Paint(1);
        this.currentScroll = 0.0f;
        this.currentPosition = 0;
        this.mCentered = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleFlowIndicator);
        int i = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleFlowIndicator_activeType, 1);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleFlowIndicator_activeColor, -1);
        int i2 = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleFlowIndicator_inactiveType, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleFlowIndicator_inactiveColor, 1157627903);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleFlowIndicator_radius, 4.0f);
        this.mRadius = dimension;
        this.mRadiusActive = dimension;
        this.mRadiusInactive = dimension;
        this.spacing = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleFlowIndicator_spacing, 12.0f) + (this.mRadiusActive * 2.0f);
        this.fadeOutTime = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleFlowIndicator_fadeOut, 0);
        this.mCentered = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CircleFlowIndicator_centered, false);
        initColors(color, color2, i, i2);
    }
}

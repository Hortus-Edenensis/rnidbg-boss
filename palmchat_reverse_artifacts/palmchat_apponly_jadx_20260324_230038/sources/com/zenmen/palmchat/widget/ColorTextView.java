package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.zenmen.palmchat.framework.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ColorTextView extends View {
    private int ctvBackgroundColor;
    private int mCornerSize;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private Rect mtitleBound;
    private Paint mtitlePaint;
    private String text;

    public ColorTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint(2);
        paint.setAntiAlias(true);
        paint.setColor(this.ctvBackgroundColor);
        RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        int i = this.mCornerSize;
        canvas.drawRoundRect(rectF, i, i, paint);
        this.mtitlePaint.setColor(this.mTitleTextColor);
        Paint.FontMetricsInt fontMetricsInt = this.mtitlePaint.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i2 = fontMetricsInt.top;
        canvas.drawText(this.text, getPaddingLeft(), ((measuredHeight + i2) / 2) - i2, this.mtitlePaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            this.mtitlePaint.setTextSize(this.mTitleTextSize);
            Paint paint = this.mtitlePaint;
            String str = this.text;
            paint.getTextBounds(str, 0, str.length(), this.mtitleBound);
            int paddingLeft = getPaddingLeft() + this.mtitleBound.width() + getPaddingRight();
            if (paddingLeft <= size) {
                size = paddingLeft;
            }
        }
        if (mode2 != 1073741824) {
            this.mtitlePaint.setTextSize(this.mTitleTextSize);
            Paint paint2 = this.mtitlePaint;
            String str2 = this.text;
            paint2.getTextBounds(str2, 0, str2.length(), this.mtitleBound);
            int paddingTop = getPaddingTop() + this.mtitleBound.height() + getPaddingBottom();
            if (paddingTop <= size2) {
                size2 = paddingTop;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setCtvBackgroundColor(int i) {
        this.ctvBackgroundColor = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public ColorTextView(Context context) {
        this(context, null);
    }

    public ColorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ColorTextView, i, 0);
        this.text = typedArrayObtainStyledAttributes.getString(R$styleable.ColorTextView_ctvText);
        this.mTitleTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ColorTextView_ctvTextColor, -16777216);
        this.mTitleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ColorTextView_ctvTextSize, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.ctvBackgroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ColorTextView_ctvBackground, -1);
        this.mCornerSize = typedArrayObtainStyledAttributes.getInteger(R$styleable.ColorTextView_ctvCornerSize, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mtitlePaint = paint;
        paint.setTextSize(this.mTitleTextSize);
        this.mtitlePaint.setAntiAlias(true);
        this.mtitleBound = new Rect();
        Paint paint2 = this.mtitlePaint;
        String str = this.text;
        paint2.getTextBounds(str, 0, str.length(), this.mtitleBound);
    }
}

package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$styleable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ProgressButton extends AppCompatButton {
    private Context mContext;
    private float mCornerRadius;
    private GradientDrawable mDrawableButton;
    private GradientDrawable mDrawableProgress;
    private GradientDrawable mDrawableProgressBackground;
    private boolean mFinish;
    private int mMaxProgress;
    private int mMinProgress;
    private int mProgress;
    private float mProgressMargin;

    public ProgressButton(Context context) {
        super(context);
        this.mCornerRadius = 3.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        this.mDrawableProgressBackground = new GradientDrawable();
        this.mDrawableProgress = new GradientDrawable();
        this.mDrawableButton = new GradientDrawable();
        int color = getResources().getColor(R$color.btn_ad_color);
        int color2 = getResources().getColor(R$color.btn_ad_download);
        int color3 = getResources().getColor(R$color.btn_ad_bg);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressButton);
        try {
            this.mProgressMargin = typedArrayObtainStyledAttributes.getDimension(R$styleable.ProgressButton_progressMargin, this.mProgressMargin);
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.ProgressButton_cornerRadius, this.mCornerRadius);
            this.mDrawableButton.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ProgressButton_buttonColor, color));
            this.mDrawableProgressBackground.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ProgressButton_progressBackColor, color3));
            this.mDrawableProgress.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ProgressButton_progressColor, color2));
            this.mProgress = typedArrayObtainStyledAttributes.getInteger(R$styleable.ProgressButton_progress, this.mProgress);
            this.mMinProgress = typedArrayObtainStyledAttributes.getInteger(R$styleable.ProgressButton_minProgress, this.mMinProgress);
            this.mMaxProgress = typedArrayObtainStyledAttributes.getInteger(R$styleable.ProgressButton_maxProgress, this.mMaxProgress);
            typedArrayObtainStyledAttributes.recycle();
            this.mDrawableButton.setCornerRadius(me1.a(context, this.mCornerRadius));
            this.mDrawableProgressBackground.setCornerRadius(me1.a(context, this.mCornerRadius));
            this.mDrawableProgress.setCornerRadius(me1.a(context, this.mCornerRadius - this.mProgressMargin));
            this.mDrawableButton.setStroke(me1.b(context, 1), color2);
            setBackgroundDrawable(this.mDrawableButton);
            this.mFinish = false;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.mProgress;
        if (i > this.mMinProgress && i <= this.mMaxProgress && !this.mFinish) {
            float measuredWidth = getMeasuredWidth();
            int i2 = this.mProgress;
            float fA = measuredWidth * (((i2 - r2) / this.mMaxProgress) - this.mMinProgress);
            if (fA < me1.a(this.mContext, this.mCornerRadius) * 2) {
                fA = me1.a(this.mContext, this.mCornerRadius) * 2;
            }
            GradientDrawable gradientDrawable = this.mDrawableProgress;
            float f = this.mProgressMargin;
            gradientDrawable.setBounds((int) f, (int) f, (int) (fA - f), getMeasuredHeight() - ((int) this.mProgressMargin));
            this.mDrawableProgress.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public void reset() {
        this.mFinish = false;
        this.mProgress = this.mMinProgress;
    }

    public void setDrawableProgress(int i) {
        this.mDrawableButton.setColor(i);
        setTextColor(-1);
        this.mDrawableButton.setStroke(me1.b(this.mContext, 1), -1);
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
    }

    public void setMinProgress(int i) {
        this.mMinProgress = i;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        if (i != 0) {
            setBackgroundDrawable(this.mDrawableProgressBackground);
            setTextColor(-1);
        } else {
            setBackgroundDrawable(this.mDrawableButton);
            setTextColor(getResources().getColor(R$color.btn_ad_download));
        }
        invalidate();
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCornerRadius = 3.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mContext = context;
        initialize(context, attributeSet);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadius = 3.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mContext = context;
        initialize(context, attributeSet);
    }
}

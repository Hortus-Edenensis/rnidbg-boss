package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.scwang.smartrefresh.layout.R$id;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import defpackage.fh5;
import defpackage.nf5;
import defpackage.wu4;
import defpackage.xb4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract {
    protected xb4 mArrowDrawable;
    protected ImageView mArrowView;
    protected int mBackgroundColor;
    protected int mFinishDuration;
    protected int mMinHeightOfContent;
    protected int mPaddingBottom;
    protected int mPaddingTop;
    protected xb4 mProgressDrawable;
    protected ImageView mProgressView;
    protected wu4 mRefreshKernel;
    protected boolean mSetAccentColor;
    protected boolean mSetPrimaryColor;
    protected TextView mTitleText;
    public static final int ID_TEXT_TITLE = R$id.srl_classics_title;
    public static final int ID_IMAGE_ARROW = R$id.srl_classics_arrow;
    public static final int ID_IMAGE_PROGRESS = R$id.srl_classics_progress;

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFinishDuration = 500;
        this.mPaddingTop = 20;
        this.mPaddingBottom = 20;
        this.mMinHeightOfContent = 0;
        this.mSpinnerStyle = fh5.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public int onFinish(@NonNull xu4 xu4Var, boolean z) {
        ImageView imageView = this.mProgressView;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.mFinishDuration;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onInitialized(@NonNull wu4 wu4Var, int i, int i2) {
        this.mRefreshKernel = wu4Var;
        wu4Var.j(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mMinHeightOfContent == 0) {
            this.mPaddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.mPaddingBottom = paddingBottom;
            if (this.mPaddingTop == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iD = this.mPaddingTop;
                if (iD == 0) {
                    iD = nf5.d(20.0f);
                }
                this.mPaddingTop = iD;
                int iD2 = this.mPaddingBottom;
                if (iD2 == 0) {
                    iD2 = nf5.d(20.0f);
                }
                this.mPaddingBottom = iD2;
                setPadding(paddingLeft, this.mPaddingTop, paddingRight, iD2);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i3 = this.mMinHeightOfContent;
            if (size < i3) {
                int i4 = (size - i3) / 2;
                setPadding(getPaddingLeft(), i4, getPaddingRight(), i4);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
        if (this.mMinHeightOfContent == 0) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                int measuredHeight = getChildAt(i5).getMeasuredHeight();
                if (this.mMinHeightOfContent < measuredHeight) {
                    this.mMinHeightOfContent = measuredHeight;
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onReleased(@NonNull xu4 xu4Var, int i, int i2) {
        onStartAnimator(xu4Var, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onStartAnimator(@NonNull xu4 xu4Var, int i, int i2) {
        ImageView imageView = this.mProgressView;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.mProgressView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
            }
        }
    }

    public T setAccentColor(@ColorInt int i) {
        this.mSetAccentColor = true;
        this.mTitleText.setTextColor(i);
        xb4 xb4Var = this.mArrowDrawable;
        if (xb4Var != null) {
            xb4Var.a(i);
            this.mArrowView.invalidateDrawable(this.mArrowDrawable);
        }
        xb4 xb4Var2 = this.mProgressDrawable;
        if (xb4Var2 != null) {
            xb4Var2.a(i);
            this.mProgressView.invalidateDrawable(this.mProgressDrawable);
        }
        return (T) self();
    }

    public T setAccentColorId(@ColorRes int i) {
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return (T) self();
    }

    public T setArrowDrawable(Drawable drawable) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageDrawable(drawable);
        return (T) self();
    }

    public T setArrowResource(@DrawableRes int i) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageResource(i);
        return (T) self();
    }

    public T setDrawableArrowSize(float f) {
        ImageView imageView = this.mArrowView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iD = nf5.d(f);
        layoutParams.width = iD;
        layoutParams.height = iD;
        imageView.setLayoutParams(layoutParams);
        return (T) self();
    }

    public T setDrawableMarginRight(float f) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int iD = nf5.d(f);
        marginLayoutParams2.rightMargin = iD;
        marginLayoutParams.rightMargin = iD;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return (T) self();
    }

    public T setDrawableProgressSize(float f) {
        ImageView imageView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iD = nf5.d(f);
        layoutParams.width = iD;
        layoutParams.height = iD;
        imageView.setLayoutParams(layoutParams);
        return (T) self();
    }

    public T setDrawableSize(float f) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iD = nf5.d(f);
        layoutParams2.width = iD;
        layoutParams.width = iD;
        int iD2 = nf5.d(f);
        layoutParams2.height = iD2;
        layoutParams.height = iD2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return (T) self();
    }

    public T setFinishDuration(int i) {
        this.mFinishDuration = i;
        return (T) self();
    }

    public T setPrimaryColor(@ColorInt int i) {
        this.mSetPrimaryColor = true;
        this.mBackgroundColor = i;
        wu4 wu4Var = this.mRefreshKernel;
        if (wu4Var != null) {
            wu4Var.j(this, i);
        }
        return (T) self();
    }

    public T setPrimaryColorId(@ColorRes int i) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return (T) self();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.mSetPrimaryColor) {
                setPrimaryColor(iArr[0]);
                this.mSetPrimaryColor = false;
            }
            if (this.mSetAccentColor) {
                return;
            }
            if (iArr.length > 1) {
                setAccentColor(iArr[1]);
            } else {
                setAccentColor(iArr[0] == -1 ? -10066330 : -1);
            }
            this.mSetAccentColor = false;
        }
    }

    public T setProgressDrawable(Drawable drawable) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageDrawable(drawable);
        return (T) self();
    }

    public T setProgressResource(@DrawableRes int i) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageResource(i);
        return (T) self();
    }

    public T setSpinnerStyle(fh5 fh5Var) {
        this.mSpinnerStyle = fh5Var;
        return (T) self();
    }

    public T setTextSizeTitle(float f) {
        this.mTitleText.setTextSize(f);
        wu4 wu4Var = this.mRefreshKernel;
        if (wu4Var != null) {
            wu4Var.c(this);
        }
        return (T) self();
    }

    public T self() {
        return this;
    }
}

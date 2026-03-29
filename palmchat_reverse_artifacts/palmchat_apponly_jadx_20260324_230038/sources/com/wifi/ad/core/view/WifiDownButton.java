package com.wifi.ad.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.wifi.ad.core.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"AppCompatCustomView"})
public class WifiDownButton extends TextView {
    private int mAdType;
    private float mCornerRadius;
    private int mDownloadStatus;
    private GradientDrawable mDrawableButton;
    private GradientDrawable mDrawableProgress;
    private GradientDrawable mDrawableProgressBackground;
    private boolean mFinish;
    private int mLastProgress;
    private float mLastX;
    private float mLastY;
    private int mMaxProgress;
    private int mMinProgress;
    private int mMoveX;
    private int mMoveY;
    private int mProgress;
    private float mProgressMargin;
    private OnButtonClickListener onButtonClickListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnButtonClickListener {
        void onPerformClick(View view);
    }

    public WifiDownButton(Context context) {
        super(context);
        this.mDownloadStatus = 0;
        this.mAdType = 0;
        this.mCornerRadius = 0.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mFinish = false;
    }

    private void handleDrawable(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() + getCompoundDrawablePadding() + ((int) getPaint().measureText(getText().toString().trim()));
            canvas.save();
            canvas.translate((getWidth() - intrinsicWidth) / 2, 0.0f);
        }
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        this.mDrawableProgressBackground = new GradientDrawable();
        this.mDrawableProgress = new GradientDrawable();
        this.mDrawableButton = new GradientDrawable();
        int color = Color.parseColor("#339AFF");
        int color2 = Color.parseColor("#339AFF");
        int color3 = Color.parseColor("#C2BEB7");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdSDKProgressButton);
        try {
            this.mProgressMargin = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdSDKProgressButton_progressMargin, this.mProgressMargin);
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.AdSDKProgressButton_cornerRadius, this.mCornerRadius);
            this.mDrawableButton.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.AdSDKProgressButton_buttonColor, color));
            this.mDrawableProgressBackground.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.AdSDKProgressButton_progressBackColor, color3));
            this.mDrawableProgress.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.AdSDKProgressButton_progressColor, color2));
            this.mProgress = typedArrayObtainStyledAttributes.getInteger(R.styleable.AdSDKProgressButton_progress, this.mProgress);
            this.mMinProgress = typedArrayObtainStyledAttributes.getInteger(R.styleable.AdSDKProgressButton_minProgress, this.mMinProgress);
            this.mMaxProgress = typedArrayObtainStyledAttributes.getInteger(R.styleable.AdSDKProgressButton_maxProgress, this.mMaxProgress);
            typedArrayObtainStyledAttributes.recycle();
            this.mDrawableButton.setCornerRadius(this.mCornerRadius);
            this.mDrawableProgressBackground.setCornerRadius(this.mCornerRadius);
            float f = this.mCornerRadius - this.mProgressMargin;
            this.mDrawableProgress.setCornerRadii(new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f});
            setBackgroundDrawable(this.mDrawableButton);
            this.mFinish = false;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void resetTouchPoint() {
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mMoveX = 0;
        this.mMoveY = 0;
    }

    private void updateDownloadTextView(int i) {
        this.mFinish = false;
        switch (this.mDownloadStatus) {
            case 0:
            case 1:
                setText(getResources().getString(R.string.download_quick));
                break;
            case 2:
                setText(getResources().getString(R.string.downloaded_to_continue));
                break;
            case 3:
                if (i >= 0) {
                    this.mProgress = i;
                    GradientDrawable gradientDrawable = this.mDrawableProgressBackground;
                    if (gradientDrawable != null) {
                        setBackgroundDrawable(gradientDrawable);
                    }
                    setText(getResources().getString(R.string.downloading) + "..." + this.mProgress + "% ");
                    break;
                }
                break;
            case 4:
                this.mFinish = true;
                GradientDrawable gradientDrawable2 = this.mDrawableButton;
                if (gradientDrawable2 != null) {
                    setBackgroundDrawable(gradientDrawable2);
                }
                setText(getResources().getString(R.string.downloaded_to_install));
                break;
            case 5:
                this.mFinish = true;
                setText(getResources().getString(R.string.downloaded_to_open));
                break;
            case 6:
                Toast.makeText(getContext(), R.string.downloaded_fail_tip, 0).show();
                break;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        handleDrawable(canvas);
        int i2 = this.mProgress;
        if (i2 > this.mMinProgress && i2 <= (i = this.mMaxProgress) && !this.mFinish) {
            float measuredWidth = getMeasuredWidth() * ((this.mProgress - this.mMinProgress) / Math.max(i - r1, 1));
            float f = this.mCornerRadius;
            if (measuredWidth < f * 2.0f) {
                measuredWidth = f * 2.0f;
            }
            GradientDrawable gradientDrawable = this.mDrawableProgress;
            if (gradientDrawable != null) {
                float f2 = this.mProgressMargin;
                gradientDrawable.setBounds((int) f2, (int) f2, (int) (measuredWidth - f2), getMeasuredHeight() - ((int) this.mProgressMargin));
                this.mDrawableProgress.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            resetTouchPoint();
            this.mLastX = motionEvent.getRawX();
            this.mLastY = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 1) {
            if (action == 2) {
                this.mMoveX = (int) (motionEvent.getRawX() - this.mLastX);
                this.mMoveY = (int) (motionEvent.getRawY() - this.mLastY);
            }
        } else {
            if (Math.abs(this.mMoveY) > 200) {
                resetTouchPoint();
                return false;
            }
            resetTouchPoint();
            performClick();
            OnButtonClickListener onButtonClickListener = this.onButtonClickListener;
            if (onButtonClickListener != null) {
                onButtonClickListener.onPerformClick(this);
            }
        }
        return true;
    }

    public void setAction(int i) {
        this.mAdType = i;
        if (i == 1) {
            updateDownloadTextView(-1);
        } else {
            setText(R.string.see_detail);
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public void updateDownloadStatus(int i, int i2) {
        this.mDownloadStatus = i;
        updateDownloadTextView(i2);
    }

    public WifiDownButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDownloadStatus = 0;
        this.mAdType = 0;
        this.mCornerRadius = 0.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mFinish = false;
        initialize(context, attributeSet);
    }

    public WifiDownButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDownloadStatus = 0;
        this.mAdType = 0;
        this.mCornerRadius = 0.0f;
        this.mProgressMargin = 0.0f;
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mFinish = false;
        initialize(context, attributeSet);
    }
}

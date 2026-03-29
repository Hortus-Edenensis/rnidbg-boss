package com.zenmen.palmchat.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TagView extends View {
    private float bdDistance;
    private float fontH;
    private float fontW;
    private boolean isExecLongClick;
    private boolean isMoved;
    private boolean isUp;
    private boolean isViewClickable;
    private boolean isViewSelectable;
    private boolean isViewSelected;
    private String mAbstractText;
    private int mBackgroundColor;
    private Bitmap mBitmapImage;
    private int mBorderColor;
    private float mBorderRadius;
    private float mBorderWidth;
    private float mCrossAreaPadding;
    private float mCrossAreaWidth;
    private int mCrossColor;
    private float mCrossLineWidth;
    private boolean mEnableCross;
    private int mHorizontalPadding;
    private int mLastX;
    private int mLastY;
    private Runnable mLongClickHandle;
    private int mLongPressTime;
    private int mMoveSlop;
    private c mOnTagClickListener;
    private String mOriginText;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;
    private int mRippleAlpha;
    private int mRippleColor;
    private int mRippleDuration;
    private Paint mRipplePaint;
    private float mRippleRadius;
    private ValueAnimator mRippleValueAnimator;
    private int mSelectedBackgroundColor;
    private int mSlopThreshold;
    private int mTagMaxLength;
    private boolean mTagSupportLettersRTL;
    private int mTextColor;
    private int mTextDirection;
    private float mTextSize;
    private float mTouchX;
    private float mTouchY;
    private Typeface mTypeface;
    private int mVerticalPadding;
    private boolean unSupportedClipPath;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TagView.this.isMoved || TagView.this.isUp || ((TagContainerLayout) TagView.this.getParent()).getTagViewState() != 0) {
                return;
            }
            TagView.this.isExecLongClick = true;
            TagView.c(TagView.this);
            ((Integer) TagView.this.getTag()).intValue();
            TagView.this.getText();
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f16003a;

        public b(float f) {
            this.f16003a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TagView tagView = TagView.this;
            if (fFloatValue >= this.f16003a) {
                fFloatValue = 0.0f;
            }
            tagView.mRippleRadius = fFloatValue;
            TagView.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public TagView(Context context, String str) {
        super(context);
        this.mMoveSlop = 5;
        this.mSlopThreshold = 4;
        this.mLongPressTime = 500;
        this.mTextDirection = 3;
        this.mTagSupportLettersRTL = false;
        this.mRippleDuration = 1000;
        this.unSupportedClipPath = false;
        this.mLongClickHandle = new a();
        init(context, str);
    }

    public static /* bridge */ /* synthetic */ c c(TagView tagView) {
        tagView.getClass();
        return null;
    }

    private void drawCross(Canvas canvas) {
        if (isEnableCross()) {
            float height = this.mCrossAreaPadding > ((float) (getHeight() / 2)) ? getHeight() / 2 : this.mCrossAreaPadding;
            this.mCrossAreaPadding = height;
            if (this.mTextDirection != 4) {
                height = (getWidth() - getHeight()) + this.mCrossAreaPadding;
            }
            int i = (int) height;
            int i2 = this.mTextDirection;
            int i3 = (int) (i2 == 4 ? this.mCrossAreaPadding : this.mCrossAreaPadding);
            int width = (int) (i2 == 4 ? this.mCrossAreaPadding : (getWidth() - getHeight()) + this.mCrossAreaPadding);
            int i4 = this.mTextDirection;
            int height2 = (int) (getHeight() - this.mCrossAreaPadding);
            int height3 = (int) ((this.mTextDirection == 4 ? getHeight() : getWidth()) - this.mCrossAreaPadding);
            int i5 = this.mTextDirection;
            int i6 = (int) (i5 == 4 ? this.mCrossAreaPadding : this.mCrossAreaPadding);
            int height4 = (int) ((i5 == 4 ? getHeight() : getWidth()) - this.mCrossAreaPadding);
            int i7 = this.mTextDirection;
            int height5 = (int) (getHeight() - this.mCrossAreaPadding);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mCrossColor);
            this.mPaint.setStrokeWidth(this.mCrossLineWidth);
            canvas.drawLine(i, i3, height4, height5, this.mPaint);
            canvas.drawLine(width, height2, height3, i6, this.mPaint);
        }
    }

    private void drawImage(Canvas canvas) {
        if (isEnableImage()) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.mBitmapImage, Math.round(getHeight() - this.mBorderWidth), Math.round(getHeight() - this.mBorderWidth), false);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmapCreateScaledBitmap, tileMode, tileMode));
            float f = this.mBorderWidth;
            RectF rectF = new RectF(f, f, getHeight() - this.mBorderWidth, getHeight() - this.mBorderWidth);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, paint);
        }
    }

    @TargetApi(11)
    private void drawRipple(Canvas canvas) {
        if (this.isViewClickable) {
            int i = Build.VERSION.SDK_INT;
            if (canvas == null || this.unSupportedClipPath) {
                return;
            }
            try {
                canvas.save();
                this.mPath.reset();
                canvas.clipPath(this.mPath);
                Path path = this.mPath;
                RectF rectF = this.mRectF;
                float f = this.mBorderRadius;
                path.addRoundRect(rectF, f, f, Path.Direction.CCW);
                if (i >= 26) {
                    canvas.clipPath(this.mPath);
                } else {
                    canvas.clipPath(this.mPath, Region.Op.REPLACE);
                }
                canvas.drawCircle(this.mTouchX, this.mTouchY, this.mRippleRadius, this.mRipplePaint);
                canvas.restore();
            } catch (UnsupportedOperationException unused) {
                this.unSupportedClipPath = true;
            }
        }
    }

    private void init(Context context, String str) {
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mRipplePaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mRectF = new RectF();
        this.mPath = new Path();
        if (str == null) {
            str = "";
        }
        this.mOriginText = str;
        this.mMoveSlop = me1.b(context, this.mMoveSlop);
        this.mSlopThreshold = me1.b(context, this.mSlopThreshold);
    }

    private boolean isClickCrossArea(MotionEvent motionEvent) {
        return this.mTextDirection == 4 ? motionEvent.getX() <= this.mCrossAreaWidth : motionEvent.getX() >= ((float) getWidth()) - this.mCrossAreaWidth;
    }

    private void onDealText() {
        if (TextUtils.isEmpty(this.mOriginText)) {
            this.mAbstractText = "";
        } else {
            this.mAbstractText = this.mOriginText.length() <= this.mTagMaxLength ? this.mOriginText : this.mOriginText.substring(0, this.mTagMaxLength - 3) + "...";
        }
        this.mPaint.setTypeface(this.mTypeface);
        this.mPaint.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        this.fontH = fontMetrics.descent - fontMetrics.ascent;
        if (this.mTextDirection != 4) {
            this.fontW = this.mPaint.measureText(this.mAbstractText);
            return;
        }
        this.fontW = 0.0f;
        for (char c2 : this.mAbstractText.toCharArray()) {
            this.fontW += this.mPaint.measureText(String.valueOf(c2));
        }
    }

    @TargetApi(11)
    private void splashRipple() {
        if (this.mTouchX <= 0.0f || this.mTouchY <= 0.0f) {
            return;
        }
        this.mRipplePaint.setColor(this.mRippleColor);
        this.mRipplePaint.setAlpha(this.mRippleAlpha);
        float fMax = Math.max(Math.max(Math.max(this.mTouchX, this.mTouchY), Math.abs(getMeasuredWidth() - this.mTouchX)), Math.abs(getMeasuredHeight() - this.mTouchY));
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, fMax).setDuration(this.mRippleDuration);
        this.mRippleValueAnimator = duration;
        duration.addUpdateListener(new b(fMax));
        this.mRippleValueAnimator.start();
    }

    public void deselectView() {
        if (this.isViewSelectable && getIsViewSelected()) {
            this.isViewSelected = false;
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.isViewClickable) {
            int y = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action == 0) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.mLastY = y;
                this.mLastX = x;
            } else if (action == 2 && !this.isViewSelected && (Math.abs(this.mLastY - y) > this.mSlopThreshold || Math.abs(this.mLastX - x) > this.mSlopThreshold)) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                this.isMoved = true;
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getCrossAreaPadding() {
        return this.mCrossAreaPadding;
    }

    public float getCrossAreaWidth() {
        return this.mCrossAreaWidth;
    }

    public int getCrossColor() {
        return this.mCrossColor;
    }

    public float getCrossLineWidth() {
        return this.mCrossLineWidth;
    }

    public boolean getIsViewClickable() {
        return this.isViewClickable;
    }

    public boolean getIsViewSelected() {
        return this.isViewSelected;
    }

    public int getTagBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getTagSelectedBackgroundColor() {
        return this.mSelectedBackgroundColor;
    }

    public String getText() {
        return this.mOriginText;
    }

    @Override // android.view.View
    public int getTextDirection() {
        return this.mTextDirection;
    }

    public boolean isEnableCross() {
        return this.mEnableCross;
    }

    public boolean isEnableImage() {
        return (this.mBitmapImage == null || this.mTextDirection == 4) ? false : true;
    }

    public boolean isTagSupportLettersRTL() {
        return this.mTagSupportLettersRTL;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(getIsViewSelected() ? this.mSelectedBackgroundColor : this.mBackgroundColor);
        RectF rectF = this.mRectF;
        float f = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPaint.setColor(this.mBorderColor);
        RectF rectF2 = this.mRectF;
        float f2 = this.mBorderRadius;
        canvas.drawRoundRect(rectF2, f2, f2, this.mPaint);
        drawRipple(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mTextColor);
        if (this.mTextDirection != 4) {
            canvas.drawText(this.mAbstractText, (((isEnableCross() ? getWidth() - getHeight() : getWidth()) / 2) - (this.fontW / 2.0f)) + (isEnableImage() ? getHeight() / 2 : 0), ((getHeight() / 2) + (this.fontH / 2.0f)) - this.bdDistance, this.mPaint);
        } else if (this.mTagSupportLettersRTL) {
            float width = ((isEnableCross() ? getWidth() + getHeight() : getWidth()) / 2) + (this.fontW / 2.0f);
            char[] charArray = this.mAbstractText.toCharArray();
            int length = charArray.length;
            while (i < length) {
                String strValueOf = String.valueOf(charArray[i]);
                width -= this.mPaint.measureText(strValueOf);
                canvas.drawText(strValueOf, width, ((getHeight() / 2) + (this.fontH / 2.0f)) - this.bdDistance, this.mPaint);
                i++;
            }
        } else {
            canvas.drawText(this.mAbstractText, ((isEnableCross() ? getWidth() + this.fontW : getWidth()) / 2.0f) - (this.fontW / 2.0f), ((getHeight() / 2) + (this.fontH / 2.0f)) - this.bdDistance, this.mPaint);
        }
        drawCross(canvas);
        drawImage(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.mVerticalPadding * 2) + ((int) this.fontH);
        int i4 = (this.mHorizontalPadding * 2) + ((int) this.fontW) + (isEnableCross() ? i3 : 0) + (isEnableImage() ? i3 : 0);
        this.mCrossAreaWidth = Math.min(Math.max(this.mCrossAreaWidth, i3), i4);
        setMeasuredDimension(i4, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = this.mRectF;
        float f = this.mBorderWidth;
        rectF.set(f, f, i - f, i2 - f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mRippleRadius = 0.0f;
            this.mTouchX = motionEvent.getX();
            this.mTouchY = motionEvent.getY();
            splashRipple();
        }
        if (isEnableCross()) {
            isClickCrossArea(motionEvent);
        }
        boolean z = this.isViewClickable;
        return super.onTouchEvent(motionEvent);
    }

    public void selectView() {
        if (!this.isViewSelectable || getIsViewSelected()) {
            return;
        }
        this.isViewSelected = true;
        postInvalidate();
    }

    public void setBdDistance(float f) {
        this.bdDistance = f;
    }

    public void setBorderRadius(float f) {
        this.mBorderRadius = f;
    }

    public void setBorderWidth(float f) {
        this.mBorderWidth = f;
    }

    public void setCrossAreaPadding(float f) {
        this.mCrossAreaPadding = f;
    }

    public void setCrossAreaWidth(float f) {
        this.mCrossAreaWidth = f;
    }

    public void setCrossColor(int i) {
        this.mCrossColor = i;
    }

    public void setCrossLineWidth(float f) {
        this.mCrossLineWidth = f;
    }

    public void setEnableCross(boolean z) {
        this.mEnableCross = z;
    }

    public void setHorizontalPadding(int i) {
        this.mHorizontalPadding = i;
    }

    public void setImage(Bitmap bitmap) {
        this.mBitmapImage = bitmap;
        invalidate();
    }

    public void setIsViewClickable(boolean z) {
        this.isViewClickable = z;
    }

    public void setIsViewSelectable(boolean z) {
        this.isViewSelectable = z;
    }

    public void setRippleAlpha(int i) {
        this.mRippleAlpha = i;
    }

    public void setRippleColor(int i) {
        this.mRippleColor = i;
    }

    public void setRippleDuration(int i) {
        this.mRippleDuration = i;
    }

    public void setTagBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setTagBorderColor(int i) {
        this.mBorderColor = i;
    }

    public void setTagMaxLength(int i) {
        this.mTagMaxLength = i;
        onDealText();
    }

    public void setTagSelectedBackgroundColor(int i) {
        this.mSelectedBackgroundColor = i;
    }

    public void setTagSupportLettersRTL(boolean z) {
        this.mTagSupportLettersRTL = z;
    }

    public void setTagTextColor(int i) {
        this.mTextColor = i;
    }

    @Override // android.view.View
    public void setTextDirection(int i) {
        this.mTextDirection = i;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        onDealText();
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
        onDealText();
    }

    public void setVerticalPadding(int i) {
        this.mVerticalPadding = i;
    }

    public TagView(Context context, String str, int i) {
        super(context);
        this.mMoveSlop = 5;
        this.mSlopThreshold = 4;
        this.mLongPressTime = 500;
        this.mTextDirection = 3;
        this.mTagSupportLettersRTL = false;
        this.mRippleDuration = 1000;
        this.unSupportedClipPath = false;
        this.mLongClickHandle = new a();
        init(context, str);
        this.mBitmapImage = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setOnTagClickListener(c cVar) {
    }
}

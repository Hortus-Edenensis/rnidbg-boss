package com.zenmen.palmchat.ui.widget.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.zenmen.palmchat.friendcircle.R$styleable;
import defpackage.k36;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CircleProgressView extends View implements View.OnClickListener {
    public static boolean DEBUG = true;
    private static final String TAG = "CircleProgressView";
    private int circleColor;
    private Paint circlePaint;
    private RectF circleRect;
    private int circleSize;
    private volatile int currentPresent;
    private int defaultHeight;
    private int defaultWidth;
    private AlphaAnimation enterAnimation;
    private AlphaAnimation exitAnimation;
    private boolean isFailed;
    private boolean isLoading;
    private long lastThreadId;
    private g onFailedClickListener;
    private int strokeColor;
    private int strokeMargin;
    private Paint strokePaint;
    private int strokeWidth;
    private int textColor;
    private Paint textPaint;
    private int textSize;

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleProgressView.this.reset();
            if (CircleProgressView.this.getAnimation() != null) {
                CircleProgressView.this.clearAnimation();
            }
            CircleProgressView circleProgressView = CircleProgressView.this;
            circleProgressView.startAnimation(circleProgressView.enterAnimation);
            Log.d(CircleProgressView.TAG, "start");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CircleProgressView.this.getAnimation() != null) {
                CircleProgressView.this.clearAnimation();
            }
            CircleProgressView circleProgressView = CircleProgressView.this;
            circleProgressView.startAnimation(circleProgressView.exitAnimation);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleProgressView.this.setVisibility(8);
            CircleProgressView.this.reset();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleProgressView.this.isFailed = true;
            CircleProgressView.this.isLoading = false;
            CircleProgressView.this.lastThreadId = 0L;
            if (CircleProgressView.this.getAnimation() != null) {
                CircleProgressView.this.clearAnimation();
            }
            if (CircleProgressView.this.defaultWidth != 0) {
                CircleProgressView.this.getLayoutParams().width = CircleProgressView.this.defaultWidth * 3 >= k36.d(CircleProgressView.this.getContext()) ? k36.d(CircleProgressView.this.getContext()) : CircleProgressView.this.defaultWidth * 3;
                CircleProgressView circleProgressView = CircleProgressView.this;
                circleProgressView.setLayoutParams(circleProgressView.getLayoutParams());
            }
            CircleProgressView.this.textPaint.setTextSize(30.0f);
            CircleProgressView circleProgressView2 = CircleProgressView.this;
            circleProgressView2.setOnClickListener(circleProgressView2);
            CircleProgressView.this.postInvalidate();
            CircleProgressView.this.setAlpha(1.0f);
            CircleProgressView.this.setVisibility(0);
            Log.d(CircleProgressView.TAG, "failed");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void buildAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.exitAnimation = alphaAnimation;
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.exitAnimation.setDuration(500L);
        this.exitAnimation.setAnimationListener(new a());
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.enterAnimation = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.enterAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.enterAnimation.setAnimationListener(new b());
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressView, 0, 0);
        this.circleSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgressView_inner_circle_size, 0);
        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgressView_inner_text_size, 0);
        this.circleColor = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressView_inner_circle_color, 0);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressView_inner_text_color, 0);
        this.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgressView_stroke_width, 0);
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressView_stroke_color, 0);
        this.strokeMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleProgressView_stroke_margin, 0);
        this.currentPresent = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleProgressView_current_progress, 0);
        typedArrayObtainStyledAttributes.recycle();
        initDefaultValueWhenEmpty(context);
        buildAnimation();
        initPaint();
    }

    private void initDefaultValueWhenEmpty(Context context) {
        if (this.circleSize == 0) {
            this.circleSize = k36.b(30.0f);
        }
        if (this.textSize == 0) {
            this.textSize = 16;
        }
        if (this.circleColor == 0) {
            this.circleColor = -1342177281;
        }
        if (this.textColor == 0) {
            this.textColor = -1;
        }
        if (this.strokeWidth == 0) {
            this.strokeWidth = k36.b(2.0f);
        }
        if (this.strokeColor == 0) {
            this.strokeColor = -1342177281;
        }
        if (this.strokeMargin == 0) {
            this.strokeMargin = k36.b(5.0f);
        }
    }

    private void initPaint() {
        Paint paint = new Paint(1);
        this.circlePaint = paint;
        paint.setColor(this.circleColor);
        this.circlePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        paint2.setColor(this.strokeColor);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeWidth(this.strokeWidth);
        Paint paint3 = new Paint(1);
        this.textPaint = paint3;
        paint3.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setStyle(Paint.Style.FILL);
    }

    public int getCircleColor() {
        return this.circleColor;
    }

    public Paint getCirclePaint() {
        return this.circlePaint;
    }

    public int getCircleSize() {
        return this.circleSize;
    }

    public int getCurrentPresent() {
        return this.currentPresent;
    }

    public g getOnFailedClickListener() {
        return null;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeMargin() {
        return this.strokeMargin;
    }

    public Paint getStrokePaint() {
        return this.strokePaint;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public boolean isFailed() {
        return this.isFailed;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.defaultWidth == 0) {
            this.defaultWidth = getWidth();
        }
        if (this.defaultHeight == 0) {
            this.defaultHeight = getHeight();
        }
        if (this.circleRect == null) {
            int i = this.strokeMargin + this.strokeWidth + 1;
            this.circleRect = new RectF(getPaddingLeft() + i, getPaddingTop() + i, (getPaddingLeft() + getWidth()) - i, (getPaddingTop() + getHeight()) - i);
        }
        if (this.isFailed) {
            Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
            RectF rectF = this.circleRect;
            float f2 = (rectF.bottom - rectF.top) - fontMetricsInt.bottom;
            int i2 = fontMetricsInt.top;
            this.textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("加载失败，点我重新加载", getWidth() / 2, (int) ((r3 + ((f2 + i2) / 2.0f)) - i2), this.textPaint);
            return;
        }
        canvas.drawArc(this.circleRect, -90.0f, this.currentPresent * 3.6f, true, this.circlePaint);
        canvas.drawCircle(this.circleRect.centerX(), this.circleRect.centerY(), ((int) Math.max(this.circleRect.width() / 2.0f, this.circleRect.height() / 2.0f)) + this.strokeMargin, this.strokePaint);
        Paint.FontMetricsInt fontMetricsInt2 = this.textPaint.getFontMetricsInt();
        RectF rectF2 = this.circleRect;
        float f3 = (rectF2.bottom - rectF2.top) - fontMetricsInt2.bottom;
        int i3 = fontMetricsInt2.top;
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.currentPresent + "%", this.circleRect.centerX(), (int) ((r3 + ((f3 + i3) / 2.0f)) - i3), this.textPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.defaultWidth == 0) {
            this.defaultWidth = i;
        }
        if (this.defaultHeight == 0) {
            this.defaultHeight = i2;
        }
        float paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        float paddingBottom = i2 - (getPaddingBottom() + getPaddingTop());
        int i5 = this.strokeMargin + this.strokeWidth + 1;
        if (this.circleRect == null) {
            float paddingLeft2 = getPaddingLeft() + paddingLeft;
            float f2 = i5;
            this.circleRect = new RectF(getPaddingLeft() + i5, getPaddingTop() + i5, paddingLeft2 - f2, (getPaddingTop() + paddingBottom) - f2);
        }
    }

    public synchronized void reset() {
        this.isFailed = false;
        this.lastThreadId = 0L;
        this.currentPresent = 0;
        if (this.defaultWidth != 0 && this.defaultHeight != 0 && getLayoutParams().width != this.defaultWidth) {
            getLayoutParams().width = this.defaultWidth;
            getLayoutParams().height = this.defaultHeight;
            setLayoutParams(getLayoutParams());
        }
        this.textPaint.setTextSize(this.textSize);
        setOnClickListener(null);
        postInvalidate();
    }

    public void setCircleColor(int i) {
        this.circleColor = i;
        postInvalidate();
    }

    public void setCirclePaint(Paint paint) {
        this.circlePaint = paint;
        postInvalidate();
    }

    public void setCircleSize(int i) {
        this.circleSize = i;
        postInvalidate();
    }

    public synchronized void setCurrentPresent(int i) {
        if (this.lastThreadId == 0) {
            this.lastThreadId = Thread.currentThread().getId();
        }
        if (Thread.currentThread().getId() == this.lastThreadId) {
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.currentPresent = i;
            postInvalidate();
        }
    }

    public synchronized void setFailed() {
        post(new f());
    }

    public synchronized void setFinish(boolean z) {
        this.isLoading = false;
        if (z) {
            post(new d());
        } else {
            post(new e());
        }
        Log.d(TAG, "finish");
    }

    public synchronized void setStart() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        post(new c());
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        postInvalidate();
    }

    public void setStrokeMargin(int i) {
        this.strokeMargin = i;
        postInvalidate();
    }

    public void setStrokePaint(Paint paint) {
        this.strokePaint = paint;
        postInvalidate();
    }

    public void setStrokeWidth(int i) {
        this.strokeWidth = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.textColor = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.textSize = i;
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastThreadId = 0L;
        init(context, attributeSet);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CircleProgressView.this.setVisibility(8);
            if (CircleProgressView.this.isFailed) {
                return;
            }
            CircleProgressView.this.reset();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            CircleProgressView.this.currentPresent = 100;
            CircleProgressView.this.postInvalidate();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            CircleProgressView.this.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setOnFailedClickListener(g gVar) {
    }
}

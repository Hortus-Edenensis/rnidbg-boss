package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WaveView extends View {
    private static final String TAG = "WaveView";
    private int colorBegin;
    private int colorEnd;
    private List<b> mCircleList;
    private final Runnable mCreateCircle;
    private long mDuration;
    private float mInitialRadius;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private long mLastCreateTime;
    private float mMaxRadius;
    private float mMaxRadiusRate;
    private boolean mMaxRadiusSet;
    private Paint mPaint;
    private int mSpeed;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveView.this.mIsRunning) {
                WaveView.this.newCircle();
                WaveView waveView = WaveView.this;
                waveView.postDelayed(waveView.mCreateCircle, WaveView.this.mSpeed);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16005a = System.currentTimeMillis();

        public b() {
        }

        public int b() {
            return (int) (255.0f - (WaveView.this.mInterpolator.getInterpolation((c() - WaveView.this.mInitialRadius) / (WaveView.this.mMaxRadius - WaveView.this.mInitialRadius)) * 255.0f));
        }

        public float c() {
            return WaveView.this.mInitialRadius + (WaveView.this.mInterpolator.getInterpolation(((System.currentTimeMillis() - this.f16005a) * 1.0f) / WaveView.this.mDuration) * (WaveView.this.mMaxRadius - WaveView.this.mInitialRadius));
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    private void clear() {
        removeCallbacks(this.mCreateCircle);
        this.mCircleList.clear();
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.wave_view);
        this.mInitialRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.wave_view_init_radius, 0.0f);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.wave_view_max_radius, 0);
        if (dimensionPixelOffset != 0) {
            this.mMaxRadius = dimensionPixelOffset;
            this.mMaxRadiusSet = true;
        }
        this.mDuration = typedArrayObtainStyledAttributes.getInteger(R$styleable.wave_view_wave_duration, TTAdConstant.STYLE_SIZE_RADIO_3_2);
        this.mSpeed = typedArrayObtainStyledAttributes.getInteger(R$styleable.wave_view_wave_speed, 600);
        int i = R$styleable.wave_view_wave_color_begin;
        Resources resources = getResources();
        int i2 = R$color.btn_main;
        this.colorBegin = typedArrayObtainStyledAttributes.getColor(i, resources.getColor(i2));
        this.colorEnd = typedArrayObtainStyledAttributes.getColor(R$styleable.wave_view_wave_color_end, getResources().getColor(i2));
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(this.colorBegin);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void newCircle() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mLastCreateTime;
        if (j <= 0 || j >= this.mSpeed) {
            this.mCircleList.add(new b());
            if (this.mCircleList.size() > 10) {
                this.mCircleList.remove(0);
            }
            invalidate();
            this.mLastCreateTime = jCurrentTimeMillis;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsRunning) {
            this.mIsRunning = false;
            start();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Iterator<b> it = this.mCircleList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            float fC = next.c();
            if (System.currentTimeMillis() - next.f16005a < this.mDuration) {
                this.mPaint.setAlpha(next.b());
                canvas.drawCircle(getWidth() >> 1, getHeight() >> 1, fC, this.mPaint);
            } else {
                it.remove();
            }
        }
        if (this.mCircleList.size() > 0) {
            postInvalidateDelayed(100L);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!this.mMaxRadiusSet) {
            this.mMaxRadius = (Math.min(i, i2) * this.mMaxRadiusRate) / 2.0f;
        }
        this.mPaint.setShader(new LinearGradient(0.0f, i2, i, 0.0f, new int[]{this.colorBegin, this.colorEnd}, (float[]) null, Shader.TileMode.CLAMP));
    }

    public void setColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEndColor(int i) {
        this.colorEnd = i;
        this.mPaint.setShader(new LinearGradient(0.0f, getMeasuredHeight(), getMeasuredWidth(), 0.0f, new int[]{this.colorBegin, this.colorEnd}, (float[]) null, Shader.TileMode.CLAMP));
    }

    public void setInitialRadius(float f) {
        this.mInitialRadius = f;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        if (interpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f) {
        this.mMaxRadius = f;
        this.mMaxRadiusSet = true;
    }

    public void setMaxRadiusRate(float f) {
        this.mMaxRadiusRate = f;
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    public void setStartColor(int i) {
        this.colorBegin = i;
        this.mPaint.setColor(i);
    }

    public void setStyle(Paint.Style style) {
        this.mPaint.setStyle(style);
    }

    public void start() {
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        this.mCreateCircle.run();
    }

    public void stop() {
        this.mIsRunning = false;
    }

    public void stopImmediately() {
        this.mIsRunning = false;
        this.mCircleList.clear();
        invalidate();
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRadius = 0.0f;
        this.mDuration = 3200L;
        this.mSpeed = 800;
        this.mMaxRadiusRate = 1.0f;
        this.mIsRunning = false;
        this.mCircleList = new ArrayList((int) ((this.mDuration / ((long) this.mSpeed)) + 1));
        this.mCreateCircle = new a();
        this.mInterpolator = new LinearInterpolator();
        this.mPaint = new Paint(1);
        init(attributeSet);
    }
}

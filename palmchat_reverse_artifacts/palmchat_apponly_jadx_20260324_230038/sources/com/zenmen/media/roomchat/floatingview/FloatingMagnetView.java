package com.zenmen.media.roomchat.floatingview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import defpackage.jr5;
import defpackage.yb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FloatingMagnetView extends FrameLayout {
    public static final int MARGIN_EDGE = 13;
    private static final int TOUCH_TIME_THRESHOLD = 150;
    private boolean isNearestLeft;
    private long mLastTouchDownTime;
    private yb3 mMagnetViewListener;
    protected a mMoveAnimator;
    private float mOriginalRawX;
    private float mOriginalRawY;
    private float mOriginalX;
    private float mOriginalY;
    private int mScreenHeight;
    protected int mScreenWidth;
    private int mStatusBarHeight;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f11973a = new Handler(Looper.getMainLooper());
        public float b;
        public float c;
        public long d;

        public a() {
        }

        public void b(float f, float f2) {
            this.b = f;
            this.c = f2;
            this.d = System.currentTimeMillis();
            this.f11973a.post(this);
        }

        public final void c() {
            this.f11973a.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float fMin = Math.min(1.0f, (System.currentTimeMillis() - this.d) / 400.0f);
            FloatingMagnetView.this.move((this.b - FloatingMagnetView.this.getX()) * fMin, (this.c - FloatingMagnetView.this.getY()) * fMin);
            if (fMin < 1.0f) {
                this.f11973a.post(this);
            }
        }
    }

    public FloatingMagnetView(Context context) {
        this(context, null);
    }

    private void changeOriginalTouchParams(MotionEvent motionEvent) {
        this.mOriginalX = getX();
        this.mOriginalY = getY();
        this.mOriginalRawX = motionEvent.getRawX();
        this.mOriginalRawY = motionEvent.getRawY();
        this.mLastTouchDownTime = System.currentTimeMillis();
    }

    private void init() {
        this.mMoveAnimator = new a();
        this.mStatusBarHeight = jr5.c(getContext());
        setClickable(true);
        updateSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void move(float f, float f2) {
        setX(getX() + f);
        setY(getY() + f2);
    }

    private void updateViewPosition(MotionEvent motionEvent) {
        setX((this.mOriginalX + motionEvent.getRawX()) - this.mOriginalRawX);
        float rawY = (this.mOriginalY + motionEvent.getRawY()) - this.mOriginalRawY;
        int i = this.mStatusBarHeight;
        if (rawY < i) {
            rawY = i;
        }
        if (rawY > this.mScreenHeight - getHeight()) {
            rawY = this.mScreenHeight - getHeight();
        }
        setY(rawY);
    }

    public void dealClickEvent() {
        yb3 yb3Var = this.mMagnetViewListener;
        if (yb3Var != null) {
            yb3Var.a(this);
        }
    }

    public boolean isNearestLeft() {
        boolean z = getX() < ((float) (this.mScreenWidth / 2));
        this.isNearestLeft = z;
        return z;
    }

    public boolean isOnClickEvent() {
        return System.currentTimeMillis() - this.mLastTouchDownTime < 150;
    }

    public void moveToEdge() {
        moveToEdge(isNearestLeft());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateSize();
        moveToEdge(this.isNearestLeft);
    }

    public void onRemove() {
        yb3 yb3Var = this.mMagnetViewListener;
        if (yb3Var != null) {
            yb3Var.b(this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            changeOriginalTouchParams(motionEvent);
            updateSize();
            this.mMoveAnimator.c();
        } else if (action == 1) {
            moveToEdge();
            if (isOnClickEvent()) {
                dealClickEvent();
            }
        } else if (action == 2) {
            updateViewPosition(motionEvent);
        }
        return true;
    }

    public void setMagnetViewListener(yb3 yb3Var) {
        this.mMagnetViewListener = yb3Var;
    }

    public void updateSize() {
        this.mScreenWidth = jr5.b(getContext()) - getWidth();
        this.mScreenHeight = jr5.a(getContext());
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void moveToEdge(boolean z) {
        this.mMoveAnimator.b(z ? 13.0f : this.mScreenWidth - 13, getY());
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNearestLeft = true;
        init();
    }
}

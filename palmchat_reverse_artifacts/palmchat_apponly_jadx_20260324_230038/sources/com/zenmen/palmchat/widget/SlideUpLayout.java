package com.zenmen.palmchat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SlideUpLayout extends ViewGroup {
    private static final int DEFAULT_DURATION = 300;
    private static final float DEFAULT_PERCENT = 0.2f;
    private boolean isFirstShowBehindView;
    private boolean isStartUp;
    private View mBehindView;
    private int mDefaultPanel;
    private long mDuration;
    private boolean mEnable;
    private View mFrontView;
    private float mInitMotionX;
    private float mInitMotionY;
    private d mOnSlideUpListener;
    private float mPercent;
    private float mSlideOffset;
    private Status mStatus;
    private View mTarget;
    private float mTouchSlop;

    /* JADX INFO: compiled from: SearchBox */
    public enum Status {
        CLOSE,
        OPEN;

        public static Status valueOf(int i) {
            return i == 0 ? CLOSE : 1 == i ? OPEN : CLOSE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SlideUpLayout.this.smoothOpen(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SlideUpLayout.this.mSlideOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SlideUpLayout.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15998a;

        public c(boolean z) {
            this.f15998a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f15998a && SlideUpLayout.this.mStatus == Status.OPEN) {
                SlideUpLayout.this.checkAndFirstOpenPanel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b(boolean z);

        void c();
    }

    public SlideUpLayout(Context context) {
        this(context, null);
    }

    private void animatorSwitch(float f, float f2, boolean z) {
        animatorSwitch(f, f2, z, this.mDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndFirstOpenPanel() {
        if (this.isFirstShowBehindView) {
            this.isFirstShowBehindView = false;
            this.mBehindView.setVisibility(0);
        }
    }

    private void ensureTarget() {
        if (this.mStatus == Status.CLOSE) {
            this.mTarget = this.mFrontView;
        } else {
            this.mTarget = this.mBehindView;
        }
    }

    private void finishTouchEvent() {
        float measuredHeight = getMeasuredHeight();
        int i = (int) (this.mPercent * measuredHeight);
        float f = this.mSlideOffset;
        Status status = Status.CLOSE;
        Status status2 = this.mStatus;
        boolean z = true;
        if (status == status2) {
            if (f <= (-i)) {
                this.mSlideOffset = -r0;
                this.mStatus = Status.OPEN;
                d dVar = this.mOnSlideUpListener;
                if (dVar != null) {
                    dVar.a();
                }
            } else {
                this.mSlideOffset = 0.0f;
                z = false;
            }
        } else if (Status.OPEN != status2) {
            z = false;
        } else if (measuredHeight + f >= i) {
            this.mSlideOffset = 0.0f;
            this.mStatus = status;
        } else {
            this.mSlideOffset = -r0;
            z = false;
        }
        animatorSwitch(f, this.mSlideOffset, z);
    }

    private void processTouchEvent(float f) {
        int measuredHeight = (int) (getMeasuredHeight() * this.mPercent);
        if (Math.abs(f) < this.mTouchSlop) {
            return;
        }
        float f2 = this.mSlideOffset;
        Status status = this.mStatus;
        if (status == Status.CLOSE) {
            if (f >= 0.0f) {
                this.mSlideOffset = 0.0f;
                d dVar = this.mOnSlideUpListener;
                if (dVar != null) {
                    dVar.b(true);
                }
            } else {
                this.mSlideOffset = f;
                d dVar2 = this.mOnSlideUpListener;
                if (dVar2 != null) {
                    dVar2.b(f >= ((float) (-measuredHeight)));
                }
            }
            if (this.mSlideOffset == f2) {
                return;
            }
        } else if (status == Status.OPEN) {
            float f3 = -getMeasuredHeight();
            if (f <= 0.0f) {
                this.mSlideOffset = f3;
            } else {
                this.mSlideOffset = f3 + f;
            }
            if (this.mSlideOffset == f2) {
                return;
            }
        }
        requestLayout();
    }

    public boolean canChildScrollVertically(int i) {
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            return canListViewScroll((AbsListView) view);
        }
        if ((view instanceof FrameLayout) || (view instanceof RelativeLayout) || (view instanceof LinearLayout)) {
            for (int i2 = 0; i2 < ((ViewGroup) this.mTarget).getChildCount(); i2++) {
                View childAt = ((ViewGroup) this.mTarget).getChildAt(i2);
                if (childAt instanceof AbsListView) {
                    return canListViewScroll((AbsListView) childAt);
                }
            }
        }
        return ViewCompat.canScrollVertically(this.mTarget, -i);
    }

    public boolean canListViewScroll(AbsListView absListView) {
        int i;
        if (this.mStatus == Status.OPEN) {
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        int childCount = absListView.getChildCount();
        return childCount > 0 && (absListView.getLastVisiblePosition() < (i = childCount - 1) || absListView.getChildAt(i).getBottom() > absListView.getMeasuredHeight());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (1 >= getChildCount()) {
            throw new RuntimeException("SlideUpLayout only accept child more than 1!!");
        }
        this.mFrontView = getChildAt(0);
        this.mBehindView = getChildAt(1);
        if (this.mDefaultPanel == 1) {
            post(new a());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        ensureTarget();
        if (this.mTarget == null || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitMotionX = motionEvent.getX();
            this.mInitMotionY = motionEvent.getY();
            return false;
        }
        if (action == 1 || action != 2) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = x - this.mInitMotionX;
        float f2 = y - this.mInitMotionY;
        Status status = this.mStatus;
        boolean z = status == Status.CLOSE && f2 > 0.0f;
        boolean z2 = status == Status.OPEN && f2 < 0.0f;
        if (canChildScrollVertically((int) f2)) {
            return false;
        }
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        return fAbs2 > this.mTouchSlop && fAbs2 >= fAbs && !z && !z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = (int) this.mSlideOffset;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.mBehindView) {
                    i5 = i4 + i7;
                    i6 = (i5 + i4) - i2;
                } else {
                    i5 = i2 + i7;
                    i6 = i4 + i7;
                }
                childAt.layout(i, i5, i3, i6);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, iMakeMeasureSpec, iMakeMeasureSpec2);
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mEnable) {
            this.mSlideOffset = savedState.offset;
            Status statusValueOf = Status.valueOf(savedState.status);
            this.mStatus = statusValueOf;
            if (statusValueOf == Status.OPEN) {
                this.mBehindView.setVisibility(0);
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.offset = this.mSlideOffset;
        savedState.status = this.mStatus.ordinal();
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return super.onTouchEvent(motionEvent);
        }
        ensureTarget();
        if (this.mTarget == null || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.mInitMotionY;
                    if (Math.abs(y) > 0.0f && !this.isStartUp) {
                        d dVar = this.mOnSlideUpListener;
                        if (dVar != null) {
                            dVar.c();
                        }
                        this.isStartUp = true;
                    }
                    if (canChildScrollVertically((int) y)) {
                        return false;
                    }
                    processTouchEvent(y);
                }
            }
            finishTouchEvent();
            return false;
        }
        boolean z = this.mTarget instanceof View;
        return true;
    }

    public void setBehindViewVisible(int i) {
        this.mBehindView.setVisibility(i);
        requestLayout();
        invalidate();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setOnSlideUpListener(d dVar) {
        this.mOnSlideUpListener = dVar;
    }

    public void setPercent(float f) {
        this.mPercent = f;
    }

    public void smoothClose(boolean z) {
        Status status = this.mStatus;
        Status status2 = Status.CLOSE;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(-getMeasuredHeight(), 0.0f, true, z ? this.mDuration : 0L);
        }
    }

    public void smoothOpen(boolean z) {
        Status status = this.mStatus;
        Status status2 = Status.OPEN;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(0.0f, -getMeasuredHeight(), true, z ? this.mDuration : 0L);
        }
    }

    public SlideUpLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void animatorSwitch(float f, float f2, boolean z, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.addUpdateListener(new b());
        valueAnimatorOfFloat.addListener(new c(z));
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private float offset;
        private int status;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.offset = parcel.readFloat();
            this.status = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.status);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SlideUpLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = Status.CLOSE;
        this.isFirstShowBehindView = true;
        this.mPercent = 0.2f;
        this.mDuration = 300L;
        this.mDefaultPanel = 0;
        this.isStartUp = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlideUpLayout, i, 0);
        this.mPercent = typedArrayObtainStyledAttributes.getFloat(2, 0.2f);
        this.mDuration = typedArrayObtainStyledAttributes.getInt(1, 300);
        this.mDefaultPanel = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}

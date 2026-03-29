package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import defpackage.c74;
import defpackage.e74;
import defpackage.fh5;
import defpackage.hd1;
import defpackage.j74;
import defpackage.k74;
import defpackage.nf5;
import defpackage.p71;
import defpackage.q71;
import defpackage.r71;
import defpackage.ru4;
import defpackage.su4;
import defpackage.tu4;
import defpackage.uu4;
import defpackage.vu4;
import defpackage.wu4;
import defpackage.x35;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements xu4, NestedScrollingParent {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static p71 sFooterCreator;
    protected static q71 sHeaderCreator;
    protected static r71 sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableDisallowIntercept;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected hd1 mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected hd1 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected wu4 mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected c74 mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected e74 mOnMultiPurposeListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected ru4 mRefreshContent;
    protected vu4 mRefreshFooter;
    protected vu4 mRefreshHeader;
    protected j74 mRefreshListener;
    protected int mScreenHeightPixels;
    protected x35 mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10551a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f10551a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10551a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10551a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10551a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10551a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10551a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10551a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10551a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10551a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10551a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10551a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10551a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10552a;

        public b(boolean z) {
            this.f10552a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.f10552a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10553a;

        public c(boolean z) {
            this.f10553a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                j74 j74Var = smartRefreshLayout.mRefreshListener;
                if (j74Var == null) {
                    smartRefreshLayout.getClass();
                    SmartRefreshLayout.this.finishRefresh(3000);
                } else if (this.f10553a) {
                    j74Var.a(smartRefreshLayout);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                vu4 vu4Var = smartRefreshLayout2.mRefreshHeader;
                if (vu4Var != null) {
                    int i = smartRefreshLayout2.mHeaderHeight;
                    vu4Var.onStartAnimator(smartRefreshLayout2, i, (int) (smartRefreshLayout2.mHeaderMaxDragRate * i));
                }
                SmartRefreshLayout.this.getClass();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.reboundAnimator = null;
                if (smartRefreshLayout.mSpinner == 0 && (refreshState = smartRefreshLayout.mState) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                    smartRefreshLayout.notifyStateChanged(refreshState2);
                    return;
                }
                RefreshState refreshState3 = smartRefreshLayout.mState;
                if (refreshState3 != smartRefreshLayout.mViceState) {
                    smartRefreshLayout.setViceState(refreshState3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.reboundAnimator != null) {
                smartRefreshLayout.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            c74 c74Var = smartRefreshLayout.mLoadMoreListener;
            if (c74Var != null) {
                c74Var.onLoadMore(smartRefreshLayout);
            } else {
                smartRefreshLayout.getClass();
                SmartRefreshLayout.this.finishLoadMore(2000);
            }
            SmartRefreshLayout.this.getClass();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10557a = 0;
        public final /* synthetic */ int b;
        public final /* synthetic */ Boolean c;
        public final /* synthetic */ boolean d;

        public g(int i, Boolean bool, boolean z) {
            this.b = i;
            this.c = bool;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f10557a;
            if (i == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.mState;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                    smartRefreshLayout.mViceState = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.reboundAnimator = null;
                        if (smartRefreshLayout2.mKernel.a(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(refreshState2);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        }
                    } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.mRefreshHeader != null && smartRefreshLayout.mRefreshContent != null) {
                        this.f10557a = i + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, this.b);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
                        if (this.c == Boolean.FALSE) {
                            SmartRefreshLayout.this.setNoMoreData(false);
                        }
                    }
                }
                if (this.c == Boolean.TRUE) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iOnFinish = smartRefreshLayout3.mRefreshHeader.onFinish(smartRefreshLayout3, this.d);
            SmartRefreshLayout.this.getClass();
            if (iOnFinish < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.mIsBeingDragged || smartRefreshLayout4.mNestedInProgress) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mIsBeingDragged) {
                        float f = smartRefreshLayout5.mLastTouchY;
                        smartRefreshLayout5.mTouchY = f;
                        smartRefreshLayout5.mTouchSpinner = 0;
                        smartRefreshLayout5.mIsBeingDragged = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout5.mLastTouchX, (f + smartRefreshLayout5.mSpinner) - (smartRefreshLayout5.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout6.mLastTouchX, smartRefreshLayout6.mLastTouchY + smartRefreshLayout6.mSpinner, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mNestedInProgress) {
                        smartRefreshLayout7.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        smartRefreshLayout8.mNestedInProgress = false;
                        smartRefreshLayout8.mTouchSpinner = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout9.mSpinner;
                if (i2 <= 0) {
                    if (i2 < 0) {
                        smartRefreshLayout9.animSpinner(0, iOnFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                        return;
                    } else {
                        smartRefreshLayout9.mKernel.i(0, false);
                        SmartRefreshLayout.this.mKernel.e(RefreshState.None);
                        return;
                    }
                }
                ValueAnimator valueAnimatorAnimSpinner = smartRefreshLayout9.animSpinner(0, iOnFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerD = smartRefreshLayout10.mEnableScrollContentWhenRefreshed ? smartRefreshLayout10.mRefreshContent.d(smartRefreshLayout10.mSpinner) : null;
                if (valueAnimatorAnimSpinner == null || animatorUpdateListenerD == null) {
                    return;
                }
                valueAnimatorAnimSpinner.addUpdateListener(animatorUpdateListenerD);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10558a = 0;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f10559a;

            /* JADX INFO: renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0839a extends AnimatorListenerAdapter {
                public C0839a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        h hVar = h.this;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.mFooterLocked = false;
                        if (hVar.c) {
                            smartRefreshLayout.setNoMoreData(true);
                        }
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.mState == RefreshState.LoadFinish) {
                            smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                        }
                    }
                }
            }

            public a(int i) {
                this.f10559a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerD;
                ValueAnimator valueAnimatorA;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.mEnableScrollContentWhenLoaded || this.f10559a >= 0) {
                    animatorUpdateListenerD = null;
                } else {
                    animatorUpdateListenerD = smartRefreshLayout.mRefreshContent.d(smartRefreshLayout.mSpinner);
                    if (animatorUpdateListenerD != null) {
                        animatorUpdateListenerD.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0839a c0839a = new C0839a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i = smartRefreshLayout2.mSpinner;
                if (i > 0) {
                    valueAnimatorA = smartRefreshLayout2.mKernel.a(0);
                } else {
                    if (animatorUpdateListenerD != null || i == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout2.reboundAnimator;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.reboundAnimator.cancel();
                            SmartRefreshLayout.this.reboundAnimator = null;
                        }
                        SmartRefreshLayout.this.mKernel.i(0, false);
                        SmartRefreshLayout.this.mKernel.e(RefreshState.None);
                    } else if (hVar.c && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData) {
                        int i2 = smartRefreshLayout2.mFooterHeight;
                        if (i >= (-i2)) {
                            smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                        } else {
                            valueAnimatorA = smartRefreshLayout2.mKernel.a(-i2);
                        }
                    } else {
                        valueAnimatorA = smartRefreshLayout2.mKernel.a(0);
                    }
                    valueAnimatorA = null;
                }
                if (valueAnimatorA != null) {
                    valueAnimatorA.addListener(c0839a);
                } else {
                    c0839a.onAnimationEnd(null);
                }
            }
        }

        public h(int i, boolean z, boolean z2) {
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            int i = this.f10558a;
            if (i == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.mState;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Loading) {
                    smartRefreshLayout.mViceState = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.reboundAnimator = null;
                        if (smartRefreshLayout2.mKernel.a(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(refreshState2);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpCanceled);
                        }
                    } else if (refreshState == RefreshState.Loading && smartRefreshLayout.mRefreshFooter != null && smartRefreshLayout.mRefreshContent != null) {
                        this.f10558a = i + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, this.b);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadFinish);
                        return;
                    }
                }
                if (this.c) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iOnFinish = smartRefreshLayout3.mRefreshFooter.onFinish(smartRefreshLayout3, this.d);
            SmartRefreshLayout.this.getClass();
            if (iOnFinish < Integer.MAX_VALUE) {
                if (this.c) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    z = smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout4.mSpinner < 0 && smartRefreshLayout4.mRefreshContent.f();
                }
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout5.mSpinner;
                int iMax = i2 - (z ? Math.max(i2, -smartRefreshLayout5.mFooterHeight) : 0);
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                if (smartRefreshLayout6.mIsBeingDragged || smartRefreshLayout6.mNestedInProgress) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mIsBeingDragged) {
                        float f = smartRefreshLayout7.mLastTouchY;
                        smartRefreshLayout7.mTouchY = f;
                        smartRefreshLayout7.mTouchSpinner = smartRefreshLayout7.mSpinner - iMax;
                        smartRefreshLayout7.mIsBeingDragged = false;
                        float f2 = smartRefreshLayout7.mEnableFooterTranslationContent ? iMax : 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout7.mLastTouchX, f + f2 + (smartRefreshLayout7.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY + f2, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.mNestedInProgress) {
                        smartRefreshLayout9.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        smartRefreshLayout10.mNestedInProgress = false;
                        smartRefreshLayout10.mTouchSpinner = 0;
                    }
                }
                SmartRefreshLayout.this.mHandler.postDelayed(new a(iMax), SmartRefreshLayout.this.mSpinner < 0 ? iOnFinish : 0L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f10561a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator == null || smartRefreshLayout.mRefreshHeader == null) {
                    return;
                }
                smartRefreshLayout.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.reboundAnimator = null;
                    if (smartRefreshLayout.mRefreshHeader == null) {
                        smartRefreshLayout.mKernel.e(RefreshState.None);
                        return;
                    }
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.mKernel.e(refreshState2);
                    }
                    SmartRefreshLayout.this.setStateRefreshing(!r5.c);
                }
            }
        }

        public i(float f, int i, boolean z) {
            this.f10561a = f;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mViceState != RefreshState.Refreshing) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                SmartRefreshLayout.this.reboundAnimator.cancel();
                SmartRefreshLayout.this.reboundAnimator = null;
            }
            SmartRefreshLayout.this.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.mKernel.e(RefreshState.PullDownToRefresh);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, (int) (smartRefreshLayout2.mHeaderHeight * this.f10561a));
            SmartRefreshLayout.this.reboundAnimator.setDuration(this.b);
            SmartRefreshLayout.this.reboundAnimator.setInterpolator(new nf5(nf5.b));
            SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
            SmartRefreshLayout.this.reboundAnimator.addListener(new b());
            SmartRefreshLayout.this.reboundAnimator.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f10564a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator == null || smartRefreshLayout.mRefreshFooter == null) {
                    return;
                }
                smartRefreshLayout.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.reboundAnimator = null;
                    if (smartRefreshLayout.mRefreshFooter == null) {
                        smartRefreshLayout.mKernel.e(RefreshState.None);
                        return;
                    }
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.mKernel.e(refreshState2);
                    }
                    SmartRefreshLayout.this.setStateLoading(!r5.c);
                }
            }
        }

        public j(float f, int i, boolean z) {
            this.f10564a = f;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mViceState != RefreshState.Loading) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                SmartRefreshLayout.this.reboundAnimator.cancel();
                SmartRefreshLayout.this.reboundAnimator = null;
            }
            SmartRefreshLayout.this.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.mKernel.e(RefreshState.PullUpToLoad);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, -((int) (smartRefreshLayout2.mFooterHeight * this.f10564a)));
            SmartRefreshLayout.this.reboundAnimator.setDuration(this.b);
            SmartRefreshLayout.this.reboundAnimator.setInterpolator(new nf5(nf5.b));
            SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
            SmartRefreshLayout.this.reboundAnimator.addListener(new b());
            SmartRefreshLayout.this.reboundAnimator.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public int c;
        public float f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10567a = 0;
        public int b = 10;
        public float e = 0.0f;
        public long d = AnimationUtils.currentAnimationTimeMillis();

        public k(float f, int i) {
            this.f = f;
            this.c = i;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.b);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.e(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.e(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.mSpinner) < Math.abs(this.c)) {
                double d = this.f;
                this.f10567a = this.f10567a + 1;
                this.f = (float) (d * Math.pow(0.949999988079071d, r2 * 2));
            } else if (this.c != 0) {
                double d2 = this.f;
                this.f10567a = this.f10567a + 1;
                this.f = (float) (d2 * Math.pow(0.44999998807907104d, r2 * 2));
            } else {
                double d3 = this.f;
                this.f10567a = this.f10567a + 1;
                this.f = (float) (d3 * Math.pow(0.8500000238418579d, r2 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.f * (((jCurrentAnimationTimeMillis - this.d) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.d = jCurrentAnimationTimeMillis;
                float f2 = this.e + f;
                this.e = f2;
                SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.mViceState;
            boolean z = refreshState.isDragging;
            if (z && refreshState.isHeader) {
                smartRefreshLayout2.mKernel.e(RefreshState.PullDownCanceled);
            } else if (z && refreshState.isFooter) {
                smartRefreshLayout2.mKernel.e(RefreshState.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.animationRunnable = null;
            if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.c)) {
                int iMin = Math.min(Math.max((int) nf5.j(Math.abs(SmartRefreshLayout.this.mSpinner - this.c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.animSpinner(this.c, 0, smartRefreshLayout4.mReboundInterpolator, iMin);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10568a;
        public float d;
        public int b = 0;
        public int c = 10;
        public float e = 0.98f;
        public long f = 0;
        public long g = AnimationUtils.currentAnimationTimeMillis();

        public l(float f) {
            this.d = f;
            this.f10568a = SmartRefreshLayout.this.mSpinner;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Runnable a() {
            RefreshState refreshState;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState2 = smartRefreshLayout.mState;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (smartRefreshLayout.mSpinner != 0) {
                if (refreshState2.isOpening || (smartRefreshLayout.mFooterNoMoreData && smartRefreshLayout.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout.mFooterNoMoreDataEffective && smartRefreshLayout.isEnableRefreshOrLoadMore(smartRefreshLayout.mEnableLoadMore))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState == RefreshState.Loading || (smartRefreshLayout2.mFooterNoMoreData && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout2.mFooterNoMoreDataEffective && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.mSpinner >= (-smartRefreshLayout3.mFooterHeight)) {
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            if (smartRefreshLayout4.mState == RefreshState.Refreshing && smartRefreshLayout4.mSpinner > smartRefreshLayout4.mHeaderHeight) {
                                int i = SmartRefreshLayout.this.mSpinner;
                                float fPow = this.d;
                                int i2 = 0;
                                int i3 = i;
                                while (true) {
                                    if (i * i3 <= 0) {
                                        break;
                                    }
                                    i2++;
                                    fPow = (float) (((double) fPow) * Math.pow(this.e, (this.c * i2) / 10.0f));
                                    float f = ((this.c * 1.0f) / 1000.0f) * fPow;
                                    if (Math.abs(f) < 1.0f) {
                                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                                        RefreshState refreshState3 = smartRefreshLayout5.mState;
                                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i3 > smartRefreshLayout5.mHeaderHeight) || (refreshState3 != refreshState && i3 < (-smartRefreshLayout5.mFooterHeight)))) {
                                            return null;
                                        }
                                    } else {
                                        i3 = (int) (i3 + f);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.f = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.c);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = jCurrentAnimationTimeMillis - this.g;
            float fPow = (float) (((double) this.d) * Math.pow(this.e, (jCurrentAnimationTimeMillis - this.f) / (1000.0f / this.c)));
            this.d = fPow;
            float f = fPow * ((j * 1.0f) / 1000.0f);
            if (Math.abs(f) <= 1.0f) {
                SmartRefreshLayout.this.animationRunnable = null;
                return;
            }
            this.g = jCurrentAnimationTimeMillis;
            int i = (int) (this.f10568a + f);
            this.f10568a = i;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.mSpinner * i > 0) {
                smartRefreshLayout2.mKernel.i(i, true);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.c);
                return;
            }
            smartRefreshLayout2.animationRunnable = null;
            smartRefreshLayout2.mKernel.i(0, true);
            nf5.e(SmartRefreshLayout.this.mRefreshContent.h(), (int) (-this.d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.mFooterLocked || f <= 0.0f) {
                return;
            }
            smartRefreshLayout3.mFooterLocked = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements wu4 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.mKernel.e(RefreshState.TwoLevel);
                }
            }
        }

        public m() {
        }

        @Override // defpackage.wu4
        public ValueAnimator a(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // defpackage.wu4
        public wu4 b(@NonNull vu4 vu4Var, boolean z) {
            if (vu4Var.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (vu4Var.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        @Override // defpackage.wu4
        public wu4 c(@NonNull vu4 vu4Var) {
            if (vu4Var.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                hd1 hd1Var = smartRefreshLayout.mHeaderHeightStatus;
                if (hd1Var.b) {
                    smartRefreshLayout.mHeaderHeightStatus = hd1Var.c();
                }
            } else if (vu4Var.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                hd1 hd1Var2 = smartRefreshLayout2.mFooterHeightStatus;
                if (hd1Var2.b) {
                    smartRefreshLayout2.mFooterHeightStatus = hd1Var2.c();
                }
            }
            return this;
        }

        @Override // defpackage.wu4
        @NonNull
        public xu4 d() {
            return SmartRefreshLayout.this;
        }

        @Override // defpackage.wu4
        public wu4 e(@NonNull RefreshState refreshState) {
            switch (a.f10551a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                    } else if (smartRefreshLayout.mSpinner != 0) {
                        a(0);
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.isOpening && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(RefreshState.PullUpToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.isOpening && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        e(RefreshState.None);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(RefreshState.PullUpCanceled);
                            e(RefreshState.None);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.isOpening && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(RefreshState.ReleaseToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.isOpening && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.isOpening && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.isOpening && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                default:
                    SmartRefreshLayout.this.notifyStateChanged(refreshState);
                    break;
            }
            return null;
        }

        @Override // defpackage.wu4
        public wu4 f() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.e(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    i(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    a(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // defpackage.wu4
        public wu4 g(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // defpackage.wu4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public wu4 h(boolean z) {
            if (z) {
                a aVar = new a();
                ValueAnimator valueAnimatorA = a(SmartRefreshLayout.this.getMeasuredHeight());
                if (valueAnimatorA != null) {
                    if (valueAnimatorA == SmartRefreshLayout.this.reboundAnimator) {
                        valueAnimatorA.setDuration(r1.mFloorDuration);
                        valueAnimatorA.addListener(aVar);
                    } else {
                        aVar.onAnimationEnd(null);
                    }
                }
            } else if (a(0) == null) {
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
        @Override // defpackage.wu4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public wu4 i(int i, boolean z) {
            int i2;
            boolean z2;
            vu4 vu4Var;
            vu4 vu4Var2;
            SmartRefreshLayout smartRefreshLayout;
            vu4 vu4Var3;
            vu4 vu4Var4;
            vu4 vu4Var5;
            vu4 vu4Var6;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.mSpinner == i && (((vu4Var5 = smartRefreshLayout2.mRefreshHeader) == null || !vu4Var5.isSupportHorizontalDrag()) && ((vu4Var6 = SmartRefreshLayout.this.mRefreshFooter) == null || !vu4Var6.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout3.mSpinner;
            smartRefreshLayout3.mSpinner = i;
            if (z) {
                RefreshState refreshState = smartRefreshLayout3.mViceState;
                if (refreshState.isDragging || refreshState.isOpening) {
                    if (i > smartRefreshLayout3.mHeaderHeight * smartRefreshLayout3.mHeaderTriggerRate) {
                        if (smartRefreshLayout3.mState != RefreshState.ReleaseToTwoLevel) {
                            smartRefreshLayout3.mKernel.e(RefreshState.ReleaseToRefresh);
                        }
                    } else if ((-i) > smartRefreshLayout3.mFooterHeight * smartRefreshLayout3.mFooterTriggerRate && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.e(RefreshState.ReleaseToLoad);
                    } else if (i < 0 && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.e(RefreshState.PullUpToLoad);
                    } else if (i > 0) {
                        smartRefreshLayout3.mKernel.e(RefreshState.PullDownToRefresh);
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            if (smartRefreshLayout4.mRefreshContent != null) {
                if (i < 0 || (vu4Var4 = smartRefreshLayout4.mRefreshHeader) == null) {
                    i2 = 0;
                    z2 = false;
                    if (i <= 0 && (vu4Var3 = (smartRefreshLayout = SmartRefreshLayout.this).mRefreshFooter) != null) {
                        if (!smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.mEnableFooterTranslationContent, vu4Var3)) {
                            i2 = i;
                        } else if (i3 > 0) {
                            i2 = 0;
                        }
                        z2 = true;
                    }
                    if (z2) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.mRefreshContent.e(i2, smartRefreshLayout5.mHeaderTranslationViewId, smartRefreshLayout5.mFooterTranslationViewId);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.mFooterNoMoreData && smartRefreshLayout6.mFooterNoMoreDataEffective && smartRefreshLayout6.mEnableFooterFollowWhenNoMoreData) {
                            vu4 vu4Var7 = smartRefreshLayout6.mRefreshFooter;
                            if ((vu4Var7 instanceof tu4) && vu4Var7.getSpinnerStyle() == fh5.d) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableLoadMore)) {
                                    SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(Math.max(0, i2));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z3 = (smartRefreshLayout8.mEnableClipHeaderWhenFixedBehind && (vu4Var2 = smartRefreshLayout8.mRefreshHeader) != null && vu4Var2.getSpinnerStyle() == fh5.f) || SmartRefreshLayout.this.mHeaderBackgroundColor != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z4 = (smartRefreshLayout9.mEnableClipFooterWhenFixedBehind && (vu4Var = smartRefreshLayout9.mRefreshFooter) != null && vu4Var.getSpinnerStyle() == fh5.f) || SmartRefreshLayout.this.mFooterBackgroundColor != 0;
                        if ((z3 && (i2 >= 0 || i3 > 0)) || (z4 && (i2 <= 0 || i3 < 0))) {
                            smartRefreshLayout3.invalidate();
                        }
                    }
                } else {
                    if (smartRefreshLayout4.isEnableTranslationContent(smartRefreshLayout4.mEnableHeaderTranslationContent, vu4Var4)) {
                        i2 = i;
                    } else {
                        if (i3 < 0) {
                            i2 = 0;
                        }
                        i2 = 0;
                        z2 = false;
                        if (i <= 0) {
                            if (!smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.mEnableFooterTranslationContent, vu4Var3)) {
                            }
                            z2 = true;
                        }
                        if (z2) {
                        }
                    }
                    z2 = true;
                    if (i <= 0) {
                    }
                    if (z2) {
                    }
                }
            }
            if ((i >= 0 || i3 > 0) && SmartRefreshLayout.this.mRefreshHeader != null) {
                int iMax = Math.max(i, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout10.mHeaderHeight;
                int i5 = (int) (i4 * smartRefreshLayout10.mHeaderMaxDragRate);
                float f = (iMax * 1.0f) / (i4 == 0 ? 1 : i4);
                if (smartRefreshLayout10.isEnableRefreshOrLoadMore(smartRefreshLayout10.mEnableRefresh) || (SmartRefreshLayout.this.mState == RefreshState.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout11.mSpinner) {
                        if (smartRefreshLayout11.mRefreshHeader.getSpinnerStyle() == fh5.d) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (smartRefreshLayout12.mHeaderBackgroundColor != 0 && smartRefreshLayout12.mPaint != null && !smartRefreshLayout12.isEnableTranslationContent(smartRefreshLayout12.mEnableHeaderTranslationContent, smartRefreshLayout12.mRefreshHeader)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle().c) {
                            View view = SmartRefreshLayout.this.mRefreshHeader.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.sDefaultMarginLP;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.mSpinner - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i6 = marginLayoutParams.leftMargin;
                            int i7 = marginLayoutParams.topMargin + SmartRefreshLayout.this.mHeaderInsetStart;
                            view.layout(i6, i7, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + i7);
                        }
                        SmartRefreshLayout.this.mRefreshHeader.onMoving(z, f, iMax, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                        int i8 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.mRefreshHeader.onHorizontalDrag(smartRefreshLayout13.mLastTouchX / (width == 0 ? 1 : width), i8, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout14.mSpinner) {
                    smartRefreshLayout14.getClass();
                }
            }
            if ((i <= 0 || i3 < 0) && SmartRefreshLayout.this.mRefreshFooter != null) {
                int i9 = -Math.min(i, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i10 = smartRefreshLayout15.mFooterHeight;
                int i11 = (int) (i10 * smartRefreshLayout15.mFooterMaxDragRate);
                float f2 = (i9 * 1.0f) / (i10 == 0 ? 1 : i10);
                if (smartRefreshLayout15.isEnableRefreshOrLoadMore(smartRefreshLayout15.mEnableLoadMore) || (SmartRefreshLayout.this.mState == RefreshState.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout16.mSpinner) {
                        if (smartRefreshLayout16.mRefreshFooter.getSpinnerStyle() == fh5.d) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (smartRefreshLayout17.mFooterBackgroundColor != 0 && smartRefreshLayout17.mPaint != null && !smartRefreshLayout17.isEnableTranslationContent(smartRefreshLayout17.mEnableFooterTranslationContent, smartRefreshLayout17.mRefreshFooter)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle().c) {
                            View view2 = SmartRefreshLayout.this.mRefreshFooter.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.sDefaultMarginLP;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.mSpinner) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i12 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout3.getMeasuredHeight()) - SmartRefreshLayout.this.mFooterInsetStart;
                            view2.layout(i12, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i12, measuredHeight);
                        }
                        SmartRefreshLayout.this.mRefreshFooter.onMoving(z, f2, i9, i10, i11);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                        int i13 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width2 = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        smartRefreshLayout18.mRefreshFooter.onHorizontalDrag(smartRefreshLayout18.mLastTouchX / (width2 == 0 ? 1 : width2), i13, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout19.mSpinner) {
                    smartRefreshLayout19.getClass();
                }
            }
            return this;
        }

        @Override // defpackage.wu4
        public wu4 j(@NonNull vu4 vu4Var, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (vu4Var.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (vu4Var.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public ValueAnimator animSpinner(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.mSpinner == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.animationRunnable = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mSpinner, i2);
        this.reboundAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i4);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new d());
        this.reboundAnimator.addUpdateListener(new e());
        this.reboundAnimator.setStartDelay(i3);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    public void animSpinnerBounce(float f2) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f2 > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new k(f2, this.mHeaderHeight);
                return;
            }
            if (f2 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new k(f2, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new k(f2, 0);
            }
        }
    }

    public boolean autoLoadMore() {
        int i2 = this.mReboundDuration;
        int i3 = this.mFooterHeight;
        float f2 = i3 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoLoadMore(0, i2, f2 / i3, false);
    }

    public boolean autoLoadMoreAnimationOnly() {
        int i2 = this.mReboundDuration;
        int i3 = this.mFooterHeight;
        float f2 = i3 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoLoadMore(0, i2, f2 / i3, true);
    }

    public boolean autoRefresh() {
        int i2 = this.mAttachedToWindow ? 0 : 400;
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, false);
    }

    public boolean autoRefreshAnimationOnly() {
        int i2 = this.mAttachedToWindow ? 0 : 400;
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, true);
    }

    @Override // defpackage.xu4
    public xu4 closeHeaderOrFooter() {
        RefreshState refreshState;
        RefreshState refreshState2 = this.mState;
        RefreshState refreshState3 = RefreshState.None;
        if (refreshState2 == refreshState3 && ((refreshState = this.mViceState) == RefreshState.Refreshing || refreshState == RefreshState.Loading)) {
            this.mViceState = refreshState3;
        }
        if (refreshState2 == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState2 == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mKernel.a(0) == null) {
            notifyStateChanged(refreshState3);
        } else if (this.mState.isHeader) {
            notifyStateChanged(RefreshState.PullDownCanceled);
        } else {
            notifyStateChanged(RefreshState.PullUpCanceled);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || !((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.i())) && (finalY <= 0 || !((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.f()))) {
                this.mVerticalPermit = true;
                invalidate();
            } else {
                if (this.mVerticalPermit) {
                    animSpinnerBounce(finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity());
                }
                this.mScroller.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
    
        if (r2.isFooter == false) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        char c2;
        vu4 vu4Var;
        vu4 vu4Var2;
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 0;
        boolean z = actionMasked == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                x += motionEvent.getX(i3);
                y += motionEvent.getY(i3);
            }
        }
        if (z) {
            pointerCount--;
        }
        float f2 = pointerCount;
        float f3 = x / f2;
        float f4 = y / f2;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f4 - this.mLastTouchY;
        }
        this.mLastTouchX = f3;
        this.mLastTouchY = f4;
        if (this.mNestedInProgress) {
            int i4 = this.mTotalUnconsumed;
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i4 == this.mTotalUnconsumed) {
                int i5 = (int) this.mLastTouchX;
                int width = getWidth();
                float f5 = this.mLastTouchX / (width != 0 ? width : 1);
                if (isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mSpinner > 0 && (vu4Var2 = this.mRefreshHeader) != null && vu4Var2.isSupportHorizontalDrag()) {
                    this.mRefreshHeader.onHorizontalDrag(f5, i5, width);
                } else if (isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mSpinner < 0 && (vu4Var = this.mRefreshFooter) != null && vu4Var.isSupportHorizontalDrag()) {
                    this.mRefreshFooter.onHorizontalDrag(f5, i5, width);
                }
            }
            return zDispatchTouchEvent;
        }
        if (isEnabled() && (this.mEnableRefresh || this.mEnableLoadMore || this.mEnableOverScrollDrag)) {
            if (this.mHeaderNeedTouchEventWhenRefreshing) {
                RefreshState refreshState2 = this.mState;
                if ((!refreshState2.isOpening && !refreshState2.isFinishing) || !refreshState2.isHeader) {
                    if (this.mFooterNeedTouchEventWhenLoading) {
                        RefreshState refreshState3 = this.mState;
                        if (!refreshState3.isOpening) {
                            if (refreshState3.isFinishing) {
                            }
                        }
                    }
                    if (!interceptAnimatorByAction(actionMasked)) {
                        RefreshState refreshState4 = this.mState;
                        if (!refreshState4.isFinishing && ((refreshState4 != (refreshState = RefreshState.Loading) || !this.mDisableContentWhenLoading) && (refreshState4 != RefreshState.Refreshing || !this.mDisableContentWhenRefresh))) {
                            if (actionMasked == 0) {
                                this.mCurrentVelocity = 0;
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mScroller.forceFinished(true);
                                this.mTouchX = f3;
                                this.mTouchY = f4;
                                this.mLastSpinner = 0;
                                this.mTouchSpinner = this.mSpinner;
                                this.mIsBeingDragged = false;
                                this.mEnableDisallowIntercept = false;
                                this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                                if (this.mState == RefreshState.TwoLevel && this.mTouchY < (getMeasuredHeight() * 5.0f) / 6.0f) {
                                    this.mDragDirection = 'h';
                                    return this.mSuperDispatchTouchEvent;
                                }
                                ru4 ru4Var = this.mRefreshContent;
                                if (ru4Var != null) {
                                    ru4Var.a(motionEvent);
                                }
                                return true;
                            }
                            if (actionMasked != 1) {
                                if (actionMasked == 2) {
                                    float f6 = f3 - this.mTouchX;
                                    float f7 = f4 - this.mTouchY;
                                    this.mVelocityTracker.addMovement(motionEvent);
                                    if (!this.mIsBeingDragged && !this.mEnableDisallowIntercept && (c2 = this.mDragDirection) != 'h' && this.mRefreshContent != null) {
                                        if (c2 == 'v' || (Math.abs(f7) >= this.mTouchSlop && Math.abs(f6) < Math.abs(f7))) {
                                            this.mDragDirection = 'v';
                                            if (f7 > 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.i()))) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = f4 - this.mTouchSlop;
                                            } else if (f7 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && ((this.mState == refreshState && this.mFooterLocked) || this.mRefreshContent.f())))) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = this.mTouchSlop + f4;
                                            }
                                            if (this.mIsBeingDragged) {
                                                f7 = f4 - this.mTouchY;
                                                if (this.mSuperDispatchTouchEvent) {
                                                    motionEvent.setAction(3);
                                                    super.dispatchTouchEvent(motionEvent);
                                                }
                                                wu4 wu4Var = this.mKernel;
                                                int i6 = this.mSpinner;
                                                wu4Var.e((i6 > 0 || (i6 == 0 && f7 > 0.0f)) ? RefreshState.PullDownToRefresh : RefreshState.PullUpToLoad);
                                                ViewParent parent = getParent();
                                                if (parent instanceof ViewGroup) {
                                                    ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                                }
                                            }
                                        } else if (Math.abs(f6) >= this.mTouchSlop && Math.abs(f6) > Math.abs(f7) && this.mDragDirection != 'v') {
                                            this.mDragDirection = 'h';
                                        }
                                    }
                                    if (this.mIsBeingDragged) {
                                        int i7 = ((int) f7) + this.mTouchSpinner;
                                        RefreshState refreshState5 = this.mViceState;
                                        if ((refreshState5.isHeader && (i7 < 0 || this.mLastSpinner < 0)) || (refreshState5.isFooter && (i7 > 0 || this.mLastSpinner > 0))) {
                                            this.mLastSpinner = i7;
                                            long eventTime = motionEvent.getEventTime();
                                            if (this.mFalsifyEvent == null) {
                                                MotionEvent motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f6, this.mTouchY, 0);
                                                this.mFalsifyEvent = motionEventObtain;
                                                super.dispatchTouchEvent(motionEventObtain);
                                            }
                                            MotionEvent motionEventObtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f6, this.mTouchY + i7, 0);
                                            super.dispatchTouchEvent(motionEventObtain2);
                                            if (this.mFooterLocked && f7 > this.mTouchSlop && this.mSpinner < 0) {
                                                this.mFooterLocked = false;
                                            }
                                            if (i7 > 0 && ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.i())) {
                                                this.mLastTouchY = f4;
                                                this.mTouchY = f4;
                                                this.mTouchSpinner = 0;
                                                this.mKernel.e(RefreshState.PullDownToRefresh);
                                            } else if (i7 >= 0 || !((this.mEnableOverScrollDrag || this.mEnableLoadMore) && this.mRefreshContent.f())) {
                                                i2 = i7;
                                            } else {
                                                this.mLastTouchY = f4;
                                                this.mTouchY = f4;
                                                this.mTouchSpinner = 0;
                                                this.mKernel.e(RefreshState.PullUpToLoad);
                                            }
                                            RefreshState refreshState6 = this.mViceState;
                                            if ((refreshState6.isHeader && i2 < 0) || (refreshState6.isFooter && i2 > 0)) {
                                                if (this.mSpinner != 0) {
                                                    moveSpinnerInfinitely(0.0f);
                                                }
                                                return true;
                                            }
                                            if (this.mFalsifyEvent != null) {
                                                this.mFalsifyEvent = null;
                                                motionEventObtain2.setAction(3);
                                                super.dispatchTouchEvent(motionEventObtain2);
                                            }
                                            motionEventObtain2.recycle();
                                            i7 = i2;
                                        }
                                        moveSpinnerInfinitely(i7);
                                        return true;
                                    }
                                    if (this.mFooterLocked && f7 > this.mTouchSlop && this.mSpinner < 0) {
                                        this.mFooterLocked = false;
                                    }
                                } else if (actionMasked == 3) {
                                }
                                return super.dispatchTouchEvent(motionEvent);
                            }
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                            startFlingIfNeed(0.0f);
                            this.mVelocityTracker.clear();
                            this.mDragDirection = 'n';
                            MotionEvent motionEvent2 = this.mFalsifyEvent;
                            if (motionEvent2 != null) {
                                motionEvent2.recycle();
                                this.mFalsifyEvent = null;
                                long eventTime2 = motionEvent.getEventTime();
                                MotionEvent motionEventObtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f4, 0);
                                super.dispatchTouchEvent(motionEventObtain3);
                                motionEventObtain3.recycle();
                            }
                            overSpinner();
                            if (this.mIsBeingDragged) {
                                this.mIsBeingDragged = false;
                                return true;
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    return false;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        ru4 ru4Var = this.mRefreshContent;
        View view2 = ru4Var != null ? ru4Var.getView() : null;
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var != null && vu4Var.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i2 = this.mHeaderBackgroundColor;
                if (i2 != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i2);
                    if (this.mRefreshHeader.getSpinnerStyle().c) {
                        iMax = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == fh5.d) {
                        iMax = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), iMax, this.mPaint);
                }
                if ((this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == fh5.f) || this.mRefreshHeader.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        vu4 vu4Var2 = this.mRefreshFooter;
        if (vu4Var2 != null && vu4Var2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i3 = this.mFooterBackgroundColor;
                if (i3 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i3);
                    if (this.mRefreshFooter.getSpinnerStyle().c) {
                        iMin = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == fh5.d) {
                        iMin = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, iMin, getWidth(), view.getBottom(), this.mPaint);
                }
                if ((this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == fh5.f) || this.mRefreshFooter.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // defpackage.xu4
    public xu4 finishLoadMore() {
        return finishLoadMore(true);
    }

    @Override // defpackage.xu4
    public xu4 finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    @Override // defpackage.xu4
    public xu4 finishRefresh() {
        return finishRefresh(true);
    }

    public xu4 finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    @Nullable
    public tu4 getRefreshFooter() {
        vu4 vu4Var = this.mRefreshFooter;
        if (vu4Var instanceof tu4) {
            return (tu4) vu4Var;
        }
        return null;
    }

    @Nullable
    public uu4 getRefreshHeader() {
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var instanceof uu4) {
            return (uu4) vu4Var;
        }
        return null;
    }

    @Override // defpackage.xu4
    @NonNull
    public RefreshState getState() {
        return this.mState;
    }

    public boolean interceptAnimatorByAction(int i2) {
        if (i2 == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.e(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.e(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.setDuration(0L);
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        return this.reboundAnimator != null;
    }

    public boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    public boolean isEnableTranslationContent(boolean z, vu4 vu4Var) {
        return z || this.mEnablePureScrollMode || vu4Var == null || vu4Var.getSpinnerStyle() == fh5.f;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    public void moveSpinnerInfinitely(float f2) {
        RefreshState refreshState;
        float f3 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f2 >= 0.0f || this.mRefreshContent.f()) ? f2 : 0.0f;
        if (f3 > this.mScreenHeightPixels * 5 && getTag() == null) {
            float f4 = this.mLastTouchY;
            int i2 = this.mScreenHeightPixels;
            if (f4 < i2 / 6.0f && this.mLastTouchX < i2 / 16.0f) {
                Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                setTag("你这么死拉，臣妾做不到啊！");
            }
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f3 > 0.0f) {
            this.mKernel.i(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f3 >= 0.0f) {
            int i3 = this.mHeaderHeight;
            if (f3 < i3) {
                this.mKernel.i((int) f3, true);
            } else {
                double d2 = (this.mHeaderMaxDragRate - 1.0f) * i3;
                int iMax = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mHeaderHeight;
                double d3 = iMax - i4;
                double dMax = Math.max(0.0f, (f3 - i4) * this.mDragRate);
                double d4 = -dMax;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.mKernel.i(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), dMax)) + this.mHeaderHeight, true);
            }
        } else if (f3 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i5 = this.mFooterHeight;
            if (f3 > (-i5)) {
                this.mKernel.i((int) f3, true);
            } else {
                double d5 = (this.mFooterMaxDragRate - 1.0f) * i5;
                int iMax2 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i6 = this.mFooterHeight;
                double d6 = iMax2 - i6;
                double d7 = -Math.min(0.0f, (i6 + f3) * this.mDragRate);
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.mKernel.i(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.mFooterHeight, true);
            }
        } else if (f3 >= 0.0f) {
            double d9 = this.mHeaderMaxDragRate * this.mHeaderHeight;
            double dMax2 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.mDragRate * f3);
            double d10 = -dMax3;
            if (dMax2 == 0.0d) {
                dMax2 = 1.0d;
            }
            this.mKernel.i((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / dMax2)), dMax3), true);
        } else {
            double d11 = this.mFooterMaxDragRate * this.mFooterHeight;
            double dMax4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d12 = -Math.min(0.0f, this.mDragRate * f3);
            double d13 = -d12;
            if (dMax4 == 0.0d) {
                dMax4 = 1.0d;
            }
            this.mKernel.i((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / dMax4)), d12)), true);
        }
        if (!this.mEnableAutoLoadMore || this.mFooterNoMoreData || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || f3 >= 0.0f || (refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.mDisableContentWhenLoading) {
            this.animationRunnable = null;
            this.mKernel.a(-this.mFooterHeight);
        }
        setStateDirectLoading(false);
        this.mHandler.postDelayed(new f(), this.mReboundDuration);
    }

    public void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == refreshState) {
            if (this.mViceState != refreshState2) {
                this.mViceState = refreshState2;
                return;
            }
            return;
        }
        this.mState = refreshState;
        this.mViceState = refreshState;
        vu4 vu4Var = this.mRefreshHeader;
        vu4 vu4Var2 = this.mRefreshFooter;
        if (vu4Var != null) {
            vu4Var.onStateChanged(this, refreshState2, refreshState);
        }
        if (vu4Var2 != null) {
            vu4Var2.onStateChanged(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.mFooterLocked = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        vu4 vu4Var;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null) {
                setRefreshHeader(new BezierRadarHeader(getContext()));
            }
            if (this.mRefreshFooter == null) {
                boolean z2 = this.mEnableLoadMore;
                setRefreshFooter(new BallPulseFooter(getContext()));
                this.mEnableLoadMore = z2;
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    vu4 vu4Var2 = this.mRefreshHeader;
                    if ((vu4Var2 == null || childAt != vu4Var2.getView()) && ((vu4Var = this.mRefreshFooter) == null || childAt != vu4Var.getView())) {
                        this.mRefreshContent = new su4(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int iD = nf5.d(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                su4 su4Var = new su4(textView);
                this.mRefreshContent = su4Var;
                su4Var.getView().setPadding(iD, iD, iD, iD);
            }
            View viewFindViewById = findViewById(this.mFixedHeaderViewId);
            View viewFindViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.b(this.mScrollBoundaryDecider);
            this.mRefreshContent.c(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.g(this.mKernel, viewFindViewById, viewFindViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                ru4 ru4Var = this.mRefreshContent;
                this.mSpinner = 0;
                ru4Var.e(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            vu4 vu4Var3 = this.mRefreshHeader;
            if (vu4Var3 != null) {
                vu4Var3.setPrimaryColors(iArr);
            }
            vu4 vu4Var4 = this.mRefreshFooter;
            if (vu4Var4 != null) {
                vu4Var4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        ru4 ru4Var2 = this.mRefreshContent;
        if (ru4Var2 != null) {
            super.bringChildToFront(ru4Var2.getView());
        }
        vu4 vu4Var5 = this.mRefreshHeader;
        if (vu4Var5 != null && vu4Var5.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        vu4 vu4Var6 = this.mRefreshFooter;
        if (vu4Var6 == null || !vu4Var6.getSpinnerStyle().b) {
            return;
        }
        super.bringChildToFront(this.mRefreshFooter.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mKernel.i(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mFooterLocked = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i4 = 0;
        int i5 = -1;
        char c2 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i4);
            if (nf5.f(childAt) && (c2 < 2 || i4 == 1)) {
                i5 = i4;
                c2 = 2;
            } else if (!(childAt instanceof vu4) && c2 < 1) {
                c2 = i4 > 0 ? (char) 1 : (char) 0;
                i5 = i4;
            }
            i4++;
        }
        if (i5 >= 0) {
            this.mRefreshContent = new su4(super.getChildAt(i5));
            if (i5 != 1) {
                if (childCount == 2) {
                    i3 = -1;
                    i2 = 1;
                }
                i3 = -1;
                i2 = -1;
            } else if (childCount == 3) {
                i3 = 0;
            } else {
                i3 = 0;
                i2 = -1;
            }
        } else {
            i3 = -1;
            i2 = -1;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = super.getChildAt(i6);
            if (i6 == i3 || (i6 != i2 && i3 == -1 && this.mRefreshHeader == null && (childAt2 instanceof uu4))) {
                this.mRefreshHeader = childAt2 instanceof uu4 ? (uu4) childAt2 : new RefreshHeaderWrapper(childAt2);
            } else if (i6 == i2 || (i2 == -1 && (childAt2 instanceof tu4))) {
                this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
                this.mRefreshFooter = childAt2 instanceof tu4 ? (tu4) childAt2 : new RefreshFooterWrapper(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                ru4 ru4Var = this.mRefreshContent;
                if (ru4Var != null && ru4Var.getView() == childAt) {
                    boolean z2 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z2 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i9 = this.mHeaderHeight;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                vu4 vu4Var = this.mRefreshHeader;
                if (vu4Var != null && vu4Var.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z3 && this.mRefreshHeader.getSpinnerStyle() == fh5.d) {
                        int i12 = this.mHeaderHeight;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                vu4 vu4Var2 = this.mRefreshFooter;
                if (vu4Var2 != null && vu4Var2.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableLoadMore);
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    fh5 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == fh5.d && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == fh5.h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (z4 || spinnerStyle == fh5.g || spinnerStyle == fh5.f) {
                            iMax = this.mFooterHeight;
                        } else if (spinnerStyle.c && this.mSpinner < 0) {
                            iMax = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ec  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int iMax;
        int i4;
        hd1 hd1Var;
        int i5;
        int i6;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int measuredHeight = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                vu4 vu4Var = this.mRefreshHeader;
                if (vu4Var != null && vu4Var.getView() == childAt) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int iMax2 = this.mHeaderHeight;
                    hd1 hd1Var2 = this.mHeaderHeightStatus;
                    if (hd1Var2.f17932a < hd1.i.f17932a) {
                        int i8 = layoutParams.height;
                        if (i8 > 0) {
                            int i9 = i8 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            hd1 hd1Var3 = hd1.g;
                            if (hd1Var2.a(hd1Var3)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.mHeaderHeightStatus = hd1Var3;
                            }
                            iMax2 = i9;
                        } else if (i8 == -2 && (this.mRefreshHeader.getSpinnerStyle() != fh5.h || !this.mHeaderHeightStatus.b)) {
                            int iMax3 = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax3, Integer.MIN_VALUE));
                            int measuredHeight2 = view.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != iMax3) {
                                    hd1 hd1Var4 = this.mHeaderHeightStatus;
                                    hd1 hd1Var5 = hd1.e;
                                    if (hd1Var4.a(hd1Var5)) {
                                        this.mHeaderHeight = measuredHeight2 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.mHeaderHeightStatus = hd1Var5;
                                    }
                                }
                                iMax2 = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == fh5.h) {
                        iMax2 = View.MeasureSpec.getSize(i3);
                        i6 = -1;
                        i5 = 0;
                    } else {
                        if (!this.mRefreshHeader.getSpinnerStyle().c || z) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            iMax2 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableRefresh) ? this.mSpinner : 0);
                        }
                        i6 = -1;
                    }
                    if (iMax2 != i6) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((iMax2 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i5), 1073741824));
                    }
                    hd1 hd1Var6 = this.mHeaderHeightStatus;
                    if (!hd1Var6.b) {
                        this.mHeaderHeightStatus = hd1Var6.b();
                        vu4 vu4Var2 = this.mRefreshHeader;
                        wu4 wu4Var = this.mKernel;
                        int i10 = this.mHeaderHeight;
                        vu4Var2.onInitialized(wu4Var, i10, (int) (this.mHeaderMaxDragRate * i10));
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        measuredHeight += view.getMeasuredHeight();
                    }
                }
                vu4 vu4Var3 = this.mRefreshFooter;
                if (vu4Var3 != null && vu4Var3.getView() == childAt) {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i11 = this.mFooterHeight;
                    hd1 hd1Var7 = this.mFooterHeightStatus;
                    if (hd1Var7.f17932a >= hd1.i.f17932a) {
                        iMax = i11;
                        if (this.mRefreshFooter.getSpinnerStyle() == fh5.h) {
                            iMax = View.MeasureSpec.getSize(i3);
                        } else {
                            if (this.mRefreshFooter.getSpinnerStyle().c && !z) {
                                i4 = 0;
                                iMax = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0);
                            }
                            if (iMax != -1) {
                                view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i4), 1073741824));
                            }
                            hd1Var = this.mFooterHeightStatus;
                            if (!hd1Var.b) {
                                this.mFooterHeightStatus = hd1Var.b();
                                vu4 vu4Var4 = this.mRefreshFooter;
                                wu4 wu4Var2 = this.mKernel;
                                int i12 = this.mFooterHeight;
                                vu4Var4.onInitialized(wu4Var2, i12, (int) (this.mFooterMaxDragRate * i12));
                            }
                            if (z && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                measuredHeight += view2.getMeasuredHeight();
                            }
                        }
                        i4 = 0;
                        if (iMax != -1) {
                        }
                        hd1Var = this.mFooterHeightStatus;
                        if (!hd1Var.b) {
                        }
                        if (z) {
                            measuredHeight += view2.getMeasuredHeight();
                        }
                    } else {
                        int i13 = layoutParams2.height;
                        if (i13 > 0) {
                            i11 = marginLayoutParams2.bottomMargin + i13 + marginLayoutParams2.topMargin;
                            hd1 hd1Var8 = hd1.g;
                            if (hd1Var7.a(hd1Var8)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = hd1Var8;
                            }
                        } else if (i13 == -2 && (this.mRefreshFooter.getSpinnerStyle() != fh5.h || !this.mFooterHeightStatus.b)) {
                            int iMax4 = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                            int measuredHeight3 = view2.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax4) {
                                    hd1 hd1Var9 = this.mFooterHeightStatus;
                                    hd1 hd1Var10 = hd1.e;
                                    if (hd1Var9.a(hd1Var10)) {
                                        this.mFooterHeight = measuredHeight3 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.mFooterHeightStatus = hd1Var10;
                                    }
                                }
                                iMax = -1;
                            }
                            if (this.mRefreshFooter.getSpinnerStyle() == fh5.h) {
                            }
                            i4 = 0;
                            if (iMax != -1) {
                            }
                            hd1Var = this.mFooterHeightStatus;
                            if (!hd1Var.b) {
                            }
                            if (z) {
                            }
                        }
                        iMax = i11;
                        if (this.mRefreshFooter.getSpinnerStyle() == fh5.h) {
                        }
                        i4 = 0;
                        if (iMax != -1) {
                        }
                        hd1Var = this.mFooterHeightStatus;
                        if (!hd1Var.b) {
                        }
                        if (z) {
                        }
                    }
                }
                ru4 ru4Var = this.mRefreshContent;
                if (ru4Var != null && ru4Var.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    view3.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((z && (this.mRefreshHeader != null && isEnableRefreshOrLoadMore(this.mEnableRefresh) && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader))) ? this.mHeaderHeight : 0) + ((z && (this.mRefreshFooter != null && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter))) ? this.mFooterHeight : 0), layoutParams3.height));
                    measuredHeight += view3.getMeasuredHeight();
                }
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), View.resolveSize(measuredHeight, i3));
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.mFooterLocked && f3 > 0.0f) || startFlingIfNeed(-f3) || this.mNestedChild.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        int i4 = this.mTotalUnconsumed;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.mTotalUnconsumed)) {
                int i6 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i5 = i6;
            } else {
                this.mTotalUnconsumed -= i3;
                i5 = i3;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i3 > 0 && this.mFooterLocked) {
            int i7 = i4 - i3;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
            i5 = i3;
        }
        this.mNestedChild.dispatchNestedPreScroll(i2, i3 - i5, iArr, null);
        iArr[1] = iArr[1] + i5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        x35 x35Var;
        x35 x35Var2;
        boolean zDispatchNestedScroll = this.mNestedChild.dispatchNestedScroll(i2, i3, i4, i5, this.mParentOffsetInWindow);
        int i6 = i5 + this.mParentOffsetInWindow[1];
        if ((i6 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (x35Var2 = this.mScrollBoundaryDecider) == null || x35Var2.b(this.mRefreshContent.getView())))) || (i6 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (x35Var = this.mScrollBoundaryDecider) == null || x35Var.a(this.mRefreshContent.getView()))))) {
            RefreshState refreshState = this.mViceState;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.mKernel.e(i6 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!zDispatchNestedScroll) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i7 = this.mTotalUnconsumed - i6;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
        }
        if (!this.mFooterLocked || i3 >= 0) {
            return;
        }
        this.mFooterLocked = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i2);
        this.mNestedChild.startNestedScroll(i2 & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    public void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity <= -1000 || this.mSpinner <= getMeasuredHeight() / 2) {
                if (this.mIsBeingDragged) {
                    this.mKernel.f();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorA = this.mKernel.a(getMeasuredHeight());
                if (valueAnimatorA != null) {
                    valueAnimatorA.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState == refreshState2 || (this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mSpinner < 0 && isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            int i2 = this.mSpinner;
            int i3 = this.mFooterHeight;
            if (i2 < (-i3)) {
                this.mKernel.a(-i3);
                return;
            } else {
                if (i2 > 0) {
                    this.mKernel.a(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState3 = this.mState;
        RefreshState refreshState4 = RefreshState.Refreshing;
        if (refreshState3 == refreshState4) {
            int i4 = this.mSpinner;
            int i5 = this.mHeaderHeight;
            if (i4 > i5) {
                this.mKernel.a(i5);
                return;
            } else {
                if (i4 < 0) {
                    this.mKernel.a(0);
                    return;
                }
                return;
            }
        }
        if (refreshState3 == RefreshState.PullDownToRefresh) {
            this.mKernel.e(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState3 == RefreshState.PullUpToLoad) {
            this.mKernel.e(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToRefresh) {
            this.mKernel.e(refreshState4);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToLoad) {
            this.mKernel.e(refreshState2);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
            this.mKernel.e(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState3 == RefreshState.RefreshReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.a(this.mHeaderHeight);
            }
        } else if (refreshState3 == RefreshState.LoadReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.a(-this.mFooterHeight);
            }
        } else if (this.mSpinner != 0) {
            this.mKernel.a(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (ViewCompat.isNestedScrollingEnabled(this.mRefreshContent.h())) {
            this.mEnableDisallowIntercept = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public xu4 resetNoMoreData() {
        return setNoMoreData(false);
    }

    public xu4 setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    public xu4 setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    public xu4 setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    @Override // defpackage.xu4
    public xu4 setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    public xu4 setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    public xu4 setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Deprecated
    public xu4 setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    public xu4 setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    public xu4 setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    public xu4 setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // defpackage.xu4
    public xu4 setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    public xu4 setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        ru4 ru4Var = this.mRefreshContent;
        if (ru4Var != null) {
            ru4Var.c(z);
        }
        return this;
    }

    @Override // defpackage.xu4
    public xu4 setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public xu4 setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    public xu4 setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    public xu4 setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    public xu4 setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    public xu4 setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    public xu4 setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    public xu4 setFooterHeight(float f2) {
        int iD = nf5.d(f2);
        if (iD == this.mFooterHeight) {
            return this;
        }
        hd1 hd1Var = this.mFooterHeightStatus;
        hd1 hd1Var2 = hd1.l;
        if (hd1Var.a(hd1Var2)) {
            this.mFooterHeight = iD;
            vu4 vu4Var = this.mRefreshFooter;
            if (vu4Var != null && this.mAttachedToWindow && this.mFooterHeightStatus.b) {
                fh5 spinnerStyle = vu4Var.getSpinnerStyle();
                if (spinnerStyle != fh5.h && !spinnerStyle.c) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i2 = marginLayoutParams.leftMargin;
                    int measuredHeight = ((marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart) - (spinnerStyle != fh5.d ? this.mFooterHeight : 0);
                    view.layout(i2, measuredHeight, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + measuredHeight);
                }
                this.mFooterHeightStatus = hd1Var2;
                vu4 vu4Var2 = this.mRefreshFooter;
                wu4 wu4Var = this.mKernel;
                int i3 = this.mFooterHeight;
                vu4Var2.onInitialized(wu4Var, i3, (int) (this.mFooterMaxDragRate * i3));
            } else {
                this.mFooterHeightStatus = hd1.k;
            }
        }
        return this;
    }

    public xu4 setFooterInsetStart(float f2) {
        this.mFooterInsetStart = nf5.d(f2);
        return this;
    }

    public xu4 setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        vu4 vu4Var = this.mRefreshFooter;
        if (vu4Var == null || !this.mAttachedToWindow) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        } else {
            wu4 wu4Var = this.mKernel;
            int i2 = this.mFooterHeight;
            vu4Var.onInitialized(wu4Var, i2, (int) (i2 * f2));
        }
        return this;
    }

    public xu4 setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    public xu4 setHeaderHeight(float f2) {
        int iD = nf5.d(f2);
        if (iD == this.mHeaderHeight) {
            return this;
        }
        hd1 hd1Var = this.mHeaderHeightStatus;
        hd1 hd1Var2 = hd1.l;
        if (hd1Var.a(hd1Var2)) {
            this.mHeaderHeight = iD;
            vu4 vu4Var = this.mRefreshHeader;
            if (vu4Var != null && this.mAttachedToWindow && this.mHeaderHeightStatus.b) {
                fh5 spinnerStyle = vu4Var.getSpinnerStyle();
                if (spinnerStyle != fh5.h && !spinnerStyle.c) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i2 = marginLayoutParams.leftMargin;
                    int i3 = (marginLayoutParams.topMargin + this.mHeaderInsetStart) - (spinnerStyle == fh5.d ? this.mHeaderHeight : 0);
                    view.layout(i2, i3, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + i3);
                }
                this.mHeaderHeightStatus = hd1Var2;
                vu4 vu4Var2 = this.mRefreshHeader;
                wu4 wu4Var = this.mKernel;
                int i4 = this.mHeaderHeight;
                vu4Var2.onInitialized(wu4Var, i4, (int) (this.mHeaderMaxDragRate * i4));
            } else {
                this.mHeaderHeightStatus = hd1.k;
            }
        }
        return this;
    }

    public xu4 setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = nf5.d(f2);
        return this;
    }

    @Override // defpackage.xu4
    public xu4 setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var == null || !this.mAttachedToWindow) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        } else {
            wu4 wu4Var = this.mKernel;
            int i2 = this.mHeaderHeight;
            vu4Var.onInitialized(wu4Var, i2, (int) (f2 * i2));
        }
        return this;
    }

    public xu4 setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    public xu4 setNoMoreData(boolean z) {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing && z) {
            finishRefreshWithNoMoreData();
        } else if (refreshState == RefreshState.Loading && z) {
            finishLoadMoreWithNoMoreData();
        } else if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            vu4 vu4Var = this.mRefreshFooter;
            if (vu4Var instanceof tu4) {
                if (((tu4) vu4Var).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == fh5.d && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public xu4 setOnLoadMoreListener(c74 c74Var) {
        this.mLoadMoreListener = c74Var;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || c74Var == null);
        return this;
    }

    public xu4 setOnRefreshListener(j74 j74Var) {
        this.mRefreshListener = j74Var;
        return this;
    }

    public xu4 setOnRefreshLoadMoreListener(k74 k74Var) {
        this.mRefreshListener = k74Var;
        this.mLoadMoreListener = k74Var;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || k74Var == null);
        return this;
    }

    public xu4 setPrimaryColors(@ColorInt int... iArr) {
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var != null) {
            vu4Var.setPrimaryColors(iArr);
        }
        vu4 vu4Var2 = this.mRefreshFooter;
        if (vu4Var2 != null) {
            vu4Var2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    public xu4 setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.getColor(getContext(), iArr[i2]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    public xu4 setReboundDuration(int i2) {
        this.mReboundDuration = i2;
        return this;
    }

    public xu4 setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    public xu4 setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, 0, 0);
    }

    public xu4 setRefreshFooter(@NonNull tu4 tu4Var) {
        return setRefreshFooter(tu4Var, 0, 0);
    }

    public xu4 setRefreshHeader(@NonNull uu4 uu4Var) {
        return setRefreshHeader(uu4Var, 0, 0);
    }

    public xu4 setScrollBoundaryDecider(x35 x35Var) {
        this.mScrollBoundaryDecider = x35Var;
        ru4 ru4Var = this.mRefreshContent;
        if (ru4Var != null) {
            ru4Var.b(x35Var);
        }
        return this;
    }

    public void setStateDirectLoading(boolean z) {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            c74 c74Var = this.mLoadMoreListener;
            if (c74Var == null) {
                finishLoadMore(2000);
            } else if (z) {
                c74Var.onLoadMore(this);
            }
            vu4 vu4Var = this.mRefreshFooter;
            if (vu4Var != null) {
                int i2 = this.mFooterHeight;
                vu4Var.onStartAnimator(this, i2, (int) (this.mFooterMaxDragRate * i2));
            }
        }
    }

    public void setStateLoading(boolean z) {
        b bVar = new b(z);
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator valueAnimatorA = this.mKernel.a(-this.mFooterHeight);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(bVar);
        }
        vu4 vu4Var = this.mRefreshFooter;
        if (vu4Var != null) {
            int i2 = this.mFooterHeight;
            vu4Var.onReleased(this, i2, (int) (this.mFooterMaxDragRate * i2));
        }
        if (valueAnimatorA == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z) {
        c cVar = new c(z);
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator valueAnimatorA = this.mKernel.a(this.mHeaderHeight);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(cVar);
        }
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var != null) {
            int i2 = this.mHeaderHeight;
            vu4Var.onReleased(this, i2, (int) (this.mHeaderMaxDragRate * i2));
        }
        if (valueAnimatorA == null) {
            cVar.onAnimationEnd(null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    public boolean startFlingIfNeed(float f2) {
        if (f2 == 0.0f) {
            f2 = this.mCurrentVelocity;
        }
        if (Build.VERSION.SDK_INT > 27 && this.mRefreshContent != null) {
            getScaleY();
            View view = this.mRefreshContent.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f2 = -f2;
            }
        }
        if (Math.abs(f2) > this.mMinimumVelocity) {
            int i2 = this.mSpinner;
            if (i2 * f2 < 0.0f) {
                RefreshState refreshState = this.mState;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i2 < 0 && this.mFooterNoMoreData)) {
                    this.animationRunnable = new l(f2).a();
                    return true;
                }
                if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && i2 >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, C.RATE_UNSET_INT, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        hd1 hd1Var = hd1.c;
        this.mHeaderHeightStatus = hd1Var;
        this.mFooterHeightStatus = hd1Var;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mKernel = new m();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler();
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new nf5(nf5.b);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = nf5.d(60.0f);
        this.mHeaderHeight = nf5.d(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        this.mDragRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i2 = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = typedArrayObtainStyledAttributes.getBoolean(i2, this.mEnableLoadMore);
        int i3 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i3, this.mHeaderHeight);
        int i4 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i4, this.mFooterHeight);
        this.mHeaderInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i5 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = typedArrayObtainStyledAttributes.getBoolean(i5, this.mEnableHeaderTranslationContent);
        int i6 = R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = typedArrayObtainStyledAttributes.getBoolean(i6, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z;
        this.mEnableFooterFollowWhenNoMoreData = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.mEnableClipHeaderWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z2;
        this.mNestedChild.setNestedScrollingEnabled(z2);
        this.mManualLoadMore = this.mManualLoadMore || typedArrayObtainStyledAttributes.hasValue(i2);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || typedArrayObtainStyledAttributes.hasValue(i5);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || typedArrayObtainStyledAttributes.hasValue(i6);
        this.mHeaderHeightStatus = typedArrayObtainStyledAttributes.hasValue(i3) ? hd1.i : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = typedArrayObtainStyledAttributes.hasValue(i4) ? hd1.i : this.mFooterHeightStatus;
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean autoLoadMore(int i2, int i3, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        j jVar = new j(f2, i3, z);
        setViceState(RefreshState.Loading);
        if (i2 > 0) {
            this.mHandler.postDelayed(jVar, i2);
            return true;
        }
        jVar.run();
        return true;
    }

    @Deprecated
    public boolean autoRefresh(int i2) {
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, false);
    }

    public xu4 finishLoadMore(int i2) {
        return finishLoadMore(i2, true, false);
    }

    public xu4 finishRefresh(int i2) {
        return finishRefresh(i2, true, Boolean.FALSE);
    }

    public xu4 setRefreshContent(@NonNull View view, int i2, int i3) {
        ru4 ru4Var = this.mRefreshContent;
        if (ru4Var != null) {
            super.removeView(ru4Var.getView());
        }
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -1;
        }
        LayoutParams layoutParams = new LayoutParams(i2, i3);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        super.addView(view, getChildCount(), layoutParams);
        this.mRefreshContent = new su4(view);
        if (this.mAttachedToWindow) {
            View viewFindViewById = findViewById(this.mFixedHeaderViewId);
            View viewFindViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.b(this.mScrollBoundaryDecider);
            this.mRefreshContent.c(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.g(this.mKernel, viewFindViewById, viewFindViewById2);
        }
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var != null && vu4Var.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        vu4 vu4Var2 = this.mRefreshFooter;
        if (vu4Var2 != null && vu4Var2.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
        return this;
    }

    public xu4 setRefreshFooter(@NonNull tu4 tu4Var, int i2, int i3) {
        vu4 vu4Var;
        vu4 vu4Var2 = this.mRefreshFooter;
        if (vu4Var2 != null) {
            super.removeView(vu4Var2.getView());
        }
        this.mRefreshFooter = tu4Var;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter != null) {
            if (i2 == 0) {
                i2 = -1;
            }
            if (i3 == 0) {
                i3 = -2;
            }
            LayoutParams layoutParams = new LayoutParams(i2, i3);
            ViewGroup.LayoutParams layoutParams2 = tu4Var.getView().getLayoutParams();
            if (layoutParams2 instanceof LayoutParams) {
                layoutParams = (LayoutParams) layoutParams2;
            }
            if (this.mRefreshFooter.getSpinnerStyle().b) {
                super.addView(this.mRefreshFooter.getView(), getChildCount(), layoutParams);
            } else {
                super.addView(this.mRefreshFooter.getView(), 0, layoutParams);
            }
            int[] iArr = this.mPrimaryColors;
            if (iArr != null && (vu4Var = this.mRefreshFooter) != null) {
                vu4Var.setPrimaryColors(iArr);
            }
        }
        return this;
    }

    public xu4 setRefreshHeader(@NonNull uu4 uu4Var, int i2, int i3) {
        vu4 vu4Var;
        vu4 vu4Var2 = this.mRefreshHeader;
        if (vu4Var2 != null) {
            super.removeView(vu4Var2.getView());
        }
        this.mRefreshHeader = uu4Var;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (this.mRefreshHeader != null) {
            if (i2 == 0) {
                i2 = -1;
            }
            if (i3 == 0) {
                i3 = -2;
            }
            LayoutParams layoutParams = new LayoutParams(i2, i3);
            ViewGroup.LayoutParams layoutParams2 = uu4Var.getView().getLayoutParams();
            if (layoutParams2 instanceof LayoutParams) {
                layoutParams = (LayoutParams) layoutParams2;
            }
            if (this.mRefreshHeader.getSpinnerStyle().b) {
                super.addView(this.mRefreshHeader.getView(), getChildCount(), layoutParams);
            } else {
                super.addView(this.mRefreshHeader.getView(), 0, layoutParams);
            }
            int[] iArr = this.mPrimaryColors;
            if (iArr != null && (vu4Var = this.mRefreshHeader) != null) {
                vu4Var.setPrimaryColors(iArr);
            }
        }
        return this;
    }

    public boolean autoRefresh(int i2, int i3, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        i iVar = new i(f2, i3, z);
        setViceState(RefreshState.Refreshing);
        if (i2 > 0) {
            this.mHandler.postDelayed(iVar, i2);
            return true;
        }
        iVar.run();
        return true;
    }

    @Override // defpackage.xu4
    public xu4 finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    @Override // defpackage.xu4
    public xu4 finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    public xu4 finishLoadMore(int i2, boolean z, boolean z2) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        h hVar = new h(i3, z2, z);
        if (i4 > 0) {
            this.mHandler.postDelayed(hVar, i4);
        } else {
            hVar.run();
        }
        return this;
    }

    public xu4 finishRefresh(int i2, boolean z, Boolean bool) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        g gVar = new g(i3, bool, z);
        if (i4 > 0) {
            this.mHandler.postDelayed(gVar, i4);
        } else {
            gVar.run();
        }
        return this;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10550a;
        public fh5 b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10550a = 0;
            this.b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.f10550a = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f10550a);
            int i = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.b = fh5.i[typedArrayObtainStyledAttributes.getInt(i, fh5.d.f17531a)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f10550a = 0;
            this.b = null;
        }
    }

    @Override // defpackage.xu4
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    public static void setDefaultRefreshFooterCreator(@NonNull p71 p71Var) {
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull q71 q71Var) {
    }

    public static void setDefaultRefreshInitializer(@NonNull r71 r71Var) {
    }

    public xu4 setOnMultiPurposeListener(e74 e74Var) {
        return this;
    }
}

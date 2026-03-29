package com.zenmen.palmchat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ScaleScrollLayout extends ViewGroup {
    private static final int TIME_ANIMAL_PREPARE_INTERVAL = 350;
    private static final int TIME_ANIMAL_SHOWING_INTERVAL = 680;
    private static final int TIME_SCROLL_INTERVAL = 2000;
    private int mCurPosition;
    private boolean mLayoutNext;
    private View mPrepareView;
    private Runnable mScrollRunnable;
    private View mShowView;
    private Handler mUIHandler;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: com.zenmen.palmchat.widget.ScaleScrollLayout$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1144a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f15995a;
            public final /* synthetic */ View b;

            public C1144a(View view, View view2) {
                this.f15995a = view;
                this.b = view2;
            }

            public final void a() {
                this.f15995a.setTranslationX(0.0f);
                this.f15995a.setScaleX(1.0f);
                this.f15995a.setScaleY(1.0f);
                this.b.setTranslationX(0.0f);
                this.b.setScaleX(1.0f);
                this.b.setScaleY(1.0f);
                ScaleScrollLayout.this.layoutNext();
                LogUtil.i("ScaleScrollLayout", "1=============" + ScaleScrollLayout.this.mCurPosition + ", listener:" + this);
                if (ScaleScrollLayout.this.mScrollRunnable != null) {
                    ScaleScrollLayout.this.mUIHandler.removeCallbacks(ScaleScrollLayout.this.mScrollRunnable);
                    ScaleScrollLayout.this.mUIHandler.postDelayed(ScaleScrollLayout.this.mScrollRunnable, 2000L);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a();
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = ScaleScrollLayout.this.mShowView;
            View view2 = ScaleScrollLayout.this.mPrepareView;
            if (view == null || view2 == null) {
                ScaleScrollLayout.this.mUIHandler.postDelayed(this, 2000L);
                return;
            }
            view.setZ(1.0f);
            view2.setZ(0.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, ScaleScrollLayout.this.getWidth());
            objectAnimatorOfFloat.setDuration(680L);
            Path path = new Path();
            path.moveTo(1.0f, 1.0f);
            path.lineTo(0.0f, 0.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", "scaleY", path);
            objectAnimatorOfFloat2.setDuration(680L);
            objectAnimatorOfFloat.addListener(new C1144a(view2, view));
            objectAnimatorOfFloat.start();
            objectAnimatorOfFloat2.start();
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "translationX", ScaleScrollLayout.this.getWidth() / 2, ScaleScrollLayout.this.getWidth());
            objectAnimatorOfFloat3.setDuration(350L);
            Path path2 = new Path();
            path2.moveTo(0.0f, 0.0f);
            path2.lineTo(1.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "scaleX", "scaleY", path2);
            objectAnimatorOfFloat4.setDuration(350L);
            objectAnimatorOfFloat3.start();
            objectAnimatorOfFloat4.start();
        }
    }

    public ScaleScrollLayout(Context context) {
        super(context);
        this.mCurPosition = -1;
        this.mLayoutNext = false;
        this.mUIHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutNext() {
        this.mLayoutNext = true;
        requestLayout();
    }

    private void startScaleScroll() {
        if (this.mScrollRunnable == null) {
            a aVar = new a();
            this.mScrollRunnable = aVar;
            this.mUIHandler.postDelayed(aVar, 2000L);
        }
    }

    private void stopScaleScroll() {
        Runnable runnable = this.mScrollRunnable;
        if (runnable != null) {
            this.mUIHandler.removeCallbacks(runnable);
            this.mScrollRunnable = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startScaleScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScaleScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.mShowView;
        if (view != null) {
            view.layout(0, 0, view.getMeasuredWidth(), this.mShowView.getMeasuredHeight());
        }
        View view2 = this.mPrepareView;
        if (view2 != null) {
            view2.layout(-view2.getMeasuredWidth(), 0, 0, this.mPrepareView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            this.mCurPosition = -1;
            this.mShowView = null;
            this.mPrepareView = null;
        } else if (size == 1) {
            this.mCurPosition = 0;
            this.mShowView = (View) arrayList.get(0);
            this.mPrepareView = null;
        } else {
            if (this.mCurPosition < 0) {
                this.mCurPosition = 0;
            }
            if (this.mLayoutNext) {
                this.mCurPosition++;
            }
            int i4 = this.mCurPosition;
            if (i4 >= size) {
                this.mCurPosition = 0;
                this.mShowView = (View) arrayList.get(0);
                this.mPrepareView = (View) arrayList.get(1);
            } else {
                this.mShowView = (View) arrayList.get(i4);
                int i5 = this.mCurPosition;
                if (i5 + 1 >= size) {
                    this.mPrepareView = (View) arrayList.get(0);
                } else {
                    this.mPrepareView = (View) arrayList.get(i5 + 1);
                }
            }
        }
        this.mLayoutNext = false;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        View view = this.mShowView;
        if (view != null) {
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        View view2 = this.mPrepareView;
        if (view2 != null) {
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
    }

    public ScaleScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurPosition = -1;
        this.mLayoutNext = false;
        this.mUIHandler = new Handler();
    }

    public ScaleScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurPosition = -1;
        this.mLayoutNext = false;
        this.mUIHandler = new Handler();
    }
}

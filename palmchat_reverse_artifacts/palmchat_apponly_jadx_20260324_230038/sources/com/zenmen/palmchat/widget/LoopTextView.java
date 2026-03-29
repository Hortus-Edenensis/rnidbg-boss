package com.zenmen.palmchat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LoopTextView extends FrameLayout {
    private static final int SIZE = 2;
    private ValueAnimator appearAnim;
    private List<SpannableStringBuilder> data;
    private ValueAnimator disappearAnim;
    private TextView firstView;
    private d listener;
    private int mCurrentPosition;
    private c mData;
    private int mDelayTime;
    private int mDuration;
    private TextView secondView;
    private Runnable task;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoopTextView.this.shiftToNext();
            LoopTextView.this.postDelayed(this, r0.mDelayTime);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15984a;

        public b(TextView textView) {
            this.f15984a = textView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f15984a.setVisibility(4);
            LoopTextView.a(LoopTextView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        SpannableStringBuilder next(FrameworkBaseActivity frameworkBaseActivity);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    public LoopTextView(Context context) {
        this(context, null);
    }

    public static /* bridge */ /* synthetic */ d a(LoopTextView loopTextView) {
        loopTextView.getClass();
        return null;
    }

    private void bindView(TextView textView) {
        SpannableStringBuilder next;
        c cVar = this.mData;
        if (cVar == null || (next = cVar.next((FrameworkBaseActivity) getContext())) == null) {
            return;
        }
        textView.setText(next);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void reset() {
        stopAnimation();
        stopAutoPlay();
        TextView textView = this.secondView;
        if (textView != null) {
            textView.setVisibility(4);
            this.secondView.setTranslationY(0.0f);
            this.secondView.setAlpha(1.0f);
        }
        TextView textView2 = this.firstView;
        if (textView2 != null) {
            textView2.setVisibility(0);
            this.firstView.setTranslationY(0.0f);
            this.firstView.setAlpha(1.0f);
        }
        this.mCurrentPosition = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shiftToNext() {
        if (this.mData == null) {
            return;
        }
        int i = this.mCurrentPosition + 1;
        this.mCurrentPosition = i;
        if (i % 2 == 0) {
            bindView(this.firstView);
            startAnimation(this.firstView, this.secondView);
        } else {
            bindView(this.secondView);
            startAnimation(this.secondView, this.firstView);
        }
    }

    private void startAnimation(TextView textView, TextView textView2) {
        stopAnimation();
        textView.setVisibility(0);
        textView.setTranslationY((textView.getHeight() / 2) + (getHeight() / 4));
        textView.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", textView.getTranslationY(), 0.0f));
        this.appearAnim = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(this.mDuration);
        this.appearAnim.setInterpolator(new DecelerateInterpolator());
        this.appearAnim.addListener(new b(textView2));
        this.appearAnim.start();
        textView2.setVisibility(0);
        textView2.setTranslationY(0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(textView2, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("translationY", textView2.getTranslationY(), ((-textView2.getHeight()) / 2) - (getHeight() / 4)));
        this.disappearAnim = objectAnimatorOfPropertyValuesHolder2;
        objectAnimatorOfPropertyValuesHolder2.setDuration(this.mDuration);
        this.disappearAnim.setInterpolator(new DecelerateInterpolator());
        this.disappearAnim.start();
    }

    private void stopAnimation() {
        ValueAnimator valueAnimator = this.appearAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.appearAnim = null;
        }
        ValueAnimator valueAnimator2 = this.disappearAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.disappearAnim = null;
        }
    }

    public int getCurrentPosition() {
        if (this.data.size() == 0) {
            return 0;
        }
        return this.mCurrentPosition % this.data.size();
    }

    public void setData(List<SpannableStringBuilder> list) {
        reset();
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        bindView(this.firstView);
    }

    public void startAutoPlay() {
        if (this.mData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeCallbacks(this.task);
        postDelayed(this.task, this.mDelayTime);
    }

    public void stopAutoPlay() {
        removeCallbacks(this.task);
    }

    public LoopTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.mDelayTime = 3000;
        this.mDuration = 800;
        this.data = new ArrayList();
        this.task = new a();
        LayoutInflater.from(context).inflate(R$layout.view_loop_text, (ViewGroup) this, true);
        this.firstView = (TextView) findViewById(R$id.banner_first);
        this.secondView = (TextView) findViewById(R$id.banner_second);
    }

    public void setData(c cVar) {
        this.mData = cVar;
        bindView(this.firstView);
        startAutoPlay();
    }

    public void setListener(d dVar) {
    }
}

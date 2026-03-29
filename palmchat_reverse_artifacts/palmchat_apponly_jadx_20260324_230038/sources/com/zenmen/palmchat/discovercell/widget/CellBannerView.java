package com.zenmen.palmchat.discovercell.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CellBannerView extends FrameLayout {
    private static final int SIZE = 2;
    private ValueAnimator appearAnim;
    private List<String> data;
    private ValueAnimator disappearAnim;
    private TextView firstView;
    private c listener;
    private int mCurrentPosition;
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
            CellBannerView.this.shiftToNext();
            CellBannerView.this.postDelayed(this, r0.mDelayTime);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f13922a;

        public b(TextView textView) {
            this.f13922a = textView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f13922a.setVisibility(4);
            CellBannerView.a(CellBannerView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public CellBannerView(Context context) {
        this(context, null);
    }

    public static /* bridge */ /* synthetic */ c a(CellBannerView cellBannerView) {
        cellBannerView.getClass();
        return null;
    }

    private void bindView(TextView textView, int i) {
        if (i < 0 || i >= this.data.size()) {
            textView.setText("");
        } else {
            textView.setText(Html.fromHtml(this.data.get(i)));
        }
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
        if (this.data.size() == 0) {
            return;
        }
        int i = this.mCurrentPosition + 1;
        this.mCurrentPosition = i;
        if (i % 2 == 0) {
            bindView(this.firstView, i % this.data.size());
            startAnimation(this.firstView, this.secondView);
        } else {
            bindView(this.secondView, i % this.data.size());
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

    public void setData(List<String> list) {
        reset();
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        bindView(this.firstView, this.mCurrentPosition);
    }

    public void startAutoPlay() {
        if (this.data.size() < 2) {
            return;
        }
        removeCallbacks(this.task);
        postDelayed(this.task, this.mDelayTime);
    }

    public void stopAutoPlay() {
        removeCallbacks(this.task);
    }

    public CellBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CellBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.mDelayTime = 3000;
        this.mDuration = 800;
        this.data = new ArrayList();
        this.task = new a();
        LayoutInflater.from(context).inflate(R.layout.layout_people_match_entry_banner, (ViewGroup) this, true);
        this.firstView = (TextView) findViewById(R.id.banner_first);
        this.secondView = (TextView) findViewById(R.id.banner_second);
    }

    public void setListener(c cVar) {
    }
}

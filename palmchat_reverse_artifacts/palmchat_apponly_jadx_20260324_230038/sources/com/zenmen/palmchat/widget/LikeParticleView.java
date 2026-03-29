package com.zenmen.palmchat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zenmen.palmchat.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LikeParticleView extends RelativeLayout {
    private RelativeLayout.LayoutParams mLayoutParams;
    private List<Integer> mLikeDrawables;
    private b mPathAnimator;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15979a = 20;
        public Random b = new Random();

        /* JADX INFO: renamed from: com.zenmen.palmchat.widget.LikeParticleView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1142a implements TypeEvaluator<PointF> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public PointF f15980a;
            public PointF b;

            @Override // android.animation.TypeEvaluator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF evaluate(float f, PointF pointF, PointF pointF2) {
                float f2 = 1.0f - f;
                PointF pointF3 = new PointF();
                double d = f2;
                float f3 = f2 * 3.0f;
                double d2 = f;
                pointF3.x = (((float) Math.pow(d, 3.0d)) * pointF.x) + (((float) Math.pow(d, 2.0d)) * 3.0f * f * this.f15980a.x) + (((float) Math.pow(d2, 2.0d)) * f3 * this.b.x) + (((float) Math.pow(d2, 3.0d)) * pointF2.x);
                pointF3.y = (((float) Math.pow(d, 3.0d)) * pointF.y) + (((float) Math.pow(d, 2.0d)) * 3.0f * f * this.f15980a.y) + (f3 * f * f * this.b.y) + (((float) Math.pow(d2, 3.0d)) * pointF2.y);
                return pointF3;
            }

            public C1142a(PointF pointF, PointF pointF2) {
                this.f15980a = pointF;
                this.b = pointF2;
            }
        }

        public C1142a a(PointF pointF, PointF pointF2) {
            return new C1142a(pointF, pointF2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends a {
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public SparseArray<a.C1142a> j = new SparseArray<>();

        /* JADX INFO: compiled from: SearchBox */
        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public View f15981a;
            public ViewGroup b;

            public a(View view, ViewGroup viewGroup) {
                this.f15981a = view;
                this.b = viewGroup;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.b.removeView(this.f15981a);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.widget.LikeParticleView$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1143b implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public View f15982a;

            public C1143b(View view) {
                this.f15982a = view;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                this.f15982a.setX(pointF.x);
                this.f15982a.setY(pointF.y);
                this.f15982a.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
            }
        }

        public b(int i, int i2) {
            this.c = i;
            this.d = i2;
        }

        public final ValueAnimator b(a.C1142a c1142a, View view) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(c1142a, new PointF((this.g - this.e) / 2.0f, this.h - this.f), new PointF(((this.g - this.e) / 2.0f) + ((this.b.nextBoolean() ? 1 : -1) * this.b.nextInt((int) ((this.g - this.e) / 2.0f))), 0.0f));
            valueAnimatorOfObject.addUpdateListener(new C1143b(view));
            valueAnimatorOfObject.setInterpolator(new LinearInterpolator());
            valueAnimatorOfObject.setDuration(this.d);
            return valueAnimatorOfObject;
        }

        public final AnimatorSet c(View view) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 0.2f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.2f, 1.0f);
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
            animatorSet.setDuration(this.c);
            return animatorSet;
        }

        public final PointF d(int i) {
            float fNextInt;
            PointF pointF = new PointF();
            if (this.b.nextBoolean()) {
                fNextInt = this.b.nextInt((int) (this.g / 4.0f));
            } else {
                fNextInt = this.b.nextInt((int) (r1 / 4.0f)) + (((this.g * 3.0f) / 4.0f) - this.e);
            }
            pointF.x = fNextInt;
            pointF.y = this.b.nextInt(this.h - this.f) / i;
            return pointF;
        }

        public void e(int i, int i2) {
            this.e = i;
            this.f = i2;
        }

        public void f(int i, int i2) {
            if (i <= this.e || i2 <= this.f) {
                return;
            }
            this.g = i;
            this.h = i2;
        }

        public void g(View view, ViewGroup viewGroup, RelativeLayout.LayoutParams layoutParams) {
            a.C1142a c1142aA;
            viewGroup.addView(view, layoutParams);
            int i = this.i + 1;
            this.i = i;
            if (i > 20) {
                c1142aA = this.j.get(Math.abs(this.b.nextInt() % 20) + 1);
            } else {
                c1142aA = a(d(1), d(2));
                this.j.put(this.i, c1142aA);
            }
            AnimatorSet animatorSetC = c(view);
            ValueAnimator valueAnimatorB = b(c1142aA, view);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorSetC, valueAnimatorB);
            animatorSet.addListener(new a(view, viewGroup));
            animatorSet.start();
        }
    }

    public LikeParticleView(Context context) {
        this(context, null);
    }

    private void init(int i, int i2, int i3) {
        this.mLikeDrawables = new ArrayList();
        if (i == -1) {
            i = R.drawable.like_particle_1;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i));
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(intrinsicWidth, intrinsicHeight);
        this.mLayoutParams = layoutParams;
        layoutParams.addRule(14);
        this.mLayoutParams.addRule(12);
        b bVar = new b(i2, i3);
        this.mPathAnimator = bVar;
        bVar.e(intrinsicWidth, intrinsicHeight);
        this.mPathAnimator.f(intrinsicWidth * 2, intrinsicHeight * 2);
    }

    public void addFavor() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(this.mLikeDrawables.get(Math.abs(this.mPathAnimator.b.nextInt(this.mLikeDrawables.size()))).intValue());
        this.mPathAnimator.g(imageView, this, this.mLayoutParams);
    }

    public void addLikeImage(int i) {
        this.mLikeDrawables.add(Integer.valueOf(i));
    }

    public void addLikeImages(Integer[] numArr) {
        this.mLikeDrawables.addAll(Arrays.asList(numArr));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mPathAnimator.f(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mPathAnimator.f(getWidth(), getHeight());
    }

    public LikeParticleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addLikeImages(List<Integer> list) {
        this.mLikeDrawables.addAll(list);
    }

    public LikeParticleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(R.drawable.like_particle_1, TTAdConstant.STYLE_SIZE_RADIO_3_2, 4500);
    }
}

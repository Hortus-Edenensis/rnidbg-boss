package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.zenmen.square.mvp.model.bean.Media;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class up0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21257a;
    public float c;
    public int d;
    public int e;
    public float b = 0.35f;
    public long f = 300;
    public long g = 150;
    public float h = -1.0f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f21258a;

        public a(Media media) {
            this.f21258a = media;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            up0.this.e(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f21258a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f21260a;

        public c(Media media) {
            this.f21260a = media;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            up0.this.e(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f21260a);
        }
    }

    public up0(View view) {
        this.c = 0.0f;
        this.d = 360;
        this.e = 540;
        this.f21257a = view;
        this.d = me1.g();
        int iF = me1.f();
        this.e = iF;
        this.c = (this.d * 1.0f) / iF;
    }

    public void a(Media media) {
        float f = this.h;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, -1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(media));
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.setDuration((long) (this.f * (1.0f - Math.abs(f))));
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.start();
    }

    public void b(Media media) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new c(media));
        valueAnimatorOfFloat.addListener(new d());
        valueAnimatorOfFloat.setDuration(this.g);
        valueAnimatorOfFloat.setStartDelay(150L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.start();
    }

    public final float c(float f) {
        if (f <= this.c) {
            return this.b;
        }
        return Math.min(1.0f, (this.b * this.e) / (this.d / f));
    }

    public final float d(Media media) {
        float f = this.c;
        if (media == null) {
            return f;
        }
        try {
            int i = Integer.parseInt(media.width);
            int i2 = Integer.parseInt(media.height);
            return (i <= 0 || i2 <= 0) ? f : (i * 1.0f) / i2;
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public void e(float f, Media media) {
        this.h = f;
        float fD = d(media);
        float fC = c(fD);
        float fMax = (this.e - ((this.d / Math.max(fD, this.c)) * fC)) / 2.0f;
        float fAbs = 1.0f - ((1.0f - Math.abs(f)) * (1.0f - fC));
        this.f21257a.setScaleX(fAbs);
        this.f21257a.setScaleY(fAbs);
        this.f21257a.setTranslationY((-(1.0f - Math.abs(f))) * fMax);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

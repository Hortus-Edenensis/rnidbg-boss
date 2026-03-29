package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"NewApi"})
public abstract class de extends of6 implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public ObjectAnimator i;
    public float j;
    public float k;
    public float l;

    public de(nf6 nf6Var, float f, float f2, h16 h16Var, View view, float f3, float f4, long j) {
        super(nf6Var, f, f2, h16Var, view);
        this.k = f3;
        this.l = f4;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phase", 0.0f, 1.0f);
        this.i = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(j);
        this.i.addUpdateListener(this);
        this.i.addListener(this);
    }

    public abstract void b();

    public void c() {
        this.i.removeAllListeners();
        this.i.removeAllUpdateListeners();
        this.i.reverse();
        this.i.addUpdateListener(this);
        this.i.addListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        try {
            b();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            b();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.i.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}

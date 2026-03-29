package defpackage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import defpackage.uj1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class g10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f17631a;
    public float b = 1.0f;
    public float c = 1.0f;

    @RequiresApi(11)
    public g10(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f17631a = animatorUpdateListener;
    }

    @RequiresApi(11)
    public void a(int i) {
        b(i, uj1.f21227a);
    }

    @RequiresApi(11)
    public void b(int i, uj1.c0 c0Var) {
        ObjectAnimator objectAnimatorJ = j(i, c0Var);
        objectAnimatorJ.addUpdateListener(this.f17631a);
        objectAnimatorJ.start();
    }

    @RequiresApi(11)
    public void c(int i, int i2) {
        uj1.c0 c0Var = uj1.f21227a;
        e(i, i2, c0Var, c0Var);
    }

    @RequiresApi(11)
    public void d(int i, int i2, uj1.c0 c0Var) {
        ObjectAnimator objectAnimatorJ = j(i, c0Var);
        ObjectAnimator objectAnimatorK = k(i2, c0Var);
        if (i > i2) {
            objectAnimatorJ.addUpdateListener(this.f17631a);
        } else {
            objectAnimatorK.addUpdateListener(this.f17631a);
        }
        objectAnimatorJ.start();
        objectAnimatorK.start();
    }

    @RequiresApi(11)
    public void e(int i, int i2, uj1.c0 c0Var, uj1.c0 c0Var2) {
        ObjectAnimator objectAnimatorJ = j(i, c0Var);
        ObjectAnimator objectAnimatorK = k(i2, c0Var2);
        if (i > i2) {
            objectAnimatorJ.addUpdateListener(this.f17631a);
        } else {
            objectAnimatorK.addUpdateListener(this.f17631a);
        }
        objectAnimatorJ.start();
        objectAnimatorK.start();
    }

    @RequiresApi(11)
    public void f(int i) {
        g(i, uj1.f21227a);
    }

    @RequiresApi(11)
    public void g(int i, uj1.c0 c0Var) {
        ObjectAnimator objectAnimatorK = k(i, c0Var);
        objectAnimatorK.addUpdateListener(this.f17631a);
        objectAnimatorK.start();
    }

    public float h() {
        return this.c;
    }

    public float i() {
        return this.b;
    }

    @RequiresApi(11)
    public final ObjectAnimator j(int i, uj1.c0 c0Var) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }

    @RequiresApi(11)
    public final ObjectAnimator k(int i, uj1.c0 c0Var) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }
}

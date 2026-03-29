package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gi4 implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f17731a;
    public View b;
    public View c;
    public boolean d = true;
    public boolean e = false;
    public ValueAnimator f;
    public int g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            gi4.this.b.setTranslationY((int) (gi4.this.g * fFloatValue));
            gi4.this.c.setAlpha(1.0f - fFloatValue);
            if (fFloatValue == 1.0f) {
                gi4.this.c.setVisibility(8);
            } else {
                gi4.this.c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationCancel isShow" + gi4.this.d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationEnd isShow" + gi4.this.d);
            boolean unused = gi4.this.d;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationRepeat isShow" + gi4.this.d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationStart isShow" + gi4.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gi4.this.f.reverse();
        }
    }

    public gi4(ViewGroup viewGroup, View view, View view2) {
        this.f17731a = viewGroup;
        this.b = view;
        this.c = view2;
        f();
    }

    public final void f() {
        this.f17731a.setOnSystemUiVisibilityChangeListener(this);
        this.g = -me1.b(this.f17731a.getContext(), 80);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.f.setFloatValues(0.0f, 1.0f);
        this.f.setDuration(250L);
        this.f.addUpdateListener(new a());
        this.f.addListener(new b());
        i(true, false);
    }

    public void g(View view) {
        this.c = view;
    }

    public void h(int i) {
        this.g = i;
    }

    public final void i(boolean z, boolean z2) {
        this.d = z;
        this.e = z2;
        if (z2) {
            if (z) {
                this.f17731a.postDelayed(new c(), 200L);
                return;
            } else {
                this.f.start();
                return;
            }
        }
        if (z) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public void j() {
        LogUtil.i("PhotoViewSysUiHelper", "switchStatus isShow=" + this.d);
        if (this.f.isRunning()) {
            return;
        }
        i(!this.d, true);
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        LogUtil.i("PhotoViewSysUiHelper", "onSystemUiVisibilityChange=" + i + "    " + (i == 0));
    }
}

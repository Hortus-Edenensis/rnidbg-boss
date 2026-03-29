package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ja4 implements un2, View.OnTouchListener {
    public final vn2 b;
    public final d c;
    public final g d;
    public final b e;
    public c f;
    public float i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f18357a = new f();
    public wn2 g = new a43();
    public xn2 h = new b43();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Property<View, Float> f18358a;
        public float b;
        public float c;

        public abstract void a(View view);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(c cVar);

        boolean b(MotionEvent motionEvent);

        int c();

        boolean d(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f18360a;

        public d() {
            this.f18360a = ja4.this.e();
        }

        @Override // ja4.c
        public void a(c cVar) {
            ja4 ja4Var = ja4.this;
            ja4Var.g.a(ja4Var, cVar.c(), c());
        }

        @Override // ja4.c
        public boolean b(MotionEvent motionEvent) {
            return false;
        }

        @Override // ja4.c
        public int c() {
            return 0;
        }

        @Override // ja4.c
        public boolean d(MotionEvent motionEvent) {
            if (!this.f18360a.a(ja4.this.b.getView(), motionEvent)) {
                return false;
            }
            if (!(ja4.this.b.b() && this.f18360a.c) && (!ja4.this.b.a() || this.f18360a.c)) {
                return false;
            }
            ja4.this.f18357a.f18362a = motionEvent.getPointerId(0);
            ja4 ja4Var = ja4.this;
            f fVar = ja4Var.f18357a;
            e eVar = this.f18360a;
            fVar.b = eVar.f18361a;
            fVar.c = eVar.c;
            ja4Var.g(ja4Var.d);
            return ja4.this.d.d(motionEvent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f18361a;
        public float b;
        public boolean c;

        public abstract boolean a(View view, MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18362a;
        public float b;
        public boolean c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f18363a;
        public final float b;
        public final e c;
        public int d;

        public g(float f, float f2) {
            this.c = ja4.this.e();
            this.f18363a = f;
            this.b = f2;
        }

        @Override // ja4.c
        public void a(c cVar) {
            ja4 ja4Var = ja4.this;
            this.d = ja4Var.f18357a.c ? 1 : 2;
            ja4Var.g.a(ja4Var, cVar.c(), c());
        }

        @Override // ja4.c
        public boolean b(MotionEvent motionEvent) {
            ja4 ja4Var = ja4.this;
            ja4Var.g(ja4Var.e);
            return false;
        }

        @Override // ja4.c
        public int c() {
            return this.d;
        }

        @Override // ja4.c
        public boolean d(MotionEvent motionEvent) {
            if (ja4.this.f18357a.f18362a != motionEvent.getPointerId(0)) {
                ja4 ja4Var = ja4.this;
                ja4Var.g(ja4Var.e);
                return true;
            }
            View view = ja4.this.b.getView();
            if (!this.c.a(view, motionEvent)) {
                return true;
            }
            e eVar = this.c;
            float f = eVar.b;
            boolean z = eVar.c;
            ja4 ja4Var2 = ja4.this;
            f fVar = ja4Var2.f18357a;
            boolean z2 = fVar.c;
            float f2 = f / (z == z2 ? this.f18363a : this.b);
            float f3 = eVar.f18361a + f2;
            if ((z2 && !z && f3 <= fVar.b) || (!z2 && z && f3 >= fVar.b)) {
                ja4Var2.i(view, fVar.b, motionEvent);
                ja4 ja4Var3 = ja4.this;
                ja4Var3.h.a(ja4Var3, this.d, 0.0f);
                ja4 ja4Var4 = ja4.this;
                ja4Var4.g(ja4Var4.c);
                return true;
            }
            if (view.getParent() != null) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
            if (eventTime > 0) {
                ja4.this.i = f2 / eventTime;
            }
            ja4.this.h(view, f3);
            ja4 ja4Var5 = ja4.this;
            ja4Var5.h.a(ja4Var5, this.d, f3);
            return true;
        }
    }

    public ja4(vn2 vn2Var, float f2, float f3, float f4) {
        this.b = vn2Var;
        this.e = new b(f2);
        this.d = new g(f3, f4);
        d dVar = new d();
        this.c = dVar;
        this.f = dVar;
        c();
    }

    @Override // defpackage.un2
    public void a(wn2 wn2Var) {
        if (wn2Var == null) {
            wn2Var = new a43();
        }
        this.g = wn2Var;
    }

    @Override // defpackage.un2
    public void b(xn2 xn2Var) {
        if (xn2Var == null) {
            xn2Var = new b43();
        }
        this.h = xn2Var;
    }

    public void c() {
        f().setOnTouchListener(this);
        f().setOverScrollMode(2);
    }

    public abstract a d();

    public abstract e e();

    public View f() {
        return this.b.getView();
    }

    public void g(c cVar) {
        c cVar2 = this.f;
        this.f = cVar;
        cVar.a(cVar2);
    }

    public abstract void h(View view, float f2);

    public abstract void i(View view, float f2, MotionEvent motionEvent);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                return this.f.d(motionEvent);
            }
            if (action != 3) {
                return false;
            }
        }
        return this.f.b(motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interpolator f18359a = new DecelerateInterpolator();
        public final float b;
        public final float c;
        public final a d;

        public b(float f) {
            this.b = f;
            this.c = f * 2.0f;
            this.d = ja4.this.d();
        }

        @Override // ja4.c
        public void a(c cVar) {
            ja4 ja4Var = ja4.this;
            ja4Var.g.a(ja4Var, cVar.c(), c());
            Animator animatorE = e();
            animatorE.addListener(this);
            animatorE.start();
        }

        @Override // ja4.c
        public boolean b(MotionEvent motionEvent) {
            return true;
        }

        @Override // ja4.c
        public int c() {
            return 3;
        }

        @Override // ja4.c
        public boolean d(MotionEvent motionEvent) {
            return true;
        }

        public Animator e() {
            View view = ja4.this.b.getView();
            this.d.a(view);
            ja4 ja4Var = ja4.this;
            float f = ja4Var.i;
            if (f == 0.0f || ((f < 0.0f && ja4Var.f18357a.c) || (f > 0.0f && !ja4Var.f18357a.c))) {
                return f(this.d.b);
            }
            float f2 = (-f) / this.b;
            float f3 = f2 >= 0.0f ? f2 : 0.0f;
            float f4 = this.d.b + (((-f) * f) / this.c);
            ObjectAnimator objectAnimatorG = g(view, (int) f3, f4);
            ObjectAnimator objectAnimatorF = f(f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorG, objectAnimatorF);
            return animatorSet;
        }

        public ObjectAnimator f(float f) {
            View view = ja4.this.b.getView();
            float fAbs = Math.abs(f);
            a aVar = this.d;
            float f2 = (fAbs / aVar.c) * 800.0f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, aVar.f18358a, ja4.this.f18357a.b);
            objectAnimatorOfFloat.setDuration(Math.max((int) f2, 200));
            objectAnimatorOfFloat.setInterpolator(this.f18359a);
            objectAnimatorOfFloat.addUpdateListener(this);
            return objectAnimatorOfFloat;
        }

        public ObjectAnimator g(View view, int i, float f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, this.d.f18358a, f);
            objectAnimatorOfFloat.setDuration(i);
            objectAnimatorOfFloat.setInterpolator(this.f18359a);
            objectAnimatorOfFloat.addUpdateListener(this);
            return objectAnimatorOfFloat;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ja4 ja4Var = ja4.this;
            ja4Var.g(ja4Var.c);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ja4 ja4Var = ja4.this;
            ja4Var.h.a(ja4Var, 3, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

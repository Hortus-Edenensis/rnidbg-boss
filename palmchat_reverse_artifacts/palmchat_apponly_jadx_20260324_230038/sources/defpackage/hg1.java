package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import com.wifi.ad.core.utils.UIUtils;
import com.zenmen.palmchat.framework.R$anim;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hg1 {
    public static int x = UIUtils.dip2px(com.zenmen.palmchat.c.b(), 100.0f);
    public static int y = UIUtils.dip2px(com.zenmen.palmchat.c.b(), 20.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewConfiguration f17947a;
    public boolean d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public float j;
    public float k;
    public float l;
    public float m;
    public View p;
    public View q;
    public e r;
    public Context s;
    public f w;
    public int b = 500;
    public float c = 0.4f;
    public boolean n = false;
    public boolean o = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            hg1 hg1Var = hg1.this;
            hg1Var.w(hg1Var.k, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f17950a;

        public c(float f) {
            this.f17950a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (hg1.this.n) {
                hg1.this.j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                hg1 hg1Var = hg1.this;
                hg1Var.k = this.f17950a * hg1Var.j;
                hg1 hg1Var2 = hg1.this;
                hg1Var2.l = hg1Var2.j;
                hg1 hg1Var3 = hg1.this;
                hg1Var3.m = hg1Var3.k;
                hg1 hg1Var4 = hg1.this;
                hg1Var4.w(hg1Var4.m, hg1.this.j);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a();

        void b();

        void c(float f);

        void d(boolean z);

        boolean intercept();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();

        void b();

        void c();
    }

    public hg1(Context context) {
        this.s = context;
        this.f17947a = ViewConfiguration.get(context);
    }

    public void n(float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.j, f2 > 0.0f ? this.q.getHeight() : -this.q.getHeight());
        valueAnimatorOfFloat.addUpdateListener(new a());
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.start();
    }

    public boolean o(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            p("action down--->");
            this.i = motionEvent.getPointerId(0);
            this.u = false;
            this.v = false;
            q(motionEvent);
        } else if (motionEvent.getAction() == 2) {
            p("action move--->" + motionEvent.getPointerCount() + "---" + this.d);
            if (motionEvent.getPointerCount() > 1) {
                if (!this.d) {
                    q(motionEvent);
                    return false;
                }
                this.d = false;
                r();
                return true;
            }
            if (this.i != motionEvent.getPointerId(0)) {
                if (this.d) {
                    r();
                }
                q(motionEvent);
                return false;
            }
            float y2 = motionEvent.getY();
            float x2 = motionEvent.getX();
            float f2 = x2 - this.g;
            float f3 = y2 - this.e;
            if (!this.d) {
                int i = x;
                if (f2 <= (-i)) {
                    if (this.w != null && Math.abs(f2) > ((double) Math.abs(f3)) * 1.5d && !this.u) {
                        this.u = true;
                        this.w.b();
                    }
                } else if (f2 > i && f2 > ((double) Math.abs(f3)) * 1.5d && !this.u) {
                    this.u = true;
                    this.w.a();
                }
                if (!this.v && (Math.abs(f2) > y || Math.abs(f3) > y)) {
                    this.w.c();
                    this.v = true;
                }
            }
            e eVar = this.r;
            if (eVar != null && eVar.intercept()) {
                p("action dispatch--->");
                this.d = false;
                return false;
            }
            float f4 = 0.0f;
            if (f3 < 0.0f && !this.d) {
                return false;
            }
            if (this.d || (Math.abs(y2 - this.e) > this.f17947a.getScaledTouchSlop() * 2 && Math.abs(y2 - this.e) > ((double) Math.abs(x2 - this.g)) * 1.5d)) {
                this.e = y2;
                this.g = x2;
                p("action move---> start close");
                float rawY = motionEvent.getRawY();
                float rawX = motionEvent.getRawX();
                if (!this.d) {
                    this.d = true;
                    e eVar2 = this.r;
                    if (eVar2 != null) {
                        eVar2.a();
                    }
                }
                float f5 = (rawY - this.f) + this.l;
                this.j = f5;
                this.k = (rawX - this.h) + this.m;
                float fAbs = 1.0f - Math.abs(f5 / (this.b + this.q.getHeight()));
                if (fAbs > 1.0f) {
                    f4 = 1.0f;
                } else if (fAbs >= 0.0f) {
                    f4 = fAbs;
                }
                this.p.getBackground().mutate().setAlpha((int) (255.0f * f4));
                e eVar3 = this.r;
                if (eVar3 != null) {
                    eVar3.c(f4);
                }
                this.q.setTranslationY(this.j);
                this.q.setTranslationX(this.k);
                float f6 = this.c;
                if (f4 < f6) {
                    f4 = f6;
                }
                this.q.setScaleX(f4);
                this.q.setScaleY(f4);
                return this.d;
            }
        } else if (motionEvent.getAction() == 1) {
            p("action up--->" + this.d);
            if (this.d) {
                float f7 = this.j;
                if (f7 <= this.b) {
                    r();
                } else if (this.o) {
                    e eVar4 = this.r;
                    if (eVar4 != null) {
                        eVar4.d(true);
                    }
                } else {
                    n(f7);
                }
                this.d = false;
                return false;
            }
        } else if (motionEvent.getAction() == 3 && this.d) {
            r();
            this.d = false;
        }
        return false;
    }

    public final void p(String str) {
        if (this.t) {
            Log.d(getClass().getName(), str);
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.d = false;
        this.e = motionEvent.getY();
        this.g = motionEvent.getX();
        this.f = motionEvent.getRawY();
        this.h = motionEvent.getRawX();
        this.l = 0.0f;
        this.m = 0.0f;
    }

    public final void r() {
        if (this.n) {
            return;
        }
        float f2 = this.j;
        if (f2 == 0.0f) {
            return;
        }
        float f3 = this.k / f2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new c(f3));
        valueAnimatorOfFloat.addListener(new d());
        valueAnimatorOfFloat.setDuration(100L).start();
    }

    public void s(e eVar) {
        this.r = eVar;
    }

    public void t(View view, View view2) {
        this.p = view;
        this.q = view2;
    }

    public void u(f fVar) {
        this.w = fVar;
    }

    public void v(boolean z) {
        this.o = z;
    }

    public final void w(float f2, float f3) {
        this.q.setTranslationY(f3);
        this.q.setTranslationX(f2);
        float fAbs = 1.0f - Math.abs(f3 / (this.b + this.q.getHeight()));
        float f4 = this.c;
        if (fAbs < f4) {
            fAbs = f4;
        }
        this.q.setScaleX(fAbs);
        this.q.setScaleY(fAbs);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (hg1.this.r != null) {
                hg1.this.r.d(false);
            }
            if (hg1.this.s instanceof Activity) {
                ((Activity) hg1.this.s).finish();
                ((Activity) hg1.this.s).overridePendingTransition(R$anim.lx_anim_drag_enter, R$anim.lx_anim_drag_exit);
            }
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

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (hg1.this.n) {
                hg1.this.p.getBackground().mutate().setAlpha(255);
                hg1.this.j = 0.0f;
                hg1.this.k = 0.0f;
                hg1.this.n = false;
                if (hg1.this.r != null) {
                    hg1.this.r.b();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            hg1.this.n = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}

package defpackage;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mr implements lr, PopupWindow.OnDismissListener, ok4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pk4 f19296a;
    public View b;
    public WeakReference<Context> c;
    public View d;
    public View e;
    public f g;
    public Animation h;
    public Animator i;
    public Animation j;
    public Animator k;
    public int o;
    public int p;
    public int q;
    public int r;
    public int[] s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public volatile int x;
    public boolean f = false;
    public boolean l = false;
    public boolean m = true;
    public int n = 0;
    public Animator.AnimatorListener y = new d();
    public Animation.AnimationListener z = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mr.this.n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19299a;

        public c(View view) {
            this.f19299a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            mr.e(mr.this);
            mr.this.P(this.f19299a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class f implements PopupWindow.OnDismissListener {
        public boolean a() {
            return true;
        }
    }

    public mr(Context context, int i, int i2) {
        B(context, i, i2);
    }

    public static /* synthetic */ int e(mr mrVar) {
        int i = mrVar.x;
        mrVar.x = i + 1;
        return i;
    }

    public Animator A() {
        return null;
    }

    public final void B(Context context, int i, int i2) {
        this.c = new WeakReference<>(context);
        this.b = a();
        View viewC = c();
        this.d = viewC;
        if (viewC != null) {
            this.w = viewC.getId();
        }
        l();
        pk4 pk4Var = new pk4(this.b, i, i2, this);
        this.f19296a = pk4Var;
        pk4Var.setOnDismissListener(this);
        F(true);
        D(i, i2);
        G(Build.VERSION.SDK_INT <= 22);
        View viewQ = q();
        this.e = viewQ;
        if (viewQ != null && !(viewQ instanceof AdapterView)) {
            viewQ.setOnClickListener(new a());
        }
        View view = this.d;
        if (view != null && !(view instanceof AdapterView)) {
            view.setOnClickListener(new b());
        }
        this.h = z();
        this.i = A();
        this.j = x();
        this.k = y();
        this.s = new int[2];
    }

    public boolean C() {
        return this.f19296a.isShowing();
    }

    public final void D(int i, int i2) {
        View view = this.b;
        if (view != null) {
            view.measure(i, i2);
            this.q = this.b.getMeasuredWidth();
            this.r = this.b.getMeasuredHeight();
            this.b.setFocusableInTouchMode(true);
        }
    }

    public final void E(View view) {
        View viewFindViewById;
        if (this.x > 3) {
            return;
        }
        if (C()) {
            o();
        }
        Context contextR = r();
        if (contextR instanceof Activity) {
            Activity activity = (Activity) contextR;
            if (!((activity.isFinishing() || activity.isDestroyed()) ? false : true) || (viewFindViewById = activity.findViewById(R.id.content)) == null) {
                return;
            }
            viewFindViewById.postDelayed(new c(view), 350L);
        }
    }

    public mr F(boolean z) {
        this.v = z;
        if (z) {
            this.f19296a.setFocusable(true);
            this.f19296a.setOutsideTouchable(true);
            this.f19296a.setBackgroundDrawable(new ColorDrawable());
        } else {
            this.f19296a.setFocusable(false);
            this.f19296a.setOutsideTouchable(false);
            this.f19296a.setBackgroundDrawable(null);
        }
        return this;
    }

    public mr G(boolean z) {
        this.m = z;
        return this;
    }

    public mr H(int i) {
        this.o = i;
        return this;
    }

    public mr I(int i) {
        this.p = i;
        return this;
    }

    public mr J(f fVar) {
        this.g = fVar;
        return this;
    }

    public void K(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            if (view != null && onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public void N(View view) {
        if (k(view)) {
            this.u = true;
            P(view);
        }
    }

    public void O(View view, boolean z) {
        if (k(view)) {
            this.u = z;
            P(view);
        }
    }

    public final void P(View view) {
        Animator animator;
        View view2;
        try {
            if (view != null) {
                int[] iArrI = i(view);
                if (this.u) {
                    this.f19296a.showAsDropDown(view, iArrI[0], iArrI[1]);
                } else {
                    this.f19296a.showAtLocation(view, this.n, iArrI[0], iArrI[1]);
                }
            } else {
                Context contextR = r();
                if (contextR instanceof Activity) {
                    this.f19296a.showAtLocation(((Activity) contextR).findViewById(R.id.content), this.n, this.o, this.p);
                } else {
                    Log.e("BasePopupWindow", "can not get token from context,make sure that context is instance of activity");
                }
            }
            if (this.h != null && (view2 = this.d) != null) {
                view2.clearAnimation();
                this.d.startAnimation(this.h);
            }
            if (this.h == null && (animator = this.i) != null && this.d != null) {
                animator.start();
            }
            if (this.f && t() != null) {
                t().requestFocus();
                lt2.b(t(), 150L);
            }
            this.x = 0;
        } catch (Exception e2) {
            if (e2 instanceof WindowManager.BadTokenException) {
                E(view);
                Log.e("BasePopupWindow", "have no window token,retry to show");
                e2.printStackTrace();
            } else {
                Log.e("BasePopupWindow", "show error\n" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.ok4
    public boolean b() {
        return j();
    }

    @Override // defpackage.ok4
    public boolean d() {
        boolean z;
        Animation animation = this.j;
        if (animation == null || this.d == null) {
            Animator animator = this.k;
            if (animator != null && !this.l) {
                animator.removeListener(this.y);
                this.k.addListener(this.y);
                this.k.start();
                this.l = true;
                z = true;
            }
            z = false;
        } else {
            if (!this.l) {
                animation.setAnimationListener(this.z);
                this.d.clearAnimation();
                this.d.startAnimation(this.j);
                this.l = true;
                z = true;
            }
            z = false;
        }
        return !z;
    }

    public final int[] i(View view) {
        int[] iArr = {this.o, this.p};
        view.getLocationOnScreen(this.s);
        if (this.t) {
            if (v() - (this.s[1] + iArr[1]) < s()) {
                iArr[1] = ((-view.getHeight()) - s()) - iArr[1];
                M(this.b);
            } else {
                L(this.b);
            }
        }
        return iArr;
    }

    public final boolean j() {
        f fVar = this.g;
        return (fVar != null ? fVar.a() : true) && !this.l;
    }

    public final boolean k(View view) {
        return true;
    }

    public final void l() {
        View view;
        View view2 = this.b;
        if (view2 == null || (view = this.d) == null || view2 != view) {
            return;
        }
        try {
            FrameLayout frameLayout = new FrameLayout(r());
            this.b = frameLayout;
            if (this.w == 0) {
                frameLayout.addView(this.d);
            } else {
                this.d = View.inflate(r(), this.w, (FrameLayout) this.b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public View m(int i) {
        if (i == 0) {
            return null;
        }
        this.w = i;
        return LayoutInflater.from(r()).inflate(i, (ViewGroup) null);
    }

    public void n() {
        try {
            this.f19296a.dismiss();
        } catch (Exception e2) {
            Log.e("BasePopupWindow", "dismiss error");
            e2.printStackTrace();
        }
    }

    public void o() {
        View view;
        if (j()) {
            try {
                if (this.j != null && (view = this.d) != null) {
                    view.clearAnimation();
                }
                Animator animator = this.k;
                if (animator != null) {
                    animator.removeAllListeners();
                }
                this.f19296a.a();
            } catch (Exception e2) {
                Log.e("BasePopupWindow", "dismiss error");
                e2.printStackTrace();
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        f fVar = this.g;
        if (fVar != null) {
            fVar.onDismiss();
        }
        this.l = false;
    }

    public View p(int i) {
        View view = this.b;
        if (view == null || i == 0) {
            return null;
        }
        return view.findViewById(i);
    }

    public abstract View q();

    public Context r() {
        WeakReference<Context> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int s() {
        int height = this.f19296a.getHeight();
        return height <= 0 ? this.r : height;
    }

    public EditText t() {
        return null;
    }

    public View u() {
        return this.b;
    }

    public int v() {
        return r().getResources().getDisplayMetrics().heightPixels;
    }

    public int w() {
        int width = this.f19296a.getWidth();
        return width <= 0 ? this.q : width;
    }

    public abstract Animation x();

    public Animator y() {
        return null;
    }

    public abstract Animation z();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            mr.this.l = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mr.this.f19296a.a();
            mr.this.l = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mr.this.l = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            mr.this.f19296a.a();
            mr.this.l = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            mr.this.l = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public void L(View view) {
    }

    public void M(View view) {
    }
}

package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.R$dimen;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mm5 {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StyledPlayerControlView f19266a;

    @Nullable
    public final View b;

    @Nullable
    public final ViewGroup c;

    @Nullable
    public final ViewGroup d;

    @Nullable
    public final ViewGroup e;

    @Nullable
    public final ViewGroup f;

    @Nullable
    public final ViewGroup g;

    @Nullable
    public final ViewGroup h;

    @Nullable
    public final ViewGroup i;

    @Nullable
    public final View j;

    @Nullable
    public final View k;
    public final AnimatorSet l;
    public final AnimatorSet m;
    public final AnimatorSet n;
    public final AnimatorSet o;
    public final AnimatorSet p;
    public final ValueAnimator q;
    public final ValueAnimator r;
    public final Runnable s = new Runnable() { // from class: zl5
        @Override // java.lang.Runnable
        public final void run() {
            this.f22445a.d0();
        }
    };
    public final Runnable t = new Runnable() { // from class: fm5
        @Override // java.lang.Runnable
        public final void run() {
            this.f17562a.D();
        }
    };
    public final Runnable u = new Runnable() { // from class: gm5
        @Override // java.lang.Runnable
        public final void run() {
            this.f17749a.H();
        }
    };
    public final Runnable v = new Runnable() { // from class: hm5
        @Override // java.lang.Runnable
        public final void run() {
            this.f17995a.G();
        }
    };
    public final Runnable w = new Runnable() { // from class: im5
        @Override // java.lang.Runnable
        public final void run() {
            this.f18203a.E();
        }
    };
    public final View.OnLayoutChangeListener x = new View.OnLayoutChangeListener() { // from class: jm5
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f18437a.S(view, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    };
    public boolean C = true;
    public int z = 0;
    public final List<View> y = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (mm5.this.b != null) {
                mm5.this.b.setVisibility(4);
            }
            if (mm5.this.c != null) {
                mm5.this.c.setVisibility(4);
            }
            if (mm5.this.e != null) {
                mm5.this.e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(mm5.this.j instanceof DefaultTimeBar) || mm5.this.A) {
                return;
            }
            ((DefaultTimeBar) mm5.this.j).hideScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (mm5.this.b != null) {
                mm5.this.b.setVisibility(0);
            }
            if (mm5.this.c != null) {
                mm5.this.c.setVisibility(0);
            }
            if (mm5.this.e != null) {
                mm5.this.e.setVisibility(mm5.this.A ? 0 : 4);
            }
            if (!(mm5.this.j instanceof DefaultTimeBar) || mm5.this.A) {
                return;
            }
            ((DefaultTimeBar) mm5.this.j).showScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f19269a;

        public c(StyledPlayerControlView styledPlayerControlView) {
            this.f19269a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mm5.this.a0(1);
            if (mm5.this.B) {
                this.f19269a.post(mm5.this.s);
                mm5.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mm5.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f19270a;

        public d(StyledPlayerControlView styledPlayerControlView) {
            this.f19270a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mm5.this.a0(2);
            if (mm5.this.B) {
                this.f19270a.post(mm5.this.s);
                mm5.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mm5.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f19271a;

        public e(StyledPlayerControlView styledPlayerControlView) {
            this.f19271a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mm5.this.a0(2);
            if (mm5.this.B) {
                this.f19271a.post(mm5.this.s);
                mm5.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mm5.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mm5.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mm5.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mm5.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            mm5.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (mm5.this.f != null) {
                mm5.this.f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (mm5.this.h != null) {
                mm5.this.h.setVisibility(0);
                mm5.this.h.setTranslationX(mm5.this.h.getWidth());
                mm5.this.h.scrollTo(mm5.this.h.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (mm5.this.h != null) {
                mm5.this.h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (mm5.this.f != null) {
                mm5.this.f.setVisibility(0);
            }
        }
    }

    public mm5(StyledPlayerControlView styledPlayerControlView) {
        this.f19266a = styledPlayerControlView;
        this.b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.d = viewGroup;
        this.i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View viewFindViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.j = viewFindViewById;
        this.f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.k = viewFindViewById2;
        View viewFindViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: km5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18725a.U(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: km5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18725a.U(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: lm5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f19032a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: am5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f1254a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        int i2 = R$dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i2) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(O(0.0f, dimension, viewFindViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(O(dimension, dimension2, viewFindViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(O(0.0f, dimension2, viewFindViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(O(dimension, 0.0f, viewFindViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(O(dimension2, 0.0f, viewFindViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dm5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17082a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: em5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17318a.N(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    public static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static ObjectAnimator O(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    public static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.y.contains(view);
    }

    public void C() {
        int i2 = this.z;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.z == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.n.start();
    }

    public final void E() {
        a0(2);
    }

    public void F() {
        int i2 = this.z;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        W();
        E();
    }

    public final void G() {
        this.l.start();
        V(this.u, 2000L);
    }

    public final void H() {
        this.m.start();
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.z == 0 && this.f19266a.isVisible();
    }

    public void P() {
        this.f19266a.addOnLayoutChangeListener(this.x);
    }

    public void Q() {
        this.f19266a.removeOnLayoutChangeListener(this.x);
    }

    public void R(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public final void S(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean zF0 = f0();
        if (this.A != zF0) {
            this.A = zF0;
            view.post(new Runnable() { // from class: bm5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1753a.e0();
                }
            });
        }
        boolean z = i4 - i2 != i8 - i6;
        if (this.A || !z) {
            return;
        }
        view.post(new Runnable() { // from class: cm5
            @Override // java.lang.Runnable
            public final void run() {
                this.f2019a.T();
            }
        });
    }

    public final void T() {
        int i2;
        if (this.f == null || this.g == null) {
            return;
        }
        int width = (this.f19266a.getWidth() - this.f19266a.getPaddingLeft()) - this.f19266a.getPaddingRight();
        while (true) {
            if (this.g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.g.getChildCount() - 2;
            View childAt = this.g.getChildAt(childCount);
            this.g.removeViewAt(childCount);
            this.f.addView(childAt, 0);
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.i);
        int childCount2 = this.f.getChildCount() - 1;
        for (int i3 = 0; i3 < childCount2; i3++) {
            iB += B(this.f.getChildAt(i3));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.r.isStarted()) {
                return;
            }
            this.q.cancel();
            this.r.start();
            return;
        }
        View view2 = this.k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = this.f.getChildAt(i4);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f.removeViews(0, arrayList.size());
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            this.g.addView((View) arrayList.get(i2), this.g.getChildCount() - 1);
        }
    }

    public final void U(View view) {
        X();
        if (view.getId() == R$id.exo_overflow_show) {
            this.q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.r.start();
        }
    }

    public final void V(Runnable runnable, long j) {
        if (j >= 0) {
            this.f19266a.postDelayed(runnable, j);
        }
    }

    public void W() {
        this.f19266a.removeCallbacks(this.w);
        this.f19266a.removeCallbacks(this.t);
        this.f19266a.removeCallbacks(this.v);
        this.f19266a.removeCallbacks(this.u);
    }

    public void X() {
        if (this.z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f19266a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.w, showTimeoutMs);
            } else if (this.z == 1) {
                V(this.u, 2000L);
            } else {
                V(this.v, showTimeoutMs);
            }
        }
    }

    public void Y(boolean z) {
        this.C = z;
    }

    public void Z(@Nullable View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.y.add(view);
    }

    public final void a0(int i2) {
        int i3 = this.z;
        this.z = i2;
        if (i2 == 2) {
            this.f19266a.setVisibility(8);
        } else if (i3 == 2) {
            this.f19266a.setVisibility(0);
        }
        if (i3 != i2) {
            this.f19266a.notifyOnVisibilityChange();
        }
    }

    public final boolean b0(View view) {
        int id = view.getId();
        return id == R$id.exo_bottom_bar || id == R$id.exo_prev || id == R$id.exo_next || id == R$id.exo_rew || id == R$id.exo_rew_with_amount || id == R$id.exo_ffwd || id == R$id.exo_ffwd_with_amount;
    }

    public void c0() {
        if (!this.f19266a.isVisible()) {
            this.f19266a.setVisibility(0);
            this.f19266a.updateAll();
            this.f19266a.requestPlayPauseFocus();
        }
        d0();
    }

    public final void d0() {
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i2 = this.z;
        if (i2 == 1) {
            this.o.start();
        } else if (i2 == 2) {
            this.p.start();
        } else if (i2 == 3) {
            this.B = true;
        } else if (i2 == 4) {
            return;
        }
        X();
    }

    public final void e0() {
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.j != null) {
            int dimensionPixelSize = this.f19266a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.j.setLayoutParams(marginLayoutParams);
            }
            View view = this.j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i2 = this.z;
                    if (i2 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view2 : this.y) {
            view2.setVisibility((this.A && b0(view2)) ? 4 : 0);
        }
    }

    public final boolean f0() {
        int width = (this.f19266a.getWidth() - this.f19266a.getPaddingLeft()) - this.f19266a.getPaddingRight();
        int height = (this.f19266a.getHeight() - this.f19266a.getPaddingBottom()) - this.f19266a.getPaddingTop();
        int iB = B(this.c);
        ViewGroup viewGroup = this.c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.c.getPaddingRight() : 0);
        int iZ = z(this.c);
        ViewGroup viewGroup2 = this.c;
        return width <= Math.max(paddingLeft, B(this.i) + B(this.k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.c.getPaddingBottom() : 0)) + (z(this.d) * 2);
    }

    public final void y(float f2) {
        if (this.h != null) {
            this.h.setTranslationX((int) (r0.getWidth() * (1.0f - f2)));
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
    }
}

package com.opos.mobad.template.f.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.c;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected TextView f9470a;
    protected c b;
    private final Context c;
    private c d;
    private AnimatorSet e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private Animator i;
    private w j;
    private EnumC0783a k;

    /* JADX INFO: renamed from: com.opos.mobad.template.f.a.a$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9473a;

        static {
            int[] iArr = new int[EnumC0783a.values().length];
            f9473a = iArr;
            try {
                iArr[EnumC0783a.FINGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9473a[EnumC0783a.FLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9473a[EnumC0783a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.template.f.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0783a {
        NONE,
        FINGER,
        FLASH
    }

    public a(Context context, EnumC0783a enumC0783a) {
        EnumC0783a enumC0783a2 = EnumC0783a.NONE;
        this.k = enumC0783a;
        this.c = context;
        b();
        f();
    }

    private int a(float f) {
        return com.opos.cmn.an.h.f.a.a(this.c, f);
    }

    private void b() {
        c cVar = new c(this.c);
        this.d = cVar;
        cVar.setId(View.generateViewId());
        c cVar2 = new c(this.c);
        this.b = cVar2;
        cVar2.setId(View.generateViewId());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.c.getResources().getColor(R.color.opos_mobad_interstitial_video_btn_color));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.c, 36.0f));
        this.b.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(20);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        layoutParams.addRule(12);
        this.d.addView(this.b, layoutParams);
        TextView textView = new TextView(this.c);
        this.f9470a = textView;
        h.a(textView);
        this.f9470a.setEllipsize(TextUtils.TruncateAt.END);
        this.f9470a.setId(View.generateViewId());
        this.f9470a.setTextColor(-1);
        this.f9470a.setTextSize(1, 12.0f);
        this.f9470a.setGravity(17);
        this.f9470a.setSingleLine();
        this.f9470a.setMaxEms(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(20);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        this.d.addView(this.f9470a, layoutParams2);
        c();
    }

    private void c() {
        int i = AnonymousClass3.f9473a[this.k.ordinal()];
        if (i == 1) {
            d();
        } else {
            if (i != 2) {
                return;
            }
            e();
        }
    }

    private void d() {
        if (this.k != EnumC0783a.FINGER) {
            return;
        }
        ImageView imageView = new ImageView(this.c);
        this.h = imageView;
        imageView.setImageResource(R.drawable.opos_mobad_icon_button_finger);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(40.0f), a(29.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(21);
        layoutParams.bottomMargin = a(4.0f);
        layoutParams.setMarginEnd(a(7.0f));
        this.d.addView(this.h, layoutParams);
        ImageView imageView2 = new ImageView(this.c);
        this.f = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_drawable_interstitial_button_big_circle);
        int iA = a(26.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(10);
        layoutParams2.addRule(21);
        layoutParams2.setMarginEnd(a(29.0f));
        layoutParams2.topMargin = a(3.0f);
        this.d.addView(this.f, layoutParams2);
        ImageView imageView3 = new ImageView(this.c);
        this.g = imageView3;
        imageView3.setImageResource(R.drawable.opos_mobad_drawable_interstitial_button_small_circle);
        int iA2 = a(16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = a(8.0f);
        layoutParams3.setMarginEnd(a(34.0f));
        this.d.addView(this.g, layoutParams3);
    }

    private void e() {
        w wVar = new w(this.c);
        this.j = wVar;
        wVar.setBackgroundColor(0);
        this.j.a(com.opos.cmn.an.h.f.a.a(this.c, 36.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        layoutParams.addRule(12);
        layoutParams.addRule(13);
        this.d.addView(this.j, layoutParams);
    }

    private void f() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.c);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.a.a.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    a.this.g();
                } else {
                    a.this.h();
                }
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i = AnonymousClass3.f9473a[this.k.ordinal()];
        if (i == 1) {
            k();
        } else {
            if (i != 2) {
                return;
            }
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i = AnonymousClass3.f9473a[this.k.ordinal()];
        if (i == 1) {
            l();
        } else {
            if (i != 2) {
                return;
            }
            j();
        }
    }

    private void i() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.bringToFront();
            if (this.i == null) {
                this.i = ae.a((RelativeLayout) this.j);
            }
            this.i.start();
        }
    }

    private void j() {
        Animator animator = this.i;
        if (animator != null) {
            animator.cancel();
        }
    }

    private void k() {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.bringToFront();
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.bringToFront();
        }
        ImageView imageView3 = this.g;
        if (imageView3 != null) {
            imageView3.bringToFront();
        }
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null) {
            animatorSet.cancel();
        } else {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.e = animatorSet2;
            animatorSet2.playSequentially(m(), n());
            this.e.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.f.a.a.2
                private boolean b;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.b = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.b) {
                        return;
                    }
                    animator.start();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    this.b = false;
                }
            });
        }
        this.e.start();
    }

    private void l() {
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private AnimatorSet m() {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f9470a, PropertyValuesHolder.ofFloat("textSize", 16.0f, 15.0f)).setDuration(1000L);
        duration.setInterpolator(o());
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.95f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.95f)).setDuration(1000L);
        duration2.setInterpolator(o());
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(this.f, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.06f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.06f)).setDuration(1000L);
        duration3.setInterpolator(o());
        ObjectAnimator duration4 = ObjectAnimator.ofPropertyValuesHolder(this.g, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.95f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.95f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.55f)).setDuration(1000L);
        duration4.setInterpolator(o());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.h, PropertyValuesHolder.ofFloat("translationX", a(3.0f), 0.0f), PropertyValuesHolder.ofFloat("translationY", a(2.0f), 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(600L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(q());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration2, duration3, duration4, duration);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(objectAnimatorOfPropertyValuesHolder).with(animatorSet);
        return animatorSet2;
    }

    private AnimatorSet n() {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f9470a, PropertyValuesHolder.ofFloat("textSize", 15.0f, 16.0f)).setDuration(1000L);
        duration.setInterpolator(o());
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("scaleX", 0.95f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.95f, 1.0f)).setDuration(1000L);
        duration2.setInterpolator(p());
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(this.f, PropertyValuesHolder.ofFloat("scaleX", 1.06f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.06f, 1.0f)).setDuration(1000L);
        duration3.setInterpolator(p());
        ObjectAnimator duration4 = ObjectAnimator.ofPropertyValuesHolder(this.g, PropertyValuesHolder.ofFloat("scaleX", 0.95f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.95f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.55f, 1.0f)).setDuration(1000L);
        duration4.setInterpolator(p());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.h, PropertyValuesHolder.ofFloat("translationX", 0.0f, a(3.0f)), PropertyValuesHolder.ofFloat("translationY", 0.0f, a(2.0f)));
        objectAnimatorOfPropertyValuesHolder.setDuration(600L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(r());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration2, duration3, duration4, duration);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(objectAnimatorOfPropertyValuesHolder).with(animatorSet);
        return animatorSet2;
    }

    private Interpolator o() {
        return PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
    }

    private Interpolator p() {
        return PathInterpolatorCompat.create(0.3f, 0.0f, 1.0f, 1.0f);
    }

    private Interpolator q() {
        return PathInterpolatorCompat.create(0.23f, 0.0f, 0.1f, 1.0f);
    }

    private Interpolator r() {
        return PathInterpolatorCompat.create(0.45f, 0.0f, 0.34f, 1.0f);
    }

    public c a() {
        return this.d;
    }

    public void b(int i) {
        TextView textView = this.f9470a;
        if (textView != null) {
            textView.setMaxEms(i);
        }
    }

    public void a(int i) {
        TextView textView = this.f9470a;
        if (textView != null) {
            textView.setTextSize(1, i);
        }
    }

    public void a(String str) {
        TextView textView = this.f9470a;
        if (textView != null) {
            textView.setText(str);
        }
    }
}

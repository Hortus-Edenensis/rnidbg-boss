package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.opos.mobad.f.a.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8830a;
    private LinearLayout b;
    private k c;
    private int d;
    private int e;
    private a h;
    private volatile boolean f = false;
    private volatile boolean g = false;
    private Animation.AnimationListener i = new Animation.AnimationListener() { // from class: com.opos.mobad.f.a.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.i();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        k.a f8833a;

        public a(k.a aVar) {
            this.f8833a = aVar;
        }

        @Override // com.opos.mobad.f.a.k.a
        public void a(int i, int i2) {
            b.this.e = i2;
            b.this.d = i;
            b.this.f = true;
            k.a aVar = this.f8833a;
            if (aVar != null) {
                aVar.a(i, i2);
            }
        }
    }

    public b(Context context, com.opos.mobad.ad.a.a aVar, k.a aVar2) {
        this.f8830a = context.getApplicationContext();
        this.b = new LinearLayout(this.f8830a);
        int iB = com.opos.cmn.an.h.f.a.b(this.f8830a);
        int iA = com.opos.cmn.an.h.f.a.a(this.f8830a, 60.0f);
        this.d = iB;
        this.e = iA;
        if (aVar == null || aVar.f8519a < 0 || aVar.b < 0) {
            this.c = new k(this.f8830a, new k.b(iB, iB / 2, iB / iA));
        } else {
            this.c = new k(this.f8830a, new k.b(iB, iB / 2, aVar.f8519a / aVar.b));
        }
        a aVar3 = new a(aVar2);
        this.h = aVar3;
        this.c.a(aVar3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.b.addView(this.c, layoutParams);
        this.b.setGravity(81);
        e();
        FrameLayout frameLayout = new FrameLayout(this.f8830a);
        FrameLayout frameLayout2 = new FrameLayout(this.f8830a);
        this.c.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.c.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        if (this.f) {
            e();
            this.f = false;
        }
    }

    private void e() {
        if (this.c != null) {
            f();
            this.c.setInAnimation(g());
            this.c.setOutAnimation(h());
        }
    }

    private void f() {
        k kVar = this.c;
        if (kVar != null) {
            if (kVar.getInAnimation() != null) {
                this.c.getInAnimation().setAnimationListener(null);
                this.c.getInAnimation().cancel();
            }
            if (this.c.getOutAnimation() != null) {
                this.c.getOutAnimation().cancel();
            }
        }
    }

    private Animation g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.d, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(this.i);
        return translateAnimation;
    }

    private Animation h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.d * (-1), 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        k kVar = this.c;
        if (kVar == null || kVar.getNextView() == null) {
            return;
        }
        ((ViewGroup) this.c.getNextView()).removeAllViews();
    }

    public boolean c() {
        LinearLayout linearLayout = this.b;
        if (linearLayout != null && linearLayout.isShown() && com.opos.cmn.i.k.a(this.f8830a) && this.b.hasWindowFocus()) {
            com.opos.cmn.an.f.a.b("BannerShowPresenter", "isBannerShown");
            return true;
        }
        com.opos.cmn.an.f.a.b("BannerShowPresenter", "isBanner not Shown");
        return false;
    }

    public View a() {
        return this.b;
    }

    public void b() {
        this.g = true;
        this.c.a(null);
        this.b.removeAllViews();
    }

    public void a(View view) {
        com.opos.cmn.an.f.a.b("BannerShowPresenter", "show banner view:" + view);
        if (view == null || this.g) {
            return;
        }
        d();
        ViewGroup viewGroup = (ViewGroup) this.c.getCurrentView();
        boolean z = false;
        if (viewGroup.getChildCount() > 0 && viewGroup.getChildAt(0) != view) {
            viewGroup = (ViewGroup) this.c.getNextView();
            z = true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        if (view.getParent() == null) {
            viewGroup.removeAllViews();
            viewGroup.addView(view, layoutParams);
        } else if (view.getParent() != viewGroup) {
            if (!(view.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.removeAllViews();
            viewGroup.addView(view, layoutParams);
        }
        if (z) {
            this.c.showNext();
        }
    }
}

package com.opos.mobad.template.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends com.opos.mobad.template.cmn.baseview.c implements e {
    private static int s = 280;
    private static int t = 488;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a.b f9630a;
    private com.opos.mobad.template.a.c b;
    private com.opos.mobad.template.cmn.w c;
    private View d;
    private BaseTextView e;
    private v f;
    private com.opos.mobad.template.a.g g;
    private com.opos.mobad.template.k.c h;
    private com.opos.mobad.template.cmn.w i;
    private BaseTextView j;
    private int l;
    private int m;
    private a.InterfaceC0778a n;
    private com.opos.mobad.d.a o;
    private boolean p;
    private RelativeLayout q;
    private RelativeLayout r;
    private com.opos.mobad.template.d.b u;
    private AnimatorSet v;
    private ObjectAnimator w;
    private AnimatorSet x;
    private AnimatorSet y;
    private com.opos.mobad.template.cmn.p z;

    /* JADX INFO: renamed from: com.opos.mobad.template.f.u$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 extends com.opos.mobad.template.cmn.p {
        public AnonymousClass2() {
        }

        @Override // com.opos.mobad.template.cmn.p
        public void b(final View view, final int[] iArr) {
            if (!"1".equals((u.this.u == null || !u.this.u.J.containsKey("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI")) ? "0" : u.this.u.J.get("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI"))) {
                u.this.a(new a() { // from class: com.opos.mobad.template.f.u.2.1
                    @Override // com.opos.mobad.template.f.u.a
                    public void a() {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.u.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (u.this.n != null) {
                                    a.InterfaceC0778a interfaceC0778a = u.this.n;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    interfaceC0778a.e(view, iArr);
                                }
                            }
                        });
                    }
                });
            } else if (u.this.n != null) {
                u.this.n.e(view, iArr);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public u(Context context, int i, com.opos.mobad.d.a aVar, boolean z) {
        super(context);
        this.p = false;
        this.z = new AnonymousClass2();
        this.o = aVar;
        this.l = i;
        this.p = z;
        e();
    }

    private int c() {
        int i;
        if (this.m == 14 || (i = this.l) == 0) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
        }
        if (i == 1) {
            return 240;
        }
        if (i == 2 || i == 3) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
        }
        return 0;
    }

    private int d() {
        int i = this.m;
        if (i == 14) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME;
        }
        if (i == 12) {
            return 400;
        }
        int i2 = this.l;
        if (i2 != 0) {
            if (i2 == 1) {
                return 427;
            }
            if (i2 != 2 && i2 != 3) {
                return 0;
            }
        }
        return 401;
    }

    private void e() {
        int i;
        setClipChildren(false);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        setClickable(true);
        this.q = new RelativeLayout(getContext());
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(getContext());
        this.c = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.c.setId(View.generateViewId());
        this.c.setBackgroundColor(-1);
        this.q.addView(this.c, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), c()), com.opos.cmn.an.h.f.a.a(getContext(), d())));
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.e = baseTextView;
        baseTextView.setBackgroundResource(R.drawable.opos_mobad_dialog_close_new);
        this.e.setOnClickListener(this.z);
        this.e.setOnTouchListener(this.z);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(3, this.c.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        this.q.addView(this.e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.q, layoutParams2);
        if (this.p) {
            this.b = new com.opos.mobad.template.a.c(getContext(), "#66FFFFFF");
        } else {
            this.f9630a = new com.opos.mobad.template.a.b(getContext());
        }
        if (this.l == 1) {
            this.f = new v(getContext(), this.p, this.o);
        } else if (this.p || (i = this.m) == 8 || i == 9) {
            this.h = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.o);
        } else {
            this.g = com.opos.mobad.template.a.g.b(getContext(), this.o);
        }
        f();
        this.e.setVisibility(4);
        this.c.setVisibility(4);
    }

    private void f() {
        this.r = new RelativeLayout(getContext());
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(getContext());
        this.i = wVar;
        wVar.a();
        this.i.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.i.setId(View.generateViewId());
        this.i.setBackgroundColor(-1);
        this.i.setVisibility(0);
        this.r.addView(this.i, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), s), com.opos.cmn.an.h.f.a.a(getContext(), t)));
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.j = baseTextView;
        baseTextView.setVisibility(0);
        this.j.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.j.setOnClickListener(this.z);
        this.j.setOnTouchListener(this.z);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(3, this.i.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        this.r.addView(this.j, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.r.setVisibility(4);
        addView(this.r, layoutParams2);
    }

    private void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.v = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.v.setDuration(250L);
        this.v.start();
    }

    public u(Context context, boolean z, com.opos.mobad.d.a aVar, boolean z2, int i) {
        super(context);
        this.p = false;
        this.z = new AnonymousClass2();
        this.o = aVar;
        this.p = z2;
        this.l = z ? 1 : 0;
        this.m = i;
        e();
    }

    @Override // com.opos.mobad.template.f.e
    public ViewGroup a() {
        return this;
    }

    @Override // com.opos.mobad.template.f.e
    public void b() {
        AnimatorSet animatorSet = this.v;
        if (animatorSet != null) {
            animatorSet.end();
        }
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        AnimatorSet animatorSet2 = this.x;
        if (animatorSet2 != null) {
            animatorSet2.end();
        }
        AnimatorSet animatorSet3 = this.y;
        if (animatorSet3 != null) {
            animatorSet3.end();
        }
    }

    private void b(View view) {
        if (indexOfChild(view) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            addView(view, layoutParams);
        }
    }

    private void c(View view) {
        if (indexOfChild(view) < 0) {
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            View view2 = new View(getContext());
            view2.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.addRule(2, view2.getId());
            view.setVisibility(4);
            addView(view2, layoutParams);
            addView(view, layoutParams2);
        }
    }

    @Override // com.opos.mobad.template.f.e
    public void a(View view) {
        if (view == null) {
            return;
        }
        this.d = view;
        if (this.c.indexOfChild(view) < 0) {
            this.c.removeAllViews();
            this.c.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.template.f.e
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.n = interfaceC0778a;
        com.opos.mobad.template.a.b bVar = this.f9630a;
        if (bVar != null) {
            bVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.a.c cVar = this.b;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.a aVar) {
        String str;
        com.opos.mobad.template.a.c cVar = this.b;
        if (cVar != null) {
            c(cVar);
        }
        if (aVar == null) {
            str = "app info is null";
        } else {
            if (this.u == null) {
                String str2 = aVar.f9412a;
                String str3 = aVar.b;
                com.opos.mobad.template.a.b bVar = this.f9630a;
                if (bVar != null) {
                    b(bVar);
                    this.f9630a.a(0, str2, str3);
                }
                if (this.b == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    return;
                }
                this.b.setVisibility(0);
                this.b.a(str2, str3);
                return;
            }
            str = "app info has render";
        }
        com.opos.cmn.an.f.a.b("InterstitialViewFrame", str);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        int i;
        if (this.l == 1) {
            if (indexOfChild(this.f) < 0) {
                int iA = com.opos.cmn.an.h.f.a.a(getContext(), 49.0f);
                View view = new View(getContext());
                view.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA);
                layoutParams.addRule(10);
                layoutParams.addRule(14);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams2.addRule(14);
                layoutParams2.addRule(3, view.getId());
                addView(view, layoutParams);
                addView(this.f, layoutParams2);
                this.f.a(this.n);
                this.f.bringToFront();
            }
            if (this.p) {
                this.f.a(bVar.p, bVar.A, bVar.q, bVar.e, bVar.g, bVar.i);
                return;
            } else {
                this.f.a(bVar.p, bVar.A, bVar.q, bVar.e, bVar.f, bVar.i);
                return;
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        if (this.p || (i = this.m) == 8 || i == 9) {
            if (this.c.indexOfChild(this.h) < 0) {
                this.h.a(this.n);
                this.c.addView(this.h, layoutParams3);
                this.h.bringToFront();
            }
            this.h.a(bVar.p, bVar.e, bVar.g, bVar.i);
            return;
        }
        if (this.c.indexOfChild(this.g) < 0) {
            this.g.a(this.n);
            this.c.addView(this.g, layoutParams3);
            this.g.bringToFront();
        }
        this.g.a(bVar.p, bVar.e, bVar.f, bVar.i);
    }

    @Override // com.opos.mobad.template.f.e
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.d("", "render builder with data null");
            a.InterfaceC0778a interfaceC0778a = this.n;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
                return;
            }
            return;
        }
        com.opos.mobad.template.d.b bVarB = this.l == 1 ? fVar.b() : fVar.a();
        if (bVarB == null) {
            com.opos.cmn.an.f.a.d("InterstitialViewFrame", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.n;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        BaseTextView baseTextView = this.e;
        if (baseTextView != null && baseTextView.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.c;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.c.setVisibility(0);
        }
        a(bVarB.u);
        a(bVarB);
        if (this.u == null) {
            g();
        }
        this.u = bVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        this.w = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.w.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.w.setDuration(150L);
        this.w.start();
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.f.u.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                u.this.w.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.u.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }
}

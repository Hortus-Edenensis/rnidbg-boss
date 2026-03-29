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
public class r extends com.opos.mobad.template.cmn.baseview.c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a.b f9592a;
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
    private int q;
    private RelativeLayout r;
    private RelativeLayout s;
    private com.opos.mobad.template.d.b t;
    private AnimatorSet u;
    private ObjectAnimator v;
    private AnimatorSet w;
    private AnimatorSet x;
    private com.opos.mobad.template.cmn.p y;

    /* JADX INFO: renamed from: com.opos.mobad.template.f.r$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 extends com.opos.mobad.template.cmn.p {
        public AnonymousClass2() {
        }

        @Override // com.opos.mobad.template.cmn.p
        public void b(final View view, final int[] iArr) {
            if (!"1".equals((r.this.t == null || !r.this.t.J.containsKey("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI")) ? "0" : r.this.t.J.get("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI"))) {
                r.this.a(new a() { // from class: com.opos.mobad.template.f.r.2.1
                    @Override // com.opos.mobad.template.f.r.a
                    public void a() {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.r.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (r.this.n != null) {
                                    a.InterfaceC0778a interfaceC0778a = r.this.n;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    interfaceC0778a.e(view, iArr);
                                }
                            }
                        });
                    }
                });
            } else if (r.this.n != null) {
                r.this.n.e(view, iArr);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public r(Context context, int i, int i2, com.opos.mobad.d.a aVar, boolean z) {
        super(context);
        this.p = false;
        this.y = new AnonymousClass2();
        this.o = aVar;
        this.l = i;
        this.m = i2;
        this.p = z;
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int c() {
        int i = this.q;
        int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME;
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
        if (i == 12) {
            return this.l == 1 ? MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME : MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
        }
        int i4 = this.m;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return 0;
                    }
                } else if (this.l != 1) {
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
                }
            } else if (this.l != 1) {
            }
            return i2;
        }
        if (this.l == 1) {
            i3 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int d() {
        int i = this.q;
        int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
        if (i == 12) {
            if (this.l == 1) {
                return MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE;
            }
            return 400;
        }
        int i3 = this.m;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return 0;
                    }
                } else if (this.l != 1) {
                    i2 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME;
                }
            } else if (this.l != 1) {
            }
            return i2;
        }
        if (this.l == 1) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC;
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
        this.r = new RelativeLayout(getContext());
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(getContext());
        this.c = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.c.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), c()), com.opos.cmn.an.h.f.a.a(getContext(), d()));
        if (this.l == 1) {
            layoutParams.addRule(13);
            addView(this.c, layoutParams);
        } else {
            this.r.addView(this.c, layoutParams);
        }
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.e = baseTextView;
        baseTextView.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.e.setOnClickListener(this.y);
        this.e.setOnTouchListener(this.y);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        if (this.l == 1) {
            layoutParams2.addRule(1, this.c.getId());
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
            addView(this.e, layoutParams2);
        } else {
            layoutParams2.addRule(3, this.c.getId());
            layoutParams2.addRule(14);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
            this.r.addView(this.e, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            addView(this.r, layoutParams3);
        }
        if (this.p) {
            this.b = new com.opos.mobad.template.a.c(getContext(), "#66FFFFFF");
        } else {
            this.f9592a = new com.opos.mobad.template.a.b(getContext());
        }
        if (this.m == 1) {
            this.f = new v(getContext(), this.p, this.o);
        } else if (this.p || (i = this.q) == 8 || i == 9) {
            this.h = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.o);
        } else {
            this.g = com.opos.mobad.template.a.g.b(getContext(), this.o);
        }
        f();
        this.e.setVisibility(4);
        this.c.setVisibility(4);
    }

    private void f() {
        int i = this.l;
        int i2 = i == 0 ? MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME : 489;
        int i3 = i == 0 ? MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID : MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME;
        this.s = new RelativeLayout(getContext());
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(getContext());
        this.i = wVar;
        wVar.a();
        this.i.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.i.setId(View.generateViewId());
        this.i.setBackgroundColor(-1);
        this.i.setVisibility(0);
        this.s.addView(this.i, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), i2), com.opos.cmn.an.h.f.a.a(getContext(), i3)));
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.j = baseTextView;
        baseTextView.setVisibility(0);
        this.j.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.j.setOnClickListener(this.y);
        this.j.setOnTouchListener(this.y);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        if (this.l == 1) {
            layoutParams.addRule(1, this.i.getId());
            layoutParams.addRule(15);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        } else {
            layoutParams.addRule(3, this.i.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        this.s.addView(this.j, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.s.setVisibility(4);
        addView(this.s, layoutParams2);
    }

    private void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.u = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.u.setDuration(250L);
        this.u.start();
    }

    public r(Context context, int i, boolean z, com.opos.mobad.d.a aVar, boolean z2, int i2) {
        super(context);
        this.p = false;
        this.y = new AnonymousClass2();
        this.o = aVar;
        this.l = i;
        this.m = z ? 1 : 0;
        this.p = z2;
        this.q = i2;
        e();
    }

    @Override // com.opos.mobad.template.f.e
    public ViewGroup a() {
        return this;
    }

    @Override // com.opos.mobad.template.f.e
    public void b() {
        AnimatorSet animatorSet = this.u;
        if (animatorSet != null) {
            animatorSet.end();
        }
        ObjectAnimator objectAnimator = this.v;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        AnimatorSet animatorSet2 = this.w;
        if (animatorSet2 != null) {
            animatorSet2.end();
        }
        AnimatorSet animatorSet3 = this.x;
        if (animatorSet3 != null) {
            animatorSet3.end();
        }
    }

    private void b(View view) {
        if (indexOfChild(view) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
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
        com.opos.mobad.template.a.b bVar = this.f9592a;
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
            if (this.t == null) {
                String str2 = aVar.f9412a;
                String str3 = aVar.b;
                com.opos.mobad.template.a.b bVar = this.f9592a;
                if (bVar != null) {
                    b(bVar);
                    this.f9592a.a(this.l, str2, str3);
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
        if (this.m == 1) {
            if (indexOfChild(this.f) < 0) {
                this.f.a(this.n);
                if (this.l == 1) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.c(getContext()) - com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                    layoutParams.addRule(10);
                    layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
                    addView(this.f, layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                    layoutParams2.addRule(10);
                    layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 38.0f);
                    addView(this.f, layoutParams2);
                }
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
        if (this.p || (i = this.q) == 8 || i == 9) {
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
        com.opos.mobad.template.d.b bVarB = this.m == 1 ? fVar.b() : fVar.a();
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
        if (this.t == null) {
            g();
        }
        this.t = bVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        this.v = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.v.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.v.setDuration(150L);
        this.v.start();
        this.v.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.f.r.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                r.this.v.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.r.1.1
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

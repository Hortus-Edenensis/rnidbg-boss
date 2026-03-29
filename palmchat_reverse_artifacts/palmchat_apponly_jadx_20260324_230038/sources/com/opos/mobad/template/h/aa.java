package com.opos.mobad.template.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class aa extends com.opos.mobad.template.j.a {
    private com.opos.mobad.template.cmn.w A;
    private RelativeLayout B;
    private AnimatorSet C;
    private AnimatorSet D;
    private ViewTreeObserver.OnPreDrawListener E;
    private int F;
    private Runnable G;
    private j.b H;
    private com.opos.mobad.template.cmn.q I;
    private com.opos.mobad.template.cmn.p J;
    private com.opos.mobad.template.cmn.baseview.f K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected u f9906a;
    protected z b;
    boolean c;
    private com.opos.mobad.template.cmn.baseview.c g;
    private Context h;
    private com.opos.mobad.d.a i;
    private com.opos.mobad.template.d.b j;
    private com.opos.mobad.d.e.a k;
    private Handler l;
    private RelativeLayout m;
    private RelativeLayout.LayoutParams n;
    private RelativeLayout o;
    private TextView p;
    private boolean q;
    private int r;
    private boolean s;
    private com.opos.mobad.template.cmn.y t;
    private TextView u;
    private TextView v;
    private com.opos.mobad.template.cmn.z w;
    private ImageView x;
    private ImageView y;
    private LinearLayout z;

    private aa(Context context, int i, boolean z, com.opos.mobad.d.a aVar) {
        super(i);
        this.q = false;
        this.r = 0;
        this.c = false;
        this.G = new Runnable() { // from class: com.opos.mobad.template.h.aa.9
            @Override // java.lang.Runnable
            public void run() {
                if (aa.this.n() == 8) {
                    return;
                }
                if (aa.this.r == 3) {
                    aa aaVar = aa.this;
                    if (!aaVar.c) {
                        aaVar.q();
                    }
                }
                aa.this.a(r0.r);
                aa.i(aa.this);
                aa.this.l.postDelayed(this, 1000L);
                com.opos.cmn.an.f.a.b("RewardTrialGameTemplate", "countTime=", Integer.valueOf(aa.this.r));
                aa aaVar2 = aa.this;
                if (aaVar2.c && aaVar2.q) {
                    aa.this.l.removeCallbacks(aa.this.G);
                }
            }
        };
        this.H = new j.b() { // from class: com.opos.mobad.template.h.aa.12
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return aa.this.s();
            }
        };
        this.I = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.aa.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                aa.this.g(view, iArr);
            }
        };
        this.J = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.aa.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                aa aaVar = aa.this;
                if (aaVar.c) {
                    aaVar.h(view, iArr);
                } else {
                    aaVar.q();
                }
            }
        };
        this.K = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.aa.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.b("RewardTrialGameTemplate", "onMockEventIntercepted->clickMockEvent:", Integer.valueOf(i2), ";disAllowClick:", Boolean.valueOf(z2), ";view:", view.getClass().getName());
                aa.this.a(view, i2, z2);
            }
        };
        this.h = context.getApplicationContext();
        this.l = new Handler(Looper.getMainLooper());
        this.i = aVar;
        this.s = z;
        i();
    }

    public static com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return null;
        }
        return new aa(context, i, true, aVar);
    }

    public static com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return null;
        }
        return new aa(context, i, false, aVar);
    }

    public static /* synthetic */ int i(aa aaVar) {
        int i = aaVar.r;
        aaVar.r = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.c = true;
        int width = this.w.getWidth() - com.opos.cmn.an.h.f.a.a(this.h, 96.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "alpha", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.A, "alpha", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.x, "alpha", 1.0f, 0.808f, 0.616f, 0.424f, 0.232f, 0.04f, 0.04f, 0.04f, 0.04f, 0.04f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.y, "alpha", 0.04f, 0.04f, 0.04f, 0.04f, 0.04f, 0.04f, 0.28f, 0.52f, 0.76f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.w, "translationX", width, 0.0f);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.C = animatorSet;
        animatorSet.setInterpolator(interpolatorCreate);
        this.C.setDuration(450L);
        this.C.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat3, objectAnimatorOfFloat5);
        this.C.start();
    }

    private void r() {
        Context context;
        float f;
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.h);
        this.f9906a = u.a(this.h);
        this.b = z.a(this.h);
        int iA = com.opos.cmn.an.h.f.a.a(this.h, 28.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
        if (this.s) {
            context = this.h;
            f = 77.0f;
        } else {
            context = this.h;
            f = 44.0f;
        }
        int iA3 = com.opos.cmn.an.h.f.a.a(context, f);
        LinearLayout linearLayout = new LinearLayout(this.h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = iA2;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f9906a, new LinearLayout.LayoutParams(-2, iA));
        this.b.setId(View.generateViewId());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        layoutParams2.gravity = 80;
        layoutParams2.rightMargin = iA2;
        bVar.addView(linearLayout, layoutParams);
        bVar.addView(this.b, layoutParams2);
        bVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, iA3));
        this.o.addView(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        return n() == 8;
    }

    private void t() {
        if (this.k == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.h);
            this.k = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.aa.10
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (aa.this.j != null && z) {
                        aa.this.c(0);
                        aa.this.a((Map<String, String>) null);
                        aa.this.l.postDelayed(aa.this.G, 10L);
                        aa.this.k.a((a.InterfaceC0735a) null);
                    }
                }
            });
            this.k.a(new a.c() { // from class: com.opos.mobad.template.h.aa.11
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardTrialGameTemplate", "onViewVisibleWithoutFocus: ", Boolean.valueOf(z), ", ", Boolean.valueOf(z2));
                    if (aa.this.j == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    aa.this.b(map);
                }
            }, c());
        }
        if (this.o.indexOfChild(this.k) < 0) {
            this.o.addView(this.k, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.g;
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (this.i == null) {
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.h, 50.0f);
        com.opos.mobad.template.d.e eVar = bVar.k;
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, iA, iA, this.i, new j.a() { // from class: com.opos.mobad.template.h.aa.13
            @Override // com.opos.mobad.template.cmn.j.a
            public void a(int i, Bitmap bitmap) {
                if (i != 1) {
                    aa.this.a(bitmap);
                }
                aa.this.b(i);
            }

            @Override // com.opos.mobad.template.cmn.j.a
            public void a(Bitmap bitmap) {
                aa.this.a(bitmap);
            }
        }, this.H);
    }

    private void i() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.h);
        this.g = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.setForceDarkAllowed(false);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        this.o = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.g.addView(this.o);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.h);
        this.m = relativeLayout2;
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.o.addView(this.m);
        r();
        p();
    }

    private void p() {
        int iA;
        int iA2 = com.opos.cmn.an.h.f.a.a(this.h, 74.0f);
        int iA3 = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
        int iA4 = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        com.opos.mobad.template.cmn.z zVar = new com.opos.mobad.template.cmn.z(this.h);
        this.w = zVar;
        zVar.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        if (this.s) {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.h, 88.0f);
            iA = com.opos.cmn.an.h.f.a.b(this.h) - com.opos.cmn.an.h.f.a.a(this.h, 24.0f);
        } else {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.h, 60.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.h, 360.0f);
        }
        this.F = iA;
        this.w.b(this.F);
        this.o.addView(this.w, layoutParams);
        this.w.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.opos.mobad.template.h.aa.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                aa.this.w.removeOnLayoutChangeListener(this);
                aa.this.c(0);
            }
        });
        this.w.setPadding(com.opos.cmn.an.h.f.a.a(this.h, 2.0f), 0, iA3, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = iA4;
        gradientDrawable.setCornerRadii(new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f});
        gradientDrawable.setColor(Color.argb(255, 255, 255, 255));
        this.w.setBackground(gradientDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        this.B = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.w.addView(this.B, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.h, 24.0f), -1));
        int iA5 = com.opos.cmn.an.h.f.a.a(this.h, 24.0f);
        ImageView imageView = new ImageView(this.h);
        this.x = imageView;
        imageView.setId(View.generateViewId());
        this.x.setScaleType(ImageView.ScaleType.FIT_XY);
        this.x.setBackgroundResource(R.drawable.opos_mobad_game_open);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA5, iA5);
        layoutParams2.addRule(15);
        this.B.addView(this.x, layoutParams2);
        ImageView imageView2 = new ImageView(this.h);
        this.y = imageView2;
        imageView2.setId(View.generateViewId());
        this.y.setScaleType(ImageView.ScaleType.FIT_XY);
        this.y.setBackgroundResource(R.drawable.opos_mobad_game_close);
        this.y.setAlpha(0.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA5, iA5);
        layoutParams3.addRule(15);
        this.B.addView(this.y, layoutParams3);
        int iA6 = com.opos.cmn.an.h.f.a.a(this.h, 50.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.h, com.opos.cmn.an.h.f.a.a(r12, 12.0f));
        this.t = nVar;
        nVar.setId(View.generateViewId());
        this.t.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA6, iA6);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        layoutParams4.addRule(1, this.B.getId());
        layoutParams4.addRule(15);
        this.w.addView(this.t, layoutParams4);
        LinearLayout linearLayout = new LinearLayout(this.h);
        this.z = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.z.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.t.getId());
        this.w.addView(this.z, layoutParams5);
        TextView textView = new TextView(this.h);
        this.p = textView;
        textView.setTextColor(Color.argb(255, 0, 0, 0));
        this.p.setTextSize(1, 16.0f);
        this.p.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.p.setSingleLine(true);
        com.opos.mobad.template.h.a(this.p);
        this.z.addView(this.p, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.h);
        this.v = textView2;
        textView2.setTextColor(Color.argb(255, 102, 102, 102));
        this.v.setTextSize(1, 12.0f);
        this.v.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.v.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 2.0f);
        this.z.addView(this.v, layoutParams6);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.h);
        this.A = wVar;
        wVar.setId(View.generateViewId());
        TextView textView3 = new TextView(this.h);
        this.u = textView3;
        textView3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        this.u.setTextColor(-1);
        this.u.setTextSize(1, 14.0f);
        com.opos.mobad.template.h.a(this.u);
        this.u.setText("前往");
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13);
        this.A.a(90.0f);
        this.A.addView(this.u, layoutParams7);
        this.A.setBackgroundColor(Color.argb(255, 0, 102, 255));
        com.opos.mobad.template.cmn.p.a(this.A, this.I);
        this.A.a(this.K);
        int iA7 = com.opos.cmn.an.h.f.a.a(this.h, 52.0f);
        int iA8 = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(iA7, com.opos.cmn.an.h.f.a.a(this.h, 28.0f));
        layoutParams8.setMarginStart(iA8);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, this.z.getId());
        this.w.addView(this.A, layoutParams8);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.template.h.aa.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa aaVar = aa.this;
                if (aaVar.c) {
                    aaVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME);
                } else {
                    aaVar.q();
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.w, this.J);
        this.w.a(this.K);
        if (this.E == null) {
            this.E = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.h.aa.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (aa.this.n() != 8 && aa.this.w != null && aa.this.A != null && aa.this.z != null) {
                        try {
                            if (aa.this.w.getWidth() == aa.this.F) {
                                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) aa.this.A.getLayoutParams();
                                layoutParams9.removeRule(1);
                                layoutParams9.addRule(11);
                                aa.this.w.updateViewLayout(aa.this.A, layoutParams9);
                                RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) aa.this.z.getLayoutParams();
                                layoutParams10.addRule(0, aa.this.A.getId());
                                aa.this.w.updateViewLayout(aa.this.z, layoutParams10);
                                if (aa.this.w != null && aa.this.E != null && aa.this.w.getViewTreeObserver().isAlive()) {
                                    aa.this.w.getViewTreeObserver().removeOnPreDrawListener(aa.this.E);
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("RewardTrialGameTemplate", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            com.opos.mobad.template.cmn.z zVar2 = this.w;
            if (zVar2 == null || !zVar2.getViewTreeObserver().isAlive()) {
                return;
            }
            this.w.getViewTreeObserver().addOnPreDrawListener(this.E);
        }
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        return false;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        this.j = null;
        AnimatorSet animatorSet = this.C;
        if (animatorSet != null) {
            com.opos.mobad.template.h.a(animatorSet);
        }
        AnimatorSet animatorSet2 = this.D;
        if (animatorSet2 != null) {
            com.opos.mobad.template.h.a(animatorSet2);
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacks(this.G);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.g;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.b bVar = this.j;
        if (bVar == null || this.q) {
            return;
        }
        long j2 = bVar.C;
        if (j2 <= 0 || j * 1000 >= j2) {
            this.q = true;
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        this.c = false;
        int width = this.w.getWidth() - com.opos.cmn.an.h.f.a.a(this.h, 96.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.A, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.y, "alpha", 1.0f, 0.808f, 0.616f, 0.424f, 0.232f, 0.04f, 0.04f, 0.04f, 0.04f, 0.04f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.x, "alpha", 0.04f, 0.04f, 0.04f, 0.04f, 0.04f, 0.04f, 0.28f, 0.52f, 0.76f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.w, "translationX", 0.0f, width);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.D = animatorSet;
        animatorSet.setInterpolator(interpolatorCreate);
        this.D.setDuration(i);
        this.D.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        this.D.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.h.aa.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (aa.this.w.getVisibility() != 0) {
                    aa.this.w.setVisibility(0);
                    aa.this.D.removeAllListeners();
                }
            }
        });
        this.D.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.aa.2
            @Override // java.lang.Runnable
            public void run() {
                if (aa.this.s() || aa.this.t == null) {
                    return;
                }
                aa.this.t.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.b.a(this.e);
        this.f9906a.a(this.e);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            b(bVar);
            if (this.p != null && !TextUtils.isEmpty(bVar.b)) {
                this.p.setText(bVar.b);
            }
            if (this.v != null && !TextUtils.isEmpty(bVar.f9413a)) {
                this.v.setText(bVar.f9413a);
            }
            u uVar = this.f9906a;
            if (uVar != null) {
                uVar.a(bVar.q, bVar.B);
            }
            z zVar = this.b;
            if (zVar != null) {
                zVar.a(bVar.A);
            }
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.c("RewardTrialGameTemplate", "data is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.c("", "adShowData is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.e eVar = bVarA.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            com.opos.cmn.an.f.a.c("RewardTrialGameTemplate", "icon is null");
            a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("RewardTrialGameTemplate", "render");
        if (this.j == null && this.e != null) {
            m();
            t();
        }
        if (bVarA.M != null && this.n == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.n = layoutParams;
            this.m.addView(bVarA.M, layoutParams);
        }
        a(bVarA);
        this.j = bVarA;
    }
}

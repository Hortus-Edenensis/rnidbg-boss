package com.opos.mobad.template.e.c.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.h;
import com.opos.mobad.template.cmn.r;
import com.opos.mobad.template.k.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends com.opos.mobad.template.e.c.a implements d.a {
    private TextView A;
    private LinearLayout B;
    private ImageView C;
    private AnimatorSet D;
    private AnimatorSet E;
    private com.opos.mobad.template.e.c.b F;
    private Animator G;
    private int H;
    private int I;
    private int J;
    private int K;
    private double L;
    private com.opos.mobad.template.k.d M;
    private final View.OnTouchListener N;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private RelativeLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private h t;
    private RelativeLayout u;
    private r v;
    private r w;
    private ImageView x;
    private ImageView y;
    private TextView z;

    public c(Context context, boolean z, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.o = false;
        this.N = new View.OnTouchListener() { // from class: com.opos.mobad.template.e.c.d.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float f = c.this.f / 2.0f;
                float f2 = c.this.g / 2.0f;
                float f3 = c.this.f / 2.0f;
                float f4 = c.this.g / 2.0f;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f5 = (c.this.f - c.this.j) / 2.0f;
                if (motionEvent.getAction() == 0) {
                    if (!c.this.a(x + f5, y, f3, f4, f, f2)) {
                        return false;
                    }
                    c.this.H = (int) motionEvent.getX();
                    c.this.I = (int) motionEvent.getY();
                    c.this.p = false;
                } else if (2 == motionEvent.getAction()) {
                    int y2 = (int) motionEvent.getY();
                    int x2 = (int) motionEvent.getX();
                    if (y2 <= 0 && !c.this.p) {
                        c.this.a(x2, y2);
                    }
                } else if (1 == motionEvent.getAction()) {
                    c.this.J = (int) motionEvent.getX();
                    c.this.K = (int) motionEvent.getY();
                    if ((c.this.H == c.this.J && c.this.I == c.this.K) || (c.this.I - c.this.K > c.this.L && !c.this.p)) {
                        c cVar = c.this;
                        cVar.a(cVar.J, c.this.K);
                    }
                }
                return true;
            }
        };
        this.n = z;
        k();
        a();
        b();
    }

    private void l() {
        this.G = ae.g(this.C);
        this.D = new AnimatorSet();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.t, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.15f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.15f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.v, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.15f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.15f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.t, PropertyValuesHolder.ofFloat("scaleX", 1.15f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.15f, 1.0f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(this.v, PropertyValuesHolder.ofFloat("scaleX", 1.15f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.15f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(1700L);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.38f, 0.0f, 0.1f, 1.0f));
        animatorSet2.playTogether(objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4);
        this.D.playSequentially(animatorSet, animatorSet2);
        this.D.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.c.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.D.start();
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
        });
        this.E = new AnimatorSet();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder(this.x, PropertyValuesHolder.ofFloat("translationY", 0.0f, -com.opos.cmn.an.h.f.a.a(this.b, 8.0f)), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.38f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder6 = ObjectAnimator.ofPropertyValuesHolder(this.y, PropertyValuesHolder.ofFloat("translationY", 0.0f, -com.opos.cmn.an.h.f.a.a(this.b, 10.0f)), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.47f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder7 = ObjectAnimator.ofPropertyValuesHolder(this.x, PropertyValuesHolder.ofFloat("translationY", -com.opos.cmn.an.h.f.a.a(this.b, 8.0f), 0.0f), PropertyValuesHolder.ofFloat("alpha", 0.38f, 1.0f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder8 = ObjectAnimator.ofPropertyValuesHolder(this.y, PropertyValuesHolder.ofFloat("translationY", -com.opos.cmn.an.h.f.a.a(this.b, 10.0f), 0.0f), PropertyValuesHolder.ofFloat("alpha", 0.47f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(700L);
        animatorSet3.playTogether(objectAnimatorOfPropertyValuesHolder5, objectAnimatorOfPropertyValuesHolder6);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.setDuration(1300L);
        animatorSet4.playTogether(objectAnimatorOfPropertyValuesHolder7, objectAnimatorOfPropertyValuesHolder8);
        this.E.setInterpolator(new LinearInterpolator());
        this.E.playSequentially(animatorSet3, animatorSet4);
        this.E.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.d.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.E.start();
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
        });
    }

    private void k() {
        int iB;
        if (this.n) {
            this.c = com.opos.cmn.an.h.f.a.a(this.b, 542.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.b, 246.0f);
            this.e = com.opos.cmn.an.h.f.a.a(this.b, 62.0f);
            this.f = com.opos.cmn.an.h.f.a.a(this.b, 498.0f);
            this.g = com.opos.cmn.an.h.f.a.a(this.b, 226.0f);
            this.h = com.opos.cmn.an.h.f.a.a(this.b, 52.0f);
            this.i = com.opos.cmn.an.h.f.a.a(this.b, 174.0f);
            this.j = com.opos.cmn.an.h.f.a.b(this.b);
            iB = com.opos.cmn.an.h.f.a.c(this.b);
        } else {
            this.c = com.opos.cmn.an.h.f.a.a(this.b, 1154.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.b, 452.0f);
            this.e = com.opos.cmn.an.h.f.a.a(this.b, 272.0f);
            this.f = com.opos.cmn.an.h.f.a.a(this.b, 1063.0f);
            this.g = com.opos.cmn.an.h.f.a.a(this.b, 416.0f);
            this.h = com.opos.cmn.an.h.f.a.a(this.b, 254.0f);
            this.i = com.opos.cmn.an.h.f.a.a(this.b, 162.0f);
            this.j = com.opos.cmn.an.h.f.a.c(this.b);
            iB = com.opos.cmn.an.h.f.a.b(this.b);
        }
        this.k = iB;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.m;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.l) {
            this.D.start();
            this.E.start();
        }
        if (this.m) {
            if (this.l) {
                this.G.start();
            }
            this.M.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        if (this.m) {
            this.M.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.m) {
            this.M.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        com.opos.mobad.template.h.a(this.D);
        com.opos.mobad.template.h.a(this.E);
        com.opos.mobad.template.h.a(this.G);
        com.opos.mobad.template.k.d dVar = this.M;
        if (dVar != null) {
            dVar.d();
        }
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.l = com.opos.mobad.template.h.a();
        this.m = com.opos.mobad.template.h.a(this.b);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.q = relativeLayout;
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.r = new RelativeLayout(this.b);
        this.q.addView(this.r, new RelativeLayout.LayoutParams(-1, -1));
        this.q.setVisibility(4);
        this.s = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = -this.e;
        this.r.addView(this.s, layoutParams);
        this.t = new h(this.b, new int[]{1308622847, 1308622847}).b(this.c / 2.0f).c(this.d / 2.0f).a(com.opos.cmn.an.h.f.a.a(this.b, 1.0f)).a(Paint.Style.STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.c, this.d);
        layoutParams2.addRule(12);
        this.s.addView(this.t, layoutParams2);
        this.u = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.bottomMargin = -this.h;
        this.r.addView(this.u, layoutParams3);
        this.v = new r(this.b, 1291845632, this.f / 2.0f, this.g / 2.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f, this.g);
        layoutParams4.addRule(12);
        this.u.addView(this.v, layoutParams4);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.bottomMargin = -this.h;
        this.r.addView(relativeLayout2, layoutParams5);
        this.w = new r(this.b, 0, this.f / 2.0f, this.g / 2.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(this.f, this.g);
        layoutParams6.addRule(12);
        this.w.setOnTouchListener(this.N);
        this.u.addView(this.w, layoutParams6);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.b);
        relativeLayout3.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, this.i);
        layoutParams7.addRule(12);
        this.r.addView(relativeLayout3, layoutParams7);
        ImageView imageView = new ImageView(this.b);
        this.x = imageView;
        imageView.setBackgroundResource(R.drawable.opos_mobad_triangle_top);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 25.0f), com.opos.cmn.an.h.f.a.a(this.b, 14.0f));
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 20.0f);
        layoutParams8.addRule(14);
        relativeLayout3.addView(this.x, layoutParams8);
        ImageView imageView2 = new ImageView(this.b);
        this.y = imageView2;
        imageView2.setBackgroundResource(R.drawable.opos_mobad_triangle_bottom);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 25.0f), com.opos.cmn.an.h.f.a.a(this.b, 14.0f));
        layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 35.0f);
        layoutParams9.addRule(14);
        relativeLayout3.addView(this.y, layoutParams9);
        TextView textView = new TextView(this.b);
        this.z = textView;
        textView.setTextSize(1, 18.0f);
        this.z.setText("上滑进入");
        this.z.setSingleLine();
        this.z.setLines(1);
        this.z.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        layoutParams10.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 58.0f);
        this.z.setTextColor(-1);
        com.opos.mobad.template.h.a(this.z);
        relativeLayout3.addView(this.z, layoutParams10);
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.B = linearLayout;
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 24.0f));
        layoutParams11.addRule(14);
        layoutParams11.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 96.0f);
        relativeLayout3.addView(this.B, layoutParams11);
        this.C = new ImageView(this.b);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
        layoutParams12.gravity = 16;
        layoutParams12.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        this.C.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.C.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.C.setVisibility(8);
        this.B.addView(this.C, layoutParams12);
        TextView textView2 = new TextView(this.b);
        this.A = textView2;
        textView2.setTextSize(1, 16.0f);
        this.A.setTextColor(-1);
        this.A.setSingleLine();
        this.A.setLines(1);
        this.A.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 16;
        this.B.addView(this.A, layoutParams13);
        this.M = new com.opos.mobad.template.k.d(this.b, false, this);
        if (this.l) {
            l();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int[] iArr = {this.H, this.I, i, i2};
        this.p = true;
        com.opos.mobad.template.e.c.b bVar = this.F;
        if (bVar != null) {
            bVar.b(this.w, iArr);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.w.a(fVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        TextView textView;
        String str;
        TextView textView2;
        StringBuilder sb;
        String str2;
        if (aVar != null) {
            if (this.m) {
                if (TextUtils.isEmpty(aVar.b) || !aVar.b.contains("点击")) {
                    textView2 = this.A;
                    sb = new StringBuilder();
                    str2 = "摇动或点击";
                } else {
                    textView2 = this.A;
                    sb = new StringBuilder();
                    str2 = "摇动或";
                }
                sb.append(str2);
                sb.append(aVar.b);
                textView2.setText(sb.toString());
                this.C.setVisibility(0);
            } else {
                if (TextUtils.isEmpty(aVar.b) || !aVar.b.contains("点击")) {
                    textView = this.A;
                    str = "点击" + aVar.b;
                } else {
                    textView = this.A;
                    str = aVar.b;
                }
                textView.setText(str);
            }
            if (aVar instanceof com.opos.mobad.template.e.b.d) {
                com.opos.mobad.template.k.d dVar = this.M;
                if (dVar != null) {
                    dVar.a(aVar);
                }
                this.L = com.opos.cmn.an.h.f.a.a(this.b, ((com.opos.mobad.template.e.b.d) aVar).F);
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.c.b bVar) {
        this.F = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        com.opos.mobad.template.e.c.b bVar = this.F;
        if (bVar != null) {
            bVar.a(iArr);
            this.M.c();
        }
    }

    public boolean a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f - f3;
        float f8 = f2 - f4;
        return ((f7 * f7) / (f5 * f5)) + ((f8 * f8) / (f6 * f6)) <= 1.0f;
    }
}

package com.opos.mobad.template.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.n;
import com.opos.mobad.template.cmn.o;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.cmn.x;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {
    private com.opos.mobad.template.cmn.baseview.c A;
    private LinearLayout B;
    private LinearLayout C;
    private RelativeLayout D;
    private o E;
    private com.opos.mobad.template.cmn.baseview.c F;
    private int G;
    private int H;
    private Typeface I;
    private int J;
    private com.opos.mobad.template.e.c.a K;
    private a.InterfaceC0778a L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f9281a;
    private Context c;
    private RelativeLayout d;
    private TextView e;
    private com.opos.mobad.template.cmn.baseview.c f;
    private TextView g;
    private TextView h;
    private TextView i;
    private n j;
    private TextView k;
    private TextView l;
    private w m;
    private TextView n;
    private ImageView o;
    private Animator p;
    private Animator q;
    private Animator r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    p b = new p() { // from class: com.opos.mobad.template.a.e.5
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (e.this.L != null) {
                if (e.this.x) {
                    e.this.L.a(7, (int[]) null);
                } else {
                    e.this.L.a(8, iArr);
                }
            }
        }
    };

    public e(Context context, boolean z) {
        this.c = context;
        this.u = z;
        a();
        b();
    }

    private void h() {
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.B = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.B.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
        this.A.addView(this.B, layoutParams);
    }

    private void i() {
        RelativeLayout.LayoutParams layoutParams;
        int iA;
        int i;
        int i2;
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.C = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.C.setOrientation(1);
        if (this.u) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            iA = com.opos.cmn.an.h.f.a.a(this.c, 30.0f);
            i = 22;
            i2 = 25;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 74.0f));
            iA = com.opos.cmn.an.h.f.a.a(this.c, 20.0f);
            i = 20;
            i2 = 24;
        }
        layoutParams.addRule(10);
        this.C.setGravity(1);
        this.f.addView(this.C, layoutParams);
        TextView textView = new TextView(this.c);
        this.e = textView;
        textView.setTextSize(1, 18.0f);
        this.e.setIncludeFontPadding(false);
        this.e.setText("获得加速机会！");
        this.e.setTextColor(-1678050);
        this.e.setTypeface(this.I);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = iA;
        layoutParams2.gravity = 1;
        this.C.addView(this.e, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 5.0f);
        layoutParams3.gravity = 1;
        this.C.addView(linearLayout2, layoutParams3);
        TextView textView2 = new TextView(this.c);
        this.h = textView2;
        textView2.setText("去看");
        float f = i;
        this.h.setTextSize(1, f);
        this.h.setTextColor(-16777216);
        this.h.setTypeface(Typeface.DEFAULT_BOLD);
        a(this.h);
        linearLayout2.addView(this.h);
        TextView textView3 = new TextView(this.c);
        this.g = textView3;
        textView3.setTextSize(1, i2);
        this.g.setIncludeFontPadding(false);
        this.g.setTextColor(-53504);
        this.g.setTypeface(Typeface.DEFAULT_BOLD);
        this.g.setPadding(com.opos.cmn.an.h.f.a.a(this.c, 2.0f), 0, com.opos.cmn.an.h.f.a.a(this.c, 2.0f), 0);
        a(this.g);
        linearLayout2.addView(this.g);
        TextView textView4 = new TextView(this.c);
        this.i = textView4;
        textView4.setText("可直接拿奖励");
        this.i.setTextSize(1, f);
        this.i.setTextColor(-16777216);
        this.i.setTypeface(Typeface.DEFAULT_BOLD);
        a(this.i);
        linearLayout2.addView(this.i);
    }

    private void j() {
        int iA;
        int i;
        LinearLayout linearLayout;
        int iA2;
        int i2;
        int i3;
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        this.D = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        if (this.u) {
            iA = com.opos.cmn.an.h.f.a.a(this.c, 195.0f);
        } else {
            iA = this.H;
            this.D.setPadding(com.opos.cmn.an.h.f.a.a(this.c, 24.0f), com.opos.cmn.an.h.f.a.a(this.c, 8.0f), com.opos.cmn.an.h.f.a.a(this.c, 24.0f), com.opos.cmn.an.h.f.a.a(this.c, 8.0f));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA);
        layoutParams.addRule(3, this.C.getId());
        layoutParams.addRule(2, this.F.getId());
        this.f.addView(this.D, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.c);
        int i4 = 13;
        if (this.u) {
            ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 195.0f));
            relativeLayout2.setPadding(com.opos.cmn.an.h.f.a.a(this.c, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.c, 24.0f), 0);
            this.D.addView(relativeLayout2, layoutParams2);
        } else {
            ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            o oVar = new o(this.c);
            this.E = oVar;
            oVar.setVerticalScrollBarEnabled(false);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            if (!this.u) {
                this.E.setPadding(0, com.opos.cmn.an.h.f.a.a(this.c, 7.0f), 0, com.opos.cmn.an.h.f.a.a(this.c, 7.0f));
            }
            layoutParams4.addRule(13);
            this.E.setFillViewport(true);
            this.D.addView(this.E, layoutParams4);
            this.E.addView(relativeLayout2, layoutParams3);
        }
        x xVar = new x(this.c);
        xVar.a(com.opos.cmn.an.h.f.a.a(this.c, 12.0f));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        if (this.u) {
            xVar.setOrientation(1);
        } else {
            xVar.setOrientation(0);
            i4 = 15;
        }
        layoutParams5.addRule(i4);
        xVar.setPadding(com.opos.cmn.an.h.f.a.a(this.c, 16.0f), com.opos.cmn.an.h.f.a.a(this.c, 16.0f), com.opos.cmn.an.h.f.a.a(this.c, 16.0f), com.opos.cmn.an.h.f.a.a(this.c, 16.0f));
        xVar.a(com.opos.cmn.an.h.f.a.a(this.c, 1.0f), -8840);
        xVar.setBackgroundColor(-67354);
        relativeLayout2.addView(xVar, layoutParams5);
        this.j = new n(this.c, com.opos.cmn.an.h.f.a.a(r3, 12.0f));
        if (this.u) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 56.0f), com.opos.cmn.an.h.f.a.a(this.c, 56.0f));
            layoutParams6.gravity = 1;
            layoutParams6.bottomMargin = com.opos.cmn.an.h.f.a.a(this.c, 8.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.c, 20.0f);
            xVar.addView(this.j, layoutParams6);
            linearLayout = null;
            i = 18;
            i2 = 26;
            i3 = 14;
        } else {
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 52.0f), com.opos.cmn.an.h.f.a.a(this.c, 52.0f));
            i = 16;
            layoutParams7.gravity = 16;
            layoutParams7.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 8.0f);
            xVar.addView(this.j, layoutParams7);
            linearLayout = new LinearLayout(this.c);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams8.gravity = 16;
            xVar.addView(linearLayout, layoutParams8);
            iA2 = com.opos.cmn.an.h.f.a.a(this.c, 16.0f);
            i2 = 22;
            i3 = 12;
        }
        TextView textView = new TextView(this.c);
        this.l = textView;
        textView.setTextColor(-436207616);
        this.l.setTypeface(this.I);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        if (this.u) {
            layoutParams9.gravity = 1;
        }
        this.l.setTextSize(1, i);
        this.l.setMaxHeight(com.opos.cmn.an.h.f.a.a(this.c, i2));
        this.l.setSingleLine(true);
        this.l.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        TextView textView2 = new TextView(this.c);
        this.k = textView2;
        textView2.setTextColor(-1979711488);
        this.k.setMaxLines(2);
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.gravity = 1;
        this.k.setTextSize(1, i3);
        if (!this.u) {
            linearLayout.addView(this.l, layoutParams9);
            linearLayout.addView(this.k, layoutParams10);
            return;
        }
        layoutParams10.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 2.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            this.k.setLineHeight(iA2);
        }
        xVar.addView(this.l, layoutParams9);
        xVar.addView(this.k, layoutParams10);
    }

    private void k() {
        int iA;
        int iA2;
        Context context;
        float f;
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.c);
        this.F = cVar;
        cVar.setId(View.generateViewId());
        if (this.u) {
            iA = com.opos.cmn.an.h.f.a.a(this.c, 26.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.c, 70.0f);
            context = this.c;
            f = 232.0f;
        } else {
            iA = com.opos.cmn.an.h.f.a.a(this.c, 24.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(this.c, 68.0f);
            context = this.c;
            f = 252.0f;
        }
        int iA3 = com.opos.cmn.an.h.f.a.a(context, f);
        this.F.setPadding(0, 0, 0, iA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA2);
        layoutParams.addRule(12);
        this.f.addView(this.F, layoutParams);
        w wVar = new w(this.c);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.c, 44.0f));
        this.m.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-45224, -64216, -231916, -219372}));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA3, com.opos.cmn.an.h.f.a.a(this.c, 44.0f));
        layoutParams2.addRule(14);
        this.F.addView(this.m, layoutParams2);
        TextView textView = new TextView(this.c);
        this.n = textView;
        textView.setTextColor(-1);
        this.n.setTextSize(1, 16.0f);
        this.n.setText("我要直接拿奖励");
        this.n.setTypeface(this.I);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.m.addView(this.n, layoutParams3);
    }

    private void l() {
        TextView textView = new TextView(this.c);
        textView.setText("点击跳转到详情页或第三方应用");
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-436207617);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.B.addView(textView, layoutParams);
    }

    private void m() {
        if (this.s) {
            Animator animator = this.p;
            if (animator != null) {
                animator.removeAllListeners();
                this.p.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.a.e.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        e.this.p.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                    }
                });
            }
            Animator animator2 = this.q;
            if (animator2 != null) {
                animator2.removeAllListeners();
                this.q.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.a.e.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator3) {
                        e.this.q.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator3) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator3) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator3) {
                    }
                });
            }
            Animator animator3 = this.p;
            if (animator3 != null) {
                animator3.start();
            }
            Animator animator4 = this.r;
            if (animator4 != null) {
                animator4.start();
            }
            Animator animator5 = this.q;
            if (animator5 != null) {
                animator5.start();
            }
        }
    }

    private void n() {
        com.opos.mobad.template.h.a(this.p);
        com.opos.mobad.template.h.a(this.r);
        com.opos.mobad.template.h.a(this.q);
    }

    private void o() {
        this.x = true;
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.i.setText("激励已发放");
        this.n.setText("确认");
        f();
    }

    public void e() {
        com.opos.cmn.an.f.a.b("ECommerceRewardView", "stop() ");
        com.opos.mobad.template.e.c.a aVar = this.K;
        if (aVar != null && (aVar instanceof com.opos.mobad.template.e.c.c.a)) {
            aVar.i();
        }
        n();
    }

    public void g() {
        this.z = true;
        n();
        com.opos.mobad.template.e.c.a aVar = this.K;
        if (aVar != null) {
            aVar.j();
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public void a() {
        this.s = com.opos.mobad.template.h.a();
        this.t = com.opos.mobad.template.h.a(this.c);
    }

    public void b() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        this.d = relativeLayout;
        relativeLayout.setVisibility(4);
        this.d.setClipChildren(false);
        this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.J = com.opos.cmn.an.h.f.a.a(this.c, 32.0f);
        ImageView imageView = new ImageView(this.c);
        this.o = imageView;
        imageView.setImageResource(R.drawable.opos_mobad_light_bg_ecommerce);
        this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 400.0f), com.opos.cmn.an.h.f.a.a(this.c, 400.0f));
        if (this.u) {
            layoutParams2.topMargin = (com.opos.cmn.an.h.f.a.c(this.c) / 2) - com.opos.cmn.an.h.f.a.a(this.c, 241.0f);
        } else {
            layoutParams2.addRule(13);
        }
        this.d.addView(this.o, layoutParams2);
        this.A = new com.opos.mobad.template.cmn.baseview.c(this.c);
        if (this.u) {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 280.0f), com.opos.cmn.an.h.f.a.a(this.c, 382.0f));
        } else {
            int iMin = Math.min(com.opos.cmn.an.h.f.a.b(this.c), com.opos.cmn.an.h.f.a.a(this.c, 290.0f));
            this.G = iMin;
            this.H = iMin - com.opos.cmn.an.h.f.a.a(this.c, 174.0f);
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 300.0f), this.G);
        }
        layoutParams.addRule(13);
        this.d.addView(this.A, layoutParams);
        h();
        w wVar = new w(this.c);
        wVar.a(com.opos.cmn.an.h.f.a.a(this.c, 24.0f));
        wVar.setBackgroundResource(R.drawable.opos_mobad_bg_ecommerce_window);
        RelativeLayout.LayoutParams layoutParams3 = this.u ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 280.0f), com.opos.cmn.an.h.f.a.a(this.c, 350.0f)) : new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 300.0f), this.G - this.J);
        layoutParams3.addRule(2, this.B.getId());
        this.A.addView(wVar, layoutParams3);
        View view = new View(this.c);
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-855710101, 16777215, 16777215}));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 72.0f));
        layoutParams4.addRule(10);
        wVar.addView(view, layoutParams4);
        this.f = new com.opos.mobad.template.cmn.baseview.c(this.c);
        wVar.addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
        this.I = Typeface.create("sans-serif-medium", 0);
        i();
        k();
        j();
        if (this.s) {
            this.p = ae.a(this.g, 1.17f, 350L);
            this.q = ae.a(this.m, 1.03f, 350L);
            this.r = ae.h(this.o);
        }
        a(this.c);
    }

    public View c() {
        return this.d;
    }

    public void d() {
        if (this.v || !this.w) {
            return;
        }
        com.opos.cmn.an.f.a.b("ECommerceRewardView", "start() ");
        com.opos.mobad.template.e.c.a aVar = this.K;
        if (aVar != null && (aVar instanceof com.opos.mobad.template.e.c.c.a)) {
            aVar.h();
        }
        m();
    }

    public void f() {
        this.v = true;
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.a.e.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                e.this.w = z;
                if (!z) {
                    e.this.e();
                    return;
                }
                if (e.this.L != null) {
                    e.this.L.a(a.b.E_COMMERCE_DIALOG_RESUME, (Map<String, String>) null);
                }
                if (e.this.K != null && (e.this.K instanceof com.opos.mobad.template.e.c.c.a)) {
                    e.this.K.h();
                }
                e.this.d();
            }
        });
        this.d.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(2.0f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
        }
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.L = interfaceC0778a;
        p.a(this.m, this.b);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        Context context;
        float f;
        if (this.y) {
            return;
        }
        this.y = true;
        this.j.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            this.j.setBackgroundResource(R.drawable.opos_mobad_icon_null);
            com.opos.cmn.an.f.a.a("ECommerceRewardView", "renderIcon() but iconUrl is null");
            return;
        }
        if (this.u) {
            context = this.c;
            f = 56.0f;
        } else {
            context = this.c;
            f = 52.0f;
        }
        int iA = com.opos.cmn.an.h.f.a.a(context, f);
        aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.a.e.4
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (e.this.z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (e.this.L != null) {
                        e.this.L.c(i);
                    }
                } else {
                    if (i == 1 && e.this.L != null) {
                        e.this.L.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.a.e.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (e.this.z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            e.this.j.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    public void a(com.opos.mobad.template.e.c.a aVar) {
        if (this.f9281a) {
            return;
        }
        this.f9281a = true;
        if (aVar != null) {
            this.K = aVar;
            if ((aVar instanceof com.opos.mobad.template.e.c.c.a) && aVar.e() && aVar.c() != null) {
                this.B.addView(aVar.c(), new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.c, 20.0f)));
            }
        }
        l();
    }

    public void a(String str, com.opos.mobad.template.d.e eVar, String str2, String str3, com.opos.mobad.d.a aVar) {
        this.g.setText(str + "秒");
        this.l.setText(str2);
        this.k.setText(str3);
        a(eVar, aVar);
        if (str.equals("0")) {
            o();
        }
    }
}

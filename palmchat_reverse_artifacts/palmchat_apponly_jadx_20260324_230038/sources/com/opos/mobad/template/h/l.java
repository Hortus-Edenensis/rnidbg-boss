package com.opos.mobad.template.h;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l extends d {
    private LinearLayout A;
    private TextView B;
    private com.opos.mobad.template.k.c C;
    private TextView D;
    private TextView E;
    private com.opos.mobad.template.cmn.w F;
    private final int G;
    private com.opos.mobad.template.cmn.q H;
    private int I;
    private final int[] J;
    private Context f;
    private int g;
    private LinearLayout h;
    private com.opos.mobad.template.cmn.y i;
    private TextView j;
    private com.opos.mobad.template.k.c l;
    private com.opos.mobad.d.a m;
    private LinearLayout n;
    private LinearLayout o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private com.opos.mobad.template.a.c s;
    private com.opos.mobad.template.cmn.w t;
    private LinearLayout u;
    private com.opos.mobad.template.cmn.w v;
    private com.opos.mobad.template.a.c w;
    private LinearLayout x;
    private LinearLayout y;
    private com.opos.mobad.template.cmn.y z;

    public l(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = -16777216;
        this.J = new int[]{1, 4, 7};
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.G = com.opos.cmn.an.h.f.a.a(applicationContext, 44.0f);
        this.m = aVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 280.0f));
        layoutParams.addRule(12);
        setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.f, 30.0f));
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(this.g, 255), ColorUtils.setAlphaComponent(this.g, 255), ColorUtils.setAlphaComponent(this.g, 200), ColorUtils.setAlphaComponent(this.g, 160), ColorUtils.setAlphaComponent(this.g, 0)});
        gradientDrawable.setShape(0);
        setBackground(gradientDrawable);
        k();
        l();
        m();
        n();
        q();
        a(context);
        p();
        o();
        f();
        e();
        g();
        h();
        r();
        i();
        j();
        s();
        d();
    }

    private void d() {
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext());
        this.w = cVar;
        cVar.setGravity(3);
        this.u.addView(this.w, new LinearLayout.LayoutParams(-1, -2));
        this.w.setVisibility(8);
    }

    private void e() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.v = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.f, 16.0f));
        this.v.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 140.0f));
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.v.setLayoutParams(layoutParams);
        this.u.addView(this.v);
        this.v.setVisibility(8);
    }

    private void f() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.u = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 84.0f);
        this.u.setGravity(80);
        addView(this.u, layoutParams);
    }

    private void g() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.x = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.x.setOrientation(0);
        this.x.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.topMargin = iA;
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        this.v.addView(this.x, layoutParams);
    }

    private void h() {
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.f, com.opos.cmn.an.h.f.a.a(r1, 12.0f));
        this.z = nVar;
        nVar.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 52.0f), com.opos.cmn.an.h.f.a.a(this.f, 52.0f)));
        this.z.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        wVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar.addView(this.z);
        wVar.a(com.opos.cmn.an.h.f.a.a(this.f, 12.0f));
        this.x.addView(wVar);
    }

    private LinearLayout i() {
        this.A = new LinearLayout(this.f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 52.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.A.setGravity(16);
        this.A.setLayoutParams(layoutParams);
        this.A.setOrientation(1);
        this.x.addView(this.A);
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.y = linearLayout;
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.y.setOrientation(0);
        this.A.addView(this.y, layoutParams2);
        TextView textView = new TextView(this.f);
        this.B = textView;
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.B.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.B.setTextSize(1, 14.0f);
        this.B.setTextColor(Color.parseColor("#E6000000"));
        this.B.setLines(1);
        this.B.setSingleLine(true);
        this.B.setEllipsize(TextUtils.TruncateAt.END);
        this.y.addView(this.B);
        this.y.addView(this.C);
        return this.A;
    }

    private void j() {
        this.D = new TextView(this.f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 4.0f);
        this.D.setTextSize(1, 14.0f);
        this.D.setLines(1);
        this.D.setGravity(16);
        this.D.setEllipsize(TextUtils.TruncateAt.END);
        this.D.setTextColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.A.addView(this.D, layoutParams);
    }

    private void k() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.h = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 74.0f);
        this.h.setGravity(80);
        addView(this.h, layoutParams);
    }

    private void l() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.n = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.f);
        this.o = linearLayout2;
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.o.setGravity(16);
        this.n.addView(this.o, layoutParams);
        this.h.addView(this.n);
    }

    private void m() {
        this.i = new com.opos.mobad.template.cmn.n(this.f, com.opos.cmn.an.h.f.a.a(r1, 21.0f));
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 42.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.o.addView(this.i, layoutParams);
    }

    private void n() {
        TextView textView = new TextView(this.f);
        this.j = textView;
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.j.setTextColor(-1);
        this.j.setTextSize(1, 14.0f);
        this.j.setLines(1);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.o.addView(this.j, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    private void o() {
        this.s = new com.opos.mobad.template.a.c(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.s.setGravity(3);
        this.q.addView(this.s, layoutParams);
        this.q.setVisibility(4);
        this.q.post(new Runnable() { // from class: com.opos.mobad.template.h.l.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                if (lVar.e) {
                    return;
                }
                lVar.I = lVar.q.getHeight();
                l.this.q.setVisibility(8);
            }
        });
    }

    private void p() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.q = linearLayout;
        linearLayout.setOrientation(1);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.t = wVar;
        wVar.setBackgroundColor(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.G);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        layoutParams.bottomMargin = iA;
        layoutParams.topMargin = iA;
        this.t.setLayoutParams(layoutParams);
        this.t.a(90.0f);
        TextView textView = new TextView(this.f);
        this.r = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        this.r.setTextColor(-1);
        this.r.setTextSize(1, 16.0f);
        TextPaint paint = this.r.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.t.addView(this.r, layoutParams2);
        this.q.addView(this.t);
        this.h.addView(this.q);
    }

    private void q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.m);
        this.l = cVarA;
        this.o.addView(cVarA, layoutParams);
    }

    private void r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 2, 0, this.m);
        this.C = cVarA;
        cVarA.setLayoutParams(layoutParams);
    }

    private void s() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.F = wVar;
        wVar.setBackgroundColor(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.G);
        layoutParams.addRule(3, this.x.getId());
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        this.F.setLayoutParams(layoutParams);
        this.F.a(90.0f);
        TextView textView = new TextView(this.f);
        this.E = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        this.E.setTextColor(-1);
        this.E.setTextSize(1, 16.0f);
        TextPaint paint = this.E.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.F.addView(this.E, layoutParams2);
        this.v.addView(this.F);
    }

    @Override // com.opos.mobad.template.h.d
    public int a(int i) {
        return this.J[i];
    }

    @Override // com.opos.mobad.template.h.d
    public void b() {
        com.opos.mobad.template.cmn.q qVar = this.H;
        if (qVar != null) {
            qVar.a(this.d);
        }
        this.w.setVisibility(0);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.t, "backgroundColor", this.c, this.d);
        objectAnimatorOfInt.setDuration(350L);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void c() {
        com.opos.mobad.template.cmn.q qVar = this.H;
        if (qVar != null) {
            qVar.a(this.d);
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.h, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat.start();
        this.v.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.v, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.v, "translationY", com.opos.cmn.an.h.f.a.a(this.f, 140.0f), 0.0f);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3);
        animatorSet.start();
    }

    @Override // com.opos.mobad.template.h.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.h.clearAnimation();
        this.q.clearAnimation();
        this.n.clearAnimation();
        this.t.clearAnimation();
        this.v.clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // com.opos.mobad.template.h.d
    public void a() {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(interpolatorCreate);
        this.q.setVisibility(0);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        animatorSet.play(ObjectAnimator.ofFloat(this.n, "translationY", r4.getHeight() - iA, 0.0f)).with(ObjectAnimator.ofFloat(this.q, "translationY", this.I, 0.0f));
        animatorSet.start();
    }

    private void a(Context context) {
        this.p = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.p.setTextSize(1, 14.0f);
        this.p.setMaxLines(2);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        this.n.addView(this.p, layoutParams);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.i.setVisibility(8);
            this.z.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.z.setVisibility(0);
            this.i.setImageBitmap(bitmap);
            this.z.setImageBitmap(bitmap);
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.l.a(interfaceC0778a);
        this.C.a(interfaceC0778a);
        this.s.a(interfaceC0778a);
        this.w.a(interfaceC0778a);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.cmn.q qVar) {
        com.opos.mobad.template.cmn.w wVar;
        if (qVar == null || (wVar = this.t) == null) {
            return;
        }
        this.H = qVar;
        com.opos.mobad.template.cmn.p.a(wVar, qVar);
        com.opos.mobad.template.cmn.p.a(this.F, this.H);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            this.j.setText(bVar.b);
            this.B.setText(bVar.b);
            this.p.setText(bVar.f9413a);
            this.D.setText(bVar.f9413a);
            this.r.setText(bVar.j);
            this.E.setText(bVar.j);
            this.l.a(bVar.p, bVar.e, bVar.g, bVar.i);
            this.C.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
            com.opos.mobad.template.d.a aVar = bVar.u;
            if (aVar == null) {
                this.s.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                this.s.a(aVar.f9412a, aVar.b);
                com.opos.mobad.template.a.c cVar = this.w;
                com.opos.mobad.template.d.a aVar2 = bVar.u;
                cVar.a(aVar2.f9412a, aVar2.b);
            }
        }
    }
}

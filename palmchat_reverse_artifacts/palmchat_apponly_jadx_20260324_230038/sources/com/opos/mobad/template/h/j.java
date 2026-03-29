package com.opos.mobad.template.h;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j extends d {
    protected Context f;
    protected LinearLayout g;
    protected TextView h;
    private com.opos.mobad.d.a i;
    private int j;
    private RelativeLayout l;
    private com.opos.mobad.template.cmn.w m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private com.opos.mobad.template.cmn.w q;
    private TextView r;
    private ImageView s;
    private com.opos.mobad.template.cmn.w t;
    private ImageView u;
    private com.opos.mobad.template.k.c v;
    private TextView w;
    private com.opos.mobad.template.a.c x;
    private com.opos.mobad.template.cmn.q y;

    public j(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.j = -16777216;
        this.f = context.getApplicationContext();
        this.i = aVar;
        f();
        g();
        d();
        b(context);
        d(context);
        c(context);
        j();
        e();
        a(context);
        i();
    }

    private RelativeLayout.LayoutParams d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.n = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.n.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 112.0f), -1);
        layoutParams.addRule(1, this.q.getId());
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.n.setLayoutParams(layoutParams);
        this.n.setGravity(16);
        TextView textView = new TextView(context);
        this.o = textView;
        textView.setGravity(3);
        this.o.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.o.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        TextPaint paint = this.o.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.o.setLines(1);
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        this.o.setTextSize(1, 12.0f);
        this.n.addView(this.o);
        TextView textView2 = new TextView(context);
        this.p = textView2;
        textView2.setGravity(3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 2.0f);
        this.p.setLayoutParams(layoutParams2);
        this.p.setLines(1);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.p.setTextSize(1, 10.0f);
        this.n.addView(this.p);
        this.l.addView(this.n);
        return layoutParams;
    }

    private void i() {
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext());
        this.x = cVar;
        cVar.setGravity(3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.g.addView(this.x, layoutParams);
    }

    private void j() {
        ImageView imageView = new ImageView(this.f);
        this.u = imageView;
        imageView.setId(View.generateViewId());
        this.u.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        this.u.setImageAlpha(63);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.l.addView(this.u, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.addRule(0, this.u.getId());
        this.t.setLayoutParams(layoutParams2);
    }

    private com.opos.mobad.template.cmn.p k() {
        return new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.j.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(j.this.m, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(500L);
                objectAnimatorOfFloat.setInterpolator(interpolatorCreate);
                objectAnimatorOfFloat.start();
            }
        };
    }

    public void e() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = h();
        linearLayout.setGravity(16);
        TextView textView = new TextView(this.f);
        this.h = textView;
        textView.setTextColor(-1);
        this.h.setTextSize(1, 14.0f);
        this.h.setLines(1);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        com.opos.mobad.template.h.a(this.h);
        linearLayout.addView(this.h);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.i);
        this.v = cVarA;
        linearLayout.addView(cVarA, layoutParams2);
        this.g.addView(linearLayout, layoutParams);
    }

    public void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 280.0f));
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        setPadding(iA, 0, iA, 0);
        layoutParams.addRule(12);
        setLayoutParams(layoutParams);
    }

    public void g() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(this.j, 255), ColorUtils.setAlphaComponent(this.j, 255), ColorUtils.setAlphaComponent(this.j, 200), ColorUtils.setAlphaComponent(this.j, 160), ColorUtils.setAlphaComponent(this.j, 0)});
        gradientDrawable.setShape(0);
        setBackground(gradientDrawable);
    }

    public int h() {
        return com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
    }

    @Override // com.opos.mobad.template.h.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.t.clearAnimation();
        this.m.clearAnimation();
        this.u.clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // com.opos.mobad.template.h.d
    public void a() {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        this.m.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.play(ObjectAnimator.ofFloat(this.m, "alpha", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.m, "translationX", -(this.m.getWidth() - com.opos.cmn.an.h.f.a.a(this.f, 200.0f)), 0.0f));
        animatorSet.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void b() {
        com.opos.mobad.template.cmn.q qVar = this.y;
        if (qVar != null) {
            qVar.a(this.d);
        }
        this.t.setBackgroundColor(this.d);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.t, "backgroundColor", this.c, this.d);
        objectAnimatorOfInt.setDuration(350L);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void c() {
        com.opos.mobad.template.cmn.q qVar = this.y;
        if (qVar != null) {
            qVar.a(this.d);
        }
        if (this.b) {
            b();
        }
    }

    public void d() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        this.m = new com.opos.mobad.template.cmn.w(this.f);
        float fA = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.m.a(fA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), ColorUtils.setAlphaComponent(-1, 51));
        gradientDrawable.setCornerRadius(fA);
        this.m.setBackground(gradientDrawable);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        wVar.a(fA);
        wVar.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(1, 1, 1, 1);
        this.l = new RelativeLayout(this.f);
        this.l.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 260.0f), com.opos.cmn.an.h.f.a.a(this.f, 56.0f)));
        this.l.setPadding(com.opos.cmn.an.h.f.a.a(this.f, 12.0f), 0, com.opos.cmn.an.h.f.a.a(this.f, 4.0f), 12);
        wVar.addView(this.l);
        this.m.addView(wVar, layoutParams);
        this.g.addView(this.m, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 30.0f);
        addView(this.g, layoutParams2);
        this.m.setVisibility(4);
    }

    private void a(Context context) {
        this.w = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.w.setTextSize(1, 14.0f);
        this.w.setMaxLines(2);
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        this.g.addView(this.w, layoutParams);
    }

    private void b(Context context) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        this.q = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.q.setLayoutParams(layoutParams);
        layoutParams.addRule(15);
        ImageView imageView = new ImageView(context);
        this.s = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(context, 32.0f);
        this.s.setLayoutParams(new RelativeLayout.LayoutParams(iA, iA));
        this.q.addView(this.s);
        this.l.addView(this.q);
        this.q.a(com.opos.cmn.an.h.f.a.a(context, 8.0f));
    }

    private void c(final Context context) {
        this.t = new com.opos.mobad.template.cmn.w(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.t.setLayoutParams(layoutParams);
        this.t.setId(View.generateViewId());
        this.t.setBackgroundColor(this.c);
        layoutParams.addRule(15);
        TextView textView = new TextView(context);
        this.r = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.r.setLayoutParams(new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f)));
        this.r.setTextSize(1, 12.0f);
        this.r.setGravity(17);
        int iA = com.opos.cmn.an.h.f.a.a(context, 10.0f);
        this.r.setPadding(iA, 0, iA, 0);
        TextPaint paint = this.r.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.r.setTextColor(-1);
        this.t.addView(this.r);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams2.addRule(0, this.t.getId());
        this.n.setLayoutParams(layoutParams2);
        this.r.post(new Runnable() { // from class: com.opos.mobad.template.h.j.1
            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                if (jVar.e) {
                    return;
                }
                j.this.t.a(jVar.r.getHeight() > 0 ? j.this.r.getHeight() / 2 : com.opos.cmn.an.h.f.a.a(context, 16.0f));
            }
        });
        this.l.addView(this.t);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
            this.s.setImageBitmap(bitmap);
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.v.a(interfaceC0778a);
        this.x.a(interfaceC0778a);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.cmn.q qVar) {
        if (qVar != null) {
            this.y = qVar;
            com.opos.mobad.template.cmn.p.a(this.t, qVar);
        }
        if (this.u != null) {
            com.opos.mobad.template.cmn.p.a(this.u, k());
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.d.b bVar) {
        this.o.setText(bVar.b);
        this.h.setText(bVar.b);
        this.p.setText(bVar.f9413a);
        this.r.setText(bVar.j);
        this.w.setText(bVar.f9413a);
        this.v.a(bVar.p, bVar.e, bVar.g, bVar.i);
        if (bVar.u == null) {
            this.x.setVisibility(8);
            return;
        }
        this.x.setVisibility(0);
        com.opos.mobad.template.a.c cVar = this.x;
        com.opos.mobad.template.d.a aVar = bVar.u;
        cVar.a(aVar.f9412a, aVar.b);
    }
}

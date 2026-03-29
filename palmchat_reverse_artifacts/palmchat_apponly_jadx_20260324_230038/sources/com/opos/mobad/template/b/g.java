package com.opos.mobad.template.b;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.n;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.q;
import com.opos.mobad.template.cmn.w;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f9334a;
    protected com.opos.mobad.d.a b;
    protected a.InterfaceC0778a c;
    protected Context d;
    protected ViewGroup e;
    protected boolean f;
    protected Animator g;
    protected w h;
    protected Animator i;
    protected ImageView j;
    private w l;
    private com.opos.mobad.template.a.g m;
    private com.opos.mobad.template.k.c n;
    private n o;
    private LinearLayout p;
    private TextView q;
    private com.opos.mobad.template.cmn.baseview.c r;
    private TextView s;
    private TextView t;
    private w u;
    private int v;
    private BaseImageView w;
    private com.opos.mobad.template.a.c x;

    public g(Context context, int i, com.opos.mobad.d.a aVar, boolean z) {
        super(context);
        this.f = true;
        this.v = Color.parseColor("#2DA74E");
        this.d = context.getApplicationContext();
        this.f9334a = i;
        this.b = aVar;
        this.f = z;
        a();
    }

    private void h() {
        this.x = new com.opos.mobad.template.a.c(this.d, getResources().getColor(R.color.opos_mobad_version_company_color), getResources().getColor(R.color.opos_mobad_version_company_split_line_color));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.d, 6.0f);
        this.p.addView(this.x, layoutParams);
    }

    private void i() {
        Context context;
        float f;
        View view;
        if (this.d == null || this.e == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(12);
        if (this.f9334a == 2) {
            context = getContext();
            f = 4.0f;
        } else {
            context = getContext();
            f = 6.0f;
        }
        int iA = com.opos.cmn.an.h.f.a.a(context, f);
        layoutParams.leftMargin = iA;
        layoutParams.bottomMargin = iA;
        if (this.f9334a == 2) {
            com.opos.mobad.template.a.g gVarA = com.opos.mobad.template.a.g.a(this.d, ColorUtils.setAlphaComponent(-16777216, 51), this.b);
            this.m = gVarA;
            view = gVarA;
        } else {
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.d, 0, 0, this.b);
            this.n = cVarA;
            view = cVarA;
        }
        this.e.addView(view, layoutParams);
    }

    private void j() {
        this.p = new LinearLayout(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.d, 8.0f));
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(this.d, 16.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.e.getId());
        this.p.setOrientation(1);
        this.p.setLayoutParams(layoutParams);
        this.l.addView(this.p);
    }

    private void k() {
        TextView textView = new TextView(this.d);
        this.q = textView;
        textView.setTextSize(1, 14.0f);
        this.q.setLines(2);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextColor(this.d.getResources().getColor(R.color.opos_mobad_title_color));
        LinearLayout linearLayout = this.p;
        if (linearLayout != null) {
            linearLayout.addView(this.q);
        }
    }

    private void l() {
        this.r = new com.opos.mobad.template.cmn.baseview.c(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 28.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.d, 12.0f);
        this.r.setGravity(16);
        this.r.setLayoutParams(layoutParams);
        this.p.addView(this.r);
    }

    private void m() {
        this.s = new TextView(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 86.0f), -2);
        this.s.setTextSize(1, 12.0f);
        this.s.setLines(1);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setTextColor(this.d.getResources().getColor(R.color.opos_mobad_des_color));
        layoutParams.addRule(0, this.u.getId());
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.d, 8.0f);
        layoutParams.addRule(15);
        com.opos.mobad.template.cmn.baseview.c cVar = this.r;
        if (cVar != null) {
            cVar.addView(this.s, layoutParams);
        }
    }

    private void n() {
        w wVar = new w(this.d);
        this.u = wVar;
        wVar.a(90.0f);
        this.t = new TextView(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 72.0f), com.opos.cmn.an.h.f.a.a(this.d, 28.0f));
        layoutParams.addRule(11);
        this.u.setLayoutParams(layoutParams);
        this.u.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        TextPaint paint = this.t.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.t.setGravity(17);
        this.t.setLayoutParams(layoutParams2);
        this.t.setLines(1);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setTextColor(this.d.getResources().getColor(R.color.opos_mobad_banner_button_color));
        this.t.setTextSize(1, 12);
        this.u.setBackgroundColor(this.d.getResources().getColor(R.color.opos_mobad_banner_button_background_color));
        this.u.addView(this.t);
        this.r.addView(this.u);
    }

    private void o() {
        BaseImageView baseImageView = new BaseImageView(this.d);
        this.w = baseImageView;
        baseImageView.setImageResource(R.drawable.opos_mobad_bottom_img_block_close);
        int iA = com.opos.cmn.an.h.f.a.a(this.d, 16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.d, 8.0f));
        this.r.addView(this.w, layoutParams);
    }

    public g a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
        this.x.a(interfaceC0778a);
        return this;
    }

    public g a_(com.opos.mobad.template.cmn.baseview.f fVar) {
        a(fVar);
        w wVar = this.u;
        if (wVar != null) {
            wVar.a(fVar);
        }
        return this;
    }

    public g b(p pVar) {
        BaseImageView baseImageView = this.w;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.w.setOnTouchListener(pVar);
        }
        return this;
    }

    public ViewGroup c() {
        w wVar = new w(this.d);
        wVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 122.0f), com.opos.cmn.an.h.f.a.a(this.d, 80.0f));
        wVar.setLayoutParams(layoutParams);
        layoutParams.addRule(15);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.d, 16.0f));
        wVar.a(com.opos.cmn.an.h.f.a.a(this.d, 8.0f));
        wVar.setBackgroundColor(this.d.getResources().getColor(R.color.opos_mobad_stroke_icon_color));
        a((ViewGroup) wVar);
        return wVar;
    }

    public void d() {
        Animator animator = this.i;
        if (animator != null) {
            animator.start();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.start();
        }
    }

    public void e() {
        Animator animator = this.i;
        if (animator != null) {
            animator.pause();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.pause();
        }
    }

    public void f() {
        Animator animator = this.i;
        if (animator != null) {
            animator.resume();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.start();
        }
    }

    public void g() {
        Animator animator = this.i;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.g;
        if (animator2 != null) {
            animator2.end();
        }
    }

    public g a(p pVar) {
        if (this.f) {
            setOnClickListener(pVar);
            setOnTouchListener(pVar);
        }
        return this;
    }

    public g b(String str) {
        if (this.q != null && !TextUtils.isEmpty(str)) {
            this.q.setText(str);
        }
        return this;
    }

    public g c(String str) {
        if (this.s != null && !TextUtils.isEmpty(str)) {
            this.s.setText(str);
        }
        return this;
    }

    public g a(q qVar) {
        w wVar = this.u;
        if (wVar != null) {
            wVar.setOnClickListener(qVar);
            this.u.setOnTouchListener(qVar);
        }
        return this;
    }

    @TargetApi(21)
    public void b() {
        this.g = a.a(this.o);
        this.h = new w(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(5, this.u.getId());
        layoutParams.addRule(7, this.u.getId());
        layoutParams.addRule(6, this.u.getId());
        layoutParams.addRule(8, this.u.getId());
        layoutParams.addRule(21);
        this.h.setBackgroundColor(0);
        this.h.a(com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        this.r.addView(this.h, layoutParams);
        this.i = a.a((RelativeLayout) this.h);
    }

    public g a(com.opos.mobad.template.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.f9412a)) {
            this.q.setLines(2);
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.q.setLines(1);
            this.x.a(aVar.f9412a, aVar.b);
        }
        return this;
    }

    public g a(com.opos.mobad.template.d.b bVar) {
        if (this.f9334a == 2) {
            com.opos.mobad.template.a.g gVar = this.m;
            if (gVar != null) {
                a.InterfaceC0778a interfaceC0778a = this.c;
                if (interfaceC0778a != null) {
                    gVar.a(interfaceC0778a);
                }
                this.m.a(bVar.p, bVar.e, bVar.f, bVar.i);
            }
        } else {
            com.opos.mobad.template.k.c cVar = this.n;
            if (cVar != null) {
                a.InterfaceC0778a interfaceC0778a2 = this.c;
                if (interfaceC0778a2 != null) {
                    cVar.a(interfaceC0778a2);
                }
                this.n.a(bVar.p, bVar.e, bVar.g, bVar.i);
            }
        }
        return this;
    }

    public g a(String str) {
        if (this.t != null && !TextUtils.isEmpty(str)) {
            this.t.setText(str);
        }
        return this;
    }

    public g a(List<Bitmap> list, int i) {
        if (list != null && !list.isEmpty()) {
            Bitmap bitmap = list.get(0);
            n nVar = this.o;
            if (nVar != null) {
                nVar.setImageBitmap(bitmap);
                ViewGroup viewGroup = this.e;
                if (viewGroup != null) {
                    viewGroup.setBackgroundColor(0);
                }
            }
        }
        return this;
    }

    public void a() {
        this.l = new w(this.d);
        this.l.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 328.0f), com.opos.cmn.an.h.f.a.a(this.d, 112.0f)));
        this.l.setBackgroundColor(getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.l.a(com.opos.cmn.an.h.f.a.a(this.d, 12.0f));
        addView(this.l);
        ViewGroup viewGroupC = c();
        this.e = viewGroupC;
        if (viewGroupC != null) {
            viewGroupC.setId(View.generateViewId());
            this.l.addView(this.e);
        }
        i();
        j();
        k();
        h();
        l();
        n();
        m();
        if (this.f9334a == 2) {
            o();
        }
        if (this.f9334a != 2) {
            a((RelativeLayout) this.l);
            b();
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            n nVar = new n(this.d, com.opos.cmn.an.h.f.a.a(r1, 8.0f));
            this.o = nVar;
            nVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.o.setScaleType(this.f9334a == 0 ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.CENTER_CROP);
            viewGroup.addView(this.o);
        }
    }

    public void a(RelativeLayout relativeLayout) {
        Context context;
        int i;
        Drawable drawable = ContextCompat.getDrawable(this.d, R.drawable.opos_mobad_close);
        if (this.f9334a == 4) {
            context = this.d;
            i = R.color.opos_mobad_banner_close_normal_color;
        } else {
            context = this.d;
            i = R.color.opos_mobad_banner_close_color;
        }
        DrawableCompat.setTint(drawable, ContextCompat.getColor(context, i));
        ImageView imageView = new ImageView(this.d);
        this.j = imageView;
        imageView.setImageDrawable(drawable);
        int iA = com.opos.cmn.an.h.f.a.a(this.d, 16.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.d, 4.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA2;
        relativeLayout.addView(this.j, layoutParams);
        p.a(this.j, new p() { // from class: com.opos.mobad.template.b.g.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                a.InterfaceC0778a interfaceC0778a = g.this.c;
                if (interfaceC0778a != null) {
                    interfaceC0778a.e(view, iArr);
                }
            }
        });
    }
}

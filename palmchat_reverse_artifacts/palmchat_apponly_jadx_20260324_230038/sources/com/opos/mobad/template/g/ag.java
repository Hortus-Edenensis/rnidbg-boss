package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.g.ai;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ag extends com.opos.mobad.template.cmn.baseview.c {
    private ad A;
    private boolean B;
    private int C;
    private int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a.InterfaceC0778a f9671a;
    protected Context b;
    protected ViewGroup c;
    protected com.opos.mobad.template.e.c.a d;
    private com.opos.mobad.d.a e;
    private ImageView f;
    private LinearLayout g;
    private ImageView h;
    private TextView i;
    private com.opos.mobad.template.k.c j;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private com.opos.mobad.template.cmn.w s;
    private float t;
    private int u;
    private int v;
    private com.opos.mobad.template.a.c w;
    private TextView x;
    private Animator y;
    private com.opos.mobad.template.cmn.w z;

    public ag(Context context, int i, com.opos.mobad.d.a aVar, int i2) {
        super(context);
        this.B = false;
        if (context == null) {
            return;
        }
        this.C = i2;
        this.D = i;
        this.u = Color.parseColor("#52CC6D");
        this.v = Color.parseColor("#0066FF");
        setWillNotDraw(false);
        this.b = context.getApplicationContext();
        this.e = aVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -1);
        layoutParams.addRule(13);
        layoutParams.setMargins(1, 1, 1, 1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        ViewGroup viewGroupC = c();
        this.c = viewGroupC;
        if (viewGroupC != null) {
            viewGroupC.setId(View.generateViewId());
            addView(this.c);
        }
        g();
        h();
        f();
        i();
        j();
        m();
        e();
        if (i != 2) {
            n();
        }
    }

    private TextView a(@NonNull Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(1, 14.0f);
        textView.setMaxLines(3);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        return textView;
    }

    private void e() {
        Context context = this.b;
        if (context == null) {
            return;
        }
        TextView textViewA = a(context);
        this.i = textViewA;
        textViewA.setId(View.generateViewId());
        this.i.setTextColor(this.b.getResources().getColor(R.color.opos_mobad_title_or_desc_color));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 178.0f), com.opos.cmn.an.h.f.a.a(this.b, 60.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setLayoutParams(layoutParams);
        this.g.addView(this.i);
    }

    private void f() {
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.l = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 3.0f);
        this.l.setLayoutParams(layoutParams);
        this.g.addView(this.l);
    }

    private void g() {
        if (this.b == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.g = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.g.setOrientation(1);
        this.g.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 12.0f), com.opos.cmn.an.h.f.a.a(this.b, 16.0f), com.opos.cmn.an.h.f.a.a(this.b, 16.0f), 0);
        this.g.setBackgroundColor(this.b.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 206.0f), com.opos.cmn.an.h.f.a.a(getContext(), 218.0f));
        layoutParams.addRule(1, this.c.getId());
        addView(this.g, layoutParams);
    }

    private void h() {
        this.A = ad.a(this.b, 10, this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.A.setId(View.generateViewId());
        addView(this.A, layoutParams);
    }

    private void i() {
        if (this.b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.b);
        this.p = imageView;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 42.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f)));
        this.p.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        wVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar.addView(this.p);
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 8.0f));
        this.l.addView(wVar);
    }

    private LinearLayout j() {
        if (this.b == null) {
            return null;
        }
        this.m = k();
        this.m.setLayoutParams(new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 128.0f), -2));
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.n = linearLayout;
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.b, 8.0f));
        layoutParams.gravity = 16;
        this.n.setLayoutParams(layoutParams);
        this.n.setOrientation(0);
        l();
        TextView textView = new TextView(this.b);
        this.q = textView;
        textView.setTextSize(1, 14.0f);
        this.q.setTextColor(this.b.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.q.setLines(1);
        this.q.setMaxEms(7);
        this.q.setSingleLine(true);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        TextPaint paint = this.q.getPaint();
        paint.setStrokeWidth(0.8f);
        this.n.addView(this.q);
        this.m.addView(this.n);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        return this.m;
    }

    private LinearLayout k() {
        if (this.b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.l.addView(linearLayout);
        return linearLayout;
    }

    private void l() {
        if (this.b == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams.leftMargin = iA;
        layoutParams.topMargin = iA;
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.b, 0, 0, this.e);
        this.j = cVarA;
        addView(cVarA, layoutParams);
    }

    private void m() {
        if (this.b == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.o = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 128.0f), -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.b, 8.0f));
        this.o.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 128.0f), -2);
        this.w = new com.opos.mobad.template.a.c(getContext(), getContext().getResources().getColor(R.color.opos_mobad_version_company_color));
        layoutParams2.addRule(3, this.q.getId());
        this.w.setVisibility(4);
        this.o.addView(this.w, layoutParams2);
        this.m.addView(this.o);
    }

    private void n() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        this.s = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 36.0f));
        this.s.setGravity(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams.addRule(12);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 25.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        TextView textView = new TextView(this.b);
        this.x = textView;
        textView.setId(View.generateViewId());
        TextPaint paint = this.x.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.x.setGravity(17);
        this.x.setLayoutParams(layoutParams2);
        this.x.setTextSize(1, 16.0f);
        this.x.setTextColor(-1);
        this.s.setBackgroundColor(this.v);
        this.s.addView(this.x);
        this.z = new com.opos.mobad.template.cmn.w(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams3.addRule(5, this.x.getId());
        layoutParams3.addRule(7, this.x.getId());
        layoutParams3.addRule(6, this.x.getId());
        layoutParams3.addRule(8, this.x.getId());
        layoutParams3.addRule(13);
        this.z.setId(View.generateViewId());
        this.z.a(com.opos.cmn.an.h.f.a.a(getContext(), 22.0f));
        a();
        Animator animatorC = com.opos.mobad.template.cmn.ae.c((RelativeLayout) this.z);
        this.y = animatorC;
        animatorC.start();
        this.z.setVisibility(4);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ag.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BottomImageLeftView", "onBtnClick");
                a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                if (interfaceC0778a != null) {
                    interfaceC0778a.g(view, iArr);
                }
            }
        };
        this.z.setOnClickListener(pVar);
        this.x.setOnClickListener(pVar);
        this.s.addView(this.z, layoutParams3);
        this.g.addView(this.s, layoutParams);
    }

    private void o() {
        LinearLayout linearLayout = this.o;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void p() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && (layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams()) != null) {
            layoutParams2.setMarginStart(0);
            this.n.setLayoutParams(layoutParams2);
        }
        LinearLayout linearLayout2 = this.o;
        if (linearLayout2 == null || (layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMarginStart(0);
        this.o.setLayoutParams(layoutParams);
    }

    public ag b(Bitmap bitmap) {
        ImageView imageView = this.p;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else if (imageView != null) {
            imageView.setVisibility(8);
            p();
        }
        return this;
    }

    public ViewGroup c() {
        if (this.b == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 122.0f), -1));
        a(frameLayout);
        return frameLayout;
    }

    public void d() {
        setLayerType(1, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (!this.B) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.b, this.C, bVar.L);
            this.d = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.ag.3
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 25.0f);
            if (this.d.c() != null && this.g != null) {
                this.d.c().setId(View.generateViewId());
                this.z = new com.opos.mobad.template.cmn.w(getContext());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
                layoutParams2.addRule(5, this.d.c().getId());
                layoutParams2.addRule(7, this.d.c().getId());
                layoutParams2.addRule(6, this.d.c().getId());
                layoutParams2.addRule(8, this.d.c().getId());
                layoutParams2.addRule(13);
                this.z.setId(View.generateViewId());
                this.z.a(com.opos.cmn.an.h.f.a.a(getContext(), 22.0f));
                a();
                Animator animatorC = com.opos.mobad.template.cmn.ae.c((RelativeLayout) this.z);
                this.y = animatorC;
                animatorC.start();
                this.z.setVisibility(4);
                this.z.setOnClickListener(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ag.4
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        com.opos.cmn.an.f.a.b("BottomImageLeftView", "onBtnClick");
                        a.InterfaceC0778a interfaceC0778a = ag.this.f9671a;
                        if (interfaceC0778a != null) {
                            interfaceC0778a.g(view, iArr);
                        }
                    }
                });
                com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
                this.s = wVar;
                wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 22.0f));
                this.s.setGravity(1);
                this.s.addView(this.d.c());
                this.s.addView(this.z, layoutParams2);
                this.g.addView(this.s, layoutParams);
            }
            this.B = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.d;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    public ag a(Bitmap bitmap) {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public ag b(com.opos.mobad.template.cmn.p pVar) {
        return this;
    }

    public ag a(a.InterfaceC0778a interfaceC0778a) {
        this.f9671a = interfaceC0778a;
        com.opos.mobad.template.a.c cVar = this.w;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
        ad adVar = this.A;
        if (adVar != null) {
            adVar.a(this.f9671a);
        }
        return this;
    }

    public ag b(com.opos.mobad.template.d.b bVar) {
        if (this.D == 2) {
            c(bVar);
            com.opos.mobad.template.e.c.a aVar = this.d;
            if (aVar == null || aVar.c() == null) {
                n();
            } else {
                this.d.c().setVisibility(0);
            }
        }
        com.opos.mobad.template.cmn.w wVar = this.z;
        if (wVar != null) {
            wVar.setVisibility(0);
        }
        return this;
    }

    public ag a(com.opos.mobad.template.cmn.p pVar) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(pVar);
            this.h.setOnTouchListener(pVar);
        }
        return this;
    }

    public ag b(String str) {
        if (this.r != null && !TextUtils.isEmpty(str)) {
            this.r.setText(str);
        }
        if (this.x != null && !TextUtils.isEmpty(str)) {
            this.x.setText(str);
        }
        if (this.x != null && !TextUtils.isEmpty(str)) {
            this.x.setText(str);
        }
        return this;
    }

    public ag a(com.opos.mobad.template.d.a aVar) {
        com.opos.mobad.template.a.c cVar = this.w;
        if (cVar != null) {
            if (aVar == null) {
                cVar.setVisibility(4);
            } else if (TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
                this.w.setVisibility(4);
            } else {
                this.w.setVisibility(0);
                this.w.b(aVar.f9412a, aVar.b);
            }
        }
        return this;
    }

    public void b() {
        a();
        com.opos.mobad.template.e.c.a aVar = this.d;
        if (aVar != null) {
            aVar.j();
        }
    }

    public ag a(com.opos.mobad.template.d.b bVar) {
        a.InterfaceC0778a interfaceC0778a = this.f9671a;
        if (interfaceC0778a != null) {
            this.j.a(interfaceC0778a);
        }
        this.j.a(bVar.p, bVar.e, bVar.g, bVar.i);
        return this;
    }

    public ag a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.i) != null) {
            textView.setText(str);
        }
        return this;
    }

    public ag a(String str, com.opos.mobad.template.d.a aVar) {
        if (this.q != null && !TextUtils.isEmpty(str)) {
            this.q.setText(str);
        }
        if (aVar == null) {
            o();
        } else if (TextUtils.isEmpty(aVar.b)) {
            o();
            return this;
        }
        return this;
    }

    public void a() {
        Animator animator = this.y;
        if (animator != null) {
            com.opos.mobad.template.h.a(animator);
        }
    }

    public void a(final float f) {
        this.t = f;
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.template.g.ag.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f);
            }
        });
        setClipToOutline(true);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ImageView imageView = new ImageView(this.b);
            this.f = imageView;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f.setScaleType(ImageView.ScaleType.FIT_XY);
            viewGroup.addView(this.f);
        }
    }

    public void a(com.opos.mobad.template.cmn.t tVar) {
    }

    public void a(ai.a aVar) {
    }
}

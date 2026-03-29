package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9475a;
    private Context b;
    private a.InterfaceC0778a c;
    private com.opos.mobad.d.a d;
    private Palette.Swatch e;
    private View f;
    private View g;
    private LinearLayout h;
    private TextView i;
    private com.opos.mobad.template.k.c j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private com.opos.mobad.template.a.c n;
    private ImageView o;
    private TextView p;
    private a q;
    private com.opos.mobad.template.cmn.w r;
    private boolean s;
    private boolean t;

    public b(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        if (context == null) {
            return;
        }
        this.d = aVar;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.s = af.b(applicationContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 330.0f));
        layoutParams.addRule(12);
        setLayoutParams(layoutParams);
        b(context);
        j();
        i();
        g();
        f();
        c();
        d();
        b();
    }

    private TextView a(@NonNull Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(1, 24.0f);
        textView.setLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(com.opos.cmn.an.h.f.a.a(context, 35.5f));
        }
        return textView;
    }

    private LinearLayout c() {
        if (this.b == null) {
            return null;
        }
        this.l = e();
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.m = linearLayout;
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.b, 8.0f));
        layoutParams.gravity = 16;
        this.m.setLayoutParams(layoutParams);
        this.m.setOrientation(0);
        this.l.addView(this.m);
        h();
        TextView textView = new TextView(this.b);
        this.p = textView;
        textView.setTextSize(1, 16.0f);
        this.p.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        this.p.setLines(1);
        this.p.setSingleLine(true);
        com.opos.mobad.template.h.a(this.p);
        this.p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.s ? 10 : 12)});
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.m.addView(this.p);
        this.m.addView(this.j);
        return this.l;
    }

    private void d() {
        Context context = this.b;
        if (context == null) {
            return;
        }
        this.n = new com.opos.mobad.template.a.c(context, Color.parseColor("#66FFFFFF"), Color.parseColor("#33FFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        this.n.setGravity(3);
        this.l.addView(this.n, layoutParams);
    }

    private LinearLayout e() {
        if (this.b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.k.addView(linearLayout);
        return linearLayout;
    }

    private void f() {
        if (this.b == null) {
            return;
        }
        ImageView imageView = new ImageView(this.b);
        this.o = imageView;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 42.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f)));
        this.o.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        wVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar.addView(this.o);
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 8.0f));
        this.k.addView(wVar);
    }

    private void g() {
        if (this.b == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.k = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.k.setLayoutParams(layoutParams);
        this.h.addView(this.k);
    }

    private void h() {
        if (this.b == null) {
            return;
        }
        this.j = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.j.setLayoutParams(layoutParams);
    }

    private void i() {
        Context context = this.b;
        if (context == null) {
            return;
        }
        TextView textViewA = a(context);
        this.i = textViewA;
        this.h.addView(textViewA);
        View view = new View(this.b);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 3.0f)));
        this.h.addView(view);
    }

    private void j() {
        if (this.b == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.h = linearLayout;
        linearLayout.setOrientation(1);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 24.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 110.0f);
        addView(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(iA, iA2, iA, 0);
        this.h.setLayoutParams(layoutParams);
    }

    private void k() {
        com.opos.mobad.template.a.c cVar = this.n;
        if (cVar != null) {
            cVar.setVisibility(8);
        }
    }

    private void l() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = this.m;
        if (linearLayout != null && (layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams()) != null) {
            layoutParams2.setMarginStart(0);
            this.m.setLayoutParams(layoutParams2);
        }
        com.opos.mobad.template.a.c cVar = this.n;
        if (cVar == null || (layoutParams = (LinearLayout.LayoutParams) cVar.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMarginStart(0);
        this.n.setLayoutParams(layoutParams);
    }

    public b b(String str) {
        this.q.a(Color.parseColor("#2B8CDA"), true).a(str).a();
        return this;
    }

    private void b() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        this.r = wVar;
        wVar.a(90.0f);
        this.q = new a(this.b);
        com.opos.mobad.template.cmn.q qVar = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.f.b.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.c != null) {
                    if (b.this.t) {
                        b.this.c.j(view, iArr);
                    } else {
                        b.this.c.g(view, iArr);
                    }
                }
            }
        };
        this.r.setOnTouchListener(qVar);
        this.r.setOnClickListener(qVar);
        this.r.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.b.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("FullScreenBottomView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (b.this.c != null) {
                    b.this.c.a(view, i, z);
                }
            }
        });
        this.q.a(qVar);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 44.0f);
        this.r.setLayoutParams(new RelativeLayout.LayoutParams(-1, iA));
        this.r.setGravity(1);
        this.q.setLayoutParams(new RelativeLayout.LayoutParams(-1, iA));
        this.r.addView(this.q);
        this.h.addView(this.r);
        ((LinearLayout.LayoutParams) ((ViewGroup) this.q.getParent()).getLayoutParams()).topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
    }

    public a.InterfaceC0778a a() {
        return this.c;
    }

    private void b(@NonNull Context context) {
        if (context == null) {
            return;
        }
        View view = new View(context);
        this.f = view;
        view.setId(View.generateViewId());
        this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 150.0f)));
        addView(this.f);
        this.g = new View(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 180.0f));
        layoutParams.addRule(3, this.f.getId());
        this.g.setLayoutParams(layoutParams);
        addView(this.g);
    }

    public b a(int i) {
        this.f9475a = i;
        return this;
    }

    public b a(Bitmap bitmap) {
        ImageView imageView = this.o;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else if (imageView != null) {
            imageView.setVisibility(8);
            l();
        }
        return this;
    }

    public b a(Palette palette) {
        if (palette == null) {
            return this;
        }
        a(com.opos.mobad.template.cmn.s.a(palette));
        Palette.Swatch swatch = this.e;
        a(swatch == null ? -16777216 : ColorUtils.HSLToColor(com.opos.mobad.template.cmn.s.a(swatch, 0.5f, 0.2f)));
        View view = this.g;
        if (view != null) {
            view.setBackgroundColor(this.f9475a);
        }
        if (this.f != null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(this.f9475a, 253), ColorUtils.setAlphaComponent(this.f9475a, 204), ColorUtils.setAlphaComponent(this.f9475a, 153), ColorUtils.setAlphaComponent(this.f9475a, 0)});
            gradientDrawable.setShape(0);
            this.f.setBackground(gradientDrawable);
        }
        return this;
    }

    public b a(com.opos.mobad.template.d.b bVar) {
        a.InterfaceC0778a interfaceC0778a = this.c;
        if (interfaceC0778a != null) {
            this.j.a(interfaceC0778a);
        }
        this.j.a(bVar.p, bVar.e, bVar.g, bVar.i);
        return this;
    }

    public b a(String str) {
        if (this.i != null && !TextUtils.isEmpty(str)) {
            this.i.setText(String.format("“%s”", str));
        }
        return this;
    }

    public b a(String str, com.opos.mobad.template.d.a aVar) {
        if (this.p != null && !TextUtils.isEmpty(str)) {
            this.p.setText(str);
        }
        if (aVar != null) {
            this.n.a(aVar.f9412a, aVar.b);
            this.n.a(this.c);
        } else {
            k();
        }
        return this;
    }

    public void a(Palette.Swatch swatch) {
        this.e = swatch;
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
    }
}

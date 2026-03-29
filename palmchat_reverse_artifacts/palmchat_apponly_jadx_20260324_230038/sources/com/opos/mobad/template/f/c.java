package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a.InterfaceC0778a f9478a;
    private com.opos.mobad.d.a b;
    private Context c;
    private Palette.Swatch d;
    private ImageView e;
    private RelativeLayout f;
    private LinearLayout g;
    private BaseImageView h;
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
    private float s;
    private int t;
    private int u;

    public c(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.t = 528;
        this.u = 300;
        if (context == null) {
            return;
        }
        setWillNotDraw(false);
        this.c = context.getApplicationContext();
        this.b = aVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, this.t), com.opos.cmn.an.h.f.a.a(context, this.u));
        layoutParams.addRule(13);
        int iA = com.opos.cmn.an.h.f.a.a(this.c, 1.0f);
        layoutParams.setMargins(iA, iA, iA, iA);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        ImageView imageView = new ImageView(this.c);
        this.e = imageView;
        imageView.setId(View.generateViewId());
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.e, new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 168.0f), -1));
        e();
        d();
        b();
        c();
        f();
        g();
        j();
        k();
    }

    private TextView a(@NonNull Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(1, 24.0f);
        textView.setLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        return textView;
    }

    private void c() {
        if (this.c == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.k = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
        this.k.setLayoutParams(layoutParams);
        this.g.addView(this.k);
    }

    private void d() {
        BaseImageView baseImageView = new BaseImageView(this.c);
        this.h = baseImageView;
        baseImageView.setImageResource(R.drawable.opos_mobad_drawable_block_close_with_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
        this.f.addView(this.h, layoutParams);
    }

    private void e() {
        if (this.c == null) {
            return;
        }
        this.g = new LinearLayout(this.c);
        this.g.setPadding(com.opos.cmn.an.h.f.a.a(this.c, 24.0f), 0, com.opos.cmn.an.h.f.a.a(this.c, 24.0f), 0);
        this.g.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f = new RelativeLayout(this.c);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(1, this.e.getId());
        layoutParams2.addRule(15);
        this.f.addView(this.g, layoutParams);
        addView(this.f, layoutParams2);
    }

    private void f() {
        if (this.c == null) {
            return;
        }
        ImageView imageView = new ImageView(this.c);
        this.o = imageView;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 42.0f), com.opos.cmn.an.h.f.a.a(this.c, 42.0f)));
        this.o.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.c);
        wVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar.addView(this.o);
        wVar.a(com.opos.cmn.an.h.f.a.a(this.c, 8.0f));
        this.k.addView(wVar);
    }

    private LinearLayout g() {
        if (this.c == null) {
            return null;
        }
        this.l = h();
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.m = linearLayout;
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(this.c, 8.0f));
        layoutParams.gravity = 16;
        this.m.setLayoutParams(layoutParams);
        this.m.setOrientation(0);
        this.l.addView(this.m);
        i();
        TextView textView = new TextView(this.c);
        this.p = textView;
        textView.setTextSize(1, 16.0f);
        this.p.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        this.p.setLines(1);
        this.p.setSingleLine(true);
        this.p.setMaxEms(10);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.p);
        this.m.addView(this.p);
        this.m.addView(this.j);
        return this.l;
    }

    private LinearLayout h() {
        if (this.c == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.k.addView(linearLayout);
        return linearLayout;
    }

    private void i() {
        if (this.c == null) {
            return;
        }
        this.j = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.j.setLayoutParams(layoutParams);
    }

    private void j() {
        Context context = this.c;
        if (context == null) {
            return;
        }
        this.n = new com.opos.mobad.template.a.c(context, Color.parseColor("#66FFFFFF"), Color.parseColor("#33FFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 4.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.c, 8.0f);
        this.n.setGravity(3);
        this.l.addView(this.n, layoutParams);
    }

    private void k() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.c);
        this.r = wVar;
        wVar.a(90.0f);
        this.q = new a(this.c);
        com.opos.mobad.template.cmn.q qVar = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.f.c.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.f9478a != null) {
                    c.this.f9478a.g(view, iArr);
                }
            }
        };
        this.r.setOnClickListener(qVar);
        this.r.setOnTouchListener(qVar);
        this.r.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.c.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("FullScreenHorizontalView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (c.this.f9478a != null) {
                    c.this.f9478a.a(view, i, z);
                }
            }
        });
        this.q.a(qVar);
        int iA = com.opos.cmn.an.h.f.a.a(this.c, 44.0f);
        this.r.setLayoutParams(new RelativeLayout.LayoutParams(-1, iA));
        this.r.setGravity(1);
        this.q.setLayoutParams(new RelativeLayout.LayoutParams(-1, iA));
        this.r.addView(this.q);
        this.g.addView(this.r);
        ((LinearLayout.LayoutParams) ((ViewGroup) this.q.getParent()).getLayoutParams()).topMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
    }

    private void l() {
        com.opos.mobad.template.a.c cVar = this.n;
        if (cVar != null) {
            cVar.setVisibility(8);
        }
    }

    private void m() {
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

    public c b(Bitmap bitmap) {
        ImageView imageView = this.o;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else if (imageView != null) {
            imageView.setVisibility(8);
            m();
        }
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public c b(String str) {
        this.q.a(Color.parseColor("#2B8CDA"), false).a(str).a();
        return this;
    }

    private void b() {
        Context context = this.c;
        if (context == null) {
            return;
        }
        TextView textViewA = a(context);
        this.i = textViewA;
        this.g.addView(textViewA);
        this.i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public c a(Bitmap bitmap) {
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public c a(Palette palette) {
        if (palette == null) {
            return this;
        }
        a(com.opos.mobad.template.cmn.s.a(palette));
        Palette.Swatch swatch = this.d;
        int iHSLToColor = swatch == null ? -16777216 : ColorUtils.HSLToColor(com.opos.mobad.template.cmn.s.a(swatch, 0.5f, 0.2f));
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(iHSLToColor);
        }
        return this;
    }

    public c a(a.InterfaceC0778a interfaceC0778a) {
        this.f9478a = interfaceC0778a;
        return this;
    }

    public c a(com.opos.mobad.template.cmn.p pVar) {
        BaseImageView baseImageView = this.h;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.h.setOnTouchListener(pVar);
        }
        return this;
    }

    public c a(com.opos.mobad.template.d.b bVar) {
        a.InterfaceC0778a interfaceC0778a = this.f9478a;
        if (interfaceC0778a != null) {
            this.j.a(interfaceC0778a);
        }
        this.j.a(bVar.p, bVar.e, bVar.g, bVar.i);
        return this;
    }

    public c a(String str) {
        if (this.i != null && !TextUtils.isEmpty(str)) {
            this.i.setText(String.format("“%s”", str));
        }
        return this;
    }

    public c a(String str, com.opos.mobad.template.d.a aVar) {
        String str2;
        String str3;
        if (this.p != null && !TextUtils.isEmpty(str)) {
            this.p.setText(str);
        }
        if (aVar == null || (str2 = aVar.b) == null || (str3 = aVar.f9412a) == null) {
            l();
        } else {
            this.n.a(str3, str2);
            a.InterfaceC0778a interfaceC0778a = this.f9478a;
            if (interfaceC0778a != null) {
                this.n.a(interfaceC0778a);
            }
        }
        return this;
    }

    public void a() {
        setLayerType(1, null);
    }

    public void a(final float f) {
        this.s = f;
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.template.f.c.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f);
            }
        });
        setClipToOutline(true);
    }

    public void a(Palette.Swatch swatch) {
        this.d = swatch;
    }
}

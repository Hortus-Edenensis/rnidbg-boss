package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
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
import com.opos.mobad.template.cmn.aa;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.opos.mobad.template.a {
    private ad A;
    private com.opos.mobad.template.cmn.w B;
    private int b;
    private int c;
    private int f;
    private LinearLayout g;
    private TextView h;
    private com.opos.mobad.template.a.g i;
    private com.opos.mobad.template.k.c j;
    private com.opos.mobad.template.a.c k;
    private com.opos.mobad.template.e.c.a l;
    private Context n;
    private a.InterfaceC0778a o;
    private int p;
    private int q;
    private com.opos.mobad.template.d.b r;
    private ImageView s;
    private ab t;
    private TextView u;
    private w v;
    private com.opos.mobad.template.cmn.baseview.c w;
    private com.opos.mobad.template.cmn.w x;
    private com.opos.mobad.template.cmn.aa y;
    private com.opos.mobad.d.a z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9705a = false;
    private int d = 0;
    private int e = 0;
    private boolean m = false;

    private b(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.n = context;
        this.q = i2;
        this.p = i;
        this.z = aVar;
        f();
        a(amVar);
        l();
        k();
    }

    private void f() {
        Context context;
        float f;
        this.d = com.opos.cmn.an.h.f.a.a(this.n, 320.0f);
        int i = this.q;
        if (i != 1) {
            if (i == 3) {
                this.b = com.opos.cmn.an.h.f.a.a(this.n, 360.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.n, 298.0f);
                this.d = com.opos.cmn.an.h.f.a.a(this.n, 328.0f);
                context = this.n;
                f = 184.0f;
            }
            this.f = this.c;
        }
        this.b = com.opos.cmn.an.h.f.a.a(this.n, 320.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.n, 288.0f);
        context = this.n;
        f = 210.0f;
        this.e = com.opos.cmn.an.h.f.a.a(context, f);
        this.f = this.c;
    }

    private boolean g() {
        return this.q == 3;
    }

    private void h() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.n);
        this.x = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.x.setVisibility(4);
        this.w.addView(this.x, layoutParams);
        i();
    }

    private void i() {
        TextView textView = new TextView(this.n);
        this.u = textView;
        textView.setId(View.generateViewId());
        this.u.setTextColor(this.n.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.u.setTextSize(1, 16.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.u.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 328.0f), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 16.0f);
        this.x.addView(this.u, layoutParams);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.n);
        this.B = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.n, 16.0f));
        this.B.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.d, this.e);
        layoutParams2.addRule(3, this.u.getId());
        layoutParams2.addRule(14);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 12.0f);
        b(this.B);
        this.x.addView(this.B, layoutParams2);
        if (!g()) {
            this.t = ab.a(this.n, this.z);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 320.0f), -2);
            layoutParams3.addRule(3, this.B.getId());
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 6.0f);
            this.x.addView(this.t, layoutParams3);
            return;
        }
        a(this.B);
        j();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.n, 320.0f), -2);
        layoutParams4.addRule(3, this.B.getId());
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 12.0f);
        layoutParams4.addRule(14);
        this.x.addView(this.g, layoutParams4);
    }

    private void j() {
        View view;
        LinearLayout linearLayout = new LinearLayout(this.n);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        TextView textView = new TextView(this.n);
        this.h = textView;
        textView.setId(View.generateViewId());
        this.h.setTextColor(this.n.getResources().getColor(R.color.opos_mobad_title_or_desc_color));
        this.h.setTextSize(1, 12.0f);
        this.h.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.h.setMaxEms(12);
        this.h.setSingleLine(true);
        TextPaint paint = this.h.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        relativeLayout.addView(this.h, new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (g()) {
            this.j = com.opos.mobad.template.k.c.a(this.n, 1, 0, this.z);
            layoutParams.addRule(1, this.h.getId());
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.n, 4.0f);
            layoutParams.addRule(15);
            view = this.j;
        } else {
            this.i = com.opos.mobad.template.a.g.b(this.n, this.z);
            layoutParams.addRule(11);
            view = this.i;
        }
        relativeLayout.addView(view, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        Context context = this.n;
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(context, context.getResources().getColor(R.color.opos_mobad_version_company_color));
        this.k = cVar;
        cVar.setVisibility(4);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 6.0f);
        this.g.addView(relativeLayout);
        this.g.addView(this.k, layoutParams2);
    }

    private void k() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.n);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.b.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (b.this.r == null) {
                    return;
                }
                if (z) {
                    if (b.this.o != null) {
                        b.this.o.a(com.opos.mobad.template.h.a(b.this.l));
                    }
                    if (b.this.l != null && b.this.l.c() != null) {
                        b.this.l.c().setVisibility(0);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage10", "BlockBigImage10 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.b.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (b.this.r == null) {
                    return;
                }
                if (b.this.o != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(b.this.l);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    b.this.o.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage10", "BlockBigImage10 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.w.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void l() {
        this.x.setVisibility(0);
        com.opos.mobad.template.e.c.a aVar = this.l;
        if (aVar == null || aVar.c().getVisibility() == 0) {
            return;
        }
        this.l.c().setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.y;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage10", "destroy");
        this.r = null;
        this.f9705a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.y;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.l;
        if (aVar != null) {
            aVar.f();
            this.l.j();
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.p;
    }

    public static b a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new b(context, amVar, i, 1, aVar);
    }

    public static b b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new b(context, amVar, i, 3, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        String str = bVar.f9413a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u.setText(str);
    }

    private void e(com.opos.mobad.template.d.b bVar) {
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0) {
            return;
        }
        a(this.s, bVar.c.get(0));
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.k) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.k.a(aVar.f9412a, aVar.b);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    private void a(final ImageView imageView, final com.opos.mobad.template.d.e eVar) {
        if (imageView == null || eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.z.a(eVar.f9414a, eVar.b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.b.6
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (b.this.f9705a) {
                    return;
                }
                if (eVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage10", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (b.this.o != null) {
                        b.this.o.c(i);
                    }
                } else {
                    if (i == 1 && b.this.o != null) {
                        b.this.o.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.f9705a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void b(com.opos.mobad.template.cmn.w wVar) {
        this.s = new ImageView(this.n);
        wVar.addView(this.s, new RelativeLayout.LayoutParams(this.d, this.e));
        this.s.setVisibility(8);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.m) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.n, e(), bVar.L);
            this.l = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.b.5
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (b.this.o != null) {
                        b.this.o.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (b.this.o != null) {
                        b.this.o.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (b.this.o != null) {
                        b.this.o.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (b.this.o != null) {
                        b.this.o.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.n, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.n, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.n, 12.0f);
            if (this.B != null && this.l.c() != null) {
                this.B.addView(this.l.c(), layoutParams);
            }
            this.m = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.l;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.o = interfaceC0778a;
        ab abVar = this.t;
        if (abVar != null) {
            abVar.a(interfaceC0778a);
        }
        w wVar = this.v;
        if (wVar != null) {
            wVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.a.g gVar = this.i;
        if (gVar != null) {
            gVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.k.c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.a(interfaceC0778a);
        }
        ad adVar = this.A;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.A = ad.a(this.n, 8, this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.A.setId(View.generateViewId());
        this.A.setVisibility(4);
        wVar.addView(this.A, layoutParams);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        e(bVar);
        if (!TextUtils.isEmpty(bVar.b) && (textView = this.h) != null) {
            textView.setText(bVar.b);
        }
        if (g()) {
            com.opos.mobad.template.k.c cVar = this.j;
            if (cVar != null) {
                cVar.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
            }
        } else {
            com.opos.mobad.template.a.g gVar = this.i;
            if (gVar != null) {
                gVar.a(bVar.p, bVar.e, bVar.f, bVar.i);
            }
        }
        c(bVar);
        d(bVar);
        b(bVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA == null) {
                str = "adShowData is null";
            } else {
                List<com.opos.mobad.template.d.e> list = bVarA.c;
                if (list != null && list.size() > 0) {
                    com.opos.cmn.an.f.a.b("BlockBigImage10", "render");
                    if (this.r == null && (interfaceC0778a = this.o) != null) {
                        interfaceC0778a.f();
                    }
                    this.r = bVarA;
                    com.opos.mobad.template.cmn.aa aaVar = this.y;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.y.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.baseview.c cVar = this.w;
                    if (cVar != null && cVar.getVisibility() != 0) {
                        this.w.setVisibility(0);
                    }
                    ad adVar = this.A;
                    if (adVar != null) {
                        adVar.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage10", str);
        this.o.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.n);
        }
        Context context = this.n;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.y = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.f));
        this.w = new com.opos.mobad.template.cmn.baseview.c(this.n);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.c);
        layoutParams.width = this.b;
        layoutParams.height = this.c;
        this.w.setId(View.generateViewId());
        this.w.setLayoutParams(layoutParams);
        this.w.setVisibility(8);
        this.y.addView(this.w, layoutParams);
        this.y.setLayoutParams(layoutParams);
        this.w.setBackgroundColor(0);
        h();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.b.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.o != null) {
                    b.this.o.h(view, iArr);
                }
            }
        };
        this.w.setOnClickListener(pVar);
        this.w.setOnTouchListener(pVar);
        this.w.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.b.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage10", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (b.this.o != null) {
                    b.this.o.a(view, i4, z);
                }
            }
        });
    }
}

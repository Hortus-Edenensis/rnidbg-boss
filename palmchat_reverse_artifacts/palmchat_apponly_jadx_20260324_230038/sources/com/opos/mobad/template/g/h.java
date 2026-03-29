package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class h implements com.opos.mobad.template.a {
    private int d;
    private int e;
    private TextView f;
    private Context g;
    private a.InterfaceC0778a h;
    private int i;
    private int j;
    private com.opos.mobad.template.d.b k;
    private ImageView l;
    private ad m;
    private com.opos.mobad.template.cmn.w n;
    private RelativeLayout o;
    private RelativeLayout p;
    private s q;
    private x r;
    private TextView s;
    private com.opos.mobad.template.cmn.aa u;
    private com.opos.mobad.d.a v;
    private com.opos.mobad.template.e.c.a w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9763a = false;
    private int b = 256;
    private int c = 144;
    private boolean t = false;
    private boolean x = false;

    private h(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.g = context;
        this.j = i2;
        this.i = i;
        this.v = aVar;
        f();
        a(amVar);
        q();
        p();
    }

    private void f() {
        Context context;
        int i = this.j;
        float f = 212.0f;
        if (i == 1) {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
            context = this.g;
        } else {
            if (i == 2) {
                this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
                this.d = com.opos.cmn.an.h.f.a.a(this.g, 212.0f);
                this.e = this.b;
                this.t = true;
                return;
            }
            if (i != 3) {
                return;
            }
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 328.0f);
            this.c = com.opos.cmn.an.h.f.a.a(this.g, 184.0f);
            context = this.g;
            f = 258.0f;
        }
        this.d = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = this.b;
    }

    private boolean g() {
        return this.j == 3;
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        RelativeLayout relativeLayout2 = this.p;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        s sVar = this.q;
        if (sVar != null) {
            layoutParams.addRule(3, sVar.getId());
        }
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        if (this.t) {
            k();
        } else {
            l();
        }
        if (!g()) {
            m();
        } else {
            j();
            i();
        }
    }

    private void i() {
        this.m = ad.a(this.g, 9, this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        this.m.setId(View.generateViewId());
        this.m.setVisibility(4);
        this.o.addView(this.m, layoutParams);
    }

    private void j() {
        TextView textView = new TextView(this.g);
        this.f = textView;
        textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_description_color));
        this.f.setTextSize(1, 12.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.g, 48.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        layoutParams.addRule(12);
        this.f.setVisibility(4);
        this.o.addView(this.f, layoutParams);
    }

    private void k() {
        this.r = x.a(this.g, this.b, this.c, true);
        this.o.addView(this.r, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void l() {
        this.l = new ImageView(this.g);
        this.o.addView(this.l, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void m() {
        this.m = ad.a(this.g, false, this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        this.m.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.o.addView(this.m, layoutParams);
    }

    private void n() {
        s sVarA = s.a(this.g, 2, true, this.v, true);
        this.q = sVarA;
        sVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.g, 74.0f));
        this.q.setVisibility(4);
        this.n.addView(this.q, layoutParams);
    }

    private void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.p = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.g, 44.0f));
        this.p.setVisibility(4);
        TextView textView = new TextView(this.g);
        this.s = textView;
        textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
        this.s.setTextSize(1, 12.0f);
        this.s.setGravity(17);
        this.s.setMaxLines(1);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.rightMargin = iA;
        this.p.addView(this.s, layoutParams2);
        this.n.addView(this.p, layoutParams);
    }

    private void p() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.h.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (h.this.k == null) {
                    return;
                }
                if (z) {
                    if (h.this.h != null) {
                        h.this.h.a(com.opos.mobad.template.h.a(h.this.w));
                    }
                    aVar.a((a.InterfaceC0735a) null);
                    if (h.this.w != null && h.this.w.c() != null) {
                        h.this.w.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImage5", "blockBigImage5 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.h.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (h.this.k == null) {
                    return;
                }
                if (h.this.h != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(h.this.w);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    h.this.h.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage5", "blockBigImage5 onWindowVisibilityChanged：" + z + ", " + z2);
            }
        }, c());
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void q() {
        this.o.setVisibility(0);
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.setVisibility(0);
        }
        ad adVar = this.m;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.u;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage5", "destroy");
        this.k = null;
        this.f9763a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.u;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.r;
        if (xVar != null) {
            xVar.a();
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.f();
            this.w.j();
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.i;
    }

    public static h a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new h(context, amVar, i, 1, aVar);
    }

    public static h b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new h(context, amVar, i, 2, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        String str = bVar.b;
        if (!TextUtils.isEmpty(str) && (textView = this.s) != null) {
            textView.setText(str);
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.a(bVar, this.v, this.f9763a);
        }
    }

    private void f(com.opos.mobad.template.d.b bVar) {
        this.m.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
    }

    public static h c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new h(context, amVar, i, 3, aVar);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.l) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.h.6
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (h.this.f9763a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage5", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (h.this.h != null) {
                        h.this.h.c(i);
                    }
                } else {
                    if (i == 1 && h.this.h != null) {
                        h.this.h.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.h.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (h.this.f9763a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            h.this.l.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        if (this.t) {
            c(bVar);
        } else {
            e(bVar);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(bVar.f9413a);
        }
        if (g()) {
            return;
        }
        f(bVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        x xVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (xVar = this.r) == null) {
            return;
        }
        xVar.a(bVar, this.v, this.f9763a, bVar.y);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.h = interfaceC0778a;
        ad adVar = this.m;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.r;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.x) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.g, e(), bVar.L);
            this.w = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.h.1
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (h.this.h != null) {
                        h.this.h.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (h.this.h != null) {
                        h.this.h.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (h.this.h != null) {
                        h.this.h.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (h.this.h != null) {
                        h.this.h.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
            if (this.o != null && this.w.c() != null) {
                this.o.addView(this.w.c(), layoutParams);
            }
            this.x = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.w;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage5", "data is null");
            this.h.a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage5", "adShowData is null");
            this.h.a(1);
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVarA.c;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.b("BlockBigImage5", "imgList is null");
            this.h.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage5", "render");
        if (this.k == null && (interfaceC0778a = this.h) != null) {
            interfaceC0778a.f();
        }
        this.k = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.u;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.n;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        b(bVarA);
        a(bVarA);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.g);
        }
        Context context = this.g;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.u = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.n = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.n.setId(View.generateViewId());
        this.n.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.u.addView(this.n, layoutParams);
        this.u.setLayoutParams(layoutParams);
        if (g()) {
            n();
        } else {
            o();
        }
        h();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.h.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (h.this.h != null) {
                    h.this.h.h(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(pVar);
        this.n.setOnTouchListener(pVar);
        this.n.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.h.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage5", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (h.this.h != null) {
                    h.this.h.a(view, i4, z);
                }
            }
        });
    }
}

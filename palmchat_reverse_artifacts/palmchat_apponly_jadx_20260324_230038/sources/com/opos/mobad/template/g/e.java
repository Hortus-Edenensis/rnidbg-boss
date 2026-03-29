package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
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
public class e implements com.opos.mobad.template.a {
    private int d;
    private int e;
    private TextView g;
    private com.opos.mobad.template.e.c.a h;
    private Context j;
    private a.InterfaceC0778a k;
    private int l;
    private int m;
    private com.opos.mobad.template.d.b n;
    private ImageView o;
    private ad p;
    private com.opos.mobad.template.cmn.w q;
    private RelativeLayout r;
    private s s;
    private y t;
    private RelativeLayout u;
    private x v;
    private com.opos.mobad.template.cmn.aa w;
    private RelativeLayout x;
    private com.opos.mobad.template.cmn.b y;
    private com.opos.mobad.d.a z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9733a = false;
    private int b = 256;
    private int c = 144;
    private int f = 64;
    private boolean i = false;

    /* JADX INFO: renamed from: com.opos.mobad.template.g.e$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f9739a;

        public AnonymousClass6(com.opos.mobad.template.d.b bVar) {
            this.f9739a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f9733a) {
                com.opos.cmn.an.f.a.b("BlockBigImage2", "load ima but has destroyed");
            } else {
                com.opos.mobad.template.d.e eVar = this.f9739a.k;
                com.opos.mobad.template.h.b(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(e.this.j, e.this.y.b), com.opos.cmn.an.h.f.a.a(e.this.j, e.this.y.b), e.this.z, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.g.e.6.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.e.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (e.this.f9733a) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage2", "load bitmap but has destroy");
                                } else if (bitmap == null) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage2", "null bitmap");
                                } else {
                                    e.this.y.a(bitmap, 16);
                                }
                            }
                        });
                    }
                }, e.this.k);
            }
        }
    }

    private e(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.j = context;
        this.m = i2;
        this.l = i;
        this.z = aVar;
        f();
        a(amVar);
        r();
        q();
    }

    public static e d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new e(context, amVar, i, 9, aVar);
    }

    private void i() {
        this.x = new RelativeLayout(this.j);
        this.r.addView(this.x, new RelativeLayout.LayoutParams(this.b, this.c));
        this.y = com.opos.mobad.template.cmn.b.a(this.j, 1);
        this.x.addView(this.y, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        this.u = new RelativeLayout(this.j);
        if (p()) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1979711488});
            gradientDrawable.setShape(0);
            this.u.setBackground(gradientDrawable);
        } else {
            this.u.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f);
        this.u.setVisibility(4);
        layoutParams.addRule(12);
        this.r.addView(this.u, layoutParams);
    }

    private void k() {
        this.o = new ImageView(this.j);
        this.r.addView(this.o, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void l() {
        TextView textView = new TextView(this.j);
        this.g = textView;
        textView.setTextColor(this.j.getResources().getColor(R.color.opos_mobad_description_color));
        this.g.setTextSize(1, 12.0f);
        this.g.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.g.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.g.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.j, 48.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.j, 8.0f);
        layoutParams.addRule(12);
        this.g.setVisibility(4);
        this.r.addView(this.g, layoutParams);
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (p()) {
            this.p = ad.a(this.j, 2, this.z);
        } else {
            this.p = ad.a(this.j, false, this.z);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 16.0f);
        }
        this.p.setVisibility(4);
        this.r.addView(this.p, layoutParams);
    }

    private void n() {
        this.p = ad.a(this.j, 9, this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
        this.p.setId(View.generateViewId());
        this.p.setVisibility(4);
        this.r.addView(this.p, layoutParams);
    }

    private void o() {
        j();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (p()) {
            y yVarB = y.b(this.j);
            this.t = yVarB;
            yVarB.setGravity(3);
        } else {
            this.t = y.a(this.j);
            layoutParams.addRule(14);
        }
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.j, 10.0f);
        this.t.setVisibility(4);
        this.r.addView(this.t, layoutParams);
    }

    private boolean p() {
        int i = this.m;
        return i == 7 || i == 8 || i == 9;
    }

    private void q() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.j);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.e.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (e.this.n == null) {
                    return;
                }
                if (z) {
                    if (e.this.k != null) {
                        e.this.k.a(com.opos.mobad.template.h.a(e.this.h));
                    }
                    aVar.a((a.InterfaceC0735a) null);
                    if (e.this.h != null && e.this.h.c() != null) {
                        e.this.h.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImage2", "blockBigImage2 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.e.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (e.this.n == null) {
                    return;
                }
                if (e.this.k != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(e.this.h);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    e.this.k.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage2", "blockBigImage2 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.q.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void r() {
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        TextView textView = this.g;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ad adVar = this.p;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.w;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.l;
    }

    public static e a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new e(context, amVar, i, 6, aVar);
    }

    public static e b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new e(context, amVar, i, 7, aVar);
    }

    private void f() {
        Context context;
        float f;
        int iA;
        Context context2;
        float f2;
        switch (this.m) {
            case 6:
                this.b = com.opos.cmn.an.h.f.a.a(this.j, 256.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.j, 168.0f);
                context = this.j;
                f = 242.0f;
                this.d = com.opos.cmn.an.h.f.a.a(context, f);
                this.e = this.b;
                iA = com.opos.cmn.an.h.f.a.a(this.j, 70.0f);
                this.f = iA;
                break;
            case 7:
                this.b = com.opos.cmn.an.h.f.a.a(this.j, 328.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.j, 144.0f);
                context = this.j;
                f = 218.0f;
                this.d = com.opos.cmn.an.h.f.a.a(context, f);
                this.e = this.b;
                iA = com.opos.cmn.an.h.f.a.a(this.j, 70.0f);
                this.f = iA;
                break;
            case 8:
                this.b = com.opos.cmn.an.h.f.a.a(this.j, 328.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.j, 184.0f);
                context2 = this.j;
                f2 = 258.0f;
                this.d = com.opos.cmn.an.h.f.a.a(context2, f2);
                this.e = this.b;
                iA = com.opos.cmn.an.h.f.a.a(this.j, 64.0f);
                this.f = iA;
                break;
            case 9:
                this.b = com.opos.cmn.an.h.f.a.a(this.j, 328.0f);
                this.c = com.opos.cmn.an.h.f.a.a(this.j, 216.0f);
                context2 = this.j;
                f2 = 290.0f;
                this.d = com.opos.cmn.an.h.f.a.a(context2, f2);
                this.e = this.b;
                iA = com.opos.cmn.an.h.f.a.a(this.j, 64.0f);
                this.f = iA;
                break;
        }
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.j);
        this.r = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        s sVar = this.s;
        if (sVar != null) {
            layoutParams.addRule(3, sVar.getId());
        }
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        int i = this.m;
        if (i == 6) {
            h();
        } else if (i == 7) {
            i();
        } else {
            k();
        }
        if (p()) {
            n();
            l();
        } else {
            m();
            o();
        }
    }

    private void h() {
        this.v = x.a(this.j, this.b, this.c, true);
        this.r.addView(this.v, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage2", "destroy");
        this.n = null;
        this.f9733a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.w;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.a();
        }
        com.opos.mobad.template.e.c.a aVar = this.h;
        if (aVar != null) {
            aVar.f();
            this.h.j();
        }
        s sVar = this.s;
        if (sVar != null) {
            sVar.a();
        }
    }

    public static e c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new e(context, amVar, i, 8, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.s.a(bVar, this.z, this.f9733a);
    }

    private void e(com.opos.mobad.template.d.b bVar) {
        if (this.z == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "mBitmapCache is null");
        } else if (bVar.k == null || this.y == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "iconUrl is null");
        } else {
            com.opos.cmn.an.j.b.c(new AnonymousClass6(bVar));
        }
    }

    private void f(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.o) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.z.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.e.7
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (e.this.f9733a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage2", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (e.this.k != null) {
                        e.this.k.c(i);
                    }
                } else {
                    if (i == 1 && e.this.k != null) {
                        e.this.k.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (e.this.f9733a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            e.this.o.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        this.p.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
    }

    private void h(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        y yVar = this.t;
        if (yVar != null) {
            yVar.setVisibility(0);
            this.t.a(aVar.f9412a, aVar.b);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar = this.h;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar = this.h;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void a(int i, com.opos.mobad.d.a aVar) {
        this.s = p() ? s.a(this.j, 2, true, aVar, true) : s.a(this.j, i, aVar);
        this.s.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.j, 74.0f));
        this.s.setVisibility(4);
        this.q.addView(this.s, layoutParams);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        int i = this.m;
        if (i == 6) {
            c(bVar);
        } else if (i == 7) {
            e(bVar);
        } else {
            f(bVar);
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(bVar.f9413a);
        }
        if (p()) {
            return;
        }
        g(bVar);
        h(bVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        x xVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (xVar = this.v) == null) {
            return;
        }
        xVar.a(bVar, this.z, this.f9733a, bVar.y);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.k = interfaceC0778a;
        y yVar = this.t;
        if (yVar != null) {
            yVar.a(interfaceC0778a);
        }
        s sVar = this.s;
        if (sVar != null) {
            sVar.a(interfaceC0778a);
        }
        ad adVar = this.p;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.i) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.j, e(), bVar.L);
            this.h = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.e.5
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (e.this.k != null) {
                        e.this.k.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (e.this.k != null) {
                        e.this.k.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (e.this.k != null) {
                        e.this.k.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (e.this.k != null) {
                        e.this.k.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.j, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.j, 12.0f);
            if (this.r != null && this.h.c() != null) {
                this.r.addView(this.h.c(), layoutParams);
            }
            this.i = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.h;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.e eVar;
        List<com.opos.mobad.template.d.e> list;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "data is null");
            this.k.a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "adShowData is null");
            this.k.a(1);
            return;
        }
        if (this.m != 7 && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "imgList is null");
            this.k.a(1);
            return;
        }
        if (this.m == 7 && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.b("BlockBigImage2", "icon is null");
            this.k.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage2", "render");
        if (this.n == null && (interfaceC0778a = this.k) != null) {
            interfaceC0778a.f();
        }
        this.n = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.w;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.q;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.q.setVisibility(0);
        }
        b(bVarA);
        a(bVarA);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.j);
        }
        Context context = this.j;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.w = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.j);
        this.q = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.j, 16.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.q.setId(View.generateViewId());
        this.q.setBackgroundColor(this.j.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.w.addView(this.q, layoutParams);
        this.w.setLayoutParams(layoutParams);
        a(this.m, this.z);
        g();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.e.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (e.this.k != null) {
                    e.this.k.h(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(pVar);
        this.q.setOnTouchListener(pVar);
        this.q.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.e.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage2", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (e.this.k != null) {
                    e.this.k.a(view, i4, z);
                }
            }
        });
    }
}

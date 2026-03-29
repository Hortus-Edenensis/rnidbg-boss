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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements com.opos.mobad.template.a {
    private TextView e;
    private int f;
    private com.opos.mobad.template.e.c.a g;
    private Context i;
    private a.InterfaceC0778a j;
    private int k;
    private int l;
    private com.opos.mobad.template.d.b m;
    private ImageView n;
    private ad o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private com.opos.mobad.template.cmn.w q;
    private u r;
    private y s;
    private x t;
    private RelativeLayout u;
    private com.opos.mobad.template.cmn.aa v;
    private RelativeLayout w;
    private com.opos.mobad.template.cmn.b x;
    private com.opos.mobad.d.a y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9744a = false;
    private int b = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
    private int c = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
    private int d = 64;
    private boolean h = false;

    /* JADX INFO: renamed from: com.opos.mobad.template.g.f$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f9750a;

        public AnonymousClass6(com.opos.mobad.template.d.b bVar) {
            this.f9750a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f9744a) {
                com.opos.cmn.an.f.a.b("BlockBigImage3", "load ima but has destroyed");
            } else {
                com.opos.mobad.template.d.e eVar = this.f9750a.k;
                com.opos.mobad.template.h.b(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(f.this.i, f.this.x.b), com.opos.cmn.an.h.f.a.a(f.this.i, f.this.x.b), f.this.y, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.g.f.6.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.f.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (f.this.f9744a) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage3", "load bitmap but has destroy");
                                } else if (bitmap == null) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage3", "null bitmap");
                                } else {
                                    f.this.x.a(bitmap, 16);
                                }
                            }
                        });
                    }
                }, f.this.j);
            }
        }
    }

    private f(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.i = context;
        this.l = i2;
        this.k = i;
        this.y = aVar;
        f();
        a(amVar);
        u();
        t();
    }

    public static f d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new f(context, amVar, i, 9, aVar);
    }

    private void i() {
        TextView textView = new TextView(this.i);
        this.e = textView;
        textView.setTextColor(this.i.getResources().getColor(R.color.opos_mobad_description_color));
        this.e.setTextSize(1, 12.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.e.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
        layoutParams.addRule(12);
        this.e.setVisibility(4);
        this.q.addView(this.e, layoutParams);
    }

    private void j() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, com.opos.cmn.an.h.f.a.a(this.i, 60.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        if (q()) {
            this.r = u.a(this.i, 2, this.y, r(), true);
        } else {
            u uVarA = u.a(this.i);
            this.r = uVarA;
            uVarA.setId(View.generateViewId());
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        }
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
    }

    private void k() {
        this.w = new RelativeLayout(this.i);
        this.q.addView(this.w, new RelativeLayout.LayoutParams(this.b, this.c));
        this.x = com.opos.mobad.template.cmn.b.a(this.i, 1);
        this.w.addView(this.x, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        this.u = new RelativeLayout(this.i);
        if (q()) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1979711488});
            gradientDrawable.setShape(0);
            this.u.setBackground(gradientDrawable);
        } else {
            this.u.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.d);
        this.u.setVisibility(0);
        layoutParams.addRule(12);
        this.q.addView(this.u, layoutParams);
    }

    private void m() {
        this.t = x.a(this.i, this.b, this.c, true);
        this.q.addView(this.t, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void n() {
        this.n = new ImageView(this.i);
        this.q.addView(this.n, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void o() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (q()) {
            this.o = ad.a(this.i, 1, this.y);
        } else {
            this.o = ad.a(this.i, false, this.y);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
        }
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    private void p() {
        ViewGroup viewGroup;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (q()) {
            y yVarB = y.b(this.i);
            this.s = yVarB;
            yVarB.setId(View.generateViewId());
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 10.0f);
            layoutParams.addRule(12);
            this.s.setGravity(3);
            this.s.setVisibility(4);
            viewGroup = this.q;
        } else {
            this.s = y.c(this.i);
            layoutParams.addRule(3, this.q.getId());
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 10.0f);
            layoutParams.addRule(14);
            this.s.setVisibility(4);
            viewGroup = this.p;
        }
        viewGroup.addView(this.s, layoutParams);
    }

    private boolean q() {
        int i = this.l;
        return i == 7 || i == 8 || i == 9;
    }

    private boolean r() {
        int i = this.l;
        return i == 7 || i == 9;
    }

    private boolean s() {
        return this.l == 8;
    }

    private void t() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.f.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (f.this.m == null) {
                    return;
                }
                if (z) {
                    if (f.this.j != null) {
                        f.this.j.a(com.opos.mobad.template.h.a(f.this.g));
                    }
                    aVar.a((a.InterfaceC0735a) null);
                    if (f.this.g != null && f.this.g.c() != null) {
                        f.this.g.c().setVisibility(0);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImage3", "blockBigImage3 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.f.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (f.this.m == null) {
                    return;
                }
                if (f.this.j != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(f.this.g);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    f.this.j.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage3", "blockBigImage3 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.p.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void u() {
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ad adVar = this.o;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.v;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.k;
    }

    public static f a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new f(context, amVar, i, 6, aVar);
    }

    public static f b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new f(context, amVar, i, 7, aVar);
    }

    private void f() {
        Context context;
        this.d = com.opos.cmn.an.h.f.a.a(this.i, 64.0f);
        float f = 216.0f;
        switch (this.l) {
            case 6:
            case 9:
                this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                context = this.i;
                break;
            case 7:
            case 8:
                this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                context = this.i;
                f = 184.0f;
                break;
            default:
                this.f = this.c + com.opos.cmn.an.h.f.a.a(this.i, 24.0f);
        }
        this.c = com.opos.cmn.an.h.f.a.a(context, f);
        this.f = this.c + com.opos.cmn.an.h.f.a.a(this.i, 24.0f);
    }

    private void g() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.q = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        this.q.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.q.setVisibility(4);
        this.p.addView(this.q, layoutParams);
        int i = this.l;
        if (i == 6) {
            m();
        } else if (i == 7) {
            k();
        } else {
            n();
        }
        l();
        if (!q()) {
            o();
        } else {
            i();
            h();
        }
    }

    private void h() {
        this.o = ad.a(this.i, 8, this.y);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.o.setId(View.generateViewId());
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage3", "destroy");
        this.m = null;
        this.f9744a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.v;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.t;
        if (xVar != null) {
            xVar.a();
        }
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.j();
        }
        u uVar = this.r;
        if (uVar != null) {
            uVar.a();
        }
    }

    public static f c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new f(context, amVar, i, 8, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.r.a(bVar);
    }

    private void e(com.opos.mobad.template.d.b bVar) {
        if (this.y == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage3", "mBitmapCache is null");
        } else if (bVar.k == null || this.x == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage3", "iconUrl is null");
        } else {
            com.opos.cmn.an.j.b.c(new AnonymousClass6(bVar));
        }
    }

    private void f(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.n) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.y.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.f.7
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (f.this.f9744a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage3", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (f.this.j != null) {
                        f.this.j.c(i);
                    }
                } else {
                    if (i == 1 && f.this.j != null) {
                        f.this.j.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.f.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (f.this.f9744a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            f.this.n.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        this.o.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
    }

    private void h(com.opos.mobad.template.d.b bVar) {
        y yVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (yVar = this.s) == null) {
            return;
        }
        yVar.setVisibility(0);
        this.s.a(aVar.f9412a, aVar.b);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        int i = this.l;
        if (i == 6) {
            c(bVar);
        } else if (i == 7) {
            e(bVar);
        } else {
            f(bVar);
        }
        if (q()) {
            return;
        }
        g(bVar);
        h(bVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        x xVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (xVar = this.t) == null) {
            return;
        }
        xVar.a(bVar, this.y, this.f9744a, bVar.y);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        u uVar = this.r;
        if (uVar != null) {
            uVar.a(interfaceC0778a);
        }
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0778a);
        }
        ad adVar = this.o;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.t;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        RelativeLayout.LayoutParams layoutParams;
        if (!this.h) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.i, e(), bVar.L);
            this.g = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.f.5
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (f.this.j != null) {
                        f.this.j.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (f.this.j != null) {
                        f.this.j.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (f.this.j != null) {
                        f.this.j.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (f.this.j != null) {
                        f.this.j.a(iArr);
                    }
                }
            });
            if (s()) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.i, 28.0f));
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 12.0f);
            }
            if (this.q != null && this.g.c() != null) {
                this.q.addView(this.g.c(), layoutParams);
            }
            this.h = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.g;
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
            com.opos.cmn.an.f.a.b("BlockBigImage3", "data is null");
            this.j.a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage3", "adShowData is null");
            this.j.a(1);
            return;
        }
        if (this.l != 7 && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.b("BlockBigImage3", "imgList is null");
            this.j.a(1);
            return;
        }
        if (this.l == 7 && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.b("BlockBigImage3", "icon is null");
            this.j.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage3", "render");
        if (this.m == null && (interfaceC0778a = this.j) != null) {
            interfaceC0778a.f();
        }
        this.m = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.v;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.p;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        b(bVarA);
        a(bVarA);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.i);
        }
        Context context = this.i;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.v = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.f));
        this.p = new com.opos.mobad.template.cmn.baseview.c(this.i);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.p.setId(View.generateViewId());
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams2.addRule(13);
        this.v.addView(this.p, layoutParams2);
        this.v.setLayoutParams(layoutParams);
        g();
        if (!q()) {
            p();
        }
        j();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.f.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.j != null) {
                    f.this.j.h(view, iArr);
                }
            }
        };
        this.p.setOnClickListener(pVar);
        this.p.setOnTouchListener(pVar);
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.f.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage3", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (f.this.j != null) {
                    f.this.j.a(view, i4, z);
                }
            }
        });
    }
}

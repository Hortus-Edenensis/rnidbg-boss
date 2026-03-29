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
public class a implements com.opos.mobad.template.a {
    private int d;
    private int e;
    private com.opos.mobad.template.e.c.a g;
    private Context i;
    private a.InterfaceC0778a j;
    private int k;
    private int l;
    private com.opos.mobad.template.d.b m;
    private ImageView n;
    private ad o;
    private com.opos.mobad.template.cmn.w p;
    private RelativeLayout q;
    private s r;
    private y s;
    private RelativeLayout t;
    private x u;
    private com.opos.mobad.template.cmn.aa v;
    private RelativeLayout w;
    private com.opos.mobad.template.cmn.b x;
    private com.opos.mobad.d.a y;
    private TextView z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9643a = false;
    private int b = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
    private int c = 144;
    private int f = 64;
    private boolean h = false;

    /* JADX INFO: renamed from: com.opos.mobad.template.g.a$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f9649a;

        public AnonymousClass6(com.opos.mobad.template.d.b bVar) {
            this.f9649a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f9643a) {
                com.opos.cmn.an.f.a.b("BlockBigImage1", "load ima but has destroyed");
            } else {
                com.opos.mobad.template.d.e eVar = this.f9649a.k;
                com.opos.mobad.template.h.b(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(a.this.i, a.this.x.b), com.opos.cmn.an.h.f.a.a(a.this.i, a.this.x.b), a.this.y, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.g.a.6.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.a.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.f9643a) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage1", "load bitmap but has destroy");
                                } else if (bitmap == null) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage1", "null bitmap");
                                } else {
                                    a.this.x.a(bitmap, 16);
                                }
                            }
                        });
                    }
                }, a.this.j);
            }
        }
    }

    private a(Context context, int i, am amVar, int i2, com.opos.mobad.d.a aVar) {
        this.i = context;
        this.l = i2;
        this.k = i;
        this.y = aVar;
        f();
        a(amVar);
        u();
        t();
    }

    public static a d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 8, aVar);
    }

    private void i() {
        TextView textView = new TextView(this.i);
        this.z = textView;
        textView.setTextColor(this.i.getResources().getColor(R.color.opos_mobad_description_color));
        this.z.setTextSize(1, 12.0f);
        this.z.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.z.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 296.0f), com.opos.cmn.an.h.f.a.a(this.i, 16.0f));
        this.z.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 8.0f);
        layoutParams.addRule(12);
        this.z.setVisibility(4);
        this.q.addView(this.z, layoutParams);
    }

    private void j() {
        this.u = x.a(this.i, this.b, this.c, true);
        this.q.addView(this.u, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void k() {
        this.w = new RelativeLayout(this.i);
        this.q.addView(this.w, new RelativeLayout.LayoutParams(this.b, this.c));
        this.x = com.opos.mobad.template.cmn.b.a(this.i, 1);
        this.w.addView(this.x, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        this.t = new RelativeLayout(this.i);
        if (q()) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1979711488});
            gradientDrawable.setShape(0);
            this.t.setBackground(gradientDrawable);
        } else {
            this.t.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f);
        this.t.setVisibility(4);
        layoutParams.addRule(12);
        this.q.addView(this.t, layoutParams);
    }

    private void m() {
        this.n = new ImageView(this.i);
        this.q.addView(this.n, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void n() {
        ad adVarA;
        Context context;
        int i;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (q()) {
            context = this.i;
            i = 1;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
            if (this.l != 6) {
                adVarA = ad.a(this.i, false, this.y);
                this.o = adVarA;
                this.o.setVisibility(4);
                this.q.addView(this.o, layoutParams);
            }
            context = this.i;
            i = 11;
        }
        adVarA = ad.a(context, i, this.y);
        this.o = adVarA;
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    private void o() {
        l();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        if (q()) {
            y yVarB = y.b(this.i);
            this.s = yVarB;
            yVarB.setGravity(3);
        } else {
            this.s = y.a(this.i);
            layoutParams.addRule(14);
        }
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, 10.0f);
        this.s.setVisibility(4);
        this.q.addView(this.s, layoutParams);
    }

    private void p() {
        this.r = q() ? s.a(this.i, 2, r(), this.y, true) : s.a(this.i, 0, (com.opos.mobad.d.a) null);
        this.r.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.i, 74.0f));
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.r.setVisibility(4);
        this.p.addView(this.r, layoutParams);
    }

    private boolean q() {
        int i = this.l;
        return (i == 2 || i == 6) ? false : true;
    }

    private boolean r() {
        int i = this.l;
        return i == 7 || i == 11 || i == 9;
    }

    private boolean s() {
        return this.l == 8;
    }

    private void t() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.a.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (a.this.m == null) {
                    return;
                }
                if (z) {
                    if (a.this.j != null) {
                        a.this.j.a(com.opos.mobad.template.h.a(a.this.g));
                    }
                    if (a.this.g != null && a.this.g.c() != null) {
                        a.this.g.c().setVisibility(0);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage1", "blockBigImage1 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.a.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (a.this.m == null) {
                    return;
                }
                if (a.this.j != null) {
                    Map<String, String> mapA = com.opos.mobad.template.h.a(a.this.g);
                    mapA.put("isVisibleRect", String.valueOf(z));
                    mapA.put("isAttached", String.valueOf(z2));
                    a.this.j.a(mapA);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage1", "blockBigImage1 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.p.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void u() {
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        ad adVar = this.o;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setVisibility(0);
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

    public static a a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 2, aVar);
    }

    public static a b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 6, aVar);
    }

    public static a f(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 11, aVar);
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.q = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.q.setVisibility(4);
        this.p.addView(this.q, layoutParams);
        int i = this.l;
        if (i == 2 || i == 6) {
            j();
        } else if (i == 7) {
            k();
        } else {
            m();
        }
        if (q()) {
            i();
            h();
        } else {
            n();
            o();
        }
    }

    private void h() {
        this.o = ad.a(this.i, 8, this.y);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.o.setVisibility(4);
        this.q.addView(this.o, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage1", "destroy");
        this.m = null;
        this.f9643a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.v;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.u;
        if (xVar != null) {
            xVar.a();
        }
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
            this.g.j();
        }
        s sVar = this.r;
        if (sVar != null) {
            sVar.a();
        }
    }

    public static a c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 7, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.r.a(bVar, this.y, this.f9643a);
    }

    public static a e(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new a(context, i, amVar, 9, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        int iA;
        int iA2;
        Context context;
        float f;
        Context context2;
        int i = this.l;
        float f2 = 242.0f;
        if (i != 2) {
            if (i != 11) {
                switch (i) {
                    case 6:
                        this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                        this.c = com.opos.cmn.an.h.f.a.a(this.i, 168.0f);
                        context2 = this.i;
                        this.d = com.opos.cmn.an.h.f.a.a(context2, f2);
                        this.e = this.b;
                        iA2 = com.opos.cmn.an.h.f.a.a(this.i, 70.0f);
                        break;
                    case 7:
                        this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                        this.c = com.opos.cmn.an.h.f.a.a(this.i, 144.0f);
                        context2 = this.i;
                        f2 = 218.0f;
                        this.d = com.opos.cmn.an.h.f.a.a(context2, f2);
                        this.e = this.b;
                        iA2 = com.opos.cmn.an.h.f.a.a(this.i, 70.0f);
                        break;
                    case 8:
                        this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                        this.c = com.opos.cmn.an.h.f.a.a(this.i, 184.0f);
                        context = this.i;
                        f = 258.0f;
                        iA = com.opos.cmn.an.h.f.a.a(context, f);
                        break;
                    case 9:
                        this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
                        this.c = com.opos.cmn.an.h.f.a.a(this.i, 216.0f);
                        context = this.i;
                        f = 290.0f;
                        iA = com.opos.cmn.an.h.f.a.a(context, f);
                        break;
                }
            }
            this.f = iA2;
        }
        this.b = com.opos.cmn.an.h.f.a.a(this.i, 328.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.i, 168.0f);
        iA = com.opos.cmn.an.h.f.a.a(this.i, 242.0f);
        this.d = iA;
        this.e = this.b;
        iA2 = com.opos.cmn.an.h.f.a.a(this.i, 64.0f);
        this.f = iA2;
    }

    private void g(com.opos.mobad.template.d.b bVar) {
        if (this.l == 6) {
            this.o.a(bVar);
        } else {
            this.o.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
        }
    }

    private void h(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        y yVar = this.s;
        if (yVar != null) {
            yVar.setVisibility(0);
            this.s.a(aVar.f9412a, aVar.b);
        }
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
        com.opos.mobad.template.e.c.a aVar = this.g;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        int i = this.l;
        if (i == 2 || i == 6) {
            c(bVar);
        } else if (i == 7) {
            e(bVar);
        } else {
            f(bVar);
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(bVar.f9413a);
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
        if (list == null || list.size() == 0 || (xVar = this.u) == null) {
            return;
        }
        xVar.a(bVar, this.y, this.f9643a, bVar.y);
    }

    private void e(com.opos.mobad.template.d.b bVar) {
        if (this.y == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "mBitmapCache is null");
        } else if (bVar.k == null || this.x == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "iconUrl is null");
        } else {
            com.opos.cmn.an.j.b.c(new AnonymousClass6(bVar));
        }
    }

    private void f(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        if (this.y == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "mBitmapCache is null");
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.n) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "null imgList");
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.y.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.a.7
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (a.this.f9643a) {
                        return;
                    }
                    if (bVar.c.get(0) == null) {
                        com.opos.cmn.an.f.a.b("BlockBigImage1", "null imgList");
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (a.this.j != null) {
                            a.this.j.c(i);
                        }
                    } else {
                        if (i == 1 && a.this.j != null) {
                            a.this.j.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (a.this.f9643a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                a.this.n.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0778a);
        }
        s sVar = this.r;
        if (sVar != null) {
            sVar.a(interfaceC0778a);
        }
        ad adVar = this.o;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.u;
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
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.a.5
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (a.this.j != null) {
                        a.this.j.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (a.this.j != null) {
                        a.this.j.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (a.this.j != null) {
                        a.this.j.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (a.this.j != null) {
                        a.this.j.a(iArr);
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
            com.opos.cmn.an.f.a.b("BlockBigImage1", "data is null");
            this.j.a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "adShowData is null");
            this.j.a(1);
            return;
        }
        if (this.l != 7 && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "imgList is null");
            this.j.a(1);
            return;
        }
        if (this.l == 7 && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.b("BlockBigImage1", "icon is null");
            this.j.a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage1", "render");
        if (this.m == null && (interfaceC0778a = this.j) != null) {
            interfaceC0778a.f();
        }
        this.m = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.v;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.p;
        if (wVar != null && wVar.getVisibility() != 0) {
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
        this.v = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.i);
        this.p = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.p.setId(View.generateViewId());
        this.p.setBackgroundColor(this.i.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        this.v.addView(this.p, layoutParams);
        this.v.setLayoutParams(layoutParams);
        g();
        p();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.a.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (a.this.j != null) {
                    a.this.j.h(view, iArr);
                }
            }
        };
        this.p.setOnClickListener(pVar);
        this.p.setOnTouchListener(pVar);
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.a.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage1", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (a.this.j != null) {
                    a.this.j.a(view, i4, z);
                }
            }
        });
    }
}

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
public class d extends com.opos.mobad.template.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9722a;
    private int b;
    private int c;
    private int g;
    private int h;
    private com.opos.mobad.template.e.c.a i;
    private boolean j;
    private Context k;
    private int l;
    private com.opos.mobad.template.d.b m;
    private ImageView n;
    private ad o;
    private com.opos.mobad.template.cmn.w p;
    private RelativeLayout q;
    private t r;
    private RelativeLayout s;
    private x t;
    private com.opos.mobad.template.cmn.aa u;
    private RelativeLayout v;
    private com.opos.mobad.template.cmn.b w;
    private com.opos.mobad.d.a x;
    private TextView y;

    /* JADX INFO: renamed from: com.opos.mobad.template.g.d$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.mobad.template.d.b f9728a;

        public AnonymousClass6(com.opos.mobad.template.d.b bVar) {
            this.f9728a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.y()) {
                com.opos.cmn.an.f.a.b("BlockBigImage14", "load ima but has destroyed");
            } else {
                com.opos.mobad.template.d.e eVar = this.f9728a.k;
                com.opos.mobad.template.h.b(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(d.this.k, d.this.w.b), com.opos.cmn.an.h.f.a.a(d.this.k, d.this.w.b), d.this.x, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.g.d.6.1
                    @Override // com.opos.mobad.template.b
                    public void a(final Bitmap bitmap) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.d.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.this.y()) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage14", "load bitmap but has destroy");
                                } else if (bitmap == null) {
                                    com.opos.cmn.an.f.a.b("BlockBigImage14", "null bitmap");
                                } else {
                                    d.this.w.a(bitmap, 16);
                                }
                            }
                        });
                    }
                }, ((com.opos.mobad.template.j.a) d.this).e);
            }
        }
    }

    private d(Context context, int i, am amVar, int i2, com.opos.mobad.d.a aVar) {
        super(i);
        this.f9722a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE;
        this.b = MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO;
        this.h = 58;
        this.j = false;
        this.k = context;
        this.l = i2;
        this.x = aVar;
        i();
        a(amVar);
        x();
    }

    private void r() {
        this.s = new RelativeLayout(this.k);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1291845632});
        gradientDrawable.setShape(0);
        this.s.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f9722a, this.h);
        layoutParams.addRule(12);
        this.q.addView(this.s, layoutParams);
    }

    private void s() {
        TextView textView = new TextView(this.k);
        this.y = textView;
        textView.setTextColor(this.k.getResources().getColor(R.color.opos_mobad_description_color));
        this.y.setTextSize(1, 12.0f);
        this.y.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.y.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.y.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.k, 8.0f);
        layoutParams.addRule(12);
        this.q.addView(this.y, layoutParams);
    }

    private void t() {
        this.t = x.a(this.k, this.f9722a, this.b, true);
        this.q.addView(this.t, new RelativeLayout.LayoutParams(this.f9722a, this.b));
    }

    private void u() {
        this.v = new RelativeLayout(this.k);
        this.q.addView(this.v, new RelativeLayout.LayoutParams(this.f9722a, this.b));
        this.w = com.opos.mobad.template.cmn.b.a(this.k, 1);
        this.v.addView(this.w, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void v() {
        this.n = new ImageView(this.k);
        this.q.addView(this.n, new RelativeLayout.LayoutParams(this.f9722a, this.b));
    }

    private void w() {
        t tVarA = t.a(this.k, this.x);
        this.r = tVarA;
        tVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.g, com.opos.cmn.an.h.f.a.a(this.k, 130.0f));
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.p.addView(this.r, layoutParams);
    }

    private void x() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.k);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.d.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (d.this.m == null) {
                    return;
                }
                if (z) {
                    d.this.a(com.opos.mobad.template.h.a(d.this.i));
                    if (d.this.i != null && d.this.i.c() != null) {
                        d.this.i.c().setVisibility(0);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage14", "blockBigImage14 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.d.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (d.this.m == null) {
                    return;
                }
                Map<String, String> mapA = com.opos.mobad.template.h.a(d.this.i);
                mapA.put("isVisibleRect", String.valueOf(z));
                mapA.put("isAttached", String.valueOf(z2));
                d.this.b(mapA);
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage14", "blockBigImage14 onWindowVisibilityChanged：" + z + ", " + z2);
            }
        }, c());
        this.p.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        return n() == 8;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.u;
    }

    public static d a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new d(context, i, amVar, 0, aVar);
    }

    public static d b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new d(context, i, amVar, 1, aVar);
    }

    public static d d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new d(context, i, amVar, 3, aVar);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        if (this.x == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "mBitmapCache is null");
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.n) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "null imgList");
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.x.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.f9722a, this.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.d.7
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (d.this.y()) {
                        return;
                    }
                    if (bVar.c.get(0) == null) {
                        com.opos.cmn.an.f.a.b("BlockBigImage14", "null imgList");
                        return;
                    }
                    if (i != 0 && i != 1) {
                        d.this.b(i);
                        return;
                    }
                    if (i == 1 && ((com.opos.mobad.template.j.a) d.this).e != null) {
                        d.this.b(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.d.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (d.this.y() || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            d.this.n.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    private void i() {
        Context context;
        float f;
        int i = this.l;
        if (i == 0) {
            this.f9722a = com.opos.cmn.an.h.f.a.a(this.k, 328.0f);
            this.b = com.opos.cmn.an.h.f.a.a(this.k, 216.0f);
            context = this.k;
            f = 346.0f;
        } else {
            if (i != 1 && i != 2 && i != 3) {
                return;
            }
            this.f9722a = com.opos.cmn.an.h.f.a.a(this.k, 328.0f);
            this.b = com.opos.cmn.an.h.f.a.a(this.k, 184.0f);
            context = this.k;
            f = 314.0f;
        }
        this.c = com.opos.cmn.an.h.f.a.a(context, f);
        this.g = this.f9722a;
        this.h = com.opos.cmn.an.h.f.a.a(this.k, 58.0f);
    }

    private void p() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.q = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.p.addView(this.q, new RelativeLayout.LayoutParams(this.f9722a, this.b));
        int i = this.l;
        if (i == 2) {
            t();
        } else if (i == 3) {
            u();
        } else {
            v();
        }
        r();
        s();
        q();
    }

    private void q() {
        this.o = ad.a(this.k, 8, this.x);
        this.q.addView(this.o, new RelativeLayout.LayoutParams(-2, -2));
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.h();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.i();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("BlockBigImage14", "doEnd");
        this.m = null;
        com.opos.mobad.template.cmn.aa aaVar = this.u;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.t;
        if (xVar != null) {
            xVar.a();
        }
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.f();
            this.i.j();
        }
        t tVar = this.r;
        if (tVar != null) {
            tVar.a();
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.j) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.k, e(), bVar.L);
            this.i = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.g.d.5
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) d.this).e != null) {
                        ((com.opos.mobad.template.j.a) d.this).e.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) d.this).e != null) {
                        ((com.opos.mobad.template.j.a) d.this).e.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (((com.opos.mobad.template.j.a) d.this).e != null) {
                        ((com.opos.mobad.template.j.a) d.this).e.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (((com.opos.mobad.template.j.a) d.this).e != null) {
                        ((com.opos.mobad.template.j.a) d.this).e.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 12.0f);
            if (this.q != null && this.i.c() != null) {
                this.q.addView(this.i.c(), layoutParams);
            }
            this.j = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.i;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    public static d c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new d(context, i, amVar, 2, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        if (this.x == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "mBitmapCache is null");
        } else if (bVar.k == null || this.w == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "iconUrl is null");
        } else {
            com.opos.cmn.an.j.b.c(new AnonymousClass6(bVar));
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        t tVar = this.r;
        if (tVar != null) {
            tVar.a(interfaceC0778a);
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
        t tVar = this.r;
        if (tVar != null) {
            tVar.a(bVar, this.x, y());
        }
        int i = this.l;
        if (i == 2) {
            c(bVar);
        } else if (i == 3) {
            d(bVar);
        } else {
            e(bVar);
        }
        TextView textView = this.y;
        if (textView != null) {
            com.opos.mobad.template.d.a aVar = bVar.u;
            if (aVar == null) {
                textView.setVisibility(8);
            } else if (TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
                this.y.setVisibility(8);
            } else {
                this.y.setText(bVar.f9413a);
            }
        }
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        x xVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (xVar = this.t) == null) {
            return;
        }
        xVar.a(bVar, this.x, y(), bVar.y);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.e eVar;
        List<com.opos.mobad.template.d.e> list;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "data is null");
            a(1);
            return;
        }
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "adShowData is null");
            a(1);
            return;
        }
        if (this.l != 3 && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "imgList is null");
            a(1);
            return;
        }
        if (this.l == 3 && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.b("BlockBigImage14", "icon is null");
            a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage14", "render");
        if (this.m == null && this.e != null) {
            m();
        }
        this.m = bVarA;
        com.opos.mobad.template.cmn.aa aaVar = this.u;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.p;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        a(bVarA);
        b(bVarA);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.k);
        }
        Context context = this.k;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.f9722a;
        this.u = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.c));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.k);
        this.p = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.k, 16.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f9722a, this.c);
        layoutParams.width = this.f9722a;
        layoutParams.height = this.c;
        this.p.setId(View.generateViewId());
        this.p.setBackgroundColor(this.k.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        this.u.addView(this.p, layoutParams);
        this.u.setLayoutParams(layoutParams);
        p();
        w();
        com.opos.mobad.template.cmn.p.a(this.p, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.d.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                d.this.h(view, iArr);
            }
        });
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.d.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage14", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                d.this.a(view, i4, z);
            }
        });
    }
}

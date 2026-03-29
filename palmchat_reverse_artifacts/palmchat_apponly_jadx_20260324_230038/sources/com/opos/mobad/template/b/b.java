package com.opos.mobad.template.b;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.n;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.g.am;
import com.opos.mobad.template.g.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.opos.mobad.template.a {
    private Animator A;
    private w B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p f9295a;
    private volatile boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private Context i;
    private a.InterfaceC0778a j;
    private int k;
    private int l;
    private com.opos.mobad.template.d.b m;
    private com.opos.mobad.template.cmn.baseview.c n;
    private RelativeLayout o;
    private i p;
    private x q;
    private boolean r;
    private aa s;
    private n t;
    private RelativeLayout u;
    private com.opos.mobad.template.k.c v;
    private ImageView w;
    private RelativeLayout x;
    private com.opos.mobad.d.a y;
    private Animator z;

    private b(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this(context, amVar, i, i2, aVar, true);
    }

    public static b b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new b(context, amVar, i, 1, aVar);
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.o.setBackgroundColor(this.i.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        if (this.r) {
            n();
            j();
        } else {
            k();
        }
        l();
        if (this.r) {
            i();
        } else {
            h();
        }
    }

    private void h() {
        this.w = new ImageView(this.i);
        Drawable drawable = ContextCompat.getDrawable(this.i, R.drawable.opos_mobad_close);
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this.i, R.color.opos_mobad_banner_close_color));
        this.w.setImageDrawable(drawable);
        int iA = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.i, 4.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA2;
        this.o.addView(this.w, layoutParams);
        p.a(this.w, this.f9295a);
    }

    private void i() {
        this.x = new RelativeLayout(this.i);
        BaseImageView baseImageView = new BaseImageView(this.i);
        this.x.setId(View.generateViewId());
        baseImageView.setImageResource(com.opos.mobad.template.h.f(this.i) ? R.drawable.opos_mobad_drawable_block_close : R.drawable.opos_mobad_bottom_img_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 16.0f), com.opos.cmn.an.h.f.a.a(this.i, 16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.c, -2);
        this.x.addView(baseImageView, layoutParams);
        this.n.addView(this.x, layoutParams2);
        p.a(baseImageView, this.f9295a);
    }

    private void j() {
        this.v = com.opos.mobad.template.k.c.a(this.i, 0, 0, this.y);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.i, 14.0f));
        layoutParams.addRule(9);
        this.o.addView(this.v, layoutParams);
    }

    private void k() {
        Context context;
        float f;
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.u = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(this.i, 0.33f);
        this.u.setPadding(iA, iA, iA, iA);
        this.u.setBackgroundResource(this.l == 3 ? R.drawable.opos_mobad_drawable_block_icon_stroke : R.drawable.opos_mobad_drawable_block_icon_stroke2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.i, 16.0f);
        layoutParams.addRule(15);
        if (this.l == 3) {
            context = this.i;
            f = 8.0f;
        } else {
            context = this.i;
            f = 4.0f;
        }
        n nVar = new n(this.i, com.opos.cmn.an.h.f.a.a(context, f));
        this.t = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
        this.o.addView(this.u, layoutParams);
    }

    private void l() {
        if (this.l == 2) {
            this.p = i.a(this.i, this.y);
        } else {
            this.p = i.b(this.i, this.y);
            m();
        }
        this.p.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c - this.e, -2);
        layoutParams.addRule(15);
        if (this.l == 2) {
            b(layoutParams);
        } else {
            a(layoutParams);
        }
        this.p.setVisibility(4);
        this.o.addView(this.p, layoutParams);
    }

    @TargetApi(21)
    private void m() {
        this.z = a.a(this.t);
        View viewA = this.p.a();
        this.B = new w(this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, viewA.getId());
        layoutParams.addRule(7, viewA.getId());
        layoutParams.addRule(6, viewA.getId());
        layoutParams.addRule(8, viewA.getId());
        layoutParams.addRule(13);
        this.B.setBackgroundColor(0);
        this.B.a(com.opos.cmn.an.h.f.a.a(this.i, 60.0f));
        this.p.addView(this.B, layoutParams);
        this.A = a.a((RelativeLayout) this.B);
    }

    private void n() {
        x xVarB = x.b(this.i, this.e, this.d, false);
        this.q = xVarB;
        xVarB.setId(View.generateViewId());
        int i = this.e;
        this.o.addView(this.q, new RelativeLayout.LayoutParams(i, i));
    }

    private void o() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.i);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.b.b.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (b.this.m == null) {
                    return;
                }
                if (z) {
                    if (b.this.j != null) {
                        b.this.j.a((Map<String, String>) null);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                    if (b.this.z != null) {
                        b.this.z.start();
                    }
                    if (b.this.A != null) {
                        b.this.A.start();
                    }
                }
                com.opos.cmn.an.f.a.b("BannerBigImage", "BannerBigImage onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.b.b.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (b.this.m == null) {
                    return;
                }
                if (b.this.j != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    b.this.j.a(map);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BannerBigImage", "BannerBigImage onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void p() {
        this.o.setVisibility(0);
        this.p.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.k;
    }

    private b(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar, boolean z) {
        this.b = false;
        this.c = 360;
        this.d = 62;
        this.h = true;
        this.r = false;
        this.f9295a = new p() { // from class: com.opos.mobad.template.b.b.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.j != null) {
                    b.this.j.e(view, iArr);
                }
            }
        };
        this.i = context;
        this.l = i2;
        this.k = i;
        this.y = aVar;
        this.h = z;
        f();
        a(amVar);
        p();
        o();
    }

    public static b a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return a(context, amVar, i, aVar, true);
    }

    public static b d(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new b(context, amVar, i, 3, aVar);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        if (this.u == null) {
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
        } else {
            this.t.setScaleType(ImageView.ScaleType.FIT_XY);
            this.y.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.c, this.d, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.b.b.8
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, Bitmap bitmap) {
                    if (b.this.b) {
                        return;
                    }
                    if (bVar.c.get(0) == null) {
                        com.opos.cmn.an.f.a.b("BannerBigImage", "null imgList");
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.j != null) {
                            b.this.j.c(i);
                        }
                    } else {
                        if (i == 1 && b.this.j != null) {
                            b.this.j.c(i);
                        }
                        b.this.b(bitmap);
                    }
                }
            });
        }
    }

    private void f() {
        Context context;
        float f;
        int iA;
        this.c = com.opos.cmn.an.h.f.a.a(this.i, 360.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.i, 62.0f);
        int i = this.l;
        if (i == 0) {
            context = this.i;
            f = 75.0f;
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.e = com.opos.cmn.an.h.f.a.a(this.i, 91.43f);
                    this.r = true;
                } else if (i == 3) {
                    iA = com.opos.cmn.an.h.f.a.a(this.i, 42.0f);
                    this.e = iA;
                    this.f = com.opos.cmn.an.h.f.a.a(this.i, 42.0f);
                }
                this.g = this.d;
            }
            context = this.i;
            f = 64.0f;
        }
        iA = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = iA;
        this.f = com.opos.cmn.an.h.f.a.a(this.i, 42.0f);
        this.g = this.d;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.s;
    }

    public static b a(Context context, am amVar, int i, com.opos.mobad.d.a aVar, boolean z) {
        return new b(context, amVar, i, 0, aVar, z);
    }

    public static b c(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new b(context, amVar, i, 2, aVar);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        Animator animator = this.z;
        if (animator != null) {
            animator.resume();
        }
        Animator animator2 = this.A;
        if (animator2 != null) {
            animator2.resume();
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerBigImage", "destroy");
        this.m = null;
        this.b = true;
        aa aaVar = this.s;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.q;
        if (xVar != null) {
            xVar.a();
        }
        Animator animator = this.z;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.A;
        if (animator2 != null) {
            animator2.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.b.b.9
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (b.this.b || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                b.this.t.setImageBitmap(bitmap);
            }
        });
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (this.q == null) {
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list != null && list.size() > 0) {
            this.q.a(bVar, this.y, this.b, 3000);
        } else {
            com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
            this.j.a(1);
        }
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.p.a(bVar.j, bVar.b, bVar.f9413a);
        this.p.a(bVar);
        if (this.l != 2) {
            this.p.b(bVar);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        Animator animator = this.z;
        if (animator != null) {
            animator.pause();
        }
        Animator animator2 = this.A;
        if (animator2 != null) {
            animator2.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.b.b.7
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (b.this.b || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                b.this.t.setImageBitmap(bitmap);
            }
        });
    }

    private void b(RelativeLayout.LayoutParams layoutParams) {
        x xVar = this.q;
        if (xVar != null) {
            layoutParams.addRule(1, xVar.getId());
        }
    }

    private void a(RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            layoutParams.addRule(1, relativeLayout.getId());
        }
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.k.c cVar = this.v;
        if (cVar == null) {
            return;
        }
        cVar.a(bVar.p, bVar.e, bVar.g, bVar.i);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.j = interfaceC0778a;
        this.p.a(interfaceC0778a);
        x xVar = this.q;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.k.c cVar = this.v;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        if (this.l == 3) {
            a(bVar.k);
            return;
        }
        if (this.r) {
            c(bVar);
        } else {
            e(bVar);
        }
        b(bVar);
    }

    private void a(com.opos.mobad.template.d.e eVar) {
        if (this.u == null) {
            return;
        }
        a(eVar, this.y, this.b);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, final boolean z) {
        this.t.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "iconUrl is null or empty");
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(this.i, 42.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.b.b.6
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, Bitmap bitmap) {
                    if (z) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (b.this.j != null) {
                            b.this.j.c(i);
                        }
                    } else {
                        if (i == 1 && b.this.j != null) {
                            b.this.j.c(i);
                        }
                        b.this.a(bitmap);
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        List<com.opos.mobad.template.d.e> list;
        String str;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA == null) {
                str = "adShowData is null";
            } else {
                if (this.l != 2 || ((list = bVarA.c) != null && list.size() > 0)) {
                    com.opos.cmn.an.f.a.b("BannerBigImage", "render");
                    if (this.m == null && (interfaceC0778a = this.j) != null) {
                        interfaceC0778a.f();
                    }
                    this.m = bVarA;
                    aa aaVar = this.s;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.baseview.c cVar = this.n;
                    if (cVar != null && cVar.getVisibility() != 0) {
                        this.n.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerBigImage", str);
        this.j.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.i);
        }
        Context context = this.i;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.c;
        this.s = new aa(context, new aa.a(i, i2, i3, i3 / this.g));
        this.n = new com.opos.mobad.template.cmn.baseview.c(this.i);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.c, -2);
        layoutParams.width = this.c;
        layoutParams.height = -2;
        this.n.setId(View.generateViewId());
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.s.addView(this.n, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        if (this.h) {
            p pVar = new p() { // from class: com.opos.mobad.template.b.b.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (b.this.j != null) {
                        b.this.j.h(view, iArr);
                    }
                }
            };
            this.n.setOnClickListener(pVar);
            this.n.setOnTouchListener(pVar);
            this.n.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.b.b.2
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view, int i4, boolean z) {
                    com.opos.cmn.an.f.a.a("BannerBigImage", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                    if (b.this.j != null) {
                        b.this.j.a(view, i4, z);
                    }
                }
            });
        }
    }
}
